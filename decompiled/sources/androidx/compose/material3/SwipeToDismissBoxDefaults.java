package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SwipeToDismissBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u00058G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxDefaults;", "", "<init>", "()V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "getPositionalThreshold", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissBoxDefaults {
    public static final int $stable = 0;
    public static final SwipeToDismissBoxDefaults INSTANCE = new SwipeToDismissBoxDefaults();

    private SwipeToDismissBoxDefaults() {
    }

    public final Function1<Float, Float> getPositionalThreshold(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1545861529, "C(<get-positionalThreshold>)362@15187L7:SwipeToDismissBox.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1545861529, i, -1, "androidx.compose.material3.SwipeToDismissBoxDefaults.<get-positionalThreshold> (SwipeToDismissBox.kt:362)");
        }
        composer.startReplaceGroup(-485754360);
        ComposerKt.sourceInformation(composer, "*362@15198L16");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, 778513148, "CC(remember):SwipeToDismissBox.kt#9igjgp");
        boolean zChanged = composer.changed(density);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.SwipeToDismissBoxDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Float.valueOf(SwipeToDismissBoxDefaults._get_positionalThreshold_$lambda$2$lambda$1$lambda$0(density, ((Float) obj).floatValue()));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function1<Float, Float> function1 = (Function1) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _get_positionalThreshold_$lambda$2$lambda$1$lambda$0(Density density, float f2) {
        return density.mo488toPx0680j_4(Dp.m8830constructorimpl(56));
    }
}
