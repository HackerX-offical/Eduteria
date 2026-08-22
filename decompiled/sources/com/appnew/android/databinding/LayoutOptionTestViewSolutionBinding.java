package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutOptionTestViewSolutionBinding implements ViewBinding {
    public final TextView optionIconTV;
    public final MathView optionTextTV;
    public final RadioButton radioRB;
    private final LinearLayout rootView;
    public final LinearLayout viewLL;

    private LayoutOptionTestViewSolutionBinding(LinearLayout rootView, TextView optionIconTV, MathView optionTextTV, RadioButton radioRB, LinearLayout viewLL) {
        this.rootView = rootView;
        this.optionIconTV = optionIconTV;
        this.optionTextTV = optionTextTV;
        this.radioRB = radioRB;
        this.viewLL = viewLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutOptionTestViewSolutionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutOptionTestViewSolutionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_option_test_view_solution, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutOptionTestViewSolutionBinding bind(View rootView) {
        int i = R.id.optionIconTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionIconTV);
        if (textView != null) {
            i = R.id.optionTextTV;
            MathView mathView = (MathView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV);
            if (mathView != null) {
                i = R.id.radioRB;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.radioRB);
                if (radioButton != null) {
                    i = R.id.viewLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewLL);
                    if (linearLayout != null) {
                        return new LayoutOptionTestViewSolutionBinding((LinearLayout) rootView, textView, mathView, radioButton, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
