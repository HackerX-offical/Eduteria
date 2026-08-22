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
public final class CustomLanguagelistBinding implements ViewBinding {
    public final TextView languageText;
    private final LinearLayout rootView;

    private CustomLanguagelistBinding(LinearLayout rootView, TextView languageText) {
        this.rootView = rootView;
        this.languageText = languageText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomLanguagelistBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomLanguagelistBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_languagelist, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomLanguagelistBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.languageText);
        if (textView != null) {
            return new CustomLanguagelistBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.languageText)));
    }
}
