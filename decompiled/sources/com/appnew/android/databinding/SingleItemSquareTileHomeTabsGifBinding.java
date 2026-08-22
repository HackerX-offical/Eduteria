package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemSquareTileHomeTabsGifBinding implements ViewBinding {
    public final RelativeLayout parentRL;
    private final CardView rootView;
    public final ImageView tabIV;
    public final TextView tabTitle;

    private SingleItemSquareTileHomeTabsGifBinding(CardView rootView, RelativeLayout parentRL, ImageView tabIV, TextView tabTitle) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static SingleItemSquareTileHomeTabsGifBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemSquareTileHomeTabsGifBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_square_tile_home_tabs_gif, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemSquareTileHomeTabsGifBinding bind(View rootView) {
        int i = R.id.parentRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
        if (relativeLayout != null) {
            i = R.id.tabIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
            if (imageView != null) {
                i = R.id.tabTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                if (textView != null) {
                    return new SingleItemSquareTileHomeTabsGifBinding((CardView) rootView, relativeLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
