package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class HelpChatBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final RecyclerView chatList;
    public final EditText helpChatTxt;
    public final ImageView imageIV;
    public final Toolbar myProgressToolbar;
    public final TextView queryTV;
    private final RelativeLayout rootView;
    public final ImageView sendMessage;
    public final LinearLayout sendingLayout;
    public final TextView toolbartitleTV;

    private HelpChatBinding(RelativeLayout rootView, AppBarLayout appBarLayout, RecyclerView chatList, EditText helpChatTxt, ImageView imageIV, Toolbar myProgressToolbar, TextView queryTV, ImageView sendMessage, LinearLayout sendingLayout, TextView toolbartitleTV) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.chatList = chatList;
        this.helpChatTxt = helpChatTxt;
        this.imageIV = imageIV;
        this.myProgressToolbar = myProgressToolbar;
        this.queryTV = queryTV;
        this.sendMessage = sendMessage;
        this.sendingLayout = sendingLayout;
        this.toolbartitleTV = toolbartitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HelpChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HelpChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.help_chat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HelpChatBinding bind(View rootView) {
        int i = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i = R.id.chat_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.chat_list);
            if (recyclerView != null) {
                i = R.id.help_chat_txt;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.help_chat_txt);
                if (editText != null) {
                    i = R.id.imageIV;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                    if (imageView != null) {
                        i = R.id.myProgress_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.myProgress_toolbar);
                        if (toolbar != null) {
                            i = R.id.queryTV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.queryTV);
                            if (textView != null) {
                                i = R.id.send_message;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.send_message);
                                if (imageView2 != null) {
                                    i = R.id.sending_layout;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.sending_layout);
                                    if (linearLayout != null) {
                                        i = R.id.toolbartitleTV;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                        if (textView2 != null) {
                                            return new HelpChatBinding((RelativeLayout) rootView, appBarLayout, recyclerView, editText, imageView, toolbar, textView, imageView2, linearLayout, textView2);
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
