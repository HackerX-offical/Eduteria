package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCreateTestSolutionBinding implements ViewBinding {
    public final AppCompatImageView bookmarkIconDeselect;
    public final AppCompatImageView bookmarkIconSelect;
    public final FrameLayout btnFinish;
    public final FrameLayout btnNext;
    public final FrameLayout btnPrev;
    public final TextView changelang;
    public final DrawerLayout drawerLayout;
    public final ImageView imgTestback;
    public final ImageView langimage;
    public final LinearLayout llBottom;
    public final TextView nextTV;
    public final RelativeLayout rlTime;
    public final ConstraintLayout rootConstraint;
    private final DrawerLayout rootView;
    public final RecyclerView rvnumberpad;
    public final TextView testSeriesName;
    public final Toolbar toolbar;
    public final TextView tvQuestionnumber;
    public final ViewPager viewPagerTest;

    private ActivityCreateTestSolutionBinding(DrawerLayout rootView, AppCompatImageView bookmarkIconDeselect, AppCompatImageView bookmarkIconSelect, FrameLayout btnFinish, FrameLayout btnNext, FrameLayout btnPrev, TextView changelang, DrawerLayout drawerLayout, ImageView imgTestback, ImageView langimage, LinearLayout llBottom, TextView nextTV, RelativeLayout rlTime, ConstraintLayout rootConstraint, RecyclerView rvnumberpad, TextView testSeriesName, Toolbar toolbar, TextView tvQuestionnumber, ViewPager viewPagerTest) {
        this.rootView = rootView;
        this.bookmarkIconDeselect = bookmarkIconDeselect;
        this.bookmarkIconSelect = bookmarkIconSelect;
        this.btnFinish = btnFinish;
        this.btnNext = btnNext;
        this.btnPrev = btnPrev;
        this.changelang = changelang;
        this.drawerLayout = drawerLayout;
        this.imgTestback = imgTestback;
        this.langimage = langimage;
        this.llBottom = llBottom;
        this.nextTV = nextTV;
        this.rlTime = rlTime;
        this.rootConstraint = rootConstraint;
        this.rvnumberpad = rvnumberpad;
        this.testSeriesName = testSeriesName;
        this.toolbar = toolbar;
        this.tvQuestionnumber = tvQuestionnumber;
        this.viewPagerTest = viewPagerTest;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCreateTestSolutionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCreateTestSolutionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_create_test_solution, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCreateTestSolutionBinding bind(View rootView) {
        int i = R.id.bookmark_icon_deselect;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.bookmark_icon_deselect);
        if (appCompatImageView != null) {
            i = R.id.bookmark_icon_select;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.bookmark_icon_select);
            if (appCompatImageView2 != null) {
                i = R.id.btn_finish;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_finish);
                if (frameLayout != null) {
                    i = R.id.btn_next;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_next);
                    if (frameLayout2 != null) {
                        i = R.id.btn_prev;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_prev);
                        if (frameLayout3 != null) {
                            i = R.id.changelang;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.changelang);
                            if (textView != null) {
                                DrawerLayout drawerLayout = (DrawerLayout) rootView;
                                i = R.id.img_testback;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_testback);
                                if (imageView != null) {
                                    i = R.id.langimage;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.langimage);
                                    if (imageView2 != null) {
                                        i = R.id.ll_bottom;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                        if (linearLayout != null) {
                                            i = R.id.nextTV;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextTV);
                                            if (textView2 != null) {
                                                i = R.id.rl_time;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_time);
                                                if (relativeLayout != null) {
                                                    i = R.id.rootConstraint;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.rootConstraint);
                                                    if (constraintLayout != null) {
                                                        i = R.id.rvnumberpad;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvnumberpad);
                                                        if (recyclerView != null) {
                                                            i = R.id.testSeriesName;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testSeriesName);
                                                            if (textView3 != null) {
                                                                i = R.id.toolbar;
                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                                if (toolbar != null) {
                                                                    i = R.id.tv_questionnumber;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_questionnumber);
                                                                    if (textView4 != null) {
                                                                        i = R.id.view_pager_test;
                                                                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager_test);
                                                                        if (viewPager != null) {
                                                                            return new ActivityCreateTestSolutionBinding(drawerLayout, appCompatImageView, appCompatImageView2, frameLayout, frameLayout2, frameLayout3, textView, drawerLayout, imageView, imageView2, linearLayout, textView2, relativeLayout, constraintLayout, recyclerView, textView3, toolbar, textView4, viewPager);
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
