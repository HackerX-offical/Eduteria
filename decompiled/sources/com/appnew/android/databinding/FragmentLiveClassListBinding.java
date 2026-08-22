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
public final class FragmentLiveClassListBinding implements ViewBinding {
    public final RecyclerView recycler;
    private final RelativeLayout rootView;
    public final RecyclerView textRecycler;

    private FragmentLiveClassListBinding(RelativeLayout rootView, RecyclerView recycler, RecyclerView textRecycler) {
        this.rootView = rootView;
        this.recycler = recycler;
        this.textRecycler = textRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLiveClassListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLiveClassListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_live_class_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLiveClassListBinding bind(View rootView) {
        int i = R.id.recycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler);
        if (recyclerView != null) {
            i = R.id.textRecycler;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.textRecycler);
            if (recyclerView2 != null) {
                return new FragmentLiveClassListBinding((RelativeLayout) rootView, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
