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
public final class BottomItemBinding implements ViewBinding {
    public final LinearLayout dynamicLL;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView title;
    public final LinearLayout viewLL;
    public final RelativeLayout viewUnderLine;

    private BottomItemBinding(LinearLayout rootView, LinearLayout dynamicLL, ImageView icon, TextView title, LinearLayout viewLL, RelativeLayout viewUnderLine) {
        this.rootView = rootView;
        this.dynamicLL = dynamicLL;
        this.icon = icon;
        this.title = title;
        this.viewLL = viewLL;
        this.viewUnderLine = viewUnderLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomItemBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.icon);
        if (imageView != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
            if (textView != null) {
                i = R.id.viewLL;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewLL);
                if (linearLayout2 != null) {
                    i = R.id.viewUnderLine;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewUnderLine);
                    if (relativeLayout != null) {
                        return new BottomItemBinding(linearLayout, linearLayout, imageView, textView, linearLayout2, relativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
