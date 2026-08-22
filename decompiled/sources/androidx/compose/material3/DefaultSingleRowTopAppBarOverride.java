package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultSingleRowTopAppBarOverride;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "<init>", "()V", "SingleRowTopAppBar", "", "Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;", "(Landroidx/compose/material3/SingleRowTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "targetColor", "Landroidx/compose/ui/graphics/Color;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultSingleRowTopAppBarOverride implements SingleRowTopAppBarOverride {
    public static final int $stable = 0;
    public static final DefaultSingleRowTopAppBarOverride INSTANCE = new DefaultSingleRowTopAppBarOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SingleRowTopAppBar$lambda$15$lambda$14$lambda$13() {
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleRowTopAppBar$lambda$16(DefaultSingleRowTopAppBarOverride defaultSingleRowTopAppBarOverride, SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope, int i, Composer composer, int i2) {
        defaultSingleRowTopAppBarOverride.SingleRowTopAppBar(singleRowTopAppBarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultSingleRowTopAppBarOverride() {
    }

    @Override // androidx.compose.material3.SingleRowTopAppBarOverride
    public void SingleRowTopAppBar(final SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionDraggable$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(2137486921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SingleRowTopAppBar)2520@118647L280,2531@119179L7,2528@118976L225,2536@119296L222,2574@120882L222,2580@121136L27,2581@121204L2,2570@120751L1724:AppBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(singleRowTopAppBarOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2137486921, i2, -1, "androidx.compose.material3.DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar (AppBar.kt:2510)");
            }
            if (Float.isNaN(singleRowTopAppBarOverrideScope.getExpandedHeight()) || (Float.floatToRawIntBits(singleRowTopAppBarOverrideScope.getExpandedHeight()) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            TopAppBarColors colors = singleRowTopAppBarOverrideScope.getColors();
            TopAppBarScrollBehavior scrollBehavior = singleRowTopAppBarOverrideScope.getScrollBehavior();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130584929, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(colors) | composerStartRestartGroup.changed(scrollBehavior);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Color>() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$targetColor$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Color invoke() {
                        return Color.m5958boximpl(m2825invoke0d7_KjU());
                    }

                    /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
                    public final long m2825invoke0d7_KjU() {
                        TopAppBarState state;
                        TopAppBarScrollBehavior scrollBehavior2 = singleRowTopAppBarOverrideScope.getScrollBehavior();
                        return singleRowTopAppBarOverrideScope.getColors().m3921containerColorvNxB06k$material3(((scrollBehavior2 == null || (state = scrollBehavior2.getState()) == null) ? 0.0f : state.getOverlappedFraction()) > 0.01f ? 1.0f : 0.0f);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Color> stateM162animateColorAsStateeuL9pac = SingleValueAnimationKt.m162animateColorAsStateeuL9pac(SingleRowTopAppBar$lambda$2((State) objRememberedValue), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1658896622, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$actionsRow$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C2537@119314L190:AppBar.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1658896622, i3, -1, "androidx.compose.material3.DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar.<anonymous> (AppBar.kt:2537)");
                    }
                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> actions = singleRowTopAppBarOverrideScope.getActions();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer2);
                    Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    actions.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            if (singleRowTopAppBarOverrideScope.getScrollBehavior() != null && !singleRowTopAppBarOverrideScope.getScrollBehavior().getIsPinned()) {
                composerStartRestartGroup.startReplaceGroup(689467622);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2550@119886L107,2550@119863L130,2553@120031L312");
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130624404, "CC(remember):AppBar.kt#9igjgp");
                int i3 = i2 & 14;
                boolean z = i3 == 4;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$4$lambda$3(singleRowTopAppBarOverrideScope, ((Float) obj).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) objRememberedValue2, composerStartRestartGroup, 0);
                Modifier.Companion companion2 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130629249, "CC(remember):AppBar.kt#9igjgp");
                boolean z2 = i3 == 4;
                DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1 defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1RememberedValue = new DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1(singleRowTopAppBarOverrideScope, null);
                    composerStartRestartGroup.updateRememberedValue(defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionDraggable$default = DraggableKt.draggable$default(companion2, draggableStateRememberDraggableState, orientation, false, null, false, null, (Function3) defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$appBarDragModifier$2$1RememberedValue, false, 188, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(690108113);
                composerStartRestartGroup.endReplaceGroup();
                companionDraggable$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = singleRowTopAppBarOverrideScope.getModifier().then(companionDraggable$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130656391, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(stateM162animateColorAsStateeuL9pac);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$7$lambda$6(stateM162animateColorAsStateeuL9pac, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifierThen, (Function1) objRememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130664324, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$9$lambda$8((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierDrawBehind, false, (Function1) objRememberedValue4, 1, null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1130666475, "CC(remember):AppBar.kt#9igjgp");
            DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1 defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1RememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics$default, unit, (PointerInputEventHandler) defaultSingleRowTopAppBarOverride$SingleRowTopAppBar$4$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPointerInput);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1199733554, "C2589@121570L45,2598@122100L6,2583@121231L1234:AppBar.kt#uh7d8r");
            Modifier modifierAdjustHeightOffsetLimit = AppBarKt.adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, singleRowTopAppBarOverrideScope.getWindowInsets())), singleRowTopAppBarOverrideScope.getScrollBehavior());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592880752, "CC(remember):AppBar.kt#9igjgp");
            boolean z3 = (i2 & 14) == 4;
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new FloatProducer() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda3
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$15$lambda$12$lambda$11(singleRowTopAppBarOverrideScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            FloatProducer floatProducer = (FloatProducer) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long navigationIconContentColor = singleRowTopAppBarOverrideScope.getColors().getNavigationIconContentColor();
            long titleContentColor = singleRowTopAppBarOverrideScope.getColors().getTitleContentColor();
            long actionIconContentColor = singleRowTopAppBarOverrideScope.getColors().getActionIconContentColor();
            long subtitleContentColor = singleRowTopAppBarOverrideScope.getColors().getSubtitleContentColor();
            Function2<Composer, Integer, Unit> title = singleRowTopAppBarOverrideScope.getTitle();
            TextStyle titleTextStyle = singleRowTopAppBarOverrideScope.getTitleTextStyle();
            Function2<Composer, Integer, Unit> subtitle = singleRowTopAppBarOverrideScope.getSubtitle();
            TextStyle subtitleTextStyle = singleRowTopAppBarOverrideScope.getSubtitleTextStyle();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal titleHorizontalAlignment = singleRowTopAppBarOverrideScope.getTitleHorizontalAlignment();
            Function2<Composer, Integer, Unit> navigationIcon = singleRowTopAppBarOverrideScope.getNavigationIcon();
            float expandedHeight = singleRowTopAppBarOverrideScope.getExpandedHeight();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -592863831, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$15$lambda$14$lambda$13());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AppBarKt.m2467TopAppBarLayoutlyUyIHI(modifierAdjustHeightOffsetLimit, floatProducer, navigationIconContentColor, titleContentColor, subtitleContentColor, actionIconContentColor, title, titleTextStyle, subtitle, subtitleTextStyle, (Function0) objRememberedValue6, center, titleHorizontalAlignment, 0, false, navigationIcon, composableLambdaRememberComposableLambda, expandedHeight, composerStartRestartGroup, 0, 1600566);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultSingleRowTopAppBarOverride$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultSingleRowTopAppBarOverride.SingleRowTopAppBar$lambda$16(this.f$0, singleRowTopAppBarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleRowTopAppBar$lambda$4$lambda$3(SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope, float f2) {
        TopAppBarState state = singleRowTopAppBarOverrideScope.getScrollBehavior().getState();
        state.setHeightOffset(state.getHeightOffset() + f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleRowTopAppBar$lambda$7$lambda$6(State state, DrawScope drawScope) {
        long jM5978unboximpl = ((Color) state.getValue()).m5978unboximpl();
        if (!Color.m5969equalsimpl0(jM5978unboximpl, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            DrawScope.m6543drawRectnJ9OG0$default(drawScope, jM5978unboximpl, 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SingleRowTopAppBar$lambda$9$lambda$8(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float SingleRowTopAppBar$lambda$15$lambda$12$lambda$11(SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope) {
        TopAppBarState state;
        TopAppBarScrollBehavior scrollBehavior = singleRowTopAppBarOverrideScope.getScrollBehavior();
        if (scrollBehavior == null || (state = scrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }

    private static final long SingleRowTopAppBar$lambda$2(State<Color> state) {
        return state.getValue().m5978unboximpl();
    }
}
