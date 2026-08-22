package androidx.compose.ui.geometry;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RoundRect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0001?BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001e\u001a\u00020\u0000H\u0002J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b(\u0010)J\b\u0010*\u001a\u00020+H\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u0010\u00100\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b1\u0010\u0014J\u0010\u00102\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b3\u0010\u0014J\u0010\u00104\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b5\u0010\u0014J\u0010\u00106\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b7\u0010\u0014J`\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b9\u0010:J\u0014\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010=\u001a\u00020>HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000fR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "<init>", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft", "()F", "getTop", "getRight", "getBottom", "getTopLeftCornerRadius-kKHJgLs", "()J", "J", "getTopRightCornerRadius-kKHJgLs", "getBottomRightCornerRadius-kKHJgLs", "getBottomLeftCornerRadius-kKHJgLs", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight", "_scaledRadiiRect", "scaledRadiiRect", "minRadius", "min", "radius1", "radius2", Constants.KEY_LIMIT, "contains", "", Const.POINT, "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", InAppPurchaseConstants.METHOD_TO_STRING, "", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", Constants.COPY_TYPE, "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RoundRect {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final RoundRect Zero = RoundRectKt.m5777RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.INSTANCE.m5695getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f2, float f3, float f4, float f5, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, j, j2, j3, j4);
    }

    /* JADX INFO: renamed from: copy-MDFrsts$default, reason: not valid java name */
    public static /* synthetic */ RoundRect m5764copyMDFrsts$default(RoundRect roundRect, float f2, float f3, float f4, float f5, long j, long j2, long j3, long j4, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = roundRect.left;
        }
        if ((i & 2) != 0) {
            f3 = roundRect.top;
        }
        if ((i & 4) != 0) {
            f4 = roundRect.right;
        }
        if ((i & 8) != 0) {
            f5 = roundRect.bottom;
        }
        if ((i & 16) != 0) {
            j = roundRect.topLeftCornerRadius;
        }
        if ((i & 32) != 0) {
            j2 = roundRect.topRightCornerRadius;
        }
        if ((i & 64) != 0) {
            j3 = roundRect.bottomRightCornerRadius;
        }
        if ((i & 128) != 0) {
            j4 = roundRect.bottomLeftCornerRadius;
        }
        long j5 = j4;
        long j6 = j3;
        long j7 = j2;
        long j8 = j;
        return roundRect.m5770copyMDFrsts(f2, f3, f4, f5, j8, j7, j6, j5);
    }

    public static final RoundRect getZero() {
        return INSTANCE.getZero();
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: component5-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopLeftCornerRadius() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: component6-kKHJgLs, reason: not valid java name and from getter */
    public final long getTopRightCornerRadius() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: component7-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomRightCornerRadius() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: component8-kKHJgLs, reason: not valid java name and from getter */
    public final long getBottomLeftCornerRadius() {
        return this.bottomLeftCornerRadius;
    }

    /* JADX INFO: renamed from: copy-MDFrsts, reason: not valid java name */
    public final RoundRect m5770copyMDFrsts(float left, float top, float right, float bottom, long topLeftCornerRadius, long topRightCornerRadius, long bottomRightCornerRadius, long bottomLeftCornerRadius) {
        return new RoundRect(left, top, right, bottom, topLeftCornerRadius, topRightCornerRadius, bottomRightCornerRadius, bottomLeftCornerRadius, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) other;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m5682equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m5682equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m5682equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m5682equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + CornerRadius.m5685hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m5685hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m5685hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m5685hashCodeimpl(this.bottomLeftCornerRadius);
    }

    private RoundRect(float f2, float f3, float f4, float f5, long j, long j2, long j3, long j4) {
        this.left = f2;
        this.top = f3;
        this.right = f4;
        this.bottom = f5;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public /* synthetic */ RoundRect(float f2, float f3, float f4, float f5, long j, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5, (i & 16) != 0 ? CornerRadius.INSTANCE.m5695getZerokKHJgLs() : j, (i & 32) != 0 ? CornerRadius.INSTANCE.m5695getZerokKHJgLs() : j2, (i & 64) != 0 ? CornerRadius.INSTANCE.m5695getZerokKHJgLs() : j3, (i & 128) != 0 ? CornerRadius.INSTANCE.m5695getZerokKHJgLs() : j4, null);
    }

    /* JADX INFO: renamed from: getTopLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m5773getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* JADX INFO: renamed from: getTopRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m5774getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomRightCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m5772getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* JADX INFO: renamed from: getBottomLeftCornerRadius-kKHJgLs, reason: not valid java name */
    public final long m5771getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        float fMinRadius = minRadius(minRadius(minRadius(minRadius(1.0f, Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & 4294967295L)), Float.intBitsToFloat((int) (this.topLeftCornerRadius & 4294967295L)), getHeight()), Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)), Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)), getWidth()), Float.intBitsToFloat((int) (this.topRightCornerRadius & 4294967295L)), Float.intBitsToFloat((int) (this.bottomRightCornerRadius & 4294967295L)), getHeight()), Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)), Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)), getWidth());
        float f2 = this.left * fMinRadius;
        float f3 = this.top * fMinRadius;
        float f4 = this.right * fMinRadius;
        float f5 = this.bottom * fMinRadius;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.topLeftCornerRadius >> 32)) * fMinRadius;
        long jM5677constructorimpl = CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.topLeftCornerRadius & 4294967295L)) * fMinRadius)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.topRightCornerRadius >> 32)) * fMinRadius;
        long jM5677constructorimpl2 = CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.topRightCornerRadius & 4294967295L)) * fMinRadius)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.bottomRightCornerRadius >> 32)) * fMinRadius;
        RoundRect roundRect2 = new RoundRect(f2, f3, f4, f5, jM5677constructorimpl, jM5677constructorimpl2, CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.bottomRightCornerRadius & 4294967295L)) * fMinRadius)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32)), CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.bottomLeftCornerRadius >> 32)) * fMinRadius)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (this.bottomLeftCornerRadius & 4294967295L)) * fMinRadius)) & 4294967295L)), null);
        this._scaledRadiiRect = roundRect2;
        return roundRect2;
    }

    private final float minRadius(float min, float radius1, float radius2, float limit) {
        float f2 = radius1 + radius2;
        return (f2 <= limit || f2 == 0.0f) ? min : Math.min(min, limit / f2);
    }

    public String toString() {
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        String str = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m5682equalsimpl0(j, j2) || !CornerRadius.m5682equalsimpl0(j2, j3) || !CornerRadius.m5682equalsimpl0(j3, j4)) {
            return "RoundRect(rect=" + str + ", topLeft=" + ((Object) CornerRadius.m5691toStringimpl(j)) + ", topRight=" + ((Object) CornerRadius.m5691toStringimpl(j2)) + ", bottomRight=" + ((Object) CornerRadius.m5691toStringimpl(j3)) + ", bottomLeft=" + ((Object) CornerRadius.m5691toStringimpl(j4)) + ')';
        }
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        return Float.intBitsToFloat(i) == Float.intBitsToFloat(i2) ? "RoundRect(rect=" + str + ", radius=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1) + ')' : "RoundRect(rect=" + str + ", x=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat(i2), 1) + ')';
    }

    /* JADX INFO: compiled from: RoundRect.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "<init>", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }

    /* JADX INFO: renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m5769containsk4lQ0M(long point) {
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        float fIntBitsToFloat3;
        float fIntBitsToFloat4;
        int i = (int) (point >> 32);
        if (Float.intBitsToFloat(i) >= this.left && Float.intBitsToFloat(i) < this.right) {
            int i2 = (int) (point & 4294967295L);
            if (Float.intBitsToFloat(i2) >= this.top && Float.intBitsToFloat(i2) < this.bottom) {
                RoundRect roundRectScaledRadiiRect = scaledRadiiRect();
                if (Float.intBitsToFloat(i) < this.left + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topLeftCornerRadius >> 32)) && Float.intBitsToFloat(i2) < this.top + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topLeftCornerRadius & 4294967295L))) {
                    fIntBitsToFloat = (Float.intBitsToFloat(i) - this.left) - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topLeftCornerRadius >> 32));
                    fIntBitsToFloat2 = (Float.intBitsToFloat(i2) - this.top) - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topLeftCornerRadius & 4294967295L));
                    fIntBitsToFloat3 = Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topLeftCornerRadius >> 32));
                    fIntBitsToFloat4 = Float.intBitsToFloat((int) (4294967295L & roundRectScaledRadiiRect.topLeftCornerRadius));
                } else if (Float.intBitsToFloat(i) > this.right - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topRightCornerRadius >> 32)) && Float.intBitsToFloat(i2) < this.top + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topRightCornerRadius & 4294967295L))) {
                    fIntBitsToFloat = (Float.intBitsToFloat(i) - this.right) + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topRightCornerRadius >> 32));
                    fIntBitsToFloat2 = (Float.intBitsToFloat(i2) - this.top) - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topRightCornerRadius & 4294967295L));
                    fIntBitsToFloat3 = Float.intBitsToFloat((int) (roundRectScaledRadiiRect.topRightCornerRadius >> 32));
                    fIntBitsToFloat4 = Float.intBitsToFloat((int) (4294967295L & roundRectScaledRadiiRect.topRightCornerRadius));
                } else if (Float.intBitsToFloat(i) > this.right - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomRightCornerRadius >> 32)) && Float.intBitsToFloat(i2) > this.bottom - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomRightCornerRadius & 4294967295L))) {
                    fIntBitsToFloat = (Float.intBitsToFloat(i) - this.right) + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomRightCornerRadius >> 32));
                    fIntBitsToFloat2 = (Float.intBitsToFloat(i2) - this.bottom) + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomRightCornerRadius & 4294967295L));
                    fIntBitsToFloat3 = Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomRightCornerRadius >> 32));
                    fIntBitsToFloat4 = Float.intBitsToFloat((int) (4294967295L & roundRectScaledRadiiRect.bottomRightCornerRadius));
                } else {
                    if (Float.intBitsToFloat(i) >= this.left + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomLeftCornerRadius >> 32)) || Float.intBitsToFloat(i2) <= this.bottom - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomLeftCornerRadius & 4294967295L))) {
                        return true;
                    }
                    fIntBitsToFloat = (Float.intBitsToFloat(i) - this.left) - Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomLeftCornerRadius >> 32));
                    fIntBitsToFloat2 = (Float.intBitsToFloat(i2) - this.bottom) + Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomLeftCornerRadius & 4294967295L));
                    fIntBitsToFloat3 = Float.intBitsToFloat((int) (roundRectScaledRadiiRect.bottomLeftCornerRadius >> 32));
                    fIntBitsToFloat4 = Float.intBitsToFloat((int) (4294967295L & roundRectScaledRadiiRect.bottomLeftCornerRadius));
                }
                float f2 = fIntBitsToFloat / fIntBitsToFloat3;
                float f3 = fIntBitsToFloat2 / fIntBitsToFloat4;
                return (f2 * f2) + (f3 * f3) <= 1.0f;
            }
        }
        return false;
    }
}
