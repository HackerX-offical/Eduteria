package com.futuremind.recyclerviewfastscroll;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    List<ScrollerListener> f590listeners = new ArrayList();
    int oldScrollState = 0;
    private final FastScroller scroller;

    public interface ScrollerListener {
        void onScroll(float relativePos);
    }

    public RecyclerViewScrollListener(FastScroller scroller) {
        this.scroller = scroller;
    }

    public void addScrollerListener(ScrollerListener listener) {
        this.f590listeners.add(listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newScrollState) {
        super.onScrollStateChanged(recyclerView, newScrollState);
        if (newScrollState == 0 && this.oldScrollState != 0) {
            this.scroller.getViewProvider().onScrollFinished();
        } else if (newScrollState != 0 && this.oldScrollState == 0) {
            this.scroller.getViewProvider().onScrollStarted();
        }
        this.oldScrollState = newScrollState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView rv, int dx, int dy) {
        if (this.scroller.shouldUpdateHandlePosition()) {
            updateHandlePosition(rv);
        }
    }

    void updateHandlePosition(RecyclerView rv) {
        int iComputeHorizontalScrollOffset;
        int iComputeHorizontalScrollExtent;
        int iComputeHorizontalScrollRange;
        if (this.scroller.isVertical()) {
            iComputeHorizontalScrollOffset = rv.computeVerticalScrollOffset();
            iComputeHorizontalScrollExtent = rv.computeVerticalScrollExtent();
            iComputeHorizontalScrollRange = rv.computeVerticalScrollRange();
        } else {
            iComputeHorizontalScrollOffset = rv.computeHorizontalScrollOffset();
            iComputeHorizontalScrollExtent = rv.computeHorizontalScrollExtent();
            iComputeHorizontalScrollRange = rv.computeHorizontalScrollRange();
        }
        float f2 = iComputeHorizontalScrollOffset / (iComputeHorizontalScrollRange - iComputeHorizontalScrollExtent);
        this.scroller.setScrollerPosition(f2);
        notifyListeners(f2);
    }

    public void notifyListeners(float relativePos) {
        Iterator<ScrollerListener> it = this.f590listeners.iterator();
        while (it.hasNext()) {
            it.next().onScroll(relativePos);
        }
    }
}
