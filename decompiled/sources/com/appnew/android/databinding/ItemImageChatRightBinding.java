package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemImageChatRightBinding implements ViewBinding {
    public final RelativeLayout cvrRightimage;
    public final LinearLayout ivImgClickRight;
    public final ImageView ivPinImage;
    public final LinearLayout mainRl3;
    public final CardView rightImageCardView;
    public final TextView rightimagettime;
    public final ImageView rightmessageimage;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl4;
    public final TextView userNamerightimage;

    private ItemImageChatRightBinding(RelativeLayout rootView, RelativeLayout cvrRightimage, LinearLayout ivImgClickRight, ImageView ivPinImage, LinearLayout mainRl3, CardView rightImageCardView, TextView rightimagettime, ImageView rightmessageimage, LinearLayout timeRl4, TextView userNamerightimage) {
        this.rootView = rootView;
        this.cvrRightimage = cvrRightimage;
        this.ivImgClickRight = ivImgClickRight;
        this.ivPinImage = ivPinImage;
        this.mainRl3 = mainRl3;
        this.rightImageCardView = rightImageCardView;
        this.rightimagettime = rightimagettime;
        this.rightmessageimage = rightmessageimage;
        this.timeRl4 = timeRl4;
        this.userNamerightimage = userNamerightimage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemImageChatRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemImageChatRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_image_chat_right, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemImageChatRightBinding bind(View rootView) {
        int i = R.id.cvrRightimage;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightimage);
        if (relativeLayout != null) {
            i = R.id.iv_img_click_right;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.iv_img_click_right);
            if (linearLayout != null) {
                i = R.id.ivPinImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinImage);
                if (imageView != null) {
                    i = R.id.mainRl3;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl3);
                    if (linearLayout2 != null) {
                        i = R.id.rightImageCardView;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.rightImageCardView);
                        if (cardView != null) {
                            i = R.id.rightimagettime;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightimagettime);
                            if (textView != null) {
                                i = R.id.rightmessageimage;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.rightmessageimage);
                                if (imageView2 != null) {
                                    i = R.id.timeRl_4;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_4);
                                    if (linearLayout3 != null) {
                                        i = R.id.userNamerightimage;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNamerightimage);
                                        if (textView2 != null) {
                                            return new ItemImageChatRightBinding((RelativeLayout) rootView, relativeLayout, linearLayout, imageView, linearLayout2, cardView, textView, imageView2, linearLayout3, textView2);
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
