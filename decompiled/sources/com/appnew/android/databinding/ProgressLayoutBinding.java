package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.wang.avi.AVLoadingIndicatorView;

/* JADX INFO: loaded from: classes6.dex */
public final class ProgressLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final AVLoadingIndicatorView testLoader;

    private ProgressLayoutBinding(RelativeLayout rootView, AVLoadingIndicatorView testLoader) {
        this.rootView = rootView;
        this.testLoader = testLoader;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProgressLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ProgressLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.progress_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ProgressLayoutBinding bind(View rootView) {
        AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(rootView, R.id.testLoader);
        if (aVLoadingIndicatorView != null) {
            return new ProgressLayoutBinding((RelativeLayout) rootView, aVLoadingIndicatorView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.testLoader)));
    }
}
