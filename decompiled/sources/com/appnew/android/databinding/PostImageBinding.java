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
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PostImageBinding extends ViewDataBinding {
    public final ConstraintLayout imageConstraintLayout;
    public final TextView imageText;
    public final ImageView imgeView;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;

    @Bindable
    protected Data mImagebind;
    public final ImageView pinIV;
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

    public abstract void setImagebind(Data imagebind);

    protected PostImageBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout imageConstraintLayout, TextView imageText, ImageView imgeView, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, ImageView pinIV, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, TextView readMore, ImageView shareImage, TextView userName, View view, View view1, View viewComment, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageConstraintLayout = imageConstraintLayout;
        this.imageText = imageText;
        this.imgeView = imgeView;
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
        this.readMore = readMore;
        this.shareImage = shareImage;
        this.userName = userName;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.whatsappShare = whatsappShare;
    }

    public Data getImagebind() {
        return this.mImagebind;
    }

    public static PostImageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostImageBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PostImageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.post_image, root, attachToRoot, component);
    }

    public static PostImageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostImageBinding inflate(LayoutInflater inflater, Object component) {
        return (PostImageBinding) ViewDataBinding.inflateInternal(inflater, R.layout.post_image, null, false, component);
    }

    public static PostImageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PostImageBinding bind(View view, Object component) {
        return (PostImageBinding) bind(component, view, R.layout.post_image);
    }
}
