package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NewItemShapBinding implements ViewBinding {
    public final Button bitrateButton;
    public final RelativeLayout parentLayout;
    private final RelativeLayout rootView;

    private NewItemShapBinding(RelativeLayout rootView, Button bitrateButton, RelativeLayout parentLayout) {
        this.rootView = rootView;
        this.bitrateButton = bitrateButton;
        this.parentLayout = parentLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NewItemShapBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NewItemShapBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.new_item_shap, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NewItemShapBinding bind(View rootView) {
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.bitrateButton);
        if (button != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            return new NewItemShapBinding(relativeLayout, button, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.bitrateButton)));
    }
}
