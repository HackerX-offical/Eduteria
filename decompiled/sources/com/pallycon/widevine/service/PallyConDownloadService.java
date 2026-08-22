package com.pallycon.widevine.service;

import android.app.Notification;
import android.content.Context;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.Download;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.DownloadNotificationHelper;
import androidx.media3.exoplayer.offline.DownloadService;
import androidx.media3.exoplayer.scheduler.PlatformScheduler;
import androidx.media3.exoplayer.scheduler.Scheduler;
import com.pallycon.widevine.R;
import h.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001eB;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u001a\u001a\u00020\u00192\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/pallycon/widevine/service/PallyConDownloadService;", "Landroidx/media3/exoplayer/offline/DownloadService;", "", "foregroundNotificationId", "", "foregroundNotificationUpdateInterval", "", "channelId", "channelNameResourceId", "channelDescriptionResourceId", "<init>", "(IJLjava/lang/String;II)V", "", "onDestroy", "()V", "Landroidx/media3/exoplayer/offline/DownloadManager;", "getDownloadManager", "()Landroidx/media3/exoplayer/offline/DownloadManager;", "Landroidx/media3/exoplayer/scheduler/Scheduler;", "getScheduler", "()Landroidx/media3/exoplayer/scheduler/Scheduler;", "", "Landroidx/media3/exoplayer/offline/Download;", "downloads", "notMetRequirements", "Landroid/app/Notification;", "getForegroundNotification", "(Ljava/util/List;I)Landroid/app/Notification;", "Companion", "a", "b", "widevine_release"}, k = 1, mv = {1, 9, 0})
public class PallyConDownloadService extends DownloadService {
    private static final int FOREGROUND_NOTIFICATION_ID = 0;
    private static final int JOB_ID = 1;

    public static final class b implements DownloadManager.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DownloadNotificationHelper f1110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1111c;

        public b(Context context, DownloadNotificationHelper notificationHelper, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(notificationHelper, "notificationHelper");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.f1109a = applicationContext;
            this.f1110b = notificationHelper;
            this.f1111c = i;
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.Listener
        public void onDownloadChanged(DownloadManager downloadManager, Download download, Exception exc) {
            Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
            Intrinsics.checkNotNullParameter(download, "download");
        }
    }

    public PallyConDownloadService() {
        this(0, 0L, null, 0, 0, 31, null);
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public DownloadManager getDownloadManager() {
        return d.m.a().f(this);
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public Notification getForegroundNotification(List<Download> downloads, int notMetRequirements) {
        Intrinsics.checkNotNullParameter(downloads, "downloads");
        Notification notificationBuildProgressNotification = d.m.a().g(this).buildProgressNotification(this, R.drawable.pallycon_ic_baseline_arrow_downward_24, null, null, new ArrayList(), notMetRequirements);
        Intrinsics.checkNotNullExpressionValue(notificationBuildProgressNotification, "buildProgressNotification(...)");
        return notificationBuildProgressNotification;
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService
    public Scheduler getScheduler() {
        if (Util.SDK_INT >= 21) {
            return new PlatformScheduler(this, JOB_ID);
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.offline.DownloadService, android.app.Service
    public void onDestroy() {
        DownloadService.clearDownloadManagerHelpers();
        super.onDestroy();
    }

    public /* synthetic */ PallyConDownloadService(int i, long j, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? FOREGROUND_NOTIFICATION_ID : i, (i4 & 2) != 0 ? 1000L : j, (i4 & 4) != 0 ? d.m.a().e() : str, (i4 & 8) != 0 ? R.string.exo_download_notification_channel_name : i2, (i4 & 16) != 0 ? 0 : i3);
    }

    public PallyConDownloadService(int i, long j, String str, int i2, int i3) {
        super(i, j, str, i2, i3);
    }
}
