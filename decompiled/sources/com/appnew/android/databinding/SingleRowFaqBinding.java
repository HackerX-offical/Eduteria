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
public final class SingleRowFaqBinding implements ViewBinding {
    public final TextView answertextTV;
    public final View dividerV;
    public final ImageView dropDownIV;
    public final LinearLayout lowerViewItem;
    public final LinearLayout parentLL;
    public final TextView questionTV;
    public final TextView questiontextTV;
    private final LinearLayout rootView;
    public final LinearLayout topViewItem;

    private SingleRowFaqBinding(LinearLayout rootView, TextView answertextTV, View dividerV, ImageView dropDownIV, LinearLayout lowerViewItem, LinearLayout parentLL, TextView questionTV, TextView questiontextTV, LinearLayout topViewItem) {
        this.rootView = rootView;
        this.answertextTV = answertextTV;
        this.dividerV = dividerV;
        this.dropDownIV = dropDownIV;
        this.lowerViewItem = lowerViewItem;
        this.parentLL = parentLL;
        this.questionTV = questionTV;
        this.questiontextTV = questiontextTV;
        this.topViewItem = topViewItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowFaqBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowFaqBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_faq, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowFaqBinding bind(View rootView) {
        int i = R.id.answertextTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.answertextTV);
        if (textView != null) {
            i = R.id.dividerV;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dividerV);
            if (viewFindChildViewById != null) {
                i = R.id.dropDownIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dropDownIV);
                if (imageView != null) {
                    i = R.id.lowerViewItem;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lowerViewItem);
                    if (linearLayout != null) {
                        i = R.id.parentLL;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                        if (linearLayout2 != null) {
                            i = R.id.questionTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questionTV);
                            if (textView2 != null) {
                                i = R.id.questiontextTV;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questiontextTV);
                                if (textView3 != null) {
                                    i = R.id.topViewItem;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.topViewItem);
                                    if (linearLayout3 != null) {
                                        return new SingleRowFaqBinding((LinearLayout) rootView, textView, viewFindChildViewById, imageView, linearLayout, linearLayout2, textView2, textView3, linearLayout3);
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
