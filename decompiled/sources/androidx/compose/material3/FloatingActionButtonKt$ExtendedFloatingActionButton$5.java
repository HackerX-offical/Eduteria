package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FloatingActionButtonKt$ExtendedFloatingActionButton$5 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ float $endPadding;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ float $iconPadding;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ float $minWidth;
    final /* synthetic */ float $startPadding;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX WARN: Multi-variable type inference failed */
    FloatingActionButtonKt$ExtendedFloatingActionButton$5(boolean z, float f2, float f3, float f4, float f5, Function2<? super Composer, ? super Integer, Unit> function2, float f6, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$expanded = z;
        this.$minWidth = f2;
        this.$minHeight = f3;
        this.$startPadding = f4;
        this.$endPadding = f5;
        this.$icon = function2;
        this.$iconPadding = f6;
        this.$text = function22;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult invoke$lambda$4$lambda$3(float f2, State state, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        int iLerp = MathHelpersKt.lerp(measureScope.mo482roundToPx0680j_4(f2), measurable.maxIntrinsicWidth(Constraints.m8782getMaxHeightimpl(constraints.getValue())), ((Number) state.getValue()).floatValue());
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        return MeasureScope.layout$default(measureScope, iLerp, placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FloatingActionButtonKt$ExtendedFloatingActionButton$5.invoke$lambda$4$lambda$3$lambda$2(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$12$lambda$6$lambda$5(Transition transition) {
        return ((Number) transition.getCurrentState()).floatValue() == 0.0f && !transition.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$8$lambda$7(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$12$lambda$10$lambda$9(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C464@21161L68,466@21372L14,467@21456L14,469@21536L59,471@21661L62,474@21792L435,472@21732L1313:FloatingActionButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-827388388, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:464)");
        }
        final Transition transitionUpdateTransition = TransitionKt.updateTransition(Float.valueOf(this.$expanded ? 1.0f : 0.0f), "expanded state", composer, 48, 0);
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6);
        final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$expandedWidthProgress$1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Float> segment, Composer composer2, int i2) {
                composer2.startReplaceGroup(-1114419602);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1114419602, i2, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:469)");
                }
                FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpec;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Float> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        float fFloatValue = ((Number) transitionUpdateTransition.getCurrentState()).floatValue();
        composer.startReplaceGroup(-157343033);
        ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:469)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf = Float.valueOf(fFloatValue);
        float fFloatValue2 = ((Number) transitionUpdateTransition.getTargetState()).floatValue();
        composer.startReplaceGroup(-157343033);
        ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-157343033, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:469)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(fFloatValue2), function3.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter, "FloatAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>> function32 = new Function3<Transition.Segment<Float>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$expandedAlphaProgress$1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<Float> segment, Composer composer2, int i2) {
                composer2.startReplaceGroup(-781713402);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-781713402, i2, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:471)");
                }
                FiniteAnimationSpec<Float> finiteAnimationSpec = finiteAnimationSpecValue2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return finiteAnimationSpec;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<Float> segment, Composer composer2, Integer num) {
                return invoke(segment, composer2, num.intValue());
            }
        };
        ComposerKt.sourceInformationMarkerStart(composer, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
        TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
        float fFloatValue3 = ((Number) transitionUpdateTransition.getCurrentState()).floatValue();
        composer.startReplaceGroup(175363167);
        ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:471)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        Float fValueOf2 = Float.valueOf(fFloatValue3);
        float fFloatValue4 = ((Number) transitionUpdateTransition.getTargetState()).floatValue();
        composer.startReplaceGroup(175363167);
        ComposerKt.sourceInformation(composer, "CN(it):FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(175363167, 0, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:471)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(fFloatValue4), function32.invoke(transitionUpdateTransition.getSegment(), composer, 0), vectorConverter2, "FloatAnimation", composer, 0);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, -551269425, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean zChanged = composer.changed(this.$minWidth) | composer.changed(stateCreateTransitionAnimation);
        final float f2 = this.$minWidth;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function3() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FloatingActionButtonKt$ExtendedFloatingActionButton$5.invoke$lambda$4$lambda$3(f2, stateCreateTransitionAnimation, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(SizeKt.m1225sizeInqDBjuR0$default(LayoutModifierKt.layout(companion, (Function3) objRememberedValue), this.$minWidth, this.$minHeight, 0.0f, 0.0f, 12, null), this.$startPadding, 0.0f, this.$endPadding, 0.0f, 10, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        Function2<Composer, Integer, Unit> function2 = this.$icon;
        float f3 = this.$iconPadding;
        Function2<Composer, Integer, Unit> function22 = this.$text;
        ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1155paddingqDBjuR0$default);
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
        Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 65394718, "C485@22454L6,487@22510L196:FloatingActionButton.kt#uh7d8r");
        function2.invoke(composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -2076099068, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean zChanged2 = composer.changed(transitionUpdateTransition);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(FloatingActionButtonKt$ExtendedFloatingActionButton$5.invoke$lambda$12$lambda$6$lambda$5(transitionUpdateTransition));
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (((Boolean) ((State) objRememberedValue2).getValue()).booleanValue()) {
            composer.startReplaceGroup(65953058);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(65675329);
            ComposerKt.sourceInformation(composer, "494@22819L2,495@22861L39,493@22764L257");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2076089374, "CC(remember):FloatingActionButton.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonKt$ExtendedFloatingActionButton$5.invoke$lambda$12$lambda$8$lambda$7((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion2, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer, -2076087993, "CC(remember):FloatingActionButton.kt#9igjgp");
            boolean zChanged3 = composer.changed(stateCreateTransitionAnimation2);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.FloatingActionButtonKt$ExtendedFloatingActionButton$5$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FloatingActionButtonKt$ExtendedFloatingActionButton$5.invoke$lambda$12$lambda$10$lambda$9(stateCreateTransitionAnimation2, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierClearAndSetSemantics, (Function1) objRememberedValue4);
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierGraphicsLayer);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composer);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -545340570, "C497@22941L35,498@22997L6:FloatingActionButton.kt#uh7d8r");
            SpacerKt.Spacer(SizeKt.m1226width3ABfNKs(Modifier.INSTANCE, f3), composer, 0);
            function22.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
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
