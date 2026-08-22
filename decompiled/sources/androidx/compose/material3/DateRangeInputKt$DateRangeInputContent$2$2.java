package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DateRangeInput.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class DateRangeInputKt$DateRangeInputContent$2$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $pattern;
    final /* synthetic */ String $startRangeText;

    DateRangeInputKt$DateRangeInputContent$2$2(String str, String str2) {
        this.$startRangeText = str;
        this.$pattern = str2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C83@3602L52,80@3486L187:DateRangeInput.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1740538748, i, -1, "androidx.compose.material3.DateRangeInputContent.<anonymous>.<anonymous> (DateRangeInput.kt:80)");
        }
        String str = this.$startRangeText;
        Modifier.Companion companion = Modifier.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 1915463024, "CC(remember):DateRangeInput.kt#9igjgp");
        boolean zChanged = composer.changed(this.$startRangeText) | composer.changed(this.$pattern);
        final String str2 = this.$startRangeText;
        final String str3 = this.$pattern;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.DateRangeInputKt$DateRangeInputContent$2$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DateRangeInputKt$DateRangeInputContent$2$2.invoke$lambda$1$lambda$0(str2, str3, (SemanticsPropertyReceiver) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TextKt.m3703TextNvy7gAk(str, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262140);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str + ", " + str2);
        return Unit.INSTANCE;
    }
}
