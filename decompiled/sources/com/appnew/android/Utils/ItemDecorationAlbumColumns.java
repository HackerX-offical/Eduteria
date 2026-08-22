package com.appnew.android.Utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class ItemDecorationAlbumColumns extends RecyclerView.ItemDecoration {
    private int mGridSize;
    private boolean mNeedLeftSpacing = false;
    private int mSizeGridSpacingPx;

    public ItemDecorationAlbumColumns(int gridSpacingPx, int gridSize) {
        this.mSizeGridSpacingPx = gridSpacingPx;
        this.mGridSize = gridSize;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        float width = parent.getWidth();
        float f2 = this.mSizeGridSpacingPx;
        int width2 = (parent.getWidth() / this.mGridSize) - ((int) ((width - (f2 * (r1 - 1))) / this.mGridSize));
        int viewAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        if (viewAdapterPosition < this.mGridSize) {
            outRect.top = 0;
        } else {
            outRect.top = this.mSizeGridSpacingPx;
        }
        int i = this.mGridSize;
        if (viewAdapterPosition % i == 0) {
            outRect.left = 0;
            outRect.right = width2;
            this.mNeedLeftSpacing = true;
        } else if ((viewAdapterPosition + 1) % i == 0) {
            this.mNeedLeftSpacing = false;
            outRect.right = 0;
            outRect.left = width2;
        } else if (this.mNeedLeftSpacing) {
            this.mNeedLeftSpacing = false;
            outRect.left = this.mSizeGridSpacingPx - width2;
            if ((viewAdapterPosition + 2) % this.mGridSize == 0) {
                outRect.right = this.mSizeGridSpacingPx - width2;
            } else {
                outRect.right = this.mSizeGridSpacingPx / 2;
            }
        } else if ((viewAdapterPosition + 2) % i == 0) {
            this.mNeedLeftSpacing = false;
            outRect.left = this.mSizeGridSpacingPx / 2;
            outRect.right = this.mSizeGridSpacingPx - width2;
        } else {
            this.mNeedLeftSpacing = false;
            outRect.left = this.mSizeGridSpacingPx / 2;
            outRect.right = this.mSizeGridSpacingPx / 2;
        }
        outRect.bottom = 0;
    }
}
