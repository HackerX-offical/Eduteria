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
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityProfileTheme8Binding implements ViewBinding {
    public final RecyclerView ProfileRV;
    public final RecyclerView ProfileRV1;
    public final TextView activeSinceTV;
    public final LinearLayout allMainLL;
    public final TextView appVersionTv;
    public final Button btnLogout;
    public final RelativeLayout changeLang;
    public final CollapsingToolbarLayout collapseToolbar;
    public final RelativeLayout collapseToolbarRL;
    public final CardView cvInfo;
    public final ImageView downarrowIV;
    public final TextView emailTV;
    public final TextView errorTV;
    public final TextView errorTVIBT;
    public final TextView examsCategoryTV;
    public final Button expertBtn;
    public final Button followBtn;
    public final Button followBtn1;
    public final LinearLayout followersLL;
    public final TextView followersTV;
    public final TextView followersTV1;
    public final TextView followertxt;
    public final LinearLayout followingLL;
    public final TextView followingTV;
    public final TextView followingTV1;
    public final TextView followingtxt;
    public final LinearLayout helpLL;
    public final LinearLayout horizontalLL;
    public final RelativeLayout ibtProfileToolbar;
    public final TextView ibtSettingsTvChangeLang;
    public final TextView ibtSettingsTvLang;
    public final TextView ibtToolbarNext;
    public final ImageView imageBack;
    public final FrameLayout imageFL;
    public final TextView interestedcoursesTV;
    public final ImageView ivLanguage;
    public final TextView likeText;
    public final TextView likesTV;
    public final LinearLayout ll1;
    public final LinearLayout ll2;
    public final AppBarLayout mainAppbar;
    public final CoordinatorLayout mainContent;
    public final TextView mainTextviewTitle;
    public final TextView mainTextviewTitle1;
    public final Toolbar mainToolbar;
    public final Toolbar mainToolbar1;
    public final CardView myCourseCv;
    public final LinearLayout myLL;
    public final CardView myNotesCv;
    public final CardView myOrderCv;
    public final RelativeLayout myProfileOptionsRL;
    public final LinearLayout otherLL;
    public final LinearLayout parentLayout;
    public final LinearLayout policyLL;
    public final TextView postTV;
    public final LinearLayout profileCheatNotesLL;
    public final LayoutErrorMessageBinding profileErrLayout;
    public final LinearLayout profileExamSelectionLL;
    public final RecyclerView profileFeedsRL;
    public final CircleImageView profileImage;
    public final CircleImageView profileImage1;
    public final ImageView profileImageText;
    public final RelativeLayout profileLL;
    public final NestedScrollView profileMain;
    public final CardView profileMmeMoneyCv;
    public final CardView profileMyActivityCv;
    public final TextView profileName;
    public final TextView profileName1;
    public final LinearLayout profileResetPassword;
    public final ImageView profileUploadImage;
    private final RelativeLayout rootView;
    public final LinearLayout shareAppLayout;
    public final LinearLayout specialisationLLL;
    public final TextView title;
    public final RelativeLayout titleRL;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbarsubtitleTV;

    private ActivityProfileTheme8Binding(RelativeLayout rootView, RecyclerView ProfileRV, RecyclerView ProfileRV1, TextView activeSinceTV, LinearLayout allMainLL, TextView appVersionTv, Button btnLogout, RelativeLayout changeLang, CollapsingToolbarLayout collapseToolbar, RelativeLayout collapseToolbarRL, CardView cvInfo, ImageView downarrowIV, TextView emailTV, TextView errorTV, TextView errorTVIBT, TextView examsCategoryTV, Button expertBtn, Button followBtn, Button followBtn1, LinearLayout followersLL, TextView followersTV, TextView followersTV1, TextView followertxt, LinearLayout followingLL, TextView followingTV, TextView followingTV1, TextView followingtxt, LinearLayout helpLL, LinearLayout horizontalLL, RelativeLayout ibtProfileToolbar, TextView ibtSettingsTvChangeLang, TextView ibtSettingsTvLang, TextView ibtToolbarNext, ImageView imageBack, FrameLayout imageFL, TextView interestedcoursesTV, ImageView ivLanguage, TextView likeText, TextView likesTV, LinearLayout ll1, LinearLayout ll2, AppBarLayout mainAppbar, CoordinatorLayout mainContent, TextView mainTextviewTitle, TextView mainTextviewTitle1, Toolbar mainToolbar, Toolbar mainToolbar1, CardView myCourseCv, LinearLayout myLL, CardView myNotesCv, CardView myOrderCv, RelativeLayout myProfileOptionsRL, LinearLayout otherLL, LinearLayout parentLayout, LinearLayout policyLL, TextView postTV, LinearLayout profileCheatNotesLL, LayoutErrorMessageBinding profileErrLayout, LinearLayout profileExamSelectionLL, RecyclerView profileFeedsRL, CircleImageView profileImage, CircleImageView profileImage1, ImageView profileImageText, RelativeLayout profileLL, NestedScrollView profileMain, CardView profileMmeMoneyCv, CardView profileMyActivityCv, TextView profileName, TextView profileName1, LinearLayout profileResetPassword, ImageView profileUploadImage, LinearLayout shareAppLayout, LinearLayout specialisationLLL, TextView title, RelativeLayout titleRL, RelativeLayout titleinnerRL, TextView toolbarsubtitleTV) {
        this.rootView = rootView;
        this.ProfileRV = ProfileRV;
        this.ProfileRV1 = ProfileRV1;
        this.activeSinceTV = activeSinceTV;
        this.allMainLL = allMainLL;
        this.appVersionTv = appVersionTv;
        this.btnLogout = btnLogout;
        this.changeLang = changeLang;
        this.collapseToolbar = collapseToolbar;
        this.collapseToolbarRL = collapseToolbarRL;
        this.cvInfo = cvInfo;
        this.downarrowIV = downarrowIV;
        this.emailTV = emailTV;
        this.errorTV = errorTV;
        this.errorTVIBT = errorTVIBT;
        this.examsCategoryTV = examsCategoryTV;
        this.expertBtn = expertBtn;
        this.followBtn = followBtn;
        this.followBtn1 = followBtn1;
        this.followersLL = followersLL;
        this.followersTV = followersTV;
        this.followersTV1 = followersTV1;
        this.followertxt = followertxt;
        this.followingLL = followingLL;
        this.followingTV = followingTV;
        this.followingTV1 = followingTV1;
        this.followingtxt = followingtxt;
        this.helpLL = helpLL;
        this.horizontalLL = horizontalLL;
        this.ibtProfileToolbar = ibtProfileToolbar;
        this.ibtSettingsTvChangeLang = ibtSettingsTvChangeLang;
        this.ibtSettingsTvLang = ibtSettingsTvLang;
        this.ibtToolbarNext = ibtToolbarNext;
        this.imageBack = imageBack;
        this.imageFL = imageFL;
        this.interestedcoursesTV = interestedcoursesTV;
        this.ivLanguage = ivLanguage;
        this.likeText = likeText;
        this.likesTV = likesTV;
        this.ll1 = ll1;
        this.ll2 = ll2;
        this.mainAppbar = mainAppbar;
        this.mainContent = mainContent;
        this.mainTextviewTitle = mainTextviewTitle;
        this.mainTextviewTitle1 = mainTextviewTitle1;
        this.mainToolbar = mainToolbar;
        this.mainToolbar1 = mainToolbar1;
        this.myCourseCv = myCourseCv;
        this.myLL = myLL;
        this.myNotesCv = myNotesCv;
        this.myOrderCv = myOrderCv;
        this.myProfileOptionsRL = myProfileOptionsRL;
        this.otherLL = otherLL;
        this.parentLayout = parentLayout;
        this.policyLL = policyLL;
        this.postTV = postTV;
        this.profileCheatNotesLL = profileCheatNotesLL;
        this.profileErrLayout = profileErrLayout;
        this.profileExamSelectionLL = profileExamSelectionLL;
        this.profileFeedsRL = profileFeedsRL;
        this.profileImage = profileImage;
        this.profileImage1 = profileImage1;
        this.profileImageText = profileImageText;
        this.profileLL = profileLL;
        this.profileMain = profileMain;
        this.profileMmeMoneyCv = profileMmeMoneyCv;
        this.profileMyActivityCv = profileMyActivityCv;
        this.profileName = profileName;
        this.profileName1 = profileName1;
        this.profileResetPassword = profileResetPassword;
        this.profileUploadImage = profileUploadImage;
        this.shareAppLayout = shareAppLayout;
        this.specialisationLLL = specialisationLLL;
        this.title = title;
        this.titleRL = titleRL;
        this.titleinnerRL = titleinnerRL;
        this.toolbarsubtitleTV = toolbarsubtitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityProfileTheme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityProfileTheme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_profile_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityProfileTheme8Binding bind(View rootView) {
        int i = R.id.ProfileRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.ProfileRV);
        if (recyclerView != null) {
            i = R.id.ProfileRV1;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.ProfileRV1);
            if (recyclerView2 != null) {
                i = R.id.active_sinceTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.active_sinceTV);
                if (textView != null) {
                    i = R.id.allMainLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.allMainLL);
                    if (linearLayout != null) {
                        i = R.id.app_version_tv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.app_version_tv);
                        if (textView2 != null) {
                            i = R.id.btn_logout;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_logout);
                            if (button != null) {
                                i = R.id.changeLang;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.changeLang);
                                if (relativeLayout != null) {
                                    i = R.id.collapse_toolbar;
                                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(rootView, R.id.collapse_toolbar);
                                    if (collapsingToolbarLayout != null) {
                                        i = R.id.collapse_toolbar_RL;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.collapse_toolbar_RL);
                                        if (relativeLayout2 != null) {
                                            i = R.id.cv_info;
                                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cv_info);
                                            if (cardView != null) {
                                                i = R.id.downarrowIV;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                if (imageView != null) {
                                                    i = R.id.emailTV;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                                    if (textView3 != null) {
                                                        i = R.id.errorTV;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTV);
                                                        if (textView4 != null) {
                                                            i = R.id.errorTVIBT;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTVIBT);
                                                            if (textView5 != null) {
                                                                i = R.id.examsCategoryTV;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.examsCategoryTV);
                                                                if (textView6 != null) {
                                                                    i = R.id.expertBtn;
                                                                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.expertBtn);
                                                                    if (button2 != null) {
                                                                        i = R.id.followBtn;
                                                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.followBtn);
                                                                        if (button3 != null) {
                                                                            i = R.id.followBtn1;
                                                                            Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.followBtn1);
                                                                            if (button4 != null) {
                                                                                i = R.id.followersLL;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.followersLL);
                                                                                if (linearLayout2 != null) {
                                                                                    i = R.id.followersTV;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followersTV);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.followersTV1;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followersTV1);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.followertxt;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followertxt);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.followingLL;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.followingLL);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i = R.id.followingTV;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followingTV);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.followingTV1;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followingTV1);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.followingtxt;
                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.followingtxt);
                                                                                                            if (textView12 != null) {
                                                                                                                i = R.id.help_LL;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.help_LL);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i = R.id.horizontalLL;
                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.horizontalLL);
                                                                                                                    if (linearLayout5 != null) {
                                                                                                                        i = R.id.ibt_profile_toolbar;
                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ibt_profile_toolbar);
                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                            i = R.id.ibt_settings_tv_change_lang;
                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_settings_tv_change_lang);
                                                                                                                            if (textView13 != null) {
                                                                                                                                i = R.id.ibt_settings_tv_lang;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_settings_tv_lang);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    i = R.id.ibt_toolbar_next;
                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_toolbar_next);
                                                                                                                                    if (textView15 != null) {
                                                                                                                                        i = R.id.image_back;
                                                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                                                                                                                        if (imageView2 != null) {
                                                                                                                                            i = R.id.imageFL;
                                                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.imageFL);
                                                                                                                                            if (frameLayout != null) {
                                                                                                                                                i = R.id.interestedcoursesTV;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.interestedcoursesTV);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.iv_language;
                                                                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_language);
                                                                                                                                                    if (imageView3 != null) {
                                                                                                                                                        i = R.id.likeText;
                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.likeText);
                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                            i = R.id.likesTV;
                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.likesTV);
                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                i = R.id.ll_1;
                                                                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_1);
                                                                                                                                                                if (linearLayout6 != null) {
                                                                                                                                                                    i = R.id.ll_2;
                                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_2);
                                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                                        i = R.id.main_appbar;
                                                                                                                                                                        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.main_appbar);
                                                                                                                                                                        if (appBarLayout != null) {
                                                                                                                                                                            i = R.id.main_content;
                                                                                                                                                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(rootView, R.id.main_content);
                                                                                                                                                                            if (coordinatorLayout != null) {
                                                                                                                                                                                i = R.id.main_textview_title;
                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.main_textview_title);
                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                    i = R.id.main_textview_title1;
                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.main_textview_title1);
                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                        i = R.id.main_toolbar;
                                                                                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                                                                                                                                        if (toolbar != null) {
                                                                                                                                                                                            i = R.id.main_toolbar1;
                                                                                                                                                                                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar1);
                                                                                                                                                                                            if (toolbar2 != null) {
                                                                                                                                                                                                i = R.id.myCourse_cv;
                                                                                                                                                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.myCourse_cv);
                                                                                                                                                                                                if (cardView2 != null) {
                                                                                                                                                                                                    i = R.id.myLL;
                                                                                                                                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.myLL);
                                                                                                                                                                                                    if (linearLayout8 != null) {
                                                                                                                                                                                                        i = R.id.myNotes_cv;
                                                                                                                                                                                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.myNotes_cv);
                                                                                                                                                                                                        if (cardView3 != null) {
                                                                                                                                                                                                            i = R.id.myOrder_cv;
                                                                                                                                                                                                            CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, R.id.myOrder_cv);
                                                                                                                                                                                                            if (cardView4 != null) {
                                                                                                                                                                                                                i = R.id.my_profile_options_RL;
                                                                                                                                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.my_profile_options_RL);
                                                                                                                                                                                                                if (relativeLayout4 != null) {
                                                                                                                                                                                                                    i = R.id.otherLL;
                                                                                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.otherLL);
                                                                                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                                                                                        i = R.id.parent_layout;
                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parent_layout);
                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                            i = R.id.policy_LL;
                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.policy_LL);
                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                i = R.id.postTV;
                                                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.postTV);
                                                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                                                    i = R.id.profile_cheatNotes_LL;
                                                                                                                                                                                                                                    LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.profile_cheatNotes_LL);
                                                                                                                                                                                                                                    if (linearLayout12 != null) {
                                                                                                                                                                                                                                        i = R.id.profile_err_layout;
                                                                                                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.profile_err_layout);
                                                                                                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                                                                                                            LayoutErrorMessageBinding layoutErrorMessageBindingBind = LayoutErrorMessageBinding.bind(viewFindChildViewById);
                                                                                                                                                                                                                                            i = R.id.profile_exam_selection_LL;
                                                                                                                                                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.profile_exam_selection_LL);
                                                                                                                                                                                                                                            if (linearLayout13 != null) {
                                                                                                                                                                                                                                                i = R.id.profile_feedsRL;
                                                                                                                                                                                                                                                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.profile_feedsRL);
                                                                                                                                                                                                                                                if (recyclerView3 != null) {
                                                                                                                                                                                                                                                    i = R.id.profileImage;
                                                                                                                                                                                                                                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                                                                                                                                                                                                                    if (circleImageView != null) {
                                                                                                                                                                                                                                                        i = R.id.profileImage1;
                                                                                                                                                                                                                                                        CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage1);
                                                                                                                                                                                                                                                        if (circleImageView2 != null) {
                                                                                                                                                                                                                                                            i = R.id.profileImageText;
                                                                                                                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageText);
                                                                                                                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                                                                                                                i = R.id.profileLL;
                                                                                                                                                                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                                                                                                                if (relativeLayout5 != null) {
                                                                                                                                                                                                                                                                    i = R.id.profile_main;
                                                                                                                                                                                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.profile_main);
                                                                                                                                                                                                                                                                    if (nestedScrollView != null) {
                                                                                                                                                                                                                                                                        i = R.id.profile_mme_money_cv;
                                                                                                                                                                                                                                                                        CardView cardView5 = (CardView) ViewBindings.findChildViewById(rootView, R.id.profile_mme_money_cv);
                                                                                                                                                                                                                                                                        if (cardView5 != null) {
                                                                                                                                                                                                                                                                            i = R.id.profile_my_activity_cv;
                                                                                                                                                                                                                                                                            CardView cardView6 = (CardView) ViewBindings.findChildViewById(rootView, R.id.profile_my_activity_cv);
                                                                                                                                                                                                                                                                            if (cardView6 != null) {
                                                                                                                                                                                                                                                                                i = R.id.profileName;
                                                                                                                                                                                                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileName);
                                                                                                                                                                                                                                                                                if (textView22 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.profileName1;
                                                                                                                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileName1);
                                                                                                                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.profile_reset_password;
                                                                                                                                                                                                                                                                                        LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.profile_reset_password);
                                                                                                                                                                                                                                                                                        if (linearLayout14 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.profile_upload_Image;
                                                                                                                                                                                                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_upload_Image);
                                                                                                                                                                                                                                                                                            if (imageView5 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.share_app_layout;
                                                                                                                                                                                                                                                                                                LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.share_app_layout);
                                                                                                                                                                                                                                                                                                if (linearLayout15 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.specialisationLLL;
                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.specialisationLLL);
                                                                                                                                                                                                                                                                                                    if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.title;
                                                                                                                                                                                                                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                                                                                                                                                                                        if (textView24 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.titleRL;
                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleRL);
                                                                                                                                                                                                                                                                                                            if (relativeLayout6 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.titleinnerRL;
                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                                                                                                                                                                                if (relativeLayout7 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.toolbarsubtitleTV;
                                                                                                                                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarsubtitleTV);
                                                                                                                                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                                                                                                                                        return new ActivityProfileTheme8Binding((RelativeLayout) rootView, recyclerView, recyclerView2, textView, linearLayout, textView2, button, relativeLayout, collapsingToolbarLayout, relativeLayout2, cardView, imageView, textView3, textView4, textView5, textView6, button2, button3, button4, linearLayout2, textView7, textView8, textView9, linearLayout3, textView10, textView11, textView12, linearLayout4, linearLayout5, relativeLayout3, textView13, textView14, textView15, imageView2, frameLayout, textView16, imageView3, textView17, textView18, linearLayout6, linearLayout7, appBarLayout, coordinatorLayout, textView19, textView20, toolbar, toolbar2, cardView2, linearLayout8, cardView3, cardView4, relativeLayout4, linearLayout9, linearLayout10, linearLayout11, textView21, linearLayout12, layoutErrorMessageBindingBind, linearLayout13, recyclerView3, circleImageView, circleImageView2, imageView4, relativeLayout5, nestedScrollView, cardView5, cardView6, textView22, textView23, linearLayout14, imageView5, linearLayout15, linearLayout16, textView24, relativeLayout6, relativeLayout7, textView25);
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
