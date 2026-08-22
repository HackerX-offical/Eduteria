package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$FloatList;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\u0002\u0010\tJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/microsoft/clarity/models/display/common/RRect;", "Lcom/microsoft/clarity/models/display/common/Rect;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "radii", "", "(FFFFLjava/util/List;)V", "getRadii", "()Ljava/util/List;", "equals", "", "other", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Rect;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RRect extends Rect {
    private final List<List<Float>> radii;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RRect(float f2, float f3, float f4, float f5, List<? extends List<Float>> radii) {
        super(f2, f3, f4, f5);
        Intrinsics.checkNotNullParameter(radii, "radii");
        this.radii = radii;
    }

    @Override // com.microsoft.clarity.models.display.common.Rect
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(RRect.class, other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public final List<List<Float>> getRadii() {
        return this.radii;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.display.common.Rect, com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Rect toProtobufInstance() {
        MutationPayload$Rect.a aVarC = MutationPayload$Rect.newBuilder().a(getBottom()).d(getTop()).b(getLeft()).c(getRight());
        Iterator<List<Float>> it = this.radii.iterator();
        while (it.hasNext()) {
            aVarC.a(MutationPayload$FloatList.newBuilder().a(it.next()).build());
        }
        MutationPayload$Rect mutationPayload$RectBuild = aVarC.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$RectBuild, "builder.build()");
        return mutationPayload$RectBuild;
    }

    @Override // com.microsoft.clarity.models.display.common.Rect
    public String toString() {
        String string = b.a("RRect(").append(getLeft()).append("F, ").append(getTop()).append("F, ").append(getRight()).append("F, ").append(getBottom()).append("F, arrayListOf(").toString();
        Iterator<List<Float>> it = this.radii.iterator();
        while (it.hasNext()) {
            String str = string + "arrayListOf(";
            Iterator<Float> it2 = it.next().iterator();
            while (it2.hasNext()) {
                str = str + it2.next().floatValue() + "F, ";
            }
            string = str + "), ";
        }
        return string + "))";
    }
}
