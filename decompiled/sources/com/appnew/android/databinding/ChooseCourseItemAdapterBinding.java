package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChooseCourseItemAdapterBinding implements ViewBinding {
    public final LinearLayout currentAffairRL;
    public final ImageView ivCheck;
    public final LinearLayout llMain;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private ChooseCourseItemAdapterBinding(LinearLayout rootView, LinearLayout currentAffairRL, ImageView ivCheck, LinearLayout llMain, TextView tvTitle) {
        this.rootView = rootView;
        this.currentAffairRL = currentAffairRL;
        this.ivCheck = ivCheck;
        this.llMain = llMain;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChooseCourseItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChooseCourseItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.choose_course_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChooseCourseItemAdapterBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.iv_check;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_check);
        if (imageView != null) {
            i = R.id.ll_main;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_main);
            if (linearLayout2 != null) {
                i = R.id.tv_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_title);
                if (textView != null) {
                    return new ChooseCourseItemAdapterBinding(linearLayout, linearLayout, imageView, linearLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
