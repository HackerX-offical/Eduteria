package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.ArcAnimationSpec;
import androidx.compose.animation.core.ArcMode;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LookaheadAnimationVisualDebugHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b+J\u001f\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\u0011\u00101\u001a\u00020&*\u000202H\u0000¢\u0006\u0002\b3J\u001b\u00104\u001a\u00020&*\u0002022\u0006\u00105\u001a\u00020!H\u0000¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u0001H\u0000¢\u0006\u0004\b:\u0010;J?\u0010<\u001a\u00020&*\u0002022\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ_\u0010D\u001a\u00020&*\u0002022\u0006\u0010=\u001a\u00020!2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\f2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bK\u0010LJC\u0010M\u001a\u00020&*\u0002022\u0006\u0010N\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00012\u0006\u0010O\u001a\u00020P2\u0006\u0010@\u001a\u00020A2\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0004\bQ\u0010RJ;\u0010S\u001a\u00020&*\u0002022\u0006\u0010T\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u0006H\u0002J5\u0010]\u001a\u00020&2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020I0_2\u0006\u0010`\u001a\u00020I2\u0006\u0010a\u001a\u00020I2\b\b\u0002\u0010b\u001a\u00020IH\u0000¢\u0006\u0002\bcR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010$¨\u0006d"}, d2 = {"Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "", "<init>", "()V", "reverseProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "restartProgress", "isProgressAnimationRunning", "", "sharedTransitionScopeOffset", "Landroidx/compose/ui/geometry/Offset;", "getSharedTransitionScopeOffset-F1C5BW0", "()J", "setSharedTransitionScopeOffset-k-4lQ0M", "(J)V", "J", "sharedTransitionScopeSize", "Landroidx/compose/ui/unit/IntSize;", "getSharedTransitionScopeSize-YbymL2g", "setSharedTransitionScopeSize-ozmzZPI", "debugOffset", "getDebugOffset-F1C5BW0", "setDebugOffset-k-4lQ0M", "debugPath", "Landroidx/compose/ui/graphics/Path;", "getDebugPath", "()Landroidx/compose/ui/graphics/Path;", "centerPath", "getCenterPath", "colors", "", "Landroidx/compose/ui/graphics/Color;", "getColors$annotations", "getColors", "()Ljava/util/List;", "onAttach", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttach$animation", "onDetach", "onDetach$animation", "updateDrawingCoordinates", "offsetInSharedTransitionScope", "sizeOfSharedTransitionScope", "updateDrawingCoordinates-CowoxoA$animation", "(JJ)V", "drawGlobalVisualizations", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawGlobalVisualizations$animation", "drawOverlay", "overlayColor", "drawOverlay-4WTKRHQ$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;J)V", "chooseColor", "key", "chooseColor-vNxB06k$animation", "(Ljava/lang/Object;)J", "drawInactiveVisualizations", "animationColor", "isShowKeyLabelEnabled", "strokeWidth", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "drawInactiveVisualizations-3IgeMak$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZFLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;)V", "drawLocalVisualizations", "targetOffset", "targetSize", "Landroidx/compose/ui/geometry/Size;", "currentRect", "Landroidx/compose/ui/geometry/Rect;", "center", "drawLocalVisualizations-0XenJco$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JJJLandroidx/compose/ui/geometry/Rect;JZFLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;)V", "drawMultipleMatchesElement", "multipleMatchesColor", "numMatches", "", "drawMultipleMatchesElement-sW7UJKQ$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZLjava/lang/Object;ILandroidx/compose/ui/text/TextMeasurer;F)V", "drawUnmatchedElement", "unmatchedColor", "drawUnmatchedElement-3IgeMak$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;F)V", "findPositionAlongPerimeter", "distanceTraveled", "findPositionAlongPerimeter-tuRUvjQ", "(F)J", "calculatePathCenter", "diamondWidth", "calculatePath", "spec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "current", TypedValues.AttributesType.S_TARGET, "initialVelocity", "calculatePath$animation", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LookaheadAnimationVisualDebugHelper {
    public static final int $stable = 8;
    private boolean isProgressAnimationRunning;
    private final Animatable<Float, AnimationVector1D> reverseProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final Animatable<Float, AnimationVector1D> restartProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private long sharedTransitionScopeOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
    private long sharedTransitionScopeSize = IntSize.INSTANCE.m9006getZeroYbymL2g();
    private long debugOffset = Offset.INSTANCE.m5739getZeroF1C5BW0();
    private final Path debugPath = AndroidPath_androidKt.Path();
    private final Path centerPath = AndroidPath_androidKt.Path();
    private final List<Color> colors = CollectionsKt.listOf((Object[]) new Color[]{Color.m5958boximpl(ColorKt.Color(4293542709L)), Color.m5958boximpl(ColorKt.Color(4294086695L)), Color.m5958boximpl(ColorKt.Color(4291905755L)), Color.m5958boximpl(ColorKt.Color(4282549748L)), Color.m5958boximpl(ColorKt.Color(4282038458L))});

    public static /* synthetic */ void getColors$annotations() {
    }

    /* JADX INFO: renamed from: getSharedTransitionScopeOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getSharedTransitionScopeOffset() {
        return this.sharedTransitionScopeOffset;
    }

    /* JADX INFO: renamed from: setSharedTransitionScopeOffset-k-4lQ0M, reason: not valid java name */
    public final void m135setSharedTransitionScopeOffsetk4lQ0M(long j) {
        this.sharedTransitionScopeOffset = j;
    }

    /* JADX INFO: renamed from: getSharedTransitionScopeSize-YbymL2g, reason: not valid java name and from getter */
    public final long getSharedTransitionScopeSize() {
        return this.sharedTransitionScopeSize;
    }

    /* JADX INFO: renamed from: setSharedTransitionScopeSize-ozmzZPI, reason: not valid java name */
    public final void m136setSharedTransitionScopeSizeozmzZPI(long j) {
        this.sharedTransitionScopeSize = j;
    }

    /* JADX INFO: renamed from: getDebugOffset-F1C5BW0, reason: not valid java name and from getter */
    public final long getDebugOffset() {
        return this.debugOffset;
    }

    /* JADX INFO: renamed from: setDebugOffset-k-4lQ0M, reason: not valid java name */
    public final void m134setDebugOffsetk4lQ0M(long j) {
        this.debugOffset = j;
    }

    public final Path getDebugPath() {
        return this.debugPath;
    }

    public final Path getCenterPath() {
        return this.centerPath;
    }

    public final List<Color> getColors() {
        return this.colors;
    }

    public final void onAttach$animation(CoroutineScope coroutineScope) {
        if (this.isProgressAnimationRunning) {
            return;
        }
        this.isProgressAnimationRunning = true;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onAttach$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onAttach$2(this, null), 3, null);
    }

    public final void onDetach$animation(CoroutineScope coroutineScope) {
        if (this.isProgressAnimationRunning) {
            this.isProgressAnimationRunning = false;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onDetach$1(this, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: updateDrawingCoordinates-CowoxoA$animation, reason: not valid java name */
    public final void m137updateDrawingCoordinatesCowoxoA$animation(long offsetInSharedTransitionScope, long sizeOfSharedTransitionScope) {
        this.sharedTransitionScopeOffset = offsetInSharedTransitionScope;
        this.sharedTransitionScopeSize = sizeOfSharedTransitionScope;
    }

    public final void drawGlobalVisualizations$animation(ContentDrawScope contentDrawScope) {
        long j = this.sharedTransitionScopeSize;
        Brush brushM5919radialGradientP_VxKs$default = Brush.Companion.m5919radialGradientP_VxKs$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m5958boximpl(ColorKt.Color(4293542709L)), Color.m5958boximpl(ColorKt.Color(4282549748L)), Color.m5958boximpl(ColorKt.Color(4281641043L)), Color.m5958boximpl(ColorKt.Color(4294687748L)), Color.m5958boximpl(ColorKt.Color(4293542709L))}), m124findPositionAlongPerimetertuRUvjQ(((((int) (j >> 32)) * 2) + (((int) (j & 4294967295L)) * 2)) * this.restartProgress.getValue().floatValue()), 2000.0f, 0, 8, (Object) null);
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        Paint Paint = AndroidPaint_androidKt.Paint();
        brushM5919radialGradientP_VxKs$default.mo5913applyToPq9zytI(contentDrawScope.mo6549getSizeNHjbRc(), Paint, 1.0f);
        Paint.mo5848setStylek9PVt8s(PaintingStyle.INSTANCE.m6252getStrokeTiuSbCo());
        Paint.setStrokeWidth((contentDrawScope.mo488toPx0680j_4(Dp.m8830constructorimpl(8)) * this.reverseProgress.getValue().floatValue()) + contentDrawScope.mo488toPx0680j_4(Dp.m8830constructorimpl(4)));
        canvas.save();
        canvas.translate(-Float.intBitsToFloat((int) (this.sharedTransitionScopeOffset >> 32)), -Float.intBitsToFloat((int) (this.sharedTransitionScopeOffset & 4294967295L)));
        long j2 = this.sharedTransitionScopeSize;
        canvas.drawRect(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L), Paint);
        canvas.restore();
    }

    /* JADX INFO: renamed from: drawOverlay-4WTKRHQ$animation, reason: not valid java name */
    public final void m129drawOverlay4WTKRHQ$animation(ContentDrawScope contentDrawScope, long j) {
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: chooseColor-vNxB06k$animation, reason: not valid java name */
    public final long m125chooseColorvNxB06k$animation(Object key) {
        if (LookaheadAnimationVisualDebugHelperKt.keyToColor.contains(key)) {
            V v = LookaheadAnimationVisualDebugHelperKt.keyToColor.get(key);
            Intrinsics.checkNotNull(v);
            return ((Color) v).m5978unboximpl();
        }
        if (LookaheadAnimationVisualDebugHelperKt.colorIndex >= this.colors.size()) {
            LookaheadAnimationVisualDebugHelperKt.colorIndex = 0;
        }
        long jM5978unboximpl = this.colors.get(LookaheadAnimationVisualDebugHelperKt.colorIndex).m5978unboximpl();
        LookaheadAnimationVisualDebugHelperKt.colorIndex++;
        LookaheadAnimationVisualDebugHelperKt.keyToColor.set(key, Color.m5958boximpl(jM5978unboximpl));
        return jM5978unboximpl;
    }

    /* JADX INFO: renamed from: drawInactiveVisualizations-3IgeMak$animation, reason: not valid java name */
    public final void m126drawInactiveVisualizations3IgeMak$animation(ContentDrawScope contentDrawScope, long j, boolean z, float f2, Object obj, TextMeasurer textMeasurer) {
        float f3 = f2 * 2.0f;
        long jColor = j;
        if (Color.m5969equalsimpl0(jColor, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope, Color.INSTANCE.m6005getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
            jColor = ColorKt.Color(4288323750L);
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, jColor, 0L, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        if (!z || textMeasurer == null) {
            return;
        }
        TextPainterKt.m8258drawTextd8rzKo(contentDrawScope2, TextMeasurer.m8246measurewNUYSr0$default(textMeasurer, obj.toString(), new TextStyle(jColor, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5967copywmQWz5c$default(Color.INSTANCE.m6005getWhite0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775164, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), (250 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : 0L, (250 & 4) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(10.0f)) << 32) | (((long) Float.floatToRawIntBits(10.0f)) & 4294967295L)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & 128) != 0 ? DrawScope.INSTANCE.m6551getDefaultBlendMode0nO6VwU() : 0);
    }

    /* JADX INFO: renamed from: drawLocalVisualizations-0XenJco$animation, reason: not valid java name */
    public final void m127drawLocalVisualizations0XenJco$animation(ContentDrawScope contentDrawScope, long j, long j2, long j3, Rect rect, long j4, boolean z, float f2, Object obj, TextMeasurer textMeasurer) throws Throwable {
        ContentDrawScope contentDrawScope2;
        float f3;
        float f4;
        long j5;
        float f5;
        float fIntBitsToFloat;
        float fIntBitsToFloat2;
        float f6;
        Object obj2;
        long jM125chooseColorvNxB06k$animation = j;
        if (Color.m5969equalsimpl0(jM125chooseColorvNxB06k$animation, Color.INSTANCE.m6003getTransparent0d7_KjU())) {
            return;
        }
        float f7 = 2.0f * f2;
        if (Color.m5969equalsimpl0(jM125chooseColorvNxB06k$animation, Color.INSTANCE.m6004getUnspecified0d7_KjU())) {
            contentDrawScope2 = contentDrawScope;
            DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, Color.INSTANCE.m6005getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f7, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
            int i = (int) (j2 >> 32);
            float fIntBitsToFloat3 = Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() >> 32));
            int i2 = (int) (j2 & 4294967295L);
            float fIntBitsToFloat4 = Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() & 4294967295L));
            contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat3, fIntBitsToFloat4);
            try {
                try {
                    j5 = 4294967295L;
                    f4 = fIntBitsToFloat4;
                    f3 = fIntBitsToFloat3;
                    f5 = 0.5f;
                    try {
                        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, Color.INSTANCE.m6005getWhite0d7_KjU(), 0L, j3, 0.0f, new Stroke(f7, 0.0f, 0, 0, null, 30, null), null, 0, 106, null);
                        contentDrawScope2.getDrawContext().getTransform().translate(-f3, -f4);
                        fIntBitsToFloat = (Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() >> 32))) - Float.intBitsToFloat((int) (this.debugOffset >> 32));
                        fIntBitsToFloat2 = (Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() & 4294967295L))) - Float.intBitsToFloat((int) (this.debugOffset & 4294967295L));
                        contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat, fIntBitsToFloat2);
                        try {
                            float fIntBitsToFloat5 = Float.intBitsToFloat((int) (j3 >> 32)) * 0.5f;
                            float fIntBitsToFloat6 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * 0.5f;
                            contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat5, fIntBitsToFloat6);
                            try {
                                try {
                                    f6 = fIntBitsToFloat6;
                                } catch (Throwable th) {
                                    th = th;
                                    f6 = fIntBitsToFloat6;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                f6 = fIntBitsToFloat6;
                            }
                            try {
                                DrawScope.m6539drawPathLG529CI$default(contentDrawScope2, this.debugPath, Color.INSTANCE.m6005getWhite0d7_KjU(), 0.0f, new Stroke(f7, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{20.0f, 10.0f}, 0.0f, 2, null), 14, null), null, 0, 52, null);
                                contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat5, -f6);
                                contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                calculatePathCenter(3.5f * f2);
                                float fIntBitsToFloat7 = Float.intBitsToFloat((int) (j4 >> 32));
                                float fIntBitsToFloat8 = Float.intBitsToFloat((int) (j4 & 4294967295L));
                                contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat7, fIntBitsToFloat8);
                                try {
                                    DrawScope.m6539drawPathLG529CI$default(contentDrawScope2, this.centerPath, Color.INSTANCE.m6005getWhite0d7_KjU(), 0.0f, null, null, 0, 60, null);
                                    contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat7, -fIntBitsToFloat8);
                                    obj2 = obj;
                                    jM125chooseColorvNxB06k$animation = m125chooseColorvNxB06k$animation(obj2);
                                } finally {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat5, -f6);
                                throw th;
                            }
                        } finally {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        contentDrawScope2.getDrawContext().getTransform().translate(-f3, -f4);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    f4 = fIntBitsToFloat4;
                    f3 = fIntBitsToFloat3;
                }
            } catch (Throwable th6) {
                th = th6;
                f3 = fIntBitsToFloat3;
                f4 = fIntBitsToFloat4;
            }
        } else {
            obj2 = obj;
            j5 = 4294967295L;
            f5 = 0.5f;
        }
        long j6 = jM125chooseColorvNxB06k$animation;
        contentDrawScope2 = contentDrawScope;
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, j6, 0L, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        int i3 = (int) (j2 >> 32);
        fIntBitsToFloat = Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() >> 32));
        int i4 = (int) (j2 & j5);
        fIntBitsToFloat2 = Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() & j5));
        contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat, fIntBitsToFloat2);
        try {
        } catch (Throwable th7) {
            th = th7;
        }
        try {
            DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, j6, 0L, j3, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 106, null);
            contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat, -fIntBitsToFloat2);
            fIntBitsToFloat = (Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() >> 32))) - Float.intBitsToFloat((int) (this.debugOffset >> 32));
            fIntBitsToFloat2 = (Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() & j5))) - Float.intBitsToFloat((int) (this.debugOffset & j5));
            contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat, fIntBitsToFloat2);
            try {
                float fIntBitsToFloat9 = Float.intBitsToFloat((int) (j3 >> 32)) * f5;
                float fIntBitsToFloat10 = Float.intBitsToFloat((int) (j3 & j5)) * f5;
                contentDrawScope2.getDrawContext().getTransform().translate(fIntBitsToFloat9, fIntBitsToFloat10);
                try {
                    DrawScope.m6539drawPathLG529CI$default(contentDrawScope2, this.debugPath, j6, 0.0f, new Stroke(f2, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{20.0f, 10.0f}, 0.0f, 2, null), 14, null), null, 0, 52, null);
                    contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                    calculatePathCenter(3 * f2);
                    contentDrawScope2.getDrawContext().getTransform().translate(Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & j5)));
                    try {
                        DrawScope.m6539drawPathLG529CI$default(contentDrawScope2, this.centerPath, j6, 0.0f, null, null, 0, 60, null);
                        if (!z || textMeasurer == null) {
                            return;
                        }
                        TextLayoutResult textLayoutResultM8246measurewNUYSr0$default = TextMeasurer.m8246measurewNUYSr0$default(textMeasurer, obj2.toString(), new TextStyle(j6, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5967copywmQWz5c$default(Color.INSTANCE.m6005getWhite0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775164, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null);
                        TextPainterKt.m8258drawTextd8rzKo(contentDrawScope2, textLayoutResultM8246measurewNUYSr0$default, (250 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : 0L, (250 & 4) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(10.0f)) << 32) | (((long) Float.floatToRawIntBits(10.0f)) & j5)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & 128) != 0 ? DrawScope.INSTANCE.m6551getDefaultBlendMode0nO6VwU() : 0);
                        contentDrawScope2.getDrawContext().getTransform().translate(Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() >> 32)), Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5758getTopLeftF1C5BW0() & j5)));
                        try {
                            try {
                                TextPainterKt.m8258drawTextd8rzKo(contentDrawScope2, textLayoutResultM8246measurewNUYSr0$default, (250 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : 0L, (250 & 4) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(10.0f)) << 32) | (((long) Float.floatToRawIntBits(10.0f)) & j5)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & 128) != 0 ? DrawScope.INSTANCE.m6551getDefaultBlendMode0nO6VwU() : 0);
                            } catch (Throwable th8) {
                                th = th8;
                                contentDrawScope2 = contentDrawScope2;
                                throw th;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    } finally {
                    }
                } finally {
                    contentDrawScope2.getDrawContext().getTransform().translate(-fIntBitsToFloat9, -fIntBitsToFloat10);
                }
            } finally {
            }
        } catch (Throwable th10) {
            th = th10;
            contentDrawScope2 = contentDrawScope2;
            throw th;
        }
    }

    /* JADX INFO: renamed from: drawMultipleMatchesElement-sW7UJKQ$animation, reason: not valid java name */
    public final void m128drawMultipleMatchesElementsW7UJKQ$animation(ContentDrawScope contentDrawScope, long j, boolean z, Object obj, int i, TextMeasurer textMeasurer, float f2) {
        String str;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, Color.INSTANCE.m6005getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f2 * 2.0f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, j, 0L, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        if (z) {
            switch (i) {
                case 2:
                    str = "2️⃣";
                    break;
                case 3:
                    str = "3️⃣";
                    break;
                case 4:
                    str = "4️⃣";
                    break;
                case 5:
                    str = "5️⃣";
                    break;
                case 6:
                    str = "6️⃣";
                    break;
                case 7:
                    str = "7️⃣";
                    break;
                case 8:
                    str = "8️⃣";
                    break;
                case 9:
                    str = "9️⃣";
                    break;
                default:
                    str = "> 9️⃣";
                    break;
            }
            TextPainterKt.m8258drawTextd8rzKo(contentDrawScope2, TextMeasurer.m8246measurewNUYSr0$default(textMeasurer, obj + ": " + str + " matches", new TextStyle(Color.INSTANCE.m6005getWhite0d7_KjU(), TextUnitKt.getSp(22), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5967copywmQWz5c$default(j, 0.8f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775160, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), (250 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : 0L, (250 & 4) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(10.0f)) << 32) | (((long) Float.floatToRawIntBits(10.0f)) & 4294967295L)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & 128) != 0 ? DrawScope.INSTANCE.m6551getDefaultBlendMode0nO6VwU() : 0);
        }
    }

    /* JADX INFO: renamed from: drawUnmatchedElement-3IgeMak$animation, reason: not valid java name */
    public final void m130drawUnmatchedElement3IgeMak$animation(ContentDrawScope contentDrawScope, long j, boolean z, Object obj, TextMeasurer textMeasurer, float f2) throws Throwable {
        long j2;
        long j3;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, Color.INSTANCE.m6005getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f2 * 2.0f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        DrawScope.m6543drawRectnJ9OG0$default(contentDrawScope2, j, 0L, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope2.mo6549getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo6549getSizeNHjbRc() & 4294967295L));
        int iM5957getIntersectrtfAjoo = ClipOp.INSTANCE.m5957getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long jMo6470getSizeNHjbRc = drawContext.mo6470getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo6473clipRectN_I0leg(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, iM5957getIntersectrtfAjoo);
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope2.mo6549getSizeNHjbRc() >> 32));
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (contentDrawScope2.mo6549getSizeNHjbRc() & 4294967295L));
            float f3 = -fIntBitsToFloat4;
            while (f3 < fIntBitsToFloat3) {
                try {
                    long j4 = jMo6470getSizeNHjbRc;
                    float f4 = fIntBitsToFloat4;
                    j3 = j4;
                    try {
                        DrawScope.m6535drawLineNGM6Ib0$default(contentDrawScope2, Color.m5967copywmQWz5c$default(j, 0.3f, 0.0f, 0.0f, 0.0f, 14, null), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat4)) & 4294967295L)), Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3 + fIntBitsToFloat4)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), f2, 0, null, 0.0f, null, 0, 496, null);
                        f3 += 4 * f2;
                        fIntBitsToFloat4 = f4;
                        jMo6470getSizeNHjbRc = j3;
                    } catch (Throwable th) {
                        th = th;
                        j2 = j3;
                        drawContext.getCanvas().restore();
                        drawContext.mo6471setSizeuvyYCjk(j2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j3 = jMo6470getSizeNHjbRc;
                }
            }
            drawContext.getCanvas().restore();
            drawContext.mo6471setSizeuvyYCjk(jMo6470getSizeNHjbRc);
            if (z) {
                TextPainterKt.m8258drawTextd8rzKo(contentDrawScope2, TextMeasurer.m8246measurewNUYSr0$default(textMeasurer, obj + ": 0️⃣ matches", new TextStyle(Color.INSTANCE.m6005getWhite0d7_KjU(), TextUnitKt.getSp(22), FontWeight.INSTANCE.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5967copywmQWz5c$default(j, 0.8f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775160, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), (250 & 2) != 0 ? Color.INSTANCE.m6004getUnspecified0d7_KjU() : 0L, (250 & 4) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(10.0f)) & 4294967295L) | (Float.floatToRawIntBits(10.0f) << 32)), (250 & 8) != 0 ? Float.NaN : 0.0f, (250 & 16) != 0 ? null : null, (250 & 32) != 0 ? null : null, (250 & 64) == 0 ? null : null, (250 & 128) != 0 ? DrawScope.INSTANCE.m6551getDefaultBlendMode0nO6VwU() : 0);
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = jMo6470getSizeNHjbRc;
        }
    }

    /* JADX INFO: renamed from: findPositionAlongPerimeter-tuRUvjQ, reason: not valid java name */
    private final long m124findPositionAlongPerimetertuRUvjQ(float distanceTraveled) {
        long j = this.sharedTransitionScopeSize;
        float f2 = (int) (j >> 32);
        float f3 = (int) (j & 4294967295L);
        if (distanceTraveled <= f2) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(distanceTraveled)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        }
        if (distanceTraveled <= f2 + f3) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(distanceTraveled - f2)) & 4294967295L));
        }
        float f4 = 2;
        float f5 = f2 * f4;
        float f6 = f5 + f3;
        if (distanceTraveled <= f6) {
            return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f6 - distanceTraveled) << 32));
        }
        return Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(((f3 * f4) + f5) - distanceTraveled)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
    }

    private final void calculatePathCenter(float diamondWidth) {
        this.centerPath.rewind();
        Path path = this.centerPath;
        float f2 = -diamondWidth;
        path.moveTo(0.0f, f2);
        path.lineTo(diamondWidth, 0.0f);
        path.lineTo(0.0f, diamondWidth);
        path.lineTo(f2, 0.0f);
        path.close();
    }

    public final void calculatePath$animation(FiniteAnimationSpec<Rect> spec, Rect current, Rect target, Rect initialVelocity) {
        long j;
        long j2;
        this.debugPath.rewind();
        long j3 = 4294967295L;
        if ((spec instanceof TweenSpec) || (spec instanceof SnapSpec) || ((spec instanceof ArcAnimationSpec) && ArcMode.m207equalsimpl0(((ArcAnimationSpec) spec).getMode(), ArcMode.INSTANCE.m213getArcLinear9TMq4()))) {
            this.debugPath.moveTo(Float.intBitsToFloat((int) (current.m5753getCenterF1C5BW0() >> 32)), Float.intBitsToFloat((int) (current.m5753getCenterF1C5BW0() & 4294967295L)));
            this.debugPath.lineTo(Float.intBitsToFloat((int) (target.m5753getCenterF1C5BW0() >> 32)), Float.intBitsToFloat((int) (target.m5753getCenterF1C5BW0() & 4294967295L)));
            this.debugPath.mo5860translatek4lQ0M(Offset.m5715constructorimpl(current.m5753getCenterF1C5BW0() ^ (-9223372034707292160L)));
            this.debugOffset = Offset.m5727minusMKHz9U(target.m5753getCenterF1C5BW0(), current.m5753getCenterF1C5BW0());
            return;
        }
        TargetBasedAnimation TargetBasedAnimation = AnimationKt.TargetBasedAnimation(spec, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), current, target, initialVelocity);
        long durationNanos = TargetBasedAnimation.getDurationNanos();
        Rect rect = (Rect) TargetBasedAnimation.getValueFromNanos(0L);
        int i = 0;
        while (true) {
            long jM5753getCenterF1C5BW0 = ((Rect) TargetBasedAnimation.getValueFromNanos(durationNanos - ((long) (durationNanos * (i / 399))))).m5753getCenterF1C5BW0();
            if (i == 0) {
                j = -9223372034707292160L;
                this.debugPath.moveTo(Float.intBitsToFloat((int) (jM5753getCenterF1C5BW0 >> 32)), Float.intBitsToFloat((int) (jM5753getCenterF1C5BW0 & j3)));
                j2 = j3;
            } else {
                j = -9223372034707292160L;
                j2 = j3;
                this.debugPath.lineTo(Float.intBitsToFloat((int) (jM5753getCenterF1C5BW0 >> 32)), Float.intBitsToFloat((int) (jM5753getCenterF1C5BW0 & j2)));
            }
            if (i == 400) {
                this.debugPath.mo5860translatek4lQ0M(Offset.m5715constructorimpl(rect.m5753getCenterF1C5BW0() ^ j));
                this.debugOffset = Offset.m5727minusMKHz9U(target.m5753getCenterF1C5BW0(), rect.m5753getCenterF1C5BW0());
                return;
            } else {
                i++;
                j3 = j2;
            }
        }
    }

    public static /* synthetic */ void calculatePath$animation$default(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper, FiniteAnimationSpec finiteAnimationSpec, Rect rect, Rect rect2, Rect rect3, int i, Object obj) {
        if ((i & 8) != 0) {
            rect3 = RectKt.m5762Rect3MmeM6k(Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), 0.0f);
        }
        lookaheadAnimationVisualDebugHelper.calculatePath$animation(finiteAnimationSpec, rect, rect2, rect3);
    }
}
