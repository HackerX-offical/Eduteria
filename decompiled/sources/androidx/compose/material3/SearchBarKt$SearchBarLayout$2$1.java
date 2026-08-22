package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchBar.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        final Placeable placeableMo7445measureBRTryo0;
        int i;
        int iM8782getMaxHeightimpl;
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        final float fFloatValue = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable3 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                break;
                            }
                            i4++;
                        }
                        Measurable measurable4 = measurable;
                        final int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.mo482roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i5 = measureScope2.mo482roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j2, measurable2.maxIntrinsicWidth(Constraints.m8782getMaxHeightimpl(j2)));
                        int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j2, measurable2.minIntrinsicHeight(Constraints.m8783getMaxWidthimpl(j2)));
                        int iRoundToInt = MathKt.roundToInt(Constraints.m8783getMaxWidthimpl(j2) * 0.9f);
                        int iRoundToInt2 = MathKt.roundToInt(Constraints.m8782getMaxHeightimpl(j2) * 0.9f);
                        final float fCalculatePredictiveBackMultiplier = SearchBarKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), fFloatValue, this.$finalBackProgress.getFloatValue());
                        int iLerp = MathHelpersKt.lerp(iM8800constrainWidthK40F9xA, iRoundToInt, fCalculatePredictiveBackMultiplier);
                        int i6 = top + iM8799constrainHeightK40F9xA;
                        int iLerp2 = MathHelpersKt.lerp(i6, iRoundToInt2, fCalculatePredictiveBackMultiplier);
                        int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j2);
                        int iM8782getMaxHeightimpl2 = Constraints.m8782getMaxHeightimpl(j2);
                        int iLerp3 = MathHelpersKt.lerp(iLerp, iM8783getMaxWidthimpl, fFloatValue);
                        final int iLerp4 = MathHelpersKt.lerp(iLerp2, iM8782getMaxHeightimpl2, fFloatValue);
                        final int iLerp5 = MathHelpersKt.lerp(top, 0, fFloatValue);
                        final int iLerp6 = MathHelpersKt.lerp(0, i5, fFloatValue);
                        final Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(ConstraintsKt.Constraints(iLerp3, iM8783getMaxWidthimpl, iM8799constrainHeightK40F9xA, iM8799constrainHeightK40F9xA));
                        int width = placeableMo7445measureBRTryo02.getWidth();
                        final Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(width, iLerp4 - iLerp5));
                        if (measurable4 != null) {
                            if (Constraints.m8778getHasBoundedHeightimpl(j)) {
                                i = 0;
                                iM8782getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m8782getMaxHeightimpl(j) - (i6 + i5), 0);
                            } else {
                                i = 0;
                                iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j);
                            }
                            placeableMo7445measureBRTryo0 = measurable4.mo7445measureBRTryo0(ConstraintsKt.Constraints(width, width, i, iM8782getMaxHeightimpl));
                        } else {
                            placeableMo7445measureBRTryo0 = null;
                        }
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        return MeasureScope.layout$default(measureScope, width, iLerp4, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$SearchBarLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchBarKt$SearchBarLayout$2$1.measure_3p2s80s$lambda$3(measureScope, j, mutableState, fFloatValue, fCalculatePredictiveBackMultiplier, mutableState2, iLerp4, placeableMo7445measureBRTryo03, iLerp5, placeableMo7445measureBRTryo02, top, placeableMo7445measureBRTryo0, iLerp6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i3++;
                    measureScope2 = measureScope;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i2++;
            measureScope2 = measureScope;
            j2 = j;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(MeasureScope measureScope, long j, MutableState mutableState, float f2, float f3, MutableState mutableState2, int i, Placeable placeable, int i2, Placeable placeable2, int i3, Placeable placeable3, int i4, Placeable.PlacementScope placementScope) {
        int i5 = measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin);
        int iM3365calculatePredictiveBackOffsetXrOvwMX4 = SearchBarKt.m3365calculatePredictiveBackOffsetXrOvwMX4(j, i5, (BackEventCompat) mutableState.getValue(), measureScope.getLayoutDirection(), f2, f3);
        int iM3366calculatePredictiveBackOffsetYdzo92Q0 = SearchBarKt.m3366calculatePredictiveBackOffsetYdzo92Q0(j, i5, (BackEventCompat) mutableState.getValue(), (BackEventCompat) mutableState2.getValue(), i, measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY), f3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, iM3365calculatePredictiveBackOffsetXrOvwMX4, iM3366calculatePredictiveBackOffsetYdzo92Q0 + i2, 0.0f, 4, null);
        int i6 = iM3366calculatePredictiveBackOffsetYdzo92Q0 + i3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, iM3365calculatePredictiveBackOffsetXrOvwMX4, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, iM3365calculatePredictiveBackOffsetXrOvwMX4, i6 + placeable2.getHeight() + i4, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
