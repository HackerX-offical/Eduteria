package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import androidx.media3.exoplayer.RendererCapabilities;
import com.clevertap.android.sdk.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidSelectionHandles.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u0016\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000\u001a0\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b H\u0001¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"SelectionHandle", "", "offsetProvider", "Landroidx/compose/foundation/text/selection/OffsetProvider;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "minTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "lineHeight", "", "modifier", "Landroidx/compose/ui/Modifier;", "SelectionHandle-wLIcFTc", "(Landroidx/compose/foundation/text/selection/OffsetProvider;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZJFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectionHandleIcon", "iconVisible", "Lkotlin/Function0;", "isLeft", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "drawSelectionHandle", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", Constants.KEY_RADIUS, "HandlePopup", "positionProvider", "handleReferencePoint", "Landroidx/compose/ui/Alignment;", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/OffsetProvider;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidSelectionHandles_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandlePopup$lambda$1(OffsetProvider offsetProvider, Alignment alignment, Function2 function2, int i, Composer composer, int i2) {
        HandlePopup(offsetProvider, alignment, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionHandleIcon$lambda$0(Modifier modifier, Function0 function0, boolean z, int i, Composer composer, int i2) {
        SelectionHandleIcon(modifier, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionHandle_wLIcFTc$lambda$2(OffsetProvider offsetProvider, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, long j, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m2271SelectionHandlewLIcFTc(offsetProvider, z, resolvedTextDirection, z2, j, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016e  */
    /* JADX INFO: renamed from: SelectionHandle-wLIcFTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2271SelectionHandlewLIcFTc(final androidx.compose.foundation.text.selection.OffsetProvider r18, final boolean r19, final androidx.compose.ui.text.style.ResolvedTextDirection r20, final boolean r21, long r22, final float r24, final androidx.compose.ui.Modifier r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m2271SelectionHandlewLIcFTc(androidx.compose.foundation.text.selection.OffsetProvider, boolean, androidx.compose.ui.text.style.ResolvedTextDirection, boolean, long, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionHandle_wLIcFTc$lambda$0$0(OffsetProvider offsetProvider, boolean z, boolean z2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        long jMo1654provideF1C5BW0 = offsetProvider.mo1654provideF1C5BW0();
        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(z ? Handle.SelectionStart : Handle.SelectionEnd, jMo1654provideF1C5BW0, z2 ? SelectionHandleAnchor.Left : SelectionHandleAnchor.Right, (9223372034707292159L & jMo1654provideF1C5BW0) != InlineClassHelperKt.UnspecifiedPackedFloats, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionHandle_wLIcFTc$lambda$1(ViewConfiguration viewConfiguration, final long j, final boolean z, final Modifier modifier, final OffsetProvider offsetProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@3764L1254,85@3688L1330:AndroidSelectionHandles.android.kt#eksfi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1365123137, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:85)");
            }
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalViewConfiguration().provides(viewConfiguration), ComposableLambdaKt.rememberComposableLambda(1260045569, true, new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0(j, z, modifier, offsetProvider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SelectionHandle_wLIcFTc$lambda$1$0$0$0$0(OffsetProvider offsetProvider) {
        return (offsetProvider.mo1654provideF1C5BW0() & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SelectionHandle_wLIcFTc$lambda$1$0$1$0(OffsetProvider offsetProvider) {
        return (offsetProvider.mo1654provideF1C5BW0() & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    public static final void SelectionHandleIcon(final Modifier modifier, final Function0<Boolean> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2111672474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionHandleIcon)N(modifier,iconVisible,isLeft)124@5167L89:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2111672474, i2, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:123)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m1223sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), function0, z), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidSelectionHandles_androidKt.SelectionHandleIcon$lambda$0(modifier, function0, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Modifier drawSelectionHandle(Modifier modifier, final Function0<Boolean> function0, final boolean z) {
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0(function0, z, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier drawSelectionHandle$lambda$0(final Function0 function0, final boolean z, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-196777734);
        ComposerKt.sourceInformation(composer, "C129@5425L7,130@5472L678:AndroidSelectionHandles.android.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-196777734, i, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:129)");
        }
        ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localTextSelectionColors);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final long handleColor = ((TextSelectionColors) objConsume).getHandleColor();
        ComposerKt.sourceInformationMarkerStart(composer, -124837472, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
        boolean zChanged = composer.changed(handleColor) | composer.changed(function0) | composer.changed(z);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0$0$0(handleColor, function0, z, (CacheDrawScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierDrawWithCache = DrawModifierKt.drawWithCache(modifier, (Function1) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDrawWithCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawSelectionHandle$lambda$0$0$0(long j, final Function0 function0, final boolean z, CacheDrawScope cacheDrawScope) {
        final ImageBitmap imageBitmapCreateHandleImage = createHandleImage(cacheDrawScope, Float.intBitsToFloat((int) (cacheDrawScope.m5503getSizeNHjbRc() >> 32)) / 2.0f);
        final ColorFilter colorFilterM6009tintxETnrds$default = ColorFilter.Companion.m6009tintxETnrds$default(ColorFilter.INSTANCE, j, 0, 2, null);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidSelectionHandles_androidKt.drawSelectionHandle$lambda$0$0$0$0(function0, z, imageBitmapCreateHandleImage, colorFilterM6009tintxETnrds$default, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawSelectionHandle$lambda$0$0$0$0(Function0 function0, boolean z, ImageBitmap imageBitmap, ColorFilter colorFilter, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (!((Boolean) function0.invoke()).booleanValue()) {
            return Unit.INSTANCE;
        }
        if (z) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            long jMo6548getCenterF1C5BW0 = contentDrawScope2.mo6548getCenterF1C5BW0();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo6477scale0AR0LA0(-1.0f, 1.0f, jMo6548getCenterF1C5BW0);
                DrawScope.m6533drawImagegbVJVH8$default(contentDrawScope2, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            }
        } else {
            DrawScope.m6533drawImagegbVJVH8$default(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
        }
        return Unit.INSTANCE;
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f2) {
        int iCeil = ((int) Math.ceil(f2)) * 2;
        ImageBitmap imageBitmap = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope canvasDrawScope = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap == null || canvas == null || iCeil > imageBitmap.getWidth() || iCeil > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m6206ImageBitmapx__hDU$default(iCeil, iCeil, ImageBitmapConfig.INSTANCE.m6200getAlpha8_sVssgQ(), false, null, 24, null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap);
            canvas = CanvasKt.Canvas(imageBitmap);
            HandleImageCache.INSTANCE.setCanvas(canvas);
        }
        ImageBitmap imageBitmap2 = imageBitmap;
        Canvas canvas2 = canvas;
        if (canvasDrawScope == null) {
            canvasDrawScope = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(canvasDrawScope);
        }
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        long jM5783constructorimpl = Size.m5783constructorimpl((((long) Float.floatToRawIntBits(imageBitmap2.getWidth())) << 32) | (((long) Float.floatToRawIntBits(imageBitmap2.getHeight())) & 4294967295L));
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density density = drawParams.getDensity();
        LayoutDirection layoutDirection2 = drawParams.getLayoutDirection();
        Canvas canvas3 = drawParams.getCanvas();
        long size = drawParams.getSize();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(cacheDrawScope);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas2);
        drawParams2.m6469setSizeuvyYCjk(jM5783constructorimpl);
        canvas2.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        DrawScope.m6543drawRectnJ9OG0$default(canvasDrawScope3, Color.INSTANCE.m5994getBlack0d7_KjU(), 0L, canvasDrawScope3.mo6549getSizeNHjbRc(), 0.0f, null, null, BlendMode.INSTANCE.m5881getClear0nO6VwU(), 58, null);
        DrawScope.m6543drawRectnJ9OG0$default(canvasDrawScope3, ColorKt.Color(4278190080L), Offset.INSTANCE.m5739getZeroF1C5BW0(), Size.m5783constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), 0.0f, null, null, 0, 120, null);
        DrawScope.m6530drawCircleVaOC9Bg$default(canvasDrawScope3, ColorKt.Color(4278190080L), f2, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32)), 0.0f, null, null, 0, 120, null);
        canvas2.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection2);
        drawParams3.setCanvas(canvas3);
        drawParams3.m6469setSizeuvyYCjk(size);
        return imageBitmap2;
    }

    public static final void HandlePopup(final OffsetProvider offsetProvider, final Alignment alignment, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1090171650);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HandlePopup)N(positionProvider,handleReferencePoint,content)221@8864L135,224@9004L190:AndroidSelectionHandles.android.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(offsetProvider) : composerStartRestartGroup.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(alignment) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        boolean z = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1090171650, i2, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:219)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 317070245, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changed(offsetProvider))) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidPopup_androidKt.Popup((HandlePositionProvider) objRememberedValue, null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, composerStartRestartGroup, ((i2 << 3) & 7168) | RendererCapabilities.DECODER_SUPPORT_MASK, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidSelectionHandles_androidKt.HandlePopup$lambda$1(offsetProvider, alignment, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionHandle_wLIcFTc$lambda$1$0(long j, boolean z, Modifier modifier, final OffsetProvider offsetProvider, Composer composer, int i) {
        Arrangement.Horizontal left;
        ComposerKt.sourceInformation(composer, "C:AndroidSelectionHandles.android.kt#eksfi3");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1260045569, i, -1, "androidx.compose.foundation.text.selection.SelectionHandle.<anonymous>.<anonymous> (AndroidSelectionHandles.android.kt:86)");
            }
            if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
                composer.startReplaceGroup(3458246);
                ComposerKt.sourceInformation(composer, "96@4179L576");
                if (z) {
                    left = Arrangement.Absolute.INSTANCE.getRight();
                } else {
                    left = Arrangement.Absolute.INSTANCE.getLeft();
                }
                Modifier modifierM1217requiredSizeInqDBjuR0$default = SizeKt.m1217requiredSizeInqDBjuR0$default(modifier, DpSize.m8928getWidthD9Ej5fM(j), DpSize.m8926getHeightD9Ej5fM(j), 0.0f, 0.0f, 12, null);
                ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(left, Alignment.INSTANCE.getTop(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1217requiredSizeInqDBjuR0$default);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
                Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1665345997, "C106@4633L40,104@4529L208:AndroidSelectionHandles.android.kt#eksfi3");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1439191000, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(offsetProvider);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0$0$0$0(offsetProvider));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SelectionHandleIcon(companion, (Function0) objRememberedValue, z, composer, 6);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(4389176);
                ComposerKt.sourceInformation(composer, "113@4898L40,111@4793L201");
                ComposerKt.sourceInformationMarkerStart(composer, -276949335, "CC(remember):AndroidSelectionHandles.android.kt#9igjgp");
                boolean zChangedInstance2 = composer.changedInstance(offsetProvider);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(AndroidSelectionHandles_androidKt.SelectionHandle_wLIcFTc$lambda$1$0$1$0(offsetProvider));
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SelectionHandleIcon(modifier, (Function0) objRememberedValue2, z, composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
