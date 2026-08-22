package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultShortNavigationBarOverride;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "<init>", "()V", "ShortNavigationBar", "", "Landroidx/compose/material3/ShortNavigationBarOverrideScope;", "(Landroidx/compose/material3/ShortNavigationBarOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultShortNavigationBarOverride implements ShortNavigationBarOverride {
    public static final int $stable = 0;
    public static final DefaultShortNavigationBarOverride INSTANCE = new DefaultShortNavigationBarOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBar$lambda$0(DefaultShortNavigationBarOverride defaultShortNavigationBarOverride, ShortNavigationBarOverrideScope shortNavigationBarOverrideScope, int i, Composer composer, int i2) {
        defaultShortNavigationBarOverride.ShortNavigationBar(shortNavigationBarOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultShortNavigationBarOverride() {
    }

    @Override // androidx.compose.material3.ShortNavigationBarOverride
    public void ShortNavigationBar(final ShortNavigationBarOverrideScope shortNavigationBarOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(256157474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBar)123@5671L865,123@5589L947:ShortNavigationBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(shortNavigationBarOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(256157474, i2, -1, "androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar (ShortNavigationBar.kt:122)");
            }
            SurfaceKt.m3531SurfaceT9BRK9s(shortNavigationBarOverrideScope.getModifier(), null, shortNavigationBarOverrideScope.getContainerColor(), shortNavigationBarOverrideScope.getContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(236236519, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CenteredContentMeasurePolicy centeredContentMeasurePolicy;
                    ComposerKt.sourceInformation(composer2, "C124@5685L841:ShortNavigationBar.kt#uh7d8r");
                    if (!composer2.shouldExecute((i3 & 3) != 2, i3 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(236236519, i3, -1, "androidx.compose.material3.DefaultShortNavigationBarOverride.ShortNavigationBar.<anonymous> (ShortNavigationBar.kt:124)");
                    }
                    Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1206defaultMinSizeVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, shortNavigationBarOverrideScope.getWindowInsets()), 0.0f, NavigationBarTokens.INSTANCE.m4602getContainerHeightD9Ej5fM(), 1, null));
                    Function2<Composer, Integer, Unit> content = shortNavigationBarOverrideScope.getContent();
                    int arrangement = shortNavigationBarOverrideScope.getArrangement();
                    if (ShortNavigationBarArrangement.m3423equalsimpl0(arrangement, ShortNavigationBarArrangement.INSTANCE.m3428getEqualWeightLnnQw40())) {
                        centeredContentMeasurePolicy = new EqualWeightContentMeasurePolicy();
                    } else if (ShortNavigationBarArrangement.m3423equalsimpl0(arrangement, ShortNavigationBarArrangement.INSTANCE.m3427getCenteredLnnQw40())) {
                        centeredContentMeasurePolicy = new CenteredContentMeasurePolicy();
                    } else {
                        throw new IllegalArgumentException("Invalid ItemsArrangement value.");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierSelectableGroup);
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
                    Updater.m5077setimpl(composerM5069constructorimpl, centeredContentMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    content.invoke(composer2, 0);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultShortNavigationBarOverride$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultShortNavigationBarOverride.ShortNavigationBar$lambda$0(this.f$0, shortNavigationBarOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
