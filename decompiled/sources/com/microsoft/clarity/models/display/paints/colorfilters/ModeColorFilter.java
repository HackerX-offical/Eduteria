package com.microsoft.clarity.models.display.paints.colorfilters;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$ColorFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/colorfilters/ModeColorFilter;", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilter;", "color", "", "mode", "(JJ)V", "getColor", "()J", "getMode", "type", "Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilterType;", "getType", "()Lcom/microsoft/clarity/models/display/paints/colorfilters/ColorFilterType;", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$ColorFilter;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ModeColorFilter extends ColorFilter {
    private final long color;
    private final long mode;
    private final ColorFilterType type = ColorFilterType.ModeColorFilter;

    public ModeColorFilter(long j, long j2) {
        this.color = j;
        this.mode = j2;
    }

    public static /* synthetic */ ModeColorFilter copy$default(ModeColorFilter modeColorFilter, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modeColorFilter.color;
        }
        if ((i & 2) != 0) {
            j2 = modeColorFilter.mode;
        }
        return modeColorFilter.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMode() {
        return this.mode;
    }

    public final ModeColorFilter copy(long color, long mode) {
        return new ModeColorFilter(color, mode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModeColorFilter)) {
            return false;
        }
        ModeColorFilter modeColorFilter = (ModeColorFilter) other;
        return this.color == modeColorFilter.color && this.mode == modeColorFilter.mode;
    }

    public final long getColor() {
        return this.color;
    }

    public final long getMode() {
        return this.mode;
    }

    @Override // com.microsoft.clarity.models.display.paints.colorfilters.ColorFilter
    public ColorFilterType getType() {
        return this.type;
    }

    public int hashCode() {
        return Long.hashCode(this.mode) + (Long.hashCode(this.color) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$ColorFilter toProtobufInstance() {
        MutationPayload$ColorFilter mutationPayload$ColorFilterBuild = MutationPayload$ColorFilter.newBuilder().a(getType().name()).a(this.color).b(this.mode).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$ColorFilterBuild, "newBuilder()\n           …e())\n            .build()");
        return mutationPayload$ColorFilterBuild;
    }

    public String toString() {
        return b.a("ModeColorFilter(color=").append(this.color).append(", mode=").append(this.mode).append(')').toString();
    }
}
