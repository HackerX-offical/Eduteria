package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.LabeledEditText;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentChangepasswordNewBinding implements ViewBinding {
    public final ImageView loginLogo;
    public final LabeledEditText newpasswordET;
    public final LabeledEditText retrypasswordET;
    private final LinearLayout rootView;
    public final Button submitBtn;

    private FragmentChangepasswordNewBinding(LinearLayout rootView, ImageView loginLogo, LabeledEditText newpasswordET, LabeledEditText retrypasswordET, Button submitBtn) {
        this.rootView = rootView;
        this.loginLogo = loginLogo;
        this.newpasswordET = newpasswordET;
        this.retrypasswordET = retrypasswordET;
        this.submitBtn = submitBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentChangepasswordNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentChangepasswordNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_changepassword_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentChangepasswordNewBinding bind(View rootView) {
        int i = R.id.loginLogo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.loginLogo);
        if (imageView != null) {
            i = R.id.newpasswordET;
            LabeledEditText labeledEditText = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.newpasswordET);
            if (labeledEditText != null) {
                i = R.id.retrypasswordET;
                LabeledEditText labeledEditText2 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.retrypasswordET);
                if (labeledEditText2 != null) {
                    i = R.id.submitBtn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitBtn);
                    if (button != null) {
                        return new FragmentChangepasswordNewBinding((LinearLayout) rootView, imageView, labeledEditText, labeledEditText2, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
