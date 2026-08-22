package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class MainAppbarBinding implements ViewBinding {
    public final Toolbar mainToolbar;
    private final AppBarLayout rootView;

    private MainAppbarBinding(AppBarLayout rootView, Toolbar mainToolbar) {
        this.rootView = rootView;
        this.mainToolbar = mainToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public AppBarLayout getRoot() {
        return this.rootView;
    }

    public static MainAppbarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MainAppbarBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.main_appbar, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainAppbarBinding bind(View rootView) {
        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
        if (toolbar != null) {
            return new MainAppbarBinding((AppBarLayout) rootView, toolbar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.main_toolbar)));
    }
}
