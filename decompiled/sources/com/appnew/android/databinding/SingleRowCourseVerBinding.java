package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowCourseVerBinding implements ViewBinding {
    public final ImageView imageIV;
    public final TextView learnerTV;
    public final TextView nameTV;
    public final LinearLayout parentLL;
    public final TextView priceTV;
    public final RatingBar ratingRB;
    public final TextView ratingTV;
    private final LinearLayout rootView;

    private SingleRowCourseVerBinding(LinearLayout rootView, ImageView imageIV, TextView learnerTV, TextView nameTV, LinearLayout parentLL, TextView priceTV, RatingBar ratingRB, TextView ratingTV) {
        this.rootView = rootView;
        this.imageIV = imageIV;
        this.learnerTV = learnerTV;
        this.nameTV = nameTV;
        this.parentLL = parentLL;
        this.priceTV = priceTV;
        this.ratingRB = ratingRB;
        this.ratingTV = ratingTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowCourseVerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowCourseVerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_course_ver, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowCourseVerBinding bind(View rootView) {
        int i = R.id.imageIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
        if (imageView != null) {
            i = R.id.learnerTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.learnerTV);
            if (textView != null) {
                i = R.id.nameTV;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.priceTV;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                    if (textView3 != null) {
                        i = R.id.ratingRB;
                        RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.ratingRB);
                        if (ratingBar != null) {
                            i = R.id.ratingTV;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ratingTV);
                            if (textView4 != null) {
                                return new SingleRowCourseVerBinding(linearLayout, imageView, textView, textView2, linearLayout, textView3, ratingBar, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
