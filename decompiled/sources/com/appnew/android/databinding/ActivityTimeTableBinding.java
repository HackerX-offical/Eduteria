package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTimeTableBinding implements ViewBinding {
    public final RecyclerView DateTableRecycler;
    public final ImageView arrow1;
    public final ImageView arrow2;
    public final Button backBtn;
    public final RecyclerView batchRecycler;
    public final ImageView currentAffairImageBack;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    private final RelativeLayout rootView;
    public final LinearLayout teacherTimeTableLayout;
    public final RecyclerView timeTableRecycler;
    public final TextView toolbarTitleTV;

    private ActivityTimeTableBinding(RelativeLayout rootView, RecyclerView DateTableRecycler, ImageView arrow1, ImageView arrow2, Button backBtn, RecyclerView batchRecycler, ImageView currentAffairImageBack, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, LinearLayout teacherTimeTableLayout, RecyclerView timeTableRecycler, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.DateTableRecycler = DateTableRecycler;
        this.arrow1 = arrow1;
        this.arrow2 = arrow2;
        this.backBtn = backBtn;
        this.batchRecycler = batchRecycler;
        this.currentAffairImageBack = currentAffairImageBack;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.teacherTimeTableLayout = teacherTimeTableLayout;
        this.timeTableRecycler = timeTableRecycler;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTimeTableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTimeTableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_time_table, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTimeTableBinding bind(View rootView) {
        int i = R.id.DateTableRecycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.DateTableRecycler);
        if (recyclerView != null) {
            i = R.id.arrow1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow1);
            if (imageView != null) {
                i = R.id.arrow2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow2);
                if (imageView2 != null) {
                    i = R.id.backBtn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
                    if (button != null) {
                        i = R.id.batchRecycler;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.batchRecycler);
                        if (recyclerView2 != null) {
                            i = R.id.currentAffair_image_back;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_image_back);
                            if (imageView3 != null) {
                                i = R.id.image;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                if (imageView4 != null) {
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.no_data;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                        if (textView != null) {
                                            i = R.id.no_data_found_RL;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                            if (relativeLayout != null) {
                                                i = R.id.teacherTimeTableLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.teacherTimeTableLayout);
                                                if (linearLayout != null) {
                                                    i = R.id.timeTableRecycler;
                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.timeTableRecycler);
                                                    if (recyclerView3 != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView2 != null) {
                                                            return new ActivityTimeTableBinding((RelativeLayout) rootView, recyclerView, imageView, imageView2, button, recyclerView2, imageView3, imageView4, toolbar, textView, relativeLayout, linearLayout, recyclerView3, textView2);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
