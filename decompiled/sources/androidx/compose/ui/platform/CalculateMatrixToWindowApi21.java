package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/platform/CalculateMatrixToWindowApi21;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "<init>", "([FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "[F", "tmpLocation", "", "calculateMatrixToWindow", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "matrix", "calculateMatrixToWindow-EL8BTi8", "(Landroid/view/View;[F)V", "transformMatrixToWindow", "transformMatrixToWindow-EL8BTi8", "preConcat", "other", "Landroid/graphics/Matrix;", "preConcat-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "preTranslate", "x", "", "y", "preTranslate-3XD1CNM", "([FFF)V", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    private final int[] tmpLocation;
    private final float[] tmpMatrix;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo7912calculateMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Matrix.m6223resetimpl(matrix);
        m7915transformMatrixToWindowEL8BTi8(view, matrix);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    private final void m7915transformMatrixToWindowEL8BTi8(View view, float[] matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            m7915transformMatrixToWindowEL8BTi8((View) parent, matrix);
            m7914preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m7914preTranslate3XD1CNM(matrix, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.tmpLocation);
            m7914preTranslate3XD1CNM(matrix, -view.getScrollX(), -view.getScrollY());
            m7914preTranslate3XD1CNM(matrix, r0[0], r0[1]);
        }
        android.graphics.Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        m7913preConcattUYjHk(matrix, matrix2);
    }

    /* JADX INFO: renamed from: preConcat-tU-YjHk, reason: not valid java name */
    private final void m7913preConcattUYjHk(float[] fArr, android.graphics.Matrix matrix) {
        AndroidMatrixConversions_androidKt.m5836setFromtUYjHk(this.tmpMatrix, matrix);
        AndroidComposeView_androidKt.m7900preTransformJiSxe2E(fArr, this.tmpMatrix);
    }

    /* JADX INFO: renamed from: preTranslate-3XD1CNM, reason: not valid java name */
    private final void m7914preTranslate3XD1CNM(float[] fArr, float f2, float f3) {
        AndroidComposeView_androidKt.m7901preTranslatecG2Xzmc(fArr, f2, f3, this.tmpMatrix);
    }
}
