package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: VectorPainter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0093\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2@\u0010\u000f\u001a<\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u009d\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00182@\u0010\u000f\u001a<\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\n\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a&\u0010\u001e\u001a\u00020\u0012*\u00020\u001f2\u0017\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00120!¢\u0006\u0002\b\"H\u0082\b\u001a#\u0010#\u001a\u00020$*\u00020%2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010'\u001a'\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010+\u001a!\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010/\u001aA\u00100\u001a\u00020\u0003*\u00020\u00032\u0006\u0010)\u001a\u00020$2\u0006\u00101\u001a\u00020$2\b\b\u0002\u0010\n\u001a\u00020\u00012\b\u00102\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b3\u00104\u001a \u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209H\u0000\u001a\u0014\u0010:\u001a\u000209*\u0002092\u0006\u0010;\u001a\u00020<H\u0000\u001a+\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020<2\u0014\b\u0002\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020A0@H\u0007¢\u0006\u0002\u0010B\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"RootGroupName", "", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "obtainSizePx", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/Density;", "obtainSizePx-VpY3zN4", "(Landroidx/compose/ui/unit/Density;FF)J", "obtainViewportSize", "defaultSize", "obtainViewportSize-Pq9zytI", "(JFF)J", "createColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "createColorFilter-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "configureVectorPainter", "viewportSize", "intrinsicColorFilter", "configureVectorPainter-T4PVSW8", "(Landroidx/compose/ui/graphics/vector/VectorPainter;JJLjava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;Z)Landroidx/compose/ui/graphics/vector/VectorPainter;", "createVectorPainterFromImageVector", "density", "imageVector", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "createGroupComponent", "currentGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "RenderVectorGroup", "group", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* JADX INFO: renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m6735rememberVectorPaintermlNsNFs(float f2, float f3, float f4, float f5, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 411310745, "C(rememberVectorPainter)N(defaultWidth:c#ui.unit.Dp,defaultHeight:c#ui.unit.Dp,viewportWidth,viewportHeight,name,tintColor:c#ui.graphics.Color,tintBlendMode:c#ui.graphics.BlendMode,content)85@3806L208:VectorPainter.kt#huu6hf");
        float f6 = (i3 & 4) != 0 ? Float.NaN : f4;
        float f7 = (i3 & 8) != 0 ? Float.NaN : f5;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long jM6004getUnspecified0d7_KjU = (i3 & 32) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : j;
        int iM5906getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.INSTANCE.m5906getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(411310745, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:85)");
        }
        VectorPainter vectorPainterM6736rememberVectorPaintervIP8VLU = m6736rememberVectorPaintervIP8VLU(f2, f3, f6, f7, str2, jM6004getUnspecified0d7_KjU, iM5906getSrcIn0nO6VwU, false, function4, composer, (i2 & 14) | 12582912 | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainterM6736rememberVectorPaintervIP8VLU;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0168  */
    /* JADX INFO: renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.graphics.vector.VectorPainter m6736rememberVectorPaintervIP8VLU(float r17, float r18, float r19, float r20, java.lang.String r21, long r22, int r24, boolean r25, final kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.m6736rememberVectorPaintervIP8VLU(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1413834416, "C(rememberVectorPainter)N(image)170@7434L7,172@7518L188:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:169)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        float genId = imageVector.getGenId();
        float density2 = density.getDensity();
        long jFloatToRawIntBits = Float.floatToRawIntBits(genId);
        long jFloatToRawIntBits2 = ((long) Float.floatToRawIntBits(density2)) & 4294967295L;
        ComposerKt.sourceInformationMarkerStart(composer, 1485214124, "CC(remember):VectorPainter.kt#9igjgp");
        boolean zChanged = composer.changed(jFloatToRawIntBits2 | (jFloatToRawIntBits << 32));
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            GroupComponent groupComponent = new GroupComponent();
            createGroupComponent(groupComponent, imageVector.getRoot());
            Unit unit = Unit.INSTANCE;
            objRememberedValue = createVectorPainterFromImageVector(density, imageVector, groupComponent);
            composer.updateRememberedValue(objRememberedValue);
        }
        VectorPainter vectorPainter = (VectorPainter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return vectorPainter;
    }

    /* JADX INFO: renamed from: obtainSizePx-VpY3zN4, reason: not valid java name */
    private static final long m6733obtainSizePxVpY3zN4(Density density, float f2, float f3) {
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(f2);
        float fMo488toPx0680j_42 = density.mo488toPx0680j_4(f3);
        return Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fMo488toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo488toPx0680j_42)) & 4294967295L));
    }

    /* JADX INFO: renamed from: obtainViewportSize-Pq9zytI, reason: not valid java name */
    private static final long m6734obtainViewportSizePq9zytI(long j, float f2, float f3) {
        if (Float.isNaN(f2)) {
            f2 = Float.intBitsToFloat((int) (j >> 32));
        }
        if (Float.isNaN(f3)) {
            f3 = Float.intBitsToFloat((int) (j & 4294967295L));
        }
        return Size.m5783constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L));
    }

    /* JADX INFO: renamed from: createColorFilter-xETnrds, reason: not valid java name */
    private static final ColorFilter m6732createColorFilterxETnrds(long j, int i) {
        if (j != 16) {
            return ColorFilter.INSTANCE.m6012tintxETnrds(j, i);
        }
        return null;
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8$default, reason: not valid java name */
    public static /* synthetic */ VectorPainter m6731configureVectorPainterT4PVSW8$default(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str = RootGroupName;
        }
        return m6730configureVectorPainterT4PVSW8(vectorPainter, j, j2, str, colorFilter, (i & 16) != 0 ? false : z);
    }

    /* JADX INFO: renamed from: configureVectorPainter-T4PVSW8, reason: not valid java name */
    public static final VectorPainter m6730configureVectorPainterT4PVSW8(VectorPainter vectorPainter, long j, long j2, String str, ColorFilter colorFilter, boolean z) {
        vectorPainter.m6728setSizeuvyYCjk$ui(j);
        vectorPainter.setAutoMirror$ui(z);
        vectorPainter.setIntrinsicColorFilter$ui(colorFilter);
        vectorPainter.m6729setViewportSizeuvyYCjk$ui(j2);
        vectorPainter.setName$ui(str);
        return vectorPainter;
    }

    public static final VectorPainter createVectorPainterFromImageVector(Density density, ImageVector imageVector, GroupComponent groupComponent) {
        long jM6733obtainSizePxVpY3zN4 = m6733obtainSizePxVpY3zN4(density, imageVector.getDefaultWidth(), imageVector.getDefaultHeight());
        return m6730configureVectorPainterT4PVSW8(new VectorPainter(groupComponent), jM6733obtainSizePxVpY3zN4, m6734obtainViewportSizePq9zytI(jM6733obtainSizePxVpY3zN4, imageVector.getViewportWidth(), imageVector.getViewportHeight()), imageVector.getName(), m6732createColorFilterxETnrds(imageVector.getTintColor(), imageVector.getTintBlendMode()), imageVector.getAutoMirror());
    }

    public static final GroupComponent createGroupComponent(GroupComponent groupComponent, VectorGroup vectorGroup) {
        int size = vectorGroup.getSize();
        for (int i = 0; i < size; i++) {
            VectorNode vectorNode = vectorGroup.get(i);
            if (vectorNode instanceof VectorPath) {
                PathComponent pathComponent = new PathComponent();
                VectorPath vectorPath = (VectorPath) vectorNode;
                pathComponent.setPathData(vectorPath.getPathData());
                pathComponent.m6713setPathFillTypeoQ8Xj4U(vectorPath.getPathFillType());
                pathComponent.setName(vectorPath.getName());
                pathComponent.setFill(vectorPath.getFill());
                pathComponent.setFillAlpha(vectorPath.getFillAlpha());
                pathComponent.setStroke(vectorPath.getStroke());
                pathComponent.setStrokeAlpha(vectorPath.getStrokeAlpha());
                pathComponent.setStrokeLineWidth(vectorPath.getStrokeLineWidth());
                pathComponent.m6714setStrokeLineCapBeK7IIE(vectorPath.getStrokeLineCap());
                pathComponent.m6715setStrokeLineJoinWw9F2mQ(vectorPath.getStrokeLineJoin());
                pathComponent.setStrokeLineMiter(vectorPath.getStrokeLineMiter());
                pathComponent.setTrimPathStart(vectorPath.getTrimPathStart());
                pathComponent.setTrimPathEnd(vectorPath.getTrimPathEnd());
                pathComponent.setTrimPathOffset(vectorPath.getTrimPathOffset());
                groupComponent.insertAt(i, pathComponent);
            } else if (vectorNode instanceof VectorGroup) {
                GroupComponent groupComponent2 = new GroupComponent();
                VectorGroup vectorGroup2 = (VectorGroup) vectorNode;
                groupComponent2.setName(vectorGroup2.getName());
                groupComponent2.setRotation(vectorGroup2.getRotation());
                groupComponent2.setScaleX(vectorGroup2.getScaleX());
                groupComponent2.setScaleY(vectorGroup2.getScaleY());
                groupComponent2.setTranslationX(vectorGroup2.getTranslationX());
                groupComponent2.setTranslationY(vectorGroup2.getTranslationY());
                groupComponent2.setPivotX(vectorGroup2.getPivotX());
                groupComponent2.setPivotY(vectorGroup2.getPivotY());
                groupComponent2.setClipPathData(vectorGroup2.getClipPathData());
                createGroupComponent(groupComponent2, vectorGroup2);
                groupComponent.insertAt(i, groupComponent2);
            }
        }
        return groupComponent;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RenderVectorGroup(final androidx.compose.ui.graphics.vector.VectorGroup r23, java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long jMo6548getCenterF1C5BW0 = drawScope.mo6548getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6477scale0AR0LA0(-1.0f, 1.0f, jMo6548getCenterF1C5BW0);
            function1.invoke(drawScope);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }
}
