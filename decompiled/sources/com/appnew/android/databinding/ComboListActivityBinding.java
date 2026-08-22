package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ComboListActivityBinding implements ViewBinding {
    public final RecyclerView comboRV;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final ImageView searchIV;
    public final TextView toolbarTitleTV;

    private ComboListActivityBinding(RelativeLayout rootView, RecyclerView comboRV, ImageView imageBack, Toolbar mainToolbar, ProgressBar progressBar, ImageView searchIV, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.comboRV = comboRV;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.progressBar = progressBar;
        this.searchIV = searchIV;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ComboListActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ComboListActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.combo_list_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ComboListActivityBinding bind(View rootView) {
        int i = R.id.comboRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.comboRV);
        if (recyclerView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.progressBar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                    if (progressBar != null) {
                        i = R.id.searchIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                        if (imageView2 != null) {
                            i = R.id.toolbarTitleTV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                            if (textView != null) {
                                return new ComboListActivityBinding((RelativeLayout) rootView, recyclerView, imageView, toolbar, progressBar, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
