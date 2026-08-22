package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: FlowLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u001a2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a=\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010*\u001aT\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0082\b\u001a\u0091\u0001\u00103\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0083\b\u001a[\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0002¢\u0006\u0002\u0010<\u001a\u0096\u0001\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001aY\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010M\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002\u001a\u001c\u0010P\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u00104\u001a\u00020\u000bH\u0000\u001a\u001c\u0010S\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u0010/\u001a\u00020\u000bH\u0000\u001a9\u0010Z\u001a\u000207*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020[2\u0014\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001aQ\u0010`\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W\"\u0014\u0010X\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010W¨\u0006i"}, d2 = {"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", FirebaseAnalytics.Param.ITEMS, "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(Alignment.INSTANCE.getStart());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$2(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, flowColumnOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$3(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$2(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, flowRowOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$3(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    @kotlin.Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowRow(androidx.compose.ui.Modifier r22, androidx.compose.foundation.layout.Arrangement.Horizontal r23, androidx.compose.foundation.layout.Arrangement.Vertical r24, androidx.compose.ui.Alignment.Vertical r25, int r26, int r27, androidx.compose.foundation.layout.FlowRowOverflow r28, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowRowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, androidx.compose.foundation.layout.FlowRowOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@5051L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1192950673, i, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:113)");
            }
            function3.invoke(FlowRowScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowRow(androidx.compose.ui.Modifier r21, androidx.compose.foundation.layout.Arrangement.Horizontal r22, androidx.compose.foundation.layout.Arrangement.Vertical r23, androidx.compose.ui.Alignment.Vertical r24, int r25, int r26, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowRowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    @kotlin.Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowColumn(androidx.compose.ui.Modifier r22, androidx.compose.foundation.layout.Arrangement.Vertical r23, androidx.compose.foundation.layout.Arrangement.Horizontal r24, androidx.compose.ui.Alignment.Horizontal r25, int r26, int r27, androidx.compose.foundation.layout.FlowColumnOverflow r28, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, androidx.compose.foundation.layout.FlowColumnOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$1$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C227@10017L9:FlowLayout.kt#2w3rfo");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1720407857, i, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:227)");
            }
            function3.invoke(FlowColumnScopeInstance.INSTANCE, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowColumn(androidx.compose.ui.Modifier r21, androidx.compose.foundation.layout.Arrangement.Vertical r22, androidx.compose.foundation.layout.Arrangement.Horizontal r23, androidx.compose.ui.Alignment.Horizontal r24, int r25, int r26, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.FlowColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1479255111, "C(rowMeasurementHelper)N(horizontalArrangement,verticalArrangement,maxItemsInMainAxis)440@17697L893:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -70006556, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1016measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2010142641, "C(rowMeasurementMultiContentHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState)471@18969L708:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2010142641, i3, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 988216051, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(vertical2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2013098357, "C(columnMeasurementHelper)N(verticalArrangement,horizontalArrangement,maxItemsInMainAxis)501@19939L850:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1852231075, "CC(remember):FlowLayout.kt#9igjgp");
        boolean z = ((((i2 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        MeasurePolicy measurePolicyRememberedValue = composer.rememberedValue();
        if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return flowMeasurePolicy.mo1016measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(measurePolicyRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy;
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -308635847, "C(columnMeasurementMultiContentHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState)529@21138L715:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-308635847, i3, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -246294460, "CC(remember):FlowLayout.kt#9igjgp");
        boolean zChanged = ((((i3 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(horizontal2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i3 & 7168) ^ 3072) > 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy2;
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int i6 = i4;
        int i7 = i5;
        if (list2.isEmpty()) {
            return 0;
        }
        int size = list2.size();
        int[] iArr = new int[size];
        int size2 = list2.size();
        int[] iArr2 = new int[size2];
        int size3 = list2.size();
        for (int i8 = 0; i8 < size3; i8++) {
            IntrinsicMeasurable intrinsicMeasurable = list2.get(i8);
            int iIntValue = function3.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(i)).intValue();
            iArr[i8] = iIntValue;
            iArr2[i8] = function32.invoke(intrinsicMeasurable, Integer.valueOf(i8), Integer.valueOf(iIntValue)).intValue();
        }
        int i9 = Integer.MAX_VALUE;
        if (i7 != Integer.MAX_VALUE && i6 != Integer.MAX_VALUE) {
            i9 = i6 * i7;
        }
        int i10 = 1;
        int iMin = Math.min(i9 - (((i9 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i9 < list2.size() || i7 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout() || flowLayoutOverflowState.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list2.size());
        int iSum = ArraysKt.sum(iArr) + ((list2.size() - 1) * i2);
        if (size2 != 0) {
            int iM31getFirstimpl = iArr2[0];
            int lastIndex = ArraysKt.getLastIndex(iArr2);
            if (1 <= lastIndex) {
                int i11 = 1;
                while (true) {
                    int i12 = iArr2[i11];
                    if (iM31getFirstimpl < i12) {
                        iM31getFirstimpl = i12;
                    }
                    if (i11 == lastIndex) {
                        break;
                    }
                    i11++;
                }
            }
            if (size != 0) {
                int i13 = iArr[0];
                int lastIndex2 = ArraysKt.getLastIndex(iArr);
                if (1 <= lastIndex2) {
                    while (true) {
                        int i14 = iArr[i10];
                        if (i13 < i14) {
                            i13 = i14;
                        }
                        if (i10 == lastIndex2) {
                            break;
                        }
                        i10++;
                    }
                }
                int i15 = i13;
                int i16 = iSum;
                while (i15 <= i16 && iM31getFirstimpl != i) {
                    int i17 = (i15 + i16) / 2;
                    long jIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i17, i2, i3, i6, i7, flowLayoutOverflowState);
                    iM31getFirstimpl = IntIntPair.m31getFirstimpl(jIntrinsicCrossAxisSize);
                    int iM32getSecondimpl = IntIntPair.m32getSecondimpl(jIntrinsicCrossAxisSize);
                    if (iM31getFirstimpl > i || iM32getSecondimpl < iMin) {
                        i15 = i17 + 1;
                        if (i15 > i16) {
                            return i15;
                        }
                    } else {
                        if (iM31getFirstimpl >= i) {
                            return i17;
                        }
                        i16 = i17 - 1;
                    }
                    list2 = list;
                    i6 = i4;
                    i7 = i5;
                    iSum = i17;
                }
                return iSum;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i6;
        if (list.isEmpty()) {
            return IntIntPair.m27constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1117constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int iIntValue = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i)).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue)).intValue() : 0;
        int i7 = 0;
        int iMax = 0;
        if (flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m27constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m24boximpl(IntIntPair.m27constructorimpl(iIntValue2, iIntValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM997ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m997ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m27constructorimpl(intIntPairM997ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m32getSecondimpl(intIntPairM997ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i8 = i;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = iMax;
            if (i9 >= size) {
                i6 = i10;
                break;
            }
            int i14 = i8 - iIntValue2;
            int i15 = i9 + 1;
            iMax = Math.max(i13, iIntValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i15);
            int iIntValue3 = intrinsicMeasurable2 != null ? function32.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(i)).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, Integer.valueOf(i15), Integer.valueOf(iIntValue3)).intValue() + i2 : 0;
            int i16 = i15 - i11;
            i6 = i15;
            int i17 = i12;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM988getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(i9 + 2 < list.size(), i16, IntIntPair.m27constructorimpl(i14, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m24boximpl(IntIntPair.m27constructorimpl(iIntValue4, iIntValue3)), i17, i7, iMax, false, false);
            if (wrapInfoM988getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM32getSecondimpl = i7 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM988getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i17, iM32getSecondimpl, i14, i16);
                iIntValue4 -= i2;
                i12 = i17 + 1;
                if (wrapInfoM988getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM32getSecondimpl += IntIntPair.m32getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i7 = iM32getSecondimpl;
                } else {
                    i8 = i;
                    i11 = i6;
                    i7 = iM32getSecondimpl;
                    iMax = 0;
                }
            } else {
                i8 = i14;
                i12 = i17;
            }
            iIntValue2 = iIntValue4;
            iIntValue = iIntValue3;
            i9 = i6;
            i10 = i9;
        }
        return IntIntPair.m27constructorimpl(i7 - i3, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$0$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit breakDownItems_di9J0FM$lambda$2$0(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (it instanceof ContextualFlowItemIterator) {
                Intrinsics.checkNotNull(flowLineInfo);
                return ((ContextualFlowItemIterator) it).getNext$foundation_layout(flowLineInfo);
            }
            return it.next();
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    /* JADX INFO: renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m993measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j, Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        Measurable measurable2 = measurable;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable2)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable2);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j);
                function1.invoke(placeableMo7445measureBRTryo0);
                return IntIntPair.m27constructorimpl(flowLineMeasurePolicy.mainAxisSize(placeableMo7445measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(placeableMo7445measureBRTryo0));
            }
        }
        int iMainAxisMin = mainAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m27constructorimpl(iMainAxisMin, crossAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), iMainAxisMin));
    }

    /* JADX INFO: renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m994placeHelperBmaY500(MeasureScope measureScope, long j, int i, int i2, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int iM8782getMaxHeightimpl;
        int i3;
        int i4;
        boolean zIsHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (zIsHorizontal) {
            int i5 = i2 + (measureScope.mo482roundToPx0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(j);
            iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
            if (i5 < iM8784getMinHeightimpl) {
                i5 = iM8784getMinHeightimpl;
            }
            if (i5 <= iM8782getMaxHeightimpl) {
                iM8782getMaxHeightimpl = i5;
            }
            verticalArrangement.arrange(measureScope, iM8782getMaxHeightimpl, iArr, iArr2);
        } else {
            int i6 = i2 + (measureScope.mo482roundToPx0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1));
            int iM8784getMinHeightimpl2 = Constraints.m8784getMinHeightimpl(j);
            int iM8782getMaxHeightimpl2 = Constraints.m8782getMaxHeightimpl(j);
            if (i6 < iM8784getMinHeightimpl2) {
                i6 = iM8784getMinHeightimpl2;
            }
            int i7 = i6 > iM8782getMaxHeightimpl2 ? iM8782getMaxHeightimpl2 : i6;
            horizontalArrangement.arrange(measureScope, i7, iArr, measureScope.getLayoutDirection(), iArr2);
            iM8782getMaxHeightimpl = i7;
        }
        int iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(j);
        int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
        if (i < iM8785getMinWidthimpl) {
            i = iM8785getMinWidthimpl;
        }
        if (i <= iM8783getMaxWidthimpl) {
            iM8783getMaxWidthimpl = i;
        }
        if (zIsHorizontal) {
            i4 = iM8783getMaxWidthimpl;
            i3 = iM8782getMaxHeightimpl;
        } else {
            i3 = iM8783getMaxWidthimpl;
            i4 = iM8782getMaxHeightimpl;
        }
        return MeasureScope.layout$default(measureScope, i4, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.placeHelper_BmaY500$lambda$2(mutableVector, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int iIntValue = function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i)).intValue() + i2;
            int i7 = i4 + 1;
            if (i7 - i5 == i3 || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iIntValue) - i2);
                i6 = 0;
                i5 = i4;
            } else {
                i6 += iIntValue;
            }
            i4 = i7;
        }
        return iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return IntIntPair.m27constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1117constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int i6 = intrinsicMeasurable != null ? iArr2[0] : 0;
        int i7 = intrinsicMeasurable != null ? iArr[0] : 0;
        int i8 = 0;
        if (flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m27constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m24boximpl(IntIntPair.m27constructorimpl(i7, i6)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM997ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m997ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m27constructorimpl(intIntPairM997ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m32getSecondimpl(intIntPairM997ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i9 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            int i15 = i9 - i7;
            int i16 = i10 + 1;
            int iMax = Math.max(i14, i6);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i16);
            int i17 = intrinsicMeasurable2 != null ? iArr2[i16] : 0;
            int i18 = intrinsicMeasurable2 != null ? iArr[i16] + i2 : 0;
            int i19 = i16 - i12;
            int i20 = i13;
            int i21 = i17;
            int i22 = i18;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM988getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(i10 + 2 < list.size(), i19, IntIntPair.m27constructorimpl(i15, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m24boximpl(IntIntPair.m27constructorimpl(i18, i17)), i20, i8, iMax, false, false);
            if (wrapInfoM988getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM32getSecondimpl = i8 + iMax + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM988getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i20, iM32getSecondimpl, i15, i19);
                int i23 = i22 - i2;
                i13 = i20 + 1;
                if (wrapInfoM988getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM32getSecondimpl += IntIntPair.m32getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i8 = iM32getSecondimpl;
                    i11 = i16;
                } else {
                    i14 = 0;
                    i8 = iM32getSecondimpl;
                    i7 = i23;
                    i12 = i16;
                    i9 = i;
                }
            } else {
                i9 = i15;
                i13 = i20;
                i14 = iMax;
                i7 = i22;
            }
            i10 = i16;
            i11 = i10;
            i6 = i21;
        }
        return IntIntPair.m27constructorimpl(i8 - i3, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX INFO: renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m992breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f2, float f3, long j, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i3;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        MutableIntObjectMap mutableIntObjectMap;
        int i4;
        int i5;
        MeasureScope measureScope2;
        int[] iArr;
        FlowLineMeasurePolicy flowLineMeasurePolicy2;
        int[] iArr2;
        long j2;
        int i6;
        int i7;
        int i8;
        MutableIntObjectMap mutableIntObjectMap2;
        IntIntPair intIntPairM24boximpl;
        int i9;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i10;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        int i11;
        boolean z;
        int i12;
        int i13;
        FlowLayoutData flowLayoutData;
        MeasureScope measureScope3 = measureScope;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
        int iM8785getMinWidthimpl = Constraints.m8785getMinWidthimpl(j);
        int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope3.mo488toPx0680j_4(f2));
        int iCeil2 = (int) Math.ceil(measureScope3.mo488toPx0680j_4(f3));
        long jM1117constructorimpl = OrientationIndependentConstraints.m1117constructorimpl(0, iM8783getMaxWidthimpl, 0, iM8782getMaxHeightimpl);
        long jM1132toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m1132toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m1121copyyUG9Ft0$default(jM1117constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope3.mo485toDpu2uoSUM(iM8783getMaxWidthimpl), measureScope3.mo485toDpu2uoSUM(iM8782getMaxHeightimpl), null) : null;
        Measurable measurableSafeNext = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
        IntIntPair intIntPairM24boximpl2 = measurableSafeNext != null ? IntIntPair.m24boximpl(m993measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy, jM1132toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlowLayoutKt.breakDownItems_di9J0FM$lambda$0$0(objectRef, (Placeable) obj);
            }
        })) : null;
        Integer numValueOf = intIntPairM24boximpl2 != null ? Integer.valueOf(IntIntPair.m31getFirstimpl(intIntPairM24boximpl2.getPackedValue())) : null;
        Integer numValueOf2 = intIntPairM24boximpl2 != null ? Integer.valueOf(IntIntPair.m32getSecondimpl(intIntPairM24boximpl2.getPackedValue())) : null;
        Integer numValueOf3 = numValueOf;
        Measurable measurable = measurableSafeNext;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        MutableIntSet mutableIntSetMutableIntSetOf = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j, i2, iCeil, iCeil2, null);
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM988getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(it2.hasNext(), 0, IntIntPair.m27constructorimpl(iM8783getMaxWidthimpl, iM8782getMaxHeightimpl), intIntPairM24boximpl2, 0, 0, 0, false, false);
        if (wrapInfoM988getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM988getWrapInfoOpUlnko, intIntPairM24boximpl2 != null, -1, 0, iM8783getMaxWidthimpl, 0);
            i3 = iM8783getMaxWidthimpl;
        } else {
            i3 = iM8783getMaxWidthimpl;
            wrapEllipsisInfo = null;
        }
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i14 = i3;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoM988getWrapInfoOpUlnko;
        int iMax = iM8785getMinWidthimpl;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z2 = false;
        int i18 = 0;
        int i19 = 0;
        MutableIntSet mutableIntSet = mutableIntSetMutableIntSetOf;
        int i20 = iM8782getMaxHeightimpl;
        Measurable measurableSafeNext2 = measurable;
        int i21 = 0;
        while (!wrapInfo.getIsLastItemInContainer() && measurableSafeNext2 != null) {
            Intrinsics.checkNotNull(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            Intrinsics.checkNotNull(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i22 = i3;
            int i23 = i17 + iIntValue;
            int iMax2 = Math.max(i16, numValueOf2.intValue());
            int i24 = i14 - iIntValue;
            int i25 = i15 + 1;
            int i26 = iMax;
            flowLayoutOverflowState.setItemShown$foundation_layout(i25);
            arrayList.add(measurableSafeNext2);
            mutableIntObjectMapMutableIntObjectMapOf.set(i15, objectRef.element);
            Object parentData = measurableSafeNext2.getParentData();
            RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) != null) {
                z2 = true;
            }
            int i27 = i25 - i21;
            boolean z3 = i27 < i;
            if (flowLineInfo != null) {
                if (z3) {
                    i8 = i27;
                    i11 = i18;
                } else {
                    i8 = i27;
                    i11 = i18 + 1;
                }
                int i28 = z3 ? i8 : 0;
                if (z3) {
                    int i29 = i24 - iCeil;
                    z = z3;
                    i12 = i29 < 0 ? 0 : i29;
                } else {
                    z = z3;
                    i12 = i22;
                }
                float f4 = measureScope3.mo485toDpu2uoSUM(i12);
                if (z) {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i13 = i20;
                } else {
                    int i30 = (i20 - iMax2) - iCeil2;
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i13 = i30 < 0 ? 0 : i30;
                }
                flowLineInfo.m1005update4j6BHR0$foundation_layout(i11, i28, f4, measureScope3.mo485toDpu2uoSUM(i13));
                Unit unit = Unit.INSTANCE;
            } else {
                i8 = i27;
                mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
            }
            measurableSafeNext2 = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
            objectRef.element = null;
            IntIntPair intIntPairM24boximpl3 = measurableSafeNext2 != null ? IntIntPair.m24boximpl(m993measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy, jM1132toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FlowLayoutKt.breakDownItems_di9J0FM$lambda$2$0(objectRef, (Placeable) obj);
                }
            })) : null;
            Integer numValueOf4 = intIntPairM24boximpl3 != null ? Integer.valueOf(IntIntPair.m31getFirstimpl(intIntPairM24boximpl3.getPackedValue()) + iCeil) : null;
            numValueOf2 = intIntPairM24boximpl3 != null ? Integer.valueOf(IntIntPair.m32getSecondimpl(intIntPairM24boximpl3.getPackedValue())) : null;
            boolean zHasNext = it2.hasNext();
            int i31 = i18;
            long jM27constructorimpl = IntIntPair.m27constructorimpl(i24, i20);
            if (intIntPairM24boximpl3 == null) {
                intIntPairM24boximpl = null;
            } else {
                Intrinsics.checkNotNull(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                Intrinsics.checkNotNull(numValueOf2);
                intIntPairM24boximpl = IntIntPair.m24boximpl(IntIntPair.m27constructorimpl(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM988getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m988getWrapInfoOpUlnko(zHasNext, i8, jM27constructorimpl, intIntPairM24boximpl, i31, i19, iMax2, false, false);
            if (wrapInfoM988getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int iMin = Math.min(Math.max(i26, i23), i22);
                int i32 = i19 + iMax2;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM988getWrapInfoOpUlnko2, intIntPairM24boximpl3 != null, i31, i32, i24, i8);
                mutableIntList2 = mutableIntList6;
                mutableIntList2.add(iMax2);
                MutableIntSet mutableIntSet2 = mutableIntSet;
                if (z2) {
                    mutableIntSet2.plusAssign(i31);
                }
                int i33 = (iM8782getMaxHeightimpl - i32) - iCeil2;
                mutableIntSet = mutableIntSet2;
                mutableIntList = mutableIntList5;
                mutableIntList.add(i25);
                i18 = i31 + 1;
                i19 = i32 + iCeil2;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                i22 = i22;
                i21 = i25;
                i23 = 0;
                z2 = false;
                i9 = 0;
                i10 = iMin;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                i20 = i33;
                i14 = i22;
            } else {
                i9 = iMax2;
                mutableIntList = mutableIntList5;
                mutableIntList2 = mutableIntList6;
                numValueOf3 = numValueOf4;
                i14 = i24;
                i18 = i31;
                i10 = i26;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            mutableIntList5 = mutableIntList;
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            mutableIntSet = mutableIntSet;
            iMax = i10;
            i15 = i25;
            mutableIntObjectMapMutableIntObjectMapOf = mutableIntObjectMap2;
            wrapInfo = wrapInfoM988getWrapInfoOpUlnko2;
            it2 = it;
            mutableIntList4 = mutableIntList2;
            i17 = i23;
            i3 = i22;
            i16 = i9;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapMutableIntObjectMapOf;
        MutableIntList mutableIntList7 = mutableIntList4;
        MutableIntList mutableIntList8 = mutableIntList5;
        MutableIntSet mutableIntSet3 = mutableIntSet;
        if (wrapEllipsisInfo3 != null) {
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            MutableIntList mutableIntList9 = mutableIntList8;
            int i34 = mutableIntList9._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int i35 = mutableIntList9._size - 1;
                mutableIntList7.set(i34, Math.max(mutableIntList7.get(i34), IntIntPair.m32getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList8.set(i35, mutableIntList8.last() + 1);
                Unit unit2 = Unit.INSTANCE;
            } else {
                mutableIntList7.add(IntIntPair.m32getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                Boolean.valueOf(mutableIntList8.add(mutableIntList8.last() + 1));
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size = arrayList.size();
        ?? r4 = new Placeable[size];
        for (int i36 = 0; i36 < size; i36++) {
            r4[i36] = mutableIntObjectMap.get(i36);
        }
        MutableIntList mutableIntList10 = mutableIntList8;
        int[] iArr3 = new int[mutableIntList10._size];
        int[] iArr4 = new int[mutableIntList10._size];
        int[] iArr5 = mutableIntList10.content;
        int i37 = mutableIntList10._size;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        ?? r42 = r4;
        while (i39 < i37) {
            int i41 = iArr5[i39];
            int iM8782getMaxHeightimpl2 = mutableIntList7.get(i39);
            if (!mutableIntSet3.contains(i39)) {
                iM8782getMaxHeightimpl2 = Constraints.m8782getMaxHeightimpl(jM1117constructorimpl) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Constraints.m8782getMaxHeightimpl(jM1117constructorimpl) - i40;
            }
            int i42 = i37;
            MutableIntSet mutableIntSet4 = mutableIntSet3;
            int[] iArr6 = iArr3;
            ?? r8 = r42;
            MutableIntList mutableIntList11 = mutableIntList7;
            MeasureResult measureResultMeasure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, iMax, Constraints.m8784getMinHeightimpl(jM1117constructorimpl), Constraints.m8783getMaxWidthimpl(jM1117constructorimpl), iM8782getMaxHeightimpl2, iCeil, measureScope3, arrayList, r8, i38, i41, iArr6, i39);
            if (flowLineMeasurePolicy.isHorizontal()) {
                i6 = measureResultMeasure.getWidth();
                i7 = measureResultMeasure.getHeight();
            } else {
                i6 = measureResultMeasure.getHeight();
                i7 = measureResultMeasure.getWidth();
            }
            iArr4[i39] = i7;
            i40 += i7;
            iMax = Math.max(iMax, i6);
            mutableVector.add(measureResultMeasure);
            i39++;
            r42 = r8;
            i38 = i41;
            iArr3 = iArr6;
            i37 = i42;
            mutableIntSet3 = mutableIntSet4;
            mutableIntList7 = mutableIntList11;
            measureScope3 = measureScope;
        }
        int[] iArr7 = iArr3;
        if (mutableVector.getSize() == 0) {
            i4 = 0;
            i5 = 0;
            measureScope2 = measureScope;
            j2 = j;
            iArr = iArr7;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr2 = iArr4;
        } else {
            i4 = iMax;
            i5 = i40;
            measureScope2 = measureScope;
            iArr = iArr7;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr2 = iArr4;
            j2 = j;
        }
        return m994placeHelperBmaY500(measureScope2, j2, i4, i5, iArr2, mutableVector, flowLineMeasurePolicy2, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeHelper_BmaY500$lambda$2(MutableVector mutableVector, Placeable.PlacementScope placementScope) {
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            ((MeasureResult) objArr[i]).placeChildren();
        }
        return Unit.INSTANCE;
    }
}
