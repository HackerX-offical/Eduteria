package com.clevertap.android.sdk.inapp.images.repo;

import android.content.Context;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategyCoroutine;
import com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoFactory;
import com.clevertap.android.sdk.inapp.store.preference.FileStore;
import com.clevertap.android.sdk.inapp.store.preference.InAppAssetsStore;
import com.clevertap.android.sdk.inapp.store.preference.LegacyInAppStore;
import com.clevertap.android.sdk.inapp.store.preference.StoreRegistry;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileResourcesRepoFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepoFactory;", "", "<init>", "()V", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileResourcesRepoFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean USE_COROUTINES = true;

    @JvmStatic
    public static final FileResourcesRepoImpl createFileResourcesRepo(Context context, Logger logger, StoreRegistry storeRegistry) {
        return INSTANCE.createFileResourcesRepo(context, logger, storeRegistry);
    }

    /* JADX INFO: compiled from: FileResourcesRepoFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepoFactory$Companion;", "", "<init>", "()V", "USE_COROUTINES", "", "createFileResourcesRepo", "Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepoImpl;", "context", "Landroid/content/Context;", "logger", "Lcom/clevertap/android/sdk/Logger;", "storeRegistry", "Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        public final FileResourcesRepoImpl createFileResourcesRepo(final Context context, final Logger logger, StoreRegistry storeRegistry) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logger, "logger");
            Intrinsics.checkNotNullParameter(storeRegistry, "storeRegistry");
            InAppAssetsStore inAppAssetsStore = storeRegistry.getInAppAssetsStore();
            FileStore filesStore = storeRegistry.getFilesStore();
            LegacyInAppStore legacyInAppStore = storeRegistry.getLegacyInAppStore();
            Function0 function0 = new Function0() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoFactory$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return FileResourcesRepoFactory.Companion.createFileResourcesRepo$lambda$0(context, logger);
                }
            };
            return new FileResourcesRepoImpl(new FileCleanupStrategyCoroutine(function0, null, 2, 0 == true ? 1 : 0), new FilePreloaderCoroutine(function0, logger, null, null, 0L, false, 60, null), inAppAssetsStore, filesStore, legacyInAppStore);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final FileResourceProvider createFileResourcesRepo$lambda$0(Context context, Logger logger) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(logger, "$logger");
            return FileResourceProvider.INSTANCE.getInstance(context, logger);
        }
    }
}
