package androidx.compose.ui.graphics;

import com.amazonaws.services.s3.internal.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ColorFilter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrixColorFilter;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorMatrix", "Landroidx/compose/ui/graphics/ColorMatrix;", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "<init>", "([FLandroid/graphics/ColorFilter;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "copyColorMatrix", "targetColorMatrix", "copyColorMatrix-gBh15pI", "([F)[F", "equals", "", "other", "", "obtainColorMatrix", "obtainColorMatrix-p10-uLo", "()[F", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorMatrixColorFilter extends ColorFilter {
    public static final int $stable = 0;
    private float[] colorMatrix;

    public /* synthetic */ ColorMatrixColorFilter(float[] fArr, android.graphics.ColorFilter colorFilter, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr, colorFilter);
    }

    public /* synthetic */ ColorMatrixColorFilter(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private ColorMatrixColorFilter(float[] fArr, android.graphics.ColorFilter colorFilter) {
        super(colorFilter);
        this.colorMatrix = fArr;
    }

    private ColorMatrixColorFilter(float[] fArr) {
        this(fArr, AndroidColorFilter_androidKt.m5828actualColorMatrixColorFilterjHGOpc(fArr), null);
    }

    /* JADX INFO: renamed from: copyColorMatrix-gBh15pI$default, reason: not valid java name */
    public static /* synthetic */ float[] m6044copyColorMatrixgBh15pI$default(ColorMatrixColorFilter colorMatrixColorFilter, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = ColorMatrix.m6025constructorimpl$default(null, 1, null);
        }
        return colorMatrixColorFilter.m6046copyColorMatrixgBh15pI(fArr);
    }

    /* JADX INFO: renamed from: copyColorMatrix-gBh15pI, reason: not valid java name */
    public final float[] m6046copyColorMatrixgBh15pI(float[] targetColorMatrix) {
        ArraysKt.copyInto$default(m6045obtainColorMatrixp10uLo(), targetColorMatrix, 0, 0, 0, 14, (Object) null);
        return targetColorMatrix;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorMatrixColorFilter) && Arrays.equals(m6045obtainColorMatrixp10uLo(), ((ColorMatrixColorFilter) other).m6045obtainColorMatrixp10uLo());
    }

    /* JADX INFO: renamed from: obtainColorMatrix-p10-uLo, reason: not valid java name */
    private final float[] m6045obtainColorMatrixp10uLo() {
        float[] fArr = this.colorMatrix;
        if (fArr != null) {
            return fArr;
        }
        float[] fArrActualColorMatrixFromFilter = AndroidColorFilter_androidKt.actualColorMatrixFromFilter(getNativeColorFilter());
        this.colorMatrix = fArrActualColorMatrixFromFilter;
        return fArrActualColorMatrixFromFilter;
    }

    public int hashCode() {
        float[] fArr = this.colorMatrix;
        if (fArr != null) {
            return ColorMatrix.m6031hashCodeimpl(fArr);
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColorMatrixColorFilter(colorMatrix=");
        float[] fArr = this.colorMatrix;
        return sb.append((Object) (fArr == null ? Constants.NULL_VERSION_ID : ColorMatrix.m6042toStringimpl(fArr))).append(')').toString();
    }
}
