package com.microsoft.clarity.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.microsoft.clarity.c.g;
import com.microsoft.clarity.g.o;
import com.microsoft.clarity.n.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/clarity/workers/BaseWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0})
public abstract class BaseWorker extends Worker {

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ListenableWorker.Result> f1097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseWorker f1098b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Ref.ObjectRef<ListenableWorker.Result> objectRef, BaseWorker baseWorker) {
            super(0);
            this.f1097a = objectRef;
            this.f1098b = baseWorker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            T tA;
            Ref.ObjectRef<ListenableWorker.Result> objectRef = this.f1097a;
            if (this.f1098b.getRunAttemptCount() + 1 > 3) {
                this.f1098b.a(new g());
                tA = ListenableWorker.Result.failure();
            } else {
                tA = this.f1098b.a();
            }
            objectRef.element = tA;
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<Exception, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<ListenableWorker.Result> f1099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseWorker f1100b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.ObjectRef<ListenableWorker.Result> objectRef, BaseWorker baseWorker) {
            super(1);
            this.f1099a = objectRef;
            this.f1100b = baseWorker;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.work.ListenableWorker$Result] */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Exception exc) {
            Exception it = exc;
            Intrinsics.checkNotNullParameter(it, "it");
            this.f1099a.element = ListenableWorker.Result.retry();
            this.f1100b.a(it);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
    }

    public abstract ListenableWorker.Result a();

    public abstract void a(Exception exc);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        e.a(new a(objectRef, this), new b(objectRef, this), (o.c) null, 10);
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        return (ListenableWorker.Result) t;
    }
}
