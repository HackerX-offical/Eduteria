package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemSquareTileHomeTabsBinding implements ViewBinding {
    public final ConstraintLayout consLay;
    public final RelativeLayout parentRL;
    public final RelativeLayout relativeLayoutSingleItem;
    private final RelativeLayout rootView;
    public final ImageView tabIV;
    public final TextView tabTitle;

    private SingleItemSquareTileHomeTabsBinding(RelativeLayout rootView, ConstraintLayout consLay, RelativeLayout parentRL, RelativeLayout relativeLayoutSingleItem, ImageView tabIV, TextView tabTitle) {
        this.rootView = rootView;
        this.consLay = consLay;
        this.parentRL = parentRL;
        this.relativeLayoutSingleItem = relativeLayoutSingleItem;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleItemSquareTileHomeTabsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemSquareTileHomeTabsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_square_tile_home_tabs, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemSquareTileHomeTabsBinding bind(View rootView) {
        int i = R.id.cons_lay;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.cons_lay);
        if (constraintLayout != null) {
            i = R.id.parentRL;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
            if (relativeLayout != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                i = R.id.tabIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
                if (imageView != null) {
                    i = R.id.tabTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                    if (textView != null) {
                        return new SingleItemSquareTileHomeTabsBinding(relativeLayout2, constraintLayout, relativeLayout, relativeLayout2, imageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
