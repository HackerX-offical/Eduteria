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
public final class ActivityRewardBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView image;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final TextView rewardPoint;
    public final RecyclerView rewardRecyclerView;
    public final RelativeLayout rewardRelativeLayout;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityRewardBinding(ConstraintLayout rootView, Button backBtn, ImageView image, ImageView imageBack, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, TextView rewardPoint, RecyclerView rewardRecyclerView, RelativeLayout rewardRelativeLayout, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.rewardPoint = rewardPoint;
        this.rewardRecyclerView = rewardRecyclerView;
        this.rewardRelativeLayout = rewardRelativeLayout;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRewardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRewardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_reward, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRewardBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (imageView != null) {
                i = R.id.image_back;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView2 != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.no_data;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                        if (textView != null) {
                            i = R.id.no_data_found_RL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                            if (relativeLayout != null) {
                                i = R.id.rewardPoint;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rewardPoint);
                                if (textView2 != null) {
                                    i = R.id.rewardRecyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rewardRecyclerView);
                                    if (recyclerView != null) {
                                        i = R.id.rewardRelativeLayout;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rewardRelativeLayout);
                                        if (relativeLayout2 != null) {
                                            i = R.id.toolbarTitleTV;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                            if (textView3 != null) {
                                                return new ActivityRewardBinding((ConstraintLayout) rootView, button, imageView, imageView2, toolbar, textView, relativeLayout, textView2, recyclerView, relativeLayout2, textView3);
                                            }
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
