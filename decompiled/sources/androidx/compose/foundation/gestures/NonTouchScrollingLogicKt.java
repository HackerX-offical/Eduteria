package androidx.compose.foundation.gestures;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: NonTouchScrollingLogic.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0080@¢\u0006\u0002\u0010\u0003\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\bH\u0000¨\u0006\t"}, d2 = {"busyReceive", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/Channel;", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "untilNull", "Lkotlin/sequences/Sequence;", ExifInterface.LONGITUDE_EAST, "builderAction", "Lkotlin/Function0;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class NonTouchScrollingLogicKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$busyReceive$2, reason: invalid class name */
    /* JADX INFO: compiled from: NonTouchScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$busyReceive$2", f = "NonTouchScrollingLogic.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"job"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Channel<T> $this_busyReceive;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Channel<T> channel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_busyReceive = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_busyReceive, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r1 = this.label;
            try {
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, null, null, new NonTouchScrollingLogicKt$busyReceive$2$job$1(null), 3, null);
                    this.L$0 = jobLaunch$default;
                    this.label = 1;
                    obj = this.$this_busyReceive.receive(this);
                    r1 = jobLaunch$default;
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (r1 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Job job = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r1 = job;
                }
                return obj;
            } finally {
                Job.DefaultImpls.cancel$default((Job) r1, (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public static final <T> Object busyReceive(Channel<T> channel, Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(channel, null), continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$untilNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: NonTouchScrollingLogic.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.NonTouchScrollingLogicKt$untilNull$1", f = "NonTouchScrollingLogic.kt", i = {0}, l = {89}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<E> $builderAction;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function0<? extends E> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$builderAction = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$builderAction, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super E> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0037 -> B:15:0x003b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003a -> B:15:0x003b). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                java.lang.Object r1 = r4.L$1
                java.lang.Object r3 = r4.L$0
                kotlin.sequences.SequenceScope r3 = (kotlin.sequences.SequenceScope) r3
                kotlin.ResultKt.throwOnFailure(r5)
                goto L3b
            L15:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1d:
                kotlin.ResultKt.throwOnFailure(r5)
                java.lang.Object r5 = r4.L$0
                kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
                r3 = r5
            L25:
                kotlin.jvm.functions.Function0<E> r5 = r4.$builderAction
                java.lang.Object r1 = r5.invoke()
                if (r1 == 0) goto L3a
                r4.L$0 = r3
                r4.L$1 = r1
                r4.label = r2
                java.lang.Object r5 = r3.yield(r1, r4)
                if (r5 != r0) goto L3b
                return r0
            L3a:
                r1 = 0
            L3b:
                if (r1 != 0) goto L25
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.NonTouchScrollingLogicKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <E> Sequence<E> untilNull(Function0<? extends E> function0) {
        return SequencesKt.sequence(new AnonymousClass1(function0, null));
    }
}
