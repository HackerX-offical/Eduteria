package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class NewCourseAdapterBinding implements ViewBinding {
    public final TextView courseName;
    public final RoundedImageView courseThumbnail;
    public final TextView courseValidty;
    public final TextView mrpCutTV;
    public final RelativeLayout parentLayout;
    public final TextView priceTV;
    private final RelativeLayout rootView;

    private NewCourseAdapterBinding(RelativeLayout rootView, TextView courseName, RoundedImageView courseThumbnail, TextView courseValidty, TextView mrpCutTV, RelativeLayout parentLayout, TextView priceTV) {
        this.rootView = rootView;
        this.courseName = courseName;
        this.courseThumbnail = courseThumbnail;
        this.courseValidty = courseValidty;
        this.mrpCutTV = mrpCutTV;
        this.parentLayout = parentLayout;
        this.priceTV = priceTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NewCourseAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewCourseAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.new_course_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NewCourseAdapterBinding bind(View rootView) {
        int i = R.id.course_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
        if (textView != null) {
            i = R.id.course_thumbnail;
            RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.course_thumbnail);
            if (roundedImageView != null) {
                i = R.id.course_validty;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_validty);
                if (textView2 != null) {
                    i = R.id.mrpCutTV;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                    if (textView3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                        i = R.id.priceTV;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                        if (textView4 != null) {
                            return new NewCourseAdapterBinding(relativeLayout, textView, roundedImageView, textView2, textView3, relativeLayout, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
