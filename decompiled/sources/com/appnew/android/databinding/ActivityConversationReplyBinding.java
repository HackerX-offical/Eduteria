package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityConversationReplyBinding implements ViewBinding {
    public final NoDataFoundBinding dataNotFoundLL;
    public final EditText etMessage;
    public final ImageView imageBack;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    public final Toolbar mainToolbar;
    public final RecyclerView replyList;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityConversationReplyBinding(ConstraintLayout rootView, NoDataFoundBinding dataNotFoundLL, EditText etMessage, ImageView imageBack, ImageView ivSend, LinearLayout linearLayout, Toolbar mainToolbar, RecyclerView replyList, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.dataNotFoundLL = dataNotFoundLL;
        this.etMessage = etMessage;
        this.imageBack = imageBack;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
        this.mainToolbar = mainToolbar;
        this.replyList = replyList;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityConversationReplyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityConversationReplyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_conversation_reply, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityConversationReplyBinding bind(View rootView) {
        int i = R.id.dataNotFoundLL;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dataNotFoundLL);
        if (viewFindChildViewById != null) {
            NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
            i = R.id.et_message;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
            if (editText != null) {
                i = R.id.image_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView != null) {
                    i = R.id.iv_send;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                    if (imageView2 != null) {
                        i = R.id.linearLayout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                        if (linearLayout != null) {
                            i = R.id.main_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                            if (toolbar != null) {
                                i = R.id.reply_List;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.reply_List);
                                if (recyclerView != null) {
                                    i = R.id.toolbarTitleTV;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                    if (textView != null) {
                                        return new ActivityConversationReplyBinding((ConstraintLayout) rootView, noDataFoundBindingBind, editText, imageView, imageView2, linearLayout, toolbar, recyclerView, textView);
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
