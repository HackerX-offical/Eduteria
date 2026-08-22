package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DoubtVideoItemLayoutBinding implements ViewBinding {
    public final ImageView doubtImageView;
    public final ImageView itemImage;
    public final LinearLayout llVoteBtn;
    private final RelativeLayout rootView;
    public final TextView voteTxt;

    private DoubtVideoItemLayoutBinding(RelativeLayout rootView, ImageView doubtImageView, ImageView itemImage, LinearLayout llVoteBtn, TextView voteTxt) {
        this.rootView = rootView;
        this.doubtImageView = doubtImageView;
        this.itemImage = itemImage;
        this.llVoteBtn = llVoteBtn;
        this.voteTxt = voteTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DoubtVideoItemLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DoubtVideoItemLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.doubt_video_item_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DoubtVideoItemLayoutBinding bind(View rootView) {
        int i = R.id.doubtImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubtImageView);
        if (imageView != null) {
            i = R.id.item_image;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.item_image);
            if (imageView2 != null) {
                i = R.id.ll_vote_btn;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_vote_btn);
                if (linearLayout != null) {
                    i = R.id.voteTxt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.voteTxt);
                    if (textView != null) {
                        return new DoubtVideoItemLayoutBinding((RelativeLayout) rootView, imageView, imageView2, linearLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
