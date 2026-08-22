package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.dataclass.Data;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LinkViewBinding extends ViewDataBinding {
    public final ConstraintLayout imageConstraintLayout;
    public final TextView like;
    public final LinearLayout likeCommentCountLayout;
    public final LinearLayout likeCommentLayout;
    public final RoundedImageView linkImage;
    public final TextView linkTxt;
    public final ImageView linkYoutubeThumbnail;

    @Bindable
    protected Data mLinkbind;
    public final ImageView pinIV;
    public final ImageView playLink;
    public final TextView postComment;
    public final TextView postCommentCount;
    public final TextView postLikeCount;
    public final TextView postShare;
    public final TextView postSubject;
    public final TextView postTime;
    public final CircleImageView profileImage;
    public final RelativeLayout rlLink;
    public final ImageView shareImage;
    public final TextView userName;
    public final View view;
    public final View view1;
    public final View viewComment;
    public final LinearLayout whatsappShare;

    public abstract void setLinkbind(Data linkbind);

    protected LinkViewBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout imageConstraintLayout, TextView like, LinearLayout likeCommentCountLayout, LinearLayout likeCommentLayout, RoundedImageView linkImage, TextView linkTxt, ImageView linkYoutubeThumbnail, ImageView pinIV, ImageView playLink, TextView postComment, TextView postCommentCount, TextView postLikeCount, TextView postShare, TextView postSubject, TextView postTime, CircleImageView profileImage, RelativeLayout rlLink, ImageView shareImage, TextView userName, View view, View view1, View viewComment, LinearLayout whatsappShare) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageConstraintLayout = imageConstraintLayout;
        this.like = like;
        this.likeCommentCountLayout = likeCommentCountLayout;
        this.likeCommentLayout = likeCommentLayout;
        this.linkImage = linkImage;
        this.linkTxt = linkTxt;
        this.linkYoutubeThumbnail = linkYoutubeThumbnail;
        this.pinIV = pinIV;
        this.playLink = playLink;
        this.postComment = postComment;
        this.postCommentCount = postCommentCount;
        this.postLikeCount = postLikeCount;
        this.postShare = postShare;
        this.postSubject = postSubject;
        this.postTime = postTime;
        this.profileImage = profileImage;
        this.rlLink = rlLink;
        this.shareImage = shareImage;
        this.userName = userName;
        this.view = view;
        this.view1 = view1;
        this.viewComment = viewComment;
        this.whatsappShare = whatsappShare;
    }

    public Data getLinkbind() {
        return this.mLinkbind;
    }

    public static LinkViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LinkViewBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (LinkViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.link_view, root, attachToRoot, component);
    }

    public static LinkViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LinkViewBinding inflate(LayoutInflater inflater, Object component) {
        return (LinkViewBinding) ViewDataBinding.inflateInternal(inflater, R.layout.link_view, null, false, component);
    }

    public static LinkViewBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LinkViewBinding bind(View view, Object component) {
        return (LinkViewBinding) bind(component, view, R.layout.link_view);
    }
}
