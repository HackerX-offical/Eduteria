package androidx.compose.ui.node;

import android.os.Trace;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.tooling.ComposeToolingFlags;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.message_correct.element.MessageCorrectExtension;

/* JADX INFO: compiled from: MeasurePassDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010$\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010b\u001a\u000200H\u0000¢\u0006\u0002\bcJ\b\u0010l\u001a\u000200H\u0016J\b\u0010m\u001a\u000200H\u0002J\b\u0010n\u001a\u000200H\u0002J\b\u0010o\u001a\u000200H\u0002J\r\u0010y\u001a\u000200H\u0000¢\u0006\u0002\bzJ\b\u0010{\u001a\u000200H\u0002J\u001d\u0010|\u001a\u0002002\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002000.H\u0082\bJ\u001a\u0010~\u001a\u0002002\u0006\u0010\u007f\u001a\u00020\u0017H\u0080\b¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001a\u0010\u0082\u0001\u001a\u00020\u00022\u0006\u0010\u007f\u001a\u00020\u0017H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0018\u0010\u0085\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\u0017¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0012\u0010\u0088\u0001\u001a\u0002002\u0007\u0010\u0089\u0001\u001a\u00020\u001bH\u0002J\u0014\u0010\u008e\u0001\u001a\u00020\f2\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001H\u0096\u0002J?\u0010\u0091\u0001\u001a\u0002002\u0007\u0010\u0092\u0001\u001a\u00020(2\u0006\u0010p\u001a\u0002052\u001a\u0010\u0093\u0001\u001a\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1H\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J,\u0010\u0091\u0001\u001a\u0002002\u0007\u0010\u0092\u0001\u001a\u00020(2\u0006\u0010p\u001a\u0002052\u0007\u0010\u0096\u0001\u001a\u000203H\u0014¢\u0006\u0006\b\u0094\u0001\u0010\u0097\u0001J\u0012\u0010\u009b\u0001\u001a\u0002002\u0007\u0010\u009c\u0001\u001a\u00020\nH\u0016JJ\u0010\u009d\u0001\u001a\u0002002\u0007\u0010\u0092\u0001\u001a\u00020(2\u0006\u0010p\u001a\u0002052\u001a\u0010\u0093\u0001\u001a\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b12\t\u0010\u0096\u0001\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001JJ\u0010 \u0001\u001a\u0002002\u0007\u0010\u0092\u0001\u001a\u00020(2\u0006\u0010p\u001a\u0002052\u001a\u0010\u0093\u0001\u001a\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b12\t\u0010\u0096\u0001\u001a\u0004\u0018\u000103H\u0002¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J\u0007\u0010¢\u0001\u001a\u000200J\u0012\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\fH\u0016J\u0012\u0010¥\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\fH\u0016J\u0012\u0010¦\u0001\u001a\u00020\f2\u0007\u0010§\u0001\u001a\u00020\fH\u0016J\u0012\u0010¨\u0001\u001a\u00020\f2\u0007\u0010§\u0001\u001a\u00020\fH\u0016J\t\u0010©\u0001\u001a\u000200H\u0002J\u0007\u0010ª\u0001\u001a\u000200J\u0007\u0010«\u0001\u001a\u00020\nJ\u0017\u0010¬\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0090\u0001\u0012\u0004\u0012\u00020\f0\u00ad\u0001H\u0016J\u001d\u0010±\u0001\u001a\u0002002\u0012\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002000.H\u0016J\t\u0010²\u0001\u001a\u000200H\u0016J\t\u0010³\u0001\u001a\u000200H\u0016J\u0007\u0010´\u0001\u001a\u000200J\t\u0010µ\u0001\u001a\u000200H\u0002J\u0010\u0010¶\u0001\u001a\u0002002\u0007\u0010·\u0001\u001a\u00020\nJ\u0007\u0010¸\u0001\u001a\u000200J\u0007\u0010¹\u0001\u001a\u000200J\u000f\u0010º\u0001\u001a\u000200H\u0000¢\u0006\u0003\b»\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010'R \u0010)\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020(@BX\u0080\u000e¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R!\u0010-\u001a\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\u0004\u0018\u0001072\b\u0010\u000b\u001a\u0004\u0018\u000107@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010'R$\u0010B\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010'R\u001e\u0010D\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0015R\u001e\u0010F\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0015R\u000e\u0010H\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010J\u001a\u00020I2\u0006\u0010\u000b\u001a\u00020I8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010RR\u0014\u0010U\u001a\u00020VX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010'R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00000_8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001e\u0010d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0015R\u0010\u0010f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u0002000hX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\b\u0012\u0004\u0012\u0002000hX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010p\u001a\u0002052\u0006\u0010\u000b\u001a\u000205@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u000e\u0010s\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010t\u001a\u0015\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0018\u00010.¢\u0006\u0002\b1X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010w\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010x\u001a\b\u0012\u0004\u0012\u0002000hX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u008a\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u0010\u000fR\u0016\u0010\u008c\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u0010\u000fR\u000f\u0010\u0098\u0001\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0099\u0001\u001a\u00020\nX\u0096\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0015\"\u0005\b\u009a\u0001\u0010'R\u0019\u0010®\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001¨\u0006¼\u0001"}, d2 = {"Landroidx/compose/ui/node/MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "layoutNodeLayoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "relayoutWithoutParentInProgress", "", "value", "", "previousPlaceOrder", "getPreviousPlaceOrder$ui", "()I", "placeOrder", "getPlaceOrder", "measuredOnce", "placedOnce", "getPlacedOnce", "()Z", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui", "setDuringAlignmentLinesQuery$ui", "(Z)V", "Landroidx/compose/ui/unit/IntOffset;", "lastPosition", "getLastPosition-nOcc-ac$ui", "()J", "J", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastZIndex", "", "parentDataDirty", "", "parentData", "getParentData", "()Ljava/lang/Object;", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LookaheadPassDelegate;", "isPlaced", "isPlaced$ui", "setPlaced$ui", "isPlacedByParent", "setPlacedByParent$ui", "measurePending", "getMeasurePending$ui", "layoutPending", "getLayoutPending$ui", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "setLayoutState", "(Landroidx/compose/ui/node/LayoutNode$LayoutState;)V", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", "getInnerCoordinator", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui", "setChildDelegatesDirty$ui", "childDelegates", "", "getChildDelegates$ui", "()Ljava/util/List;", "markDetachedFromParentLookaheadPass", "markDetachedFromParentLookaheadPass$ui", "layingOutChildren", "getLayingOutChildren", "performMeasureConstraints", "performMeasureBlock", "Lkotlin/Function0;", "getPerformMeasureBlock$ui", "()Lkotlin/jvm/functions/Function0;", "layoutChildrenBlock", "layoutChildren", "checkChildrenPlaceOrderForUpdates", "markSubtreeAsNotPlaced", "markNodeAndSubtreeAsPlaced", "zIndex", "getZIndex$ui", "()F", "onNodePlacedCalled", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placeOuterCoordinatorBlock", "onNodePlaced", "onNodePlaced$ui", "clearPlaceOrder", "forEachChildDelegate", BlockContactsIQ.ELEMENT, "performMeasure", "constraints", "performMeasure-BRTryo0$ui", "(J)V", "measure", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "remeasure", "remeasure-BRTryo0", "(J)Z", "trackMeasurementByParent", NodeElement.ELEMENT, "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeAt", Const.POSITION, "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", Const.LAYER, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "needsCoordinatesUpdate", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "updatePlacedUnderMotionFrameOfReference", "newMFR", "placeSelf", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeOuterCoordinator", "placeOuterCoordinator-MLgxB_4", MessageCorrectExtension.ELEMENT, "minIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "maxIntrinsicWidth", "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicHeight", "onIntrinsicsQueried", "invalidateParentData", "updateParentData", "calculateAlignmentLines", "", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "forEachChildAlignmentLinesOwner", "requestLayout", "requestMeasure", "requestLayoutIfCoordinatesAreUsedAndNotifyChildren", "onBeforeLayoutChildren", "invalidateIntrinsicsParent", "forceRequest", "onNodeDetached", "markLayoutPending", "markMeasurePending", "markMeasurePending$ui", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
    public static final int $stable = 8;
    private boolean duringAlignmentLinesQuery;
    private boolean isPlaced;
    private boolean isPlacedByParent;
    private boolean isPlacedUnderMotionFrameOfReference;
    private GraphicsLayer lastExplicitLayer;
    private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
    private float lastZIndex;
    private boolean layingOutChildren;
    private final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private boolean measurePending;
    private boolean measuredOnce;
    private boolean needsCoordinatesUpdate;
    private boolean onNodePlacedCalled;
    private Object parentData;
    private GraphicsLayer placeOuterCoordinatorLayer;
    private Function1<? super GraphicsLayerScope, Unit> placeOuterCoordinatorLayerBlock;
    private float placeOuterCoordinatorZIndex;
    private boolean placedOnce;
    private boolean relayoutWithoutParentInProgress;
    private float zIndex;
    private int previousPlaceOrder = Integer.MAX_VALUE;
    private int placeOrder = Integer.MAX_VALUE;
    private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
    private long lastPosition = IntOffset.INSTANCE.m8969getZeronOccac();
    private boolean parentDataDirty = true;
    private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
    private final MutableVector<MeasurePassDelegate> _childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
    private boolean childDelegatesDirty = true;
    private long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private final Function0<Unit> performMeasureBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$performMeasureBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.getOuterCoordinator().mo7445measureBRTryo0(this.this$0.performMeasureConstraints);
        }
    };
    private final Function0<Unit> layoutChildrenBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.clearPlaceOrder();
            this.this$0.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui(false);
                }
            });
            if (this.this$0.getInnerCoordinator().getIsPlacingForAlignment()) {
                List<LayoutNode> children$ui = this.this$0.getLayoutNode().getChildren$ui();
                int size = children$ui.size();
                for (int i = 0; i < size; i++) {
                    children$ui.get(i).getOuterCoordinator$ui().setPlacingForAlignment$ui(true);
                }
            }
            this.this$0.getInnerCoordinator().getMeasureResult$ui().placeChildren();
            if (this.this$0.getInnerCoordinator().getIsPlacingForAlignment()) {
                List<LayoutNode> children$ui2 = this.this$0.getLayoutNode().getChildren$ui();
                int size2 = children$ui2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    children$ui2.get(i2).getOuterCoordinator$ui().setPlacingForAlignment$ui(false);
                }
            }
            this.this$0.checkChildrenPlaceOrderForUpdates();
            this.this$0.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$layoutChildrenBlock$1.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
                }
            });
        }
    };
    private long placeOuterCoordinatorPosition = IntOffset.INSTANCE.m8969getZeronOccac();
    private final Function0<Unit> placeOuterCoordinatorBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$placeOuterCoordinatorBlock$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Placeable.PlacementScope placementScope;
            NodeCoordinator wrappedBy = this.this$0.getOuterCoordinator().getWrappedBy();
            if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                placementScope = LayoutNodeKt.requireOwner(this.this$0.getLayoutNode()).getPlacementScope();
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            MeasurePassDelegate measurePassDelegate = this.this$0;
            Function1<? super GraphicsLayerScope, Unit> function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
            GraphicsLayer graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
            if (graphicsLayer != null) {
                placementScope2.m7526placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, graphicsLayer, measurePassDelegate.placeOuterCoordinatorZIndex);
            } else if (function1 == null) {
                placementScope2.m7517place70tqf50(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex);
            } else {
                placementScope2.m7525placeWithLayeraW9wM(measurePassDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex, function1);
            }
        }
    };

    /* JADX INFO: compiled from: MeasurePassDelegate.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
            try {
                iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MeasurePassDelegate(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        this.layoutNodeLayoutDelegate = layoutNodeLayoutDelegate;
    }

    /* JADX INFO: renamed from: getPreviousPlaceOrder$ui, reason: from getter */
    public final int getPreviousPlaceOrder() {
        return this.previousPlaceOrder;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public int getPlaceOrder() {
        return this.placeOrder;
    }

    public final boolean getPlacedOnce() {
        return this.placedOnce;
    }

    /* JADX INFO: renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m7715getLastConstraintsDWUhwKw() {
        if (this.measuredOnce) {
            return Constraints.m8770boximpl(getMeasurementConstraints());
        }
        return null;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNodeLayoutDelegate.getLayoutNode();
    }

    /* JADX INFO: renamed from: getMeasuredByParent$ui, reason: from getter */
    public final LayoutNode.UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui(LayoutNode.UsageByParent usageByParent) {
        this.measuredByParent = usageByParent;
    }

    /* JADX INFO: renamed from: getDuringAlignmentLinesQuery$ui, reason: from getter */
    public final boolean getDuringAlignmentLinesQuery() {
        return this.duringAlignmentLinesQuery;
    }

    public final void setDuringAlignmentLinesQuery$ui(boolean z) {
        this.duringAlignmentLinesQuery = z;
    }

    /* JADX INFO: renamed from: getLastPosition-nOcc-ac$ui, reason: not valid java name and from getter */
    public final long getLastPosition() {
        return this.lastPosition;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.parentData;
    }

    private final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutNodeLayoutDelegate.getLookaheadPassDelegate();
    }

    /* JADX INFO: renamed from: isPlaced$ui, reason: from getter */
    public final boolean getIsPlaced() {
        return this.isPlaced;
    }

    public final void setPlaced$ui(boolean z) {
        this.isPlaced = z;
    }

    /* JADX INFO: renamed from: isPlacedByParent, reason: from getter */
    public final boolean getIsPlacedByParent() {
        return this.isPlacedByParent;
    }

    public final void setPlacedByParent$ui(boolean z) {
        this.isPlacedByParent = z;
    }

    /* JADX INFO: renamed from: getMeasurePending$ui, reason: from getter */
    public final boolean getMeasurePending() {
        return this.measurePending;
    }

    /* JADX INFO: renamed from: getLayoutPending$ui, reason: from getter */
    public final boolean getLayoutPending() {
        return this.layoutPending;
    }

    public final LayoutNode.LayoutState getLayoutState() {
        return this.layoutNodeLayoutDelegate.getLayoutState();
    }

    public final void setLayoutState(LayoutNode.LayoutState layoutState) {
        this.layoutNodeLayoutDelegate.setLayoutState$ui(layoutState);
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNodeLayoutDelegate.getOuterCoordinator();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public NodeCoordinator getInnerCoordinator() {
        return getLayoutNode().getInnerCoordinator$ui();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLines getAlignmentLines() {
        return this.alignmentLines;
    }

    /* JADX INFO: renamed from: getChildDelegatesDirty$ui, reason: from getter */
    public final boolean getChildDelegatesDirty() {
        return this.childDelegatesDirty;
    }

    public final void setChildDelegatesDirty$ui(boolean z) {
        this.childDelegatesDirty = z;
    }

    public final List<MeasurePassDelegate> getChildDelegates$ui() {
        getLayoutNode().updateChildrenIfDirty$ui();
        if (!this.childDelegatesDirty) {
            return this._childDelegates.asMutableList();
        }
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<MeasurePassDelegate> mutableVector = this._childDelegates;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector2.content;
        int size = mutableVector2.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (mutableVector.getSize() <= i) {
                mutableVector.add(layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
            } else {
                mutableVector.set(i, layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
            }
        }
        mutableVector.removeRange(layoutNode.getChildren$ui().size(), mutableVector.getSize());
        this.childDelegatesDirty = false;
        return this._childDelegates.asMutableList();
    }

    public final void markDetachedFromParentLookaheadPass$ui() {
        this.layoutNodeLayoutDelegate.setDetachedFromParentLookaheadPass$ui(true);
    }

    public final boolean getLayingOutChildren() {
        return this.layingOutChildren;
    }

    public final Function0<Unit> getPerformMeasureBlock$ui() {
        return this.performMeasureBlock;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void layoutChildren() {
        this.layingOutChildren = true;
        getAlignmentLines().recalculateQueryOwner();
        if (this.layoutPending) {
            onBeforeLayoutChildren();
        }
        if (this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().getIsPlacingForAlignment() && this.layoutPending)) {
            this.layoutPending = false;
            LayoutNode.LayoutState layoutState = getLayoutState();
            setLayoutState(LayoutNode.LayoutState.LayingOut);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
            LayoutNode layoutNode = getLayoutNode();
            OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver();
            Function0<Unit> function0 = this.layoutChildrenBlock;
            Function1 function1 = snapshotObserver.onCommitAffectingLayout;
            snapshotObserver.observer.observeReads(layoutNode, function1, function0);
            setLayoutState(layoutState);
            this.layoutPendingForAlignment = false;
        }
        if (getAlignmentLines().getUsedDuringParentLayout()) {
            getAlignmentLines().setPreviousUsedDuringParentLayout$ui(true);
        }
        if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui()) {
            getAlignmentLines().recalculate();
        }
        this.layingOutChildren = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkChildrenPlaceOrderForUpdates() {
        LayoutNode layoutNode = getLayoutNode();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getMeasurePassDelegate$ui().previousPlaceOrder != layoutNode2.getPlaceOrder$ui()) {
                layoutNode.onZSortedChildrenInvalidated$ui();
                layoutNode.invalidateLayer$ui();
                if (layoutNode2.getPlaceOrder$ui() == Integer.MAX_VALUE) {
                    if (layoutNode2.getLayoutDelegate().getDetachedFromParentLookaheadPlacement() || LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(layoutNode2)) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui = layoutNode2.getLookaheadPassDelegate$ui();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui);
                        lookaheadPassDelegate$ui.markNodeAndSubtreeAsNotPlaced$ui(false);
                    }
                    layoutNode2.getMeasurePassDelegate$ui().markSubtreeAsNotPlaced();
                }
            }
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (this.isPlaced) {
            this.isPlaced = false;
            LayoutNodeKt.requireOwner(getLayoutNode()).getRectManager().remove(getLayoutNode());
            LayoutNode layoutNode = getLayoutNode();
            NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui().getWrapped();
            for (NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
                outerCoordinator$ui.onUnplaced();
                outerCoordinator$ui.releaseLayer();
            }
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                layoutNodeArr[i].getMeasurePassDelegate$ui().markSubtreeAsNotPlaced();
            }
        }
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean z = this.isPlaced;
        this.isPlaced = true;
        LayoutNode layoutNode = getLayoutNode();
        if (!z) {
            layoutNode.getInnerCoordinator$ui().onPlaced();
            LayoutNodeKt.requireOwner(layoutNode).getRectManager().recalculateRectIfDirty(getLayoutNode());
            if (layoutNode.getMeasurePending$ui()) {
                LayoutNode.requestRemeasure$ui$default(layoutNode, true, false, false, 6, null);
            } else if (layoutNode.getLookaheadMeasurePending$ui()) {
                LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, true, false, false, 6, null);
            }
        }
        NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui().getWrapped();
        for (NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui(); !Intrinsics.areEqual(outerCoordinator$ui, wrapped) && outerCoordinator$ui != null; outerCoordinator$ui = outerCoordinator$ui.getWrapped()) {
            if (outerCoordinator$ui.getLastLayerDrawingWasSkipped()) {
                outerCoordinator$ui.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.getPlaceOrder$ui() != Integer.MAX_VALUE) {
                layoutNode2.getMeasurePassDelegate$ui().markNodeAndSubtreeAsPlaced();
                layoutNode.rescheduleRemeasureOrRelayout$ui(layoutNode2);
            }
        }
    }

    /* JADX INFO: renamed from: getZIndex$ui, reason: from getter */
    public final float getZIndex() {
        return this.zIndex;
    }

    public final void onNodePlaced$ui() {
        this.onNodePlacedCalled = true;
        LayoutNode parent$ui = getLayoutNode().getParent$ui();
        float zIndex = getInnerCoordinator().getZIndex();
        LayoutNode layoutNode = getLayoutNode();
        NodeCoordinator outerCoordinator$ui = layoutNode.getOuterCoordinator$ui();
        NodeCoordinator innerCoordinator$ui = layoutNode.getInnerCoordinator$ui();
        while (outerCoordinator$ui != innerCoordinator$ui) {
            Intrinsics.checkNotNull(outerCoordinator$ui, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui;
            zIndex += layoutModifierNodeCoordinator.getZIndex();
            outerCoordinator$ui = layoutModifierNodeCoordinator.getWrapped();
        }
        if (zIndex != this.zIndex) {
            this.zIndex = zIndex;
            if (parent$ui != null) {
                parent$ui.onZSortedChildrenInvalidated$ui();
            }
            if (parent$ui != null) {
                parent$ui.invalidateLayer$ui();
            }
        }
        if (!getInnerCoordinator().getIsPlacingForAlignment()) {
            boolean z = this.isPlaced;
            if (!z || getAlignmentLines().getQueried$ui()) {
                markNodeAndSubtreeAsPlaced();
            }
            if (!z) {
                if (parent$ui != null) {
                    parent$ui.invalidateLayer$ui();
                }
                if (this.relayoutWithoutParentInProgress && parent$ui != null) {
                    LayoutNode.requestRelayout$ui$default(parent$ui, false, 1, null);
                }
            } else {
                getLayoutNode().getInnerCoordinator$ui().onPlaced();
            }
        }
        if (parent$ui != null) {
            if (!this.relayoutWithoutParentInProgress && parent$ui.getLayoutState$ui() == LayoutNode.LayoutState.LayingOut) {
                if (!(getPlaceOrder() == Integer.MAX_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                this.placeOrder = parent$ui.getLayoutDelegate().getNextChildPlaceOrder();
                LayoutNodeLayoutDelegate layoutDelegate = parent$ui.getLayoutDelegate();
                layoutDelegate.setNextChildPlaceOrder$ui(layoutDelegate.getNextChildPlaceOrder() + 1);
            }
        } else {
            this.placeOrder = 0;
        }
        layoutChildren();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPlaceOrder() {
        this.layoutNodeLayoutDelegate.setNextChildPlaceOrder$ui(0);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            MeasurePassDelegate measurePassDelegate$ui = layoutNodeArr[i].getMeasurePassDelegate$ui();
            measurePassDelegate$ui.previousPlaceOrder = measurePassDelegate$ui.getPlaceOrder();
            measurePassDelegate$ui.placeOrder = Integer.MAX_VALUE;
            measurePassDelegate$ui.isPlacedByParent = false;
            if (measurePassDelegate$ui.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                measurePassDelegate$ui.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
        }
    }

    private final void forEachChildDelegate(Function1<? super MeasurePassDelegate, Unit> block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(layoutNodeArr[i].getMeasurePassDelegate$ui());
        }
    }

    /* JADX INFO: renamed from: performMeasure-BRTryo0$ui, reason: not valid java name */
    public final void m7717performMeasureBRTryo0$ui(long constraints) {
        if (!(getLayoutState() == LayoutNode.LayoutState.Idle)) {
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }
        this.performMeasureConstraints = constraints;
        setLayoutState(LayoutNode.LayoutState.Measuring);
        this.measurePending = false;
        OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
        LayoutNode layoutNode = getLayoutNode();
        Function0<Unit> performMeasureBlock$ui = getPerformMeasureBlock$ui();
        snapshotObserver.observer.observeReads(layoutNode, snapshotObserver.onCommitAffectingMeasure, performMeasureBlock$ui);
        if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
            markLayoutPending();
            setLayoutState(LayoutNode.LayoutState.Idle);
        }
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo7445measureBRTryo0(long constraints) throws Throwable {
        if (getLayoutNode().getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
            getLayoutNode().clearSubtreeIntrinsicsUsage$ui();
        }
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.setMeasuredByParent$ui(LayoutNode.UsageByParent.NotUsed);
            if (!ComposeToolingFlags.isVerboseTracingEnabled) {
                lookaheadPassDelegate.mo7445measureBRTryo0(constraints);
            } else {
                Trace.beginSection("Compose:lookaheadMeasure");
                try {
                    lookaheadPassDelegate.mo7445measureBRTryo0(constraints);
                } finally {
                    Trace.endSection();
                }
            }
        }
        trackMeasurementByParent(getLayoutNode());
        m7718remeasureBRTryo0(constraints);
        return this;
    }

    /* JADX INFO: renamed from: remeasure-BRTryo0, reason: not valid java name */
    public final boolean m7718remeasureBRTryo0(long constraints) throws Throwable {
        LayoutNode layoutNode = getLayoutNode();
        try {
            if (getLayoutNode().getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
            LayoutNode parent$ui = getLayoutNode().getParent$ui();
            boolean z = true;
            getLayoutNode().setCanMultiMeasure$ui(getLayoutNode().getCanMultiMeasure() || (parent$ui != null && parent$ui.getCanMultiMeasure()));
            if (!getLayoutNode().getMeasurePending$ui() && Constraints.m8776equalsimpl0(getMeasurementConstraints(), constraints)) {
                Owner.forceMeasureTheSubtree$default(ownerRequireOwner, getLayoutNode(), false, 2, null);
                getLayoutNode().resetSubtreeIntrinsicsUsage$ui();
                return false;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.MeasurePassDelegate$remeasure$1$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui(false);
                }
            });
            this.measuredOnce = true;
            long jMo7453getSizeYbymL2g = getOuterCoordinator().mo7453getSizeYbymL2g();
            m7510setMeasurementConstraintsBRTryo0(constraints);
            if (!(getLayoutState() == LayoutNode.LayoutState.Idle)) {
                InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
            }
            this.performMeasureConstraints = constraints;
            setLayoutState(LayoutNode.LayoutState.Measuring);
            this.measurePending = false;
            OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
            snapshotObserver.observer.observeReads(getLayoutNode(), snapshotObserver.onCommitAffectingMeasure, getPerformMeasureBlock$ui());
            if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
                markLayoutPending();
                setLayoutState(LayoutNode.LayoutState.Idle);
            }
            if (IntSize.m8999equalsimpl0(getOuterCoordinator().mo7453getSizeYbymL2g(), jMo7453getSizeYbymL2g) && getOuterCoordinator().getWidth() == getWidth() && getOuterCoordinator().getHeight() == getHeight()) {
                z = false;
            }
            m7509setMeasuredSizeozmzZPI(IntSize.m8996constructorimpl((((long) getOuterCoordinator().getHeight()) & 4294967295L) | (((long) getOuterCoordinator().getWidth()) << 32)));
            return z;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    private final void trackMeasurementByParent(LayoutNode node) {
        LayoutNode.UsageByParent usageByParent;
        LayoutNode parent$ui = node.getParent$ui();
        if (parent$ui != null) {
            if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure())) {
                InlineClassHelperKt.throwIllegalStateException(LayoutNodeLayoutDelegateKt.MeasuredTwiceErrorMessage);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[parent$ui.getLayoutState$ui().ordinal()];
            if (i == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else if (i == 2) {
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            } else {
                throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui.getLayoutState$ui());
            }
            this.measuredByParent = usageByParent;
            return;
        }
        this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return getOuterCoordinator().getMeasuredWidth();
    }

    @Override // androidx.compose.ui.layout.Placeable, androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return getOuterCoordinator().getMeasuredHeight();
    }

    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        LayoutNode parent$ui = getLayoutNode().getParent$ui();
        if ((parent$ui != null ? parent$ui.getLayoutState$ui() : null) == LayoutNode.LayoutState.Measuring) {
            getAlignmentLines().setUsedDuringParentMeasurement$ui(true);
        } else {
            LayoutNode parent$ui2 = getLayoutNode().getParent$ui();
            if ((parent$ui2 != null ? parent$ui2.getLayoutState$ui() : null) == LayoutNode.LayoutState.LayingOut) {
                getAlignmentLines().setUsedDuringParentLayout$ui(true);
            }
        }
        this.duringAlignmentLinesQuery = true;
        int i = getOuterCoordinator().get(alignmentLine);
        this.duringAlignmentLinesQuery = false;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo7446placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) throws Throwable {
        m7714placeSelfMLgxB_4(position, zIndex, layerBlock, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo7508placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) throws Throwable {
        m7714placeSelfMLgxB_4(position, zIndex, null, layer);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* JADX INFO: renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        if (newMFR != getOuterCoordinator().getIsPlacedUnderMotionFrameOfReference()) {
            getOuterCoordinator().setPlacedUnderMotionFrameOfReference(newMFR);
            this.needsCoordinatesUpdate = true;
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    /* JADX INFO: renamed from: placeSelf-MLgxB_4, reason: not valid java name */
    private final void m7714placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) throws Throwable {
        Placeable.PlacementScope placementScope;
        LayoutNode layoutNode = getLayoutNode();
        boolean z = true;
        try {
            this.isPlacedByParent = true;
            if (!IntOffset.m8957equalsimpl0(position, this.lastPosition) || layerBlock != this.lastLayerBlock || this.needsCoordinatesUpdate) {
                if (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement() || this.needsCoordinatesUpdate) {
                    this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }
            }
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.onApproachPlacement$ui();
            }
            LookaheadPassDelegate lookaheadPassDelegate2 = getLookaheadPassDelegate();
            if (lookaheadPassDelegate2 != null && lookaheadPassDelegate2.getNeedsToBePlacedInApproach()) {
                NodeCoordinator wrappedBy = getOuterCoordinator().getWrappedBy();
                if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                    placementScope = LayoutNodeKt.requireOwner(getLayoutNode()).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                LookaheadPassDelegate lookaheadPassDelegate3 = getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate3);
                LayoutNode parent$ui = getLayoutNode().getParent$ui();
                if (parent$ui != null) {
                    parent$ui.getLayoutDelegate().setNextChildLookaheadPlaceOrder$ui(0);
                }
                lookaheadPassDelegate3.setPlaceOrder$ui(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default(placementScope2, lookaheadPassDelegate3, IntOffset.m8958getXimpl(position), IntOffset.m8959getYimpl(position), 0.0f, 4, null);
            }
            LookaheadPassDelegate lookaheadPassDelegate4 = getLookaheadPassDelegate();
            if (lookaheadPassDelegate4 == null || lookaheadPassDelegate4.getPlacedOnce()) {
                z = false;
            }
            if (z) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            m7713placeOuterCoordinatorMLgxB_4(position, zIndex, layerBlock, layer);
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            layoutNode.rethrowWithComposeStackTrace(th);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: renamed from: placeOuterCoordinator-MLgxB_4, reason: not valid java name */
    private final void m7713placeOuterCoordinatorMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
        if (getLayoutNode().getIsDeactivated()) {
            InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
        }
        setLayoutState(LayoutNode.LayoutState.LayingOut);
        this.lastPosition = position;
        this.lastZIndex = zIndex;
        this.lastLayerBlock = layerBlock;
        this.lastExplicitLayer = layer;
        this.onNodePlacedCalled = false;
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        if (!this.layoutPending && this.isPlaced) {
            getOuterCoordinator().m7753placeSelfApparentToRealOffsetMLgxB_4(position, zIndex, layerBlock, layer);
            onNodePlaced$ui();
        } else {
            getAlignmentLines().setUsedByModifierLayout$ui(false);
            this.layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
            this.placeOuterCoordinatorLayerBlock = layerBlock;
            this.placeOuterCoordinatorPosition = position;
            this.placeOuterCoordinatorZIndex = zIndex;
            this.placeOuterCoordinatorLayer = layer;
            OwnerSnapshotObserver snapshotObserver = ownerRequireOwner.getSnapshotObserver();
            LayoutNode layoutNode = getLayoutNode();
            Function0<Unit> function0 = this.placeOuterCoordinatorBlock;
            Function1 function1 = snapshotObserver.onCommitAffectingLayoutModifier;
            snapshotObserver.observer.observeReads(layoutNode, function1, function0);
        }
        setLayoutState(LayoutNode.LayoutState.Idle);
        if (getOuterCoordinator().getIsPlacingForAlignment() && (this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringModifierPlacement() || this.layoutNodeLayoutDelegate.getCoordinatesAccessedDuringPlacement())) {
            requestLayout();
        }
        this.placedOnce = true;
    }

    public final void replace() {
        MeasurePassDelegate measurePassDelegate;
        LayoutNode parent$ui;
        try {
            this.relayoutWithoutParentInProgress = true;
            if (!this.placedOnce) {
                InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
            }
            boolean z = this.isPlaced;
            measurePassDelegate = this;
            try {
                measurePassDelegate.m7713placeOuterCoordinatorMLgxB_4(this.lastPosition, this.lastZIndex, this.lastLayerBlock, this.lastExplicitLayer);
                if (z && !measurePassDelegate.onNodePlacedCalled && (parent$ui = getLayoutNode().getParent$ui()) != null) {
                    LayoutNode.requestRelayout$ui$default(parent$ui, false, 1, null);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    getLayoutNode().rethrowWithComposeStackTrace(th);
                    throw new KotlinNothingValueException();
                } finally {
                    measurePassDelegate.relayoutWithoutParentInProgress = false;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            measurePassDelegate = this;
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.minIntrinsicWidth(height);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.maxIntrinsicWidth(height);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.minIntrinsicHeight(width);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(getLayoutNode())) {
            LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.maxIntrinsicHeight(width);
        }
        onIntrinsicsQueried();
        return getOuterCoordinator().maxIntrinsicHeight(width);
    }

    private final void onIntrinsicsQueried() {
        LayoutNode.UsageByParent intrinsicsUsageByParent;
        LayoutNode.requestRemeasure$ui$default(getLayoutNode(), false, false, false, 7, null);
        LayoutNode parent$ui = getLayoutNode().getParent$ui();
        if (parent$ui == null || getLayoutNode().getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        LayoutNode layoutNode = getLayoutNode();
        int i = WhenMappings.$EnumSwitchMapping$0[parent$ui.getLayoutState$ui().ordinal()];
        if (i == 1) {
            intrinsicsUsageByParent = LayoutNode.UsageByParent.InMeasureBlock;
        } else if (i == 2) {
            intrinsicsUsageByParent = LayoutNode.UsageByParent.InLayoutBlock;
        } else {
            intrinsicsUsageByParent = parent$ui.getIntrinsicsUsageByParent();
        }
        layoutNode.setIntrinsicsUsageByParent$ui(intrinsicsUsageByParent);
    }

    public final void invalidateParentData() {
        this.parentDataDirty = true;
    }

    public final boolean updateParentData() {
        if ((getParentData() == null && getOuterCoordinator().getParentData() == null) || !this.parentDataDirty) {
            return false;
        }
        this.parentDataDirty = false;
        this.parentData = getOuterCoordinator().getParentData();
        return true;
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public Map<AlignmentLine, Integer> calculateAlignmentLines() {
        if (!this.duringAlignmentLinesQuery) {
            if (getLayoutState() == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedByModifierMeasurement$ui(true);
                if (getAlignmentLines().getDirty()) {
                    markLayoutPending();
                }
            } else {
                getAlignmentLines().setUsedByModifierLayout$ui(true);
            }
        }
        NodeCoordinator innerCoordinator = getInnerCoordinator();
        boolean zIsPlacingForAlignment$ui = innerCoordinator.getIsPlacingForAlignment();
        innerCoordinator.setPlacingForAlignment$ui(true);
        layoutChildren();
        innerCoordinator.setPlacingForAlignment$ui(zIsPlacingForAlignment$ui);
        return getAlignmentLines().getLastCalculation();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public AlignmentLinesOwner getParentAlignmentLinesOwner() {
        LayoutNodeLayoutDelegate layoutDelegate;
        LayoutNode parent$ui = getLayoutNode().getParent$ui();
        if (parent$ui == null || (layoutDelegate = parent$ui.getLayoutDelegate()) == null) {
            return null;
        }
        return layoutDelegate.getAlignmentLinesOwner$ui();
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            block.invoke(layoutNodeArr[i].getLayoutDelegate().getAlignmentLinesOwner$ui());
        }
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestLayout() {
        LayoutNode.requestRelayout$ui$default(getLayoutNode(), false, 1, null);
    }

    @Override // androidx.compose.ui.node.AlignmentLinesOwner
    public void requestMeasure() {
        LayoutNode.requestRemeasure$ui$default(getLayoutNode(), false, false, false, 7, null);
    }

    public final void requestLayoutIfCoordinatesAreUsedAndNotifyChildren() {
        if (!getLayoutNode().isPlaced() || this.layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() <= 0) {
            return;
        }
        LayoutNodeLayoutDelegate layoutDelegate = getLayoutNode().getLayoutDelegate();
        if ((layoutDelegate.getCoordinatesAccessedDuringPlacement() || layoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLayoutPending$ui()) {
            LayoutNode.requestRelayout$ui$default(getLayoutNode(), false, 1, null);
        }
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            layoutNodeArr[i].getMeasurePassDelegate$ui().requestLayoutIfCoordinatesAreUsedAndNotifyChildren();
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            if (layoutNode.getMeasurePending$ui() && layoutNode.getMeasuredByParent$ui() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m7671remeasure_Sx5XlM$ui$default(layoutNode, null, 1, null)) {
                LayoutNode.requestRemeasure$ui$default(getLayoutNode(), false, false, false, 7, null);
            }
        }
    }

    public final void invalidateIntrinsicsParent(boolean forceRequest) {
        LayoutNode layoutNode;
        LayoutNode parent$ui = getLayoutNode().getParent$ui();
        LayoutNode.UsageByParent intrinsicsUsageByParent = getLayoutNode().getIntrinsicsUsageByParent();
        if (parent$ui == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
            return;
        }
        do {
            layoutNode = parent$ui;
            if (layoutNode.getIntrinsicsUsageByParent() != intrinsicsUsageByParent) {
                break;
            } else {
                parent$ui = layoutNode.getParent$ui();
            }
        } while (parent$ui != null);
        int i = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
        if (i == 1) {
            LayoutNode.requestRemeasure$ui$default(layoutNode, forceRequest, false, false, 6, null);
        } else {
            if (i == 2) {
                layoutNode.requestRelayout$ui(forceRequest);
                return;
            }
            throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
        }
    }

    public final void onNodeDetached() {
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final void markLayoutPending() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui() {
        this.measurePending = true;
    }
}
