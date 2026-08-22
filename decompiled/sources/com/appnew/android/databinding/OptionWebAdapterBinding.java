package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class OptionWebAdapterBinding implements ViewBinding {
    public final ProgressBar activeProgress;
    public final RelativeLayout layoutOption;
    public final ImageView optionA;
    public final MathView optionTextTV;
    public final TextView optionTextTV2;
    public final RelativeLayout questionLayout;
    private final RelativeLayout rootView;

    private OptionWebAdapterBinding(RelativeLayout rootView, ProgressBar activeProgress, RelativeLayout layoutOption, ImageView optionA, MathView optionTextTV, TextView optionTextTV2, RelativeLayout questionLayout) {
        this.rootView = rootView;
        this.activeProgress = activeProgress;
        this.layoutOption = layoutOption;
        this.optionA = optionA;
        this.optionTextTV = optionTextTV;
        this.optionTextTV2 = optionTextTV2;
        this.questionLayout = questionLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OptionWebAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static OptionWebAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.option_web_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OptionWebAdapterBinding bind(View rootView) {
        int i = R.id.activeProgress;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.activeProgress);
        if (progressBar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.option_a;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.option_a);
            if (imageView != null) {
                i = R.id.optionTextTV;
                MathView mathView = (MathView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV);
                if (mathView != null) {
                    i = R.id.optionTextTV2;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV2);
                    if (textView != null) {
                        i = R.id.question_layout;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_layout);
                        if (relativeLayout2 != null) {
                            return new OptionWebAdapterBinding(relativeLayout, progressBar, relativeLayout, imageView, mathView, textView, relativeLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
