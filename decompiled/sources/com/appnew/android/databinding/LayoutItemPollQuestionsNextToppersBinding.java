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
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutItemPollQuestionsNextToppersBinding implements ViewBinding {
    public final RelativeLayout checkOption1;
    public final TextView option1;
    public final RelativeLayout option1Layout;
    public final TextView percentage1;
    public final ProgressBar progress1;
    public final ImageView radioButton1;
    private final RelativeLayout rootView;

    private LayoutItemPollQuestionsNextToppersBinding(RelativeLayout rootView, RelativeLayout checkOption1, TextView option1, RelativeLayout option1Layout, TextView percentage1, ProgressBar progress1, ImageView radioButton1) {
        this.rootView = rootView;
        this.checkOption1 = checkOption1;
        this.option1 = option1;
        this.option1Layout = option1Layout;
        this.percentage1 = percentage1;
        this.progress1 = progress1;
        this.radioButton1 = radioButton1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemPollQuestionsNextToppersBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemPollQuestionsNextToppersBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_item_poll_questions_next_toppers, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutItemPollQuestionsNextToppersBinding bind(View rootView) {
        int i = R.id.checkOption1;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.checkOption1);
        if (relativeLayout != null) {
            i = R.id.option1;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.option1);
            if (textView != null) {
                i = R.id.option1Layout;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.option1Layout);
                if (relativeLayout2 != null) {
                    i = R.id.percentage1;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.percentage1);
                    if (textView2 != null) {
                        i = R.id.progress1;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress1);
                        if (progressBar != null) {
                            i = R.id.radioButton1;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.radioButton1);
                            if (imageView != null) {
                                return new LayoutItemPollQuestionsNextToppersBinding((RelativeLayout) rootView, relativeLayout, textView, relativeLayout2, textView2, progressBar, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
