package com.microsoft.clarity.models.display.paths;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006#"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/ConicPathVerb;", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "x1", "", "y1", "x2", "y2", "weight", "(FFFFF)V", "type", "Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getType", "()Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getWeight", "()F", "getX1", "getX2", "getY1", "getY2", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathVerb;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ConicPathVerb extends PathVerb {
    private final PathVerbType type = PathVerbType.Conic;
    private final float weight;
    private final float x1;
    private final float x2;
    private final float y1;
    private final float y2;

    public ConicPathVerb(float f2, float f3, float f4, float f5, float f6) {
        this.x1 = f2;
        this.y1 = f3;
        this.x2 = f4;
        this.y2 = f5;
        this.weight = f6;
    }

    public static /* synthetic */ ConicPathVerb copy$default(ConicPathVerb conicPathVerb, float f2, float f3, float f4, float f5, float f6, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = conicPathVerb.x1;
        }
        if ((i & 2) != 0) {
            f3 = conicPathVerb.y1;
        }
        if ((i & 4) != 0) {
            f4 = conicPathVerb.x2;
        }
        if ((i & 8) != 0) {
            f5 = conicPathVerb.y2;
        }
        if ((i & 16) != 0) {
            f6 = conicPathVerb.weight;
        }
        float f7 = f6;
        float f8 = f4;
        return conicPathVerb.copy(f2, f3, f8, f5, f7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX1() {
        return this.x1;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY1() {
        return this.y1;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getX2() {
        return this.x2;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getY2() {
        return this.y2;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getWeight() {
        return this.weight;
    }

    public final ConicPathVerb copy(float x1, float y1, float x2, float y2, float weight) {
        return new ConicPathVerb(x1, y1, x2, y2, weight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConicPathVerb)) {
            return false;
        }
        ConicPathVerb conicPathVerb = (ConicPathVerb) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.x1), (Object) Float.valueOf(conicPathVerb.x1)) && Intrinsics.areEqual((Object) Float.valueOf(this.y1), (Object) Float.valueOf(conicPathVerb.y1)) && Intrinsics.areEqual((Object) Float.valueOf(this.x2), (Object) Float.valueOf(conicPathVerb.x2)) && Intrinsics.areEqual((Object) Float.valueOf(this.y2), (Object) Float.valueOf(conicPathVerb.y2)) && Intrinsics.areEqual((Object) Float.valueOf(this.weight), (Object) Float.valueOf(conicPathVerb.weight));
    }

    @Override // com.microsoft.clarity.models.display.paths.PathVerb
    public PathVerbType getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final float getX1() {
        return this.x1;
    }

    public final float getX2() {
        return this.x2;
    }

    public final float getY1() {
        return this.y1;
    }

    public final float getY2() {
        return this.y2;
    }

    public int hashCode() {
        return Float.hashCode(this.weight) + ((Float.hashCode(this.y2) + ((Float.hashCode(this.x2) + ((Float.hashCode(this.y1) + (Float.hashCode(this.x1) * 31)) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathVerb toProtobufInstance() {
        MutationPayload$PathVerb mutationPayload$PathVerbBuild = MutationPayload$PathVerb.newBuilder().a(getType().name()).g(this.x1).j(this.y1).h(this.x2).k(this.y2).e(this.weight).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PathVerbBuild, "newBuilder()\n           …ght)\n            .build()");
        return mutationPayload$PathVerbBuild;
    }

    public String toString() {
        return b.a("ConicPathVerb(x1=").append(this.x1).append(", y1=").append(this.y1).append(", x2=").append(this.x2).append(", y2=").append(this.y2).append(", weight=").append(this.weight).append(')').toString();
    }
}
