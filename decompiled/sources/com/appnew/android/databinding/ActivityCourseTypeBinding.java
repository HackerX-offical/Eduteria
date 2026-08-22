package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCourseTypeBinding implements ViewBinding {
    public final CardView courseBanner;
    public final RelativeLayout courseBgLayout;
    public final TextView courseTitle;
    public final ClickableWebView courseTitleWeb;
    public final RecyclerView courseTypeRV;
    public final ImageView downarrowIV;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout rlTitleMain;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final TextView toolbarTitleTV;

    private ActivityCourseTypeBinding(RelativeLayout rootView_, CardView courseBanner, RelativeLayout courseBgLayout, TextView courseTitle, ClickableWebView courseTitleWeb, RecyclerView courseTypeRV, ImageView downarrowIV, ImageView imageBack, Toolbar mainToolbar, RelativeLayout rlTitleMain, RelativeLayout rootView, TextView toolbarTitleTV) {
        this.rootView_ = rootView_;
        this.courseBanner = courseBanner;
        this.courseBgLayout = courseBgLayout;
        this.courseTitle = courseTitle;
        this.courseTitleWeb = courseTitleWeb;
        this.courseTypeRV = courseTypeRV;
        this.downarrowIV = downarrowIV;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.rlTitleMain = rlTitleMain;
        this.rootView = rootView;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityCourseTypeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCourseTypeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_course_type, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCourseTypeBinding bind(View rootView) {
        int i = R.id.course_banner;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.course_banner);
        if (cardView != null) {
            i = R.id.course_bg_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.course_bg_layout);
            if (relativeLayout != null) {
                i = R.id.courseTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseTitle);
                if (textView != null) {
                    i = R.id.courseTitleWeb;
                    ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.courseTitleWeb);
                    if (clickableWebView != null) {
                        i = R.id.courseTypeRV;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseTypeRV);
                        if (recyclerView != null) {
                            i = R.id.downarrowIV;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                            if (imageView != null) {
                                i = R.id.image_back;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                if (imageView2 != null) {
                                    i = R.id.main_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.rl_title_main;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_title_main);
                                        if (relativeLayout2 != null) {
                                            RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                            i = R.id.toolbarTitleTV;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                            if (textView2 != null) {
                                                return new ActivityCourseTypeBinding(relativeLayout3, cardView, relativeLayout, textView, clickableWebView, recyclerView, imageView, imageView2, toolbar, relativeLayout2, relativeLayout3, textView2);
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
