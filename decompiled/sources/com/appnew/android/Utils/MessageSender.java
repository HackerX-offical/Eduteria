package com.appnew.android.Utils;

import android.util.Log;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MessageSender.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\"\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0006\u0010\u001f\u001a\u00020\u0004J\b\u0010 \u001a\u00020\u0006H\u0002R,\u0010\u0002\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/appnew/android/Utils/MessageSender;", "", "messageProcessingFunction", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "targetRatePerSecond", "", "testDurationSeconds", "<init>", "(Lkotlin/jvm/functions/Function2;II)V", "Lkotlin/jvm/functions/Function2;", "messageChannel", "Lkotlinx/coroutines/channels/Channel;", "isTestingActive", "", "sendingJob", "Lkotlinx/coroutines/Job;", "processingJob", "messageCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "startTesting", "isEmoji", "stopTesting", "startMessageSending", "count", "getCount", "()I", "setCount", "(I)V", "getRandomEmoji", "startMessageProcessing", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageSender {
    private static final String TAG = "HighFreqMsgTester";
    private int count;
    private boolean isTestingActive;
    private final Channel<String> messageChannel;
    private final AtomicInteger messageCounter;
    private final Function2<String, Continuation<? super Unit>, Object> messageProcessingFunction;
    private Job processingJob;
    private Job sendingJob;
    private final int targetRatePerSecond;
    private final int testDurationSeconds;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public MessageSender(Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> messageProcessingFunction, int i, int i2) {
        Intrinsics.checkNotNullParameter(messageProcessingFunction, "messageProcessingFunction");
        this.messageProcessingFunction = messageProcessingFunction;
        this.targetRatePerSecond = i;
        this.testDurationSeconds = i2;
        this.messageChannel = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.messageCounter = new AtomicInteger(0);
    }

    public /* synthetic */ MessageSender(Function2 function2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i3 & 2) != 0 ? 1000 : i, (i3 & 4) != 0 ? 10 : i2);
    }

    public final void startTesting(boolean isEmoji) {
        if (this.isTestingActive) {
            Log.w(TAG, "Testing is already active.");
            return;
        }
        this.isTestingActive = true;
        this.messageCounter.set(0);
        startMessageSending(isEmoji);
        startMessageProcessing();
        Log.i(TAG, "High-frequency message testing started for " + this.testDurationSeconds + " seconds at target rate of " + this.targetRatePerSecond + " messages/sec.");
    }

    public final void stopTesting() {
        if (!this.isTestingActive) {
            Log.w(TAG, "Testing is not active.");
            return;
        }
        this.isTestingActive = false;
        Job job = this.sendingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.processingJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        Log.i(TAG, "High-frequency message testing stopped. Total messages sent: " + this.messageCounter.get());
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.MessageSender$startMessageSending$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MessageSender.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.MessageSender$startMessageSending$1", f = "MessageSender.kt", i = {0, 0, 1, 1}, l = {67, 69}, m = "invokeSuspend", n = {"delayBetweenMessagesMs", "startTime", "delayBetweenMessagesMs", "startTime"}, s = {"J$0", "J$1", "J$0", "J$1"})
    static final class C05481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEmoji;
        long J$0;
        long J$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05481(boolean z, Continuation<? super C05481> continuation) {
            super(2, continuation);
            this.$isEmoji = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MessageSender.this.new C05481(this.$isEmoji, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Path cross not found for [B:15:0x0052, B:28:0x00cc], limit reached: 32 */
        /* JADX WARN: Path cross not found for [B:28:0x00cc, B:15:0x0052], limit reached: 32 */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ca -> B:15:0x0052). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00d9 -> B:15:0x0052). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.MessageSender.C05481.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void startMessageSending(boolean isEmoji) {
        this.sendingJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C05481(isEmoji, null), 3, null);
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final String getRandomEmoji() {
        return new String[]{"❤️", "👍", "😀", "😠", "😔", "😮"}[Random.INSTANCE.nextInt(6)];
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.MessageSender$startMessageProcessing$1, reason: invalid class name */
    /* JADX INFO: compiled from: MessageSender.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.appnew.android.Utils.MessageSender$startMessageProcessing$1", f = "MessageSender.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"processedCount", "start$iv"}, s = {"L$0", "J$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        long J$0;
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MessageSender.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.IntRef intRef;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                System.currentTimeMillis();
                intRef = new Ref.IntRef();
                MessageSender messageSender = MessageSender.this;
                long jCurrentTimeMillis = System.currentTimeMillis();
                Flow flowReceiveAsFlow = FlowKt.receiveAsFlow(messageSender.messageChannel);
                MessageSender$startMessageProcessing$1$1$1 messageSender$startMessageProcessing$1$1$1 = new MessageSender$startMessageProcessing$1$1$1(messageSender, intRef, null);
                this.L$0 = intRef;
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                if (FlowKt.collectLatest(flowReceiveAsFlow, messageSender$startMessageProcessing$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = jCurrentTimeMillis;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                intRef = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - j;
            double d2 = jCurrentTimeMillis2 > 0 ? (((double) intRef.element) * 1000.0d) / jCurrentTimeMillis2 : 0.0d;
            int i2 = intRef.element;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Boxing.boxDouble(d2)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            Log.i(MessageSender.TAG, "Message processing finished. Total processed: " + i2 + " in " + jCurrentTimeMillis2 + "ms (Actual rate: " + str + " messages/sec)");
            return Unit.INSTANCE;
        }
    }

    private final void startMessageProcessing() {
        this.processingJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
    }
}
