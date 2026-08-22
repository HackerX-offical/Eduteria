package androidx.compose.foundation.layout;

import androidx.collection.LongList;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

/* JADX INFO: compiled from: Grid.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0019\b\b\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\n¢\u0006\u0002\b\u0005H\u0087\b¢\u0006\u0002\u0010\u000b\u001a%\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u0001*\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a5\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002\u001a]\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101\u001ak\u00102\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0014\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u000e2\u0006\u0010+\u001a\u00020,2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010-\u001a\u00020\u001fH\u0002¢\u0006\u0004\b9\u0010:\u001as\u0010;\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u00103\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0014\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010'0\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010=\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010/\u001a\u00020\u001fH\u0002¢\u0006\u0004\b>\u0010?\u001a0\u0010@\u001a\u00020\u001f2\u0006\u00106\u001a\u0002072\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020C2\u0006\u00104\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0018H\u0002\u001a\u0018\u0010D\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a\u0018\u0010F\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a(\u0010G\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001a(\u0010I\u001a\u00020\u001f2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001a\u0018\u0010J\u001a\u00020K2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002\u001a(\u0010L\u001a\u00020K2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010=\u001a\u0002072\u0006\u0010H\u001a\u00020\u001fH\u0002\u001aO\u0010M\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00182\u0006\u0010N\u001a\u0002072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010O\u001a\u00020P2\u0006\u0010+\u001a\u00020,2\b\u0010Q\u001a\u0004\u0018\u0001072\u0006\u0010R\u001a\u00020\u001fH\u0002¢\u0006\u0004\bS\u0010T\u001a(\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2\u0006\u00106\u001a\u0002072\u0006\u0010X\u001a\u0002072\u0006\u00105\u001a\u00020\u001fH\u0002\u001a&\u0010Y\u001a\u00020\u00012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010Z\u001a\u00020#2\u0006\u0010[\u001a\u00020\\H\u0002\u001a\u0018\u0010]\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010^\u001a\u00020\u001fH\u0002\u001a\"\u0010_\u001a\u0002H`\"\u0004\b\u0000\u0010`2\f\u0010a\u001a\b\u0012\u0004\u0012\u0002H`0bH\u0082\b¢\u0006\u0002\u0010c\"\u0016\u0010d\u001a\u00020e8\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bf\u0010g¨\u0006h"}, d2 = {"Grid", "", "config", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/GridConfigurationScope;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/GridScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columns", "specs", "", "Landroidx/compose/foundation/layout/GridTrackSpec;", "(Landroidx/compose/foundation/layout/GridConfigurationScope;[Landroidx/compose/foundation/layout/GridTrackSpec;)V", "rows", "resolveGridItemIndices", "Landroidx/compose/foundation/layout/ResolvedGridItemIndicesResult;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "columnSpecs", "Landroidx/collection/LongList;", "rowSpecs", "flow", "Landroidx/compose/foundation/layout/GridFlow;", "resolveGridItemIndices-pclAfdo", "(Ljava/util/List;Landroidx/collection/LongList;Landroidx/collection/LongList;I)Landroidx/compose/foundation/layout/ResolvedGridItemIndicesResult;", "resolveToZeroBasedIndex", "", FirebaseAnalytics.Param.INDEX, "maxCount", "calculateGridTrackSizes", "Landroidx/compose/foundation/layout/GridTrackSizes;", "density", "Landroidx/compose/ui/unit/Density;", "gridItems", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/layout/GridItem;", "totalColCount", "totalRowCount", "constraints", "Landroidx/compose/ui/unit/Constraints;", "columnGap", "Landroidx/compose/ui/unit/Dp;", "rowGap", "calculateGridTrackSizes-cMe430U", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/MutableObjectList;Landroidx/collection/LongList;Landroidx/collection/LongList;IIJFF)Landroidx/compose/foundation/layout/GridTrackSizes;", "calculateColumnWidths", "explicitSpecs", "totalCount", "availableSpace", "outSizes", "", "itemsByColumn", "calculateColumnWidths-O3s9Psw", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/LongList;II[I[Landroidx/collection/MutableObjectList;JLandroidx/collection/MutableObjectList;I)I", "calculateRowHeights", "itemsByRow", "columnWidths", "calculateRowHeights-ESwBiLc", "(Landroidx/compose/ui/unit/Density;Landroidx/collection/LongList;II[I[Landroidx/collection/MutableObjectList;J[ILandroidx/collection/MutableObjectList;I)I", "distributeFlexSpaceAndGetTotal", "availableTrackSpace", "totalFlex", "", "calculateMaxIntrinsicWidth", FirebaseAnalytics.Param.ITEMS, "calculateMinIntrinsicWidth", "calculateMaxIntrinsicHeight", "fallbackWidth", "calculateMinIntrinsicHeight", "calculateMinMaxIntrinsicWidth", "", "calculateMinMaxIntrinsicHeight", "distributeSpanningSpace", "sizes", "isRowAxis", "", "crossAxisSizes", "gap", "distributeSpanningSpace-WeOhcdQ", "(Landroidx/collection/LongList;[ILandroidx/collection/MutableObjectList;ZJ[II)V", "expandAutoTracks", "autoTrackIndices", "Landroidx/collection/MutableIntList;", "maxSizes", "measureItems", "trackSizes", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateTrackOffsets", "gapPx", "wrapIntrinsicException", ExifInterface.GPS_DIRECTION_TRUE, BlockContactsIQ.ELEMENT, "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "SubcomposeLayoutIntrinsicErrorMessage", "", "getSubcomposeLayoutIntrinsicErrorMessage$annotations", "()V", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class GridKt {
    public static final String SubcomposeLayoutIntrinsicErrorMessage = "Grid intrinsic measurement failed because a SubcomposeLayout (e.g., LazyColumn or LazyRow) was placed inside a track that queries its intrinsic measurements (like `Auto` or `Flex`).\n\nTo fix this, change the track definition to `GridTrackSize.MinMax(min = 0.dp, max = 1.fr)` (or your desired flex weight for max) to explicitly set a minimum base size and bypass the intrinsic measurement pass.";

    public static /* synthetic */ void getSubcomposeLayoutIntrinsicErrorMessage$annotations() {
    }

    private static final int resolveGridItemIndices_pclAfdo$packCoordinate(int i, int i2) {
        return (i << 16) | (i2 & 65535);
    }

    private static final int resolveToZeroBasedIndex(int i, int i2) {
        if (i == 0) {
            return -1;
        }
        if (i > 0) {
            return i - 1;
        }
        int i3 = i2 + i;
        if (i3 >= 0) {
            return i3;
        }
        return -1;
    }

    public static final void Grid(Function1<? super GridConfigurationScope, Unit> function1, Modifier modifier, Function3<? super GridScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1588403050, "CC(Grid)N(config,modifier,content)98@4389L28,104@4693L45,106@4744L132:Grid.kt#2w3rfo");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 1741961271, "CC(remember):Grid.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new GridMeasurePolicy(stateRememberUpdatedState);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        GridMeasurePolicy gridMeasurePolicy = (GridMeasurePolicy) objRememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM5069constructorimpl = Updater.m5069constructorimpl(composer);
        Updater.m5077setimpl(composerM5069constructorimpl, gridMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m5077setimpl(composerM5069constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m5077setimpl(composerM5069constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m5075reconcileimpl(composerM5069constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m5077setimpl(composerM5069constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, 83312277, "C107@4790L9:Grid.kt#2w3rfo");
        function3.invoke(GridScopeInstance.INSTANCE, composer, Integer.valueOf(((i >> 3) & 112) | 6));
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void columns(GridConfigurationScope gridConfigurationScope, GridTrackSpec... gridTrackSpecArr) {
        for (GridTrackSpec gridTrackSpec : gridTrackSpecArr) {
            if (gridTrackSpec instanceof GridTrackSize) {
                gridConfigurationScope.mo1034column118E5d0(((GridTrackSize) gridTrackSpec).getEncodedValue());
            }
        }
    }

    public static final void rows(GridConfigurationScope gridConfigurationScope, GridTrackSpec... gridTrackSpecArr) {
        for (GridTrackSpec gridTrackSpec : gridTrackSpecArr) {
            if (gridTrackSpec instanceof GridTrackSize) {
                gridConfigurationScope.mo1046row118E5d0(((GridTrackSize) gridTrackSpec).getEncodedValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019f  */
    /* JADX INFO: renamed from: resolveGridItemIndices-pclAfdo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.layout.ResolvedGridItemIndicesResult m1071resolveGridItemIndicespclAfdo(java.util.List<? extends androidx.compose.ui.layout.Measurable> r31, androidx.collection.LongList r32, androidx.collection.LongList r33, int r34) {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.GridKt.m1071resolveGridItemIndicespclAfdo(java.util.List, androidx.collection.LongList, androidx.collection.LongList, int):androidx.compose.foundation.layout.ResolvedGridItemIndicesResult");
    }

    private static final boolean resolveGridItemIndices_pclAfdo$isAreaOccupied(MutableIntSet mutableIntSet, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i3 + i;
        if (i6 > 1000 || (i5 = i4 + i2) > 1000) {
            return true;
        }
        while (i < i6) {
            for (int i7 = i2; i7 < i5; i7++) {
                if (mutableIntSet.contains(resolveGridItemIndices_pclAfdo$packCoordinate(i, i7))) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    private static final void resolveGridItemIndices_pclAfdo$markAreaOccupied(MutableIntSet mutableIntSet, int i, int i2, int i3, int i4) {
        int i5 = i3 + i;
        while (i < i5) {
            int i6 = i2 + i4;
            for (int i7 = i2; i7 < i6; i7++) {
                mutableIntSet.add(resolveGridItemIndices_pclAfdo$packCoordinate(i, i7));
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateGridTrackSizes-cMe430U, reason: not valid java name */
    public static final GridTrackSizes m1068calculateGridTrackSizescMe430U(Density density, MutableObjectList<GridItem> mutableObjectList, LongList longList, LongList longList2, int i, int i2, long j, float f2, float f3) {
        int iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(f2);
        int iMo482roundToPx0680j_42 = density.mo482roundToPx0680j_4(f3);
        MutableObjectList[] mutableObjectListArr = new MutableObjectList[i];
        MutableObjectList[] mutableObjectListArr2 = new MutableObjectList[i2];
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i3 = mutableObjectList2._size;
        for (int i4 = 0; i4 < i3; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getColumn() < i) {
                MutableObjectList mutableObjectList3 = mutableObjectListArr[gridItem.getColumn()];
                if (mutableObjectList3 == null) {
                    mutableObjectList3 = new MutableObjectList(0, 1, null);
                    mutableObjectListArr[gridItem.getColumn()] = mutableObjectList3;
                }
                mutableObjectList3.add(gridItem);
            }
            if (gridItem.getRow() < i2) {
                MutableObjectList mutableObjectList4 = mutableObjectListArr2[gridItem.getRow()];
                if (mutableObjectList4 == null) {
                    mutableObjectList4 = new MutableObjectList(0, 1, null);
                    mutableObjectListArr2[gridItem.getRow()] = mutableObjectList4;
                }
                mutableObjectList4.add(gridItem);
            }
        }
        int[] iArr = new int[i];
        int[] iArr2 = new int[i2];
        return new GridTrackSizes(iArr, iArr2, m1067calculateColumnWidthsO3s9Psw(density, longList, i, Constraints.m8783getMaxWidthimpl(j), iArr, mutableObjectListArr, j, mutableObjectList, iMo482roundToPx0680j_4) + (Math.max(0, i - 1) * iMo482roundToPx0680j_4), m1069calculateRowHeightsESwBiLc(density, longList2, i2, Constraints.m8782getMaxHeightimpl(j), iArr2, mutableObjectListArr2, j, iArr, mutableObjectList, iMo482roundToPx0680j_42) + (Math.max(0, i2 - 1) * iMo482roundToPx0680j_42), iMo482roundToPx0680j_4, iMo482roundToPx0680j_42);
    }

    /* JADX INFO: renamed from: calculateColumnWidths-O3s9Psw, reason: not valid java name */
    private static final int m1067calculateColumnWidthsO3s9Psw(Density density, LongList longList, int i, int i2, int[] iArr, MutableObjectList<GridItem>[] mutableObjectListArr, long j, MutableObjectList<GridItem> mutableObjectList, int i3) {
        long jM1091getAutoeyNpfc4;
        int iMo482roundToPx0680j_4;
        if (i == 0) {
            return 0;
        }
        int iCoerceAtLeast = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(i2 - RangesKt.coerceAtLeast((i - 1) * i3, 0), 0);
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int[] iArr2 = new int[i];
        float fM1080getValueimpl$foundation_layout = 0.0f;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 < longList._size) {
                jM1091getAutoeyNpfc4 = longList.get(i4);
            } else {
                jM1091getAutoeyNpfc4 = GridTrackSize.INSTANCE.m1091getAutoeyNpfc4();
            }
            long jM1074constructorimpl = GridTrackSize.m1074constructorimpl(jM1091getAutoeyNpfc4);
            switch (GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl)) {
                case 1:
                    iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl)));
                    break;
                case 2:
                    if (iCoerceAtLeast != Integer.MAX_VALUE) {
                        iMo482roundToPx0680j_4 = MathKt.roundToInt(GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl) * iCoerceAtLeast);
                    } else {
                        iMo482roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    }
                    break;
                case 3:
                    fM1080getValueimpl$foundation_layout += GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl);
                    iMo482roundToPx0680j_4 = calculateMinIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 4:
                    iMo482roundToPx0680j_4 = calculateMinIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 5:
                    iMo482roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
                case 6:
                    if (iCoerceAtLeast == Integer.MAX_VALUE) {
                        iMo482roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    } else {
                        long jCalculateMinMaxIntrinsicWidth = calculateMinMaxIntrinsicWidth(mutableObjectListArr[i4]);
                        mutableIntList.add(i4);
                        iArr2[i4] = (int) (jCalculateMinMaxIntrinsicWidth >>> 32);
                        iMo482roundToPx0680j_4 = (int) (jCalculateMinMaxIntrinsicWidth & 4294967295L);
                    }
                    break;
                case 7:
                    fM1080getValueimpl$foundation_layout += GridTrackSize.m1077getMaxValueimpl$foundation_layout(jM1074constructorimpl);
                    iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(GridTrackSize.m1078getMinValueimpl$foundation_layout(jM1074constructorimpl)));
                    break;
                default:
                    iMo482roundToPx0680j_4 = calculateMaxIntrinsicWidth(mutableObjectListArr[i4]);
                    break;
            }
            iArr[i4] = iMo482roundToPx0680j_4;
        }
        m1070distributeSpanningSpaceWeOhcdQ(longList, iArr, mutableObjectList, false, j, null, i3);
        if (iCoerceAtLeast != Integer.MAX_VALUE && mutableIntList._size != 0) {
            expandAutoTracks(mutableIntList, iArr, iArr2, iCoerceAtLeast);
        }
        return distributeFlexSpaceAndGetTotal(iArr, iCoerceAtLeast, fM1080getValueimpl$foundation_layout, i, longList);
    }

    /* JADX INFO: renamed from: calculateRowHeights-ESwBiLc, reason: not valid java name */
    private static final int m1069calculateRowHeightsESwBiLc(Density density, LongList longList, int i, int i2, int[] iArr, MutableObjectList<GridItem>[] mutableObjectListArr, long j, int[] iArr2, MutableObjectList<GridItem> mutableObjectList, int i3) {
        long jM1091getAutoeyNpfc4;
        int iMo482roundToPx0680j_4;
        if (i == 0) {
            return 0;
        }
        int iCoerceAtLeast = i2 == Integer.MAX_VALUE ? Integer.MAX_VALUE : RangesKt.coerceAtLeast(i2 - RangesKt.coerceAtLeast((i - 1) * i3, 0), 0);
        MutableIntList mutableIntList = new MutableIntList(0, 1, null);
        int[] iArr3 = new int[i];
        float fM1080getValueimpl$foundation_layout = 0.0f;
        for (int i4 = 0; i4 < i; i4++) {
            if (i4 < longList._size) {
                jM1091getAutoeyNpfc4 = longList.get(i4);
            } else {
                jM1091getAutoeyNpfc4 = GridTrackSize.INSTANCE.m1091getAutoeyNpfc4();
            }
            long jM1074constructorimpl = GridTrackSize.m1074constructorimpl(jM1091getAutoeyNpfc4);
            switch (GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl)) {
                case 1:
                    iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl)));
                    break;
                case 2:
                    if (iCoerceAtLeast != Integer.MAX_VALUE) {
                        iMo482roundToPx0680j_4 = MathKt.roundToInt(GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl) * iCoerceAtLeast);
                    } else {
                        iMo482roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    }
                    break;
                case 3:
                    fM1080getValueimpl$foundation_layout += GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl);
                    iMo482roundToPx0680j_4 = calculateMinIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    break;
                case 4:
                    iMo482roundToPx0680j_4 = calculateMinIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    break;
                case 5:
                    iMo482roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    break;
                case 6:
                    if (iCoerceAtLeast == Integer.MAX_VALUE) {
                        iMo482roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    } else {
                        long jCalculateMinMaxIntrinsicHeight = calculateMinMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                        mutableIntList.add(i4);
                        iArr3[i4] = (int) (jCalculateMinMaxIntrinsicHeight >>> 32);
                        iMo482roundToPx0680j_4 = (int) (jCalculateMinMaxIntrinsicHeight & 4294967295L);
                    }
                    break;
                case 7:
                    fM1080getValueimpl$foundation_layout += GridTrackSize.m1077getMaxValueimpl$foundation_layout(jM1074constructorimpl);
                    iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(GridTrackSize.m1078getMinValueimpl$foundation_layout(jM1074constructorimpl)));
                    break;
                default:
                    iMo482roundToPx0680j_4 = calculateMaxIntrinsicHeight(mutableObjectListArr[i4], iArr2, Constraints.m8783getMaxWidthimpl(j));
                    break;
            }
            iArr[i4] = iMo482roundToPx0680j_4;
        }
        m1070distributeSpanningSpaceWeOhcdQ(longList, iArr, mutableObjectList, true, j, iArr2, i3);
        if (iCoerceAtLeast != Integer.MAX_VALUE && mutableIntList._size != 0) {
            expandAutoTracks(mutableIntList, iArr, iArr3, iCoerceAtLeast);
        }
        return distributeFlexSpaceAndGetTotal(iArr, iCoerceAtLeast, fM1080getValueimpl$foundation_layout, i, longList);
    }

    private static final int distributeFlexSpaceAndGetTotal(int[] iArr, int i, float f2, int i2, LongList longList) {
        long jM1091getAutoeyNpfc4;
        float fM1080getValueimpl$foundation_layout;
        int i3 = 0;
        int i4 = 0;
        for (int i5 : iArr) {
            i4 += i5;
        }
        int iMax = i == Integer.MAX_VALUE ? 0 : Math.max(0, i - i4);
        if (f2 > 0.0f && iMax > 0) {
            float f3 = 0.0f;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                if (i8 < longList._size) {
                    jM1091getAutoeyNpfc4 = longList.get(i8);
                } else {
                    jM1091getAutoeyNpfc4 = GridTrackSize.INSTANCE.m1091getAutoeyNpfc4();
                }
                long jM1074constructorimpl = GridTrackSize.m1074constructorimpl(jM1091getAutoeyNpfc4);
                int iM1079getTypeimpl$foundation_layout = GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl);
                if (iM1079getTypeimpl$foundation_layout == 3) {
                    fM1080getValueimpl$foundation_layout = GridTrackSize.m1080getValueimpl$foundation_layout(jM1074constructorimpl);
                } else {
                    fM1080getValueimpl$foundation_layout = iM1079getTypeimpl$foundation_layout != 7 ? 0.0f : GridTrackSize.m1077getMaxValueimpl$foundation_layout(jM1074constructorimpl);
                }
                if (fM1080getValueimpl$foundation_layout > 0.0f) {
                    f3 += fM1080getValueimpl$foundation_layout;
                    int iMax2 = Math.max(0, MathKt.roundToInt((f3 / f2) * iMax) - i7);
                    iArr[i8] = iArr[i8] + iMax2;
                    i6 = iMax2 + i7;
                    i7 = i6;
                }
            }
            i3 = i6;
        }
        return i4 + i3;
    }

    private static final int calculateMaxIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int iMaxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                    if (iMaxIntrinsicWidth > i2) {
                        i2 = iMaxIntrinsicWidth;
                    }
                } catch (IllegalStateException e2) {
                    String message = e2.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return i2;
    }

    private static final int calculateMinIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int iMinIntrinsicWidth = gridItem.getMeasurable().minIntrinsicWidth(Integer.MAX_VALUE);
                    if (iMinIntrinsicWidth > i2) {
                        i2 = iMinIntrinsicWidth;
                    }
                } catch (IllegalStateException e2) {
                    String message = e2.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return i2;
    }

    private static final int calculateMaxIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                try {
                    int iMaxIntrinsicHeight = gridItem.getMeasurable().maxIntrinsicHeight(column < iArr.length ? iArr[column] : i);
                    if (iMaxIntrinsicHeight > i3) {
                        i3 = iMaxIntrinsicHeight;
                    }
                } catch (IllegalStateException e2) {
                    String message = e2.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return i3;
    }

    private static final int calculateMinIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                try {
                    int iMinIntrinsicHeight = gridItem.getMeasurable().minIntrinsicHeight(column < iArr.length ? iArr[column] : i);
                    if (iMinIntrinsicHeight > i3) {
                        i3 = iMinIntrinsicHeight;
                    }
                } catch (IllegalStateException e2) {
                    String message = e2.getMessage();
                    if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                    }
                    throw e2;
                }
            }
        }
        return i3;
    }

    private static final long calculateMinMaxIntrinsicWidth(MutableObjectList<GridItem> mutableObjectList) {
        if (mutableObjectList == null) {
            return 0L;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            GridItem gridItem = (GridItem) objArr[i4];
            if (gridItem.getColumnSpan() == 1) {
                try {
                    int iMinIntrinsicWidth = gridItem.getMeasurable().minIntrinsicWidth(Integer.MAX_VALUE);
                    try {
                        int iMaxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                        if (iMinIntrinsicWidth > i3) {
                            i3 = iMinIntrinsicWidth;
                        }
                        if (iMaxIntrinsicWidth > i2) {
                            i2 = iMaxIntrinsicWidth;
                        }
                    } catch (IllegalStateException e2) {
                        String message = e2.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                        }
                        throw e2;
                    }
                } catch (IllegalStateException e3) {
                    String message2 = e3.getMessage();
                    if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e3);
                    }
                    throw e3;
                }
            }
        }
        return (((long) i2) << 32) | (((long) i3) & 4294967295L);
    }

    private static final long calculateMinMaxIntrinsicHeight(MutableObjectList<GridItem> mutableObjectList, int[] iArr, int i) {
        if (mutableObjectList == null) {
            return 0L;
        }
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            GridItem gridItem = (GridItem) objArr[i5];
            if (gridItem.getRowSpan() == 1) {
                int column = gridItem.getColumn();
                int i6 = column < iArr.length ? iArr[column] : i;
                try {
                    int iMinIntrinsicHeight = gridItem.getMeasurable().minIntrinsicHeight(i6);
                    try {
                        int iMaxIntrinsicHeight = gridItem.getMeasurable().maxIntrinsicHeight(i6);
                        if (iMinIntrinsicHeight > i4) {
                            i4 = iMinIntrinsicHeight;
                        }
                        if (iMaxIntrinsicHeight > i3) {
                            i3 = iMaxIntrinsicHeight;
                        }
                    } catch (IllegalStateException e2) {
                        String message = e2.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                        }
                        throw e2;
                    }
                } catch (IllegalStateException e3) {
                    String message2 = e3.getMessage();
                    if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                        throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e3);
                    }
                    throw e3;
                }
            }
        }
        return (((long) i3) << 32) | (((long) i4) & 4294967295L);
    }

    /* JADX INFO: renamed from: distributeSpanningSpace-WeOhcdQ, reason: not valid java name */
    private static final void m1070distributeSpanningSpaceWeOhcdQ(LongList longList, int[] iArr, MutableObjectList<GridItem> mutableObjectList, boolean z, long j, int[] iArr2, int i) {
        int iMaxIntrinsicWidth;
        long jM1091getAutoeyNpfc4;
        boolean z2;
        int iM8783getMaxWidthimpl;
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i2 = mutableObjectList2._size;
        for (int i3 = 0; i3 < i2; i3++) {
            GridItem gridItem = (GridItem) objArr[i3];
            int row = z ? gridItem.getRow() : gridItem.getColumn();
            int rowSpan = z ? gridItem.getRowSpan() : gridItem.getColumnSpan();
            if (rowSpan > 1) {
                int iCoerceAtMost = RangesKt.coerceAtMost(rowSpan + row, iArr.length);
                int i4 = row;
                int i5 = 0;
                int i6 = 0;
                while (i4 < iCoerceAtMost) {
                    i5 += iArr[i4];
                    long jM1074constructorimpl = GridTrackSize.m1074constructorimpl(i4 < longList._size ? longList.get(i4) : GridTrackSize.INSTANCE.m1091getAutoeyNpfc4());
                    if (GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl) != 1 && GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl) != 2) {
                        i6++;
                    }
                    i4++;
                }
                if (z) {
                    if (iArr2 != null) {
                        int column = gridItem.getColumn();
                        z2 = true;
                        int iCoerceAtMost2 = RangesKt.coerceAtMost(column + gridItem.getColumnSpan(), iArr2.length);
                        int i7 = 0;
                        for (int i8 = column; i8 < iCoerceAtMost2; i8++) {
                            i7 += iArr2[i8];
                        }
                        iM8783getMaxWidthimpl = i7 + (Math.max(0, gridItem.getColumnSpan() - 1) * i);
                    } else {
                        z2 = true;
                        iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j);
                    }
                    try {
                        iMaxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicHeight(iM8783getMaxWidthimpl);
                    } catch (IllegalStateException e2) {
                        String message = e2.getMessage();
                        if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null) == z2) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
                        }
                        throw e2;
                    }
                } else {
                    try {
                        iMaxIntrinsicWidth = gridItem.getMeasurable().maxIntrinsicWidth(Integer.MAX_VALUE);
                    } catch (IllegalStateException e3) {
                        String message2 = e3.getMessage();
                        if (message2 != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                            throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e3);
                        }
                        throw e3;
                    }
                }
                int i9 = iMaxIntrinsicWidth - i5;
                if (i9 > 0 && i6 > 0) {
                    int i10 = i9 / i6;
                    int i11 = i9 % i6;
                    while (row < iCoerceAtMost) {
                        if (row < longList._size) {
                            jM1091getAutoeyNpfc4 = longList.get(row);
                        } else {
                            jM1091getAutoeyNpfc4 = GridTrackSize.INSTANCE.m1091getAutoeyNpfc4();
                        }
                        long jM1074constructorimpl2 = GridTrackSize.m1074constructorimpl(jM1091getAutoeyNpfc4);
                        if (GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl2) != 1 && GridTrackSize.m1079getTypeimpl$foundation_layout(jM1074constructorimpl2) != 2) {
                            iArr[row] = iArr[row] + (i11 > 0 ? 1 : 0) + i10;
                            if (i11 > 0) {
                                i11--;
                            }
                        }
                        row++;
                    }
                }
            }
        }
    }

    private static final void expandAutoTracks(MutableIntList mutableIntList, int[] iArr, int[] iArr2, int i) {
        MutableIntList mutableIntList2 = mutableIntList;
        if (mutableIntList2._size == 0) {
            return;
        }
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = i - i2;
        if (i4 <= 0) {
            return;
        }
        int[] iArr3 = new int[mutableIntList2._size];
        int[] iArr4 = mutableIntList2.content;
        int i5 = mutableIntList2._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = iArr4[i7];
            int iMax = Math.max(0, iArr2[i8] - iArr[i8]);
            iArr3[i7] = iMax;
            i6 += iMax;
        }
        if (i6 == 0) {
            return;
        }
        if (i4 >= i6) {
            IntRange intRangeUntil = RangesKt.until(0, mutableIntList2._size);
            int first = intRangeUntil.getFirst();
            int last = intRangeUntil.getLast();
            if (first > last) {
                return;
            }
            while (true) {
                int i9 = mutableIntList.get(first);
                iArr[i9] = iArr[i9] + iArr3[first];
                if (first == last) {
                    return;
                } else {
                    first++;
                }
            }
        } else {
            IntRange intRangeUntil2 = RangesKt.until(0, mutableIntList2._size);
            int first2 = intRangeUntil2.getFirst();
            int last2 = intRangeUntil2.getLast();
            if (first2 > last2) {
                return;
            }
            while (true) {
                int i10 = mutableIntList.get(first2);
                iArr[i10] = iArr[i10] + MathKt.roundToInt((iArr3[first2] / i6) * i4);
                if (first2 == last2) {
                    return;
                } else {
                    first2++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void measureItems(MutableObjectList<GridItem> mutableObjectList, GridTrackSizes gridTrackSizes, LayoutDirection layoutDirection) {
        int length = gridTrackSizes.getRowHeights().length;
        int length2 = gridTrackSizes.getColumnWidths().length;
        MutableObjectList<GridItem> mutableObjectList2 = mutableObjectList;
        Object[] objArr = mutableObjectList2.content;
        int i = mutableObjectList2._size;
        for (int i2 = 0; i2 < i; i2++) {
            GridItem gridItem = (GridItem) objArr[i2];
            int row = gridItem.getRow();
            int column = gridItem.getColumn();
            if (row < length && column < length2) {
                int iCoerceAtMost = RangesKt.coerceAtMost(gridItem.getColumnSpan() + column, length2);
                int columnGapPx = 0;
                for (int i3 = column; i3 < iCoerceAtMost; i3++) {
                    columnGapPx += gridTrackSizes.getColumnWidths()[i3];
                }
                int i4 = iCoerceAtMost - column;
                if (i4 > 1) {
                    columnGapPx += (i4 - 1) * gridTrackSizes.getColumnGapPx();
                }
                int i5 = columnGapPx;
                int iCoerceAtMost2 = RangesKt.coerceAtMost(gridItem.getRowSpan() + row, length);
                int rowGapPx = 0;
                for (int i6 = row; i6 < iCoerceAtMost2; i6++) {
                    rowGapPx += gridTrackSizes.getRowHeights()[i6];
                }
                int i7 = iCoerceAtMost2 - row;
                if (i7 > 1) {
                    rowGapPx += (i7 - 1) * gridTrackSizes.getRowGapPx();
                }
                int i8 = rowGapPx;
                Placeable placeableMo7445measureBRTryo0 = gridItem.getMeasurable().mo7445measureBRTryo0(ConstraintsKt.Constraints$default(0, i5, 0, i8, 5, null));
                long jMo5391alignKFBX0sM = gridItem.getAlignment().mo5391alignKFBX0sM(IntSize.m8996constructorimpl((((long) placeableMo7445measureBRTryo0.getHeight()) & 4294967295L) | (((long) placeableMo7445measureBRTryo0.getWidth()) << 32)), IntSize.m8996constructorimpl((((long) i5) << 32) | (((long) i8) & 4294967295L)), layoutDirection);
                gridItem.setPlaceable(placeableMo7445measureBRTryo0);
                gridItem.setOffsetX(IntOffset.m8958getXimpl(jMo5391alignKFBX0sM));
                gridItem.setOffsetY(IntOffset.m8959getYimpl(jMo5391alignKFBX0sM));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateTrackOffsets(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        int length = iArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iArr2[i3] = i2;
            i2 += iArr[i3] + i;
        }
        return iArr2;
    }

    private static final <T> T wrapIntrinsicException(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (IllegalStateException e2) {
            String message = e2.getMessage();
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "SubcomposeLayout", false, 2, (Object) null)) {
                throw new IllegalStateException(SubcomposeLayoutIntrinsicErrorMessage, e2);
            }
            throw e2;
        }
    }
}
