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
public final class SlideItemContainerBinding implements ViewBinding {
    public final TextView btnCancel;
    private final LinearLayout rootView;
    public final TextView txtTitle;

    private SlideItemContainerBinding(LinearLayout rootView, TextView btnCancel, TextView txtTitle) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.txtTitle = txtTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SlideItemContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SlideItemContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.slide_item_container, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SlideItemContainerBinding bind(View rootView) {
        int i = R.id.btnCancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btnCancel);
        if (textView != null) {
            i = R.id.txtTitle;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTitle);
            if (textView2 != null) {
                return new SlideItemContainerBinding((LinearLayout) rootView, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
