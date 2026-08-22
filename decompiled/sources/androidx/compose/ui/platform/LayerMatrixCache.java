package androidx.compose.ui.platform;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LayerMatrixCache.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u00126\u0010\u0003\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u001d\u0010\u001e\u001a\u00020#2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001d\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b'\u0010&R>\u0010\u0003\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/platform/LayerMatrixCache;", ExifInterface.GPS_DIRECTION_TRUE, "", "getMatrix", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", TypedValues.AttributesType.S_TARGET, "Landroid/graphics/Matrix;", "matrix", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "androidMatrixCache", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", "isDirty", "", "isInverseDirty", "isInverseValid", "isIdentity", "reset", "invalidate", "calculateMatrix", "calculateMatrix-GrdbGEg", "(Ljava/lang/Object;)[F", "calculateInverseMatrix", "calculateInverseMatrix-bWbORWo", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "(Ljava/lang/Object;Landroidx/compose/ui/geometry/MutableRect;)V", "mapInverse", "Landroidx/compose/ui/geometry/Offset;", "offset", "map-R5De75A", "(Ljava/lang/Object;J)J", "mapInverse-R5De75A", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LayerMatrixCache<T> {
    public static final int $stable = 8;
    private Matrix androidMatrixCache;
    private final Function2<T, Matrix, Unit> getMatrix;
    private boolean isDirty;
    private boolean isInverseDirty;
    private float[] matrixCache = androidx.compose.ui.graphics.Matrix.m6214constructorimpl$default(null, 1, null);
    private float[] inverseMatrixCache = androidx.compose.ui.graphics.Matrix.m6214constructorimpl$default(null, 1, null);
    private boolean isInverseValid = true;
    private boolean isIdentity = true;

    /* JADX WARN: Multi-variable type inference failed */
    public LayerMatrixCache(Function2<? super T, ? super Matrix, Unit> function2) {
        this.getMatrix = function2;
    }

    public final void reset() {
        this.isDirty = false;
        this.isInverseDirty = false;
        this.isIdentity = true;
        this.isInverseValid = true;
        androidx.compose.ui.graphics.Matrix.m6223resetimpl(this.matrixCache);
        androidx.compose.ui.graphics.Matrix.m6223resetimpl(this.inverseMatrixCache);
    }

    public final void invalidate() {
        this.isDirty = true;
        this.isInverseDirty = true;
    }

    /* JADX INFO: renamed from: calculateMatrix-GrdbGEg, reason: not valid java name */
    public final float[] m7954calculateMatrixGrdbGEg(T target) {
        float[] fArr = this.matrixCache;
        if (!this.isDirty) {
            return fArr;
        }
        Matrix matrix = this.androidMatrixCache;
        if (matrix == null) {
            matrix = new Matrix();
            this.androidMatrixCache = matrix;
        }
        this.getMatrix.invoke(target, matrix);
        AndroidMatrixConversions_androidKt.m5836setFromtUYjHk(fArr, matrix);
        this.isDirty = false;
        this.isIdentity = MatrixKt.m6239isIdentity58bKbWc(fArr);
        return fArr;
    }

    /* JADX INFO: renamed from: calculateInverseMatrix-bWbORWo, reason: not valid java name */
    public final float[] m7953calculateInverseMatrixbWbORWo(T target) {
        float[] fArr = this.inverseMatrixCache;
        if (this.isInverseDirty) {
            this.isInverseValid = InvertMatrixKt.m7951invertToJiSxe2E(m7954calculateMatrixGrdbGEg(target), fArr);
            this.isInverseDirty = false;
        }
        if (this.isInverseValid) {
            return fArr;
        }
        return null;
    }

    public final void map(T target, MutableRect rect) {
        float[] fArrM7954calculateMatrixGrdbGEg = m7954calculateMatrixGrdbGEg(target);
        if (this.isIdentity) {
            return;
        }
        androidx.compose.ui.graphics.Matrix.m6222mapimpl(fArrM7954calculateMatrixGrdbGEg, rect);
    }

    public final void mapInverse(T target, MutableRect rect) {
        float[] fArrM7953calculateInverseMatrixbWbORWo = m7953calculateInverseMatrixbWbORWo(target);
        if (fArrM7953calculateInverseMatrixbWbORWo == null) {
            rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            if (this.isIdentity) {
                return;
            }
            androidx.compose.ui.graphics.Matrix.m6222mapimpl(fArrM7953calculateInverseMatrixbWbORWo, rect);
        }
    }

    /* JADX INFO: renamed from: map-R5De75A, reason: not valid java name */
    public final long m7955mapR5De75A(T target, long offset) {
        return !this.isIdentity ? androidx.compose.ui.graphics.Matrix.m6220mapMKHz9U(m7954calculateMatrixGrdbGEg(target), offset) : offset;
    }

    /* JADX INFO: renamed from: mapInverse-R5De75A, reason: not valid java name */
    public final long m7956mapInverseR5De75A(T target, long offset) {
        float[] fArrM7953calculateInverseMatrixbWbORWo = m7953calculateInverseMatrixbWbORWo(target);
        if (fArrM7953calculateInverseMatrixbWbORWo == null) {
            return Offset.INSTANCE.m5737getInfiniteF1C5BW0();
        }
        return !this.isIdentity ? androidx.compose.ui.graphics.Matrix.m6220mapMKHz9U(fArrM7953calculateInverseMatrixbWbORWo, offset) : offset;
    }
}
