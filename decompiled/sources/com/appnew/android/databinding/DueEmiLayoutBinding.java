package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DueEmiLayoutBinding implements ViewBinding {
    public final RelativeLayout dueEmiLayout;
    public final Button payEmi;
    private final RelativeLayout rootView;
    public final TextView txtTitle;

    private DueEmiLayoutBinding(RelativeLayout rootView, RelativeLayout dueEmiLayout, Button payEmi, TextView txtTitle) {
        this.rootView = rootView;
        this.dueEmiLayout = dueEmiLayout;
        this.payEmi = payEmi;
        this.txtTitle = txtTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DueEmiLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DueEmiLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.due_emi_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DueEmiLayoutBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.payEmi;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.payEmi);
        if (button != null) {
            i = R.id.txtTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTitle);
            if (textView != null) {
                return new DueEmiLayoutBinding(relativeLayout, relativeLayout, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
