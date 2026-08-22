package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityChatBotActvityBinding implements ViewBinding {
    public final WebView chatbotwebview;
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private ActivityChatBotActvityBinding(RelativeLayout rootView, WebView chatbotwebview, TextView delete, ImageView imageBack, Toolbar mainToolbar, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.chatbotwebview = chatbotwebview;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChatBotActvityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityChatBotActvityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_chat_bot_actvity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityChatBotActvityBinding bind(View rootView) {
        int i = R.id.chatbotwebview;
        WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.chatbotwebview);
        if (webView != null) {
            i = R.id.delete;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
            if (textView != null) {
                i = R.id.image_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.select_all_delete;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                        if (checkBox != null) {
                            i = R.id.toolbarTitleTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                            if (textView2 != null) {
                                return new ActivityChatBotActvityBinding((RelativeLayout) rootView, webView, textView, imageView, toolbar, checkBox, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
