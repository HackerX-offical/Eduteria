package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: MultiWidgetSelectionDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001f\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\n\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0017\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b1\u00102J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u00103\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0014\u001a\u00020\u0013*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getSelectableId", "()J", "lock", "", "Landroidx/compose/foundation/platform/SynchronizedObject;", "Ljava/lang/Object;", "_previousTextLayoutResult", "_previousLastVisibleOffset", "", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "appendSelectableInfoToBuilder", "", "builder", "Landroidx/compose/foundation/text/selection/SelectionLayoutBuilder;", "getSelectAllSelection", "Landroidx/compose/foundation/text/selection/Selection;", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "textLayoutResult", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getLineLeft", "", "getLineRight", "getCenterYForOffset", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getLineHeight", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiWidgetSelectionDelegate implements Selectable {
    public static final int $stable = 8;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;
    private final Object lock = this;
    private int _previousLastVisibleOffset = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiWidgetSelectionDelegate(long j, Function0<? extends LayoutCoordinates> function0, Function0<TextLayoutResult> function02) {
        this.selectableId = j;
        this.coordinatesCallback = function0;
        this.layoutResultCallback = function02;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public long getSelectableId() {
        return this.selectableId;
    }

    private final int getLastVisibleOffset(TextLayoutResult textLayoutResult) {
        int i;
        int lineCount;
        synchronized (this.lock) {
            if (this._previousTextLayoutResult != textLayoutResult) {
                if (!textLayoutResult.getDidOverflowHeight() || textLayoutResult.getMultiParagraph().getDidExceedMaxLines()) {
                    lineCount = textLayoutResult.getLineCount() - 1;
                } else {
                    int iCoerceAtMost = RangesKt.coerceAtMost(textLayoutResult.getLineForVerticalPosition((int) (textLayoutResult.getSize() & 4294967295L)), textLayoutResult.getLineCount() - 1);
                    while (iCoerceAtMost >= 0 && textLayoutResult.getLineTop(iCoerceAtMost) >= ((int) (textLayoutResult.getSize() & 4294967295L))) {
                        iCoerceAtMost--;
                    }
                    lineCount = RangesKt.coerceAtLeast(iCoerceAtMost, 0);
                }
                this._previousLastVisibleOffset = textLayoutResult.getLineEnd(lineCount, true);
                this._previousTextLayoutResult = textLayoutResult;
            }
            i = this._previousLastVisibleOffset;
        }
        return i;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public void appendSelectableInfoToBuilder(SelectionLayoutBuilder builder) {
        TextLayoutResult textLayoutResultInvoke;
        long jM5727minusMKHz9U;
        LayoutCoordinates layoutCoordinates = getLayoutCoordinates();
        if (layoutCoordinates == null || (textLayoutResultInvoke = this.layoutResultCallback.invoke()) == null) {
            return;
        }
        long jMo7454localPositionOfR5De75A = builder.getContainerCoordinates().mo7454localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m5739getZeroF1C5BW0());
        long jM5727minusMKHz9U2 = Offset.m5727minusMKHz9U(builder.getCurrentPosition(), jMo7454localPositionOfR5De75A);
        if ((builder.getPreviousHandlePosition() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            jM5727minusMKHz9U = Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        } else {
            jM5727minusMKHz9U = Offset.m5727minusMKHz9U(builder.getPreviousHandlePosition(), jMo7454localPositionOfR5De75A);
        }
        MultiWidgetSelectionDelegateKt.m2278appendSelectableInfoParwq6A(builder, textLayoutResultInvoke, jM5727minusMKHz9U2, jM5727minusMKHz9U, getSelectableId());
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Selection getSelectAllSelection() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return null;
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        return new Selection(new Selection.AnchorInfo(textLayoutResultInvoke.getBidiRunDirection(0), 0, getSelectableId()), new Selection.AnchorInfo(textLayoutResultInvoke.getBidiRunDirection(Math.max(length - 1, 0)), length, getSelectableId()), false);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getHandlePosition-dBAh8RU, reason: not valid java name */
    public long mo2276getHandlePositiondBAh8RU(Selection selection, boolean isStartHandle) {
        TextLayoutResult textLayoutResultInvoke;
        if ((isStartHandle && selection.getStart().getSelectableId() != getSelectableId()) || (!isStartHandle && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
        }
        if (getLayoutCoordinates() != null && (textLayoutResultInvoke = this.layoutResultCallback.invoke()) != null) {
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResultInvoke, RangesKt.coerceIn((isStartHandle ? selection.getStart() : selection.getEnd()).getOffset(), 0, getLastVisibleOffset(textLayoutResultInvoke)), isStartHandle, selection.getHandlesCrossed());
        }
        return Offset.INSTANCE.m5738getUnspecifiedF1C5BW0();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinatesInvoke = this.coordinatesCallback.invoke();
        if (layoutCoordinatesInvoke == null || !layoutCoordinatesInvoke.isAttached()) {
            return null;
        }
        return layoutCoordinatesInvoke;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public TextLayoutResult textLayoutResult() {
        return this.layoutResultCallback.invoke();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public AnnotatedString getText() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        return textLayoutResultInvoke == null ? new AnnotatedString("", null, 2, null) : textLayoutResultInvoke.getLayoutInput().getText();
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public Rect getBoundingBox(int offset) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return Rect.INSTANCE.getZero();
        }
        int length = textLayoutResultInvoke.getLayoutInput().getText().length();
        if (length < 1) {
            return Rect.INSTANCE.getZero();
        }
        return textLayoutResultInvoke.getBoundingBox(RangesKt.coerceIn(offset, 0, length - 1));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineLeft(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke != null && (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) < textLayoutResultInvoke.getLineCount()) {
            return textLayoutResultInvoke.getLineLeft(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineRight(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke != null && (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) < textLayoutResultInvoke.getLineCount()) {
            return textLayoutResultInvoke.getLineRight(lineForOffset);
        }
        return -1.0f;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getCenterYForOffset(int offset) {
        int lineForOffset;
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null || (lineForOffset = textLayoutResultInvoke.getLineForOffset(offset)) >= textLayoutResultInvoke.getLineCount()) {
            return -1.0f;
        }
        float lineTop = textLayoutResultInvoke.getLineTop(lineForOffset);
        return ((textLayoutResultInvoke.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop;
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    /* JADX INFO: renamed from: getRangeOfLineContaining--jx7JFs, reason: not valid java name */
    public long mo2277getRangeOfLineContainingjx7JFs(int offset) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return TextRange.INSTANCE.m8278getZerod9O1mEE();
        }
        int lastVisibleOffset = getLastVisibleOffset(textLayoutResultInvoke);
        if (lastVisibleOffset < 1) {
            return TextRange.INSTANCE.m8278getZerod9O1mEE();
        }
        int lineForOffset = textLayoutResultInvoke.getLineForOffset(RangesKt.coerceIn(offset, 0, lastVisibleOffset - 1));
        return TextRangeKt.TextRange(textLayoutResultInvoke.getLineStart(lineForOffset), textLayoutResultInvoke.getLineEnd(lineForOffset, true));
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public int getLastVisibleOffset() {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke == null) {
            return 0;
        }
        return getLastVisibleOffset(textLayoutResultInvoke);
    }

    @Override // androidx.compose.foundation.text.selection.Selectable
    public float getLineHeight(int offset) {
        TextLayoutResult textLayoutResultInvoke = this.layoutResultCallback.invoke();
        if (textLayoutResultInvoke != null) {
            return TextLayoutHelperKt.getLineHeight(textLayoutResultInvoke, offset);
        }
        return 0.0f;
    }
}
