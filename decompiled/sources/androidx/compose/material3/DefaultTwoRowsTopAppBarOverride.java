package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultTwoRowsTopAppBarOverride;", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "<init>", "()V", "TwoRowsTopAppBar", "", "Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;", "(Landroidx/compose/material3/TwoRowsTopAppBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "hideTopRowSemantics", ""}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultTwoRowsTopAppBarOverride implements TwoRowsTopAppBarOverride {
    public static final int $stable = 0;
    public static final DefaultTwoRowsTopAppBarOverride INSTANCE = new DefaultTwoRowsTopAppBarOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar$lambda$28(DefaultTwoRowsTopAppBarOverride defaultTwoRowsTopAppBarOverride, TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, int i, Composer composer, int i2) {
        defaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar(twoRowsTopAppBarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultTwoRowsTopAppBarOverride() {
    }

    @Override // androidx.compose.material3.TwoRowsTopAppBarOverride
    public void TwoRowsTopAppBar(final TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Modifier.Companion companionDraggable$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1640665680);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TwoRowsTopAppBar)2742@128485L7,2749@128976L50,2750@129062L52,2754@129209L222,2761@129460L60,2762@129552L34,2766@129813L117,2797@131033L44,2798@131109L27,2799@131177L2,2793@130902L3154:AppBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(twoRowsTopAppBarOverrideScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1640665680, i2, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar (AppBar.kt:2732)");
            }
            if (Float.isNaN(twoRowsTopAppBarOverrideScope.getCollapsedHeight()) || (Float.floatToRawIntBits(twoRowsTopAppBarOverrideScope.getCollapsedHeight()) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The collapsedHeight is expected to be specified and finite".toString());
            }
            if (Float.isNaN(twoRowsTopAppBarOverrideScope.getExpandedHeight()) || (Float.floatToRawIntBits(twoRowsTopAppBarOverrideScope.getExpandedHeight()) & Integer.MAX_VALUE) >= 2139095040) {
                throw new IllegalArgumentException("The expandedHeight is expected to be specified and finite".toString());
            }
            if (Dp.m8829compareTo0680j_4(twoRowsTopAppBarOverrideScope.getExpandedHeight(), twoRowsTopAppBarOverrideScope.getCollapsedHeight()) < 0) {
                throw new IllegalArgumentException("The expandedHeight is expected to be greater or equal to the collapsedHeight".toString());
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int iMo482roundToPx0680j_4 = ((Density) objConsume).mo482roundToPx0680j_4(twoRowsTopAppBarOverrideScope.getTitleBottomPadding());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426685886, "CC(remember):AppBar.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$5$lambda$4(twoRowsTopAppBarOverrideScope));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426683132, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged = (i3 == 4) | composerStartRestartGroup.changed(function0);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Color>() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarContainerColor$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Color invoke() {
                        return Color.m5958boximpl(m2831invoke0d7_KjU());
                    }

                    /* JADX INFO: renamed from: invoke-0d7_KjU, reason: not valid java name */
                    public final long m2831invoke0d7_KjU() {
                        return twoRowsTopAppBarOverrideScope.getColors().m3921containerColorvNxB06k$material3(function0.invoke().floatValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final Function0 function02 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1333673671, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$actionsRow$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C2755@129227L190:AppBar.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1333673671, i4, -1, "androidx.compose.material3.DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar.<anonymous> (AppBar.kt:2755)");
                    }
                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> actions = twoRowsTopAppBarOverrideScope.getActions();
                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer3);
                    Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    actions.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426670388, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(function0);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$8$lambda$7(function0));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function03 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426667470, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(function0);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$10$lambda$9(function0));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function04 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426659035, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged4 = composerStartRestartGroup.changed(function0);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$12$lambda$11(function0));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            State state = (State) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z2 = !TwoRowsTopAppBar$lambda$13(state);
            if (twoRowsTopAppBarOverrideScope.getScrollBehavior() != null && !twoRowsTopAppBarOverrideScope.getScrollBehavior().getIsPinned()) {
                composerStartRestartGroup.startReplaceGroup(-341140385);
                ComposerKt.sourceInformation(composerStartRestartGroup, "2777@130356L107,2777@130333L130,2780@130501L312");
                Modifier.Companion companion = Modifier.INSTANCE;
                Orientation orientation = Orientation.Vertical;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426641669, "CC(remember):AppBar.kt#9igjgp");
                boolean z3 = i3 == 4;
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$15$lambda$14(twoRowsTopAppBarOverrideScope, ((Float) obj).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                DraggableState draggableStateRememberDraggableState = DraggableKt.rememberDraggableState((Function1) objRememberedValue6, composerStartRestartGroup, 0);
                Modifier.Companion companion2 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426636824, "CC(remember):AppBar.kt#9igjgp");
                boolean z4 = i3 == 4;
                DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1 defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4 || defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1RememberedValue = new DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1(twoRowsTopAppBarOverrideScope, null);
                    composerStartRestartGroup.updateRememberedValue(defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionDraggable$default = DraggableKt.draggable$default(companion2, draggableStateRememberDraggableState, orientation, false, null, false, null, (Function3) defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$appBarDragModifier$2$1RememberedValue, false, 188, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-340499894);
                composerStartRestartGroup.endReplaceGroup();
                companionDraggable$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = twoRowsTopAppBarOverrideScope.getModifier().then(companionDraggable$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426620068, "CC(remember):AppBar.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(function02);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$18$lambda$17(function02, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawBehind = DrawModifierKt.drawBehind(modifierThen, (Function1) objRememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426617653, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$20$lambda$19((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierDrawBehind, false, (Function1) objRememberedValue8, 1, null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -426615502, "CC(remember):AppBar.kt#9igjgp");
            DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1 defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1RememberedValue = new PointerInputEventHandler() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierSemantics$default, unit, (PointerInputEventHandler) defaultTwoRowsTopAppBarOverride$TwoRowsTopAppBar$6$1RememberedValue);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325285569, "C2801@131204L2842:AppBar.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -200564612, "C2807@131523L6,2802@131229L1260,2833@133025L45,2825@132506L1526:AppBar.kt#uh7d8r");
            Modifier modifierClipToBounds = ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, twoRowsTopAppBarOverrideScope.getWindowInsets()));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1379010106, "CC(remember):AppBar.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new FloatProducer() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda7
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$27$lambda$26$lambda$23$lambda$22();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AppBarKt.m2467TopAppBarLayoutlyUyIHI(modifierClipToBounds, (FloatProducer) objRememberedValue9, twoRowsTopAppBarOverrideScope.getColors().getNavigationIconContentColor(), twoRowsTopAppBarOverrideScope.getColors().getTitleContentColor(), twoRowsTopAppBarOverrideScope.getColors().getSubtitleContentColor(), twoRowsTopAppBarOverrideScope.getColors().getActionIconContentColor(), twoRowsTopAppBarOverrideScope.getSmallTitle(), twoRowsTopAppBarOverrideScope.getSmallTitleTextStyle(), twoRowsTopAppBarOverrideScope.getSmallSubtitle(), twoRowsTopAppBarOverrideScope.getSmallSubtitleTextStyle(), function03, Arrangement.INSTANCE.getCenter(), twoRowsTopAppBarOverrideScope.getTitleHorizontalAlignment(), 0, TwoRowsTopAppBar$lambda$13(state), twoRowsTopAppBarOverrideScope.getNavigationIcon(), composableLambdaRememberComposableLambda, twoRowsTopAppBarOverrideScope.getCollapsedHeight(), composerStartRestartGroup, 0, 1575984);
            Modifier modifierAdjustHeightOffsetLimit = AppBarKt.adjustHeightOffsetLimit(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m1250onlybOOhFvg(twoRowsTopAppBarOverrideScope.getWindowInsets(), WindowInsetsSides.INSTANCE.m1276getHorizontalJoeWqyM()))), twoRowsTopAppBarOverrideScope.getScrollBehavior());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1379058209, "CC(remember):AppBar.kt#9igjgp");
            boolean z5 = i3 == 4;
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new FloatProducer() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda8
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(twoRowsTopAppBarOverrideScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            AppBarKt.m2467TopAppBarLayoutlyUyIHI(modifierAdjustHeightOffsetLimit, (FloatProducer) objRememberedValue10, twoRowsTopAppBarOverrideScope.getColors().getNavigationIconContentColor(), twoRowsTopAppBarOverrideScope.getColors().getTitleContentColor(), twoRowsTopAppBarOverrideScope.getColors().getSubtitleContentColor(), twoRowsTopAppBarOverrideScope.getColors().getActionIconContentColor(), twoRowsTopAppBarOverrideScope.getTitle(), twoRowsTopAppBarOverrideScope.getTitleTextStyle(), twoRowsTopAppBarOverrideScope.getSubtitle(), twoRowsTopAppBarOverrideScope.getSubtitleTextStyle(), function04, Arrangement.INSTANCE.getBottom(), twoRowsTopAppBarOverrideScope.getTitleHorizontalAlignment(), iMo482roundToPx0680j_4, z2, ComposableSingletons$AppBarKt.INSTANCE.m2688getLambda$2101264077$material3(), ComposableSingletons$AppBarKt.INSTANCE.getLambda$37575796$material3(), Dp.m8830constructorimpl(twoRowsTopAppBarOverrideScope.getExpandedHeight() - twoRowsTopAppBarOverrideScope.getCollapsedHeight()), composer2, 0, 1769520);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultTwoRowsTopAppBarOverride$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultTwoRowsTopAppBarOverride.TwoRowsTopAppBar$lambda$28(this.f$0, twoRowsTopAppBarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TwoRowsTopAppBar$lambda$5$lambda$4(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope) {
        TopAppBarState state;
        TopAppBarScrollBehavior scrollBehavior = twoRowsTopAppBarOverrideScope.getScrollBehavior();
        if (scrollBehavior == null || (state = scrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getCollapsedFraction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TwoRowsTopAppBar$lambda$8$lambda$7(Function0 function0) {
        return AppBarKt.getTopTitleAlphaEasing().transform(((Number) function0.invoke()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TwoRowsTopAppBar$lambda$10$lambda$9(Function0 function0) {
        return 1.0f - ((Number) function0.invoke()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TwoRowsTopAppBar$lambda$12$lambda$11(Function0 function0) {
        return ((Number) function0.invoke()).floatValue() < 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar$lambda$15$lambda$14(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope, float f2) {
        TopAppBarState state = twoRowsTopAppBarOverrideScope.getScrollBehavior().getState();
        state.setHeightOffset(state.getHeightOffset() + f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar$lambda$18$lambda$17(Function0 function0, DrawScope drawScope) {
        DrawScope.m6543drawRectnJ9OG0$default(drawScope, ((Color) function0.invoke()).m5978unboximpl(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TwoRowsTopAppBar$lambda$20$lambda$19(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TwoRowsTopAppBar$lambda$27$lambda$26$lambda$25$lambda$24(TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope) {
        TopAppBarState state;
        TopAppBarScrollBehavior scrollBehavior = twoRowsTopAppBarOverrideScope.getScrollBehavior();
        if (scrollBehavior == null || (state = scrollBehavior.getState()) == null) {
            return 0.0f;
        }
        return state.getHeightOffset();
    }

    private static final boolean TwoRowsTopAppBar$lambda$13(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
