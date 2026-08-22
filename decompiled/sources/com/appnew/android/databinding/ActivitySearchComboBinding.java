package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySearchComboBinding implements ViewBinding {
    public final ImageView clearIV;
    public final AutoCompleteTextView etSearch;
    public final ImageView imageBack;
    public final ProgressBar progressBar;
    public final CoordinatorLayout root;
    private final CoordinatorLayout rootView;
    public final RecyclerView searchListRV;

    private ActivitySearchComboBinding(CoordinatorLayout rootView, ImageView clearIV, AutoCompleteTextView etSearch, ImageView imageBack, ProgressBar progressBar, CoordinatorLayout root, RecyclerView searchListRV) {
        this.rootView = rootView;
        this.clearIV = clearIV;
        this.etSearch = etSearch;
        this.imageBack = imageBack;
        this.progressBar = progressBar;
        this.root = root;
        this.searchListRV = searchListRV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchComboBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySearchComboBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_search_combo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySearchComboBinding bind(View rootView) {
        int i = R.id.clearIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.clearIV);
        if (imageView != null) {
            i = R.id.et_search;
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.et_search);
            if (autoCompleteTextView != null) {
                i = R.id.imageBack;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageBack);
                if (imageView2 != null) {
                    i = R.id.progressBar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                    if (progressBar != null) {
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                        i = R.id.searchListRV;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.searchListRV);
                        if (recyclerView != null) {
                            return new ActivitySearchComboBinding(coordinatorLayout, imageView, autoCompleteTextView, imageView2, progressBar, coordinatorLayout, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
