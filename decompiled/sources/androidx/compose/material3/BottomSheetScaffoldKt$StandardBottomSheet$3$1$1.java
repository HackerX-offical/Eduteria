package androidx.compose.material3;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $dismissActionLabel;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dragHandle;
    final /* synthetic */ String $expandActionLabel;
    final /* synthetic */ String $partialExpandActionLabel;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ boolean $sheetSwipeEnabled;
    final /* synthetic */ SheetState $state;

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Expanded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    BottomSheetScaffoldKt$StandardBottomSheet$3$1$1(SheetState sheetState, CoroutineScope coroutineScope, boolean z, String str, String str2, String str3, Function2<? super Composer, ? super Integer, Unit> function2) {
        this.$state = sheetState;
        this.$scope = coroutineScope;
        this.$sheetSwipeEnabled = z;
        this.$expandActionLabel = str;
        this.$partialExpandActionLabel = str2;
        this.$dismissActionLabel = str3;
        this.$dragHandle = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C338@16043L790,353@16902L2539,336@15956L3568:BottomSheetScaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511691176, i, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:336)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -2108944114, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean zChanged = composer.changed(this.$state) | composer.changedInstance(this.$scope);
        final SheetState sheetState = this.$state;
        final CoroutineScope coroutineScope = this.$scope;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BottomSheetScaffoldKt$StandardBottomSheet$3$1$1.invoke$lambda$1$lambda$0(sheetState, coroutineScope);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM357clickableXHw0xAI$default = ClickableKt.m357clickableXHw0xAI$default(companion, false, null, null, (Function0) objRememberedValue, 7, null);
        ComposerKt.sourceInformationMarkerStart(composer, -2108914877, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean zChanged2 = composer.changed(this.$state) | composer.changed(this.$sheetSwipeEnabled) | composer.changed(this.$expandActionLabel) | composer.changedInstance(this.$scope) | composer.changed(this.$partialExpandActionLabel) | composer.changed(this.$dismissActionLabel);
        final SheetState sheetState2 = this.$state;
        final boolean z = this.$sheetSwipeEnabled;
        final String str = this.$expandActionLabel;
        final String str2 = this.$partialExpandActionLabel;
        final String str3 = this.$dismissActionLabel;
        final CoroutineScope coroutineScope2 = this.$scope;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Function1 function1 = new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BottomSheetScaffoldKt$StandardBottomSheet$3$1$1.invoke$lambda$7$lambda$6(sheetState2, z, str, str2, str3, coroutineScope2, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(function1);
            objRememberedValue2 = function1;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM357clickableXHw0xAI$default, true, (Function1) objRememberedValue2);
        Function2<Composer, Integer, Unit> function2 = this.$dragHandle;
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics);
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
        ComposerKt.sourceInformationMarkerStart(composer, 2015269861, "C395@19490L12:BottomSheetScaffold.kt#uh7d8r");
        function2.invoke(composer, 0);
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
    public static final Unit invoke$lambda$1$lambda$0(SheetState sheetState, CoroutineScope coroutineScope) {
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
        if (i == 1) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1(sheetState, null), 3, null);
        } else if (i != 2) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3(sheetState, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6(final SheetState sheetState, boolean z, String str, String str2, String str3, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (sheetState.getAnchoredDraggableState$material3().getAnchors().getSize() > 1 && z) {
            if (sheetState.getCurrentValue() == SheetValue.PartiallyExpanded) {
                if (sheetState.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Expanded).booleanValue()) {
                    SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(BottomSheetScaffoldKt$StandardBottomSheet$3$1$1.invoke$lambda$7$lambda$6$lambda$5$lambda$2(coroutineScope, sheetState));
                        }
                    });
                }
            } else if (sheetState.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.PartiallyExpanded).booleanValue()) {
                SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt$StandardBottomSheet$3$1$1.invoke$lambda$7$lambda$6$lambda$5$lambda$3(coroutineScope, sheetState));
                    }
                });
            }
            if (!sheetState.getSkipHiddenState()) {
                SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new Function0() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(BottomSheetScaffoldKt$StandardBottomSheet$3$1$1.invoke$lambda$7$lambda$6$lambda$5$lambda$4(coroutineScope, sheetState));
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$2(CoroutineScope coroutineScope, SheetState sheetState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$1$1(sheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$3(CoroutineScope coroutineScope, SheetState sheetState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$2$1(sheetState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$7$lambda$6$lambda$5$lambda$4(CoroutineScope coroutineScope, SheetState sheetState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$2$1$1$3$1(sheetState, null), 3, null);
        return true;
    }
}
