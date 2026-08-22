package com.appnew.android.Utils;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes6.dex */
public class FixedRecyclerView extends RecyclerView {
    public FixedRecyclerView(Context context) {
        super(context);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        if (direction < 0) {
            boolean zCanScrollVertically = super.canScrollVertically(direction);
            return !(zCanScrollVertically || getChildAt(0) == null || getChildAt(0).getTop() >= 0) || zCanScrollVertically;
        }
        return super.canScrollVertically(direction);
    }
}
