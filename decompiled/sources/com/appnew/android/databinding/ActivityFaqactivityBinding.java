package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFaqactivityBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView faqImageBack;
    public final TextView faqTitleTV;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    private final ConstraintLayout rootView;
    public final RecyclerView rvList;

    private ActivityFaqactivityBinding(ConstraintLayout rootView, Button backBtn, ImageView faqImageBack, TextView faqTitleTV, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, RecyclerView rvList) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.faqImageBack = faqImageBack;
        this.faqTitleTV = faqTitleTV;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.rvList = rvList;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFaqactivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFaqactivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_faqactivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFaqactivityBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.faq_image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.faq_image_back);
            if (imageView != null) {
                i = R.id.faqTitleTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.faqTitleTV);
                if (textView != null) {
                    i = R.id.image;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                    if (imageView2 != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.no_data;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                            if (textView2 != null) {
                                i = R.id.no_data_found_RL;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                if (relativeLayout != null) {
                                    i = R.id.rv_list;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rv_list);
                                    if (recyclerView != null) {
                                        return new ActivityFaqactivityBinding((ConstraintLayout) rootView, button, imageView, textView, imageView2, toolbar, textView2, relativeLayout, recyclerView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
