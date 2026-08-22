package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CursorAnchorInfoBuilder.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u001au\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a,\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u001c"}, d2 = {InAppPurchaseConstants.METHOD_BUILD, "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "decorationBoxBounds", "includeInsertionMarker", "", "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "build-vxqZcH0", "(Landroid/view/inputmethod/CursorAnchorInfo$Builder;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Landroidx/compose/ui/text/TextLayoutResult;Landroid/graphics/Matrix;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ZZZZ)Landroid/view/inputmethod/CursorAnchorInfo;", "setInsertionMarker", "selectionStart", "", "addCharacterBounds", "startOffset", "endOffset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CursorAnchorInfoBuilder_androidKt {
    /* JADX INFO: renamed from: build-vxqZcH0$default, reason: not valid java name */
    public static /* synthetic */ CursorAnchorInfo m1974buildvxqZcH0$default(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 128) != 0) {
            z = true;
        }
        if ((i & 256) != 0) {
            z2 = true;
        }
        if ((i & 512) != 0) {
            z3 = true;
        }
        if ((i & 1024) != 0) {
            z4 = true;
        }
        return m1973buildvxqZcH0(builder, charSequence, j, textRange, textLayoutResult, matrix, rect, rect2, z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: build-vxqZcH0, reason: not valid java name */
    public static final CursorAnchorInfo m1973buildvxqZcH0(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z, boolean z2, boolean z3, boolean z4) {
        builder.reset();
        builder.setMatrix(matrix);
        int iM8271getMinimpl = TextRange.m8271getMinimpl(j);
        builder.setSelectionRange(iM8271getMinimpl, TextRange.m8270getMaximpl(j));
        if (z) {
            setInsertionMarker(builder, iM8271getMinimpl, textLayoutResult, rect);
        }
        if (z2) {
            int iM8271getMinimpl2 = textRange != null ? TextRange.m8271getMinimpl(textRange.getPackedValue()) : -1;
            int iM8270getMaximpl = textRange != null ? TextRange.m8270getMaximpl(textRange.getPackedValue()) : -1;
            if (iM8271getMinimpl2 >= 0 && iM8271getMinimpl2 < iM8270getMaximpl) {
                builder.setComposingText(iM8271getMinimpl2, charSequence.subSequence(iM8271getMinimpl2, iM8270getMaximpl));
                addCharacterBounds(builder, iM8271getMinimpl2, iM8270getMaximpl, textLayoutResult, rect);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && z3) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (Build.VERSION.SDK_INT >= 34 && z4) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i, TextLayoutResult textLayoutResult, Rect rect) {
        if (i < 0) {
            return builder;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(i);
        float fCoerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, (int) (textLayoutResult.getSize() >> 32));
        boolean zContainsInclusive = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fCoerceIn, cursorRect.getTop());
        boolean zContainsInclusive2 = LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(rect, fCoerceIn, cursorRect.getBottom());
        int i2 = 1;
        boolean z = textLayoutResult.getBidiRunDirection(i) == ResolvedTextDirection.Rtl;
        if (!zContainsInclusive && !zContainsInclusive2) {
            i2 = 0;
        }
        if (!zContainsInclusive || !zContainsInclusive2) {
            i2 |= 2;
        }
        if (z) {
            i2 |= 4;
        }
        builder.setInsertionMarkerLocation(fCoerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), i2);
        return builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder addCharacterBounds(android.view.inputmethod.CursorAnchorInfo.Builder r14, int r15, int r16, androidx.compose.ui.text.TextLayoutResult r17, androidx.compose.ui.geometry.Rect r18) {
        /*
            r0 = r16
            r1 = r18
            int r2 = r0 - r15
            int r2 = r2 * 4
            float[] r2 = new float[r2]
            androidx.compose.ui.text.MultiParagraph r3 = r17.getMultiParagraph()
            long r4 = androidx.compose.ui.text.TextRangeKt.TextRange(r15, r16)
            r6 = 0
            r3.m8106fillBoundingBoxes8ffj60Q(r4, r2, r6)
            r8 = r15
        L17:
            if (r8 >= r0) goto L76
            int r3 = r8 - r15
            int r3 = r3 * 4
            androidx.compose.ui.geometry.Rect r4 = new androidx.compose.ui.geometry.Rect
            r5 = r2[r3]
            int r6 = r3 + 1
            r6 = r2[r6]
            int r7 = r3 + 2
            r7 = r2[r7]
            int r3 = r3 + 3
            r3 = r2[r3]
            r4.<init>(r5, r6, r7, r3)
            boolean r3 = r1.overlaps(r4)
            float r5 = r4.getLeft()
            float r6 = r4.getTop()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r5, r6)
            if (r5 == 0) goto L50
            float r5 = r4.getRight()
            float r6 = r4.getBottom()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.containsInclusive(r1, r5, r6)
            if (r5 != 0) goto L52
        L50:
            r3 = r3 | 2
        L52:
            r5 = r17
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r5.getBidiRunDirection(r8)
            androidx.compose.ui.text.style.ResolvedTextDirection r7 = androidx.compose.ui.text.style.ResolvedTextDirection.Rtl
            if (r6 != r7) goto L5e
            r3 = r3 | 4
        L5e:
            r13 = r3
            float r9 = r4.getLeft()
            float r10 = r4.getTop()
            float r11 = r4.getRight()
            float r12 = r4.getBottom()
            r7 = r14
            r7.addCharacterBounds(r8, r9, r10, r11, r12, r13)
            int r8 = r8 + 1
            goto L17
        L76:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnchorInfoBuilder_androidKt.addCharacterBounds(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.geometry.Rect):android.view.inputmethod.CursorAnchorInfo$Builder");
    }
}
