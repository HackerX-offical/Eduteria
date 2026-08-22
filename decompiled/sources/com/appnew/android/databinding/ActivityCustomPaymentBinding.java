package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCustomPaymentBinding implements ViewBinding {
    public final EditText amt;
    public final Button buttonProceed;
    public final ConstraintLayout constraintLayout;
    public final TextView courseTxt;
    public final Guideline guideline2;
    public final ImageView imageBack;
    public final TextView imageView2;
    public final Toolbar mainToolbar;
    public final EditText remark;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final TextView textView2;
    public final TextView textView3;
    public final TextView toolbarTitleTV;

    private ActivityCustomPaymentBinding(ConstraintLayout rootView, EditText amt, Button buttonProceed, ConstraintLayout constraintLayout, TextView courseTxt, Guideline guideline2, ImageView imageBack, TextView imageView2, Toolbar mainToolbar, EditText remark, TextView textView, TextView textView2, TextView textView3, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.amt = amt;
        this.buttonProceed = buttonProceed;
        this.constraintLayout = constraintLayout;
        this.courseTxt = courseTxt;
        this.guideline2 = guideline2;
        this.imageBack = imageBack;
        this.imageView2 = imageView2;
        this.mainToolbar = mainToolbar;
        this.remark = remark;
        this.textView = textView;
        this.textView2 = textView2;
        this.textView3 = textView3;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCustomPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCustomPaymentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_custom_payment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCustomPaymentBinding bind(View rootView) {
        int i = R.id.amt;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.amt);
        if (editText != null) {
            i = R.id.buttonProceed;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
            if (button != null) {
                i = R.id.constraintLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.constraintLayout);
                if (constraintLayout != null) {
                    i = R.id.courseTxt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTxt);
                    if (textView != null) {
                        i = R.id.guideline2;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, R.id.guideline2);
                        if (guideline != null) {
                            i = R.id.image_back;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                            if (imageView != null) {
                                i = R.id.imageView2;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.imageView2);
                                if (textView2 != null) {
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.remark;
                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.remark);
                                        if (editText2 != null) {
                                            i = R.id.textView;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView);
                                            if (textView3 != null) {
                                                i = R.id.textView2;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView2);
                                                if (textView4 != null) {
                                                    i = R.id.textView3;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textView3);
                                                    if (textView5 != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView6 != null) {
                                                            return new ActivityCustomPaymentBinding((ConstraintLayout) rootView, editText, button, constraintLayout, textView, guideline, imageView, textView2, toolbar, editText2, textView3, textView4, textView5, textView6);
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
