package androidx.compose.foundation.style;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.border.BorderLogic;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.modifiers.TextStyleProviderNode;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.InnerShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: compiled from: StyleModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\"H\u0000¢\u0006\u0002\b?J\b\u0010@\u001a\u00020\"H\u0002J\b\u0010A\u001a\u00020\"H\u0002J#\u0010B\u001a\u00020C*\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\f\u0010K\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010L\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010X\u001a\u00020P*\u00020OH\u0002J#\u0010b\u001a\u00020a*\u00020c2\u0006\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020_H\u0002¢\u0006\u0004\bf\u0010gJ\f\u0010h\u001a\u00020P*\u00020cH\u0016J$\u0010p\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010p\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J$\u0010{\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010|\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010{\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J\u0080\u0001\u0010}\u001a\u00020P*\u00020c2\u0006\u0010e\u001a\u00020_2\u0006\u0010~\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u00102\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0082\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0087\u0001\u001a\u00030\u0082\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u0090\u0001\u001a\u00020P2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u0010J\t\u0010\u0092\u0001\u001a\u00020PH\u0016J\u0007\u0010\u0099\u0001\u001a\u00020PJ'\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030 \u0001H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0019\u0010¬\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0003\b\u00ad\u0001J\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0003\b±\u0001J\u0017\u0010²\u0001\u001a\u00020P2\u0006\u0010\u000b\u001a\u00020\"H\u0000¢\u0006\u0003\b³\u0001J\t\u0010´\u0001\u001a\u00020PH\u0002J\t\u0010µ\u0001\u001a\u00020PH\u0002J\t\u0010¶\u0001\u001a\u00020PH\u0016R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R-\u0010M\u001a\u0015\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0018\u00010N¢\u0006\u0002\bQX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR%\u0010V\u001a\u0013\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0N¢\u0006\u0002\bQ8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010SR\u0010\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010n\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u001a\u0010w\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010x\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010y\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010zR\u0017\u0010\u008d\u0001\u001a\u00020u8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u0010\u009a\u0001\u001a\u0003H\u009b\u0001\"\u0005\b\u0000\u0010\u009b\u0001*\n\u0012\u0005\u0012\u0003H\u009b\u00010\u009c\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0000\u0018\u00010§\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Landroidx/compose/foundation/style/StyleOuterNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Landroidx/compose/foundation/text/modifiers/TextStyleProviderNode;", "styleState", "Landroidx/compose/foundation/style/StyleState;", "style", "Landroidx/compose/foundation/style/Style;", "<init>", "(Landroidx/compose/foundation/style/StyleState;Landroidx/compose/foundation/style/Style;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "innerNodeField", "Landroidx/compose/foundation/style/StyleInnerNode;", "getInnerNodeField$foundation", "()Landroidx/compose/foundation/style/StyleInnerNode;", "setInnerNodeField$foundation", "(Landroidx/compose/foundation/style/StyleInnerNode;)V", "value", "innerNode", "getInnerNode$foundation", "setInnerNode$foundation", "getStyle$foundation", "()Landroidx/compose/foundation/style/Style;", "setStyle$foundation", "(Landroidx/compose/foundation/style/Style;)V", "_resolved", "Landroidx/compose/foundation/style/ResolvedStyle;", "_bufferOrNull", "bufferNonNull", "getBufferNonNull", "()Landroidx/compose/foundation/style/ResolvedStyle;", "animations", "Landroidx/compose/foundation/style/StyleAnimations;", "getAnimations$foundation", "()Landroidx/compose/foundation/style/StyleAnimations;", "setAnimations$foundation", "(Landroidx/compose/foundation/style/StyleAnimations;)V", "borderLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "borderLayerProvider", "Lkotlin/Function0;", "borderLogic", "Landroidx/compose/foundation/border/BorderLogic;", "_state", "currentInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "state", "getState$foundation", "()Landroidx/compose/foundation/style/StyleState;", "setState$foundation", "(Landroidx/compose/foundation/style/StyleState;)V", "resolveAnimatedStyleFor", "flags", "", "base", "resolveAnimatedStyleFor$foundation", "currentLayerStyle", "currentLayoutStyle", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "shouldPlaceRelativeToRight", "shouldPlaceRelativeToBottom", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getLayerBlock$foundation", "()Lkotlin/jvm/functions/Function1;", "setLayerBlock$foundation", "(Lkotlin/jvm/functions/Function1;)V", "layerBlockNonNull", "getLayerBlockNonNull$foundation", "updateLayer", "lastSize", "Landroidx/compose/ui/geometry/Size;", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastShape", "Landroidx/compose/ui/graphics/Shape;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "getOutline", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "size", "shape", "getOutline-12SF9DM", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Outline;", "draw", "lastInnerShadow", "", "Landroidx/compose/ui/graphics/shadow/Shadow;", "[Landroidx/compose/ui/graphics/shadow/Shadow;", "cachedInnerShadowPainters", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "drawInnerShadow", FirebaseAnalytics.Param.INDEX, "shadow", "reconcileInnerShadowCache", "shadowOrArray", "", "resolved", "lastDropShadow", "cachedDropShadowPainters", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "drawDropShadow", "reconcileDropShadowCache", "drawForShape", "hasBackground", "hasBorder", "hasForeground", "bgColor", "Landroidx/compose/ui/graphics/Color;", "bgBrush", "Landroidx/compose/ui/graphics/Brush;", "borderColor", "borderBrush", "foregroundColor", "foregroundBrush", "borderWidth", "", "drawForShape-9zt3ed4", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/ui/graphics/Shape;ZZZJLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;F)V", "traverseKey", "getTraverseKey", "()Ljava/lang/Object;", "resolveStyleAndInvalidate", "initial", "onObservedReadsChanged", "sourceJob", "Lkotlinx/coroutines/Job;", "getSourceJob", "()Lkotlinx/coroutines/Job;", "setSourceJob", "(Lkotlinx/coroutines/Job;)V", "updateInteractionSources", "currentValue", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "computeInheritedTextStyle", "Landroidx/compose/ui/text/TextStyle;", TypedValues.CycleType.S_WAVE_PHASE, "Landroidx/compose/foundation/text/modifiers/StylePhase;", FallbackIndicationElement.ELEMENT, "computeInheritedTextStyle-B-LjeIk", "(ILandroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "ancestorNodes", "Landroidx/collection/MutableObjectList;", "getAncestorNodes$foundation", "()Landroidx/collection/MutableObjectList;", "setAncestorNodes$foundation", "(Landroidx/collection/MutableObjectList;)V", "resolveInheritedStyle", "resolveInheritedStyle$foundation", "cachedInheritedStyle", "inheritedStyleDirty", "getCachedInheritedStyle", "getCachedInheritedStyle$foundation", "saveInheritedStyles", "saveInheritedStyles$foundation", "invalidateTextLayout", "invalidateTextDraw", "onDetach", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StyleOuterNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, CompositionLocalAccessorScope, TextStyleProviderNode {
    public static final int $stable = 8;
    private ResolvedStyle _bufferOrNull;
    private StyleState _state;
    private MutableObjectList<StyleOuterNode> ancestorNodes;
    private StyleAnimations animations;
    private GraphicsLayer borderLayer;
    private Function0<GraphicsLayer> borderLayerProvider;
    private DropShadowPainter[] cachedDropShadowPainters;
    private ResolvedStyle cachedInheritedStyle;
    private InnerShadowPainter[] cachedInnerShadowPainters;
    private InteractionSource currentInteractionSource;
    private boolean inheritedStyleDirty;
    private StyleInnerNode innerNodeField;
    private Shadow[] lastDropShadow;
    private Shadow[] lastInnerShadow;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Job sourceJob;
    private Style style;
    private ResolvedStyle _resolved = new ResolvedStyle();
    private final BorderLogic borderLogic = new BorderLogic();

    /* JADX INFO: Access modifiers changed from: private */
    public static final float drawForShape_9zt3ed4$lambda$0(float f2) {
        return f2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public StyleOuterNode(MutableStyleState mutableStyleState, Style style) {
        this.style = style;
        this._state = mutableStyleState == null ? new MutableStyleState(null) : mutableStyleState;
        this.lastSize = Size.INSTANCE.m5800getUnspecifiedNHjbRc();
    }

    /* JADX INFO: renamed from: getInnerNodeField$foundation, reason: from getter */
    public final StyleInnerNode getInnerNodeField() {
        return this.innerNodeField;
    }

    public final void setInnerNodeField$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    public final StyleInnerNode getInnerNode$foundation() {
        StyleInnerNode styleInnerNode = this.innerNodeField;
        if (styleInnerNode != null) {
            return styleInnerNode;
        }
        throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode".toString());
    }

    public final void setInnerNode$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    /* JADX INFO: renamed from: getStyle$foundation, reason: from getter */
    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle$foundation(Style style) {
        this.style = style;
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    private final ResolvedStyle getBufferNonNull() {
        if (this._bufferOrNull == null) {
            this._bufferOrNull = new ResolvedStyle();
        }
        ResolvedStyle resolvedStyle = this._bufferOrNull;
        Intrinsics.checkNotNull(resolvedStyle);
        return resolvedStyle;
    }

    /* JADX INFO: renamed from: getAnimations$foundation, reason: from getter */
    public final StyleAnimations getAnimations() {
        return this.animations;
    }

    public final void setAnimations$foundation(StyleAnimations styleAnimations) {
        this.animations = styleAnimations;
    }

    /* JADX INFO: renamed from: getState$foundation, reason: from getter */
    public final StyleState get_state() {
        return this._state;
    }

    public final void setState$foundation(StyleState styleState) {
        if (Intrinsics.areEqual(this._state, styleState)) {
            return;
        }
        this._state = styleState;
        resolveStyleAndInvalidate$default(this, false, 1, null);
        LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
    }

    public static /* synthetic */ ResolvedStyle resolveAnimatedStyleFor$foundation$default(StyleOuterNode styleOuterNode, int i, ResolvedStyle resolvedStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            resolvedStyle = styleOuterNode._resolved;
        }
        return styleOuterNode.resolveAnimatedStyleFor$foundation(i, resolvedStyle);
    }

    public final ResolvedStyle resolveAnimatedStyleFor$foundation(int flags, ResolvedStyle base) {
        StyleAnimations styleAnimations = this.animations;
        return (styleAnimations == null || !styleAnimations.isNotEmpty()) ? base : styleAnimations.withAnimations(DelegatableNodeKt.requireDensity(this), base, this, flags);
    }

    private final ResolvedStyle currentLayerStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 4, null, 2, null);
    }

    private final ResolvedStyle currentLayoutStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 8, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.MeasureResult mo72measure3p2s80s(androidx.compose.ui.layout.MeasureScope r19, androidx.compose.ui.layout.Measurable r20, final long r21) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.style.StyleOuterNode.mo72measure3p2s80s(androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, long):androidx.compose.ui.layout.MeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(StyleOuterNode styleOuterNode, long j, Placeable placeable, float f2, float f3, float f4, float f5, Placeable.PlacementScope placementScope) {
        int iRound;
        int iRound2;
        ResolvedStyle resolvedStyleCurrentLayoutStyle = styleOuterNode.currentLayoutStyle();
        if (styleOuterNode.shouldPlaceRelativeToRight(resolvedStyleCurrentLayoutStyle)) {
            iRound = (Constraints.m8783getMaxWidthimpl(j) - placeable.getWidth()) - Math.round(f2);
        } else {
            iRound = Math.round(f3);
        }
        int i = iRound;
        if (styleOuterNode.shouldPlaceRelativeToBottom(resolvedStyleCurrentLayoutStyle)) {
            iRound2 = (Constraints.m8782getMaxHeightimpl(j) - placeable.getHeight()) - Math.round(f4);
        } else {
            iRound2 = Math.round(f5);
        }
        int i2 = iRound2;
        if ((resolvedStyleCurrentLayoutStyle.flags & 4) != 0) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, i, i2, 0.0f, styleOuterNode.getLayerBlockNonNull$foundation(), 4, (Object) null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldPlaceRelativeToRight(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getRight()) && Float.isNaN(resolvedStyle.getLeft());
    }

    private final boolean shouldPlaceRelativeToBottom(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getBottom()) && Float.isNaN(resolvedStyle.getTop());
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock$foundation() {
        return this.layerBlock;
    }

    public final void setLayerBlock$foundation(Function1<? super GraphicsLayerScope, Unit> function1) {
        this.layerBlock = function1;
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlockNonNull$foundation() {
        Function1 function1 = this.layerBlock;
        if (function1 != null) {
            return function1;
        }
        Function1<GraphicsLayerScope, Unit> function12 = new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleOuterNode._get_layerBlockNonNull_$lambda$0$0(this.f$0, (GraphicsLayerScope) obj);
            }
        };
        this.layerBlock = function12;
        return function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_layerBlockNonNull_$lambda$0$0(StyleOuterNode styleOuterNode, GraphicsLayerScope graphicsLayerScope) {
        styleOuterNode.updateLayer(graphicsLayerScope);
        return Unit.INSTANCE;
    }

    private final void updateLayer(GraphicsLayerScope graphicsLayerScope) {
        ResolvedStyle resolvedStyleCurrentLayerStyle = currentLayerStyle();
        graphicsLayerScope.setAlpha(resolvedStyleCurrentLayerStyle.getAlpha());
        graphicsLayerScope.setScaleX(resolvedStyleCurrentLayerStyle.getScaleX());
        graphicsLayerScope.setScaleY(resolvedStyleCurrentLayerStyle.getScaleY());
        graphicsLayerScope.setTranslationX(resolvedStyleCurrentLayerStyle.getTranslationX());
        graphicsLayerScope.setTranslationY(resolvedStyleCurrentLayerStyle.getTranslationY());
        graphicsLayerScope.setRotationX(resolvedStyleCurrentLayerStyle.getRotationX());
        graphicsLayerScope.setRotationY(resolvedStyleCurrentLayerStyle.getRotationY());
        graphicsLayerScope.setRotationZ(resolvedStyleCurrentLayerStyle.getRotationZ());
        graphicsLayerScope.mo6171setTransformOrigin__ExYCQ(resolvedStyleCurrentLayerStyle.getTransformOrigin());
        graphicsLayerScope.setClip(resolvedStyleCurrentLayerStyle.getClip());
        graphicsLayerScope.setShape(resolvedStyleCurrentLayerStyle.getShape());
    }

    /* JADX INFO: renamed from: getOutline-12SF9DM, reason: not valid java name */
    private final Outline m1625getOutline12SF9DM(ContentDrawScope contentDrawScope, long j, Shape shape) {
        Outline outlineMo382createOutlinePq9zytI;
        if (Size.m5788equalsimpl0(this.lastSize, j) && this.lastLayoutDirection == contentDrawScope.getLayoutDirection() && Intrinsics.areEqual(this.lastShape, shape)) {
            outlineMo382createOutlinePq9zytI = this.lastOutline;
            Intrinsics.checkNotNull(outlineMo382createOutlinePq9zytI);
        } else {
            outlineMo382createOutlinePq9zytI = shape.mo382createOutlinePq9zytI(j, contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        this.lastOutline = outlineMo382createOutlinePq9zytI;
        this.lastSize = j;
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        return outlineMo382createOutlinePq9zytI;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Shape shape;
        boolean z;
        Shape shape2;
        boolean z2;
        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = resolveAnimatedStyleFor$foundation$default(this, 2, null, 2, null);
        long backgroundColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBackgroundColor();
        Brush backgroundBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBackgroundBrush();
        long foregroundColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getForegroundColor();
        Brush foregroundBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getForegroundBrush();
        long borderColor = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderColor();
        Brush borderBrush = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderBrush();
        float borderWidth = resolvedStyleResolveAnimatedStyleFor$foundation$default.getBorderWidth();
        float f2 = borderWidth / 2.0f;
        Shape shape3 = resolvedStyleResolveAnimatedStyleFor$foundation$default.getShape();
        boolean z3 = true;
        if (f2 > 0.0f) {
            shape = shape3;
            z = true;
        } else {
            shape = shape3;
            z = false;
        }
        if (backgroundColor == 16 && backgroundBrush == null) {
            shape2 = shape;
            z2 = false;
        } else {
            shape2 = shape;
            z2 = true;
        }
        if (foregroundColor == 16 && foregroundBrush == null) {
            z3 = false;
        }
        drawDropShadow(contentDrawScope, resolvedStyleResolveAnimatedStyleFor$foundation$default);
        Shape shape4 = shape2;
        m1627drawForShape9zt3ed4(contentDrawScope, shape4, z2, z, z3, backgroundColor, backgroundBrush, borderColor, borderBrush, foregroundColor, foregroundBrush, borderWidth);
        drawInnerShadow(contentDrawScope, resolvedStyleResolveAnimatedStyleFor$foundation$default);
        this.lastShape = shape4;
    }

    private final void drawInnerShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastInnerShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        InnerShadowPainter[] innerShadowPainterArr = this.cachedInnerShadowPainters;
        InnerShadowPainter innerShadowPainterCreateInnerShadowPainter = innerShadowPainterArr != null ? (InnerShadowPainter) ArraysKt.getOrNull(innerShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || innerShadowPainterCreateInnerShadowPainter == null) {
            innerShadowPainterCreateInnerShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createInnerShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastInnerShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        if (innerShadowPainterArr2 != null) {
            innerShadowPainterArr2[i] = innerShadowPainterCreateInnerShadowPainter;
        }
        Painter.m6674drawx_KDEd0$default(innerShadowPainterCreateInnerShadowPainter, contentDrawScope, contentDrawScope.mo6549getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void reconcileInnerShadowCache(java.lang.Object r6, androidx.compose.ui.graphics.Shape r7) {
        /*
            r5 = this;
            androidx.compose.ui.graphics.shadow.Shadow[] r0 = r5.lastInnerShadow
            androidx.compose.ui.graphics.shadow.InnerShadowPainter[] r1 = r5.cachedInnerShadowPainters
            boolean r2 = r6 instanceof java.lang.Object[]
            if (r2 == 0) goto Lc
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            int r6 = r6.length
            goto Ld
        Lc:
            r6 = 1
        Ld:
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L43
            androidx.compose.ui.graphics.Shape r4 = r5.lastShape
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r7 != 0) goto L1a
            goto L43
        L1a:
            int r7 = r0.length
            if (r7 == r6) goto L42
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r0, r6)
            java.lang.String r0 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            androidx.compose.ui.graphics.shadow.Shadow[] r7 = (androidx.compose.ui.graphics.shadow.Shadow[]) r7
            r5.lastInnerShadow = r7
            if (r1 == 0) goto L37
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r1, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            androidx.compose.ui.graphics.shadow.InnerShadowPainter[] r7 = (androidx.compose.ui.graphics.shadow.InnerShadowPainter[]) r7
            if (r7 != 0) goto L40
        L37:
            androidx.compose.ui.graphics.shadow.InnerShadowPainter[] r7 = new androidx.compose.ui.graphics.shadow.InnerShadowPainter[r6]
        L39:
            if (r3 >= r6) goto L40
            r7[r3] = r2
            int r3 = r3 + 1
            goto L39
        L40:
            r5.cachedInnerShadowPainters = r7
        L42:
            return
        L43:
            androidx.compose.ui.graphics.shadow.Shadow[] r7 = new androidx.compose.ui.graphics.shadow.Shadow[r6]
            r0 = r3
        L46:
            if (r0 >= r6) goto L4d
            r7[r0] = r2
            int r0 = r0 + 1
            goto L46
        L4d:
            r5.lastInnerShadow = r7
            androidx.compose.ui.graphics.shadow.InnerShadowPainter[] r7 = new androidx.compose.ui.graphics.shadow.InnerShadowPainter[r6]
        L51:
            if (r3 >= r6) goto L58
            r7[r3] = r2
            int r3 = r3 + 1
            goto L51
        L58:
            r5.cachedInnerShadowPainters = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.style.StyleOuterNode.reconcileInnerShadowCache(java.lang.Object, androidx.compose.ui.graphics.Shape):void");
    }

    public final void drawInnerShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object innerShadow = resolvedStyle.getInnerShadow();
        if (innerShadow == null) {
            return;
        }
        Shape shape = resolvedStyle.getShape();
        reconcileInnerShadowCache(innerShadow, shape);
        if (innerShadow instanceof Object[]) {
            Object[] objArr = (Object[]) innerShadow;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawInnerShadow(contentDrawScope, i, shape, (Shadow) obj);
                }
            }
            return;
        }
        if (innerShadow instanceof Shadow) {
            drawInnerShadow(contentDrawScope, 0, shape, (Shadow) innerShadow);
        }
    }

    private final void drawDropShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastDropShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        DropShadowPainter[] dropShadowPainterArr = this.cachedDropShadowPainters;
        DropShadowPainter dropShadowPainterCreateDropShadowPainter = dropShadowPainterArr != null ? (DropShadowPainter) ArraysKt.getOrNull(dropShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || dropShadowPainterCreateDropShadowPainter == null) {
            dropShadowPainterCreateDropShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastDropShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        if (dropShadowPainterArr2 != null) {
            dropShadowPainterArr2[i] = dropShadowPainterCreateDropShadowPainter;
        }
        Painter.m6674drawx_KDEd0$default(dropShadowPainterCreateDropShadowPainter, contentDrawScope, contentDrawScope.mo6549getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void reconcileDropShadowCache(java.lang.Object r6, androidx.compose.ui.graphics.Shape r7) {
        /*
            r5 = this;
            androidx.compose.ui.graphics.shadow.Shadow[] r0 = r5.lastDropShadow
            androidx.compose.ui.graphics.shadow.DropShadowPainter[] r1 = r5.cachedDropShadowPainters
            boolean r2 = r6 instanceof java.lang.Object[]
            if (r2 == 0) goto Lc
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            int r6 = r6.length
            goto Ld
        Lc:
            r6 = 1
        Ld:
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L43
            androidx.compose.ui.graphics.Shape r4 = r5.lastShape
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r7)
            if (r7 != 0) goto L1a
            goto L43
        L1a:
            int r7 = r0.length
            if (r7 == r6) goto L42
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r0, r6)
            java.lang.String r0 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            androidx.compose.ui.graphics.shadow.Shadow[] r7 = (androidx.compose.ui.graphics.shadow.Shadow[]) r7
            r5.lastDropShadow = r7
            if (r1 == 0) goto L37
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r1, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            androidx.compose.ui.graphics.shadow.DropShadowPainter[] r7 = (androidx.compose.ui.graphics.shadow.DropShadowPainter[]) r7
            if (r7 != 0) goto L40
        L37:
            androidx.compose.ui.graphics.shadow.DropShadowPainter[] r7 = new androidx.compose.ui.graphics.shadow.DropShadowPainter[r6]
        L39:
            if (r3 >= r6) goto L40
            r7[r3] = r2
            int r3 = r3 + 1
            goto L39
        L40:
            r5.cachedDropShadowPainters = r7
        L42:
            return
        L43:
            androidx.compose.ui.graphics.shadow.Shadow[] r7 = new androidx.compose.ui.graphics.shadow.Shadow[r6]
            r0 = r3
        L46:
            if (r0 >= r6) goto L4d
            r7[r0] = r2
            int r0 = r0 + 1
            goto L46
        L4d:
            r5.lastDropShadow = r7
            androidx.compose.ui.graphics.shadow.DropShadowPainter[] r7 = new androidx.compose.ui.graphics.shadow.DropShadowPainter[r6]
        L51:
            if (r3 >= r6) goto L58
            r7[r3] = r2
            int r3 = r3 + 1
            goto L51
        L58:
            r5.cachedDropShadowPainters = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.style.StyleOuterNode.reconcileDropShadowCache(java.lang.Object, androidx.compose.ui.graphics.Shape):void");
    }

    public final void drawDropShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object dropShadow = resolvedStyle.getDropShadow();
        if (dropShadow == null) {
            return;
        }
        Shape shape = resolvedStyle.getShape();
        reconcileDropShadowCache(dropShadow, shape);
        if (dropShadow instanceof Object[]) {
            Object[] objArr = (Object[]) dropShadow;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawDropShadow(contentDrawScope, i, shape, (Shadow) obj);
                }
            }
            return;
        }
        if (dropShadow instanceof Shadow) {
            drawDropShadow(contentDrawScope, 0, shape, (Shadow) dropShadow);
        }
    }

    /* JADX INFO: renamed from: drawForShape-9zt3ed4, reason: not valid java name */
    public final void m1627drawForShape9zt3ed4(ContentDrawScope contentDrawScope, Shape shape, boolean z, boolean z2, boolean z3, long j, Brush brush, long j2, Brush brush2, long j3, Brush brush3, final float f2) {
        Outline outlineM1625getOutline12SF9DM = m1625getOutline12SF9DM(contentDrawScope, contentDrawScope.mo6549getSizeNHjbRc(), shape);
        if (z) {
            if (brush != null) {
                OutlineKt.m6241drawOutlinehn5TExg$default(contentDrawScope, outlineM1625getOutline12SF9DM, brush, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m6243drawOutlinewDX37Ww$default(contentDrawScope, outlineM1625getOutline12SF9DM, j, 0.0f, null, null, 0, 60, null);
            }
        }
        contentDrawScope.drawContent();
        if (z3) {
            if (brush3 != null) {
                OutlineKt.m6241drawOutlinehn5TExg$default(contentDrawScope, outlineM1625getOutline12SF9DM, brush3, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m6243drawOutlinewDX37Ww$default(contentDrawScope, outlineM1625getOutline12SF9DM, j3, 0.0f, null, null, 0, 60, null);
            }
        }
        if (z2) {
            SolidColor solidColor = brush2 == null ? new SolidColor(j2, null) : brush2;
            BorderLogic borderLogic = this.borderLogic;
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(StyleOuterNode.drawForShape_9zt3ed4$lambda$0(f2));
                }
            };
            Function0<GraphicsLayer> function02 = this.borderLayerProvider;
            if (function02 == null) {
                function02 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StyleOuterNode.drawForShape_9zt3ed4$lambda$1(this.f$0);
                    }
                };
                this.borderLayerProvider = function02;
                Unit unit = Unit.INSTANCE;
            }
            borderLogic.m428drawBorder2gY9BTk$foundation(contentDrawScope2, function0, solidColor, function02, outlineM1625getOutline12SF9DM, (32 & 32) != 0 ? Offset.INSTANCE.m5739getZeroF1C5BW0() : 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GraphicsLayer drawForShape_9zt3ed4$lambda$1(StyleOuterNode styleOuterNode) {
        GraphicsLayer graphicsLayer = styleOuterNode.borderLayer;
        if (graphicsLayer != null) {
            return graphicsLayer;
        }
        GraphicsLayer graphicsLayerCreateGraphicsLayer = DelegatableNodeKt.requireGraphicsContext(styleOuterNode).createGraphicsLayer();
        styleOuterNode.borderLayer = graphicsLayerCreateGraphicsLayer;
        return graphicsLayerCreateGraphicsLayer;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return StyleModifierKt.OuterNodeKey;
    }

    public static /* synthetic */ void resolveStyleAndInvalidate$default(StyleOuterNode styleOuterNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        styleOuterNode.resolveStyleAndInvalidate(z);
    }

    public final void resolveStyleAndInvalidate(final boolean initial) {
        if (getIsAttached()) {
            final ResolvedStyle resolvedStyle = initial ? null : this._resolved;
            final ResolvedStyle bufferNonNull = initial ? this._resolved : getBufferNonNull();
            final Density densityRequireDensity = DelegatableNodeKt.requireDensity(this);
            bufferNonNull.clear$foundation();
            StyleAnimations styleAnimations = this.animations;
            if (styleAnimations != null) {
                styleAnimations.preResolve();
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StyleOuterNode.resolveStyleAndInvalidate$lambda$0(bufferNonNull, this, densityRequireDensity, resolvedStyle, intRef, initial);
                }
            });
            int iDiff$foundation$default = intRef.element | (resolvedStyle != null ? ResolvedStyle.diff$foundation$default(resolvedStyle, bufferNonNull, 0, 2, null) : bufferNonNull.flags);
            if (!Intrinsics.areEqual(this._state.getInteractionSource(), this.currentInteractionSource)) {
                updateInteractionSources();
            }
            if (initial) {
                return;
            }
            if ((iDiff$foundation$default & 1) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(getInnerNode$foundation());
            }
            if ((iDiff$foundation$default & 8) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
            }
            if ((iDiff$foundation$default & 2) != 0) {
                LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
            }
            if ((iDiff$foundation$default & 4) != 0) {
                LayoutModifierNodeKt.updateLayerBlock(this, getLayerBlockNonNull$foundation());
            }
            if ((iDiff$foundation$default & 32) != 0) {
                invalidateTextLayout();
            }
            if ((iDiff$foundation$default & 64) != 0) {
                invalidateTextDraw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveStyleAndInvalidate$lambda$0(ResolvedStyle resolvedStyle, StyleOuterNode styleOuterNode, Density density, ResolvedStyle resolvedStyle2, Ref.IntRef intRef, boolean z) {
        resolvedStyle.resolve$foundation(styleOuterNode.style, styleOuterNode, density, false);
        styleOuterNode._resolved = resolvedStyle;
        styleOuterNode._bufferOrNull = resolvedStyle2;
        StyleAnimations styleAnimations = styleOuterNode.animations;
        intRef.element = styleAnimations != null ? styleAnimations.postResolve(styleOuterNode, density, !z) : 0;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    public final Job getSourceJob() {
        return this.sourceJob;
    }

    public final void setSourceJob(Job job) {
        this.sourceJob = job;
    }

    public final void updateInteractionSources() {
        Job job = this.sourceJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        InteractionSource interactionSource = this._state.getInteractionSource();
        this.currentInteractionSource = interactionSource;
        if (interactionSource != null) {
            this.sourceJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(interactionSource, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.style.StyleOuterNode$updateInteractionSources$1, reason: invalid class name */
    /* JADX INFO: compiled from: StyleModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.style.StyleOuterNode$updateInteractionSources$1", f = "StyleModifier.kt", i = {}, l = {715}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InteractionSource $source;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InteractionSource interactionSource, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$source = interactionSource;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StyleOuterNode.this.new AnonymousClass1(this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (StyleOuterNode.this._state.processInteractions$foundation(this.$source, this) == coroutine_suspended) {
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
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public <T> T getCurrentValue(CompositionLocal<T> compositionLocal) {
        return (T) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, compositionLocal);
    }

    @Override // androidx.compose.foundation.text.modifiers.TextStyleProviderNode
    /* JADX INFO: renamed from: computeInheritedTextStyle-B-LjeIk, reason: not valid java name */
    public TextStyle mo1626computeInheritedTextStyleBLjeIk(int phase, TextStyle fallback) {
        TextStyle textStyle$foundation;
        ResolvedStyle resolvedStyleResolveInheritedStyle$foundation = resolveInheritedStyle$foundation(StyleModifierKt.m1623toFlagsuwmK9pY(phase));
        return (resolvedStyleResolveInheritedStyle$foundation == null || (textStyle$foundation = resolvedStyleResolveInheritedStyle$foundation.toTextStyle$foundation(fallback)) == null) ? fallback : textStyle$foundation;
    }

    public final MutableObjectList<StyleOuterNode> getAncestorNodes$foundation() {
        return this.ancestorNodes;
    }

    public final void setAncestorNodes$foundation(MutableObjectList<StyleOuterNode> mutableObjectList) {
        this.ancestorNodes = mutableObjectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, androidx.collection.MutableObjectList, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.style.ResolvedStyle resolveInheritedStyle$foundation(int r18) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.style.StyleOuterNode.resolveInheritedStyle$foundation(int):androidx.compose.foundation.style.ResolvedStyle");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, androidx.collection.MutableObjectList, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    public static final boolean resolveInheritedStyle$lambda$1(Ref.ObjectRef objectRef, StyleOuterNode styleOuterNode, TraversableNode traversableNode) {
        StyleAnimations styleAnimations;
        if (!(traversableNode instanceof StyleOuterNode)) {
            return true;
        }
        StyleOuterNode styleOuterNode2 = (StyleOuterNode) traversableNode;
        if ((styleOuterNode2._resolved.flags & 96) != 0 || ((styleAnimations = styleOuterNode2.animations) != null && styleAnimations.isNotEmpty())) {
            MutableObjectList mutableObjectList = (MutableObjectList) objectRef.element;
            MutableObjectList mutableObjectList2 = mutableObjectList;
            if (mutableObjectList == null) {
                ?? mutableObjectList3 = new MutableObjectList(0, 1, null);
                objectRef.element = mutableObjectList3;
                styleOuterNode.ancestorNodes = mutableObjectList3;
                mutableObjectList2 = mutableObjectList3;
            }
            mutableObjectList2.add(traversableNode);
        }
        return true;
    }

    public final ResolvedStyle getCachedInheritedStyle$foundation() {
        if (this.inheritedStyleDirty) {
            return null;
        }
        return this.cachedInheritedStyle;
    }

    public final void saveInheritedStyles$foundation(ResolvedStyle style) {
        this.inheritedStyleDirty = false;
        this.cachedInheritedStyle = style;
    }

    private final void invalidateTextLayout() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateMeasurementForSubtree(this);
    }

    private final void invalidateTextDraw() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateDrawForSubtree(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        GraphicsLayer graphicsLayer = this.borderLayer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
            this.borderLayer = null;
        }
        this.borderLayerProvider = null;
    }
}
