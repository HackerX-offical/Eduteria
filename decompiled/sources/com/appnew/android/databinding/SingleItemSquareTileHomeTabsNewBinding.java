package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemSquareTileHomeTabsNewBinding implements ViewBinding {
    public final LinearLayout llMain2;
    public final ConstraintLayout parentRL;
    public final RelativeLayout parentRL1;
    public final RelativeLayout relativeLayout;
    private final RelativeLayout rootView;
    public final ImageView tabIV;
    public final TextView tabTitle;

    private SingleItemSquareTileHomeTabsNewBinding(RelativeLayout rootView, LinearLayout llMain2, ConstraintLayout parentRL, RelativeLayout parentRL1, RelativeLayout relativeLayout, ImageView tabIV, TextView tabTitle) {
        this.rootView = rootView;
        this.llMain2 = llMain2;
        this.parentRL = parentRL;
        this.parentRL1 = parentRL1;
        this.relativeLayout = relativeLayout;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleItemSquareTileHomeTabsNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemSquareTileHomeTabsNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_square_tile_home_tabs_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemSquareTileHomeTabsNewBinding bind(View rootView) {
        int i = R.id.ll_main2;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_main2);
        if (linearLayout != null) {
            i = R.id.parentRL;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
            if (constraintLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                i = R.id.relativeLayout;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLayout);
                if (relativeLayout2 != null) {
                    i = R.id.tabIV;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
                    if (imageView != null) {
                        i = R.id.tabTitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                        if (textView != null) {
                            return new SingleItemSquareTileHomeTabsNewBinding(relativeLayout, linearLayout, constraintLayout, relativeLayout, relativeLayout2, imageView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
