package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepHeaderTheme8Binding implements ViewBinding {
    public final ProgressBar circularProgressbar;
    public final TextView courseDetailText;
    public final CircleImageView courseImageIcon;
    public final LinearLayout coursePanelLL;
    public final TextView courseValue;
    public final TextView discountText;
    public final TextView duration;
    public final RelativeLayout durationLayout;
    public final TextView durationValue;
    public final TextView faculty;
    public final RelativeLayout facultyLayout;
    public final TextView facultyName;
    public final TextView ibtSingleVdTvDay;
    public final ImageView img1;
    public final ImageView img2;
    public final ImageView img3;
    public final RelativeLayout parentLayout;
    public final FrameLayout progessLayout;
    private final RelativeLayout rootView;
    public final TextView stream;
    public final RelativeLayout streamLayout;
    public final RelativeLayout streamLayoutParent;
    public final TextView streamName;
    public final TextView testCount;
    public final LinearLayout upperPanelLL;
    public final TextView upperTitle;
    public final TextView videosCount;

    private ExamPrepHeaderTheme8Binding(RelativeLayout rootView, ProgressBar circularProgressbar, TextView courseDetailText, CircleImageView courseImageIcon, LinearLayout coursePanelLL, TextView courseValue, TextView discountText, TextView duration, RelativeLayout durationLayout, TextView durationValue, TextView faculty, RelativeLayout facultyLayout, TextView facultyName, TextView ibtSingleVdTvDay, ImageView img1, ImageView img2, ImageView img3, RelativeLayout parentLayout, FrameLayout progessLayout, TextView stream, RelativeLayout streamLayout, RelativeLayout streamLayoutParent, TextView streamName, TextView testCount, LinearLayout upperPanelLL, TextView upperTitle, TextView videosCount) {
        this.rootView = rootView;
        this.circularProgressbar = circularProgressbar;
        this.courseDetailText = courseDetailText;
        this.courseImageIcon = courseImageIcon;
        this.coursePanelLL = coursePanelLL;
        this.courseValue = courseValue;
        this.discountText = discountText;
        this.duration = duration;
        this.durationLayout = durationLayout;
        this.durationValue = durationValue;
        this.faculty = faculty;
        this.facultyLayout = facultyLayout;
        this.facultyName = facultyName;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.parentLayout = parentLayout;
        this.progessLayout = progessLayout;
        this.stream = stream;
        this.streamLayout = streamLayout;
        this.streamLayoutParent = streamLayoutParent;
        this.streamName = streamName;
        this.testCount = testCount;
        this.upperPanelLL = upperPanelLL;
        this.upperTitle = upperTitle;
        this.videosCount = videosCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepHeaderTheme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepHeaderTheme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_header_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepHeaderTheme8Binding bind(View rootView) {
        int i = R.id.circularProgressbar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.circularProgressbar);
        if (progressBar != null) {
            i = R.id.course_detail_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_detail_text);
            if (textView != null) {
                i = R.id.courseImageIcon;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.courseImageIcon);
                if (circleImageView != null) {
                    i = R.id.coursePanelLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.coursePanelLL);
                    if (linearLayout != null) {
                        i = R.id.course_value;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_value);
                        if (textView2 != null) {
                            i = R.id.discount_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.discount_text);
                            if (textView3 != null) {
                                i = R.id.duration;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration);
                                if (textView4 != null) {
                                    i = R.id.duration_layout;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.duration_layout);
                                    if (relativeLayout != null) {
                                        i = R.id.duration_value;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.duration_value);
                                        if (textView5 != null) {
                                            i = R.id.faculty;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.faculty);
                                            if (textView6 != null) {
                                                i = R.id.faculty_layout;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.faculty_layout);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.faculty_name;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.faculty_name);
                                                    if (textView7 != null) {
                                                        i = R.id.ibt_single_vd_tv_day;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                                                        if (textView8 != null) {
                                                            i = R.id.img1;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img1);
                                                            if (imageView != null) {
                                                                i = R.id.img2;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img2);
                                                                if (imageView2 != null) {
                                                                    i = R.id.img3;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img3);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.parent_layout;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
                                                                        if (relativeLayout3 != null) {
                                                                            i = R.id.progess_layout;
                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.progess_layout);
                                                                            if (frameLayout != null) {
                                                                                i = R.id.stream;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stream);
                                                                                if (textView9 != null) {
                                                                                    i = R.id.stream_layout;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.stream_layout);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i = R.id.stream_layout_parent;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.stream_layout_parent);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i = R.id.stream_name;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stream_name);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.testCount;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testCount);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.upperPanelLL;
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.upperPanelLL);
                                                                                                    if (linearLayout2 != null) {
                                                                                                        i = R.id.upperTitle;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upperTitle);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.videosCount;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.videosCount);
                                                                                                            if (textView13 != null) {
                                                                                                                return new ExamPrepHeaderTheme8Binding((RelativeLayout) rootView, progressBar, textView, circleImageView, linearLayout, textView2, textView3, textView4, relativeLayout, textView5, textView6, relativeLayout2, textView7, textView8, imageView, imageView2, imageView3, relativeLayout3, frameLayout, textView9, relativeLayout4, relativeLayout5, textView10, textView11, linearLayout2, textView12, textView13);
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
