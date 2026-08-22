package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemComboTileMainBinding implements ViewBinding {
    public final RecyclerView comboRV;
    private final RelativeLayout rootView;
    public final TextView viewAll;

    private ItemComboTileMainBinding(RelativeLayout rootView, RecyclerView comboRV, TextView viewAll) {
        this.rootView = rootView;
        this.comboRV = comboRV;
        this.viewAll = viewAll;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemComboTileMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemComboTileMainBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_combo_tile_main, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemComboTileMainBinding bind(View rootView) {
        int i = R.id.comboRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.comboRV);
        if (recyclerView != null) {
            i = R.id.view_all;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.view_all);
            if (textView != null) {
                return new ItemComboTileMainBinding((RelativeLayout) rootView, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
