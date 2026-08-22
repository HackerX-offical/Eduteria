package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.window.core.layout.WindowSizeClass;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u001aE\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001aj\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aA\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\u001a\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a;\u0010\u001f\u001a\u00020\u0001*\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b#\u0010$\u001aO\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010'\u001aY\u0010%\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b(\u0010)\u001aA\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010+\u001aK\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0004\b,\u0010-\u001aI\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b&\u0010.\u001a5\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b/\u00100\u001a-\u0010%\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0004\b1\u00102\u001a3\u00103\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109\u001a#\u0010:\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b;\u0010<\u001a3\u0010=\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b>\u00109\u001a;\u0010?\u001a\u00020\u0001*\u00020\u00122\u0006\u00104\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u000207H\u0002¢\u0006\u0004\b@\u0010A\"\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E\"\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010E\"\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010E\"\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bK\u0010E\"\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010E\"\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010E\"\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040C8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010E\"\u0016\u0010R\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0016\u0010V\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bW\u0010T\"\u0016\u0010X\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bY\u0010T\"\u0016\u0010Z\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\b[\u0010T\"\u000e\u0010\\\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010_\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010b\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010d\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u0014\u0010j\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010i\"\u000e\u0010l\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010o\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010p\u001a\u00020]X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010q\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"LinearProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "gapSize", "Landroidx/compose/ui/unit/Dp;", "drawStopIndicator", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "LinearProgressIndicator-GJbTh5U", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJIFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-rIrjwxo", "(Landroidx/compose/ui/Modifier;JJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawLinearIndicator", "startFraction", "endFraction", "strokeWidth", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "CircularProgressIndicator", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-IyT6zlY", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-4lLiAd8", "(Landroidx/compose/ui/Modifier;JFJIFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "circularIndeterminateGlobalRotationAnimationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "getCircularIndeterminateGlobalRotationAnimationSpec", "()Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "circularIndeterminateRotationAnimationSpec", "getCircularIndeterminateRotationAnimationSpec", "circularIndeterminateProgressAnimationSpec", "getCircularIndeterminateProgressAnimationSpec", "linearIndeterminateFirstLineHeadAnimationSpec", "getLinearIndeterminateFirstLineHeadAnimationSpec", "linearIndeterminateFirstLineTailAnimationSpec", "getLinearIndeterminateFirstLineTailAnimationSpec", "linearIndeterminateSecondLineHeadAnimationSpec", "getLinearIndeterminateSecondLineHeadAnimationSpec", "linearIndeterminateSecondLineTailAnimationSpec", "getLinearIndeterminateSecondLineTailAnimationSpec", "LinearIndicatorWidth", "getLinearIndicatorWidth", "()F", "F", "LinearIndicatorHeight", "getLinearIndicatorHeight", "StopIndicatorTrailingSpace", "getStopIndicatorTrailingSpace", "CircularIndicatorDiameter", "getCircularIndicatorDiameter", "LinearAnimationDuration", "", "FirstLineHeadDuration", "FirstLineTailDuration", "SecondLineHeadDuration", "SecondLineTailDuration", "FirstLineHeadDelay", "FirstLineTailDelay", "SecondLineHeadDelay", "SecondLineTailDelay", "LinearIndeterminateProgressEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getLinearIndeterminateProgressEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "CircularProgressEasing", "getCircularProgressEasing", "CircularIndeterminateMinProgress", "CircularIndeterminateMaxProgress", "CircularAnimationProgressDuration", "CircularAnimationAdditionalRotationDelay", "CircularAnimationAdditionalRotationDuration", "CircularAdditionalRotationDegreesTarget", "CircularGlobalRotationDegreesTarget", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorKt {
    public static final float CircularAdditionalRotationDegreesTarget = 360.0f;
    public static final int CircularAnimationAdditionalRotationDelay = 1500;
    public static final int CircularAnimationAdditionalRotationDuration = 300;
    public static final int CircularAnimationProgressDuration = 6000;
    public static final float CircularGlobalRotationDegreesTarget = 1080.0f;
    public static final float CircularIndeterminateMaxProgress = 0.87f;
    public static final float CircularIndeterminateMinProgress = 0.1f;
    public static final int FirstLineHeadDelay = 0;
    public static final int FirstLineHeadDuration = 1000;
    public static final int FirstLineTailDelay = 250;
    public static final int FirstLineTailDuration = 1000;
    public static final int LinearAnimationDuration = 1750;
    public static final int SecondLineHeadDelay = 650;
    public static final int SecondLineHeadDuration = 850;
    public static final int SecondLineTailDelay = 900;
    public static final int SecondLineTailDuration = 850;
    private static final float LinearIndicatorWidth = Dp.m8830constructorimpl(240);
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m4560getHeightD9Ej5fM();
    private static final float StopIndicatorTrailingSpace = Dp.m8830constructorimpl(6);
    private static final float CircularIndicatorDiameter = CircularProgressIndicatorTokens.INSTANCE.m4269getSizeD9Ej5fM();
    private static final CubicBezierEasing LinearIndeterminateProgressEasing = MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier();
    private static final CubicBezierEasing CircularProgressEasing = MotionTokens.INSTANCE.getEasingStandardCubicBezier();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_4lLiAd8$lambda$35(Modifier modifier, long j, float f2, long j2, int i, float f3, int i2, int i3, Composer composer, int i4) {
        m3278CircularProgressIndicator4lLiAd8(modifier, j, f2, j2, i, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_DUhRLBM$lambda$20(Function0 function0, Modifier modifier, long j, float f2, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3280CircularProgressIndicatorDUhRLBM(function0, modifier, j, f2, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_DUhRLBM$lambda$37$lambda$36(float f2) {
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_DUhRLBM$lambda$38(float f2, Modifier modifier, long j, float f3, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3279CircularProgressIndicatorDUhRLBM(f2, modifier, j, f3, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_IyT6zlY$lambda$29(Function0 function0, Modifier modifier, long j, float f2, long j2, int i, float f3, int i2, int i3, Composer composer, int i4) {
        m3281CircularProgressIndicatorIyT6zlY(function0, modifier, j, f2, j2, i, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_LxG7B9w$lambda$30(Modifier modifier, long j, float f2, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3282CircularProgressIndicatorLxG7B9w(modifier, j, f2, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_MBs18nI$lambda$39(float f2, Modifier modifier, long j, float f3, int i, int i2, Composer composer, int i3) {
        m3283CircularProgressIndicatorMBs18nI(f2, modifier, j, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_aM_cp0Q$lambda$40(Modifier modifier, long j, float f2, int i, int i2, Composer composer, int i3) {
        m3284CircularProgressIndicatoraMcp0Q(modifier, j, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_2cYBFYY$lambda$11(Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3285LinearProgressIndicator2cYBFYY(modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_GJbTh5U$lambda$10(Function0 function0, Modifier modifier, long j, long j2, int i, float f2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m3286LinearProgressIndicatorGJbTh5U(function0, modifier, j, j2, i, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_RIQooxk$lambda$19(Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3287LinearProgressIndicatorRIQooxk(modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator__5eSR_E$lambda$0(Function0 function0, Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3289LinearProgressIndicator_5eSRE(function0, modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator__5eSR_E$lambda$16$lambda$15(float f2) {
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator__5eSR_E$lambda$17(float f2, Modifier modifier, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m3288LinearProgressIndicator_5eSRE(f2, modifier, j, j2, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_eaDK9VM$lambda$18(float f2, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m3290LinearProgressIndicatoreaDK9VM(f2, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_rIrjwxo$lambda$14(Modifier modifier, long j, long j2, int i, float f2, int i2, int i3, Composer composer, int i4) {
        m3291LinearProgressIndicatorrIrjwxo(modifier, j, j2, i, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize` and `drawStopIndicator`, see `LegacyLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(progress, modifier, color, trackColor, strokeCap, gapSize, drawStopIndicator)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3289LinearProgressIndicator_5eSRE(final kotlin.jvm.functions.Function0 r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3289LinearProgressIndicator_5eSRE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_GJbTh5U$lambda$2$lambda$1(long j, int i, DrawScope drawScope) {
        ProgressIndicatorDefaults.INSTANCE.m3261drawStopIndicatorEgI2THU(drawScope, ProgressIndicatorDefaults.INSTANCE.m3268getLinearTrackStopIndicatorSizeD9Ej5fM(), j, i);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
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
    /* JADX INFO: renamed from: LinearProgressIndicator-GJbTh5U, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3286LinearProgressIndicatorGJbTh5U(final kotlin.jvm.functions.Function0<java.lang.Float> r30, androidx.compose.ui.Modifier r31, long r32, long r34, int r36, float r37, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3286LinearProgressIndicatorGJbTh5U(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, long, int, float, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearProgressIndicator_GJbTh5U$lambda$4$lambda$3(Function0 function0) {
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_GJbTh5U$lambda$7$lambda$6(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f2 = (Float) objInvoke;
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f2 != null ? f2.floatValue() : 0.0f, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_GJbTh5U$lambda$9$lambda$8(int i, float f2, Function0 function0, long j, long j2, Function1 function1, DrawScope drawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
        if (!StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) && Float.intBitsToFloat((int) (4294967295L & drawScope.mo6549getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32))) {
            f2 = Dp.m8830constructorimpl(f2 + drawScope.mo484toDpu2uoSUM(fIntBitsToFloat));
        }
        float f3 = f2 / drawScope.mo484toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)));
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        float fMin = fFloatValue + Math.min(fFloatValue, f3);
        if (fMin <= 1.0f) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, fMin, 1.0f, j, fIntBitsToFloat, i);
        }
        m3296drawLinearIndicatorqYKTg0g(drawScope, 0.0f, fFloatValue, j2, fIntBitsToFloat, i);
        function1.invoke(drawScope);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyIndeterminateLinearProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3285LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier r18, long r19, long r21, int r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3285LinearProgressIndicator2cYBFYY(androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f2  */
    /* JADX INFO: renamed from: LinearProgressIndicator-rIrjwxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3291LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier r29, long r30, long r32, int r34, float r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3291LinearProgressIndicatorrIrjwxo(androidx.compose.ui.Modifier, long, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearProgressIndicator_rIrjwxo$lambda$13$lambda$12(int i, float f2, State state, long j, State state2, long j2, State state3, State state4, DrawScope drawScope) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
        if (!StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) && Float.intBitsToFloat((int) (4294967295L & drawScope.mo6549getSizeNHjbRc())) <= Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32))) {
            f2 = Dp.m8830constructorimpl(f2 + drawScope.mo484toDpu2uoSUM(fIntBitsToFloat));
        }
        float f3 = f2 / drawScope.mo484toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)));
        if (((Number) state.getValue()).floatValue() < 1.0f - f3) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue() > 0.0f ? ((Number) state.getValue()).floatValue() + f3 : 0.0f, 1.0f, j, fIntBitsToFloat, i);
        }
        if (((Number) state.getValue()).floatValue() - ((Number) state2.getValue()).floatValue() > 0.0f) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, ((Number) state.getValue()).floatValue(), ((Number) state2.getValue()).floatValue(), j2, fIntBitsToFloat, i);
        }
        if (((Number) state2.getValue()).floatValue() > f3) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue() > 0.0f ? ((Number) state3.getValue()).floatValue() + f3 : 0.0f, ((Number) state2.getValue()).floatValue() < 1.0f ? ((Number) state2.getValue()).floatValue() - f3 : 1.0f, j, fIntBitsToFloat, i);
        }
        if (((Number) state3.getValue()).floatValue() - ((Number) state4.getValue()).floatValue() > 0.0f) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, ((Number) state3.getValue()).floatValue(), ((Number) state4.getValue()).floatValue(), j2, fIntBitsToFloat, i);
        }
        if (((Number) state4.getValue()).floatValue() > f3) {
            m3296drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) state4.getValue()).floatValue() < 1.0f ? ((Number) state4.getValue()).floatValue() - f3 : 1.0f, j, fIntBitsToFloat, i);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3288LinearProgressIndicator_5eSRE(final float r21, androidx.compose.ui.Modifier r22, long r23, long r25, int r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3288LinearProgressIndicator_5eSRE(float, androidx.compose.ui.Modifier, long, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3290LinearProgressIndicatoreaDK9VM(final float r18, androidx.compose.ui.Modifier r19, long r20, long r22, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3290LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m3287LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long linearColor;
        long linearTrackColor;
        final Modifier modifier3;
        final long j3;
        final long j4;
        long j5;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color)391@16079L146:ProgressIndicator.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                linearColor = j;
                int i5 = composerStartRestartGroup.changed(linearColor) ? 32 : 16;
                i3 |= i5;
            } else {
                linearColor = j;
            }
            i3 |= i5;
        } else {
            linearColor = j;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                linearTrackColor = j2;
                int i6 = composerStartRestartGroup.changed(linearTrackColor) ? 256 : 128;
                i3 |= i6;
            } else {
                linearTrackColor = j2;
            }
            i3 |= i6;
        } else {
            linearTrackColor = j2;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "388@15990L11,389@16053L16");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                j5 = linearTrackColor;
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    linearColor = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                j5 = linearTrackColor;
                modifier4 = companion;
            }
            long j6 = linearColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:391)");
            }
            m3291LinearProgressIndicatorrIrjwxo(modifier4, j6, j5, ProgressIndicatorDefaults.INSTANCE.m3267getLinearStrokeCapKaPHkGw(), 0.0f, composerStartRestartGroup, (i3 & 14) | 3072 | (i3 & 112) | (i3 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j6;
            j4 = j5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = linearColor;
            j4 = linearTrackColor;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressIndicatorKt.LinearProgressIndicator_RIQooxk$lambda$19(modifier3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    private static final void m3296drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f2, float f3, long j, float f4, int i) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L));
        float f5 = 2;
        float f6 = fIntBitsToFloat2 / f5;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f7 = (z ? f2 : 1.0f - f3) * fIntBitsToFloat;
        float f8 = (z ? f3 : 1.0f - f2) * fIntBitsToFloat;
        if (StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) || fIntBitsToFloat2 > fIntBitsToFloat) {
            DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f8)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), f4, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f9 = f4 / f5;
        float f10 = fIntBitsToFloat - f9;
        if (f7 < f9) {
            f7 = f9;
        }
        if (f7 > f10) {
            f7 = f10;
        }
        if (f8 < f9) {
            f8 = f9;
        }
        if (f8 <= f10) {
            f10 = f8;
        }
        if (Math.abs(f3 - f2) > 0.0f) {
            DrawScope.m6535drawLineNGM6Ib0$default(drawScope, j, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f10)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L)), f4, i, null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`, see `LegacyCircularProgressIndicatorSample` on how to restore the previous behavior", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(progress, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3280CircularProgressIndicatorDUhRLBM(final kotlin.jvm.functions.Function0 r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3280CircularProgressIndicatorDUhRLBM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
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
    /* JADX INFO: renamed from: CircularProgressIndicator-IyT6zlY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3281CircularProgressIndicatorIyT6zlY(final kotlin.jvm.functions.Function0<java.lang.Float> r32, androidx.compose.ui.Modifier r33, long r34, float r36, long r37, int r39, float r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3281CircularProgressIndicatorIyT6zlY(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, float, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_IyT6zlY$lambda$22$lambda$21(Function0 function0) {
        float fFloatValue = ((Number) function0.invoke()).floatValue();
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            return 1.0f;
        }
        return fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_IyT6zlY$lambda$26$lambda$25(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f2 = (Float) objInvoke;
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(f2 != null ? f2.floatValue() : 0.0f, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_IyT6zlY$lambda$28$lambda$27(Function0 function0, int i, float f2, float f3, long j, Stroke stroke, long j2, DrawScope drawScope) {
        float fFloatValue = ((Number) function0.invoke()).floatValue() * 360.0f;
        if (!StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) && Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32))) {
            f2 = Dp.m8830constructorimpl(f2 + f3);
        }
        float f4 = (f2 / ((float) (((double) drawScope.mo484toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        m3292drawCircularIndicator42QJj7c(drawScope, 270.0f + fFloatValue + Math.min(fFloatValue, f4), (360.0f - fFloatValue) - (Math.min(fFloatValue, f4) * 2), j, stroke);
        m3294drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, fFloatValue, j2, stroke);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use the overload that takes `gapSize`", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(modifier, color, strokeWidth, trackColor, strokeCap, gapSize)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3282CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier r20, long r21, float r23, long r24, int r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3282CircularProgressIndicatorLxG7B9w(androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /* JADX INFO: renamed from: CircularProgressIndicator-4lLiAd8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3278CircularProgressIndicator4lLiAd8(androidx.compose.ui.Modifier r32, long r33, float r35, long r36, int r38, float r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3278CircularProgressIndicator4lLiAd8(androidx.compose.ui.Modifier, long, float, long, int, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularProgressIndicator_4lLiAd8$lambda$34$lambda$33(State state, int i, float f2, float f3, State state2, State state3, long j, Stroke stroke, long j2, DrawScope drawScope) {
        float fFloatValue = ((Number) state.getValue()).floatValue() * 360.0f;
        if (!StrokeCap.m6340equalsimpl0(i, StrokeCap.INSTANCE.m6344getButtKaPHkGw()) && Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() & 4294967295L)) <= Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32))) {
            f2 = Dp.m8830constructorimpl(f2 + f3);
        }
        float f4 = (f2 / ((float) (((double) drawScope.mo484toDpu2uoSUM(Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)))) * 3.141592653589793d))) * 360.0f;
        float fFloatValue2 = ((Number) state2.getValue()).floatValue() + ((Number) state3.getValue()).floatValue();
        long jMo6548getCenterF1C5BW0 = drawScope.mo6548getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6476rotateUv8p0NA(fFloatValue2, jMo6548getCenterF1C5BW0);
            m3292drawCircularIndicator42QJj7c(drawScope, fFloatValue + Math.min(fFloatValue, f4), (360.0f - fFloatValue) - (Math.min(fFloatValue, f4) * 2), j, stroke);
            m3294drawDeterminateCircularIndicator42QJj7c(drawScope, 0.0f, fFloatValue, j2, stroke);
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cf  */
    @kotlin.Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @kotlin.ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* JADX INFO: renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3279CircularProgressIndicatorDUhRLBM(final float r22, androidx.compose.ui.Modifier r23, long r24, float r26, long r27, int r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3279CircularProgressIndicatorDUhRLBM(float, androidx.compose.ui.Modifier, long, float, long, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3283CircularProgressIndicatorMBs18nI(final float r20, androidx.compose.ui.Modifier r21, long r22, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3283CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m3284CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier r17, long r18, float r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m3284CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3292drawCircularIndicator42QJj7c(DrawScope drawScope, float f2, float f3, long j, Stroke stroke) {
        float f4 = 2;
        float width = stroke.getWidth() / f4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo6549getSizeNHjbRc() >> 32)) - (f4 * width);
        DrawScope.m6528drawArcyD3GUKo$default(drawScope, j, f2, f3, false, Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(width)) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), Size.m5783constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    private static final void m3293drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m3292drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m3294drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f2, float f3, long j, Stroke stroke) {
        m3292drawCircularIndicator42QJj7c(drawScope, f2, f3, j, stroke);
    }

    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    private static final void m3295drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f2, float f3, float f4, long j, Stroke stroke) {
        m3292drawCircularIndicator42QJj7c(drawScope, f2 + (StrokeCap.m6340equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m6344getButtKaPHkGw()) ? 0.0f : ((f3 / Dp.m8830constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f4, 0.1f), j, stroke);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateGlobalRotationAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6000, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null);
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateRotationAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_circularIndeterminateRotationAnimationSpec_$lambda$41((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_circularIndeterminateRotationAnimationSpec_$lambda$41(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(6000);
        Float fValueOf = Float.valueOf(90.0f);
        keyframesSpecConfig.using(keyframesSpecConfig.at(fValueOf, 300), MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier());
        keyframesSpecConfig.at(fValueOf, 1500);
        Float fValueOf2 = Float.valueOf(180.0f);
        keyframesSpecConfig.at(fValueOf2, 1800);
        keyframesSpecConfig.at(fValueOf2, 3000);
        Float fValueOf3 = Float.valueOf(270.0f);
        keyframesSpecConfig.at(fValueOf3, 3300);
        keyframesSpecConfig.at(fValueOf3, 4500);
        Float fValueOf4 = Float.valueOf(360.0f);
        keyframesSpecConfig.at(fValueOf4, 4800);
        keyframesSpecConfig.at(fValueOf4, 6000);
        return Unit.INSTANCE;
    }

    public static final InfiniteRepeatableSpec<Float> getCircularIndeterminateProgressAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_circularIndeterminateProgressAnimationSpec_$lambda$42((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_circularIndeterminateProgressAnimationSpec_$lambda$42(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(6000);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.87f), 3000), CircularProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(0.1f), 6000);
        return Unit.INSTANCE;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineHeadAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_linearIndeterminateFirstLineHeadAnimationSpec_$lambda$43(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1000);
        return Unit.INSTANCE;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateFirstLineTailAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_linearIndeterminateFirstLineTailAnimationSpec_$lambda$44(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 250), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1250);
        return Unit.INSTANCE;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineHeadAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_linearIndeterminateSecondLineHeadAnimationSpec_$lambda$45(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), SecondLineHeadDelay), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), 1500);
        return Unit.INSTANCE;
    }

    public static final InfiniteRepeatableSpec<Float> getLinearIndeterminateSecondLineTailAnimationSpec() {
        return AnimationSpecKt.m200infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: androidx.compose.material3.ProgressIndicatorKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProgressIndicatorKt._get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46((KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_linearIndeterminateSecondLineTailAnimationSpec_$lambda$46(KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig) {
        keyframesSpecConfig.setDurationMillis(LinearAnimationDuration);
        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 900), LinearIndeterminateProgressEasing);
        keyframesSpecConfig.at(Float.valueOf(1.0f), LinearAnimationDuration);
        return Unit.INSTANCE;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getStopIndicatorTrailingSpace() {
        return StopIndicatorTrailingSpace;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final CubicBezierEasing getLinearIndeterminateProgressEasing() {
        return LinearIndeterminateProgressEasing;
    }

    public static final CubicBezierEasing getCircularProgressEasing() {
        return CircularProgressEasing;
    }
}
