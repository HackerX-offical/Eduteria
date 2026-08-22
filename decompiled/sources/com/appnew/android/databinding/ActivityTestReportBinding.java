package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTestReportBinding implements ViewBinding {
    public final RecyclerView TestReportRecycler;
    public final Toolbar mainToolbar;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final ImageView testReportBack;
    public final TextView toolbarTitleTV;

    private ActivityTestReportBinding(LinearLayout rootView, RecyclerView TestReportRecycler, Toolbar mainToolbar, LinearLayout root, ImageView testReportBack, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.TestReportRecycler = TestReportRecycler;
        this.mainToolbar = mainToolbar;
        this.root = root;
        this.testReportBack = testReportBack;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestReportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestReportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_test_report, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestReportBinding bind(View rootView) {
        int i = R.id.TestReportRecycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.TestReportRecycler);
        if (recyclerView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                LinearLayout linearLayout = (LinearLayout) rootView;
                i = R.id.testReportBack;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.testReportBack);
                if (imageView != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new ActivityTestReportBinding(linearLayout, recyclerView, toolbar, linearLayout, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
