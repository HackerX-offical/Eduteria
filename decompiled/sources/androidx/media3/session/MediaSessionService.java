package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaSessionManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    private static final String TAG = "MSessionService";
    private DefaultActionFactory actionFactory;
    private Listener listener;
    private MediaNotificationManager mediaNotificationManager;
    private MediaNotification.Provider mediaNotificationProvider;
    private MediaSessionServiceStub stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<String, MediaSession> sessions = new ArrayMap();
    private boolean defaultMethodCalled = false;

    public interface Listener {
        default void onForegroundServiceStartNotAllowedException() {
        }
    }

    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (this.lock) {
            this.stub = new MediaSessionServiceStub(this);
        }
    }

    public final void addSession(final MediaSession mediaSession) {
        MediaSession mediaSession2;
        Assertions.checkNotNull(mediaSession, "session must not be null");
        boolean z = true;
        Assertions.checkArgument(!mediaSession.isReleased(), "session is already released");
        synchronized (this.lock) {
            mediaSession2 = this.sessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z = false;
            }
            Assertions.checkArgument(z, "Session ID should be unique");
            this.sessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
            Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9496lambda$addSession$0$androidxmedia3sessionMediaSessionService(mediaNotificationManager, mediaSession);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addSession$0$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m9496lambda$addSession$0$androidxmedia3sessionMediaSessionService(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.addSession(mediaSession);
        mediaSession.setListener(new MediaSessionListener());
    }

    public final void removeSession(final MediaSession mediaSession) {
        Assertions.checkNotNull(mediaSession, "session must not be null");
        synchronized (this.lock) {
            Assertions.checkArgument(this.sessions.containsKey(mediaSession.getId()), "session not found");
            this.sessions.remove(mediaSession.getId());
        }
        final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.lambda$removeSession$1(mediaNotificationManager, mediaSession);
            }
        });
    }

    static /* synthetic */ void lambda$removeSession$1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.removeSession(mediaSession);
        mediaSession.clearListener();
    }

    public final List<MediaSession> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaSession mediaSession) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(mediaSession.getId());
        }
        return zContainsKey;
    }

    public final void setListener(Listener listener) {
        synchronized (this.lock) {
            this.listener = listener;
        }
    }

    public final void clearListener() {
        synchronized (this.lock) {
            this.listener = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        MediaSession mediaSessionOnGetSession;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        action.hashCode();
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (mediaSessionOnGetSession = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(mediaSessionOnGetSession);
        return mediaSessionOnGetSession.getLegacyBrowserServiceBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        String customAction;
        if (intent == null) {
            return 1;
        }
        DefaultActionFactory actionFactory = getActionFactory();
        Uri data = intent.getData();
        MediaSession session = data != null ? MediaSession.getSession(data) : null;
        if (actionFactory.isMediaAction(intent)) {
            if (session == null) {
                session = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (session == null) {
                    return 1;
                }
                addSession(session);
            }
            final MediaSessionImpl impl = session.getImpl();
            impl.getApplicationHandler().post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionService.lambda$onStartCommand$2(impl, intent);
                }
            });
        } else {
            if (session == null || !actionFactory.isCustomAction(intent) || (customAction = actionFactory.getCustomAction(intent)) == null) {
                return 1;
            }
            getMediaNotificationManager().onCustomAction(session, customAction, actionFactory.getCustomActionExtras(intent));
        }
        return 1;
    }

    static /* synthetic */ void lambda$onStartCommand$2(MediaSessionImpl mediaSessionImpl, Intent intent) {
        MediaSession.ControllerInfo mediaNotificationControllerInfo = mediaSessionImpl.getMediaNotificationControllerInfo();
        if (mediaNotificationControllerInfo == null) {
            mediaNotificationControllerInfo = createFallbackMediaButtonCaller(intent);
        }
        if (mediaSessionImpl.onMediaButtonEvent(mediaNotificationControllerInfo, intent)) {
            return;
        }
        Log.d(TAG, "Ignored unrecognized media button intent.");
    }

    private static MediaSession.ControllerInfo createFallbackMediaButtonCaller(Intent intent) {
        String packageName;
        ComponentName component = intent.getComponent();
        if (component != null) {
            packageName = component.getPackageName();
        } else {
            packageName = SERVICE_INTERFACE;
        }
        return new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo(packageName, -1, -1), MediaLibraryInfo.VERSION_INT, 7, false, null, Bundle.EMPTY, 0);
    }

    public boolean isPlaybackOngoing() {
        return getMediaNotificationManager().isStartedInForeground();
    }

    public void pauseAllPlayersAndStopSelf() {
        List<MediaSession> sessions = getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            sessions.get(i).getPlayer().setPlayWhenReady(false);
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (isPlaybackOngoing()) {
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            MediaSessionServiceStub mediaSessionServiceStub = this.stub;
            if (mediaSessionServiceStub != null) {
                mediaSessionServiceStub.release();
                this.stub = null;
            }
        }
    }

    @Deprecated
    public void onUpdateNotification(MediaSession mediaSession) {
        this.defaultMethodCalled = true;
    }

    public void onUpdateNotification(MediaSession mediaSession, boolean z) {
        onUpdateNotification(mediaSession);
        if (this.defaultMethodCalled) {
            getMediaNotificationManager().updateNotification(mediaSession, z);
        }
    }

    protected final void setMediaNotificationProvider(MediaNotification.Provider provider) {
        Assertions.checkNotNull(provider);
        synchronized (this.lock) {
            this.mediaNotificationProvider = provider;
        }
    }

    IBinder getServiceBinder() {
        IBinder iBinderAsBinder;
        synchronized (this.lock) {
            iBinderAsBinder = ((MediaSessionServiceStub) Assertions.checkStateNotNull(this.stub)).asBinder();
        }
        return iBinderAsBinder;
    }

    boolean onUpdateNotificationInternal(MediaSession mediaSession, boolean z) {
        try {
            onUpdateNotification(mediaSession, getMediaNotificationManager().shouldRunInForeground(mediaSession, z));
            return true;
        } catch (IllegalStateException e2) {
            if (Util.SDK_INT >= 31 && Api31.instanceOfForegroundServiceStartNotAllowedException(e2)) {
                Log.e(TAG, "Failed to start foreground", e2);
                onForegroundServiceStartNotAllowedException();
                return false;
            }
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaNotificationManager getMediaNotificationManager() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.lock) {
            if (this.mediaNotificationManager == null) {
                if (this.mediaNotificationProvider == null) {
                    this.mediaNotificationProvider = new DefaultMediaNotificationProvider.Builder(getApplicationContext()).build();
                }
                this.mediaNotificationManager = new MediaNotificationManager(this, this.mediaNotificationProvider, getActionFactory());
            }
            mediaNotificationManager = this.mediaNotificationManager;
        }
        return mediaNotificationManager;
    }

    private DefaultActionFactory getActionFactory() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.lock) {
            if (this.actionFactory == null) {
                this.actionFactory = new DefaultActionFactory(this);
            }
            defaultActionFactory = this.actionFactory;
        }
        return defaultActionFactory;
    }

    private Listener getListener() {
        Listener listener;
        synchronized (this.lock) {
            listener = this.listener;
        }
        return listener;
    }

    private void onForegroundServiceStartNotAllowedException() {
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9497xf9903c0b();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onForegroundServiceStartNotAllowedException$3$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m9497xf9903c0b() {
        Listener listener = getListener();
        if (listener != null) {
            listener.onForegroundServiceStartNotAllowedException();
        }
    }

    private final class MediaSessionListener implements MediaSession.Listener {
        private MediaSessionListener() {
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public void onNotificationRefreshRequired(MediaSession mediaSession) {
            MediaSessionService.this.onUpdateNotificationInternal(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public boolean onPlayRequested(MediaSession mediaSession) {
            if (Util.SDK_INT < 31 || Util.SDK_INT >= 33 || MediaSessionService.this.getMediaNotificationManager().isStartedInForeground()) {
                return true;
            }
            return MediaSessionService.this.onUpdateNotificationInternal(mediaSession, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class MediaSessionServiceStub extends IMediaSessionService.Stub {
        private final Handler handler;
        private final MediaSessionManager mediaSessionManager;
        private final Set<IMediaController> pendingControllers;
        private final WeakReference<MediaSessionService> serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.serviceReference = new WeakReference<>(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.handler = new Handler(applicationContext.getMainLooper());
            this.mediaSessionManager = MediaSessionManager.getSessionManager(applicationContext);
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        @Override // androidx.media3.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                return;
            }
            try {
                final ConnectionRequest connectionRequestFromBundle = ConnectionRequest.fromBundle(bundle);
                if (this.serviceReference.get() == null) {
                    try {
                        iMediaController.onDisconnected(0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequestFromBundle.pid;
                }
                final MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequestFromBundle.packageName, callingPid, callingUid);
                final boolean zIsTrustedForMediaControl = this.mediaSessionManager.isTrustedForMediaControl(remoteUserInfo);
                this.pendingControllers.add(iMediaController);
                try {
                    this.handler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$MediaSessionServiceStub$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            this.f$0.m9498x7a28fad4(iMediaController, remoteUserInfo, connectionRequestFromBundle, zIsTrustedForMediaControl);
                        }
                    });
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (RuntimeException e2) {
                Log.w(MediaSessionService.TAG, "Ignoring malformed Bundle for ConnectionRequest", e2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        /* JADX INFO: renamed from: lambda$connect$0$androidx-media3-session-MediaSessionService$MediaSessionServiceStub, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        /* synthetic */ void m9498x7a28fad4(androidx.media3.session.IMediaController r12, androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfo r13, androidx.media3.session.ConnectionRequest r14, boolean r15) throws java.lang.Throwable {
            /*
                r11 = this;
                java.util.Set<androidx.media3.session.IMediaController> r0 = r11.pendingControllers
                r0.remove(r12)
                r1 = 0
                r2 = 1
                java.lang.ref.WeakReference<androidx.media3.session.MediaSessionService> r0 = r11.serviceReference     // Catch: java.lang.Throwable -> L54
                java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L54
                androidx.media3.session.MediaSessionService r0 = (androidx.media3.session.MediaSessionService) r0     // Catch: java.lang.Throwable -> L54
                if (r0 != 0) goto L15
                r12.onDisconnected(r1)     // Catch: android.os.RemoteException -> L14
            L14:
                return
            L15:
                androidx.media3.session.MediaSession$ControllerInfo r3 = new androidx.media3.session.MediaSession$ControllerInfo     // Catch: java.lang.Throwable -> L54
                int r5 = r14.libraryVersion     // Catch: java.lang.Throwable -> L54
                int r6 = r14.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L54
                androidx.media3.session.MediaSessionStub$Controller2Cb r8 = new androidx.media3.session.MediaSessionStub$Controller2Cb     // Catch: java.lang.Throwable -> L54
                int r4 = r14.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L54
                r8.<init>(r12, r4)     // Catch: java.lang.Throwable -> L54
                android.os.Bundle r9 = r14.connectionHints     // Catch: java.lang.Throwable -> L54
                int r10 = r14.maxCommandsForMediaItems     // Catch: java.lang.Throwable -> L54
                r4 = r13
                r7 = r15
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L54
                androidx.media3.session.MediaSession r13 = r0.onGetSession(r3)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L54
                if (r13 != 0) goto L35
                r12.onDisconnected(r1)     // Catch: android.os.RemoteException -> L34
            L34:
                return
            L35:
                r0.addSession(r13)     // Catch: java.lang.Exception -> L45 java.lang.Throwable -> L54
                r13.handleControllerConnectionFromService(r12, r3)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L41
                r2 = r1
                goto L4e
            L3d:
                r0 = move-exception
                r13 = r0
                r2 = r1
                goto L56
            L41:
                r0 = move-exception
                r13 = r0
                r2 = r1
                goto L47
            L45:
                r0 = move-exception
                r13 = r0
            L47:
                java.lang.String r14 = "MSessionService"
                java.lang.String r15 = "Failed to add a session to session service"
                androidx.media3.common.util.Log.w(r14, r15, r13)     // Catch: java.lang.Throwable -> L54
            L4e:
                if (r2 == 0) goto L53
                r12.onDisconnected(r1)     // Catch: android.os.RemoteException -> L53
            L53:
                return
            L54:
                r0 = move-exception
                r13 = r0
            L56:
                if (r2 == 0) goto L5b
                r12.onDisconnected(r1)     // Catch: android.os.RemoteException -> L5b
            L5b:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionService.MediaSessionServiceStub.m9498x7a28fad4(androidx.media3.session.IMediaController, androidx.media3.session.legacy.MediaSessionManager$RemoteUserInfo, androidx.media3.session.ConnectionRequest, boolean):void");
        }

        public void release() {
            this.serviceReference.clear();
            this.handler.removeCallbacksAndMessages(null);
            Iterator<IMediaController> it = this.pendingControllers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static boolean instanceOfForegroundServiceStartNotAllowedException(IllegalStateException illegalStateException) {
            return illegalStateException instanceof ForegroundServiceStartNotAllowedException;
        }
    }
}
