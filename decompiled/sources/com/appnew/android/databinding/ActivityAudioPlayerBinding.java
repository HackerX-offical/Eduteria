package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ActivityAudioPlayerBinding extends ViewDataBinding {
    public final AppBarMainBinding appbar;
    public final ImageView audioImage;
    public final ImageView btnBackward;
    public final ImageView btnForward;
    public final ImageView btnPlay;
    public final TextView exoPlaybackSpeed;
    public final LinearLayout llBanner;
    public final RelativeLayout llButtons;
    public final SeekBar sBar;
    public final TextView songName;
    public final TextView txtSname;
    public final TextView txtSongTime;
    public final TextView txtStartTime;

    protected ActivityAudioPlayerBinding(Object _bindingComponent, View _root, int _localFieldCount, AppBarMainBinding appbar, ImageView audioImage, ImageView btnBackward, ImageView btnForward, ImageView btnPlay, TextView exoPlaybackSpeed, LinearLayout llBanner, RelativeLayout llButtons, SeekBar sBar, TextView songName, TextView txtSname, TextView txtSongTime, TextView txtStartTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.appbar = appbar;
        this.audioImage = audioImage;
        this.btnBackward = btnBackward;
        this.btnForward = btnForward;
        this.btnPlay = btnPlay;
        this.exoPlaybackSpeed = exoPlaybackSpeed;
        this.llBanner = llBanner;
        this.llButtons = llButtons;
        this.sBar = sBar;
        this.songName = songName;
        this.txtSname = txtSname;
        this.txtSongTime = txtSongTime;
        this.txtStartTime = txtStartTime;
    }

    public static ActivityAudioPlayerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAudioPlayerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityAudioPlayerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_audio_player, root, attachToRoot, component);
    }

    public static ActivityAudioPlayerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAudioPlayerBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityAudioPlayerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_audio_player, null, false, component);
    }

    public static ActivityAudioPlayerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAudioPlayerBinding bind(View view, Object component) {
        return (ActivityAudioPlayerBinding) bind(component, view, R.layout.activity_audio_player);
    }
}
