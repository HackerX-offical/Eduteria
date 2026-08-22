package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FaqOverviewPopupLayoutBinding implements ViewBinding {
    public final RecyclerView faqRV;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final LinearLayout rootView;
    public final TextView toolbarTitleTV;

    private FaqOverviewPopupLayoutBinding(LinearLayout rootView, RecyclerView faqRV, ImageView imageBack, Toolbar mainToolbar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.faqRV = faqRV;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FaqOverviewPopupLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FaqOverviewPopupLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.faq_overview_popup_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FaqOverviewPopupLayoutBinding bind(View rootView) {
        int i = R.id.faqRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.faqRV);
        if (recyclerView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new FaqOverviewPopupLayoutBinding((LinearLayout) rootView, recyclerView, imageView, toolbar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
