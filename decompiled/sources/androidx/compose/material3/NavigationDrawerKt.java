package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import com.clevertap.android.sdk.Constants;
import cz.msebera.android.httpclient.HttpStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a]\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001aq\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(\u001ai\u0010)\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001aq\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001ai\u0010,\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001a{\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00101\u001a\u0002022\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a$\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010:\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010;\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0014\u0010<\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0014\u0010>\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a.\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001a\u008e\u0001\u0010A\u001a\u00020\t2\u0011\u0010B\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\u0006\u0010C\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001a\u00020\u001c2\b\b\u0002\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001a \u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002\u001a;\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000e\u0010X\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b]\u0010^\"\u0016\u0010_\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b`\u0010^\"\u0016\u0010a\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bb\u0010^\"\u0014\u0010c\u001a\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "content", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", "a", "b", Constants.INAPP_POSITION, "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.m8830constructorimpl(HttpStatus.SC_BAD_REQUEST);
    private static final float MinimumDrawerWidth = Dp.m8830constructorimpl(240);
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m8830constructorimpl(12);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m8830constructorimpl(24);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m8830constructorimpl(48);
    private static final TweenSpec<Float> AnchoredDraggableDefaultAnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3163DismissibleDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier modifier, Shape shape, long j, long j2, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3164DismissibleDrawerSheetafqeVBk(modifier, shape, j, j2, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$39(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, Function2 function22, int i, int i2, Composer composer, int i3) {
        DismissibleNavigationDrawer(function2, modifier, drawerState, z, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerPredictiveBackHandler$lambda$62(DrawerState drawerState, Function3 function3, int i, Composer composer, int i2) {
        DrawerPredictiveBackHandler(drawerState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DrawerSheet_cm3T3N0$lambda$51$lambda$50() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState drawerPredictiveBackState, WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f2, FloatProducer floatProducer, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3165DrawerSheetcm3T3N0(drawerPredictiveBackState, windowInsets, modifier, shape, j, j2, f2, floatProducer, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3166ModalDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawerSheet_afqeVBk$lambda$43(Modifier modifier, Shape shape, long j, long j2, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3167ModalDrawerSheetafqeVBk(modifier, shape, j, j2, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$25(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, long j, Function2 function22, int i, int i2, Composer composer, int i3) {
        m3168ModalNavigationDrawerFHprtrg(function2, modifier, drawerState, z, j, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationDrawerItem$lambda$65(Function2 function2, boolean z, Function0 function0, Modifier modifier, Function2 function22, Function2 function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationDrawerItem(function2, z, function0, modifier, function22, function23, shape, navigationDrawerItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$49(Modifier modifier, Shape shape, long j, long j2, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3169PermanentDrawerSheetafqeVBk(modifier, shape, j, j2, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentNavigationDrawer$lambda$42(Function2 function2, Modifier modifier, Function2 function22, int i, int i2, Composer composer, int i3) {
        PermanentNavigationDrawer(function2, modifier, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$72(boolean z, Function0 function0, Function0 function02, long j, int i, Composer composer, int i2) {
        m3170ScrimBx497Mc(z, function0, function02, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue drawerValue) {
        return true;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2098699222, "C(rememberDrawerState)N(initialValue,confirmStateChange)304@12444L8,306@12546L61,306@12482L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1784672962, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavigationDrawerKt.rememberDrawerState$lambda$1$lambda$0((DrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:305)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1784669645, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed(drawerValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavigationDrawerKt.rememberDrawerState$lambda$3$lambda$2(drawerValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue drawerValue, Function1 function1) {
        return new DrawerState(drawerValue, function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04ff  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c4  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3168ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.material3.DrawerState r31, boolean r32, long r33, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 1582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3168ModalNavigationDrawerFHprtrg(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        drawerState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        if (z && drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1(drawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$24$lambda$16$lambda$15(float f2, DrawerState drawerState, MutableFloatState mutableFloatState) {
        return calculateFraction(ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState), f2, drawerState.requireOffset$material3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState drawerState, Density density) {
        int iRoundToInt;
        float currentOffset = drawerState.getCurrentOffset();
        if (Float.isNaN(currentOffset)) {
            iRoundToInt = drawerState.isOpen() ? 0 : -density.mo482roundToPx0680j_4(DrawerDefaults.INSTANCE.m2862getMaximumDrawerWidthD9Ej5fM());
        } else {
            iRoundToInt = MathKt.roundToInt(currentOffset);
        }
        return IntOffset.m8949boximpl(IntOffset.m8952constructorimpl((((long) iRoundToInt) << 32) | (((long) 0) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1(drawerState, null), 3, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DismissibleNavigationDrawer(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.ui.Modifier r27, androidx.compose.material3.DrawerState r28, boolean r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 1400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.DismissibleNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material3.DrawerState, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$27(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DismissibleNavigationDrawer$lambda$28(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1(drawerState, null), 3, null);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PermanentNavigationDrawer(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r16, androidx.compose.ui.Modifier r17, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.PermanentNavigationDrawer(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3167ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3167ModalDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0108  */
    /* JADX INFO: renamed from: ModalDrawerSheet-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3166ModalDrawerSheetSnr_uVM(final androidx.compose.material3.DrawerState r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.graphics.Shape r20, long r21, long r23, float r25, androidx.compose.foundation.layout.WindowInsets r26, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3166ModalDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ec  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3164DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3164DismissibleDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0107  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3163DismissibleDrawerSheetSnr_uVM(final androidx.compose.material3.DrawerState r18, androidx.compose.ui.Modifier r19, androidx.compose.ui.graphics.Shape r20, long r21, long r23, float r25, androidx.compose.foundation.layout.WindowInsets r26, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3163DismissibleDrawerSheetSnr_uVM(androidx.compose.material3.DrawerState, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ed  */
    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3169PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, float r31, androidx.compose.foundation.layout.WindowInsets r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3169PermanentDrawerSheetafqeVBk(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX INFO: renamed from: DrawerSheet-cm3T3N0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3165DrawerSheetcm3T3N0(final androidx.compose.material3.DrawerPredictiveBackState r28, final androidx.compose.foundation.layout.WindowInsets r29, androidx.compose.ui.Modifier r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, float r36, androidx.compose.material3.internal.FloatProducer r37, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.m3165DrawerSheetcm3T3N0(androidx.compose.material3.DrawerPredictiveBackState, androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, float, androidx.compose.material3.internal.FloatProducer, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Modifier horizontalScaleUp(Modifier modifier, final FloatProducer floatProducer, final float f2, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleUp$lambda$54(floatProducer, f2, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalScaleUp$lambda$54(FloatProducer floatProducer, float f2, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? (fInvoke / f2) + 1.0f : 1.0f);
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier horizontalScaleDown(Modifier modifier, final FloatProducer floatProducer, final float f2, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleDown$lambda$55(floatProducer, f2, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalScaleDown$lambda$55(FloatProducer floatProducer, float f2, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? 1 / ((fInvoke / f2) + 1.0f) : 1.0f);
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerContainer$lambda$56(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier predictiveBackDrawerChild(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerChild$lambda$57(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState);
        graphicsLayerScope.setScaleX(fCalculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState) / fCalculatePredictiveBackScaleX);
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return ((drawerPredictiveBackState.getScaleXDistance() * (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() ? 1 : -1)) / fIntBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (drawerPredictiveBackState.getScaleYDistance() / fIntBitsToFloat);
    }

    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        DrawerPredictiveBackState drawerPredictiveBackState;
        int i3;
        String str;
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 navigationDrawerKt$DrawerPredictiveBackHandler$2$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-383087355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerPredictiveBackHandler)N(drawerState,content)942@40202L40,943@40259L24,944@40321L7,948@40483L7,954@40796L1297,954@40744L1349,986@42136L99,986@42099L136,992@42241L34:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i4 = i2;
        if (!composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383087355, i4, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:941)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220245293, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new DrawerPredictiveBackState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DrawerPredictiveBackState drawerPredictiveBackState2 = (DrawerPredictiveBackState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z = objConsume == LayoutDirection.Rtl;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            floatRef.element = density.mo488toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            floatRef2.element = density.mo488toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            floatRef3.element = density.mo488toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean zIsOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220265558, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i5 = i4 & 14;
            boolean zChanged = composerStartRestartGroup.changed(z) | composerStartRestartGroup.changed(floatRef.element) | composerStartRestartGroup.changed(floatRef2.element) | composerStartRestartGroup.changed(floatRef3.element) | composerStartRestartGroup.changedInstance(coroutineScope) | (i5 == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                drawerPredictiveBackState = drawerPredictiveBackState2;
                i3 = i5;
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScope, drawerState, z, floatRef, floatRef2, floatRef3, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$2$1);
            } else {
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                drawerPredictiveBackState = drawerPredictiveBackState2;
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = objRememberedValue3;
                i3 = i5;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.PredictiveBackHandler(zIsOpen, (Function2) navigationDrawerKt$DrawerPredictiveBackHandler$2$1, composerStartRestartGroup, 0, 0);
            Boolean boolValueOf = Boolean.valueOf(drawerState.isClosed());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220307240, str);
            boolean z2 = i3 == 4;
            NavigationDrawerKt$DrawerPredictiveBackHandler$3$1 navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue, composerStartRestartGroup, 0);
            function3.invoke(drawerPredictiveBackState, composerStartRestartGroup, Integer.valueOf((i4 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerPredictiveBackHandler$lambda$62(drawerState, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void NavigationDrawerItem(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, final boolean r33, final kotlin.jvm.functions.Function0<kotlin.Unit> r34, androidx.compose.ui.Modifier r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.ui.graphics.Shape r38, androidx.compose.material3.NavigationDrawerItemColors r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.NavigationDrawerKt.NavigationDrawerItem(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.NavigationDrawerItemColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationDrawerItem$lambda$64$lambda$63(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8032setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8020getTabo7Vup1c());
        return Unit.INSTANCE;
    }

    private static final float calculateFraction(float f2, float f3, float f4) {
        return RangesKt.coerceIn((f4 - f2) / (f3 - f2), 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m3170ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)1285@54138L30,1300@54636L39,1300@54585L90:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1284)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(androidx.compose.ui.R.string.close_drawer), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(598792893);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1288@54256L35,1289@54344L187");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404790366, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z2 = i3 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404793334, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean zChanged = (i3 == 32) | composerStartRestartGroup.changed(strM4145getString2EP1pXo);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68(strM4145getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(599116967);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404802530, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.Scrim_Bx497Mc$lambda$71$lambda$70(j, function02, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.Scrim_Bx497Mc$lambda$72(z, function0, function02, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$69$lambda$68(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$71$lambda$70(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m6543drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function0.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }
}
