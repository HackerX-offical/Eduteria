package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/DefaultModalWideNavigationRailOverride;", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "<init>", "()V", "ModalWideNavigationRail", "", "Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;", "(Landroidx/compose/material3/ModalWideNavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3", "isCollapsed", "", "modalExpanded"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultModalWideNavigationRailOverride implements ModalWideNavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultModalWideNavigationRailOverride INSTANCE = new DefaultModalWideNavigationRailOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$23(DefaultModalWideNavigationRailOverride defaultModalWideNavigationRailOverride, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, int i, Composer composer, int i2) {
        defaultModalWideNavigationRailOverride.ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultModalWideNavigationRailOverride() {
    }

    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, kotlin.coroutines.Continuation, kotlin.jvm.functions.Function1, kotlinx.coroutines.channels.BufferOverflow] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // androidx.compose.material3.ModalWideNavigationRailOverride
    public void ModalWideNavigationRail(final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope, Composer composer, final int i) {
        int i2;
        final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope2;
        Function2<Composer, Integer, Unit> content;
        int i3;
        ?? r4;
        boolean z;
        Composer composerStartRestartGroup = composer.startRestartGroup(1751235721);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)509@25093L7,511@25254L14,513@25306L230,524@25833L7,521@25580L275,526@25892L60,527@25991L62,528@26105L132,535@26304L176,557@27012L48:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(modalWideNavigationRailOverrideScope) : composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1751235721, i2, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail (WideNavigationRail.kt:503)");
            }
            if (modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                composerStartRestartGroup.startReplaceGroup(95781714);
                composerStartRestartGroup.endReplaceGroup();
                content = modalWideNavigationRailOverrideScope.getContent();
            } else {
                composerStartRestartGroup.startReplaceGroup(95826602);
                ComposerKt.sourceInformation(composerStartRestartGroup, "507@25009L47");
                Function2<Composer, Integer, Unit> content2 = modalWideNavigationRailOverrideScope.getContent();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689645480, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(content2);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = MovableContentKt.movableContentOf(modalWideNavigationRailOverrideScope.getContent());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                content = (Function2) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            final Function2<Composer, Integer, Unit> function2 = content;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            WideNavigationRailState state = modalWideNavigationRailOverrideScope.getState();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689635793, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(state);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new ModalWideNavigationRailState(modalWideNavigationRailOverrideScope.getState(), density, finiteAnimationSpecValue);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final ModalWideNavigationRailState modalWideNavigationRailState = (ModalWideNavigationRailState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope.getState().getTargetValue()) ? 0.0f : 1.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689617211, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$3$lambda$2(stateAnimateFloatAsState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state2 = (State) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689614041, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$6$lambda$5(stateAnimateFloatAsState));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final State state3 = (State) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689610323, "CC(remember):WideNavigationRail.kt#9igjgp");
            int i4 = i2 & 14;
            boolean zChangedInstance = (i4 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
            DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || defaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                defaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1RememberedValue = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(modalWideNavigationRailOverrideScope, modalWideNavigationRailState, null);
                composerStartRestartGroup.updateRememberedValue(defaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1RememberedValue);
            }
            final Function1 function1 = (Function1) defaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689603911, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance2 = (i4 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
            DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1RememberedValue = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(modalWideNavigationRailOverrideScope, modalWideNavigationRailState, null);
                composerStartRestartGroup.updateRememberedValue(defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1RememberedValue);
            }
            final Function2 function22 = (Function2) defaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!modalWideNavigationRailOverrideScope.getShouldHideOnCollapse() && ModalWideNavigationRail$lambda$4(state2)) {
                composerStartRestartGroup.startReplaceGroup(97400069);
                ComposerKt.sourceInformation(composerStartRestartGroup, "544@26598L380");
                i3 = i4;
                r4 = 0;
                WideNavigationRailKt.WideNavigationRailLayout(modalWideNavigationRailOverrideScope.getModifier(), false, false, modalWideNavigationRailOverrideScope.getColors(), modalWideNavigationRailOverrideScope.getCollapsedShape(), modalWideNavigationRailOverrideScope.getHeader(), modalWideNavigationRailOverrideScope.getWindowInsets(), modalWideNavigationRailOverrideScope.getArrangement(), function2, composerStartRestartGroup, 432);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i3 = i4;
                r4 = 0;
                composerStartRestartGroup.startReplaceGroup(97788313);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689581383, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = ChannelKt.Channel$default(-1, r4, r4, 6, r4);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final Channel channel = (Channel) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                composerStartRestartGroup.startReplaceGroup(97908438);
                ComposerKt.sourceInformation(composerStartRestartGroup, "559@27133L403,559@27109L427");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689577156, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(channel) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
                DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1 defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance3 || defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1RememberedValue = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1(channel, modalWideNavigationRailState, r4);
                    composerStartRestartGroup.updateRememberedValue(defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) defaultModalWideNavigationRailOverride$ModalWideNavigationRail$1$1RememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(98341849);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (!ModalWideNavigationRail$lambda$4(state2)) {
                composerStartRestartGroup.startReplaceGroup(98512256);
                ComposerKt.sourceInformation(composerStartRestartGroup, "583@28043L24,584@28109L42,585@28190L38,587@28253L49,587@28242L60,591@28431L37,592@28505L110,595@28661L93,599@28829L1724,589@28316L2237");
                if (!modalWideNavigationRailOverrideScope.getShouldHideOnCollapse()) {
                    composerStartRestartGroup.startReplaceGroup(98472731);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "578@27806L197");
                    Modifier modifierM312backgroundbw27NRU = BackgroundKt.m312backgroundbw27NRU(Modifier.INSTANCE, modalWideNavigationRailOverrideScope.getColors().getContainerColor(), modalWideNavigationRailOverrideScope.getCollapsedShape());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM312backgroundbw27NRU);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1258502535, "C579@27908L77:WideNavigationRail.kt#uh7d8r");
                    z = true;
                    SpacerKt.Spacer(SizeKt.fillMaxHeight$default(SizeKt.m1228widthInVpY3zN4$default(modalWideNavigationRailOverrideScope.getModifier(), WideNavigationRailKt.CollapsedRailWidth, 0.0f, 2, r4), 0.0f, 1, r4), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    z = true;
                    composerStartRestartGroup.startReplaceGroup(98809081);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689546285, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, r4);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final Animatable animatable = (Animatable) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689543697, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new RailPredictiveBackState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final RailPredictiveBackState railPredictiveBackState = (RailPredictiveBackState) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689541670, "CC(remember):WideNavigationRail.kt#9igjgp");
                int i5 = i3;
                boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(channel) | ((i5 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) ? z : false);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance4 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$16$lambda$15(channel, modalWideNavigationRailOverrideScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z2 = false;
                EffectsKt.SideEffect((Function0) objRememberedValue9, composerStartRestartGroup, 0);
                ModalWideNavigationRailProperties expandedProperties = modalWideNavigationRailOverrideScope.getExpandedProperties();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689535986, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(coroutineScope);
                if (i5 == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(modalWideNavigationRailOverrideScope))) {
                    z2 = z;
                }
                boolean z3 = zChangedInstance5 | z2;
                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$18$lambda$17(coroutineScope, modalWideNavigationRailOverrideScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                Function0 function0 = (Function0) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689533545, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance6 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$20$lambda$19(coroutineScope, animatable, ((Float) obj).floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                }
                Function1 function12 = (Function1) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -689528570, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(animatable);
                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance7 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function0() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$22$lambda$21(coroutineScope, animatable);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Function2<Composer, Integer, Unit> function23 = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        boolean zModalWideNavigationRail$lambda$7;
                        ComposerKt.sourceInformation(composer2, "C600@28847L1692:WideNavigationRail.kt#uh7d8r");
                        if (!composer2.shouldExecute((i6 & 3) != 2, i6 & 1)) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1345045690, i6, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous> (WideNavigationRail.kt:600)");
                        }
                        Modifier modifierImePadding = WindowInsetsPadding_androidKt.imePadding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null));
                        final ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope3 = modalWideNavigationRailOverrideScope;
                        ModalWideNavigationRailState modalWideNavigationRailState2 = modalWideNavigationRailState;
                        Function1<Continuation<? super Unit>, Object> function13 = function1;
                        Animatable<Float, AnimationVector1D> animatable2 = animatable;
                        RailPredictiveBackState railPredictiveBackState2 = railPredictiveBackState;
                        Function2<Float, Continuation<? super Unit>, Object> function24 = function22;
                        Function2<Composer, Integer, Unit> function25 = function2;
                        State<Boolean> state4 = state3;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierImePadding);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composer2);
                        Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 238599055, "C608@29206L195,625@30078L201,614@29423L1098:WideNavigationRail.kt#uh7d8r");
                        if (!modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse()) {
                            zModalWideNavigationRail$lambda$7 = DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$7(state4);
                        } else {
                            zModalWideNavigationRail$lambda$7 = modalWideNavigationRailState2.getTargetValue() != WideNavigationRailValue.Collapsed;
                        }
                        WideNavigationRailKt.m3976Scrim3JVO9M(modalWideNavigationRailOverrideScope3.getColors().getModalScrimColor(), function13, zModalWideNavigationRail$lambda$7, composer2, 0);
                        WideNavigationRailKt.m3975ModalWideNavigationRailContentpU6N4AM(modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse() || DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$7(state4), modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse(), animatable2, railPredictiveBackState2, function24, modalWideNavigationRailOverrideScope3.getModifier(), modalWideNavigationRailState2, modalWideNavigationRailOverrideScope3.getColors(), modalWideNavigationRailOverrideScope3.getExpandedShape(), WideNavigationRailKt.ExpandedRailMaxWidth, ComposableLambdaKt.rememberComposableLambda(208840989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$7$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C626@30108L145:WideNavigationRail.kt#uh7d8r");
                                if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(208840989, i7, -1, "androidx.compose.material3.DefaultModalWideNavigationRailOverride.ModalWideNavigationRail.<anonymous>.<anonymous>.<anonymous> (WideNavigationRail.kt:626)");
                                }
                                Modifier modifierM1155paddingqDBjuR0$default = PaddingKt.m1155paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, modalWideNavigationRailOverrideScope3.getExpandedHeaderTopPadding(), 0.0f, 0.0f, 13, null);
                                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope4 = modalWideNavigationRailOverrideScope3;
                                ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, modifierM1155paddingqDBjuR0$default);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor3);
                                } else {
                                    composer3.useNode();
                                }
                                Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composer3);
                                Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -1627808976, "C:WideNavigationRail.kt#uh7d8r");
                                Function2<Composer, Integer, Unit> header = modalWideNavigationRailOverrideScope4.getHeader();
                                if (header == null) {
                                    composer3.startReplaceGroup(-1627801290);
                                } else {
                                    composer3.startReplaceGroup(-2130719701);
                                    ComposerKt.sourceInformation(composer3, "627@30215L8");
                                    header.invoke(composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), modalWideNavigationRailOverrideScope3.getWindowInsets(), modalWideNavigationRailOverrideScope3.getShouldHideOnCollapse(), modalWideNavigationRailOverrideScope3.getArrangement(), function25, composer2, (Animatable.$stable << 6) | 805309440, 6);
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
                };
                modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
                WideNavigationRail_androidKt.ModalWideNavigationRailDialog(function0, expandedProperties, function12, (Function0) objRememberedValue12, railPredictiveBackState, ComposableLambdaKt.rememberComposableLambda(1345045690, z, function23, composerStartRestartGroup, 54), composerStartRestartGroup, 221184);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modalWideNavigationRailOverrideScope2 = modalWideNavigationRailOverrideScope;
                composerStartRestartGroup.startReplaceGroup(101334713);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultModalWideNavigationRailOverride$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultModalWideNavigationRailOverride.ModalWideNavigationRail$lambda$23(this.f$0, modalWideNavigationRailOverrideScope2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$3$lambda$2(State state) {
        return ((Number) state.getValue()).floatValue() == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$6$lambda$5(State state) {
        return ((Number) state.getValue()).floatValue() >= 0.3f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$16$lambda$15(Channel channel, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        channel.mo13895trySendJP2dKIU(Boolean.valueOf(WideNavigationRailStateKt.isExpanded(modalWideNavigationRailOverrideScope.getState().getTargetValue())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$18$lambda$17(CoroutineScope coroutineScope, ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$4$1$1(modalWideNavigationRailOverrideScope, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$20$lambda$19(CoroutineScope coroutineScope, Animatable animatable, float f2) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$5$1$1(animatable, f2, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail$lambda$22$lambda$21(CoroutineScope coroutineScope, Animatable animatable) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$6$1$1(animatable, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final boolean ModalWideNavigationRail$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalWideNavigationRail$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
