package com.microsoft.clarity.models.display.paths;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$PathVerb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/microsoft/clarity/models/display/paths/MovePathVerb;", "Lcom/microsoft/clarity/models/display/paths/PathVerb;", "x", "", "y", "(FF)V", "type", "Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getType", "()Lcom/microsoft/clarity/models/display/paths/PathVerbType;", "getX", "()F", "getY", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$PathVerb;", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class MovePathVerb extends PathVerb {
    private final PathVerbType type = PathVerbType.Move;
    private final float x;
    private final float y;

    public MovePathVerb(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public static /* synthetic */ MovePathVerb copy$default(MovePathVerb movePathVerb, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = movePathVerb.x;
        }
        if ((i & 2) != 0) {
            f3 = movePathVerb.y;
        }
        return movePathVerb.copy(f2, f3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final MovePathVerb copy(float x, float y) {
        return new MovePathVerb(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovePathVerb)) {
            return false;
        }
        MovePathVerb movePathVerb = (MovePathVerb) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(movePathVerb.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(movePathVerb.y));
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
        return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$PathVerb toProtobufInstance() {
        MutationPayload$PathVerb mutationPayload$PathVerbBuild = MutationPayload$PathVerb.newBuilder().a(getType().name()).f(this.x).i(this.y).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PathVerbBuild, "newBuilder()\n           …Y(y)\n            .build()");
        return mutationPayload$PathVerbBuild;
    }

    public String toString() {
        return b.a("MovePathVerb(x=").append(this.x).append(", y=").append(this.y).append(')').toString();
    }
}
