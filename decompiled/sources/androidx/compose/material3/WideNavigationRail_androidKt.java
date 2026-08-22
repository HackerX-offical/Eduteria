package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: WideNavigationRail.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a`\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u0015\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000eX\u008a\u0084\u0002"}, d2 = {"createDefaultModalWideNavigationRailProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRailDialog", "", "onDismissRequest", "Lkotlin/Function0;", JivePropertiesExtension.ELEMENT, "onPredictiveBack", "Lkotlin/Function1;", "", "onPredictiveBackCancelled", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRail_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailDialog$lambda$10(Function0 function0, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function1 function1, Function0 function02, RailPredictiveBackState railPredictiveBackState, Function2 function2, int i, Composer composer, int i2) {
        ModalWideNavigationRailDialog(function0, modalWideNavigationRailProperties, function1, function02, railPredictiveBackState, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final ModalWideNavigationRailProperties createDefaultModalWideNavigationRailProperties() {
        return new ModalWideNavigationRailProperties(false, 1, null);
    }

    public static final void ModalWideNavigationRailDialog(Function0<Unit> function0, final ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function1<? super Float, Unit> function1, final Function0<Unit> function02, final RailPredictiveBackState railPredictiveBackState, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        Object obj;
        final Function0<Unit> function03 = function0;
        Composer composerStartRestartGroup = composer.startRestartGroup(2015914411);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRailDialog)N(onDismissRequest,properties,onPredictiveBack,onPredictiveBackCancelled,predictiveBackState,content)125@5147L7,126@5186L7,127@5241L7,128@5271L28,129@5326L29,130@5392L21,130@5375L38,131@5441L21,133@5488L652,153@6171L129,153@6146L154,162@6317L183,162@6306L194:WideNavigationRail.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function03) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modalWideNavigationRailProperties) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(railPredictiveBackState) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015914411, i2, -1, "androidx.compose.material3.ModalWideNavigationRailDialog (WideNavigationRail.android.kt:124)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View view = (View) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i2 >> 15) & 14);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 263517408, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 263521111, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(view) | composerStartRestartGroup.changed(density);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i3 = 0;
                i4 = i2;
                function03 = function0;
                ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper = new ModalWideNavigationRailDialogWrapper(function03, modalWideNavigationRailProperties, view, layoutDirection, density, uuid, function1, function02, railPredictiveBackState, zIsSystemInDarkTheme);
                i5 = 1;
                modalWideNavigationRailDialogWrapper.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(-406777160, true, new WideNavigationRail_androidKt$ModalWideNavigationRailDialog$dialog$1$1$1(stateRememberUpdatedState)));
                composerStartRestartGroup.updateRememberedValue(modalWideNavigationRailDialogWrapper);
                obj = modalWideNavigationRailDialogWrapper;
            } else {
                i4 = i2;
                i5 = 1;
                i3 = 0;
                function03 = function0;
                obj = objRememberedValue2;
            }
            final ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper2 = (ModalWideNavigationRailDialogWrapper) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 263542444, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(modalWideNavigationRailDialogWrapper2);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$7$lambda$6(modalWideNavigationRailDialogWrapper2, (DisposableEffectScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(modalWideNavigationRailDialogWrapper2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 263547170, "CC(remember):WideNavigationRail.android.kt#9igjgp");
            int i6 = (composerStartRestartGroup.changedInstance(modalWideNavigationRailDialogWrapper2) ? 1 : 0) | ((i4 & 14) == 4 ? i5 : i3);
            if ((i4 & 112) != 32) {
                i5 = i3;
            }
            int i7 = i6 | i5 | (composerStartRestartGroup.changed(layoutDirection.ordinal()) ? 1 : 0);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (i7 != 0 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$9$lambda$8(modalWideNavigationRailDialogWrapper2, function03, modalWideNavigationRailProperties, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return WideNavigationRail_androidKt.ModalWideNavigationRailDialog$lambda$10(function03, modalWideNavigationRailProperties, function1, function02, railPredictiveBackState, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ModalWideNavigationRailDialog$lambda$7$lambda$6(final ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper, DisposableEffectScope disposableEffectScope) {
        modalWideNavigationRailDialogWrapper.show();
        return new DisposableEffectResult() { // from class: androidx.compose.material3.WideNavigationRail_androidKt$ModalWideNavigationRailDialog$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                modalWideNavigationRailDialogWrapper.dismiss();
                modalWideNavigationRailDialogWrapper.disposeComposition();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailDialog$lambda$9$lambda$8(ModalWideNavigationRailDialogWrapper modalWideNavigationRailDialogWrapper, Function0 function0, ModalWideNavigationRailProperties modalWideNavigationRailProperties, LayoutDirection layoutDirection) {
        modalWideNavigationRailDialogWrapper.updateParameters(function0, modalWideNavigationRailProperties, layoutDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalWideNavigationRailDialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}
