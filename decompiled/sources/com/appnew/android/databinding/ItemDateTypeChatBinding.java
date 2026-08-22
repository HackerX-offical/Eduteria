package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemDateTypeChatBinding implements ViewBinding {
    public final TextView dateText;
    private final RelativeLayout rootView;

    private ItemDateTypeChatBinding(RelativeLayout rootView, TextView dateText) {
        this.rootView = rootView;
        this.dateText = dateText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemDateTypeChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemDateTypeChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_date_type_chat, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDateTypeChatBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dateText);
        if (textView != null) {
            return new ItemDateTypeChatBinding((RelativeLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.dateText)));
    }
}
