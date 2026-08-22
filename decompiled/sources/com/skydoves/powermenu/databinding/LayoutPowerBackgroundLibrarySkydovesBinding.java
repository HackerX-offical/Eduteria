package com.skydoves.powermenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.skydoves.powermenu.R;

/* JADX INFO: loaded from: classes9.dex */
public final class LayoutPowerBackgroundLibrarySkydovesBinding implements ViewBinding {
    public final RelativeLayout powerBackground;
    private final RelativeLayout rootView;

    private LayoutPowerBackgroundLibrarySkydovesBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.powerBackground = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPowerBackgroundLibrarySkydovesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutPowerBackgroundLibrarySkydovesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_power_background_library_skydoves, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutPowerBackgroundLibrarySkydovesBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        return new LayoutPowerBackgroundLibrarySkydovesBinding(relativeLayout, relativeLayout);
    }
}
