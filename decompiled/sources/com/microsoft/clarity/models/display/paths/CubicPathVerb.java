package com.microsoft.clarity.models.display.paths;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000b¨\u0006&"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/CubicPathVerb;", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "cpx1", "", "cpy1", "cpx2", "cpy2", "x", "y", "(FFFFFF)V", "getCpx1", "()F", "getCpx2", "getCpy1", "getCpy2", "type", "Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getType", "()Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "component6", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathVerb;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class CubicPathVerb extends PathVerb {
    private final float cpx1;
    private final float cpx2;
    private final float cpy1;
    private final float cpy2;
    private final PathVerbType type = PathVerbType.Cubic;
    private final float x;
    private final float y;

    public CubicPathVerb(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.cpx1 = f2;
        this.cpy1 = f3;
        this.cpx2 = f4;
        this.cpy2 = f5;
        this.x = f6;
        this.y = f7;
    }

    public static /* synthetic */ CubicPathVerb copy$default(CubicPathVerb cubicPathVerb, float f2, float f3, float f4, float f5, float f6, float f7, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = cubicPathVerb.cpx1;
        }
        if ((i & 2) != 0) {
            f3 = cubicPathVerb.cpy1;
        }
        if ((i & 4) != 0) {
            f4 = cubicPathVerb.cpx2;
        }
        if ((i & 8) != 0) {
            f5 = cubicPathVerb.cpy2;
        }
        if ((i & 16) != 0) {
            f6 = cubicPathVerb.x;
        }
        if ((i & 32) != 0) {
            f7 = cubicPathVerb.y;
        }
        float f8 = f6;
        float f9 = f7;
        return cubicPathVerb.copy(f2, f3, f4, f5, f8, f9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getCpx1() {
        return this.cpx1;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getCpy1() {
        return this.cpy1;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getCpx2() {
        return this.cpx2;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getCpy2() {
        return this.cpy2;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final CubicPathVerb copy(float cpx1, float cpy1, float cpx2, float cpy2, float x, float y) {
        return new CubicPathVerb(cpx1, cpy1, cpx2, cpy2, x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CubicPathVerb)) {
            return false;
        }
        CubicPathVerb cubicPathVerb = (CubicPathVerb) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.cpx1), (Object) Float.valueOf(cubicPathVerb.cpx1)) && Intrinsics.areEqual((Object) Float.valueOf(this.cpy1), (Object) Float.valueOf(cubicPathVerb.cpy1)) && Intrinsics.areEqual((Object) Float.valueOf(this.cpx2), (Object) Float.valueOf(cubicPathVerb.cpx2)) && Intrinsics.areEqual((Object) Float.valueOf(this.cpy2), (Object) Float.valueOf(cubicPathVerb.cpy2)) && Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(cubicPathVerb.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(cubicPathVerb.y));
    }

    public final float getCpx1() {
        return this.cpx1;
    }

    public final float getCpx2() {
        return this.cpx2;
    }

    public final float getCpy1() {
        return this.cpy1;
    }

    public final float getCpy2() {
        return this.cpy2;
    }

    @Override // com.microsoft.clarity.models.display.paths.PathVerb
    public PathVerbType getType() {
        return this.type;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.y) + ((Float.hashCode(this.x) + ((Float.hashCode(this.cpy2) + ((Float.hashCode(this.cpx2) + ((Float.hashCode(this.cpy1) + (Float.hashCode(this.cpx1) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathVerb toProtobufInstance() {
        MutationPayload$PathVerb mutationPayload$PathVerbBuild = MutationPayload$PathVerb.newBuilder().a(getType().name()).a(this.cpx1).c(this.cpy1).b(this.cpx2).d(this.cpy2).f(this.x).i(this.y).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PathVerbBuild, "newBuilder()\n           …Y(y)\n            .build()");
        return mutationPayload$PathVerbBuild;
    }

    public String toString() {
        return b.a("CubicPathVerb(cpx1=").append(this.cpx1).append(", cpy1=").append(this.cpy1).append(", cpx2=").append(this.cpx2).append(", cpy2=").append(this.cpy2).append(", x=").append(this.x).append(", y=").append(this.y).append(')').toString();
    }
}
