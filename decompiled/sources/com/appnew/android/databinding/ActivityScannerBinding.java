package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityScannerBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final RelativeLayout bottomBar;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;

    private ActivityScannerBinding(RelativeLayout rootView, AppBarLayout appBar, RelativeLayout bottomBar, Toolbar toolbar) {
        this.rootView = rootView;
        this.appBar = appBar;
        this.bottomBar = bottomBar;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityScannerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityScannerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_scanner, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityScannerBinding bind(View rootView) {
        int i = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.appBar);
        if (appBarLayout != null) {
            i = R.id.bottomBar;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.bottomBar);
            if (relativeLayout != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                if (toolbar != null) {
                    return new ActivityScannerBinding((RelativeLayout) rootView, appBarLayout, relativeLayout, toolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
