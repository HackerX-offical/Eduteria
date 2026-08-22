package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomCourseReviewBinding implements ViewBinding {
    public final TextView courseComment;
    public final RatingBar courseRating;
    public final TextView courseReviewDate;
    public final TextView currentAffairTittle;
    private final RelativeLayout rootView;

    private CustomCourseReviewBinding(RelativeLayout rootView, TextView courseComment, RatingBar courseRating, TextView courseReviewDate, TextView currentAffairTittle) {
        this.rootView = rootView;
        this.courseComment = courseComment;
        this.courseRating = courseRating;
        this.courseReviewDate = courseReviewDate;
        this.currentAffairTittle = currentAffairTittle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomCourseReviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomCourseReviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_course_review, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomCourseReviewBinding bind(View rootView) {
        int i = R.id.courseComment;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseComment);
        if (textView != null) {
            i = R.id.courseRating;
            RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.courseRating);
            if (ratingBar != null) {
                i = R.id.courseReview_date;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseReview_date);
                if (textView2 != null) {
                    i = R.id.currentAffair_tittle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_tittle);
                    if (textView3 != null) {
                        return new CustomCourseReviewBinding((RelativeLayout) rootView, textView, ratingBar, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
