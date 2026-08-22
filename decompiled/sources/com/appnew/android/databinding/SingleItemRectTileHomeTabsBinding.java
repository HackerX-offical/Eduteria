package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemRectTileHomeTabsBinding implements ViewBinding {
    public final ConstraintLayout parentRL;
    private final CardView rootView;
    public final ImageView tabIV;
    public final TextView tabTitle;

    private SingleItemRectTileHomeTabsBinding(CardView rootView, ConstraintLayout parentRL, ImageView tabIV, TextView tabTitle) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static SingleItemRectTileHomeTabsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemRectTileHomeTabsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_rect_tile_home_tabs, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemRectTileHomeTabsBinding bind(View rootView) {
        int i = R.id.parentRL;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
        if (constraintLayout != null) {
            i = R.id.tabIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
            if (imageView != null) {
                i = R.id.tabTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                if (textView != null) {
                    return new SingleItemRectTileHomeTabsBinding((CardView) rootView, constraintLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
