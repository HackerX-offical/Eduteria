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
public final class BookmarkIndexRowBinding implements ViewBinding {
    public final ImageView delIv;
    public final CardView parentCV;
    private final RelativeLayout rootView;
    public final ImageView vedioicon;
    public final TextView vediotime;
    public final TextView vediotitle;

    private BookmarkIndexRowBinding(RelativeLayout rootView, ImageView delIv, CardView parentCV, ImageView vedioicon, TextView vediotime, TextView vediotitle) {
        this.rootView = rootView;
        this.delIv = delIv;
        this.parentCV = parentCV;
        this.vedioicon = vedioicon;
        this.vediotime = vediotime;
        this.vediotitle = vediotitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BookmarkIndexRowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BookmarkIndexRowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bookmark_index_row, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BookmarkIndexRowBinding bind(View rootView) {
        int i = R.id.del_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.del_iv);
        if (imageView != null) {
            i = R.id.parentCV;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.parentCV);
            if (cardView != null) {
                i = R.id.vedioicon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vedioicon);
                if (imageView2 != null) {
                    i = R.id.vediotime;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.vediotime);
                    if (textView != null) {
                        i = R.id.vediotitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.vediotitle);
                        if (textView2 != null) {
                            return new BookmarkIndexRowBinding((RelativeLayout) rootView, imageView, cardView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
