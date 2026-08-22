package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidCanvas.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J7\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u000204*\u00020+¢\u0006\u0004\b5\u00106J'\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b;\u0010<J0\u0010=\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J@\u0010>\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J0\u0010A\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bE\u0010FJH\u0010G\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010L\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002092\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bQ\u0010RJ?\u0010S\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020W2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bZ\u0010[J-\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\ba\u0010bJ\b\u0010c\u001a\u00020\u000fH\u0016J\b\u0010d\u001a\u00020\u000fH\u0016J\u001e\u0010\\\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010e\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J'\u0010h\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bj\u0010kJ \u0010h\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J \u0010l\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J'\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\br\u0010sR$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "internalCanvas", "Landroid/graphics/Canvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "Landroid/graphics/Rect;", "dstRect", "save", "", "restore", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", CropImage.SCALE, "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", "center", Constants.KEY_RADIUS, "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "drawLines", "stepBy", "", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidCanvas implements Canvas {
    public static final int $stable = 8;
    private Rect dstRect;
    private android.graphics.Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private Rect srcRect;

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(androidx.compose.ui.geometry.Rect bounds, Paint paint) {
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), AndroidPaint_androidKt.getNativePaint(paint), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float dx, float dy) {
        this.internalCanvas.translate(dx, dy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float sx, float sy) {
        this.internalCanvas.scale(sx, sy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float degrees) {
        this.internalCanvas.rotate(degrees);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float sx, float sy) {
        this.internalCanvas.skew(sx, sy);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: concat-58bKbWc, reason: not valid java name */
    public void mo5819concat58bKbWc(float[] matrix) {
        if (MatrixKt.m6239isIdentity58bKbWc(matrix)) {
            return;
        }
        android.graphics.Matrix matrix2 = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m5835setFromEL8BTi8(matrix2, matrix);
        this.internalCanvas.concat(matrix2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
    public void mo5818clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
        this.internalCanvas.clipRect(left, top, right, bottom, m5827toRegionOp7u2Bmg(clipOp));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
    public void mo5817clipPathmtrdDE(Path path, int clipOp) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) path).getInternalPath(), m5827toRegionOp7u2Bmg(clipOp));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* JADX INFO: renamed from: toRegionOp--7u2Bmg, reason: not valid java name */
    public final Region.Op m5827toRegionOp7u2Bmg(int i) {
        return ClipOp.m5952equalsimpl0(i, ClipOp.INSTANCE.m5956getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawLine-Wko1d7g, reason: not valid java name */
    public void mo5823drawLineWko1d7g(long p1, long p2, Paint paint) {
        this.internalCanvas.drawLine(Float.intBitsToFloat((int) (p1 >> 32)), Float.intBitsToFloat((int) (p1 & 4294967295L)), Float.intBitsToFloat((int) (p2 >> 32)), Float.intBitsToFloat((int) (p2 & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        this.internalCanvas.drawRect(left, top, right, bottom, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint) {
        this.internalCanvas.drawRoundRect(left, top, right, bottom, radiusX, radiusY, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float left, float top, float right, float bottom, Paint paint) {
        this.internalCanvas.drawOval(left, top, right, bottom, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawCircle-9KIMszo, reason: not valid java name */
    public void mo5820drawCircle9KIMszo(long center, float radius, Paint paint) {
        this.internalCanvas.drawCircle(Float.intBitsToFloat((int) (center >> 32)), Float.intBitsToFloat((int) (center & 4294967295L)), radius, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        this.internalCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).getInternalPath(), AndroidPaint_androidKt.getNativePaint(paint));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImage-d-4ec7I, reason: not valid java name */
    public void mo5821drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Float.intBitsToFloat((int) (topLeftOffset >> 32)), Float.intBitsToFloat((int) (topLeftOffset & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawImageRect-HPBpro0, reason: not valid java name */
    public void mo5822drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint) {
        if (this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap bitmapAsAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        Rect rect = this.srcRect;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.m8958getXimpl(srcOffset);
        rect.top = IntOffset.m8959getYimpl(srcOffset);
        rect.right = IntOffset.m8958getXimpl(srcOffset) + ((int) (srcSize >> 32));
        rect.bottom = IntOffset.m8959getYimpl(srcOffset) + ((int) (srcSize & 4294967295L));
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.m8958getXimpl(dstOffset);
        rect2.top = IntOffset.m8959getYimpl(dstOffset);
        rect2.right = IntOffset.m8958getXimpl(dstOffset) + ((int) (dstSize >> 32));
        rect2.bottom = IntOffset.m8959getYimpl(dstOffset) + ((int) (dstSize & 4294967295L));
        Unit unit2 = Unit.INSTANCE;
        canvas.drawBitmap(bitmapAsAndroidBitmap, rect, rect2, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawPoints-O7TthRY, reason: not valid java name */
    public void mo5824drawPointsO7TthRY(int pointMode, List<Offset> points, Paint paint) {
        if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6289getLinesr_lszbg())) {
            drawLines(points, paint, 2);
        } else if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6291getPolygonr_lszbg())) {
            drawLines(points, paint, 1);
        } else if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6290getPointsr_lszbg())) {
            drawPoints(points, paint);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    private final void drawLines(List<Offset> points, Paint paint, int stepBy) {
        if (points.size() >= 2) {
            android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
            int i = 0;
            while (i < points.size() - 1) {
                long jM5733unboximpl = points.get(i).m5733unboximpl();
                long jM5733unboximpl2 = points.get(i + 1).m5733unboximpl();
                this.internalCanvas.drawLine(Float.intBitsToFloat((int) (jM5733unboximpl >> 32)), Float.intBitsToFloat((int) (jM5733unboximpl & 4294967295L)), Float.intBitsToFloat((int) (jM5733unboximpl2 >> 32)), Float.intBitsToFloat((int) (jM5733unboximpl2 & 4294967295L)), nativePaint);
                i += stepBy;
            }
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawRawPoints-O7TthRY, reason: not valid java name */
    public void mo5825drawRawPointsO7TthRY(int pointMode, float[] points, Paint paint) {
        if (points.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6289getLinesr_lszbg())) {
            drawRawLines(points, paint, 2);
        } else if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6291getPolygonr_lszbg())) {
            drawRawLines(points, paint, 1);
        } else if (PointMode.m6285equalsimpl0(pointMode, PointMode.INSTANCE.m6290getPointsr_lszbg())) {
            drawRawPoints(points, paint, 2);
        }
    }

    private final void drawRawPoints(float[] points, Paint paint, int stepBy) {
        if (points.length % 2 == 0) {
            android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
            int i = 0;
            while (i < points.length - 1) {
                this.internalCanvas.drawPoint(points[i], points[i + 1], nativePaint);
                i += stepBy;
            }
        }
    }

    private final void drawRawLines(float[] points, Paint paint, int stepBy) {
        if (points.length < 4 || points.length % 2 != 0) {
            return;
        }
        android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
        int i = 0;
        while (i < points.length - 3) {
            this.internalCanvas.drawLine(points[i], points[i + 1], points[i + 2], points[i + 3], nativePaint);
            i += stepBy * 2;
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* JADX INFO: renamed from: drawVertices-TPEHhCM, reason: not valid java name */
    public void mo5826drawVerticesTPEHhCM(Vertices vertices, int blendMode, Paint paint) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m5872toAndroidVertexModeJOOmi9M(vertices.getVertexMode()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, AndroidPaint_androidKt.getNativePaint(paint));
    }

    private final void drawPoints(List<Offset> points, Paint paint) {
        int size = points.size();
        for (int i = 0; i < size; i++) {
            long jM5733unboximpl = points.get(i).m5733unboximpl();
            this.internalCanvas.drawPoint(Float.intBitsToFloat((int) (jM5733unboximpl >> 32)), Float.intBitsToFloat((int) (jM5733unboximpl & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
        }
    }
}
