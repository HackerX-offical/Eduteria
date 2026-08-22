package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: DrawScope.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001a:\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001a?\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a?\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0013\u001aG\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a?\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u001c\u0010\u0013\u001a_\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b \u0010!\u001a?\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b%\u0010&\u001a!\u0010'\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\tH\u0086\b\u001a?\u0010)\u001a\u00020\u0001*\u00020\u00022\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001aM\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u0002042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0087\b¢\u0006\u0004\b5\u00106\u001aY\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u0002042\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2 = {"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "left", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "horizontal", "vertical", "translate", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", CropImage.SCALE, "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "scale-Rg1IO4c", "clipRect", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DrawScopeKt {
    public static final void inset(DrawScope drawScope, float f2, float f3, float f4, float f5, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f2, f3, f4, f5);
        try {
            function1.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().inset(-f2, -f3, -f4, -f5);
        }
    }

    public static final void inset(DrawScope drawScope, float f2, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
        try {
            function1.invoke(drawScope);
        } finally {
            float f3 = -f2;
            drawScope.getDrawContext().getTransform().inset(f3, f3, f3, f3);
        }
    }

    public static final void translate(DrawScope drawScope, float f2, float f3, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().translate(f2, f3);
        try {
            function1.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-f2, -f3);
        }
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f2, float f3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().translate(f2, f3);
        try {
            function1.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-f2, -f3);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m6597rotateRg1IO4c$default(DrawScope drawScope, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo6548getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(f2, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m6599rotateRadRg1IO4c$default(DrawScope drawScope, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo6548getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(DegreesKt.degrees(f2), j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ void m6601scaleFgt4K4Q$default(DrawScope drawScope, float f2, float f3, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.mo6548getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6477scale0AR0LA0(f2, f3, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ void m6603scaleRg1IO4c$default(DrawScope drawScope, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.mo6548getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6477scale0AR0LA0(f2, f2, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo$default, reason: not valid java name */
    public static /* synthetic */ void m6592clipRectrOu3jXo$default(DrawScope drawScope, float f2, float f3, float f4, float f5, int i, Function1 function1, int i2, Object obj) {
        float f6 = (i2 & 1) != 0 ? 0.0f : f2;
        float f7 = (i2 & 2) != 0 ? 0.0f : f3;
        if ((i2 & 4) != 0) {
            f4 = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
        }
        float f8 = f4;
        if ((i2 & 8) != 0) {
            f5 = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
        }
        float f9 = f5;
        if ((i2 & 16) != 0) {
            i = ClipOp.INSTANCE.m5957getIntersectrtfAjoo();
        }
        int i3 = i;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6473clipRectN_I0leg(f6, f7, f8, f9, i3);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M$default, reason: not valid java name */
    public static /* synthetic */ void m6590clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.INSTANCE.m5957getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6472clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    public static final void drawIntoCanvas(DrawScope drawScope, Function1<? super Canvas, Unit> function1) {
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope drawScope, Function1<? super DrawTransform, Unit> function1, Function1<? super DrawScope, Unit> function12) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            function1.invoke(drawContext.getTransform());
            function12.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk, reason: not valid java name */
    public static final void m6594drawymL40Pk(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo6470getSizeNHjbRc = drawScope.getDrawContext().mo6470getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo6471setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
        }
    }

    /* JADX INFO: renamed from: draw-ymL40Pk$default, reason: not valid java name */
    public static /* synthetic */ void m6595drawymL40Pk$default(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, GraphicsLayer graphicsLayer, Function1 function1, int i, Object obj) {
        if ((i & 16) != 0) {
            graphicsLayer = null;
        }
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo6470getSizeNHjbRc = drawScope.getDrawContext().mo6470getSizeNHjbRc();
        GraphicsLayer graphicsLayer2 = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo6471setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(graphicsLayer);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
        }
    }

    public static final void inset(DrawScope drawScope, float f2, float f3, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f2, f3, f2, f3);
        try {
            function1.invoke(drawScope);
        } finally {
            float f4 = -f2;
            float f5 = -f3;
            drawScope.getDrawContext().getTransform().inset(f4, f5, f4, f5);
        }
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f2, float f3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().inset(f2, f3, f2, f3);
        try {
            function1.invoke(drawScope);
        } finally {
            float f4 = -f2;
            float f5 = -f3;
            drawScope.getDrawContext().getTransform().inset(f4, f5, f4, f5);
        }
    }

    /* JADX INFO: renamed from: rotate-Rg1IO4c, reason: not valid java name */
    public static final void m6596rotateRg1IO4c(DrawScope drawScope, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(f2, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: rotateRad-Rg1IO4c, reason: not valid java name */
    public static final void m6598rotateRadRg1IO4c(DrawScope drawScope, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(DegreesKt.degrees(f2), j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: scale-Fgt4K4Q, reason: not valid java name */
    public static final void m6600scaleFgt4K4Q(DrawScope drawScope, float f2, float f3, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6477scale0AR0LA0(f2, f3, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: scale-Rg1IO4c, reason: not valid java name */
    public static final void m6602scaleRg1IO4c(DrawScope drawScope, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6477scale0AR0LA0(f2, f2, j);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: clipRect-rOu3jXo, reason: not valid java name */
    public static final void m6591clipRectrOu3jXo(DrawScope drawScope, float f2, float f3, float f4, float f5, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6473clipRectN_I0leg(f2, f3, f4, f5, i);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: clipPath-KD09W0M, reason: not valid java name */
    public static final void m6589clipPathKD09W0M(DrawScope drawScope, Path path, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6472clipPathmtrdDE(path, i);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use a new overload accepting nullable GraphicsLayer")
    /* JADX INFO: renamed from: draw-GRGpd60, reason: not valid java name */
    public static final /* synthetic */ void m6593drawGRGpd60(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long jMo6470getSizeNHjbRc = drawScope.getDrawContext().mo6470getSizeNHjbRc();
        GraphicsLayer graphicsLayer = drawScope.getDrawContext().getGraphicsLayer();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.mo6471setSizeuvyYCjk(j);
        drawContext.setGraphicsLayer(null);
        canvas.save();
        try {
            function1.invoke(drawScope);
        } finally {
            canvas.restore();
            DrawContext drawContext2 = drawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas2);
            drawContext2.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer);
        }
    }
}
