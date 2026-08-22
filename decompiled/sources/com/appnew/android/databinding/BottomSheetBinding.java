package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetBinding implements ViewBinding {
    public final LinearLayout bottom;
    private final LinearLayout rootView;
    public final RecyclerView streamItems;
    public final View view;

    private BottomSheetBinding(LinearLayout rootView, LinearLayout bottom, RecyclerView streamItems, View view) {
        this.rootView = rootView;
        this.bottom = bottom;
        this.streamItems = streamItems;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.streamItems;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.streamItems);
        if (recyclerView != null) {
            i = R.id.view;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
            if (viewFindChildViewById != null) {
                return new BottomSheetBinding(linearLayout, linearLayout, recyclerView, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
