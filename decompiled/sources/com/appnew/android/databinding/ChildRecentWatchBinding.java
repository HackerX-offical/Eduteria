package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChildRecentWatchBinding implements ViewBinding {
    public final ImageView imgThumb;
    private final LinearLayout rootView;
    public final ProgressBar simpleProgressBar;
    public final TextView tvCourse;
    public final TextView tvSubject;

    private ChildRecentWatchBinding(LinearLayout rootView, ImageView imgThumb, ProgressBar simpleProgressBar, TextView tvCourse, TextView tvSubject) {
        this.rootView = rootView;
        this.imgThumb = imgThumb;
        this.simpleProgressBar = simpleProgressBar;
        this.tvCourse = tvCourse;
        this.tvSubject = tvSubject;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ChildRecentWatchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChildRecentWatchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.child_recent_watch, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChildRecentWatchBinding bind(View rootView) {
        int i = R.id.img_thumb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_thumb);
        if (imageView != null) {
            i = R.id.simple_ProgressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.simple_ProgressBar);
            if (progressBar != null) {
                i = R.id.tv_course;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_course);
                if (textView != null) {
                    i = R.id.tv_subject;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_subject);
                    if (textView2 != null) {
                        return new ChildRecentWatchBinding((LinearLayout) rootView, imageView, progressBar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
