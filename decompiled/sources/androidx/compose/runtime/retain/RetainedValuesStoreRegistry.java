package androidx.compose.runtime.retain;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RetainedValuesStoreRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J+\u0010\u0013\u001a\u00020\n2#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010\u0018\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/retain/RetainedValuesStoreRegistry;", "", "<init>", "()V", "isDisposed", "", "childStores", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "LocalRetainedValuesStoreProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getOrCreateRetainedValuesStoreForChild", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "clearChild", "clearChildren", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dispose", "runtime-retain"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RetainedValuesStoreRegistry {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, ManagedRetainedValuesStore> childStores = new MutableScatterMap<>(0, 1, null);
    private boolean isDisposed;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LocalRetainedValuesStoreProvider$lambda$0(RetainedValuesStoreRegistry retainedValuesStoreRegistry, Object obj, Function2 function2, int i, Composer composer, int i2) {
        retainedValuesStoreRegistry.LocalRetainedValuesStoreProvider(obj, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dispose$lambda$0(Object obj) {
        return true;
    }

    public final void LocalRetainedValuesStoreProvider(final Object obj, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1626630244);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LocalRetainedValuesStoreProvider)N(key,content)71@3830L139:RetainedValuesStoreRegistry.kt#3my55w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1626630244, i2, -1, "androidx.compose.runtime.retain.RetainedValuesStoreRegistry.LocalRetainedValuesStoreProvider (RetainedValuesStoreRegistry.kt:70)");
            }
            LocalRetainedValuesStoreKt.LocalRetainedValuesStoreProvider(getOrCreateRetainedValuesStoreForChild(obj), function2, composerStartRestartGroup, i2 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.runtime.retain.RetainedValuesStoreRegistry$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return RetainedValuesStoreRegistry.LocalRetainedValuesStoreProvider$lambda$0(this.f$0, obj, function2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private final RetainedValuesStore getOrCreateRetainedValuesStoreForChild(Object key) {
        if (this.isDisposed) {
            PreconditionsKt.throwIllegalStateException("Cannot get a RetainedValuesStore after a RetainedValuesStoreRegistry has been disposed.");
        }
        MutableScatterMap<Object, ManagedRetainedValuesStore> mutableScatterMap = this.childStores;
        ManagedRetainedValuesStore managedRetainedValuesStore = mutableScatterMap.get(key);
        if (managedRetainedValuesStore == null) {
            managedRetainedValuesStore = new ManagedRetainedValuesStore();
            mutableScatterMap.set(key, managedRetainedValuesStore);
        }
        return managedRetainedValuesStore;
    }

    public final void clearChild(Object key) {
        ManagedRetainedValuesStore managedRetainedValuesStoreRemove = this.childStores.remove(key);
        if (managedRetainedValuesStoreRemove != null) {
            managedRetainedValuesStoreRemove.dispose();
        }
    }

    public final void clearChildren(Function1<Object, Boolean> predicate) {
        MutableScatterMap<Object, ManagedRetainedValuesStore> mutableScatterMap = this.childStores;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = mutableScatterMap.keys[i4];
                        ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) mutableScatterMap.values[i4];
                        Boolean boolInvoke = predicate.invoke(obj);
                        if (boolInvoke.booleanValue()) {
                            managedRetainedValuesStore.dispose();
                        }
                        if (boolInvoke.booleanValue()) {
                            mutableScatterMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void dispose() {
        this.isDisposed = true;
        clearChildren(new Function1() { // from class: androidx.compose.runtime.retain.RetainedValuesStoreRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(RetainedValuesStoreRegistry.dispose$lambda$0(obj));
            }
        });
    }
}
