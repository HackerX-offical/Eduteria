package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.material3.internal.PredictiveBackState;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.exoplayer.RendererCapabilities;
import com.canhub.cropper.CropImageOptionsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001ar\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0099\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0084\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020$2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b*\u0010+\u001a\u008e\u0001\u0010,\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b-\u0010.\u001a7\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u0002012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u000204032\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0007¢\u0006\u0002\u00106\u001a\u0090\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bC\u0010D\u001a\u0086\u0002\u0010,\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bE\u0010F\u001aÄ\u0001\u0010K\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0001¢\u0006\u0004\bV\u0010W\u001a \u0001\u0010X\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010Y\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010Z\u001ap\u0010[\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\b\\\u0010]\u001a\u0080\u0001\u0010^\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\ba\u0010b\u001a\u000e\u0010c\u001a\u000204*\u0004\u0018\u00010dH\u0002\u001a#\u0010j\u001a\u00020\u00012\u0006\u0010A\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010m\u001a-\u0010n\u001a\u0002042\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010o\u001a\u0002042\u0006\u0010O\u001a\u000204H\u0002¢\u0006\u0002\u0010p\u001aG\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010v\u001a\u00020w2\u0006\u0010o\u001a\u0002042\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\by\u0010z\u001aW\u0010{\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u000e\u0010Q\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020r2\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\b~\u0010\u007f\"\u001e\u0010G\u001a\u00020(*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001a\u0004\bG\u0010J\"\u001e\u0010e\u001a\u00020f*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bg\u0010I\u001a\u0004\bh\u0010i\"\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0082\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0083\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0085\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001a\u0010\u0089\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u001a\u0010\u008c\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u0087\u0001\"\u000f\u0010\u008e\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u008f\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u0087\u0001\"\u0012\u0010\u0091\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u001a\u0010\u0092\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0093\u0001\u0010\u0087\u0001\"\u0012\u0010\u0094\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0095\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0096\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0097\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0098\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0099\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009a\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009b\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u009e\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001²\u0006\u000b\u0010«\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\u000b\u0010¬\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u0010\u00ad\u0001\u001a\u00030®\u0001X\u008a\u0084\u0002"}, d2 = {"SearchBar", "", "state", "Landroidx/compose/material3/SearchBarState;", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "SearchBar-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/runtime/Composer;II)V", "TopSearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "scrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "TopSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/SearchBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "ExpandedFullScreenSearchBar", "collapsedShape", JivePropertiesExtension.ELEMENT, "Landroidx/compose/ui/window/DialogProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ExpandedFullScreenSearchBar-_UtchM0", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ExpandedDockedSearchBar", "Landroidx/compose/ui/window/PopupProperties;", "ExpandedDockedSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "onExpandedChange", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSearchBarState", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpecForCollapse", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarState;", "query", "", "onQueryChange", "onSearch", "active", "onActiveChange", StreamManagement.Enabled.ELEMENT, "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isExpanded", "isExpanded$annotations", "(Landroidx/compose/material3/SearchBarState;)V", "(Landroidx/compose/material3/SearchBarState;)Z", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DockedSearchBarLayout", "DockedSearchBarLayout-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FullScreenSearchBarLayout", "predictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "FullScreenSearchBarLayout-EQC0FA8", "(Landroidx/compose/material3/SearchBarState;Landroidx/compose/material3/internal/PredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "transform", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "collapsedBounds", "Landroidx/compose/ui/unit/IntRect;", "getCollapsedBounds$annotations", "getCollapsedBounds", "(Landroidx/compose/material3/SearchBarState;)Landroidx/compose/ui/unit/IntRect;", "DetectClickFromInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "onClick", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "(Landroidx/activity/BackEventCompat;FF)F", "calculatePredictiveBackOffsetX", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarAsTopBarPadding", "getSearchBarAsTopBarPadding", "()F", "F", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "AnimationExitDurationMillis", "AnimationDelayMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitSizeSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "material3", "useFullScreenShape", "showContent", "backEvent", "Landroidx/compose/material3/internal/BackEventProgress;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarAsTopBarPadding;
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMinMargin;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    private static final TextFieldColors UnspecifiedTextFieldColors = new TextFieldColors(Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), new TextSelectionColors(Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), null), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), Color.INSTANCE.m6004getUnspecified0d7_KjU(), null);
    private static final float SearchBarCornerRadius = Dp.m8830constructorimpl(SearchBarDefaults.INSTANCE.m3333getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedExpandedTableMinHeight = Dp.m8830constructorimpl(240);
    private static final float SearchBarMinWidth = Dp.m8830constructorimpl(CropImageOptionsKt.DEGREES_360);
    private static final float SearchBarMaxWidth = Dp.m8830constructorimpl(720);
    private static final float SearchBarIconOffsetX = Dp.m8830constructorimpl(4);
    private static final float SearchBarPredictiveBackMaxOffsetY = Dp.m8830constructorimpl(24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetectClickFromInteractionSource$lambda$73(InteractionSource interactionSource, Function0 function0, int i, Composer composer, int i2) {
        DetectClickFromInteractionSource(interactionSource, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, Function3 function3, int i, Composer composer, int i2) {
        m3352DockedSearchBarLayoutnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBar_EQC0FA8$lambda$25(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3350DockedSearchBarEQC0FA8(function2, z, function1, modifier, shape, searchBarColors, f2, f3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBar_eWTbjVg$lambda$29(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f2, float f3, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3351DockedSearchBareWTbjVg(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f2, f3, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3353ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3353ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3354ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3354ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState searchBarState, PredictiveBackState predictiveBackState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, WindowInsets windowInsets, Function3 function3, int i, Composer composer, int i2) {
        m3355FullScreenSearchBarLayoutEQC0FA8(searchBarState, predictiveBackState, function2, modifier, shape, searchBarColors, f2, f3, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBarImpl_j1jLAyQ$lambda$39(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, Function2 function2, Shape shape, SearchBarColors searchBarColors, float f2, float f3, WindowInsets windowInsets, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3359SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier, function2, shape, searchBarColors, f2, f3, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBarLayout$lambda$49(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, WindowInsets windowInsets, Function2 function2, Function2 function22, Function2 function23, int i, Composer composer, int i2) {
        SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar_WuY5d9Q$lambda$28(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f2, float f3, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m3356SearchBarWuY5d9Q(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f2, f3, windowInsets, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar_Y92LkZI$lambda$22(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3357SearchBarY92LkZI(function2, z, function1, modifier, shape, searchBarColors, f2, f3, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar_nbWgWpA$lambda$2(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m3358SearchBarnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopSearchBar_qKj4JfE$lambda$5(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f2, float f3, WindowInsets windowInsets, SearchBarScrollBehavior searchBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m3360TopSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f2, f3, windowInsets, searchBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getCollapsedBounds$annotations(SearchBarState searchBarState) {
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    private static /* synthetic */ void isExpanded$annotations(SearchBarState searchBarState) {
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* JADX INFO: renamed from: SearchBar-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3358SearchBarnbWgWpA(final androidx.compose.material3.SearchBarState r22, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.ui.Modifier r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.material3.SearchBarColors r26, float r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3358SearchBarnbWgWpA(androidx.compose.material3.SearchBarState, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState searchBarState, LayoutCoordinates layoutCoordinates) {
        searchBarState.setCollapsedCoords(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX INFO: renamed from: TopSearchBar-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3360TopSearchBarqKj4JfE(final androidx.compose.material3.SearchBarState r26, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, androidx.compose.ui.graphics.Shape r29, androidx.compose.material3.SearchBarColors r30, float r31, float r32, androidx.compose.foundation.layout.WindowInsets r33, androidx.compose.material3.SearchBarScrollBehavior r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3360TopSearchBarqKj4JfE(androidx.compose.material3.SearchBarState, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.material3.SearchBarScrollBehavior, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /* JADX INFO: renamed from: ExpandedFullScreenSearchBar-_UtchM0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3354ExpandedFullScreenSearchBar_UtchM0(final androidx.compose.material3.SearchBarState r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.SearchBarColors r28, float r29, float r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.foundation.layout.WindowInsets> r31, androidx.compose.ui.window.DialogProperties r32, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3354ExpandedFullScreenSearchBar_UtchM0(androidx.compose.material3.SearchBarState, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, kotlin.jvm.functions.Function2, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedFullScreenSearchBar$3$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6  */
    /* JADX INFO: renamed from: ExpandedDockedSearchBar-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3353ExpandedDockedSearchBarqKj4JfE(final androidx.compose.material3.SearchBarState r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.ui.Modifier r26, androidx.compose.ui.graphics.Shape r27, androidx.compose.material3.SearchBarColors r28, float r29, float r30, androidx.compose.ui.window.PopupProperties r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 748
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3353ExpandedDockedSearchBarqKj4JfE(androidx.compose.material3.SearchBarState, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedDockedSearchBar$2$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* JADX INFO: renamed from: SearchBar-Y92LkZI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3357SearchBarY92LkZI(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, boolean r31, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.ui.graphics.Shape r34, androidx.compose.material3.SearchBarColors r35, float r36, float r37, androidx.compose.foundation.layout.WindowInsets r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3357SearchBarY92LkZI(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /* JADX INFO: renamed from: DockedSearchBar-EQC0FA8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3350DockedSearchBarEQC0FA8(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, final boolean r28, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, androidx.compose.ui.graphics.Shape r31, androidx.compose.material3.SearchBarColors r32, float r33, float r34, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3350DockedSearchBarEQC0FA8(kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    public static final SearchBarState rememberSearchBarState(final SearchBarValue searchBarValue, final AnimationSpec<Float> animationSpec, final AnimationSpec<Float> animationSpec2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -546016819, "C(rememberSearchBarState)N(initialValue,animationSpecForExpand,animationSpecForCollapse)817@37213L7,818@37312L7,829@37663L208,820@37352L519:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            searchBarValue = SearchBarValue.Collapsed;
        }
        if ((i2 & 2) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowSpatial, composer, 6);
        }
        if ((i2 & 4) != 0) {
            animationSpec2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-546016819, i, -1, "androidx.compose.material3.rememberSearchBarState (SearchBar.kt:819)");
        }
        Object[] objArr = {searchBarValue, animationSpec, animationSpec2};
        Saver<SearchBarState, ?> Saver = SearchBarState.INSTANCE.Saver(animationSpec, animationSpec2);
        ComposerKt.sourceInformationMarkerStart(composer, -736131555, "CC(remember):SearchBar.kt#9igjgp");
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(searchBarValue.ordinal())) || (i & 6) == 4) | composer.changedInstance(animationSpec) | composer.changedInstance(animationSpec2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchBarKt.rememberSearchBarState$lambda$27$lambda$26(searchBarValue, animationSpec, animationSpec2);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchBarState searchBarState = (SearchBarState) RememberSaveableKt.m5351rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchBarState rememberSearchBarState$lambda$27$lambda$26(SearchBarValue searchBarValue, AnimationSpec animationSpec, AnimationSpec animationSpec2) {
        return new SearchBarState(searchBarValue, (AnimationSpec<Float>) animationSpec, (AnimationSpec<Float>) animationSpec2);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @kotlin.Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @kotlin.ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3356SearchBarWuY5d9Q(final java.lang.String r36, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r37, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, final boolean r39, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.ui.graphics.Shape r46, androidx.compose.material3.SearchBarColors r47, float r48, float r49, androidx.compose.foundation.layout.WindowInsets r50, androidx.compose.foundation.interaction.MutableInteractionSource r51, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, androidx.compose.runtime.Composer r53, final int r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3356SearchBarWuY5d9Q(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @kotlin.Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @kotlin.ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* JADX INFO: renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3351DockedSearchBareWTbjVg(final java.lang.String r34, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r35, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r36, final boolean r37, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.ui.graphics.Shape r44, androidx.compose.material3.SearchBarColors r45, float r46, float r47, androidx.compose.foundation.interaction.MutableInteractionSource r48, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3351DockedSearchBareWTbjVg(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isExpanded(SearchBarState searchBarState) {
        return searchBarState.getCurrentValue() == SearchBarValue.Expanded;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX INFO: renamed from: SearchBarImpl-j1jLAyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m3359SearchBarImplj1jLAyQ(final androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r28, final androidx.compose.runtime.MutableFloatState r29, final androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r30, final androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r31, androidx.compose.ui.Modifier r32, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.graphics.Shape r34, androidx.compose.material3.SearchBarColors r35, float r36, float r37, androidx.compose.foundation.layout.WindowInsets r38, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, final int r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 1015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarKt.m3359SearchBarImplj1jLAyQ(androidx.compose.animation.core.Animatable, androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.SearchBarColors, float, float, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() == 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density density, Animatable animatable, Path path, Size size, LayoutDirection layoutDirection) {
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(Dp.m8830constructorimpl(SearchBarCornerRadius * (1 - ((Number) animatable.getValue()).floatValue())));
        Path.addRoundRect$default(path, RoundRectKt.m5778RoundRectsniSvfs(SizeKt.m5813toRectuvyYCjk(size.m5797unboximpl()), CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMo488toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo488toPx0680j_4)) & 4294967295L))), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() > 0.0f;
    }

    private static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i) {
        int i2;
        MutableState<BackEventCompat> mutableState3;
        MutableState<BackEventCompat> mutableState4;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1217602934);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBarLayout)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,windowInsets,inputField,surface,content)2171@101429L34,2176@101591L120,2191@102227L5012,2172@101468L5771:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableFloatState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            mutableState3 = mutableState;
            i2 |= composerStartRestartGroup.changed(mutableState3) ? 256 : 128;
        } else {
            mutableState3 = mutableState;
        }
        if ((i & 3072) == 0) {
            mutableState4 = mutableState2;
            i2 |= composerStartRestartGroup.changed(mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217602934, i2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.kt:2167)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885337272, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MutableWindowInsets(null, 1, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierZIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885342542, "CC(remember):SearchBar.kt#9igjgp");
            boolean z = (458752 & i2) == 131072;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarKt.SearchBarLayout$lambda$42$lambda$41(mutableWindowInsets, windowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifierZIndex, (Function1) objRememberedValue2), windowInsets);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1885367786, "CC(remember):SearchBar.kt#9igjgp");
            boolean z2 = ((i2 & 14) == 4 || ((i2 & 8) != 0 && composerStartRestartGroup.changedInstance(animatable))) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            SearchBarKt$SearchBarLayout$2$1 searchBarKt$SearchBarLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || searchBarKt$SearchBarLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                MutableState<BackEventCompat> mutableState5 = mutableState3;
                i3 = i2;
                searchBarKt$SearchBarLayout$2$1RememberedValue = new SearchBarKt$SearchBarLayout$2$1(animatable, mutableWindowInsets, mutableState4, mutableFloatState, mutableState5);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$SearchBarLayout$2$1RememberedValue);
            } else {
                i3 = i2;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) searchBarKt$SearchBarLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierConsumeWindowInsets);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2058590599, "C2181@101796L85,2182@101894L119:SearchBar.kt#uh7d8r");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 329239585, "C2181@101870L9:SearchBar.kt#uh7d8r");
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 397275701, "C2183@101987L12:SearchBar.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function23 == null) {
                composerStartRestartGroup.startReplaceGroup(2058820276);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2058820277);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*2186@102068L127");
                Modifier modifierLayoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM5069constructorimpl4 = Updater.m5069constructorimpl(composerStartRestartGroup);
                Updater.m5077setimpl(composerM5069constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5077setimpl(composerM5069constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM5069constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM5069constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM5069constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m5077setimpl(composerM5069constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1819747385, "C2187@102168L9:SearchBar.kt#uh7d8r");
                function23.invoke(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.SearchBarLayout$lambda$49(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DockedSearchBarLayout-nbWgWpA, reason: not valid java name */
    public static final void m3352DockedSearchBarLayoutnbWgWpA(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f2, final float f3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Modifier modifier2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1402423467);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBarLayout)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)2324@107586L24,2325@107655L47,2325@107615L87,2330@107802L38,2334@107974L2233,2327@107708L2499:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            modifier2 = modifier;
            i2 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(searchBarColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402423467, i2, -1, "androidx.compose.material3.DockedSearchBarLayout (SearchBar.kt:2323)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zIsExpanded = isExpanded(searchBarState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -890765926, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(coroutineScope);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(coroutineScope, searchBarState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.BackHandler(zIsExpanded, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 0);
            int i3 = i2 >> 3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m3531SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(modifier2), shape, searchBarColors.m3323getContainerColor0d7_KjU(), ColorSchemeKt.m2664contentColorForek8zF_U(searchBarColors.m3323getContainerColor0d7_KjU(), composerStartRestartGroup, 0), f2, f3, null, ComposableLambdaKt.rememberComposableLambda(-956905210, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C2335@108012L26,2343@108320L195,2350@108545L1656,2339@108213L1988:SearchBar.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-956905210, i4, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous> (SearchBar.kt:2335)");
                    }
                    float fM8830constructorimpl = Dp.m8830constructorimpl(SearchBar_androidKt.getWindowContainerHeight(composer3, 0) * 0.6666667f);
                    float fM8844unboximpl = ((Dp) RangesKt.coerceAtMost(Dp.m8828boximpl(SearchBarKt.getDockedExpandedTableMinHeight()), Dp.m8828boximpl(fM8830constructorimpl))).m8844unboximpl();
                    final SearchBarColors searchBarColors2 = searchBarColors;
                    final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, ComposableLambdaKt.rememberComposableLambda(-1776541672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i5) {
                            ComposerKt.sourceInformation(composer4, "C2344@108346L147:SearchBar.kt#uh7d8r");
                            if (!composer4.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1776541672, i5, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous>.<anonymous> (SearchBar.kt:2344)");
                            }
                            SearchBarColors searchBarColors3 = searchBarColors2;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, companion);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer4);
                            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 1313930401, "C2345@108383L46,2346@108458L9:SearchBar.kt#uh7d8r");
                            DividerKt.m2850HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors3.m3324getDividerColor0d7_KjU(), composer4, 0, 3);
                            function33.invoke(columnScopeInstance, composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54)});
                    ComposerKt.sourceInformationMarkerStart(composer3, -462885538, "CC(remember):SearchBar.kt#9igjgp");
                    boolean zChanged = composer3.changed(searchBarState) | composer3.changed(fM8830constructorimpl) | composer3.changed(fM8844unboximpl);
                    SearchBarState searchBarState2 = searchBarState;
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (MultiContentMeasurePolicy) new SearchBarKt$DockedSearchBarLayout$2$2$1(searchBarState2, fM8830constructorimpl, fM8844unboximpl);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Function2<Composer, Integer, Unit> function2CombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listListOf);
                    ComposerKt.sourceInformationMarkerStart(composer3, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean zChanged2 = composer3.changed(multiContentMeasurePolicy);
                    Object objRememberedValue4 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer3);
                    Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    function2CombineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, ((i2 >> 6) & 112) | 12582912 | (57344 & i3) | (i3 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$52(searchBarState, function2, modifier3, shape, searchBarColors, f2, f3, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$DockedSearchBarLayout$1$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: FullScreenSearchBarLayout-EQC0FA8, reason: not valid java name */
    public static final void m3355FullScreenSearchBarLayoutEQC0FA8(final SearchBarState searchBarState, final PredictiveBackState predictiveBackState, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f2, final float f3, final WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        State state;
        final MutableState mutableState;
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-740838201);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FullScreenSearchBarLayout)N(state,predictiveBackState,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2399@110650L57,2401@110747L64,2410@111159L64,2419@111546L7,2420@111598L15,2422@111646L1042,2447@112954L34,2453@113205L120,2484@114348L4812,2450@113110L6050:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(predictiveBackState) : composerStartRestartGroup.changedInstance(predictiveBackState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(searchBarColors) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f3) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740838201, i2, -1, "androidx.compose.material3.FullScreenSearchBarLayout (SearchBar.kt:2398)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019074080, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return predictiveBackState.getValue();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            State state2 = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019077191, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackEventProgress backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state2);
            if (backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55 instanceof BackEventProgress.InProgress) {
                if (mutableState2.getValue() == null) {
                    mutableState2.setValue(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55);
                }
            } else if (Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState2.setValue(null);
            } else if (!Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019090375, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                state = state2;
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                state = state2;
            }
            MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackEventProgress backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state);
            if (backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552 instanceof BackEventProgress.InProgress) {
                mutableState3.setValue(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552);
            } else if (Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState3.setValue(null);
            } else if (!Intrinsics.areEqual(backEventProgressFullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            int i5 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            final Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019106937, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(density) | composerStartRestartGroup.changed(fullScreenShape);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
                GenericShape genericShape = new GenericShape(new Function3() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(shape, fullScreenShape, density, searchBarState, mutableState, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(genericShape);
                objRememberedValue4 = genericShape;
            } else {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
            }
            GenericShape genericShape2 = (GenericShape) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019147785, "CC(remember):SearchBar.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new MutableWindowInsets(null, i4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            WindowInsets windowInsetsM1250onlybOOhFvg = WindowInsetsKt.m1250onlybOOhFvg(mutableWindowInsets.getInsets(), WindowInsetsSides.m1266plusgK_yJZ4(WindowInsetsSides.INSTANCE.m1276getHorizontalJoeWqyM(), WindowInsetsSides.INSTANCE.m1274getBottomJoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019155903, "CC(remember):SearchBar.kt#9igjgp");
            int i6 = (i3 & 234881024) == 67108864 ? i4 : 0;
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (i6 != 0 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(mutableWindowInsets, windowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierConsumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier, (Function1) objRememberedValue6), windowInsets);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1019197171, "CC(remember):SearchBar.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState) | ((i3 & 14) == 4) | composerStartRestartGroup.changed(mutableState2);
            SearchBarKt$FullScreenSearchBarLayout$2$1 searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue = new SearchBarKt$FullScreenSearchBarLayout$2$1(mutableState, searchBarState, mutableWindowInsets, mutableState2);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) searchBarKt$FullScreenSearchBarLayout$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierConsumeWindowInsets);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM5069constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM5069constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1312429125, "C2461@113581L17,2458@113410L297,2471@113910L38,2467@113721L372,2478@114193L17,2477@114107L223:SearchBar.kt#uh7d8r");
            Modifier modifierPadding = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdInputField), WindowInsetsKt.asPaddingValues(WindowInsetsKt.m1250onlybOOhFvg(windowInsetsM1250onlybOOhFvg, WindowInsetsSides.INSTANCE.m1276getHorizontalJoeWqyM()), composerStartRestartGroup, 0));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5069constructorimpl2 = Updater.m5069constructorimpl(composerStartRestartGroup);
            Updater.m5077setimpl(composerM5069constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM5069constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM5069constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m5077setimpl(composerM5069constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 714795213, "C2464@113681L12:SearchBar.kt#uh7d8r");
            int i7 = i3 >> 6;
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i7 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SurfaceKt.m3531SurfaceT9BRK9s(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSurface), genericShape2, searchBarColors.m3323getContainerColor0d7_KjU(), ColorSchemeKt.m2664contentColorForek8zF_U(searchBarColors.m3323getContainerColor0d7_KjU(), composerStartRestartGroup, 0), f2, f3, null, ComposableSingletons$SearchBarKt.INSTANCE.m2706getLambda$1146652811$material3(), composerStartRestartGroup, (57344 & i7) | 12582918 | (i7 & 458752), 64);
            composer2 = composerStartRestartGroup;
            Modifier modifierPadding2 = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutIdSearchContent), WindowInsetsKt.asPaddingValues(windowInsetsM1250onlybOOhFvg, composer2, 0));
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierPadding2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer composerM5069constructorimpl3 = Updater.m5069constructorimpl(composer2);
            Updater.m5077setimpl(composerM5069constructorimpl3, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5077setimpl(composerM5069constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5069constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM5069constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM5069constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM5069constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m5077setimpl(composerM5069constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1748770687, "C2480@114244L46,2481@114307L9:SearchBar.kt#uh7d8r");
            DividerKt.m2850HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors.m3324getDividerColor0d7_KjU(), composer2, 0, 3);
            function3.invoke(columnScopeInstance, composer2, Integer.valueOf(6 | ((i3 >> 24) & 112)));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$70(searchBarState, predictiveBackState, function2, modifier, shape, searchBarColors, f2, f3, windowInsets, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape shape, Shape shape2, Density density, SearchBarState searchBarState, MutableState mutableState, Path path, Size size, LayoutDirection layoutDirection) {
        if (shape == RoundedCornerShapeKt.getCircleShape() && shape2 == RectangleShapeKt.getRectangleShape()) {
            float fMo488toPx0680j_4 = density.mo488toPx0680j_4(Dp.m8830constructorimpl(SearchBarCornerRadius * Math.max(1 - searchBarState.getProgress(), transform((BackEventProgress.InProgress) mutableState.getValue()))));
            if (fMo488toPx0680j_4 < 0.001d) {
                Path.addRect$default(path, SizeKt.m5813toRectuvyYCjk(size.m5797unboximpl()), null, 2, null);
            } else {
                Path.addRoundRect$default(path, RoundRectKt.m5778RoundRectsniSvfs(SizeKt.m5813toRectuvyYCjk(size.m5797unboximpl()), CornerRadius.m5677constructorimpl((((long) Float.floatToRawIntBits(fMo488toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo488toPx0680j_4)) & 4294967295L))), null, 2, null);
            }
        } else {
            if (searchBarState.getProgress() >= 0.5f) {
                shape = shape2;
            }
            OutlineKt.addOutline(path, shape.mo382createOutlinePq9zytI(size.m5797unboximpl(), layoutDirection, density));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float transform(BackEventProgress.InProgress inProgress) {
        if (inProgress == null) {
            return 0.0f;
        }
        return PredictiveBack.INSTANCE.transform$material3(inProgress.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect getCollapsedBounds(SearchBarState searchBarState) {
        IntRect intRectM8991IntRectVbeCjmY;
        LayoutCoordinates collapsedCoords = searchBarState.getCollapsedCoords();
        return (collapsedCoords == null || (intRectM8991IntRectVbeCjmY = IntRectKt.m8991IntRectVbeCjmY(IntOffsetKt.m8975roundk4lQ0M(LayoutCoordinatesKt.positionInWindow(collapsedCoords)), collapsedCoords.mo7453getSizeYbymL2g())) == null) ? IntRect.INSTANCE.getZero() : intRectM8991IntRectVbeCjmY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DetectClickFromInteractionSource(final InteractionSource interactionSource, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-652650823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DetectClickFromInteractionSource)N(interactionSource,onClick)2593@119695L148,2593@119661L182:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652650823, i2, -1, "androidx.compose.material3.DetectClickFromInteractionSource (SearchBar.kt:2592)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -132210195, "CC(remember):SearchBar.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            SearchBarKt$DetectClickFromInteractionSource$1$1 searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue = new SearchBarKt$DetectClickFromInteractionSource$1$1(interactionSource, function0, null);
                composerStartRestartGroup.updateRememberedValue(searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchBarKt$DetectClickFromInteractionSource$1$1RememberedValue, composerStartRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DetectClickFromInteractionSource$lambda$73(interactionSource, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat backEventCompat, float f2, float f3) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f3)) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        return f2 / f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetX-rOvwMX4, reason: not valid java name */
    public static final int m3365calculatePredictiveBackOffsetXrOvwMX4(long j, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f2, float f3) {
        if (backEventCompat == null || f3 == 0.0f) {
            return 0;
        }
        return MathKt.roundToInt(((Constraints.m8783getMaxWidthimpl(j) * SearchBarPredictiveBackMaxOffsetXRatio) - i) * (1 - f2) * f3 * (backEventCompat.getSwipeEdge() == 0 ? 1 : -1) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculatePredictiveBackOffsetY-dzo92Q0, reason: not valid java name */
    public static final int m3366calculatePredictiveBackOffsetYdzo92Q0(long j, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i2, int i3, float f2) {
        if (backEventCompat2 == null || backEventCompat == null || f2 == 0.0f) {
            return 0;
        }
        int iMin = Math.min(Math.max(0, ((Constraints.m8782getMaxHeightimpl(j) - i2) / 2) - i), i3);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float fAbs = Math.abs(touchY) / Constraints.m8782getMaxHeightimpl(j);
        return MathKt.roundToInt(MathHelpersKt.lerp(0, iMin, fAbs) * f2 * Math.signum(touchY));
    }

    static {
        float f2 = 8;
        SearchBarAsTopBarPadding = Dp.m8830constructorimpl(f2);
        SearchBarVerticalPadding = Dp.m8830constructorimpl(f2);
        SearchBarPredictiveBackMinMargin = Dp.m8830constructorimpl(f2);
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tweenSpecTween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tweenSpecTween;
        TweenSpec tweenSpecTween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tweenSpecTween2;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, cubicBezierEasing, 2, null);
        TweenSpec tweenSpecTween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tweenSpecTween3;
        TweenSpec tweenSpecTween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tweenSpecTween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tweenSpecTween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tweenSpecTween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tweenSpecTween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tweenSpecTween4, null, false, null, 14, null));
    }

    public static final float getSearchBarAsTopBarPadding() {
        return SearchBarAsTopBarPadding;
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$32(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$38(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55(State<? extends BackEventProgress> state) {
        return state.getValue();
    }
}
