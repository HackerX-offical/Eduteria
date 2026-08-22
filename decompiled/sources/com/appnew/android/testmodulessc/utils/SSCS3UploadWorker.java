package com.appnew.android.testmodulessc.utils;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.WorkerParameters;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.appnew.android.Utils.Const;
import com.appnew.android.testmodulessc.utils.SSCS3UploadWorker;
import com.facebook.internal.NativeProtocol;
import java.io.ByteArrayInputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: compiled from: SSCS3UploadWorker.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/appnew/android/testmodulessc/utils/SSCS3UploadWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroidx/work/WorkerParameters;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadToS3", "", "file", "Ljava/io/File;", "testSeriesId", "", "(Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SSCS3UploadWorker extends CoroutineWorker {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.utils.SSCS3UploadWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: SSCS3UploadWorker.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.testmodulessc.utils.SSCS3UploadWorker", f = "SSCS3UploadWorker.kt", i = {0, 0}, l = {33}, m = "doWork", n = {"filePath", "testSeriesId"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return SSCS3UploadWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SSCS3UploadWorker(Context context, WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.testmodulessc.utils.SSCS3UploadWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.appnew.android.testmodulessc.utils.SSCS3UploadWorker$uploadToS3$2, reason: invalid class name */
    /* JADX INFO: compiled from: SSCS3UploadWorker.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.testmodulessc.utils.SSCS3UploadWorker$uploadToS3$2", f = "SSCS3UploadWorker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ String $testSeriesId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$file = file;
            this.$testSeriesId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SSCS3UploadWorker.this.new AnonymousClass2(this.$file, this.$testSeriesId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AmazonS3Client amazonS3Client = new AmazonS3Client(new CognitoCachingCredentialsProvider(SSCS3UploadWorker.this.getApplicationContext(), "ap-south-1:d6df173c-d6b5-48b5-87dd-266300ae6b7e", Regions.AP_SOUTH_1));
            amazonS3Client.setEndpoint(Const.AMAZON_S3_END_POINT);
            byte[] bytes = FilesKt.readBytes(this.$file);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(bytes.length);
            PutObjectRequest putObjectRequest = new PutObjectRequest(StringsKt.trimEnd("vc-10000386-38616500102/166/admin_v1/test_management/question_bank/", '/') + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.$testSeriesId, this.$file.getName(), new ByteArrayInputStream(bytes), objectMetadata);
            putObjectRequest.setCannedAcl(CannedAccessControlList.BucketOwnerFullControl);
            final Ref.LongRef longRef = new Ref.LongRef();
            final long contentLength = objectMetadata.getContentLength();
            final SSCS3UploadWorker sSCS3UploadWorker = SSCS3UploadWorker.this;
            putObjectRequest.setProgressListener(new ProgressListener() { // from class: com.appnew.android.testmodulessc.utils.SSCS3UploadWorker$uploadToS3$2$$ExternalSyntheticLambda0
                @Override // com.amazonaws.services.s3.model.ProgressListener
                public final void progressChanged(ProgressEvent progressEvent) {
                    SSCS3UploadWorker.AnonymousClass2.invokeSuspend$lambda$3(longRef, contentLength, sSCS3UploadWorker, progressEvent);
                }
            });
            amazonS3Client.putObject(putObjectRequest);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3(Ref.LongRef longRef, long j, SSCS3UploadWorker sSCS3UploadWorker, ProgressEvent progressEvent) {
            longRef.element = RangesKt.coerceAtMost(longRef.element + progressEvent.getBytesTransferred(), j);
            Pair[] pairArr = {TuplesKt.to("progress", Integer.valueOf(RangesKt.coerceIn((int) ((longRef.element * ((long) 100)) / j), 0, 100)))};
            Data.Builder builder = new Data.Builder();
            Pair pair = pairArr[0];
            builder.put((String) pair.getFirst(), pair.getSecond());
            sSCS3UploadWorker.setProgressAsync(builder.build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadToS3(File file, String str, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(file, str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
