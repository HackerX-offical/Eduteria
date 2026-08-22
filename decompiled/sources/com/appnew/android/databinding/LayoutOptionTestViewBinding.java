package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutOptionTestViewBinding implements ViewBinding {
    public final ImageView imgOption;
    public final TextView optionIconTV;
    public final MathView optionTextTV;
    public final TextView optionTextTV2;
    public final RadioButton radioRB;
    private final LinearLayout rootView;
    public final LinearLayout viewLL;

    private LayoutOptionTestViewBinding(LinearLayout rootView, ImageView imgOption, TextView optionIconTV, MathView optionTextTV, TextView optionTextTV2, RadioButton radioRB, LinearLayout viewLL) {
        this.rootView = rootView;
        this.imgOption = imgOption;
        this.optionIconTV = optionIconTV;
        this.optionTextTV = optionTextTV;
        this.optionTextTV2 = optionTextTV2;
        this.radioRB = radioRB;
        this.viewLL = viewLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutOptionTestViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutOptionTestViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_option_test_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutOptionTestViewBinding bind(View rootView) {
        int i = R.id.imgOption;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imgOption);
        if (imageView != null) {
            i = R.id.optionIconTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionIconTV);
            if (textView != null) {
                i = R.id.optionTextTV;
                MathView mathView = (MathView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV);
                if (mathView != null) {
                    i = R.id.optionTextTV2;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV2);
                    if (textView2 != null) {
                        i = R.id.radioRB;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.radioRB);
                        if (radioButton != null) {
                            i = R.id.viewLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewLL);
                            if (linearLayout != null) {
                                return new LayoutOptionTestViewBinding((LinearLayout) rootView, imageView, textView, mathView, textView2, radioButton, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
