package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1 implements PointerInputEventHandler {
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function1<Offset, Unit>> $onTapState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX WARN: Multi-variable type inference failed */
    TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, State<? extends Function1<? super Offset, Unit>> state) {
        this.$scope = coroutineScope;
        this.$pressedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
        this.$onTapState = state;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1", f = "TextFieldPressGestureFilter.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
        final /* synthetic */ CoroutineScope $scope;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CoroutineScope coroutineScope, MutableState<PressInteraction.Press> mutableState, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$scope = coroutineScope;
            this.$pressedInteraction = mutableState;
            this.$interactionSource = mutableInteractionSource;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
            return m1848invoked4ec7I(pressGestureScope, offset.m5733unboximpl(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1848invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, continuation);
            anonymousClass1.L$0 = pressGestureScope;
            anonymousClass1.J$0 = j;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$1", f = "TextFieldPressGestureFilter.kt", i = {1}, l = {60, 64}, m = "invokeSuspend", n = {"interaction"}, s = {"L$0"}, v = 1)
        static final class C00301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ long $it;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00301(MutableState<PressInteraction.Press> mutableState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C00301> continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$it = j;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00301(this.$pressedInteraction, this.$it, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r7.label
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L27
                    if (r1 == r4) goto L1f
                    if (r1 != r3) goto L17
                    java.lang.Object r0 = r7.L$0
                    androidx.compose.foundation.interaction.PressInteraction$Press r0 = (androidx.compose.foundation.interaction.PressInteraction.Press) r0
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L6e
                L17:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L1f:
                    java.lang.Object r1 = r7.L$0
                    androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L4d
                L27:
                    kotlin.ResultKt.throwOnFailure(r8)
                    androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r8 = r7.$pressedInteraction
                    java.lang.Object r8 = r8.getValue()
                    androidx.compose.foundation.interaction.PressInteraction$Press r8 = (androidx.compose.foundation.interaction.PressInteraction.Press) r8
                    if (r8 == 0) goto L51
                    androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                    androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r5 = r7.$pressedInteraction
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                    r6.<init>(r8)
                    if (r1 == 0) goto L4e
                    androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                    r7.L$0 = r5
                    r7.label = r4
                    java.lang.Object r8 = r1.emit(r6, r7)
                    if (r8 != r0) goto L4c
                    goto L6c
                L4c:
                    r1 = r5
                L4d:
                    r5 = r1
                L4e:
                    r5.setValue(r2)
                L51:
                    androidx.compose.foundation.interaction.PressInteraction$Press r8 = new androidx.compose.foundation.interaction.PressInteraction$Press
                    long r4 = r7.$it
                    r8.<init>(r4, r2)
                    androidx.compose.foundation.interaction.MutableInteractionSource r1 = r7.$interactionSource
                    if (r1 == 0) goto L6f
                    r2 = r8
                    androidx.compose.foundation.interaction.Interaction r2 = (androidx.compose.foundation.interaction.Interaction) r2
                    r4 = r7
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r7.L$0 = r8
                    r7.label = r3
                    java.lang.Object r1 = r1.emit(r2, r4)
                    if (r1 != r0) goto L6d
                L6c:
                    return r0
                L6d:
                    r0 = r8
                L6e:
                    r8 = r0
                L6f:
                    androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.PressInteraction$Press> r0 = r7.$pressedInteraction
                    r0.setValue(r8)
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.AnonymousClass1.C00301.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new C00301(this.$pressedInteraction, this.J$0, this.$interactionSource, null), 3, null);
                this.label = 1;
                obj = pressGestureScope.tryAwaitRelease(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: TextFieldPressGestureFilter.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1$2", f = "TextFieldPressGestureFilter.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ MutableInteractionSource $interactionSource;
            final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
            final /* synthetic */ boolean $success;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(MutableState<PressInteraction.Press> mutableState, boolean z, MutableInteractionSource mutableInteractionSource, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$pressedInteraction = mutableState;
                this.$success = z;
                this.$interactionSource = mutableInteractionSource;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$pressedInteraction, this.$success, this.$interactionSource, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                MutableState<PressInteraction.Press> mutableState;
                PressInteraction.Cancel cancel;
                MutableState<PressInteraction.Press> mutableState2;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressInteraction.Press value = this.$pressedInteraction.getValue();
                    if (value != null) {
                        boolean z = this.$success;
                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                        mutableState = this.$pressedInteraction;
                        if (z) {
                            cancel = new PressInteraction.Release(value);
                        } else {
                            cancel = new PressInteraction.Cancel(value);
                        }
                        if (mutableInteractionSource != null) {
                            this.L$0 = mutableState;
                            this.label = 1;
                            if (mutableInteractionSource.emit(cancel, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mutableState2 = mutableState;
                        }
                        mutableState.setValue(null);
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableState2 = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableState = mutableState2;
                mutableState.setValue(null);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, this.$pressedInteraction, this.$interactionSource, null);
        final State<Function1<Offset, Unit>> state = this.$onTapState;
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, anonymousClass1, new Function1() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1.invoke$lambda$0(state, (Offset) obj);
            }
        }, continuation);
        return objDetectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(State state, Offset offset) {
        ((Function1) state.getValue()).invoke(offset);
        return Unit.INSTANCE;
    }
}
