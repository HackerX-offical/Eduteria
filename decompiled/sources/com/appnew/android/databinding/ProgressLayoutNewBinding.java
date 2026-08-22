package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.wang.avi.AVLoadingIndicatorView;

/* JADX INFO: loaded from: classes6.dex */
public final class ProgressLayoutNewBinding implements ViewBinding {
    public final TextView appNameLoader;
    private final LinearLayout rootView;
    public final AVLoadingIndicatorView testLoader;

    private ProgressLayoutNewBinding(LinearLayout rootView, TextView appNameLoader, AVLoadingIndicatorView testLoader) {
        this.rootView = rootView;
        this.appNameLoader = appNameLoader;
        this.testLoader = testLoader;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ProgressLayoutNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ProgressLayoutNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.progress_layout_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ProgressLayoutNewBinding bind(View rootView) {
        int i = R.id.appNameLoader;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.appNameLoader);
        if (textView != null) {
            i = R.id.testLoader;
            AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(rootView, R.id.testLoader);
            if (aVLoadingIndicatorView != null) {
                return new ProgressLayoutNewBinding((LinearLayout) rootView, textView, aVLoadingIndicatorView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
