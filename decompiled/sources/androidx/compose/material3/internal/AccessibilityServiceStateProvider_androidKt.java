package androidx.compose.material3.internal;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessibilityServiceStateProvider.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0003¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"rememberAccessibilityServiceState", "Landroidx/compose/runtime/State;", "", "listenToTouchExplorationState", "listenToSwitchAccessState", "listenToVoiceAccessState", "(ZZZLandroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "ObserveState", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "handleEvent", "Lkotlin/Function1;", "Landroidx/lifecycle/Lifecycle$Event;", "onDispose", "Lkotlin/Function0;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SwitchAccessActivityName", "", "VoiceAccessActivityName", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AccessibilityServiceStateProvider_androidKt {
    private static final String SwitchAccessActivityName = "SwitchAccess";
    private static final String VoiceAccessActivityName = "VoiceAccess";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveState$lambda$13(LifecycleOwner lifecycleOwner, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        ObserveState(lifecycleOwner, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final State<Boolean> rememberAccessibilityServiceState(boolean z, boolean z2, boolean z3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 432241692, "C(rememberAccessibilityServiceState)N(listenToTouchExplorationState,listenToSwitchAccessState,listenToVoiceAccessState)47@1997L7,52@2152L406,65@2623L7,66@2654L144,71@2820L45,64@2564L308:AccessibilityServiceStateProvider.android.kt#mqatfk");
        boolean z4 = true;
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        boolean z5 = (i2 & 4) != 0 ? true : z3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(432241692, i, -1, "androidx.compose.material3.internal.rememberAccessibilityServiceState (AccessibilityServiceStateProvider.android.kt:46)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object systemService = ((Context) objConsume).getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        final AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        ComposerKt.sourceInformationMarkerStart(composer, -1227548622, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
        boolean z6 = ((((i & 14) ^ 6) > 4 && composer.changed(z)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(z2)) || (i & 48) == 32);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(z5)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z4 = false;
        }
        boolean z7 = z6 | z4;
        Object objRememberedValue = composer.rememberedValue();
        if (z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Listener(z, z2, z5);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Listener listener = (Listener) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume2;
        ComposerKt.sourceInformationMarkerStart(composer, -1227532820, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
        boolean zChanged = composer.changed(listener) | composer.changedInstance(accessibilityManager);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState$lambda$2$lambda$1(listener, accessibilityManager, (Lifecycle.Event) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function1 = (Function1) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1227527607, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
        boolean zChanged2 = composer.changed(listener) | composer.changedInstance(accessibilityManager);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState$lambda$4$lambda$3(listener, accessibilityManager);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ObserveState(lifecycleOwner, function1, (Function0) objRememberedValue3, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberAccessibilityServiceState$lambda$2$lambda$1(Listener listener, AccessibilityManager accessibilityManager, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_RESUME) {
            listener.register(accessibilityManager);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberAccessibilityServiceState$lambda$4$lambda$3(Listener listener, AccessibilityManager accessibilityManager) {
        listener.unregister(accessibilityManager);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveState$lambda$6$lambda$5(Lifecycle.Event event) {
        return Unit.INSTANCE;
    }

    private static final void ObserveState(final LifecycleOwner lifecycleOwner, final Function1<? super Lifecycle.Event, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1868327245);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ObserveState)N(lifecycleOwner,handleEvent,onDispose)80@3016L2,81@3048L2,83@3093L259,83@3060L292:AccessibilityServiceStateProvider.android.kt#mqatfk");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(lifecycleOwner) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -166148907, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$6$lambda$5((Lifecycle.Event) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -166147883, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1868327245, i3, -1, "androidx.compose.material3.internal.ObserveState (AccessibilityServiceStateProvider.android.kt:82)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -166146186, "CC(remember):AccessibilityServiceStateProvider.android.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(lifecycleOwner) | ((i3 & 896) == 256);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$12$lambda$11(lifecycleOwner, function1, function0, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function1<? super Lifecycle.Event, Unit> function12 = function1;
        final Function0<Unit> function02 = function0;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccessibilityServiceStateProvider_androidKt.ObserveState$lambda$13(lifecycleOwner, function12, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ObserveState$lambda$12$lambda$11(final LifecycleOwner lifecycleOwner, final Function1 function1, final Function0 function0, DisposableEffectScope disposableEffectScope) {
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                function1.invoke(event);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt$ObserveState$lambda$12$lambda$11$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                function0.invoke();
                lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
            }
        };
    }
}
