package h;

import android.content.Context;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.NoOpCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadNotificationHelper;
import androidx.media3.exoplayer.offline.DownloadService;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.service.PallyConDownloadService;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final a m = new a(null);
    public static d n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadManager f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DatabaseProvider f1324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Cache f1325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpDataSource.Factory f1326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DownloadNotificationHelper f1327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public File f1329g;
    public boolean k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1330h = "download_channel";
    public final Map<String, b> i = new LinkedHashMap();
    public final Map<String, Download> j = new LinkedHashMap();
    public Class<? extends DownloadService> l = PallyConDownloadService.class;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            d dVar;
            d dVar2 = d.n;
            if (dVar2 != null) {
                return dVar2;
            }
            synchronized (this) {
                dVar = d.n;
                if (dVar == null) {
                    dVar = new d();
                    a aVar = d.m;
                    d.n = dVar;
                }
            }
            return dVar;
        }

        public final void b() {
            d.n = null;
        }

        public a() {
        }
    }

    public interface b {
        void a(Download download);

        void a(Download download, Exception exc);
    }

    public static final class c implements DownloadManager.Listener {
        public c() {
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
            Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
            Intrinsics.checkNotNullParameter(download, "download");
            super.onDownloadChanged(downloadManager, download, exc);
            b bVar = (b) d.this.i.get(download.request.id);
            if (bVar != null) {
                bVar.a(download, exc);
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public void onDownloadRemoved(DownloadManager downloadManager, Download download) {
            Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
            Intrinsics.checkNotNullParameter(download, "download");
            super.onDownloadRemoved(downloadManager, download);
            b bVar = (b) d.this.i.get(download.request.id);
            if (bVar != null) {
                bVar.a(download);
            }
        }
    }

    public final Map<String, Download> c() {
        return this.j;
    }

    public final DatabaseProvider d(Context context) {
        DatabaseProvider standaloneDatabaseProvider;
        Intrinsics.checkNotNullParameter(context, "context");
        DatabaseProvider databaseProvider = this.f1324b;
        if (databaseProvider != null) {
            return databaseProvider;
        }
        synchronized (this) {
            standaloneDatabaseProvider = this.f1324b;
            if (standaloneDatabaseProvider == null) {
                standaloneDatabaseProvider = new StandaloneDatabaseProvider(context);
                this.f1324b = standaloneDatabaseProvider;
            }
        }
        return standaloneDatabaseProvider;
    }

    public final File e(Context context) {
        File fileA;
        Intrinsics.checkNotNullParameter(context, "context");
        File file = this.f1329g;
        if (file != null) {
            return file;
        }
        synchronized (this) {
            fileA = this.f1329g;
            if (fileA == null) {
                fileA = a(context);
                this.f1329g = fileA;
            }
        }
        return fileA;
    }

    public final void f() {
        DownloadManager downloadManager = this.f1323a;
        if (downloadManager != null) {
            downloadManager.release();
        }
        Cache cache = this.f1325c;
        if (cache != null) {
            cache.release();
        }
        this.f1323a = null;
        this.f1325c = null;
    }

    public final DownloadNotificationHelper g(Context context) {
        DownloadNotificationHelper downloadNotificationHelper;
        Intrinsics.checkNotNullParameter(context, "context");
        DownloadNotificationHelper downloadNotificationHelper2 = this.f1327e;
        if (downloadNotificationHelper2 != null) {
            return downloadNotificationHelper2;
        }
        synchronized (this) {
            downloadNotificationHelper = this.f1327e;
            if (downloadNotificationHelper == null) {
                downloadNotificationHelper = new DownloadNotificationHelper(context, this.f1330h);
                this.f1327e = downloadNotificationHelper;
            }
        }
        return downloadNotificationHelper;
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.k) {
            return;
        }
        try {
            DownloadService.start(context, this.l);
        } catch (IllegalStateException unused) {
            DownloadService.startForeground(context, this.l);
        }
        this.k = true;
    }

    public final Class<? extends DownloadService> b() {
        return this.l;
    }

    public final Cache c(Context context) {
        Cache cache;
        Intrinsics.checkNotNullParameter(context, "context");
        Cache cache2 = this.f1325c;
        if (cache2 != null) {
            return cache2;
        }
        synchronized (this) {
            cache = this.f1325c;
            if (cache == null) {
                SimpleCache simpleCache = new SimpleCache(e(context), new NoOpCacheEvictor(), d(context));
                this.f1325c = simpleCache;
                cache = simpleCache;
            }
        }
        return cache;
    }

    public final void a(Class<? extends DownloadService> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.l = cls;
    }

    public final void b(Class<? extends DownloadService> cls) {
        if (cls == null) {
            cls = PallyConDownloadService.class;
        }
        this.l = cls;
    }

    public final File a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f1328f != null) {
            String str = this.f1328f;
            Intrinsics.checkNotNull(str);
            return new File(str);
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        return new File(externalFilesDir, "downloads");
    }

    public final DownloadManager b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DownloadManager downloadManager = new DownloadManager(context, d(context), c(context), d(), Executors.newFixedThreadPool(6));
        downloadManager.addListener(new c());
        return downloadManager;
    }

    public final HttpDataSource.Factory d() {
        HttpDataSource.Factory factory;
        HttpDataSource.Factory factory2 = this.f1326d;
        if (factory2 != null) {
            return factory2;
        }
        synchronized (this) {
            factory = this.f1326d;
            if (factory == null) {
                factory = new OkHttpDataSource.Factory(new OkHttpClient.Builder().build());
                this.f1326d = factory;
            }
        }
        return factory;
    }

    public final String e() {
        return this.f1330h;
    }

    public final DownloadManager f(Context context) {
        DownloadManager downloadManagerB;
        Intrinsics.checkNotNullParameter(context, "context");
        DownloadManager downloadManager = this.f1323a;
        if (downloadManager != null) {
            return downloadManager;
        }
        synchronized (this) {
            downloadManagerB = this.f1323a;
            if (downloadManagerB == null) {
                downloadManagerB = b(context);
                this.f1323a = downloadManagerB;
            }
        }
        return downloadManagerB;
    }

    public final void a(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f1330h = id;
    }

    public final void a(Context context, String directoryName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directoryName, "directoryName");
        this.f1328f = directoryName;
        f();
        this.f1323a = b(context);
    }

    public final void a(String str, String contentUrl, b listener) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (str != null) {
            this.i.put(str, listener);
        } else {
            this.i.put(contentUrl, listener);
        }
    }

    public final void a(String str, String contentUrl) {
        Intrinsics.checkNotNullParameter(contentUrl, "contentUrl");
        if (str != null) {
            this.i.remove(str);
        } else {
            this.i.remove(contentUrl);
        }
    }

    public final void a(ContentData contentData, Download download) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(download, "download");
        if (contentData.getContentId() != null) {
            Map<String, Download> map = this.j;
            String contentId = contentData.getContentId();
            Intrinsics.checkNotNull(contentId);
            map.put(contentId, download);
            return;
        }
        Map<String, Download> map2 = this.j;
        String url = contentData.getUrl();
        Intrinsics.checkNotNull(url);
        map2.put(url, download);
    }

    public final Download a(ContentData contentData) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData.getContentId() != null) {
            Map<String, Download> map = this.j;
            String contentId = contentData.getContentId();
            Intrinsics.checkNotNull(contentId);
            return map.get(contentId);
        }
        Map<String, Download> map2 = this.j;
        String url = contentData.getUrl();
        Intrinsics.checkNotNull(url);
        return map2.get(url);
    }
}
