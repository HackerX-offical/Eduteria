package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.CTPreferenceCache;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTPreferenceCache.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/CTPreferenceCache;", "", "<init>", "()V", "isFirstTimeRequest", "", "setFirstTimeRequest", "", "fTR", "updateCacheToDisk", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTPreferenceCache {
    private static volatile CTPreferenceCache INSTANCE;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean firstTimeRequest = true;

    @JvmStatic
    public static final CTPreferenceCache getInstance(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        return INSTANCE.getInstance(context, cleverTapInstanceConfig);
    }

    public final boolean isFirstTimeRequest() {
        return firstTimeRequest;
    }

    public final void setFirstTimeRequest(boolean fTR) {
        firstTimeRequest = fTR;
    }

    public final void updateCacheToDisk(final Context context, CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        CTExecutorFactory.executors(config).ioTask().execute("updateCacheToDisk", new Callable() { // from class: com.clevertap.android.sdk.CTPreferenceCache$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CTPreferenceCache.updateCacheToDisk$lambda$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void updateCacheToDisk$lambda$0(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        StorageHelper.INSTANCE.putBooleanImmediate(context, InAppController.IS_FIRST_TIME_PERMISSION_REQUEST, firstTimeRequest);
        return null;
    }

    /* JADX INFO: compiled from: CTPreferenceCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/CTPreferenceCache$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/clevertap/android/sdk/CTPreferenceCache;", InAppController.IS_FIRST_TIME_PERMISSION_REQUEST, "", "getInstance", "context", "Landroid/content/Context;", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "buildCache", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CTPreferenceCache getInstance(Context context, CleverTapInstanceConfig config) {
            CTPreferenceCache cTPreferenceCacheBuildCache;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            CTPreferenceCache cTPreferenceCache = CTPreferenceCache.INSTANCE;
            if (cTPreferenceCache != null) {
                return cTPreferenceCache;
            }
            synchronized (this) {
                cTPreferenceCacheBuildCache = CTPreferenceCache.INSTANCE;
                if (cTPreferenceCacheBuildCache == null) {
                    cTPreferenceCacheBuildCache = CTPreferenceCache.INSTANCE.buildCache(context, config);
                    Companion companion = CTPreferenceCache.INSTANCE;
                    CTPreferenceCache.INSTANCE = cTPreferenceCacheBuildCache;
                }
            }
            return cTPreferenceCacheBuildCache;
        }

        private final CTPreferenceCache buildCache(final Context context, CleverTapInstanceConfig config) {
            CTExecutorFactory.executors(config).ioTask().execute("buildCache", new Callable() { // from class: com.clevertap.android.sdk.CTPreferenceCache$Companion$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return CTPreferenceCache.Companion.buildCache$lambda$2(context);
                }
            });
            return new CTPreferenceCache();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit buildCache$lambda$2(Context context) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Companion companion = CTPreferenceCache.INSTANCE;
            CTPreferenceCache.firstTimeRequest = StorageHelper.INSTANCE.getBoolean(context, InAppController.IS_FIRST_TIME_PERMISSION_REQUEST, true);
            return Unit.INSTANCE;
        }
    }
}
