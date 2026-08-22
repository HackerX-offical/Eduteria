package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.EnhancedWrapContentViewPager;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboard8Binding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RelativeLayout RL1P;
    public final ImageView arrow;
    public final RecyclerView bannerSlider;
    public final AutoSliderPageLayoutBinding bannerSliderLayout;
    public final DynamicBottomBarBinding bottomMenu;
    public final RelativeLayout browseByMode;
    public final LinearLayout cartLL;
    public final ImageView chatboat;
    public final ImageButton chromecast;
    public final RelativeLayout containtLayout;
    public final LinearLayout courseLayoutCover;
    public final TextView coursesTxt;
    public final RelativeLayout cvr1;
    public final LinearLayout cvrNotificationCount;
    public final RelativeLayout cvrNotificationRL;
    public final RelativeLayout dailyDoseCover;
    public final RecyclerView dailyDoseRV;
    public final ImageView downarrowIV;
    public final ImageView downarrowIVNew;
    public final RelativeLayout feedsLl;
    public final Toolbar feedsToolbar;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final ImageView homeBackIV;
    public final LinearLayout homeLL;
    public final ImageView image;
    public final ImageView ivWhatsapp;
    public final LinearLayout layoutDotsMode;
    public final LinearLayout libLL;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetestLL;
    public final RelativeLayout llTop;
    public final LinearLayout llTopTwo;
    public final RelativeLayout mainlayout;
    public final LinearLayout myLibrary;
    public final TextView noData;
    public final RelativeLayout noDataDailyDose;
    public final RelativeLayout noDataFoundRL1;
    public final TextView notificaionCount;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout rl1;
    private final RelativeLayout rootView;
    public final StickyScrollView scrollView;
    public final ImageView searchIV;
    public final LinearLayout testLL;
    public final TextView testseriesTxt;
    public final RecyclerView tileRv;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;
    public final RelativeLayout viewPagerRL;
    public final RelativeLayout viewPagerRLExam;
    public final EnhancedWrapContentViewPager viewPagerVideosParent;
    public final View vodView;

    private AppBarDashboard8Binding(RelativeLayout rootView, LinearLayout CourseLL, RelativeLayout RL1P, ImageView arrow, RecyclerView bannerSlider, AutoSliderPageLayoutBinding bannerSliderLayout, DynamicBottomBarBinding bottomMenu, RelativeLayout browseByMode, LinearLayout cartLL, ImageView chatboat, ImageButton chromecast, RelativeLayout containtLayout, LinearLayout courseLayoutCover, TextView coursesTxt, RelativeLayout cvr1, LinearLayout cvrNotificationCount, RelativeLayout cvrNotificationRL, RelativeLayout dailyDoseCover, RecyclerView dailyDoseRV, ImageView downarrowIV, ImageView downarrowIVNew, RelativeLayout feedsLl, Toolbar feedsToolbar, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, ImageView homeBackIV, LinearLayout homeLL, ImageView image, ImageView ivWhatsapp, LinearLayout layoutDotsMode, LinearLayout libLL, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetestLL, RelativeLayout llTop, LinearLayout llTopTwo, RelativeLayout mainlayout, LinearLayout myLibrary, TextView noData, RelativeLayout noDataDailyDose, RelativeLayout noDataFoundRL1, TextView notificaionCount, ImageView profileImage, RelativeLayout profileLL, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout rl1, StickyScrollView scrollView, ImageView searchIV, LinearLayout testLL, TextView testseriesTxt, RecyclerView tileRv, RelativeLayout titleinnerRL, TextView toolbartitleTV, RelativeLayout viewPagerRL, RelativeLayout viewPagerRLExam, EnhancedWrapContentViewPager viewPagerVideosParent, View vodView) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.RL1P = RL1P;
        this.arrow = arrow;
        this.bannerSlider = bannerSlider;
        this.bannerSliderLayout = bannerSliderLayout;
        this.bottomMenu = bottomMenu;
        this.browseByMode = browseByMode;
        this.cartLL = cartLL;
        this.chatboat = chatboat;
        this.chromecast = chromecast;
        this.containtLayout = containtLayout;
        this.courseLayoutCover = courseLayoutCover;
        this.coursesTxt = coursesTxt;
        this.cvr1 = cvr1;
        this.cvrNotificationCount = cvrNotificationCount;
        this.cvrNotificationRL = cvrNotificationRL;
        this.dailyDoseCover = dailyDoseCover;
        this.dailyDoseRV = dailyDoseRV;
        this.downarrowIV = downarrowIV;
        this.downarrowIVNew = downarrowIVNew;
        this.feedsLl = feedsLl;
        this.feedsToolbar = feedsToolbar;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.homeBackIV = homeBackIV;
        this.homeLL = homeLL;
        this.image = image;
        this.ivWhatsapp = ivWhatsapp;
        this.layoutDotsMode = layoutDotsMode;
        this.libLL = libLL;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetestLL = livetestLL;
        this.llTop = llTop;
        this.llTopTwo = llTopTwo;
        this.mainlayout = mainlayout;
        this.myLibrary = myLibrary;
        this.noData = noData;
        this.noDataDailyDose = noDataDailyDose;
        this.noDataFoundRL1 = noDataFoundRL1;
        this.notificaionCount = notificaionCount;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.rl1 = rl1;
        this.scrollView = scrollView;
        this.searchIV = searchIV;
        this.testLL = testLL;
        this.testseriesTxt = testseriesTxt;
        this.tileRv = tileRv;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
        this.viewPagerRL = viewPagerRL;
        this.viewPagerRLExam = viewPagerRLExam;
        this.viewPagerVideosParent = viewPagerVideosParent;
        this.vodView = vodView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboard8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboard8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboard8Binding bind(View rootView) {
        int i = R.id.CourseLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.CourseLL);
        if (linearLayout != null) {
            i = R.id.RL1P;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
            if (relativeLayout != null) {
                i = R.id.arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
                if (imageView != null) {
                    i = R.id.bannerSlider;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.bannerSlider);
                    if (recyclerView != null) {
                        i = R.id.bannerSliderLayout;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bannerSliderLayout);
                        if (viewFindChildViewById != null) {
                            AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind = AutoSliderPageLayoutBinding.bind(viewFindChildViewById);
                            i = R.id.bottom_menu;
                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                            if (viewFindChildViewById2 != null) {
                                DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById2);
                                i = R.id.browse_by_mode;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.browse_by_mode);
                                if (relativeLayout2 != null) {
                                    i = R.id.cartLL;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                                    if (linearLayout2 != null) {
                                        i = R.id.chatboat;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatboat);
                                        if (imageView2 != null) {
                                            i = R.id.chromecast;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.chromecast);
                                            if (imageButton != null) {
                                                i = R.id.containt_layout;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.containt_layout);
                                                if (relativeLayout3 != null) {
                                                    i = R.id.courseLayoutCover;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.courseLayoutCover);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.courses_txt;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courses_txt);
                                                        if (textView != null) {
                                                            i = R.id.cvr1;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvr1);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.cvrNotificationCount;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.cvrNotificationRL;
                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationRL);
                                                                    if (relativeLayout5 != null) {
                                                                        i = R.id.dailyDoseCover;
                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dailyDoseCover);
                                                                        if (relativeLayout6 != null) {
                                                                            i = R.id.dailyDoseRV;
                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.dailyDoseRV);
                                                                            if (recyclerView2 != null) {
                                                                                i = R.id.downarrowIV;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.downarrowIV_new;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                                                                                    if (imageView4 != null) {
                                                                                        i = R.id.feeds_ll;
                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.feeds_ll);
                                                                                        if (relativeLayout7 != null) {
                                                                                            i = R.id.feeds_toolbar;
                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.feeds_toolbar);
                                                                                            if (toolbar != null) {
                                                                                                i = R.id.filter;
                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                                                                                                if (relativeLayout8 != null) {
                                                                                                    i = R.id.filterOne;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                                                                                    if (textView2 != null) {
                                                                                                        i = R.id.filter_one_click;
                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                                                                                        if (relativeLayout9 != null) {
                                                                                                            i = R.id.filterTwo;
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                                                                                            if (textView3 != null) {
                                                                                                                i = R.id.filter_two_click;
                                                                                                                RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                                                                                                if (relativeLayout10 != null) {
                                                                                                                    i = R.id.homeBackIV;
                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                                                                    if (imageView5 != null) {
                                                                                                                        i = R.id.homeLL;
                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                                                                        if (linearLayout5 != null) {
                                                                                                                            i = R.id.image;
                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                                                                                                            if (imageView6 != null) {
                                                                                                                                i = R.id.iv_whatsapp;
                                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_whatsapp);
                                                                                                                                if (imageView7 != null) {
                                                                                                                                    i = R.id.layoutDots_Mode;
                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layoutDots_Mode);
                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                        i = R.id.libLL;
                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                            i = R.id.liveclass;
                                                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                                                                                            if (linearLayout8 != null) {
                                                                                                                                                i = R.id.liveclassLL;
                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                    i = R.id.livetest;
                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                        i = R.id.livetestLL;
                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                            i = R.id.ll_top;
                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top);
                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                i = R.id.ll_top_two;
                                                                                                                                                                LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                                                                                                                                if (linearLayout12 != null) {
                                                                                                                                                                    i = R.id.mainlayout;
                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                        i = R.id.my_library;
                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                            i = R.id.no_data;
                                                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                                                                                                                                                            if (textView4 != null) {
                                                                                                                                                                                i = R.id.noDataDailyDose;
                                                                                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.noDataDailyDose);
                                                                                                                                                                                if (relativeLayout13 != null) {
                                                                                                                                                                                    i = R.id.no_data_found_RL_1;
                                                                                                                                                                                    RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL_1);
                                                                                                                                                                                    if (relativeLayout14 != null) {
                                                                                                                                                                                        i = R.id.notificaionCount;
                                                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                                            i = R.id.profile_image;
                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                i = R.id.profileLL;
                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                    i = R.id.progressBar;
                                                                                                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                                                                                                    if (progressBar != null) {
                                                                                                                                                                                                        i = R.id.pullto_referesh;
                                                                                                                                                                                                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                                                                                                                                                        if (swipeRefreshLayout != null) {
                                                                                                                                                                                                            i = R.id.rl1;
                                                                                                                                                                                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                                                                                                                                                                                            if (relativeLayout16 != null) {
                                                                                                                                                                                                                i = R.id.scrollView;
                                                                                                                                                                                                                StickyScrollView stickyScrollView = (StickyScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                                                                                                                if (stickyScrollView != null) {
                                                                                                                                                                                                                    i = R.id.searchIV;
                                                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                                                        i = R.id.testLL;
                                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                                            i = R.id.testseries_txt;
                                                                                                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testseries_txt);
                                                                                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                                                                                i = R.id.tileRv;
                                                                                                                                                                                                                                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                                                                                                                if (recyclerView3 != null) {
                                                                                                                                                                                                                                    i = R.id.titleinnerRL;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                                                                                                    if (relativeLayout17 != null) {
                                                                                                                                                                                                                                        i = R.id.toolbartitleTV;
                                                                                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                                                                                            i = R.id.viewPagerRL;
                                                                                                                                                                                                                                            RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                                                                                                                                            if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                i = R.id.view_pagerRL_exam;
                                                                                                                                                                                                                                                RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.view_pagerRL_exam);
                                                                                                                                                                                                                                                if (relativeLayout19 != null) {
                                                                                                                                                                                                                                                    i = R.id.view_pager_videos_parent;
                                                                                                                                                                                                                                                    EnhancedWrapContentViewPager enhancedWrapContentViewPager = (EnhancedWrapContentViewPager) ViewBindings.findChildViewById(rootView, R.id.view_pager_videos_parent);
                                                                                                                                                                                                                                                    if (enhancedWrapContentViewPager != null) {
                                                                                                                                                                                                                                                        i = R.id.vodView;
                                                                                                                                                                                                                                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                                                                                                                                                        if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                            return new AppBarDashboard8Binding((RelativeLayout) rootView, linearLayout, relativeLayout, imageView, recyclerView, autoSliderPageLayoutBindingBind, dynamicBottomBarBindingBind, relativeLayout2, linearLayout2, imageView2, imageButton, relativeLayout3, linearLayout3, textView, relativeLayout4, linearLayout4, relativeLayout5, relativeLayout6, recyclerView2, imageView3, imageView4, relativeLayout7, toolbar, relativeLayout8, textView2, relativeLayout9, textView3, relativeLayout10, imageView5, linearLayout5, imageView6, imageView7, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, relativeLayout11, linearLayout12, relativeLayout12, linearLayout13, textView4, relativeLayout13, relativeLayout14, textView5, imageView8, relativeLayout15, progressBar, swipeRefreshLayout, relativeLayout16, stickyScrollView, imageView9, linearLayout14, textView6, recyclerView3, relativeLayout17, textView7, relativeLayout18, relativeLayout19, enhancedWrapContentViewPager, viewFindChildViewById3);
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
