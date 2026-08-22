package androidx.compose.foundation.text.contextmenu.provider;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import org.jivesoftware.smack.packet.Session;

/* JADX INFO: compiled from: BasicTextContextMenuProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0015\u001ae\u0010\u0016\u001a\u00020\u00172V\u0010\u0005\u001aR\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0002\u0010\u0018¨\u0006\u0019²\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"ProvideBasicTextContextMenu", "", "providableCompositionLocal", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuProvider;", "contextMenu", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuSession;", "Lkotlin/ParameterName;", "name", Session.ELEMENT, "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "dataProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "anchorLayoutCoordinates", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/ProvidableCompositionLocal;Lkotlin/jvm/functions/Function5;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "basicTextContextMenuProvider", "Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "(Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/contextmenu/provider/BasicTextContextMenuProvider;", "foundation", "layoutCoordinates"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class BasicTextContextMenuProviderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideBasicTextContextMenu$lambda$0(ProvidableCompositionLocal providableCompositionLocal, Function5 function5, Function2 function2, int i, Composer composer, int i2) {
        ProvideBasicTextContextMenu(providableCompositionLocal, function5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideBasicTextContextMenu$lambda$5(Modifier modifier, ProvidableCompositionLocal providableCompositionLocal, Function5 function5, Function2 function2, int i, Composer composer, int i2) {
        ProvideBasicTextContextMenu(modifier, providableCompositionLocal, function5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProvideBasicTextContextMenu(ProvidableCompositionLocal<TextContextMenuProvider> providableCompositionLocal, Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final ProvidableCompositionLocal<TextContextMenuProvider> providableCompositionLocal2;
        final Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> function52;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composerStartRestartGroup = composer.startRestartGroup(2072681886);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideBasicTextContextMenu)N(providableCompositionLocal,contextMenu,content)65@2975L87:BasicTextContextMenuProvider.kt#qzx0zs");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(providableCompositionLocal) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            providableCompositionLocal2 = providableCompositionLocal;
            function52 = function5;
            function22 = function2;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2072681886, i2, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:64)");
            }
            int i3 = i2 << 3;
            providableCompositionLocal2 = providableCompositionLocal;
            function52 = function5;
            function22 = function2;
            ProvideBasicTextContextMenu(Modifier.INSTANCE, providableCompositionLocal2, function52, function22, composerStartRestartGroup, (i3 & 112) | 6 | (i3 & 896) | (i3 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$0(providableCompositionLocal2, function52, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ProvideBasicTextContextMenu(final Modifier modifier, final ProvidableCompositionLocal<TextContextMenuProvider> providableCompositionLocal, final Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-714464401);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideBasicTextContextMenu)N(modifier,providableCompositionLocal,contextMenu,content)81@3548L65,85@3634L41,86@3751L270,86@3680L341:BasicTextContextMenuProvider.kt#qzx0zs");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(providableCompositionLocal) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-714464401, i2, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu (BasicTextContextMenuProvider.kt:80)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 594492816, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final BasicTextContextMenuProvider basicTextContextMenuProvider = basicTextContextMenuProvider(function5, composerStartRestartGroup, (i2 >> 6) & 14);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(basicTextContextMenuProvider), ComposableLambdaKt.rememberComposableLambda(274270255, true, new Function2() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$4(modifier, mutableState, function2, basicTextContextMenuProvider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$5(modifier, providableCompositionLocal, function5, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final LayoutCoordinates ProvideBasicTextContextMenu$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideBasicTextContextMenu$lambda$4(Modifier modifier, final MutableState mutableState, Function2 function2, BasicTextContextMenuProvider basicTextContextMenuProvider, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@3863L26,87@3761L254:BasicTextContextMenuProvider.kt#qzx0zs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274270255, i, -1, "androidx.compose.foundation.text.contextmenu.provider.ProvideBasicTextContextMenu.<anonymous> (BasicTextContextMenuProvider.kt:87)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1580713609, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$4$0$0(mutableState, (LayoutCoordinates) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnGloballyPositioned);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
            Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -733481004, "C91@3915L9,92@3958L47,92@3946L59:BasicTextContextMenuProvider.kt#qzx0zs");
            function2.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 669077316, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BasicTextContextMenuProviderKt.ProvideBasicTextContextMenu$lambda$4$1$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            basicTextContextMenuProvider.ContextMenu((Function0) objRememberedValue2, composer, 6);
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideBasicTextContextMenu$lambda$4$0$0(MutableState mutableState, LayoutCoordinates layoutCoordinates) {
        mutableState.setValue(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates ProvideBasicTextContextMenu$lambda$4$1$0$0(MutableState mutableState) {
        LayoutCoordinates layoutCoordinatesProvideBasicTextContextMenu$lambda$2 = ProvideBasicTextContextMenu$lambda$2(mutableState);
        if (layoutCoordinatesProvideBasicTextContextMenu$lambda$2 != null) {
            return layoutCoordinatesProvideBasicTextContextMenu$lambda$2;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public static final BasicTextContextMenuProvider basicTextContextMenuProvider(Function5<? super TextContextMenuSession, ? super TextContextMenuDataProvider, ? super Function0<? extends LayoutCoordinates>, ? super Composer, ? super Integer, Unit> function5, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 100861460, "C(basicTextContextMenuProvider)N(contextMenu)107@4360L67,108@4459L35,108@4432L62:BasicTextContextMenuProvider.kt#qzx0zs");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(100861460, i, -1, "androidx.compose.foundation.text.contextmenu.provider.basicTextContextMenuProvider (BasicTextContextMenuProvider.kt:106)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1856374633, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(function5)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BasicTextContextMenuProvider(function5);
            composer.updateRememberedValue(objRememberedValue);
        }
        final BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1856371497, "CC(remember):BasicTextContextMenuProvider.kt#9igjgp");
        boolean zChanged = composer.changed(basicTextContextMenuProvider);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BasicTextContextMenuProviderKt.basicTextContextMenuProvider$lambda$1$0(basicTextContextMenuProvider, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(basicTextContextMenuProvider, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return basicTextContextMenuProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult basicTextContextMenuProvider$lambda$1$0(final BasicTextContextMenuProvider basicTextContextMenuProvider, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProviderKt$basicTextContextMenuProvider$lambda$1$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                basicTextContextMenuProvider.cancel();
            }
        };
    }
}
