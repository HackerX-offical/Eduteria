package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemChatPopupMenuBinding implements ViewBinding {
    public final ImageView popupImage;
    public final TextView popupText;
    private final RelativeLayout rootView;

    private ItemChatPopupMenuBinding(RelativeLayout rootView, ImageView popupImage, TextView popupText) {
        this.rootView = rootView;
        this.popupImage = popupImage;
        this.popupText = popupText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemChatPopupMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemChatPopupMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_chat_popup_menu, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemChatPopupMenuBinding bind(View rootView) {
        int i = R.id.popupImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.popupImage);
        if (imageView != null) {
            i = R.id.popupText;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.popupText);
            if (textView != null) {
                return new ItemChatPopupMenuBinding((RelativeLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
