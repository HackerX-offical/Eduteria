package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.TransformableStateKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007\u001ah\u0010\u0000\u001a\u00020\u00012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\f\u001aZ\u0010\u000e\u001a\u00020\u00012K\u0010\u0002\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001ao\u0010\u000e\u001a\u00020\u00012`\u0010\u0002\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\fH\u0007¢\u0006\u0002\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001a6\u0010\u0011\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0002\u0010\u0015\u001a6\u0010\u0018\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001a\u0010\u0017\u001a,\u0010\u001b\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0087@¢\u0006\u0004\b\u001d\u0010\u001e\u001a6\u0010\u001b\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001f\u0010 \u001a\\\u0010!\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0087@¢\u0006\u0004\b'\u0010(\u001af\u0010!\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00042\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b)\u0010*\u001a\u001a\u0010-\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010.\u001a&\u0010-\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b/\u00100\u001a\u001a\u00101\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010.\u001a&\u00101\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b2\u00100\u001a\u001c\u00103\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\bH\u0087@¢\u0006\u0004\b4\u00105\u001a&\u00103\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0086@¢\u0006\u0004\b6\u00107\u001a\u001c\u00108\u001a\u00020\u000b*\u00020\u00012\b\b\u0002\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;\"\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"TransformableState", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "Lkotlin/Function4;", "centroid", "rememberTransformableState", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "animateZoomBy", "zoomFactor", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateZoomBy-Fgt4K4Q", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateRotateBy", "degrees", "animateRotateBy-Fgt4K4Q", "animatePanBy", "offset", "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animatePanBy-umk_asQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy", "panOffset", "rotationDegrees", "zoomAnimationSpec", "panAnimationSpec", "rotationAnimationSpec", "animateBy-Su4bsnU", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateBy-jlnHOkQ", "(Landroidx/compose/foundation/gestures/TransformableState;FJFLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ZeroAnimationVelocity", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zoomBy-Rg1IO4c", "(Landroidx/compose/foundation/gestures/TransformableState;FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rotateBy", "rotateBy-Rg1IO4c", "panBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "panBy-DUneCvk", "(Landroidx/compose/foundation/gestures/TransformableState;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopTransformation", "terminationPriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransformableStateKt {
    private static final AnimationData ZeroAnimationVelocity = new AnimationData(0.0f, Offset.INSTANCE.m5739getZeroF1C5BW0(), 0.0f, null);

    @Deprecated(message = "Prefer creating TransformableState with a onTransformation lambda that takes the centroid. This centroid (if specified) is the point at which zooming or rotation should happen around which allows for more natural transformations.")
    public static final TransformableState TransformableState(final Function3<? super Float, ? super Offset, ? super Float, Unit> function3) {
        return TransformableState((Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit>) new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return TransformableStateKt.TransformableState$lambda$0(function3, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransformableState$lambda$0(Function3 function3, Offset offset, float f2, Offset offset2, float f3) {
        function3.invoke(Float.valueOf(f2), offset2, Float.valueOf(f3));
        return Unit.INSTANCE;
    }

    public static final TransformableState TransformableState(Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit> function4) {
        return new DefaultTransformableState(function4);
    }

    @Deprecated(message = "Prefer remembering a TransformableState with a onTransformation lambda that takes the centroid. This centroid (if specified) is the point at which zooming or rotation should happen around which allows for more natural transformations.")
    public static final TransformableState rememberTransformableState(final Function3<? super Float, ? super Offset, ? super Float, Unit> function3, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1681419281, "C(rememberTransformableState)N(onTransformation)189@9448L43,189@9421L70:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:189)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 936231388, "CC(remember):TransformableState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(function3)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return TransformableStateKt.rememberTransformableState$lambda$0$0(function3, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TransformableState transformableStateRememberTransformableState = rememberTransformableState((Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit>) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transformableStateRememberTransformableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberTransformableState$lambda$0$0(Function3 function3, Offset offset, float f2, Offset offset2, float f3) {
        function3.invoke(Float.valueOf(f2), offset2, Float.valueOf(f3));
        return Unit.INSTANCE;
    }

    public static final TransformableState rememberTransformableState(Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit> function4, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -963411216, "C(rememberTransformableState)N(onTransformation)211@10617L38,212@10667L86:TransformableState.kt#8bwon0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-963411216, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:210)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1874765318, "CC(remember):TransformableState.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = TransformableState((Function4<? super Offset, ? super Float, ? super Offset, ? super Float, Unit>) new Function4() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return TransformableStateKt.rememberTransformableState$lambda$1$0(stateRememberUpdatedState, (Offset) obj, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        TransformableState transformableState = (TransformableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transformableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberTransformableState$lambda$1$0(State state, Offset offset, float f2, Offset offset2, float f3) {
        ((Function4) state.getValue()).invoke(offset, Float.valueOf(f2), offset2, Float.valueOf(f3));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f2, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f2, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object animateZoomBy(TransformableState transformableState, float f2, AnimationSpec animationSpec, Continuation continuation) {
        Object objM741animateZoomByFgt4K4Q = m741animateZoomByFgt4K4Q(transformableState, f2, animationSpec, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM741animateZoomByFgt4K4Q == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM741animateZoomByFgt4K4Q : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animateZoomBy-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ Object m742animateZoomByFgt4K4Q$default(TransformableState transformableState, float f2, AnimationSpec animationSpec, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m741animateZoomByFgt4K4Q(transformableState, f2, animationSpec2, j, continuation);
    }

    /* JADX INFO: renamed from: animateZoomBy-Fgt4K4Q, reason: not valid java name */
    public static final Object m741animateZoomByFgt4K4Q(TransformableState transformableState, float f2, AnimationSpec<Float> animationSpec, long j, Continuation<? super Unit> continuation) {
        if (!(f2 > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = 1.0f;
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass4(floatRef, f2, animationSpec, j, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$4, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$4", f = "TransformableState.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ long $centroid;
        final /* synthetic */ Ref.FloatRef $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Ref.FloatRef floatRef, float f2, AnimationSpec<Float> animationSpec, long j, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$previous = floatRef;
            this.$zoomFactor = f2;
            this.$animationSpec = animationSpec;
            this.$centroid = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$previous, this.$zoomFactor, this.$animationSpec, this.$centroid, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0L, 0L, false, 30, null);
                Float fBoxFloat = Boxing.boxFloat(this.$zoomFactor);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                final long j = this.$centroid;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformableStateKt.AnonymousClass4.invokeSuspend$lambda$0(floatRef, transformScope, j, (AnimationScope) obj2);
                    }
                }, this, 4, null) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, TransformScope transformScope, long j, AnimationScope animationScope) {
            TransformScope.m725transformByWithCentroidIEwrmTk$default(transformScope, j, floatRef.element == 0.0f ? 1.0f : ((Number) animationScope.getValue()).floatValue() / floatRef.element, 0L, 0.0f, 12, null);
            floatRef.element = ((Number) animationScope.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f2, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f2, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object animateRotateBy(TransformableState transformableState, float f2, AnimationSpec animationSpec, Continuation continuation) {
        Object objM739animateRotateByFgt4K4Q = m739animateRotateByFgt4K4Q(transformableState, f2, animationSpec, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM739animateRotateByFgt4K4Q == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM739animateRotateByFgt4K4Q : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animateRotateBy-Fgt4K4Q$default, reason: not valid java name */
    public static /* synthetic */ Object m740animateRotateByFgt4K4Q$default(TransformableState transformableState, float f2, AnimationSpec animationSpec, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m739animateRotateByFgt4K4Q(transformableState, f2, animationSpec2, j, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$3, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$3", f = "TransformableState.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ long $centroid;
        final /* synthetic */ float $degrees;
        final /* synthetic */ Ref.FloatRef $previous;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.FloatRef floatRef, float f2, AnimationSpec<Float> animationSpec, long j, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$previous = floatRef;
            this.$degrees = f2;
            this.$animationSpec = animationSpec;
            this.$centroid = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$previous, this.$degrees, this.$animationSpec, this.$centroid, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0L, 0L, false, 30, null);
                Float fBoxFloat = Boxing.boxFloat(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                final long j = this.$centroid;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, fBoxFloat, animationSpec, false, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TransformableStateKt.AnonymousClass3.invokeSuspend$lambda$0(floatRef, transformScope, j, (AnimationScope) obj2);
                    }
                }, this, 4, null) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, TransformScope transformScope, long j, AnimationScope animationScope) {
            TransformScope.m725transformByWithCentroidIEwrmTk$default(transformScope, j, 0.0f, 0L, ((Number) animationScope.getValue()).floatValue() - floatRef.element, 6, null);
            floatRef.element = ((Number) animationScope.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: animateRotateBy-Fgt4K4Q, reason: not valid java name */
    public static final Object m739animateRotateByFgt4K4Q(TransformableState transformableState, float f2, AnimationSpec<Float> animationSpec, long j, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass3(new Ref.FloatRef(), f2, animationSpec, j, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m736animatePanByubNVwUQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m735animatePanByubNVwUQ(transformableState, j, animationSpec, continuation);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final /* synthetic */ Object m735animatePanByubNVwUQ(TransformableState transformableState, long j, AnimationSpec animationSpec, Continuation continuation) {
        Object objM737animatePanByumk_asQ = m737animatePanByumk_asQ(transformableState, j, animationSpec, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM737animatePanByumk_asQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM737animatePanByumk_asQ : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animatePanBy-umk_asQ$default, reason: not valid java name */
    public static /* synthetic */ Object m738animatePanByumk_asQ$default(TransformableState transformableState, long j, AnimationSpec animationSpec, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i & 4) != 0) {
            j2 = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m737animatePanByumk_asQ(transformableState, j, animationSpec2, j2, continuation);
    }

    /* JADX INFO: renamed from: animatePanBy-umk_asQ, reason: not valid java name */
    public static final Object m737animatePanByumk_asQ(TransformableState transformableState, long j, AnimationSpec<Offset> animationSpec, long j2, Continuation<? super Unit> continuation) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = Offset.INSTANCE.m5739getZeroF1C5BW0();
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animatePanBy$3(longRef, j, animationSpec, j2, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: animateBy-Su4bsnU, reason: not valid java name */
    public static final /* synthetic */ Object m731animateBySu4bsnU(TransformableState transformableState, float f2, long j, float f3, AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, Continuation continuation) {
        Object objM733animateByjlnHOkQ = m733animateByjlnHOkQ(transformableState, f2, j, f3, animationSpec, animationSpec2, animationSpec3, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM733animateByjlnHOkQ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM733animateByjlnHOkQ : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: animateBy-jlnHOkQ$default, reason: not valid java name */
    public static /* synthetic */ Object m734animateByjlnHOkQ$default(TransformableState transformableState, float f2, long j, float f3, AnimationSpec animationSpec, AnimationSpec animationSpec2, AnimationSpec animationSpec3, long j2, Continuation continuation, int i, Object obj) {
        long jM5738getUnspecifiedF1C5BW0;
        TransformableState transformableState2;
        float f4;
        long j3;
        float f5;
        Continuation continuation2;
        AnimationSpec springSpec = (i & 8) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec;
        AnimationSpec springSpec2 = (i & 16) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec2;
        AnimationSpec springSpec3 = (i & 32) != 0 ? new SpringSpec(0.0f, 200.0f, null, 5, null) : animationSpec3;
        if ((i & 64) != 0) {
            jM5738getUnspecifiedF1C5BW0 = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
            f4 = f2;
            j3 = j;
            f5 = f3;
            continuation2 = continuation;
            transformableState2 = transformableState;
        } else {
            jM5738getUnspecifiedF1C5BW0 = j2;
            transformableState2 = transformableState;
            f4 = f2;
            j3 = j;
            f5 = f3;
            continuation2 = continuation;
        }
        return m733animateByjlnHOkQ(transformableState2, f4, j3, f5, springSpec, springSpec2, springSpec3, jM5738getUnspecifiedF1C5BW0, continuation2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.compose.foundation.gestures.AnimationData] */
    /* JADX INFO: renamed from: animateBy-jlnHOkQ, reason: not valid java name */
    public static final Object m733animateByjlnHOkQ(TransformableState transformableState, float f2, long j, float f3, AnimationSpec<Float> animationSpec, AnimationSpec<Offset> animationSpec2, AnimationSpec<Float> animationSpec3, long j2, Continuation<? super Unit> continuation) {
        if (!(f2 > 0.0f)) {
            InlineClassHelperKt.throwIllegalArgumentException("zoom value should be greater than 0");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new AnimationData(1.0f, Offset.INSTANCE.m5739getZeroF1C5BW0(), 0.0f, null);
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animateBy$4(objectRef, new AnimationData(f2, j, f3, null), new DelegatingAnimationSpec(animationSpec, animationSpec2, animationSpec3), j2, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object zoomBy(TransformableState transformableState, float f2, Continuation continuation) {
        Object objM748zoomByRg1IO4c = m748zoomByRg1IO4c(transformableState, f2, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM748zoomByRg1IO4c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM748zoomByRg1IO4c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$3", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03173 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $centroid;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03173(long j, float f2, Continuation<? super C03173> continuation) {
            super(2, continuation);
            this.$centroid = j;
            this.$zoomFactor = f2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03173 c03173 = new C03173(this.$centroid, this.$zoomFactor, continuation);
            c03173.L$0 = obj;
            return c03173;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((C03173) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((TransformScope) this.L$0).mo542transformByWithCentroidIEwrmTk(this.$centroid, this.$zoomFactor, Offset.INSTANCE.m5739getZeroF1C5BW0(), 0.0f);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: zoomBy-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ Object m749zoomByRg1IO4c$default(TransformableState transformableState, float f2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m748zoomByRg1IO4c(transformableState, f2, j, continuation);
    }

    /* JADX INFO: renamed from: zoomBy-Rg1IO4c, reason: not valid java name */
    public static final Object m748zoomByRg1IO4c(TransformableState transformableState, float f2, long j, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C03173(j, f2, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ Object rotateBy(TransformableState transformableState, float f2, Continuation continuation) {
        Object objM746rotateByRg1IO4c = m746rotateByRg1IO4c(transformableState, f2, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM746rotateByRg1IO4c == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM746rotateByRg1IO4c : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$3", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C03163 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $centroid;
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03163(long j, float f2, Continuation<? super C03163> continuation) {
            super(2, continuation);
            this.$centroid = j;
            this.$degrees = f2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03163 c03163 = new C03163(this.$centroid, this.$degrees, continuation);
            c03163.L$0 = obj;
            return c03163;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((C03163) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((TransformScope) this.L$0).mo542transformByWithCentroidIEwrmTk(this.$centroid, 1.0f, Offset.INSTANCE.m5739getZeroF1C5BW0(), this.$degrees);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: rotateBy-Rg1IO4c$default, reason: not valid java name */
    public static /* synthetic */ Object m747rotateByRg1IO4c$default(TransformableState transformableState, float f2, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m746rotateByRg1IO4c(transformableState, f2, j, continuation);
    }

    /* JADX INFO: renamed from: rotateBy-Rg1IO4c, reason: not valid java name */
    public static final Object m746rotateByRg1IO4c(TransformableState transformableState, float f2, long j, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C03163(j, f2, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final /* synthetic */ Object m745panByd4ec7I(TransformableState transformableState, long j, Continuation continuation) {
        Object objM743panByDUneCvk = m743panByDUneCvk(transformableState, j, Offset.INSTANCE.m5738getUnspecifiedF1C5BW0(), continuation);
        return objM743panByDUneCvk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM743panByDUneCvk : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: panBy-DUneCvk$default, reason: not valid java name */
    public static /* synthetic */ Object m744panByDUneCvk$default(TransformableState transformableState, long j, long j2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        return m743panByDUneCvk(transformableState, j, j2, continuation);
    }

    /* JADX INFO: renamed from: panBy-DUneCvk, reason: not valid java name */
    public static final Object m743panByDUneCvk(TransformableState transformableState, long j, long j2, Continuation<? super Unit> continuation) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$panBy$3(j2, j, null), continuation, 1, null);
        return objTransform$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, continuation);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        Object objTransform = transformableState.transform(mutatePriority, new AnonymousClass2(null), continuation);
        return objTransform == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objTransform : Unit.INSTANCE;
    }
}
