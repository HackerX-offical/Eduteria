package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.common.Player;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.PlayerInfo;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
class MediaControllerStub extends IMediaController.Stub {
    private static final String TAG = "MediaControllerStub";
    public static final int VERSION_INT = 7;
    private final WeakReference<MediaControllerImplBase> controller;

    /* JADX INFO: Access modifiers changed from: private */
    interface ControllerTask<T extends MediaControllerImplBase> {
        void run(T t);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase) {
        this.controller = new WeakReference<>(mediaControllerImplBase);
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionResult(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            setControllerFutureResult(i, SessionResult.fromBundle(bundle));
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionResult", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onLibraryResult(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            setControllerFutureResult(i, LibraryResult.fromUnknownBundle(bundle));
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for LibraryResult", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onConnected(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            final ConnectionState connectionStateFromBundle = ConnectionState.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onConnected(connectionStateFromBundle);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Malformed Bundle for ConnectionResult. Disconnected from the session.", e2);
            onDisconnected(i);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onDisconnected(int i) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda13
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaControllerStub.lambda$onDisconnected$1(mediaControllerImplBase);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnected$1(MediaControllerImplBase mediaControllerImplBase) {
        MediaController mediaControllerImplBase2 = mediaControllerImplBase.getInstance();
        MediaController mediaControllerImplBase3 = mediaControllerImplBase.getInstance();
        Objects.requireNonNull(mediaControllerImplBase3);
        mediaControllerImplBase2.runOnApplicationLooper(new MediaControllerImplBase$$ExternalSyntheticLambda43(mediaControllerImplBase3));
    }

    @Override // androidx.media3.session.IMediaController
    public void onSetCustomLayout(final int i, List<Bundle> list) {
        if (list == null) {
            return;
        }
        try {
            final int sessionInterfaceVersion = getSessionInterfaceVersion();
            if (sessionInterfaceVersion == -1) {
                return;
            }
            final ImmutableList immutableListFromBundleList = BundleCollectionUtil.fromBundleList(new Function() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda3
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return CommandButton.fromBundle((Bundle) obj, sessionInterfaceVersion);
                }
            }, list);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda4
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onSetCustomLayout(i, immutableListFromBundleList);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for CommandButton", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onSetMediaButtonPreferences(final int i, List<Bundle> list) {
        if (list == null) {
            return;
        }
        try {
            final int sessionInterfaceVersion = getSessionInterfaceVersion();
            if (sessionInterfaceVersion == -1) {
                return;
            }
            final ImmutableList immutableListFromBundleList = BundleCollectionUtil.fromBundleList(new Function() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return CommandButton.fromBundle((Bundle) obj, sessionInterfaceVersion);
                }
            }, list);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda9
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onSetMediaButtonPreferences(i, immutableListFromBundleList);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for CommandButton", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromSession(int i, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        try {
            final SessionCommands sessionCommandsFromBundle = SessionCommands.fromBundle(bundle);
            try {
                final Player.Commands commandsFromBundle = Player.Commands.fromBundle(bundle2);
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda12
                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onAvailableCommandsChangedFromSession(sessionCommandsFromBundle, commandsFromBundle);
                    }
                });
            } catch (RuntimeException e2) {
                Log.w(TAG, "Ignoring malformed Bundle for Commands", e2);
            }
        } catch (RuntimeException e3) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommands", e3);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            final Player.Commands commandsFromBundle = Player.Commands.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda6
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onAvailableCommandsChangedFromPlayer(commandsFromBundle);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for Commands", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onCustomCommand(final int i, Bundle bundle, final Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            Log.w(TAG, "Ignoring custom command with null args.");
            return;
        }
        try {
            final SessionCommand sessionCommandFromBundle = SessionCommand.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda16
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onCustomCommand(i, sessionCommandFromBundle, bundle2);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommand", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionActivityChanged(final int i, final PendingIntent pendingIntent) throws RemoteException {
        if (pendingIntent == null) {
            Log.w(TAG, "Ignoring null session activity intent");
        } else {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda15
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onSetSessionActivity(i, pendingIntent);
                }
            });
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            final SessionPositionInfo sessionPositionInfoFromBundle = SessionPositionInfo.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda2
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyPeriodicSessionPositionInfoChanged(sessionPositionInfoFromBundle);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionPositionInfo", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    @Deprecated
    public void onPlayerInfoChanged(int i, Bundle bundle, boolean z) {
        onPlayerInfoChangedWithExclusions(i, bundle, new PlayerInfo.BundlingExclusions(z, true).toBundle());
    }

    @Override // androidx.media3.session.IMediaController
    public void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        try {
            int sessionInterfaceVersion = getSessionInterfaceVersion();
            if (sessionInterfaceVersion == -1) {
                return;
            }
            final PlayerInfo playerInfoFromBundle = PlayerInfo.fromBundle(bundle, sessionInterfaceVersion);
            try {
                final PlayerInfo.BundlingExclusions bundlingExclusionsFromBundle = PlayerInfo.BundlingExclusions.fromBundle(bundle2);
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda7
                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onPlayerInfoChanged(playerInfoFromBundle, bundlingExclusionsFromBundle);
                    }
                });
            } catch (RuntimeException e2) {
                Log.w(TAG, "Ignoring malformed Bundle for BundlingExclusions", e2);
            }
        } catch (RuntimeException e3) {
            Log.w(TAG, "Ignoring malformed Bundle for PlayerInfo", e3);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onExtrasChanged(int i, final Bundle bundle) {
        if (bundle == null) {
            Log.w(TAG, "Ignoring null Bundle for extras");
        } else {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda17
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onExtrasChanged(bundle);
                }
            });
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onError(final int i, Bundle bundle) throws RemoteException {
        try {
            final SessionError sessionErrorFromBundle = SessionError.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda10
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onError(i, sessionErrorFromBundle);
                }
            });
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionError", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onRenderedFirstFrame(int i) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda11
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onRenderedFirstFrame();
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onSearchResultChanged(int i, final String str, final int i2, Bundle bundle) throws RuntimeException {
        final MediaLibraryService.LibraryParams libraryParamsFromBundle;
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        if (bundle == null) {
            libraryParamsFromBundle = null;
        } else {
            try {
                libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle);
            } catch (RuntimeException e2) {
                Log.w(TAG, "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda5
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                ((MediaBrowserImplBase) mediaControllerImplBase).notifySearchResultChanged(str, i2, libraryParamsFromBundle);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onChildrenChanged(int i, final String str, final int i2, Bundle bundle) {
        final MediaLibraryService.LibraryParams libraryParamsFromBundle;
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        if (bundle == null) {
            libraryParamsFromBundle = null;
        } else {
            try {
                libraryParamsFromBundle = MediaLibraryService.LibraryParams.fromBundle(bundle);
            } catch (RuntimeException e2) {
                Log.w(TAG, "Ignoring malformed Bundle for LibraryParams", e2);
                return;
            }
        }
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda14
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                ((MediaBrowserImplBase) mediaControllerImplBase).notifyChildrenChanged(str, i2, libraryParamsFromBundle);
            }
        });
    }

    public void destroy() {
        this.controller.clear();
    }

    private <T> void setControllerFutureResult(int i, T t) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.setFutureResult(i, t);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    private <T extends MediaControllerImplBase> void dispatchControllerTaskOnHandler(final ControllerTask<T> controllerTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            Util.postOrRun(mediaControllerImplBase.getInstance().applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    MediaControllerStub.lambda$dispatchControllerTaskOnHandler$16(mediaControllerImplBase, controllerTask);
                }
            });
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    static /* synthetic */ void lambda$dispatchControllerTaskOnHandler$16(MediaControllerImplBase mediaControllerImplBase, ControllerTask controllerTask) {
        if (mediaControllerImplBase.isReleased()) {
            return;
        }
        controllerTask.run(mediaControllerImplBase);
    }

    private int getSessionInterfaceVersion() {
        SessionToken connectedToken;
        MediaControllerImplBase mediaControllerImplBase = this.controller.get();
        if (mediaControllerImplBase == null || (connectedToken = mediaControllerImplBase.getConnectedToken()) == null) {
            return -1;
        }
        return connectedToken.getInterfaceVersion();
    }
}
