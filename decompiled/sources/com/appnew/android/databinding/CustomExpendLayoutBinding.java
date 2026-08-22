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
public final class CustomExpendLayoutBinding implements ViewBinding {
    public final CardView cardLayout;
    public final ImageView downIcon;
    public final RelativeLayout expandedView;
    private final CardView rootView;
    public final TextView tvDescription;
    public final TextView tvLangName;

    private CustomExpendLayoutBinding(CardView rootView, CardView cardLayout, ImageView downIcon, RelativeLayout expandedView, TextView tvDescription, TextView tvLangName) {
        this.rootView = rootView;
        this.cardLayout = cardLayout;
        this.downIcon = downIcon;
        this.expandedView = expandedView;
        this.tvDescription = tvDescription;
        this.tvLangName = tvLangName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static CustomExpendLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomExpendLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_expend_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomExpendLayoutBinding bind(View rootView) {
        CardView cardView = (CardView) rootView;
        int i = R.id.downIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downIcon);
        if (imageView != null) {
            i = R.id.expanded_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.expanded_view);
            if (relativeLayout != null) {
                i = R.id.tv_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_description);
                if (textView != null) {
                    i = R.id.tv_lang_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_lang_name);
                    if (textView2 != null) {
                        return new CustomExpendLayoutBinding(cardView, cardView, imageView, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
