package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DailyDoseMenuBinding implements ViewBinding {
    public final LinearLayout LinearBackground;
    public final RelativeLayout imageplayerRL;
    public final ImageView itemIV;
    public final TextView itemTitleTV;
    public final LinearLayout parentLL;
    private final LinearLayout rootView;
    public final View view1;

    private DailyDoseMenuBinding(LinearLayout rootView, LinearLayout LinearBackground, RelativeLayout imageplayerRL, ImageView itemIV, TextView itemTitleTV, LinearLayout parentLL, View view1) {
        this.rootView = rootView;
        this.LinearBackground = LinearBackground;
        this.imageplayerRL = imageplayerRL;
        this.itemIV = itemIV;
        this.itemTitleTV = itemTitleTV;
        this.parentLL = parentLL;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DailyDoseMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DailyDoseMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.daily_dose_menu, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DailyDoseMenuBinding bind(View rootView) {
        int i = R.id.Linear_background;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Linear_background);
        if (linearLayout != null) {
            i = R.id.imageplayerRL;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageplayerRL);
            if (relativeLayout != null) {
                i = R.id.itemIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.itemIV);
                if (imageView != null) {
                    i = R.id.itemTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.itemTitleTV);
                    if (textView != null) {
                        LinearLayout linearLayout2 = (LinearLayout) rootView;
                        i = R.id.view1;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                        if (viewFindChildViewById != null) {
                            return new DailyDoseMenuBinding(linearLayout2, linearLayout, relativeLayout, imageView, textView, linearLayout2, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
