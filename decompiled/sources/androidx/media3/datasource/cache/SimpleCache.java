package androidx.media3.datasource.cache;

import android.os.ConditionVariable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class SimpleCache implements Cache {
    private static final int SUBDIRECTORY_COUNT = 10;
    private static final String TAG = "SimpleCache";
    private static final String UID_FILE_SUFFIX = ".uid";
    private static final HashSet<File> lockedCacheDirs = new HashSet<>();
    private final File cacheDir;
    private final CachedContentIndex contentIndex;
    private final CacheEvictor evictor;
    private final CacheFileMetadataIndex fileIndex;
    private Cache.CacheException initializationException;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final HashMap<String, ArrayList<Cache.Listener>> f218listeners;
    private final Random random;
    private boolean released;
    private long totalSpace;
    private final boolean touchCacheSpans;
    private long uid;

    public static synchronized boolean isCacheFolderLocked(File file) {
        return lockedCacheDirs.contains(file.getAbsoluteFile());
    }

    public static void delete(File file, DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long jLoadUid = loadUid(fileArrListFiles);
                if (jLoadUid != -1) {
                    try {
                        CacheFileMetadataIndex.delete(databaseProvider, jLoadUid);
                    } catch (DatabaseIOException unused) {
                        Log.w(TAG, "Failed to delete file metadata: " + jLoadUid);
                    }
                    try {
                        CachedContentIndex.delete(databaseProvider, jLoadUid);
                    } catch (DatabaseIOException unused2) {
                        Log.w(TAG, "Failed to delete file metadata: " + jLoadUid);
                    }
                }
            }
            Util.recursiveDelete(file);
        }
    }

    @Deprecated
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, null, false, true);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider, byte[] bArr, boolean z, boolean z2) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z, z2), (databaseProvider == null || z2) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.media3.datasource.cache.SimpleCache$1] */
    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (!lockFolder(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.contentIndex = cachedContentIndex;
        this.fileIndex = cacheFileMetadataIndex;
        this.f218listeners = new HashMap<>();
        this.random = new Random();
        this.touchCacheSpans = cacheEvictor.requiresCacheSpanTouches();
        this.uid = -1L;
        final ConditionVariable conditionVariable = new ConditionVariable();
        new Thread("ExoPlayer:SimpleCacheInit") { // from class: androidx.media3.datasource.cache.SimpleCache.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (SimpleCache.this) {
                    conditionVariable.open();
                    SimpleCache.this.initialize();
                    SimpleCache.this.evictor.onCacheInitialized();
                }
            }
        }.start();
        conditionVariable.block();
    }

    public synchronized void checkInitialization() throws Cache.CacheException {
        Cache.CacheException cacheException = this.initializationException;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getUid() {
        return this.uid;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void release() {
        File file;
        if (this.released) {
            return;
        }
        this.f218listeners.clear();
        removeStaleSpans();
        try {
            try {
                this.contentIndex.store();
                file = this.cacheDir;
            } catch (IOException e2) {
                Log.e(TAG, "Storing index file failed", e2);
                file = this.cacheDir;
            }
            unlockFolder(file);
            this.released = true;
        } catch (Throwable th) {
            unlockFolder(this.cacheDir);
            this.released = true;
            throw th;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        Assertions.checkState(!this.released);
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(listener);
        ArrayList<Cache.Listener> arrayList = this.f218listeners.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f218listeners.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void removeListener(String str, Cache.Listener listener) {
        if (this.released) {
            return;
        }
        ArrayList<Cache.Listener> arrayList = this.f218listeners.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.f218listeners.remove(str);
            }
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        TreeSet treeSet;
        Assertions.checkState(!this.released);
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent == null || cachedContent.isEmpty()) {
            treeSet = new TreeSet();
        } else {
            treeSet = new TreeSet((Collection) cachedContent.getSpans());
        }
        return treeSet;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized Set<String> getKeys() {
        Assertions.checkState(!this.released);
        return new HashSet(this.contentIndex.getKeys());
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getCacheSpace() {
        Assertions.checkState(!this.released);
        return this.totalSpace;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized CacheSpan startReadWrite(String str, long j, long j2) throws Throwable {
        try {
            try {
                Assertions.checkState(!this.released);
                checkInitialization();
                while (true) {
                    CacheSpan cacheSpanStartReadWriteNonBlocking = startReadWriteNonBlocking(str, j, j2);
                    long j3 = j2;
                    long j4 = j;
                    String str2 = str;
                    if (cacheSpanStartReadWriteNonBlocking != null) {
                        return cacheSpanStartReadWriteNonBlocking;
                    }
                    wait();
                    str = str2;
                    j = j4;
                    j2 = j3;
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized CacheSpan startReadWriteNonBlocking(String str, long j, long j2) throws Throwable {
        try {
            try {
                Assertions.checkState(!this.released);
                checkInitialization();
                SimpleCacheSpan span = getSpan(str, j, j2);
                if (span.isCached) {
                    return touchSpan(str, span);
                }
                if (this.contentIndex.getOrAdd(str).lockRange(j, span.length)) {
                    return span;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized File startFile(String str, long j, long j2) throws Throwable {
        Throwable th;
        try {
            try {
                Assertions.checkState(!this.released);
                checkInitialization();
                CachedContent cachedContent = this.contentIndex.get(str);
                Assertions.checkNotNull(cachedContent);
                Assertions.checkState(cachedContent.isFullyLocked(j, j2));
                if (!this.cacheDir.exists()) {
                    try {
                        createCacheDirectories(this.cacheDir);
                        removeStaleSpans();
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                this.evictor.onStartFile(this, str, j, j2);
                File file = new File(this.cacheDir, Integer.toString(this.random.nextInt(10)));
                if (!file.exists()) {
                    createCacheDirectories(file);
                }
                return SimpleCacheSpan.getCacheFile(file, cachedContent.id, j, System.currentTimeMillis());
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void commitFile(File file, long j) throws Cache.CacheException {
        boolean z = true;
        Assertions.checkState(!this.released);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.checkNotNull(SimpleCacheSpan.createCacheEntry(file, j, this.contentIndex));
            CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(simpleCacheSpan.key));
            Assertions.checkState(cachedContent.isFullyLocked(simpleCacheSpan.position, simpleCacheSpan.length));
            long contentLength = ContentMetadata.getContentLength(cachedContent.getMetadata());
            if (contentLength != -1) {
                if (simpleCacheSpan.position + simpleCacheSpan.length > contentLength) {
                    z = false;
                }
                Assertions.checkState(z);
            }
            if (this.fileIndex != null) {
                try {
                    this.fileIndex.set(file.getName(), simpleCacheSpan.length, simpleCacheSpan.lastTouchTimestamp);
                    addSpan(simpleCacheSpan);
                    try {
                        this.contentIndex.store();
                        notifyAll();
                        return;
                    } catch (IOException e2) {
                        throw new Cache.CacheException(e2);
                    }
                } catch (IOException e3) {
                    throw new Cache.CacheException(e3);
                }
            }
            addSpan(simpleCacheSpan);
            this.contentIndex.store();
            notifyAll();
            return;
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.released);
        CachedContent cachedContent = (CachedContent) Assertions.checkNotNull(this.contentIndex.get(cacheSpan.key));
        cachedContent.unlockRange(cacheSpan.position);
        this.contentIndex.maybeRemove(cachedContent.key);
        notifyAll();
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void removeResource(String str) {
        Assertions.checkState(!this.released);
        Iterator<CacheSpan> it = getCachedSpans(str).iterator();
        while (it.hasNext()) {
            removeSpanInternal(it.next());
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) {
        Assertions.checkState(!this.released);
        removeSpanInternal(cacheSpan);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // androidx.media3.datasource.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isCached(java.lang.String r3, long r4, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.released     // Catch: java.lang.Throwable -> L1c
            r1 = 1
            r0 = r0 ^ r1
            androidx.media3.common.util.Assertions.checkState(r0)     // Catch: java.lang.Throwable -> L1c
            androidx.media3.datasource.cache.CachedContentIndex r0 = r2.contentIndex     // Catch: java.lang.Throwable -> L1c
            androidx.media3.datasource.cache.CachedContent r3 = r0.get(r3)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L19
            long r3 = r3.getCachedBytesLength(r4, r6)     // Catch: java.lang.Throwable -> L1c
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 < 0) goto L19
            goto L1a
        L19:
            r1 = 0
        L1a:
            monitor-exit(r2)
            return r1
        L1c:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.SimpleCache.isCached(java.lang.String, long, long):boolean");
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getCachedLength(String str, long j, long j2) {
        CachedContent cachedContent;
        Assertions.checkState(!this.released);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        cachedContent = this.contentIndex.get(str);
        return cachedContent != null ? cachedContent.getCachedBytesLength(j, j2) : -j2;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized long getCachedBytes(String str, long j, long j2) {
        long j3;
        long j4 = j2 == -1 ? Long.MAX_VALUE : j + j2;
        long j5 = j4 >= 0 ? j4 : Long.MAX_VALUE;
        long j6 = j;
        j3 = 0;
        while (j6 < j5) {
            long cachedLength = getCachedLength(str, j6, j5 - j6);
            if (cachedLength > 0) {
                j3 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j6 += cachedLength;
        }
        return j3;
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized void applyContentMetadataMutations(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        Assertions.checkState(!this.released);
        checkInitialization();
        this.contentIndex.applyContentMetadataMutations(str, contentMetadataMutations);
        try {
            this.contentIndex.store();
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        }
    }

    @Override // androidx.media3.datasource.cache.Cache
    public synchronized ContentMetadata getContentMetadata(String str) {
        Assertions.checkState(!this.released);
        return this.contentIndex.getContentMetadata(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        if (!this.cacheDir.exists()) {
            try {
                createCacheDirectories(this.cacheDir);
            } catch (Cache.CacheException e2) {
                this.initializationException = e2;
                return;
            }
        }
        File[] fileArrListFiles = this.cacheDir.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.cacheDir;
            Log.e(TAG, str);
            this.initializationException = new Cache.CacheException(str);
            return;
        }
        long jLoadUid = loadUid(fileArrListFiles);
        this.uid = jLoadUid;
        if (jLoadUid == -1) {
            try {
                this.uid = createUid(this.cacheDir);
            } catch (IOException e3) {
                String str2 = "Failed to create cache UID: " + this.cacheDir;
                Log.e(TAG, str2, e3);
                this.initializationException = new Cache.CacheException(str2, e3);
                return;
            }
        }
        try {
            this.contentIndex.initialize(this.uid);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.initialize(this.uid);
                Map<String, CacheFileMetadata> all = this.fileIndex.getAll();
                loadDirectory(this.cacheDir, true, fileArrListFiles, all);
                this.fileIndex.removeAll(all.keySet());
            } else {
                loadDirectory(this.cacheDir, true, fileArrListFiles, null);
            }
            this.contentIndex.removeEmpty();
            try {
                this.contentIndex.store();
            } catch (IOException e4) {
                Log.e(TAG, "Storing index file failed", e4);
            }
        } catch (IOException e5) {
            String str3 = "Failed to initialize cache indices: " + this.cacheDir;
            Log.e(TAG, str3, e5);
            this.initializationException = new Cache.CacheException(str3, e5);
        }
    }

    private void loadDirectory(File file, boolean z, File[] fileArr, Map<String, CacheFileMetadata> map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                loadDirectory(file2, false, file2.listFiles(), map);
            } else if (!z || (!CachedContentIndex.isIndexFile(name) && !name.endsWith(UID_FILE_SUFFIX))) {
                CacheFileMetadata cacheFileMetadataRemove = map != null ? map.remove(name) : null;
                if (cacheFileMetadataRemove != null) {
                    j = cacheFileMetadataRemove.length;
                    j2 = cacheFileMetadataRemove.lastTouchTimestamp;
                } else {
                    j = -1;
                    j2 = -9223372036854775807L;
                }
                SimpleCacheSpan simpleCacheSpanCreateCacheEntry = SimpleCacheSpan.createCacheEntry(file2, j, j2, this.contentIndex);
                if (simpleCacheSpanCreateCacheEntry != null) {
                    addSpan(simpleCacheSpanCreateCacheEntry);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private SimpleCacheSpan touchSpan(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z;
        if (!this.touchCacheSpans) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.checkNotNull(simpleCacheSpan.file)).getName();
        long j = simpleCacheSpan.length;
        long jCurrentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.fileIndex;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.set(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.w(TAG, "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        SimpleCacheSpan lastTouchTimestamp = ((CachedContent) Assertions.checkNotNull(this.contentIndex.get(str))).setLastTouchTimestamp(simpleCacheSpan, jCurrentTimeMillis, z);
        notifySpanTouched(simpleCacheSpan, lastTouchTimestamp);
        return lastTouchTimestamp;
    }

    private SimpleCacheSpan getSpan(String str, long j, long j2) {
        SimpleCacheSpan span;
        CachedContent cachedContent = this.contentIndex.get(str);
        if (cachedContent == null) {
            return SimpleCacheSpan.createHole(str, j, j2);
        }
        while (true) {
            span = cachedContent.getSpan(j, j2);
            if (!span.isCached || ((File) Assertions.checkNotNull(span.file)).length() == span.length) {
                break;
            }
            removeStaleSpans();
        }
        return span;
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.contentIndex.getOrAdd(simpleCacheSpan.key).addSpan(simpleCacheSpan);
        this.totalSpace += simpleCacheSpan.length;
        notifySpanAdded(simpleCacheSpan);
    }

    private void removeSpanInternal(CacheSpan cacheSpan) {
        CachedContent cachedContent = this.contentIndex.get(cacheSpan.key);
        if (cachedContent == null || !cachedContent.removeSpan(cacheSpan)) {
            return;
        }
        this.totalSpace -= cacheSpan.length;
        if (this.fileIndex != null) {
            String name = ((File) Assertions.checkNotNull(cacheSpan.file)).getName();
            try {
                this.fileIndex.remove(name);
            } catch (IOException unused) {
                Log.w(TAG, "Failed to remove file index entry for: " + name);
            }
        }
        this.contentIndex.maybeRemove(cachedContent.key);
        notifySpanRemoved(cacheSpan);
    }

    private void removeStaleSpans() {
        ArrayList arrayList = new ArrayList();
        Iterator<CachedContent> it = this.contentIndex.getAll().iterator();
        while (it.hasNext()) {
            for (SimpleCacheSpan simpleCacheSpan : it.next().getSpans()) {
                if (((File) Assertions.checkNotNull(simpleCacheSpan.file)).length() != simpleCacheSpan.length) {
                    arrayList.add(simpleCacheSpan);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            removeSpanInternal((CacheSpan) arrayList.get(i));
        }
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.f218listeners.get(cacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanRemoved(this, cacheSpan);
            }
        }
        this.evictor.onSpanRemoved(this, cacheSpan);
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.f218listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.evictor.onSpanAdded(this, simpleCacheSpan);
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList<Cache.Listener> arrayList = this.f218listeners.get(simpleCacheSpan.key);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    private static long loadUid(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(UID_FILE_SUFFIX)) {
                try {
                    return parseUid(name);
                } catch (NumberFormatException unused) {
                    Log.e(TAG, "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static long createUid(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + UID_FILE_SUFFIX);
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private static long parseUid(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private static void createCacheDirectories(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        Log.e(TAG, str);
        throw new Cache.CacheException(str);
    }

    private static synchronized boolean lockFolder(File file) {
        return lockedCacheDirs.add(file.getAbsoluteFile());
    }

    private static synchronized void unlockFolder(File file) {
        lockedCacheDirs.remove(file.getAbsoluteFile());
    }
}
