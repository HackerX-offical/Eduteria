package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtIntroBluelayout1Binding implements ViewBinding {
    public final TextView firstTitle;
    private final LinearLayout rootView;

    private IbtIntroBluelayout1Binding(LinearLayout rootView, TextView firstTitle) {
        this.rootView = rootView;
        this.firstTitle = firstTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtIntroBluelayout1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtIntroBluelayout1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_intro_bluelayout1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtIntroBluelayout1Binding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.firstTitle);
        if (textView != null) {
            return new IbtIntroBluelayout1Binding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.firstTitle)));
    }
}
