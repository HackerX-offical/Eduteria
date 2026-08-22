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
public final class ItemImageChatLeftBinding implements ViewBinding {
    public final RelativeLayout cvrLeftimage;
    public final CardView imageCardViewLeft;
    public final LinearLayout ivImgLeftClick;
    public final ImageView ivPinMsgLeftImage;
    public final TextView leftimagetime;
    public final ImageView letfmessageTvimage;
    public final LinearLayout mainRl2;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl3;
    public final TextView userNameimage;

    private ItemImageChatLeftBinding(RelativeLayout rootView, RelativeLayout cvrLeftimage, CardView imageCardViewLeft, LinearLayout ivImgLeftClick, ImageView ivPinMsgLeftImage, TextView leftimagetime, ImageView letfmessageTvimage, LinearLayout mainRl2, LinearLayout timeRl3, TextView userNameimage) {
        this.rootView = rootView;
        this.cvrLeftimage = cvrLeftimage;
        this.imageCardViewLeft = imageCardViewLeft;
        this.ivImgLeftClick = ivImgLeftClick;
        this.ivPinMsgLeftImage = ivPinMsgLeftImage;
        this.leftimagetime = leftimagetime;
        this.letfmessageTvimage = letfmessageTvimage;
        this.mainRl2 = mainRl2;
        this.timeRl3 = timeRl3;
        this.userNameimage = userNameimage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemImageChatLeftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemImageChatLeftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_image_chat_left, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemImageChatLeftBinding bind(View rootView) {
        int i = R.id.cvrLeftimage;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftimage);
        if (relativeLayout != null) {
            i = R.id.imageCardViewLeft;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.imageCardViewLeft);
            if (cardView != null) {
                i = R.id.iv_img_left_click;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.iv_img_left_click);
                if (linearLayout != null) {
                    i = R.id.ivPinMsgLeftImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftImage);
                    if (imageView != null) {
                        i = R.id.leftimagetime;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.leftimagetime);
                        if (textView != null) {
                            i = R.id.letfmessageTvimage;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTvimage);
                            if (imageView2 != null) {
                                i = R.id.mainRl2;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl2);
                                if (linearLayout2 != null) {
                                    i = R.id.timeRl_3;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_3);
                                    if (linearLayout3 != null) {
                                        i = R.id.userNameimage;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameimage);
                                        if (textView2 != null) {
                                            return new ItemImageChatLeftBinding((RelativeLayout) rootView, relativeLayout, cardView, linearLayout, imageView, textView, imageView2, linearLayout2, linearLayout3, textView2);
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
