package com.appnew.android.player.music_player;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSessionManager;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media.app.NotificationCompat;
import com.appnew.android.Model.Song;
import com.appnew.android.player.AudioPlayerActivity;
import com.eduteria.app.app.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MusicNotificationManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010\"\u001a\u00020#H\u0003J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/appnew/android/player/music_player/MusicNotificationManager;", "", "mMusicService", "Lcom/appnew/android/player/music_player/MusicService;", "<init>", "(Lcom/appnew/android/player/music_player/MusicService;)V", "CHANNEL_ID", "", "REQUEST_CODE", "", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "value", "Landroidx/core/app/NotificationCompat$Builder;", "notificationBuilder", "getNotificationBuilder", "()Landroidx/core/app/NotificationCompat$Builder;", "mediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mediaSessionManager", "Landroid/media/session/MediaSessionManager;", "transportControls", "Landroid/support/v4/media/session/MediaControllerCompat$TransportControls;", "context", "Landroid/content/Context;", "playerAction", "Landroid/app/PendingIntent;", "action", "createNotification", "Landroid/app/Notification;", "notificationAction", "Landroidx/core/app/NotificationCompat$Action;", "createNotificationChannel", "", "initMediaSession", "song", "Lcom/appnew/android/Model/Song;", "updateMetaData", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicNotificationManager {
    private final String CHANNEL_ID;
    private final int REQUEST_CODE;
    private final Context context;
    private final MusicService mMusicService;
    private MediaSessionCompat mediaSession;
    private MediaSessionManager mediaSessionManager;
    private NotificationCompat.Builder notificationBuilder;
    private final NotificationManager notificationManager;
    private MediaControllerCompat.TransportControls transportControls;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final int NOTIFICATION_ID = 101;
    private static final String PLAY_PAUSE_ACTION = "action.PLAYPAUSE";
    private static final String NEXT_ACTION = "action.NEXT";
    private static final String PREV_ACTION = "action.PREV";

    public MusicNotificationManager(MusicService mMusicService) {
        Intrinsics.checkNotNullParameter(mMusicService, "mMusicService");
        this.mMusicService = mMusicService;
        this.CHANNEL_ID = "action.CHANNEL_ID";
        this.REQUEST_CODE = 100;
        Object systemService = mMusicService.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.notificationManager = (NotificationManager) systemService;
        this.context = mMusicService.getBaseContext();
    }

    public final NotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public final NotificationCompat.Builder getNotificationBuilder() {
        return this.notificationBuilder;
    }

    private final PendingIntent playerAction(String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mMusicService, this.REQUEST_CODE, intent, 67108864);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    public final Notification createNotification() {
        MediaPlayerHolder mediaPlayerHolder = this.mMusicService.getMediaPlayerHolder();
        Song mSelectedSong = mediaPlayerHolder != null ? mediaPlayerHolder.getMSelectedSong() : null;
        this.notificationBuilder = new NotificationCompat.Builder(this.mMusicService, this.CHANNEL_ID);
        createNotificationChannel();
        Intent intent = new Intent(this.mMusicService, (Class<?>) AudioPlayerActivity.class);
        intent.setFlags(603979776);
        PendingIntent activity = PendingIntent.getActivity(this.mMusicService, this.REQUEST_CODE, intent, 67108864);
        Intrinsics.checkNotNull(mSelectedSong);
        String artistName = mSelectedSong.getArtistName();
        String title = mSelectedSong.getTitle();
        initMediaSession(mSelectedSong);
        NotificationCompat.Builder builder = this.notificationBuilder;
        Intrinsics.checkNotNull(builder);
        builder.setShowWhen(false).setSmallIcon(R.mipmap.splash_logo).setColor(ContextCompat.getColor(this.context, R.color.colorAccent)).setContentTitle(title).setContentText(artistName).setContentIntent(activity).addAction(notificationAction(PREV_ACTION)).addAction(notificationAction(PLAY_PAUSE_ACTION)).addAction(notificationAction(NEXT_ACTION)).setVisibility(1);
        NotificationCompat.Builder builder2 = this.notificationBuilder;
        Intrinsics.checkNotNull(builder2);
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat);
        builder2.setStyle(mediaStyle.setMediaSession(mediaSessionCompat.getSessionToken()).setShowActionsInCompactView(0, 1, 2));
        NotificationCompat.Builder builder3 = this.notificationBuilder;
        Intrinsics.checkNotNull(builder3);
        Notification notificationBuild = builder3.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        return notificationBuild;
    }

    public final NotificationCompat.Action notificationAction(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        boolean zAreEqual = Intrinsics.areEqual(action, PREV_ACTION);
        int i = android.R.drawable.ic_media_previous;
        if (!zAreEqual) {
            if (Intrinsics.areEqual(action, PLAY_PAUSE_ACTION)) {
                MediaPlayerHolder mediaPlayerHolder = this.mMusicService.getMediaPlayerHolder();
                i = (mediaPlayerHolder == null || mediaPlayerHolder.getMState() != 1) ? com.appnew.android.R.drawable.pause : com.appnew.android.R.drawable.play;
            } else if (Intrinsics.areEqual(action, NEXT_ACTION)) {
                i = android.R.drawable.ic_media_next;
            }
        }
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(i, action, playerAction(action)).build();
        Intrinsics.checkNotNullExpressionValue(actionBuild, "build(...)");
        return actionBuild;
    }

    private final void createNotificationChannel() {
        if (this.notificationManager.getNotificationChannel(this.CHANNEL_ID) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(this.CHANNEL_ID, this.mMusicService.getString(R.string.app_name), 2);
            notificationChannel.setDescription(this.mMusicService.getString(R.string.app_name));
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(false);
            this.notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final void initMediaSession(Song song) {
        Object systemService = this.context.getSystemService("media_session");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.session.MediaSessionManager");
        this.mediaSessionManager = (MediaSessionManager) systemService;
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this.context, "AudioPlayer");
        this.mediaSession = mediaSessionCompat;
        Intrinsics.checkNotNull(mediaSessionCompat);
        this.transportControls = mediaSessionCompat.getController().getTransportControls();
        MediaSessionCompat mediaSessionCompat2 = this.mediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat2);
        mediaSessionCompat2.setActive(true);
        MediaSessionCompat mediaSessionCompat3 = this.mediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat3);
        mediaSessionCompat3.setFlags(2);
        updateMetaData(song);
    }

    private final void updateMetaData(Song song) {
        MediaSessionCompat mediaSessionCompat = this.mediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat);
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
        Utils utils = Utils.INSTANCE;
        String path = song.getPath();
        Intrinsics.checkNotNull(path);
        mediaSessionCompat.setMetadata(builder.putBitmap("android.media.metadata.ALBUM_ART", utils.songArt(path, this.context)).putString("android.media.metadata.ARTIST", song.getArtistName()).putString("android.media.metadata.TITLE", song.getTitle()).build());
    }

    /* JADX INFO: compiled from: MusicNotificationManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\tX\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/appnew/android/player/music_player/MusicNotificationManager$Companion;", "", "<init>", "()V", "NOTIFICATION_ID", "", "getNOTIFICATION_ID", "()I", "PLAY_PAUSE_ACTION", "", "getPLAY_PAUSE_ACTION$app_EDUTERIARelease", "()Ljava/lang/String;", "NEXT_ACTION", "getNEXT_ACTION$app_EDUTERIARelease", "PREV_ACTION", "getPREV_ACTION$app_EDUTERIARelease", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getNOTIFICATION_ID() {
            return MusicNotificationManager.NOTIFICATION_ID;
        }

        public final String getPLAY_PAUSE_ACTION$app_EDUTERIARelease() {
            return MusicNotificationManager.PLAY_PAUSE_ACTION;
        }

        public final String getNEXT_ACTION$app_EDUTERIARelease() {
            return MusicNotificationManager.NEXT_ACTION;
        }

        public final String getPREV_ACTION$app_EDUTERIARelease() {
            return MusicNotificationManager.PREV_ACTION;
        }
    }
}
