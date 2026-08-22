package com.appnew.android.Utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i = this.spanCount;
        int i2 = childAdapterPosition % i;
        if (this.includeEdge) {
            int i3 = this.spacing;
            outRect.left = i3 - ((i2 * i3) / i);
            int i4 = i2 + 1;
            outRect.right = (this.spacing * i4) / this.spanCount;
            if (childAdapterPosition < this.spanCount) {
                outRect.top = this.spacing;
            }
            outRect.bottom = this.spacing;
            outRect.left = (i2 * this.spacing) / this.spanCount;
            int i5 = this.spacing;
            outRect.right = i5 - ((i4 * i5) / this.spanCount);
            if (childAdapterPosition >= this.spanCount) {
                outRect.top = this.spacing;
            }
        }
    }
}
