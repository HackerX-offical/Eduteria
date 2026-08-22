package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextFieldCoreModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\u001a+\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a6\u0010\u001b\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\""}, d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "F", "isSpecified", "", "Landroidx/compose/ui/graphics/Brush;", "(Landroidx/compose/ui/graphics/Brush;)Z", "getCursorRectInScroller", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/Density;", "cursorRect", "rtl", "textLayoutSize", "", "roundToNext", "", "drawDefaultSelectionHighlight", "", "Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "scope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "selection", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawDefaultSelectionHighlight-YmzfRxQ", "(Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawDefaultCursor", "brush", "showCursor", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TextFieldCoreModifierKt {
    private static final float DefaultCursorThickness = Dp.m8830constructorimpl(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSpecified(Brush brush) {
        return ((brush instanceof SolidColor) && ((SolidColor) brush).getValue() == 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getCursorRectInScroller(Density density, Rect rect, boolean z, int i) {
        float left;
        float left2;
        int iMo482roundToPx0680j_4 = density.mo482roundToPx0680j_4(DefaultCursorThickness);
        if (z) {
            left = i - rect.getRight();
        } else {
            left = rect.getLeft();
        }
        float f2 = left;
        if (z) {
            left2 = i - rect.getRight();
        } else {
            left2 = rect.getLeft();
        }
        return Rect.copy$default(rect, f2, 0.0f, left2 + iMo482roundToPx0680j_4, 0.0f, 10, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float roundToNext(float f2) {
        double dFloor;
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        if (f2 > 0.0f) {
            dFloor = Math.ceil(f2);
        } else {
            dFloor = Math.floor(f2);
        }
        return (float) dFloor;
    }

    /* JADX INFO: renamed from: drawDefaultSelectionHighlight-YmzfRxQ, reason: not valid java name */
    public static final void m2073drawDefaultSelectionHighlightYmzfRxQ(TextFieldCoreModifierNode textFieldCoreModifierNode, DrawScope drawScope, long j, TextLayoutResult textLayoutResult) {
        int iM8271getMinimpl = TextRange.m8271getMinimpl(j);
        int iM8270getMaximpl = TextRange.m8270getMaximpl(j);
        if (iM8271getMinimpl != iM8270getMaximpl) {
            DrawScope.m6539drawPathLG529CI$default(drawScope, textLayoutResult.getPathForRange(iM8271getMinimpl, iM8270getMaximpl), ((TextSelectionColors) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldCoreModifierNode, TextSelectionColorsKt.getLocalTextSelectionColors())).getBackgroundColor(), 0.0f, null, null, 0, 60, null);
        }
    }

    public static final void drawDefaultCursor(TextFieldCoreModifierNode textFieldCoreModifierNode, DrawScope drawScope, Brush brush, boolean z, CursorAnimationState cursorAnimationState, TextFieldSelectionState textFieldSelectionState) {
        float cursorAlpha = cursorAnimationState != null ? cursorAnimationState.getCursorAlpha() : 0.0f;
        if (cursorAlpha != 0.0f && z) {
            Rect cursorRect = textFieldSelectionState.getCursorRect();
            DrawScope.m6534drawLine1RTmtNc$default(drawScope, brush, cursorRect.m5757getTopCenterF1C5BW0(), cursorRect.m5750getBottomCenterF1C5BW0(), cursorRect.getRight() - cursorRect.getLeft(), 0, null, cursorAlpha, null, 0, 432, null);
        }
    }
}
