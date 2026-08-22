package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Courses.Fragment.TestSeriesOptionWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class McqQuizBinding implements ViewBinding {
    public final ImageView correctIV;
    public final LinearLayout correctLL;
    public final LinearLayout mcqlayoutLL;
    public final TextView optionIconTV;
    public final TestSeriesOptionWebView optionTextTV;
    private final LinearLayout rootView;

    private McqQuizBinding(LinearLayout rootView, ImageView correctIV, LinearLayout correctLL, LinearLayout mcqlayoutLL, TextView optionIconTV, TestSeriesOptionWebView optionTextTV) {
        this.rootView = rootView;
        this.correctIV = correctIV;
        this.correctLL = correctLL;
        this.mcqlayoutLL = mcqlayoutLL;
        this.optionIconTV = optionIconTV;
        this.optionTextTV = optionTextTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static McqQuizBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static McqQuizBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.mcq_quiz, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static McqQuizBinding bind(View rootView) {
        int i = R.id.correctIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.correctIV);
        if (imageView != null) {
            i = R.id.correctLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.correctLL);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) rootView;
                i = R.id.optionIconTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionIconTV);
                if (textView != null) {
                    i = R.id.optionTextTV;
                    TestSeriesOptionWebView testSeriesOptionWebView = (TestSeriesOptionWebView) ViewBindings.findChildViewById(rootView, R.id.optionTextTV);
                    if (testSeriesOptionWebView != null) {
                        return new McqQuizBinding(linearLayout2, imageView, linearLayout, linearLayout2, textView, testSeriesOptionWebView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
