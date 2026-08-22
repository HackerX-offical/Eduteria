package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class DownloadYoutubeBottomSheetBinding extends ViewDataBinding {
    public final LinearLayout lnPreparing;
    public final RecyclerView recyclerView;
    public final LinearLayout topLayout;
    public final TextView tvResName;

    protected DownloadYoutubeBottomSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout lnPreparing, RecyclerView recyclerView, LinearLayout topLayout, TextView tvResName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.lnPreparing = lnPreparing;
        this.recyclerView = recyclerView;
        this.topLayout = topLayout;
        this.tvResName = tvResName;
    }

    public static DownloadYoutubeBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadYoutubeBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DownloadYoutubeBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.download_youtube_bottom_sheet, root, attachToRoot, component);
    }

    public static DownloadYoutubeBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadYoutubeBottomSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DownloadYoutubeBottomSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.download_youtube_bottom_sheet, null, false, component);
    }

    public static DownloadYoutubeBottomSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DownloadYoutubeBottomSheetBinding bind(View view, Object component) {
        return (DownloadYoutubeBottomSheetBinding) bind(component, view, R.layout.download_youtube_bottom_sheet);
    }
}
