package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ListItemKt {
    public static final ComposableSingletons$ListItemKt INSTANCE = new ComposableSingletons$ListItemKt();

    /* JADX INFO: renamed from: lambda$-489887388, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f25lambda$489887388 = ComposableLambdaKt.composableLambdaInstance(-489887388, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$lambda$-489887388$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-489887388, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$-489887388.<anonymous> (ListItem.kt:185)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1629163587 = ComposableLambdaKt.composableLambdaInstance(1629163587, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$lambda$1629163587$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1629163587, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$1629163587.<anonymous> (ListItem.kt:185)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-546752734, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f26lambda$546752734 = ComposableLambdaKt.composableLambdaInstance(-546752734, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$lambda$-546752734$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-546752734, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$-546752734.<anonymous> (ListItem.kt:185)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1572298241 = ComposableLambdaKt.composableLambdaInstance(1572298241, false, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ComposableSingletons$ListItemKt$lambda$1572298241$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
            if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1572298241, i, -1, "androidx.compose.material3.ComposableSingletons$ListItemKt.lambda$1572298241.<anonymous> (ListItem.kt:185)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda$-489887388$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2699getLambda$489887388$material3() {
        return f25lambda$489887388;
    }

    /* JADX INFO: renamed from: getLambda$-546752734$material3, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m2700getLambda$546752734$material3() {
        return f26lambda$546752734;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1572298241$material3() {
        return lambda$1572298241;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1629163587$material3() {
        return lambda$1629163587;
    }
}
