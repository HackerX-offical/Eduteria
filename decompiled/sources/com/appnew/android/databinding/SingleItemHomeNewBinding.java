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
public final class SingleItemHomeNewBinding implements ViewBinding {
    public final RelativeLayout parentRL;
    private final CardView rootView;
    public final ImageView tabIV;
    public final TextView tabTitle;

    private SingleItemHomeNewBinding(CardView rootView, RelativeLayout parentRL, ImageView tabIV, TextView tabTitle) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static SingleItemHomeNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemHomeNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_home_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemHomeNewBinding bind(View rootView) {
        int i = R.id.parentRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
        if (relativeLayout != null) {
            i = R.id.tabIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
            if (imageView != null) {
                i = R.id.tabTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                if (textView != null) {
                    return new SingleItemHomeNewBinding((CardView) rootView, relativeLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
