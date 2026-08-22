package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevation;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "shadowElevation", "Landroidx/compose/runtime/State;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "shadowElevation$material3", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tonalElevation", "tonalElevation-D9Ej5fM$material3", "()F", "animateElevation", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class FloatingActionButtonElevation {
    public static final int $stable = 0;
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    public /* synthetic */ FloatingActionButtonElevation(float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f2, f3, f4, f5);
    }

    private FloatingActionButtonElevation(float f2, float f3, float f4, float f5) {
        this.defaultElevation = f2;
        this.pressedElevation = f3;
        this.focusedElevation = f4;
        this.hoveredElevation = f5;
    }

    public final State<Dp> shadowElevation$material3(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -424810125, "C(shadowElevation)N(interactionSource)620@28145L55:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-424810125, i, -1, "androidx.compose.material3.FloatingActionButtonElevation.shadowElevation (FloatingActionButton.kt:619)");
        }
        State<Dp> stateAnimateElevation = animateElevation(interactionSource, composer, i & 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateElevation;
    }

    /* JADX INFO: renamed from: tonalElevation-D9Ej5fM$material3, reason: not valid java name and from getter */
    public final float getDefaultElevation() {
        return this.defaultElevation;
    }

    private final State<Dp> animateElevation(InteractionSource interactionSource, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1845106002, "C(animateElevation)N(interactionSource)630@28424L346,639@28801L277,639@28780L298,648@29122L1282,648@29088L1316:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1845106002, i, -1, "androidx.compose.material3.FloatingActionButtonElevation.animateElevation (FloatingActionButton.kt:628)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 674629928, "CC(remember):FloatingActionButton.kt#9igjgp");
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z = (i3 > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object floatingActionButtonElevationAnimatable = new FloatingActionButtonElevationAnimatable(this.defaultElevation, this.pressedElevation, this.hoveredElevation, this.focusedElevation, null);
            composer.updateRememberedValue(floatingActionButtonElevationAnimatable);
            objRememberedValue = floatingActionButtonElevationAnimatable;
        }
        FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable2 = (FloatingActionButtonElevationAnimatable) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 674641923, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(floatingActionButtonElevationAnimatable2) | ((((i & 112) ^ 48) > 32 && composer.changed(this)) || (i & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new FloatingActionButtonElevation$animateElevation$1$1(floatingActionButtonElevationAnimatable2, this, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(this, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, (i >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 674653200, "CC(remember):FloatingActionButton.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(floatingActionButtonElevationAnimatable2) | ((i3 > 4 && composer.changed(interactionSource)) || (i & 6) == 4);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new FloatingActionButtonElevation$animateElevation$2$1(interactionSource, floatingActionButtonElevationAnimatable2, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, i2);
        State<Dp> stateAsState = floatingActionButtonElevationAnimatable2.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAsState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof FloatingActionButtonElevation)) {
            return false;
        }
        FloatingActionButtonElevation floatingActionButtonElevation = (FloatingActionButtonElevation) other;
        if (Dp.m8835equalsimpl0(this.defaultElevation, floatingActionButtonElevation.defaultElevation) && Dp.m8835equalsimpl0(this.pressedElevation, floatingActionButtonElevation.pressedElevation) && Dp.m8835equalsimpl0(this.focusedElevation, floatingActionButtonElevation.focusedElevation)) {
            return Dp.m8835equalsimpl0(this.hoveredElevation, floatingActionButtonElevation.hoveredElevation);
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m8836hashCodeimpl(this.defaultElevation) * 31) + Dp.m8836hashCodeimpl(this.pressedElevation)) * 31) + Dp.m8836hashCodeimpl(this.focusedElevation)) * 31) + Dp.m8836hashCodeimpl(this.hoveredElevation);
    }
}
