package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityInitializeSdkBinding implements ViewBinding {
    public final TextView joinButton;
    public final Button loginButton;
    private final ConstraintLayout rootView;

    private ActivityInitializeSdkBinding(ConstraintLayout rootView, TextView joinButton, Button loginButton) {
        this.rootView = rootView;
        this.joinButton = joinButton;
        this.loginButton = loginButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInitializeSdkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityInitializeSdkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_initialize_sdk, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInitializeSdkBinding bind(View rootView) {
        int i = R.id.join_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.join_button);
        if (textView != null) {
            i = R.id.login_button;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.login_button);
            if (button != null) {
                return new ActivityInitializeSdkBinding((ConstraintLayout) rootView, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
