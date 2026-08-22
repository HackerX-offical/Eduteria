package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.pendingPurchase.PendingPurchaseBanner;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboardBinding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RecyclerView CourseListRV;
    public final RelativeLayout RL1P;
    public final RelativeLayout RlQuestionTitle;
    public final TextView addStdFeedback;
    public final RecyclerView bannerSlider;
    public final AutoSliderPageLayoutBinding bannerSliderLayout;
    public final AutoSliderPageLayoutBinding bannerSliderLayout1;
    public final DynamicBottomBarBinding bottomMenu;
    public final AutoSliderPageLayoutBinding bottomSliderLayout;
    public final ConstraintLayout bottomViewPagerRL;
    public final TextView cartCount;
    public final LinearLayout cartLL;
    public final CardView chatSupportHere;
    public final RelativeLayout chatSupportRel;
    public final ConstraintLayout consLay;
    public final LinearLayout contactUsLL;
    public final FrameLayout container;
    public final RelativeLayout cvrHeaderKrantikari;
    public final LinearLayout cvrNotificationCount;
    public final LinearLayout cvrNotificationCount1;
    public final Toolbar dashboardToolbar;
    public final LinearLayout educatorListLL;
    public final LinearLayout educatorsLiveClassLay;
    public final RecyclerView emiRecyclerView;
    public final LinearLayout emiView;
    public final RelativeLayout feedsLl;
    public final LinearLayout followLinear;
    public final ImageView gotoCart;
    public final LinearLayout greetingMsgLL;
    public final TextView greetingMsgTV;
    public final ImageView headerImg;
    public final RelativeLayout headerRL;
    public final ImageView homeBackIV;
    public final LinearLayout homeLL;
    public final ImageView iconFacebook1;
    public final ImageView iconInstagram1;
    public final ImageView iconLinkedIn1;
    public final ImageView iconTelegram1;
    public final ImageView iconTwitter1;
    public final ImageView iconWebsite1;
    public final ImageView iconWhatsapp1;
    public final ImageView iconYoutube1;
    public final ImageView image;
    public final LinearLayout libLL;
    public final LinearLayout linearGotoCart;
    public final RecyclerView liveClassesRecyclerView;
    public final TextView liveTestTV;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetestLL;
    public final LinearLayout llDailyQuestion;
    public final ImageView mailIcon1;
    public final LinearLayout myLibrary;
    public final CardView myLibraryCV;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL1;
    public final TextView notificaionCount;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final RelativeLayout otherMainLayout;
    public final RecyclerView ourEducatorsRecyclerView;
    public final PendingPurchaseBanner pendingBanner;
    public final ImageView phoneIcon1;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ImageView quesIV;
    public final TextView questionExplanation;
    public final TextView questionExplanationHint;
    public final TextView questionTitleTxt;
    public final TextView questionTxt;
    public final TextView readMore;
    public final RelativeLayout relativeGotoCart;
    public final AutoSliderPageLayoutBinding reviewBannerSlider;
    public final CardView reviewCard;
    public final LinearLayout reviewLinear;
    public final TextView reviewTV;
    public final RelativeLayout rlAnnounce;
    public final RelativeLayout rlRecentWatch;
    private final RelativeLayout rootView;
    public final RecyclerView rvQuestionOption;
    public final RecyclerView rvRecentActivity;
    public final NestedScrollView scrollView;
    public final ImageView searchIcon;
    public final LinearLayout socialIconLL1;
    public final HorizontalScrollView socialIconLLScroll1;
    public final RecyclerView socialIconRecyclerView;
    public final RecyclerView studentFeedbackRecyclerView;
    public final RecyclerView tabsRV;
    public final LinearLayout testLL;
    public final LinearLayout testimonialLL;
    public final RelativeLayout toolbarLogo;
    public final LinearLayout topLayout;
    public final LinearLayout trendingCourseLL;
    public final RecyclerView trendingCourseRecyclerView;
    public final TextView tvMyLibrary;
    public final TextView tvRecentAct;
    public final TextView viewAllClasses;
    public final ConstraintLayout viewPagerRL;
    public final View vodView;
    public final ImageView whatsappIcon;

    private AppBarDashboardBinding(RelativeLayout rootView, LinearLayout CourseLL, RecyclerView CourseListRV, RelativeLayout RL1P, RelativeLayout RlQuestionTitle, TextView addStdFeedback, RecyclerView bannerSlider, AutoSliderPageLayoutBinding bannerSliderLayout, AutoSliderPageLayoutBinding bannerSliderLayout1, DynamicBottomBarBinding bottomMenu, AutoSliderPageLayoutBinding bottomSliderLayout, ConstraintLayout bottomViewPagerRL, TextView cartCount, LinearLayout cartLL, CardView chatSupportHere, RelativeLayout chatSupportRel, ConstraintLayout consLay, LinearLayout contactUsLL, FrameLayout container, RelativeLayout cvrHeaderKrantikari, LinearLayout cvrNotificationCount, LinearLayout cvrNotificationCount1, Toolbar dashboardToolbar, LinearLayout educatorListLL, LinearLayout educatorsLiveClassLay, RecyclerView emiRecyclerView, LinearLayout emiView, RelativeLayout feedsLl, LinearLayout followLinear, ImageView gotoCart, LinearLayout greetingMsgLL, TextView greetingMsgTV, ImageView headerImg, RelativeLayout headerRL, ImageView homeBackIV, LinearLayout homeLL, ImageView iconFacebook1, ImageView iconInstagram1, ImageView iconLinkedIn1, ImageView iconTelegram1, ImageView iconTwitter1, ImageView iconWebsite1, ImageView iconWhatsapp1, ImageView iconYoutube1, ImageView image, LinearLayout libLL, LinearLayout linearGotoCart, RecyclerView liveClassesRecyclerView, TextView liveTestTV, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetestLL, LinearLayout llDailyQuestion, ImageView mailIcon1, LinearLayout myLibrary, CardView myLibraryCV, TextView noData, RelativeLayout noDataFoundRL1, TextView notificaionCount, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, RelativeLayout otherMainLayout, RecyclerView ourEducatorsRecyclerView, PendingPurchaseBanner pendingBanner, ImageView phoneIcon1, ImageView profileImage, RelativeLayout profileLL, ImageView quesIV, TextView questionExplanation, TextView questionExplanationHint, TextView questionTitleTxt, TextView questionTxt, TextView readMore, RelativeLayout relativeGotoCart, AutoSliderPageLayoutBinding reviewBannerSlider, CardView reviewCard, LinearLayout reviewLinear, TextView reviewTV, RelativeLayout rlAnnounce, RelativeLayout rlRecentWatch, RecyclerView rvQuestionOption, RecyclerView rvRecentActivity, NestedScrollView scrollView, ImageView searchIcon, LinearLayout socialIconLL1, HorizontalScrollView socialIconLLScroll1, RecyclerView socialIconRecyclerView, RecyclerView studentFeedbackRecyclerView, RecyclerView tabsRV, LinearLayout testLL, LinearLayout testimonialLL, RelativeLayout toolbarLogo, LinearLayout topLayout, LinearLayout trendingCourseLL, RecyclerView trendingCourseRecyclerView, TextView tvMyLibrary, TextView tvRecentAct, TextView viewAllClasses, ConstraintLayout viewPagerRL, View vodView, ImageView whatsappIcon) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.CourseListRV = CourseListRV;
        this.RL1P = RL1P;
        this.RlQuestionTitle = RlQuestionTitle;
        this.addStdFeedback = addStdFeedback;
        this.bannerSlider = bannerSlider;
        this.bannerSliderLayout = bannerSliderLayout;
        this.bannerSliderLayout1 = bannerSliderLayout1;
        this.bottomMenu = bottomMenu;
        this.bottomSliderLayout = bottomSliderLayout;
        this.bottomViewPagerRL = bottomViewPagerRL;
        this.cartCount = cartCount;
        this.cartLL = cartLL;
        this.chatSupportHere = chatSupportHere;
        this.chatSupportRel = chatSupportRel;
        this.consLay = consLay;
        this.contactUsLL = contactUsLL;
        this.container = container;
        this.cvrHeaderKrantikari = cvrHeaderKrantikari;
        this.cvrNotificationCount = cvrNotificationCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.dashboardToolbar = dashboardToolbar;
        this.educatorListLL = educatorListLL;
        this.educatorsLiveClassLay = educatorsLiveClassLay;
        this.emiRecyclerView = emiRecyclerView;
        this.emiView = emiView;
        this.feedsLl = feedsLl;
        this.followLinear = followLinear;
        this.gotoCart = gotoCart;
        this.greetingMsgLL = greetingMsgLL;
        this.greetingMsgTV = greetingMsgTV;
        this.headerImg = headerImg;
        this.headerRL = headerRL;
        this.homeBackIV = homeBackIV;
        this.homeLL = homeLL;
        this.iconFacebook1 = iconFacebook1;
        this.iconInstagram1 = iconInstagram1;
        this.iconLinkedIn1 = iconLinkedIn1;
        this.iconTelegram1 = iconTelegram1;
        this.iconTwitter1 = iconTwitter1;
        this.iconWebsite1 = iconWebsite1;
        this.iconWhatsapp1 = iconWhatsapp1;
        this.iconYoutube1 = iconYoutube1;
        this.image = image;
        this.libLL = libLL;
        this.linearGotoCart = linearGotoCart;
        this.liveClassesRecyclerView = liveClassesRecyclerView;
        this.liveTestTV = liveTestTV;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetestLL = livetestLL;
        this.llDailyQuestion = llDailyQuestion;
        this.mailIcon1 = mailIcon1;
        this.myLibrary = myLibrary;
        this.myLibraryCV = myLibraryCV;
        this.noData = noData;
        this.noDataFoundRL1 = noDataFoundRL1;
        this.notificaionCount = notificaionCount;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.otherMainLayout = otherMainLayout;
        this.ourEducatorsRecyclerView = ourEducatorsRecyclerView;
        this.pendingBanner = pendingBanner;
        this.phoneIcon1 = phoneIcon1;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.quesIV = quesIV;
        this.questionExplanation = questionExplanation;
        this.questionExplanationHint = questionExplanationHint;
        this.questionTitleTxt = questionTitleTxt;
        this.questionTxt = questionTxt;
        this.readMore = readMore;
        this.relativeGotoCart = relativeGotoCart;
        this.reviewBannerSlider = reviewBannerSlider;
        this.reviewCard = reviewCard;
        this.reviewLinear = reviewLinear;
        this.reviewTV = reviewTV;
        this.rlAnnounce = rlAnnounce;
        this.rlRecentWatch = rlRecentWatch;
        this.rvQuestionOption = rvQuestionOption;
        this.rvRecentActivity = rvRecentActivity;
        this.scrollView = scrollView;
        this.searchIcon = searchIcon;
        this.socialIconLL1 = socialIconLL1;
        this.socialIconLLScroll1 = socialIconLLScroll1;
        this.socialIconRecyclerView = socialIconRecyclerView;
        this.studentFeedbackRecyclerView = studentFeedbackRecyclerView;
        this.tabsRV = tabsRV;
        this.testLL = testLL;
        this.testimonialLL = testimonialLL;
        this.toolbarLogo = toolbarLogo;
        this.topLayout = topLayout;
        this.trendingCourseLL = trendingCourseLL;
        this.trendingCourseRecyclerView = trendingCourseRecyclerView;
        this.tvMyLibrary = tvMyLibrary;
        this.tvRecentAct = tvRecentAct;
        this.viewAllClasses = viewAllClasses;
        this.viewPagerRL = viewPagerRL;
        this.vodView = vodView;
        this.whatsappIcon = whatsappIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboardBinding bind(View rootView) {
        int i = R.id.CourseLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.CourseLL);
        if (linearLayout != null) {
            i = R.id.CourseListRV;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.CourseListRV);
            if (recyclerView != null) {
                i = R.id.RL1P;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
                if (relativeLayout != null) {
                    i = R.id._rl_question_title;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id._rl_question_title);
                    if (relativeLayout2 != null) {
                        i = R.id.addStdFeedback;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addStdFeedback);
                        if (textView != null) {
                            i = R.id.bannerSlider;
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.bannerSlider);
                            if (recyclerView2 != null) {
                                i = R.id.bannerSliderLayout;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bannerSliderLayout);
                                if (viewFindChildViewById != null) {
                                    AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind = AutoSliderPageLayoutBinding.bind(viewFindChildViewById);
                                    i = R.id.bannerSliderLayout1;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bannerSliderLayout1);
                                    if (viewFindChildViewById2 != null) {
                                        AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind2 = AutoSliderPageLayoutBinding.bind(viewFindChildViewById2);
                                        i = R.id.bottom_menu;
                                        View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                                        if (viewFindChildViewById3 != null) {
                                            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById3);
                                            i = R.id.bottomSliderLayout;
                                            View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.bottomSliderLayout);
                                            if (viewFindChildViewById4 != null) {
                                                AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind3 = AutoSliderPageLayoutBinding.bind(viewFindChildViewById4);
                                                i = R.id.bottomViewPagerRL;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.bottomViewPagerRL);
                                                if (constraintLayout != null) {
                                                    i = R.id.cart_count;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cart_count);
                                                    if (textView2 != null) {
                                                        i = R.id.cartLL;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.chat_support_here;
                                                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.chat_support_here);
                                                            if (cardView != null) {
                                                                i = R.id.chat_supportRel;
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.chat_supportRel);
                                                                if (relativeLayout3 != null) {
                                                                    i = R.id.cons_lay;
                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.cons_lay);
                                                                    if (constraintLayout2 != null) {
                                                                        i = R.id.contactUsLL;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.contactUsLL);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.container;
                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.container);
                                                                            if (frameLayout != null) {
                                                                                i = R.id.cvrHeaderKrantikari;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrHeaderKrantikari);
                                                                                if (relativeLayout4 != null) {
                                                                                    i = R.id.cvrNotificationCount;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.cvrNotificationCount1;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.dashboardToolbar;
                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.dashboardToolbar);
                                                                                            if (toolbar != null) {
                                                                                                i = R.id.educatorListLL;
                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.educatorListLL);
                                                                                                if (linearLayout6 != null) {
                                                                                                    i = R.id.educatorsLiveClassLay;
                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.educatorsLiveClassLay);
                                                                                                    if (linearLayout7 != null) {
                                                                                                        i = R.id.emiRecyclerView;
                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.emiRecyclerView);
                                                                                                        if (recyclerView3 != null) {
                                                                                                            i = R.id.emiView;
                                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emiView);
                                                                                                            if (linearLayout8 != null) {
                                                                                                                i = R.id.feeds_ll;
                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.feeds_ll);
                                                                                                                if (relativeLayout5 != null) {
                                                                                                                    i = R.id.followLinear;
                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.followLinear);
                                                                                                                    if (linearLayout9 != null) {
                                                                                                                        i = R.id.gotoCart;
                                                                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.gotoCart);
                                                                                                                        if (imageView != null) {
                                                                                                                            i = R.id.greetingMsgLL;
                                                                                                                            LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.greetingMsgLL);
                                                                                                                            if (linearLayout10 != null) {
                                                                                                                                i = R.id.greetingMsgTV;
                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.greetingMsgTV);
                                                                                                                                if (textView3 != null) {
                                                                                                                                    i = R.id.headerImg;
                                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.headerImg);
                                                                                                                                    if (imageView2 != null) {
                                                                                                                                        i = R.id.headerRL;
                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.headerRL);
                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                            i = R.id.homeBackIV;
                                                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                                                                                            if (imageView3 != null) {
                                                                                                                                                i = R.id.homeLL;
                                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                                    i = R.id.iconFacebook1;
                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconFacebook1);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i = R.id.iconInstagram1;
                                                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconInstagram1);
                                                                                                                                                        if (imageView5 != null) {
                                                                                                                                                            i = R.id.iconLinkedIn1;
                                                                                                                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconLinkedIn1);
                                                                                                                                                            if (imageView6 != null) {
                                                                                                                                                                i = R.id.iconTelegram1;
                                                                                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTelegram1);
                                                                                                                                                                if (imageView7 != null) {
                                                                                                                                                                    i = R.id.iconTwitter1;
                                                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTwitter1);
                                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                                        i = R.id.icon_website1;
                                                                                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.icon_website1);
                                                                                                                                                                        if (imageView9 != null) {
                                                                                                                                                                            i = R.id.iconWhatsapp1;
                                                                                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconWhatsapp1);
                                                                                                                                                                            if (imageView10 != null) {
                                                                                                                                                                                i = R.id.iconYoutube1;
                                                                                                                                                                                ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconYoutube1);
                                                                                                                                                                                if (imageView11 != null) {
                                                                                                                                                                                    i = R.id.image;
                                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                                        i = R.id.libLL;
                                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                                            i = R.id.linear_gotoCart;
                                                                                                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_gotoCart);
                                                                                                                                                                                            if (linearLayout13 != null) {
                                                                                                                                                                                                i = R.id.liveClassesRecyclerView;
                                                                                                                                                                                                RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.liveClassesRecyclerView);
                                                                                                                                                                                                if (recyclerView4 != null) {
                                                                                                                                                                                                    i = R.id.liveTestTV;
                                                                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveTestTV);
                                                                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                                                                        i = R.id.liveclass;
                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                            i = R.id.liveclassLL;
                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                i = R.id.livetest;
                                                                                                                                                                                                                LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                                                                                                                                                if (linearLayout16 != null) {
                                                                                                                                                                                                                    i = R.id.livetestLL;
                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                        i = R.id.ll_daily_question;
                                                                                                                                                                                                                        LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_daily_question);
                                                                                                                                                                                                                        if (linearLayout18 != null) {
                                                                                                                                                                                                                            i = R.id.mailIcon1;
                                                                                                                                                                                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.mailIcon1);
                                                                                                                                                                                                                            if (imageView13 != null) {
                                                                                                                                                                                                                                i = R.id.my_library;
                                                                                                                                                                                                                                LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                                                                                                                                                if (linearLayout19 != null) {
                                                                                                                                                                                                                                    i = R.id.myLibraryCV;
                                                                                                                                                                                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.myLibraryCV);
                                                                                                                                                                                                                                    if (cardView2 != null) {
                                                                                                                                                                                                                                        i = R.id.no_data;
                                                                                                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                                                                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                                                                                            i = R.id.no_data_found_RL_1;
                                                                                                                                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL_1);
                                                                                                                                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                                                                                                                                i = R.id.notificaionCount;
                                                                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                                                                    i = R.id.notificaionCount1;
                                                                                                                                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                                                                                                                                                                                                                                    if (textView7 != null) {
                                                                                                                                                                                                                                                        i = R.id.notificationIV;
                                                                                                                                                                                                                                                        ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                                                                                                                                                                                                                                        if (imageView14 != null) {
                                                                                                                                                                                                                                                            i = R.id.notificationLL;
                                                                                                                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                                                                                                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                                                                                                                i = R.id.otherMainLayout;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.otherMainLayout);
                                                                                                                                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                                                                                                                                    i = R.id.ourEducatorsRecyclerView;
                                                                                                                                                                                                                                                                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.ourEducatorsRecyclerView);
                                                                                                                                                                                                                                                                    if (recyclerView5 != null) {
                                                                                                                                                                                                                                                                        i = R.id.pendingBanner;
                                                                                                                                                                                                                                                                        PendingPurchaseBanner pendingPurchaseBanner = (PendingPurchaseBanner) ViewBindings.findChildViewById(rootView, R.id.pendingBanner);
                                                                                                                                                                                                                                                                        if (pendingPurchaseBanner != null) {
                                                                                                                                                                                                                                                                            i = R.id.phoneIcon1;
                                                                                                                                                                                                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.phoneIcon1);
                                                                                                                                                                                                                                                                            if (imageView15 != null) {
                                                                                                                                                                                                                                                                                i = R.id.profile_image;
                                                                                                                                                                                                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                                                                                                                                                                                                if (imageView16 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.profileLL;
                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                                                                                                                                    if (relativeLayout10 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.quesIV;
                                                                                                                                                                                                                                                                                        ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quesIV);
                                                                                                                                                                                                                                                                                        if (imageView17 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.question_explanation;
                                                                                                                                                                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_explanation);
                                                                                                                                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.question_explanation_hint;
                                                                                                                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_explanation_hint);
                                                                                                                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.question_title_txt;
                                                                                                                                                                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_title_txt);
                                                                                                                                                                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.question_txt;
                                                                                                                                                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_txt);
                                                                                                                                                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.read_more;
                                                                                                                                                                                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_more);
                                                                                                                                                                                                                                                                                                            if (textView12 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.relative_gotoCart;
                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_gotoCart);
                                                                                                                                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.reviewBannerSlider;
                                                                                                                                                                                                                                                                                                                    View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.reviewBannerSlider);
                                                                                                                                                                                                                                                                                                                    if (viewFindChildViewById5 != null) {
                                                                                                                                                                                                                                                                                                                        AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind4 = AutoSliderPageLayoutBinding.bind(viewFindChildViewById5);
                                                                                                                                                                                                                                                                                                                        i = R.id.reviewCard;
                                                                                                                                                                                                                                                                                                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.reviewCard);
                                                                                                                                                                                                                                                                                                                        if (cardView3 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.reviewLinear;
                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.reviewLinear);
                                                                                                                                                                                                                                                                                                                            if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.reviewTV;
                                                                                                                                                                                                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.reviewTV);
                                                                                                                                                                                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.rlAnnounce;
                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlAnnounce);
                                                                                                                                                                                                                                                                                                                                    if (relativeLayout12 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.rl_recentWatch;
                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_recentWatch);
                                                                                                                                                                                                                                                                                                                                        if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.rv_question_option;
                                                                                                                                                                                                                                                                                                                                            RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rv_question_option);
                                                                                                                                                                                                                                                                                                                                            if (recyclerView6 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.rv_recent_activity;
                                                                                                                                                                                                                                                                                                                                                RecyclerView recyclerView7 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rv_recent_activity);
                                                                                                                                                                                                                                                                                                                                                if (recyclerView7 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.scrollView;
                                                                                                                                                                                                                                                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                                                                                                                                                                                                                                                    if (nestedScrollView != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.searchIcon;
                                                                                                                                                                                                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIcon);
                                                                                                                                                                                                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.socialIconLL1;
                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.socialIconLL1);
                                                                                                                                                                                                                                                                                                                                                            if (linearLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.socialIconLLScroll1;
                                                                                                                                                                                                                                                                                                                                                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(rootView, R.id.socialIconLLScroll1);
                                                                                                                                                                                                                                                                                                                                                                if (horizontalScrollView != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.socialIconRecyclerView;
                                                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView8 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.socialIconRecyclerView);
                                                                                                                                                                                                                                                                                                                                                                    if (recyclerView8 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.studentFeedbackRecyclerView;
                                                                                                                                                                                                                                                                                                                                                                        RecyclerView recyclerView9 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studentFeedbackRecyclerView);
                                                                                                                                                                                                                                                                                                                                                                        if (recyclerView9 != null) {
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.tabsRV;
                                                                                                                                                                                                                                                                                                                                                                            RecyclerView recyclerView10 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tabsRV);
                                                                                                                                                                                                                                                                                                                                                                            if (recyclerView10 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.testLL;
                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.testimonialLL;
                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testimonialLL);
                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.toolbar_logo;
                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.toolbar_logo);
                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.topLayout;
                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.topLayout);
                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.trending_courseLL;
                                                                                                                                                                                                                                                                                                                                                                                                LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.trending_courseLL);
                                                                                                                                                                                                                                                                                                                                                                                                if (linearLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.trendingCourseRecyclerView;
                                                                                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView11 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.trendingCourseRecyclerView);
                                                                                                                                                                                                                                                                                                                                                                                                    if (recyclerView11 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.tv_myLibrary;
                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_myLibrary);
                                                                                                                                                                                                                                                                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.tv_recent_act;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_recent_act);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.viewAllClasses;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewAllClasses);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.viewPagerRL;
                                                                                                                                                                                                                                                                                                                                                                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (constraintLayout3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.vodView;
                                                                                                                                                                                                                                                                                                                                                                                                                        View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (viewFindChildViewById6 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.whatsappIcon;
                                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.whatsappIcon);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                return new AppBarDashboardBinding((RelativeLayout) rootView, linearLayout, recyclerView, relativeLayout, relativeLayout2, textView, recyclerView2, autoSliderPageLayoutBindingBind, autoSliderPageLayoutBindingBind2, dynamicBottomBarBindingBind, autoSliderPageLayoutBindingBind3, constraintLayout, textView2, linearLayout2, cardView, relativeLayout3, constraintLayout2, linearLayout3, frameLayout, relativeLayout4, linearLayout4, linearLayout5, toolbar, linearLayout6, linearLayout7, recyclerView3, linearLayout8, relativeLayout5, linearLayout9, imageView, linearLayout10, textView3, imageView2, relativeLayout6, imageView3, linearLayout11, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, linearLayout12, linearLayout13, recyclerView4, textView4, linearLayout14, linearLayout15, linearLayout16, linearLayout17, linearLayout18, imageView13, linearLayout19, cardView2, textView5, relativeLayout7, textView6, textView7, imageView14, relativeLayout8, relativeLayout9, recyclerView5, pendingPurchaseBanner, imageView15, imageView16, relativeLayout10, imageView17, textView8, textView9, textView10, textView11, textView12, relativeLayout11, autoSliderPageLayoutBindingBind4, cardView3, linearLayout20, textView13, relativeLayout12, relativeLayout13, recyclerView6, recyclerView7, nestedScrollView, imageView18, linearLayout21, horizontalScrollView, recyclerView8, recyclerView9, recyclerView10, linearLayout22, linearLayout23, relativeLayout14, linearLayout24, linearLayout25, recyclerView11, textView14, textView15, textView16, constraintLayout3, viewFindChildViewById6, imageView19);
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
