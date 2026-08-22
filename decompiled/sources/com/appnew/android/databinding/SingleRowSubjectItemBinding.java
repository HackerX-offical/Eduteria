package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowSubjectItemBinding implements ViewBinding {
    public final LinearLayout parentLL;
    public final TextView questiontextTV;
    private final LinearLayout rootView;
    public final CheckBox selectCB;

    private SingleRowSubjectItemBinding(LinearLayout rootView, LinearLayout parentLL, TextView questiontextTV, CheckBox selectCB) {
        this.rootView = rootView;
        this.parentLL = parentLL;
        this.questiontextTV = questiontextTV;
        this.selectCB = selectCB;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowSubjectItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowSubjectItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_subject_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowSubjectItemBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.questiontextTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.questiontextTV);
        if (textView != null) {
            i = R.id.selectCB;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.selectCB);
            if (checkBox != null) {
                return new SingleRowSubjectItemBinding(linearLayout, linearLayout, textView, checkBox);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
