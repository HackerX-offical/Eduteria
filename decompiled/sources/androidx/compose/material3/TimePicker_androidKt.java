package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimePicker.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePicker_androidKt {
    public static final int defaultTimePickerLayoutType(Composer composer, int i) {
        int iM3782getVerticalQJTpgSE;
        ComposerKt.sourceInformationMarkerStart(composer, -721362352, "C(defaultTimePickerLayoutType)26@977L7:TimePicker.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721362352, i, -1, "androidx.compose.material3.defaultTimePickerLayoutType (TimePicker.android.kt:26)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        if (configuration.screenHeightDp < configuration.screenWidthDp) {
            iM3782getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m3781getHorizontalQJTpgSE();
        } else {
            iM3782getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m3782getVerticalQJTpgSE();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM3782getVerticalQJTpgSE;
    }
}
