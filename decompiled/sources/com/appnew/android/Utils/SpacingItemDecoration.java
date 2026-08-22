package com.appnew.android.Utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacingPx;
    private int spanCount;

    public SpacingItemDecoration(int spanCount, int spacingPx, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacingPx = spacingPx;
        this.includeEdge = includeEdge;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i = this.spanCount;
        int i2 = childAdapterPosition % i;
        if (this.includeEdge) {
            int i3 = this.spacingPx;
            outRect.left = i3 - ((i2 * i3) / i);
            outRect.right = ((i2 + 1) * this.spacingPx) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                outRect.top = this.spacingPx;
            }
            outRect.bottom = this.spacingPx;
            return;
        }
        outRect.left = (this.spacingPx * i2) / i;
        int i4 = this.spacingPx;
        outRect.right = i4 - (((i2 + 1) * i4) / this.spanCount);
        if (childAdapterPosition >= this.spanCount) {
            outRect.top = this.spacingPx;
        }
    }
}
