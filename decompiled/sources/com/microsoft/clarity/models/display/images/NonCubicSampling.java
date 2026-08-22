package com.microsoft.clarity.models.display.images;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Sampling;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/microsoft/clarity/models/display/images/NonCubicSampling;", "Lcom/microsoft/clarity/models/display/images/Sampling;", "filter", "", "mipmap", "(II)V", "getFilter", "()I", "getMipmap", "type", "Lcom/microsoft/clarity/models/display/images/SamplingType;", "getType", "()Lcom/microsoft/clarity/models/display/images/SamplingType;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Sampling;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class NonCubicSampling extends Sampling {
    private final int filter;
    private final int mipmap;
    private final SamplingType type = SamplingType.NonCubic;

    public NonCubicSampling(int i, int i2) {
        this.filter = i;
        this.mipmap = i2;
    }

    public static /* synthetic */ NonCubicSampling copy$default(NonCubicSampling nonCubicSampling, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = nonCubicSampling.filter;
        }
        if ((i3 & 2) != 0) {
            i2 = nonCubicSampling.mipmap;
        }
        return nonCubicSampling.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMipmap() {
        return this.mipmap;
    }

    public final NonCubicSampling copy(int filter, int mipmap) {
        return new NonCubicSampling(filter, mipmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NonCubicSampling)) {
            return false;
        }
        NonCubicSampling nonCubicSampling = (NonCubicSampling) other;
        return this.filter == nonCubicSampling.filter && this.mipmap == nonCubicSampling.mipmap;
    }

    public final int getFilter() {
        return this.filter;
    }

    public final int getMipmap() {
        return this.mipmap;
    }

    @Override // com.microsoft.clarity.models.display.images.Sampling
    public SamplingType getType() {
        return this.type;
    }

    public int hashCode() {
        return Integer.hashCode(this.mipmap) + (Integer.hashCode(this.filter) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Sampling toProtobufInstance() {
        MutationPayload$Sampling mutationPayload$SamplingBuild = MutationPayload$Sampling.newBuilder().a(getType().name()).a(this.filter).b(this.mipmap).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$SamplingBuild, "newBuilder()\n           …map)\n            .build()");
        return mutationPayload$SamplingBuild;
    }

    public String toString() {
        return b.a("NonCubicSampling(filter=").append(this.filter).append(", mipmap=").append(this.mipmap).append(')').toString();
    }
}
