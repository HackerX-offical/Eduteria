package androidx.compose.runtime.retain;

import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.retain.impl.SafeMultiValueMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: ManagedRetainedValuesStore.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "<init>", "()V", "isEnabled", "", "isDisposed", "isContentComposed", "keptExitedValues", "Landroidx/compose/runtime/retain/impl/SafeMultiValueMap;", "", "Landroidx/collection/MutableScatterMap;", "isRetainingExitedValues", "()Z", "enableRetainingExitedValues", "", "disableRetainingExitedValues", "dispose", "onContentExitComposition", "onContentEnteredComposition", "purgeUnusedExitedValues", "consumeExitedValueOrDefault", "key", "defaultValue", "saveExitingValue", "value", "runtime-retain"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManagedRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable = 8;
    private boolean isContentComposed;
    private boolean isDisposed;
    private boolean isEnabled = true;
    private final MutableScatterMap<Object, Object> keptExitedValues = SafeMultiValueMap.m5331constructorimpl$default(null, 1, null);

    public final boolean isRetainingExitedValues() {
        return this.isEnabled && !this.isContentComposed;
    }

    public final void enableRetainingExitedValues() {
        if (this.isDisposed) {
            PreconditionsKt.throwIllegalStateException("Cannot call enableRetainingExitedValues on a disposed store");
        }
        this.isEnabled = true;
    }

    public final void disableRetainingExitedValues() {
        this.isEnabled = false;
        purgeUnusedExitedValues();
    }

    public final void dispose() {
        this.isDisposed = true;
        disableRetainingExitedValues();
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentExitComposition() {
        if (this.isDisposed) {
            return;
        }
        if (!this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
        }
        if (!SafeMultiValueMap.m5338isEmptyimpl(this.keptExitedValues)) {
            PreconditionsKt.throwIllegalStateException("Attempted to start retaining exited values with pending exited values");
        }
        this.isContentComposed = false;
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentEnteredComposition() {
        if (this.isDisposed) {
            return;
        }
        if (this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
        }
        purgeUnusedExitedValues();
        this.isContentComposed = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void purgeUnusedExitedValues() {
        /*
            r15 = this;
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r0 = r15.keptExitedValues
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r1 = r0.values
            long[] r0 = r0.metadata
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L6f
            r3 = 0
            r4 = r3
        Lf:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L6a
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L29:
            if (r9 >= r7) goto L68
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L64
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof androidx.collection.MutableObjectList
            if (r11 == 0) goto L5b
            java.lang.String r11 = "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
            androidx.collection.MutableObjectList r10 = (androidx.collection.MutableObjectList) r10
            androidx.collection.ObjectList r10 = (androidx.collection.ObjectList) r10
            java.lang.Object[] r11 = r10.content
            int r10 = r10._size
            r12 = r3
        L4b:
            if (r12 >= r10) goto L64
            r13 = r11[r12]
            boolean r14 = r13 instanceof androidx.compose.runtime.retain.RetainObserver
            if (r14 == 0) goto L58
            androidx.compose.runtime.retain.RetainObserver r13 = (androidx.compose.runtime.retain.RetainObserver) r13
            r13.onRetired()
        L58:
            int r12 = r12 + 1
            goto L4b
        L5b:
            boolean r11 = r10 instanceof androidx.compose.runtime.retain.RetainObserver
            if (r11 == 0) goto L64
            androidx.compose.runtime.retain.RetainObserver r10 = (androidx.compose.runtime.retain.RetainObserver) r10
            r10.onRetired()
        L64:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L29
        L68:
            if (r7 != r8) goto L6f
        L6a:
            if (r4 == r2) goto L6f
            int r4 = r4 + 1
            goto Lf
        L6f:
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r0 = r15.keptExitedValues
            androidx.compose.runtime.retain.impl.SafeMultiValueMap.m5329clearimpl(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.retain.ManagedRetainedValuesStore.purgeUnusedExitedValues():void");
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public Object consumeExitedValueOrDefault(Object key, Object defaultValue) {
        return SafeMultiValueMap.m5342removeLastimpl(this.keptExitedValues, key, defaultValue);
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void saveExitingValue(Object key, Object value) {
        if (isRetainingExitedValues()) {
            SafeMultiValueMap.m5327addimpl(this.keptExitedValues, key, value);
        } else if (value instanceof RetainObserver) {
            ((RetainObserver) value).onRetired();
        }
    }
}
