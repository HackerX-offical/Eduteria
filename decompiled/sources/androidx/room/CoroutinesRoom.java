package androidx.room;

import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import com.facebook.appevents.UserDataStore;
import java.util.concurrent.Callable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CoroutinesRoom.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "<init>", "()V", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoroutinesRoom {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z, strArr, callable);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z, cancellationSignal, callable, continuation);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
        return INSTANCE.execute(roomDatabase, z, callable, continuation);
    }

    private CoroutinesRoom() {
    }

    /* JADX INFO: compiled from: CoroutinesRoom.android.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\fJ<\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00120\u0011\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "execute", "R", UserDataStore.DATE_OF_BIRTH, "Landroidx/room/RoomDatabase;", "inTransaction", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/JvmSuppressWildcards;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @kotlin.Deprecated(message = "No longer called by generated implementation")
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r6, boolean r7, java.util.concurrent.Callable<R> r8, kotlin.coroutines.Continuation<? super R> r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof androidx.room.CoroutinesRoom$Companion$execute$1
                if (r0 == 0) goto L14
                r0 = r9
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = (androidx.room.CoroutinesRoom$Companion$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$1
                r0.<init>(r5, r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r9)
                return r9
            L2d:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L35:
                java.lang.Object r6 = r0.L$0
                r8 = r6
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto L5d
            L3e:
                kotlin.ResultKt.throwOnFailure(r9)
                boolean r9 = r6.isOpenInternal()
                if (r9 == 0) goto L52
                boolean r9 = r6.inTransaction()
                if (r9 == 0) goto L52
                java.lang.Object r6 = r8.call()
                return r6
            L52:
                r0.L$0 = r8
                r0.label = r4
                java.lang.Object r9 = androidx.room.util.DBUtil.getCoroutineContext(r6, r7, r0)
                if (r9 != r1) goto L5d
                goto L71
            L5d:
                kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
                androidx.room.CoroutinesRoom$Companion$execute$2 r6 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r7 = 0
                r6.<init>(r8, r7)
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r9, r6, r0)
                if (r6 != r1) goto L72
            L71:
                return r1
            L72:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
        @kotlin.Deprecated(message = "No longer called by generated implementation")
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r17, boolean r18, android.os.CancellationSignal r19, java.util.concurrent.Callable<R> r20, kotlin.coroutines.Continuation<? super R> r21) {
            /*
                Method dump skipped, instruction units count: 216
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, android.os.CancellationSignal, java.util.concurrent.Callable, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return callable.call();
        }

        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase db, boolean inTransaction, String[] tableNames, final Callable<R> callable) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return FlowUtil.createFlow(db, inTransaction, tableNames, new Function1() { // from class: androidx.room.CoroutinesRoom$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CoroutinesRoom.Companion.createFlow$lambda$1(callable, (SQLiteConnection) obj);
                }
            });
        }
    }
}
