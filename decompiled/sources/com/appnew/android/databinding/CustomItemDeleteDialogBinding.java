package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomItemDeleteDialogBinding implements ViewBinding {
    public final TextView TV1;
    public final Button cancelBtn;
    public final Button deleteBtn;
    private final RelativeLayout rootView;

    private CustomItemDeleteDialogBinding(RelativeLayout rootView, TextView TV1, Button cancelBtn, Button deleteBtn) {
        this.rootView = rootView;
        this.TV1 = TV1;
        this.cancelBtn = cancelBtn;
        this.deleteBtn = deleteBtn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomItemDeleteDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomItemDeleteDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_item_delete_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomItemDeleteDialogBinding bind(View rootView) {
        int i = R.id.TV1;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.TV1);
        if (textView != null) {
            i = R.id.cancelBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.cancelBtn);
            if (button != null) {
                i = R.id.deleteBtn;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.deleteBtn);
                if (button2 != null) {
                    return new CustomItemDeleteDialogBinding((RelativeLayout) rootView, textView, button, button2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
