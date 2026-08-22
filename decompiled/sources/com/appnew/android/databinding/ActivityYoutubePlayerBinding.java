package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.player.YTubePlayerView;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityYoutubePlayerBinding implements ViewBinding {
    public final TextView addBookmark;
    public final RecyclerView addOptionRecycler;
    public final RelativeLayout addOptionRl;
    public final RelativeLayout addPoll;
    public final RelativeLayout audioLayoutRl;
    public final LinearLayout audioMainLL;
    public final TextView audioRecordTime;
    public final LinearLayout autoplayRow;
    public final CardView bookmarkBtn;
    public final ImageView bookmarkIcon;
    public final LinearLayout bookmarkLinear;
    public final LinearLayout bottomlayout;
    public final ImageView cancelRecording;
    public final CardView chatBtn;
    public final LinearLayout chatLinear;
    public final RelativeLayout chatMainRl;
    public final CheckBox checkMark;
    public final RelativeLayout createPoll;
    public final NestedScrollView createPollNestedScrollView;
    public final RelativeLayout delayDurationRl;
    public final TextView delayDurationText;
    public final CardView doubtBtn;
    public final ImageView doubtIcon;
    public final LinearLayout doubtLinear;
    public final TextView doubtText;
    public final ImageView emoji;
    public final LinearLayout endLayout;
    public final EditText enterDelayET;
    public final EditText enterQuestionET;
    public final RelativeLayout enterQuestionRl;
    public final TextView enterTimeET;
    public final EditText etMessage;
    public final ImageView fileUpload;
    public final TextView floatingTextNew;
    public final LinearLayout forDoubtll;
    public final FrameLayout fullScreenViewContainer;
    public final TextView generateLeaderboard;
    public final RelativeLayout goToCurrentRl;
    public final ImageView icBackPdf;
    public final ImageView icFullPdf;
    public final CardView indexBtn;
    public final ImageView indexIcon;
    public final LinearLayout indexLinear;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    public final LinearLayout linearLayout1;
    public final ImageView liveChatIcon;
    public final ImageView liveDot;
    public final LinearLayout llChatSetting;
    public final LinearLayout llMarkRead;
    public final LinearLayout llll;
    public final TextView loveImage;
    public final RelativeLayout messageRl;
    public final RelativeLayout newYoutubePlayer;
    public final TextView nextVideo;
    public final LinearLayout operatorLL;
    public final ImageView pauseAudio;
    public final CardView pdfBtn;
    public final ImageView pdfIcon;
    public final LinearLayout pdfLinear;
    public final TextView pdfText;
    public final PDFView pdfView;
    public final TextView pinChat;
    public final LinearLayout pinll;
    public final CardView poll;
    public final ImageView pollIcon;
    public final ImageView pollImage;
    public final LinearLayout pollMain;
    public final RelativeLayout pollRl;
    public final ImageView pollSubmit;
    public final TextView pollText;
    public final TextView pollType;
    public final ProgressBar progressBar;
    public final ProgressBar progressBarPdf;
    public final RelativeLayout publishDoubts;
    public final TextView publishTxt;
    public final ImageView quality;
    public final TextView questionText;
    public final RecyclerView recyclerView;
    public final RecyclerView recylerViewPollOperator;
    public final ImageView refreshUrl;
    public final RelativeLayout refressDoubtRl;
    public final FrameLayout relativeLYoutubeLogo;
    public final FrameLayout relativeLYoutubeLogoTab;
    public final RelativeLayout relativeLayout;
    public final RelativeLayout relativeLayout1;
    public final RelativeLayout relativeLayoutTab;
    public final RelativeLayout rlPdfData;
    public final RelativeLayout rootNew;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final RelativeLayout selectMode;
    public final ImageView sendRecording;
    public final ImageView startaudio;
    public final RelativeLayout submitDoubts;
    public final RelativeLayout submitPoll;
    public final FrameLayout suggestedVideoTab;
    public final SwitchCompat switchChat;
    public final SwitchCompat switchEmoticons;
    public final SwitchCompat switchFeedback;
    public final SwitchCompat switchPublic;
    public final LinearLayout textLayout;
    public final RelativeLayout timeDurationRl;
    public final TextView timeDurationText;
    public final RelativeLayout topImage;
    public final TextView tvMark;
    public final TextView unpublishtxt;
    public final ImageView videoBookmark;
    public final ImageView videoFeedback;
    public final RelativeLayout videoLayout;
    public final TextView videoName;
    public final TextView viewLeaderboard;
    public final ImageView vodChatIcon;
    public final CardView vodchatBtn;
    public final LinearLayout vodchatLinear;
    public final YouTubePlayerView youtubePlayer2;
    public final YTubePlayerView youtubePlayerView;
    public final PlayerView youtubePlayerViewExo;
    public final FrameLayout youtubePlayerViewLay;
    public final RelativeLayout youtubePlayerViewLay1;

    private ActivityYoutubePlayerBinding(RelativeLayout rootView_, TextView addBookmark, RecyclerView addOptionRecycler, RelativeLayout addOptionRl, RelativeLayout addPoll, RelativeLayout audioLayoutRl, LinearLayout audioMainLL, TextView audioRecordTime, LinearLayout autoplayRow, CardView bookmarkBtn, ImageView bookmarkIcon, LinearLayout bookmarkLinear, LinearLayout bottomlayout, ImageView cancelRecording, CardView chatBtn, LinearLayout chatLinear, RelativeLayout chatMainRl, CheckBox checkMark, RelativeLayout createPoll, NestedScrollView createPollNestedScrollView, RelativeLayout delayDurationRl, TextView delayDurationText, CardView doubtBtn, ImageView doubtIcon, LinearLayout doubtLinear, TextView doubtText, ImageView emoji, LinearLayout endLayout, EditText enterDelayET, EditText enterQuestionET, RelativeLayout enterQuestionRl, TextView enterTimeET, EditText etMessage, ImageView fileUpload, TextView floatingTextNew, LinearLayout forDoubtll, FrameLayout fullScreenViewContainer, TextView generateLeaderboard, RelativeLayout goToCurrentRl, ImageView icBackPdf, ImageView icFullPdf, CardView indexBtn, ImageView indexIcon, LinearLayout indexLinear, ImageView ivSend, LinearLayout linearLayout, LinearLayout linearLayout1, ImageView liveChatIcon, ImageView liveDot, LinearLayout llChatSetting, LinearLayout llMarkRead, LinearLayout llll, TextView loveImage, RelativeLayout messageRl, RelativeLayout newYoutubePlayer, TextView nextVideo, LinearLayout operatorLL, ImageView pauseAudio, CardView pdfBtn, ImageView pdfIcon, LinearLayout pdfLinear, TextView pdfText, PDFView pdfView, TextView pinChat, LinearLayout pinll, CardView poll, ImageView pollIcon, ImageView pollImage, LinearLayout pollMain, RelativeLayout pollRl, ImageView pollSubmit, TextView pollText, TextView pollType, ProgressBar progressBar, ProgressBar progressBarPdf, RelativeLayout publishDoubts, TextView publishTxt, ImageView quality, TextView questionText, RecyclerView recyclerView, RecyclerView recylerViewPollOperator, ImageView refreshUrl, RelativeLayout refressDoubtRl, FrameLayout relativeLYoutubeLogo, FrameLayout relativeLYoutubeLogoTab, RelativeLayout relativeLayout, RelativeLayout relativeLayout1, RelativeLayout relativeLayoutTab, RelativeLayout rlPdfData, RelativeLayout rootNew, RelativeLayout rootView, RelativeLayout selectMode, ImageView sendRecording, ImageView startaudio, RelativeLayout submitDoubts, RelativeLayout submitPoll, FrameLayout suggestedVideoTab, SwitchCompat switchChat, SwitchCompat switchEmoticons, SwitchCompat switchFeedback, SwitchCompat switchPublic, LinearLayout textLayout, RelativeLayout timeDurationRl, TextView timeDurationText, RelativeLayout topImage, TextView tvMark, TextView unpublishtxt, ImageView videoBookmark, ImageView videoFeedback, RelativeLayout videoLayout, TextView videoName, TextView viewLeaderboard, ImageView vodChatIcon, CardView vodchatBtn, LinearLayout vodchatLinear, YouTubePlayerView youtubePlayer2, YTubePlayerView youtubePlayerView, PlayerView youtubePlayerViewExo, FrameLayout youtubePlayerViewLay, RelativeLayout youtubePlayerViewLay1) {
        this.rootView_ = rootView_;
        this.addBookmark = addBookmark;
        this.addOptionRecycler = addOptionRecycler;
        this.addOptionRl = addOptionRl;
        this.addPoll = addPoll;
        this.audioLayoutRl = audioLayoutRl;
        this.audioMainLL = audioMainLL;
        this.audioRecordTime = audioRecordTime;
        this.autoplayRow = autoplayRow;
        this.bookmarkBtn = bookmarkBtn;
        this.bookmarkIcon = bookmarkIcon;
        this.bookmarkLinear = bookmarkLinear;
        this.bottomlayout = bottomlayout;
        this.cancelRecording = cancelRecording;
        this.chatBtn = chatBtn;
        this.chatLinear = chatLinear;
        this.chatMainRl = chatMainRl;
        this.checkMark = checkMark;
        this.createPoll = createPoll;
        this.createPollNestedScrollView = createPollNestedScrollView;
        this.delayDurationRl = delayDurationRl;
        this.delayDurationText = delayDurationText;
        this.doubtBtn = doubtBtn;
        this.doubtIcon = doubtIcon;
        this.doubtLinear = doubtLinear;
        this.doubtText = doubtText;
        this.emoji = emoji;
        this.endLayout = endLayout;
        this.enterDelayET = enterDelayET;
        this.enterQuestionET = enterQuestionET;
        this.enterQuestionRl = enterQuestionRl;
        this.enterTimeET = enterTimeET;
        this.etMessage = etMessage;
        this.fileUpload = fileUpload;
        this.floatingTextNew = floatingTextNew;
        this.forDoubtll = forDoubtll;
        this.fullScreenViewContainer = fullScreenViewContainer;
        this.generateLeaderboard = generateLeaderboard;
        this.goToCurrentRl = goToCurrentRl;
        this.icBackPdf = icBackPdf;
        this.icFullPdf = icFullPdf;
        this.indexBtn = indexBtn;
        this.indexIcon = indexIcon;
        this.indexLinear = indexLinear;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
        this.linearLayout1 = linearLayout1;
        this.liveChatIcon = liveChatIcon;
        this.liveDot = liveDot;
        this.llChatSetting = llChatSetting;
        this.llMarkRead = llMarkRead;
        this.llll = llll;
        this.loveImage = loveImage;
        this.messageRl = messageRl;
        this.newYoutubePlayer = newYoutubePlayer;
        this.nextVideo = nextVideo;
        this.operatorLL = operatorLL;
        this.pauseAudio = pauseAudio;
        this.pdfBtn = pdfBtn;
        this.pdfIcon = pdfIcon;
        this.pdfLinear = pdfLinear;
        this.pdfText = pdfText;
        this.pdfView = pdfView;
        this.pinChat = pinChat;
        this.pinll = pinll;
        this.poll = poll;
        this.pollIcon = pollIcon;
        this.pollImage = pollImage;
        this.pollMain = pollMain;
        this.pollRl = pollRl;
        this.pollSubmit = pollSubmit;
        this.pollText = pollText;
        this.pollType = pollType;
        this.progressBar = progressBar;
        this.progressBarPdf = progressBarPdf;
        this.publishDoubts = publishDoubts;
        this.publishTxt = publishTxt;
        this.quality = quality;
        this.questionText = questionText;
        this.recyclerView = recyclerView;
        this.recylerViewPollOperator = recylerViewPollOperator;
        this.refreshUrl = refreshUrl;
        this.refressDoubtRl = refressDoubtRl;
        this.relativeLYoutubeLogo = relativeLYoutubeLogo;
        this.relativeLYoutubeLogoTab = relativeLYoutubeLogoTab;
        this.relativeLayout = relativeLayout;
        this.relativeLayout1 = relativeLayout1;
        this.relativeLayoutTab = relativeLayoutTab;
        this.rlPdfData = rlPdfData;
        this.rootNew = rootNew;
        this.rootView = rootView;
        this.selectMode = selectMode;
        this.sendRecording = sendRecording;
        this.startaudio = startaudio;
        this.submitDoubts = submitDoubts;
        this.submitPoll = submitPoll;
        this.suggestedVideoTab = suggestedVideoTab;
        this.switchChat = switchChat;
        this.switchEmoticons = switchEmoticons;
        this.switchFeedback = switchFeedback;
        this.switchPublic = switchPublic;
        this.textLayout = textLayout;
        this.timeDurationRl = timeDurationRl;
        this.timeDurationText = timeDurationText;
        this.topImage = topImage;
        this.tvMark = tvMark;
        this.unpublishtxt = unpublishtxt;
        this.videoBookmark = videoBookmark;
        this.videoFeedback = videoFeedback;
        this.videoLayout = videoLayout;
        this.videoName = videoName;
        this.viewLeaderboard = viewLeaderboard;
        this.vodChatIcon = vodChatIcon;
        this.vodchatBtn = vodchatBtn;
        this.vodchatLinear = vodchatLinear;
        this.youtubePlayer2 = youtubePlayer2;
        this.youtubePlayerView = youtubePlayerView;
        this.youtubePlayerViewExo = youtubePlayerViewExo;
        this.youtubePlayerViewLay = youtubePlayerViewLay;
        this.youtubePlayerViewLay1 = youtubePlayerViewLay1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityYoutubePlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityYoutubePlayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_youtube_player, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityYoutubePlayerBinding bind(View rootView) {
        int i = R.id.add_bookmark;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_bookmark);
        if (textView != null) {
            i = R.id.addOptionRecycler;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.addOptionRecycler);
            if (recyclerView != null) {
                i = R.id.addOptionRl;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addOptionRl);
                if (relativeLayout != null) {
                    i = R.id.addPoll;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addPoll);
                    if (relativeLayout2 != null) {
                        i = R.id.audioLayoutRl;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.audioLayoutRl);
                        if (relativeLayout3 != null) {
                            i = R.id.audioMainLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.audioMainLL);
                            if (linearLayout != null) {
                                i = R.id.audioRecordTime;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioRecordTime);
                                if (textView2 != null) {
                                    i = R.id.autoplayRow;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.autoplayRow);
                                    if (linearLayout2 != null) {
                                        i = R.id.bookmark_btn;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.bookmark_btn);
                                        if (cardView != null) {
                                            i = R.id.bookmarkIcon;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookmarkIcon);
                                            if (imageView != null) {
                                                i = R.id.bookmarkLinear;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bookmarkLinear);
                                                if (linearLayout3 != null) {
                                                    i = R.id.bottomlayout;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomlayout);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.cancelRecording;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelRecording);
                                                        if (imageView2 != null) {
                                                            i = R.id.chat_btn;
                                                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.chat_btn);
                                                            if (cardView2 != null) {
                                                                i = R.id.chatLinear;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.chatLinear);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.chatMainRl;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.chatMainRl);
                                                                    if (relativeLayout4 != null) {
                                                                        i = R.id.checkMark;
                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkMark);
                                                                        if (checkBox != null) {
                                                                            i = R.id.createPoll;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.createPoll);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.createPollNestedScrollView;
                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.createPollNestedScrollView);
                                                                                if (nestedScrollView != null) {
                                                                                    i = R.id.delayDurationRl;
                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.delayDurationRl);
                                                                                    if (relativeLayout6 != null) {
                                                                                        i = R.id.delayDurationText;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delayDurationText);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.doubt_btn;
                                                                                            CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.doubt_btn);
                                                                                            if (cardView3 != null) {
                                                                                                i = R.id.doubtIcon;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubtIcon);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.doubtLinear;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doubtLinear);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.doubtText;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubtText);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.emoji;
                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.emoji);
                                                                                                            if (imageView4 != null) {
                                                                                                                i = R.id.endLayout;
                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.endLayout);
                                                                                                                if (linearLayout7 != null) {
                                                                                                                    i = R.id.enterDelayET;
                                                                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterDelayET);
                                                                                                                    if (editText != null) {
                                                                                                                        i = R.id.enterQuestionET;
                                                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterQuestionET);
                                                                                                                        if (editText2 != null) {
                                                                                                                            i = R.id.enterQuestionRl;
                                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.enterQuestionRl);
                                                                                                                            if (relativeLayout7 != null) {
                                                                                                                                i = R.id.enterTimeET;
                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enterTimeET);
                                                                                                                                if (textView5 != null) {
                                                                                                                                    i = R.id.et_message;
                                                                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                                                                                                                                    if (editText3 != null) {
                                                                                                                                        i = R.id.file_upload;
                                                                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.file_upload);
                                                                                                                                        if (imageView5 != null) {
                                                                                                                                            i = R.id.floatingText_new;
                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
                                                                                                                                            if (textView6 != null) {
                                                                                                                                                i = R.id.forDoubtll;
                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.forDoubtll);
                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                    i = R.id.full_screen_view_container;
                                                                                                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.full_screen_view_container);
                                                                                                                                                    if (frameLayout != null) {
                                                                                                                                                        i = R.id.generateLeaderboard;
                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.generateLeaderboard);
                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                            i = R.id.goToCurrentRl;
                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.goToCurrentRl);
                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                i = R.id.ic_back_pdf;
                                                                                                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ic_back_pdf);
                                                                                                                                                                if (imageView6 != null) {
                                                                                                                                                                    i = R.id.ic_full_pdf;
                                                                                                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ic_full_pdf);
                                                                                                                                                                    if (imageView7 != null) {
                                                                                                                                                                        i = R.id.index_btn;
                                                                                                                                                                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, R.id.index_btn);
                                                                                                                                                                        if (cardView4 != null) {
                                                                                                                                                                            i = R.id.indexIcon;
                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.indexIcon);
                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                i = R.id.indexLinear;
                                                                                                                                                                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.indexLinear);
                                                                                                                                                                                if (linearLayout9 != null) {
                                                                                                                                                                                    i = R.id.iv_send;
                                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                                        i = R.id.linearLayout;
                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                            i = R.id.linearLayout1;
                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout1);
                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                i = R.id.liveChatIcon;
                                                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveChatIcon);
                                                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                                                    i = R.id.liveDot;
                                                                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveDot);
                                                                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                                                                        i = R.id.llChatSetting;
                                                                                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llChatSetting);
                                                                                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                                                                                            i = R.id.llMarkRead;
                                                                                                                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMarkRead);
                                                                                                                                                                                                            if (linearLayout13 != null) {
                                                                                                                                                                                                                i = R.id.llll;
                                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llll);
                                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                                    i = R.id.loveImage;
                                                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loveImage);
                                                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                                                        i = R.id.messageRl;
                                                                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.messageRl);
                                                                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                                                                            i = R.id.newYoutubePlayer;
                                                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.newYoutubePlayer);
                                                                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                                                                i = R.id.nextVideo;
                                                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextVideo);
                                                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                                                    i = R.id.operatorLL;
                                                                                                                                                                                                                                    LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.operatorLL);
                                                                                                                                                                                                                                    if (linearLayout15 != null) {
                                                                                                                                                                                                                                        i = R.id.pauseAudio;
                                                                                                                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pauseAudio);
                                                                                                                                                                                                                                        if (imageView12 != null) {
                                                                                                                                                                                                                                            i = R.id.pdf_btn;
                                                                                                                                                                                                                                            CardView cardView5 = (CardView) ViewBindings.findChildViewById(rootView, R.id.pdf_btn);
                                                                                                                                                                                                                                            if (cardView5 != null) {
                                                                                                                                                                                                                                                i = R.id.pdfIcon;
                                                                                                                                                                                                                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdfIcon);
                                                                                                                                                                                                                                                if (imageView13 != null) {
                                                                                                                                                                                                                                                    i = R.id.pdfLinear;
                                                                                                                                                                                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfLinear);
                                                                                                                                                                                                                                                    if (linearLayout16 != null) {
                                                                                                                                                                                                                                                        i = R.id.pdfText;
                                                                                                                                                                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText);
                                                                                                                                                                                                                                                        if (textView10 != null) {
                                                                                                                                                                                                                                                            i = R.id.pdfView;
                                                                                                                                                                                                                                                            PDFView pDFView = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfView);
                                                                                                                                                                                                                                                            if (pDFView != null) {
                                                                                                                                                                                                                                                                i = R.id.pinChat;
                                                                                                                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pinChat);
                                                                                                                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                                                                                                                    i = R.id.pinll;
                                                                                                                                                                                                                                                                    LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pinll);
                                                                                                                                                                                                                                                                    if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                        i = R.id.poll;
                                                                                                                                                                                                                                                                        CardView cardView6 = (CardView) ViewBindings.findChildViewById(rootView, R.id.poll);
                                                                                                                                                                                                                                                                        if (cardView6 != null) {
                                                                                                                                                                                                                                                                            i = R.id.pollIcon;
                                                                                                                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollIcon);
                                                                                                                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                                                                                                                i = R.id.pollImage;
                                                                                                                                                                                                                                                                                ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollImage);
                                                                                                                                                                                                                                                                                if (imageView15 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.pollMain;
                                                                                                                                                                                                                                                                                    LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pollMain);
                                                                                                                                                                                                                                                                                    if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.pollRl;
                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pollRl);
                                                                                                                                                                                                                                                                                        if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.pollSubmit;
                                                                                                                                                                                                                                                                                            ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollSubmit);
                                                                                                                                                                                                                                                                                            if (imageView16 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.pollText;
                                                                                                                                                                                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollText);
                                                                                                                                                                                                                                                                                                if (textView12 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.pollType;
                                                                                                                                                                                                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollType);
                                                                                                                                                                                                                                                                                                    if (textView13 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.progress_bar;
                                                                                                                                                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                                                                                                                                                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.progress_bar_pdf;
                                                                                                                                                                                                                                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar_pdf);
                                                                                                                                                                                                                                                                                                            if (progressBar2 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.publishDoubts;
                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.publishDoubts);
                                                                                                                                                                                                                                                                                                                if (relativeLayout12 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.publishTxt;
                                                                                                                                                                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.publishTxt);
                                                                                                                                                                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.quality;
                                                                                                                                                                                                                                                                                                                        ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                                                                                                                                                                                                                                                                                        if (imageView17 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.questionText;
                                                                                                                                                                                                                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questionText);
                                                                                                                                                                                                                                                                                                                            if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.recycler_view;
                                                                                                                                                                                                                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view);
                                                                                                                                                                                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.recylerViewPollOperator;
                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recylerViewPollOperator);
                                                                                                                                                                                                                                                                                                                                    if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.refreshUrl;
                                                                                                                                                                                                                                                                                                                                        ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refreshUrl);
                                                                                                                                                                                                                                                                                                                                        if (imageView18 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.refressDoubtRl;
                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.refressDoubtRl);
                                                                                                                                                                                                                                                                                                                                            if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.relativeLYoutubeLogo;
                                                                                                                                                                                                                                                                                                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLYoutubeLogo);
                                                                                                                                                                                                                                                                                                                                                if (frameLayout2 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.relativeLYoutubeLogoTab;
                                                                                                                                                                                                                                                                                                                                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLYoutubeLogoTab);
                                                                                                                                                                                                                                                                                                                                                    if (frameLayout3 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.relativeLayout;
                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout);
                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.relativeLayout1;
                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout1);
                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.relativeLayoutTab;
                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayoutTab);
                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.rl_pdf_data;
                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_pdf_data);
                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.root_new;
                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout19 = (RelativeLayout) rootView;
                                                                                                                                                                                                                                                                                                                                                                            i = R.id.selectMode;
                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.selectMode);
                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                i = R.id.sendRecording;
                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.sendRecording);
                                                                                                                                                                                                                                                                                                                                                                                if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.startaudio;
                                                                                                                                                                                                                                                                                                                                                                                    ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.startaudio);
                                                                                                                                                                                                                                                                                                                                                                                    if (imageView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.submitDoubts;
                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout21 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.submitDoubts);
                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.submitPoll;
                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout22 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.submitPoll);
                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.suggestedVideoTab;
                                                                                                                                                                                                                                                                                                                                                                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.suggestedVideoTab);
                                                                                                                                                                                                                                                                                                                                                                                                if (frameLayout4 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.switchChat;
                                                                                                                                                                                                                                                                                                                                                                                                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.switchChat);
                                                                                                                                                                                                                                                                                                                                                                                                    if (switchCompat != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.switchEmoticons;
                                                                                                                                                                                                                                                                                                                                                                                                        SwitchCompat switchCompat2 = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.switchEmoticons);
                                                                                                                                                                                                                                                                                                                                                                                                        if (switchCompat2 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.switchFeedback;
                                                                                                                                                                                                                                                                                                                                                                                                            SwitchCompat switchCompat3 = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.switchFeedback);
                                                                                                                                                                                                                                                                                                                                                                                                            if (switchCompat3 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.switchPublic;
                                                                                                                                                                                                                                                                                                                                                                                                                SwitchCompat switchCompat4 = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.switchPublic);
                                                                                                                                                                                                                                                                                                                                                                                                                if (switchCompat4 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.textLayout;
                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textLayout);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.timeDurationRl;
                                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout23 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.timeDurationRl);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.timeDurationText;
                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeDurationText);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.topImage;
                                                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout24 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topImage);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.tvMark;
                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMark);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.unpublishtxt;
                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unpublishtxt);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.video_bookmark;
                                                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.video_bookmark);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.video_feedback;
                                                                                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.video_feedback);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (imageView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.video_layout;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout25 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.video_layout);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout25 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.video_name;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.viewLeaderboard;
                                                                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewLeaderboard);
                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.vodChatIcon;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vodChatIcon);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (imageView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.vodchat_btn;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    CardView cardView7 = (CardView) ViewBindings.findChildViewById(rootView, R.id.vodchat_btn);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (cardView7 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.vodchatLinear;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.vodchatLinear);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (linearLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.youtube_player2;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(rootView, R.id.youtube_player2);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (youTubePlayerView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.youtube_player_view;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                YTubePlayerView yTubePlayerView = (YTubePlayerView) ViewBindings.findChildViewById(rootView, R.id.youtube_player_view);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                if (yTubePlayerView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.youtube_player_view_exo;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.youtube_player_view_exo);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (playerView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.youtubePlayerViewLay;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.youtubePlayerViewLay);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (frameLayout5 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.youtubePlayerViewLay1;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout26 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.youtubePlayerViewLay1);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if (relativeLayout26 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                return new ActivityYoutubePlayerBinding(relativeLayout19, textView, recyclerView, relativeLayout, relativeLayout2, relativeLayout3, linearLayout, textView2, linearLayout2, cardView, imageView, linearLayout3, linearLayout4, imageView2, cardView2, linearLayout5, relativeLayout4, checkBox, relativeLayout5, nestedScrollView, relativeLayout6, textView3, cardView3, imageView3, linearLayout6, textView4, imageView4, linearLayout7, editText, editText2, relativeLayout7, textView5, editText3, imageView5, textView6, linearLayout8, frameLayout, textView7, relativeLayout8, imageView6, imageView7, cardView4, imageView8, linearLayout9, imageView9, linearLayout10, linearLayout11, imageView10, imageView11, linearLayout12, linearLayout13, linearLayout14, textView8, relativeLayout9, relativeLayout10, textView9, linearLayout15, imageView12, cardView5, imageView13, linearLayout16, textView10, pDFView, textView11, linearLayout17, cardView6, imageView14, imageView15, linearLayout18, relativeLayout11, imageView16, textView12, textView13, progressBar, progressBar2, relativeLayout12, textView14, imageView17, textView15, recyclerView2, recyclerView3, imageView18, relativeLayout13, frameLayout2, frameLayout3, relativeLayout14, relativeLayout15, relativeLayout16, relativeLayout17, relativeLayout18, relativeLayout19, relativeLayout20, imageView19, imageView20, relativeLayout21, relativeLayout22, frameLayout4, switchCompat, switchCompat2, switchCompat3, switchCompat4, linearLayout19, relativeLayout23, textView16, relativeLayout24, textView17, textView18, imageView21, imageView22, relativeLayout25, textView19, textView20, imageView23, cardView7, linearLayout20, youTubePlayerView, yTubePlayerView, playerView, frameLayout5, relativeLayout26);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
