package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00162\u0006\u0010 \u001a\u00020\u001dH\u0016J\"\u0010!\u001a\u00020\u001d*\u00020\u001e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00162\u0006\u0010\"\u001a\u00020\u001dH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006#"}, d2 = {"Landroidx/compose/material3/StartIconMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "startIconToLabelHorizontalPadding", "<init>", "(Lkotlin/jvm/functions/Function0;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "maxIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class StartIconMeasurePolicy implements MeasurePolicy {
    private final Function0<Float> indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;

    public /* synthetic */ StartIconMeasurePolicy(Function0 function0, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, f2, f3, f4);
    }

    private StartIconMeasurePolicy(Function0<Float> function0, float f2, float f3, float f4) {
        this.indicatorAnimationProgress = function0;
        this.indicatorHorizontalPadding = f2;
        this.indicatorVerticalPadding = f3;
        this.startIconToLabelHorizontalPadding = f4;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorHorizontalPadding() {
        return this.indicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorVerticalPadding() {
        return this.indicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconToLabelHorizontalPadding() {
        return this.startIconToLabelHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo44measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        MeasureScope measureScope2 = measureScope;
        float fFloatValue = this.indicatorAnimationProgress.invoke().floatValue();
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(jM8773copyZbe2FdA$default);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                        Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(jM8773copyZbe2FdA$default, -(placeableMo7445measureBRTryo0.getWidth() + measureScope2.mo482roundToPx0680j_4(this.startIconToLabelHorizontalPadding)), 0, 2, null));
                        float f2 = 2;
                        int width = placeableMo7445measureBRTryo0.getWidth() + placeableMo7445measureBRTryo02.getWidth() + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.startIconToLabelHorizontalPadding + Dp.m8830constructorimpl(this.indicatorHorizontalPadding * f2)));
                        int iMax = Math.max(placeableMo7445measureBRTryo0.getHeight(), placeableMo7445measureBRTryo02.getHeight()) + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorVerticalPadding * f2));
                        int iRoundToInt = MathKt.roundToInt(width * fFloatValue);
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                List<? extends Measurable> list3 = list2;
                                Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(ConstraintsKt.m8798constrainN9IONVI(jM8773copyZbe2FdA$default, Constraints.INSTANCE.m8793fixedJhjzzOo(width, iMax)));
                                int size4 = list3.size();
                                int i4 = 0;
                                while (i4 < size4) {
                                    Measurable measurable4 = list.get(i4);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        return NavigationItemKt.m3210placeLabelAndStartIconnru01g4(measureScope, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo03, measurable4.mo7445measureBRTryo0(ConstraintsKt.m8798constrainN9IONVI(jM8773copyZbe2FdA$default, Constraints.INSTANCE.m8793fixedJhjzzOo(iRoundToInt, iMax))), j, this.startIconToLabelHorizontalPadding);
                                    }
                                    i4++;
                                    placeableMo7445measureBRTryo03 = placeableMo7445measureBRTryo03;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i3++;
                            list2 = list2;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope2 = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        return iMaxIntrinsicWidth + intrinsicMeasurable2.maxIntrinsicWidth(i) + intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(Dp.m8830constructorimpl(this.indicatorHorizontalPadding * 2) + this.startIconToLabelHorizontalPadding));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), "label")) {
                        return Math.max(iMaxIntrinsicHeight, intrinsicMeasurable2.maxIntrinsicHeight(i)) + intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorVerticalPadding * 2));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
