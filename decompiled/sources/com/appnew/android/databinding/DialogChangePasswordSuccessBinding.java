package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogChangePasswordSuccessBinding implements ViewBinding {
    public final Button btnSubmit;
    public final ImageView changeDialogIV;
    public final TextView passwordResetTV;
    private final CardView rootView;
    public final TextView signInWithNewTV;

    private DialogChangePasswordSuccessBinding(CardView rootView, Button btnSubmit, ImageView changeDialogIV, TextView passwordResetTV, TextView signInWithNewTV) {
        this.rootView = rootView;
        this.btnSubmit = btnSubmit;
        this.changeDialogIV = changeDialogIV;
        this.passwordResetTV = passwordResetTV;
        this.signInWithNewTV = signInWithNewTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static DialogChangePasswordSuccessBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogChangePasswordSuccessBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_change_password_success, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogChangePasswordSuccessBinding bind(View rootView) {
        int i = R.id.btnSubmit;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnSubmit);
        if (button != null) {
            i = R.id.changeDialogIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.changeDialogIV);
            if (imageView != null) {
                i = R.id.passwordResetTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.passwordResetTV);
                if (textView != null) {
                    i = R.id.signInWithNewTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.signInWithNewTV);
                    if (textView2 != null) {
                        return new DialogChangePasswordSuccessBinding((CardView) rootView, button, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
