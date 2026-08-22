package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTestCreateBinding implements ViewBinding {
    public final TextView btnClear;
    public final FrameLayout btnFinish;
    public final FrameLayout btnNext;
    public final FrameLayout btnPrev;
    public final Button btnSubmit;
    public final AppCompatImageView calci;
    public final TextView changelang;
    public final DrawerLayout drawerLayout;
    public final TextView gridView;
    public final ImageView imgPause;
    public final ImageView imgTestback;
    public final ImageView imgTestmenu;
    public final ImageView langimage;
    public final LinearLayout layout;
    public final TextView listView;
    public final LinearLayout llBottom;
    public final LinearLayout llBottomRightmenu;
    public final LinearLayout llDrawerRight;
    public final LinearLayout llMarkForReview;
    public final LinearLayout llMarkForReviewCount;
    public final TextView nextTV;
    public final RecyclerView rlQuestionpad;
    public final RelativeLayout rlTime;
    private final DrawerLayout rootView;
    public final RecyclerView rvnumberpad;
    public final TextView saveMark;
    public final ImageView saveMarkCount;
    public final TextView testSeriesName;
    public final FrameLayout testlayout;
    public final Toolbar toolbar;
    public final TextView tvAnswerCount;
    public final TextView tvMarkforReviewCount;
    public final TextView tvQuestionnumber;
    public final TextView tvSavemarkforReviewCount;
    public final TextView tvSkipCount;
    public final TextView tvTime;
    public final TextView tvUnanswerCount;
    public final View viewMarkForReviewCount;
    public final ViewPager viewPagerTest;

    private ActivityTestCreateBinding(DrawerLayout rootView, TextView btnClear, FrameLayout btnFinish, FrameLayout btnNext, FrameLayout btnPrev, Button btnSubmit, AppCompatImageView calci, TextView changelang, DrawerLayout drawerLayout, TextView gridView, ImageView imgPause, ImageView imgTestback, ImageView imgTestmenu, ImageView langimage, LinearLayout layout, TextView listView, LinearLayout llBottom, LinearLayout llBottomRightmenu, LinearLayout llDrawerRight, LinearLayout llMarkForReview, LinearLayout llMarkForReviewCount, TextView nextTV, RecyclerView rlQuestionpad, RelativeLayout rlTime, RecyclerView rvnumberpad, TextView saveMark, ImageView saveMarkCount, TextView testSeriesName, FrameLayout testlayout, Toolbar toolbar, TextView tvAnswerCount, TextView tvMarkforReviewCount, TextView tvQuestionnumber, TextView tvSavemarkforReviewCount, TextView tvSkipCount, TextView tvTime, TextView tvUnanswerCount, View viewMarkForReviewCount, ViewPager viewPagerTest) {
        this.rootView = rootView;
        this.btnClear = btnClear;
        this.btnFinish = btnFinish;
        this.btnNext = btnNext;
        this.btnPrev = btnPrev;
        this.btnSubmit = btnSubmit;
        this.calci = calci;
        this.changelang = changelang;
        this.drawerLayout = drawerLayout;
        this.gridView = gridView;
        this.imgPause = imgPause;
        this.imgTestback = imgTestback;
        this.imgTestmenu = imgTestmenu;
        this.langimage = langimage;
        this.layout = layout;
        this.listView = listView;
        this.llBottom = llBottom;
        this.llBottomRightmenu = llBottomRightmenu;
        this.llDrawerRight = llDrawerRight;
        this.llMarkForReview = llMarkForReview;
        this.llMarkForReviewCount = llMarkForReviewCount;
        this.nextTV = nextTV;
        this.rlQuestionpad = rlQuestionpad;
        this.rlTime = rlTime;
        this.rvnumberpad = rvnumberpad;
        this.saveMark = saveMark;
        this.saveMarkCount = saveMarkCount;
        this.testSeriesName = testSeriesName;
        this.testlayout = testlayout;
        this.toolbar = toolbar;
        this.tvAnswerCount = tvAnswerCount;
        this.tvMarkforReviewCount = tvMarkforReviewCount;
        this.tvQuestionnumber = tvQuestionnumber;
        this.tvSavemarkforReviewCount = tvSavemarkforReviewCount;
        this.tvSkipCount = tvSkipCount;
        this.tvTime = tvTime;
        this.tvUnanswerCount = tvUnanswerCount;
        this.viewMarkForReviewCount = viewMarkForReviewCount;
        this.viewPagerTest = viewPagerTest;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestCreateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestCreateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_test_create, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestCreateBinding bind(View rootView) {
        int i = R.id.btn_clear;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn_clear);
        if (textView != null) {
            i = R.id.btn_finish;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_finish);
            if (frameLayout != null) {
                i = R.id.btn_next;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_next);
                if (frameLayout2 != null) {
                    i = R.id.btn_prev;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_prev);
                    if (frameLayout3 != null) {
                        i = R.id.btn_submit;
                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
                        if (button != null) {
                            i = R.id.calci;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.calci);
                            if (appCompatImageView != null) {
                                i = R.id.changelang;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.changelang);
                                if (textView2 != null) {
                                    DrawerLayout drawerLayout = (DrawerLayout) rootView;
                                    i = R.id.gridView;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gridView);
                                    if (textView3 != null) {
                                        i = R.id.img_pause;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_pause);
                                        if (imageView != null) {
                                            i = R.id.img_testback;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_testback);
                                            if (imageView2 != null) {
                                                i = R.id.img_testmenu;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_testmenu);
                                                if (imageView3 != null) {
                                                    i = R.id.langimage;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.langimage);
                                                    if (imageView4 != null) {
                                                        i = R.id.layout;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                                                        if (linearLayout != null) {
                                                            i = R.id.listView;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listView);
                                                            if (textView4 != null) {
                                                                i = R.id.ll_bottom;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.ll_bottom_rightmenu;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom_rightmenu);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.llDrawerRight;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llDrawerRight);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.llMarkForReview;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMarkForReview);
                                                                            if (linearLayout5 != null) {
                                                                                i = R.id.llMarkForReviewCount;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMarkForReviewCount);
                                                                                if (linearLayout6 != null) {
                                                                                    i = R.id.nextTV;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextTV);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.rl_questionpad;
                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rl_questionpad);
                                                                                        if (recyclerView != null) {
                                                                                            i = R.id.rl_time;
                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_time);
                                                                                            if (relativeLayout != null) {
                                                                                                i = R.id.rvnumberpad;
                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvnumberpad);
                                                                                                if (recyclerView2 != null) {
                                                                                                    i = R.id.save_mark;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_mark);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.save_mark_count;
                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.save_mark_count);
                                                                                                        if (imageView5 != null) {
                                                                                                            i = R.id.testSeriesName;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testSeriesName);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.testlayout;
                                                                                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.testlayout);
                                                                                                                if (frameLayout4 != null) {
                                                                                                                    i = R.id.toolbar;
                                                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                                                                                                    if (toolbar != null) {
                                                                                                                        i = R.id.tv_answer_count;
                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_answer_count);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i = R.id.tv_markforReview_count;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_markforReview_count);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.tv_questionnumber;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_questionnumber);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.tv_savemarkforReview_count;
                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_savemarkforReview_count);
                                                                                                                                    if (textView11 != null) {
                                                                                                                                        i = R.id.tv_skip_count;
                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_skip_count);
                                                                                                                                        if (textView12 != null) {
                                                                                                                                            i = R.id.tv_time;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_time);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i = R.id.tv_unanswer_count;
                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_unanswer_count);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = R.id.viewMarkForReviewCount;
                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewMarkForReviewCount);
                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                        i = R.id.view_pager_test;
                                                                                                                                                        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager_test);
                                                                                                                                                        if (viewPager != null) {
                                                                                                                                                            return new ActivityTestCreateBinding(drawerLayout, textView, frameLayout, frameLayout2, frameLayout3, button, appCompatImageView, textView2, drawerLayout, textView3, imageView, imageView2, imageView3, imageView4, linearLayout, textView4, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView5, recyclerView, relativeLayout, recyclerView2, textView6, imageView5, textView7, frameLayout4, toolbar, textView8, textView9, textView10, textView11, textView12, textView13, textView14, viewFindChildViewById, viewPager);
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
