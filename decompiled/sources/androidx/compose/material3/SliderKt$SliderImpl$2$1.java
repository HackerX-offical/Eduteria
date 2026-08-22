package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
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
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SliderKt$SliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ SliderState $state;

    SliderKt$SliderImpl$2$1(SliderState sliderState) {
        this.$state = sliderState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(Placeable placeable, int i, int i2, Placeable placeable2, int i3, Ref.IntRef intRef, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i3, intRef.element, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeableMo7445measureBRTryo0;
        int width;
        int iMax;
        int width2;
        int height;
        int iRoundToInt;
        int width3;
        int iRoundToInt2;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                long j2 = j;
                final Placeable placeableMo7445measureBRTryo02 = measurable.mo7445measureBRTryo0(j2);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                        if (this.$state.getOrientation() == Orientation.Vertical) {
                            placeableMo7445measureBRTryo0 = measurable2.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(j2, 0, -placeableMo7445measureBRTryo02.getHeight(), 1, null), 0, 0, 0, 0, 14, null));
                        } else {
                            placeableMo7445measureBRTryo0 = measurable2.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(j, -placeableMo7445measureBRTryo02.getWidth(), 0, 2, null), 0, 0, 0, 0, 11, null));
                        }
                        final Placeable placeable = placeableMo7445measureBRTryo0;
                        final Ref.IntRef intRef = new Ref.IntRef();
                        float coercedValueAsFraction = this.$state.getCoercedValueAsFraction();
                        boolean z = Intrinsics.areEqual(coercedValueAsFraction, ArraysKt.firstOrNull(this.$state.getTickFractions())) || Intrinsics.areEqual(coercedValueAsFraction, ArraysKt.lastOrNull(this.$state.getTickFractions()));
                        int i3 = placeable.get(SliderKt.getCornerSizeAlignmentLine());
                        int i4 = i3 != Integer.MIN_VALUE ? i3 : 0;
                        if (this.$state.getOrientation() == Orientation.Vertical) {
                            width = Math.max(placeable.getWidth(), placeableMo7445measureBRTryo02.getWidth());
                            iMax = placeableMo7445measureBRTryo02.getHeight() + placeable.getHeight();
                            width2 = (width - placeable.getWidth()) / 2;
                            height = placeableMo7445measureBRTryo02.getHeight() / 2;
                            width3 = (width - placeableMo7445measureBRTryo02.getWidth()) / 2;
                            if (this.$state.getSteps() > 0 && !z) {
                                iRoundToInt2 = MathKt.roundToInt((placeable.getHeight() - (i4 * 2)) * coercedValueAsFraction) + i4;
                            } else {
                                iRoundToInt2 = MathKt.roundToInt(placeable.getHeight() * coercedValueAsFraction);
                            }
                            intRef.element = iRoundToInt2;
                            if (this.$state.getReverseVerticalDirection()) {
                                intRef.element = placeable.getHeight() - intRef.element;
                            }
                        } else {
                            width = placeableMo7445measureBRTryo02.getWidth() + placeable.getWidth();
                            iMax = Math.max(placeable.getHeight(), placeableMo7445measureBRTryo02.getHeight());
                            width2 = placeableMo7445measureBRTryo02.getWidth() / 2;
                            height = (iMax - placeable.getHeight()) / 2;
                            if (this.$state.getSteps() > 0 && !z) {
                                iRoundToInt = MathKt.roundToInt((placeable.getWidth() - (i4 * 2)) * coercedValueAsFraction) + i4;
                            } else {
                                iRoundToInt = MathKt.roundToInt(placeable.getWidth() * coercedValueAsFraction);
                            }
                            width3 = iRoundToInt;
                            intRef.element = (iMax - placeableMo7445measureBRTryo02.getHeight()) / 2;
                        }
                        final int i5 = height;
                        final int i6 = width3;
                        final int i7 = width2;
                        this.$state.updateDimensions$material3(width, iMax);
                        return MeasureScope.layout$default(measureScope, width, iMax, null, new Function1() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SliderKt$SliderImpl$2$1.measure_3p2s80s$lambda$3(placeable, i7, i5, placeableMo7445measureBRTryo02, i6, intRef, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i2++;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
