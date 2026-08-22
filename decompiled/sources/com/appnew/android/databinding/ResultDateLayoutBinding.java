package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ResultDateLayoutBinding implements ViewBinding {
    public final Button btnSubmit;
    public final TextView message;
    private final LinearLayout rootView;

    private ResultDateLayoutBinding(LinearLayout rootView, Button btnSubmit, TextView message) {
        this.rootView = rootView;
        this.btnSubmit = btnSubmit;
        this.message = message;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ResultDateLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ResultDateLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.result_date_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ResultDateLayoutBinding bind(View rootView) {
        int i = R.id.btn_submit;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
        if (button != null) {
            i = R.id.message;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.message);
            if (textView != null) {
                return new ResultDateLayoutBinding((LinearLayout) rootView, button, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
