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
public final class SingleItemTilesTheme2Binding implements ViewBinding {
    public final View bgBottom;
    public final ImageView imageView;
    public final ImageView liveIV;
    public final LinearLayout parentBottom;
    private final LinearLayout rootView;
    public final TextView tilesTextTv;
    public final RelativeLayout tourLl;

    private SingleItemTilesTheme2Binding(LinearLayout rootView, View bgBottom, ImageView imageView, ImageView liveIV, LinearLayout parentBottom, TextView tilesTextTv, RelativeLayout tourLl) {
        this.rootView = rootView;
        this.bgBottom = bgBottom;
        this.imageView = imageView;
        this.liveIV = liveIV;
        this.parentBottom = parentBottom;
        this.tilesTextTv = tilesTextTv;
        this.tourLl = tourLl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleItemTilesTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemTilesTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_tiles_theme_2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemTilesTheme2Binding bind(View rootView) {
        int i = R.id.bg_bottom;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bg_bottom);
        if (viewFindChildViewById != null) {
            i = R.id.imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageView);
            if (imageView != null) {
                i = R.id.liveIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                if (imageView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) rootView;
                    i = R.id.tilesTextTv;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tilesTextTv);
                    if (textView != null) {
                        i = R.id.tour_ll;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tour_ll);
                        if (relativeLayout != null) {
                            return new SingleItemTilesTheme2Binding(linearLayout, viewFindChildViewById, imageView, imageView2, linearLayout, textView, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
