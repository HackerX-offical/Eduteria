package com.appnew.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.databinding.ActivityAudioPlayerBindingImpl;
import com.appnew.android.databinding.ActivityAudioPlayerBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityAudioPlayerBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityChangeLanguageBindingImpl;
import com.appnew.android.databinding.ActivityChangeLanguageBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityChangeLanguageBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityFeedDetailsBindingImpl;
import com.appnew.android.databinding.ActivityFeedDetailsBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityFeedDetailsBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityFeedsBindingImpl;
import com.appnew.android.databinding.ActivityFeedsBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityFeedsBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityIntroBindingImpl;
import com.appnew.android.databinding.ActivityIntroBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityIntroBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityLoggedOutUserBindingImpl;
import com.appnew.android.databinding.ActivityLoggedOutUserBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityLoggedOutUserBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityMyBagBindingImpl;
import com.appnew.android.databinding.ActivityMyBagBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityMyBagBindingSw720dpImpl;
import com.appnew.android.databinding.ActivityTestBaseSscpatternBindingImpl;
import com.appnew.android.databinding.ActivityTestBaseSscpatternBindingSw600dpImpl;
import com.appnew.android.databinding.ActivityTestBaseSscpatternBindingSw720dpImpl;
import com.appnew.android.databinding.ArticleVmBindingImpl;
import com.appnew.android.databinding.ArticleVmBindingSw600dpImpl;
import com.appnew.android.databinding.ArticleVmBindingSw720dpImpl;
import com.appnew.android.databinding.AudioPostBindingImpl;
import com.appnew.android.databinding.AudioPostBindingSw600dpImpl;
import com.appnew.android.databinding.AudioPostBindingSw720dpImpl;
import com.appnew.android.databinding.BannerAdapterImageviewBindingImpl;
import com.appnew.android.databinding.BannerAdapterImageviewBindingSw600dpImpl;
import com.appnew.android.databinding.BannerAdapterImageviewBindingSw720dpImpl;
import com.appnew.android.databinding.BannerViewBindingImpl;
import com.appnew.android.databinding.BannerViewBindingSw600dpImpl;
import com.appnew.android.databinding.BannerViewBindingSw720dpImpl;
import com.appnew.android.databinding.BottomSheetPaymentLayoutBindingImpl;
import com.appnew.android.databinding.BottomSheetPaymentLayoutBindingSw600dpImpl;
import com.appnew.android.databinding.BottomSheetPaymentLayoutBindingSw720dpImpl;
import com.appnew.android.databinding.BottomSheetStreamYtBindingImpl;
import com.appnew.android.databinding.BottomSheetStreamYtBindingSw600dpImpl;
import com.appnew.android.databinding.BottomSheetStreamYtBindingSw720dpImpl;
import com.appnew.android.databinding.CartItemBookBindingImpl;
import com.appnew.android.databinding.CartItemBookBindingSw600dpImpl;
import com.appnew.android.databinding.CartItemBookBindingSw720dpImpl;
import com.appnew.android.databinding.CartItemBookGridBindingImpl;
import com.appnew.android.databinding.CartItemBookGridBindingSw600dpImpl;
import com.appnew.android.databinding.CartItemBookGridBindingSw720dpImpl;
import com.appnew.android.databinding.CommentAdapterBindingImpl;
import com.appnew.android.databinding.CommentAdapterBindingSw600dpImpl;
import com.appnew.android.databinding.CommentAdapterBindingSw720dpImpl;
import com.appnew.android.databinding.CustomSmeStudentlistBindingImpl;
import com.appnew.android.databinding.CustomSmeStudentlistBindingSw600dpImpl;
import com.appnew.android.databinding.CustomSmeStudentlistBindingSw720dpImpl;
import com.appnew.android.databinding.CustomSocialIconsBindingImpl;
import com.appnew.android.databinding.CustomSocialIconsBindingSw600dpImpl;
import com.appnew.android.databinding.CustomSocialIconsBindingSw720dpImpl;
import com.appnew.android.databinding.CustomStudentDoubtListBindingImpl;
import com.appnew.android.databinding.CustomStudentDoubtListBindingSw600dpImpl;
import com.appnew.android.databinding.CustomStudentDoubtListBindingSw720dpImpl;
import com.appnew.android.databinding.DialogAlertSimpleBindingImpl;
import com.appnew.android.databinding.DialogAlertSimpleBindingSw600dpImpl;
import com.appnew.android.databinding.DialogAlertSimpleBindingSw720dpImpl;
import com.appnew.android.databinding.DialogReportErrorBindingImpl;
import com.appnew.android.databinding.DialogReportErrorBindingSw600dpImpl;
import com.appnew.android.databinding.DialogReportErrorBindingSw720dpImpl;
import com.appnew.android.databinding.DownloadUrlBitrateBindingImpl;
import com.appnew.android.databinding.DownloadUrlBitrateBindingSw600dpImpl;
import com.appnew.android.databinding.DownloadUrlBitrateBindingSw720dpImpl;
import com.appnew.android.databinding.DownloadYoutubeBottomSheetBindingImpl;
import com.appnew.android.databinding.DownloadYoutubeBottomSheetBindingSw600dpImpl;
import com.appnew.android.databinding.DownloadYoutubeBottomSheetBindingSw720dpImpl;
import com.appnew.android.databinding.EnterFibLayoutBindingImpl;
import com.appnew.android.databinding.EnterFibLayoutBindingSw600dpImpl;
import com.appnew.android.databinding.EnterFibLayoutBindingSw720dpImpl;
import com.appnew.android.databinding.FeedLiveClassAdapterBindingImpl;
import com.appnew.android.databinding.FeedLiveClassAdapterBindingSw600dpImpl;
import com.appnew.android.databinding.FeedLiveClassAdapterBindingSw720dpImpl;
import com.appnew.android.databinding.FeedLiveTestAdapterBindingImpl;
import com.appnew.android.databinding.FeedLiveTestAdapterBindingSw600dpImpl;
import com.appnew.android.databinding.FeedLiveTestAdapterBindingSw720dpImpl;
import com.appnew.android.databinding.FragmentFeedsBindingImpl;
import com.appnew.android.databinding.FragmentFeedsBindingSw600dpImpl;
import com.appnew.android.databinding.FragmentFeedsBindingSw720dpImpl;
import com.appnew.android.databinding.Item11BindingImpl;
import com.appnew.android.databinding.Item11BindingSw600dpImpl;
import com.appnew.android.databinding.Item11BindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternInstructionTextBindingImpl;
import com.appnew.android.databinding.ItemSscPatternInstructionTextBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternInstructionTextBindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternNumBoxBindingImpl;
import com.appnew.android.databinding.ItemSscPatternNumBoxBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternNumBoxBindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternOptionBindingImpl;
import com.appnew.android.databinding.ItemSscPatternOptionBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternOptionBindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBindingImpl;
import com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternQuestionViewpagerBindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectPartBindingImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectPartBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectPartBindingSw720dpImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectTabBindingImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectTabBindingSw600dpImpl;
import com.appnew.android.databinding.ItemSscPatternSubjectTabBindingSw720dpImpl;
import com.appnew.android.databinding.ItemViewConversatiuonBindingImpl;
import com.appnew.android.databinding.ItemViewConversatiuonBindingSw600dpImpl;
import com.appnew.android.databinding.ItemViewConversatiuonBindingSw720dpImpl;
import com.appnew.android.databinding.LayoutOptionSectionListViewBindingImpl;
import com.appnew.android.databinding.LayoutOptionSectionListViewBindingSw600dpImpl;
import com.appnew.android.databinding.LayoutOptionSectionListViewBindingSw720dpImpl;
import com.appnew.android.databinding.LinkViewBindingImpl;
import com.appnew.android.databinding.LinkViewBindingSw600dpImpl;
import com.appnew.android.databinding.LinkViewBindingSw720dpImpl;
import com.appnew.android.databinding.ListRankBindingImpl;
import com.appnew.android.databinding.ListRankBindingSw600dpImpl;
import com.appnew.android.databinding.ListRankBindingSw720dpImpl;
import com.appnew.android.databinding.LiveClassVmBindingImpl;
import com.appnew.android.databinding.LiveClassVmBindingSw600dpImpl;
import com.appnew.android.databinding.LiveClassVmBindingSw720dpImpl;
import com.appnew.android.databinding.LiveTestVmBindingImpl;
import com.appnew.android.databinding.LiveTestVmBindingSw600dpImpl;
import com.appnew.android.databinding.LiveTestVmBindingSw720dpImpl;
import com.appnew.android.databinding.NewCourseVmBindingImpl;
import com.appnew.android.databinding.NewCourseVmBindingSw600dpImpl;
import com.appnew.android.databinding.NewCourseVmBindingSw720dpImpl;
import com.appnew.android.databinding.NewTestResultAdapterBindingImpl;
import com.appnew.android.databinding.NewTestResultAdapterBindingSw600dpImpl;
import com.appnew.android.databinding.NewTestResultAdapterBindingSw720dpImpl;
import com.appnew.android.databinding.NewTestresultVmBindingImpl;
import com.appnew.android.databinding.NewTestresultVmBindingSw600dpImpl;
import com.appnew.android.databinding.NewTestresultVmBindingSw720dpImpl;
import com.appnew.android.databinding.PendingPurchaseBannerItemBindingImpl;
import com.appnew.android.databinding.PendingPurchaseBannerItemBindingSw600dpImpl;
import com.appnew.android.databinding.PendingPurchaseBannerItemBindingSw720dpImpl;
import com.appnew.android.databinding.PendingPurchaseBannerLayoutBindingImpl;
import com.appnew.android.databinding.PendingPurchaseBannerLayoutBindingSw600dpImpl;
import com.appnew.android.databinding.PendingPurchaseBannerLayoutBindingSw720dpImpl;
import com.appnew.android.databinding.PopupBasicinfoQuizCareerBindingImpl;
import com.appnew.android.databinding.PopupBasicinfoQuizCareerBindingSw600dpImpl;
import com.appnew.android.databinding.PopupBasicinfoQuizCareerBindingSw720dpImpl;
import com.appnew.android.databinding.PostImageBindingImpl;
import com.appnew.android.databinding.PostImageBindingSw600dpImpl;
import com.appnew.android.databinding.PostImageBindingSw720dpImpl;
import com.appnew.android.databinding.QuestionViewBindingImpl;
import com.appnew.android.databinding.QuestionViewBindingSw600dpImpl;
import com.appnew.android.databinding.QuestionViewBindingSw720dpImpl;
import com.appnew.android.databinding.QuizViewBindingImpl;
import com.appnew.android.databinding.QuizViewBindingSw600dpImpl;
import com.appnew.android.databinding.QuizViewBindingSw720dpImpl;
import com.appnew.android.databinding.RatingDialogBindingImpl;
import com.appnew.android.databinding.RatingDialogBindingSw600dpImpl;
import com.appnew.android.databinding.RatingDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SelectMediaFileBindingImpl;
import com.appnew.android.databinding.SelectMediaFileBindingSw600dpImpl;
import com.appnew.android.databinding.SelectMediaFileBindingSw720dpImpl;
import com.appnew.android.databinding.SscEnterFibDialogBindingImpl;
import com.appnew.android.databinding.SscEnterFibDialogBindingSw600dpImpl;
import com.appnew.android.databinding.SscEnterFibDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SscInstructionsDialogBindingImpl;
import com.appnew.android.databinding.SscInstructionsDialogBindingSw600dpImpl;
import com.appnew.android.databinding.SscInstructionsDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SscPatternBackSubmitDialogBindingImpl;
import com.appnew.android.databinding.SscPatternBackSubmitDialogBindingSw600dpImpl;
import com.appnew.android.databinding.SscPatternBackSubmitDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SscPatternDrawerLayoutBindingImpl;
import com.appnew.android.databinding.SscPatternDrawerLayoutBindingSw600dpImpl;
import com.appnew.android.databinding.SscPatternDrawerLayoutBindingSw720dpImpl;
import com.appnew.android.databinding.SscPatternSectionSwitchDailogBindingImpl;
import com.appnew.android.databinding.SscPatternSectionSwitchDailogBindingSw600dpImpl;
import com.appnew.android.databinding.SscPatternSectionSwitchDailogBindingSw720dpImpl;
import com.appnew.android.databinding.SscPatternTimeOutDialogBindingImpl;
import com.appnew.android.databinding.SscPatternTimeOutDialogBindingSw600dpImpl;
import com.appnew.android.databinding.SscPatternTimeOutDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SscPatternToolbarLayoutBindingImpl;
import com.appnew.android.databinding.SscPatternToolbarLayoutBindingSw600dpImpl;
import com.appnew.android.databinding.SscPatternToolbarLayoutBindingSw720dpImpl;
import com.appnew.android.databinding.SscSymbolsDialogBindingImpl;
import com.appnew.android.databinding.SscSymbolsDialogBindingSw600dpImpl;
import com.appnew.android.databinding.SscSymbolsDialogBindingSw720dpImpl;
import com.appnew.android.databinding.SubscriptionPlanItemBindingImpl;
import com.appnew.android.databinding.SubscriptionPlanItemBindingSw600dpImpl;
import com.appnew.android.databinding.SubscriptionPlanItemBindingSw720dpImpl;
import com.appnew.android.databinding.ThankYouDialogBindingImpl;
import com.appnew.android.databinding.ThankYouDialogBindingSw600dpImpl;
import com.appnew.android.databinding.ThankYouDialogBindingSw720dpImpl;
import com.appnew.android.databinding.VideoPostBindingImpl;
import com.appnew.android.databinding.VideoPostBindingSw600dpImpl;
import com.appnew.android.databinding.VideoPostBindingSw720dpImpl;
import com.appnew.android.databinding.ViewDialogBindingImpl;
import com.appnew.android.databinding.ViewDialogBindingSw600dpImpl;
import com.appnew.android.databinding.ViewDialogBindingSw720dpImpl;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYAUDIOPLAYER = 1;
    private static final int LAYOUT_ACTIVITYCHANGELANGUAGE = 2;
    private static final int LAYOUT_ACTIVITYFEEDDETAILS = 3;
    private static final int LAYOUT_ACTIVITYFEEDS = 4;
    private static final int LAYOUT_ACTIVITYINTRO = 5;
    private static final int LAYOUT_ACTIVITYLOGGEDOUTUSER = 6;
    private static final int LAYOUT_ACTIVITYMYBAG = 7;
    private static final int LAYOUT_ACTIVITYTESTBASESSCPATTERN = 8;
    private static final int LAYOUT_ARTICLEVM = 9;
    private static final int LAYOUT_AUDIOPOST = 10;
    private static final int LAYOUT_BANNERADAPTERIMAGEVIEW = 11;
    private static final int LAYOUT_BANNERVIEW = 12;
    private static final int LAYOUT_BOTTOMSHEETPAYMENTLAYOUT = 13;
    private static final int LAYOUT_BOTTOMSHEETSTREAMYT = 14;
    private static final int LAYOUT_CARTITEMBOOK = 15;
    private static final int LAYOUT_CARTITEMBOOKGRID = 16;
    private static final int LAYOUT_COMMENTADAPTER = 17;
    private static final int LAYOUT_CUSTOMSMESTUDENTLIST = 18;
    private static final int LAYOUT_CUSTOMSOCIALICONS = 19;
    private static final int LAYOUT_CUSTOMSTUDENTDOUBTLIST = 20;
    private static final int LAYOUT_DIALOGALERTSIMPLE = 21;
    private static final int LAYOUT_DIALOGREPORTERROR = 22;
    private static final int LAYOUT_DOWNLOADURLBITRATE = 23;
    private static final int LAYOUT_DOWNLOADYOUTUBEBOTTOMSHEET = 24;
    private static final int LAYOUT_ENTERFIBLAYOUT = 25;
    private static final int LAYOUT_FEEDLIVECLASSADAPTER = 26;
    private static final int LAYOUT_FEEDLIVETESTADAPTER = 27;
    private static final int LAYOUT_FRAGMENTFEEDS = 28;
    private static final int LAYOUT_ITEM11 = 29;
    private static final int LAYOUT_ITEMSSCPATTERNINSTRUCTIONTEXT = 30;
    private static final int LAYOUT_ITEMSSCPATTERNNUMBOX = 31;
    private static final int LAYOUT_ITEMSSCPATTERNOPTION = 32;
    private static final int LAYOUT_ITEMSSCPATTERNQUESTIONVIEWPAGER = 33;
    private static final int LAYOUT_ITEMSSCPATTERNSUBJECTPART = 34;
    private static final int LAYOUT_ITEMSSCPATTERNSUBJECTTAB = 35;
    private static final int LAYOUT_ITEMVIEWCONVERSATIUON = 36;
    private static final int LAYOUT_LAYOUTOPTIONSECTIONLISTVIEW = 37;
    private static final int LAYOUT_LINKVIEW = 38;
    private static final int LAYOUT_LISTRANK = 39;
    private static final int LAYOUT_LIVECLASSVM = 40;
    private static final int LAYOUT_LIVETESTVM = 41;
    private static final int LAYOUT_NEWCOURSEVM = 42;
    private static final int LAYOUT_NEWTESTRESULTADAPTER = 43;
    private static final int LAYOUT_NEWTESTRESULTVM = 44;
    private static final int LAYOUT_PENDINGPURCHASEBANNERITEM = 45;
    private static final int LAYOUT_PENDINGPURCHASEBANNERLAYOUT = 46;
    private static final int LAYOUT_POPUPBASICINFOQUIZCAREER = 47;
    private static final int LAYOUT_POSTIMAGE = 48;
    private static final int LAYOUT_QUESTIONVIEW = 49;
    private static final int LAYOUT_QUIZVIEW = 50;
    private static final int LAYOUT_RATINGDIALOG = 51;
    private static final int LAYOUT_SELECTMEDIAFILE = 52;
    private static final int LAYOUT_SSCENTERFIBDIALOG = 53;
    private static final int LAYOUT_SSCINSTRUCTIONSDIALOG = 54;
    private static final int LAYOUT_SSCPATTERNBACKSUBMITDIALOG = 55;
    private static final int LAYOUT_SSCPATTERNDRAWERLAYOUT = 56;
    private static final int LAYOUT_SSCPATTERNSECTIONSWITCHDAILOG = 57;
    private static final int LAYOUT_SSCPATTERNTIMEOUTDIALOG = 58;
    private static final int LAYOUT_SSCPATTERNTOOLBARLAYOUT = 59;
    private static final int LAYOUT_SSCSYMBOLSDIALOG = 60;
    private static final int LAYOUT_SUBSCRIPTIONPLANITEM = 61;
    private static final int LAYOUT_THANKYOUDIALOG = 62;
    private static final int LAYOUT_VIDEOPOST = 63;
    private static final int LAYOUT_VIEWDIALOG = 64;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(64);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_audio_player, 1);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_change_language, 2);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_feed_details, 3);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_feeds, 4);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_intro, 5);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_logged_out_user, 6);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_my_bag, 7);
        sparseIntArray.put(com.eduteria.app.app.R.layout.activity_test_base_sscpattern, 8);
        sparseIntArray.put(com.eduteria.app.app.R.layout.article_vm, 9);
        sparseIntArray.put(com.eduteria.app.app.R.layout.audio_post, 10);
        sparseIntArray.put(com.eduteria.app.app.R.layout.banner_adapter_imageview, 11);
        sparseIntArray.put(com.eduteria.app.app.R.layout.banner_view, 12);
        sparseIntArray.put(com.eduteria.app.app.R.layout.bottom_sheet_payment_layout, 13);
        sparseIntArray.put(com.eduteria.app.app.R.layout.bottom_sheet_stream_yt, 14);
        sparseIntArray.put(com.eduteria.app.app.R.layout.cart_item_book, 15);
        sparseIntArray.put(com.eduteria.app.app.R.layout.cart_item_book_grid, 16);
        sparseIntArray.put(com.eduteria.app.app.R.layout.comment_adapter, 17);
        sparseIntArray.put(com.eduteria.app.app.R.layout.custom_sme_studentlist, 18);
        sparseIntArray.put(com.eduteria.app.app.R.layout.custom_social_icons, 19);
        sparseIntArray.put(com.eduteria.app.app.R.layout.custom_student_doubt_list, 20);
        sparseIntArray.put(com.eduteria.app.app.R.layout.dialog_alert_simple, 21);
        sparseIntArray.put(com.eduteria.app.app.R.layout.dialog_report_error, 22);
        sparseIntArray.put(com.eduteria.app.app.R.layout.download_url_bitrate, 23);
        sparseIntArray.put(com.eduteria.app.app.R.layout.download_youtube_bottom_sheet, 24);
        sparseIntArray.put(com.eduteria.app.app.R.layout.enter_fib_layout, 25);
        sparseIntArray.put(com.eduteria.app.app.R.layout.feed_live_class_adapter, 26);
        sparseIntArray.put(com.eduteria.app.app.R.layout.feed_live_test_adapter, 27);
        sparseIntArray.put(com.eduteria.app.app.R.layout.fragment_feeds, 28);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item11, 29);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_instruction_text, 30);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_num_box, 31);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_option, 32);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_question_viewpager, 33);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_part, 34);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_tab, 35);
        sparseIntArray.put(com.eduteria.app.app.R.layout.item_view_conversatiuon, 36);
        sparseIntArray.put(com.eduteria.app.app.R.layout.layout_option_section_list_view, 37);
        sparseIntArray.put(com.eduteria.app.app.R.layout.link_view, 38);
        sparseIntArray.put(com.eduteria.app.app.R.layout.list_rank, 39);
        sparseIntArray.put(com.eduteria.app.app.R.layout.live_class_vm, 40);
        sparseIntArray.put(com.eduteria.app.app.R.layout.live_test_vm, 41);
        sparseIntArray.put(com.eduteria.app.app.R.layout.new_course_vm, 42);
        sparseIntArray.put(com.eduteria.app.app.R.layout.new_test_result_adapter, 43);
        sparseIntArray.put(com.eduteria.app.app.R.layout.new_testresult_vm, 44);
        sparseIntArray.put(com.eduteria.app.app.R.layout.pending_purchase_banner_item, 45);
        sparseIntArray.put(com.eduteria.app.app.R.layout.pending_purchase_banner_layout, 46);
        sparseIntArray.put(com.eduteria.app.app.R.layout.popup_basicinfo_quiz_career, 47);
        sparseIntArray.put(com.eduteria.app.app.R.layout.post_image, 48);
        sparseIntArray.put(com.eduteria.app.app.R.layout.question_view, 49);
        sparseIntArray.put(com.eduteria.app.app.R.layout.quiz_view, 50);
        sparseIntArray.put(com.eduteria.app.app.R.layout.rating_dialog, 51);
        sparseIntArray.put(com.eduteria.app.app.R.layout.select_media_file, 52);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_enter_fib_dialog, 53);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_instructions_dialog, 54);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_pattern_back_submit_dialog, 55);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_pattern_drawer_layout, 56);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_pattern_section_switch_dailog, 57);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_pattern_time_out_dialog, 58);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_pattern_toolbar_layout, 59);
        sparseIntArray.put(com.eduteria.app.app.R.layout.ssc_symbols_dialog, 60);
        sparseIntArray.put(com.eduteria.app.app.R.layout.subscription_plan_item, 61);
        sparseIntArray.put(com.eduteria.app.app.R.layout.thank_you_dialog, 62);
        sparseIntArray.put(com.eduteria.app.app.R.layout.video_post, 63);
        sparseIntArray.put(com.eduteria.app.app.R.layout.view_dialog, 64);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout-sw720dp/activity_audio_player_0".equals(tag)) {
                    return new ActivityAudioPlayerBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/activity_audio_player_0".equals(tag)) {
                    return new ActivityAudioPlayerBindingSw600dpImpl(component, view);
                }
                if ("layout/activity_audio_player_0".equals(tag)) {
                    return new ActivityAudioPlayerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_audio_player is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_change_language_0".equals(tag)) {
                    return new ActivityChangeLanguageBindingImpl(component, view);
                }
                if ("layout-sw600dp/activity_change_language_0".equals(tag)) {
                    return new ActivityChangeLanguageBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/activity_change_language_0".equals(tag)) {
                    return new ActivityChangeLanguageBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_change_language is invalid. Received: " + tag);
            case 3:
                if ("layout-sw600dp/activity_feed_details_0".equals(tag)) {
                    return new ActivityFeedDetailsBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/activity_feed_details_0".equals(tag)) {
                    return new ActivityFeedDetailsBindingSw720dpImpl(component, view);
                }
                if ("layout/activity_feed_details_0".equals(tag)) {
                    return new ActivityFeedDetailsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_feed_details is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_feeds_0".equals(tag)) {
                    return new ActivityFeedsBindingImpl(component, view);
                }
                if ("layout-sw600dp/activity_feeds_0".equals(tag)) {
                    return new ActivityFeedsBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/activity_feeds_0".equals(tag)) {
                    return new ActivityFeedsBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_feeds is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_intro_0".equals(tag)) {
                    return new ActivityIntroBindingImpl(component, view);
                }
                if ("layout-sw720dp/activity_intro_0".equals(tag)) {
                    return new ActivityIntroBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/activity_intro_0".equals(tag)) {
                    return new ActivityIntroBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_intro is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_logged_out_user_0".equals(tag)) {
                    return new ActivityLoggedOutUserBindingImpl(component, view);
                }
                if ("layout-sw720dp/activity_logged_out_user_0".equals(tag)) {
                    return new ActivityLoggedOutUserBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/activity_logged_out_user_0".equals(tag)) {
                    return new ActivityLoggedOutUserBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_logged_out_user is invalid. Received: " + tag);
            case 7:
                if ("layout-sw720dp/activity_my_bag_0".equals(tag)) {
                    return new ActivityMyBagBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/activity_my_bag_0".equals(tag)) {
                    return new ActivityMyBagBindingSw600dpImpl(component, view);
                }
                if ("layout/activity_my_bag_0".equals(tag)) {
                    return new ActivityMyBagBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_my_bag is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_test_base_sscpattern_0".equals(tag)) {
                    return new ActivityTestBaseSscpatternBindingImpl(component, view);
                }
                if ("layout-sw720dp/activity_test_base_sscpattern_0".equals(tag)) {
                    return new ActivityTestBaseSscpatternBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/activity_test_base_sscpattern_0".equals(tag)) {
                    return new ActivityTestBaseSscpatternBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_test_base_sscpattern is invalid. Received: " + tag);
            case 9:
                if ("layout/article_vm_0".equals(tag)) {
                    return new ArticleVmBindingImpl(component, view);
                }
                if ("layout-sw600dp/article_vm_0".equals(tag)) {
                    return new ArticleVmBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/article_vm_0".equals(tag)) {
                    return new ArticleVmBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for article_vm is invalid. Received: " + tag);
            case 10:
                if ("layout/audio_post_0".equals(tag)) {
                    return new AudioPostBindingImpl(component, view);
                }
                if ("layout-sw600dp/audio_post_0".equals(tag)) {
                    return new AudioPostBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/audio_post_0".equals(tag)) {
                    return new AudioPostBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for audio_post is invalid. Received: " + tag);
            case 11:
                if ("layout/banner_adapter_imageview_0".equals(tag)) {
                    return new BannerAdapterImageviewBindingImpl(component, view);
                }
                if ("layout-sw600dp/banner_adapter_imageview_0".equals(tag)) {
                    return new BannerAdapterImageviewBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/banner_adapter_imageview_0".equals(tag)) {
                    return new BannerAdapterImageviewBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for banner_adapter_imageview is invalid. Received: " + tag);
            case 12:
                if ("layout/banner_view_0".equals(tag)) {
                    return new BannerViewBindingImpl(component, view);
                }
                if ("layout-sw600dp/banner_view_0".equals(tag)) {
                    return new BannerViewBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/banner_view_0".equals(tag)) {
                    return new BannerViewBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for banner_view is invalid. Received: " + tag);
            case 13:
                if ("layout-sw720dp/bottom_sheet_payment_layout_0".equals(tag)) {
                    return new BottomSheetPaymentLayoutBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/bottom_sheet_payment_layout_0".equals(tag)) {
                    return new BottomSheetPaymentLayoutBindingSw600dpImpl(component, view);
                }
                if ("layout/bottom_sheet_payment_layout_0".equals(tag)) {
                    return new BottomSheetPaymentLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_sheet_payment_layout is invalid. Received: " + tag);
            case 14:
                if ("layout-sw720dp/bottom_sheet_stream_yt_0".equals(tag)) {
                    return new BottomSheetStreamYtBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/bottom_sheet_stream_yt_0".equals(tag)) {
                    return new BottomSheetStreamYtBindingSw600dpImpl(component, view);
                }
                if ("layout/bottom_sheet_stream_yt_0".equals(tag)) {
                    return new BottomSheetStreamYtBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_sheet_stream_yt is invalid. Received: " + tag);
            case 15:
                if ("layout/cart_item_book_0".equals(tag)) {
                    return new CartItemBookBindingImpl(component, view);
                }
                if ("layout-sw720dp/cart_item_book_0".equals(tag)) {
                    return new CartItemBookBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/cart_item_book_0".equals(tag)) {
                    return new CartItemBookBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for cart_item_book is invalid. Received: " + tag);
            case 16:
                if ("layout/cart_item_book_grid_0".equals(tag)) {
                    return new CartItemBookGridBindingImpl(component, view);
                }
                if ("layout-sw720dp/cart_item_book_grid_0".equals(tag)) {
                    return new CartItemBookGridBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/cart_item_book_grid_0".equals(tag)) {
                    return new CartItemBookGridBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for cart_item_book_grid is invalid. Received: " + tag);
            case 17:
                if ("layout-sw720dp/comment_adapter_0".equals(tag)) {
                    return new CommentAdapterBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/comment_adapter_0".equals(tag)) {
                    return new CommentAdapterBindingSw600dpImpl(component, view);
                }
                if ("layout/comment_adapter_0".equals(tag)) {
                    return new CommentAdapterBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for comment_adapter is invalid. Received: " + tag);
            case 18:
                if ("layout-sw720dp/custom_sme_studentlist_0".equals(tag)) {
                    return new CustomSmeStudentlistBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/custom_sme_studentlist_0".equals(tag)) {
                    return new CustomSmeStudentlistBindingSw600dpImpl(component, view);
                }
                if ("layout/custom_sme_studentlist_0".equals(tag)) {
                    return new CustomSmeStudentlistBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_sme_studentlist is invalid. Received: " + tag);
            case 19:
                if ("layout-sw600dp/custom_social_icons_0".equals(tag)) {
                    return new CustomSocialIconsBindingSw600dpImpl(component, view);
                }
                if ("layout/custom_social_icons_0".equals(tag)) {
                    return new CustomSocialIconsBindingImpl(component, view);
                }
                if ("layout-sw720dp/custom_social_icons_0".equals(tag)) {
                    return new CustomSocialIconsBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_social_icons is invalid. Received: " + tag);
            case 20:
                if ("layout-sw720dp/custom_student_doubt_list_0".equals(tag)) {
                    return new CustomStudentDoubtListBindingSw720dpImpl(component, view);
                }
                if ("layout/custom_student_doubt_list_0".equals(tag)) {
                    return new CustomStudentDoubtListBindingImpl(component, view);
                }
                if ("layout-sw600dp/custom_student_doubt_list_0".equals(tag)) {
                    return new CustomStudentDoubtListBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for custom_student_doubt_list is invalid. Received: " + tag);
            case 21:
                if ("layout-sw720dp/dialog_alert_simple_0".equals(tag)) {
                    return new DialogAlertSimpleBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/dialog_alert_simple_0".equals(tag)) {
                    return new DialogAlertSimpleBindingSw600dpImpl(component, view);
                }
                if ("layout/dialog_alert_simple_0".equals(tag)) {
                    return new DialogAlertSimpleBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_alert_simple is invalid. Received: " + tag);
            case 22:
                if ("layout-sw720dp/dialog_report_error_0".equals(tag)) {
                    return new DialogReportErrorBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/dialog_report_error_0".equals(tag)) {
                    return new DialogReportErrorBindingSw600dpImpl(component, view);
                }
                if ("layout/dialog_report_error_0".equals(tag)) {
                    return new DialogReportErrorBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_report_error is invalid. Received: " + tag);
            case 23:
                if ("layout-sw600dp/download_url_bitrate_0".equals(tag)) {
                    return new DownloadUrlBitrateBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/download_url_bitrate_0".equals(tag)) {
                    return new DownloadUrlBitrateBindingSw720dpImpl(component, view);
                }
                if ("layout/download_url_bitrate_0".equals(tag)) {
                    return new DownloadUrlBitrateBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for download_url_bitrate is invalid. Received: " + tag);
            case 24:
                if ("layout/download_youtube_bottom_sheet_0".equals(tag)) {
                    return new DownloadYoutubeBottomSheetBindingImpl(component, view);
                }
                if ("layout-sw720dp/download_youtube_bottom_sheet_0".equals(tag)) {
                    return new DownloadYoutubeBottomSheetBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/download_youtube_bottom_sheet_0".equals(tag)) {
                    return new DownloadYoutubeBottomSheetBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for download_youtube_bottom_sheet is invalid. Received: " + tag);
            case 25:
                if ("layout-sw720dp/enter_fib_layout_0".equals(tag)) {
                    return new EnterFibLayoutBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/enter_fib_layout_0".equals(tag)) {
                    return new EnterFibLayoutBindingSw600dpImpl(component, view);
                }
                if ("layout/enter_fib_layout_0".equals(tag)) {
                    return new EnterFibLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for enter_fib_layout is invalid. Received: " + tag);
            case 26:
                if ("layout-sw720dp/feed_live_class_adapter_0".equals(tag)) {
                    return new FeedLiveClassAdapterBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/feed_live_class_adapter_0".equals(tag)) {
                    return new FeedLiveClassAdapterBindingSw600dpImpl(component, view);
                }
                if ("layout/feed_live_class_adapter_0".equals(tag)) {
                    return new FeedLiveClassAdapterBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for feed_live_class_adapter is invalid. Received: " + tag);
            case 27:
                if ("layout/feed_live_test_adapter_0".equals(tag)) {
                    return new FeedLiveTestAdapterBindingImpl(component, view);
                }
                if ("layout-sw720dp/feed_live_test_adapter_0".equals(tag)) {
                    return new FeedLiveTestAdapterBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/feed_live_test_adapter_0".equals(tag)) {
                    return new FeedLiveTestAdapterBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for feed_live_test_adapter is invalid. Received: " + tag);
            case 28:
                if ("layout-sw600dp/fragment_feeds_0".equals(tag)) {
                    return new FragmentFeedsBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/fragment_feeds_0".equals(tag)) {
                    return new FragmentFeedsBindingSw720dpImpl(component, view);
                }
                if ("layout/fragment_feeds_0".equals(tag)) {
                    return new FragmentFeedsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_feeds is invalid. Received: " + tag);
            case 29:
                if ("layout-sw600dp/item11_0".equals(tag)) {
                    return new Item11BindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/item11_0".equals(tag)) {
                    return new Item11BindingSw720dpImpl(component, view);
                }
                if ("layout/item11_0".equals(tag)) {
                    return new Item11BindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item11 is invalid. Received: " + tag);
            case 30:
                if ("layout-sw600dp/item_ssc_pattern_instruction_text_0".equals(tag)) {
                    return new ItemSscPatternInstructionTextBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/item_ssc_pattern_instruction_text_0".equals(tag)) {
                    return new ItemSscPatternInstructionTextBindingSw720dpImpl(component, view);
                }
                if ("layout/item_ssc_pattern_instruction_text_0".equals(tag)) {
                    return new ItemSscPatternInstructionTextBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_instruction_text is invalid. Received: " + tag);
            case 31:
                if ("layout-sw720dp/item_ssc_pattern_num_box_0".equals(tag)) {
                    return new ItemSscPatternNumBoxBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/item_ssc_pattern_num_box_0".equals(tag)) {
                    return new ItemSscPatternNumBoxBindingSw600dpImpl(component, view);
                }
                if ("layout/item_ssc_pattern_num_box_0".equals(tag)) {
                    return new ItemSscPatternNumBoxBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_num_box is invalid. Received: " + tag);
            case 32:
                if ("layout/item_ssc_pattern_option_0".equals(tag)) {
                    return new ItemSscPatternOptionBindingImpl(component, view);
                }
                if ("layout-sw600dp/item_ssc_pattern_option_0".equals(tag)) {
                    return new ItemSscPatternOptionBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/item_ssc_pattern_option_0".equals(tag)) {
                    return new ItemSscPatternOptionBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_option is invalid. Received: " + tag);
            case 33:
                if ("layout-sw600dp/item_ssc_pattern_question_viewpager_0".equals(tag)) {
                    return new ItemSscPatternQuestionViewpagerBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/item_ssc_pattern_question_viewpager_0".equals(tag)) {
                    return new ItemSscPatternQuestionViewpagerBindingSw720dpImpl(component, view);
                }
                if ("layout/item_ssc_pattern_question_viewpager_0".equals(tag)) {
                    return new ItemSscPatternQuestionViewpagerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_question_viewpager is invalid. Received: " + tag);
            case 34:
                if ("layout-sw720dp/item_ssc_pattern_subject_part_0".equals(tag)) {
                    return new ItemSscPatternSubjectPartBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/item_ssc_pattern_subject_part_0".equals(tag)) {
                    return new ItemSscPatternSubjectPartBindingSw600dpImpl(component, view);
                }
                if ("layout/item_ssc_pattern_subject_part_0".equals(tag)) {
                    return new ItemSscPatternSubjectPartBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_subject_part is invalid. Received: " + tag);
            case 35:
                if ("layout/item_ssc_pattern_subject_tab_0".equals(tag)) {
                    return new ItemSscPatternSubjectTabBindingImpl(component, view);
                }
                if ("layout-sw600dp/item_ssc_pattern_subject_tab_0".equals(tag)) {
                    return new ItemSscPatternSubjectTabBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/item_ssc_pattern_subject_tab_0".equals(tag)) {
                    return new ItemSscPatternSubjectTabBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_ssc_pattern_subject_tab is invalid. Received: " + tag);
            case 36:
                if ("layout-sw720dp/item_view_conversatiuon_0".equals(tag)) {
                    return new ItemViewConversatiuonBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/item_view_conversatiuon_0".equals(tag)) {
                    return new ItemViewConversatiuonBindingSw600dpImpl(component, view);
                }
                if ("layout/item_view_conversatiuon_0".equals(tag)) {
                    return new ItemViewConversatiuonBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for item_view_conversatiuon is invalid. Received: " + tag);
            case 37:
                if ("layout/layout_option_section_list_view_0".equals(tag)) {
                    return new LayoutOptionSectionListViewBindingImpl(component, view);
                }
                if ("layout-sw720dp/layout_option_section_list_view_0".equals(tag)) {
                    return new LayoutOptionSectionListViewBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/layout_option_section_list_view_0".equals(tag)) {
                    return new LayoutOptionSectionListViewBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_option_section_list_view is invalid. Received: " + tag);
            case 38:
                if ("layout-sw720dp/link_view_0".equals(tag)) {
                    return new LinkViewBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/link_view_0".equals(tag)) {
                    return new LinkViewBindingSw600dpImpl(component, view);
                }
                if ("layout/link_view_0".equals(tag)) {
                    return new LinkViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for link_view is invalid. Received: " + tag);
            case 39:
                if ("layout/list_rank_0".equals(tag)) {
                    return new ListRankBindingImpl(component, view);
                }
                if ("layout-sw720dp/list_rank_0".equals(tag)) {
                    return new ListRankBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/list_rank_0".equals(tag)) {
                    return new ListRankBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for list_rank is invalid. Received: " + tag);
            case 40:
                if ("layout/live_class_vm_0".equals(tag)) {
                    return new LiveClassVmBindingImpl(component, view);
                }
                if ("layout-sw600dp/live_class_vm_0".equals(tag)) {
                    return new LiveClassVmBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/live_class_vm_0".equals(tag)) {
                    return new LiveClassVmBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for live_class_vm is invalid. Received: " + tag);
            case 41:
                if ("layout/live_test_vm_0".equals(tag)) {
                    return new LiveTestVmBindingImpl(component, view);
                }
                if ("layout-sw720dp/live_test_vm_0".equals(tag)) {
                    return new LiveTestVmBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/live_test_vm_0".equals(tag)) {
                    return new LiveTestVmBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for live_test_vm is invalid. Received: " + tag);
            case 42:
                if ("layout-sw720dp/new_course_vm_0".equals(tag)) {
                    return new NewCourseVmBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/new_course_vm_0".equals(tag)) {
                    return new NewCourseVmBindingSw600dpImpl(component, view);
                }
                if ("layout/new_course_vm_0".equals(tag)) {
                    return new NewCourseVmBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for new_course_vm is invalid. Received: " + tag);
            case 43:
                if ("layout-sw600dp/new_test_result_adapter_0".equals(tag)) {
                    return new NewTestResultAdapterBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/new_test_result_adapter_0".equals(tag)) {
                    return new NewTestResultAdapterBindingSw720dpImpl(component, view);
                }
                if ("layout/new_test_result_adapter_0".equals(tag)) {
                    return new NewTestResultAdapterBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for new_test_result_adapter is invalid. Received: " + tag);
            case 44:
                if ("layout/new_testresult_vm_0".equals(tag)) {
                    return new NewTestresultVmBindingImpl(component, view);
                }
                if ("layout-sw600dp/new_testresult_vm_0".equals(tag)) {
                    return new NewTestresultVmBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/new_testresult_vm_0".equals(tag)) {
                    return new NewTestresultVmBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for new_testresult_vm is invalid. Received: " + tag);
            case 45:
                if ("layout/pending_purchase_banner_item_0".equals(tag)) {
                    return new PendingPurchaseBannerItemBindingImpl(component, view);
                }
                if ("layout-sw720dp/pending_purchase_banner_item_0".equals(tag)) {
                    return new PendingPurchaseBannerItemBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/pending_purchase_banner_item_0".equals(tag)) {
                    return new PendingPurchaseBannerItemBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for pending_purchase_banner_item is invalid. Received: " + tag);
            case 46:
                if ("layout/pending_purchase_banner_layout_0".equals(tag)) {
                    return new PendingPurchaseBannerLayoutBindingImpl(component, view);
                }
                if ("layout-sw600dp/pending_purchase_banner_layout_0".equals(tag)) {
                    return new PendingPurchaseBannerLayoutBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/pending_purchase_banner_layout_0".equals(tag)) {
                    return new PendingPurchaseBannerLayoutBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for pending_purchase_banner_layout is invalid. Received: " + tag);
            case 47:
                if ("layout/popup_basicinfo_quiz_career_0".equals(tag)) {
                    return new PopupBasicinfoQuizCareerBindingImpl(component, view);
                }
                if ("layout-sw600dp/popup_basicinfo_quiz_career_0".equals(tag)) {
                    return new PopupBasicinfoQuizCareerBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/popup_basicinfo_quiz_career_0".equals(tag)) {
                    return new PopupBasicinfoQuizCareerBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for popup_basicinfo_quiz_career is invalid. Received: " + tag);
            case 48:
                if ("layout-sw720dp/post_image_0".equals(tag)) {
                    return new PostImageBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/post_image_0".equals(tag)) {
                    return new PostImageBindingSw600dpImpl(component, view);
                }
                if ("layout/post_image_0".equals(tag)) {
                    return new PostImageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for post_image is invalid. Received: " + tag);
            case 49:
                if ("layout/question_view_0".equals(tag)) {
                    return new QuestionViewBindingImpl(component, view);
                }
                if ("layout-sw720dp/question_view_0".equals(tag)) {
                    return new QuestionViewBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/question_view_0".equals(tag)) {
                    return new QuestionViewBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for question_view is invalid. Received: " + tag);
            case 50:
                if ("layout-sw600dp/quiz_view_0".equals(tag)) {
                    return new QuizViewBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/quiz_view_0".equals(tag)) {
                    return new QuizViewBindingSw720dpImpl(component, view);
                }
                if ("layout/quiz_view_0".equals(tag)) {
                    return new QuizViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for quiz_view is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/rating_dialog_0".equals(tag)) {
                    return new RatingDialogBindingImpl(component, view);
                }
                if ("layout-sw600dp/rating_dialog_0".equals(tag)) {
                    return new RatingDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/rating_dialog_0".equals(tag)) {
                    return new RatingDialogBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for rating_dialog is invalid. Received: " + tag);
            case 52:
                if ("layout-sw600dp/select_media_file_0".equals(tag)) {
                    return new SelectMediaFileBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/select_media_file_0".equals(tag)) {
                    return new SelectMediaFileBindingSw720dpImpl(component, view);
                }
                if ("layout/select_media_file_0".equals(tag)) {
                    return new SelectMediaFileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for select_media_file is invalid. Received: " + tag);
            case 53:
                if ("layout-sw720dp/ssc_enter_fib_dialog_0".equals(tag)) {
                    return new SscEnterFibDialogBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/ssc_enter_fib_dialog_0".equals(tag)) {
                    return new SscEnterFibDialogBindingSw600dpImpl(component, view);
                }
                if ("layout/ssc_enter_fib_dialog_0".equals(tag)) {
                    return new SscEnterFibDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_enter_fib_dialog is invalid. Received: " + tag);
            case 54:
                if ("layout/ssc_instructions_dialog_0".equals(tag)) {
                    return new SscInstructionsDialogBindingImpl(component, view);
                }
                if ("layout-sw600dp/ssc_instructions_dialog_0".equals(tag)) {
                    return new SscInstructionsDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_instructions_dialog_0".equals(tag)) {
                    return new SscInstructionsDialogBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_instructions_dialog is invalid. Received: " + tag);
            case 55:
                if ("layout-sw720dp/ssc_pattern_back_submit_dialog_0".equals(tag)) {
                    return new SscPatternBackSubmitDialogBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/ssc_pattern_back_submit_dialog_0".equals(tag)) {
                    return new SscPatternBackSubmitDialogBindingSw600dpImpl(component, view);
                }
                if ("layout/ssc_pattern_back_submit_dialog_0".equals(tag)) {
                    return new SscPatternBackSubmitDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_pattern_back_submit_dialog is invalid. Received: " + tag);
            case 56:
                if ("layout/ssc_pattern_drawer_layout_0".equals(tag)) {
                    return new SscPatternDrawerLayoutBindingImpl(component, view);
                }
                if ("layout-sw600dp/ssc_pattern_drawer_layout_0".equals(tag)) {
                    return new SscPatternDrawerLayoutBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_pattern_drawer_layout_0".equals(tag)) {
                    return new SscPatternDrawerLayoutBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_pattern_drawer_layout is invalid. Received: " + tag);
            case 57:
                if ("layout-sw600dp/ssc_pattern_section_switch_dailog_0".equals(tag)) {
                    return new SscPatternSectionSwitchDailogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_pattern_section_switch_dailog_0".equals(tag)) {
                    return new SscPatternSectionSwitchDailogBindingSw720dpImpl(component, view);
                }
                if ("layout/ssc_pattern_section_switch_dailog_0".equals(tag)) {
                    return new SscPatternSectionSwitchDailogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_pattern_section_switch_dailog is invalid. Received: " + tag);
            case 58:
                if ("layout-sw600dp/ssc_pattern_time_out_dialog_0".equals(tag)) {
                    return new SscPatternTimeOutDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_pattern_time_out_dialog_0".equals(tag)) {
                    return new SscPatternTimeOutDialogBindingSw720dpImpl(component, view);
                }
                if ("layout/ssc_pattern_time_out_dialog_0".equals(tag)) {
                    return new SscPatternTimeOutDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_pattern_time_out_dialog is invalid. Received: " + tag);
            case 59:
                if ("layout-sw600dp/ssc_pattern_toolbar_layout_0".equals(tag)) {
                    return new SscPatternToolbarLayoutBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_pattern_toolbar_layout_0".equals(tag)) {
                    return new SscPatternToolbarLayoutBindingSw720dpImpl(component, view);
                }
                if ("layout/ssc_pattern_toolbar_layout_0".equals(tag)) {
                    return new SscPatternToolbarLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_pattern_toolbar_layout is invalid. Received: " + tag);
            case 60:
                if ("layout-sw600dp/ssc_symbols_dialog_0".equals(tag)) {
                    return new SscSymbolsDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/ssc_symbols_dialog_0".equals(tag)) {
                    return new SscSymbolsDialogBindingSw720dpImpl(component, view);
                }
                if ("layout/ssc_symbols_dialog_0".equals(tag)) {
                    return new SscSymbolsDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ssc_symbols_dialog is invalid. Received: " + tag);
            case 61:
                if ("layout/subscription_plan_item_0".equals(tag)) {
                    return new SubscriptionPlanItemBindingImpl(component, view);
                }
                if ("layout-sw720dp/subscription_plan_item_0".equals(tag)) {
                    return new SubscriptionPlanItemBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/subscription_plan_item_0".equals(tag)) {
                    return new SubscriptionPlanItemBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for subscription_plan_item is invalid. Received: " + tag);
            case 62:
                if ("layout-sw600dp/thank_you_dialog_0".equals(tag)) {
                    return new ThankYouDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/thank_you_dialog_0".equals(tag)) {
                    return new ThankYouDialogBindingSw720dpImpl(component, view);
                }
                if ("layout/thank_you_dialog_0".equals(tag)) {
                    return new ThankYouDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for thank_you_dialog is invalid. Received: " + tag);
            case 63:
                if ("layout/video_post_0".equals(tag)) {
                    return new VideoPostBindingImpl(component, view);
                }
                if ("layout-sw720dp/video_post_0".equals(tag)) {
                    return new VideoPostBindingSw720dpImpl(component, view);
                }
                if ("layout-sw600dp/video_post_0".equals(tag)) {
                    return new VideoPostBindingSw600dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for video_post is invalid. Received: " + tag);
            case 64:
                if ("layout/view_dialog_0".equals(tag)) {
                    return new ViewDialogBindingImpl(component, view);
                }
                if ("layout-sw600dp/view_dialog_0".equals(tag)) {
                    return new ViewDialogBindingSw600dpImpl(component, view);
                }
                if ("layout-sw720dp/view_dialog_0".equals(tag)) {
                    return new ViewDialogBindingSw720dpImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i2 = (i - 1) / 50;
        if (i2 == 0) {
            return internalGetViewDataBinding0(component, view, i, tag);
        }
        if (i2 != 1) {
            return null;
        }
        return internalGetViewDataBinding1(component, view, i, tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(28);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "articlebind");
            sparseArray.put(2, "audiobind");
            sparseArray.put(3, "bannerdata");
            sparseArray.put(4, "bannerviewadapter");
            sparseArray.put(5, "commentdata");
            sparseArray.put(6, "coursedata");
            sparseArray.put(7, "data");
            sparseArray.put(8, "feedadapter");
            sparseArray.put(9, "feedbind");
            sparseArray.put(10, "feeddatatable");
            sparseArray.put(11, "feeddetailVm");
            sparseArray.put(12, "imagebind");
            sparseArray.put(13, "linkbind");
            sparseArray.put(14, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            sparseArray.put(15, "liveclass");
            sparseArray.put(16, "liveclassdata");
            sparseArray.put(17, "livetest");
            sparseArray.put(18, "livetestdata");
            sparseArray.put(19, "livetestresult");
            sparseArray.put(20, "mediaListener");
            sparseArray.put(21, "message");
            sparseArray.put(22, "optionadapter");
            sparseArray.put(23, "optionwebadapter");
            sparseArray.put(24, "questionbind");
            sparseArray.put(25, "quizbind");
            sparseArray.put(26, "socialItem");
            sparseArray.put(27, "videopostbind");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(192);
            sKeys = map;
            Integer numValueOf = Integer.valueOf(com.eduteria.app.app.R.layout.activity_audio_player);
            map.put("layout-sw720dp/activity_audio_player_0", numValueOf);
            map.put("layout-sw600dp/activity_audio_player_0", numValueOf);
            map.put("layout/activity_audio_player_0", numValueOf);
            Integer numValueOf2 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_change_language);
            map.put("layout/activity_change_language_0", numValueOf2);
            map.put("layout-sw600dp/activity_change_language_0", numValueOf2);
            map.put("layout-sw720dp/activity_change_language_0", numValueOf2);
            Integer numValueOf3 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_feed_details);
            map.put("layout-sw600dp/activity_feed_details_0", numValueOf3);
            map.put("layout-sw720dp/activity_feed_details_0", numValueOf3);
            map.put("layout/activity_feed_details_0", numValueOf3);
            Integer numValueOf4 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_feeds);
            map.put("layout/activity_feeds_0", numValueOf4);
            map.put("layout-sw600dp/activity_feeds_0", numValueOf4);
            map.put("layout-sw720dp/activity_feeds_0", numValueOf4);
            Integer numValueOf5 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_intro);
            map.put("layout/activity_intro_0", numValueOf5);
            map.put("layout-sw720dp/activity_intro_0", numValueOf5);
            map.put("layout-sw600dp/activity_intro_0", numValueOf5);
            Integer numValueOf6 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_logged_out_user);
            map.put("layout/activity_logged_out_user_0", numValueOf6);
            map.put("layout-sw720dp/activity_logged_out_user_0", numValueOf6);
            map.put("layout-sw600dp/activity_logged_out_user_0", numValueOf6);
            Integer numValueOf7 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_my_bag);
            map.put("layout-sw720dp/activity_my_bag_0", numValueOf7);
            map.put("layout-sw600dp/activity_my_bag_0", numValueOf7);
            map.put("layout/activity_my_bag_0", numValueOf7);
            Integer numValueOf8 = Integer.valueOf(com.eduteria.app.app.R.layout.activity_test_base_sscpattern);
            map.put("layout/activity_test_base_sscpattern_0", numValueOf8);
            map.put("layout-sw720dp/activity_test_base_sscpattern_0", numValueOf8);
            map.put("layout-sw600dp/activity_test_base_sscpattern_0", numValueOf8);
            Integer numValueOf9 = Integer.valueOf(com.eduteria.app.app.R.layout.article_vm);
            map.put("layout/article_vm_0", numValueOf9);
            map.put("layout-sw600dp/article_vm_0", numValueOf9);
            map.put("layout-sw720dp/article_vm_0", numValueOf9);
            Integer numValueOf10 = Integer.valueOf(com.eduteria.app.app.R.layout.audio_post);
            map.put("layout/audio_post_0", numValueOf10);
            map.put("layout-sw600dp/audio_post_0", numValueOf10);
            map.put("layout-sw720dp/audio_post_0", numValueOf10);
            Integer numValueOf11 = Integer.valueOf(com.eduteria.app.app.R.layout.banner_adapter_imageview);
            map.put("layout/banner_adapter_imageview_0", numValueOf11);
            map.put("layout-sw600dp/banner_adapter_imageview_0", numValueOf11);
            map.put("layout-sw720dp/banner_adapter_imageview_0", numValueOf11);
            Integer numValueOf12 = Integer.valueOf(com.eduteria.app.app.R.layout.banner_view);
            map.put("layout/banner_view_0", numValueOf12);
            map.put("layout-sw600dp/banner_view_0", numValueOf12);
            map.put("layout-sw720dp/banner_view_0", numValueOf12);
            Integer numValueOf13 = Integer.valueOf(com.eduteria.app.app.R.layout.bottom_sheet_payment_layout);
            map.put("layout-sw720dp/bottom_sheet_payment_layout_0", numValueOf13);
            map.put("layout-sw600dp/bottom_sheet_payment_layout_0", numValueOf13);
            map.put("layout/bottom_sheet_payment_layout_0", numValueOf13);
            Integer numValueOf14 = Integer.valueOf(com.eduteria.app.app.R.layout.bottom_sheet_stream_yt);
            map.put("layout-sw720dp/bottom_sheet_stream_yt_0", numValueOf14);
            map.put("layout-sw600dp/bottom_sheet_stream_yt_0", numValueOf14);
            map.put("layout/bottom_sheet_stream_yt_0", numValueOf14);
            Integer numValueOf15 = Integer.valueOf(com.eduteria.app.app.R.layout.cart_item_book);
            map.put("layout/cart_item_book_0", numValueOf15);
            map.put("layout-sw720dp/cart_item_book_0", numValueOf15);
            map.put("layout-sw600dp/cart_item_book_0", numValueOf15);
            map.put("layout/cart_item_book_grid_0", Integer.valueOf(com.eduteria.app.app.R.layout.cart_item_book_grid));
            map.put("layout-sw720dp/cart_item_book_grid_0", Integer.valueOf(com.eduteria.app.app.R.layout.cart_item_book_grid));
            map.put("layout-sw600dp/cart_item_book_grid_0", Integer.valueOf(com.eduteria.app.app.R.layout.cart_item_book_grid));
            map.put("layout-sw720dp/comment_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.comment_adapter));
            map.put("layout-sw600dp/comment_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.comment_adapter));
            map.put("layout/comment_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.comment_adapter));
            map.put("layout-sw720dp/custom_sme_studentlist_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_sme_studentlist));
            map.put("layout-sw600dp/custom_sme_studentlist_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_sme_studentlist));
            map.put("layout/custom_sme_studentlist_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_sme_studentlist));
            map.put("layout-sw600dp/custom_social_icons_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_social_icons));
            map.put("layout/custom_social_icons_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_social_icons));
            map.put("layout-sw720dp/custom_social_icons_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_social_icons));
            map.put("layout-sw720dp/custom_student_doubt_list_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_student_doubt_list));
            map.put("layout/custom_student_doubt_list_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_student_doubt_list));
            map.put("layout-sw600dp/custom_student_doubt_list_0", Integer.valueOf(com.eduteria.app.app.R.layout.custom_student_doubt_list));
            map.put("layout-sw720dp/dialog_alert_simple_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_alert_simple));
            map.put("layout-sw600dp/dialog_alert_simple_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_alert_simple));
            map.put("layout/dialog_alert_simple_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_alert_simple));
            map.put("layout-sw720dp/dialog_report_error_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_report_error));
            map.put("layout-sw600dp/dialog_report_error_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_report_error));
            map.put("layout/dialog_report_error_0", Integer.valueOf(com.eduteria.app.app.R.layout.dialog_report_error));
            map.put("layout-sw600dp/download_url_bitrate_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_url_bitrate));
            map.put("layout-sw720dp/download_url_bitrate_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_url_bitrate));
            map.put("layout/download_url_bitrate_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_url_bitrate));
            map.put("layout/download_youtube_bottom_sheet_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_youtube_bottom_sheet));
            map.put("layout-sw720dp/download_youtube_bottom_sheet_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_youtube_bottom_sheet));
            map.put("layout-sw600dp/download_youtube_bottom_sheet_0", Integer.valueOf(com.eduteria.app.app.R.layout.download_youtube_bottom_sheet));
            map.put("layout-sw720dp/enter_fib_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.enter_fib_layout));
            map.put("layout-sw600dp/enter_fib_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.enter_fib_layout));
            map.put("layout/enter_fib_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.enter_fib_layout));
            map.put("layout-sw720dp/feed_live_class_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_class_adapter));
            map.put("layout-sw600dp/feed_live_class_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_class_adapter));
            map.put("layout/feed_live_class_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_class_adapter));
            map.put("layout/feed_live_test_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_test_adapter));
            map.put("layout-sw720dp/feed_live_test_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_test_adapter));
            map.put("layout-sw600dp/feed_live_test_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.feed_live_test_adapter));
            map.put("layout-sw600dp/fragment_feeds_0", Integer.valueOf(com.eduteria.app.app.R.layout.fragment_feeds));
            map.put("layout-sw720dp/fragment_feeds_0", Integer.valueOf(com.eduteria.app.app.R.layout.fragment_feeds));
            map.put("layout/fragment_feeds_0", Integer.valueOf(com.eduteria.app.app.R.layout.fragment_feeds));
            map.put("layout-sw600dp/item11_0", Integer.valueOf(com.eduteria.app.app.R.layout.item11));
            map.put("layout-sw720dp/item11_0", Integer.valueOf(com.eduteria.app.app.R.layout.item11));
            map.put("layout/item11_0", Integer.valueOf(com.eduteria.app.app.R.layout.item11));
            map.put("layout-sw600dp/item_ssc_pattern_instruction_text_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_instruction_text));
            map.put("layout-sw720dp/item_ssc_pattern_instruction_text_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_instruction_text));
            map.put("layout/item_ssc_pattern_instruction_text_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_instruction_text));
            map.put("layout-sw720dp/item_ssc_pattern_num_box_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_num_box));
            map.put("layout-sw600dp/item_ssc_pattern_num_box_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_num_box));
            map.put("layout/item_ssc_pattern_num_box_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_num_box));
            map.put("layout/item_ssc_pattern_option_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_option));
            map.put("layout-sw600dp/item_ssc_pattern_option_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_option));
            map.put("layout-sw720dp/item_ssc_pattern_option_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_option));
            map.put("layout-sw600dp/item_ssc_pattern_question_viewpager_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_question_viewpager));
            map.put("layout-sw720dp/item_ssc_pattern_question_viewpager_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_question_viewpager));
            map.put("layout/item_ssc_pattern_question_viewpager_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_question_viewpager));
            map.put("layout-sw720dp/item_ssc_pattern_subject_part_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_part));
            map.put("layout-sw600dp/item_ssc_pattern_subject_part_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_part));
            map.put("layout/item_ssc_pattern_subject_part_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_part));
            map.put("layout/item_ssc_pattern_subject_tab_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_tab));
            map.put("layout-sw600dp/item_ssc_pattern_subject_tab_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_tab));
            map.put("layout-sw720dp/item_ssc_pattern_subject_tab_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_ssc_pattern_subject_tab));
            map.put("layout-sw720dp/item_view_conversatiuon_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_view_conversatiuon));
            map.put("layout-sw600dp/item_view_conversatiuon_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_view_conversatiuon));
            map.put("layout/item_view_conversatiuon_0", Integer.valueOf(com.eduteria.app.app.R.layout.item_view_conversatiuon));
            map.put("layout/layout_option_section_list_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.layout_option_section_list_view));
            map.put("layout-sw720dp/layout_option_section_list_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.layout_option_section_list_view));
            map.put("layout-sw600dp/layout_option_section_list_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.layout_option_section_list_view));
            map.put("layout-sw720dp/link_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.link_view));
            map.put("layout-sw600dp/link_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.link_view));
            map.put("layout/link_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.link_view));
            map.put("layout/list_rank_0", Integer.valueOf(com.eduteria.app.app.R.layout.list_rank));
            map.put("layout-sw720dp/list_rank_0", Integer.valueOf(com.eduteria.app.app.R.layout.list_rank));
            map.put("layout-sw600dp/list_rank_0", Integer.valueOf(com.eduteria.app.app.R.layout.list_rank));
            map.put("layout/live_class_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_class_vm));
            map.put("layout-sw600dp/live_class_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_class_vm));
            map.put("layout-sw720dp/live_class_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_class_vm));
            map.put("layout/live_test_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_test_vm));
            map.put("layout-sw720dp/live_test_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_test_vm));
            map.put("layout-sw600dp/live_test_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.live_test_vm));
            map.put("layout-sw720dp/new_course_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_course_vm));
            map.put("layout-sw600dp/new_course_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_course_vm));
            map.put("layout/new_course_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_course_vm));
            map.put("layout-sw600dp/new_test_result_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_test_result_adapter));
            map.put("layout-sw720dp/new_test_result_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_test_result_adapter));
            map.put("layout/new_test_result_adapter_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_test_result_adapter));
            map.put("layout/new_testresult_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_testresult_vm));
            map.put("layout-sw600dp/new_testresult_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_testresult_vm));
            map.put("layout-sw720dp/new_testresult_vm_0", Integer.valueOf(com.eduteria.app.app.R.layout.new_testresult_vm));
            map.put("layout/pending_purchase_banner_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_item));
            map.put("layout-sw720dp/pending_purchase_banner_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_item));
            map.put("layout-sw600dp/pending_purchase_banner_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_item));
            map.put("layout/pending_purchase_banner_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_layout));
            map.put("layout-sw600dp/pending_purchase_banner_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_layout));
            map.put("layout-sw720dp/pending_purchase_banner_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.pending_purchase_banner_layout));
            map.put("layout/popup_basicinfo_quiz_career_0", Integer.valueOf(com.eduteria.app.app.R.layout.popup_basicinfo_quiz_career));
            map.put("layout-sw600dp/popup_basicinfo_quiz_career_0", Integer.valueOf(com.eduteria.app.app.R.layout.popup_basicinfo_quiz_career));
            map.put("layout-sw720dp/popup_basicinfo_quiz_career_0", Integer.valueOf(com.eduteria.app.app.R.layout.popup_basicinfo_quiz_career));
            map.put("layout-sw720dp/post_image_0", Integer.valueOf(com.eduteria.app.app.R.layout.post_image));
            map.put("layout-sw600dp/post_image_0", Integer.valueOf(com.eduteria.app.app.R.layout.post_image));
            map.put("layout/post_image_0", Integer.valueOf(com.eduteria.app.app.R.layout.post_image));
            map.put("layout/question_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.question_view));
            map.put("layout-sw720dp/question_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.question_view));
            map.put("layout-sw600dp/question_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.question_view));
            map.put("layout-sw600dp/quiz_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.quiz_view));
            map.put("layout-sw720dp/quiz_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.quiz_view));
            map.put("layout/quiz_view_0", Integer.valueOf(com.eduteria.app.app.R.layout.quiz_view));
            map.put("layout/rating_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.rating_dialog));
            map.put("layout-sw600dp/rating_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.rating_dialog));
            map.put("layout-sw720dp/rating_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.rating_dialog));
            map.put("layout-sw600dp/select_media_file_0", Integer.valueOf(com.eduteria.app.app.R.layout.select_media_file));
            map.put("layout-sw720dp/select_media_file_0", Integer.valueOf(com.eduteria.app.app.R.layout.select_media_file));
            map.put("layout/select_media_file_0", Integer.valueOf(com.eduteria.app.app.R.layout.select_media_file));
            map.put("layout-sw720dp/ssc_enter_fib_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_enter_fib_dialog));
            map.put("layout-sw600dp/ssc_enter_fib_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_enter_fib_dialog));
            map.put("layout/ssc_enter_fib_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_enter_fib_dialog));
            map.put("layout/ssc_instructions_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_instructions_dialog));
            map.put("layout-sw600dp/ssc_instructions_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_instructions_dialog));
            map.put("layout-sw720dp/ssc_instructions_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_instructions_dialog));
            map.put("layout-sw720dp/ssc_pattern_back_submit_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_back_submit_dialog));
            map.put("layout-sw600dp/ssc_pattern_back_submit_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_back_submit_dialog));
            map.put("layout/ssc_pattern_back_submit_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_back_submit_dialog));
            map.put("layout/ssc_pattern_drawer_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_drawer_layout));
            map.put("layout-sw600dp/ssc_pattern_drawer_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_drawer_layout));
            map.put("layout-sw720dp/ssc_pattern_drawer_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_drawer_layout));
            map.put("layout-sw600dp/ssc_pattern_section_switch_dailog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_section_switch_dailog));
            map.put("layout-sw720dp/ssc_pattern_section_switch_dailog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_section_switch_dailog));
            map.put("layout/ssc_pattern_section_switch_dailog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_section_switch_dailog));
            map.put("layout-sw600dp/ssc_pattern_time_out_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_time_out_dialog));
            map.put("layout-sw720dp/ssc_pattern_time_out_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_time_out_dialog));
            map.put("layout/ssc_pattern_time_out_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_time_out_dialog));
            map.put("layout-sw600dp/ssc_pattern_toolbar_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_toolbar_layout));
            map.put("layout-sw720dp/ssc_pattern_toolbar_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_toolbar_layout));
            map.put("layout/ssc_pattern_toolbar_layout_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_pattern_toolbar_layout));
            map.put("layout-sw600dp/ssc_symbols_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_symbols_dialog));
            map.put("layout-sw720dp/ssc_symbols_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_symbols_dialog));
            map.put("layout/ssc_symbols_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.ssc_symbols_dialog));
            map.put("layout/subscription_plan_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.subscription_plan_item));
            map.put("layout-sw720dp/subscription_plan_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.subscription_plan_item));
            map.put("layout-sw600dp/subscription_plan_item_0", Integer.valueOf(com.eduteria.app.app.R.layout.subscription_plan_item));
            map.put("layout-sw600dp/thank_you_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.thank_you_dialog));
            map.put("layout-sw720dp/thank_you_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.thank_you_dialog));
            map.put("layout/thank_you_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.thank_you_dialog));
            map.put("layout/video_post_0", Integer.valueOf(com.eduteria.app.app.R.layout.video_post));
            map.put("layout-sw720dp/video_post_0", Integer.valueOf(com.eduteria.app.app.R.layout.video_post));
            map.put("layout-sw600dp/video_post_0", Integer.valueOf(com.eduteria.app.app.R.layout.video_post));
            map.put("layout/view_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.view_dialog));
            map.put("layout-sw600dp/view_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.view_dialog));
            map.put("layout-sw720dp/view_dialog_0", Integer.valueOf(com.eduteria.app.app.R.layout.view_dialog));
        }
    }
}
