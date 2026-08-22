package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
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
final class ModalBottomSheetKt$ModalBottomSheet$4 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $animateToDismiss;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, WindowInsets> $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    final /* synthetic */ ModalBottomSheetProperties $properties;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $sheetGesturesEnabled;
    final /* synthetic */ float $sheetMaxWidth;
    final /* synthetic */ SheetState $sheetState;
    final /* synthetic */ float $tonalElevation;

    /* JADX WARN: Multi-variable type inference failed */
    ModalBottomSheetKt$ModalBottomSheet$4(long j, Function0<Unit> function0, SheetState sheetState, ModalBottomSheetProperties modalBottomSheetProperties, Animatable<Float, AnimationVector1D> animatable, CoroutineScope coroutineScope, Function1<? super Float, Unit> function1, Modifier modifier, float f2, boolean z, Shape shape, long j2, long j3, float f3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        this.$scrimColor = j;
        this.$animateToDismiss = function0;
        this.$sheetState = sheetState;
        this.$properties = modalBottomSheetProperties;
        this.$predictiveBackProgress = animatable;
        this.$scope = coroutineScope;
        this.$settleToDismiss = function1;
        this.$modifier = modifier;
        this.$sheetMaxWidth = f2;
        this.$sheetGesturesEnabled = z;
        this.$shape = shape;
        this.$containerColor = j2;
        this.$contentColor = j3;
        this.$tonalElevation = f3;
        this.$dragHandle = function2;
        this.$contentWindowInsets = function22;
        this.$content = function3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C185@9348L27,185@9287L867:ModalBottomSheet.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010026864, i, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:185)");
        }
        Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
        ComposerKt.sourceInformationMarkerStart(composer, -26790293, "CC(remember):ModalBottomSheet.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt$ModalBottomSheet$4.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierImePadding, false, (Function1) objRememberedValue, 1, null);
        long j = this.$scrimColor;
        Function0<Unit> function0 = this.$animateToDismiss;
        SheetState sheetState = this.$sheetState;
        ModalBottomSheetProperties modalBottomSheetProperties = this.$properties;
        Animatable<Float, AnimationVector1D> animatable = this.$predictiveBackProgress;
        CoroutineScope coroutineScope = this.$scope;
        Function1<Float, Unit> function1 = this.$settleToDismiss;
        Modifier modifier = this.$modifier;
        float f2 = this.$sheetMaxWidth;
        boolean z = this.$sheetGesturesEnabled;
        Shape shape = this.$shape;
        long j2 = this.$containerColor;
        long j3 = this.$contentColor;
        float f3 = this.$tonalElevation;
        Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
        Function2<Composer, Integer, WindowInsets> function22 = this.$contentWindowInsets;
        Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$content;
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 824032392, "C186@9391L242,192@9646L498:ModalBottomSheet.kt#uh7d8r");
        ModalBottomSheetKt.m3110ScrimKTwxG1Y(j, function0, sheetState.getTargetValue() != SheetValue.Hidden, modalBottomSheetProperties.getShouldDismissOnClickOutside(), composer, 0);
        ModalBottomSheetKt.m3109ModalBottomSheetContent7e2Q(boxScopeInstance, animatable, coroutineScope, function0, function1, modifier, sheetState, f2, z, shape, j2, j3, f3, function2, function22, function3, composer, (Animatable.$stable << 3) | 6, 0, 0);
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
}
