package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.Alignment;
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
import androidx.compose.ui.unit.IntOffset;
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

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\"\u0010\u001e\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\"\u0010\u001f\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001aH\u0016J\"\u0010!\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001aH\u0016J8\u0010\"\u001a\u00020\u001a2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010 \u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0$H\u0002J<\u0010%\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00132\u0006\u0010\u001d\u001a\u00020\u001a2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0$H\u0002JO\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/Jk\u00100\u001a\u00020\u001a*\u0002012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020;H\u0002¢\u0006\u0004\b<\u0010=J \u0001\u0010>\u001a\u00020?*\u00020@2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010C2\b\u0010G\u001a\u0004\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010C2\u0006\u0010J\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010C2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020;2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020PH\u0002Jp\u0010Q\u001a\u00020?*\u00020@2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010C2\b\u0010G\u001a\u0004\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010C2\b\u0010I\u001a\u0004\u0018\u00010C2\u0006\u0010J\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010C2\u0006\u0010S\u001a\u00020;H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006T"}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "minimizedLabelHalfHeight", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "minIntrinsicHeight", "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "calculateHeight", "Landroidx/compose/ui/unit/Density;", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "placeWithLabel", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelStartY", "labelEndY", "textPosition", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeWithoutLabel", "textPlaceable", "density", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final float minimizedLabelHalfHeight;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public /* synthetic */ TextFieldMeasurePolicy(boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, PaddingValues paddingValues, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, textFieldLabelPosition, floatProducer, paddingValues, f2);
    }

    private TextFieldMeasurePolicy(boolean z, TextFieldLabelPosition textFieldLabelPosition, FloatProducer floatProducer, PaddingValues paddingValues, float f2) {
        this.singleLine = z;
        this.labelPosition = textFieldLabelPosition;
        this.labelProgress = floatProducer;
        this.paddingValues = paddingValues;
        this.minimizedLabelHalfHeight = f2;
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
        Measurable measurable7;
        int i;
        final Placeable placeableMo7445measureBRTryo03;
        final float fInvoke = this.labelProgress.invoke();
        int i2 = measureScope.mo482roundToPx0680j_4(this.paddingValues.getTop());
        int i3 = measureScope.mo482roundToPx0680j_4(this.paddingValues.getBottom());
        long jM8773copyZbe2FdA$default = Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                measurable = null;
                break;
            }
            measurable = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i4++;
        }
        Measurable measurable8 = measurable;
        Placeable placeableMo7445measureBRTryo04 = measurable8 != null ? measurable8.mo7445measureBRTryo0(jM8773copyZbe2FdA$default) : null;
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo04);
        int iMax = Math.max(0, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo04));
        int size2 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                measurable2 = null;
                break;
            }
            measurable2 = list.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i5++;
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
        int iMax2 = Math.max(iMax, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo0));
        int size3 = list2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                measurable3 = null;
                break;
            }
            measurable3 = list.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), TextFieldImplKt.PrefixId)) {
                break;
            }
            i6++;
        }
        Measurable measurable10 = measurable3;
        Placeable placeableMo7445measureBRTryo05 = measurable10 != null ? measurable10.mo7445measureBRTryo0(ConstraintsKt.m8803offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, null)) : null;
        int widthOrZero3 = widthOrZero2 + LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo05);
        int iMax3 = Math.max(iMax2, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo05));
        int size4 = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size4) {
                measurable4 = null;
                break;
            }
            measurable4 = list.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), TextFieldImplKt.SuffixId)) {
                break;
            }
            i7++;
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
        int iMax4 = Math.max(iMax3, LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo02));
        boolean z = this.labelPosition instanceof TextFieldLabelPosition.Above;
        int size5 = list2.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size5) {
                measurable5 = null;
                break;
            }
            measurable5 = list.get(i8);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), TextFieldImplKt.LabelId)) {
                break;
            }
            i8++;
        }
        Measurable measurable12 = measurable5;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (!z) {
            objectRef.element = measurable12 != null ? measurable12.mo7445measureBRTryo0(ConstraintsKt.m8802offsetNN6EwU(j3, -widthOrZero4, -i3)) : 0;
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
        int heightOrZero = i2 + LayoutUtilKt.getHeightOrZero((Placeable) objectRef.element) + iMinIntrinsicHeight;
        long jM8802offsetNN6EwU = ConstraintsKt.m8802offsetNN6EwU(Constraints.m8773copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null), -widthOrZero4, ((-heightOrZero) - i3) - iMinIntrinsicHeight2);
        int size7 = list2.size();
        int i10 = 0;
        while (i10 < size7) {
            Measurable measurable14 = list.get(i10);
            int i11 = size7;
            int i12 = heightOrZero;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable14), TextFieldImplKt.TextFieldId)) {
                final Placeable placeableMo7445measureBRTryo06 = measurable14.mo7445measureBRTryo0(jM8802offsetNN6EwU);
                long jM8773copyZbe2FdA$default2 = Constraints.m8773copyZbe2FdA$default(jM8802offsetNN6EwU, 0, 0, 0, 0, 14, null);
                int size8 = list2.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size8) {
                        measurable7 = null;
                        break;
                    }
                    measurable7 = list.get(i13);
                    int i14 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable7), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i13++;
                    size8 = i14;
                }
                Measurable measurable15 = measurable7;
                Placeable placeableMo7445measureBRTryo07 = measurable15 != null ? measurable15.mo7445measureBRTryo0(jM8773copyZbe2FdA$default2) : null;
                int iMax5 = Math.max(iMax4, Math.max(LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo06), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo07)) + i12 + i3);
                long j4 = j3;
                boolean z2 = z;
                final Placeable placeable = placeableMo7445measureBRTryo02;
                Ref.ObjectRef objectRef2 = objectRef;
                final int iM3695calculateWidthyeHjK3Y = m3695calculateWidthyeHjK3Y(LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo04), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo0), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo05), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo02), placeableMo7445measureBRTryo06.getWidth(), LayoutUtilKt.getWidthOrZero((Placeable) objectRef.element), LayoutUtilKt.getWidthOrZero(placeableMo7445measureBRTryo07), j);
                if (z2) {
                    objectRef2.element = measurable12 != null ? measurable12.mo7445measureBRTryo0(Constraints.m8773copyZbe2FdA$default(j4, 0, iM3695calculateWidthyeHjK3Y, 0, iMinIntrinsicHeight, 5, null)) : 0;
                }
                long jM8773copyZbe2FdA$default3 = Constraints.m8773copyZbe2FdA$default(ConstraintsKt.m8803offsetNN6EwU$default(j4, 0, -iMax5, 1, null), 0, iM3695calculateWidthyeHjK3Y, 0, 0, 9, null);
                if (measurable13 != null) {
                    i = i2;
                    placeableMo7445measureBRTryo03 = measurable13.mo7445measureBRTryo0(jM8773copyZbe2FdA$default3);
                } else {
                    i = i2;
                    placeableMo7445measureBRTryo03 = null;
                }
                int heightOrZero2 = LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03);
                boolean z3 = z2;
                int iM3694calculateHeightmKXJcVc = m3694calculateHeightmKXJcVc(measureScope, placeableMo7445measureBRTryo06.getHeight(), LayoutUtilKt.getHeightOrZero((Placeable) objectRef2.element), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo04), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo0), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo05), LayoutUtilKt.getHeightOrZero(placeable), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo07), LayoutUtilKt.getHeightOrZero(placeableMo7445measureBRTryo03), j, z3, fInvoke);
                final int heightOrZero3 = (iM3694calculateHeightmKXJcVc - heightOrZero2) - (z3 ? LayoutUtilKt.getHeightOrZero((Placeable) objectRef2.element) : 0);
                int size9 = list2.size();
                int i15 = 0;
                while (i15 < size9) {
                    Measurable measurable16 = list.get(i15);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable16), TextFieldImplKt.ContainerId)) {
                        final Placeable placeableMo7445measureBRTryo08 = measurable16.mo7445measureBRTryo0(ConstraintsKt.Constraints(iM3695calculateWidthyeHjK3Y != Integer.MAX_VALUE ? iM3695calculateWidthyeHjK3Y : 0, iM3695calculateWidthyeHjK3Y, heightOrZero3 != Integer.MAX_VALUE ? heightOrZero3 : 0, heightOrZero3));
                        final int i16 = iM3694calculateHeightmKXJcVc;
                        final boolean z4 = z3;
                        final Ref.ObjectRef objectRef3 = objectRef2;
                        final int i17 = i;
                        final Placeable placeable2 = placeableMo7445measureBRTryo04;
                        final Placeable placeable3 = placeableMo7445measureBRTryo0;
                        final Placeable placeable4 = placeableMo7445measureBRTryo07;
                        final Placeable placeable5 = placeableMo7445measureBRTryo05;
                        return MeasureScope.layout$default(measureScope, iM3695calculateWidthyeHjK3Y, i16, null, new Function1() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return TextFieldMeasurePolicy.measure_3p2s80s$lambda$9(objectRef3, z4, this, heightOrZero3, i17, measureScope, iM3695calculateWidthyeHjK3Y, i16, placeableMo7445measureBRTryo06, placeable4, placeable2, placeable3, placeable5, placeable, placeableMo7445measureBRTryo08, placeableMo7445measureBRTryo03, fInvoke, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i15++;
                    iM3694calculateHeightmKXJcVc = iM3694calculateHeightmKXJcVc;
                    z3 = z3;
                    objectRef2 = objectRef2;
                    heightOrZero3 = heightOrZero3;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i10++;
            size7 = i11;
            heightOrZero = i12;
            z = z;
            objectRef = objectRef;
            jM8802offsetNN6EwU = jM8802offsetNN6EwU;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit measure_3p2s80s$lambda$9(Ref.ObjectRef objectRef, boolean z, TextFieldMeasurePolicy textFieldMeasurePolicy, int i, int i2, MeasureScope measureScope, int i3, int i4, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, float f2, Placeable.PlacementScope placementScope) {
        MeasureScope measureScope2;
        int iAlign;
        int i5;
        if (objectRef.element != 0) {
            if (z) {
                measureScope2 = measureScope;
                i5 = 0;
            } else {
                if (textFieldMeasurePolicy.singleLine) {
                    iAlign = Alignment.INSTANCE.getCenterVertically().align(((Placeable) objectRef.element).getHeight(), i);
                    measureScope2 = measureScope;
                } else {
                    measureScope2 = measureScope;
                    iAlign = i2 + measureScope2.mo482roundToPx0680j_4(textFieldMeasurePolicy.minimizedLabelHalfHeight);
                }
                i5 = iAlign;
            }
            textFieldMeasurePolicy.placeWithLabel(placementScope, i3, i4, placeable, (Placeable) objectRef.element, placeable2, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, i5, z ? 0 : i2, z, f2, i2 + (z ? 0 : ((Placeable) objectRef.element).getHeight()), measureScope2.getLayoutDirection());
        } else {
            textFieldMeasurePolicy.placeWithoutLabel(placementScope, i3, i4, placeable, placeable2, placeable3, placeable4, placeable5, placeable6, placeable7, placeable8, measureScope.getDensity());
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicHeight(intrinsicMeasureScope, list, i, new Function2() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, new Function2() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return intrinsicWidth(list, i, new Function2() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(((IntrinsicMeasurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            }
        });
    }

    /* JADX INFO: renamed from: calculateWidth-yeHjK3Y, reason: not valid java name */
    private final int m3695calculateWidthyeHjK3Y(int leadingWidth, int trailingWidth, int prefixWidth, int suffixWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        int i = prefixWidth + suffixWidth;
        return ConstraintsKt.m8800constrainWidthK40F9xA(constraints, leadingWidth + Math.max(textFieldWidth + i, Math.max(placeholderWidth + i, labelWidth)) + trailingWidth);
    }

    /* JADX INFO: renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    private final int m3694calculateHeightmKXJcVc(Density density, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, boolean z, float f2) {
        int iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.paddingValues.getTop() + this.paddingValues.getBottom())) + ((i2 <= 0 || z) ? 0 : Math.max(density.mo482roundToPx0680j_4(Dp.m8830constructorimpl(this.minimizedLabelHalfHeight * 2)), MathHelpersKt.lerp(0, i2, MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier().transform(f2)))) + ComparisonsKt.maxOf(i, i7, i5, i6, z ? 0 : MathHelpersKt.lerp(i2, 0, f2));
        if (!z) {
            i2 = 0;
        }
        return ConstraintsKt.m8799constrainHeightK40F9xA(j, i2 + Math.max(i3, Math.max(i4, iMo482roundToPx0680j_4)) + i8);
    }

    private final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, int i3, int i4, boolean z, float f2, int i5, LayoutDirection layoutDirection) {
        int height = z ? placeable2.getHeight() : 0;
        Placeable.PlacementScope.place$default(placementScope, placeable8, 0, height, 0.0f, 4, null);
        int heightOrZero = (i2 - LayoutUtilKt.getHeightOrZero(placeable9)) - (z ? placeable2.getHeight() : 0);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, height + Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        int iLerp = MathHelpersKt.lerp(i3, i4, f2);
        if (z) {
            Placeable.PlacementScope.place$default(placementScope, placeable2, TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(placeable2.getWidth(), i, layoutDirection), iLerp, 0.0f, 4, null);
        } else {
            int widthOrZero = layoutDirection == LayoutDirection.Ltr ? LayoutUtilKt.getWidthOrZero(placeable4) : LayoutUtilKt.getWidthOrZero(placeable5);
            Placeable.PlacementScope.place$default(placementScope, placeable2, MathHelpersKt.lerp(TextFieldImplKt.getExpandedAlignment(this.labelPosition).align(placeable2.getWidth(), (i - LayoutUtilKt.getWidthOrZero(placeable4)) - LayoutUtilKt.getWidthOrZero(placeable5), layoutDirection) + widthOrZero, TextFieldImplKt.getMinimizedAlignment(this.labelPosition).align(placeable2.getWidth(), (i - LayoutUtilKt.getWidthOrZero(placeable4)) - LayoutUtilKt.getWidthOrZero(placeable5), layoutDirection) + widthOrZero, f2), iLerp, 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, LayoutUtilKt.getWidthOrZero(placeable4), height + i5, 0.0f, 4, null);
        }
        int widthOrZero2 = LayoutUtilKt.getWidthOrZero(placeable4) + LayoutUtilKt.getWidthOrZero(placeable6);
        int i6 = height + i5;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero2, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, widthOrZero2, i6, 0.0f, 4, null);
        }
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - LayoutUtilKt.getWidthOrZero(placeable5)) - placeable7.getWidth(), i6, 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), height + Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, height + heightOrZero, 0.0f, 4, null);
        }
    }

    private final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, float f2) {
        Placeable.PlacementScope.m7511place70tqf50$default(placementScope, placeable7, IntOffset.INSTANCE.m8969getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i2 - LayoutUtilKt.getHeightOrZero(placeable8);
        int iRoundToInt = MathKt.roundToInt(this.paddingValues.getTop() * f2);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, LayoutUtilKt.getWidthOrZero(placeable3), placeWithoutLabel$calculateVerticalPosition(this, heightOrZero, iRoundToInt, placeable5), 0.0f, 4, null);
        }
        int widthOrZero = LayoutUtilKt.getWidthOrZero(placeable5) + LayoutUtilKt.getWidthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, widthOrZero, placeWithoutLabel$calculateVerticalPosition(this, heightOrZero, iRoundToInt, placeable), 0.0f, 4, null);
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, widthOrZero, placeWithoutLabel$calculateVerticalPosition(this, heightOrZero, iRoundToInt, placeable2), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, (i - LayoutUtilKt.getWidthOrZero(placeable4)) - placeable6.getWidth(), placeWithoutLabel$calculateVerticalPosition(this, heightOrZero, iRoundToInt, placeable6), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable8 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, 0, heightOrZero, 0.0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(TextFieldMeasurePolicy textFieldMeasurePolicy, int i, int i2, Placeable placeable) {
        return textFieldMeasurePolicy.singleLine ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i) : i2;
    }

    private final int intrinsicWidth(List<? extends IntrinsicMeasurable> measurables, int height, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMeasurer) {
        IntrinsicMeasurable intrinsicMeasurable;
        IntrinsicMeasurable intrinsicMeasurable2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        IntrinsicMeasurable intrinsicMeasurable5;
        IntrinsicMeasurable intrinsicMeasurable6;
        List<? extends IntrinsicMeasurable> list = measurables;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            IntrinsicMeasurable intrinsicMeasurable7 = measurables.get(i);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.TextFieldId)) {
                int iIntValue = intrinsicMeasurer.invoke(intrinsicMeasurable7, Integer.valueOf(height)).intValue();
                int size2 = list.size();
                int i2 = 0;
                while (true) {
                    intrinsicMeasurable = null;
                    if (i2 >= size2) {
                        intrinsicMeasurable2 = null;
                        break;
                    }
                    intrinsicMeasurable2 = measurables.get(i2);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.LabelId)) {
                        break;
                    }
                    i2++;
                }
                IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable2;
                int iIntValue2 = intrinsicMeasurable8 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable8, Integer.valueOf(height)).intValue() : 0;
                int size3 = list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size3) {
                        intrinsicMeasurable3 = null;
                        break;
                    }
                    intrinsicMeasurable3 = measurables.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.TrailingId)) {
                        break;
                    }
                    i3++;
                }
                IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable3;
                int iIntValue3 = intrinsicMeasurable9 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable9, Integer.valueOf(height)).intValue() : 0;
                int size4 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size4) {
                        intrinsicMeasurable4 = null;
                        break;
                    }
                    intrinsicMeasurable4 = measurables.get(i4);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.PrefixId)) {
                        break;
                    }
                    i4++;
                }
                IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable4;
                int iIntValue4 = intrinsicMeasurable10 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable10, Integer.valueOf(height)).intValue() : 0;
                int size5 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size5) {
                        intrinsicMeasurable5 = null;
                        break;
                    }
                    intrinsicMeasurable5 = measurables.get(i5);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.SuffixId)) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable5;
                int iIntValue5 = intrinsicMeasurable11 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable11, Integer.valueOf(height)).intValue() : 0;
                int size6 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size6) {
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = measurables.get(i6);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.LeadingId)) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable6;
                int iIntValue6 = intrinsicMeasurable12 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable12, Integer.valueOf(height)).intValue() : 0;
                int size7 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size7) {
                        break;
                    }
                    IntrinsicMeasurable intrinsicMeasurable13 = measurables.get(i7);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.PlaceholderId)) {
                        intrinsicMeasurable = intrinsicMeasurable13;
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable;
                return m3695calculateWidthyeHjK3Y(iIntValue6, iIntValue3, iIntValue4, iIntValue5, iIntValue, iIntValue2, intrinsicMeasurable14 != null ? intrinsicMeasurer.invoke(intrinsicMeasurable14, Integer.valueOf(height)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        IntrinsicMeasurable intrinsicMeasurable;
        int i2;
        int iSubtractConstraintSafely;
        int iIntValue;
        IntrinsicMeasurable intrinsicMeasurable2;
        int iIntValue2;
        IntrinsicMeasurable intrinsicMeasurable3;
        IntrinsicMeasurable intrinsicMeasurable4;
        int iSubtractConstraintSafely2;
        int i3;
        IntrinsicMeasurable intrinsicMeasurable5;
        int iIntValue3;
        List<? extends IntrinsicMeasurable> list2;
        IntrinsicMeasurable intrinsicMeasurable6;
        IntrinsicMeasurable intrinsicMeasurable7;
        TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        List<? extends IntrinsicMeasurable> list3 = list;
        int size = list3.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                intrinsicMeasurable = null;
                break;
            }
            intrinsicMeasurable = list.get(i4);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), TextFieldImplKt.LeadingId)) {
                break;
            }
            i4++;
        }
        IntrinsicMeasurable intrinsicMeasurable8 = intrinsicMeasurable;
        if (intrinsicMeasurable8 != null) {
            i2 = i;
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i2, intrinsicMeasurable8.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue = function2.invoke(intrinsicMeasurable8, Integer.valueOf(i2)).intValue();
        } else {
            i2 = i;
            iSubtractConstraintSafely = i2;
            iIntValue = 0;
        }
        int size2 = list3.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                intrinsicMeasurable2 = null;
                break;
            }
            intrinsicMeasurable2 = list.get(i5);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), TextFieldImplKt.TrailingId)) {
                break;
            }
            i5++;
        }
        IntrinsicMeasurable intrinsicMeasurable9 = intrinsicMeasurable2;
        if (intrinsicMeasurable9 != null) {
            iSubtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable9.maxIntrinsicWidth(Integer.MAX_VALUE));
            iIntValue2 = function2.invoke(intrinsicMeasurable9, Integer.valueOf(i2)).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list3.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                intrinsicMeasurable3 = null;
                break;
            }
            intrinsicMeasurable3 = list.get(i6);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable3), TextFieldImplKt.LabelId)) {
                break;
            }
            i6++;
        }
        IntrinsicMeasurable intrinsicMeasurable10 = intrinsicMeasurable3;
        int iIntValue4 = intrinsicMeasurable10 != null ? function2.invoke(intrinsicMeasurable10, Integer.valueOf(iSubtractConstraintSafely)).intValue() : 0;
        int size4 = list3.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size4) {
                intrinsicMeasurable4 = null;
                break;
            }
            intrinsicMeasurable4 = list.get(i7);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable4), TextFieldImplKt.PrefixId)) {
                break;
            }
            i7++;
        }
        IntrinsicMeasurable intrinsicMeasurable11 = intrinsicMeasurable4;
        if (intrinsicMeasurable11 != null) {
            int iIntValue5 = function2.invoke(intrinsicMeasurable11, Integer.valueOf(iSubtractConstraintSafely)).intValue();
            int iSubtractConstraintSafely3 = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable11.maxIntrinsicWidth(Integer.MAX_VALUE));
            i3 = iIntValue5;
            iSubtractConstraintSafely2 = iSubtractConstraintSafely3;
        } else {
            iSubtractConstraintSafely2 = iSubtractConstraintSafely;
            i3 = 0;
        }
        int size5 = list3.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size5) {
                intrinsicMeasurable5 = null;
                break;
            }
            intrinsicMeasurable5 = list.get(i8);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable5), TextFieldImplKt.SuffixId)) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable12 = intrinsicMeasurable5;
        if (intrinsicMeasurable12 != null) {
            iIntValue3 = function2.invoke(intrinsicMeasurable12, Integer.valueOf(iSubtractConstraintSafely2)).intValue();
            iSubtractConstraintSafely2 = LayoutUtilKt.subtractConstraintSafely(iSubtractConstraintSafely2, intrinsicMeasurable12.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue3 = 0;
        }
        int size6 = list3.size();
        int i9 = 0;
        while (i9 < size6) {
            IntrinsicMeasurable intrinsicMeasurable13 = list.get(i9);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable13), TextFieldImplKt.TextFieldId)) {
                int iIntValue6 = function2.invoke(intrinsicMeasurable13, Integer.valueOf(iSubtractConstraintSafely2)).intValue();
                int size7 = list3.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size7) {
                        list2 = list3;
                        intrinsicMeasurable6 = null;
                        break;
                    }
                    intrinsicMeasurable6 = list.get(i10);
                    list2 = list3;
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable6), TextFieldImplKt.PlaceholderId)) {
                        break;
                    }
                    i10++;
                    list3 = list2;
                }
                IntrinsicMeasurable intrinsicMeasurable14 = intrinsicMeasurable6;
                int iIntValue7 = intrinsicMeasurable14 != null ? function2.invoke(intrinsicMeasurable14, Integer.valueOf(iSubtractConstraintSafely2)).intValue() : 0;
                int size8 = list2.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size8) {
                        intrinsicMeasurable7 = null;
                        break;
                    }
                    intrinsicMeasurable7 = list.get(i11);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable7), TextFieldImplKt.SupportingId)) {
                        break;
                    }
                    i11++;
                }
                IntrinsicMeasurable intrinsicMeasurable15 = intrinsicMeasurable7;
                return textFieldMeasurePolicy.m3694calculateHeightmKXJcVc(intrinsicMeasureScope, iIntValue6, iIntValue4, iIntValue, iIntValue2, i3, iIntValue3, iIntValue7, intrinsicMeasurable15 != null ? function2.invoke(intrinsicMeasurable15, Integer.valueOf(i2)).intValue() : 0, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), textFieldMeasurePolicy.labelPosition instanceof TextFieldLabelPosition.Above, textFieldMeasurePolicy.labelProgress.invoke());
            }
            i9++;
            textFieldMeasurePolicy = this;
            list3 = list3;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
