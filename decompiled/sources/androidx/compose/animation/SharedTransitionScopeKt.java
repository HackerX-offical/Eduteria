package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SharedTransitionScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t\u001a1\u0010\n\u001a\u00020\u00012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u001a\u001a\u00020\u0013*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u001a\u001a\u00020\u0013*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001d\"&\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u001f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "VisualDebugging", "", "ScaleToBoundsCached", "Landroidx/compose/animation/ScaleToBoundsImpl;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SharedTransitionScopeKt {
    public static final boolean VisualDebugging = false;
    private static final SpringSpec<Rect> DefaultSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 1, null);
    private static final SharedTransitionScope.OverlayClip ParentClip = new SharedTransitionScope.OverlayClip() { // from class: androidx.compose.animation.SharedTransitionScopeKt$ParentClip$1
        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path getClipPath(SharedTransitionScope.SharedContentState sharedContentState, Rect bounds, LayoutDirection layoutDirection, Density density) {
            SharedTransitionScope.SharedContentState parentSharedContentState = sharedContentState.getParentSharedContentState();
            if (parentSharedContentState != null) {
                return parentSharedContentState.getClipPathInOverlay();
            }
            return null;
        }
    };
    private static final MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> cachedScaleToBoundsImplMap = new MutableScatterMap<>(0, 1, null);

    public static final void SharedTransitionLayout(final Modifier modifier, final Function3<? super SharedTransitionScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(646379026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SharedTransitionLayout)N(modifier,content)123@6103L279,123@6081L301:SharedTransitionScope.kt#xbi5r1");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(646379026, i3, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:122)");
            }
            SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(1948801580, true, new Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, Integer num) {
                    invoke(sharedTransitionScope, modifier2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, int i5) {
                    int i6;
                    ComposerKt.sourceInformation(composer2, "CN(sharedTransitionModifier)126@6318L58:SharedTransitionScope.kt#xbi5r1");
                    if ((i5 & 6) == 0) {
                        i6 = (composer2.changed(sharedTransitionScope) ? 4 : 2) | i5;
                    } else {
                        i6 = i5;
                    }
                    if ((i5 & 48) == 0) {
                        i6 |= composer2.changed(modifier2) ? 32 : 16;
                    }
                    if (!composer2.shouldExecute((i6 & 147) != 146, i6 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1948801580, i6, -1, "androidx.compose.animation.SharedTransitionLayout.<anonymous> (SharedTransitionScope.kt:126)");
                    }
                    Modifier modifierThen = modifier.then(modifier2);
                    Function3<SharedTransitionScope, Composer, Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierThen);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                    Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m5073initimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 158724660, "C126@6365L9:SharedTransitionScope.kt#xbi5r1");
                    function32.invoke(sharedTransitionScope, composer2, Integer.valueOf(i6 & 14));
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    SharedTransitionScopeKt.SharedTransitionLayout(modifier, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final void SharedTransitionScope(final Function4<? super SharedTransitionScope, ? super Modifier, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1908320054);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SharedTransitionScope)N(content)145@7246L231,145@7231L246:SharedTransitionScope.kt#xbi5r1");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1908320054, i2, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:144)");
            }
            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(2062852661, true, new Function3<LookaheadScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LookaheadScope lookaheadScope, Composer composer2, Integer num) {
                    invoke(lookaheadScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LookaheadScope lookaheadScope, Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C146@7277L24,147@7328L60,148@7409L62:SharedTransitionScope.kt#xbi5r1");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2062852661, i3, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:146)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)616@28039L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2);
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1873480847, "CC(remember):SharedTransitionScope.kt#9igjgp");
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    function4.invoke(sharedTransitionScopeImpl, new SharedTransitionScopeRootModifierElement(sharedTransitionScopeImpl), composer2, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt.SharedTransitionScope.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    SharedTransitionScopeKt.SharedTransitionScope(function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale contentScale, Alignment alignment) {
        if (getShouldCache(contentScale) && getShouldCache(alignment)) {
            MutableScatterMap<ContentScale, MutableScatterMap<Alignment, ScaleToBoundsImpl>> mutableScatterMap = cachedScaleToBoundsImplMap;
            MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap2 = mutableScatterMap.get(contentScale);
            if (mutableScatterMap2 == null) {
                mutableScatterMap2 = new MutableScatterMap<>(0, 1, null);
                mutableScatterMap.set(contentScale, mutableScatterMap2);
            }
            MutableScatterMap<Alignment, ScaleToBoundsImpl> mutableScatterMap3 = mutableScatterMap2;
            ScaleToBoundsImpl scaleToBoundsImpl = mutableScatterMap3.get(alignment);
            if (scaleToBoundsImpl == null) {
                scaleToBoundsImpl = new ScaleToBoundsImpl(contentScale, alignment);
                mutableScatterMap3.set(alignment, scaleToBoundsImpl);
            }
            return scaleToBoundsImpl;
        }
        return new ScaleToBoundsImpl(contentScale, alignment);
    }

    private static final boolean getShouldCache(Alignment alignment) {
        return alignment == Alignment.INSTANCE.getTopStart() || alignment == Alignment.INSTANCE.getTopCenter() || alignment == Alignment.INSTANCE.getTopEnd() || alignment == Alignment.INSTANCE.getCenterStart() || alignment == Alignment.INSTANCE.getCenter() || alignment == Alignment.INSTANCE.getCenterEnd() || alignment == Alignment.INSTANCE.getBottomStart() || alignment == Alignment.INSTANCE.getBottomCenter() || alignment == Alignment.INSTANCE.getBottomEnd();
    }

    private static final boolean getShouldCache(ContentScale contentScale) {
        return contentScale == ContentScale.INSTANCE.getFillWidth() || contentScale == ContentScale.INSTANCE.getFillHeight() || contentScale == ContentScale.INSTANCE.getFillBounds() || contentScale == ContentScale.INSTANCE.getFit() || contentScale == ContentScale.INSTANCE.getCrop() || contentScale == ContentScale.INSTANCE.getNone() || contentScale == ContentScale.INSTANCE.getInside();
    }
}
