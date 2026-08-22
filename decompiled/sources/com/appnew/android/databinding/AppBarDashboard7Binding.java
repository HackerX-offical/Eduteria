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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboard7Binding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RelativeLayout RL1P;
    public final ImageView arrow;
    public final RecyclerView bannerSlider;
    public final DynamicBottomBarBinding bottomMenu;
    public final ViewPager2 bottomSliderViewPager;
    public final RelativeLayout bottomViewPagerRL;
    public final LinearLayout cartLL;
    public final ImageView chatboat;
    public final ImageButton chromecast;
    public final RecyclerView courseListRV;
    public final LinearLayout cvrNotificationCount;
    public final LinearLayout cvrNotificationCount1;
    public final LinearLayout cvrRightItems;
    public final TextView desc;
    public final TextView descTest;
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
    public final ImageView imageMyCourses;
    public final ImageView imageMyTest;
    public final LinearLayout libLL;
    public final LinearLayout liveTest;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetest2;
    public final LinearLayout livetestLL;
    public final RelativeLayout llTop;
    public final RelativeLayout llTop2;
    public final LinearLayout llTopTwo;
    public final LinearLayout mainRl;
    public final RelativeLayout mainlayout;
    public final LinearLayout myCoursesLL;
    public final LinearLayout myCoursesTestLL;
    public final CardView myLibrary;
    public final LinearLayout myLibraryGone;
    public final CardView myTest;
    public final LinearLayout myTestGone;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL1;
    public final TextView notificaionCount;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout rl1;
    private final RelativeLayout rootView;
    public final StickyScrollView scrollView;
    public final ImageView searchIV;
    public final ViewPager2 sliderViewPager;
    public final LinearLayout testLL;
    public final RecyclerView tileRv;
    public final TextView tileTv;
    public final TextView title;
    public final LinearLayout titleLl;
    public final TextView titleTest;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;
    public final RelativeLayout viewPagerRL;
    public final View vodView;

    private AppBarDashboard7Binding(RelativeLayout rootView, LinearLayout CourseLL, RelativeLayout RL1P, ImageView arrow, RecyclerView bannerSlider, DynamicBottomBarBinding bottomMenu, ViewPager2 bottomSliderViewPager, RelativeLayout bottomViewPagerRL, LinearLayout cartLL, ImageView chatboat, ImageButton chromecast, RecyclerView courseListRV, LinearLayout cvrNotificationCount, LinearLayout cvrNotificationCount1, LinearLayout cvrRightItems, TextView desc, TextView descTest, ImageView downarrowIV, ImageView downarrowIVNew, RelativeLayout feedsLl, Toolbar feedsToolbar, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, ImageView homeBackIV, LinearLayout homeLL, ImageView image, ImageView imageMyCourses, ImageView imageMyTest, LinearLayout libLL, LinearLayout liveTest, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetest2, LinearLayout livetestLL, RelativeLayout llTop, RelativeLayout llTop2, LinearLayout llTopTwo, LinearLayout mainRl, RelativeLayout mainlayout, LinearLayout myCoursesLL, LinearLayout myCoursesTestLL, CardView myLibrary, LinearLayout myLibraryGone, CardView myTest, LinearLayout myTestGone, TextView noData, RelativeLayout noDataFoundRL1, TextView notificaionCount, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ImageView profileImage, RelativeLayout profileLL, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout rl1, StickyScrollView scrollView, ImageView searchIV, ViewPager2 sliderViewPager, LinearLayout testLL, RecyclerView tileRv, TextView tileTv, TextView title, LinearLayout titleLl, TextView titleTest, RelativeLayout titleinnerRL, TextView toolbartitleTV, RelativeLayout viewPagerRL, View vodView) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.RL1P = RL1P;
        this.arrow = arrow;
        this.bannerSlider = bannerSlider;
        this.bottomMenu = bottomMenu;
        this.bottomSliderViewPager = bottomSliderViewPager;
        this.bottomViewPagerRL = bottomViewPagerRL;
        this.cartLL = cartLL;
        this.chatboat = chatboat;
        this.chromecast = chromecast;
        this.courseListRV = courseListRV;
        this.cvrNotificationCount = cvrNotificationCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.cvrRightItems = cvrRightItems;
        this.desc = desc;
        this.descTest = descTest;
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
        this.imageMyCourses = imageMyCourses;
        this.imageMyTest = imageMyTest;
        this.libLL = libLL;
        this.liveTest = liveTest;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetest2 = livetest2;
        this.livetestLL = livetestLL;
        this.llTop = llTop;
        this.llTop2 = llTop2;
        this.llTopTwo = llTopTwo;
        this.mainRl = mainRl;
        this.mainlayout = mainlayout;
        this.myCoursesLL = myCoursesLL;
        this.myCoursesTestLL = myCoursesTestLL;
        this.myLibrary = myLibrary;
        this.myLibraryGone = myLibraryGone;
        this.myTest = myTest;
        this.myTestGone = myTestGone;
        this.noData = noData;
        this.noDataFoundRL1 = noDataFoundRL1;
        this.notificaionCount = notificaionCount;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.rl1 = rl1;
        this.scrollView = scrollView;
        this.searchIV = searchIV;
        this.sliderViewPager = sliderViewPager;
        this.testLL = testLL;
        this.tileRv = tileRv;
        this.tileTv = tileTv;
        this.title = title;
        this.titleLl = titleLl;
        this.titleTest = titleTest;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
        this.viewPagerRL = viewPagerRL;
        this.vodView = vodView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboard7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboard7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboard7Binding bind(View rootView) {
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
                        i = R.id.bottom_menu;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                        if (viewFindChildViewById != null) {
                            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
                            i = R.id.bottomSliderViewPager;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, R.id.bottomSliderViewPager);
                            if (viewPager2 != null) {
                                i = R.id.bottomViewPagerRL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.bottomViewPagerRL);
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
                                                i = R.id.courseListRV;
                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
                                                if (recyclerView2 != null) {
                                                    i = R.id.cvrNotificationCount;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.cvrNotificationCount1;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
                                                        if (linearLayout4 != null) {
                                                            i = R.id.cvrRightItems;
                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightItems);
                                                            if (linearLayout5 != null) {
                                                                i = R.id.desc;
                                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
                                                                if (textView != null) {
                                                                    i = R.id.descTest;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.descTest);
                                                                    if (textView2 != null) {
                                                                        i = R.id.downarrowIV;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                        if (imageView3 != null) {
                                                                            i = R.id.downarrowIV_new;
                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                                                                            if (imageView4 != null) {
                                                                                i = R.id.feeds_ll;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.feeds_ll);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.feeds_toolbar;
                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.feeds_toolbar);
                                                                                    if (toolbar != null) {
                                                                                        i = R.id.filter;
                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                                                                                        if (relativeLayout4 != null) {
                                                                                            i = R.id.filterOne;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.filter_one_click;
                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                                                                                if (relativeLayout5 != null) {
                                                                                                    i = R.id.filterTwo;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.filter_two_click;
                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                                                                                        if (relativeLayout6 != null) {
                                                                                                            i = R.id.homeBackIV;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                                                            if (imageView5 != null) {
                                                                                                                i = R.id.homeLL;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                                                                if (linearLayout6 != null) {
                                                                                                                    i = R.id.image;
                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                                                                                                    if (imageView6 != null) {
                                                                                                                        i = R.id.imageMyCourses;
                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageMyCourses);
                                                                                                                        if (imageView7 != null) {
                                                                                                                            i = R.id.imageMyTest;
                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageMyTest);
                                                                                                                            if (imageView8 != null) {
                                                                                                                                i = R.id.libLL;
                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                    i = R.id.liveTest;
                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveTest);
                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                        i = R.id.liveclass;
                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                            i = R.id.liveclassLL;
                                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                                i = R.id.livetest;
                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                    i = R.id.livetest2;
                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest2);
                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                        i = R.id.livetestLL;
                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                            i = R.id.ll_top;
                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top);
                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                i = R.id.ll_top2;
                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top2);
                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                    i = R.id.ll_top_two;
                                                                                                                                                                    LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                                                                                                                                    if (linearLayout14 != null) {
                                                                                                                                                                        i = R.id.main_rl;
                                                                                                                                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.main_rl);
                                                                                                                                                                        if (linearLayout15 != null) {
                                                                                                                                                                            i = R.id.mainlayout;
                                                                                                                                                                            RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                                                                                                                            if (relativeLayout9 != null) {
                                                                                                                                                                                i = R.id.myCoursesLL;
                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.myCoursesLL);
                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                    i = R.id.myCoursesTestLL;
                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.myCoursesTestLL);
                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                        i = R.id.my_library;
                                                                                                                                                                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                                                                                                        if (cardView != null) {
                                                                                                                                                                                            i = R.id.my_libraryGone;
                                                                                                                                                                                            LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_libraryGone);
                                                                                                                                                                                            if (linearLayout18 != null) {
                                                                                                                                                                                                i = R.id.myTest;
                                                                                                                                                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.myTest);
                                                                                                                                                                                                if (cardView2 != null) {
                                                                                                                                                                                                    i = R.id.my_TestGone;
                                                                                                                                                                                                    LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_TestGone);
                                                                                                                                                                                                    if (linearLayout19 != null) {
                                                                                                                                                                                                        i = R.id.no_data;
                                                                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                                                            i = R.id.no_data_found_RL_1;
                                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL_1);
                                                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                                                i = R.id.notificaionCount;
                                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                                    i = R.id.notificaionCount1;
                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                        i = R.id.notificationIV;
                                                                                                                                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                                                                                                                                                                                                        if (imageView9 != null) {
                                                                                                                                                                                                                            i = R.id.notificationLL;
                                                                                                                                                                                                                            RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                                                                                                                                                                                                            if (relativeLayout11 != null) {
                                                                                                                                                                                                                                i = R.id.profile_image;
                                                                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                                                    i = R.id.profileLL;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                                        i = R.id.progressBar;
                                                                                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                                                                                            i = R.id.pullto_referesh;
                                                                                                                                                                                                                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                                                                                                                                                                                            if (swipeRefreshLayout != null) {
                                                                                                                                                                                                                                                i = R.id.rl1;
                                                                                                                                                                                                                                                RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                                                                                                                                                                                                                                if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                    i = R.id.scrollView;
                                                                                                                                                                                                                                                    StickyScrollView stickyScrollView = (StickyScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                                                                                                                                                    if (stickyScrollView != null) {
                                                                                                                                                                                                                                                        i = R.id.searchIV;
                                                                                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                                                                                            i = R.id.sliderViewPager;
                                                                                                                                                                                                                                                            ViewPager2 viewPager22 = (ViewPager2) ViewBindings.findChildViewById(rootView, R.id.sliderViewPager);
                                                                                                                                                                                                                                                            if (viewPager22 != null) {
                                                                                                                                                                                                                                                                i = R.id.testLL;
                                                                                                                                                                                                                                                                LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                                                                                                                                                if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                    i = R.id.tileRv;
                                                                                                                                                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                        i = R.id.tile_tv;
                                                                                                                                                                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tile_tv);
                                                                                                                                                                                                                                                                        if (textView8 != null) {
                                                                                                                                                                                                                                                                            i = R.id.title;
                                                                                                                                                                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                                                                            if (textView9 != null) {
                                                                                                                                                                                                                                                                                i = R.id.title_ll;
                                                                                                                                                                                                                                                                                LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                                                                                                                                                                                                                                                if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.titleTest;
                                                                                                                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleTest);
                                                                                                                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.titleinnerRL;
                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.toolbartitleTV;
                                                                                                                                                                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                                                                                                                                                                                                            if (textView11 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.viewPagerRL;
                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.vodView;
                                                                                                                                                                                                                                                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                                                                                                                        return new AppBarDashboard7Binding((RelativeLayout) rootView, linearLayout, relativeLayout, imageView, recyclerView, dynamicBottomBarBindingBind, viewPager2, relativeLayout2, linearLayout2, imageView2, imageButton, recyclerView2, linearLayout3, linearLayout4, linearLayout5, textView, textView2, imageView3, imageView4, relativeLayout3, toolbar, relativeLayout4, textView3, relativeLayout5, textView4, relativeLayout6, imageView5, linearLayout6, imageView6, imageView7, imageView8, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, relativeLayout7, relativeLayout8, linearLayout14, linearLayout15, relativeLayout9, linearLayout16, linearLayout17, cardView, linearLayout18, cardView2, linearLayout19, textView5, relativeLayout10, textView6, textView7, imageView9, relativeLayout11, imageView10, relativeLayout12, progressBar, swipeRefreshLayout, relativeLayout13, stickyScrollView, imageView11, viewPager22, linearLayout20, recyclerView3, textView8, textView9, linearLayout21, textView10, relativeLayout14, textView11, relativeLayout15, viewFindChildViewById2);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
