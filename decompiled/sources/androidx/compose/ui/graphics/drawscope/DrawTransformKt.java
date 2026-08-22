package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.DegreesKt;
import com.appnew.android.Utils.imagecropper.CropImage;
import kotlin.Metadata;

/* JADX INFO: compiled from: DrawTransform.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0086\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0004H\u0086\b\u001a&\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "horizontal", "", "vertical", "rotateRad", "radians", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotateRad-0AR0LA0", "(Landroidx/compose/ui/graphics/drawscope/DrawTransform;FJ)V", CropImage.SCALE, "scale-0AR0LA0", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DrawTransformKt {
    public static final void inset(DrawTransform drawTransform, float f2, float f3) {
        drawTransform.inset(f2, f3, f2, f3);
    }

    public static /* synthetic */ void inset$default(DrawTransform drawTransform, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        drawTransform.inset(f2, f3, f2, f3);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m6615rotateRad0AR0LA0$default(DrawTransform drawTransform, float f2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawTransform.mo6474getCenterF1C5BW0();
        }
        drawTransform.mo6476rotateUv8p0NA(DegreesKt.degrees(f2), j);
    }

    /* JADX INFO: renamed from: rotateRad-0AR0LA0, reason: not valid java name */
    public static final void m6614rotateRad0AR0LA0(DrawTransform drawTransform, float f2, long j) {
        drawTransform.mo6476rotateUv8p0NA(DegreesKt.degrees(f2), j);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
    public static final void m6616scale0AR0LA0(DrawTransform drawTransform, float f2, long j) {
        drawTransform.mo6477scale0AR0LA0(f2, f2, j);
    }

    /* JADX INFO: renamed from: scale-0AR0LA0$default, reason: not valid java name */
    public static /* synthetic */ void m6617scale0AR0LA0$default(DrawTransform drawTransform, float f2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawTransform.mo6474getCenterF1C5BW0();
        }
        drawTransform.mo6477scale0AR0LA0(f2, f2, j);
    }

    public static final void inset(DrawTransform drawTransform, float f2) {
        drawTransform.inset(f2, f2, f2, f2);
    }
}
