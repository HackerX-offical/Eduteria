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
public final class ContentTypeAdapterItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView text;

    private ContentTypeAdapterItemBinding(LinearLayout rootView, TextView text) {
        this.rootView = rootView;
        this.text = text;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ContentTypeAdapterItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ContentTypeAdapterItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.content_type_adapter_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ContentTypeAdapterItemBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.text);
        if (textView != null) {
            return new ContentTypeAdapterItemBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.text)));
    }
}
