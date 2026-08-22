package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtIntroOrangelayout2Binding implements ViewBinding {
    private final LinearLayout rootView;

    private IbtIntroOrangelayout2Binding(LinearLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtIntroOrangelayout2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtIntroOrangelayout2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_intro_orangelayout2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtIntroOrangelayout2Binding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new IbtIntroOrangelayout2Binding((LinearLayout) rootView);
    }
}
