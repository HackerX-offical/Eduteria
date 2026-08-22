package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomAudioplayerBinding implements ViewBinding {
    public final TextView audioTextUsername;
    public final Button audiopause1;
    public final Button audioplay1;
    public final ImageView cancel;
    public final TextView righttexttimeAudio;
    private final RelativeLayout rootView;
    public final TextView textaudio;
    public final ImageView userimage;

    private CustomAudioplayerBinding(RelativeLayout rootView, TextView audioTextUsername, Button audiopause1, Button audioplay1, ImageView cancel, TextView righttexttimeAudio, TextView textaudio, ImageView userimage) {
        this.rootView = rootView;
        this.audioTextUsername = audioTextUsername;
        this.audiopause1 = audiopause1;
        this.audioplay1 = audioplay1;
        this.cancel = cancel;
        this.righttexttimeAudio = righttexttimeAudio;
        this.textaudio = textaudio;
        this.userimage = userimage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomAudioplayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomAudioplayerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_audioplayer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomAudioplayerBinding bind(View rootView) {
        int i = R.id.audioText_username;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.audioText_username);
        if (textView != null) {
            i = R.id.audiopause1;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.audiopause1);
            if (button != null) {
                i = R.id.audioplay1;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.audioplay1);
                if (button2 != null) {
                    i = R.id.cancel;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                    if (imageView != null) {
                        i = R.id.righttexttimeAudio;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimeAudio);
                        if (textView2 != null) {
                            i = R.id.textaudio;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textaudio);
                            if (textView3 != null) {
                                i = R.id.userimage;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.userimage);
                                if (imageView2 != null) {
                                    return new CustomAudioplayerBinding((RelativeLayout) rootView, textView, button, button2, imageView, textView2, textView3, imageView2);
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
