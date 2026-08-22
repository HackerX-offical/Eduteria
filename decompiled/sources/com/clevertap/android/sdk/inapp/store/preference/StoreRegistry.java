package com.clevertap.android.sdk.inapp.store.preference;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StoreRegistry.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J?\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;", "", "inAppStore", "Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;", "impressionStore", "Lcom/clevertap/android/sdk/inapp/store/preference/ImpressionStore;", "legacyInAppStore", "Lcom/clevertap/android/sdk/inapp/store/preference/LegacyInAppStore;", "inAppAssetsStore", "Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;", "filesStore", "Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;", "<init>", "(Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;Lcom/clevertap/android/sdk/inapp/store/preference/ImpressionStore;Lcom/clevertap/android/sdk/inapp/store/preference/LegacyInAppStore;Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;)V", "getInAppStore", "()Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;", "setInAppStore", "(Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;)V", "getImpressionStore", "()Lcom/clevertap/android/sdk/inapp/store/preference/ImpressionStore;", "setImpressionStore", "(Lcom/clevertap/android/sdk/inapp/store/preference/ImpressionStore;)V", "getLegacyInAppStore", "()Lcom/clevertap/android/sdk/inapp/store/preference/LegacyInAppStore;", "getInAppAssetsStore", "()Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;", "getFilesStore", "()Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class StoreRegistry {
    private final FileStore filesStore;
    private ImpressionStore impressionStore;
    private final InAppAssetsStore inAppAssetsStore;
    private InAppStore inAppStore;
    private final LegacyInAppStore legacyInAppStore;

    public static /* synthetic */ StoreRegistry copy$default(StoreRegistry storeRegistry, InAppStore inAppStore, ImpressionStore impressionStore, LegacyInAppStore legacyInAppStore, InAppAssetsStore inAppAssetsStore, FileStore fileStore, int i, Object obj) {
        if ((i & 1) != 0) {
            inAppStore = storeRegistry.inAppStore;
        }
        if ((i & 2) != 0) {
            impressionStore = storeRegistry.impressionStore;
        }
        if ((i & 4) != 0) {
            legacyInAppStore = storeRegistry.legacyInAppStore;
        }
        if ((i & 8) != 0) {
            inAppAssetsStore = storeRegistry.inAppAssetsStore;
        }
        if ((i & 16) != 0) {
            fileStore = storeRegistry.filesStore;
        }
        FileStore fileStore2 = fileStore;
        LegacyInAppStore legacyInAppStore2 = legacyInAppStore;
        return storeRegistry.copy(inAppStore, impressionStore, legacyInAppStore2, inAppAssetsStore, fileStore2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InAppStore getInAppStore() {
        return this.inAppStore;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ImpressionStore getImpressionStore() {
        return this.impressionStore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LegacyInAppStore getLegacyInAppStore() {
        return this.legacyInAppStore;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final InAppAssetsStore getInAppAssetsStore() {
        return this.inAppAssetsStore;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final FileStore getFilesStore() {
        return this.filesStore;
    }

    public final StoreRegistry copy(InAppStore inAppStore, ImpressionStore impressionStore, LegacyInAppStore legacyInAppStore, InAppAssetsStore inAppAssetsStore, FileStore filesStore) {
        Intrinsics.checkNotNullParameter(legacyInAppStore, "legacyInAppStore");
        Intrinsics.checkNotNullParameter(inAppAssetsStore, "inAppAssetsStore");
        Intrinsics.checkNotNullParameter(filesStore, "filesStore");
        return new StoreRegistry(inAppStore, impressionStore, legacyInAppStore, inAppAssetsStore, filesStore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreRegistry)) {
            return false;
        }
        StoreRegistry storeRegistry = (StoreRegistry) other;
        return Intrinsics.areEqual(this.inAppStore, storeRegistry.inAppStore) && Intrinsics.areEqual(this.impressionStore, storeRegistry.impressionStore) && Intrinsics.areEqual(this.legacyInAppStore, storeRegistry.legacyInAppStore) && Intrinsics.areEqual(this.inAppAssetsStore, storeRegistry.inAppAssetsStore) && Intrinsics.areEqual(this.filesStore, storeRegistry.filesStore);
    }

    public int hashCode() {
        InAppStore inAppStore = this.inAppStore;
        int iHashCode = (inAppStore == null ? 0 : inAppStore.hashCode()) * 31;
        ImpressionStore impressionStore = this.impressionStore;
        return ((((((iHashCode + (impressionStore != null ? impressionStore.hashCode() : 0)) * 31) + this.legacyInAppStore.hashCode()) * 31) + this.inAppAssetsStore.hashCode()) * 31) + this.filesStore.hashCode();
    }

    public String toString() {
        return "StoreRegistry(inAppStore=" + this.inAppStore + ", impressionStore=" + this.impressionStore + ", legacyInAppStore=" + this.legacyInAppStore + ", inAppAssetsStore=" + this.inAppAssetsStore + ", filesStore=" + this.filesStore + ')';
    }

    public StoreRegistry(InAppStore inAppStore, ImpressionStore impressionStore, LegacyInAppStore legacyInAppStore, InAppAssetsStore inAppAssetsStore, FileStore filesStore) {
        Intrinsics.checkNotNullParameter(legacyInAppStore, "legacyInAppStore");
        Intrinsics.checkNotNullParameter(inAppAssetsStore, "inAppAssetsStore");
        Intrinsics.checkNotNullParameter(filesStore, "filesStore");
        this.inAppStore = inAppStore;
        this.impressionStore = impressionStore;
        this.legacyInAppStore = legacyInAppStore;
        this.inAppAssetsStore = inAppAssetsStore;
        this.filesStore = filesStore;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StoreRegistry(InAppStore inAppStore, ImpressionStore impressionStore, LegacyInAppStore legacyInAppStore, InAppAssetsStore inAppAssetsStore, FileStore fileStore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        FileStore fileStore2;
        InAppAssetsStore inAppAssetsStore2;
        LegacyInAppStore legacyInAppStore2;
        ImpressionStore impressionStore2;
        inAppStore = (i & 1) != 0 ? null : inAppStore;
        if ((i & 2) != 0) {
            fileStore2 = fileStore;
            inAppAssetsStore2 = inAppAssetsStore;
            legacyInAppStore2 = legacyInAppStore;
            impressionStore2 = null;
        } else {
            fileStore2 = fileStore;
            inAppAssetsStore2 = inAppAssetsStore;
            legacyInAppStore2 = legacyInAppStore;
            impressionStore2 = impressionStore;
        }
        this(inAppStore, impressionStore2, legacyInAppStore2, inAppAssetsStore2, fileStore2);
    }

    public final InAppStore getInAppStore() {
        return this.inAppStore;
    }

    public final void setInAppStore(InAppStore inAppStore) {
        this.inAppStore = inAppStore;
    }

    public final ImpressionStore getImpressionStore() {
        return this.impressionStore;
    }

    public final void setImpressionStore(ImpressionStore impressionStore) {
        this.impressionStore = impressionStore;
    }

    public final LegacyInAppStore getLegacyInAppStore() {
        return this.legacyInAppStore;
    }

    public final InAppAssetsStore getInAppAssetsStore() {
        return this.inAppAssetsStore;
    }

    public final FileStore getFilesStore() {
        return this.filesStore;
    }
}
