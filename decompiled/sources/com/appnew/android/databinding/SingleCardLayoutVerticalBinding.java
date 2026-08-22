package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleCardLayoutVerticalBinding implements ViewBinding {
    public final TextView appId;
    public final TextView id;
    public final TextView language;
    private final RelativeLayout rootView;
    public final CardView singleItemCardView;

    private SingleCardLayoutVerticalBinding(RelativeLayout rootView, TextView appId, TextView id, TextView language, CardView singleItemCardView) {
        this.rootView = rootView;
        this.appId = appId;
        this.id = id;
        this.language = language;
        this.singleItemCardView = singleItemCardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleCardLayoutVerticalBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleCardLayoutVerticalBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_card_layout_vertical, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleCardLayoutVerticalBinding bind(View rootView) {
        int i = R.id.appId;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.appId);
        if (textView != null) {
            i = R.id.id;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.id);
            if (textView2 != null) {
                i = R.id.language;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.language);
                if (textView3 != null) {
                    i = R.id.singleItemCardView;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.singleItemCardView);
                    if (cardView != null) {
                        return new SingleCardLayoutVerticalBinding((RelativeLayout) rootView, textView, textView2, textView3, cardView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
