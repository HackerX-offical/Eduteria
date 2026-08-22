package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: AnimateAsState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001aW\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000f\u001aO\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0006\u001a\u00020\u00112\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001aO\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0006\u001a\u00020\u00162\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001aO\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0006\u001a\u00020\u001b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b\u001c\u0010\u0018\u001aM\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010\u0006\u001a\u00020\u001f2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010 \u001aM\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00052\u0006\u0010\u0006\u001a\u00020#2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020#0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010$\u001aO\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00052\u0006\u0010\u0006\u001a\u00020'2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020'0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b(\u0010\u0018\u001aO\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00052\u0006\u0010\u0006\u001a\u00020+2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020+0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b,\u0010\u0018\u001a}\u0010.\u001a\b\u0012\u0004\u0012\u0002H/0\u0005\"\u0004\b\u0000\u0010/\"\b\b\u0001\u00100*\u0002012\u0006\u0010\u0006\u001a\u0002H/2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H0032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H/0\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H/2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u00104\u001aM\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00022\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u00105\u001aE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0006\u001a\u00020\u00112\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b6\u00107\u001aE\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0006\u001a\u00020\u00162\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00160\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b8\u00109\u001aE\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0006\u001a\u00020\u001b2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b:\u00109\u001aC\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010\u0006\u001a\u00020\u001f2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010;\u001aC\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00052\u0006\u0010\u0006\u001a\u00020#2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020#0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010<\u001aE\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00052\u0006\u0010\u0006\u001a\u00020'2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020'0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b=\u00109\u001aE\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00052\u0006\u0010\u0006\u001a\u00020+2\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020+0\b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0004\b>\u00109\u001as\u0010.\u001a\b\u0012\u0004\u0012\u0002H/0\u0005\"\u0004\b\u0000\u0010/\"\b\b\u0001\u00100*\u0002012\u0006\u0010\u0006\u001a\u0002H/2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u0002H0032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H/0\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H/2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0007¢\u0006\u0002\u0010?\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@²\u0006\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\"\u0004\b\u0000\u0010/X\u008a\u0084\u0002²\u0006\u0016\u0010B\u001a\b\u0012\u0004\u0012\u0002H/0\b\"\u0004\b\u0000\u0010/X\u008a\u0084\u0002"}, d2 = {"defaultAnimation", "Landroidx/compose/animation/core/SpringSpec;", "", "DefaultFloatVisibilityThreshold", "animateFloatAsState", "Landroidx/compose/runtime/State;", "targetValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "visibilityThreshold", "label", "", "finishedListener", "Lkotlin/Function1;", "", "(FLandroidx/compose/animation/core/AnimationSpec;FLjava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState", "Landroidx/compose/ui/unit/Dp;", "animateDpAsState-AjpBEmI", "(FLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "dpDefaultSpring", "animateSizeAsState", "Landroidx/compose/ui/geometry/Size;", "animateSizeAsState-YLp_XPw", "(JLandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "sizeDefaultSpring", "animateOffsetAsState", "Landroidx/compose/ui/geometry/Offset;", "animateOffsetAsState-7362WCg", "offsetDefaultSpring", "animateRectAsState", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "rectDefaultSpring", "animateIntAsState", "", "(ILandroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "intDefaultSpring", "animateIntOffsetAsState", "Landroidx/compose/ui/unit/IntOffset;", "animateIntOffsetAsState-HyPO7BM", "intOffsetDefaultSpring", "animateIntSizeAsState", "Landroidx/compose/ui/unit/IntSize;", "animateIntSizeAsState-4goxYXU", "intSizeDefaultSpring", "animateValueAsState", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(FLandroidx/compose/animation/core/AnimationSpec;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateDpAsState-Kz89ssw", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateSizeAsState-LjSzlW0", "(JLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateOffsetAsState-N6fFfp4", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "(ILandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateIntOffsetAsState-8f6pmRE", "animateIntSizeAsState-zTRF_AQ", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation-core", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "animSpec"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AnimateAsStateKt {
    private static final float DefaultFloatVisibilityThreshold = 0.01f;
    private static final SpringSpec<Float> defaultAnimation = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    private static final SpringSpec<Dp> dpDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m8828boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
    private static final SpringSpec<Size> sizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m5780boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
    private static final SpringSpec<Offset> offsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m5712boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
    private static final SpringSpec<Rect> rectDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
    private static final SpringSpec<Integer> intDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 3, null);
    private static final SpringSpec<IntOffset> intOffsetDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m8949boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.INSTANCE)), 3, null);
    private static final SpringSpec<IntSize> intSizeDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m8993boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.INSTANCE)), 3, null);

    public static final State<Float> animateFloatAsState(float f2, AnimationSpec<Float> animationSpec, float f3, String str, Function1<? super Float, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 668842840, "C(animateFloatAsState)N(targetValue,animationSpec,visibilityThreshold,label,finishedListener)81@3778L504:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.01f;
        }
        if ((i2 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        Function1<? super Float, Unit> function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(668842840, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:74)");
        }
        if (animationSpec == defaultAnimation) {
            composer.startReplaceGroup(1144115775);
            ComposerKt.sourceInformation(composer, "77@3630L83");
            ComposerKt.sourceInformationMarkerStart(composer, -1487113269, "CC(remember):AnimateAsState.kt#9igjgp");
            boolean z = (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(f3)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
            Object objRememberedValue = composer.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, Float.valueOf(f3), 3, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endReplaceGroup();
            animationSpec = (SpringSpec) objRememberedValue;
        } else {
            composer.startReplaceGroup(1144225701);
            composer.endReplaceGroup();
        }
        int i3 = i << 3;
        State<Float> stateAnimateValueAsState = animateValueAsState(Float.valueOf(f2), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), animationSpec, f3 != 0.01f ? Float.valueOf(f3) : null, str2, function12, composer, (i & 14) | (57344 & i3) | (i3 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State<Dp> m189animateDpAsStateAjpBEmI(float f2, AnimationSpec<Dp> animationSpec, String str, Function1<? super Dp, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1407150062, "C(animateDpAsState)N(targetValue:c#ui.unit.Dp,animationSpec,label,finishedListener)124@5810L166:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec<Dp> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Dp, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1407150062, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:123)");
        }
        int i3 = i << 6;
        State<Dp> stateAnimateValueAsState = animateValueAsState(Dp.m8828boximpl(f2), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateSizeAsState-YLp_XPw, reason: not valid java name */
    public static final State<Size> m198animateSizeAsStateYLp_XPw(long j, AnimationSpec<Size> animationSpec, String str, Function1<? super Size, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1374633148, "C(animateSizeAsState)N(targetValue:c#ui.geometry.Size,animationSpec,label,finishedListener)165@7649L168:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec<Size> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        Function1<? super Size, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1374633148, i, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:164)");
        }
        int i3 = i << 6;
        State<Size> stateAnimateValueAsState = animateValueAsState(Size.m5780boximpl(j), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateOffsetAsState-7362WCg, reason: not valid java name */
    public static final State<Offset> m195animateOffsetAsState7362WCg(long j, AnimationSpec<Offset> animationSpec, String str, Function1<? super Offset, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 357896800, "C(animateOffsetAsState)N(targetValue:c#ui.geometry.Offset,animationSpec,label,finishedListener)204@9471L170:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec<Offset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        Function1<? super Offset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(357896800, i, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:203)");
        }
        int i3 = i << 6;
        State<Offset> stateAnimateValueAsState = animateValueAsState(Offset.m5712boximpl(j), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    public static final State<Rect> animateRectAsState(Rect rect, AnimationSpec<Rect> animationSpec, String str, Function1<? super Rect, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 536062978, "C(animateRectAsState)N(targetValue,animationSpec,label,finishedListener)245@11325L168:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec<Rect> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Rect, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(536062978, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:244)");
        }
        int i3 = i << 6;
        State<Rect> stateAnimateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    public static final State<Integer> animateIntAsState(int i, AnimationSpec<Integer> animationSpec, String str, Function1<? super Integer, Unit> function1, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 428074472, "C(animateIntAsState)N(targetValue,animationSpec,label,finishedListener)283@13047L167:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec<Integer> animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            function1 = null;
        }
        Function1<? super Integer, Unit> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(428074472, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:282)");
        }
        int i4 = i2 << 6;
        State<Integer> stateAnimateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, str2, function12, composer, (i2 & 14) | ((i2 << 3) & 896) | (57344 & i4) | (i4 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateIntOffsetAsState-HyPO7BM, reason: not valid java name */
    public static final State<IntOffset> m192animateIntOffsetAsStateHyPO7BM(long j, AnimationSpec<IntOffset> animationSpec, String str, Function1<? super IntOffset, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -696782904, "C(animateIntOffsetAsState)N(targetValue:c#ui.unit.IntOffset,animationSpec,label,finishedListener)322@14897L173:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec<IntOffset> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        Function1<? super IntOffset, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-696782904, i, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:321)");
        }
        int i3 = i << 6;
        State<IntOffset> stateAnimateValueAsState = animateValueAsState(IntOffset.m8949boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: renamed from: animateIntSizeAsState-4goxYXU, reason: not valid java name */
    public static final State<IntSize> m193animateIntSizeAsState4goxYXU(long j, AnimationSpec<IntSize> animationSpec, String str, Function1<? super IntSize, Unit> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 582576328, "C(animateIntSizeAsState)N(targetValue:c#ui.unit.IntSize,animationSpec,label,finishedListener)360@16674L171:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec<IntSize> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        Function1<? super IntSize, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(582576328, i, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:359)");
        }
        int i3 = i << 6;
        State<IntSize> stateAnimateValueAsState = animateValueAsState(IntSize.m8993boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, str2, function12, composer, (i & 14) | ((i << 3) & 896) | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    public static final <T, V extends AnimationVector> State<T> animateValueAsState(final T t, TwoWayConverter<T, V> twoWayConverter, AnimationSpec<T> animationSpec, T t2, String str, Function1<? super T, Unit> function1, Composer composer, int i, int i2) {
        SpringSpec springSpecSpring;
        Channel channel;
        ComposerKt.sourceInformationMarkerStart(composer, -1994373980, "C(animateValueAsState)N(targetValue,typeConverter,animationSpec,visibilityThreshold,label,finishedListener)403@18778L21,409@18961L44,410@19027L79,411@19127L38,413@19212L428,426@19659L42,427@19717L32,427@19706L43,428@19778L697,428@19754L721:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1037975943, "CC(remember):AnimateAsState.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            springSpecSpring = (SpringSpec) objRememberedValue;
        } else {
            springSpecSpring = animationSpec;
        }
        T t3 = (i2 & 8) != 0 ? null : t2;
        String str2 = (i2 & 16) != 0 ? "ValueAnimation" : str;
        Function1<? super T, Unit> function12 = (i2 & 32) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994373980, i, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:407)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1037970064, "CC(remember):AnimateAsState.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1037967917, "CC(remember):AnimateAsState.kt#9igjgp");
        Object objRememberedValue3 = composer.rememberedValue();
        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Animatable(t, twoWayConverter, t3, str2);
            composer.updateRememberedValue(objRememberedValue3);
        }
        Animatable animatable = (Animatable) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function12, composer, (i >> 15) & 14);
        if (t3 != null && (springSpecSpring instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) springSpecSpring;
            if (!Intrinsics.areEqual(springSpec.getVisibilityThreshold(), t3)) {
                springSpecSpring = AnimationSpecKt.spring(springSpec.getDampingRatio(), springSpec.getStiffness(), t3);
            }
        }
        State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(springSpecSpring, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1037947730, "CC(remember):AnimateAsState.kt#9igjgp");
        Object objRememberedValue4 = composer.rememberedValue();
        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(objRememberedValue4);
        }
        final Channel channel2 = (Channel) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1037945884, "CC(remember):AnimateAsState.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(channel2);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function0() { // from class: androidx.compose.animation.core.AnimateAsStateKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnimateAsStateKt.animateValueAsState$lambda$7$0(channel2, t);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) objRememberedValue5, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, -1037943267, "CC(remember):AnimateAsState.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(channel2) | composer.changedInstance(animatable) | composer.changed(stateRememberUpdatedState2) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            channel = channel2;
            objRememberedValue6 = (Function2) new AnimateAsStateKt$animateValueAsState$3$1(channel, animatable, stateRememberUpdatedState2, stateRememberUpdatedState, null);
            composer.updateRememberedValue(objRememberedValue6);
        } else {
            channel = channel2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(channel, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composer, 0);
        State<T> stateAsState = (State) mutableState.getValue();
        if (stateAsState == null) {
            stateAsState = animatable.asState();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit animateValueAsState$lambda$7$0(Channel channel, Object obj) {
        channel.mo13895trySendJP2dKIU(obj);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateFloatAsState(float f2, AnimationSpec animationSpec, float f3, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1091643291, "C(animateFloatAsState)N(targetValue,animationSpec,visibilityThreshold,finishedListener)458@20893L144:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = defaultAnimation;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            f3 = 0.01f;
        }
        float f4 = f3;
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1091643291, i, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:458)");
        }
        State<Float> stateAnimateFloatAsState = animateFloatAsState(f2, animationSpec2, f4, null, function12, composer, (i & 1022) | ((i << 3) & 57344), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateFloatAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateDpAsState-Kz89ssw, reason: not valid java name */
    public static final /* synthetic */ State m190animateDpAsStateKz89ssw(float f2, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 704104481, "C(animateDpAsState)N(targetValue:c#ui.unit.Dp,animationSpec,finishedListener)475@21347L143:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = dpDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(704104481, i, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:474)");
        }
        State stateAnimateValueAsState = animateValueAsState(Dp.m8828boximpl(f2), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateSizeAsState-LjSzlW0, reason: not valid java name */
    public static final /* synthetic */ State m197animateSizeAsStateLjSzlW0(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 875212471, "C(animateSizeAsState)N(targetValue:c#ui.geometry.Size,animationSpec,finishedListener)493@21814L145:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = sizeDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875212471, i, -1, "androidx.compose.animation.core.animateSizeAsState (AnimateAsState.kt:492)");
        }
        State stateAnimateValueAsState = animateValueAsState(Size.m5780boximpl(j), VectorConvertersKt.getVectorConverter(Size.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateOffsetAsState-N6fFfp4, reason: not valid java name */
    public static final /* synthetic */ State m196animateOffsetAsStateN6fFfp4(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -456513133, "C(animateOffsetAsState)N(targetValue:c#ui.geometry.Offset,animationSpec,finishedListener)511@22295L147:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = offsetDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-456513133, i, -1, "androidx.compose.animation.core.animateOffsetAsState (AnimateAsState.kt:510)");
        }
        State stateAnimateValueAsState = animateValueAsState(Offset.m5712boximpl(j), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateRectAsState(Rect rect, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -782613967, "C(animateRectAsState)N(targetValue,animationSpec,finishedListener)529@22766L145:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = rectDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782613967, i, -1, "androidx.compose.animation.core.animateRectAsState (AnimateAsState.kt:528)");
        }
        State stateAnimateValueAsState = animateValueAsState(rect, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateIntAsState(int i, AnimationSpec animationSpec, Function1 function1, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -842612981, "C(animateIntAsState)N(targetValue,animationSpec,finishedListener)547@23229L144:AnimateAsState.kt#pdpnli");
        if ((i3 & 2) != 0) {
            animationSpec = intDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-842612981, i2, -1, "androidx.compose.animation.core.animateIntAsState (AnimateAsState.kt:546)");
        }
        State stateAnimateValueAsState = animateValueAsState(Integer.valueOf(i), VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), animationSpec2, null, null, function12, composer, (i2 & 14) | ((i2 << 3) & 896) | ((i2 << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntOffsetAsState-8f6pmRE, reason: not valid java name */
    public static final /* synthetic */ State m191animateIntOffsetAsState8f6pmRE(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1010307371, "C(animateIntOffsetAsState)N(targetValue:c#ui.unit.IntOffset,animationSpec,finishedListener)565@23727L150:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intOffsetDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1010307371, i, -1, "androidx.compose.animation.core.animateIntOffsetAsState (AnimateAsState.kt:564)");
        }
        State stateAnimateValueAsState = animateValueAsState(IntOffset.m8949boximpl(j), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    /* JADX INFO: renamed from: animateIntSizeAsState-zTRF_AQ, reason: not valid java name */
    public static final /* synthetic */ State m194animateIntSizeAsStatezTRF_AQ(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1749239765, "C(animateIntSizeAsState)N(targetValue:c#ui.unit.IntSize,animationSpec,finishedListener)583@24219L148:AnimateAsState.kt#pdpnli");
        if ((i2 & 2) != 0) {
            animationSpec = intSizeDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1749239765, i, -1, "androidx.compose.animation.core.animateIntSizeAsState (AnimateAsState.kt:582)");
        }
        State stateAnimateValueAsState = animateValueAsState(IntSize.m8993boximpl(j), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), animationSpec2, null, null, function12, composer, (i & 14) | ((i << 3) & 896) | ((i << 9) & 458752), 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    public static final /* synthetic */ State animateValueAsState(Object obj, TwoWayConverter twoWayConverter, AnimationSpec animationSpec, Object obj2, Function1 function1, Composer composer, int i, int i2) {
        SpringSpec springSpec;
        ComposerKt.sourceInformationMarkerStart(composer, -846382129, "C(animateValueAsState)N(targetValue,typeConverter,animationSpec,visibilityThreshold,finishedListener)599@24658L21,603@24780L269:AnimateAsState.kt#pdpnli");
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1624402204, "CC(remember):AnimateAsState.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            springSpec = (SpringSpec) objRememberedValue;
        } else {
            springSpec = animationSpec;
        }
        Object obj3 = (i2 & 8) != 0 ? null : obj2;
        Function1 function12 = (i2 & 16) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-846382129, i, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:603)");
        }
        int i3 = i & 8;
        State stateAnimateValueAsState = animateValueAsState(obj, twoWayConverter, springSpec, obj3, "ValueAnimation", function12, composer, (i3 << 9) | i3 | 24576 | (i & 14) | (i & 112) | (i & 896) | (i & 7168) | ((i << 3) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return stateAnimateValueAsState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> animateValueAsState$lambda$3(State<? extends Function1<? super T, Unit>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> AnimationSpec<T> animateValueAsState$lambda$5(State<? extends AnimationSpec<T>> state) {
        return state.getValue();
    }
}
