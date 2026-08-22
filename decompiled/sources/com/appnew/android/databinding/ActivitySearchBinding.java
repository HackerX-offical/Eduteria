package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySearchBinding implements ViewBinding {
    public final ImageView clearIV;
    public final AutoCompleteTextView etSearch;
    public final ImageView imageBack;
    public final ImageView noData;
    public final TextView noDataFound;
    public final CoordinatorLayout root;
    private final CoordinatorLayout rootView;
    public final RecyclerView searchListRV;

    private ActivitySearchBinding(CoordinatorLayout rootView, ImageView clearIV, AutoCompleteTextView etSearch, ImageView imageBack, ImageView noData, TextView noDataFound, CoordinatorLayout root, RecyclerView searchListRV) {
        this.rootView = rootView;
        this.clearIV = clearIV;
        this.etSearch = etSearch;
        this.imageBack = imageBack;
        this.noData = noData;
        this.noDataFound = noDataFound;
        this.root = root;
        this.searchListRV = searchListRV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_search, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySearchBinding bind(View rootView) {
        int i = R.id.clearIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.clearIV);
        if (imageView != null) {
            i = R.id.et_search;
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(rootView, R.id.et_search);
            if (autoCompleteTextView != null) {
                i = R.id.imageBack;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageBack);
                if (imageView2 != null) {
                    i = R.id.no_data;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                    if (imageView3 != null) {
                        i = R.id.no_data_found;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data_found);
                        if (textView != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                            i = R.id.searchListRV;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.searchListRV);
                            if (recyclerView != null) {
                                return new ActivitySearchBinding(coordinatorLayout, imageView, autoCompleteTextView, imageView2, imageView3, textView, coordinatorLayout, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
