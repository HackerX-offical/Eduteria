package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentChangepasswordBinding implements ViewBinding {
    public final ImageView image;
    public final ImageView ivBack;
    public final LinearLayout ll1;
    public final EditText newpasswordET;
    public final EditText retrypasswordET;
    private final NestedScrollView rootView;
    public final Button submitBtn;
    public final TextView title;

    private FragmentChangepasswordBinding(NestedScrollView rootView, ImageView image, ImageView ivBack, LinearLayout ll1, EditText newpasswordET, EditText retrypasswordET, Button submitBtn, TextView title) {
        this.rootView = rootView;
        this.image = image;
        this.ivBack = ivBack;
        this.ll1 = ll1;
        this.newpasswordET = newpasswordET;
        this.retrypasswordET = retrypasswordET;
        this.submitBtn = submitBtn;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentChangepasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentChangepasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_changepassword, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentChangepasswordBinding bind(View rootView) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
        if (imageView != null) {
            i = R.id.iv_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
            if (imageView2 != null) {
                i = R.id.ll1;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll1);
                if (linearLayout != null) {
                    i = R.id.newpasswordET;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.newpasswordET);
                    if (editText != null) {
                        i = R.id.retrypasswordET;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.retrypasswordET);
                        if (editText2 != null) {
                            i = R.id.submitBtn;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitBtn);
                            if (button != null) {
                                i = R.id.title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                if (textView != null) {
                                    return new FragmentChangepasswordBinding((NestedScrollView) rootView, imageView, imageView2, linearLayout, editText, editText2, button, textView);
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
