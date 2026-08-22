package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomGroupChatNewBinding implements ViewBinding {
    public final TextView audioTextUsernameLeft;
    public final TextView audioTimeLeftAudio;
    public final Button audiopauseLeft;
    public final Button audioplayLeft;
    public final RelativeLayout cvrLeftAudio;
    public final RelativeLayout cvrLeftimage;
    public final LinearLayout ivImgLeftClick;
    public final TextView leftimagetime;
    public final ImageView letfmessageTvimage;
    public final LinearLayout masterMessageCard;
    public final LinearLayout navHeaderLeftAudio;
    public final TextView replayMessage;
    private final LinearLayout rootView;
    public final TextView textaudioLeft;
    public final TextView tvTime;
    public final TextView userMessage;
    public final LinearLayout userMessageCard;
    public final TextView userNameimage;
    public final ImageView userimageLeft;

    private CustomGroupChatNewBinding(LinearLayout rootView, TextView audioTextUsernameLeft, TextView audioTimeLeftAudio, Button audiopauseLeft, Button audioplayLeft, RelativeLayout cvrLeftAudio, RelativeLayout cvrLeftimage, LinearLayout ivImgLeftClick, TextView leftimagetime, ImageView letfmessageTvimage, LinearLayout masterMessageCard, LinearLayout navHeaderLeftAudio, TextView replayMessage, TextView textaudioLeft, TextView tvTime, TextView userMessage, LinearLayout userMessageCard, TextView userNameimage, ImageView userimageLeft) {
        this.rootView = rootView;
        this.audioTextUsernameLeft = audioTextUsernameLeft;
        this.audioTimeLeftAudio = audioTimeLeftAudio;
        this.audiopauseLeft = audiopauseLeft;
        this.audioplayLeft = audioplayLeft;
        this.cvrLeftAudio = cvrLeftAudio;
        this.cvrLeftimage = cvrLeftimage;
        this.ivImgLeftClick = ivImgLeftClick;
        this.leftimagetime = leftimagetime;
        this.letfmessageTvimage = letfmessageTvimage;
        this.masterMessageCard = masterMessageCard;
        this.navHeaderLeftAudio = navHeaderLeftAudio;
        this.replayMessage = replayMessage;
        this.textaudioLeft = textaudioLeft;
        this.tvTime = tvTime;
        this.userMessage = userMessage;
        this.userMessageCard = userMessageCard;
        this.userNameimage = userNameimage;
        this.userimageLeft = userimageLeft;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomGroupChatNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomGroupChatNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_group_chat_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomGroupChatNewBinding bind(View rootView) {
        int i = R.id.audioText_usernameLeft;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioText_usernameLeft);
        if (textView != null) {
            i = R.id.audio_timeLeftAudio;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.audio_timeLeftAudio);
            if (textView2 != null) {
                i = R.id.audiopauseLeft;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.audiopauseLeft);
                if (button != null) {
                    i = R.id.audioplayLeft;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.audioplayLeft);
                    if (button2 != null) {
                        i = R.id.cvrLeftAudio;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftAudio);
                        if (relativeLayout != null) {
                            i = R.id.cvrLeftimage;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftimage);
                            if (relativeLayout2 != null) {
                                i = R.id.iv_img_left_click;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.iv_img_left_click);
                                if (linearLayout != null) {
                                    i = R.id.leftimagetime;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.leftimagetime);
                                    if (textView3 != null) {
                                        i = R.id.letfmessageTvimage;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.letfmessageTvimage);
                                        if (imageView != null) {
                                            i = R.id.masterMessageCard;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.masterMessageCard);
                                            if (linearLayout2 != null) {
                                                i = R.id.nav_headerLeftAudio;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLeftAudio);
                                                if (linearLayout3 != null) {
                                                    i = R.id.replayMessage;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.replayMessage);
                                                    if (textView4 != null) {
                                                        i = R.id.textaudioLeft;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudioLeft);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_time;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_time);
                                                            if (textView6 != null) {
                                                                i = R.id.userMessage;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userMessage);
                                                                if (textView7 != null) {
                                                                    i = R.id.userMessageCard;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.userMessageCard);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.userNameimage;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userNameimage);
                                                                        if (textView8 != null) {
                                                                            i = R.id.userimageLeft;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimageLeft);
                                                                            if (imageView2 != null) {
                                                                                return new CustomGroupChatNewBinding((LinearLayout) rootView, textView, textView2, button, button2, relativeLayout, relativeLayout2, linearLayout, textView3, imageView, linearLayout2, linearLayout3, textView4, textView5, textView6, textView7, linearLayout4, textView8, imageView2);
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
