package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
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
import com.appnew.android.player.music_player.ZoomableVideoView;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityLiveawsactivityBinding implements ViewBinding {
    public final TextView addBookmark;
    public final RecyclerView addOptionRecycler;
    public final RelativeLayout addOptionRl;
    public final RelativeLayout addPoll;
    public final RelativeLayout audioLayoutRl;
    public final LinearLayout audioMainLL;
    public final TextView audioRecordTime;
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
    public final ImageView cross;
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
    public final ImageView expand;
    public final ImageView fileUpload;
    public final TextView floatingTextNew;
    public final LinearLayout forDoubtll;
    public final TextView generateLeaderboard;
    public final RelativeLayout goToCurrentRl;
    public final ImageView icBackPdf;
    public final ImageView icFullPdf;
    public final CardView indexBtn;
    public final ImageView indexIcon;
    public final LinearLayout indexLinear;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    public final ImageView liveChatIcon;
    public final ImageView liveDot;
    public final LinearLayout llChatSetting;
    public final LinearLayout llMarkRead;
    public final LinearLayout llTitle;
    public final LinearLayout llll;
    public final TextView loveImage;
    public final RelativeLayout mainRoot;
    public final RelativeLayout messageRl;
    public final LinearLayout operatorLL;
    public final ImageView pauseAudio;
    public final CardView pdfBtn;
    public final ImageView pdfIcon;
    public final LinearLayout pdfLinear;
    public final TextView pdfText;
    public final PDFView pdfView;
    public final RelativeLayout pdfViewLayout;
    public final PDFView pdfViewPager;
    public final TextView pinChat;
    public final LinearLayout pinll;
    public final PlayerView playerViewNew;
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
    public final RelativeLayout refressDoubtRl;
    public final RelativeLayout rlPdfData;
    public final RelativeLayout rootNew;
    private final RelativeLayout rootView;
    public final RelativeLayout selectMode;
    public final ImageView sendRecording;
    public final ImageView startaudio;
    public final RelativeLayout submitDoubts;
    public final RelativeLayout submitPoll;
    public final SwitchCompat switchChat;
    public final SwitchCompat switchEmoticons;
    public final SwitchCompat switchFeedback;
    public final SwitchCompat switchPublic;
    public final LinearLayout textLayout;
    public final RelativeLayout timeDurationRl;
    public final TextView timeDurationText;
    public final RelativeLayout topImage;
    public final TextView tvMark;
    public final TextView txtTimer;
    public final TextView unpublishtxt;
    public final ImageView videoBookmark;
    public final ImageView videoFeedback;
    public final RelativeLayout videoLayout;
    public final TextView videoName;
    public final TextView viewLeaderboard;
    public final ImageView vodChatIcon;
    public final CardView vodchatBtn;
    public final LinearLayout vodchatLinear;
    public final ZoomableVideoView zoomableVideoView;

    private ActivityLiveawsactivityBinding(RelativeLayout rootView, TextView addBookmark, RecyclerView addOptionRecycler, RelativeLayout addOptionRl, RelativeLayout addPoll, RelativeLayout audioLayoutRl, LinearLayout audioMainLL, TextView audioRecordTime, CardView bookmarkBtn, ImageView bookmarkIcon, LinearLayout bookmarkLinear, LinearLayout bottomlayout, ImageView cancelRecording, CardView chatBtn, LinearLayout chatLinear, RelativeLayout chatMainRl, CheckBox checkMark, RelativeLayout createPoll, NestedScrollView createPollNestedScrollView, ImageView cross, RelativeLayout delayDurationRl, TextView delayDurationText, CardView doubtBtn, ImageView doubtIcon, LinearLayout doubtLinear, TextView doubtText, ImageView emoji, LinearLayout endLayout, EditText enterDelayET, EditText enterQuestionET, RelativeLayout enterQuestionRl, TextView enterTimeET, EditText etMessage, ImageView expand, ImageView fileUpload, TextView floatingTextNew, LinearLayout forDoubtll, TextView generateLeaderboard, RelativeLayout goToCurrentRl, ImageView icBackPdf, ImageView icFullPdf, CardView indexBtn, ImageView indexIcon, LinearLayout indexLinear, ImageView ivSend, LinearLayout linearLayout, ImageView liveChatIcon, ImageView liveDot, LinearLayout llChatSetting, LinearLayout llMarkRead, LinearLayout llTitle, LinearLayout llll, TextView loveImage, RelativeLayout mainRoot, RelativeLayout messageRl, LinearLayout operatorLL, ImageView pauseAudio, CardView pdfBtn, ImageView pdfIcon, LinearLayout pdfLinear, TextView pdfText, PDFView pdfView, RelativeLayout pdfViewLayout, PDFView pdfViewPager, TextView pinChat, LinearLayout pinll, PlayerView playerViewNew, CardView poll, ImageView pollIcon, ImageView pollImage, LinearLayout pollMain, RelativeLayout pollRl, ImageView pollSubmit, TextView pollText, TextView pollType, ProgressBar progressBar, ProgressBar progressBarPdf, RelativeLayout publishDoubts, TextView publishTxt, ImageView quality, TextView questionText, RecyclerView recyclerView, RecyclerView recylerViewPollOperator, RelativeLayout refressDoubtRl, RelativeLayout rlPdfData, RelativeLayout rootNew, RelativeLayout selectMode, ImageView sendRecording, ImageView startaudio, RelativeLayout submitDoubts, RelativeLayout submitPoll, SwitchCompat switchChat, SwitchCompat switchEmoticons, SwitchCompat switchFeedback, SwitchCompat switchPublic, LinearLayout textLayout, RelativeLayout timeDurationRl, TextView timeDurationText, RelativeLayout topImage, TextView tvMark, TextView txtTimer, TextView unpublishtxt, ImageView videoBookmark, ImageView videoFeedback, RelativeLayout videoLayout, TextView videoName, TextView viewLeaderboard, ImageView vodChatIcon, CardView vodchatBtn, LinearLayout vodchatLinear, ZoomableVideoView zoomableVideoView) {
        this.rootView = rootView;
        this.addBookmark = addBookmark;
        this.addOptionRecycler = addOptionRecycler;
        this.addOptionRl = addOptionRl;
        this.addPoll = addPoll;
        this.audioLayoutRl = audioLayoutRl;
        this.audioMainLL = audioMainLL;
        this.audioRecordTime = audioRecordTime;
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
        this.cross = cross;
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
        this.expand = expand;
        this.fileUpload = fileUpload;
        this.floatingTextNew = floatingTextNew;
        this.forDoubtll = forDoubtll;
        this.generateLeaderboard = generateLeaderboard;
        this.goToCurrentRl = goToCurrentRl;
        this.icBackPdf = icBackPdf;
        this.icFullPdf = icFullPdf;
        this.indexBtn = indexBtn;
        this.indexIcon = indexIcon;
        this.indexLinear = indexLinear;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
        this.liveChatIcon = liveChatIcon;
        this.liveDot = liveDot;
        this.llChatSetting = llChatSetting;
        this.llMarkRead = llMarkRead;
        this.llTitle = llTitle;
        this.llll = llll;
        this.loveImage = loveImage;
        this.mainRoot = mainRoot;
        this.messageRl = messageRl;
        this.operatorLL = operatorLL;
        this.pauseAudio = pauseAudio;
        this.pdfBtn = pdfBtn;
        this.pdfIcon = pdfIcon;
        this.pdfLinear = pdfLinear;
        this.pdfText = pdfText;
        this.pdfView = pdfView;
        this.pdfViewLayout = pdfViewLayout;
        this.pdfViewPager = pdfViewPager;
        this.pinChat = pinChat;
        this.pinll = pinll;
        this.playerViewNew = playerViewNew;
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
        this.refressDoubtRl = refressDoubtRl;
        this.rlPdfData = rlPdfData;
        this.rootNew = rootNew;
        this.selectMode = selectMode;
        this.sendRecording = sendRecording;
        this.startaudio = startaudio;
        this.submitDoubts = submitDoubts;
        this.submitPoll = submitPoll;
        this.switchChat = switchChat;
        this.switchEmoticons = switchEmoticons;
        this.switchFeedback = switchFeedback;
        this.switchPublic = switchPublic;
        this.textLayout = textLayout;
        this.timeDurationRl = timeDurationRl;
        this.timeDurationText = timeDurationText;
        this.topImage = topImage;
        this.tvMark = tvMark;
        this.txtTimer = txtTimer;
        this.unpublishtxt = unpublishtxt;
        this.videoBookmark = videoBookmark;
        this.videoFeedback = videoFeedback;
        this.videoLayout = videoLayout;
        this.videoName = videoName;
        this.viewLeaderboard = viewLeaderboard;
        this.vodChatIcon = vodChatIcon;
        this.vodchatBtn = vodchatBtn;
        this.vodchatLinear = vodchatLinear;
        this.zoomableVideoView = zoomableVideoView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLiveawsactivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLiveawsactivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_liveawsactivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLiveawsactivityBinding bind(View rootView) {
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
                                    i = R.id.bookmark_btn;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.bookmark_btn);
                                    if (cardView != null) {
                                        i = R.id.bookmarkIcon;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookmarkIcon);
                                        if (imageView != null) {
                                            i = R.id.bookmarkLinear;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bookmarkLinear);
                                            if (linearLayout2 != null) {
                                                i = R.id.bottomlayout;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomlayout);
                                                if (linearLayout3 != null) {
                                                    i = R.id.cancelRecording;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelRecording);
                                                    if (imageView2 != null) {
                                                        i = R.id.chat_btn;
                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.chat_btn);
                                                        if (cardView2 != null) {
                                                            i = R.id.chatLinear;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.chatLinear);
                                                            if (linearLayout4 != null) {
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
                                                                                i = R.id.cross;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
                                                                                if (imageView3 != null) {
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
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubtIcon);
                                                                                                if (imageView4 != null) {
                                                                                                    i = R.id.doubtLinear;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.doubtLinear);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        i = R.id.doubtText;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubtText);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.emoji;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.emoji);
                                                                                                            if (imageView5 != null) {
                                                                                                                i = R.id.endLayout;
                                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.endLayout);
                                                                                                                if (linearLayout6 != null) {
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
                                                                                                                                        i = R.id.expand;
                                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.expand);
                                                                                                                                        if (imageView6 != null) {
                                                                                                                                            i = R.id.file_upload;
                                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.file_upload);
                                                                                                                                            if (imageView7 != null) {
                                                                                                                                                i = R.id.floatingText_new;
                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.floatingText_new);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    i = R.id.forDoubtll;
                                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.forDoubtll);
                                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                                        i = R.id.generateLeaderboard;
                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.generateLeaderboard);
                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                            i = R.id.goToCurrentRl;
                                                                                                                                                            RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.goToCurrentRl);
                                                                                                                                                            if (relativeLayout8 != null) {
                                                                                                                                                                i = R.id.ic_back_pdf;
                                                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ic_back_pdf);
                                                                                                                                                                if (imageView8 != null) {
                                                                                                                                                                    i = R.id.ic_full_pdf;
                                                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ic_full_pdf);
                                                                                                                                                                    if (imageView9 != null) {
                                                                                                                                                                        i = R.id.index_btn;
                                                                                                                                                                        CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, R.id.index_btn);
                                                                                                                                                                        if (cardView4 != null) {
                                                                                                                                                                            i = R.id.indexIcon;
                                                                                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.indexIcon);
                                                                                                                                                                            if (imageView10 != null) {
                                                                                                                                                                                i = R.id.indexLinear;
                                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.indexLinear);
                                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                                    i = R.id.iv_send;
                                                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                                                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                                                        i = R.id.linearLayout;
                                                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                                                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                                                            i = R.id.liveChatIcon;
                                                                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveChatIcon);
                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                i = R.id.liveDot;
                                                                                                                                                                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveDot);
                                                                                                                                                                                                if (imageView13 != null) {
                                                                                                                                                                                                    i = R.id.llChatSetting;
                                                                                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llChatSetting);
                                                                                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                                                                                        i = R.id.llMarkRead;
                                                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llMarkRead);
                                                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                                                            i = R.id.ll_title;
                                                                                                                                                                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_title);
                                                                                                                                                                                                            if (linearLayout12 != null) {
                                                                                                                                                                                                                i = R.id.llll;
                                                                                                                                                                                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llll);
                                                                                                                                                                                                                if (linearLayout13 != null) {
                                                                                                                                                                                                                    i = R.id.loveImage;
                                                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loveImage);
                                                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) rootView;
                                                                                                                                                                                                                        i = R.id.messageRl;
                                                                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.messageRl);
                                                                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                                                                            i = R.id.operatorLL;
                                                                                                                                                                                                                            LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.operatorLL);
                                                                                                                                                                                                                            if (linearLayout14 != null) {
                                                                                                                                                                                                                                i = R.id.pauseAudio;
                                                                                                                                                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pauseAudio);
                                                                                                                                                                                                                                if (imageView14 != null) {
                                                                                                                                                                                                                                    i = R.id.pdf_btn;
                                                                                                                                                                                                                                    CardView cardView5 = (CardView) ViewBindings.findChildViewById(rootView, R.id.pdf_btn);
                                                                                                                                                                                                                                    if (cardView5 != null) {
                                                                                                                                                                                                                                        i = R.id.pdfIcon;
                                                                                                                                                                                                                                        ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdfIcon);
                                                                                                                                                                                                                                        if (imageView15 != null) {
                                                                                                                                                                                                                                            i = R.id.pdfLinear;
                                                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfLinear);
                                                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                                                i = R.id.pdfText;
                                                                                                                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText);
                                                                                                                                                                                                                                                if (textView9 != null) {
                                                                                                                                                                                                                                                    i = R.id.pdfView;
                                                                                                                                                                                                                                                    PDFView pDFView = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfView);
                                                                                                                                                                                                                                                    if (pDFView != null) {
                                                                                                                                                                                                                                                        i = R.id.pdf_view_layout;
                                                                                                                                                                                                                                                        RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pdf_view_layout);
                                                                                                                                                                                                                                                        if (relativeLayout11 != null) {
                                                                                                                                                                                                                                                            i = R.id.pdfViewPager;
                                                                                                                                                                                                                                                            PDFView pDFView2 = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfViewPager);
                                                                                                                                                                                                                                                            if (pDFView2 != null) {
                                                                                                                                                                                                                                                                i = R.id.pinChat;
                                                                                                                                                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pinChat);
                                                                                                                                                                                                                                                                if (textView10 != null) {
                                                                                                                                                                                                                                                                    i = R.id.pinll;
                                                                                                                                                                                                                                                                    LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pinll);
                                                                                                                                                                                                                                                                    if (linearLayout16 != null) {
                                                                                                                                                                                                                                                                        i = R.id.player_view_new;
                                                                                                                                                                                                                                                                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, R.id.player_view_new);
                                                                                                                                                                                                                                                                        if (playerView != null) {
                                                                                                                                                                                                                                                                            i = R.id.poll;
                                                                                                                                                                                                                                                                            CardView cardView6 = (CardView) ViewBindings.findChildViewById(rootView, R.id.poll);
                                                                                                                                                                                                                                                                            if (cardView6 != null) {
                                                                                                                                                                                                                                                                                i = R.id.pollIcon;
                                                                                                                                                                                                                                                                                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollIcon);
                                                                                                                                                                                                                                                                                if (imageView16 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.pollImage;
                                                                                                                                                                                                                                                                                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollImage);
                                                                                                                                                                                                                                                                                    if (imageView17 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.pollMain;
                                                                                                                                                                                                                                                                                        LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pollMain);
                                                                                                                                                                                                                                                                                        if (linearLayout17 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.pollRl;
                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pollRl);
                                                                                                                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.pollSubmit;
                                                                                                                                                                                                                                                                                                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pollSubmit);
                                                                                                                                                                                                                                                                                                if (imageView18 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.pollText;
                                                                                                                                                                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollText);
                                                                                                                                                                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.pollType;
                                                                                                                                                                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pollType);
                                                                                                                                                                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.progress_bar;
                                                                                                                                                                                                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar);
                                                                                                                                                                                                                                                                                                            if (progressBar != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.progress_bar_pdf;
                                                                                                                                                                                                                                                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_bar_pdf);
                                                                                                                                                                                                                                                                                                                if (progressBar2 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.publishDoubts;
                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.publishDoubts);
                                                                                                                                                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.publishTxt;
                                                                                                                                                                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.publishTxt);
                                                                                                                                                                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.quality;
                                                                                                                                                                                                                                                                                                                            ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.quality);
                                                                                                                                                                                                                                                                                                                            if (imageView19 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.questionText;
                                                                                                                                                                                                                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questionText);
                                                                                                                                                                                                                                                                                                                                if (textView14 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.recycler_view;
                                                                                                                                                                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view);
                                                                                                                                                                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.recylerViewPollOperator;
                                                                                                                                                                                                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recylerViewPollOperator);
                                                                                                                                                                                                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                                                                                                                                                                                                            i = R.id.refressDoubtRl;
                                                                                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.refressDoubtRl);
                                                                                                                                                                                                                                                                                                                                            if (relativeLayout14 != null) {
                                                                                                                                                                                                                                                                                                                                                i = R.id.rl_pdf_data;
                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_pdf_data);
                                                                                                                                                                                                                                                                                                                                                if (relativeLayout15 != null) {
                                                                                                                                                                                                                                                                                                                                                    i = R.id.root_new;
                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.root_new);
                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                                                                                        i = R.id.selectMode;
                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout17 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.selectMode);
                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout17 != null) {
                                                                                                                                                                                                                                                                                                                                                            i = R.id.sendRecording;
                                                                                                                                                                                                                                                                                                                                                            ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.sendRecording);
                                                                                                                                                                                                                                                                                                                                                            if (imageView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                i = R.id.startaudio;
                                                                                                                                                                                                                                                                                                                                                                ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.startaudio);
                                                                                                                                                                                                                                                                                                                                                                if (imageView21 != null) {
                                                                                                                                                                                                                                                                                                                                                                    i = R.id.submitDoubts;
                                                                                                                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout18 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.submitDoubts);
                                                                                                                                                                                                                                                                                                                                                                    if (relativeLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                        i = R.id.submitPoll;
                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout19 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.submitPoll);
                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout19 != null) {
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
                                                                                                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textLayout);
                                                                                                                                                                                                                                                                                                                                                                                            if (linearLayout18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.timeDurationRl;
                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout20 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.timeDurationRl);
                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.timeDurationText;
                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeDurationText);
                                                                                                                                                                                                                                                                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.topImage;
                                                                                                                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout21 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topImage);
                                                                                                                                                                                                                                                                                                                                                                                                        if (relativeLayout21 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.tvMark;
                                                                                                                                                                                                                                                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMark);
                                                                                                                                                                                                                                                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.txt_timer;
                                                                                                                                                                                                                                                                                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_timer);
                                                                                                                                                                                                                                                                                                                                                                                                                if (textView17 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.unpublishtxt;
                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unpublishtxt);
                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.video_bookmark;
                                                                                                                                                                                                                                                                                                                                                                                                                        ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.video_bookmark);
                                                                                                                                                                                                                                                                                                                                                                                                                        if (imageView22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.video_feedback;
                                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.video_feedback);
                                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView23 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.video_layout;
                                                                                                                                                                                                                                                                                                                                                                                                                                RelativeLayout relativeLayout22 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.video_layout);
                                                                                                                                                                                                                                                                                                                                                                                                                                if (relativeLayout22 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.video_name;
                                                                                                                                                                                                                                                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                                                                                                                                                                                                                                                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.viewLeaderboard;
                                                                                                                                                                                                                                                                                                                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.viewLeaderboard);
                                                                                                                                                                                                                                                                                                                                                                                                                                        if (textView20 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                            i = R.id.vodChatIcon;
                                                                                                                                                                                                                                                                                                                                                                                                                                            ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vodChatIcon);
                                                                                                                                                                                                                                                                                                                                                                                                                                            if (imageView24 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                i = R.id.vodchat_btn;
                                                                                                                                                                                                                                                                                                                                                                                                                                                CardView cardView7 = (CardView) ViewBindings.findChildViewById(rootView, R.id.vodchat_btn);
                                                                                                                                                                                                                                                                                                                                                                                                                                                if (cardView7 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                    i = R.id.vodchatLinear;
                                                                                                                                                                                                                                                                                                                                                                                                                                                    LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.vodchatLinear);
                                                                                                                                                                                                                                                                                                                                                                                                                                                    if (linearLayout19 != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                        i = R.id.zoomableVideoView;
                                                                                                                                                                                                                                                                                                                                                                                                                                                        ZoomableVideoView zoomableVideoView = (ZoomableVideoView) ViewBindings.findChildViewById(rootView, R.id.zoomableVideoView);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        if (zoomableVideoView != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                            return new ActivityLiveawsactivityBinding(relativeLayout9, textView, recyclerView, relativeLayout, relativeLayout2, relativeLayout3, linearLayout, textView2, cardView, imageView, linearLayout2, linearLayout3, imageView2, cardView2, linearLayout4, relativeLayout4, checkBox, relativeLayout5, nestedScrollView, imageView3, relativeLayout6, textView3, cardView3, imageView4, linearLayout5, textView4, imageView5, linearLayout6, editText, editText2, relativeLayout7, textView5, editText3, imageView6, imageView7, textView6, linearLayout7, textView7, relativeLayout8, imageView8, imageView9, cardView4, imageView10, linearLayout8, imageView11, linearLayout9, imageView12, imageView13, linearLayout10, linearLayout11, linearLayout12, linearLayout13, textView8, relativeLayout9, relativeLayout10, linearLayout14, imageView14, cardView5, imageView15, linearLayout15, textView9, pDFView, relativeLayout11, pDFView2, textView10, linearLayout16, playerView, cardView6, imageView16, imageView17, linearLayout17, relativeLayout12, imageView18, textView11, textView12, progressBar, progressBar2, relativeLayout13, textView13, imageView19, textView14, recyclerView2, recyclerView3, relativeLayout14, relativeLayout15, relativeLayout16, relativeLayout17, imageView20, imageView21, relativeLayout18, relativeLayout19, switchCompat, switchCompat2, switchCompat3, switchCompat4, linearLayout18, relativeLayout20, textView15, relativeLayout21, textView16, textView17, textView18, imageView22, imageView23, relativeLayout22, textView19, textView20, imageView24, cardView7, linearLayout19, zoomableVideoView);
                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
