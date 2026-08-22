package androidx.compose.foundation.style;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: StyleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0082\b\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u0018\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u0019\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u001a\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0014\u0010\u001c\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a3\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00110\"¢\u0006\u0002\b$H\u0087\b¢\u0006\u0002\u0010%\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"PressedStateMask", "", "HoveredStateMask", "FocusedStateMask", "SelectedStateMask", "EnabledStateMask", "ToggleStateShift", "ToggleStateOff", "ToggleStateOn", "ToggleStateIndeterminate", "ToggleStateMask", "updateFromMask", "predefinedState", "mask", "include", "", "checked", "", "Landroidx/compose/foundation/style/StyleScope;", "value", "Landroidx/compose/foundation/style/Style;", "disabled", "focused", "hovered", "pressed", "selected", "triStateToggleOn", "triStateToggleOff", "triStateToggleIndeterminate", "rememberUpdatedStyleState", "Landroidx/compose/foundation/style/StyleState;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/style/MutableStyleState;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/style/StyleState;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StyleStateKt {
    private static final int EnabledStateMask = 16;
    private static final int FocusedStateMask = 4;
    private static final int HoveredStateMask = 2;
    private static final int PressedStateMask = 1;
    private static final int SelectedStateMask = 8;
    private static final int ToggleStateIndeterminate = 64;
    private static final int ToggleStateMask = 96;
    private static final int ToggleStateOff = 0;
    private static final int ToggleStateOn = 32;
    private static final int ToggleStateShift = 5;

    private static final int updateFromMask(int i, int i2, boolean z) {
        int i3 = i & (~i2);
        if (!z) {
            i2 = 0;
        }
        return i3 | i2;
    }

    public static final void checked(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getToggle(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.checked$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean checked$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.isChecked();
    }

    public static final void disabled(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getEnabled(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.disabled$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disabled$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return !styleState.isEnabled();
    }

    public static final void focused(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getFocused(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.focused$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean focused$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.isFocused();
    }

    public static final void hovered(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getHovered(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.hovered$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hovered$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.isHovered();
    }

    public static final void pressed(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getPressed(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.pressed$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pressed$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.isPressed();
    }

    public static final void selected(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getSelected(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.selected$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean selected$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.isSelected();
    }

    public static final void triStateToggleOn(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getToggle(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.triStateToggleOn$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean triStateToggleOn$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.getTriStateToggle() == ToggleableState.On;
    }

    public static final void triStateToggleOff(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getToggle(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.triStateToggleOff$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean triStateToggleOff$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.getTriStateToggle() == ToggleableState.Off;
    }

    public static final void triStateToggleIndeterminate(StyleScope styleScope, Style style) {
        styleScope.state(StyleStateKey.INSTANCE.getToggle(), style, new Function2() { // from class: androidx.compose.foundation.style.StyleStateKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(StyleStateKt.triStateToggleIndeterminate$lambda$0((StyleStateKey) obj, (StyleState) obj2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean triStateToggleIndeterminate$lambda$0(StyleStateKey styleStateKey, StyleState styleState) {
        return styleState.getTriStateToggle() == ToggleableState.Indeterminate;
    }

    public static final StyleState rememberUpdatedStyleState(InteractionSource interactionSource, Function3<? super MutableStyleState, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 172476298, "CC(rememberUpdatedStyleState)N(interactionSource,block)646@25304L68,647@25377L24:StyleState.kt#g8yfp3");
        if ((i2 & 2) != 0) {
            function3 = new Function3<MutableStyleState, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.style.StyleStateKt.rememberUpdatedStyleState.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(MutableStyleState mutableStyleState, Composer composer2, Integer num) {
                    invoke(mutableStyleState, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MutableStyleState mutableStyleState, Composer composer2, int i3) {
                    ComposerKt.sourceInformationMarkerStart(composer2, -879283608, "CN(it):StyleState.kt#g8yfp3");
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                }
            };
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1753996498, "CC(remember):StyleState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(interactionSource)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new MutableStyleState(interactionSource);
            composer.updateRememberedValue(objRememberedValue);
        }
        MutableStyleState mutableStyleState = (MutableStyleState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        function3.invoke(mutableStyleState, composer, Integer.valueOf(i & 112));
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableStyleState;
    }
}
