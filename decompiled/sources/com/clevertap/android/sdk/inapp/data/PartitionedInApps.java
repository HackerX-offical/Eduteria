package com.clevertap.android.sdk.inapp.data;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: PartitionedInApps.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/clevertap/android/sdk/inapp/data/PartitionedInApps;", "", "immediateInApps", "Lorg/json/JSONArray;", "delayedInApps", "<init>", "(Lorg/json/JSONArray;Lorg/json/JSONArray;)V", "getImmediateInApps", "()Lorg/json/JSONArray;", "getDelayedInApps", "hasImmediateInApps", "", "getHasImmediateInApps", "()Z", "hasDelayedInApps", "getHasDelayedInApps", "component1", "component2", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PartitionedInApps {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JSONArray delayedInApps;
    private final JSONArray immediateInApps;

    public static /* synthetic */ PartitionedInApps copy$default(PartitionedInApps partitionedInApps, JSONArray jSONArray, JSONArray jSONArray2, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONArray = partitionedInApps.immediateInApps;
        }
        if ((i & 2) != 0) {
            jSONArray2 = partitionedInApps.delayedInApps;
        }
        return partitionedInApps.copy(jSONArray, jSONArray2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JSONArray getImmediateInApps() {
        return this.immediateInApps;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final JSONArray getDelayedInApps() {
        return this.delayedInApps;
    }

    public final PartitionedInApps copy(JSONArray immediateInApps, JSONArray delayedInApps) {
        Intrinsics.checkNotNullParameter(immediateInApps, "immediateInApps");
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        return new PartitionedInApps(immediateInApps, delayedInApps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartitionedInApps)) {
            return false;
        }
        PartitionedInApps partitionedInApps = (PartitionedInApps) other;
        return Intrinsics.areEqual(this.immediateInApps, partitionedInApps.immediateInApps) && Intrinsics.areEqual(this.delayedInApps, partitionedInApps.delayedInApps);
    }

    public int hashCode() {
        return (this.immediateInApps.hashCode() * 31) + this.delayedInApps.hashCode();
    }

    public String toString() {
        return "PartitionedInApps(immediateInApps=" + this.immediateInApps + ", delayedInApps=" + this.delayedInApps + ')';
    }

    public PartitionedInApps(JSONArray immediateInApps, JSONArray delayedInApps) {
        Intrinsics.checkNotNullParameter(immediateInApps, "immediateInApps");
        Intrinsics.checkNotNullParameter(delayedInApps, "delayedInApps");
        this.immediateInApps = immediateInApps;
        this.delayedInApps = delayedInApps;
    }

    public final JSONArray getImmediateInApps() {
        return this.immediateInApps;
    }

    public final JSONArray getDelayedInApps() {
        return this.delayedInApps;
    }

    public final boolean getHasImmediateInApps() {
        return this.immediateInApps.length() > 0;
    }

    public final boolean getHasDelayedInApps() {
        return this.delayedInApps.length() > 0;
    }

    /* JADX INFO: compiled from: PartitionedInApps.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/inapp/data/PartitionedInApps$Companion;", "", "<init>", "()V", "empty", "Lcom/clevertap/android/sdk/inapp/data/PartitionedInApps;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PartitionedInApps empty() {
            return new PartitionedInApps(new JSONArray(), new JSONArray());
        }
    }
}
