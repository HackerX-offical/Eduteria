package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class StateCityDialogBinding implements ViewBinding {
    public final EditText etSearch;
    public final ImageView ivClearSearch;
    private final RelativeLayout rootView;
    public final RecyclerView searchRecyclerview;
    public final Button tvCancel;

    private StateCityDialogBinding(RelativeLayout rootView, EditText etSearch, ImageView ivClearSearch, RecyclerView searchRecyclerview, Button tvCancel) {
        this.rootView = rootView;
        this.etSearch = etSearch;
        this.ivClearSearch = ivClearSearch;
        this.searchRecyclerview = searchRecyclerview;
        this.tvCancel = tvCancel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StateCityDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StateCityDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.state_city_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StateCityDialogBinding bind(View rootView) {
        int i = R.id.et_search;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_search);
        if (editText != null) {
            i = R.id.iv_clear_search;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_clear_search);
            if (imageView != null) {
                i = R.id.search_recyclerview;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.search_recyclerview);
                if (recyclerView != null) {
                    i = R.id.tv_cancel;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.tv_cancel);
                    if (button != null) {
                        return new StateCityDialogBinding((RelativeLayout) rootView, editText, imageView, recyclerView, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
