package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SnackbarHost.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$SnackbarHostKt {
    public static final ComposableSingletons$SnackbarHostKt INSTANCE = new ComposableSingletons$SnackbarHostKt();

    /* JADX INFO: renamed from: lambda$-1548712596, reason: not valid java name */
    private static Function3<SnackbarData, Composer, Integer, Unit> f33lambda$1548712596 = ComposableLambdaKt.composableLambdaInstance(-1548712596, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$SnackbarHostKt$lambda$-1548712596$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            invoke(snackbarData, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData snackbarData, Composer composer, int i) {
            SnackbarData snackbarData2;
            int i2;
            ComposerKt.sourceInformation(composer, "CN(it)219@9383L12:SnackbarHost.kt#uh7d8r");
            if ((i & 6) == 0) {
                snackbarData2 = snackbarData;
                i2 = i | (composer.changed(snackbarData2) ? 4 : 2);
            } else {
                snackbarData2 = snackbarData;
                i2 = i;
            }
            if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1548712596, i2, -1, "androidx.compose.material3.ComposableSingletons$SnackbarHostKt.lambda$-1548712596.<anonymous> (SnackbarHost.kt:219)");
            }
            SnackbarKt.m3517SnackbarsDKtq54(snackbarData2, null, false, null, 0L, 0L, 0L, 0L, 0L, composer, i2 & 14, TypedValues.PositionType.TYPE_POSITION_TYPE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda$-1548712596$material3, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m2707getLambda$1548712596$material3() {
        return f33lambda$1548712596;
    }
}
