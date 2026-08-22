package com.skydoves.powermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powermenu.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutPowerMenuLibrarySkydovesBinding implements ViewBinding {
    public final CardView powerMenuCard;
    public final ListView powerMenuListView;
    private final FrameLayout rootView;

    private LayoutPowerMenuLibrarySkydovesBinding(FrameLayout frameLayout, CardView cardView, ListView listView) {
        this.rootView = frameLayout;
        this.powerMenuCard = cardView;
        this.powerMenuListView = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_power_menu_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPowerMenuLibrarySkydovesBinding bind(View view) {
        int i = R.id.power_menu_card;
        CardView cardView = (CardView) view.findViewById(i);
        if (cardView != null) {
            i = R.id.power_menu_listView;
            ListView listView = (ListView) view.findViewById(i);
            if (listView != null) {
                return new LayoutPowerMenuLibrarySkydovesBinding((FrameLayout) view, cardView, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
