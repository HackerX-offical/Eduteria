package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityGroupChatBinding implements ViewBinding {
    public final TextView addBookmark;
    public final LinearLayout bottomlayout;
    public final ImageView chatAddButton;
    public final LinearLayoutCompat cvr;
    public final ImageView doubtChatBack;
    public final TextView doubtMessage;
    public final RecyclerView doubtReplyRecycler;
    public final Button doubtResolved;
    public final TextView doubtSubject;
    public final Button doubtUnResolved;
    public final EditText etMessage;
    public final ImageView fileUpload;
    public final ImageView ivSend;
    public final LinearLayout linearLayout;
    public final CardView linearLayoutChat;
    public final LinearLayout llResolved;
    public final LinearLayout main;
    public final Toolbar mainToolbar;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final Button startaudio;
    public final Button stopaudio;
    public final TextView toolbarTitleTV;

    private ActivityGroupChatBinding(RelativeLayout rootView, TextView addBookmark, LinearLayout bottomlayout, ImageView chatAddButton, LinearLayoutCompat cvr, ImageView doubtChatBack, TextView doubtMessage, RecyclerView doubtReplyRecycler, Button doubtResolved, TextView doubtSubject, Button doubtUnResolved, EditText etMessage, ImageView fileUpload, ImageView ivSend, LinearLayout linearLayout, CardView linearLayoutChat, LinearLayout llResolved, LinearLayout main, Toolbar mainToolbar, RelativeLayout root, Button startaudio, Button stopaudio, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.addBookmark = addBookmark;
        this.bottomlayout = bottomlayout;
        this.chatAddButton = chatAddButton;
        this.cvr = cvr;
        this.doubtChatBack = doubtChatBack;
        this.doubtMessage = doubtMessage;
        this.doubtReplyRecycler = doubtReplyRecycler;
        this.doubtResolved = doubtResolved;
        this.doubtSubject = doubtSubject;
        this.doubtUnResolved = doubtUnResolved;
        this.etMessage = etMessage;
        this.fileUpload = fileUpload;
        this.ivSend = ivSend;
        this.linearLayout = linearLayout;
        this.linearLayoutChat = linearLayoutChat;
        this.llResolved = llResolved;
        this.main = main;
        this.mainToolbar = mainToolbar;
        this.root = root;
        this.startaudio = startaudio;
        this.stopaudio = stopaudio;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGroupChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityGroupChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_group_chat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityGroupChatBinding bind(View rootView) {
        int i = R.id.add_bookmark;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_bookmark);
        if (textView != null) {
            i = R.id.bottomlayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomlayout);
            if (linearLayout != null) {
                i = R.id.chatAddButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatAddButton);
                if (imageView != null) {
                    i = R.id.cvr;
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvr);
                    if (linearLayoutCompat != null) {
                        i = R.id.doubtChat_back;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubtChat_back);
                        if (imageView2 != null) {
                            i = R.id.doubtMessage;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubtMessage);
                            if (textView2 != null) {
                                i = R.id.doubt_Reply_Recycler;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.doubt_Reply_Recycler);
                                if (recyclerView != null) {
                                    i = R.id.doubtResolved;
                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.doubtResolved);
                                    if (button != null) {
                                        i = R.id.doubtSubject;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.doubtSubject);
                                        if (textView3 != null) {
                                            i = R.id.doubtUnResolved;
                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.doubtUnResolved);
                                            if (button2 != null) {
                                                i = R.id.et_message;
                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                                                if (editText != null) {
                                                    i = R.id.file_upload;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.file_upload);
                                                    if (imageView3 != null) {
                                                        i = R.id.iv_send;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_send);
                                                        if (imageView4 != null) {
                                                            i = R.id.linearLayout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.linearLayoutChat;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.linearLayoutChat);
                                                                if (cardView != null) {
                                                                    i = R.id.ll_resolved;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_resolved);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.main;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.main);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.main_toolbar;
                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                            if (toolbar != null) {
                                                                                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                                                                i = R.id.startaudio;
                                                                                Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.startaudio);
                                                                                if (button3 != null) {
                                                                                    i = R.id.stopaudio;
                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.stopaudio);
                                                                                    if (button4 != null) {
                                                                                        i = R.id.toolbarTitleTV;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                        if (textView4 != null) {
                                                                                            return new ActivityGroupChatBinding(relativeLayout, textView, linearLayout, imageView, linearLayoutCompat, imageView2, textView2, recyclerView, button, textView3, button2, editText, imageView3, imageView4, linearLayout2, cardView, linearLayout3, linearLayout4, toolbar, relativeLayout, button3, button4, textView4);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
