package com.appnew.android.Utils;

import android.content.Context;
import android.graphics.PointF;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class LinearLayoutManagerWithSmoothScroller extends LinearLayoutManager {
    public LinearLayoutManagerWithSmoothScroller(Context context) {
        super(context, 1, false);
    }

    public LinearLayoutManagerWithSmoothScroller(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        TopSnappedSmoothScroller topSnappedSmoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
        topSnappedSmoothScroller.setTargetPosition(position);
        startSmoothScroll(topSnappedSmoothScroller);
    }

    private class TopSnappedSmoothScroller extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }

        public TopSnappedSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int targetPosition) {
            return LinearLayoutManagerWithSmoothScroller.this.computeScrollVectorForPosition(targetPosition);
        }
    }
}
