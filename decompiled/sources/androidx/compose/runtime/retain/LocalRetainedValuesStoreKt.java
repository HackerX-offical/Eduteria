package androidx.compose.runtime.retain;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jivesoftware.smackx.hints.element.StoreHint;

/* JADX INFO: compiled from: LocalRetainedValuesStore.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"LocalRetainedValuesStore", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "getLocalRetainedValuesStore", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalRetainedValuesStoreProvider", "", StoreHint.ELEMENT, "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/retain/RetainedValuesStore;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "runtime-retain"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LocalRetainedValuesStoreKt {
    private static final ProvidableCompositionLocal<RetainedValuesStore> LocalRetainedValuesStore = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.runtime.retain.LocalRetainedValuesStoreKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LocalRetainedValuesStoreKt.LocalRetainedValuesStore$lambda$0();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalRetainedValuesStoreProvider$lambda$2(RetainedValuesStore retainedValuesStore, Function2 function2, int i, Composer composer, int i2) {
        LocalRetainedValuesStoreProvider(retainedValuesStore, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final ProvidableCompositionLocal<RetainedValuesStore> getLocalRetainedValuesStore() {
        return LocalRetainedValuesStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RetainedValuesStore LocalRetainedValuesStore$lambda$0() {
        return ForgetfulRetainedValuesStore.INSTANCE;
    }

    public static final void LocalRetainedValuesStoreProvider(final RetainedValuesStore retainedValuesStore, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-358532755);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LocalRetainedValuesStoreProvider)N(store,content)78@3847L74,83@4142L67:LocalRetainedValuesStore.kt#3my55w");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(retainedValuesStore) : composerStartRestartGroup.changedInstance(retainedValuesStore) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        boolean z = false;
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-358532755, i2, -1, "androidx.compose.runtime.retain.LocalRetainedValuesStoreProvider (LocalRetainedValuesStore.kt:77)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalRetainedValuesStore.provides(retainedValuesStore), function2, composerStartRestartGroup, ProvidedValue.$stable | (i2 & 112));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -952580688, "CC(remember):LocalRetainedValuesStore.kt#9igjgp");
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changed(retainedValuesStore))) {
                z = true;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new RetainContentPresenceIndicator(retainedValuesStore, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((RetainContentPresenceIndicator) objRememberedValue).setComposer(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.runtime.retain.LocalRetainedValuesStoreKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocalRetainedValuesStoreKt.LocalRetainedValuesStoreProvider$lambda$2(retainedValuesStore, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
