package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WideNavigationRailState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\b\u001a\u00020\u0003*\u00020\u0003H\u0080\u0002\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"rememberWideNavigationRailState", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailState;", "isExpanded", "", "(Landroidx/compose/material3/WideNavigationRailValue;)Z", "not", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailStateKt {
    public static final WideNavigationRailState rememberWideNavigationRailState(final WideNavigationRailValue wideNavigationRailValue, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1595273472, "C(rememberWideNavigationRailState)N(initialValue)88@3279L14,89@3380L103,89@3305L178:WideNavigationRailState.kt#uh7d8r");
        boolean z = true;
        if ((i2 & 1) != 0) {
            wideNavigationRailValue = WideNavigationRailValue.Collapsed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595273472, i, -1, "androidx.compose.material3.rememberWideNavigationRailState (WideNavigationRailState.kt:86)");
        }
        final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
        Object[] objArr = new Object[0];
        Saver<WideNavigationRailState, WideNavigationRailValue> Saver = WideNavigationRailStateImpl.INSTANCE.Saver(finiteAnimationSpecValue);
        ComposerKt.sourceInformationMarkerStart(composer, -245505433, "CC(remember):WideNavigationRailState.kt#9igjgp");
        if ((((i & 14) ^ 6) <= 4 || !composer.changed(wideNavigationRailValue.ordinal())) && (i & 6) != 4) {
            z = false;
        }
        boolean zChangedInstance = composer.changedInstance(finiteAnimationSpecValue) | z;
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.WideNavigationRailStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WideNavigationRailStateKt.rememberWideNavigationRailState$lambda$1$lambda$0(wideNavigationRailValue, finiteAnimationSpecValue);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        WideNavigationRailState wideNavigationRailState = (WideNavigationRailState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return wideNavigationRailState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WideNavigationRailState rememberWideNavigationRailState$lambda$1$lambda$0(WideNavigationRailValue wideNavigationRailValue, FiniteAnimationSpec finiteAnimationSpec) {
        return new WideNavigationRailStateImpl(wideNavigationRailValue, finiteAnimationSpec);
    }

    public static final boolean isExpanded(WideNavigationRailValue wideNavigationRailValue) {
        return wideNavigationRailValue == WideNavigationRailValue.Expanded;
    }

    public static final WideNavigationRailValue not(WideNavigationRailValue wideNavigationRailValue) {
        if (wideNavigationRailValue == WideNavigationRailValue.Collapsed) {
            return WideNavigationRailValue.Expanded;
        }
        return WideNavigationRailValue.Collapsed;
    }
}
