package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InfiniteTransition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001ac\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u0002H\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001a?\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0014\u001aY\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u0002H\u00072\u0006\u0010\u000b\u001a\u0002H\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001a5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "label", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/InfiniteTransition;", "animateValue", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class InfiniteTransitionKt {
    public static final InfiniteTransition rememberInfiniteTransition(String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1013651573, "C(rememberInfiniteTransition)N(label)45@1988L38,46@2050L5:InfiniteTransition.kt#pdpnli");
        if ((i2 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1013651573, i, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -838410661, "CC(remember):InfiniteTransition.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new InfiniteTransition(str);
            composer.updateRememberedValue(objRememberedValue);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        infiniteTransition.run$animation_core(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return infiniteTransition;
    }

    public static final <T, V extends AnimationVector> State<T> animateValue(final InfiniteTransition infiniteTransition, final T t, final T t2, TwoWayConverter<T, V> twoWayConverter, final InfiniteRepeatableSpec<T> infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1062847727, "C(animateValue)N(initialValue,targetValue,typeConverter,animationSpec,label)246@10575L113,250@10705L364,250@10694L375,263@11113L108,263@11075L146:InfiniteTransition.kt#pdpnli");
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1062847727, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:245)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 805559650, "CC(remember):InfiniteTransition.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            InfiniteTransition.TransitionAnimationState transitionAnimationState = infiniteTransition.new TransitionAnimationState(t, t2, twoWayConverter, infiniteRepeatableSpec, str2);
            composer.updateRememberedValue(transitionAnimationState);
            objRememberedValue = transitionAnimationState;
        }
        final InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 805564061, "CC(remember):InfiniteTransition.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i & 112) ^ 48) > 32 && composer.changedInstance(t)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changedInstance(t2)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if ((((57344 & i) ^ 24576) <= 16384 || !composer.changedInstance(infiniteRepeatableSpec)) && (i & 24576) != 16384) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return InfiniteTransitionKt.animateValue$lambda$1$0(t, transitionAnimationState2, t2, infiniteRepeatableSpec);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) objRememberedValue2, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 805576861, "CC(remember):InfiniteTransition.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(infiniteTransition);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InfiniteTransitionKt.animateValue$lambda$2$0(infiniteTransition, transitionAnimationState2, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(transitionAnimationState2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return transitionAnimationState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateValue$lambda$1$0(Object obj, InfiniteTransition.TransitionAnimationState transitionAnimationState, Object obj2, InfiniteRepeatableSpec infiniteRepeatableSpec) {
        if (!Intrinsics.areEqual(obj, transitionAnimationState.getInitialValue$animation_core()) || !Intrinsics.areEqual(obj2, transitionAnimationState.getTargetValue$animation_core())) {
            transitionAnimationState.updateValues$animation_core(obj, obj2, infiniteRepeatableSpec);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult animateValue$lambda$2$0(final InfiniteTransition infiniteTransition, final InfiniteTransition.TransitionAnimationState transitionAnimationState, DisposableEffectScope disposableEffectScope) {
        infiniteTransition.addAnimation$animation_core(transitionAnimationState);
        return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$lambda$2$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                infiniteTransition.removeAnimation$animation_core(transitionAnimationState);
            }
        };
    }

    public static final State<Float> animateFloat(InfiniteTransition infiniteTransition, float f2, float f3, InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -644770905, "C(animateFloat)N(initialValue,targetValue,animationSpec,label)296@12385L84:InfiniteTransition.kt#pdpnli");
        String str2 = (i2 & 8) != 0 ? "FloatAnimation" : str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-644770905, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:296)");
        }
        int i3 = i << 3;
        State<Float> stateAnimateValue = animateValue(infiniteTransition, Float.valueOf(f2), Float.valueOf(f3), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), infiniteRepeatableSpec, str2, composer, (i & 1022) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "rememberInfiniteTransition APIs now have a new label parameter added.")
    public static final /* synthetic */ InfiniteTransition rememberInfiniteTransition(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -840193660, "C(rememberInfiniteTransition)304@12685L48:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-840193660, i, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:303)");
        }
        InfiniteTransition infiniteTransitionRememberInfiniteTransition = rememberInfiniteTransition("InfiniteTransition", composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return infiniteTransitionRememberInfiniteTransition;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateValue APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValue(InfiniteTransition infiniteTransition, Object obj, Object obj2, TwoWayConverter twoWayConverter, InfiniteRepeatableSpec infiniteRepeatableSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1695411770, "C(animateValue)N(initialValue,targetValue,typeConverter,animationSpec)318@13087L203:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695411770, i, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:317)");
        }
        int i2 = (i >> 3) & 8;
        State stateAnimateValue = animateValue(infiniteTransition, obj, obj2, twoWayConverter, infiniteRepeatableSpec, "ValueAnimation", composer, (i & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i2 << 3) | (i & 112) | (i2 << 6) | (i & 896) | (i & 7168) | (i & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateFloat APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloat(InfiniteTransition infiniteTransition, float f2, float f3, InfiniteRepeatableSpec infiniteRepeatableSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 469472752, "C(animateFloat)N(initialValue,targetValue,animationSpec)337@13593L164:InfiniteTransition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469472752, i, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:336)");
        }
        State<Float> stateAnimateFloat = animateFloat(infiniteTransition, f2, f3, infiniteRepeatableSpec, "FloatAnimation", composer, (i & 14) | 24576 | (i & 112) | (i & 896) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateFloat;
    }
}
