package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemGroupChatTileBinding implements ViewBinding {
    public final ImageView group;
    public final TextView groupName;
    public final CardView mainCv;
    private final CardView rootView;

    private ItemGroupChatTileBinding(CardView rootView, ImageView group, TextView groupName, CardView mainCv) {
        this.rootView = rootView;
        this.group = group;
        this.groupName = groupName;
        this.mainCv = mainCv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemGroupChatTileBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemGroupChatTileBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_group_chat_tile, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemGroupChatTileBinding bind(View rootView) {
        int i = R.id.group;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.group);
        if (imageView != null) {
            i = R.id.groupName;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.groupName);
            if (textView != null) {
                CardView cardView = (CardView) rootView;
                return new ItemGroupChatTileBinding(cardView, imageView, textView, cardView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
