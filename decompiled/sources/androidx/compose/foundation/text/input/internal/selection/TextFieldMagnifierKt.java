package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextFieldMagnifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-hUlJWOE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldMagnifierKt {

    /* JADX INFO: compiled from: TextFieldMagnifier.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-hUlJWOE, reason: not valid java name */
    public static final long m2159calculateSelectionMagnifierCenterAndroidhUlJWOE(TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, long j) {
        int iM8273getStartimpl;
        long jM2179getHandleDragPositionF1C5BW0 = textFieldSelectionState.m2179getHandleDragPositionF1C5BW0();
        if ((9223372034707292159L & jM2179getHandleDragPositionF1C5BW0) == InlineClassHelperKt.UnspecifiedPackedFloats || transformedTextFieldState.getVisualText().length() == 0) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        long selection = transformedTextFieldState.getVisualText().getSelection();
        Handle draggingHandle = textFieldSelectionState.getDraggingHandle();
        int i = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i == -1) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        if (i == 1 || i == 2) {
            iM8273getStartimpl = TextRange.m8273getStartimpl(selection);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            iM8273getStartimpl = TextRange.m8268getEndimpl(selection);
        }
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jM2179getHandleDragPositionF1C5BW0 >> 32));
        int lineForOffset = layoutResult.getLineForOffset(iM8273getStartimpl);
        float lineLeft = layoutResult.getLineLeft(lineForOffset);
        float lineRight = layoutResult.getLineRight(lineForOffset);
        float fCoerceIn = RangesKt.coerceIn(fIntBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        if (!IntSize.m8999equalsimpl0(j, IntSize.INSTANCE.m9006getZeroYbymL2g()) && Math.abs(fIntBitsToFloat - fCoerceIn) > ((int) (j >> 32)) / 2) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        float lineTop = layoutResult.getLineTop(lineForOffset);
        long jM5715constructorimpl = Offset.m5715constructorimpl((((long) Float.floatToRawIntBits(((layoutResult.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop)) & 4294967295L) | (((long) Float.floatToRawIntBits(fCoerceIn)) << 32));
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                jM5715constructorimpl = TextLayoutStateKt.m2116coerceIn3MmeM6k(jM5715constructorimpl, SelectionManagerKt.visibleBounds(textLayoutNodeCoordinates));
            }
        }
        return TextLayoutStateKt.m2118fromTextLayoutToCoreUv8p0NA(textLayoutState, jM5715constructorimpl);
    }
}
