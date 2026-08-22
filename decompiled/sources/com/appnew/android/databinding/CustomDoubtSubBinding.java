package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomDoubtSubBinding implements ViewBinding {
    public final TextView doubtSubjectName;
    private final ConstraintLayout rootView;

    private CustomDoubtSubBinding(ConstraintLayout rootView, TextView doubtSubjectName) {
        this.rootView = rootView;
        this.doubtSubjectName = doubtSubjectName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CustomDoubtSubBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDoubtSubBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_doubt_sub, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDoubtSubBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubt_subject_name);
        if (textView != null) {
            return new CustomDoubtSubBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.doubt_subject_name)));
    }
}
