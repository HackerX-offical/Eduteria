package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemTilesNewBinding implements ViewBinding {
    public final LinearLayout parentBottom;
    private final LinearLayout rootView;
    public final TextView tilesTextTv;

    private SingleItemTilesNewBinding(LinearLayout rootView, LinearLayout parentBottom, TextView tilesTextTv) {
        this.rootView = rootView;
        this.parentBottom = parentBottom;
        this.tilesTextTv = tilesTextTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleItemTilesNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemTilesNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_tiles_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemTilesNewBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tilesTextTv);
        if (textView != null) {
            return new SingleItemTilesNewBinding(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.tilesTextTv)));
    }
}
