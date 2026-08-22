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
public final class ItemAudioChatLeftBinding implements ViewBinding {
    public final ImageView PopupLeftAudio;
    public final TextView audioTextUsernameLeft;
    public final TextView audioTimeLeftAudio;
    public final Button audiopauseLeft;
    public final Button audioplayLeft;
    public final RelativeLayout cvrLeftAudio;
    public final ImageView ivPinMsgLeftAudio;
    public final LinearLayout navHeaderLeftAudio;
    private final RelativeLayout rootView;
    public final TextView textaudioLeft;
    public final LinearLayout timeRl8;
    public final ImageView userimageLeft;

    private ItemAudioChatLeftBinding(RelativeLayout rootView, ImageView PopupLeftAudio, TextView audioTextUsernameLeft, TextView audioTimeLeftAudio, Button audiopauseLeft, Button audioplayLeft, RelativeLayout cvrLeftAudio, ImageView ivPinMsgLeftAudio, LinearLayout navHeaderLeftAudio, TextView textaudioLeft, LinearLayout timeRl8, ImageView userimageLeft) {
        this.rootView = rootView;
        this.PopupLeftAudio = PopupLeftAudio;
        this.audioTextUsernameLeft = audioTextUsernameLeft;
        this.audioTimeLeftAudio = audioTimeLeftAudio;
        this.audiopauseLeft = audiopauseLeft;
        this.audioplayLeft = audioplayLeft;
        this.cvrLeftAudio = cvrLeftAudio;
        this.ivPinMsgLeftAudio = ivPinMsgLeftAudio;
        this.navHeaderLeftAudio = navHeaderLeftAudio;
        this.textaudioLeft = textaudioLeft;
        this.timeRl8 = timeRl8;
        this.userimageLeft = userimageLeft;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemAudioChatLeftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemAudioChatLeftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_audio_chat_left, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAudioChatLeftBinding bind(View rootView) {
        int i = R.id.PopupLeftAudio;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.PopupLeftAudio);
        if (imageView != null) {
            i = R.id.audioText_usernameLeft;
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
                                i = R.id.ivPinMsgLeftAudio;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftAudio);
                                if (imageView2 != null) {
                                    i = R.id.nav_headerLeftAudio;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLeftAudio);
                                    if (linearLayout != null) {
                                        i = R.id.textaudioLeft;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudioLeft);
                                        if (textView3 != null) {
                                            i = R.id.timeRl_8;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_8);
                                            if (linearLayout2 != null) {
                                                i = R.id.userimageLeft;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimageLeft);
                                                if (imageView3 != null) {
                                                    return new ItemAudioChatLeftBinding((RelativeLayout) rootView, imageView, textView, textView2, button, button2, relativeLayout, imageView2, linearLayout, textView3, linearLayout2, imageView3);
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
