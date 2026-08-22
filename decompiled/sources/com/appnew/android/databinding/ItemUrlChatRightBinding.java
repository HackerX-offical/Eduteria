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
public final class ItemUrlChatRightBinding implements ViewBinding {
    public final RelativeLayout cvrUrlRight;
    public final ImageView ivPinUrl;
    public final LinearLayout mainContainerLL;
    public final TextView rightmessageUrl;
    public final TextView righttexttimeUrl;
    public final RelativeLayout rlUrlClick;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl10;
    public final TextView userNamerightUrl;

    private ItemUrlChatRightBinding(RelativeLayout rootView, RelativeLayout cvrUrlRight, ImageView ivPinUrl, LinearLayout mainContainerLL, TextView rightmessageUrl, TextView righttexttimeUrl, RelativeLayout rlUrlClick, LinearLayout timeRl10, TextView userNamerightUrl) {
        this.rootView = rootView;
        this.cvrUrlRight = cvrUrlRight;
        this.ivPinUrl = ivPinUrl;
        this.mainContainerLL = mainContainerLL;
        this.rightmessageUrl = rightmessageUrl;
        this.righttexttimeUrl = righttexttimeUrl;
        this.rlUrlClick = rlUrlClick;
        this.timeRl10 = timeRl10;
        this.userNamerightUrl = userNamerightUrl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemUrlChatRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemUrlChatRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_url_chat_right, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUrlChatRightBinding bind(View rootView) {
        int i = R.id.cvrUrlRight;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrUrlRight);
        if (relativeLayout != null) {
            i = R.id.ivPinUrl;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinUrl);
            if (imageView != null) {
                i = R.id.mainContainerLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainContainerLL);
                if (linearLayout != null) {
                    i = R.id.rightmessageUrl;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.rightmessageUrl);
                    if (textView != null) {
                        i = R.id.righttexttimeUrl;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimeUrl);
                        if (textView2 != null) {
                            i = R.id.rl_url_click;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_url_click);
                            if (relativeLayout2 != null) {
                                i = R.id.timeRl_10;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_10);
                                if (linearLayout2 != null) {
                                    i = R.id.userNamerightUrl;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNamerightUrl);
                                    if (textView3 != null) {
                                        return new ItemUrlChatRightBinding((RelativeLayout) rootView, relativeLayout, imageView, linearLayout, textView, textView2, relativeLayout2, linearLayout2, textView3);
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
