package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTestReportsBinding implements ViewBinding {
    private final HorizontalScrollView rootView;
    public final TextView subjectAvgMarks1;
    public final TextView subjectMarks1;
    public final TextView subjectMaxMarks1;
    public final TextView subjectPercentile1;
    public final TextView subjectRank1;
    public final TextView subjectTitle;
    public final TextView testDate;
    public final TextView testSubject;

    private ActivityTestReportsBinding(HorizontalScrollView rootView, TextView subjectAvgMarks1, TextView subjectMarks1, TextView subjectMaxMarks1, TextView subjectPercentile1, TextView subjectRank1, TextView subjectTitle, TextView testDate, TextView testSubject) {
        this.rootView = rootView;
        this.subjectAvgMarks1 = subjectAvgMarks1;
        this.subjectMarks1 = subjectMarks1;
        this.subjectMaxMarks1 = subjectMaxMarks1;
        this.subjectPercentile1 = subjectPercentile1;
        this.subjectRank1 = subjectRank1;
        this.subjectTitle = subjectTitle;
        this.testDate = testDate;
        this.testSubject = testSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public HorizontalScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityTestReportsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestReportsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_test_reports, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestReportsBinding bind(View rootView) {
        int i = R.id.subjectAvgMarks1;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectAvgMarks1);
        if (textView != null) {
            i = R.id.subjectMarks1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectMarks1);
            if (textView2 != null) {
                i = R.id.subjectMaxMarks1;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectMaxMarks1);
                if (textView3 != null) {
                    i = R.id.subjectPercentile1;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectPercentile1);
                    if (textView4 != null) {
                        i = R.id.subjectRank1;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectRank1);
                        if (textView5 != null) {
                            i = R.id.subjectTitle;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectTitle);
                            if (textView6 != null) {
                                i = R.id.testDate;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testDate);
                                if (textView7 != null) {
                                    i = R.id.testSubject;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testSubject);
                                    if (textView8 != null) {
                                        return new ActivityTestReportsBinding((HorizontalScrollView) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                    }
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
