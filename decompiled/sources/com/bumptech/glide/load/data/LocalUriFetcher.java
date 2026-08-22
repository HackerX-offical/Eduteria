package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final ContentResolver contentResolver;
    private T data;
    private final Uri uri;
    protected final boolean useMediaStoreApisIfAvailable;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    protected abstract void close(T t) throws IOException;

    protected abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this(contentResolver, uri, false);
    }

    LocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z) {
        this.contentResolver = contentResolver;
        this.uri = uri;
        this.useMediaStoreApisIfAvailable = z;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final void loadData(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T tLoadResource = loadResource(this.uri, this.contentResolver);
            this.data = tLoadResource;
            dataCallback.onDataReady(tLoadResource);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open Uri", e2);
            }
            dataCallback.onLoadFailed(e2);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    protected AssetFileDescriptor openAssetFileDescriptor(Uri uri) throws FileNotFoundException {
        if (this.useMediaStoreApisIfAvailable && MediaStoreUtil.isMediaStoreUri(uri) && MediaStoreUtil.isMediaStoreOpenFileApisAvailable()) {
            return MediaStoreUtil.openAssetFileDescriptor(uri, this.contentResolver);
        }
        return this.contentResolver.openAssetFileDescriptor(uri, StreamManagement.AckRequest.ELEMENT);
    }
}
