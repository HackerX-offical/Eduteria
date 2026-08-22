package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DownloadUrlBitrateBinding extends ViewDataBinding {
    public final Button quality;

    protected DownloadUrlBitrateBinding(Object _bindingComponent, View _root, int _localFieldCount, Button quality) {
        super(_bindingComponent, _root, _localFieldCount);
        this.quality = quality;
    }

    public static DownloadUrlBitrateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadUrlBitrateBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DownloadUrlBitrateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.download_url_bitrate, root, attachToRoot, component);
    }

    public static DownloadUrlBitrateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadUrlBitrateBinding inflate(LayoutInflater inflater, Object component) {
        return (DownloadUrlBitrateBinding) ViewDataBinding.inflateInternal(inflater, R.layout.download_url_bitrate, null, false, component);
    }

    public static DownloadUrlBitrateBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadUrlBitrateBinding bind(View view, Object component) {
        return (DownloadUrlBitrateBinding) bind(component, view, R.layout.download_url_bitrate);
    }
}
