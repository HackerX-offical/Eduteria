package com.pallycon.widevine.sdk;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.pallycon.widevine.exception.PallyConException;
import com.pallycon.widevine.model.ContentData;
import com.pallycon.widevine.model.DownloadState;
import com.pallycon.widevine.model.PallyConCallback;
import com.pallycon.widevine.model.PallyConDrmInformation;
import com.pallycon.widevine.model.PallyConEventListener;
import com.pallycon.widevine.model.PallyConFileInformation;
import com.pallycon.widevine.track.PallyConDownloaderTracks;
import e.b;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 B2\u00020\u0001:\u0001BJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J4\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH&J0\u0010\u000e\u001a\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J\n\u0010\u001f\u001a\u0004\u0018\u00010 H&J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020$H&J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eH&J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)H&J\b\u0010+\u001a\u00020'H&J\b\u0010,\u001a\u00020\u0003H&J*\u0010-\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0003H&J\b\u00102\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0003H&J-\u00104\u001a\u00020\u00032\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u0001062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0002\u00108J#\u00109\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H'¢\u0006\u0002\u0010<J\u0012\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010?H'J\b\u0010@\u001a\u00020\u0003H&J*\u0010A\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH&¨\u0006C"}, d2 = {"Lcom/pallycon/widevine/sdk/PallyConWvSDK;", "", "download", "", "downloaderTracks", "Lcom/pallycon/widevine/track/PallyConDownloaderTracks;", "downloadLicense", "format", "Landroidx/media3/common/Format;", "onSuccess", "Lkotlin/Function0;", "onFailed", "Lkotlin/Function1;", "Lcom/pallycon/widevine/exception/PallyConException;", "getContentTrackInfo", "getDataSourceFactory", "Landroidx/media3/datasource/DataSource$Factory;", "getDownloadFileInformation", "Lcom/pallycon/widevine/model/PallyConFileInformation;", "getDownloadManager", "Landroidx/media3/exoplayer/offline/DownloadManager;", "context", "Landroid/content/Context;", "dummy", "(Landroid/content/Context;Lkotlin/Unit;)Landroidx/media3/exoplayer/offline/DownloadManager;", "getDownloadState", "Lcom/pallycon/widevine/model/DownloadState;", "getDrmInformation", "Lcom/pallycon/widevine/model/PallyConDrmInformation;", "getDrmSessionManager", "Landroidx/media3/exoplayer/drm/DrmSessionManager;", "getKeySetId", "", "getMediaItem", "Landroidx/media3/common/MediaItem;", "getMediaSource", "Landroidx/media3/exoplayer/source/MediaSource;", "drmSessionManager", "migrateDownloadedContent", "", "contentName", "", "downloadedFolderName", "needsMigrateDownloadedContent", "pauseAll", "reProvisionRequest", "release", "remove", "removeAll", "removeLicense", "renewLicense", "resumeAll", "setDownloadService", NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/Class;", "Landroidx/media3/exoplayer/offline/DownloadService;", "(Ljava/lang/Class;Lkotlin/Unit;)V", "setPallyConCallback", "pallyConCallback", "Lcom/pallycon/widevine/model/PallyConCallback;", "(Lcom/pallycon/widevine/model/PallyConCallback;Lkotlin/Unit;)V", "setPallyConEventListener", "pallyConEventListener", "Lcom/pallycon/widevine/model/PallyConEventListener;", "stop", "updateSecure", "Companion", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PallyConWvSDK {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001c\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0017\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0007J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¨\u0006\u001d"}, d2 = {"Lcom/pallycon/widevine/sdk/PallyConWvSDK$Companion;", "", "()V", "addPallyConEventListener", "", "pallyConEventListener", "Lcom/pallycon/widevine/model/PallyConEventListener;", "createPallyConWvSDK", "Lcom/pallycon/widevine/sdk/PallyConWvSDK;", "context", "Landroid/content/Context;", "contentData", "Lcom/pallycon/widevine/model/ContentData;", "getDownloadManager", "Landroidx/media3/exoplayer/offline/DownloadManager;", "removePallyConEventListener", "setCmcdConfigurationFactory", "factory", "Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;", "setDownloadDirectory", "directoryPath", "", "setDownloadService", NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/Class;", "Landroidx/media3/exoplayer/offline/DownloadService;", "setPallyConCallback", "pallyConCallback", "Lcom/pallycon/widevine/model/PallyConCallback;", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final void addPallyConEventListener(PallyConEventListener pallyConEventListener) {
            Intrinsics.checkNotNullParameter(pallyConEventListener, "pallyConEventListener");
            b.f1157g.a(pallyConEventListener);
        }

        @JvmStatic
        public final PallyConWvSDK createPallyConWvSDK(Context context, ContentData contentData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(contentData, "contentData");
            return b.f1157g.a(context, contentData);
        }

        @JvmStatic
        public final DownloadManager getDownloadManager(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return b.f1157g.a(context);
        }

        @JvmStatic
        public final void removePallyConEventListener(PallyConEventListener pallyConEventListener) {
            Intrinsics.checkNotNullParameter(pallyConEventListener, "pallyConEventListener");
            b.f1157g.b(pallyConEventListener);
        }

        @JvmStatic
        public final void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            b.f1157g.a(factory);
        }

        @JvmStatic
        public final void setDownloadDirectory(Context context, String directoryPath) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
            b.f1157g.a(context, directoryPath);
        }

        @JvmStatic
        public final void setDownloadService(Class<? extends DownloadService> service) {
            b.f1157g.a(service);
        }

        @JvmStatic
        public final void setPallyConCallback(PallyConCallback pallyConCallback) {
            b.f1157g.a(pallyConCallback);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(PallyConWvSDK pallyConWvSDK, PallyConCallback pallyConCallback, Unit unit, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPallyConCallback");
            }
            if ((i & 2) != 0) {
                unit = null;
            }
            pallyConWvSDK.setPallyConCallback(pallyConCallback, unit);
        }

        public static /* synthetic */ void a(PallyConWvSDK pallyConWvSDK, Class cls, Unit unit, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDownloadService");
            }
            if ((i & 2) != 0) {
                unit = null;
            }
            pallyConWvSDK.setDownloadService(cls, unit);
        }

        public static /* synthetic */ DownloadManager a(PallyConWvSDK pallyConWvSDK, Context context, Unit unit, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownloadManager");
            }
            if ((i & 2) != 0) {
                unit = null;
            }
            return pallyConWvSDK.getDownloadManager(context, unit);
        }
    }

    @JvmStatic
    static void addPallyConEventListener(PallyConEventListener pallyConEventListener) {
        INSTANCE.addPallyConEventListener(pallyConEventListener);
    }

    @JvmStatic
    static PallyConWvSDK createPallyConWvSDK(Context context, ContentData contentData) {
        return INSTANCE.createPallyConWvSDK(context, contentData);
    }

    @JvmStatic
    static DownloadManager getDownloadManager(Context context) {
        return INSTANCE.getDownloadManager(context);
    }

    @JvmStatic
    static void removePallyConEventListener(PallyConEventListener pallyConEventListener) {
        INSTANCE.removePallyConEventListener(pallyConEventListener);
    }

    @JvmStatic
    static void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
        INSTANCE.setCmcdConfigurationFactory(factory);
    }

    @JvmStatic
    static void setDownloadDirectory(Context context, String str) {
        INSTANCE.setDownloadDirectory(context, str);
    }

    @JvmStatic
    static void setDownloadService(Class<? extends DownloadService> cls) {
        INSTANCE.setDownloadService(cls);
    }

    @JvmStatic
    static void setPallyConCallback(PallyConCallback pallyConCallback) {
        INSTANCE.setPallyConCallback(pallyConCallback);
    }

    void download(PallyConDownloaderTracks downloaderTracks) throws PallyConException.DownloadException, PallyConException.ContentDataException;

    void downloadLicense(Format format, Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed);

    void getContentTrackInfo(Function1<? super PallyConDownloaderTracks, Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed);

    DataSource.Factory getDataSourceFactory();

    PallyConFileInformation getDownloadFileInformation();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated and will be removed in the next release", replaceWith = @ReplaceWith(expression = "PallyConWvSDK.getDownloadManager(Context)", imports = {}))
    DownloadManager getDownloadManager(Context context, Unit dummy);

    DownloadState getDownloadState();

    PallyConDrmInformation getDrmInformation();

    DrmSessionManager getDrmSessionManager();

    byte[] getKeySetId();

    MediaItem getMediaItem() throws PallyConException.DetectedDeviceTimeModifiedException, PallyConException.ContentDataException;

    MediaSource getMediaSource() throws PallyConException.DetectedDeviceTimeModifiedException, PallyConException.ContentDataException;

    MediaSource getMediaSource(DrmSessionManager drmSessionManager) throws PallyConException.DetectedDeviceTimeModifiedException, PallyConException.ContentDataException;

    boolean migrateDownloadedContent(String contentName, String downloadedFolderName) throws PallyConException.MigrationLocalPathException, PallyConException.MigrationException, PallyConException.ContentDataException;

    boolean needsMigrateDownloadedContent() throws PallyConException.ContentDataException;

    void pauseAll();

    void reProvisionRequest(Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed);

    void release();

    void remove() throws PallyConException.DownloadException, PallyConException.ContentDataException;

    void removeAll();

    void removeLicense() throws PallyConException.DrmException;

    void renewLicense() throws PallyConException.DrmException;

    void resumeAll();

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated and will be removed in the next release", replaceWith = @ReplaceWith(expression = "PallyConWvSDK.setDownloadService(PallyConEventListener)", imports = {}))
    void setDownloadService(Class<? extends DownloadService> service, Unit dummy);

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated and will be removed in the next release", replaceWith = @ReplaceWith(expression = "PallyConWvSDK.setPallyConCallback(PallyConEventListener)", imports = {}))
    void setPallyConCallback(PallyConCallback pallyConCallback, Unit dummy);

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated and will be removed in the next release", replaceWith = @ReplaceWith(expression = "PallyConWvSDK.addPallyConEventListener(PallyConEventListener)", imports = {}))
    void setPallyConEventListener(PallyConEventListener pallyConEventListener);

    void stop();

    void updateSecure(Function0<Unit> onSuccess, Function1<? super PallyConException, Unit> onFailed);
}
