package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BottomSheetStreamYtBinding extends ViewDataBinding {
    public final LinearLayout stream1Layout;
    public final LinearLayout stream2Layout;
    public final LinearLayout stream3Layout;
    public final TextView streamTitle;

    protected BottomSheetStreamYtBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout stream1Layout, LinearLayout stream2Layout, LinearLayout stream3Layout, TextView streamTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.stream1Layout = stream1Layout;
        this.stream2Layout = stream2Layout;
        this.stream3Layout = stream3Layout;
        this.streamTitle = streamTitle;
    }

    public static BottomSheetStreamYtBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetStreamYtBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (BottomSheetStreamYtBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_stream_yt, root, attachToRoot, component);
    }

    public static BottomSheetStreamYtBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetStreamYtBinding inflate(LayoutInflater inflater, Object component) {
        return (BottomSheetStreamYtBinding) ViewDataBinding.inflateInternal(inflater, R.layout.bottom_sheet_stream_yt, null, false, component);
    }

    public static BottomSheetStreamYtBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static BottomSheetStreamYtBinding bind(View view, Object component) {
        return (BottomSheetStreamYtBinding) bind(component, view, R.layout.bottom_sheet_stream_yt);
    }
}
