package com.appnew.android.Utils;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class GridDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mHorizontalDivider;
    private int mNumColumns;
    private Drawable mVerticalDivider;

    public GridDividerItemDecoration(Drawable horizontalDivider, Drawable verticalDivider, int numColumns) {
        this.mHorizontalDivider = horizontalDivider;
        this.mVerticalDivider = verticalDivider;
        this.mNumColumns = numColumns;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        drawHorizontalDividers(canvas, parent);
        drawVerticalDividers(canvas, parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) % this.mNumColumns != 0) {
            outRect.left = this.mHorizontalDivider.getIntrinsicWidth();
        }
        if (parent.getChildAdapterPosition(view) < this.mNumColumns) {
            return;
        }
        outRect.top = this.mVerticalDivider.getIntrinsicHeight();
    }

    private void drawHorizontalDividers(Canvas canvas, RecyclerView parent) {
        int childCount = parent.getChildCount();
        int i = this.mNumColumns;
        int i2 = childCount / i;
        int i3 = childCount % i;
        int i4 = 1;
        while (true) {
            int i5 = this.mNumColumns;
            if (i4 >= i5) {
                return;
            }
            int i6 = i4 < i3 ? (i5 * i2) + i4 : i4 + ((i2 - 1) * i5);
            View childAt = parent.getChildAt(i4);
            View childAt2 = parent.getChildAt(i6);
            int top = childAt.getTop();
            int left = childAt.getLeft();
            this.mHorizontalDivider.setBounds(left - this.mHorizontalDivider.getIntrinsicWidth(), top, left, childAt2.getBottom());
            this.mHorizontalDivider.draw(canvas);
            i4++;
        }
    }

    private void drawVerticalDividers(Canvas canvas, RecyclerView parent) {
        int childCount;
        int childCount2 = parent.getChildCount() / this.mNumColumns;
        for (int i = 1; i <= childCount2; i++) {
            if (i == childCount2) {
                childCount = parent.getChildCount() - 1;
            } else {
                int i2 = this.mNumColumns;
                childCount = ((i * i2) + i2) - 1;
            }
            View childAt = parent.getChildAt(this.mNumColumns * i);
            View childAt2 = parent.getChildAt(childCount);
            int left = childAt.getLeft();
            int top = childAt.getTop();
            this.mVerticalDivider.setBounds(left, top - this.mVerticalDivider.getIntrinsicHeight(), childAt2.getRight(), top);
            this.mVerticalDivider.draw(canvas);
        }
    }
}
