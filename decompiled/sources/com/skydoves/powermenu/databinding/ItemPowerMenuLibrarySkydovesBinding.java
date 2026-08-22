package com.skydoves.powermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powermenu.R;

/* JADX INFO: loaded from: classes9.dex */
public final class ItemPowerMenuLibrarySkydovesBinding implements ViewBinding {
    public final AppCompatImageView itemPowerMenuIcon;
    public final LinearLayout itemPowerMenuLayout;
    public final AppCompatTextView itemPowerMenuTitle;
    private final LinearLayout rootView;

    private ItemPowerMenuLibrarySkydovesBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.itemPowerMenuIcon = appCompatImageView;
        this.itemPowerMenuLayout = linearLayout2;
        this.itemPowerMenuTitle = appCompatTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPowerMenuLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_power_menu_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPowerMenuLibrarySkydovesBinding bind(View view) {
        int i = R.id.item_power_menu_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(i);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.item_power_menu_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i2);
            if (appCompatTextView != null) {
                return new ItemPowerMenuLibrarySkydovesBinding(linearLayout, appCompatImageView, linearLayout, appCompatTextView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
