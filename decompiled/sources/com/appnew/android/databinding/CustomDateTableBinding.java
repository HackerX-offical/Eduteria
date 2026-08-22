package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomDateTableBinding implements ViewBinding {
    public final TextView dateItem;
    private final RelativeLayout rootView;
    public final View underLine;

    private CustomDateTableBinding(RelativeLayout rootView, TextView dateItem, View underLine) {
        this.rootView = rootView;
        this.dateItem = dateItem;
        this.underLine = underLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomDateTableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDateTableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_date_table, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDateTableBinding bind(View rootView) {
        int i = R.id.dateItem;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dateItem);
        if (textView != null) {
            i = R.id.underLine;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.underLine);
            if (viewFindChildViewById != null) {
                return new CustomDateTableBinding((RelativeLayout) rootView, textView, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
