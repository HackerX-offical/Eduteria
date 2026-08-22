package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aú\u0001\u0010!\u001a\u00020\u0001*\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0001¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a\u0014\u00103\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a-\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u000b2\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u00108\u001a5\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0003¢\u0006\u0004\b=\u0010>\"\u0010\u0010?\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006E²\u0006\n\u0010F\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", JivePropertiesExtension.ELEMENT, "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", "visible", "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetKt {
    private static final float PredictiveBackMaxScaleXDistance = Dp.m8830constructorimpl(48);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m8830constructorimpl(24);
    private static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope boxScope, Animatable animatable, CoroutineScope coroutineScope, Function0 function0, Function1 function1, Modifier modifier, SheetState sheetState, float f2, boolean z, Shape shape, long j, long j2, float f3, Function2 function2, Function2 function22, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3109ModalBottomSheetContent7e2Q(boxScope, animatable, coroutineScope, function0, function1, modifier, sheetState, f2, z, shape, j, j2, f3, function2, function22, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$13(Function0 function0, Modifier modifier, SheetState sheetState, float f2, boolean z, Shape shape, long j, long j2, float f3, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3107ModalBottomSheetYbuCTN8(function0, modifier, sheetState, f2, z, shape, j, j2, f3, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_dYc4hso$lambda$14(Function0 function0, Modifier modifier, SheetState sheetState, float f2, Shape shape, long j, long j2, float f3, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3108ModalBottomSheetdYc4hso(function0, modifier, sheetState, f2, shape, j, j2, f3, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$34(long j, Function0 function0, boolean z, boolean z2, int i, Composer composer, int i2) {
        m3110ScrimKTwxG1Y(j, function0, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberModalBottomSheetState$lambda$26$lambda$25(SheetValue sheetValue) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3107ModalBottomSheetYbuCTN8(final kotlin.jvm.functions.Function0<kotlin.Unit> r48, androidx.compose.ui.Modifier r49, androidx.compose.material3.SheetState r50, float r51, boolean r52, androidx.compose.ui.graphics.Shape r53, long r54, long r56, float r58, long r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets> r62, androidx.compose.material3.ModalBottomSheetProperties r63, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.runtime.Composer r65, final int r66, final int r67, final int r68) {
        /*
            Method dump skipped, instruction units count: 1379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.m3107ModalBottomSheetYbuCTN8(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, boolean, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(final SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        if (sheetState.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(sheetState, function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope coroutineScope, final SheetState sheetState, final Function0 function0, float f2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(sheetState, f2, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(sheetState, function0, (Throwable) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState sheetState, CoroutineScope coroutineScope, Animatable animatable, final Function0 function0) {
        if (sheetState.getCurrentValue() != SheetValue.Expanded || !sheetState.getHasPartiallyExpandedState()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(sheetState, null), 3, null).invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(function0, (Throwable) obj);
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(animatable, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for Binary compatibility. Use overload with sheetGesturesEnabled param.")
    /* JADX INFO: renamed from: ModalBottomSheet-dYc4hso, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3108ModalBottomSheetdYc4hso(final kotlin.jvm.functions.Function0 r30, androidx.compose.ui.Modifier r31, androidx.compose.material3.SheetState r32, float r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, float r39, long r40, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function2 r43, androidx.compose.material3.ModalBottomSheetProperties r44, final kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.m3108ModalBottomSheetdYc4hso(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /* JADX INFO: renamed from: ModalBottomSheetContent-7---e2Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3109ModalBottomSheetContent7e2Q(final androidx.compose.foundation.layout.BoxScope r46, final androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r47, final kotlinx.coroutines.CoroutineScope r48, final kotlin.jvm.functions.Function0<kotlin.Unit> r49, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r50, androidx.compose.ui.Modifier r51, androidx.compose.material3.SheetState r52, float r53, boolean r54, androidx.compose.ui.graphics.Shape r55, long r56, long r58, float r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets> r62, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, androidx.compose.runtime.Composer r64, final int r65, final int r66, final int r67) {
        /*
            Method dump skipped, instruction units count: 1431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheetKt.m3109ModalBottomSheetContent7e2Q(androidx.compose.foundation.layout.BoxScope, androidx.compose.animation.core.Animatable, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(final SheetState sheetState, final IntSize intSize, Constraints constraints) {
        SheetValue sheetValue;
        final float fM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(constraints.getValue());
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(fM8782getMaxHeightimpl, intSize, sheetState, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3().getTargetValue().ordinal()];
        if (i == 1) {
            sheetValue = SheetValue.Hidden;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
            sheetValue = SheetValue.PartiallyExpanded;
        } else {
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, sheetValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(float f2, IntSize intSize, SheetState sheetState, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SheetValue.Hidden, f2);
        if (((int) (intSize.m9005unboximpl() & 4294967295L)) > f2 / 2 && !sheetState.getSkipPartiallyExpanded()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f2 / 2.0f);
        }
        if (((int) (intSize.m9005unboximpl() & 4294967295L)) != 0) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, f2 - ((int) (intSize.m9005unboximpl() & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 0.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState sheetState, Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (!Float.isNaN(offset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (offset + fIntBitsToFloat) / fIntBitsToFloat));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo488toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f2) / fIntBitsToFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo488toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f2) / fIntBitsToFloat);
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)500@23719L8,502@23737L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -573963974, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$26$lambda$25((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:502)");
        }
        SheetState sheetStateM3415rememberSheetStateAGcomas = SheetDefaultsKt.m3415rememberSheetStateAGcomas(z2, function12, SheetValue.Hidden, false, 0.0f, 0.0f, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i & 112), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return sheetStateM3415rememberSheetStateAGcomas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-KTwxG1Y, reason: not valid java name */
    public static final void m3110ScrimKTwxG1Y(final long j, final Function0<Unit> function0, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        int i3;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-391613911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible,dismissEnabled):ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391613911, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:514)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-1438582326);
                ComposerKt.sourceInformation(composerStartRestartGroup, "520@24316L7,518@24171L167,522@24364L29,537@24994L79,537@24944L129");
                int i4 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                Strings.Companion companion = Strings.INSTANCE;
                final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(androidx.compose.ui.R.string.close_sheet), composerStartRestartGroup, 0);
                if (z2) {
                    composerStartRestartGroup.startReplaceGroup(-1438283579);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "525@24511L44,526@24612L263");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616173205, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i5 = i4 & 112;
                    boolean z3 = i5 == 32;
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (PointerInputEventHandler) new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616176656, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM4145getString2EP1pXo) | (i5 == 32);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30(strM4145getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 = 1;
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i3 = 1;
                    composerStartRestartGroup.startReplaceGroup(-1437857391);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1616188696, "CC(remember):ModalBottomSheet.kt#9igjgp");
                int i6 = (composerStartRestartGroup.changed(stateAnimateFloatAsState) ? 1 : 0) | ((i4 & 14) == 4 ? i3 : 0);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (i6 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$33$lambda$32(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1437676103);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$34(j, function0, z, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$31$lambda$30(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_KTwxG1Y$lambda$33$lambda$32(long j, State state, DrawScope drawScope) {
        DrawScope.m6543drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_KTwxG1Y$lambda$27(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final float Scrim_KTwxG1Y$lambda$27(State<Float> state) {
        return state.getValue().floatValue();
    }
}
