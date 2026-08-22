package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes8.dex */
abstract class SheetDelegate {
    abstract int calculateInnerMargin(ViewGroup.MarginLayoutParams marginLayoutParams);

    abstract float calculateSlideOffset(int i);

    abstract int calculateTargetStateOnViewReleased(View view, float f2, float f3);

    abstract int getExpandedOffset();

    abstract int getHiddenOffset();

    abstract <V extends View> int getOuterEdge(V v);

    abstract int getSheetEdge();

    abstract boolean isSettling(View view, int i, boolean z);

    abstract boolean shouldHide(View view, float f2);

    abstract void updateCoplanarSiblingLayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2);

    SheetDelegate() {
    }
}
