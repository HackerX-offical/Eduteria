package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaBrowserCompat;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    private static final String TAG = "MLSLegacyStub";
    private final MediaSession.ControllerCb browserLegacyCbForBroadcast;
    private final MediaLibrarySessionImpl librarySessionImpl;

    private static <T> void ignoreFuture(Future<T> future) {
    }

    public MediaLibraryServiceLegacyStub(MediaLibrarySessionImpl mediaLibrarySessionImpl) {
        super(mediaLibrarySessionImpl);
        this.librarySessionImpl = mediaLibrarySessionImpl;
        this.browserLegacyCbForBroadcast = new BrowserLegacyCbForBroadcast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media3.session.legacy.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        final MediaSession.ControllerInfo currentController;
        LibraryResult libraryResult;
        Bundle bundle2;
        if (super.onGetRoot(str, i, bundle) == null || (currentController = getCurrentController()) == null || !getConnectedControllersManager().isSessionCommandAvailable(currentController, 50000)) {
            return null;
        }
        final MediaLibraryService.LibraryParams libraryParamsConvertToLibraryParams = LegacyConversions.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle);
        final AtomicReference atomicReference = new AtomicReference();
        final ConditionVariable conditionVariable = new ConditionVariable();
        Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9427xa7534c8(atomicReference, currentController, libraryParamsConvertToLibraryParams, conditionVariable);
            }
        });
        try {
            conditionVariable.block();
            libraryResult = (LibraryResult) Assertions.checkNotNull((LibraryResult) ((ListenableFuture) atomicReference.get()).get(), "LibraryResult must not be null");
        } catch (InterruptedException | CancellationException | ExecutionException e2) {
            Log.e(TAG, "Couldn't get a result from onGetLibraryRoot", e2);
            libraryResult = null;
        }
        if (libraryResult != null && libraryResult.resultCode == 0 && libraryResult.value != 0) {
            if (libraryResult.params != null) {
                bundle2 = LegacyConversions.convertToRootHints(libraryResult.params);
            } else {
                bundle2 = new Bundle();
            }
            ((Bundle) Assertions.checkNotNull(bundle2)).putBoolean("android.media.browse.SEARCH_SUPPORTED", getConnectedControllersManager().isSessionCommandAvailable(currentController, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH));
            ImmutableList<CommandButton> commandButtonsForMediaItems = this.librarySessionImpl.getCommandButtonsForMediaItems();
            if (!commandButtonsForMediaItems.isEmpty()) {
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < commandButtonsForMediaItems.size(); i2++) {
                    CommandButton commandButton = commandButtonsForMediaItems.get(i2);
                    if (commandButton.sessionCommand != null && commandButton.sessionCommand.commandCode == 0) {
                        arrayList.add(LegacyConversions.convertToBundle(commandButton));
                    }
                }
                if (!arrayList.isEmpty()) {
                    bundle2.putParcelableArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ROOT_LIST", arrayList);
                }
            }
            return new MediaBrowserServiceCompat.BrowserRoot(((MediaItem) libraryResult.value).mediaId, bundle2);
        }
        if (libraryResult == null || libraryResult.resultCode == 0) {
            return MediaUtils.defaultBrowserRoot;
        }
        return null;
    }

    /* JADX INFO: renamed from: lambda$onGetRoot$0$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9427xa7534c8(AtomicReference atomicReference, MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams, ConditionVariable conditionVariable) {
        atomicReference.set(this.librarySessionImpl.onGetLibraryRootOnHandler(controllerInfo, libraryParams));
        conditionVariable.open();
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onSubscribe(final String str, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSubscribe(): Ignoring empty id from " + currentController);
        } else {
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9431x33fceefb(currentController, bundle, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onSubscribe$1$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9431x33fceefb(MediaSession.ControllerInfo controllerInfo, Bundle bundle, String str) {
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
            ignoreFuture(this.librarySessionImpl.onSubscribeOnHandler(controllerInfo, str, LegacyConversions.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle)));
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onUnsubscribe(final String str) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onUnsubscribe(): Ignoring empty id from " + currentController);
        } else {
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9432xd6387fc3(currentController, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onUnsubscribe$2$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9432xd6387fc3(MediaSession.ControllerInfo controllerInfo, String str) {
        if (getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
            ignoreFuture(this.librarySessionImpl.onUnsubscribeOnHandler(controllerInfo, str));
        }
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub, androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        onLoadChildren(str, result, null);
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onLoadChildren(final String str, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, final Bundle bundle) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendResult(null);
        } else if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onLoadChildren(): Ignoring empty parentId from " + currentController);
            result.sendResult(null);
        } else {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9428x4e3aab0(currentController, result, bundle, str);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX INFO: renamed from: lambda$onLoadChildren$3$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    /* synthetic */ void m9428x4e3aab0(androidx.media3.session.MediaSession.ControllerInfo r8, androidx.media3.session.legacy.MediaBrowserServiceCompat.Result r9, android.os.Bundle r10, java.lang.String r11) {
        /*
            r7 = this;
            androidx.media3.session.ConnectedControllersManager r0 = r7.getConnectedControllersManager()
            r1 = 50003(0xc353, float:7.0069E-41)
            boolean r0 = r0.isSessionCommandAvailable(r8, r1)
            if (r0 != 0) goto L12
            r8 = 0
            r9.sendResult(r8)
            return
        L12:
            if (r10 == 0) goto L54
            androidx.media3.session.MediaLibrarySessionImpl r0 = r7.librarySessionImpl
            android.content.Context r0 = r0.getContext()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            r10.setClassLoader(r0)
            java.lang.String r0 = "android.media.browse.extra.PAGE"
            int r4 = r10.getInt(r0)     // Catch: android.os.BadParcelableException -> L54
            java.lang.String r0 = "android.media.browse.extra.PAGE_SIZE"
            int r5 = r10.getInt(r0)     // Catch: android.os.BadParcelableException -> L54
            if (r4 < 0) goto L54
            if (r5 <= 0) goto L54
            androidx.media3.session.MediaLibrarySessionImpl r0 = r7.librarySessionImpl     // Catch: android.os.BadParcelableException -> L54
            android.content.Context r0 = r0.getContext()     // Catch: android.os.BadParcelableException -> L54
            androidx.media3.session.MediaLibraryService$LibraryParams r6 = androidx.media3.session.LegacyConversions.convertToLibraryParams(r0, r10)     // Catch: android.os.BadParcelableException -> L54
            androidx.media3.session.MediaLibrarySessionImpl r1 = r7.librarySessionImpl     // Catch: android.os.BadParcelableException -> L54
            r2 = r8
            r3 = r11
            com.google.common.util.concurrent.ListenableFuture r8 = r1.onGetChildrenOnHandler(r2, r3, r4, r5, r6)     // Catch: android.os.BadParcelableException -> L51
            r1 = r2
            r2 = r3
            com.google.common.util.concurrent.AsyncFunction r10 = r7.createMediaItemsToBrowserItemsAsyncFunction()     // Catch: android.os.BadParcelableException -> L56
            com.google.common.util.concurrent.ListenableFuture r8 = androidx.media3.common.util.Util.transformFutureAsync(r8, r10)     // Catch: android.os.BadParcelableException -> L56
            sendLibraryResultWithMediaItemsWhenReady(r9, r8)     // Catch: android.os.BadParcelableException -> L56
            return
        L51:
            r1 = r2
            r2 = r3
            goto L56
        L54:
            r1 = r8
            r2 = r11
        L56:
            androidx.media3.session.MediaLibrarySessionImpl r0 = r7.librarySessionImpl
            r4 = 2147483647(0x7fffffff, float:NaN)
            r5 = 0
            r3 = 0
            com.google.common.util.concurrent.ListenableFuture r8 = r0.onGetChildrenOnHandler(r1, r2, r3, r4, r5)
            com.google.common.util.concurrent.AsyncFunction r10 = r7.createMediaItemsToBrowserItemsAsyncFunction()
            com.google.common.util.concurrent.ListenableFuture r8 = androidx.media3.common.util.Util.transformFutureAsync(r8, r10)
            sendLibraryResultWithMediaItemsWhenReady(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaLibraryServiceLegacyStub.m9428x4e3aab0(androidx.media3.session.MediaSession$ControllerInfo, androidx.media3.session.legacy.MediaBrowserServiceCompat$Result, android.os.Bundle, java.lang.String):void");
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onLoadItem(final String str, final MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendResult(null);
        } else if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "Ignoring empty itemId from " + currentController);
            result.sendResult(null);
        } else {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9429xa4bca205(currentController, result, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onLoadItem$4$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9429xa4bca205(MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, String str) {
        if (!getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
            result.sendResult(null);
        } else {
            sendLibraryResultWithMediaItemWhenReady(result, Util.transformFutureAsync(this.librarySessionImpl.onGetItemOnHandler(controllerInfo, str), createMediaItemToBrowserItemAsyncFunction()));
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onSearch(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendResult(null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "Ignoring empty query from " + currentController);
            result.sendResult(null);
        } else if (currentController.getControllerCb() instanceof BrowserLegacyCb) {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9430xa75a61d5(currentController, result, str, bundle);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onSearch$5$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9430xa75a61d5(MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, String str, Bundle bundle) {
        if (!getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
            result.sendResult(null);
            return;
        }
        ((BrowserLegacyCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).registerSearchRequest(controllerInfo, str, bundle, result);
        ignoreFuture(this.librarySessionImpl.onSearchOnHandler(controllerInfo, str, LegacyConversions.convertToLibraryParams(this.librarySessionImpl.getContext(), bundle)));
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void onCustomAction(final String str, final Bundle bundle, final MediaBrowserServiceCompat.Result<Bundle> result) {
        final MediaSession.ControllerInfo currentController = getCurrentController();
        if (currentController == null) {
            result.sendError(null);
        } else {
            result.detach();
            Util.postOrRun(this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9426x888c5875(str, currentController, result, bundle);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onCustomAction$6$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9426x888c5875(String str, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle) {
        SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        if (!getConnectedControllersManager().isSessionCommandAvailable(controllerInfo, sessionCommand)) {
            result.sendError(null);
        } else {
            sendCustomActionResultWhenReady(result, this.librarySessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle));
        }
    }

    @Override // androidx.media3.session.MediaSessionServiceLegacyStub
    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, Bundle bundle) {
        return new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, getMediaSessionManager().isTrustedForMediaControl(remoteUserInfo), new BrowserLegacyCb(remoteUserInfo), bundle, LegacyConversions.extractMaxCommandsForMediaItemFromRootHints(bundle));
    }

    public MediaSession.ControllerCb getBrowserLegacyCbForBroadcast() {
        return this.browserLegacyCbForBroadcast;
    }

    private MediaSession.ControllerInfo getCurrentController() {
        return getConnectedControllersManager().getController(getCurrentBrowserInfo());
    }

    private static void sendCustomActionResultWhenReady(final MediaBrowserServiceCompat.Result<Bundle> result, final ListenableFuture<SessionResult> listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendCustomActionResultWhenReady$7(listenableFuture, result);
            }
        }, MoreExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$sendCustomActionResultWhenReady$7(ListenableFuture listenableFuture, MediaBrowserServiceCompat.Result result) {
        try {
            result.sendResult(((SessionResult) Assertions.checkNotNull((SessionResult) listenableFuture.get(), "SessionResult must not be null")).extras);
        } catch (InterruptedException | CancellationException | ExecutionException e2) {
            Log.w(TAG, "Custom action failed", e2);
            result.sendError(null);
        }
    }

    private static void sendLibraryResultWithMediaItemWhenReady(final MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result, final ListenableFuture<MediaBrowserCompat.MediaItem> listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendLibraryResultWithMediaItemWhenReady$8(listenableFuture, result);
            }
        }, MoreExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$sendLibraryResultWithMediaItemWhenReady$8(ListenableFuture listenableFuture, MediaBrowserServiceCompat.Result result) {
        try {
            result.sendResult((MediaBrowserCompat.MediaItem) listenableFuture.get());
        } catch (InterruptedException | CancellationException | ExecutionException e2) {
            Log.w(TAG, "Library operation failed", e2);
            result.sendResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendLibraryResultWithMediaItemsWhenReady(final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, final ListenableFuture<List<MediaBrowserCompat.MediaItem>> listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$sendLibraryResultWithMediaItemsWhenReady$9(listenableFuture, result);
            }
        }, MoreExecutors.directExecutor());
    }

    static /* synthetic */ void lambda$sendLibraryResultWithMediaItemsWhenReady$9(ListenableFuture listenableFuture, MediaBrowserServiceCompat.Result result) {
        try {
            List list = (List) listenableFuture.get();
            result.sendResult(list == null ? null : MediaUtils.truncateListBySize(list, 262144));
        } catch (InterruptedException | CancellationException | ExecutionException e2) {
            Log.w(TAG, "Library operation failed", e2);
            result.sendResult(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AsyncFunction<LibraryResult<ImmutableList<MediaItem>>, List<MediaBrowserCompat.MediaItem>> createMediaItemsToBrowserItemsAsyncFunction() {
        return new AsyncFunction() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda12
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.m9425xa49f4399((LibraryResult) obj);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$createMediaItemsToBrowserItemsAsyncFunction$12$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ ListenableFuture m9425xa49f4399(LibraryResult libraryResult) throws Exception {
        Assertions.checkNotNull(libraryResult, "LibraryResult must not be null");
        final SettableFuture settableFutureCreate = SettableFuture.create();
        if (libraryResult.resultCode != 0 || libraryResult.value == 0) {
            settableFutureCreate.set(null);
            return settableFutureCreate;
        }
        final ImmutableList immutableList = (ImmutableList) libraryResult.value;
        if (immutableList.isEmpty()) {
            settableFutureCreate.set(new ArrayList());
            return settableFutureCreate;
        }
        final ArrayList arrayList = new ArrayList();
        settableFutureCreate.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemsToBrowserItemsAsyncFunction$10(settableFutureCreate, arrayList);
            }
        }, MoreExecutors.directExecutor());
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable runnable = new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9424x7b4aee58(atomicInteger, immutableList, arrayList, settableFutureCreate);
            }
        };
        for (int i = 0; i < immutableList.size(); i++) {
            MediaMetadata mediaMetadata = ((MediaItem) immutableList.get(i)).mediaMetadata;
            if (mediaMetadata.artworkData == null) {
                arrayList.add(null);
                runnable.run();
            } else {
                ListenableFuture<Bitmap> listenableFutureDecodeBitmap = this.librarySessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
                arrayList.add(listenableFutureDecodeBitmap);
                listenableFutureDecodeBitmap.addListener(runnable, MoreExecutors.directExecutor());
            }
        }
        return settableFutureCreate;
    }

    static /* synthetic */ void lambda$createMediaItemsToBrowserItemsAsyncFunction$10(SettableFuture settableFuture, List list) {
        if (settableFuture.isCancelled()) {
            cancelAllFutures(list);
        }
    }

    /* JADX INFO: renamed from: lambda$createMediaItemsToBrowserItemsAsyncFunction$11$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ void m9424x7b4aee58(AtomicInteger atomicInteger, ImmutableList immutableList, List list, SettableFuture settableFuture) {
        if (atomicInteger.incrementAndGet() == immutableList.size()) {
            handleBitmapFuturesAllCompletedAndSetOutputFuture(list, immutableList, settableFuture);
        }
    }

    private void handleBitmapFuturesAllCompletedAndSetOutputFuture(List<ListenableFuture<Bitmap>> list, List<MediaItem> list2, SettableFuture<List<MediaBrowserCompat.MediaItem>> settableFuture) {
        Bitmap bitmap;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ListenableFuture<Bitmap> listenableFuture = list.get(i);
            if (listenableFuture != null) {
                try {
                    bitmap = (Bitmap) Futures.getDone(listenableFuture);
                } catch (CancellationException | ExecutionException e2) {
                    Log.d(TAG, "Failed to get bitmap", e2);
                    bitmap = null;
                }
            } else {
                bitmap = null;
            }
            arrayList.add(LegacyConversions.convertToBrowserItem(list2.get(i), bitmap));
        }
        settableFuture.set(arrayList);
    }

    private static <T> void cancelAllFutures(List<ListenableFuture<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                list.get(i).cancel(false);
            }
        }
    }

    private AsyncFunction<LibraryResult<MediaItem>, MediaBrowserCompat.MediaItem> createMediaItemToBrowserItemAsyncFunction() {
        return new AsyncFunction() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda3
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.m9423xc5987e36((LibraryResult) obj);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$createMediaItemToBrowserItemAsyncFunction$15$androidx-media3-session-MediaLibraryServiceLegacyStub, reason: not valid java name */
    /* synthetic */ ListenableFuture m9423xc5987e36(LibraryResult libraryResult) throws Exception {
        Assertions.checkNotNull(libraryResult, "LibraryResult must not be null");
        final SettableFuture settableFutureCreate = SettableFuture.create();
        if (libraryResult.resultCode != 0 || libraryResult.value == 0) {
            settableFutureCreate.set(null);
            return settableFutureCreate;
        }
        final MediaItem mediaItem = (MediaItem) libraryResult.value;
        MediaMetadata mediaMetadata = mediaItem.mediaMetadata;
        if (mediaMetadata.artworkData == null) {
            settableFutureCreate.set(LegacyConversions.convertToBrowserItem(mediaItem, null));
            return settableFutureCreate;
        }
        final ListenableFuture<Bitmap> listenableFutureDecodeBitmap = this.librarySessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
        settableFutureCreate.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemToBrowserItemAsyncFunction$13(settableFutureCreate, listenableFutureDecodeBitmap);
            }
        }, MoreExecutors.directExecutor());
        listenableFutureDecodeBitmap.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MediaLibraryServiceLegacyStub.lambda$createMediaItemToBrowserItemAsyncFunction$14(listenableFutureDecodeBitmap, settableFutureCreate, mediaItem);
            }
        }, MoreExecutors.directExecutor());
        return settableFutureCreate;
    }

    static /* synthetic */ void lambda$createMediaItemToBrowserItemAsyncFunction$13(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        if (settableFuture.isCancelled()) {
            listenableFuture.cancel(false);
        }
    }

    static /* synthetic */ void lambda$createMediaItemToBrowserItemAsyncFunction$14(ListenableFuture listenableFuture, SettableFuture settableFuture, MediaItem mediaItem) {
        Bitmap bitmap;
        try {
            bitmap = (Bitmap) Futures.getDone(listenableFuture);
        } catch (CancellationException | ExecutionException e2) {
            Log.d(TAG, "failed to get bitmap", e2);
            bitmap = null;
        }
        settableFuture.set(LegacyConversions.convertToBrowserItem(mediaItem, bitmap));
    }

    private static class SearchRequest {
        public final MediaSession.ControllerInfo controller;
        public final Bundle extras;
        public final String query;
        public final MediaSessionManager.RemoteUserInfo remoteUserInfo;
        public final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result;

        public SearchRequest(MediaSession.ControllerInfo controllerInfo, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            this.controller = controllerInfo;
            this.remoteUserInfo = remoteUserInfo;
            this.query = str;
            this.extras = bundle;
            this.result = result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class BrowserLegacyCb implements MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;
        private final Object lock = new Object();
        private final List<SearchRequest> searchRequests = new ArrayList();

        public BrowserLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.remoteUserInfo = remoteUserInfo;
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Bundle bundle = libraryParams != null ? libraryParams.extras : null;
            MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = MediaLibraryServiceLegacyStub.this;
            MediaSessionManager.RemoteUserInfo remoteUserInfo = this.remoteUserInfo;
            if (bundle == null) {
                bundle = Bundle.EMPTY;
            }
            mediaLibraryServiceLegacyStub.notifyChildrenChanged(remoteUserInfo, str, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            final ArrayList arrayList = new ArrayList();
            synchronized (this.lock) {
                for (int size = this.searchRequests.size() - 1; size >= 0; size--) {
                    SearchRequest searchRequest = this.searchRequests.get(size);
                    if (Util.areEqual(this.remoteUserInfo, searchRequest.remoteUserInfo) && searchRequest.query.equals(str)) {
                        arrayList.add(searchRequest);
                        this.searchRequests.remove(size);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
                Util.postOrRun(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaLibraryServiceLegacyStub$BrowserLegacyCb$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9433xc133ba0b(arrayList);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$onSearchResultChanged$0$androidx-media3-session-MediaLibraryServiceLegacyStub$BrowserLegacyCb, reason: not valid java name */
        /* synthetic */ void m9433xc133ba0b(List list) {
            int i;
            int i2;
            int i3;
            int i4;
            for (int i5 = 0; i5 < list.size(); i5++) {
                SearchRequest searchRequest = (SearchRequest) list.get(i5);
                if (searchRequest.extras != null) {
                    try {
                        searchRequest.extras.setClassLoader(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getContext().getClassLoader());
                        i = searchRequest.extras.getInt("android.media.browse.extra.PAGE", -1);
                        i2 = searchRequest.extras.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                    } catch (BadParcelableException unused) {
                        searchRequest.result.sendResult(null);
                        return;
                    }
                } else {
                    i = 0;
                    i2 = Integer.MAX_VALUE;
                }
                if (i < 0 || i2 < 1) {
                    i3 = 0;
                    i4 = Integer.MAX_VALUE;
                } else {
                    i3 = i;
                    i4 = i2;
                }
                MediaLibraryServiceLegacyStub.sendLibraryResultWithMediaItemsWhenReady(searchRequest.result, Util.transformFutureAsync(MediaLibraryServiceLegacyStub.this.librarySessionImpl.onGetSearchResultOnHandler(searchRequest.controller, searchRequest.query, i3, i4, LegacyConversions.convertToLibraryParams(MediaLibraryServiceLegacyStub.this.librarySessionImpl.getContext(), searchRequest.extras)), MediaLibraryServiceLegacyStub.this.createMediaItemsToBrowserItemsAsyncFunction()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void registerSearchRequest(MediaSession.ControllerInfo controllerInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            synchronized (this.lock) {
                this.searchRequests.add(new SearchRequest(controllerInfo, controllerInfo.getRemoteUserInfo(), str, bundle, result));
            }
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BrowserLegacyCb) {
                return Util.areEqual(this.remoteUserInfo, ((BrowserLegacyCb) obj).remoteUserInfo);
            }
            return false;
        }
    }

    private final class BrowserLegacyCbForBroadcast implements MediaSession.ControllerCb {
        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        private BrowserLegacyCbForBroadcast() {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            if (libraryParams == null || libraryParams.extras == null) {
                MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(str);
            } else {
                MediaLibraryServiceLegacyStub.this.notifyChildrenChanged(str, (Bundle) Util.castNonNull(libraryParams.extras));
            }
        }
    }
}
