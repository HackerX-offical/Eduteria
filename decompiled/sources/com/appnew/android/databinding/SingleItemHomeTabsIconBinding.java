package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemHomeTabsIconBinding implements ViewBinding {
    public final RelativeLayout parentRL;
    private final CardView rootView;
    public final ImageView tabIV;

    private SingleItemHomeTabsIconBinding(CardView rootView, RelativeLayout parentRL, ImageView tabIV) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static SingleItemHomeTabsIconBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemHomeTabsIconBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_home_tabs_icon, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemHomeTabsIconBinding bind(View rootView) {
        int i = R.id.parentRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
        if (relativeLayout != null) {
            i = R.id.tabIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
            if (imageView != null) {
                return new SingleItemHomeTabsIconBinding((CardView) rootView, relativeLayout, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
