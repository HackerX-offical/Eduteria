package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class QuizViewBinding extends ViewDataBinding {
    public final ImageView img;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;

    @Bindable
    protected Data mQuizbind;
    public final ImageView pinIV;
    public final TextView postComment;
    public final TextView postCommentCount;
    public final TextView postLikeCount;
    public final TextView postShare;
    public final TextView postSubject;
    public final TextView postTime;
    public final CircleImageView profileImage;
    public final RelativeLayout quizLayout;
    public final ImageView shareImage;
    public final Button startQuiz;
    public final LinearLayout testInfo;
    public final TextView testName;
    public final TextView totalMin;
    public final TextView totalQuestion;
    public final TextView userName;
    public final View view;
    public final View view1;
    public final View viewComment;
    public final LinearLayout whatsappShare;

    public abstract void setQuizbind(Data quizbind);

    protected QuizViewBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView img, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, ImageView pinIV, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, RelativeLayout quizLayout, ImageView shareImage, Button startQuiz, LinearLayout testInfo, TextView testName, TextView totalMin, TextView totalQuestion, TextView userName, View view, View view1, View viewComment, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.img = img;
        this.like = like;
        this.likeCommentCountLayout = likeCommentCountLayout;
        this.likeCommentLayout = likeCommentLayout;
        this.pinIV = pinIV;
        this.postComment = postComment;
        this.postCommentCount = postCommentCount;
        this.postLikeCount = postLikeCount;
        this.postShare = postShare;
        this.postSubject = postSubject;
        this.postTime = postTime;
        this.profileImage = profileImage;
        this.quizLayout = quizLayout;
        this.shareImage = shareImage;
        this.startQuiz = startQuiz;
        this.testInfo = testInfo;
        this.testName = testName;
        this.totalMin = totalMin;
        this.totalQuestion = totalQuestion;
        this.userName = userName;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.whatsappShare = whatsappShare;
    }

    public Data getQuizbind() {
        return this.mQuizbind;
    }

    public static QuizViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuizViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (QuizViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.quiz_view, root, attachToRoot, component);
    }

    public static QuizViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuizViewBinding inflate(LayoutInflater inflater, Object component) {
        return (QuizViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.quiz_view, null, false, component);
    }

    public static QuizViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static QuizViewBinding bind(View view, Object component) {
        return (QuizViewBinding) bind(component, view, R.layout.quiz_view);
    }
}
