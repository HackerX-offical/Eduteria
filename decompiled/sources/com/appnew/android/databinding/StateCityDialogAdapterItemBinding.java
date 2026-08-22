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
public final class StateCityDialogAdapterItemBinding implements ViewBinding {
    public final TextView nameTv;
    private final LinearLayout rootView;
    public final View viewDivider;

    private StateCityDialogAdapterItemBinding(LinearLayout rootView, TextView nameTv, View viewDivider) {
        this.rootView = rootView;
        this.nameTv = nameTv;
        this.viewDivider = viewDivider;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StateCityDialogAdapterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static StateCityDialogAdapterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.state_city_dialog_adapter_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StateCityDialogAdapterItemBinding bind(View rootView) {
        int i = R.id.nameTv;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTv);
        if (textView != null) {
            i = R.id.viewDivider;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewDivider);
            if (viewFindChildViewById != null) {
                return new StateCityDialogAdapterItemBinding((LinearLayout) rootView, textView, viewFindChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
