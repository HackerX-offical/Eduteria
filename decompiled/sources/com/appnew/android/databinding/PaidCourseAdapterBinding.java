package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class PaidCourseAdapterBinding implements ViewBinding {
    public final TextView alertText;
    public final ImageView arrowForward;
    public final TextView courseName;
    public final RelativeLayout courseValidty;
    public final ImageView delete;
    public final TextView extendValidy;
    public final RoundedImageView ibtSingleVdIv;
    public final ImageView liveIV;
    public final RelativeLayout mycourseLayout;
    public final RelativeLayout parentLayout;
    public final RelativeLayout progessLayout;
    public final TextView progreesValueTexta;
    public final ProgressBar progressValue;
    public final TextView remaingDays;
    private final RelativeLayout rootView;
    public final TextView totalDays;
    public final FrameLayout videoplayerRL;

    private PaidCourseAdapterBinding(RelativeLayout rootView, TextView alertText, ImageView arrowForward, TextView courseName, RelativeLayout courseValidty, ImageView delete, TextView extendValidy, RoundedImageView ibtSingleVdIv, ImageView liveIV, RelativeLayout mycourseLayout, RelativeLayout parentLayout, RelativeLayout progessLayout, TextView progreesValueTexta, ProgressBar progressValue, TextView remaingDays, TextView totalDays, FrameLayout videoplayerRL) {
        this.rootView = rootView;
        this.alertText = alertText;
        this.arrowForward = arrowForward;
        this.courseName = courseName;
        this.courseValidty = courseValidty;
        this.delete = delete;
        this.extendValidy = extendValidy;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.liveIV = liveIV;
        this.mycourseLayout = mycourseLayout;
        this.parentLayout = parentLayout;
        this.progessLayout = progessLayout;
        this.progreesValueTexta = progreesValueTexta;
        this.progressValue = progressValue;
        this.remaingDays = remaingDays;
        this.totalDays = totalDays;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PaidCourseAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PaidCourseAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.paid_course_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PaidCourseAdapterBinding bind(View rootView) {
        int i = R.id.alert_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.alert_text);
        if (textView != null) {
            i = R.id.arrow_forward;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow_forward);
            if (imageView != null) {
                i = R.id.course_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                if (textView2 != null) {
                    i = R.id.course__validty;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.course__validty);
                    if (relativeLayout != null) {
                        i = R.id.delete;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.delete);
                        if (imageView2 != null) {
                            i = R.id.extend_validy;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.extend_validy);
                            if (textView3 != null) {
                                i = R.id.ibt_single_vd_iv;
                                RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                                if (roundedImageView != null) {
                                    i = R.id.liveIV;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                    if (imageView3 != null) {
                                        RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                        i = R.id.parent_layout;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
                                        if (relativeLayout3 != null) {
                                            i = R.id.progess_layout;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.progess_layout);
                                            if (relativeLayout4 != null) {
                                                i = R.id.progrees_value_texta;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.progrees_value_texta);
                                                if (textView4 != null) {
                                                    i = R.id.progress_value;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_value);
                                                    if (progressBar != null) {
                                                        i = R.id.remaing_days;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remaing_days);
                                                        if (textView5 != null) {
                                                            i = R.id.total_days;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_days);
                                                            if (textView6 != null) {
                                                                i = R.id.videoplayerRL;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                                if (frameLayout != null) {
                                                                    return new PaidCourseAdapterBinding(relativeLayout2, textView, imageView, textView2, relativeLayout, imageView2, textView3, roundedImageView, imageView3, relativeLayout2, relativeLayout3, relativeLayout4, textView4, progressBar, textView5, textView6, frameLayout);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
