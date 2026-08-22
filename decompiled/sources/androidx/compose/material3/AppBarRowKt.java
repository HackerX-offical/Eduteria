package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.AppBarRowKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppBarRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002"}, d2 = {"AppBarRow", "", "overflowIndicator", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "maxItemCount", "", "content", "Landroidx/compose/material3/AppBarRowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "material3", "scope", "Landroidx/compose/material3/AppBarRowScopeImpl;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarRow$lambda$5(Function3 function3, Modifier modifier, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        AppBarRow(function3, modifier, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AppBarRow(final kotlin.jvm.functions.Function3<? super androidx.compose.material3.AppBarMenuState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r16, androidx.compose.ui.Modifier r17, int r18, final kotlin.jvm.functions.Function1<? super androidx.compose.material3.AppBarRowScope, kotlin.Unit> r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AppBarRowKt.AppBarRow(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarRowScopeImpl AppBarRow$lambda$1$lambda$0(State state) {
        AppBarRowScopeImpl appBarRowScopeImpl = new AppBarRowScopeImpl(new AppBarScopeImpl());
        ((Function1) state.getValue()).invoke(appBarRowScopeImpl);
        return appBarRowScopeImpl;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AppBarRowKt$AppBarRow$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppBarRow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ AppBarMenuState $menuState;
        final /* synthetic */ Function3<AppBarMenuState, Composer, Integer, Unit> $overflowIndicator;
        final /* synthetic */ AppBarOverflowState $overflowState;
        final /* synthetic */ State<AppBarRowScopeImpl> $scope$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> function3, AppBarMenuState appBarMenuState, AppBarOverflowState appBarOverflowState, State<AppBarRowScopeImpl> state) {
            this.$overflowIndicator = function3;
            this.$menuState = appBarMenuState;
            this.$overflowState = appBarOverflowState;
            this.$scope$delegate = state;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C73@3453L640:AppBarRow.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-815780026, i, -1, "androidx.compose.material3.AppBarRow.<anonymous> (AppBarRow.kt:73)");
            }
            Function3<AppBarMenuState, Composer, Integer, Unit> function3 = this.$overflowIndicator;
            final AppBarMenuState appBarMenuState = this.$menuState;
            final AppBarOverflowState appBarOverflowState = this.$overflowState;
            final State<AppBarRowScopeImpl> state = this.$scope$delegate;
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, -337072597, "C74@3483L28,77@3658L23,78@3709L362,75@3536L535:AppBarRow.kt#uh7d8r");
            function3.invoke(appBarMenuState, composer, 6);
            boolean zIsExpanded = appBarMenuState.isExpanded();
            ComposerKt.sourceInformationMarkerStart(composer, 1790247043, "CC(remember):AppBarRow.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarRowKt$AppBarRow$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBarRowKt.AnonymousClass2.invoke$lambda$2$lambda$1$lambda$0(appBarMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.m2426DropdownMenuIlH_yew(zIsExpanded, (Function0) objRememberedValue, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1786124721, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarRowKt$AppBarRow$2$1$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope columnScope, Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C*84@4021L22:AppBarRow.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 17) != 16, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1786124721, i2, -1, "androidx.compose.material3.AppBarRow.<anonymous>.<anonymous>.<anonymous> (AppBarRow.kt:79)");
                    }
                    List<AppBarItem> listSubList = AppBarRowKt.AppBarRow$lambda$2(state).getItems().subList(appBarOverflowState.getVisibleItemCount(), appBarOverflowState.getTotalItemCount());
                    AppBarMenuState appBarMenuState2 = appBarMenuState;
                    int size = listSubList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        listSubList.get(i3).MenuContent(appBarMenuState2, composer2, 6);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 48, 48, 2044);
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
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(AppBarMenuState appBarMenuState) {
            appBarMenuState.dismiss();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarRowScopeImpl AppBarRow$lambda$2(State<AppBarRowScopeImpl> state) {
        return state.getValue();
    }
}
