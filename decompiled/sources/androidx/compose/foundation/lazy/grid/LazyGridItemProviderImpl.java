package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyGridItemProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0011H\u0017¢\u0006\u0002\u0010\u001bJ\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010$\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemProviderImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "intervalContent", "Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridIntervalContent;Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;)V", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "itemCount", "", "getItemCount", "()I", "getKey", "", FirebaseAnalytics.Param.INDEX, "getContentType", "headerIndexes", "Landroidx/collection/IntList;", "getHeaderIndexes", "()Landroidx/collection/IntList;", "Item", "", "key", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getSpanLayoutProvider", "()Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "getIndex", "equals", "", "other", "hashCode", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class LazyGridItemProviderImpl implements LazyGridItemProvider {
    private final LazyGridIntervalContent intervalContent;
    private final LazyLayoutKeyIndexMap keyIndexMap;
    private final LazyGridState state;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Item$lambda$1(LazyGridItemProviderImpl lazyGridItemProviderImpl, int i, Object obj, int i2, Composer composer, int i3) {
        lazyGridItemProviderImpl.Item(i, obj, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public LazyGridItemProviderImpl(LazyGridState lazyGridState, LazyGridIntervalContent lazyGridIntervalContent, LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap) {
        this.state = lazyGridState;
        this.intervalContent = lazyGridIntervalContent;
        this.keyIndexMap = lazyLayoutKeyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.keyIndexMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.intervalContent.getItemCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getKey(int index) {
        Object key = getKeyIndexMap().getKey(index);
        return key == null ? this.intervalContent.getKey(index) : key;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public Object getContentType(int index) {
        return this.intervalContent.getContentType(index);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public IntList getHeaderIndexes() {
        return this.intervalContent.getHeaderIndexes();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public void Item(final int i, Object obj, Composer composer, final int i2) {
        int i3;
        final int i4;
        final Object obj2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1493551140);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Item)N(index,key)80@3057L162,80@3003L216:LazyGridItemProvider.kt#7791vq");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(obj) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(this) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            i4 = i;
            obj2 = obj;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1493551140, i3, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item (LazyGridItemProvider.kt:79)");
            }
            i4 = i;
            obj2 = obj;
            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(obj2, i4, this.state.getPinnedItems(), ComposableLambdaKt.rememberComposableLambda(726189336, true, new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return LazyGridItemProviderImpl.Item$lambda$0(this.f$0, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 3072 | ((i3 << 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return LazyGridItemProviderImpl.Item$lambda$1(this.f$0, i4, obj2, i2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Item$lambda$0(LazyGridItemProviderImpl lazyGridItemProviderImpl, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C*82@3156L39:LazyGridItemProvider.kt#7791vq");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726189336, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridItemProviderImpl.Item.<anonymous> (LazyGridItemProvider.kt:81)");
            }
            IntervalList.Interval<LazyGridInterval> interval = lazyGridItemProviderImpl.intervalContent.getIntervals().get(i);
            interval.getValue().getItem().invoke(LazyGridItemScopeImpl.INSTANCE, Integer.valueOf(i - interval.getStartIndex()), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemProvider
    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.intervalContent.getSpanLayoutProvider();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getIndex(Object key) {
        return getKeyIndexMap().getIndex(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LazyGridItemProviderImpl) {
            return Intrinsics.areEqual(this.intervalContent, ((LazyGridItemProviderImpl) other).intervalContent);
        }
        return false;
    }

    public int hashCode() {
        return this.intervalContent.hashCode();
    }
}
