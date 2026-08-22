package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SliderKt$RangeSliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ RangeSliderState $state;

    SliderKt$RangeSliderImpl$2$1(RangeSliderState rangeSliderState) {
        this.$state = rangeSliderState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$4(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4, Placeable placeable3, int i5, int i6, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, i4, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i5, i6, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int iRoundToInt;
        int iRoundToInt2;
        long j2 = j;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (LayoutIdKt.getLayoutId(measurable) == RangeSliderComponents.STARTTHUMB) {
                final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(j2);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (LayoutIdKt.getLayoutId(measurable2) == RangeSliderComponents.ENDTHUMB) {
                        final Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(j2);
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            if (LayoutIdKt.getLayoutId(measurable3) == RangeSliderComponents.TRACK) {
                                final Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(j2, (-(placeableMo7445measureBRTryo0.getWidth() + placeableMo7445measureBRTryo02.getWidth())) / 2, 0, 2, null), 0, 0, 0, 0, 11, null));
                                int width = placeableMo7445measureBRTryo03.getWidth() + ((placeableMo7445measureBRTryo0.getWidth() + placeableMo7445measureBRTryo02.getWidth()) / 2);
                                int iMax = Math.max(placeableMo7445measureBRTryo03.getHeight(), Math.max(placeableMo7445measureBRTryo0.getHeight(), placeableMo7445measureBRTryo02.getHeight()));
                                this.$state.setTotalWidth$material3(width);
                                this.$state.updateMinMaxPx$material3();
                                float coercedActiveRangeStartAsFraction$material3 = this.$state.getCoercedActiveRangeStartAsFraction$material3();
                                boolean z = true;
                                boolean z2 = Intrinsics.areEqual(coercedActiveRangeStartAsFraction$material3, ArraysKt.firstOrNull(this.$state.getTickFractions())) || Intrinsics.areEqual(coercedActiveRangeStartAsFraction$material3, ArraysKt.lastOrNull(this.$state.getTickFractions()));
                                float coercedActiveRangeEndAsFraction$material3 = this.$state.getCoercedActiveRangeEndAsFraction$material3();
                                if (!Intrinsics.areEqual(coercedActiveRangeEndAsFraction$material3, ArraysKt.firstOrNull(this.$state.getTickFractions())) && !Intrinsics.areEqual(coercedActiveRangeEndAsFraction$material3, ArraysKt.lastOrNull(this.$state.getTickFractions()))) {
                                    z = false;
                                }
                                final int width2 = placeableMo7445measureBRTryo0.getWidth() / 2;
                                int i4 = placeableMo7445measureBRTryo03.get(SliderKt.getCornerSizeAlignmentLine());
                                int i5 = i4 != Integer.MIN_VALUE ? i4 : 0;
                                if (this.$state.getSteps() > 0 && !z2) {
                                    iRoundToInt = MathKt.roundToInt((placeableMo7445measureBRTryo03.getWidth() - (i5 * 2)) * coercedActiveRangeStartAsFraction$material3) + i5;
                                } else {
                                    iRoundToInt = MathKt.roundToInt(placeableMo7445measureBRTryo03.getWidth() * coercedActiveRangeStartAsFraction$material3);
                                }
                                final int i6 = iRoundToInt;
                                int width3 = (placeableMo7445measureBRTryo0.getWidth() - placeableMo7445measureBRTryo02.getWidth()) / 2;
                                if (this.$state.getSteps() > 0 && !z) {
                                    iRoundToInt2 = MathKt.roundToInt(((placeableMo7445measureBRTryo03.getWidth() - (i5 * 2)) * coercedActiveRangeEndAsFraction$material3) + width3) + i5;
                                } else {
                                    iRoundToInt2 = MathKt.roundToInt((placeableMo7445measureBRTryo03.getWidth() * coercedActiveRangeEndAsFraction$material3) + width3);
                                }
                                final int i7 = iRoundToInt2;
                                final int height = (iMax - placeableMo7445measureBRTryo03.getHeight()) / 2;
                                final int height2 = (iMax - placeableMo7445measureBRTryo0.getHeight()) / 2;
                                final int height3 = (iMax - placeableMo7445measureBRTryo02.getHeight()) / 2;
                                return MeasureScope.layout$default(measureScope, width, iMax, null, new Function1() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SliderKt$RangeSliderImpl$2$1.measure_3p2s80s$lambda$4(placeableMo7445measureBRTryo03, width2, height, placeableMo7445measureBRTryo0, i6, height2, placeableMo7445measureBRTryo02, i7, height3, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            i3++;
                            j2 = j;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            j2 = j;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
