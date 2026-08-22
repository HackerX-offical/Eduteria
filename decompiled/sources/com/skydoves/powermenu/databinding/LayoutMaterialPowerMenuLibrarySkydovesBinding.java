package com.skydoves.powermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.skydoves.powermenu.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutMaterialPowerMenuLibrarySkydovesBinding implements ViewBinding {
    public final MaterialCardView powerMenuCard;
    public final ListView powerMenuListView;
    private final FrameLayout rootView;

    private LayoutMaterialPowerMenuLibrarySkydovesBinding(FrameLayout frameLayout, MaterialCardView materialCardView, ListView listView) {
        this.rootView = frameLayout;
        this.powerMenuCard = materialCardView;
        this.powerMenuListView = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMaterialPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutMaterialPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_material_power_menu_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutMaterialPowerMenuLibrarySkydovesBinding bind(View view) {
        int i = R.id.power_menu_card;
        MaterialCardView materialCardView = (MaterialCardView) view.findViewById(i);
        if (materialCardView != null) {
            i = R.id.power_menu_listView;
            ListView listView = (ListView) view.findViewById(i);
            if (listView != null) {
                return new LayoutMaterialPowerMenuLibrarySkydovesBinding((FrameLayout) view, materialCardView, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
