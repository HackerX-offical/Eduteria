package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetExamCenterBinding implements ViewBinding {
    public final RelativeLayout headerRl;
    public final RecyclerView recyclerCenter;
    private final RelativeLayout rootView;
    public final RelativeLayout scrollableRl;

    private BottomSheetExamCenterBinding(RelativeLayout rootView, RelativeLayout headerRl, RecyclerView recyclerCenter, RelativeLayout scrollableRl) {
        this.rootView = rootView;
        this.headerRl = headerRl;
        this.recyclerCenter = recyclerCenter;
        this.scrollableRl = scrollableRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetExamCenterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetExamCenterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_exam_center, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetExamCenterBinding bind(View rootView) {
        int i = R.id.header_rl;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.header_rl);
        if (relativeLayout != null) {
            i = R.id.recycler_center;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_center);
            if (recyclerView != null) {
                i = R.id.scrollable_rl;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.scrollable_rl);
                if (relativeLayout2 != null) {
                    return new BottomSheetExamCenterBinding((RelativeLayout) rootView, relativeLayout, recyclerView, relativeLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
