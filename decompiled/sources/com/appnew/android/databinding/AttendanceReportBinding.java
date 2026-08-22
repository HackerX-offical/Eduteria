package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AttendanceReportBinding implements ViewBinding {
    public final TextView attendanceDate;
    public final TextView attendanceInTime;
    public final TextView attendanceStatus;
    public final LinearLayout main;
    public final LinearLayout relativeLayout3;
    private final RelativeLayout rootView;

    private AttendanceReportBinding(RelativeLayout rootView, TextView attendanceDate, TextView attendanceInTime, TextView attendanceStatus, LinearLayout main, LinearLayout relativeLayout3) {
        this.rootView = rootView;
        this.attendanceDate = attendanceDate;
        this.attendanceInTime = attendanceInTime;
        this.attendanceStatus = attendanceStatus;
        this.main = main;
        this.relativeLayout3 = relativeLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AttendanceReportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AttendanceReportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.attendance_report, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AttendanceReportBinding bind(View rootView) {
        int i = R.id.attendanceDate;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.attendanceDate);
        if (textView != null) {
            i = R.id.attendanceInTime;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.attendanceInTime);
            if (textView2 != null) {
                i = R.id.attendanceStatus;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.attendanceStatus);
                if (textView3 != null) {
                    i = R.id.main;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.main);
                    if (linearLayout != null) {
                        i = R.id.relativeLayout3;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout3);
                        if (linearLayout2 != null) {
                            return new AttendanceReportBinding((RelativeLayout) rootView, textView, textView2, textView3, linearLayout, linearLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
