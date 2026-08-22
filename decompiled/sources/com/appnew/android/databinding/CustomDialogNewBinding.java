package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomDialogNewBinding implements ViewBinding {
    public final Button cancel;
    public final LinearLayout linearLayout;
    public final Button play;
    public final Button record;
    private final LinearLayout rootView;
    public final Button send;
    public final TextView timerno;

    private CustomDialogNewBinding(LinearLayout rootView, Button cancel, LinearLayout linearLayout, Button play, Button record, Button send, TextView timerno) {
        this.rootView = rootView;
        this.cancel = cancel;
        this.linearLayout = linearLayout;
        this.play = play;
        this.record = record;
        this.send = send;
        this.timerno = timerno;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomDialogNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomDialogNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_dialog_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomDialogNewBinding bind(View rootView) {
        int i = R.id.cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.cancel);
        if (button != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.play;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.play);
            if (button2 != null) {
                i = R.id.record;
                Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.record);
                if (button3 != null) {
                    i = R.id.send;
                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.send);
                    if (button4 != null) {
                        i = R.id.timerno;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.timerno);
                        if (textView != null) {
                            return new CustomDialogNewBinding(linearLayout, button, linearLayout, button2, button3, button4, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
