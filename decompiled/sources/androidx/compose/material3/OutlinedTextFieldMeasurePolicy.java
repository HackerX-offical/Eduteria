package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OutlinedTextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001eH\u0016J\"\u0010\"\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001eH\u0016J\"\u0010#\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001eH\u0016J\"\u0010%\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001eH\u0016J<\u0010&\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001a\u00020\u001e2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0(H\u0002J<\u0010)\u001a\u00020\u001e*\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001a\u00020\u001e2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0(H\u0002J[\u0010*\u001a\u00020\u001e*\u00020+2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\n\u001a\u000203H\u0002¢\u0006\u0004\b4\u00105Jk\u00106\u001a\u00020\u001e*\u00020+2\u0006\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\n\u001a\u000203H\u0002¢\u0006\u0004\b@\u0010AJ\u009a\u0001\u0010B\u001a\u00020\u0005*\u00020C2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001e2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010F2\b\u0010I\u001a\u0004\u0018\u00010F2\u0006\u0010J\u001a\u00020F2\b\u0010K\u001a\u0004\u0018\u00010F2\b\u0010L\u001a\u0004\u0018\u00010F2\u0006\u0010M\u001a\u00020F2\b\u0010N\u001a\u0004\u0018\u00010F2\u0006\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020Q2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010\n\u001a\u0002032\u0006\u0010R\u001a\u000203H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006S"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "horizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "minIntrinsicHeight", "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "Landroidx/compose/ui/unit/Density;", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "", "calculateWidth-IzADHW4", "(Landroidx/compose/ui/unit/Density;IIIIIIIJF)I", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "iconPadding", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float horizontalIconPadding;
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final Function1<Size, Unit> onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public /* synthetic */ OutlinedTextFieldMeasurePolicy(Function1 function1, boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, PaddingValues paddingValues, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, z, textFieldLabelPosition, floatProducer, paddingValues, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> function1, boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, PaddingValues paddingValues, float f2) {
        this.onLabelMeasured = function1;
        this.singleLine = z;
        this.labelPosition = textFieldLabelPosition;
        this.labelProgress = floatProducer;
        this.paddingValues = paddingValues;
        this.horizontalIconPadding = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo44measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Measurable measurable;
        Measurable measurable2;
        long j2;
        Placeable placeableMo7445measureBRTryo0;
        Measurable measurable3;
        Measurable measurable4;
        long j3;
        Placeable placeableMo7445measureBRTryo02;
        Measurable measurable5;
        int iMinIntrinsicHeight;
        Measurable measurable6;
        MeasureScope measureScope2;
        int iMax;
        Measurable measurable7;
        int i;
        long jM5801getZeroNHjbRc;
        long jM5801getZeroNHjbRc2;
        final float fInvoke = this.labelProgress.invoke();
        int i2 = measureScope.mo482roundToPx0680j_4(this.paddingValues.getBottom());
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i3++;
        }
        Measurable measurable8 = measurable;
        Placeable placeableMo7445measureBRTryo03 = measurable8 != null ? measurable8.mo7445measureBRTryo0(jM8773copyZbe2FdA$default) : null;
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo03);
        int iMax2 = Math.max(0, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03));
        int size2 = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i4++;
        }
        Measurable measurable9 = measurable2;
        if (measurable9 != null) {
            j2 = jM8773copyZbe2FdA$default;
            placeableMo7445measureBRTryo0 = measurable9.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero, 0, 2, null));
        } else {
            j2 = jM8773copyZbe2FdA$default;
            placeableMo7445measureBRTryo0 = null;
        }
        int widthOrZero2 = widthOrZero + LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo0);
        int iMax3 = Math.max(iMax2, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo0));
        int size3 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i5++;
        }
        Measurable measurable10 = measurable3;
        Placeable placeableMo7445measureBRTryo04 = measurable10 != null ? measurable10.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, null)) : null;
        int widthOrZero3 = widthOrZero2 + LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo04);
        int iMax4 = Math.max(iMax3, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo04));
        int size4 = list2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i6++;
        }
        Measurable measurable11 = measurable4;
        if (measurable11 != null) {
            j3 = j2;
            placeableMo7445measureBRTryo02 = measurable11.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero3, 0, 2, null));
        } else {
            j3 = j2;
            placeableMo7445measureBRTryo02 = null;
        }
        int widthOrZero4 = widthOrZero3 + LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo02);
        int iMax5 = Math.max(iMax4, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo02));
        boolean z = this.labelPosition instanceof TextFieldLabelPosition.Above;
        int size5 = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size5) {
                measurable5 = null;
                break;
            }
            measurable5 = list.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), TextFieldImplKt.LabelId)) {
                break;
            }
            i7++;
        }
        Measurable measurable12 = measurable5;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (!z) {
            int i8 = measureScope.mo482roundToPx0680j_4(this.paddingValues.mo1096calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.mo482roundToPx0680j_4(this.paddingValues.mo1097calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
            objectRef.element = measurable12 != null ? measurable12.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j3, -MathHelpersKt.lerp(widthOrZero4 + i8, i8, fInvoke), -i2)) : 0;
            if (((Placeable) objectRef.element) == null) {
                jM5801getZeroNHjbRc2 = Size.INSTANCE.m5801getZeroNHjbRc();
            } else {
                jM5801getZeroNHjbRc2 = Size.m5783constructorimpl((((long) Float.floatToRawIntBits(r6.getWidth())) << 32) | (((long) Float.floatToRawIntBits(r6.getHeight())) & 4294967295L));
            }
            this.onLabelMeasured.invoke(Size.m5780boximpl(jM5801getZeroNHjbRc2));
            iMinIntrinsicHeight = 0;
        } else {
            iMinIntrinsicHeight = measurable12 != null ? measurable12.minIntrinsicHeight(Constraints.m8785getMinWidthimpl(j)) : 0;
        }
        int size6 = list2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size6) {
                measurable6 = null;
                break;
            }
            measurable6 = list.get(i9);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), TextFieldImplKt.SupportingId)) {
                break;
            }
            i9++;
        }
        Measurable measurable13 = measurable6;
        int iMinIntrinsicHeight2 = measurable13 != null ? measurable13.minIntrinsicHeight(Constraints.m8785getMinWidthimpl(j)) : 0;
        if (z) {
            measureScope2 = measureScope;
            iMax = measureScope2.mo482roundToPx0680j_4(this.paddingValues.getTop());
        } else {
            measureScope2 = measureScope;
            iMax = Math.max(LayoutUtilKt.getHeightOrZero((Placeable) objectRef.element) / 2, measureScope2.mo482roundToPx0680j_4(this.paddingValues.getTop()));
        }
        int i10 = (((-i2) - iMax) - iMinIntrinsicHeight) - iMinIntrinsicHeight2;
        int i11 = i2;
        long jM8773copyZbe2FdA$default2 = Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8802offsetNN6EwU(j, -widthOrZero4, i10), 0, 0, 0, 0, 11, null);
        int size7 = list2.size();
        int i12 = 0;
        while (i12 < size7) {
            int i13 = size7;
            Measurable measurable14 = list.get(i12);
            boolean z2 = z;
            int i14 = i11;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable14), TextFieldImplKt.TextFieldId)) {
                final Placeable placeableMo7445measureBRTryo05 = measurable14.mo7445measureBRTryo0(jM8773copyZbe2FdA$default2);
                long jM8773copyZbe2FdA$default3 = Constraints.m8773copyZbe2FdA$default(jM8773copyZbe2FdA$default2, 0, 0, 0, 0, 14, null);
                int size8 = list2.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list.get(i15);
                    int i16 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i15++;
                    size8 = i16;
                }
                Measurable measurable15 = measurable7;
                Placeable placeableMo7445measureBRTryo06 = measurable15 != null ? measurable15.mo7445measureBRTryo0(jM8773copyZbe2FdA$default3) : null;
                int iMax6 = Math.max(iMax5, Math.max(LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo05), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo06)) + iMax + i14);
                MeasureScope measureScope3 = measureScope2;
                long j4 = j3;
                Ref.ObjectRef objectRef2 = objectRef;
                int iM3255calculateWidthIzADHW4 = m3255calculateWidthIzADHW4(measureScope3, LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo03), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo0), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo04), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo02), placeableMo7445measureBRTryo05.getWidth(), LayoutUtilKt.getWidthOrZero((Placeable) objectRef.element), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo06), j, fInvoke);
                if (z2) {
                    i = iM3255calculateWidthIzADHW4;
                    objectRef2.element = measurable12 != null ? measurable12.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j4, 0, iM3255calculateWidthIzADHW4, 0, iMinIntrinsicHeight, 5, null)) : 0;
                    if (((Placeable) objectRef2.element) == null) {
                        jM5801getZeroNHjbRc = Size.INSTANCE.m5801getZeroNHjbRc();
                    } else {
                        jM5801getZeroNHjbRc = Size.m5783constructorimpl((((long) Float.floatToRawIntBits(r2.getWidth())) << 32) | (((long) Float.floatToRawIntBits(r2.getHeight())) & 4294967295L));
                    }
                    this.onLabelMeasured.invoke(Size.m5780boximpl(jM5801getZeroNHjbRc));
                } else {
                    i = iM3255calculateWidthIzADHW4;
                }
                final int i17 = i;
                Placeable placeableMo7445measureBRTryo07 = measurable13 != null ? measurable13.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(j4, 0, -iMax6, 1, null), 0, i, 0, 0, 9, null)) : null;
                int heightOrZero = LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo07);
                boolean z3 = z2;
                final int iM3254calculateHeightmKXJcVc = m3254calculateHeightmKXJcVc(measureScope3, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo0), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo04), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo02), placeableMo7445measureBRTryo05.getHeight(), LayoutUtilKt.getHeightOrZero((Placeable) objectRef2.element), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo06), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo07), j, z3, fInvoke);
                int heightOrZero2 = (iM3254calculateHeightmKXJcVc - heightOrZero) - (z3 ? LayoutUtilKt.getHeightOrZero((Placeable) objectRef2.element) : 0);
                int size9 = list2.size();
                int i18 = 0;
                while (i18 < size9) {
                    Measurable measurable16 = list.get(i18);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable16), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo7445measureBRTryo08 = measurable16.mo7445measureBRTryo0(ConstraintsKt.Constraints(i17 != Integer.MAX_VALUE ? i17 : 0, i17, heightOrZero2 != Integer.MAX_VALUE ? heightOrZero2 : 0, heightOrZero2));
                        final Ref.ObjectRef objectRef3 = objectRef2;
                        final Placeable placeable = placeableMo7445measureBRTryo0;
                        final Placeable placeable2 = placeableMo7445measureBRTryo04;
                        final Placeable placeable3 = placeableMo7445measureBRTryo02;
                        final Placeable placeable4 = placeableMo7445measureBRTryo06;
                        final boolean z4 = z3;
                        final Placeable placeable5 = placeableMo7445measureBRTryo07;
                        final Placeable placeable6 = placeableMo7445measureBRTryo03;
                        return MeasureScope.layout$default(measureScope, i17, iM3254calculateHeightmKXJcVc, null, new Function1() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return OutlinedTextFieldMeasurePolicy.measure_3p2s80s$lambda$11(this.f$0, iM3254calculateHeightmKXJcVc, i17, placeable6, placeable, placeable2, placeable3, placeableMo7445measureBRTryo05, objectRef3, placeable4, placeableMo7445measureBRTryo08, placeable5, measureScope, z4, fInvoke, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i18++;
                    iM3254calculateHeightmKXJcVc = iM3254calculateHeightmKXJcVc;
                    z3 = z3;
                    objectRef2 = objectRef2;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i12++;
            objectRef = objectRef;
            z = z2;
            size7 = i13;
            i11 = i14;
            measureScope2 = measureScope;
            j3 = j3;
            jM8773copyZbe2FdA$default2 = jM8773copyZbe2FdA$default2;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit measure_3p2s80s$lambda$11(OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Ref.ObjectRef objectRef, Placeable placeable6, Placeable placeable7, Placeable placeable8, MeasureScope measureScope, boolean z, float f2, Placeable.PlacementScope placementScope) {
        outlinedTextFieldMeasurePolicy.place(placementScope, i, i2, placeable, placeable2, placeable3, placeable4, placeable5, (Placeable) objectRef.element, placeable6, placeable7, placeable8, measureScope.getDensity(), measureScope.getLayoutDirection(), z, f2, measureScope.mo488toPx0680j_4(outlinedTextFieldMeasurePolicy.horizontalIconPadding));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        int iSubtractConstraintSafely;
        int iIntValue;
        IntrinsicMeasurable intrinsicMeasurable2;
        int iIntValue2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int iIntValue3;
        IntrinsicMeasurable intrinsicMeasurable5;
        int iIntValue4;
        int i2;
        IntrinsicMeasurable intrinsicMeasurable6;
        IntrinsicMeasurable intrinsicMeasurable7;
        int i3;
        int i4;
        int i5;
        int iIntValue5;
        OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        float fInvoke = outlinedTextFieldMeasurePolicy.labelProgress.invoke();
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i6);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i6++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
        if (intrinsicMeasurable8 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = function2.invoke(intrinsicMeasurable8, Integer.valueOf(i)).intValue();
        } else {
            iSubtractConstraintSafely = i;
            iIntValue = 0;
        }
        int size2 = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i7);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i7++;
        }
        IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable2;
        if (intrinsicMeasurable9 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable9.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = function2.invoke(intrinsicMeasurable9, Integer.valueOf(i)).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size3) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i8);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.LabelId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable3;
        int iIntValue6 = intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(MathHelpersKt.lerp(iSubtractConstraintSafely, i, fInvoke))).intValue() : 0;
        int size4 = list2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size4) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i9);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.PrefixId)) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable4;
        if (intrinsicMeasurable11 != null) {
            iIntValue3 = function2.invoke(intrinsicMeasurable11, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable11.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue3 = 0;
        }
        int size5 = list2.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size5) {
                intrinsicMeasurable5 = null;
                break;
            }
            intrinsicMeasurable5 = list.get(i10);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.SuffixId)) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable5;
        if (intrinsicMeasurable12 != null) {
            iIntValue4 = function2.invoke(intrinsicMeasurable12, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable12.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue4 = 0;
        }
        int size6 = list2.size();
        int i11 = 0;
        while (i11 < size6) {
            IntrinsicMeasurable intrinsicMeasurable13 = list.get(i11);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.TextFieldId)) {
                int iIntValue7 = function2.invoke(intrinsicMeasurable13, Integer.valueOf(iSubtractConstraintSafely)).intValue();
                int size7 = list2.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size7) {
                        i2 = iIntValue7;
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i12);
                    i2 = iIntValue7;
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i12++;
                    iIntValue7 = i2;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable6;
                int iIntValue8 = intrinsicMeasurable14 != null ? function2.invoke(intrinsicMeasurable14, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
                int size8 = list2.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size8) {
                        intrinsicMeasurable7 = null;
                        break;
                    }
                    intrinsicMeasurable7 = list.get(i13);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    i13++;
                }
                IntrinsicMeasurable intrinsicMeasurable15 = intrinsicMeasurable7;
                if (intrinsicMeasurable15 != null) {
                    i3 = iIntValue3;
                    i4 = iIntValue8;
                    i5 = iIntValue;
                    iIntValue5 = function2.invoke(intrinsicMeasurable15, Integer.valueOf(i)).intValue();
                } else {
                    i3 = iIntValue3;
                    i4 = iIntValue8;
                    i5 = iIntValue;
                    iIntValue5 = 0;
                }
                return outlinedTextFieldMeasurePolicy.m3254calculateHeightmKXJcVc(intrinsicMeasureScope, i5, iIntValue2, i3, iIntValue4, i2, iIntValue6, i4, iIntValue5, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), outlinedTextFieldMeasurePolicy.labelPosition instanceof TextFieldLabelPosition.Above, fInvoke);
            }
            i11++;
            iIntValue6 = iIntValue6;
            outlinedTextFieldMeasurePolicy = this;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: renamed from: calculateWidth-IzADHW4, reason: not valid java name */
    private final int m3255calculateWidthIzADHW4(Density density, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, float f2) {
        int i8 = i3 + i4;
        return ConstraintsKt.m8800constrainWidthK40F9xA(j, Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, MathHelpersKt.lerp(i6, 0, f2))) + i2, MathKt.roundToInt((i6 + density.mo488toPx0680j_4(Dp.m8830constructorimpl(this.paddingValues.mo1096calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + this.paddingValues.mo1097calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)))) * f2)));
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    private final int m3254calculateHeightmKXJcVc(Density density, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, boolean z, float f2) {
        int iMaxOf = ComparisonsKt.maxOf(i5, i7, i3, i4, z ? 0 : MathHelpersKt.lerp(i6, 0, f2));
        float fMo488toPx0680j_4 = density.mo488toPx0680j_4(this.paddingValues.getTop());
        if (!z) {
            fMo488toPx0680j_4 = MathHelpersKt.lerp(fMo488toPx0680j_4, Math.max(fMo488toPx0680j_4, i6 / 2.0f), f2);
        }
        float fMo488toPx0680j_42 = fMo488toPx0680j_4 + iMaxOf + density.mo488toPx0680j_4(this.paddingValues.getBottom());
        if (!z) {
            i6 = 0;
        }
        return ConstraintsKt.m8799constrainHeightK40F9xA(j, i6 + Math.max(i, Math.max(i2, MathKt.roundToInt(fMo488toPx0680j_42))) + i8);
    }

    private final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f2, LayoutDirection layoutDirection, boolean z, float f3, float f4) {
        int i3;
        int i4;
        int i5;
        int iAlign;
        int heightOrZero = z ? LayoutUtilKt.getHeightOrZero(placeable6) : 0;
        Placeable.PlacementScope.place$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        int heightOrZero2 = (i - LayoutUtilKt.getHeightOrZero(placeable9)) - (z ? LayoutUtilKt.getHeightOrZero(placeable6) : 0);
        int iRoundToInt = MathKt.roundToInt(this.paddingValues.getTop() * f2);
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, heightOrZero + Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), heightOrZero2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            if (z) {
                iAlign = 0;
            } else {
                iAlign = this.singleLine ? Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), heightOrZero2) : iRoundToInt;
            }
            int iLerp = MathHelpersKt.lerp(iAlign, z ? 0 : -(placeable6.getHeight() / 2), f3);
            if (z) {
                Placeable.PlacementScope.place$default(placementScope, placeable6, TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(placeable6.getWidth(), i2, layoutDirection), iLerp, 0.0f, 4, null);
            } else {
                float fCalculateStartPadding = PaddingKt.calculateStartPadding(this.paddingValues, layoutDirection) * f2;
                float fCalculateEndPadding = PaddingKt.calculateEndPadding(this.paddingValues, layoutDirection) * f2;
                Placeable.PlacementScope.place$default(placementScope, placeable6, MathKt.roundToInt(MathHelpersKt.lerp(TextFieldImplKt.getExpandedAlignment(this.labelPosition).align(placeable6.getWidth(), i2 - MathKt.roundToInt(r9 + r11), layoutDirection) + (layoutDirection == LayoutDirection.Ltr ? placeable == null ? fCalculateStartPadding : placeable.getWidth() + RangesKt.coerceAtLeast(fCalculateStartPadding - f4, 0.0f) : placeable2 == null ? fCalculateEndPadding : placeable2.getWidth() + RangesKt.coerceAtLeast(fCalculateEndPadding - f4, 0.0f)), TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(placeable6.getWidth(), i2 - MathKt.roundToInt(fCalculateStartPadding + fCalculateEndPadding), layoutDirection) + (layoutDirection == LayoutDirection.Ltr ? fCalculateStartPadding : fCalculateEndPadding), f3)), iLerp, 0.0f, 4, null);
            }
        }
        if (placeable3 != null) {
            i3 = heightOrZero2;
            i4 = iRoundToInt;
            i5 = heightOrZero;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, LayoutUtilKt.getWidthOrZero(placeable), place$calculateVerticalPosition(i5, this, i3, i4, placeable6, placeable3), 0.0f, 4, null);
        } else {
            i3 = heightOrZero2;
            i4 = iRoundToInt;
            i5 = heightOrZero;
        }
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeable) + LayoutUtilKt.getWidthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, place$calculateVerticalPosition(i5, this, i3, i4, placeable6, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, widthOrZero, place$calculateVerticalPosition(i5, this, i3, i4, placeable6, placeable7), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i2 - LayoutUtilKt.getWidthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(i5, this, i3, i4, placeable6, placeable4), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), i5 + Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i3), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, i5 + i3, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(int i, OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy, int i2, int i3, Placeable placeable, Placeable placeable2) {
        if (outlinedTextFieldMeasurePolicy.singleLine) {
            i3 = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
        }
        int i4 = i + i3;
        return outlinedTextFieldMeasurePolicy.labelPosition instanceof TextFieldLabelPosition.Above ? i4 : Math.max(i4, LayoutUtilKt.getHeightOrZero(placeable) / 2);
    }

    private final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable7 = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.TextFieldId)) {
                int iIntValue = function2.invoke(intrinsicMeasurable7, Integer.valueOf(i)).intValue();
                int size2 = list2.size();
                int i3 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i3 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable8 != null ? function2.invoke(intrinsicMeasurable8, Integer.valueOf(i)).intValue() : 0;
                int size3 = list2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = list.get(i4);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable9 != null ? function2.invoke(intrinsicMeasurable9, Integer.valueOf(i)).intValue() : 0;
                int size4 = list2.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = list.get(i5);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(i)).intValue() : 0;
                int size5 = list2.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = list.get(i6);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int iIntValue5 = intrinsicMeasurable11 != null ? function2.invoke(intrinsicMeasurable11, Integer.valueOf(i)).intValue() : 0;
                int size6 = list2.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i7);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int iIntValue6 = intrinsicMeasurable12 != null ? function2.invoke(intrinsicMeasurable12, Integer.valueOf(i)).intValue() : 0;
                int size7 = list2.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = list.get(i8);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                return m3255calculateWidthIzADHW4(intrinsicMeasureScope, iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, intrinsicMeasurable14 != null ? function2.invoke(intrinsicMeasurable14, Integer.valueOf(i)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.labelProgress.invoke());
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
