package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0015\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0018J'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0010¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\fH\u0002J\u001b\u0010\u001c\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\fH\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\fH\u0010¢\u0006\u0002\b!J\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/runtime/SingleSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", "soleWatchedObject", "", "workingSoleWatchedObject", "watchSet", "Landroidx/collection/MutableScatterSet;", "workingWatchSet", "subscribedChannel", "Lkotlinx/coroutines/channels/SendChannel;", "", "getSubscribedChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "setSubscribedChannel", "(Lkotlinx/coroutines/channels/SendChannel;)V", "readObserverCache", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSetImpl", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "promote", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SingleSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    private Object soleWatchedObject;
    private SendChannel<? super Unit> subscribedChannel;
    private MutableScatterSet<Object> watchSet;
    private Object workingSoleWatchedObject;
    private MutableScatterSet<Object> workingWatchSet;
    private final Function1<Object, Unit> readObserverCache = new Function1() { // from class: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SingleSubscriptionSnapshotFlowManager.readObserverCache$lambda$0(this.f$0, obj);
        }
    };
    private final ObserverHandle unregisterApplyObserver = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SingleSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    });

    public final SendChannel<Unit> getSubscribedChannel() {
        return this.subscribedChannel;
    }

    public final void setSubscribedChannel(SendChannel<? super Unit> sendChannel) {
        this.subscribedChannel = sendChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readObserverCache$lambda$0(SingleSubscriptionSnapshotFlowManager singleSubscriptionSnapshotFlowManager, Object obj) {
        SendChannel<? super Unit> sendChannel = singleSubscriptionSnapshotFlowManager.subscribedChannel;
        Intrinsics.checkNotNull(sendChannel);
        singleSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[EDGE_INSN: B:38:0x0065->B:25:0x0065 BREAK  A[LOOP:0: B:12:0x0027->B:24:0x0062], EDGE_INSN: B:39:0x0065->B:25:0x0065 BREAK  A[LOOP:0: B:12:0x0027->B:24:0x0062]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit unregisterApplyObserver$lambda$0(androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager r17, java.util.Set r18, androidx.compose.runtime.snapshots.Snapshot r19) {
        /*
            r0 = r17
            r1 = r18
            java.lang.Object r2 = r0.getLock()
            monitor-enter(r2)
            androidx.collection.MutableScatterSet<java.lang.Object> r3 = r0.watchSet     // Catch: java.lang.Throwable -> L77
            if (r3 != 0) goto L1a
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch: java.lang.Throwable -> L77
            java.lang.Object r3 = r0.soleWatchedObject     // Catch: java.lang.Throwable -> L77
            boolean r1 = kotlin.collections.CollectionsKt.contains(r1, r3)     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L65
            kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r0 = r0.subscribedChannel     // Catch: java.lang.Throwable -> L77
            goto L66
        L1a:
            androidx.collection.ScatterSet r3 = (androidx.collection.ScatterSet) r3     // Catch: java.lang.Throwable -> L77
            java.lang.Object[] r4 = r3.elements     // Catch: java.lang.Throwable -> L77
            long[] r3 = r3.metadata     // Catch: java.lang.Throwable -> L77
            int r5 = r3.length     // Catch: java.lang.Throwable -> L77
            int r5 = r5 + (-2)
            if (r5 < 0) goto L65
            r6 = 0
            r7 = r6
        L27:
            r8 = r3[r7]     // Catch: java.lang.Throwable -> L77
            long r10 = ~r8     // Catch: java.lang.Throwable -> L77
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L60
            int r10 = r7 - r5
            int r10 = ~r10     // Catch: java.lang.Throwable -> L77
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L41:
            if (r12 >= r10) goto L5e
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L5a
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]     // Catch: java.lang.Throwable -> L77
            boolean r13 = r1.contains(r13)     // Catch: java.lang.Throwable -> L77
            if (r13 == 0) goto L5a
            kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r0 = r0.subscribedChannel     // Catch: java.lang.Throwable -> L77
            goto L66
        L5a:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L41
        L5e:
            if (r10 != r11) goto L65
        L60:
            if (r7 == r5) goto L65
            int r7 = r7 + 1
            goto L27
        L65:
            r0 = 0
        L66:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L77
            monitor-exit(r2)
            if (r0 == 0) goto L74
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            java.lang.Object r0 = r0.mo13895trySendJP2dKIU(r1)
            kotlinx.coroutines.channels.ChannelResult.m13910boximpl(r0)
        L74:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L77:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager, java.util.Set, androidx.compose.runtime.snapshots.Snapshot):kotlin.Unit");
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void watch$runtime(SendChannel<? super Unit> channel, Object obj) {
        if (!Intrinsics.areEqual(this.subscribedChannel, channel)) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        MutableScatterSet<Object> mutableScatterSet = this.workingWatchSet;
        Object obj2 = this.workingSoleWatchedObject;
        if (mutableScatterSet != null) {
            if (!(obj2 == null)) {
                PreconditionsKt.throwIllegalStateException("workingSoleWatchedObject must be null when workingWatchSet is non-null");
            }
            mutableScatterSet.add(obj);
        } else {
            if (obj2 == null) {
                this.workingSoleWatchedObject = obj;
                return;
            }
            MutableScatterSet<Object> mutableScatterSetMutableScatterSetOf = ScatterSetKt.mutableScatterSetOf();
            mutableScatterSetMutableScatterSetOf.add(obj2);
            mutableScatterSetMutableScatterSetOf.add(obj);
            this.workingWatchSet = mutableScatterSetMutableScatterSetOf;
            this.workingSoleWatchedObject = null;
        }
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public Function1<Object, Unit> readObserverFor$runtime(SendChannel<? super Unit> channel) {
        SendChannel<? super Unit> sendChannel = this.subscribedChannel;
        if (!(sendChannel == null || Intrinsics.areEqual(sendChannel, channel))) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }
        this.subscribedChannel = channel;
        return this.readObserverCache;
    }

    private final void clearWatchSetImpl() {
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void clearWatchSet$runtime(SendChannel<? super Unit> channel) {
        clearWatchSetImpl();
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void commitSubscriptionChanges$runtime() {
        synchronized (getLock()) {
            this.soleWatchedObject = this.workingSoleWatchedObject;
            if (this.workingWatchSet == null) {
                this.watchSet = null;
            } else {
                if (this.watchSet == null) {
                    this.watchSet = ScatterSetKt.mutableScatterSetOf();
                }
                MutableScatterSet<Object> mutableScatterSet = this.watchSet;
                this.watchSet = this.workingWatchSet;
                this.workingWatchSet = mutableScatterSet;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        clearWatchSetImpl();
        synchronized (getLock()) {
            this.subscribedChannel = null;
            this.soleWatchedObject = null;
            this.watchSet = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager promote() {
        /*
            r17 = this;
            r0 = r17
            androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager r1 = new androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager
            r1.<init>()
            kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r2 = r0.subscribedChannel
            r3 = 0
            if (r2 == 0) goto Le
            r4 = 1
            goto Lf
        Le:
            r4 = r3
        Lf:
            if (r4 != 0) goto L16
            java.lang.String r4 = "promote must only be called when a manager is managing subscriptions for one channel and needs to start managing them for a second"
            androidx.compose.runtime.PreconditionsKt.throwIllegalStateException(r4)
        L16:
            androidx.collection.MutableScatterSet<java.lang.Object> r4 = r0.watchSet
            if (r4 != 0) goto L23
            java.lang.Object r3 = r0.soleWatchedObject
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r1.watch$runtime(r2, r3)
            goto L67
        L23:
            androidx.collection.ScatterSet r4 = (androidx.collection.ScatterSet) r4
            java.lang.Object[] r5 = r4.elements
            long[] r4 = r4.metadata
            int r6 = r4.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L67
            r7 = r3
        L2f:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L62
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r3
        L49:
            if (r12 >= r10) goto L60
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L5c
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r5[r13]
            r1.watch$runtime(r2, r13)
        L5c:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L49
        L60:
            if (r10 != r11) goto L67
        L62:
            if (r7 == r6) goto L67
            int r7 = r7 + 1
            goto L2f
        L67:
            r1.commitSubscriptionChanges$runtime()
            r0.dispose$runtime()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SingleSubscriptionSnapshotFlowManager.promote():androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager");
    }
}
