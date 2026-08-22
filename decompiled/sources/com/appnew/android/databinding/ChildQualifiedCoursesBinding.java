package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChildQualifiedCoursesBinding implements ViewBinding {
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView tvCourseTitle;
    public final TextView tvDiscountMessage;
    public final TextView tvEnrollNow;
    public final View viewid;

    private ChildQualifiedCoursesBinding(RelativeLayout rootView, RelativeLayout rlMain, TextView tvCourseTitle, TextView tvDiscountMessage, TextView tvEnrollNow, View viewid) {
        this.rootView = rootView;
        this.rlMain = rlMain;
        this.tvCourseTitle = tvCourseTitle;
        this.tvDiscountMessage = tvDiscountMessage;
        this.tvEnrollNow = tvEnrollNow;
        this.viewid = viewid;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChildQualifiedCoursesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChildQualifiedCoursesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.child_qualified_courses, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChildQualifiedCoursesBinding bind(View rootView) {
        int i = R.id.rl_main;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
        if (relativeLayout != null) {
            i = R.id.tv_course_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_course_title);
            if (textView != null) {
                i = R.id.tv_discount_message;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_discount_message);
                if (textView2 != null) {
                    i = R.id.tv_enroll_now;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_enroll_now);
                    if (textView3 != null) {
                        i = R.id.viewid;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewid);
                        if (viewFindChildViewById != null) {
                            return new ChildQualifiedCoursesBinding((RelativeLayout) rootView, relativeLayout, textView, textView2, textView3, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
