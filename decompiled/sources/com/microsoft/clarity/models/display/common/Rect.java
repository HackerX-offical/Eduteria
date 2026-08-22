package com.microsoft.clarity.models.display.common;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u0013\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0000J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Rect;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Rect;", "rect", "(Lcom/microsoft/clarity/models/display/common/Rect;)V", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "(FFFF)V", "getBottom", "()F", "getLeft", "getRight", "getTop", "contains", "", "x", "y", "equals", "other", "", "intersects", "makeSorted", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class Rect implements IProtoModel<MutationPayload$Rect> {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public Rect(float f2, float f3, float f4, float f5) {
        this.left = f2;
        this.top = f3;
        this.right = f4;
        this.bottom = f5;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Rect(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    public final boolean contains(float x, float y) {
        float f2 = this.left;
        if (x > this.right || f2 > x) {
            return false;
        }
        return y <= this.bottom && this.top <= y;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(toString(), other.toString());
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final boolean intersects(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return this.right > rect.left && this.left < rect.right && this.bottom > rect.top && this.top < rect.bottom;
    }

    public final Rect makeSorted() {
        return new Rect(Float.min(this.left, this.right), Float.min(this.top, this.bottom), Float.max(this.left, this.right), Float.max(this.top, this.bottom));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Rect toProtobufInstance() {
        MutationPayload$Rect mutationPayload$RectBuild = MutationPayload$Rect.newBuilder().a(this.bottom).b(this.left).c(this.right).d(this.top).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$RectBuild, "newBuilder()\n           …top)\n            .build()");
        return mutationPayload$RectBuild;
    }

    public String toString() {
        return b.a("Rect(").append(this.left).append("F, ").append(this.top).append("F, ").append(this.right).append("F, ").append(this.bottom).append("F)").toString();
    }
}
