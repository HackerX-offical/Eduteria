package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class TrackSelectionDialogBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final Button trackSelectionDialogCancelButton;
    public final Button trackSelectionDialogOkButton;
    public final TabLayout trackSelectionDialogTabLayout;
    public final ViewPager trackSelectionDialogViewPager;

    private TrackSelectionDialogBinding(RelativeLayout rootView, Button trackSelectionDialogCancelButton, Button trackSelectionDialogOkButton, TabLayout trackSelectionDialogTabLayout, ViewPager trackSelectionDialogViewPager) {
        this.rootView = rootView;
        this.trackSelectionDialogCancelButton = trackSelectionDialogCancelButton;
        this.trackSelectionDialogOkButton = trackSelectionDialogOkButton;
        this.trackSelectionDialogTabLayout = trackSelectionDialogTabLayout;
        this.trackSelectionDialogViewPager = trackSelectionDialogViewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TrackSelectionDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TrackSelectionDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.track_selection_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TrackSelectionDialogBinding bind(View rootView) {
        int i = R.id.track_selection_dialog_cancel_button;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.track_selection_dialog_cancel_button);
        if (button != null) {
            i = R.id.track_selection_dialog_ok_button;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.track_selection_dialog_ok_button);
            if (button2 != null) {
                i = R.id.track_selection_dialog_tab_layout;
                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.track_selection_dialog_tab_layout);
                if (tabLayout != null) {
                    i = R.id.track_selection_dialog_view_pager;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.track_selection_dialog_view_pager);
                    if (viewPager != null) {
                        return new TrackSelectionDialogBinding((RelativeLayout) rootView, button, button2, tabLayout, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
