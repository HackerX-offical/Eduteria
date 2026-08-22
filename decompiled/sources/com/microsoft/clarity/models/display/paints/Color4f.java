package com.microsoft.clarity.models.display.paints;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Color4f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/display/paints/Color4f;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Color4f;", StreamManagement.AckRequest.ELEMENT, "", "g", "b", "a", "(FFFF)V", "getA", "()F", "getB", "getG", "getR", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Color4f implements IProtoModel<MutationPayload$Color4f> {
    private final float a;
    private final float b;
    private final float g;
    private final float r;

    public Color4f(float f2, float f3, float f4, float f5) {
        this.r = f2;
        this.g = f3;
        this.b = f4;
        this.a = f5;
    }

    public static /* synthetic */ Color4f copy$default(Color4f color4f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = color4f.r;
        }
        if ((i & 2) != 0) {
            f3 = color4f.g;
        }
        if ((i & 4) != 0) {
            f4 = color4f.b;
        }
        if ((i & 8) != 0) {
            f5 = color4f.a;
        }
        return color4f.copy(f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getR() {
        return this.r;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getG() {
        return this.g;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getA() {
        return this.a;
    }

    public final Color4f copy(float r, float g2, float b2, float a2) {
        return new Color4f(r, g2, b2, a2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Color4f)) {
            return false;
        }
        Color4f color4f = (Color4f) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.r), (Object) Float.valueOf(color4f.r)) && Intrinsics.areEqual((Object) Float.valueOf(this.g), (Object) Float.valueOf(color4f.g)) && Intrinsics.areEqual((Object) Float.valueOf(this.b), (Object) Float.valueOf(color4f.b)) && Intrinsics.areEqual((Object) Float.valueOf(this.a), (Object) Float.valueOf(color4f.a));
    }

    public final float getA() {
        return this.a;
    }

    public final float getB() {
        return this.b;
    }

    public final float getG() {
        return this.g;
    }

    public final float getR() {
        return this.r;
    }

    public int hashCode() {
        return Float.hashCode(this.a) + ((Float.hashCode(this.b) + ((Float.hashCode(this.g) + (Float.hashCode(this.r) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Color4f toProtobufInstance() {
        MutationPayload$Color4f mutationPayload$Color4fBuild = MutationPayload$Color4f.newBuilder().a(this.a).b(this.b).c(this.g).d(this.r).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$Color4fBuild, "newBuilder()\n           …R(r)\n            .build()");
        return mutationPayload$Color4fBuild;
    }

    public String toString() {
        return b.a("Color4f(r=").append(this.r).append(", g=").append(this.g).append(", b=").append(this.b).append(", a=").append(this.a).append(')').toString();
    }
}
