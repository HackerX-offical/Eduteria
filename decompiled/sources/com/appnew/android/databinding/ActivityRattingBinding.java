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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityRattingBinding implements ViewBinding {
    public final Button backBtn;
    public final RecyclerView courseReviewRecycler;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final ImageView rattingImageBack;
    private final ConstraintLayout rootView;
    public final FloatingActionButton sendRating;
    public final TextView toolbarTitleTV;

    private ActivityRattingBinding(ConstraintLayout rootView, Button backBtn, RecyclerView courseReviewRecycler, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, ImageView rattingImageBack, FloatingActionButton sendRating, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.courseReviewRecycler = courseReviewRecycler;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.rattingImageBack = rattingImageBack;
        this.sendRating = sendRating;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRattingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRattingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_ratting, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRattingBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.courseReview_Recycler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseReview_Recycler);
            if (recyclerView != null) {
                i = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                if (imageView != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.no_data;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                        if (textView != null) {
                            i = R.id.no_data_found_RL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                            if (relativeLayout != null) {
                                i = R.id.ratting_image_back;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ratting_image_back);
                                if (imageView2 != null) {
                                    i = R.id.send_rating;
                                    FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.send_rating);
                                    if (floatingActionButton != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView2 != null) {
                                            return new ActivityRattingBinding((ConstraintLayout) rootView, button, recyclerView, imageView, toolbar, textView, relativeLayout, imageView2, floatingActionButton, textView2);
                                        }
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
