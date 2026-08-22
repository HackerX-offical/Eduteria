package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtIntroPurplelayout3Binding implements ViewBinding {
    private final LinearLayout rootView;

    private IbtIntroPurplelayout3Binding(LinearLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtIntroPurplelayout3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtIntroPurplelayout3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_intro_purplelayout3, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtIntroPurplelayout3Binding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new IbtIntroPurplelayout3Binding((LinearLayout) rootView);
    }
}
