package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemLeftNavigationBinding implements ViewBinding {
    public final ImageView expandIV;
    public final LinearLayout feedsLL;
    public final ImageView iconIV;
    public final TextView nameTV;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final SwitchCompat switchCompat;

    private ItemLeftNavigationBinding(LinearLayout rootView, ImageView expandIV, LinearLayout feedsLL, ImageView iconIV, TextView nameTV, RecyclerView recyclerView, SwitchCompat switchCompat) {
        this.rootView = rootView;
        this.expandIV = expandIV;
        this.feedsLL = feedsLL;
        this.iconIV = iconIV;
        this.nameTV = nameTV;
        this.recyclerView = recyclerView;
        this.switchCompat = switchCompat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemLeftNavigationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemLeftNavigationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_left_navigation, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemLeftNavigationBinding bind(View rootView) {
        int i = R.id.expandIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.expandIV);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.iconIV;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconIV);
            if (imageView2 != null) {
                i = R.id.nameTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                if (textView != null) {
                    i = R.id.recyclerView;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                    if (recyclerView != null) {
                        i = R.id.switchCompat;
                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.switchCompat);
                        if (switchCompat != null) {
                            return new ItemLeftNavigationBinding(linearLayout, imageView, linearLayout, imageView2, textView, recyclerView, switchCompat);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
