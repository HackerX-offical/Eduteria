package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberAppBarOverflowState", "Landroidx/compose/material3/AppBarOverflowState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/AppBarOverflowState;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarDslKt {
    public static final AppBarOverflowState rememberAppBarOverflowState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 209837519, "C(rememberAppBarOverflowState)265@8053L29,265@7997L85:AppBarDsl.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(209837519, i, -1, "androidx.compose.material3.rememberAppBarOverflowState (AppBarDsl.kt:264)");
        }
        Object[] objArr = new Object[0];
        Saver<AppBarOverflowStateImpl, ?> saver = AppBarOverflowStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -209602484, "CC(remember):AppBarDsl.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBarDslKt.rememberAppBarOverflowState$lambda$1$lambda$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AppBarOverflowStateImpl appBarOverflowStateImpl = (AppBarOverflowStateImpl) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, RendererCapabilities.DECODER_SUPPORT_MASK);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return appBarOverflowStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarOverflowStateImpl rememberAppBarOverflowState$lambda$1$lambda$0() {
        return new AppBarOverflowStateImpl();
    }
}
