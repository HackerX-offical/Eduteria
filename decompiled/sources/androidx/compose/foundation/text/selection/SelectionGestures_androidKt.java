package androidx.compose.foundation.text.selection;

import kotlin.Metadata;

/* JADX INFO: compiled from: SelectionGestures.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"isMouseOrTouchPad", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "FirstLongPressSelectionAdjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getFirstLongPressSelectionAdjustment", "()Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SelectionGestures_androidKt {
    private static final SelectionAdjustment FirstLongPressSelectionAdjustment = SelectionAdjustment.INSTANCE.getWord();

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean isMouseOrTouchPad(androidx.compose.ui.input.pointer.PointerEvent r7) {
        /*
            java.util.List r0 = r7.getChanges()
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
            r3 = r2
        Ld:
            r4 = 1
            if (r3 >= r1) goto L49
            java.lang.Object r5 = r0.get(r3)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            int r5 = r5.getType()
            androidx.compose.ui.input.pointer.PointerType$Companion r6 = androidx.compose.ui.input.pointer.PointerType.INSTANCE
            int r6 = r6.m7390getMouseT8wyACA()
            boolean r5 = androidx.compose.ui.input.pointer.PointerType.m7385equalsimpl0(r5, r6)
            if (r5 != 0) goto L46
            android.view.MotionEvent r0 = r7.getMotionEvent()
            if (r0 == 0) goto L35
            r1 = 8194(0x2002, float:1.1482E-41)
            boolean r0 = r0.isFromSource(r1)
            if (r0 != r4) goto L35
            goto L49
        L35:
            android.view.MotionEvent r7 = r7.getMotionEvent()
            if (r7 == 0) goto L45
            r0 = 1048584(0x100008, float:1.469379E-39)
            boolean r7 = r7.isFromSource(r0)
            if (r7 != r4) goto L45
            goto L49
        L45:
            return r2
        L46:
            int r3 = r3 + 1
            goto Ld
        L49:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(androidx.compose.ui.input.pointer.PointerEvent):boolean");
    }

    public static final SelectionAdjustment getFirstLongPressSelectionAdjustment() {
        return FirstLongPressSelectionAdjustment;
    }
}
