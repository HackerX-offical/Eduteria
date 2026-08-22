package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.feeds.adapters.OptionAdapter;
import com.appnew.android.feeds.adapters.OptionWebAdapter;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class QuestionViewBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;

    @Bindable
    protected OptionAdapter mOptionadapter;

    @Bindable
    protected OptionWebAdapter mOptionwebadapter;

    @Bindable
    protected Data mQuestionbind;
    public final ImageView pinIV;
    public final TextView postAttempt;
    public final TextView postComment;
    public final TextView postCommentCount;
    public final TextView postLikeCount;
    public final TextView postShare;
    public final TextView postSubject;
    public final TextView postTime;
    public final CircleImageView profileImage;
    public final ClickableWebView questionTxt;
    public final RecyclerView recyerclerView;
    public final RecyclerView recyerclerViewWebview;
    public final ImageView shareImage;
    public final TextView userName;
    public final View view;
    public final View view1;
    public final View viewComment;
    public final LinearLayout whatsappShare;

    public abstract void setOptionadapter(OptionAdapter optionadapter);

    public abstract void setOptionwebadapter(OptionWebAdapter optionwebadapter);

    public abstract void setQuestionbind(Data questionbind);

    protected QuestionViewBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout constraint, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, ImageView pinIV, TextView postAttempt, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, ClickableWebView questionTxt, RecyclerView recyerclerView, RecyclerView recyerclerViewWebview, ImageView shareImage, TextView userName, View view, View view1, View viewComment, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.constraint = constraint;
        this.like = like;
        this.likeCommentCountLayout = likeCommentCountLayout;
        this.likeCommentLayout = likeCommentLayout;
        this.pinIV = pinIV;
        this.postAttempt = postAttempt;
        this.postComment = postComment;
        this.postCommentCount = postCommentCount;
        this.postLikeCount = postLikeCount;
        this.postShare = postShare;
        this.postSubject = postSubject;
        this.postTime = postTime;
        this.profileImage = profileImage;
        this.questionTxt = questionTxt;
        this.recyerclerView = recyerclerView;
        this.recyerclerViewWebview = recyerclerViewWebview;
        this.shareImage = shareImage;
        this.userName = userName;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.whatsappShare = whatsappShare;
    }

    public Data getQuestionbind() {
        return this.mQuestionbind;
    }

    public OptionAdapter getOptionadapter() {
        return this.mOptionadapter;
    }

    public OptionWebAdapter getOptionwebadapter() {
        return this.mOptionwebadapter;
    }

    public static QuestionViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (QuestionViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_view, root, attachToRoot, component);
    }

    public static QuestionViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionViewBinding inflate(LayoutInflater inflater, Object component) {
        return (QuestionViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.question_view, null, false, component);
    }

    public static QuestionViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuestionViewBinding bind(View view, Object component) {
        return (QuestionViewBinding) bind(component, view, R.layout.question_view);
    }
}
