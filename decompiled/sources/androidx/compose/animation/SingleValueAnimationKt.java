package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SingleValueAnimation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"animateColorAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "", "finishedListener", "Lkotlin/Function1;", "", "animateColorAsState-euL9pac", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColorAsState-KTwxG1Y", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "colorDefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector4D;", "initialValue", "Animatable-8_81llA", "(J)Landroidx/compose/animation/core/Animatable;", "animation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SingleValueAnimationKt {
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);

    /* JADX INFO: renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final State<Color> m162animateColorAsStateeuL9pac(long j, AnimationSpec<Color> animationSpec, String str, Function1<? super Color, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -451899108, "C(animateColorAsState)N(targetValue:c#ui.graphics.Color,animationSpec,label,finishedListener)63@2906L84,64@3002L157:SingleValueAnimation.kt#xbi5r1");
        SpringSpec<Color> springSpec = (i2 & 2) != 0 ? colorDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "ColorAnimation" : str;
        Function1<? super Color, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451899108, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:61)");
        }
        ColorSpace colorSpaceM5972getColorSpaceimpl = Color.m5972getColorSpaceimpl(j);
        ComposerKt.sourceInformationMarkerStart(composer, -483338000, "CC(remember):SingleValueAnimation.kt#9igjgp");
        boolean zChanged = composer.changed(colorSpaceM5972getColorSpaceimpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m5972getColorSpaceimpl(j));
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i3 = i << 6;
        State<Color> stateAnimateValueAsState = AnimateAsStateKt.animateValueAsState(Color.m5958boximpl(j), (TwoWayConverter) objRememberedValue, springSpec, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateColorAsState-KTwxG1Y, reason: not valid java name */
    public static final /* synthetic */ State m161animateColorAsStateKTwxG1Y(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1942442407, "C(animateColorAsState)N(targetValue:c#ui.graphics.Color,animationSpec,finishedListener)83@3489L84:SingleValueAnimation.kt#xbi5r1");
        if ((i2 & 2) != 0) {
            animationSpec = colorDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1942442407, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:82)");
        }
        State<Color> stateM162animateColorAsStateeuL9pac = m162animateColorAsStateeuL9pac(j, animationSpec2, null, function12, composer, (i & 126) | ((i << 3) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateM162animateColorAsStateeuL9pac;
    }

    /* JADX INFO: renamed from: Animatable-8_81llA, reason: not valid java name */
    public static final Animatable<Color, AnimationVector4D> m160Animatable8_81llA(long j) {
        return new Animatable<>(Color.m5958boximpl(j), ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(Color.m5972getColorSpaceimpl(j)), null, null, 12, null);
    }
}
