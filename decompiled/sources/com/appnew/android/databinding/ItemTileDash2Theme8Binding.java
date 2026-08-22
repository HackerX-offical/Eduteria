package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemTileDash2Theme8Binding implements ViewBinding {
    public final LinearLayout parentRL;
    private final LinearLayout rootView;
    public final CircleImageView tabIV;
    public final TextView title;

    private ItemTileDash2Theme8Binding(LinearLayout rootView, LinearLayout parentRL, CircleImageView tabIV, TextView title) {
        this.rootView = rootView;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemTileDash2Theme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemTileDash2Theme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_tile_dash2_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemTileDash2Theme8Binding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.tabIV;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
        if (circleImageView != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
            if (textView != null) {
                return new ItemTileDash2Theme8Binding(linearLayout, linearLayout, circleImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
