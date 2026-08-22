package androidx.compose.material3;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.clevertap.android.sdk.Constants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: TimePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 INSTANCE = new TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1();

    TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$3(boolean z, int i, Placeable placeable, int i2, Placeable placeable2, int i3, int i4, int i5, MeasureScope measureScope, Placeable placeable3, int i6, int i7, int i8, int i9, Placeable.PlacementScope placementScope) {
        if (z) {
            int height = i4 - ((((i + placeable.getHeight()) + i2) + placeable2.getHeight()) + i3);
            int i10 = i4 >= i5 ? measureScope.mo482roundToPx0680j_4(Dp.m8830constructorimpl(16)) : 0;
            Placeable.PlacementScope.place$default(placementScope, placeable3, i6, i6, 0.0f, 4, null);
            int i11 = height / 2;
            int i12 = i + i11;
            Placeable.PlacementScope.place$default(placementScope, placeable, i7, i12, 0.0f, 4, null);
            Placeable.PlacementScope.place$default(placementScope, placeable2, i7, (((i12 + placeable.getHeight()) + i2) - i10) + i11, 0.0f, 4, null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, placeable3, i6, i8, 0.0f, 4, null);
            int width = (i9 - placeable.getWidth()) / 2;
            int height2 = i8 + placeable3.getHeight();
            Placeable.PlacementScope.place$default(placementScope, placeable, width, height2, 0.0f, 4, null);
            Placeable.PlacementScope.place$default(placementScope, placeable2, (i9 - placeable2.getWidth()) / 2, height2 + placeable.getHeight(), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo44measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        boolean z;
        int width;
        int height;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "title")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "timePickerContent")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), Constants.KEY_ACTIONS)) {
                                float f2 = 24;
                                final int i5 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2));
                                final int i6 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(RendererCapabilities.DECODER_SUPPORT_MASK));
                                final int i7 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2));
                                final int i8 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(16));
                                final int i9 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(4));
                                final int i10 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(8));
                                final int i11 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2));
                                int i12 = measureScope2.mo482roundToPx0680j_4(Dp.m8830constructorimpl(f2));
                                final Placeable placeableMo7445measureBRTryo0 = measurable2.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                if (placeableMo7445measureBRTryo0.getWidth() <= placeableMo7445measureBRTryo0.getHeight() || placeableMo7445measureBRTryo0.getHeight() < MathKt.truncate(measureScope2.mo488toPx0680j_4(TimePickerKt.getClockDialMinContainerSize()))) {
                                    i = i12;
                                    z = false;
                                } else {
                                    i = i12;
                                    z = true;
                                }
                                if (z) {
                                    width = placeableMo7445measureBRTryo0.getWidth();
                                } else {
                                    width = placeableMo7445measureBRTryo0.getWidth();
                                }
                                final int i13 = width + (i5 * 2);
                                final boolean z2 = z;
                                final Placeable placeableMo7445measureBRTryo02 = measurable3.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, placeableMo7445measureBRTryo0.getWidth(), 0, 0, 8, null));
                                final Placeable placeableMo7445measureBRTryo03 = measurable.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j, 0, placeableMo7445measureBRTryo0.getWidth(), 0, 0, 8, null));
                                if (z2) {
                                    height = placeableMo7445measureBRTryo0.getHeight() + placeableMo7445measureBRTryo02.getHeight() + i10 + i8 + i9;
                                    if (Constraints.m8778getHasBoundedHeightimpl(j)) {
                                        height = Constraints.m8782getMaxHeightimpl(j);
                                    }
                                } else {
                                    height = placeableMo7445measureBRTryo03.getHeight() + i11 + placeableMo7445measureBRTryo0.getHeight() + placeableMo7445measureBRTryo02.getHeight() + i;
                                }
                                final int i14 = height;
                                return MeasureScope.layout$default(measureScope, i13, i14, null, new Function1() { // from class: androidx.compose.material3.TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1.measure_3p2s80s$lambda$3(z2, i8, placeableMo7445measureBRTryo0, i9, placeableMo7445measureBRTryo02, i10, i14, i6, measureScope, placeableMo7445measureBRTryo03, i7, i5, i11, i13, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            i4++;
                            measureScope2 = measureScope;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i3++;
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
}
