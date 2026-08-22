package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityGroupChat2Binding implements ViewBinding {
    public final ImageView attachment;
    public final RelativeLayout audioLayoutRl;
    public final LinearLayout audioMainLL;
    public final TextView audioRecordTime;
    public final ImageView backBtn;
    public final LinearLayout bottomLayout;
    public final ImageView camera;
    public final ImageView cancel;
    public final ImageView cancelRecording;
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
    public final ImageView pauseAudio;
    public final TextView pinChatMessage;
    public final ImageView pinnedImage;
    public final RelativeLayout pinnedLayout;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final ImageView send;
    public final ImageView sendRecording;
    public final Space space;
    public final LinearLayout textLayout;
    public final TextView toolbarTitleTV;
    public final ImageView voice;

    private ActivityGroupChat2Binding(RelativeLayout rootView, ImageView attachment, RelativeLayout audioLayoutRl, LinearLayout audioMainLL, TextView audioRecordTime, ImageView backBtn, LinearLayout bottomLayout, ImageView camera, ImageView cancel, ImageView cancelRecording, RecyclerView chatRecycler, TextView editChatText, RelativeLayout editChatTextRl, RelativeLayout editLayout, ImageView emoji, LinearLayout endLayout, EditText etMessage, RelativeLayout main, RelativeLayout mainToolbar, RelativeLayout messageRl, NoDataFoundBinding ndf, ImageView pauseAudio, TextView pinChatMessage, ImageView pinnedImage, RelativeLayout pinnedLayout, ProgressBar progressBar, ImageView send, ImageView sendRecording, Space space, LinearLayout textLayout, TextView toolbarTitleTV, ImageView voice) {
        this.rootView = rootView;
        this.attachment = attachment;
        this.audioLayoutRl = audioLayoutRl;
        this.audioMainLL = audioMainLL;
        this.audioRecordTime = audioRecordTime;
        this.backBtn = backBtn;
        this.bottomLayout = bottomLayout;
        this.camera = camera;
        this.cancel = cancel;
        this.cancelRecording = cancelRecording;
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
        this.pauseAudio = pauseAudio;
        this.pinChatMessage = pinChatMessage;
        this.pinnedImage = pinnedImage;
        this.pinnedLayout = pinnedLayout;
        this.progressBar = progressBar;
        this.send = send;
        this.sendRecording = sendRecording;
        this.space = space;
        this.textLayout = textLayout;
        this.toolbarTitleTV = toolbarTitleTV;
        this.voice = voice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGroupChat2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityGroupChat2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_group_chat2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityGroupChat2Binding bind(View rootView) {
        int i = R.id.attachment;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.attachment);
        if (imageView != null) {
            i = R.id.audioLayoutRl;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.audioLayoutRl);
            if (relativeLayout != null) {
                i = R.id.audioMainLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.audioMainLL);
                if (linearLayout != null) {
                    i = R.id.audioRecordTime;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioRecordTime);
                    if (textView != null) {
                        i = R.id.backBtn;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backBtn);
                        if (imageView2 != null) {
                            i = R.id.bottomLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomLayout);
                            if (linearLayout2 != null) {
                                i = R.id.camera;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.camera);
                                if (imageView3 != null) {
                                    i = R.id.cancel;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                                    if (imageView4 != null) {
                                        i = R.id.cancelRecording;
                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelRecording);
                                        if (imageView5 != null) {
                                            i = R.id.chatRecycler;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.chatRecycler);
                                            if (recyclerView != null) {
                                                i = R.id.editChatText;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.editChatText);
                                                if (textView2 != null) {
                                                    i = R.id.editChatTextRl;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editChatTextRl);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.editLayout;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editLayout);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.emoji;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.emoji);
                                                            if (imageView6 != null) {
                                                                i = R.id.endLayout;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.endLayout);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.et_message;
                                                                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_message);
                                                                    if (editText != null) {
                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) rootView;
                                                                        i = R.id.main_toolbar;
                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                        if (relativeLayout5 != null) {
                                                                            i = R.id.messageRl;
                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.messageRl);
                                                                            if (relativeLayout6 != null) {
                                                                                i = R.id.ndf;
                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.ndf);
                                                                                if (viewFindChildViewById != null) {
                                                                                    NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
                                                                                    i = R.id.pauseAudio;
                                                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pauseAudio);
                                                                                    if (imageView7 != null) {
                                                                                        i = R.id.pinChatMessage;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pinChatMessage);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.pinnedImage;
                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pinnedImage);
                                                                                            if (imageView8 != null) {
                                                                                                i = R.id.pinnedLayout;
                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pinnedLayout);
                                                                                                if (relativeLayout7 != null) {
                                                                                                    i = R.id.progressBar;
                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                    if (progressBar != null) {
                                                                                                        i = R.id.send;
                                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.send);
                                                                                                        if (imageView9 != null) {
                                                                                                            i = R.id.sendRecording;
                                                                                                            ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.sendRecording);
                                                                                                            if (imageView10 != null) {
                                                                                                                i = R.id.space;
                                                                                                                Space space = (Space) ViewBindings.findChildViewById(rootView, R.id.space);
                                                                                                                if (space != null) {
                                                                                                                    i = R.id.textLayout;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.textLayout);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i = R.id.toolbarTitleTV;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                        if (textView4 != null) {
                                                                                                                            i = R.id.voice;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.voice);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                return new ActivityGroupChat2Binding(relativeLayout4, imageView, relativeLayout, linearLayout, textView, imageView2, linearLayout2, imageView3, imageView4, imageView5, recyclerView, textView2, relativeLayout2, relativeLayout3, imageView6, linearLayout3, editText, relativeLayout4, relativeLayout5, relativeLayout6, noDataFoundBindingBind, imageView7, textView3, imageView8, relativeLayout7, progressBar, imageView9, imageView10, space, linearLayout4, textView4, imageView11);
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
