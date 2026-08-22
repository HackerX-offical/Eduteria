package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: FocusInteropUtils.android.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u001a%\u0010\u0015\u001a\u00020\u0016*\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"tempCoordinates", "", "tempRect", "Landroid/graphics/Rect;", "toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateFocusRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "requestInteropFocus", "", "direction", "rect", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FocusInteropUtils_androidKt {
    private static final int[] tempCoordinates = new int[2];
    private static final Rect tempRect = new Rect();

    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5607getPreviousdhqQ8s());
        }
        if (i == 2) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5606getNextdhqQ8s());
        }
        if (i == 17) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5605getLeftdhqQ8s());
        }
        if (i == 33) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5609getUpdhqQ8s());
        }
        if (i == 66) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5608getRightdhqQ8s());
        }
        if (i != 130) {
            return null;
        }
        return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5602getDowndhqQ8s());
    }

    /* JADX INFO: renamed from: toAndroidFocusDirection-3ESFkO8, reason: not valid java name */
    public static final Integer m5610toAndroidFocusDirection3ESFkO8(int i) {
        if (FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5609getUpdhqQ8s())) {
            return 33;
        }
        if (FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5602getDowndhqQ8s())) {
            return 130;
        }
        if (FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5605getLeftdhqQ8s())) {
            return 17;
        }
        if (FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5608getRightdhqQ8s())) {
            return 66;
        }
        if (FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5606getNextdhqQ8s())) {
            return 2;
        }
        return FocusDirection.m5598equalsimpl0(i, FocusDirection.INSTANCE.m5607getPreviousdhqQ8s()) ? 1 : null;
    }

    /* JADX INFO: renamed from: toFocusDirection-ZmokQxo, reason: not valid java name */
    public static final FocusDirection m5611toFocusDirectionZmokQxo(KeyEvent keyEvent) {
        long jM7144getKeyZmokQxo = KeyEvent_androidKt.m7144getKeyZmokQxo(keyEvent);
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6985getNavigatePreviousEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5607getPreviousdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6983getNavigateNextEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5606getNextdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7072getTabEK5gGoQ())) {
            return FocusDirection.m5595boximpl(KeyEvent_androidKt.m7150isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m5607getPreviousdhqQ8s() : FocusDirection.INSTANCE.m5606getNextdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6902getDirectionRightEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5608getRightdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6901getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5605getLeftdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6903getDirectionUpEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7024getPageUpEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5609getUpdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6898getDirectionDownEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7023getPageDownEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5602getDowndhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6897getDirectionCenterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6911getEnterEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m7008getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5603getEnterdhqQ8s());
        }
        if (Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6840getBackEK5gGoQ()) || Key.m6824equalsimpl0(jM7144getKeyZmokQxo, Key.INSTANCE.m6914getEscapeEK5gGoQ())) {
            return FocusDirection.m5595boximpl(FocusDirection.INSTANCE.m5604getExitdhqQ8s());
        }
        return null;
    }

    public static final LayoutDirection toLayoutDirection(int i) {
        if (i == 0) {
            return LayoutDirection.Ltr;
        }
        if (i != 1) {
            return null;
        }
        return LayoutDirection.Rtl;
    }

    public static final androidx.compose.ui.geometry.Rect calculateFocusRectRelativeTo(View view, View view2) {
        int[] iArr = tempCoordinates;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        view2.getLocationInWindow(iArr);
        float f2 = i - iArr[0];
        float f3 = i2 - iArr[1];
        view.getFocusedRect(tempRect);
        return new androidx.compose.ui.geometry.Rect(r1.left + f2, r1.top + f3, f2 + r1.left + r1.width(), f3 + r1.top + r1.height());
    }

    public static final boolean requestInteropFocus(View view, Integer num, Rect rect) {
        if (num == null) {
            return view.requestFocus();
        }
        if (!(view instanceof ViewGroup)) {
            return view.requestFocus(num.intValue(), rect);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.isFocused()) {
            return true;
        }
        if (viewGroup.isFocusable() && !viewGroup.hasFocus()) {
            return viewGroup.requestFocus(num.intValue(), rect);
        }
        if (view instanceof AndroidComposeView) {
            return ((AndroidComposeView) view).requestFocus(num.intValue(), rect);
        }
        if (rect != null) {
            View viewFindNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(viewGroup, rect, num.intValue());
            return viewFindNextFocusFromRect != null ? viewFindNextFocusFromRect.requestFocus(num.intValue(), rect) : viewGroup.requestFocus(num.intValue(), rect);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(viewGroup, viewGroup.hasFocus() ? viewGroup.findFocus() : null, num.intValue());
        return viewFindNextFocus != null ? viewFindNextFocus.requestFocus(num.intValue()) : view.requestFocus(num.intValue());
    }
}
