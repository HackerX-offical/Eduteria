package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.FlexAlignContent;
import androidx.compose.foundation.layout.FlexAlignItems;
import androidx.compose.foundation.layout.FlexAlignSelf;
import androidx.compose.foundation.layout.FlexWrap;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: FlexBox.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019Jl\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J+\u0010)\u001a\u00020\"*\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u0017*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b.\u0010/Jt\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010(\u001a\u00020&2\u0006\u00101\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001b04H\u0082\b¢\u0006\u0004\b5\u00106JW\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001f2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00109\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010:\u001a\u00020&H\u0002¢\u0006\u0004\b;\u0010<JP\u0010=\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&H\u0002JG\u0010B\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\b2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002¢\u0006\u0004\bD\u0010EJ_\u0010F\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010C\u001a\u00020&2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0015H\u0002¢\u0006\u0004\bG\u0010HJ@\u0010I\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010J\u001a\u00020&2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010C\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002J$\u0010K\u001a\u00020&*\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` 2\u0006\u0010L\u001a\u00020\u0017H\u0002JH\u0010M\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010A\u001a\u00020&2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020&2\u0006\u0010N\u001a\u00020\u0017H\u0002J?\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020&2\u0006\u0010S\u001a\u00020&2\u0006\u0010T\u001a\u00020&2\u0006\u0010U\u001a\u00020VH\u0002¢\u0006\u0004\bW\u0010XJ\u0018\u0010Y\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010Z\u001a\u00020\u001b2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001ej\b\u0012\u0004\u0012\u00020\"` 2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020&H\u0002J0\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010T\u001a\u00020&2\u0006\u0010]\u001a\u00020\u00172\u0006\u0010:\u001a\u00020&H\u0002J\"\u0010^\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010b\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J\"\u0010d\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010a\u001a\u00020&H\u0016J\"\u0010e\u001a\u00020&*\u00020_2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020`0\r2\u0006\u0010c\u001a\u00020&H\u0016J'\u0010f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\bi\u0010jR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Landroidx/compose/foundation/layout/FlexBoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "flexBoxConfigState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/layout/FlexBoxConfig;", "<init>", "(Landroidx/compose/runtime/State;)V", "resolvedFlexBoxConfig", "Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measureFlexBox", "flexBoxConfig", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "isHorizontal", "", "measureFlexBox-w1Onq5I", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/List;JZ)Landroidx/compose/ui/layout/MeasureResult;", "placeFlexItems", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "lines", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/layout/FlexLine;", "Lkotlin/collections/ArrayList;", FirebaseAnalytics.Param.ITEMS, "Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutWidth", "", "layoutHeight", "mainAxisGap", "createFlexItem", "measurable", "createFlexItem-XsoA538", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;ZJ)Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;", "needUpfrontCrossAxisCalculation", "needUpfrontCrossAxisCalculation-RMq0m1M", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;J)Z", "buildFlexLines", "crossAxisGap", "needsUpfrontCrossAxisCalculation", "updateTotalCrossSize", "Lkotlin/Function1;", "buildFlexLines-JlE-8fw", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JIIZLkotlin/jvm/functions/Function1;)Ljava/util/ArrayList;", "processFlexLine", "line", "currentLineHypotheticalMainAxisSize", "remainingCrossAxisSize", "processFlexLine-7gjidqw", "(Landroidx/compose/foundation/layout/FlexLine;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJI)V", "resolveFlexibleLengths", "startIndex", "endIndex", "hypotheticalLineSize", "containerMainAxisSize", "applyAlignContentStretch", "totalLinesCrossSize", "applyAlignContentStretch-WWvErGg", "(Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;Ljava/util/ArrayList;JII)I", "measureFlexItems", "measureFlexItems-HjG58DU", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;IZJ)I", "calculateLineCrossPositions", "totalCrossAxisSpace", "totalCrossAxisSize", "isReverse", "positionItemsOnMainAxis", "isMainAxisReverse", "calculateItemCrossPosition", "flexConfig", "itemBaseline", "lineMaxAboveBaseline", "itemCrossAxisSize", "lineCrossAxisSize", "containerAlignItems", "Landroidx/compose/foundation/layout/FlexAlignItems;", "calculateItemCrossPosition-sT6f14c", "(Landroidx/compose/foundation/layout/ResolvedFlexItemInfo;IIIII)I", "isMainAxisReversedForLayout", "calculateLineCrossAxisSize", "measureItem", "item", "shouldStretch", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", "maxIntrinsicHeight", "resolveFlexBoxConfig", "density", "Landroidx/compose/ui/unit/Density;", "resolveFlexBoxConfig-3p2s80s", "(Landroidx/compose/foundation/layout/FlexBoxConfig;Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/ResolvedFlexBoxConfig;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlexBoxMeasurePolicy implements MeasurePolicy {
    private final State<FlexBoxConfig> flexBoxConfigState;
    private final ResolvedFlexBoxConfig resolvedFlexBoxConfig = new ResolvedFlexBoxConfig();

    /* JADX WARN: Multi-variable type inference failed */
    public FlexBoxMeasurePolicy(State<? extends FlexBoxConfig> state) {
        this.flexBoxConfigState = state;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.MeasureResult mo44measure3p2s80s(androidx.compose.ui.layout.MeasureScope r9, java.util.List<? extends androidx.compose.ui.layout.Measurable> r10, long r11) {
        /*
            r8 = this;
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L1c
            int r2 = androidx.compose.ui.unit.Constraints.m8785getMinWidthimpl(r11)
            int r3 = androidx.compose.ui.unit.Constraints.m8784getMinHeightimpl(r11)
            androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.layout.FlexBoxMeasurePolicy$$ExternalSyntheticLambda0
            r5.<init>()
            r6 = 4
            r7 = 0
            r4 = 0
            r1 = r9
            androidx.compose.ui.layout.MeasureResult r9 = androidx.compose.ui.layout.MeasureScope.layout$default(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L1c:
            r1 = r9
            androidx.compose.runtime.State<androidx.compose.foundation.layout.FlexBoxConfig> r9 = r8.flexBoxConfigState
            java.lang.Object r9 = r9.getValue()
            androidx.compose.foundation.layout.FlexBoxConfig r9 = (androidx.compose.foundation.layout.FlexBoxConfig) r9
            r0 = r1
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.foundation.layout.ResolvedFlexBoxConfig r2 = r8.m944resolveFlexBoxConfig3p2s80s(r9, r0, r11)
            int r9 = r2.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r0 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r0 = 0
            int r3 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r0)
            boolean r9 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r9, r3)
            r3 = 2
            if (r9 != 0) goto L52
            int r9 = r2.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r4 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            int r4 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r3)
            boolean r9 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r9, r4)
            if (r9 == 0) goto L4f
            goto L52
        L4f:
            androidx.compose.foundation.layout.LayoutOrientation r9 = androidx.compose.foundation.layout.LayoutOrientation.Vertical
            goto L54
        L52:
            androidx.compose.foundation.layout.LayoutOrientation r9 = androidx.compose.foundation.layout.LayoutOrientation.Horizontal
        L54:
            long r4 = androidx.compose.foundation.layout.OrientationIndependentConstraints.m1119constructorimpl(r11, r9)
            int r9 = r2.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r11 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            int r11 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r0)
            boolean r9 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r9, r11)
            if (r9 != 0) goto L78
            int r9 = r2.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r11 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            int r11 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r3)
            boolean r9 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r9, r11)
            if (r9 == 0) goto L79
        L78:
            r0 = 1
        L79:
            r3 = r10
            r6 = r0
            r0 = r8
            androidx.compose.ui.layout.MeasureResult r9 = r0.m940measureFlexBoxw1Onq5I(r1, r2, r3, r4, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.mo44measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX INFO: renamed from: measureFlexBox-w1Onq5I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.ui.layout.MeasureResult m940measureFlexBoxw1Onq5I(final androidx.compose.ui.layout.MeasureScope r25, final androidx.compose.foundation.layout.ResolvedFlexBoxConfig r26, java.util.List<? extends androidx.compose.ui.layout.Measurable> r27, long r28, final boolean r30) {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.m940measureFlexBoxw1Onq5I(androidx.compose.ui.layout.MeasureScope, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, java.util.List, long, boolean):androidx.compose.ui.layout.MeasureResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureFlexBox_w1Onq5I$lambda$4(FlexBoxMeasurePolicy flexBoxMeasurePolicy, ArrayList arrayList, ArrayList arrayList2, MeasureScope measureScope, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z, Placeable.PlacementScope placementScope) {
        flexBoxMeasurePolicy.placeFlexItems(placementScope, arrayList, arrayList2, measureScope.getLayoutDirection(), resolvedFlexBoxConfig, i, i2, i3, z);
        return Unit.INSTANCE;
    }

    private final void placeFlexItems(Placeable.PlacementScope placementScope, ArrayList<FlexLine> arrayList, ArrayList<ResolvedFlexItemInfo> arrayList2, LayoutDirection layoutDirection, ResolvedFlexBoxConfig resolvedFlexBoxConfig, int i, int i2, int i3, boolean z) {
        int crossPosition;
        int mainPosition;
        ArrayList<FlexLine> arrayList3 = arrayList;
        int size = arrayList3.size();
        for (int i4 = 0; i4 < size; i4++) {
            FlexLine flexLine = arrayList3.get(i4);
            positionItemsOnMainAxis(arrayList2, resolvedFlexBoxConfig, z ? i : i2, flexLine, i3, isMainAxisReversedForLayout(resolvedFlexBoxConfig, layoutDirection));
            int startIndex = flexLine.getStartIndex();
            int endIndex = flexLine.getEndIndex();
            if (startIndex < 0 || startIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + startIndex + ") is out of bounds [0, " + arrayList2.size() + ']');
            }
            if (endIndex < 0 || endIndex > arrayList2.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList2.size() + ']');
            }
            while (startIndex < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList2.get(startIndex);
                if (z) {
                    crossPosition = resolvedFlexItemInfo.getMainPosition();
                } else {
                    crossPosition = resolvedFlexItemInfo.getCrossPosition();
                }
                int i5 = crossPosition;
                if (z) {
                    mainPosition = resolvedFlexItemInfo.getCrossPosition();
                } else {
                    mainPosition = resolvedFlexItemInfo.getMainPosition();
                }
                int i6 = mainPosition;
                Placeable placeable = resolvedFlexItemInfo.getPlaceable();
                if (placeable != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i5, i6, 0.0f, 4, null);
                }
                startIndex++;
            }
        }
    }

    /* JADX INFO: renamed from: createFlexItem-XsoA538, reason: not valid java name */
    private final ResolvedFlexItemInfo m939createFlexItemXsoA538(MeasureScope measureScope, Measurable measurable, boolean z, long j) {
        int maxContentSize$foundation_layout;
        Object parentData = measurable.getParentData();
        FlexBoxChildDataNode flexBoxChildDataNode = parentData instanceof FlexBoxChildDataNode ? (FlexBoxChildDataNode) parentData : null;
        ResolvedFlexItemInfo resolvedFlexItemInfo = new ResolvedFlexItemInfo();
        if (flexBoxChildDataNode != null) {
            resolvedFlexItemInfo.m1195prepareRMq0m1M(measureScope, j);
            flexBoxChildDataNode.getConfig().configure(resolvedFlexItemInfo);
        }
        resolvedFlexItemInfo.setMeasurable(measurable);
        int minMainAxisSize$foundation_layout = resolvedFlexItemInfo.getMinMainAxisSize$foundation_layout(z);
        if (FlexBasis.m918isDpimpl$foundation_layout(resolvedFlexItemInfo.getBasis())) {
            maxContentSize$foundation_layout = measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(FlexBasis.m915getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis())));
        } else if (!FlexBasis.m919isPercentimpl$foundation_layout(resolvedFlexItemInfo.getBasis())) {
            maxContentSize$foundation_layout = FlexBasis.m917isAutoimpl$foundation_layout(resolvedFlexItemInfo.getBasis()) ? resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z) : resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else if (Constraints.m8783getMaxWidthimpl(j) == Integer.MAX_VALUE || Float.isNaN(FlexBasis.m915getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis()))) {
            maxContentSize$foundation_layout = resolvedFlexItemInfo.getMaxContentSize$foundation_layout(z);
        } else {
            maxContentSize$foundation_layout = (int) (Constraints.m8783getMaxWidthimpl(j) * FlexBasis.m915getValueimpl$foundation_layout(resolvedFlexItemInfo.getBasis()));
        }
        resolvedFlexItemInfo.setFlexBaseSize(maxContentSize$foundation_layout);
        if (maxContentSize$foundation_layout >= minMainAxisSize$foundation_layout) {
            minMainAxisSize$foundation_layout = maxContentSize$foundation_layout;
        }
        resolvedFlexItemInfo.setHypotheticalMainSize(minMainAxisSize$foundation_layout);
        resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
        return resolvedFlexItemInfo;
    }

    /* JADX INFO: renamed from: needUpfrontCrossAxisCalculation-RMq0m1M, reason: not valid java name */
    private final boolean m942needUpfrontCrossAxisCalculationRMq0m1M(ResolvedFlexBoxConfig resolvedFlexBoxConfig, long j) {
        int alignItems = resolvedFlexBoxConfig.getAlignItems();
        FlexAlignItems.Companion companion = FlexAlignItems.INSTANCE;
        if (!FlexAlignItems.m889equalsimpl0(alignItems, FlexAlignItems.m887constructorimpl(3))) {
            int alignItems2 = resolvedFlexBoxConfig.getAlignItems();
            FlexAlignItems.Companion companion2 = FlexAlignItems.INSTANCE;
            if (!FlexAlignItems.m889equalsimpl0(alignItems2, FlexAlignItems.m887constructorimpl(4))) {
                int wrap = resolvedFlexBoxConfig.getWrap();
                FlexWrap.Companion companion3 = FlexWrap.INSTANCE;
                if (!FlexWrap.m975equalsimpl0(wrap, FlexWrap.m973constructorimpl(1))) {
                    int wrap2 = resolvedFlexBoxConfig.getWrap();
                    FlexWrap.Companion companion4 = FlexWrap.INSTANCE;
                    if (!FlexWrap.m975equalsimpl0(wrap2, FlexWrap.m973constructorimpl(2))) {
                        return false;
                    }
                }
                int alignContent = resolvedFlexBoxConfig.getAlignContent();
                FlexAlignContent.Companion companion5 = FlexAlignContent.INSTANCE;
                if (!FlexAlignContent.m876equalsimpl0(alignContent, FlexAlignContent.m874constructorimpl(3)) || Constraints.m8782getMaxHeightimpl(j) == Integer.MAX_VALUE) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004f  */
    /* JADX INFO: renamed from: buildFlexLines-JlE-8fw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.ArrayList<androidx.compose.foundation.layout.FlexLine> m937buildFlexLinesJlE8fw(androidx.compose.foundation.layout.ResolvedFlexBoxConfig r18, java.util.ArrayList<androidx.compose.foundation.layout.ResolvedFlexItemInfo> r19, long r20, int r22, int r23, boolean r24, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r25) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.m937buildFlexLinesJlE8fw(androidx.compose.foundation.layout.ResolvedFlexBoxConfig, java.util.ArrayList, long, int, int, boolean, kotlin.jvm.functions.Function1):java.util.ArrayList");
    }

    private final int resolveFlexibleLengths(boolean isHorizontal, ArrayList<ResolvedFlexItemInfo> items, ResolvedFlexBoxConfig flexBoxConfig, int startIndex, int endIndex, int hypotheticalLineSize, int containerMainAxisSize) {
        int i;
        boolean z;
        ArrayList<ResolvedFlexItemInfo> arrayList = items;
        int i2 = startIndex;
        int i3 = containerMainAxisSize;
        int i4 = endIndex - i2;
        int iMainAxisGap = i4 > 0 ? (i4 - 1) * flexBoxConfig.mainAxisGap() : 0;
        if (i3 == Integer.MAX_VALUE) {
            if (i2 < 0 || i2 > arrayList.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + ']');
            }
            if (endIndex < 0 || endIndex > arrayList.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList.size() + ']');
            }
            while (i2 < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo = arrayList.get(i2);
                resolvedFlexItemInfo.setTargetMainSize(resolvedFlexItemInfo.getHypotheticalMainSize());
                iMainAxisGap += resolvedFlexItemInfo.getTargetMainSize();
                i2++;
            }
            return iMainAxisGap;
        }
        boolean z2 = hypotheticalLineSize < i3;
        if (i2 < 0 || i2 > arrayList.size()) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + items.size() + ']');
        }
        if (endIndex < 0 || endIndex > arrayList.size()) {
            throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + ']');
        }
        int targetMainSize = 0;
        int flexBaseSize = 0;
        float shrink$foundation_layout = 0.0f;
        float grow$foundation_layout = 0.0f;
        int i5 = 0;
        float shrink$foundation_layout2 = 0.0f;
        for (int i6 = i2; i6 < endIndex; i6++) {
            ResolvedFlexItemInfo resolvedFlexItemInfo2 = arrayList.get(i6);
            float grow$foundation_layout2 = z2 ? resolvedFlexItemInfo2.getGrow() : resolvedFlexItemInfo2.getShrink();
            if (grow$foundation_layout2 == 0.0f || (!z2 && resolvedFlexItemInfo2.getFlexBaseSize() <= resolvedFlexItemInfo2.getHypotheticalMainSize())) {
                resolvedFlexItemInfo2.setTargetMainSize(resolvedFlexItemInfo2.getHypotheticalMainSize());
                resolvedFlexItemInfo2.setFrozen(true);
                targetMainSize += resolvedFlexItemInfo2.getTargetMainSize();
            } else {
                resolvedFlexItemInfo2.setFrozen(false);
                i5++;
                flexBaseSize += resolvedFlexItemInfo2.getFlexBaseSize();
                shrink$foundation_layout += grow$foundation_layout2;
                if (z2) {
                    grow$foundation_layout += resolvedFlexItemInfo2.getGrow();
                } else {
                    shrink$foundation_layout2 += resolvedFlexItemInfo2.getShrink() * resolvedFlexItemInfo2.getFlexBaseSize();
                }
            }
        }
        int targetMainSize2 = 0;
        float f2 = ((i3 - iMainAxisGap) - targetMainSize) - flexBaseSize;
        float f3 = 1.0f;
        if (z2) {
            float f4 = i3 - ((iMainAxisGap + targetMainSize) + flexBaseSize);
            if (shrink$foundation_layout < 1.0f) {
                float f5 = f2 * shrink$foundation_layout;
                if (Math.abs(f5) < Math.abs(f4)) {
                    f4 = f5;
                }
            }
            if (i2 < 0 || i2 > arrayList.size()) {
                throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + arrayList.size() + ']');
            }
            if (endIndex < 0 || endIndex > arrayList.size()) {
                throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + arrayList.size() + ']');
            }
            while (i2 < endIndex) {
                ResolvedFlexItemInfo resolvedFlexItemInfo3 = arrayList.get(i2);
                if (!resolvedFlexItemInfo3.getIsFrozen()) {
                    int iRound = Math.round((grow$foundation_layout > 0.0f ? resolvedFlexItemInfo3.getGrow() / grow$foundation_layout : 0.0f) * f4);
                    f4 -= iRound;
                    grow$foundation_layout -= resolvedFlexItemInfo3.getGrow();
                    resolvedFlexItemInfo3.setTargetMainSize(resolvedFlexItemInfo3.getFlexBaseSize() + iRound);
                    targetMainSize2 += resolvedFlexItemInfo3.getTargetMainSize();
                }
                i2++;
            }
        } else {
            int i7 = 0;
            int targetMainSize3 = 0;
            boolean z3 = true;
            while (z3 && i7 < i4) {
                i7++;
                if (i5 == 0) {
                    targetMainSize2 = 0;
                    break;
                }
                float f6 = i3 - ((iMainAxisGap + targetMainSize) + flexBaseSize);
                if (shrink$foundation_layout < f3) {
                    float f7 = f2 * shrink$foundation_layout;
                    if (Math.abs(f7) < Math.abs(f6)) {
                        f6 = f7;
                    }
                }
                float fAbs = Math.abs(f6);
                if (i2 < 0 || i2 > arrayList.size()) {
                    throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is out of bounds [0, " + items.size() + ']');
                }
                if (endIndex < 0 || endIndex > arrayList.size()) {
                    throw new IndexOutOfBoundsException("toIndex (" + endIndex + ") is out of bounds [0, " + items.size() + ']');
                }
                int i8 = i2;
                float flexBaseSize2 = fAbs;
                float f8 = shrink$foundation_layout2;
                z3 = false;
                targetMainSize3 = 0;
                while (i8 < endIndex) {
                    ResolvedFlexItemInfo resolvedFlexItemInfo4 = arrayList.get(i8);
                    if (resolvedFlexItemInfo4.getIsFrozen()) {
                        i = i4;
                        z = true;
                    } else {
                        float shrink$foundation_layout3 = resolvedFlexItemInfo4.getShrink() * resolvedFlexItemInfo4.getFlexBaseSize();
                        int iRound2 = Math.round((f8 > 0.0f ? shrink$foundation_layout3 / f8 : 0.0f) * flexBaseSize2);
                        int flexBaseSize3 = resolvedFlexItemInfo4.getFlexBaseSize() - iRound2;
                        i = i4;
                        float f9 = flexBaseSize2;
                        int minMainAxisSize$foundation_layout = resolvedFlexItemInfo4.getMinMainAxisSize$foundation_layout(isHorizontal);
                        if (flexBaseSize3 < minMainAxisSize$foundation_layout) {
                            z = true;
                            resolvedFlexItemInfo4.setFrozen(true);
                            f8 -= shrink$foundation_layout3;
                            resolvedFlexItemInfo4.setTargetMainSize(minMainAxisSize$foundation_layout);
                            i5--;
                            targetMainSize += minMainAxisSize$foundation_layout;
                            flexBaseSize -= resolvedFlexItemInfo4.getFlexBaseSize();
                            shrink$foundation_layout2 -= shrink$foundation_layout3;
                            shrink$foundation_layout -= resolvedFlexItemInfo4.getShrink();
                            flexBaseSize2 = f9 - (resolvedFlexItemInfo4.getFlexBaseSize() - minMainAxisSize$foundation_layout);
                            z3 = true;
                        } else {
                            z = true;
                            flexBaseSize2 = f9 - iRound2;
                            f8 -= shrink$foundation_layout3;
                            resolvedFlexItemInfo4.setTargetMainSize(flexBaseSize3);
                            targetMainSize3 += resolvedFlexItemInfo4.getTargetMainSize();
                        }
                    }
                    i8++;
                    arrayList = items;
                    i4 = i;
                }
                arrayList = items;
                i3 = containerMainAxisSize;
                f3 = 1.0f;
            }
            targetMainSize2 = targetMainSize3;
        }
        return iMainAxisGap + targetMainSize + targetMainSize2;
    }

    /* JADX INFO: renamed from: applyAlignContentStretch-WWvErGg, reason: not valid java name */
    private final int m936applyAlignContentStretchWWvErGg(ResolvedFlexBoxConfig flexBoxConfig, ArrayList<FlexLine> lines, long constraints, int totalLinesCrossSize, int crossAxisGap) {
        int alignContent = flexBoxConfig.getAlignContent();
        FlexAlignContent.Companion companion = FlexAlignContent.INSTANCE;
        if (FlexAlignContent.m876equalsimpl0(alignContent, FlexAlignContent.m874constructorimpl(3)) && Constraints.m8784getMinHeightimpl(constraints) != Integer.MAX_VALUE && !lines.isEmpty() && lines.size() != 1) {
            int size = (lines.size() - 1) * crossAxisGap;
            int iM8784getMinHeightimpl = Constraints.m8784getMinHeightimpl(constraints);
            if (totalLinesCrossSize + size < iM8784getMinHeightimpl) {
                int i = (iM8784getMinHeightimpl - totalLinesCrossSize) - size;
                if (i < 0) {
                    i = 0;
                }
                int size2 = i / lines.size();
                ArrayList<FlexLine> arrayList = lines;
                int size3 = arrayList.size();
                int i2 = totalLinesCrossSize;
                int crossAxisSize = 0;
                for (int i3 = 0; i3 < size3; i3++) {
                    FlexLine flexLine = arrayList.get(i3);
                    flexLine.setCrossStart(crossAxisSize);
                    flexLine.setCrossAxisSize(flexLine.getCrossAxisSize() + size2);
                    crossAxisSize += flexLine.getCrossAxisSize() + crossAxisGap;
                    i2 += size2;
                }
                return i2;
            }
        }
        return totalLinesCrossSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void calculateLineCrossPositions(androidx.compose.foundation.layout.ResolvedFlexBoxConfig r6, int r7, java.util.ArrayList<androidx.compose.foundation.layout.FlexLine> r8, int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.calculateLineCrossPositions(androidx.compose.foundation.layout.ResolvedFlexBoxConfig, int, java.util.ArrayList, int, int):void");
    }

    private final int totalCrossAxisSize(ArrayList<FlexLine> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        int lastIndex = z ? 0 : CollectionsKt.getLastIndex(arrayList);
        return arrayList.get(lastIndex).getCrossStart() + arrayList.get(lastIndex).getCrossAxisSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void positionItemsOnMainAxis(java.util.ArrayList<androidx.compose.foundation.layout.ResolvedFlexItemInfo> r14, androidx.compose.foundation.layout.ResolvedFlexBoxConfig r15, int r16, androidx.compose.foundation.layout.FlexLine r17, int r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.positionItemsOnMainAxis(java.util.ArrayList, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, int, androidx.compose.foundation.layout.FlexLine, int, boolean):void");
    }

    /* JADX INFO: renamed from: calculateItemCrossPosition-sT6f14c, reason: not valid java name */
    private final int m938calculateItemCrossPositionsT6f14c(ResolvedFlexItemInfo flexConfig, int itemBaseline, int lineMaxAboveBaseline, int itemCrossAxisSize, int lineCrossAxisSize, int containerAlignItems) {
        int iM899constructorimpl;
        int iM1193getAlignSelf_ov7Qcc$foundation_layout = flexConfig.getAlignSelf();
        FlexAlignSelf.Companion companion = FlexAlignSelf.INSTANCE;
        if (!FlexAlignSelf.m901equalsimpl0(iM1193getAlignSelf_ov7Qcc$foundation_layout, FlexAlignSelf.m899constructorimpl(0))) {
            iM899constructorimpl = flexConfig.getAlignSelf();
        } else {
            FlexAlignItems.Companion companion2 = FlexAlignItems.INSTANCE;
            if (!FlexAlignItems.m889equalsimpl0(containerAlignItems, FlexAlignItems.m887constructorimpl(0))) {
                FlexAlignItems.Companion companion3 = FlexAlignItems.INSTANCE;
                if (!FlexAlignItems.m889equalsimpl0(containerAlignItems, FlexAlignItems.m887constructorimpl(1))) {
                    FlexAlignItems.Companion companion4 = FlexAlignItems.INSTANCE;
                    if (!FlexAlignItems.m889equalsimpl0(containerAlignItems, FlexAlignItems.m887constructorimpl(2))) {
                        FlexAlignItems.Companion companion5 = FlexAlignItems.INSTANCE;
                        if (!FlexAlignItems.m889equalsimpl0(containerAlignItems, FlexAlignItems.m887constructorimpl(3))) {
                            FlexAlignItems.Companion companion6 = FlexAlignItems.INSTANCE;
                            if (!FlexAlignItems.m889equalsimpl0(containerAlignItems, FlexAlignItems.m887constructorimpl(4))) {
                                FlexAlignSelf.Companion companion7 = FlexAlignSelf.INSTANCE;
                                iM899constructorimpl = FlexAlignSelf.m899constructorimpl(1);
                            } else {
                                FlexAlignSelf.Companion companion8 = FlexAlignSelf.INSTANCE;
                                iM899constructorimpl = FlexAlignSelf.m899constructorimpl(5);
                            }
                        } else {
                            FlexAlignSelf.Companion companion9 = FlexAlignSelf.INSTANCE;
                            iM899constructorimpl = FlexAlignSelf.m899constructorimpl(4);
                        }
                    } else {
                        FlexAlignSelf.Companion companion10 = FlexAlignSelf.INSTANCE;
                        iM899constructorimpl = FlexAlignSelf.m899constructorimpl(3);
                    }
                } else {
                    FlexAlignSelf.Companion companion11 = FlexAlignSelf.INSTANCE;
                    iM899constructorimpl = FlexAlignSelf.m899constructorimpl(2);
                }
            } else {
                FlexAlignSelf.Companion companion12 = FlexAlignSelf.INSTANCE;
                iM899constructorimpl = FlexAlignSelf.m899constructorimpl(1);
            }
        }
        FlexAlignSelf.Companion companion13 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m901equalsimpl0(iM899constructorimpl, FlexAlignSelf.m899constructorimpl(1))) {
            return 0;
        }
        FlexAlignSelf.Companion companion14 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m901equalsimpl0(iM899constructorimpl, FlexAlignSelf.m899constructorimpl(2))) {
            return lineCrossAxisSize - itemCrossAxisSize;
        }
        FlexAlignSelf.Companion companion15 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m901equalsimpl0(iM899constructorimpl, FlexAlignSelf.m899constructorimpl(3))) {
            return (lineCrossAxisSize - itemCrossAxisSize) / 2;
        }
        FlexAlignSelf.Companion companion16 = FlexAlignSelf.INSTANCE;
        if (FlexAlignSelf.m901equalsimpl0(iM899constructorimpl, FlexAlignSelf.m899constructorimpl(4))) {
            return 0;
        }
        FlexAlignSelf.Companion companion17 = FlexAlignSelf.INSTANCE;
        if (!FlexAlignSelf.m901equalsimpl0(iM899constructorimpl, FlexAlignSelf.m899constructorimpl(5)) || itemBaseline == Integer.MIN_VALUE) {
            return 0;
        }
        return lineMaxAboveBaseline - itemBaseline;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isMainAxisReversedForLayout(androidx.compose.foundation.layout.ResolvedFlexBoxConfig r7, androidx.compose.ui.unit.LayoutDirection r8) {
        /*
            r6 = this;
            int r0 = r7.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r1 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r1 = 2
            int r2 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r1)
            boolean r0 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r0, r2)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L27
            int r0 = r7.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r4 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r4 = 3
            int r4 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r4)
            boolean r0 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r0, r4)
            if (r0 == 0) goto L25
            goto L27
        L25:
            r0 = r3
            goto L28
        L27:
            r0 = r2
        L28:
            int r4 = r7.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r5 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            int r5 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r3)
            boolean r4 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r4, r5)
            if (r4 != 0) goto L4a
            int r7 = r7.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r4 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            int r1 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r1)
            boolean r7 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r7, r1)
            if (r7 == 0) goto L49
            goto L4a
        L49:
            return r0
        L4a:
            androidx.compose.ui.unit.LayoutDirection r7 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r8 != r7) goto L52
            if (r0 != 0) goto L51
            return r2
        L51:
            return r3
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.isMainAxisReversedForLayout(androidx.compose.foundation.layout.ResolvedFlexBoxConfig, androidx.compose.ui.unit.LayoutDirection):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int minIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope r18, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r19, int r20) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.minIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int minIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r18, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r19, int r20) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.minIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int maxIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope r18, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r19, int r20) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.maxIntrinsicWidth(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int maxIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r18, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r19, int r20) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.maxIntrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int):int");
    }

    /* JADX INFO: renamed from: resolveFlexBoxConfig-3p2s80s, reason: not valid java name */
    private final ResolvedFlexBoxConfig m944resolveFlexBoxConfig3p2s80s(FlexBoxConfig flexBoxConfig, Density density, long constraints) {
        this.resolvedFlexBoxConfig.m1185prepare0kLqBqw(density, constraints);
        flexBoxConfig.configure(this.resolvedFlexBoxConfig);
        return this.resolvedFlexBoxConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0022  */
    /* JADX INFO: renamed from: processFlexLine-7gjidqw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m943processFlexLine7gjidqw(androidx.compose.foundation.layout.FlexLine r11, java.util.ArrayList<androidx.compose.foundation.layout.ResolvedFlexItemInfo> r12, androidx.compose.foundation.layout.ResolvedFlexBoxConfig r13, int r14, boolean r15, long r16, int r18) {
        /*
            r10 = this;
            int r0 = r13.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r1 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r1 = 0
            int r2 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r1)
            boolean r0 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r0, r2)
            if (r0 != 0) goto L22
            int r0 = r13.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r2 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r2 = 2
            int r2 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r2)
            boolean r0 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r0, r2)
            if (r0 == 0) goto L23
        L22:
            r1 = 1
        L23:
            r3 = r1
            int r6 = r11.getStartIndex()
            int r7 = r11.getEndIndex()
            int r9 = androidx.compose.ui.unit.Constraints.m8783getMaxWidthimpl(r16)
            r2 = r10
            r4 = r12
            r5 = r13
            r8 = r14
            int r14 = r2.resolveFlexibleLengths(r3, r4, r5, r6, r7, r8, r9)
            r11.setMainAxisSize(r14)
            if (r15 == 0) goto L42
            r14 = r18
            r10.calculateLineCrossAxisSize(r12, r13, r11, r14)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.m943processFlexLine7gjidqw(androidx.compose.foundation.layout.FlexLine, java.util.ArrayList, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, int, boolean, long, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0 A[SYNTHETIC] */
    /* JADX INFO: renamed from: measureFlexItems-HjG58DU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int m941measureFlexItemsHjG58DU(java.util.ArrayList<androidx.compose.foundation.layout.FlexLine> r17, java.util.ArrayList<androidx.compose.foundation.layout.ResolvedFlexItemInfo> r18, androidx.compose.foundation.layout.ResolvedFlexBoxConfig r19, int r20, boolean r21, long r22) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.m941measureFlexItemsHjG58DU(java.util.ArrayList, java.util.ArrayList, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, int, boolean, long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void calculateLineCrossAxisSize(java.util.ArrayList<androidx.compose.foundation.layout.ResolvedFlexItemInfo> r17, androidx.compose.foundation.layout.ResolvedFlexBoxConfig r18, androidx.compose.foundation.layout.FlexLine r19, int r20) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.calculateLineCrossAxisSize(java.util.ArrayList, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, androidx.compose.foundation.layout.FlexLine, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int measureItem(androidx.compose.foundation.layout.ResolvedFlexItemInfo r4, androidx.compose.foundation.layout.ResolvedFlexBoxConfig r5, int r6, boolean r7, int r8) {
        /*
            r3 = this;
            int r0 = r5.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r1 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r1 = 0
            int r2 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r1)
            boolean r0 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r0, r2)
            if (r0 != 0) goto L25
            int r5 = r5.getDirection()
            androidx.compose.foundation.layout.FlexDirection$Companion r0 = androidx.compose.foundation.layout.FlexDirection.INSTANCE
            r0 = 2
            int r0 = androidx.compose.foundation.layout.FlexDirection.m949constructorimpl(r0)
            boolean r5 = androidx.compose.foundation.layout.FlexDirection.m951equalsimpl0(r5, r0)
            if (r5 == 0) goto L23
            goto L25
        L23:
            r5 = r1
            goto L26
        L25:
            r5 = 1
        L26:
            if (r7 == 0) goto L47
            if (r6 <= 0) goto L47
            androidx.compose.ui.unit.Constraints$Companion r7 = androidx.compose.ui.unit.Constraints.INSTANCE
            if (r5 == 0) goto L33
            int r0 = r4.getTargetMainSize()
            goto L38
        L33:
            if (r6 <= r8) goto L37
            r0 = r8
            goto L38
        L37:
            r0 = r6
        L38:
            if (r5 == 0) goto L3e
            if (r6 <= r8) goto L42
            r6 = r8
            goto L42
        L3e:
            int r6 = r4.getTargetMainSize()
        L42:
            long r6 = r7.m8793fixedJhjzzOo(r0, r6)
            goto L66
        L47:
            if (r5 == 0) goto L58
            androidx.compose.ui.unit.Constraints$Companion r6 = androidx.compose.ui.unit.Constraints.INSTANCE
            int r7 = r4.getTargetMainSize()
            int r0 = r4.getTargetMainSize()
            long r6 = r6.m8792fitPrioritizingWidthZbe2FdA(r7, r0, r1, r8)
            goto L66
        L58:
            androidx.compose.ui.unit.Constraints$Companion r6 = androidx.compose.ui.unit.Constraints.INSTANCE
            int r7 = r4.getTargetMainSize()
            int r0 = r4.getTargetMainSize()
            long r6 = r6.m8791fitPrioritizingHeightZbe2FdA(r1, r8, r7, r0)
        L66:
            androidx.compose.ui.layout.Measurable r8 = r4.getMeasurable()
            if (r8 == 0) goto L71
            androidx.compose.ui.layout.Placeable r6 = r8.mo7445measureBRTryo0(r6)
            goto L72
        L71:
            r6 = 0
        L72:
            r4.setPlaceable(r6)
            if (r5 == 0) goto L82
            androidx.compose.ui.layout.Placeable r6 = r4.getPlaceable()
            if (r6 == 0) goto L8d
            int r6 = r6.getHeight()
            goto L8e
        L82:
            androidx.compose.ui.layout.Placeable r6 = r4.getPlaceable()
            if (r6 == 0) goto L8d
            int r6 = r6.getWidth()
            goto L8e
        L8d:
            r6 = r1
        L8e:
            r4.setCrossAxisSize(r6)
            if (r5 == 0) goto L9e
            androidx.compose.ui.layout.Placeable r5 = r4.getPlaceable()
            if (r5 == 0) goto La8
            int r1 = r5.getWidth()
            goto La8
        L9e:
            androidx.compose.ui.layout.Placeable r5 = r4.getPlaceable()
            if (r5 == 0) goto La8
            int r1 = r5.getHeight()
        La8:
            r4.setMainAxisSize(r1)
            int r4 = r4.getCrossAxisSize()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlexBoxMeasurePolicy.measureItem(androidx.compose.foundation.layout.ResolvedFlexItemInfo, androidx.compose.foundation.layout.ResolvedFlexBoxConfig, int, boolean, int):int");
    }
}
