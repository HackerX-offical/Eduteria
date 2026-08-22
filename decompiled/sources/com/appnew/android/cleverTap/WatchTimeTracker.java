package com.appnew.android.cleverTap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.work.PeriodicWorkRequest;
import com.tv9news.utils.helpers.AnalyticEvents;
import com.tv9news.utils.helpers.AnalyticsConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatchTimeTracker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/cleverTap/WatchTimeTracker;", "", "context", "Landroid/content/Context;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "courseid", "", "video_name", "contentFlag", "<init>", "(Landroid/content/Context;Landroidx/media3/exoplayer/ExoPlayer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "handler", "Landroid/os/Handler;", "watchTimeInMillis", "", "isTracking", "", "INTERVAL", "MILESTONE_5_MIN", "MILESTONE_15_MIN", "MILESTONE_30_MIN", "startTracking", "", "stopTracking", "watchTimeRunnable", "Ljava/lang/Runnable;", "pushEventForWatchTime", "eventType", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatchTimeTracker {
    public static final int $stable = 8;
    private final long INTERVAL;
    private final long MILESTONE_15_MIN;
    private final long MILESTONE_30_MIN;
    private final long MILESTONE_5_MIN;
    private final String contentFlag;
    private final Context context;
    private final String courseid;
    private final Handler handler;
    private boolean isTracking;
    private final ExoPlayer player;
    private final String video_name;
    private long watchTimeInMillis;
    private final Runnable watchTimeRunnable;

    public WatchTimeTracker(Context context, ExoPlayer player, String courseid, String video_name, String contentFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(courseid, "courseid");
        Intrinsics.checkNotNullParameter(video_name, "video_name");
        Intrinsics.checkNotNullParameter(contentFlag, "contentFlag");
        this.context = context;
        this.player = player;
        this.courseid = courseid;
        this.video_name = video_name;
        this.contentFlag = contentFlag;
        this.handler = new Handler(Looper.getMainLooper());
        this.INTERVAL = 1000L;
        this.MILESTONE_5_MIN = 300000L;
        this.MILESTONE_15_MIN = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
        this.MILESTONE_30_MIN = 1800000L;
        this.watchTimeRunnable = new Runnable() { // from class: com.appnew.android.cleverTap.WatchTimeTracker$watchTimeRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.isTracking && this.this$0.player.isPlaying()) {
                    this.this$0.watchTimeInMillis += this.this$0.INTERVAL;
                    if (this.this$0.watchTimeInMillis == this.this$0.MILESTONE_5_MIN) {
                        this.this$0.pushEventForWatchTime(AnalyticsConstants.FIVE_MIN_VIEW);
                    } else if (this.this$0.watchTimeInMillis == this.this$0.MILESTONE_15_MIN) {
                        this.this$0.pushEventForWatchTime(AnalyticsConstants.FIFTEEN_MIN_VIEW);
                    } else if (this.this$0.watchTimeInMillis == this.this$0.MILESTONE_30_MIN) {
                        this.this$0.pushEventForWatchTime(AnalyticsConstants.THIRTY_MIN_VIEW);
                    }
                    this.this$0.handler.postDelayed(this, this.this$0.INTERVAL);
                    Log.d("TAGMilestoneReached", "WatchTime: " + this.this$0.watchTimeInMillis);
                }
            }
        };
    }

    public final void startTracking() {
        this.isTracking = true;
        this.handler.postDelayed(this.watchTimeRunnable, this.INTERVAL);
        Log.d("TAGMilestoneReached", "startTracking");
    }

    public final void stopTracking() {
        this.isTracking = false;
        this.handler.removeCallbacks(this.watchTimeRunnable);
        Log.d("TAGMilestoneReached", "stopTracking");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushEventForWatchTime(String eventType) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("date", AnalyticHelper.INSTANCE.getCurrentDateTimeForEvent());
        map2.put("user_id", AnalyticHelper.INSTANCE.getUserId());
        map2.put("course_id", !TextUtils.isEmpty(this.courseid) ? this.courseid : "NA");
        map2.put(AnalyticsConstants.class_name, !TextUtils.isEmpty(this.video_name) ? this.video_name : "NA");
        map2.put(AnalyticsConstants.content_flag, TextUtils.isEmpty(this.contentFlag) ? "NA" : this.contentFlag);
        AnalyticEvents.INSTANCE.pushEvents(this.context, eventType, map);
    }
}
