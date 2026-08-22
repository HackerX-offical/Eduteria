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
public final class ItemAudioChatRightBinding implements ViewBinding {
    public final TextView audioTextUsername;
    public final Button audiopause;
    public final Button audioplay;
    public final RelativeLayout cvrRightAudio;
    public final ImageView ivPinAudio;
    public final LinearLayout mainContainerLL;
    public final LinearLayout mainRl6;
    public final TextView righttexttimeAudio;
    public final RelativeLayout rlAudioRight;
    private final RelativeLayout rootView;
    public final TextView textaudio;
    public final LinearLayout timeRl7;
    public final ImageView userimage;

    private ItemAudioChatRightBinding(RelativeLayout rootView, TextView audioTextUsername, Button audiopause, Button audioplay, RelativeLayout cvrRightAudio, ImageView ivPinAudio, LinearLayout mainContainerLL, LinearLayout mainRl6, TextView righttexttimeAudio, RelativeLayout rlAudioRight, TextView textaudio, LinearLayout timeRl7, ImageView userimage) {
        this.rootView = rootView;
        this.audioTextUsername = audioTextUsername;
        this.audiopause = audiopause;
        this.audioplay = audioplay;
        this.cvrRightAudio = cvrRightAudio;
        this.ivPinAudio = ivPinAudio;
        this.mainContainerLL = mainContainerLL;
        this.mainRl6 = mainRl6;
        this.righttexttimeAudio = righttexttimeAudio;
        this.rlAudioRight = rlAudioRight;
        this.textaudio = textaudio;
        this.timeRl7 = timeRl7;
        this.userimage = userimage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemAudioChatRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemAudioChatRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_audio_chat_right, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemAudioChatRightBinding bind(View rootView) {
        int i = R.id.audioText_username;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioText_username);
        if (textView != null) {
            i = R.id.audiopause;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.audiopause);
            if (button != null) {
                i = R.id.audioplay;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.audioplay);
                if (button2 != null) {
                    i = R.id.cvrRightAudio;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightAudio);
                    if (relativeLayout != null) {
                        i = R.id.ivPinAudio;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinAudio);
                        if (imageView != null) {
                            i = R.id.mainContainerLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainContainerLL);
                            if (linearLayout != null) {
                                i = R.id.mainRl6;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl6);
                                if (linearLayout2 != null) {
                                    i = R.id.righttexttimeAudio;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimeAudio);
                                    if (textView2 != null) {
                                        i = R.id.rl_audio_right;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_audio_right);
                                        if (relativeLayout2 != null) {
                                            i = R.id.textaudio;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudio);
                                            if (textView3 != null) {
                                                i = R.id.timeRl_7;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_7);
                                                if (linearLayout3 != null) {
                                                    i = R.id.userimage;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimage);
                                                    if (imageView2 != null) {
                                                        return new ItemAudioChatRightBinding((RelativeLayout) rootView, textView, button, button2, relativeLayout, imageView, linearLayout, linearLayout2, textView2, relativeLayout2, textView3, linearLayout3, imageView2);
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
