package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtIntroGreenlayout4Binding implements ViewBinding {
    private final LinearLayout rootView;

    private IbtIntroGreenlayout4Binding(LinearLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtIntroGreenlayout4Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtIntroGreenlayout4Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_intro_greenlayout4, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtIntroGreenlayout4Binding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new IbtIntroGreenlayout4Binding((LinearLayout) rootView);
    }
}
