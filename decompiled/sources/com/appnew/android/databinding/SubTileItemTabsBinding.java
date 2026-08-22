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
public final class SubTileItemTabsBinding implements ViewBinding {
    public final RelativeLayout parentRL1;
    private final CardView rootView;
    public final CardView subTileItemCard;
    public final ImageView tabIV1;
    public final TextView tabTitle1;

    private SubTileItemTabsBinding(CardView rootView, RelativeLayout parentRL1, CardView subTileItemCard, ImageView tabIV1, TextView tabTitle1) {
        this.rootView = rootView;
        this.parentRL1 = parentRL1;
        this.subTileItemCard = subTileItemCard;
        this.tabIV1 = tabIV1;
        this.tabTitle1 = tabTitle1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static SubTileItemTabsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SubTileItemTabsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.sub_tile_item_tabs, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SubTileItemTabsBinding bind(View rootView) {
        int i = R.id.parentRL1;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL1);
        if (relativeLayout != null) {
            CardView cardView = (CardView) rootView;
            i = R.id.tabIV1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV1);
            if (imageView != null) {
                i = R.id.tabTitle1;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle1);
                if (textView != null) {
                    return new SubTileItemTabsBinding(cardView, relativeLayout, cardView, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
