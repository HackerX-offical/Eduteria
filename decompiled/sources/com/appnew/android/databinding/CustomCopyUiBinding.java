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
public final class CustomCopyUiBinding implements ViewBinding {
    public final TextView copyText;
    private final ConstraintLayout rootView;

    private CustomCopyUiBinding(ConstraintLayout rootView, TextView copyText) {
        this.rootView = rootView;
        this.copyText = copyText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CustomCopyUiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomCopyUiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_copy_ui, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomCopyUiBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.copyText);
        if (textView != null) {
            return new CustomCopyUiBinding((ConstraintLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.copyText)));
    }
}
