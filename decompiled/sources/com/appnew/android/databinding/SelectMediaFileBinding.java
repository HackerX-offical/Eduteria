package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.player.music_player.Utils;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class SelectMediaFileBinding extends ViewDataBinding {
    public final ImageView closeButton;

    @Bindable
    protected Utils.ChooseMediaFileBottomSheetDialog.MediaListener mMediaListener;

    public abstract void setMediaListener(Utils.ChooseMediaFileBottomSheetDialog.MediaListener mediaListener);

    protected SelectMediaFileBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView closeButton) {
        super(_bindingComponent, _root, _localFieldCount);
        this.closeButton = closeButton;
    }

    public Utils.ChooseMediaFileBottomSheetDialog.MediaListener getMediaListener() {
        return this.mMediaListener;
    }

    public static SelectMediaFileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SelectMediaFileBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SelectMediaFileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.select_media_file, root, attachToRoot, component);
    }

    public static SelectMediaFileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SelectMediaFileBinding inflate(LayoutInflater inflater, Object component) {
        return (SelectMediaFileBinding) ViewDataBinding.inflateInternal(inflater, R.layout.select_media_file, null, false, component);
    }

    public static SelectMediaFileBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SelectMediaFileBinding bind(View view, Object component) {
        return (SelectMediaFileBinding) bind(component, view, R.layout.select_media_file);
    }
}
