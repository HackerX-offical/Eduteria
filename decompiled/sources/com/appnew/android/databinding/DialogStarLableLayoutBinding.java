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
public final class DialogStarLableLayoutBinding implements ViewBinding {
    public final LinearLayout llDelete;
    private final LinearLayout rootView;
    public final TextView tvDelete;
    public final TextView tvLable;
    public final TextView tvPin;

    private DialogStarLableLayoutBinding(LinearLayout rootView, LinearLayout llDelete, TextView tvDelete, TextView tvLable, TextView tvPin) {
        this.rootView = rootView;
        this.llDelete = llDelete;
        this.tvDelete = tvDelete;
        this.tvLable = tvLable;
        this.tvPin = tvPin;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogStarLableLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogStarLableLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_star_lable_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogStarLableLayoutBinding bind(View rootView) {
        int i = R.id.llDelete;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llDelete);
        if (linearLayout != null) {
            i = R.id.tvDelete;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvDelete);
            if (textView != null) {
                i = R.id.tvLable;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLable);
                if (textView2 != null) {
                    i = R.id.tvPin;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvPin);
                    if (textView3 != null) {
                        return new DialogStarLableLayoutBinding((LinearLayout) rootView, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
