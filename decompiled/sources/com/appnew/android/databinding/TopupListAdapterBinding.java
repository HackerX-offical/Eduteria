package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TopupListAdapterBinding implements ViewBinding {
    public final TextView days;
    public final RelativeLayout layoutSelect;
    public final TextView price;
    private final RelativeLayout rootView;
    public final ImageView selectPlan;
    public final ImageView selected;

    private TopupListAdapterBinding(RelativeLayout rootView, TextView days, RelativeLayout layoutSelect, TextView price, ImageView selectPlan, ImageView selected) {
        this.rootView = rootView;
        this.days = days;
        this.layoutSelect = layoutSelect;
        this.price = price;
        this.selectPlan = selectPlan;
        this.selected = selected;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TopupListAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TopupListAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.topup_list_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TopupListAdapterBinding bind(View rootView) {
        int i = R.id.days;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.days);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.price;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.price);
            if (textView2 != null) {
                i = R.id.select_plan;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.select_plan);
                if (imageView != null) {
                    i = R.id.selected;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.selected);
                    if (imageView2 != null) {
                        return new TopupListAdapterBinding(relativeLayout, textView, relativeLayout, textView2, imageView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
