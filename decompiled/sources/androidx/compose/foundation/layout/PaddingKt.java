package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0015\u0010\b\u001a\u0015\u0010\u0016\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0015\u0010\u0018\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0087\u0002\u001a\u0019\u0010\u0019\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0019\u0010\u001d\u001a\u00020\u0003*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\"\u001a7\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"padding", "Landroidx/compose/ui/Modifier;", "start", "Landroidx/compose/ui/unit/Dp;", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "padding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "horizontal", "vertical", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "all", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "left", "right", "absolutePadding-qDBjuR0", "plus", "other", "minus", "calculateStartPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateEndPadding", "PaddingValues", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "foundation-layout"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PaddingKt {
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m1154paddingqDBjuR0(Modifier modifier, final float f2, final float f3, final float f4, final float f5) {
        return modifier.then(new PaddingElement(f2, f3, f4, f5, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_qDBjuR0$lambda$0(f2, f3, f4, f5, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit padding_qDBjuR0$lambda$0(float f2, float f3, float f4, float f5, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("start", Dp.m8828boximpl(f2));
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.m8828boximpl(f3));
        inspectorInfo.getProperties().set("end", Dp.m8828boximpl(f4));
        inspectorInfo.getProperties().set("bottom", Dp.m8828boximpl(f5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m1152paddingVpY3zN4(Modifier modifier, final float f2, final float f3) {
        return modifier.then(new PaddingElement(f2, f3, f2, f3, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_VpY3zN4$lambda$0(f2, f3, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit padding_VpY3zN4$lambda$0(float f2, float f3, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("horizontal", Dp.m8828boximpl(f2));
        inspectorInfo.getProperties().set("vertical", Dp.m8828boximpl(f3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m1151padding3ABfNKs(Modifier modifier, final float f2) {
        return modifier.then(new PaddingElement(f2, f2, f2, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding_3ABfNKs$lambda$0(f2, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit padding_3ABfNKs$lambda$0(float f2, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.setValue(Dp.m8828boximpl(f2));
        return Unit.INSTANCE;
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.padding$lambda$0(paddingValues, (InspectorInfo) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit padding$lambda$0(PaddingValues paddingValues, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("padding");
        inspectorInfo.getProperties().set("paddingValues", paddingValues);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m1149absolutePaddingqDBjuR0(Modifier modifier, final float f2, final float f3, final float f4, final float f5) {
        return modifier.then(new PaddingElement(f2, f3, f4, f5, false, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaddingKt.absolutePadding_qDBjuR0$lambda$0(f2, f3, f4, f5, (InspectorInfo) obj);
            }
        }, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit absolutePadding_qDBjuR0$lambda$0(float f2, float f3, float f4, float f5, InspectorInfo inspectorInfo) {
        inspectorInfo.setName("absolutePadding");
        inspectorInfo.getProperties().set("left", Dp.m8828boximpl(f2));
        inspectorInfo.getProperties().set(ViewHierarchyConstants.DIMENSION_TOP_KEY, Dp.m8828boximpl(f3));
        inspectorInfo.getProperties().set("right", Dp.m8828boximpl(f4));
        inspectorInfo.getProperties().set("bottom", Dp.m8828boximpl(f5));
        return Unit.INSTANCE;
    }

    public static final PaddingValues plus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt.plus.1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
            public float mo1096calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8830constructorimpl(paddingValues.mo1096calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues2.mo1096calculateLeftPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
            public float getTop() {
                return Dp.m8830constructorimpl(paddingValues.getTop() + paddingValues2.getTop());
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
            public float mo1097calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8830constructorimpl(paddingValues.mo1097calculateRightPaddingu2uoSUM(layoutDirection) + paddingValues2.mo1097calculateRightPaddingu2uoSUM(layoutDirection));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
            public float getBottom() {
                return Dp.m8830constructorimpl(paddingValues.getBottom() + paddingValues2.getBottom());
            }
        };
    }

    public static final PaddingValues minus(final PaddingValues paddingValues, final PaddingValues paddingValues2) {
        return new PaddingValues() { // from class: androidx.compose.foundation.layout.PaddingKt.minus.1
            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateLeftPadding-u2uoSUM */
            public float mo1096calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8830constructorimpl(RangesKt.coerceAtLeast(Dp.m8830constructorimpl(paddingValues.mo1096calculateLeftPaddingu2uoSUM(layoutDirection) - paddingValues2.mo1096calculateLeftPaddingu2uoSUM(layoutDirection)), Dp.m8830constructorimpl(0)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateTopPadding-D9Ej5fM */
            public float getTop() {
                return Dp.m8830constructorimpl(RangesKt.coerceAtLeast(Dp.m8830constructorimpl(paddingValues.getTop() - paddingValues2.getTop()), Dp.m8830constructorimpl(0)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateRightPadding-u2uoSUM */
            public float mo1097calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
                return Dp.m8830constructorimpl(RangesKt.coerceAtLeast(Dp.m8830constructorimpl(paddingValues.mo1097calculateRightPaddingu2uoSUM(layoutDirection) - paddingValues2.mo1097calculateRightPaddingu2uoSUM(layoutDirection)), Dp.m8830constructorimpl(0)));
            }

            @Override // androidx.compose.foundation.layout.PaddingValues
            /* JADX INFO: renamed from: calculateBottomPadding-D9Ej5fM */
            public float getBottom() {
                return Dp.m8830constructorimpl(RangesKt.coerceAtLeast(Dp.m8830constructorimpl(paddingValues.getBottom() - paddingValues2.getBottom()), Dp.m8830constructorimpl(0)));
            }
        };
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo1096calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo1097calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo1097calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo1096calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m1144PaddingValues0680j_4(float f2) {
        return new PaddingValuesImpl(f2, f2, f2, f2, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m1145PaddingValuesYgX7TsA(float f2, float f3) {
        return new PaddingValuesImpl(f2, f3, f2, f3, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m1147PaddingValuesa9UjIt4(float f2, float f3, float f4, float f5) {
        return new PaddingValuesImpl(f2, f3, f4, f5, null);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1155paddingqDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f4 = Dp.m8830constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f5 = Dp.m8830constructorimpl(0);
        }
        return m1154paddingqDBjuR0(modifier, f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1153paddingVpY3zN4$default(Modifier modifier, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        return m1152paddingVpY3zN4(modifier, f2, f3);
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1150absolutePaddingqDBjuR0$default(Modifier modifier, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f4 = Dp.m8830constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f5 = Dp.m8830constructorimpl(0);
        }
        return m1149absolutePaddingqDBjuR0(modifier, f2, f3, f4, f5);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1146PaddingValuesYgX7TsA$default(float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        return m1145PaddingValuesYgX7TsA(f2, f3);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1148PaddingValuesa9UjIt4$default(float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = Dp.m8830constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f3 = Dp.m8830constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f4 = Dp.m8830constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f5 = Dp.m8830constructorimpl(0);
        }
        return m1147PaddingValuesa9UjIt4(f2, f3, f4, f5);
    }
}
