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
public final class ActivitySignInSBinding implements ViewBinding {
    public final LinearLayout activitySignIn;
    public final View etEmail;
    public final View etPassword;
    public final View forgetpasswordTV;
    public final Button loginBtn;
    private final LinearLayout rootView;
    public final View signInTextView;
    public final LinearLayout signInUpLayout;
    public final LinearLayout signLL;
    public final View signUpTextView;

    private ActivitySignInSBinding(LinearLayout rootView, LinearLayout activitySignIn, View etEmail, View etPassword, View forgetpasswordTV, Button loginBtn, View signInTextView, LinearLayout signInUpLayout, LinearLayout signLL, View signUpTextView) {
        this.rootView = rootView;
        this.activitySignIn = activitySignIn;
        this.etEmail = etEmail;
        this.etPassword = etPassword;
        this.forgetpasswordTV = forgetpasswordTV;
        this.loginBtn = loginBtn;
        this.signInTextView = signInTextView;
        this.signInUpLayout = signInUpLayout;
        this.signLL = signLL;
        this.signUpTextView = signUpTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySignInSBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySignInSBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_sign_in_s, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySignInSBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.et_email;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.et_email);
        if (viewFindChildViewById != null) {
            i = R.id.et_password;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.et_password);
            if (viewFindChildViewById2 != null) {
                i = R.id.forgetpasswordTV;
                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.forgetpasswordTV);
                if (viewFindChildViewById3 != null) {
                    i = R.id.loginBtn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                    if (button != null) {
                        i = R.id.signInTextView;
                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.signInTextView);
                        if (viewFindChildViewById4 != null) {
                            i = R.id.signInUpLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.signInUpLayout);
                            if (linearLayout2 != null) {
                                i = R.id.signLL;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.signLL);
                                if (linearLayout3 != null) {
                                    i = R.id.signUpTextView;
                                    View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.signUpTextView);
                                    if (viewFindChildViewById5 != null) {
                                        return new ActivitySignInSBinding(linearLayout, linearLayout, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, button, viewFindChildViewById4, linearLayout2, linearLayout3, viewFindChildViewById5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
