package androidx.compose.material3;

import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.SwipeEdge;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsLayerScope;
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
final class SearchBarKt$FullScreenSearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $firstInProgressValue;
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $lastInProgressValue;
    final /* synthetic */ SearchBarState $state;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    SearchBarKt$FullScreenSearchBarLayout$2$1(MutableState<BackEventProgress.InProgress> mutableState, SearchBarState searchBarState, MutableWindowInsets mutableWindowInsets, MutableState<BackEventProgress.InProgress> mutableState2) {
        this.$lastInProgressValue = mutableState;
        this.$state = searchBarState;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$firstInProgressValue = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        final long j2 = j;
        float fTransform = SearchBarKt.transform(this.$lastInProgressValue.getValue());
        Integer numValueOf = Integer.valueOf(SearchBarKt.getCollapsedBounds(this.$state).getWidth());
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : measureScope2.mo482roundToPx0680j_4(SearchBarKt.getSearchBarMinWidth());
        Integer numValueOf2 = Integer.valueOf(SearchBarKt.getCollapsedBounds(this.$state).getHeight());
        Integer num = numValueOf2.intValue() != 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : measureScope2.mo482roundToPx0680j_4(SearchBarDefaults.INSTANCE.m3333getInputFieldHeightD9Ej5fM());
        final int iCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m8783getMaxWidthimpl(j2) * 0.9f), iIntValue);
        final int iCoerceAtLeast2 = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m8782getMaxHeightimpl(j2) * 0.9f), iIntValue2);
        int iLerp = MathHelpersKt.lerp(Constraints.m8783getMaxWidthimpl(j2), iCoerceAtLeast, fTransform);
        int iLerp2 = MathHelpersKt.lerp(Constraints.m8782getMaxHeightimpl(j2), iCoerceAtLeast2, fTransform);
        int iM8800constrainWidthK40F9xA = ConstraintsKt.m8800constrainWidthK40F9xA(j2, MathHelpersKt.lerp(iIntValue, iLerp, this.$state.getProgress()));
        int iM8799constrainHeightK40F9xA = ConstraintsKt.m8799constrainHeightK40F9xA(j2, MathHelpersKt.lerp(iIntValue2, iLerp2, this.$state.getProgress()));
        List<? extends Measurable> list3 = list2;
        int size = list3.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list2.get(i);
            final float f2 = fTransform;
            List<? extends Measurable> list4 = list3;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Surface")) {
                Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(iM8800constrainWidthK40F9xA, iM8799constrainHeightK40F9xA));
                int size2 = list4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list2.get(i2);
                    final Placeable placeable = placeableMo7445measureBRTryo0;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                        final Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(iM8800constrainWidthK40F9xA, iIntValue2));
                        final int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.mo482roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i3 = measureScope2.mo482roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        final int iLerp3 = MathHelpersKt.lerp(0, top, Math.min(this.$state.getProgress(), 1 - f2));
                        final int iLerp4 = MathHelpersKt.lerp(0, i3, this.$state.getProgress());
                        int height = placeableMo7445measureBRTryo02.getHeight() + iLerp3 + iLerp4;
                        int size3 = list4.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list2.get(i4);
                            int i5 = i4;
                            int i6 = height;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Content")) {
                                final Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(ConstraintsKt.Constraints(iM8800constrainWidthK40F9xA, iM8800constrainWidthK40F9xA, 0, RangesKt.coerceAtLeast(iM8799constrainHeightK40F9xA - i6, 0)));
                                int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(j2);
                                int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(j2);
                                final MutableState<BackEventProgress.InProgress> mutableState = this.$lastInProgressValue;
                                final SearchBarState searchBarState = this.$state;
                                final MutableState<BackEventProgress.InProgress> mutableState2 = this.$firstInProgressValue;
                                return MeasureScope.layout$default(measureScope, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$6(mutableState, f2, searchBarState, placeable, placeableMo7445measureBRTryo02, iLerp3, placeableMo7445measureBRTryo03, iLerp4, j2, measureScope2, iCoerceAtLeast, mutableState2, iCoerceAtLeast2, top, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            measureScope2 = measureScope;
                            j2 = j;
                            i4 = i5 + 1;
                            height = i6;
                            list2 = list;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope2 = measureScope;
                    list2 = list;
                    j2 = j;
                    placeableMo7445measureBRTryo0 = placeable;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
            list2 = list;
            j2 = j;
            fTransform = f2;
            list3 = list4;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetX(BackEventProgress.InProgress inProgress, long j, MeasureScope measureScope, int i, SearchBarState searchBarState) {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(inProgress.getSwipeEdge() == SwipeEdge.Left ? (Constraints.m8783getMaxWidthimpl(j) - measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin)) - i : measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin), SearchBarKt.getCollapsedBounds(searchBarState).getRight() - i), SearchBarKt.getCollapsedBounds(searchBarState).getLeft());
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetY(BackEventProgress.InProgress inProgress, MutableState<BackEventProgress.InProgress> mutableState, long j, int i, MeasureScope measureScope, int i2, SearchBarState searchBarState) {
        float touchY = inProgress.getTouchY();
        BackEventProgress.InProgress value = mutableState.getValue();
        if (value == null) {
            return 0;
        }
        float touchY2 = touchY - value.getTouchY();
        return RangesKt.coerceAtMost((MathHelpersKt.lerp(0, Math.min(RangesKt.coerceAtLeast(((Constraints.m8782getMaxHeightimpl(j) - i) / 2) - measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMinMargin), 0), measureScope.mo482roundToPx0680j_4(SearchBarKt.SearchBarPredictiveBackMaxOffsetY)), Math.abs(touchY2) / Constraints.m8782getMaxHeightimpl(j)) * ((int) Math.signum(touchY2))) + i2, SearchBarKt.getCollapsedBounds(searchBarState).getTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$6(MutableState mutableState, float f2, final SearchBarState searchBarState, Placeable placeable, Placeable placeable2, int i, Placeable placeable3, int i2, long j, MeasureScope measureScope, int i3, MutableState mutableState2, int i4, int i5, Placeable.PlacementScope placementScope) {
        BackEventProgress.InProgress inProgress = (BackEventProgress.InProgress) mutableState.getValue();
        int iLerp = MathHelpersKt.lerp(0, inProgress != null ? measure_3p2s80s$lambda$6$endOffsetX(inProgress, j, measureScope, i3, searchBarState) : 0, f2);
        BackEventProgress.InProgress inProgress2 = (BackEventProgress.InProgress) mutableState.getValue();
        int iLerp2 = MathHelpersKt.lerp(0, inProgress2 != null ? measure_3p2s80s$lambda$6$endOffsetY(inProgress2, mutableState2, j, i4, measureScope, i5, searchBarState) : 0, f2);
        int iLerp3 = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(searchBarState).getLeft(), iLerp, searchBarState.getProgress());
        int iLerp4 = MathHelpersKt.lerp(SearchBarKt.getCollapsedBounds(searchBarState).getTop(), iLerp2, searchBarState.getProgress());
        Placeable.PlacementScope.place$default(placementScope, placeable, iLerp3, iLerp4, 0.0f, 4, null);
        int i6 = iLerp4 + i;
        Placeable.PlacementScope.place$default(placementScope, placeable2, iLerp3, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable3, iLerp3, i6 + placeable2.getHeight() + i2, 0.0f, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$6$lambda$5(searchBarState, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$6$lambda$5(SearchBarState searchBarState, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(searchBarState.getProgress());
        return Unit.INSTANCE;
    }
}
