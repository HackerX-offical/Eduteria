package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowFaqDataBinding implements ViewBinding {
    public final TextView answertextTV;
    public final ImageView dropDownIV;
    public final LinearLayout lowerViewItem;
    public final LinearLayout parentLL;
    public final TextView questiontextTV;
    private final LinearLayout rootView;
    public final RelativeLayout topViewItem;

    private SingleRowFaqDataBinding(LinearLayout rootView, TextView answertextTV, ImageView dropDownIV, LinearLayout lowerViewItem, LinearLayout parentLL, TextView questiontextTV, RelativeLayout topViewItem) {
        this.rootView = rootView;
        this.answertextTV = answertextTV;
        this.dropDownIV = dropDownIV;
        this.lowerViewItem = lowerViewItem;
        this.parentLL = parentLL;
        this.questiontextTV = questiontextTV;
        this.topViewItem = topViewItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowFaqDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowFaqDataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_faq_data, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowFaqDataBinding bind(View rootView) {
        int i = R.id.answertextTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.answertextTV);
        if (textView != null) {
            i = R.id.dropDownIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dropDownIV);
            if (imageView != null) {
                i = R.id.lowerViewItem;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lowerViewItem);
                if (linearLayout != null) {
                    i = R.id.parentLL;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                    if (linearLayout2 != null) {
                        i = R.id.questiontextTV;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questiontextTV);
                        if (textView2 != null) {
                            i = R.id.topViewItem;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topViewItem);
                            if (relativeLayout != null) {
                                return new SingleRowFaqDataBinding((LinearLayout) rootView, textView, imageView, linearLayout, linearLayout2, textView2, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
