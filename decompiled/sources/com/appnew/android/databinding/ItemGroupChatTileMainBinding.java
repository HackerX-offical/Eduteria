package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemGroupChatTileMainBinding implements ViewBinding {
    public final RecyclerView groupChatRecycler;
    private final RelativeLayout rootView;

    private ItemGroupChatTileMainBinding(RelativeLayout rootView, RecyclerView groupChatRecycler) {
        this.rootView = rootView;
        this.groupChatRecycler = groupChatRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemGroupChatTileMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemGroupChatTileMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_group_chat_tile_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemGroupChatTileMainBinding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.groupChatRecycler);
        if (recyclerView != null) {
            return new ItemGroupChatTileMainBinding((RelativeLayout) rootView, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.groupChatRecycler)));
    }
}
