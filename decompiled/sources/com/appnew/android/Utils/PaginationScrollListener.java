package com.appnew.android.Utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    LinearLayoutManager layoutManager;

    public abstract int getTotalPageCount();

    public abstract boolean isLastPage();

    public abstract boolean isLoading();

    protected abstract void loadMoreItems();

    public PaginationScrollListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int childCount = this.layoutManager.getChildCount();
        int itemCount = this.layoutManager.getItemCount();
        int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        if (isLoading() || isLastPage() || childCount + iFindFirstVisibleItemPosition < itemCount || iFindFirstVisibleItemPosition < 0) {
            return;
        }
        loadMoreItems();
    }
}
