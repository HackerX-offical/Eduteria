package androidx.compose.material3;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DragHandle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a0\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"VerticalDragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "colors", "Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DragHandleSizes;Landroidx/compose/material3/DragHandleColors;Landroidx/compose/material3/DragHandleShapes;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "pressable", "onPressed", "Lkotlin/Function0;", "onReleasedOrCancelled", "material3", "isDragged", "", "isPressed"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragHandleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$16(Modifier modifier, DragHandleSizes dragHandleSizes, DragHandleColors dragHandleColors, DragHandleShapes dragHandleShapes, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        VerticalDragHandle(modifier, dragHandleSizes, dragHandleColors, dragHandleShapes, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VerticalDragHandle(androidx.compose.ui.Modifier r25, androidx.compose.material3.DragHandleSizes r26, androidx.compose.material3.DragHandleColors r27, androidx.compose.material3.DragHandleShapes r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragHandleKt.VerticalDragHandle(androidx.compose.ui.Modifier, androidx.compose.material3.DragHandleSizes, androidx.compose.material3.DragHandleColors, androidx.compose.material3.DragHandleShapes, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean VerticalDragHandle$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void VerticalDragHandle$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$6$lambda$5(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$8$lambda$7(MutableState mutableState) {
        VerticalDragHandle$lambda$4(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$10$lambda$9(DragHandleShapes dragHandleShapes, State state, MutableState mutableState, GraphicsLayerScope graphicsLayerScope) {
        Shape pressedShape;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedShape = dragHandleShapes.getDraggedShape();
        } else {
            pressedShape = VerticalDragHandle$lambda$3(mutableState) ? dragHandleShapes.getPressedShape() : dragHandleShapes.getShape();
        }
        graphicsLayerScope.setShape(pressedShape);
        graphicsLayerScope.setClip(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult VerticalDragHandle$lambda$13$lambda$12(DragHandleSizes dragHandleSizes, State state, MutableState mutableState, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        long pressedSize;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedSize = dragHandleSizes.getDraggedSize();
        } else {
            pressedSize = VerticalDragHandle$lambda$3(mutableState) ? dragHandleSizes.getPressedSize() : dragHandleSizes.getSize();
        }
        long j = measureScope.mo489toSizeXkaWNTQ(pressedSize);
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(Math.round(Float.intBitsToFloat((int) (j >> 32))), Math.round(Float.intBitsToFloat((int) (j & 4294967295L)))));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.DragHandleKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragHandleKt.VerticalDragHandle$lambda$13$lambda$12$lambda$11(placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$13$lambda$12$lambda$11(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalDragHandle$lambda$15$lambda$14(DragHandleColors dragHandleColors, State state, MutableState mutableState, DrawScope drawScope) {
        long pressedColor;
        if (VerticalDragHandle$lambda$1(state)) {
            pressedColor = dragHandleColors.getDraggedColor();
        } else {
            pressedColor = VerticalDragHandle$lambda$3(mutableState) ? dragHandleColors.getPressedColor() : dragHandleColors.getColor();
        }
        DrawScope.m6543drawRectnJ9OG0$default(drawScope, pressedColor, 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.INSTANCE;
    }

    private static final Modifier pressable(Modifier modifier, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mutableInteractionSource, new PointerInputEventHandler() { // from class: androidx.compose.material3.DragHandleKt.pressable.1

            /* JADX INFO: renamed from: androidx.compose.material3.DragHandleKt$pressable$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: DragHandle.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DragHandleKt$pressable$1$1", f = "DragHandle.kt", i = {0}, l = {FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 343}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            static final class C00471 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function0<Unit> $onPressed;
                final /* synthetic */ Function0<Unit> $onReleasedOrCancelled;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00471(Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C00471> continuation) {
                    super(2, continuation);
                    this.$onPressed = function0;
                    this.$onReleasedOrCancelled = function02;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00471 c00471 = new C00471(this.$onPressed, this.$onReleasedOrCancelled, continuation);
                    c00471.L$0 = obj;
                    return c00471;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00471) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
                
                    if (androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, androidx.compose.ui.input.pointer.PointerEventPass.Initial, r10) == r0) goto L16;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r10.label
                        r2 = 2
                        r3 = 1
                        if (r1 == 0) goto L22
                        if (r1 == r3) goto L1a
                        if (r1 != r2) goto L12
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L54
                    L12:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r0)
                        throw r11
                    L1a:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L3e
                    L22:
                        kotlin.ResultKt.throwOnFailure(r11)
                        java.lang.Object r11 = r10.L$0
                        r4 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                        androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r7 = r10
                        kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                        r10.L$0 = r4
                        r10.label = r3
                        r5 = 0
                        r8 = 1
                        r9 = 0
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown$default(r4, r5, r6, r7, r8, r9)
                        if (r11 != r0) goto L3d
                        goto L53
                    L3d:
                        r1 = r4
                    L3e:
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.$onPressed
                        r11.invoke()
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r10
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4 = 0
                        r10.L$0 = r4
                        r10.label = r2
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(r1, r11, r3)
                        if (r11 != r0) goto L54
                    L53:
                        return r0
                    L54:
                        kotlin.jvm.functions.Function0<kotlin.Unit> r11 = r10.$onReleasedOrCancelled
                        r11.invoke()
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DragHandleKt.AnonymousClass1.C00471.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00471(function0, function02, null), continuation);
                return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    private static final boolean VerticalDragHandle$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
