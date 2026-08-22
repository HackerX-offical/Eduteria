package com.appnew.android.testmodule.adapter;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class DragItemTouchHelper extends ItemTouchHelper.Callback {
    public static final float ALPHA_FULL = 1.0f;
    private final MoveHelperAdapter mAdapter;
    private final SwipedHelperAdapter swipedHelperAdapter;

    public interface MoveHelperAdapter {
        boolean onItemMove(int fromPosition, int toPosition);
    }

    public interface SwipedHelperAdapter {
        boolean onItemSwiped(int toPosition);
    }

    public interface TouchViewHolder {
        void onItemClear(int toposition);

        void onItemSelected();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    public DragItemTouchHelper(MoveHelperAdapter adapter, SwipedHelperAdapter swipedHelperAdapter1) {
        this.mAdapter = adapter;
        this.swipedHelperAdapter = swipedHelperAdapter1;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            return makeMovementFlags(15, 0);
        }
        return makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        if (source.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        this.mAdapter.onItemMove(source.getAbsoluteAdapterPosition(), target.getAbsoluteAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.swipedHelperAdapter.onItemSwiped(viewHolder.getAbsoluteAdapterPosition());
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c2, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == 1) {
            viewHolder.itemView.setAlpha(1.0f - (Math.abs(dX) / viewHolder.itemView.getWidth()));
            viewHolder.itemView.setTranslationX(dX);
            return;
        }
        super.onChildDraw(c2, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != 0 && (viewHolder instanceof TouchViewHolder)) {
            ((TouchViewHolder) viewHolder).onItemSelected();
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof TouchViewHolder) {
            ((TouchViewHolder) viewHolder).onItemClear(viewHolder.getAbsoluteAdapterPosition());
        }
    }
}
