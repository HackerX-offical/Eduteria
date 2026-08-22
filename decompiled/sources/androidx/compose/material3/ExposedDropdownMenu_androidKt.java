package androidx.compose.material3;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0003¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material3/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "popupPropertiesForAnchorType", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "alwaysFocusable", "", "popupPropertiesForAnchorType-BTG8-q0", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "SoftKeyboardListener", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "material3", "a11yServicesEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnPlatformWindowBoundsChange$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        OnPlatformWindowBoundsChange(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SoftKeyboardListener$lambda$6(View view, Density density, Function0 function0, int i, Composer composer, int i2) {
        SoftKeyboardListener(view, density, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 703324275, "C(platformWindowBoundsCalculator)41@1650L7,42@1683L7,43@1702L55:ExposedDropdownMenu.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(703324275, i, -1, "androidx.compose.material3.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:40)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        View view = (View) objConsume2;
        ComposerKt.sourceInformationMarkerStart(composer, 1584768586, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        boolean zChanged = composer.changed((Configuration) objConsume) | composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new WindowBoundsCalculator(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        WindowBoundsCalculator windowBoundsCalculator = (WindowBoundsCalculator) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowBoundsCalculator;
    }

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1646555525);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnPlatformWindowBoundsChange)N(block)48@1868L7,49@1907L7,50@1919L42:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1646555525, i2, -1, "androidx.compose.material3.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:47)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SoftKeyboardListener((View) objConsume, (Density) objConsume2, function0, composerStartRestartGroup, (i2 << 6) & 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange$lambda$1(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: popupPropertiesForAnchorType-BTG8-q0, reason: not valid java name */
    public static final PopupProperties m2907popupPropertiesForAnchorTypeBTG8q0(String str, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 895018515, "C(popupPropertiesForAnchorType)N(anchorType:c#material3.ExposedDropdownMenuAnchorType,alwaysFocusable)58@2156L35:ExposedDropdownMenu.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(895018515, i, -1, "androidx.compose.material3.popupPropertiesForAnchorType (ExposedDropdownMenu.android.kt:57)");
        }
        State<Boolean> stateRememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, composer, 0, 7);
        int i2 = !popupPropertiesForAnchorType_BTG8_q0$lambda$2(stateRememberAccessibilityServiceState) ? 393248 : 393216;
        if ((ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2879getPrimaryEditableoYjWRB4()) || (ExposedDropdownMenuAnchorType.m2875equalsimpl0(str, ExposedDropdownMenuAnchorType.INSTANCE.m2881getSecondaryEditableoYjWRB4()) && !popupPropertiesForAnchorType_BTG8_q0$lambda$2(stateRememberAccessibilityServiceState))) && !z) {
            i2 |= 8;
        }
        PopupProperties popupProperties = new PopupProperties(i2, false, false, false, false, false, 62, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return popupProperties;
    }

    private static final void SoftKeyboardListener(final View view, final Density density, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SoftKeyboardListener)N(view,density,onKeyboardVisibilityChange)88@3457L1420,88@3425L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(density) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:85)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1045730588, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenu_androidKt.SoftKeyboardListener$lambda$5$lambda$4(view, function0, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(view, density, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenu_androidKt.SoftKeyboardListener$lambda$6(view, density, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SoftKeyboardListener$lambda$5$lambda$4(View view, Function0 function0, DisposableEffectScope disposableEffectScope) {
        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(view, function0);
        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                exposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1.dispose();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect getWindowBounds(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeIntRect(rect);
    }

    private static final boolean popupPropertiesForAnchorType_BTG8_q0$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
