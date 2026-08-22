package com.appnew.android.testmodulessc.utils;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkerParameters;
import com.facebook.internal.NativeProtocol;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSCQuestionReportWorker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/appnew/android/testmodulessc/utils/SSCQuestionReportWorker;", "Landroidx/work/CoroutineWorker;", "ctx", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCQuestionReportWorker extends CoroutineWorker {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.utils.SSCQuestionReportWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: SSCQuestionReportWorker.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.testmodulessc.utils.SSCQuestionReportWorker", f = "SSCQuestionReportWorker.kt", i = {}, l = {54}, m = "doWork", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SSCQuestionReportWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSCQuestionReportWorker(Context ctx, WorkerParameters params) {
        super(ctx, params);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r15) {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.utils.SSCQuestionReportWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: compiled from: SSCQuestionReportWorker.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007¨\u0006\r"}, d2 = {"Lcom/appnew/android/testmodulessc/utils/SSCQuestionReportWorker$Companion;", "", "<init>", "()V", "buildRequest", "Landroidx/work/OneTimeWorkRequest;", "cfgId", "", "questionId", "optionId", "feedback", "testId", "langId", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OneTimeWorkRequest buildRequest(String cfgId, String questionId, String optionId, String feedback, String testId, String langId) {
            Intrinsics.checkNotNullParameter(cfgId, "cfgId");
            Intrinsics.checkNotNullParameter(questionId, "questionId");
            Intrinsics.checkNotNullParameter(optionId, "optionId");
            Intrinsics.checkNotNullParameter(feedback, "feedback");
            Intrinsics.checkNotNullParameter(testId, "testId");
            Intrinsics.checkNotNullParameter(langId, "langId");
            Pair[] pairArr = {TuplesKt.to("cfgId", cfgId), TuplesKt.to("questionId", questionId), TuplesKt.to("optionId", optionId), TuplesKt.to("feedback", feedback), TuplesKt.to("testId", testId), TuplesKt.to("langId", langId)};
            Data.Builder builder = new Data.Builder();
            for (int i = 0; i < 6; i++) {
                Pair pair = pairArr[i];
                builder.put((String) pair.getFirst(), pair.getSecond());
            }
            return new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) SSCQuestionReportWorker.class).setInputData(builder.build()).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 30L, TimeUnit.SECONDS).addTag("SSC_REPORT").build();
        }
    }
}
