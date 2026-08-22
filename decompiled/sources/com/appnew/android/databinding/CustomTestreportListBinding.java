package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomTestreportListBinding implements ViewBinding {
    public final TextView attempt;
    private final LinearLayout rootView;
    public final TextView testReportEndTime;
    public final TextView testReportStartTime;
    public final TextView testReportTitle;
    public final TextView viewResult;

    private CustomTestreportListBinding(LinearLayout rootView, TextView attempt, TextView testReportEndTime, TextView testReportStartTime, TextView testReportTitle, TextView viewResult) {
        this.rootView = rootView;
        this.attempt = attempt;
        this.testReportEndTime = testReportEndTime;
        this.testReportStartTime = testReportStartTime;
        this.testReportTitle = testReportTitle;
        this.viewResult = viewResult;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomTestreportListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomTestreportListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_testreport_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomTestreportListBinding bind(View rootView) {
        int i = R.id.attempt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.attempt);
        if (textView != null) {
            i = R.id.testReport_endTime;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testReport_endTime);
            if (textView2 != null) {
                i = R.id.testReport_startTime;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testReport_startTime);
                if (textView3 != null) {
                    i = R.id.testReport_title;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testReport_title);
                    if (textView4 != null) {
                        i = R.id.view_result;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view_result);
                        if (textView5 != null) {
                            return new CustomTestreportListBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
