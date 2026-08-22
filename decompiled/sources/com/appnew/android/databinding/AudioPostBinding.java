package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class AudioPostBinding extends ViewDataBinding {
    public final TextView audioText;
    public final RelativeLayout auidoLayout;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;

    @Bindable
    protected Data mAudiobind;
    public final ImageView pinIV;
    public final ImageView playIcon;
    public final TextView postComment;
    public final TextView postCommentCount;
    public final TextView postLikeCount;
    public final TextView postShare;
    public final TextView postSubject;
    public final TextView postTime;
    public final CircleImageView profileImage;
    public final TextView readMore;
    public final ImageView shareImage;
    public final TextView userName;
    public final View view;
    public final View view1;
    public final View viewComment;
    public final LinearLayout whatsappShare;

    public abstract void setAudiobind(Data audiobind);

    protected AudioPostBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView audioText, RelativeLayout auidoLayout, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, ImageView pinIV, ImageView playIcon, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, TextView readMore, ImageView shareImage, TextView userName, View view, View view1, View viewComment, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.audioText = audioText;
        this.auidoLayout = auidoLayout;
        this.like = like;
        this.likeCommentCountLayout = likeCommentCountLayout;
        this.likeCommentLayout = likeCommentLayout;
        this.pinIV = pinIV;
        this.playIcon = playIcon;
        this.postComment = postComment;
        this.postCommentCount = postCommentCount;
        this.postLikeCount = postLikeCount;
        this.postShare = postShare;
        this.postSubject = postSubject;
        this.postTime = postTime;
        this.profileImage = profileImage;
        this.readMore = readMore;
        this.shareImage = shareImage;
        this.userName = userName;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.whatsappShare = whatsappShare;
    }

    public Data getAudiobind() {
        return this.mAudiobind;
    }

    public static AudioPostBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AudioPostBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AudioPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.audio_post, root, attachToRoot, component);
    }

    public static AudioPostBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AudioPostBinding inflate(LayoutInflater inflater, Object component) {
        return (AudioPostBinding) ViewDataBinding.inflateInternal(inflater, R.layout.audio_post, null, false, component);
    }

    public static AudioPostBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AudioPostBinding bind(View view, Object component) {
        return (AudioPostBinding) bind(component, view, R.layout.audio_post);
    }
}
