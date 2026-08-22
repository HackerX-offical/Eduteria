package com.clevertap.android.sdk.inapp;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateInAppData;
import com.clevertap.android.sdk.inapp.customtemplates.TemplatesManager;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl;
import com.clevertap.android.sdk.inapp.store.preference.FileStore;
import com.clevertap.android.sdk.inapp.store.preference.InAppAssetsStore;
import com.clevertap.android.sdk.inapp.store.preference.StoreRegistry;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.video.VideoLibChecker;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppNotificationInflater.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u001e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001e\u0010\"\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\n8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppNotificationInflater;", "", "storeRegistry", "Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;", "templatesManager", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "executors", "Lcom/clevertap/android/sdk/task/CTExecutors;", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "isVideoSupported", "", "<init>", "(Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;Lcom/clevertap/android/sdk/task/CTExecutors;Lkotlin/jvm/functions/Function0;Z)V", "getFileResourceProvider", "()Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "fileResourceProvider$delegate", "Lkotlin/Lazy;", "inflate", "", "inAppJson", "Lorg/json/JSONObject;", "taskLogTag", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/clevertap/android/sdk/inapp/InAppNotificationInflater$InAppNotificationReadyListener;", "prepareForDisplay", Constants.INAPP_KEY, "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "listenerWeakReference", "Ljava/lang/ref/WeakReference;", "processCustomTemplate", "processInAppMedia", "notifyListener", "InAppNotificationReadyListener", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppNotificationInflater {
    private final CTExecutors executors;

    /* JADX INFO: renamed from: fileResourceProvider$delegate, reason: from kotlin metadata */
    private final Lazy fileResourceProvider;
    private final boolean isVideoSupported;
    private final StoreRegistry storeRegistry;
    private final TemplatesManager templatesManager;

    /* JADX INFO: compiled from: InAppNotificationInflater.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/inapp/InAppNotificationInflater$InAppNotificationReadyListener;", "", "onNotificationReady", "", "notification", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface InAppNotificationReadyListener {
        void onNotificationReady(CTInAppNotification notification);
    }

    public InAppNotificationInflater(StoreRegistry storeRegistry, TemplatesManager templatesManager, CTExecutors executors, Function0<FileResourceProvider> fileResourceProvider, boolean z) {
        Intrinsics.checkNotNullParameter(storeRegistry, "storeRegistry");
        Intrinsics.checkNotNullParameter(templatesManager, "templatesManager");
        Intrinsics.checkNotNullParameter(executors, "executors");
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        this.storeRegistry = storeRegistry;
        this.templatesManager = templatesManager;
        this.executors = executors;
        this.isVideoSupported = z;
        this.fileResourceProvider = LazyKt.lazy(fileResourceProvider);
    }

    public /* synthetic */ InAppNotificationInflater(StoreRegistry storeRegistry, TemplatesManager templatesManager, CTExecutors cTExecutors, Function0 function0, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeRegistry, templatesManager, cTExecutors, function0, (i & 16) != 0 ? VideoLibChecker.haveVideoPlayerSupport : z);
    }

    private final FileResourceProvider getFileResourceProvider() {
        return (FileResourceProvider) this.fileResourceProvider.getValue();
    }

    public final void inflate(final JSONObject inAppJson, String taskLogTag, InAppNotificationReadyListener listener) {
        Intrinsics.checkNotNullParameter(inAppJson, "inAppJson");
        Intrinsics.checkNotNullParameter(taskLogTag, "taskLogTag");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final WeakReference weakReference = new WeakReference(listener);
        Task taskPostAsyncSafelyTask = this.executors.postAsyncSafelyTask(Constants.TAG_FEATURE_IN_APPS);
        Intrinsics.checkNotNullExpressionValue(taskPostAsyncSafelyTask, "postAsyncSafelyTask(...)");
        taskPostAsyncSafelyTask.execute(taskLogTag, new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppNotificationInflater$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return InAppNotificationInflater.inflate$lambda$0(inAppJson, this, weakReference);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inflate$lambda$0(JSONObject inAppJson, InAppNotificationInflater this$0, WeakReference listenerWeakReference) {
        Intrinsics.checkNotNullParameter(inAppJson, "$inAppJson");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listenerWeakReference, "$listenerWeakReference");
        CTInAppNotification cTInAppNotification = new CTInAppNotification(inAppJson, this$0.isVideoSupported);
        if (cTInAppNotification.getError() != null) {
            this$0.notifyListener(listenerWeakReference, cTInAppNotification);
            return Unit.INSTANCE;
        }
        this$0.prepareForDisplay(cTInAppNotification, listenerWeakReference);
        return Unit.INSTANCE;
    }

    private final void prepareForDisplay(CTInAppNotification inApp, WeakReference<InAppNotificationReadyListener> listenerWeakReference) {
        if (CTInAppType.CTInAppTypeCustomCodeTemplate == inApp.getInAppType()) {
            processCustomTemplate(inApp);
        } else {
            processInAppMedia(inApp);
        }
        notifyListener(listenerWeakReference, inApp);
    }

    private final void processCustomTemplate(CTInAppNotification inApp) {
        List<String> listEmptyList;
        CustomTemplateInAppData customTemplateData = inApp.getCustomTemplateData();
        if (customTemplateData == null || (listEmptyList = customTemplateData.getFileArgsUrls$clevertap_core_release(this.templatesManager)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Pair<FileStore, InAppAssetsStore> pair = new Pair<>(this.storeRegistry.getFilesStore(), this.storeRegistry.getInAppAssetsStore());
        for (String str : listEmptyList) {
            byte[] bArrFetchFile = getFileResourceProvider().fetchFile(str);
            if (bArrFetchFile != null) {
                if (!(bArrFetchFile.length == 0)) {
                    FileResourcesRepoImpl.INSTANCE.saveUrlExpiryToStore(new Pair<>(str, CtCacheType.FILES), pair);
                }
            }
            inApp.setError$clevertap_core_release("Error processing the custom code in-app template: file download failed.");
            return;
        }
    }

    private final void processInAppMedia(CTInAppNotification inApp) {
        for (CTInAppNotificationMedia cTInAppNotificationMedia : inApp.getMediaList$clevertap_core_release()) {
            if (cTInAppNotificationMedia.isGIF()) {
                byte[] bArrFetchInAppGifV1 = getFileResourceProvider().fetchInAppGifV1(cTInAppNotificationMedia.getMediaUrl());
                if (bArrFetchInAppGifV1 == null || bArrFetchInAppGifV1.length == 0) {
                    inApp.setError$clevertap_core_release("Error processing GIF");
                    return;
                }
            } else if (cTInAppNotificationMedia.isImage()) {
                if (getFileResourceProvider().fetchInAppImageV1(cTInAppNotificationMedia.getMediaUrl()) == null) {
                    inApp.setError$clevertap_core_release("Error processing image as bitmap was NULL");
                    return;
                }
            } else if (cTInAppNotificationMedia.isVideo() || cTInAppNotificationMedia.isAudio()) {
                if (!this.isVideoSupported) {
                    inApp.setError$clevertap_core_release("InApp Video/Audio is not supported");
                    return;
                }
            }
        }
    }

    private final void notifyListener(WeakReference<InAppNotificationReadyListener> listenerWeakReference, final CTInAppNotification inApp) {
        final InAppNotificationReadyListener inAppNotificationReadyListener = listenerWeakReference.get();
        if (inAppNotificationReadyListener != null) {
            this.executors.mainTask().execute("InAppNotificationInflater:onNotificationReady", new Callable() { // from class: com.clevertap.android.sdk.inapp.InAppNotificationInflater$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return InAppNotificationInflater.notifyListener$lambda$1(inAppNotificationReadyListener, inApp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notifyListener$lambda$1(InAppNotificationReadyListener inAppNotificationReadyListener, CTInAppNotification inApp) {
        Intrinsics.checkNotNullParameter(inApp, "$inApp");
        inAppNotificationReadyListener.onNotificationReady(inApp);
        return Unit.INSTANCE;
    }
}
