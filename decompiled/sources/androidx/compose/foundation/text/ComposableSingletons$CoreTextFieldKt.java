package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: CoreTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$CoreTextFieldKt {
    public static final ComposableSingletons$CoreTextFieldKt INSTANCE = new ComposableSingletons$CoreTextFieldKt();
    private static Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$559628295 = ComposableLambdaKt.composableLambdaInstance(559628295, false, new Function3() { // from class: androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$CoreTextFieldKt.lambda_559628295$lambda$0((Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getLambda$559628295$foundation() {
        return lambda$559628295;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_559628295$lambda$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(innerTextField)206@11693L16:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i |= composer.changedInstance(function2) ? 4 : 2;
        }
        if (composer.shouldExecute((i & 19) != 18, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(559628295, i, -1, "androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.lambda$559628295.<anonymous> (CoreTextField.kt:206)");
            }
            function2.invoke(composer, Integer.valueOf(i & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
