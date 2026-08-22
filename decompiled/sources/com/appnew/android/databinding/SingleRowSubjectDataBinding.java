package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowSubjectDataBinding implements ViewBinding {
    public final ImageView dropDownIV;
    public final LinearLayout lowerViewItem;
    public final LinearLayout parentLL;
    public final TextView questiontextTV;
    private final LinearLayout rootView;
    public final RecyclerView subjectRV;
    public final LinearLayout topViewItem;

    private SingleRowSubjectDataBinding(LinearLayout rootView, ImageView dropDownIV, LinearLayout lowerViewItem, LinearLayout parentLL, TextView questiontextTV, RecyclerView subjectRV, LinearLayout topViewItem) {
        this.rootView = rootView;
        this.dropDownIV = dropDownIV;
        this.lowerViewItem = lowerViewItem;
        this.parentLL = parentLL;
        this.questiontextTV = questiontextTV;
        this.subjectRV = subjectRV;
        this.topViewItem = topViewItem;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowSubjectDataBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowSubjectDataBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_subject_data, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowSubjectDataBinding bind(View rootView) {
        int i = R.id.dropDownIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dropDownIV);
        if (imageView != null) {
            i = R.id.lowerViewItem;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lowerViewItem);
            if (linearLayout != null) {
                i = R.id.parentLL;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                if (linearLayout2 != null) {
                    i = R.id.questiontextTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.questiontextTV);
                    if (textView != null) {
                        i = R.id.subjectRV;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.subjectRV);
                        if (recyclerView != null) {
                            i = R.id.topViewItem;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.topViewItem);
                            if (linearLayout3 != null) {
                                return new SingleRowSubjectDataBinding((LinearLayout) rootView, imageView, linearLayout, linearLayout2, textView, recyclerView, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
