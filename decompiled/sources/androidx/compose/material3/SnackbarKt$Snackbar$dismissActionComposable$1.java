package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SnackbarKt$Snackbar$dismissActionComposable$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ SnackbarData $snackbarData;

    SnackbarKt$Snackbar$dismissActionComposable$1(SnackbarData snackbarData) {
        this.$snackbarData = snackbarData;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(SnackbarData snackbarData) {
        snackbarData.dismiss();
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C224@10461L26,223@10419L331:Snackbar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1812633777, i, -1, "androidx.compose.material3.Snackbar.<anonymous> (Snackbar.kt:223)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1815664425, "CC(remember):Snackbar.kt#9igjgp");
        boolean zChanged = composer.changed(this.$snackbarData);
        final SnackbarData snackbarData = this.$snackbarData;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SnackbarKt$Snackbar$dismissActionComposable$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SnackbarKt$Snackbar$dismissActionComposable$1.invoke$lambda$1$lambda$0(snackbarData);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$SnackbarKt.INSTANCE.getLambda$984817901$material3(), composer, 1572864, 62);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
