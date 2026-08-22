package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AccessibilityUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"HorizontalSemanticsBoundsPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalSemanticsBoundsPadding$annotations", "()V", "getHorizontalSemanticsBoundsPadding", "()F", "F", "VerticalSemanticsBoundsPadding", "getVerticalSemanticsBoundsPadding$annotations", "getVerticalSemanticsBoundsPadding", "IncreaseHorizontalSemanticsBounds", "Landroidx/compose/ui/Modifier;", "getIncreaseHorizontalSemanticsBounds", "()Landroidx/compose/ui/Modifier;", "IncreaseVerticalSemanticsBounds", "getIncreaseVerticalSemanticsBounds", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AccessibilityUtilKt {
    private static final float HorizontalSemanticsBoundsPadding;
    private static final Modifier IncreaseHorizontalSemanticsBounds;
    private static final Modifier IncreaseVerticalSemanticsBounds;
    private static final float VerticalSemanticsBoundsPadding;

    public static /* synthetic */ void getHorizontalSemanticsBoundsPadding$annotations() {
    }

    public static /* synthetic */ void getVerticalSemanticsBoundsPadding$annotations() {
    }

    public static final float getHorizontalSemanticsBoundsPadding() {
        return HorizontalSemanticsBoundsPadding;
    }

    public static final float getVerticalSemanticsBoundsPadding() {
        return VerticalSemanticsBoundsPadding;
    }

    public static final Modifier getIncreaseHorizontalSemanticsBounds() {
        return IncreaseHorizontalSemanticsBounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult IncreaseHorizontalSemanticsBounds$lambda$1(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final int i = measureScope.mo482roundToPx0680j_4(HorizontalSemanticsBoundsPadding);
        long value = constraints.getValue();
        int i2 = i * 2;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(value, i2, 0));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth() - i2, placeableMo7445measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds$lambda$1$lambda$0(placeableMo7445measureBRTryo0, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncreaseHorizontalSemanticsBounds$lambda$1$lambda$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, -i, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncreaseHorizontalSemanticsBounds$lambda$2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    public static final Modifier getIncreaseVerticalSemanticsBounds() {
        return IncreaseVerticalSemanticsBounds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult IncreaseVerticalSemanticsBounds$lambda$4(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        final int i = measureScope.mo482roundToPx0680j_4(VerticalSemanticsBoundsPadding);
        long value = constraints.getValue();
        int i2 = i * 2;
        final Placeable placeableMo7445measureBRTryo0 = measurable.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(value, 0, i2));
        return MeasureScope.layout$default(measureScope, placeableMo7445measureBRTryo0.getWidth(), placeableMo7445measureBRTryo0.getHeight() - i2, null, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccessibilityUtilKt.IncreaseVerticalSemanticsBounds$lambda$4$lambda$3(placeableMo7445measureBRTryo0, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncreaseVerticalSemanticsBounds$lambda$4$lambda$3(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, -i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IncreaseVerticalSemanticsBounds$lambda$5(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    static {
        float f2 = 10;
        float fM8830constructorimpl = Dp.m8830constructorimpl(f2);
        HorizontalSemanticsBoundsPadding = fM8830constructorimpl;
        float fM8830constructorimpl2 = Dp.m8830constructorimpl(f2);
        VerticalSemanticsBoundsPadding = fM8830constructorimpl2;
        IncreaseHorizontalSemanticsBounds = PaddingKt.m1153paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds$lambda$1((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), true, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccessibilityUtilKt.IncreaseHorizontalSemanticsBounds$lambda$2((SemanticsPropertyReceiver) obj);
            }
        }), fM8830constructorimpl, 0.0f, 2, null);
        IncreaseVerticalSemanticsBounds = PaddingKt.m1153paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AccessibilityUtilKt.IncreaseVerticalSemanticsBounds$lambda$4((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), true, new Function1() { // from class: androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AccessibilityUtilKt.IncreaseVerticalSemanticsBounds$lambda$5((SemanticsPropertyReceiver) obj);
            }
        }), 0.0f, fM8830constructorimpl2, 1, null);
    }
}
