package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityPinnedChatBinding implements ViewBinding {
    public final ImageView attachment;
    public final ImageView backBtn;
    public final LinearLayout bottomLayout;
    public final ImageView camera;
    public final ImageView cancel;
    public final RecyclerView chatRecycler;
    public final TextView editChatText;
    public final RelativeLayout editChatTextRl;
    public final RelativeLayout editLayout;
    public final ImageView emoji;
    public final LinearLayout endLayout;
    public final EditText etMessage;
    public final RelativeLayout main;
    public final RelativeLayout mainToolbar;
    public final RelativeLayout messageRl;
    public final NoDataFoundBinding ndf;
    public final TextView pinChatMessage;
    public final ImageView pinnedImage;
    public final RelativeLayout pinnedLayout;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final ImageView send;
    public final TextView toolbarTitleTV;
    public final ImageView voice;

    private ActivityPinnedChatBinding(RelativeLayout rootView, ImageView attachment, ImageView backBtn, LinearLayout bottomLayout, ImageView camera, ImageView cancel, RecyclerView chatRecycler, TextView editChatText, RelativeLayout editChatTextRl, RelativeLayout editLayout, ImageView emoji, LinearLayout endLayout, EditText etMessage, RelativeLayout main, RelativeLayout mainToolbar, RelativeLayout messageRl, NoDataFoundBinding ndf, TextView pinChatMessage, ImageView pinnedImage, RelativeLayout pinnedLayout, ProgressBar progressBar, ImageView send, TextView toolbarTitleTV, ImageView voice) {
        this.rootView = rootView;
        this.attachment = attachment;
        this.backBtn = backBtn;
        this.bottomLayout = bottomLayout;
        this.camera = camera;
        this.cancel = cancel;
        this.chatRecycler = chatRecycler;
        this.editChatText = editChatText;
        this.editChatTextRl = editChatTextRl;
        this.editLayout = editLayout;
        this.emoji = emoji;
        this.endLayout = endLayout;
        this.etMessage = etMessage;
        this.main = main;
        this.mainToolbar = mainToolbar;
        this.messageRl = messageRl;
        this.ndf = ndf;
        this.pinChatMessage = pinChatMessage;
        this.pinnedImage = pinnedImage;
        this.pinnedLayout = pinnedLayout;
        this.progressBar = progressBar;
        this.send = send;
        this.toolbarTitleTV = toolbarTitleTV;
        this.voice = voice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPinnedChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPinnedChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pinned_chat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPinnedChatBinding bind(View rootView) {
        int i = R.id.attachment;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.attachment);
        if (imageView != null) {
            i = R.id.backBtn;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backBtn);
            if (imageView2 != null) {
                i = R.id.bottomLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomLayout);
                if (linearLayout != null) {
                    i = R.id.camera;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.camera);
                    if (imageView3 != null) {
                        i = R.id.cancel;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                        if (imageView4 != null) {
                            i = R.id.chatRecycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.chatRecycler);
                            if (recyclerView != null) {
                                i = R.id.editChatText;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.editChatText);
                                if (textView != null) {
                                    i = R.id.editChatTextRl;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editChatTextRl);
                                    if (relativeLayout != null) {
                                        i = R.id.editLayout;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editLayout);
                                        if (relativeLayout2 != null) {
                                            i = R.id.emoji;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.emoji);
                                            if (imageView5 != null) {
                                                i = R.id.endLayout;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.endLayout);
                                                if (linearLayout2 != null) {
                                                    i = R.id.et_message;
                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                                                    if (editText != null) {
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                                        i = R.id.main_toolbar;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.messageRl;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.messageRl);
                                                            if (relativeLayout5 != null) {
                                                                i = R.id.ndf;
                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.ndf);
                                                                if (viewFindChildViewById != null) {
                                                                    NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
                                                                    i = R.id.pinChatMessage;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pinChatMessage);
                                                                    if (textView2 != null) {
                                                                        i = R.id.pinnedImage;
                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pinnedImage);
                                                                        if (imageView6 != null) {
                                                                            i = R.id.pinnedLayout;
                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pinnedLayout);
                                                                            if (relativeLayout6 != null) {
                                                                                i = R.id.progressBar;
                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                if (progressBar != null) {
                                                                                    i = R.id.send;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.send);
                                                                                    if (imageView7 != null) {
                                                                                        i = R.id.toolbarTitleTV;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.voice;
                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.voice);
                                                                                            if (imageView8 != null) {
                                                                                                return new ActivityPinnedChatBinding(relativeLayout3, imageView, imageView2, linearLayout, imageView3, imageView4, recyclerView, textView, relativeLayout, relativeLayout2, imageView5, linearLayout2, editText, relativeLayout3, relativeLayout4, relativeLayout5, noDataFoundBindingBind, textView2, imageView6, relativeLayout6, progressBar, imageView7, textView3, imageView8);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
