package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChooseNumberDialogBinding implements ViewBinding {
    private final RelativeLayout rootView;

    private ChooseNumberDialogBinding(RelativeLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseNumberDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChooseNumberDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.choose_number_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChooseNumberDialogBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ChooseNumberDialogBinding((RelativeLayout) rootView);
    }
}
