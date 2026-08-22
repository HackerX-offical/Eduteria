package com.clevertap.android.sdk.utils;

import android.app.Activity;
import android.content.Context;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.Logger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayStoreReviewHandler.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u001a\u0010\u0014\u001a\u0016\u0012\f\u0012\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0016\u0012\u0004\u0012\u00020\r0\u0015R!\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/utils/PlayStoreReviewHandler;", "", "<init>", "()V", "reviewManagerFactoryClass", "Ljava/lang/Class;", "getReviewManagerFactoryClass", "()Ljava/lang/Class;", "reviewManagerFactoryClass$delegate", "Lkotlin/Lazy;", "isPlayStoreReviewLibraryAvailable", "", "launchReview", "", "context", "Landroid/content/Context;", "logger", "Lcom/clevertap/android/sdk/Logger;", "onCompleted", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlayStoreReviewHandler {

    /* JADX INFO: renamed from: reviewManagerFactoryClass$delegate, reason: from kotlin metadata */
    private final Lazy reviewManagerFactoryClass = LazyKt.lazy(new Function0() { // from class: com.clevertap.android.sdk.utils.PlayStoreReviewHandler$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PlayStoreReviewHandler.reviewManagerFactoryClass_delegate$lambda$0();
        }
    });

    private final Class<?> getReviewManagerFactoryClass() {
        return (Class) this.reviewManagerFactoryClass.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Class reviewManagerFactoryClass_delegate$lambda$0() {
        try {
            return Class.forName("com.google.android.play.core.review.ReviewManagerFactory");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final boolean isPlayStoreReviewLibraryAvailable() {
        return getReviewManagerFactoryClass() != null;
    }

    public final void launchReview(Context context, final Logger logger, final Function0<Unit> onCompleted, final Function1<? super Exception, Unit> onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!isPlayStoreReviewLibraryAvailable()) {
            logger.debug("Could not launch Play Store Review flow: Play store review library not found.");
            onError.invoke(null);
            return;
        }
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(context);
        Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
        Task taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
        taskRequestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.clevertap.android.sdk.utils.PlayStoreReviewHandler$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                PlayStoreReviewHandler.launchReview$lambda$2(reviewManagerCreate, logger, onError, onCompleted, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchReview$lambda$2(ReviewManager manager, Logger logger, Function1 onError, final Function0 onCompleted, Task task) {
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(logger, "$logger");
        Intrinsics.checkNotNullParameter(onError, "$onError");
        Intrinsics.checkNotNullParameter(onCompleted, "$onCompleted");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
            Activity currentActivity = CoreMetaData.getCurrentActivity();
            if (currentActivity != null) {
                Task taskLaunchReviewFlow = manager.launchReviewFlow(currentActivity, reviewInfo);
                Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(...)");
                taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: com.clevertap.android.sdk.utils.PlayStoreReviewHandler$$ExternalSyntheticLambda2
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task2) {
                        PlayStoreReviewHandler.launchReview$lambda$2$lambda$1(onCompleted, task2);
                    }
                });
                return;
            } else {
                logger.debug("Could not launch Play Store Review flow: current Activity is null.");
                onError.invoke(null);
                return;
            }
        }
        logger.debug("Could not launch Play Store Review flow.", task.getException());
        onError.invoke(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchReview$lambda$2$lambda$1(Function0 onCompleted, Task task) {
        Intrinsics.checkNotNullParameter(onCompleted, "$onCompleted");
        Intrinsics.checkNotNullParameter(task, "task");
        onCompleted.invoke();
    }
}
