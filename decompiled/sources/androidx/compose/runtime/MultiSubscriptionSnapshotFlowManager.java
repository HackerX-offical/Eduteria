package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import com.android.billingclient.api.BillingClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\u0017J'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u0019J\u001b\u0010\u001a\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\bH\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\bH\u0010¢\u0006\u0002\b\u001fR\"\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", BillingClient.FeatureType.SUBSCRIPTIONS, "Landroidx/compose/runtime/collection/ScopeMap;", "", "Lkotlinx/coroutines/channels/SendChannel;", "", "Landroidx/collection/MutableScatterMap;", "pendingChanges", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "toNotify", "Landroidx/collection/MutableScatterSet;", "readObserverCache", "Landroidx/collection/MutableScatterMap;", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "SubscriptionChange", "Add", "RemoveScope", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MultiSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    private MutableScatterMap<Object, Object> subscriptions = ScopeMap.m5109constructorimpl$default(null, 1, null);
    private final List<SubscriptionChange> pendingChanges = new ArrayList();
    private final MutableScatterSet<SendChannel<Unit>> toNotify = ScatterSetKt.mutableScatterSetOf();
    private final MutableScatterMap<SendChannel<Unit>, Function1<Object, Unit>> readObserverCache = ScatterMapKt.mutableScatterMapOf();
    private final ObserverHandle unregisterApplyObserver = Snapshot.INSTANCE.registerApplyObserver(new Function2() { // from class: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(this.f$0, (Set) obj, (Snapshot) obj2);
        }
    });

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001\u0082\u0001\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private interface SubscriptionChange {
    }

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "obj", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/SendChannel;)V", "getObj", "()Ljava/lang/Object;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Add implements SubscriptionChange {
        private final SendChannel<Unit> channel;
        private final Object obj;

        /* JADX WARN: Multi-variable type inference failed */
        public Add(Object obj, SendChannel<? super Unit> sendChannel) {
            this.obj = obj;
            this.channel = sendChannel;
        }

        public final SendChannel<Unit> getChannel() {
            return this.channel;
        }

        public final Object getObj() {
            return this.obj;
        }
    }

    /* JADX INFO: compiled from: SnapshotFlow.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class RemoveScope implements SubscriptionChange {
        private final SendChannel<Unit> channel;

        /* JADX WARN: Multi-variable type inference failed */
        public RemoveScope(SendChannel<? super Unit> sendChannel) {
            this.channel = sendChannel;
        }

        public final SendChannel<Unit> getChannel() {
            return this.channel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit unregisterApplyObserver$lambda$0(final androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager r13, final java.util.Set r14, androidx.compose.runtime.snapshots.Snapshot r15) {
        /*
            java.lang.Object r15 = r13.getLock()
            monitor-enter(r15)
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r0 = r13.subscriptions     // Catch: java.lang.Throwable -> L65
            androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1 r1 = new androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1     // Catch: java.lang.Throwable -> L65
            r1.<init>()     // Catch: java.lang.Throwable -> L65
            androidx.compose.runtime.collection.ScopeMap.m5114forEachKeyimpl(r0, r1)     // Catch: java.lang.Throwable -> L65
            androidx.collection.MutableScatterSet<kotlinx.coroutines.channels.SendChannel<kotlin.Unit>> r14 = r13.toNotify     // Catch: java.lang.Throwable -> L65
            androidx.collection.ScatterSet r14 = (androidx.collection.ScatterSet) r14     // Catch: java.lang.Throwable -> L65
            java.lang.Object[] r0 = r14.elements     // Catch: java.lang.Throwable -> L65
            long[] r14 = r14.metadata     // Catch: java.lang.Throwable -> L65
            int r1 = r14.length     // Catch: java.lang.Throwable -> L65
            int r1 = r1 + (-2)
            if (r1 < 0) goto L5a
            r2 = 0
            r3 = r2
        L1e:
            r4 = r14[r3]     // Catch: java.lang.Throwable -> L65
            long r6 = ~r4     // Catch: java.lang.Throwable -> L65
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L55
            int r6 = r3 - r1
            int r6 = ~r6     // Catch: java.lang.Throwable -> L65
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L38:
            if (r8 >= r6) goto L53
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L4f
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]     // Catch: java.lang.Throwable -> L65
            kotlinx.coroutines.channels.SendChannel r9 = (kotlinx.coroutines.channels.SendChannel) r9     // Catch: java.lang.Throwable -> L65
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L65
            r9.mo13895trySendJP2dKIU(r10)     // Catch: java.lang.Throwable -> L65
        L4f:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L38
        L53:
            if (r6 != r7) goto L5a
        L55:
            if (r3 == r1) goto L5a
            int r3 = r3 + 1
            goto L1e
        L5a:
            androidx.collection.MutableScatterSet<kotlinx.coroutines.channels.SendChannel<kotlin.Unit>> r13 = r13.toNotify     // Catch: java.lang.Throwable -> L65
            r13.clear()     // Catch: java.lang.Throwable -> L65
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L65
            monitor-exit(r15)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L65:
            r13 = move-exception
            monitor-exit(r15)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0(androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager, java.util.Set, androidx.compose.runtime.snapshots.Snapshot):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit unregisterApplyObserver$lambda$0$0$0(java.util.Set r12, androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager r13, java.lang.Object r14) {
        /*
            boolean r12 = r12.contains(r14)
            if (r12 == 0) goto L64
            androidx.collection.MutableScatterMap<java.lang.Object, java.lang.Object> r12 = r13.subscriptions
            java.lang.Object r12 = r12.get(r14)
            if (r12 == 0) goto L64
            boolean r14 = r12 instanceof androidx.collection.MutableScatterSet
            if (r14 == 0) goto L5d
            androidx.collection.MutableScatterSet r12 = (androidx.collection.MutableScatterSet) r12
            androidx.collection.ScatterSet r12 = (androidx.collection.ScatterSet) r12
            java.lang.Object[] r14 = r12.elements
            long[] r12 = r12.metadata
            int r0 = r12.length
            int r0 = r0 + (-2)
            if (r0 < 0) goto L64
            r1 = 0
            r2 = r1
        L21:
            r3 = r12[r2]
            long r5 = ~r3
            r7 = 7
            long r5 = r5 << r7
            long r5 = r5 & r3
            r7 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r5 = r5 & r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L58
            int r5 = r2 - r0
            int r5 = ~r5
            int r5 = r5 >>> 31
            r6 = 8
            int r5 = 8 - r5
            r7 = r1
        L3b:
            if (r7 >= r5) goto L56
            r8 = 255(0xff, double:1.26E-321)
            long r8 = r8 & r3
            r10 = 128(0x80, double:6.3E-322)
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 >= 0) goto L52
            int r8 = r2 << 3
            int r8 = r8 + r7
            r8 = r14[r8]
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            androidx.collection.MutableScatterSet<kotlinx.coroutines.channels.SendChannel<kotlin.Unit>> r9 = r13.toNotify
            r9.add(r8)
        L52:
            long r3 = r3 >> r6
            int r7 = r7 + 1
            goto L3b
        L56:
            if (r5 != r6) goto L64
        L58:
            if (r2 == r0) goto L64
            int r2 = r2 + 1
            goto L21
        L5d:
            kotlinx.coroutines.channels.SendChannel r12 = (kotlinx.coroutines.channels.SendChannel) r12
            androidx.collection.MutableScatterSet<kotlinx.coroutines.channels.SendChannel<kotlin.Unit>> r13 = r13.toNotify
            r13.add(r12)
        L64:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0$0$0(java.util.Set, androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager, java.lang.Object):kotlin.Unit");
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void watch$runtime(SendChannel<? super Unit> channel, Object obj) {
        this.pendingChanges.add(new Add(obj, channel));
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public Function1<Object, Unit> readObserverFor$runtime(final SendChannel<? super Unit> channel) {
        Function1<Object, Unit> function1 = this.readObserverCache.get(channel);
        if (function1 != null) {
            return function1;
        }
        Function1<Object, Unit> function12 = new Function1() { // from class: androidx.compose.runtime.MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiSubscriptionSnapshotFlowManager.readObserverFor$lambda$0(this.f$0, channel, obj);
            }
        };
        this.readObserverCache.put(channel, function12);
        return function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit readObserverFor$lambda$0(MultiSubscriptionSnapshotFlowManager multiSubscriptionSnapshotFlowManager, SendChannel sendChannel, Object obj) {
        multiSubscriptionSnapshotFlowManager.watch$runtime(sendChannel, obj);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void clearWatchSet$runtime(SendChannel<? super Unit> channel) {
        this.pendingChanges.add(new RemoveScope(channel));
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void commitSubscriptionChanges$runtime() {
        synchronized (getLock()) {
            List<SubscriptionChange> list = this.pendingChanges;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                SubscriptionChange subscriptionChange = list.get(i);
                if (subscriptionChange instanceof Add) {
                    ScopeMap.m5102addimpl(this.subscriptions, ((Add) subscriptionChange).getObj(), ((Add) subscriptionChange).getChannel());
                } else {
                    if (!(subscriptionChange instanceof RemoveScope)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ScopeMap.m5124removeScopeimpl(this.subscriptions, ((RemoveScope) subscriptionChange).getChannel());
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.pendingChanges.clear();
    }

    @Override // androidx.compose.runtime.SnapshotFlowManagerImpl
    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.pendingChanges.clear();
        this.readObserverCache.clear();
        synchronized (getLock()) {
            ScopeMap.m5107clearimpl(this.subscriptions);
            Unit unit = Unit.INSTANCE;
        }
    }
}
