package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.feeds.viewmodel.FeedDetailViewModel;
import com.appnew.android.table.PostDataTable;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityFeedDetailsBinding extends ViewDataBinding {
    public final RelativeLayout articleLayout;
    public final TextView articleTxt;
    public final TextView articleTxtTop;
    public final ConstraintLayout audioConstraintLayout;
    public final RelativeLayout audioLayout;
    public final TextView audioText;
    public final RelativeLayout auidoLayout;
    public final ConstraintLayout constraintLinkImage;
    public final Toolbar feedsToolbar;
    public final ImageView imageBack;
    public final ConstraintLayout imageConstraintLayout;
    public final RelativeLayout imageLayout;
    public final TextView imageReadMore;
    public final TextView imageText;
    public final ImageView img;
    public final ImageView imgeView;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;
    public final ImageView linkImage;
    public final RelativeLayout linkLayout;
    public final TextView linkTxt;

    @Bindable
    protected PostDataTable mFeeddatatable;

    @Bindable
    protected FeedDetailViewModel mFeeddetailVm;
    public final RecyclerView newCourseRecycler;
    public final ImageView pinIV;
    public final ImageView playIcon;
    public final ImageView playVideo;
    public final TextView postAttempt;
    public final TextView postComment;
    public final TextView postCommentCount;
    public final TextView postLikeCount;
    public final TextView postShare;
    public final TextView postSubject;
    public final TextView postTime;
    public final CircleImageView profileImage;
    public final RelativeLayout questionLayout;
    public final ClickableWebView questionTxt;
    public final RelativeLayout quizLayout;
    public final TextView readMore;
    public final TextView realted;
    public final RecyclerView recyerclerView;
    public final NestedScrollView scrollNested;
    public final Button startQuiz;
    public final LinearLayout testInfo;
    public final TextView testName;
    public final TextView totalMin;
    public final TextView totalQuestion;
    public final TextView userName;
    public final RelativeLayout videoLayout;
    public final TextView videoReadMore;
    public final TextView videoText;
    public final ImageView videoThumbnail;
    public final View view;
    public final View view1;
    public final View viewComment;
    public final RelativeLayout viewLayout;
    public final LinearLayout whatsappShare;

    public abstract void setFeeddatatable(PostDataTable feeddatatable);

    public abstract void setFeeddetailVm(FeedDetailViewModel feeddetailVm);

    protected ActivityFeedDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout articleLayout, TextView articleTxt, TextView articleTxtTop, ConstraintLayout audioConstraintLayout, RelativeLayout audioLayout, TextView audioText, RelativeLayout auidoLayout, ConstraintLayout constraintLinkImage, Toolbar feedsToolbar, ImageView imageBack, ConstraintLayout imageConstraintLayout, RelativeLayout imageLayout, TextView imageReadMore, TextView imageText, ImageView img, ImageView imgeView, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, ImageView linkImage, RelativeLayout linkLayout, TextView linkTxt, RecyclerView newCourseRecycler, ImageView pinIV, ImageView playIcon, ImageView playVideo, TextView postAttempt, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, RelativeLayout questionLayout, ClickableWebView questionTxt, RelativeLayout quizLayout, TextView readMore, TextView realted, RecyclerView recyerclerView, NestedScrollView scrollNested, Button startQuiz, LinearLayout testInfo, TextView testName, TextView totalMin, TextView totalQuestion, TextView userName, RelativeLayout videoLayout, TextView videoReadMore, TextView videoText, ImageView videoThumbnail, View view, View view1, View viewComment, RelativeLayout viewLayout, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.articleLayout = articleLayout;
        this.articleTxt = articleTxt;
        this.articleTxtTop = articleTxtTop;
        this.audioConstraintLayout = audioConstraintLayout;
        this.audioLayout = audioLayout;
        this.audioText = audioText;
        this.auidoLayout = auidoLayout;
        this.constraintLinkImage = constraintLinkImage;
        this.feedsToolbar = feedsToolbar;
        this.imageBack = imageBack;
        this.imageConstraintLayout = imageConstraintLayout;
        this.imageLayout = imageLayout;
        this.imageReadMore = imageReadMore;
        this.imageText = imageText;
        this.img = img;
        this.imgeView = imgeView;
        this.like = like;
        this.likeCommentCountLayout = likeCommentCountLayout;
        this.likeCommentLayout = likeCommentLayout;
        this.linkImage = linkImage;
        this.linkLayout = linkLayout;
        this.linkTxt = linkTxt;
        this.newCourseRecycler = newCourseRecycler;
        this.pinIV = pinIV;
        this.playIcon = playIcon;
        this.playVideo = playVideo;
        this.postAttempt = postAttempt;
        this.postComment = postComment;
        this.postCommentCount = postCommentCount;
        this.postLikeCount = postLikeCount;
        this.postShare = postShare;
        this.postSubject = postSubject;
        this.postTime = postTime;
        this.profileImage = profileImage;
        this.questionLayout = questionLayout;
        this.questionTxt = questionTxt;
        this.quizLayout = quizLayout;
        this.readMore = readMore;
        this.realted = realted;
        this.recyerclerView = recyerclerView;
        this.scrollNested = scrollNested;
        this.startQuiz = startQuiz;
        this.testInfo = testInfo;
        this.testName = testName;
        this.totalMin = totalMin;
        this.totalQuestion = totalQuestion;
        this.userName = userName;
        this.videoLayout = videoLayout;
        this.videoReadMore = videoReadMore;
        this.videoText = videoText;
        this.videoThumbnail = videoThumbnail;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.viewLayout = viewLayout;
        this.whatsappShare = whatsappShare;
    }

    public FeedDetailViewModel getFeeddetailVm() {
        return this.mFeeddetailVm;
    }

    public PostDataTable getFeeddatatable() {
        return this.mFeeddatatable;
    }

    public static ActivityFeedDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFeedDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityFeedDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_feed_details, root, attachToRoot, component);
    }

    public static ActivityFeedDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFeedDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityFeedDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_feed_details, null, false, component);
    }

    public static ActivityFeedDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFeedDetailsBinding bind(View view, Object component) {
        return (ActivityFeedDetailsBinding) bind(component, view, R.layout.activity_feed_details);
    }
}
