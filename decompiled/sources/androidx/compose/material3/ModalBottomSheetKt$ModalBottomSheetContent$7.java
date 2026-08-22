package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ModalBottomSheetKt$ModalBottomSheetContent$7 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function2<Composer, Integer, WindowInsets> $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ SheetState $sheetState;

    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetKt$ModalBottomSheetContent$7(Function2<? super Composer, ? super Integer, ? extends WindowInsets> function2, Animatable<Float, AnimationVector1D> animatable, SheetState sheetState, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0, CoroutineScope coroutineScope, boolean z) {
        this.$contentWindowInsets = function2;
        this.$predictiveBackProgress = animatable;
        this.$sheetState = sheetState;
        this.$dragHandle = function22;
        this.$content = function3;
        this.$animateToDismiss = function0;
        this.$scope = coroutineScope;
        this.$sheetGesturesEnabled = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C361@17198L21,362@17252L586,359@17117L4277:ModalBottomSheet.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(728743275, i, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:359)");
        }
        Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), this.$contentWindowInsets.invoke(composer, 0));
        ComposerKt.sourceInformationMarkerStart(composer, 242623253, "CC(remember):ModalBottomSheet.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(this.$predictiveBackProgress);
        final Animatable<Float, AnimationVector1D> animatable = this.$predictiveBackProgress;
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$7$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt$ModalBottomSheetContent$7.invoke$lambda$1$lambda$0(animatable, (GraphicsLayerScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierVerticalScaleDown = BottomSheetScaffoldKt.verticalScaleDown(GraphicsLayerModifierKt.graphicsLayer(modifierWindowInsetsPadding, (Function1) objRememberedValue), this.$sheetState);
        Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
        SheetState sheetState = this.$sheetState;
        Function0<Unit> function0 = this.$animateToDismiss;
        CoroutineScope coroutineScope = this.$scope;
        boolean z = this.$sheetGesturesEnabled;
        ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScaleDown);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1352912384, "C432@21375L9:ModalBottomSheet.kt#uh7d8r");
        if (function2 != null) {
            composer.startReplaceGroup(1352934765);
            ComposerKt.sourceInformation(composer, "379@18206L54,380@18302L48,381@18391L47,382@18477L2871,382@18455L2893");
            Strings.Companion companion = Strings.INSTANCE;
            String strM4145getString2EP1pXo = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            String strM4145getString2EP1pXo2 = Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer, 0);
            Strings.Companion companion3 = Strings.INSTANCE;
            SheetDefaultsKt.DragHandleWithTooltip(columnScopeInstance, ComposableLambdaKt.rememberComposableLambda(2000500644, true, new ModalBottomSheetKt$ModalBottomSheetContent$7$2$1(sheetState, function0, coroutineScope, z, strM4145getString2EP1pXo2, Strings_androidKt.m4145getString2EP1pXo(Strings.m4066constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer, 0), strM4145getString2EP1pXo, function2), composer, 54), composer, 54);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1356009965);
            composer.endReplaceGroup();
        }
        function3.invoke(columnScopeInstance, composer, 6);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        float fCalculatePredictiveBackScaleX = ModalBottomSheetKt.calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue);
        float fCalculatePredictiveBackScaleY = ModalBottomSheetKt.calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue);
        graphicsLayerScope.setScaleY(fCalculatePredictiveBackScaleY == 0.0f ? 1.0f : fCalculatePredictiveBackScaleX / fCalculatePredictiveBackScaleY);
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(ModalBottomSheetKt.PredictiveBackChildTransformOrigin);
        return Unit.INSTANCE;
    }
}
