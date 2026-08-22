package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityStudentListBinding implements ViewBinding {
    public final RecyclerView StudentBatchList;
    public final Button backBtn;
    public final ImageView currentAffairImageBack;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityStudentListBinding(RelativeLayout rootView, RecyclerView StudentBatchList, Button backBtn, ImageView currentAffairImageBack, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.StudentBatchList = StudentBatchList;
        this.backBtn = backBtn;
        this.currentAffairImageBack = currentAffairImageBack;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityStudentListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityStudentListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_student_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityStudentListBinding bind(View rootView) {
        int i = R.id.StudentBatchList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.StudentBatchList);
        if (recyclerView != null) {
            i = R.id.backBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
            if (button != null) {
                i = R.id.currentAffair_image_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_image_back);
                if (imageView != null) {
                    i = R.id.image;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
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
                                    i = R.id.toolbarTitleTV;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                    if (textView2 != null) {
                                        return new ActivityStudentListBinding((RelativeLayout) rootView, recyclerView, button, imageView, imageView2, toolbar, textView, relativeLayout, textView2);
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
