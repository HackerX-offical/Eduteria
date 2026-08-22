package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DesignBinding implements ViewBinding {
    public final TextView ago;
    public final TextView comments;
    public final ImageView commentsImg;
    public final ImageView img;
    public final TextView paperTitle;
    private final LinearLayout rootView;

    private DesignBinding(LinearLayout rootView, TextView ago, TextView comments, ImageView commentsImg, ImageView img, TextView paperTitle) {
        this.rootView = rootView;
        this.ago = ago;
        this.comments = comments;
        this.commentsImg = commentsImg;
        this.img = img;
        this.paperTitle = paperTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DesignBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DesignBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.design, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DesignBinding bind(View rootView) {
        int i = R.id.ago;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ago);
        if (textView != null) {
            i = R.id.comments;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.comments);
            if (textView2 != null) {
                i = R.id.commentsImg;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.commentsImg);
                if (imageView != null) {
                    i = R.id.img;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img);
                    if (imageView2 != null) {
                        i = R.id.paper_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paper_title);
                        if (textView3 != null) {
                            return new DesignBinding((LinearLayout) rootView, textView, textView2, imageView, imageView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
