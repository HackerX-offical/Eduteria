package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.IntOffset;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyGridSnapLayoutInfoProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a\u0014\u0010\u000e\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "sizeOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", Constants.KEY_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "offsetOnMainAxis", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LazyGridSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState lazyGridState, SnapPosition snapPosition, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPosition = SnapPosition.Center.INSTANCE;
        }
        return SnapLayoutInfoProvider(lazyGridState, snapPosition);
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final LazyGridState lazyGridState, final SnapPosition snapPosition) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt.SnapLayoutInfoProvider.1
            private final LazyGridLayoutInfo getLayoutInfo() {
                return lazyGridState.getLayoutInfo();
            }

            private final int getAverageItemSize() {
                LazyGridLayoutInfo layoutInfo = getLayoutInfo();
                if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
                    return 0;
                }
                int size = layoutInfo.getVisibleItemsInfo().size();
                List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
                int size2 = visibleItemsInfo.size();
                int iSizeOnMainAxis = 0;
                for (int i = 0; i < size2; i++) {
                    iSizeOnMainAxis += LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(visibleItemsInfo.get(i), layoutInfo.getOrientation());
                }
                return iSizeOnMainAxis / size;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                return RangesKt.coerceAtLeast(Math.abs(decayOffset) - getAverageItemSize(), 0.0f) * Math.signum(decayOffset);
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                List<LazyGridItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
                SnapPosition snapPosition2 = snapPosition;
                int size = visibleItemsInfo.size();
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                for (int i = 0; i < size; i++) {
                    LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
                    float fCalculateDistanceToDesiredSnapPosition = SnapPositionKt.calculateDistanceToDesiredSnapPosition(LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), lazyGridItemInfo.getIndex(), snapPosition2, getLayoutInfo().getTotalItemsCount());
                    if (fCalculateDistanceToDesiredSnapPosition <= 0.0f && fCalculateDistanceToDesiredSnapPosition > f2) {
                        f2 = fCalculateDistanceToDesiredSnapPosition;
                    }
                    if (fCalculateDistanceToDesiredSnapPosition >= 0.0f && fCalculateDistanceToDesiredSnapPosition < f3) {
                        f3 = fCalculateDistanceToDesiredSnapPosition;
                    }
                }
                return SnapFlingBehaviorKt.m763calculateFinalOffsetFhqu1e0(LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(lazyGridState.getDensity$foundation(), velocity), f2, f3);
            }
        };
    }

    public static final FlingBehavior rememberSnapFlingBehavior(LazyGridState lazyGridState, SnapPosition snapPosition, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -234434234, "C(rememberSnapFlingBehavior)N(lazyGridState,snapPosition)117@4957L79,118@5048L41:LazyGridSnapLayoutInfoProvider.kt#ppz6w6");
        if ((i2 & 2) != 0) {
            snapPosition = SnapPosition.Center.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-234434234, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (LazyGridSnapLayoutInfoProvider.kt:115)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1952993931, "CC(remember):LazyGridSnapLayoutInfoProvider.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(lazyGridState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapLayoutInfoProvider(lazyGridState, snapPosition);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TargetedFlingBehavior targetedFlingBehaviorRememberSnapFlingBehavior = SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider) objRememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return targetedFlingBehaviorRememberSnapFlingBehavior;
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        long jMo1334getViewportSizeYbymL2g;
        if (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical) {
            jMo1334getViewportSizeYbymL2g = lazyGridLayoutInfo.mo1334getViewportSizeYbymL2g() & 4294967295L;
        } else {
            jMo1334getViewportSizeYbymL2g = lazyGridLayoutInfo.mo1334getViewportSizeYbymL2g() >> 32;
        }
        return (int) jMo1334getViewportSizeYbymL2g;
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        long jMo1329getSizeYbymL2g;
        if (orientation == Orientation.Vertical) {
            jMo1329getSizeYbymL2g = lazyGridItemInfo.getSize() & 4294967295L;
        } else {
            jMo1329getSizeYbymL2g = lazyGridItemInfo.getSize() >> 32;
        }
        return (int) jMo1329getSizeYbymL2g;
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return IntOffset.m8959getYimpl(lazyGridItemInfo.getOffset());
        }
        return IntOffset.m8958getXimpl(lazyGridItemInfo.getOffset());
    }
}
