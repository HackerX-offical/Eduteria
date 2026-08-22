package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: LazySaveableStateHolder.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazySaveableStateHolderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazySaveableStateHolderProvider$lambda$2(Function3 function3, int i, Composer composer, int i2) {
        LazySaveableStateHolderProvider(function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LazySaveableStateHolderProvider(final Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-709502251);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LazySaveableStateHolderProvider)N(content)40@2007L7,41@2039L29,46@2234L91,43@2094L231,49@2399L19,49@2330L88:LazySaveableStateHolder.kt#wow0x6");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-709502251, i2, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:39)");
            }
            ProvidableCompositionLocal<SaveableStateRegistry> localSaveableStateRegistry = SaveableStateRegistryKt.getLocalSaveableStateRegistry();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSaveableStateRegistry);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) objConsume;
            final SaveableStateHolder saveableStateHolderRememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(composerStartRestartGroup, 0);
            Object[] objArr = {saveableStateRegistry};
            Saver<LazySaveableStateHolder, Map<String, List<Object>>> saver = LazySaveableStateHolder.INSTANCE.saver(saveableStateRegistry, saveableStateHolderRememberSaveableStateHolder);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1068148784, "CC(remember):LazySaveableStateHolder.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(saveableStateRegistry) | composerStartRestartGroup.changedInstance(saveableStateHolderRememberSaveableStateHolder);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LazySaveableStateHolderKt.LazySaveableStateHolderProvider$lambda$0$0(saveableStateRegistry, saveableStateHolderRememberSaveableStateHolder);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            CompositionLocalKt.CompositionLocalProvider(SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(lazySaveableStateHolder), ComposableLambdaKt.rememberComposableLambda(-412824043, true, new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazySaveableStateHolderKt.LazySaveableStateHolderProvider$lambda$1(function3, lazySaveableStateHolder, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazySaveableStateHolderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LazySaveableStateHolderKt.LazySaveableStateHolderProvider$lambda$2(function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazySaveableStateHolder LazySaveableStateHolderProvider$lambda$0$0(SaveableStateRegistry saveableStateRegistry, SaveableStateHolder saveableStateHolder) {
        return new LazySaveableStateHolder(saveableStateRegistry, MapsKt.emptyMap(), saveableStateHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazySaveableStateHolderProvider$lambda$1(Function3 function3, LazySaveableStateHolder lazySaveableStateHolder, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@2401L15:LazySaveableStateHolder.kt#wow0x6");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-412824043, i, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:49)");
            }
            function3.invoke(lazySaveableStateHolder, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
