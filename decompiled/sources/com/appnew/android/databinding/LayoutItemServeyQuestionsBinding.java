package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutItemServeyQuestionsBinding implements ViewBinding {
    public final LinearLayoutCompat cvrOption;
    public final LinearLayoutCompat cvrOption1;
    public final TextView options;
    public final TextView percenttile;
    public final ProgressBar progresscolor;
    private final RelativeLayout rootView;
    public final TextView txtOptionNumber;

    private LayoutItemServeyQuestionsBinding(RelativeLayout rootView, LinearLayoutCompat cvrOption, LinearLayoutCompat cvrOption1, TextView options, TextView percenttile, ProgressBar progresscolor, TextView txtOptionNumber) {
        this.rootView = rootView;
        this.cvrOption = cvrOption;
        this.cvrOption1 = cvrOption1;
        this.options = options;
        this.percenttile = percenttile;
        this.progresscolor = progresscolor;
        this.txtOptionNumber = txtOptionNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemServeyQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemServeyQuestionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_item_servey_questions, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutItemServeyQuestionsBinding bind(View rootView) {
        int i = R.id.cvrOption;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrOption);
        if (linearLayoutCompat != null) {
            i = R.id.cvrOption1;
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrOption1);
            if (linearLayoutCompat2 != null) {
                i = R.id.options;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.options);
                if (textView != null) {
                    i = R.id.percenttile;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.percenttile);
                    if (textView2 != null) {
                        i = R.id.progresscolor;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progresscolor);
                        if (progressBar != null) {
                            i = R.id.txtOptionNumber;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOptionNumber);
                            if (textView3 != null) {
                                return new LayoutItemServeyQuestionsBinding((RelativeLayout) rootView, linearLayoutCompat, linearLayoutCompat2, textView, textView2, progressBar, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
