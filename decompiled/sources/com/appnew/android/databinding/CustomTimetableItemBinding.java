package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomTimetableItemBinding implements ViewBinding {
    public final TextView batchCancel;
    public final RelativeLayout cancelRl;
    public final LinearLayout centerDetailLL;
    public final TextView centerName;
    public final TextView courseName;
    public final View courseTimeTableview;
    public final LinearLayout itemLL;
    public final LinearLayout linearLayout3;
    private final RelativeLayout rootView;
    public final TextView timeTableDate;
    public final TextView timeTableTeacherCode;
    public final TextView timeTableTitle;
    public final ImageView viewCenterDetails;

    private CustomTimetableItemBinding(RelativeLayout rootView, TextView batchCancel, RelativeLayout cancelRl, LinearLayout centerDetailLL, TextView centerName, TextView courseName, View courseTimeTableview, LinearLayout itemLL, LinearLayout linearLayout3, TextView timeTableDate, TextView timeTableTeacherCode, TextView timeTableTitle, ImageView viewCenterDetails) {
        this.rootView = rootView;
        this.batchCancel = batchCancel;
        this.cancelRl = cancelRl;
        this.centerDetailLL = centerDetailLL;
        this.centerName = centerName;
        this.courseName = courseName;
        this.courseTimeTableview = courseTimeTableview;
        this.itemLL = itemLL;
        this.linearLayout3 = linearLayout3;
        this.timeTableDate = timeTableDate;
        this.timeTableTeacherCode = timeTableTeacherCode;
        this.timeTableTitle = timeTableTitle;
        this.viewCenterDetails = viewCenterDetails;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomTimetableItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomTimetableItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_timetable_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomTimetableItemBinding bind(View rootView) {
        int i = R.id.batchCancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.batchCancel);
        if (textView != null) {
            i = R.id.cancelRl;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cancelRl);
            if (relativeLayout != null) {
                i = R.id.centerDetailLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.centerDetailLL);
                if (linearLayout != null) {
                    i = R.id.centerName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.centerName);
                    if (textView2 != null) {
                        i = R.id.courseName;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseName);
                        if (textView3 != null) {
                            i = R.id.courseTimeTableview;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.courseTimeTableview);
                            if (viewFindChildViewById != null) {
                                i = R.id.itemLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.itemLL);
                                if (linearLayout2 != null) {
                                    i = R.id.linearLayout3;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout3);
                                    if (linearLayout3 != null) {
                                        i = R.id.timeTableDate;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeTableDate);
                                        if (textView4 != null) {
                                            i = R.id.timeTableTeacherCode;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeTableTeacherCode);
                                            if (textView5 != null) {
                                                i = R.id.timeTableTitle;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeTableTitle);
                                                if (textView6 != null) {
                                                    i = R.id.viewCenterDetails;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.viewCenterDetails);
                                                    if (imageView != null) {
                                                        return new CustomTimetableItemBinding((RelativeLayout) rootView, textView, relativeLayout, linearLayout, textView2, textView3, viewFindChildViewById, linearLayout2, linearLayout3, textView4, textView5, textView6, imageView);
                                                    }
                                                }
                                            }
                                        }
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
