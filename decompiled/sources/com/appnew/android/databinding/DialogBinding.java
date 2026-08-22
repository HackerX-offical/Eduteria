package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogBinding implements ViewBinding {
    public final ProgressBar progressHorizontal;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView value123;

    private DialogBinding(LinearLayout rootView, ProgressBar progressHorizontal, TextView text, TextView value123) {
        this.rootView = rootView;
        this.progressHorizontal = progressHorizontal;
        this.text = text;
        this.value123 = value123;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogBinding bind(View rootView) {
        int i = R.id.progress_horizontal;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_horizontal);
        if (progressBar != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.text);
            if (textView != null) {
                i = R.id.value123;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.value123);
                if (textView2 != null) {
                    return new DialogBinding((LinearLayout) rootView, progressBar, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
