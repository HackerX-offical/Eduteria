package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RectRulers;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: RulerAlignment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"fitInside", "Landroidx/compose/ui/Modifier;", "rulers", "Landroidx/compose/ui/layout/RectRulers;", "fitOutside", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RulerAlignmentKt {
    public static final Modifier fitInside(Modifier modifier, final RectRulers rectRulers) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RulerAlignmentKt.fitInside$lambda$0(rectRulers, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult fitInside$lambda$0(final RectRulers rectRulers, MeasureScope measureScope, final Measurable measurable, Constraints constraints) {
        if (Constraints.m8779getHasBoundedWidthimpl(constraints.getValue()) && Constraints.m8778getHasBoundedHeightimpl(constraints.getValue())) {
            final int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(constraints.getValue());
            final int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(constraints.getValue());
            return MeasureScope.layout$default(measureScope, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RulerAlignmentKt.fitInside$lambda$0$0(rectRulers, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, measurable, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(constraints.getValue());
        final int width = placeableMo7445measureBRTryo0.getWidth();
        final int height = placeableMo7445measureBRTryo0.getHeight();
        return MeasureScope.layout$default(measureScope, width, height, null, new Function1() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RulerAlignmentKt.fitInside$lambda$0$1(rectRulers, width, height, placeableMo7445measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fitInside$lambda$0$0(RectRulers rectRulers, int i, int i2, Measurable measurable, Placeable.PlacementScope placementScope) {
        int iRoundToInt = MathKt.roundToInt(placementScope.current(rectRulers.getLeft(), 0.0f));
        if (iRoundToInt < 0) {
            iRoundToInt = 0;
        }
        int i3 = iRoundToInt > i ? i : iRoundToInt;
        int iRoundToInt2 = MathKt.roundToInt(placementScope.current(rectRulers.getTop(), 0.0f));
        if (iRoundToInt2 < 0) {
            iRoundToInt2 = 0;
        }
        int i4 = iRoundToInt2 > i2 ? i2 : iRoundToInt2;
        int iRoundToInt3 = MathKt.roundToInt(placementScope.current(rectRulers.getRight(), i));
        if (iRoundToInt3 < 0) {
            iRoundToInt3 = 0;
        }
        if (iRoundToInt3 <= i) {
            i = iRoundToInt3;
        }
        int iRoundToInt4 = MathKt.roundToInt(placementScope.current(rectRulers.getBottom(), i2));
        int i5 = iRoundToInt4 >= 0 ? iRoundToInt4 : 0;
        if (i5 <= i2) {
            i2 = i5;
        }
        Placeable.PlacementScope.place$default(placementScope, measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(i - i3, i2 - i4)), i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fitInside$lambda$0$1(RectRulers rectRulers, int i, int i2, Placeable placeable, Placeable.PlacementScope placementScope) {
        int iRoundToInt = MathKt.roundToInt(placementScope.current(rectRulers.getLeft(), 0.0f));
        if (iRoundToInt < 0) {
            iRoundToInt = 0;
        }
        if (iRoundToInt > i) {
            iRoundToInt = i;
        }
        int iRoundToInt2 = MathKt.roundToInt(placementScope.current(rectRulers.getTop(), 0.0f));
        if (iRoundToInt2 < 0) {
            iRoundToInt2 = 0;
        }
        if (iRoundToInt2 > i2) {
            iRoundToInt2 = i2;
        }
        int iRoundToInt3 = MathKt.roundToInt(placementScope.current(rectRulers.getRight(), i));
        if (iRoundToInt3 < 0) {
            iRoundToInt3 = 0;
        }
        if (iRoundToInt3 > i) {
            iRoundToInt3 = i;
        }
        int iRoundToInt4 = MathKt.roundToInt(placementScope.current(rectRulers.getBottom(), i2));
        int i3 = iRoundToInt4 >= 0 ? iRoundToInt4 : 0;
        if (i3 > i2) {
            i3 = i2;
        }
        Placeable.PlacementScope.place$default(placementScope, placeable, ((iRoundToInt + iRoundToInt3) - i) / 2, ((iRoundToInt2 + i3) - i2) / 2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final Modifier fitOutside(Modifier modifier, final RectRulers rectRulers) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return RulerAlignmentKt.fitOutside$lambda$0(rectRulers, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult fitOutside$lambda$0(final RectRulers rectRulers, MeasureScope measureScope, final Measurable measurable, Constraints constraints) {
        if (Constraints.m8779getHasBoundedWidthimpl(constraints.getValue()) && Constraints.m8778getHasBoundedHeightimpl(constraints.getValue())) {
            final int iM8783getMaxWidthimpl = Constraints.m8783getMaxWidthimpl(constraints.getValue());
            final int iM8782getMaxHeightimpl = Constraints.m8782getMaxHeightimpl(constraints.getValue());
            return MeasureScope.layout$default(measureScope, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RulerAlignmentKt.fitOutside$lambda$0$0(rectRulers, iM8783getMaxWidthimpl, iM8782getMaxHeightimpl, measurable, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        return MeasureScope.layout$default(measureScope, 0, 0, null, new Function1() { // from class: androidx.compose.foundation.layout.RulerAlignmentKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RulerAlignmentKt.fitOutside$lambda$0$1(measurable, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fitOutside$lambda$0$0(RectRulers rectRulers, int i, int i2, Measurable measurable, Placeable.PlacementScope placementScope) {
        int i3;
        int i4;
        int iRoundToInt = MathKt.roundToInt(placementScope.current(rectRulers.getLeft(), 0.0f));
        int iRoundToInt2 = MathKt.roundToInt(placementScope.current(rectRulers.getTop(), 0.0f));
        int iRoundToInt3 = MathKt.roundToInt(placementScope.current(rectRulers.getRight(), i));
        int iRoundToInt4 = MathKt.roundToInt(placementScope.current(rectRulers.getBottom(), i2));
        if (iRoundToInt > 0) {
            i = iRoundToInt;
        } else {
            if (iRoundToInt2 <= 0) {
                if (iRoundToInt3 < i) {
                    i -= iRoundToInt3;
                    i3 = iRoundToInt3;
                    i4 = 0;
                } else if (iRoundToInt4 < i2) {
                    i2 -= iRoundToInt4;
                    i4 = iRoundToInt4;
                    i3 = 0;
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = i3;
                }
                Placeable.PlacementScope.place$default(placementScope, measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(i, i2)), i3, i4, 0.0f, 4, null);
                return Unit.INSTANCE;
            }
            i2 = iRoundToInt2;
        }
        i3 = 0;
        i4 = i3;
        Placeable.PlacementScope.place$default(placementScope, measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(i, i2)), i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fitOutside$lambda$0$1(Measurable measurable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, measurable.mo7445measureBRTryo0(Constraints.INSTANCE.m8793fixedJhjzzOo(0, 0)), 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
