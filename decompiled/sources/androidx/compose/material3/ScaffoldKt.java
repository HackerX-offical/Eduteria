package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a®\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0084\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00062\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt {
    private static final float FabSpacing = Dp.m8830constructorimpl(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_FMILGgc$lambda$16(int i, Function2 function2, Function3 function3, Function2 function22, Function2 function23, WindowInsets windowInsets, Function2 function24, int i2, Composer composer, int i3) {
        m3321ScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_TvnljyQ$lambda$3(Modifier modifier, Function2 function2, Function2 function22, Function2 function23, Function2 function24, int i, long j, long j2, WindowInsets windowInsets, Function3 function3, int i2, int i3, Composer composer, int i4) {
        m3320ScaffoldTvnljyQ(modifier, function2, function22, function23, function24, i, j, j2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0117  */
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3320ScaffoldTvnljyQ(androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, int r33, long r34, long r36, androidx.compose.foundation.layout.WindowInsets r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 784
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m3320ScaffoldTvnljyQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_TvnljyQ$lambda$2$lambda$1(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m3321ScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1;
        boolean z;
        ?? r2;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-280287501);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)N(fabPosition:c#material3.FabPosition,topBar,content,snackbar,fab,contentWindowInsets,bottomBar)142@6839L626,158@7515L41,159@7607L45,160@7698L35,162@7788L73,163@7913L47,164@7982L5885,164@7965L5902:Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-280287501, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:137)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226671013, "CC(remember):Scaffold.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$12 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226692060, "CC(remember):Scaffold.kt#9igjgp");
            boolean z2 = (i3 & 112) == 32;
            ComposableLambda composableLambdaRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || composableLambdaRememberedValue == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue = ComposableLambdaKt.composableLambdaInstance(605195056, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$topBarContent$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C158@7536L16:Scaffold.kt#uh7d8r");
                        if (composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(605195056, i5, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:158)");
                            }
                            Function2<Composer, Integer, Unit> function25 = function2;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -1154869819, "C158@7542L8:Scaffold.kt#uh7d8r");
                            function25.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue);
            }
            final Function2 function25 = (Function2) composableLambdaRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226695008, "CC(remember):Scaffold.kt#9igjgp");
            boolean z3 = (i3 & 7168) == 2048;
            ComposableLambda composableLambdaRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || composableLambdaRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue2 = ComposableLambdaKt.composableLambdaInstance(418899191, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$snackbarContent$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C159@7630L18:Scaffold.kt#uh7d8r");
                        if (composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(418899191, i5, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:159)");
                            }
                            Function2<Composer, Integer, Unit> function26 = function22;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 367258716, "C159@7636L10:Scaffold.kt#uh7d8r");
                            function26.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue2);
            }
            final Function2 function26 = (Function2) composableLambdaRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226697910, "CC(remember):Scaffold.kt#9igjgp");
            boolean z4 = (57344 & i3) == 16384;
            ComposableLambda composableLambdaRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z4 || composableLambdaRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue3 = ComposableLambdaKt.composableLambdaInstance(338600263, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$fabContent$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C160@7716L13:Scaffold.kt#uh7d8r");
                        if (composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(338600263, i5, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:160)");
                            }
                            Function2<Composer, Integer, Unit> function27 = function23;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 2140512701, "C160@7722L5:Scaffold.kt#uh7d8r");
                            function27.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue3);
            }
            final Function2 function27 = (Function2) composableLambdaRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226700828, "CC(remember):Scaffold.kt#9igjgp");
            boolean z5 = (i3 & 896) == 256;
            ComposableLambda composableLambdaRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z5 || composableLambdaRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                scaffoldKt$ScaffoldLayout$contentPadding$1$1 = scaffoldKt$ScaffoldLayout$contentPadding$1$12;
                composableLambdaRememberedValue4 = ComposableLambdaKt.composableLambdaInstance(-1776388365, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$bodyContent$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C162@7826L31:Scaffold.kt#uh7d8r");
                        if (composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1776388365, i5, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:162)");
                            }
                            Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                            ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$13 = scaffoldKt$ScaffoldLayout$contentPadding$1$12;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, -931973261, "C162@7832L23:Scaffold.kt#uh7d8r");
                            function32.invoke(scaffoldKt$ScaffoldLayout$contentPadding$1$13, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue4);
            } else {
                scaffoldKt$ScaffoldLayout$contentPadding$1$1 = scaffoldKt$ScaffoldLayout$contentPadding$1$12;
            }
            final Function2 function28 = (Function2) composableLambdaRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226704802, "CC(remember):Scaffold.kt#9igjgp");
            boolean z6 = (3670016 & i3) == 1048576;
            ComposableLambda composableLambdaRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z6 || composableLambdaRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                z = true;
                composableLambdaRememberedValue5 = ComposableLambdaKt.composableLambdaInstance(-1731662488, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$bottomBarContent$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ComposerKt.sourceInformation(composer2, "C163@7937L19:Scaffold.kt#uh7d8r");
                        if (composer2.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1731662488, i5, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:163)");
                            }
                            Function2<Composer, Integer, Unit> function29 = function24;
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 79510070, "C163@7943L11:Scaffold.kt#uh7d8r");
                            function29.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue5);
            } else {
                z = true;
            }
            final Function2 function29 = (Function2) composableLambdaRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226712848, "CC(remember):Scaffold.kt#9igjgp");
            boolean zChanged = ((458752 & i3) == 131072 ? z : false) | composerStartRestartGroup.changed(function25) | composerStartRestartGroup.changed(function26) | composerStartRestartGroup.changed(function27) | ((i3 & 14) == 4 ? z : false) | composerStartRestartGroup.changed(function29) | composerStartRestartGroup.changed(function28);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                r2 = z;
                final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$13 = scaffoldKt$ScaffoldLayout$contentPadding$1$1;
                i4 = 0;
                Function2 function210 = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$15$lambda$14(windowInsets, function25, function26, function27, i, function29, scaffoldKt$ScaffoldLayout$contentPadding$1$13, function28, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function210);
                objRememberedValue2 = function210;
            } else {
                r2 = z;
                i4 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue2, composerStartRestartGroup, i4, r2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$16(i, function2, function3, function22, function23, windowInsets, function24, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult ScaffoldLayout_FMILGgc$lambda$15$lambda$14(final WindowInsets windowInsets, Function2 function2, Function2 function22, Function2 function23, int i, Function2 function24, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, Function2 function25, final SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        int i2;
        int i3;
        int i4;
        final FabPlacement fabPlacement;
        Integer numValueOf;
        float top;
        float bottom;
        int iIntValue;
        int height;
        int bottom2;
        final int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(constraints.getValue());
        final int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(constraints.getValue());
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 10, null);
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int left = windowInsets.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
        int right = windowInsets.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
        int bottom3 = windowInsets.getBottom(subcomposeMeasureScope2);
        final Placeable placeableMo7445measureBRTryo0 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2))).mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
        int i5 = (-left) - right;
        int i6 = -bottom3;
        final Placeable placeableMo7445measureBRTryo02 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22))).mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(jM8773copyZbe2FdA$default, i5, i6));
        final Placeable placeableMo7445measureBRTryo03 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23))).mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(jM8773copyZbe2FdA$default, i5, i6));
        if (placeableMo7445measureBRTryo03.getWidth() == 0 && placeableMo7445measureBRTryo03.getHeight() == 0) {
            fabPlacement = null;
        } else {
            int width = placeableMo7445measureBRTryo03.getWidth();
            int height2 = placeableMo7445measureBRTryo03.getHeight();
            if (FabPosition.m2911equalsimpl0(i, FabPosition.INSTANCE.m2918getStartERTFSPs())) {
                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    i2 = subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
                    i4 = i2 + left;
                } else {
                    i3 = subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
                    i4 = ((iM8783getMaxWidthimpl - i3) - width) - right;
                }
            } else if (FabPosition.m2911equalsimpl0(i, FabPosition.INSTANCE.m2916getEndERTFSPs()) || FabPosition.m2911equalsimpl0(i, FabPosition.INSTANCE.m2917getEndOverlayERTFSPs())) {
                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    i3 = subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
                    i4 = ((iM8783getMaxWidthimpl - i3) - width) - right;
                } else {
                    i2 = subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
                    i4 = i2 + left;
                }
            } else {
                i4 = (((iM8783getMaxWidthimpl - width) + left) - right) / 2;
            }
            fabPlacement = new FabPlacement(i4, width, height2);
        }
        final Placeable placeableMo7445measureBRTryo04 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, function24))).mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
        int i7 = 0;
        boolean z = placeableMo7445measureBRTryo04.getWidth() == 0 && placeableMo7445measureBRTryo04.getHeight() == 0;
        if (fabPlacement != null) {
            if (z || FabPosition.m2911equalsimpl0(i, FabPosition.INSTANCE.m2917getEndOverlayERTFSPs())) {
                height = fabPlacement.getHeight() + subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
                bottom2 = windowInsets.getBottom(subcomposeMeasureScope2);
            } else {
                height = placeableMo7445measureBRTryo04.getHeight() + fabPlacement.getHeight();
                bottom2 = subcomposeMeasureScope.mo482roundToPx0680j_4(FabSpacing);
            }
            numValueOf = Integer.valueOf(height + bottom2);
        } else {
            numValueOf = null;
        }
        int height3 = placeableMo7445measureBRTryo02.getHeight();
        if (height3 != 0) {
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                Integer numValueOf2 = Integer.valueOf(placeableMo7445measureBRTryo04.getHeight());
                numValueOf2.intValue();
                if (z) {
                    numValueOf2 = null;
                }
                iIntValue = numValueOf2 != null ? numValueOf2.intValue() : windowInsets.getBottom(subcomposeMeasureScope2);
            }
            i7 = iIntValue + height3;
        }
        PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(windowInsets, subcomposeMeasureScope2);
        if (placeableMo7445measureBRTryo0.getWidth() == 0 && placeableMo7445measureBRTryo0.getHeight() == 0) {
            top = paddingValuesAsPaddingValues.getTop();
        } else {
            top = subcomposeMeasureScope.mo485toDpu2uoSUM(placeableMo7445measureBRTryo0.getHeight());
        }
        if (z) {
            bottom = paddingValuesAsPaddingValues.getBottom();
        } else {
            bottom = subcomposeMeasureScope.mo485toDpu2uoSUM(placeableMo7445measureBRTryo04.getHeight());
        }
        final Integer num = numValueOf;
        scaffoldKt$ScaffoldLayout$contentPadding$1$1.setPaddingHolder(PaddingKt.m1147PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), top, PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom));
        final Placeable placeableMo7445measureBRTryo05 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, function25))).mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
        final int i8 = i7;
        return MeasureScope.layout$default(subcomposeMeasureScope, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$15$lambda$14$lambda$13(placeableMo7445measureBRTryo05, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo02, iM8783getMaxWidthimpl, windowInsets, subcomposeMeasureScope, iM8782getMaxHeightimpl, i8, placeableMo7445measureBRTryo04, fabPlacement, placeableMo7445measureBRTryo03, num, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_FMILGgc$lambda$15$lambda$14$lambda$13(Placeable placeable, Placeable placeable2, Placeable placeable3, int i, WindowInsets windowInsets, SubcomposeMeasureScope subcomposeMeasureScope, int i2, int i3, Placeable placeable4, FabPlacement fabPlacement, Placeable placeable5, Integer num, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, placeable2, 0, 0, 0.0f, 4, null);
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Placeable.PlacementScope.place$default(placementScope, placeable3, (((i - placeable3.getWidth()) + windowInsets.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) / 2, i2 - i3, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, placeable4, 0, i2 - placeable4.getHeight(), 0.0f, 4, null);
        if (fabPlacement != null) {
            int left = fabPlacement.getLeft();
            Intrinsics.checkNotNull(num);
            Placeable.PlacementScope.place$default(placementScope, placeable5, left, i2 - num.intValue(), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
