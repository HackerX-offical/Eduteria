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
public final class ItemUrlChatLeftBinding implements ViewBinding {
    public final RelativeLayout cvrUrlLeft;
    public final ImageView ivPinMsgLeftUrl;
    public final TextView lefttexttimeUrl;
    public final TextView letfmessageTvUrl;
    public final LinearLayout mainRl7;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl9;
    public final TextView userNameUrlLeft;

    private ItemUrlChatLeftBinding(RelativeLayout rootView, RelativeLayout cvrUrlLeft, ImageView ivPinMsgLeftUrl, TextView lefttexttimeUrl, TextView letfmessageTvUrl, LinearLayout mainRl7, LinearLayout timeRl9, TextView userNameUrlLeft) {
        this.rootView = rootView;
        this.cvrUrlLeft = cvrUrlLeft;
        this.ivPinMsgLeftUrl = ivPinMsgLeftUrl;
        this.lefttexttimeUrl = lefttexttimeUrl;
        this.letfmessageTvUrl = letfmessageTvUrl;
        this.mainRl7 = mainRl7;
        this.timeRl9 = timeRl9;
        this.userNameUrlLeft = userNameUrlLeft;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemUrlChatLeftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemUrlChatLeftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_url_chat_left, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUrlChatLeftBinding bind(View rootView) {
        int i = R.id.cvrUrlLeft;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrUrlLeft);
        if (relativeLayout != null) {
            i = R.id.ivPinMsgLeftUrl;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftUrl);
            if (imageView != null) {
                i = R.id.lefttexttimeUrl;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.lefttexttimeUrl);
                if (textView != null) {
                    i = R.id.letfmessageTvUrl;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTvUrl);
                    if (textView2 != null) {
                        i = R.id.mainRl7;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl7);
                        if (linearLayout != null) {
                            i = R.id.timeRl_9;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_9);
                            if (linearLayout2 != null) {
                                i = R.id.userNameUrlLeft;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameUrlLeft);
                                if (textView3 != null) {
                                    return new ItemUrlChatLeftBinding((RelativeLayout) rootView, relativeLayout, imageView, textView, textView2, linearLayout, linearLayout2, textView3);
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
