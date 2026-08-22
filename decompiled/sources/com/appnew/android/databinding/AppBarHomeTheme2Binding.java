package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarHomeTheme2Binding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RelativeLayout RL1P;
    public final ImageView arrow;
    public final Button attendanceIn;
    public final Button attendanceOut;
    public final LinearLayout attendanceRl;
    public final TextView attendanceTimer;
    public final AutoSliderPageLayoutBinding bannerSliderLayout;
    public final DynamicBottomBarBinding bottomMenu;
    public final AutoSliderPageLayoutBinding bottomSliderLayout;
    public final RelativeLayout bottomViewPagerRL;
    public final CardView card1;
    public final CardView card2;
    public final CardView card3;
    public final LinearLayout cartLL;
    public final ImageView chatboat;
    public final ImageButton chromecast;
    public final RecyclerView courseListRV;
    public final RelativeLayout cvrHeaderKrantikari;
    public final LinearLayout cvrNotificationCount;
    public final LinearLayout cvrNotificationCount1;
    public final LinearLayout cvrRightItems;
    public final ImageView downarrowIV;
    public final ImageView downarrowIVNew;
    public final Toolbar feedsToolbar;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final LinearLayout greetingMsgLL;
    public final TextView greetingMsgTV;
    public final ImageView headerImage;
    public final RelativeLayout headerTitleRl;
    public final ImageView homeBackIV;
    public final LinearLayout homeLL;
    public final LinearLayout libLL;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetestLL;
    public final RelativeLayout llTop;
    public final LinearLayout llTopTwo;
    public final RelativeLayout mainlayout;
    public final LinearLayout myLibrary;
    public final TextView notificaionCount;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout rl1;
    public final RelativeLayout rlRecentWatch;
    private final RelativeLayout rootView;
    public final RecyclerView rvRecentActivity;
    public final StickyScrollView scrollView;
    public final ImageView searchIV;
    public final LinearLayout testLL;
    public final RecyclerView tileRv;
    public final TextView tileTv;
    public final LinearLayout titleLl;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;
    public final TextView tvRecentAct;
    public final RelativeLayout viewPagerRL;
    public final View vodView;

    private AppBarHomeTheme2Binding(RelativeLayout rootView, LinearLayout CourseLL, RelativeLayout RL1P, ImageView arrow, Button attendanceIn, Button attendanceOut, LinearLayout attendanceRl, TextView attendanceTimer, AutoSliderPageLayoutBinding bannerSliderLayout, DynamicBottomBarBinding bottomMenu, AutoSliderPageLayoutBinding bottomSliderLayout, RelativeLayout bottomViewPagerRL, CardView card1, CardView card2, CardView card3, LinearLayout cartLL, ImageView chatboat, ImageButton chromecast, RecyclerView courseListRV, RelativeLayout cvrHeaderKrantikari, LinearLayout cvrNotificationCount, LinearLayout cvrNotificationCount1, LinearLayout cvrRightItems, ImageView downarrowIV, ImageView downarrowIVNew, Toolbar feedsToolbar, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, LinearLayout greetingMsgLL, TextView greetingMsgTV, ImageView headerImage, RelativeLayout headerTitleRl, ImageView homeBackIV, LinearLayout homeLL, LinearLayout libLL, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetestLL, RelativeLayout llTop, LinearLayout llTopTwo, RelativeLayout mainlayout, LinearLayout myLibrary, TextView notificaionCount, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ImageView profileImage, RelativeLayout profileLL, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout rl1, RelativeLayout rlRecentWatch, RecyclerView rvRecentActivity, StickyScrollView scrollView, ImageView searchIV, LinearLayout testLL, RecyclerView tileRv, TextView tileTv, LinearLayout titleLl, RelativeLayout titleinnerRL, TextView toolbartitleTV, TextView tvRecentAct, RelativeLayout viewPagerRL, View vodView) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.RL1P = RL1P;
        this.arrow = arrow;
        this.attendanceIn = attendanceIn;
        this.attendanceOut = attendanceOut;
        this.attendanceRl = attendanceRl;
        this.attendanceTimer = attendanceTimer;
        this.bannerSliderLayout = bannerSliderLayout;
        this.bottomMenu = bottomMenu;
        this.bottomSliderLayout = bottomSliderLayout;
        this.bottomViewPagerRL = bottomViewPagerRL;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.cartLL = cartLL;
        this.chatboat = chatboat;
        this.chromecast = chromecast;
        this.courseListRV = courseListRV;
        this.cvrHeaderKrantikari = cvrHeaderKrantikari;
        this.cvrNotificationCount = cvrNotificationCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.cvrRightItems = cvrRightItems;
        this.downarrowIV = downarrowIV;
        this.downarrowIVNew = downarrowIVNew;
        this.feedsToolbar = feedsToolbar;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.greetingMsgLL = greetingMsgLL;
        this.greetingMsgTV = greetingMsgTV;
        this.headerImage = headerImage;
        this.headerTitleRl = headerTitleRl;
        this.homeBackIV = homeBackIV;
        this.homeLL = homeLL;
        this.libLL = libLL;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetestLL = livetestLL;
        this.llTop = llTop;
        this.llTopTwo = llTopTwo;
        this.mainlayout = mainlayout;
        this.myLibrary = myLibrary;
        this.notificaionCount = notificaionCount;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.rl1 = rl1;
        this.rlRecentWatch = rlRecentWatch;
        this.rvRecentActivity = rvRecentActivity;
        this.scrollView = scrollView;
        this.searchIV = searchIV;
        this.testLL = testLL;
        this.tileRv = tileRv;
        this.tileTv = tileTv;
        this.titleLl = titleLl;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
        this.tvRecentAct = tvRecentAct;
        this.viewPagerRL = viewPagerRL;
        this.vodView = vodView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarHomeTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarHomeTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_home_theme2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarHomeTheme2Binding bind(View rootView) {
        int i = R.id.CourseLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.CourseLL);
        if (linearLayout != null) {
            i = R.id.RL1P;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
            if (relativeLayout != null) {
                i = R.id.arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
                if (imageView != null) {
                    i = R.id.attendanceIn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.attendanceIn);
                    if (button != null) {
                        i = R.id.attendanceOut;
                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.attendanceOut);
                        if (button2 != null) {
                            i = R.id.attendance_rl;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attendance_rl);
                            if (linearLayout2 != null) {
                                i = R.id.attendanceTimer;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.attendanceTimer);
                                if (textView != null) {
                                    i = R.id.bannerSliderLayout;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bannerSliderLayout);
                                    if (viewFindChildViewById != null) {
                                        AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind = AutoSliderPageLayoutBinding.bind(viewFindChildViewById);
                                        i = R.id.bottom_menu;
                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                                        if (viewFindChildViewById2 != null) {
                                            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById2);
                                            i = R.id.bottomSliderLayout;
                                            View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.bottomSliderLayout);
                                            if (viewFindChildViewById3 != null) {
                                                AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind2 = AutoSliderPageLayoutBinding.bind(viewFindChildViewById3);
                                                i = R.id.bottomViewPagerRL;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.bottomViewPagerRL);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.card1;
                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card1);
                                                    if (cardView != null) {
                                                        i = R.id.card2;
                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.card2);
                                                        if (cardView2 != null) {
                                                            i = R.id.card3;
                                                            CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.card3);
                                                            if (cardView3 != null) {
                                                                i = R.id.cartLL;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.chatboat;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatboat);
                                                                    if (imageView2 != null) {
                                                                        i = R.id.chromecast;
                                                                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.chromecast);
                                                                        if (imageButton != null) {
                                                                            i = R.id.courseListRV;
                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
                                                                            if (recyclerView != null) {
                                                                                i = R.id.cvrHeaderKrantikari;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrHeaderKrantikari);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.cvrNotificationCount;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.cvrNotificationCount1;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.cvrRightItems;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightItems);
                                                                                            if (linearLayout6 != null) {
                                                                                                i = R.id.downarrowIV;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.downarrowIV_new;
                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = R.id.feeds_toolbar;
                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.feeds_toolbar);
                                                                                                        if (toolbar != null) {
                                                                                                            i = R.id.filter;
                                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                                                                                                            if (relativeLayout4 != null) {
                                                                                                                i = R.id.filterOne;
                                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                                                                                                if (textView2 != null) {
                                                                                                                    i = R.id.filter_one_click;
                                                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                                                                                                    if (relativeLayout5 != null) {
                                                                                                                        i = R.id.filterTwo;
                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                                                                                                        if (textView3 != null) {
                                                                                                                            i = R.id.filter_two_click;
                                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                                                                                                            if (relativeLayout6 != null) {
                                                                                                                                i = R.id.greetingMsgLL;
                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.greetingMsgLL);
                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                    i = R.id.greetingMsgTV;
                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.greetingMsgTV);
                                                                                                                                    if (textView4 != null) {
                                                                                                                                        i = R.id.headerImage;
                                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.headerImage);
                                                                                                                                        if (imageView5 != null) {
                                                                                                                                            i = R.id.headerTitleRl;
                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.headerTitleRl);
                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                i = R.id.homeBackIV;
                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                    i = R.id.homeLL;
                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                        i = R.id.libLL;
                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                            i = R.id.liveclass;
                                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                                i = R.id.liveclassLL;
                                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                                    i = R.id.livetest;
                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                        i = R.id.livetestLL;
                                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                                            i = R.id.ll_top;
                                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top);
                                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                                i = R.id.ll_top_two;
                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                    i = R.id.mainlayout;
                                                                                                                                                                                    RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                                                                                                                                    if (relativeLayout9 != null) {
                                                                                                                                                                                        i = R.id.my_library;
                                                                                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                                                                                                        if (linearLayout15 != null) {
                                                                                                                                                                                            i = R.id.notificaionCount;
                                                                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                                                                                                            if (textView5 != null) {
                                                                                                                                                                                                i = R.id.notificaionCount1;
                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                    i = R.id.notificationIV;
                                                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                                                        i = R.id.notificationLL;
                                                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                                                            i = R.id.profile_image;
                                                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                                                i = R.id.profileLL;
                                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                                    i = R.id.progressBar;
                                                                                                                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                                                                                                                    if (progressBar != null) {
                                                                                                                                                                                                                        i = R.id.pullto_referesh;
                                                                                                                                                                                                                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                                                                                                                                                                        if (swipeRefreshLayout != null) {
                                                                                                                                                                                                                            i = R.id.rl1;
                                                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                                                i = R.id.rl_recentWatch;
                                                                                                                                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_recentWatch);
                                                                                                                                                                                                                                if (relativeLayout13 != null) {
                                                                                                                                                                                                                                    i = R.id.rv_recent_activity;
                                                                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rv_recent_activity);
                                                                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                                                                        i = R.id.scrollView;
                                                                                                                                                                                                                                        StickyScrollView stickyScrollView = (StickyScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                                                                                                                                        if (stickyScrollView != null) {
                                                                                                                                                                                                                                            i = R.id.searchIV;
                                                                                                                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                                                                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                                                                                                                i = R.id.testLL;
                                                                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                                                                    i = R.id.tileRv;
                                                                                                                                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                                                                                                                                        i = R.id.tile_tv;
                                                                                                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tile_tv);
                                                                                                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                                                                                                            i = R.id.title_ll;
                                                                                                                                                                                                                                                            LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                                                                                                                                                                                                                            if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                i = R.id.titleinnerRL;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                                                                                                                                if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                    i = R.id.toolbartitleTV;
                                                                                                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                                                                                                        i = R.id.tv_recent_act;
                                                                                                                                                                                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_recent_act);
                                                                                                                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                                                                                                                            i = R.id.viewPagerRL;
                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                                                                                                                                                                            if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                i = R.id.vodView;
                                                                                                                                                                                                                                                                                View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                                                                                                                                                                                if (viewFindChildViewById4 != null) {
                                                                                                                                                                                                                                                                                    return new AppBarHomeTheme2Binding((RelativeLayout) rootView, linearLayout, relativeLayout, imageView, button, button2, linearLayout2, textView, autoSliderPageLayoutBindingBind, dynamicBottomBarBindingBind, autoSliderPageLayoutBindingBind2, relativeLayout2, cardView, cardView2, cardView3, linearLayout3, imageView2, imageButton, recyclerView, relativeLayout3, linearLayout4, linearLayout5, linearLayout6, imageView3, imageView4, toolbar, relativeLayout4, textView2, relativeLayout5, textView3, relativeLayout6, linearLayout7, textView4, imageView5, relativeLayout7, imageView6, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, relativeLayout8, linearLayout14, relativeLayout9, linearLayout15, textView5, textView6, imageView7, relativeLayout10, imageView8, relativeLayout11, progressBar, swipeRefreshLayout, relativeLayout12, relativeLayout13, recyclerView2, stickyScrollView, imageView9, linearLayout16, recyclerView3, textView7, linearLayout17, relativeLayout14, textView8, textView9, relativeLayout15, viewFindChildViewById4);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
