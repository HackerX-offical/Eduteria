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
public final class OptionAdapterBinding implements ViewBinding {
    public final ProgressBar activeProgress;
    public final RelativeLayout layoutOption;
    public final ImageView myAns;
    public final ImageView optionA;
    public final RelativeLayout optionPercentage;
    public final TextView optionTxt;
    public final TextView percentageTxt;
    private final RelativeLayout rootView;

    private OptionAdapterBinding(RelativeLayout rootView, ProgressBar activeProgress, RelativeLayout layoutOption, ImageView myAns, ImageView optionA, RelativeLayout optionPercentage, TextView optionTxt, TextView percentageTxt) {
        this.rootView = rootView;
        this.activeProgress = activeProgress;
        this.layoutOption = layoutOption;
        this.myAns = myAns;
        this.optionA = optionA;
        this.optionPercentage = optionPercentage;
        this.optionTxt = optionTxt;
        this.percentageTxt = percentageTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OptionAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static OptionAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.option_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OptionAdapterBinding bind(View rootView) {
        int i = R.id.activeProgress;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.activeProgress);
        if (progressBar != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.my_ans;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.my_ans);
            if (imageView != null) {
                i = R.id.option_a;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.option_a);
                if (imageView2 != null) {
                    i = R.id.option_percentage;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.option_percentage);
                    if (relativeLayout2 != null) {
                        i = R.id.option_txt;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.option_txt);
                        if (textView != null) {
                            i = R.id.percentage_txt;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.percentage_txt);
                            if (textView2 != null) {
                                return new OptionAdapterBinding(relativeLayout, progressBar, relativeLayout, imageView, imageView2, relativeLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
