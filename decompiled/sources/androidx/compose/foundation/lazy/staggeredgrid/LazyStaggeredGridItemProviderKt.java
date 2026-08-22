package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: LazyStaggeredGridItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberStaggeredGridItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyStaggeredGridItemProviderKt {
    public static final Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda(final LazyStaggeredGridState lazyStaggeredGridState, Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 690901732, "C(rememberStaggeredGridItemProviderLambda)N(state,content)38@1584L29,39@1625L687:LazyStaggeredGridItemProvider.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(690901732, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProviderLambda (LazyStaggeredGridItemProvider.kt:37)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, -1763358253, "CC(remember):LazyStaggeredGridItemProvider.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(lazyStaggeredGridState)) || (i & 6) == 4;
        PropertyReference0Impl propertyReference0ImplRememberedValue = composer.rememberedValue();
        if (z || propertyReference0ImplRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda$lambda$0$0(stateRememberUpdatedState);
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda$lambda$0$1(stateDerivedStateOf, lazyStaggeredGridState);
                }
            });
            propertyReference0ImplRememberedValue = new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$1
                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(propertyReference0ImplRememberedValue);
        }
        KProperty0 kProperty0 = (KProperty0) propertyReference0ImplRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return kProperty0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridIntervalContent rememberStaggeredGridItemProviderLambda$lambda$0$0(State state) {
        return new LazyStaggeredGridIntervalContent((Function1) state.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridItemProviderImpl rememberStaggeredGridItemProviderLambda$lambda$0$1(State state, LazyStaggeredGridState lazyStaggeredGridState) {
        LazyStaggeredGridIntervalContent lazyStaggeredGridIntervalContent = (LazyStaggeredGridIntervalContent) state.getValue();
        return new LazyStaggeredGridItemProviderImpl(lazyStaggeredGridState, lazyStaggeredGridIntervalContent, new NearestRangeKeyIndexMap(lazyStaggeredGridState.getNearestRange$foundation(), lazyStaggeredGridIntervalContent));
    }
}
