package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityPopupFormBinding implements ViewBinding {
    public final Button btnOpenDialog;
    private final ConstraintLayout rootView;

    private ActivityPopupFormBinding(ConstraintLayout rootView, Button btnOpenDialog) {
        this.rootView = rootView;
        this.btnOpenDialog = btnOpenDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPopupFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPopupFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_popup_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPopupFormBinding bind(View rootView) {
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnOpenDialog);
        if (button != null) {
            return new ActivityPopupFormBinding((ConstraintLayout) rootView, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.btnOpenDialog)));
    }
}
