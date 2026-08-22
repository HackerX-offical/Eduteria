package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentExamsSubcategoryBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RecyclerView subcategoryExamsRV;

    private FragmentExamsSubcategoryBinding(FrameLayout rootView, RecyclerView subcategoryExamsRV) {
        this.rootView = rootView;
        this.subcategoryExamsRV = subcategoryExamsRV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamsSubcategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentExamsSubcategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_exams_subcategory, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamsSubcategoryBinding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.subcategoryExamsRV);
        if (recyclerView != null) {
            return new FragmentExamsSubcategoryBinding((FrameLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.subcategoryExamsRV)));
    }
}
