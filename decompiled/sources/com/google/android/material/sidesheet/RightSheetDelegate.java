package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes8.dex */
final class RightSheetDelegate extends SheetDelegate {
    final SideSheetBehavior<? extends View> sheetBehavior;

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getSheetEdge() {
        return 0;
    }

    RightSheetDelegate(SideSheetBehavior<? extends View> sideSheetBehavior) {
        this.sheetBehavior = sideSheetBehavior;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getHiddenOffset() {
        return this.sheetBehavior.getParentWidth();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int getExpandedOffset() {
        return Math.max(0, (getHiddenOffset() - this.sheetBehavior.getChildWidth()) - this.sheetBehavior.getInnerMargin());
    }

    private boolean isReleasedCloseToOriginEdge(View view) {
        return view.getLeft() > (getHiddenOffset() - getExpandedOffset()) / 2;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateTargetStateOnViewReleased(View view, float f2, float f3) {
        if (f2 < 0.0f) {
            return 3;
        }
        if (shouldHide(view, f2)) {
            return (isSwipeSignificant(f2, f3) || isReleasedCloseToOriginEdge(view)) ? 5 : 3;
        }
        if (f2 != 0.0f && SheetUtils.isSwipeMostlyHorizontal(f2, f3)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - getExpandedOffset()) < Math.abs(left - getHiddenOffset()) ? 3 : 5;
    }

    private boolean isSwipeSignificant(float f2, float f3) {
        return SheetUtils.isSwipeMostlyHorizontal(f2, f3) && f3 > ((float) this.sheetBehavior.getSignificantVelocityThreshold());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean shouldHide(View view, float f2) {
        return Math.abs(((float) view.getRight()) + (f2 * this.sheetBehavior.getHideFriction())) > this.sheetBehavior.getHideThreshold();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    boolean isSettling(View view, int i, boolean z) {
        int outerEdgeOffsetForState = this.sheetBehavior.getOuterEdgeOffsetForState(i);
        ViewDragHelper viewDragHelper = this.sheetBehavior.getViewDragHelper();
        if (viewDragHelper != null) {
            return z ? viewDragHelper.settleCapturedViewAt(outerEdgeOffsetForState, view.getTop()) : viewDragHelper.smoothSlideViewTo(view, outerEdgeOffsetForState, view.getTop());
        }
        return false;
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    <V extends View> int getOuterEdge(V v) {
        return v.getLeft() - this.sheetBehavior.getInnerMargin();
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    float calculateSlideOffset(int i) {
        float hiddenOffset = getHiddenOffset();
        return (hiddenOffset - i) / (hiddenOffset - getExpandedOffset());
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        int parentWidth = this.sheetBehavior.getParentWidth();
        if (i <= parentWidth) {
            marginLayoutParams.rightMargin = parentWidth - i;
        }
    }

    @Override // com.google.android.material.sidesheet.SheetDelegate
    int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }
}
