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
public final class TileViewNewBinding implements ViewBinding {
    public final RelativeLayout backgroundLl;
    private final LinearLayout rootView;
    public final ImageView tileImg;
    public final TextView tileTitle;

    private TileViewNewBinding(LinearLayout rootView, RelativeLayout backgroundLl, ImageView tileImg, TextView tileTitle) {
        this.rootView = rootView;
        this.backgroundLl = backgroundLl;
        this.tileImg = tileImg;
        this.tileTitle = tileTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TileViewNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TileViewNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.tile_view_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TileViewNewBinding bind(View rootView) {
        int i = R.id.background_ll;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.background_ll);
        if (relativeLayout != null) {
            i = R.id.tile_img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tile_img);
            if (imageView != null) {
                i = R.id.tile_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tile_title);
                if (textView != null) {
                    return new TileViewNewBinding((LinearLayout) rootView, relativeLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
