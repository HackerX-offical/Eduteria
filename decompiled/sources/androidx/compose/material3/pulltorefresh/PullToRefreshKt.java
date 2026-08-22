package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.exoplayer.RendererCapabilities;
import com.canhub.cropper.CropImageOptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: compiled from: PullToRefresh.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001a\u001a\b\u0010\u001b\u001a\u00020\tH\u0007\u001a\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0004\b!\u0010\"\u001a;\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b,\u0010-\u001a\u0010\u0010.\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020&H\u0002\u001aC\u0010/\u001a\u00020\u0001*\u00020$2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0016H\u0002¢\u0006\u0004\b3\u00104\"\u000e\u00105\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00106\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u00108\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0016\u00109\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b:\u0010;\"\u0016\u0010<\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b=\u0010;\"\u0010\u0010>\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u0010?\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u000e\u0010@\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010A\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010B\u001a\u00020&X\u0082T¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010D\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"PullToRefreshBox", "", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "pullToRefresh", StreamManagement.Enabled.ELEMENT, "threshold", "Landroidx/compose/ui/unit/Dp;", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "CircularArrowProgressIndicator", "progress", "Landroidx/compose/material3/internal/FloatProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Landroidx/compose/material3/internal/FloatProducer;JLandroidx/compose/runtime/Composer;I)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alpha", "", "values", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "arcBounds", "Landroidx/compose/ui/geometry/Rect;", "strokeWidth", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "ArrowValues", "drawArrow", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "MaxProgressArc", "StrokeWidth", "F", "ArcRadius", "SpinnerSize", "getSpinnerSize", "()F", "SpinnerContainerSize", "getSpinnerContainerSize", "ArrowWidth", "ArrowHeight", "MinAlpha", "MaxAlpha", "DragMultiplier", "material3", "targetAlpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PullToRefreshKt {
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float StrokeWidth = Dp.m8830constructorimpl((float) 2.5d);
    private static final float ArcRadius = Dp.m8830constructorimpl((float) 5.5d);
    private static final float SpinnerSize = Dp.m8830constructorimpl(16);
    private static final float SpinnerContainerSize = Dp.m8830constructorimpl(40);
    private static final float ArrowWidth = Dp.m8830constructorimpl(10);
    private static final float ArrowHeight = Dp.m8830constructorimpl(5);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$14(FloatProducer floatProducer, long j, int i, Composer composer, int i2) {
        m4167CircularArrowProgressIndicatorRPmYEkk(floatProducer, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshBox$lambda$1(boolean z, Function0 function0, Modifier modifier, PullToRefreshState pullToRefreshState, Alignment alignment, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        PullToRefreshBox(z, function0, modifier, pullToRefreshState, alignment, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PullToRefreshBox(final boolean r16, final kotlin.jvm.functions.Function0<kotlin.Unit> r17, androidx.compose.ui.Modifier r18, androidx.compose.material3.pulltorefresh.PullToRefreshState r19, androidx.compose.ui.Alignment r20, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshKt.PullToRefreshBox(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4172pullToRefreshZ4HSEVQ$default(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f2, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            f2 = PullToRefreshDefaults.INSTANCE.m4163getPositionalThresholdD9Ej5fM();
        }
        return m4171pullToRefreshZ4HSEVQ(modifier, z, pullToRefreshState, z3, f2, function0);
    }

    /* JADX INFO: renamed from: pullToRefresh-Z4HSEVQ, reason: not valid java name */
    public static final Modifier m4171pullToRefreshZ4HSEVQ(Modifier modifier, boolean z, PullToRefreshState pullToRefreshState, boolean z2, float f2, Function0<Unit> function0) {
        return modifier.then(new PullToRefreshElement(z, function0, z2, pullToRefreshState, f2, null));
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 318623070, "C(rememberPullToRefreshState)586@22650L28,586@22595L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(318623070, i, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:585)");
        }
        Object[] objArr = new Object[0];
        Saver<PullToRefreshStateImpl, Float> saver = PullToRefreshStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 1254096538, "CC(remember):PullToRefresh.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PullToRefreshKt.rememberPullToRefreshState$lambda$3$lambda$2();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        PullToRefreshStateImpl pullToRefreshStateImpl = (PullToRefreshStateImpl) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pullToRefreshStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PullToRefreshStateImpl rememberPullToRefreshState$lambda$3$lambda$2() {
        return new PullToRefreshStateImpl();
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: CircularArrowProgressIndicator-RPmYEkk, reason: not valid java name */
    public static final void m4167CircularArrowProgressIndicatorRPmYEkk(final FloatProducer floatProducer, final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1353562852);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowProgressIndicator)N(progress,color:c#ui.graphics.Color)632@23995L61,634@24157L76,639@24460L7,637@24335L143,644@24553L175,650@24770L443,642@24484L729:PullToRefresh.kt#djiw08");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(floatProducer) : composerStartRestartGroup.changedInstance(floatProducer) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353562852, i2, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:631)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601193529, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Object obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Path Path = AndroidPath_androidKt.Path();
                Path.mo5858setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m6266getEvenOddRgk1Os());
                composerStartRestartGroup.updateRememberedValue(Path);
                obj = Path;
            }
            final Path path = (Path) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601198728, "CC(remember):PullToRefresh.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$7$lambda$6(floatProducer));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowProgressIndicator_RPmYEkk$lambda$8((State) objRememberedValue2), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601211499, "CC(remember):PullToRefresh.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$10$lambda$9(floatProducer, (SemanticsPropertyReceiver) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM1221size3ABfNKs = SizeKt.m1221size3ABfNKs(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue3), SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 601218711, "CC(remember):PullToRefresh.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateAnimateFloatAsState) | (i3 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(floatProducer))) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(path);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$13$lambda$12(floatProducer, stateAnimateFloatAsState, j, path, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue4 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierM1221size3ABfNKs, (Function1) objRememberedValue4, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.pulltorefresh.PullToRefreshKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$14(floatProducer, j, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularArrowProgressIndicator_RPmYEkk$lambda$7$lambda$6(FloatProducer floatProducer) {
        if (floatProducer.invoke() >= 1.0f) {
            return 1.0f;
        }
        return MinAlpha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$10$lambda$9(FloatProducer floatProducer, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (floatProducer.invoke() > 0.0f) {
            SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(floatProducer.invoke(), RangesKt.rangeTo(0.0f, 1.0f), 0));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$13$lambda$12(FloatProducer floatProducer, State state, long j, Path path, DrawScope drawScope) {
        ArrowValues ArrowValues = ArrowValues(floatProducer.invoke());
        float fFloatValue = ((Number) state.getValue()).floatValue();
        float rotation = ArrowValues.getRotation();
        long jMo6548getCenterF1C5BW0 = drawScope.mo6548getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(rotation, jMo6548getCenterF1C5BW0);
            float f2 = drawScope.mo488toPx0680j_4(ArcRadius);
            float f3 = StrokeWidth;
            Rect rectM5762Rect3MmeM6k = RectKt.m5762Rect3MmeM6k(androidx.compose.ui.geometry.SizeKt.m5802getCenteruvyYCjk(drawScope.mo6549getSizeNHjbRc()), f2 + (drawScope.mo488toPx0680j_4(f3) / 2.0f));
            m4170drawCircularIndicatorKzyDr3Q(drawScope, j, fFloatValue, ArrowValues, rectM5762Rect3MmeM6k, f3);
            m4169drawArrowuDrxG_w(drawScope, path, rectM5762Rect3MmeM6k, j, fFloatValue, ArrowValues, f3);
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX INFO: renamed from: drawCircularIndicator-KzyDr3Q, reason: not valid java name */
    private static final void m4170drawCircularIndicatorKzyDr3Q(DrawScope drawScope, long j, float f2, ArrowValues arrowValues, Rect rect, float f3) {
        DrawScope.m6528drawArcyD3GUKo$default(drawScope, j, arrowValues.getStartAngle(), arrowValues.getEndAngle() - arrowValues.getStartAngle(), false, rect.m5758getTopLeftF1C5BW0(), rect.m5756getSizeNHjbRc(), f2, new Stroke(drawScope.mo488toPx0680j_4(f3), 0.0f, StrokeCap.INSTANCE.m6344getButtKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
    }

    private static final ArrowValues ArrowValues(float f2) {
        float fMax = (Math.max(Math.min(1.0f, f2) - 0.4f, 0.0f) * 5) / 3;
        float fCoerceIn = RangesKt.coerceIn(Math.abs(f2) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fCoerceIn - (((float) Math.pow(fCoerceIn, 2)) / 4))) * 0.5f;
        float f3 = CropImageOptionsKt.DEGREES_360;
        return new ArrowValues(fPow, fPow * f3, ((0.8f * fMax) + fPow) * f3, Math.min(1.0f, fMax));
    }

    /* JADX INFO: renamed from: drawArrow-uDrxG_w, reason: not valid java name */
    private static final void m4169drawArrowuDrxG_w(DrawScope drawScope, Path path, Rect rect, long j, float f2, ArrowValues arrowValues, float f3) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f4 = ArrowWidth;
        path.lineTo((drawScope.mo488toPx0680j_4(f4) * arrowValues.getScale()) / 2, drawScope.mo488toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.lineTo(drawScope.mo488toPx0680j_4(f4) * arrowValues.getScale(), 0.0f);
        float fMin = ((Math.min(rect.getRight() - rect.getLeft(), rect.getBottom() - rect.getTop()) / 2.0f) + Float.intBitsToFloat((int) (rect.m5753getCenterF1C5BW0() >> 32))) - ((drawScope.mo488toPx0680j_4(f4) * arrowValues.getScale()) / 2.0f);
        path.mo5860translatek4lQ0M(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (rect.m5753getCenterF1C5BW0() & 4294967295L)) - drawScope.mo488toPx0680j_4(f3))) & 4294967295L) | (Float.floatToRawIntBits(fMin) << 32)));
        float endAngle = arrowValues.getEndAngle() - drawScope.mo488toPx0680j_4(f3);
        long jMo6548getCenterF1C5BW0 = drawScope.mo6548getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(endAngle, jMo6548getCenterF1C5BW0);
            DrawScope.m6539drawPathLG529CI$default(drawScope, path, j, f2, new Stroke(drawScope.mo488toPx0680j_4(f3), 0.0f, 0, 0, null, 30, null), null, 0, 48, null);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
        }
    }

    public static final float getSpinnerSize() {
        return SpinnerSize;
    }

    public static final float getSpinnerContainerSize() {
        return SpinnerContainerSize;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$8(State<Float> state) {
        return state.getValue().floatValue();
    }
}
