package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarHostKt$FadeInFadeOutWithScale$1$1 implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ String $a11yPaneTitle;
    final /* synthetic */ SnackbarData $current;
    final /* synthetic */ SnackbarData $key;
    final /* synthetic */ FadeInFadeOutState<SnackbarData> $state;

    SnackbarHostKt$FadeInFadeOutWithScale$1$1(SnackbarData snackbarData, SnackbarData snackbarData2, FadeInFadeOutState<SnackbarData> fadeInFadeOutState, String str) {
        this.$key = snackbarData;
        this.$current = snackbarData2;
        this.$state = fadeInFadeOutState;
        this.$a11yPaneTitle = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "CN(children)342@13530L7,344@13628L313,341@13443L521,355@14190L7,353@14013L252,364@14543L374,358@14282L704:SnackbarHost.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | (composer.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1952400805, i2, -1, "androidx.compose.material3.FadeInFadeOutWithScale.<anonymous>.<anonymous> (SnackbarHost.kt:338)");
        }
        final boolean zAreEqual = Intrinsics.areEqual(this.$key, this.$current);
        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
        ComposerKt.sourceInformationMarkerStart(composer, 643547220, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean zChanged = composer.changed(this.$key) | composer.changedInstance(this.$state);
        final SnackbarData snackbarData = this.$key;
        final FadeInFadeOutState<SnackbarData> fadeInFadeOutState = this.$state;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke$lambda$2$lambda$1(snackbarData, fadeInFadeOutState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateAnimatedOpacity = SnackbarHostKt.animatedOpacity(finiteAnimationSpecValue, zAreEqual, (Function0) objRememberedValue, composer, 0, 0);
        State stateAnimatedScale = SnackbarHostKt.animatedScale(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer, 6), zAreEqual, composer, 0);
        Modifier modifierM6132graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m6132graphicsLayerAp8cVGQ(Modifier.INSTANCE, (124895 & 1) != 0 ? 1.0f : ((Number) stateAnimatedScale.getValue()).floatValue(), (124895 & 2) != 0 ? 1.0f : ((Number) stateAnimatedScale.getValue()).floatValue(), (124895 & 4) == 0 ? ((Number) stateAnimatedOpacity.getValue()).floatValue() : 1.0f, (124895 & 8) != 0 ? 0.0f : 0.0f, (124895 & 16) != 0 ? 0.0f : 0.0f, (124895 & 32) != 0 ? 0.0f : 0.0f, (124895 & 64) != 0 ? 0.0f : 0.0f, (124895 & 128) != 0 ? 0.0f : 0.0f, (124895 & 256) == 0 ? 0.0f : 0.0f, (124895 & 512) != 0 ? 8.0f : 0.0f, (124895 & 1024) != 0 ? TransformOrigin.INSTANCE.m6383getCenterSzJe1aQ() : 0L, (124895 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (124895 & 4096) != 0 ? false : false, (124895 & 8192) != 0 ? null : null, (124895 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & 124895) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (124895 & 65536) != 0 ? CompositingStrategy.INSTANCE.m6059getAutoNrFUSI() : 0);
        ComposerKt.sourceInformationMarkerStart(composer, 643576561, "CC(remember):SnackbarHost.kt#9igjgp");
        boolean zChanged2 = composer.changed(zAreEqual) | composer.changed(this.$key) | composer.changed(this.$a11yPaneTitle);
        final String str = this.$a11yPaneTitle;
        final SnackbarData snackbarData2 = this.$key;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke$lambda$5$lambda$4(zAreEqual, str, snackbarData2, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierM6132graphicsLayerAp8cVGQ, false, (Function1) objRememberedValue2, 1, null);
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
        ComposerKt.sourceInformationMarkerStart(composer, -2093234184, "C375@14958L10:SnackbarHost.kt#uh7d8r");
        function2.invoke(composer, Integer.valueOf(i2 & 14));
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
    public static final Unit invoke$lambda$2$lambda$1(final SnackbarData snackbarData, FadeInFadeOutState fadeInFadeOutState) {
        if (!Intrinsics.areEqual(snackbarData, fadeInFadeOutState.getCurrent())) {
            CollectionsKt.removeAll(fadeInFadeOutState.getItems(), new Function1() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke$lambda$2$lambda$1$lambda$0(snackbarData, (FadeInFadeOutAnimationItem) obj));
                }
            });
            RecomposeScope scope = fadeInFadeOutState.getScope();
            if (scope != null) {
                scope.invalidate();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2$lambda$1$lambda$0(SnackbarData snackbarData, FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem) {
        return Intrinsics.areEqual(fadeInFadeOutAnimationItem.getKey(), snackbarData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$4(boolean z, String str, final SnackbarData snackbarData, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (z) {
            SemanticsPropertiesKt.m8031setLiveRegionhR3wRGc(semanticsPropertyReceiver, LiveRegionMode.INSTANCE.m8005getPolite0phEisY());
        }
        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.SnackbarHostKt$FadeInFadeOutWithScale$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(SnackbarHostKt$FadeInFadeOutWithScale$1$1.invoke$lambda$5$lambda$4$lambda$3(snackbarData));
            }
        }, 1, null);
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$5$lambda$4$lambda$3(SnackbarData snackbarData) {
        snackbarData.dismiss();
        return true;
    }
}
