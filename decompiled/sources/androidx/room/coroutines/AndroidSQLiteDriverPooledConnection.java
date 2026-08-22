package androidx.room.coroutines;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.driver.AndroidSQLiteConnection;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: AndroidSQLiteDriverConnectionPool.android.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0016JK\u0010\u0017\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0018\u001a\u00020\n2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eJK\u0010\u001f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0018\u001a\u00020\n2-\u0010\u0013\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH\u0082@¢\u0006\u0002\u0010\u001eJ\u000e\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "delegate", "Landroidx/sqlite/driver/AndroidSQLiteConnection;", "<init>", "(Landroidx/sqlite/driver/AndroidSQLiteConnection;)V", "getDelegate", "()Landroidx/sqlite/driver/AndroidSQLiteConnection;", "currentTransactionType", "Landroidx/room/Transactor$SQLiteTransactionType;", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "type", "Lkotlin/Function2;", "Landroidx/room/TransactionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/room/Transactor$SQLiteTransactionType;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transaction", "inTransaction", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AndroidSQLiteDriverTransactor", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidSQLiteDriverPooledConnection implements Transactor, RawConnectionAccessor {
    private Transactor.SQLiteTransactionType currentTransactionType;
    private final AndroidSQLiteConnection delegate;

    /* JADX INFO: compiled from: AndroidSQLiteDriverConnectionPool.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidSQLiteDriverConnectionPool.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.room.coroutines.AndroidSQLiteDriverPooledConnection", f = "AndroidSQLiteDriverConnectionPool.android.kt", i = {0, 0}, l = {87}, m = "transaction", n = {"this", UserDataStore.DATE_OF_BIRTH}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidSQLiteDriverPooledConnection.this.transaction(null, null, this);
        }
    }

    public AndroidSQLiteDriverPooledConnection(AndroidSQLiteConnection delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final AndroidSQLiteConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    @Override // androidx.room.PooledConnection
    public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) throws Exception {
        SQLiteStatement sQLiteStatementPrepare = this.delegate.prepare(str);
        try {
            R rInvoke = function1.invoke(sQLiteStatementPrepare);
            AutoCloseableKt.closeFinally(sQLiteStatementPrepare, null);
            return rInvoke;
        } finally {
        }
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return transaction(sQLiteTransactionType, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r6, kotlin.jvm.functions.Function2<? super androidx.room.TransactionScope<R>, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super R> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1 r0 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$transaction$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r6 = r0.L$1
            android.database.sqlite.SQLiteDatabase r6 = (android.database.sqlite.SQLiteDatabase) r6
            java.lang.Object r7 = r0.L$0
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection r7 = (androidx.room.coroutines.AndroidSQLiteDriverPooledConnection) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L33 androidx.room.coroutines.ConnectionPool.RollbackException -> L36
            goto L89
        L33:
            r8 = move-exception
            goto Lb3
        L36:
            r8 = move-exception
            goto La3
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.sqlite.driver.AndroidSQLiteConnection r8 = r5.delegate
            android.database.sqlite.SQLiteDatabase r8 = r8.getDb()
            boolean r2 = r8.inTransaction()
            if (r2 != 0) goto L52
            r5.currentTransactionType = r6
        L52:
            int[] r2 = androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            if (r6 == r4) goto L70
            r2 = 2
            if (r6 == r2) goto L6c
            r2 = 3
            if (r6 != r2) goto L66
            r8.beginTransaction()
            goto L73
        L66:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L6c:
            r8.beginTransactionNonExclusive()
            goto L73
        L70:
            r8.beginTransactionNonExclusive()
        L73:
            androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor r6 = new androidx.room.coroutines.AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            r6.<init>()     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            r0.label = r4     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            java.lang.Object r6 = r7.invoke(r6, r0)     // Catch: java.lang.Throwable -> L98 androidx.room.coroutines.ConnectionPool.RollbackException -> L9e
            if (r6 != r1) goto L85
            return r1
        L85:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L89:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L33 androidx.room.coroutines.ConnectionPool.RollbackException -> L36
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto L97
            r7.currentTransactionType = r3
        L97:
            return r8
        L98:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto Lb3
        L9e:
            r6 = move-exception
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        La3:
            java.lang.Object r8 = r8.getResult()     // Catch: java.lang.Throwable -> L33
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto Lb2
            r7.currentTransactionType = r3
        Lb2:
            return r8
        Lb3:
            r6.endTransaction()
            boolean r6 = r6.inTransaction()
            if (r6 != 0) goto Lbe
            r7.currentTransactionType = r3
        Lbe:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.AndroidSQLiteDriverPooledConnection.transaction(androidx.room.Transactor$SQLiteTransactionType, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(this.delegate.getDb().inTransaction());
    }

    /* JADX INFO: compiled from: AndroidSQLiteDriverConnectionPool.android.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0096@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u0002H\u000b\"\u0004\b\u0001\u0010\u000b2(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0013H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection$AndroidSQLiteDriverTransactor;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", "<init>", "(Landroidx/room/coroutines/AndroidSQLiteDriverPooledConnection;)V", "rawConnection", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "usePrepared", "R", "sql", "", BlockContactsIQ.ELEMENT, "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withNestedTransaction", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollback", "", "result", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class AndroidSQLiteDriverTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public AndroidSQLiteDriverTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return AndroidSQLiteDriverPooledConnection.this.getRawConnection();
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, Function1<? super SQLiteStatement, ? extends R> function1, Continuation<? super R> continuation) {
            return AndroidSQLiteDriverPooledConnection.this.usePrepared(str, function1, continuation);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(Function2<? super TransactionScope<R>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
            AndroidSQLiteDriverPooledConnection androidSQLiteDriverPooledConnection = AndroidSQLiteDriverPooledConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = androidSQLiteDriverPooledConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return androidSQLiteDriverPooledConnection.transaction(sQLiteTransactionType, function2, continuation);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // androidx.room.TransactionScope
        public Object rollback(T t, Continuation<?> continuation) throws ConnectionPool.RollbackException {
            throw new ConnectionPool.RollbackException(t);
        }
    }
}
