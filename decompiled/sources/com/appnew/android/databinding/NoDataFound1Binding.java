package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NoDataFound1Binding implements ViewBinding {
    public final Button backBtn;
    public final ImageView image;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    private final RelativeLayout rootView;

    private NoDataFound1Binding(RelativeLayout rootView, Button backBtn, ImageView image, TextView noData, RelativeLayout noDataFoundRL) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NoDataFound1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NoDataFound1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.no_data_found_1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NoDataFound1Binding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (imageView != null) {
                i = R.id.no_data;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                if (textView != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    return new NoDataFound1Binding(relativeLayout, button, imageView, textView, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
