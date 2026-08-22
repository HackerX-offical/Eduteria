package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutCacheWindow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.DensityKt;
import androidx.media3.exoplayer.RendererCapabilities;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: LazyGridState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"rememberLazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "prefetchStrategy", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "(IILandroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "cacheWindow", "Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutCacheWindow;IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/grid/LazyGridState;", "EmptyLazyGridLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyGridStateKt {
    private static final LazyGridMeasureResult EmptyLazyGridLayoutInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int EmptyLazyGridLayoutInfo$lambda$1(int i) {
        return -1;
    }

    public static final LazyGridState rememberLazyGridState(final int i, final int i2, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, 29186956, "C(rememberLazyGridState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)80@3856L96,80@3810L142:LazyGridState.kt#7791vq");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(29186956, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:79)");
        }
        Object[] objArr = new Object[0];
        Saver<LazyGridState, ?> saver = LazyGridState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -2016099988, "CC(remember):LazyGridState.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4;
        if ((((i3 & 112) ^ 48) <= 32 || !composer.changed(i2)) && (i3 & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyGridStateKt.rememberLazyGridState$lambda$0$0(i, i2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LazyGridState lazyGridState = (LazyGridState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridState rememberLazyGridState$lambda$0$0(int i, int i2) {
        return new LazyGridState(i, i2);
    }

    public static final LazyGridState rememberLazyGridState(final int i, final int i2, final LazyGridPrefetchStrategy lazyGridPrefetchStrategy, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -20335728, "C(rememberLazyGridState)N(initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset,prefetchStrategy)102@4719L39,104@4872L161,104@4790L243:LazyGridState.kt#7791vq");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        boolean z = true;
        if ((i4 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 1932207319, "CC(remember):LazyGridState.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = LazyGridPrefetchStrategyKt.LazyGridPrefetchStrategy$default(0, 1, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            lazyGridPrefetchStrategy = (LazyGridPrefetchStrategy) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-20335728, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:103)");
        }
        Object[] objArr = {lazyGridPrefetchStrategy};
        Saver<LazyGridState, ?> saverSaver$foundation = LazyGridState.INSTANCE.saver$foundation(lazyGridPrefetchStrategy);
        ComposerKt.sourceInformationMarkerStart(composer, 1932212337, "CC(remember):LazyGridState.kt#9igjgp");
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.changed(i)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i2)) || (i3 & 48) == 32);
        if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changedInstance(lazyGridPrefetchStrategy)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyGridStateKt.rememberLazyGridState$lambda$2$0(i, i2, lazyGridPrefetchStrategy);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LazyGridState lazyGridState = (LazyGridState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saverSaver$foundation, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridState rememberLazyGridState$lambda$2$0(int i, int i2, LazyGridPrefetchStrategy lazyGridPrefetchStrategy) {
        return new LazyGridState(i, i2, lazyGridPrefetchStrategy);
    }

    public static final LazyGridState rememberLazyGridState(final LazyLayoutCacheWindow lazyLayoutCacheWindow, final int i, final int i2, Composer composer, int i3, int i4) {
        ComposerKt.sourceInformationMarkerStart(composer, -1537306572, "C(rememberLazyGridState)N(cacheWindow,initialFirstVisibleItemIndex,initialFirstVisibleItemScrollOffset)132@5906L156,132@5834L228:LazyGridState.kt#7791vq");
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1537306572, i3, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridState (LazyGridState.kt:131)");
        }
        Object[] objArr = {lazyLayoutCacheWindow};
        Saver<LazyGridState, ?> saverSaver$foundation = LazyGridState.INSTANCE.saver$foundation(lazyLayoutCacheWindow);
        ComposerKt.sourceInformationMarkerStart(composer, 117142672, "CC(remember):LazyGridState.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.changed(lazyLayoutCacheWindow)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(i)) || (i3 & 48) == 32);
        if ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(i2)) && (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue = composer.rememberedValue();
        if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LazyGridStateKt.rememberLazyGridState$lambda$3$0(lazyLayoutCacheWindow, i, i2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        LazyGridState lazyGridState = (LazyGridState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) saverSaver$foundation, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridState rememberLazyGridState$lambda$3$0(LazyLayoutCacheWindow lazyLayoutCacheWindow, int i, int i2) {
        return new LazyGridState(lazyLayoutCacheWindow, i, i2);
    }

    static {
        MeasureResult measureResult = new MeasureResult() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$EmptyLazyGridLayoutInfo$1
            private final Map<AlignmentLine, Integer> alignmentLines = MapsKt.emptyMap();
            private final int height;
            private final int width;

            public static /* synthetic */ void getAlignmentLines$annotations() {
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }
        };
        List listEmptyList = CollectionsKt.emptyList();
        Orientation orientation = Orientation.Vertical;
        MeasureResult measureResult2 = measureResult;
        EmptyLazyGridLayoutInfo = new LazyGridMeasureResult(null, 0, false, 0.0f, measureResult2, 0.0f, false, CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(1.0f, 0.0f, 2, null), 0, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridStateKt.EmptyLazyGridLayoutInfo$lambda$0(((Integer) obj).intValue());
            }
        }, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridStateKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(LazyGridStateKt.EmptyLazyGridLayoutInfo$lambda$1(((Integer) obj).intValue()));
            }
        }, listEmptyList, 0, 0, 0, false, orientation, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List EmptyLazyGridLayoutInfo$lambda$0(int i) {
        return CollectionsKt.emptyList();
    }
}
