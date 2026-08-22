package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutErrorMessageBinding implements ViewBinding {
    public final LinearLayout errorLL;
    private final LinearLayout rootView;
    public final Button tryAgainBtn;

    private LayoutErrorMessageBinding(LinearLayout rootView, LinearLayout errorLL, Button tryAgainBtn) {
        this.rootView = rootView;
        this.errorLL = errorLL;
        this.tryAgainBtn = tryAgainBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutErrorMessageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutErrorMessageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_error_message, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutErrorMessageBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.tryAgainBtn);
        if (button != null) {
            return new LayoutErrorMessageBinding(linearLayout, linearLayout, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tryAgainBtn)));
    }
}
