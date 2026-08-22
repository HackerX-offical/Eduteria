package androidx.compose.material3;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$Snackbar$actionComposable$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $actionColor;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ SnackbarData $snackbarData;

    SnackbarKt$Snackbar$actionComposable$1(long j, SnackbarData snackbarData, String str) {
        this.$actionColor = j;
        this.$snackbarData = snackbarData;
        this.$actionLabel = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C212@10023L44,213@10099L32,214@10163L21,211@9967L236:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1378313599, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:211)");
        }
        ButtonColors buttonColorsM2519textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2519textButtonColorsro_MJ88(0L, this.$actionColor, 0L, 0L, composer, 24576, 13);
        ComposerKt.sourceInformationMarkerStart(composer, -1709436639, "CC(remember):Snackbar.kt#9igjgp");
        boolean zChanged = composer.changed(this.$snackbarData);
        final SnackbarData snackbarData = this.$snackbarData;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SnackbarKt$Snackbar$actionComposable$1.invoke$lambda$1$lambda$0(snackbarData);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        final String str = this.$actionLabel;
        ButtonKt.TextButton(function0, null, false, null, buttonColorsM2519textButtonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(521110564, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$actionComposable$1.2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer2, int i2) {
                ComposerKt.sourceInformation(composer2, "C214@10165L17:Snackbar.kt#uh7d8r");
                if (!composer2.shouldExecute((i2 & 17) != 16, i2 & 1)) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(521110564, i2, -1, "androidx.compose.material3.Snackbar.<anonymous>.<anonymous> (Snackbar.kt:214)");
                }
                TextKt.m3703TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262142);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, C.ENCODING_PCM_32BIT, 494);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SnackbarData snackbarData) {
        snackbarData.performAction();
        return Unit.INSTANCE;
    }
}
