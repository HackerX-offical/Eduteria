package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityGraphBinding implements ViewBinding {
    public final HorizontalBarChart chart1;
    public final ImageView graphImageBack;
    public final Toolbar mainToolbar;
    private final LinearLayout rootView;
    public final SeekBar seekBar1;
    public final SeekBar seekBar2;
    public final TextView toolbarTitleTV;
    public final TextView topperCount;

    private ActivityGraphBinding(LinearLayout rootView, HorizontalBarChart chart1, ImageView graphImageBack, Toolbar mainToolbar, SeekBar seekBar1, SeekBar seekBar2, TextView toolbarTitleTV, TextView topperCount) {
        this.rootView = rootView;
        this.chart1 = chart1;
        this.graphImageBack = graphImageBack;
        this.mainToolbar = mainToolbar;
        this.seekBar1 = seekBar1;
        this.seekBar2 = seekBar2;
        this.toolbarTitleTV = toolbarTitleTV;
        this.topperCount = topperCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGraphBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityGraphBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_graph, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityGraphBinding bind(View rootView) {
        int i = R.id.chart1;
        HorizontalBarChart horizontalBarChart = (HorizontalBarChart) ViewBindings.findChildViewById(rootView, R.id.chart1);
        if (horizontalBarChart != null) {
            i = R.id.graph_image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.graph_image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.seekBar1;
                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, R.id.seekBar1);
                    if (seekBar != null) {
                        i = R.id.seekBar2;
                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(rootView, R.id.seekBar2);
                        if (seekBar2 != null) {
                            i = R.id.toolbarTitleTV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                            if (textView != null) {
                                i = R.id.topperCount;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topperCount);
                                if (textView2 != null) {
                                    return new ActivityGraphBinding((LinearLayout) rootView, horizontalBarChart, imageView, toolbar, seekBar, seekBar2, textView, textView2);
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
