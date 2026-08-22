package com.microsoft.clarity.models.display.common;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.microsoft.clarity.a.b;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Point;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/microsoft/clarity/models/display/common/Point;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Point;", "x", "", "y", "(FF)V", "getX", "()F", "getY", "add", "d", "dx", "dy", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", "toProtobufInstance", InAppPurchaseConstants.METHOD_TO_STRING, "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Point implements IProtoModel<MutationPayload$Point> {
    private final float x;
    private final float y;

    public Point(float f2, float f3) {
        this.x = f2;
        this.y = f3;
    }

    public static /* synthetic */ Point copy$default(Point point, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = point.x;
        }
        if ((i & 2) != 0) {
            f3 = point.y;
        }
        return point.copy(f2, f3);
    }

    public final Point add(float d2) {
        return add(d2, d2);
    }

    public final Point add(float dx, float dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final Point copy(float x, float y) {
        return new Point(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Point)) {
            return false;
        }
        Point point = (Point) other;
        return Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(point.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(point.y));
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
    public MutationPayload$Point toProtobufInstance() {
        MutationPayload$Point mutationPayload$PointBuild = MutationPayload$Point.newBuilder().a(this.x).b(this.y).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$PointBuild, "newBuilder()\n           …Y(y)\n            .build()");
        return mutationPayload$PointBuild;
    }

    public String toString() {
        return b.a("Point(x=").append(this.x).append(", y=").append(this.y).append(')').toString();
    }
}
