package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SnapshotFlow.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {467, 470, 475}, m = "invokeSuspend", n = {"$this$flow", "manager", "needToRerunBlock", "lastValue", "$this$flow", "manager", "needToRerunBlock", "lastValue", "$this$flow", "manager", "needToRerunBlock", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    final /* synthetic */ SnapshotFlowManager $externalManager;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1(SnapshotFlowManager snapshotFlowManager, Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1> continuation) {
        super(2, continuation);
        this.$externalManager = snapshotFlowManager;
        this.$block = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1 snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1(this.$externalManager, this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:26:0x0077, B:31:0x009a], limit reached: 40 */
    /* JADX WARN: Path cross not found for [B:31:0x009a, B:26:0x0077], limit reached: 40 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b A[Catch: all -> 0x003e, PHI: r1 r4 r5 r6
      0x008b: PHI (r1v6 java.lang.Object) = (r1v5 java.lang.Object), (r1v12 java.lang.Object) binds: [B:27:0x0088, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r4v8 ??) = (r4v13 ??), (r4v14 ??) binds: [B:27:0x0088, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r5v4 androidx.compose.runtime.SnapshotFlowManager) = (r5v3 androidx.compose.runtime.SnapshotFlowManager), (r5v8 androidx.compose.runtime.SnapshotFlowManager) binds: [B:27:0x0088, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x008b: PHI (r6v3 ??) = (r6v8 ??), (r6v9 ??) binds: [B:27:0x0088, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x003e, blocks: (B:11:0x0028, B:29:0x008b, B:26:0x0077, B:31:0x009a, B:14:0x003a), top: B:43:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #1 {all -> 0x003e, blocks: (B:11:0x0028, B:29:0x008b, B:26:0x0077, B:31:0x009a, B:14:0x003a), top: B:43:0x0009 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, kotlinx.coroutines.channels.Channel] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0098 -> B:26:0x0077). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ae -> B:26:0x0077). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L41
            if (r1 == r4) goto L2c
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L2c
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            java.lang.Object r1 = r8.L$3
            java.lang.Object r4 = r8.L$2
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r5 = r8.L$1
            androidx.compose.runtime.SnapshotFlowManager r5 = (androidx.compose.runtime.SnapshotFlowManager) r5
            java.lang.Object r6 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L3e
            goto L8b
        L2c:
            java.lang.Object r1 = r8.L$3
            java.lang.Object r4 = r8.L$2
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r5 = r8.L$1
            androidx.compose.runtime.SnapshotFlowManager r5 = (androidx.compose.runtime.SnapshotFlowManager) r5
            java.lang.Object r6 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L3e
            goto L77
        L3e:
            r9 = move-exception
            goto Lb3
        L41:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            r6 = r9
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            androidx.compose.runtime.SnapshotFlowManager r9 = r8.$externalManager
            if (r9 != 0) goto L52
            androidx.compose.runtime.SnapshotFlowManager r9 = new androidx.compose.runtime.SnapshotFlowManager
            r9.<init>()
        L52:
            r5 = r9
            r9 = 6
            r1 = 0
            kotlinx.coroutines.channels.Channel r9 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r4, r1, r1, r9, r1)
            r1 = r9
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1     // Catch: java.lang.Throwable -> Lb0
            kotlin.jvm.functions.Function0<T> r7 = r8.$block     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r1 = r5.runAndWatch$runtime(r1, r7)     // Catch: java.lang.Throwable -> Lb0
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: java.lang.Throwable -> Lb0
            r8.L$0 = r6     // Catch: java.lang.Throwable -> Lb0
            r8.L$1 = r5     // Catch: java.lang.Throwable -> Lb0
            r8.L$2 = r9     // Catch: java.lang.Throwable -> Lb0
            r8.L$3 = r1     // Catch: java.lang.Throwable -> Lb0
            r8.label = r4     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r4 = r6.emit(r1, r7)     // Catch: java.lang.Throwable -> Lb0
            if (r4 != r0) goto L76
            goto Lad
        L76:
            r4 = r9
        L77:
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch: java.lang.Throwable -> L3e
            r8.L$0 = r6     // Catch: java.lang.Throwable -> L3e
            r8.L$1 = r5     // Catch: java.lang.Throwable -> L3e
            r8.L$2 = r4     // Catch: java.lang.Throwable -> L3e
            r8.L$3 = r1     // Catch: java.lang.Throwable -> L3e
            r8.label = r3     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r9 = r4.receive(r9)     // Catch: java.lang.Throwable -> L3e
            if (r9 != r0) goto L8b
            goto Lad
        L8b:
            r9 = r4
            kotlinx.coroutines.channels.SendChannel r9 = (kotlinx.coroutines.channels.SendChannel) r9     // Catch: java.lang.Throwable -> L3e
            kotlin.jvm.functions.Function0<T> r7 = r8.$block     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r9 = r5.runAndWatch$runtime(r9, r7)     // Catch: java.lang.Throwable -> L3e
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r1)     // Catch: java.lang.Throwable -> L3e
            if (r7 != 0) goto L77
            r1 = r8
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Throwable -> L3e
            r8.L$0 = r6     // Catch: java.lang.Throwable -> L3e
            r8.L$1 = r5     // Catch: java.lang.Throwable -> L3e
            r8.L$2 = r4     // Catch: java.lang.Throwable -> L3e
            r8.L$3 = r9     // Catch: java.lang.Throwable -> L3e
            r8.label = r2     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r1 = r6.emit(r9, r1)     // Catch: java.lang.Throwable -> L3e
            if (r1 != r0) goto Lae
        Lad:
            return r0
        Lae:
            r1 = r9
            goto L77
        Lb0:
            r0 = move-exception
            r4 = r9
            r9 = r0
        Lb3:
            kotlinx.coroutines.channels.SendChannel r4 = (kotlinx.coroutines.channels.SendChannel) r4
            r5.reportSnapshotFlowCancellation$runtime(r4)
            androidx.compose.runtime.SnapshotFlowManager r0 = r8.$externalManager
            if (r0 != 0) goto Lbf
            r5.dispose()
        Lbf:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlowImpl$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
