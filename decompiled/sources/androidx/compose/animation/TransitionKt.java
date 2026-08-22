package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0082\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042*\b\n\u0010\u0005\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2&\u0010\r\u001a\"\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\tH\u0087\b¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "label", "", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TransitionKt {
    public static final <S> State<Color> animateColor(final Transition<S> transition, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> function3, String str, Function3<? super S, ? super Composer, ? super Integer, Color> function32, Composer composer, int i, int i2) {
        Object currentState;
        ComposerKt.sourceInformationMarkerStart(composer, -64433887, "CC(animateColor)N(transitionSpec,label,targetValueByState)67@3230L31,68@3297L58,70@3368L70:Transition.kt#xbi5r1");
        AnonymousClass1 anonymousClass1 = (i2 & 1) != 0 ? new Function3<Transition.Segment<S>, Composer, Integer, SpringSpec<Color>>() { // from class: androidx.compose.animation.TransitionKt.animateColor.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpringSpec<Color> invoke(Object obj, Composer composer2, Integer num) {
                return invoke((Transition.Segment) obj, composer2, num.intValue());
            }

            public final SpringSpec<Color> invoke(Transition.Segment<S> segment, Composer composer2, int i3) {
                composer2.startReplaceGroup(-781456724);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-781456724, i3, -1, "androidx.compose.animation.animateColor.<anonymous> (Transition.kt:62)");
                }
                SpringSpec<Color> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                return springSpecSpring$default;
            }
        } : function3;
        String str2 = (i2 & 2) != 0 ? "ColorAnimation" : str;
        ColorSpace colorSpaceM5972getColorSpaceimpl = Color.m5972getColorSpaceimpl(function32.invoke(transition.getTargetState(), composer, Integer.valueOf((i >> 6) & 112)).m5978unboximpl());
        ComposerKt.sourceInformationMarkerStart(composer, -1791411589, "CC(remember):Transition.kt#9igjgp");
        boolean zChanged = composer.changed(colorSpaceM5972getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM5972getColorSpaceimpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = i << 3;
        int i4 = (i & 14) | (i3 & 896) | (i3 & 7168) | (i3 & 57344);
        ComposerKt.sourceInformationMarkerStart(composer, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
        if (transition.isSeeking()) {
            composer.startReplaceGroup(1666827533);
            composer.endReplaceGroup();
            currentState = transition.getCurrentState();
        } else {
            composer.startReplaceGroup(1666573488);
            ComposerKt.sourceInformation(composer, "1864@79141L67");
            ComposerKt.sourceInformationMarkerStart(composer, -1054612652, "CC(remember):Transition.kt#9igjgp");
            boolean z = (((i4 & 14) ^ 6) > 4 && composer.changed(transition)) || (i4 & 6) == 4;
            currentState = composer.rememberedValue();
            if (z || currentState == Composer.INSTANCE.getEmpty()) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    S currentState2 = transition.getCurrentState();
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    composer.updateRememberedValue(currentState2);
                    currentState = currentState2;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
        }
        int i5 = (i4 >> 9) & 112;
        Color colorInvoke = function32.invoke(currentState, composer, Integer.valueOf(i5));
        ComposerKt.sourceInformationMarkerStart(composer, -1054592958, "CC(remember):Transition.kt#9igjgp");
        int i6 = i4 & 14;
        int i7 = i6 ^ 6;
        boolean z2 = (i7 > 4 && composer.changed(transition)) || (i4 & 6) == 4;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<S>() { // from class: androidx.compose.animation.TransitionKt$animateColor$$inlined$animateValue$1
                @Override // kotlin.jvm.functions.Function0
                public final S invoke() {
                    return (S) transition.getTargetState();
                }
            });
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Color colorInvoke2 = function32.invoke((Object) ((State) objRememberedValue2).getValue(), composer, Integer.valueOf(i5));
        ComposerKt.sourceInformationMarkerStart(composer, -1054589890, "CC(remember):Transition.kt#9igjgp");
        boolean z3 = (i7 > 4 && composer.changed(transition)) || (i4 & 6) == 4;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<S>>() { // from class: androidx.compose.animation.TransitionKt$animateColor$$inlined$animateValue$2
                @Override // kotlin.jvm.functions.Function0
                public final Transition.Segment<S> invoke() {
                    return transition.getSegment();
                }
            });
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        State<Color> stateCreateTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(transition, colorInvoke, colorInvoke2, anonymousClass1.invoke((Object) ((State) objRememberedValue3).getValue(), composer, Integer.valueOf((i4 >> 3) & 112)), twoWayConverter, str2, composer, i6 | ((i4 << 6) & 458752));
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateCreateTransitionAnimation;
    }

    /* JADX INFO: renamed from: animateColor-DTcfvLk, reason: not valid java name */
    public static final State<Color> m180animateColorDTcfvLk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec<Color> infiniteRepeatableSpec, String str, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1901963533, "C(animateColor)N(initialValue:c#ui.graphics.Color,targetValue:c#ui.graphics.Color,animationSpec,label)98@4599L60,99@4671L72:Transition.kt#xbi5r1");
        if ((i2 & 8) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1901963533, i, -1, "androidx.compose.animation.animateColor (Transition.kt:97)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1869106039, "CC(remember):Transition.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m5972getColorSpaceimpl(j2));
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = i << 3;
        State<Color> stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransition, Color.m5958boximpl(j), Color.m5958boximpl(j2), (TwoWayConverter) objRememberedValue, infiniteRepeatableSpec, str2, composer, InfiniteTransition.$stable | (i & 14) | (i & 112) | (i & 896) | (InfiniteRepeatableSpec.$stable << 12) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateColor-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ State m181animateColorRIQooxk(InfiniteTransition infiniteTransition, long j, long j2, InfiniteRepeatableSpec infiniteRepeatableSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1400583834, "C(animateColor)N(initialValue:c#ui.graphics.Color,targetValue:c#ui.graphics.Color,animationSpec)112@5044L164:Transition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400583834, i, -1, "androidx.compose.animation.animateColor (Transition.kt:112)");
        }
        State<Color> stateM180animateColorDTcfvLk = m180animateColorDTcfvLk(infiniteTransition, j, j2, infiniteRepeatableSpec, "ColorAnimation", composer, InfiniteTransition.$stable | 24576 | (i & 14) | (i & 112) | (i & 896) | (InfiniteRepeatableSpec.$stable << 9) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateM180animateColorDTcfvLk;
    }
}
