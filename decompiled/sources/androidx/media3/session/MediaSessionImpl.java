package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SequencedFutureManager;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.clevertap.android.sdk.Constants;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
class MediaSessionImpl {
    private static final String ANDROID_AUTOMOTIVE_LAUNCHER_PACKAGE_NAME = "com.android.car.carlauncher";
    private static final String ANDROID_AUTOMOTIVE_MEDIA_PACKAGE_NAME = "com.android.car.media";
    private static final String ANDROID_AUTO_PACKAGE_NAME = "com.google.android.projection.gearhead";
    private static final long DEFAULT_SESSION_POSITION_UPDATE_DELAY_MS = 3000;
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    private static final String SYSTEM_UI_PACKAGE_NAME = "com.android.systemui";
    public static final String TAG = "MediaSessionImpl";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player callback method is called from a wrong thread. See javadoc of MediaSession for details.";
    private final Handler applicationHandler;
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;
    private MediaSessionServiceLegacyStub browserServiceLegacyStub;
    private final MediaSession.Callback callback;
    private boolean closed;
    private final ImmutableList<CommandButton> commandButtonsForMediaItems;
    private final Context context;
    private MediaSession.ControllerInfo controllerForCurrentRequest;
    private ImmutableList<CommandButton> customLayout;
    private final MediaSession instance;
    private boolean isMediaNotificationControllerConnected;
    private final boolean isPeriodicPositionUpdateEnabled;
    private final Object lock = new Object();
    private final Handler mainHandler;
    private ImmutableList<CommandButton> mediaButtonPreferences;
    private final MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler;
    private MediaSession.Listener mediaSessionListener;
    private final PlayerInfoChangedHandler onPlayerInfoChangedHandler;
    private final Runnable periodicSessionPositionInfoUpdateRunnable;
    private final boolean playIfSuppressed;
    private PlayerInfo playerInfo;
    private PlayerListener playerListener;
    private PlayerWrapper playerWrapper;
    private PendingIntent sessionActivity;
    private Bundle sessionExtras;
    private final String sessionId;
    private final MediaSessionLegacyStub sessionLegacyStub;
    private long sessionPositionUpdateDelayMs;
    private final MediaSessionStub sessionStub;
    private final SessionToken sessionToken;
    private final Uri sessionUri;

    interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    public MediaSessionImpl(MediaSession mediaSession, Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, ImmutableList<CommandButton> immutableList2, ImmutableList<CommandButton> immutableList3, MediaSession.Callback callback, Bundle bundle, Bundle bundle2, androidx.media3.common.util.BitmapLoader bitmapLoader, boolean z, boolean z2) {
        Log.i(TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + Util.DEVICE_DEBUG_INFO + Constants.AES_SUFFIX);
        this.instance = mediaSession;
        this.context = context;
        this.sessionId = str;
        this.sessionActivity = pendingIntent;
        this.customLayout = immutableList;
        this.mediaButtonPreferences = immutableList2;
        this.commandButtonsForMediaItems = immutableList3;
        this.callback = callback;
        this.sessionExtras = bundle2;
        this.bitmapLoader = bitmapLoader;
        this.playIfSuppressed = z;
        this.isPeriodicPositionUpdateEnabled = z2;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.sessionStub = mediaSessionStub;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Looper applicationLooper = player.getApplicationLooper();
        Handler handler = new Handler(applicationLooper);
        this.applicationHandler = handler;
        this.playerInfo = PlayerInfo.DEFAULT;
        this.onPlayerInfoChangedHandler = new PlayerInfoChangedHandler(applicationLooper);
        this.mediaPlayPauseKeyHandler = new MediaPlayPauseKeyHandler(applicationLooper);
        Uri uriBuild = new Uri.Builder().scheme(MediaSessionImpl.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.sessionUri = uriBuild;
        MediaSessionLegacyStub mediaSessionLegacyStub = new MediaSessionLegacyStub(this, uriBuild, handler, bundle);
        this.sessionLegacyStub = mediaSessionLegacyStub;
        this.sessionToken = new SessionToken(Process.myUid(), 0, MediaLibraryInfo.VERSION_INT, 4, context.getPackageName(), mediaSessionStub, bundle, (MediaSession.Token) mediaSessionLegacyStub.getSessionCompat().getSessionToken().getToken());
        MediaSession.ConnectionResult connectionResultBuild = new MediaSession.ConnectionResult.AcceptedResultBuilder(mediaSession).build();
        final PlayerWrapper playerWrapper = new PlayerWrapper(player, z, immutableList, immutableList2, connectionResultBuild.availableSessionCommands, connectionResultBuild.availablePlayerCommands, bundle2);
        this.playerWrapper = playerWrapper;
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.setPlayerInternal(null, playerWrapper);
            }
        });
        this.sessionPositionUpdateDelayMs = 3000L;
        Objects.requireNonNull(this);
        this.periodicSessionPositionInfoUpdateRunnable = new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyPeriodicSessionPositionInfoChangesOnHandler();
            }
        };
        Objects.requireNonNull(this);
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.schedulePeriodicSessionPositionInfoChanges();
            }
        });
    }

    public void setPlayer(Player player) {
        if (player == this.playerWrapper.getWrappedPlayer()) {
            return;
        }
        setPlayerInternal(this.playerWrapper, new PlayerWrapper(player, this.playIfSuppressed, this.playerWrapper.getCustomLayout(), this.playerWrapper.getMediaButtonPreferences(), this.playerWrapper.getAvailableSessionCommands(), this.playerWrapper.getAvailablePlayerCommands(), this.playerWrapper.getLegacyExtras()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerInternal(final PlayerWrapper playerWrapper, final PlayerWrapper playerWrapper2) {
        this.playerWrapper = playerWrapper2;
        if (playerWrapper != null) {
            playerWrapper.removeListener((Player.Listener) Assertions.checkStateNotNull(this.playerListener));
        }
        PlayerListener playerListener = new PlayerListener(this, playerWrapper2);
        playerWrapper2.addListener(playerListener);
        this.playerListener = playerListener;
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda13
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlayerChanged(i, playerWrapper, playerWrapper2);
            }
        });
        if (playerWrapper == null) {
            this.sessionLegacyStub.start();
        }
        this.playerInfo = playerWrapper2.createPlayerInfoForBundling();
        handleAvailablePlayerCommandsChanged(playerWrapper2.getAvailableCommands());
    }

    public void release() {
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.5.1] [" + Util.DEVICE_DEBUG_INFO + "] [" + MediaLibraryInfo.registeredModules() + Constants.AES_SUFFIX);
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.mediaPlayPauseKeyHandler.clearPendingPlayPauseTask();
            this.applicationHandler.removeCallbacksAndMessages(null);
            try {
                Util.postOrRun(this.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9464lambda$release$2$androidxmedia3sessionMediaSessionImpl();
                    }
                });
            } catch (Exception e2) {
                Log.w(TAG, "Exception thrown while closing", e2);
            }
            this.sessionLegacyStub.release();
            this.sessionStub.release();
        }
    }

    /* JADX INFO: renamed from: lambda$release$2$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9464lambda$release$2$androidxmedia3sessionMediaSessionImpl() {
        PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            this.playerWrapper.removeListener(playerListener);
        }
    }

    public PlayerWrapper getPlayerWrapper() {
        return this.playerWrapper;
    }

    public Runnable callWithControllerForCurrentRequestSet(final MediaSession.ControllerInfo controllerInfo, final Runnable runnable) {
        return new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9460x8683e518(controllerInfo, runnable);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$callWithControllerForCurrentRequestSet$3$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9460x8683e518(MediaSession.ControllerInfo controllerInfo, Runnable runnable) {
        this.controllerForCurrentRequest = controllerInfo;
        runnable.run();
        this.controllerForCurrentRequest = null;
    }

    public String getId() {
        return this.sessionId;
    }

    public Uri getUri() {
        return this.sessionUri;
    }

    public SessionToken getToken() {
        return this.sessionToken;
    }

    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.sessionStub.getConnectedControllersManager().getConnectedControllers());
        if (this.isMediaNotificationControllerConnected) {
            ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionLegacyStub.getConnectedControllersManager().getConnectedControllers();
            for (int i = 0; i < connectedControllers.size(); i++) {
                MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
                if (!isSystemUiController(controllerInfo)) {
                    arrayList.add(controllerInfo);
                }
            }
            return arrayList;
        }
        arrayList.addAll(this.sessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    public MediaSession.ControllerInfo getControllerForCurrentRequest() {
        MediaSession.ControllerInfo controllerInfo = this.controllerForCurrentRequest;
        if (controllerInfo != null) {
            return resolveControllerInfoForCallback(controllerInfo);
        }
        return null;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        return this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo) || this.sessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo);
    }

    protected boolean isSystemUiController(MediaSession.ControllerInfo controllerInfo) {
        return controllerInfo != null && controllerInfo.getControllerVersion() == 0 && Objects.equals(controllerInfo.getPackageName(), SYSTEM_UI_PACKAGE_NAME);
    }

    public boolean isMediaNotificationController(MediaSession.ControllerInfo controllerInfo) {
        return Objects.equals(controllerInfo.getPackageName(), this.context.getPackageName()) && controllerInfo.getControllerVersion() != 0 && controllerInfo.getConnectionHints().getBoolean(MediaController.KEY_MEDIA_NOTIFICATION_CONTROLLER_FLAG, false);
    }

    public boolean isAutomotiveController(MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo.getControllerVersion() == 0) {
            return controllerInfo.getPackageName().equals(ANDROID_AUTOMOTIVE_MEDIA_PACKAGE_NAME) || controllerInfo.getPackageName().equals(ANDROID_AUTOMOTIVE_LAUNCHER_PACKAGE_NAME);
        }
        return false;
    }

    public boolean isAutoCompanionController(MediaSession.ControllerInfo controllerInfo) {
        return controllerInfo.getControllerVersion() == 0 && controllerInfo.getPackageName().equals(ANDROID_AUTO_PACKAGE_NAME);
    }

    protected MediaSession.ControllerInfo getSystemUiControllerInfo() {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionLegacyStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            if (isSystemUiController(controllerInfo)) {
                return controllerInfo;
            }
        }
        return null;
    }

    public MediaSession.ControllerInfo getMediaNotificationControllerInfo() {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            if (isMediaNotificationController(controllerInfo)) {
                return controllerInfo;
            }
        }
        return null;
    }

    protected boolean isMediaNotificationControllerConnected() {
        return this.isMediaNotificationControllerConnected;
    }

    public ListenableFuture<SessionResult> setCustomLayout(MediaSession.ControllerInfo controllerInfo, final ImmutableList<CommandButton> immutableList) {
        if (isMediaNotificationController(controllerInfo)) {
            this.playerWrapper.setCustomLayout(immutableList);
            this.sessionLegacyStub.updateLegacySessionPlaybackState(this.playerWrapper);
        }
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda28
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, immutableList);
            }
        });
    }

    public void setCustomLayout(final ImmutableList<CommandButton> immutableList) {
        this.customLayout = immutableList;
        this.playerWrapper.setCustomLayout(immutableList);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda30
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, immutableList);
            }
        });
    }

    public ListenableFuture<SessionResult> setMediaButtonPreferences(MediaSession.ControllerInfo controllerInfo, final ImmutableList<CommandButton> immutableList) {
        if (isMediaNotificationController(controllerInfo)) {
            this.playerWrapper.setMediaButtonPreferences(immutableList);
            this.sessionLegacyStub.updateLegacySessionPlaybackState(this.playerWrapper);
        }
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda0
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setMediaButtonPreferences(i, immutableList);
            }
        });
    }

    public void setMediaButtonPreferences(final ImmutableList<CommandButton> immutableList) {
        this.mediaButtonPreferences = immutableList;
        this.playerWrapper.setMediaButtonPreferences(immutableList);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda22
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setMediaButtonPreferences(i, immutableList);
            }
        });
    }

    public ImmutableList<CommandButton> getCustomLayout() {
        return this.customLayout;
    }

    public ImmutableList<CommandButton> getMediaButtonPreferences() {
        return this.mediaButtonPreferences;
    }

    public ImmutableList<CommandButton> getCommandButtonsForMediaItems() {
        return this.commandButtonsForMediaItems;
    }

    public void setSessionExtras(final Bundle bundle) {
        this.sessionExtras = bundle;
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda8
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onSessionExtrasChanged(i, bundle);
            }
        });
    }

    public void setSessionExtras(MediaSession.ControllerInfo controllerInfo, final Bundle bundle) {
        if (this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda24
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSessionExtrasChanged(i, bundle);
                }
            });
            if (isMediaNotificationController(controllerInfo)) {
                dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda25
                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                    public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onSessionExtrasChanged(i, bundle);
                    }
                });
            }
        }
    }

    public Bundle getSessionExtras() {
        return this.sessionExtras;
    }

    public androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.bitmapLoader;
    }

    public boolean shouldPlayIfSuppressed() {
        return this.playIfSuppressed;
    }

    public void setAvailableCommands(MediaSession.ControllerInfo controllerInfo, final SessionCommands sessionCommands, final Player.Commands commands) {
        if (this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            if (isMediaNotificationController(controllerInfo)) {
                setAvailableFrameworkControllerCommands(sessionCommands, commands);
                MediaSession.ControllerInfo systemUiControllerInfo = getSystemUiControllerInfo();
                if (systemUiControllerInfo != null) {
                    this.sessionLegacyStub.getConnectedControllersManager().updateCommandsFromSession(systemUiControllerInfo, sessionCommands, commands);
                }
            }
            this.sessionStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda29
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAvailableCommandsChangedFromSession(i, sessionCommands, commands);
                }
            });
            this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
            return;
        }
        this.sessionLegacyStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
    }

    public void broadcastCustomCommand(final SessionCommand sessionCommand, final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda17
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnPlayerInfoChanged(PlayerInfo playerInfo, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        int iObtainNextSequenceNumber;
        PlayerInfo playerInfoGenerateAndCacheUniqueTrackGroupIds = this.sessionStub.generateAndCacheUniqueTrackGroupIds(playerInfo);
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        int i = 0;
        while (i < connectedControllers.size()) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            try {
                ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
                SequencedFutureManager sequencedFutureManager = connectedControllersManager.getSequencedFutureManager(controllerInfo);
                if (sequencedFutureManager != null) {
                    iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
                } else if (!isConnected(controllerInfo)) {
                    return;
                } else {
                    iObtainNextSequenceNumber = 0;
                }
                z3 = z;
                z4 = z2;
                try {
                    ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onPlayerInfoChanged(iObtainNextSequenceNumber, playerInfoGenerateAndCacheUniqueTrackGroupIds, MediaUtils.intersect(connectedControllersManager.getAvailablePlayerCommands(controllerInfo), getPlayerWrapper().getAvailableCommands()), z3, z4);
                } catch (DeadObjectException unused) {
                    onDeadObjectException(controllerInfo);
                } catch (RemoteException e2) {
                    e = e2;
                    Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
                }
            } catch (DeadObjectException unused2) {
                z3 = z;
                z4 = z2;
            } catch (RemoteException e3) {
                e = e3;
                z3 = z;
                z4 = z2;
            }
            i++;
            z = z3;
            z2 = z4;
        }
    }

    public ListenableFuture<SessionResult> sendCustomCommand(MediaSession.ControllerInfo controllerInfo, final SessionCommand sessionCommand, final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda12
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    public void sendError(MediaSession.ControllerInfo controllerInfo, final SessionError sessionError) {
        if (controllerInfo.getControllerVersion() == 0 || controllerInfo.getInterfaceVersion() >= 4) {
            if (isMediaNotificationController(controllerInfo) || controllerInfo.getControllerVersion() == 0) {
                dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda18
                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                    public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onError(i, sessionError);
                    }
                });
            } else {
                dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda19
                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                    public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        controllerCb.onError(i, sessionError);
                    }
                });
            }
        }
    }

    public void sendError(final SessionError sessionError) {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            if (!isMediaNotificationController(controllerInfo)) {
                sendError(controllerInfo, sessionError);
            }
        }
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda16
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                controllerCb.onError(i2, sessionError);
            }
        });
    }

    public MediaSession.ConnectionResult onConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        ImmutableList<CommandButton> customLayout;
        ImmutableList<CommandButton> mediaButtonPreferences;
        if (this.isMediaNotificationControllerConnected && isSystemUiController(controllerInfo)) {
            return new MediaSession.ConnectionResult.AcceptedResultBuilder(this.instance).setAvailableSessionCommands(this.playerWrapper.getAvailableSessionCommands()).setAvailablePlayerCommands(this.playerWrapper.getAvailablePlayerCommands()).setCustomLayout(this.playerWrapper.getCustomLayout()).setMediaButtonPreferences(this.playerWrapper.getMediaButtonPreferences()).build();
        }
        MediaSession.ConnectionResult connectionResult = (MediaSession.ConnectionResult) Assertions.checkNotNull(this.callback.onConnect(this.instance, controllerInfo), "Callback.onConnect must return non-null future");
        if (isMediaNotificationController(controllerInfo) && connectionResult.isAccepted) {
            this.isMediaNotificationControllerConnected = true;
            PlayerWrapper playerWrapper = this.playerWrapper;
            if (connectionResult.customLayout != null) {
                customLayout = connectionResult.customLayout;
            } else {
                customLayout = this.instance.getCustomLayout();
            }
            playerWrapper.setCustomLayout(customLayout);
            PlayerWrapper playerWrapper2 = this.playerWrapper;
            if (connectionResult.mediaButtonPreferences != null) {
                mediaButtonPreferences = connectionResult.mediaButtonPreferences;
            } else {
                mediaButtonPreferences = this.instance.getMediaButtonPreferences();
            }
            playerWrapper2.setMediaButtonPreferences(mediaButtonPreferences);
            setAvailableFrameworkControllerCommands(connectionResult.availableSessionCommands, connectionResult.availablePlayerCommands);
        }
        return connectionResult;
    }

    public void onPostConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        if (this.isMediaNotificationControllerConnected && isSystemUiController(controllerInfo)) {
            return;
        }
        this.callback.onPostConnect(this.instance, controllerInfo);
    }

    public void onDisconnectedOnHandler(MediaSession.ControllerInfo controllerInfo) {
        if (this.isMediaNotificationControllerConnected) {
            if (isSystemUiController(controllerInfo)) {
                return;
            }
            if (isMediaNotificationController(controllerInfo)) {
                this.isMediaNotificationControllerConnected = false;
            }
        }
        this.callback.onDisconnected(this.instance, controllerInfo);
    }

    public int onPlayerCommandRequestOnHandler(MediaSession.ControllerInfo controllerInfo, int i) {
        return this.callback.onPlayerCommandRequest(this.instance, resolveControllerInfoForCallback(controllerInfo), i);
    }

    public ListenableFuture<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, String str, Rating rating) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetRating(this.instance, resolveControllerInfoForCallback(controllerInfo), str, rating), "Callback.onSetRating must return non-null future");
    }

    public ListenableFuture<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, Rating rating) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetRating(this.instance, resolveControllerInfoForCallback(controllerInfo), rating), "Callback.onSetRating must return non-null future");
    }

    public ListenableFuture<SessionResult> onCustomCommandOnHandler(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onCustomCommand(this.instance, resolveControllerInfoForCallback(controllerInfo), sessionCommand, bundle), "Callback.onCustomCommandOnHandler must return non-null future");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ListenableFuture<List<MediaItem>> onAddMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onAddMediaItems(this.instance, resolveControllerInfoForCallback(controllerInfo), list), "Callback.onAddMediaItems must return a non-null future");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ListenableFuture<MediaSession.MediaItemsWithStartPosition> onSetMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list, int i, long j) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetMediaItems(this.instance, resolveControllerInfoForCallback(controllerInfo), list, i, j), "Callback.onSetMediaItems must return a non-null future");
    }

    protected void onPlayerInteractionFinishedOnHandler(MediaSession.ControllerInfo controllerInfo, Player.Commands commands) {
        this.callback.onPlayerInteractionFinished(this.instance, resolveControllerInfoForCallback(controllerInfo), commands);
    }

    public void connectFromService(IMediaController iMediaController, MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.connect(iMediaController, controllerInfo);
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionLegacyStub.getSessionCompat();
    }

    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.sessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
    }

    protected Context getContext() {
        return this.context;
    }

    protected Handler getApplicationHandler() {
        return this.applicationHandler;
    }

    protected boolean isReleased() {
        boolean z;
        synchronized (this.lock) {
            z = this.closed;
        }
        return z;
    }

    protected PendingIntent getSessionActivity() {
        return this.sessionActivity;
    }

    protected void setSessionActivity(PendingIntent pendingIntent) {
        this.sessionActivity = pendingIntent;
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            setSessionActivity(connectedControllers.get(i), pendingIntent);
        }
    }

    protected void setSessionActivity(MediaSession.ControllerInfo controllerInfo, final PendingIntent pendingIntent) {
        if (controllerInfo.getControllerVersion() < 3 || !this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            return;
        }
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda14
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onSessionActivityChanged(i, pendingIntent);
            }
        });
        if (isMediaNotificationController(controllerInfo)) {
            dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSessionActivityChanged(i, pendingIntent);
                }
            });
        }
    }

    protected MediaSession.ControllerInfo resolveControllerInfoForCallback(MediaSession.ControllerInfo controllerInfo) {
        return (this.isMediaNotificationControllerConnected && isSystemUiController(controllerInfo)) ? (MediaSession.ControllerInfo) Assertions.checkNotNull(getMediaNotificationControllerInfo()) : controllerInfo;
    }

    protected IBinder getLegacyBrowserServiceBinder() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            if (this.browserServiceLegacyStub == null) {
                this.browserServiceLegacyStub = createLegacyBrowserService(this.instance.getSessionCompat().getSessionToken());
            }
            mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaSessionServiceLegacyStub.onBind(new Intent("android.media.browse.MediaBrowserService"));
    }

    protected MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub = new MediaSessionServiceLegacyStub(this);
        mediaSessionServiceLegacyStub.initialize(token);
        return mediaSessionServiceLegacyStub;
    }

    protected void setSessionPositionUpdateDelayMsOnHandler(long j) {
        verifyApplicationThread();
        this.sessionPositionUpdateDelayMs = j;
        schedulePeriodicSessionPositionInfoChanges();
    }

    protected MediaSessionServiceLegacyStub getLegacyBrowserService() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaSessionServiceLegacyStub;
    }

    boolean canResumePlaybackOnStart() {
        return this.sessionLegacyStub.canResumePlaybackOnStart();
    }

    void setMediaSessionListener(MediaSession.Listener listener) {
        this.mediaSessionListener = listener;
    }

    void clearMediaSessionListener() {
        this.mediaSessionListener = null;
    }

    void onNotificationRefreshRequired() {
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9462xb6dfc4ae();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onNotificationRefreshRequired$19$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9462xb6dfc4ae() {
        MediaSession.Listener listener = this.mediaSessionListener;
        if (listener != null) {
            listener.onNotificationRefreshRequired(this.instance);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean onPlayRequested() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final SettableFuture settableFutureCreate = SettableFuture.create();
            this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9463x44552b43(settableFutureCreate);
                }
            });
            try {
                return ((Boolean) settableFutureCreate.get()).booleanValue();
            } catch (InterruptedException | ExecutionException e2) {
                throw new IllegalStateException(e2);
            }
        }
        MediaSession.Listener listener = this.mediaSessionListener;
        if (listener != null) {
            return listener.onPlayRequested(this.instance);
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$onPlayRequested$20$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9463x44552b43(SettableFuture settableFuture) {
        settableFuture.set(Boolean.valueOf(onPlayRequested()));
    }

    void handleMediaControllerPlayRequest(MediaSession.ControllerInfo controllerInfo, boolean z) {
        if (onPlayRequested()) {
            boolean z2 = this.playerWrapper.isCommandAvailable(16) && this.playerWrapper.getCurrentMediaItem() != null;
            boolean z3 = this.playerWrapper.isCommandAvailable(31) || this.playerWrapper.isCommandAvailable(20);
            MediaSession.ControllerInfo controllerInfoResolveControllerInfoForCallback = resolveControllerInfoForCallback(controllerInfo);
            Player.Commands commandsBuild = new Player.Commands.Builder().add(1).build();
            if (z2 || !z3) {
                if (!z2) {
                    Log.w(TAG, "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
                }
                Util.handlePlayButtonAction(this.playerWrapper);
                if (z) {
                    onPlayerInteractionFinishedOnHandler(controllerInfoResolveControllerInfoForCallback, commandsBuild);
                    return;
                }
                return;
            }
            Futures.addCallback((ListenableFuture) Assertions.checkNotNull(this.callback.onPlaybackResumption(this.instance, controllerInfoResolveControllerInfoForCallback), "Callback.onPlaybackResumption must return a non-null future"), new AnonymousClass1(controllerInfoResolveControllerInfoForCallback, z, commandsBuild), new Executor() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda27
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    this.f$0.postOrRunOnApplicationHandler(runnable);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.media3.session.MediaSessionImpl$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ boolean val$callOnPlayerInteractionFinished;
        final /* synthetic */ MediaSession.ControllerInfo val$controllerForRequest;
        final /* synthetic */ Player.Commands val$playCommand;

        AnonymousClass1(MediaSession.ControllerInfo controllerInfo, boolean z, Player.Commands commands) {
            this.val$controllerForRequest = controllerInfo;
            this.val$callOnPlayerInteractionFinished = z;
            this.val$playCommand = commands;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(final MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
            final MediaSession.ControllerInfo controllerInfo = this.val$controllerForRequest;
            final boolean z = this.val$callOnPlayerInteractionFinished;
            final Player.Commands commands = this.val$playCommand;
            mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9465lambda$onSuccess$0$androidxmedia3sessionMediaSessionImpl$1(mediaItemsWithStartPosition, z, controllerInfo, commands);
                }
            }).run();
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$androidx-media3-session-MediaSessionImpl$1, reason: not valid java name */
        /* synthetic */ void m9465lambda$onSuccess$0$androidxmedia3sessionMediaSessionImpl$1(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition, boolean z, MediaSession.ControllerInfo controllerInfo, Player.Commands commands) {
            MediaUtils.setMediaItemsWithStartIndexAndPosition(MediaSessionImpl.this.playerWrapper, mediaItemsWithStartPosition);
            Util.handlePlayButtonAction(MediaSessionImpl.this.playerWrapper);
            if (z) {
                MediaSessionImpl.this.onPlayerInteractionFinishedOnHandler(controllerInfo, commands);
            }
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            if (th instanceof UnsupportedOperationException) {
                Log.w(MediaSessionImpl.TAG, "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
            } else {
                Log.e(MediaSessionImpl.TAG, "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
            }
            Util.handlePlayButtonAction(MediaSessionImpl.this.playerWrapper);
            if (this.val$callOnPlayerInteractionFinished) {
                MediaSessionImpl.this.onPlayerInteractionFinishedOnHandler(this.val$controllerForRequest, this.val$playCommand);
            }
        }
    }

    private void setAvailableFrameworkControllerCommands(SessionCommands sessionCommands, Player.Commands commands) {
        boolean z = this.playerWrapper.getAvailablePlayerCommands().contains(17) != commands.contains(17);
        this.playerWrapper.setAvailableCommands(sessionCommands, commands);
        if (z) {
            this.sessionLegacyStub.updateLegacySessionPlaybackStateAndQueue(this.playerWrapper);
        } else {
            this.sessionLegacyStub.updateLegacySessionPlaybackState(this.playerWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRemoteControllerTaskToLegacyStub(RemoteControllerTask remoteControllerTask) {
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e2) {
            Log.e(TAG, "Exception in using media1 API", e2);
        }
    }

    private void dispatchOnPeriodicSessionPositionInfoChanged(final SessionPositionInfo sessionPositionInfo) {
        ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            final MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            final boolean zIsPlayerCommandAvailable = connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 16);
            final boolean zIsPlayerCommandAvailable2 = connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 17);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda26
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPeriodicSessionPositionInfoChanged(i2, sessionPositionInfo, zIsPlayerCommandAvailable, zIsPlayerCommandAvailable2, controllerInfo.getInterfaceVersion());
                }
            });
        }
        try {
            this.sessionLegacyStub.getControllerLegacyCbForBroadcast().onPeriodicSessionPositionInfoChanged(0, sessionPositionInfo, true, true, 0);
        } catch (RemoteException e2) {
            Log.e(TAG, "Exception in using media1 API", e2);
        }
    }

    protected void dispatchRemoteControllerTaskWithoutReturn(RemoteControllerTask remoteControllerTask) {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e2) {
            Log.e(TAG, "Exception in using media1 API", e2);
        }
    }

    protected void dispatchRemoteControllerTaskWithoutReturn(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int iObtainNextSequenceNumber;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
            } else if (!isConnected(controllerInfo)) {
                return;
            } else {
                iObtainNextSequenceNumber = 0;
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, iObtainNextSequenceNumber);
            }
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
        }
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int sequenceNumber;
        ListenableFuture<SessionResult> listenableFutureImmediateFuture;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture sequencedFutureCreateSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                SequencedFutureManager.SequencedFuture sequencedFuture = sequencedFutureCreateSequencedFuture;
                sequenceNumber = sequencedFutureCreateSequencedFuture.getSequenceNumber();
                listenableFutureImmediateFuture = sequencedFutureCreateSequencedFuture;
            } else {
                if (!isConnected(controllerInfo)) {
                    return Futures.immediateFuture(new SessionResult(-100));
                }
                sequenceNumber = 0;
                listenableFutureImmediateFuture = Futures.immediateFuture(new SessionResult(0));
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, sequenceNumber);
            }
            return listenableFutureImmediateFuture;
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
            return Futures.immediateFuture(new SessionResult(-100));
        } catch (RemoteException e2) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
            return Futures.immediateFuture(new SessionResult(-1));
        }
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyApplicationThread() {
        if (Looper.myLooper() != this.applicationHandler.getLooper()) {
            throw new IllegalStateException(WRONG_THREAD_ERROR_MESSAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPeriodicSessionPositionInfoChangesOnHandler() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            SessionPositionInfo sessionPositionInfoCreateSessionPositionInfoForBundling = this.playerWrapper.createSessionPositionInfoForBundling();
            if (!this.onPlayerInfoChangedHandler.hasPendingPlayerInfoChangedUpdate() && MediaUtils.areSessionPositionInfosInSamePeriodOrAd(sessionPositionInfoCreateSessionPositionInfoForBundling, this.playerInfo.sessionPositionInfo)) {
                dispatchOnPeriodicSessionPositionInfoChanged(sessionPositionInfoCreateSessionPositionInfoForBundling);
            }
            schedulePeriodicSessionPositionInfoChanges();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedulePeriodicSessionPositionInfoChanges() {
        this.applicationHandler.removeCallbacks(this.periodicSessionPositionInfoUpdateRunnable);
        if (!this.isPeriodicPositionUpdateEnabled || this.sessionPositionUpdateDelayMs <= 0) {
            return;
        }
        if (this.playerWrapper.isPlaying() || this.playerWrapper.isLoading()) {
            this.applicationHandler.postDelayed(this.periodicSessionPositionInfoUpdateRunnable, this.sessionPositionUpdateDelayMs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAvailablePlayerCommandsChanged(final Player.Commands commands) {
        this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda9
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onAvailableCommandsChangedFromPlayer(i, commands);
            }
        });
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda10
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                this.f$0.m9461x512b9ea9(controllerCb, i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAvailablePlayerCommandsChanged$23$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9461x512b9ea9(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
        controllerCb.onDeviceInfoChanged(i, this.playerInfo.deviceInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean onMediaButtonEvent(androidx.media3.session.MediaSession.ControllerInfo r8, android.content.Intent r9) {
        /*
            r7 = this;
            android.view.KeyEvent r0 = androidx.media3.session.DefaultActionFactory.getKeyEvent(r9)
            android.content.ComponentName r1 = r9.getComponent()
            java.lang.String r2 = r9.getAction()
            java.lang.String r3 = "android.intent.action.MEDIA_BUTTON"
            boolean r2 = java.util.Objects.equals(r2, r3)
            r3 = 0
            if (r2 == 0) goto Lb4
            if (r1 == 0) goto L27
            java.lang.String r1 = r1.getPackageName()
            android.content.Context r2 = r7.context
            java.lang.String r2 = r2.getPackageName()
            boolean r1 = java.util.Objects.equals(r1, r2)
            if (r1 == 0) goto Lb4
        L27:
            if (r0 == 0) goto Lb4
            int r1 = r0.getAction()
            if (r1 == 0) goto L31
            goto Lb4
        L31:
            r7.verifyApplicationThread()
            androidx.media3.session.MediaSession$Callback r1 = r7.callback
            androidx.media3.session.MediaSession r2 = r7.instance
            boolean r9 = r1.onMediaButtonEvent(r2, r8, r9)
            r1 = 1
            if (r9 == 0) goto L40
            return r1
        L40:
            int r9 = r0.getKeyCode()
            android.content.Context r2 = r7.context
            android.content.pm.PackageManager r2 = r2.getPackageManager()
            java.lang.String r4 = "android.software.leanback"
            boolean r2 = r2.hasSystemFeature(r4)
            r4 = 85
            r5 = 79
            if (r9 == r5) goto L5e
            if (r9 == r4) goto L5e
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r2 = r7.mediaPlayPauseKeyHandler
            r2.flush()
            goto L87
        L5e:
            if (r2 != 0) goto L82
            int r2 = r8.getControllerVersion()
            if (r2 != 0) goto L82
            int r2 = r0.getRepeatCount()
            if (r2 == 0) goto L6d
            goto L82
        L6d:
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r2 = r7.mediaPlayPauseKeyHandler
            boolean r2 = r2.hasPendingPlayPauseTask()
            if (r2 == 0) goto L7c
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r2 = r7.mediaPlayPauseKeyHandler
            r2.clearPendingPlayPauseTask()
            r2 = r1
            goto L88
        L7c:
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r9 = r7.mediaPlayPauseKeyHandler
            r9.setPendingPlayPauseTask(r8, r0)
            return r1
        L82:
            androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler r2 = r7.mediaPlayPauseKeyHandler
            r2.flush()
        L87:
            r2 = r3
        L88:
            boolean r6 = r7.isMediaNotificationControllerConnected()
            if (r6 != 0) goto Laf
            if (r9 == r4) goto L92
            if (r9 != r5) goto L9a
        L92:
            if (r2 == 0) goto L9a
            androidx.media3.session.MediaSessionLegacyStub r8 = r7.sessionLegacyStub
            r8.onSkipToNext()
            return r1
        L9a:
            int r8 = r8.getControllerVersion()
            if (r8 == 0) goto Lae
            androidx.media3.session.MediaSessionLegacyStub r8 = r7.sessionLegacyStub
            androidx.media3.session.legacy.MediaSessionCompat r8 = r8.getSessionCompat()
            androidx.media3.session.legacy.MediaControllerCompat r8 = r8.getController()
            r8.dispatchMediaButtonEvent(r0)
            return r1
        Lae:
            return r3
        Laf:
            boolean r8 = r7.applyMediaButtonKeyEvent(r0, r2)
            return r8
        Lb4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionImpl.onMediaButtonEvent(androidx.media3.session.MediaSession$ControllerInfo, android.content.Intent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean applyMediaButtonKeyEvent(android.view.KeyEvent r3, boolean r4) {
        /*
            r2 = this;
            androidx.media3.session.MediaSession r0 = r2.instance
            androidx.media3.session.MediaSession$ControllerInfo r0 = r0.getMediaNotificationControllerInfo()
            java.lang.Object r0 = androidx.media3.common.util.Assertions.checkNotNull(r0)
            androidx.media3.session.MediaSession$ControllerInfo r0 = (androidx.media3.session.MediaSession.ControllerInfo) r0
            int r3 = r3.getKeyCode()
            r1 = 85
            if (r3 == r1) goto L18
            r1 = 79
            if (r3 != r1) goto L1c
        L18:
            if (r4 == 0) goto L1c
            r3 = 87
        L1c:
            r4 = 126(0x7e, float:1.77E-43)
            if (r3 == r4) goto L6b
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 == r4) goto L65
            r4 = 272(0x110, float:3.81E-43)
            if (r3 == r4) goto L5f
            r4 = 273(0x111, float:3.83E-43)
            if (r3 == r4) goto L59
            switch(r3) {
                case 85: goto L43;
                case 86: goto L3d;
                case 87: goto L5f;
                case 88: goto L59;
                case 89: goto L37;
                case 90: goto L31;
                default: goto L2f;
            }
        L2f:
            r3 = 0
            return r3
        L31:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda4 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda4
            r3.<init>()
            goto L70
        L37:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda5 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda5
            r3.<init>()
            goto L70
        L3d:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda6 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda6
            r3.<init>()
            goto L70
        L43:
            androidx.media3.session.PlayerWrapper r3 = r2.getPlayerWrapper()
            boolean r3 = r3.getPlayWhenReady()
            if (r3 == 0) goto L53
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda34 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda34
            r3.<init>()
            goto L70
        L53:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda35 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda35
            r3.<init>()
            goto L70
        L59:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda3 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda3
            r3.<init>()
            goto L70
        L5f:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda2 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda2
            r3.<init>()
            goto L70
        L65:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda1 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda1
            r3.<init>()
            goto L70
        L6b:
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda36 r3 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda36
            r3.<init>()
        L70:
            android.os.Handler r4 = r2.getApplicationHandler()
            androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda7 r1 = new androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda7
            r1.<init>()
            androidx.media3.common.util.Util.postOrRun(r4, r1)
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionImpl.applyMediaButtonKeyEvent(android.view.KeyEvent, boolean):boolean");
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$24$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9450x9e89ee61(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.pauseForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$25$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9451xa5ef2380(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.playForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$26$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9452xad54589f(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.playForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$27$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9453xb4b98dbe(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.pauseForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$28$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9454xbc1ec2dd(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.seekToNextForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$29$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9455xc383f7fc(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.seekToPreviousForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$30$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9456x663688a6(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.seekForwardForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$31$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9457x6d9bbdc5(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.seekBackForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$32$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9458x7500f2e4(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.stopForControllerInfo(controllerInfo, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: lambda$applyMediaButtonKeyEvent$33$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m9459x7c662803(Runnable runnable, MediaSession.ControllerInfo controllerInfo) {
        runnable.run();
        this.sessionStub.getConnectedControllersManager().flushCommandQueue(controllerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOrRunOnApplicationHandler(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PlayerListener implements Player.Listener {
        private final WeakReference<PlayerWrapper> player;
        private final WeakReference<MediaSessionImpl> session;

        public PlayerListener(MediaSessionImpl mediaSessionImpl, PlayerWrapper playerWrapper) {
            this.session = new WeakReference<>(mediaSessionImpl);
            this.player = new WeakReference<>(playerWrapper);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(final PlaybackException playbackException) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayerError(playbackException);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda20
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlayerError(i, playbackException);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaItemTransition(final MediaItem mediaItem, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaItemTransitionReason(i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda16
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onMediaItemTransition(i2, mediaItem, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayWhenReadyChanged(final boolean z, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(z, i, session.playerInfo.playbackSuppressionReason);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda21
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlayWhenReadyChanged(i2, z, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackSuppressionReasonChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(session.playerInfo.playWhenReady, session.playerInfo.playWhenReadyChangeReason, i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda23
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlaybackSuppressionReasonChanged(i2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackStateChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            final PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackState(i, playerWrapper.getPlayerError());
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda6
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlaybackStateChanged(i2, i, playerWrapper.getPlayerError());
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsPlayingChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsPlaying(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda11
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onIsPlayingChanged(i, z);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsLoadingChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsLoading(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda2
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onIsLoadingChanged(i, z);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPositionDiscontinuity(final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPositionInfos(positionInfo, positionInfo2, i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda19
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPositionDiscontinuity(i2, positionInfo, positionInfo2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackParameters(playbackParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda10
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackParametersChanged(i, playbackParameters);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekBackIncrementChanged(final long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekBackIncrement(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda18
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekBackIncrementChanged(i, j);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekForwardIncrementChanged(final long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekForwardIncrement(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda14
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekForwardIncrementChanged(i, j);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTimelineChanged(final Timeline timeline, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTimelineAndSessionPositionInfo(timeline, playerWrapper.createSessionPositionInfoForBundling(), i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onTimelineChanged(i2, timeline, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaylistMetadataChanged(final MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithPlaylistMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda0
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRepeatModeChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithRepeatMode(i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda12
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onShuffleModeEnabledChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithShuffleModeEnabled(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda3
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeEnabledChanged(i, z);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAudioAttributesChanged(final AudioAttributes audioAttributes) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithAudioAttributes(audioAttributes);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda8
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAudioAttributesChanged(i, audioAttributes);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVideoSizeChanged(final VideoSize videoSize) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVideoSize(videoSize);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda22
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVideoSizeChanged(i, videoSize);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVolumeChanged(final float f2) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVolume(f2);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda9
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVolumeChanged(i, f2);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(CueGroup cueGroup) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = new PlayerInfo.Builder(session.playerInfo).setCues(cueGroup).build();
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceInfoChanged(final DeviceInfo deviceInfo) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceInfo(deviceInfo);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda4
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onDeviceInfoChanged(i, deviceInfo);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceVolumeChanged(final int i, final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceVolume(i, z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda17
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onDeviceVolumeChanged(i2, i, z);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAvailableCommandsChanged(Player.Commands commands) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.handleAvailablePlayerCommandsChanged(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(final Tracks tracks) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithCurrentTracks(tracks);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, false);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda5
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTracksChanged(i, tracks);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackSelectionParametersChanged(i, trackSelectionParameters);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda13
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onMediaMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRenderedFirstFrame() {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda15
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRenderedFirstFrame(i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMaxSeekToPreviousPositionChanged(long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMaxSeekToPreviousPositionMs(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        private MediaSessionImpl getSession() {
            return this.session.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MediaPlayPauseKeyHandler extends Handler {
        private Runnable playPauseTask;

        public MediaPlayPauseKeyHandler(Looper looper) {
            super(looper);
        }

        public void setPendingPlayPauseTask(final MediaSession.ControllerInfo controllerInfo, final KeyEvent keyEvent) {
            Runnable runnable = new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$MediaPlayPauseKeyHandler$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9466xa939a527(controllerInfo, keyEvent);
                }
            };
            this.playPauseTask = runnable;
            postDelayed(runnable, ViewConfiguration.getDoubleTapTimeout());
        }

        /* JADX INFO: renamed from: lambda$setPendingPlayPauseTask$0$androidx-media3-session-MediaSessionImpl$MediaPlayPauseKeyHandler, reason: not valid java name */
        /* synthetic */ void m9466xa939a527(MediaSession.ControllerInfo controllerInfo, KeyEvent keyEvent) {
            if (MediaSessionImpl.this.isMediaNotificationController(controllerInfo)) {
                MediaSessionImpl.this.applyMediaButtonKeyEvent(keyEvent, false);
            } else {
                MediaSessionImpl.this.sessionLegacyStub.handleMediaPlayPauseOnHandler((MediaSessionManager.RemoteUserInfo) Assertions.checkNotNull(controllerInfo.getRemoteUserInfo()));
            }
            this.playPauseTask = null;
        }

        public Runnable clearPendingPlayPauseTask() {
            Runnable runnable = this.playPauseTask;
            if (runnable == null) {
                return null;
            }
            removeCallbacks(runnable);
            Runnable runnable2 = this.playPauseTask;
            this.playPauseTask = null;
            return runnable2;
        }

        public boolean hasPendingPlayPauseTask() {
            return this.playPauseTask != null;
        }

        public void flush() {
            Runnable runnableClearPendingPlayPauseTask = clearPendingPlayPauseTask();
            if (runnableClearPendingPlayPauseTask != null) {
                Util.postOrRun(this, runnableClearPendingPlayPauseTask);
            }
        }
    }

    private class PlayerInfoChangedHandler extends Handler {
        private static final int MSG_PLAYER_INFO_CHANGED = 1;
        private boolean excludeTimeline;
        private boolean excludeTracks;

        public PlayerInfoChangedHandler(Looper looper) {
            super(looper);
            this.excludeTimeline = true;
            this.excludeTracks = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
                mediaSessionImpl.playerInfo = mediaSessionImpl.playerInfo.copyWithTimelineAndSessionPositionInfo(MediaSessionImpl.this.getPlayerWrapper().getCurrentTimelineWithCommandCheck(), MediaSessionImpl.this.getPlayerWrapper().createSessionPositionInfoForBundling(), MediaSessionImpl.this.playerInfo.timelineChangeReason);
                MediaSessionImpl mediaSessionImpl2 = MediaSessionImpl.this;
                mediaSessionImpl2.dispatchOnPlayerInfoChanged(mediaSessionImpl2.playerInfo, this.excludeTimeline, this.excludeTracks);
                this.excludeTimeline = true;
                this.excludeTracks = true;
                return;
            }
            throw new IllegalStateException("Invalid message what=" + message.what);
        }

        public boolean hasPendingPlayerInfoChangedUpdate() {
            return hasMessages(1);
        }

        public void sendPlayerInfoChangedMessage(boolean z, boolean z2) {
            boolean z3 = false;
            this.excludeTimeline = this.excludeTimeline && z;
            if (this.excludeTracks && z2) {
                z3 = true;
            }
            this.excludeTracks = z3;
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }
    }
}
