package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupjumpBinding implements ViewBinding {
    public final TextView cancelText;
    public final EditText enterPdfET;
    public final TextView okayText;
    public final TextView redAlert;
    private final LinearLayout rootView;
    public final TextView totalPageTV;

    private PopupjumpBinding(LinearLayout rootView, TextView cancelText, EditText enterPdfET, TextView okayText, TextView redAlert, TextView totalPageTV) {
        this.rootView = rootView;
        this.cancelText = cancelText;
        this.enterPdfET = enterPdfET;
        this.okayText = okayText;
        this.redAlert = redAlert;
        this.totalPageTV = totalPageTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PopupjumpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PopupjumpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.popupjump, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PopupjumpBinding bind(View rootView) {
        int i = R.id.cancel_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel_text);
        if (textView != null) {
            i = R.id.enterPdfET;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterPdfET);
            if (editText != null) {
                i = R.id.okay_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.okay_text);
                if (textView2 != null) {
                    i = R.id.redAlert;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.redAlert);
                    if (textView3 != null) {
                        i = R.id.totalPageTV;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalPageTV);
                        if (textView4 != null) {
                            return new PopupjumpBinding((LinearLayout) rootView, textView, editText, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
