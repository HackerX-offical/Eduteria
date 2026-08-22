package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityChooseCourseBinding implements ViewBinding {
    public final RecyclerView courseListRV;
    public final ImageView ivBack;
    public final NoDataFoundBinding noData;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final Button signupBtn;
    public final TextView title;

    private ActivityChooseCourseBinding(RelativeLayout rootView, RecyclerView courseListRV, ImageView ivBack, NoDataFoundBinding noData, RelativeLayout rlMain, Button signupBtn, TextView title) {
        this.rootView = rootView;
        this.courseListRV = courseListRV;
        this.ivBack = ivBack;
        this.noData = noData;
        this.rlMain = rlMain;
        this.signupBtn = signupBtn;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChooseCourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityChooseCourseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_choose_course, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChooseCourseBinding bind(View rootView) {
        int i = R.id.courseListRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
        if (recyclerView != null) {
            i = R.id.iv_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
            if (imageView != null) {
                i = R.id.no_data;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.no_data);
                if (viewFindChildViewById != null) {
                    NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
                    i = R.id.rl_main;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                    if (relativeLayout != null) {
                        i = R.id.signupBtn;
                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.signupBtn);
                        if (button != null) {
                            i = R.id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                            if (textView != null) {
                                return new ActivityChooseCourseBinding((RelativeLayout) rootView, recyclerView, imageView, noDataFoundBindingBind, relativeLayout, button, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
