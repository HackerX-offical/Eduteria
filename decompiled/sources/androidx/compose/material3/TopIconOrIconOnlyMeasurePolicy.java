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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\"\u0010\"\u001a\u00020#*\u00020$2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010&\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000b\u001a\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "hasLabel", "", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "topIconItemVerticalPadding", "<init>", "(ZLkotlin/jvm/functions/Function0;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHasLabel", "()Z", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getTopIconItemVerticalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {
    private final boolean hasLabel;
    private final Function0<Float> indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;
    private final float topIconItemVerticalPadding;

    public /* synthetic */ TopIconOrIconOnlyMeasurePolicy(boolean z, Function0 function0, float f2, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, f2, f3, f4, f5);
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean z, Function0<Float> function0, float f2, float f3, float f4, float f5) {
        this.hasLabel = z;
        this.indicatorAnimationProgress = function0;
        this.indicatorHorizontalPadding = f2;
        this.indicatorVerticalPadding = f3;
        this.indicatorToLabelVerticalPadding = f4;
        this.topIconItemVerticalPadding = f5;
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
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

    /* JADX INFO: renamed from: getIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getIndicatorToLabelVerticalPadding() {
        return this.indicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getTopIconItemVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconItemVerticalPadding() {
        return this.topIconItemVerticalPadding;
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
                float f2 = 2;
                Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(jM8773copyZbe2FdA$default, -measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorHorizontalPadding * f2)), -measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorVerticalPadding * f2))));
                int width = placeableMo7445measureBRTryo0.getWidth() + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorHorizontalPadding * f2));
                int height = placeableMo7445measureBRTryo0.getHeight() + measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.indicatorVerticalPadding * f2));
                int iRoundToInt = MathKt.roundToInt(width * fFloatValue);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "indicatorRipple")) {
                        Placeable placeableMo7445measureBRTryo02 = measurable2.mo7445measureBRTryo0(ConstraintsKt.m8798constrainN9IONVI(jM8773copyZbe2FdA$default, Constraints.INSTANCE.m8793fixedJhjzzOo(width, height)));
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicator")) {
                                Placeable placeableMo7445measureBRTryo03 = measurable3.mo7445measureBRTryo0(ConstraintsKt.m8798constrainN9IONVI(jM8773copyZbe2FdA$default, Constraints.INSTANCE.m8793fixedJhjzzOo(iRoundToInt, height)));
                                if (!this.hasLabel) {
                                    return NavigationItemKt.m3209placeIconX9ElhV4(measureScope2, placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo03, j);
                                }
                                int size4 = list2.size();
                                int i4 = 0;
                                while (i4 < size4) {
                                    Measurable measurable4 = list.get(i4);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "label")) {
                                        return NavigationItemKt.m3211placeLabelAndTopIconqoqLrGI(measureScope2, measurable4.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(jM8773copyZbe2FdA$default, 0, -(placeableMo7445measureBRTryo03.getHeight() + measureScope2.mo482roundToPx0680j_4(this.indicatorToLabelVerticalPadding)), 1, null)), placeableMo7445measureBRTryo0, placeableMo7445measureBRTryo02, placeableMo7445measureBRTryo03, j, this.indicatorToLabelVerticalPadding, this.indicatorVerticalPadding, this.topIconItemVerticalPadding);
                                    }
                                    i4++;
                                    placeableMo7445measureBRTryo0 = placeableMo7445measureBRTryo0;
                                    placeableMo7445measureBRTryo03 = placeableMo7445measureBRTryo03;
                                    placeableMo7445measureBRTryo02 = placeableMo7445measureBRTryo02;
                                    measureScope2 = measureScope;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i3++;
                            placeableMo7445measureBRTryo0 = placeableMo7445measureBRTryo0;
                            measureScope2 = measureScope;
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
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        IntrinsicMeasurable intrinsicMeasurable;
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), "icon")) {
                int iMaxIntrinsicHeight = intrinsicMeasurable2.maxIntrinsicHeight(i);
                int size2 = list2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        intrinsicMeasurable = null;
                        break;
                    }
                    intrinsicMeasurable = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "label")) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable3 = intrinsicMeasurable;
                int iMaxIntrinsicHeight2 = intrinsicMeasurable3 != null ? intrinsicMeasurable3.maxIntrinsicHeight(i) : 0;
                float f2 = 2;
                return iMaxIntrinsicHeight + iMaxIntrinsicHeight2 + intrinsicMeasureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(Dp.m8830constructorimpl(Dp.m8830constructorimpl(this.topIconItemVerticalPadding * f2) + Dp.m8830constructorimpl(this.indicatorVerticalPadding * f2)) + this.indicatorToLabelVerticalPadding));
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
