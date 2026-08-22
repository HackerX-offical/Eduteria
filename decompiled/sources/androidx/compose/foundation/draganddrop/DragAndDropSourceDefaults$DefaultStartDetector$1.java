package androidx.compose.foundation.draganddrop;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/draganddrop/DragAndDropStartDetectorScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DragAndDropSourceDefaults$DefaultStartDetector$1 extends SuspendLambda implements Function2<DragAndDropStartDetectorScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    DragAndDropSourceDefaults$DefaultStartDetector$1(Continuation<? super DragAndDropSourceDefaults$DefaultStartDetector$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragAndDropSourceDefaults$DefaultStartDetector$1 dragAndDropSourceDefaults$DefaultStartDetector$1 = new DragAndDropSourceDefaults$DefaultStartDetector$1(continuation);
        dragAndDropSourceDefaults$DefaultStartDetector$1.L$0 = obj;
        return dragAndDropSourceDefaults$DefaultStartDetector$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Continuation<? super Unit> continuation) {
        return ((DragAndDropSourceDefaults$DefaultStartDetector$1) create(dragAndDropStartDetectorScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DragAndDropStartDetectorScope dragAndDropStartDetectorScope = (DragAndDropStartDetectorScope) this.L$0;
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(dragAndDropStartDetectorScope, new PressGestureScopeImpl(dragAndDropStartDetectorScope), null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        final /* synthetic */ DragAndDropStartDetectorScope $this;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this = dragAndDropStartDetectorScope;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this, this.$pressScope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1", f = "AndroidDragAndDropSource.android.kt", i = {0}, l = {48, 50, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
        static final class C00121 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ DragAndDropStartDetectorScope $this;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00121(CoroutineScope coroutineScope, PressGestureScopeImpl pressGestureScopeImpl, DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Continuation<? super C00121> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$pressScope = pressGestureScopeImpl;
                this.$this = dragAndDropStartDetectorScope;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$0() {
                return true;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00121 c00121 = new C00121(this.$$this$coroutineScope, this.$pressScope, this.$this, continuation);
                c00121.L$0 = obj;
                return c00121;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((C00121) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
            
                if (androidx.compose.foundation.gestures.DragGestureDetectorKt.processDragGesture(r4, r5, r6, null, new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda1(r14), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda2(), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda3(), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda4(), r13) == r0) goto L22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
            
                if (androidx.compose.foundation.gestures.TapGestureDetectorKt.processTapGesture(r4, r5, r6, null, new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda5(r14), new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1.AnonymousClass1.C00121.AnonymousClass7(null), null, r13) == r0) goto L22;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) {
                /*
                    r13 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r13.label
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r4) goto L1f
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    goto L1a
                L12:
                    java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r14.<init>(r0)
                    throw r14
                L1a:
                    kotlin.ResultKt.throwOnFailure(r14)
                    goto La2
                L1f:
                    java.lang.Object r1 = r13.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    kotlin.ResultKt.throwOnFailure(r14)
                    goto L40
                L27:
                    kotlin.ResultKt.throwOnFailure(r14)
                    java.lang.Object r14 = r13.L$0
                    r1 = r14
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                    androidx.compose.ui.input.pointer.PointerEventPass r14 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                    r5 = r13
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r13.L$0 = r1
                    r13.label = r4
                    r4 = 0
                    java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r4, r14, r5)
                    if (r14 != r0) goto L40
                    goto La1
                L40:
                    r4 = r1
                    r5 = r14
                    androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
                    int r14 = r5.getType()
                    androidx.compose.ui.input.pointer.PointerType$Companion r1 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
                    int r1 = r1.m7390getMouseT8wyACA()
                    boolean r14 = androidx.compose.ui.input.pointer.PointerType.m7385equalsimpl0(r14, r1)
                    r1 = 0
                    if (r14 == 0) goto L7f
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda0 r6 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda0
                    r6.<init>()
                    androidx.compose.foundation.draganddrop.DragAndDropStartDetectorScope r14 = r13.$this
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda1 r8 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda1
                    r8.<init>()
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda2 r9 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda2
                    r9.<init>()
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda3 r10 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda3
                    r10.<init>()
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda4 r11 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda4
                    r11.<init>()
                    r12 = r13
                    kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
                    r13.L$0 = r1
                    r13.label = r3
                    r7 = 0
                    java.lang.Object r14 = androidx.compose.foundation.gestures.DragGestureDetectorKt.processDragGesture(r4, r5, r6, r7, r8, r9, r10, r11, r12)
                    if (r14 != r0) goto La2
                    goto La1
                L7f:
                    kotlinx.coroutines.CoroutineScope r5 = r13.$$this$coroutineScope
                    androidx.compose.foundation.gestures.PressGestureScopeImpl r6 = r13.$pressScope
                    androidx.compose.foundation.draganddrop.DragAndDropStartDetectorScope r14 = r13.$this
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda5 r8 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$$ExternalSyntheticLambda5
                    r8.<init>()
                    androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7 r14 = new androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7
                    r14.<init>(r1)
                    r9 = r14
                    kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
                    r11 = r13
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    r13.L$0 = r1
                    r13.label = r2
                    r7 = 0
                    r10 = 0
                    java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.processTapGesture(r4, r5, r6, r7, r8, r9, r10, r11)
                    if (r14 != r0) goto La2
                La1:
                    return r0
                La2:
                    kotlin.Unit r14 = kotlin.Unit.INSTANCE
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1.AnonymousClass1.C00121.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$1(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
                dragAndDropStartDetectorScope.mo480requestDragAndDropTransferk4lQ0M(pointerInputChange.getPosition());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$2(PointerInputChange pointerInputChange, Offset offset) {
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$4(PointerInputChange pointerInputChange) {
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7, reason: invalid class name */
            /* JADX INFO: compiled from: AndroidDragAndDropSource.android.kt */
            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceDefaults$DefaultStartDetector$1$1$1$7", f = "AndroidDragAndDropSource.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass7 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
                    super(3, continuation);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                    return m476invoked4ec7I(pressGestureScope, offset.m5733unboximpl(), continuation);
                }

                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final Object m476invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                    return new AnonymousClass7(continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$5(DragAndDropStartDetectorScope dragAndDropStartDetectorScope, Offset offset) {
                dragAndDropStartDetectorScope.mo480requestDragAndDropTransferk4lQ0M(offset.m5733unboximpl());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$this, new C00121(coroutineScope, this.$pressScope, this.$this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
