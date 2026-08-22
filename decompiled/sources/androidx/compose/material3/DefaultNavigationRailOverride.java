package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.DefaultNavigationRailOverride;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/DefaultNavigationRailOverride;", "Landroidx/compose/material3/NavigationRailOverride;", "<init>", "()V", "NavigationRail", "", "Landroidx/compose/material3/NavigationRailOverrideScope;", "(Landroidx/compose/material3/NavigationRailOverrideScope;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultNavigationRailOverride implements NavigationRailOverride {
    public static final int $stable = 0;
    public static final DefaultNavigationRailOverride INSTANCE = new DefaultNavigationRailOverride();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail$lambda$0(DefaultNavigationRailOverride defaultNavigationRailOverride, NavigationRailOverrideScope navigationRailOverrideScope, int i, Composer composer, int i2) {
        defaultNavigationRailOverride.NavigationRail(navigationRailOverrideScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private DefaultNavigationRailOverride() {
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DefaultNavigationRailOverride$NavigationRail$1, reason: invalid class name */
    /* JADX INFO: compiled from: NavigationRail.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ NavigationRailOverrideScope $this_NavigationRail;

        AnonymousClass1(NavigationRailOverrideScope navigationRailOverrideScope) {
            this.$this_NavigationRail = navigationRailOverrideScope;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C155@7090L27,149@6758L769:NavigationRail.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1027527987, i, -1, "androidx.compose.material3.DefaultNavigationRailOverride.NavigationRail.<anonymous> (NavigationRail.kt:149)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m1153paddingVpY3zN4$default(SizeKt.m1228widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), this.$this_NavigationRail.getWindowInsets()), NavigationRailCollapsedTokens.INSTANCE.m4626getNarrowContainerWidthD9Ej5fM(), 0.0f, 2, null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, null));
            ComposerKt.sourceInformationMarkerStart(composer, 388093672, "CC(remember):NavigationRail.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.DefaultNavigationRailOverride$NavigationRail$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DefaultNavigationRailOverride.AnonymousClass1.invoke$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierSelectableGroup, false, (Function1) objRememberedValue, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM825spacedBy0680j_4 = Arrangement.INSTANCE.m825spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
            NavigationRailOverrideScope navigationRailOverrideScope = this.$this_NavigationRail;
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM825spacedBy0680j_4, centerHorizontally, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -548351563, "C164@7504L9:NavigationRail.kt#uh7d8r");
            Function3<ColumnScope, Composer, Integer, Unit> header = navigationRailOverrideScope.getHeader();
            if (header != null) {
                composer.startReplaceGroup(-548298554);
                ComposerKt.sourceInformation(composer, "161@7388L8,162@7417L52");
                header.invoke(columnScopeInstance, composer, 6);
                SpacerKt.Spacer(SizeKt.m1207height3ABfNKs(Modifier.INSTANCE, NavigationRailKt.NavigationRailHeaderPadding), composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-548182273);
                composer.endReplaceGroup();
            }
            navigationRailOverrideScope.getContent().invoke(columnScopeInstance, composer, 6);
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
        public static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.material3.NavigationRailOverride
    public void NavigationRail(final NavigationRailOverrideScope navigationRailOverrideScope, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-433653496);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)148@6744L793,148@6662L875:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(navigationRailOverrideScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-433653496, i2, -1, "androidx.compose.material3.DefaultNavigationRailOverride.NavigationRail (NavigationRail.kt:147)");
            }
            SurfaceKt.m3531SurfaceT9BRK9s(navigationRailOverrideScope.getModifier(), null, navigationRailOverrideScope.getContainerColor(), navigationRailOverrideScope.getContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1027527987, true, new AnonymousClass1(navigationRailOverrideScope), composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.DefaultNavigationRailOverride$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DefaultNavigationRailOverride.NavigationRail$lambda$0(this.f$0, navigationRailOverrideScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
