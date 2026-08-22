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
public final class SelectOkDialogBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final Button tvOk;
    public final TextView tvTitle;

    private SelectOkDialogBinding(RelativeLayout rootView, Button tvOk, TextView tvTitle) {
        this.rootView = rootView;
        this.tvOk = tvOk;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SelectOkDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectOkDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.select_ok_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SelectOkDialogBinding bind(View rootView) {
        int i = R.id.tv_ok;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.tv_ok);
        if (button != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_title);
            if (textView != null) {
                return new SelectOkDialogBinding((RelativeLayout) rootView, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
