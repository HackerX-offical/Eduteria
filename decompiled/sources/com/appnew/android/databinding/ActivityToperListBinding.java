package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.anychart.AnyChartView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityToperListBinding implements ViewBinding {
    public final AnyChartView anyChartView;
    public final ImageView graphImageBack;
    public final Toolbar mainToolbar;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityToperListBinding(LinearLayout rootView, AnyChartView anyChartView, ImageView graphImageBack, Toolbar mainToolbar, ProgressBar progressBar, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.anyChartView = anyChartView;
        this.graphImageBack = graphImageBack;
        this.mainToolbar = mainToolbar;
        this.progressBar = progressBar;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityToperListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityToperListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_toper_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityToperListBinding bind(View rootView) {
        int i = R.id.any_chart_view;
        AnyChartView anyChartView = (AnyChartView) ViewBindings.findChildViewById(rootView, R.id.any_chart_view);
        if (anyChartView != null) {
            i = R.id.graph_image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.graph_image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                    if (progressBar != null) {
                        i = R.id.toolbarTitleTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                        if (textView != null) {
                            return new ActivityToperListBinding((LinearLayout) rootView, anyChartView, imageView, toolbar, progressBar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
