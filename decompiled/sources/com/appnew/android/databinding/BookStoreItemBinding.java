package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BookStoreItemBinding implements ViewBinding {
    public final TextView authorTV;
    public final ImageView bookImg;
    public final RelativeLayout main;
    public final TextView offerTV;
    public final TextView priceTV;
    private final RelativeLayout rootView;
    public final TextView topicTV;

    private BookStoreItemBinding(RelativeLayout rootView, TextView authorTV, ImageView bookImg, RelativeLayout main, TextView offerTV, TextView priceTV, TextView topicTV) {
        this.rootView = rootView;
        this.authorTV = authorTV;
        this.bookImg = bookImg;
        this.main = main;
        this.offerTV = offerTV;
        this.priceTV = priceTV;
        this.topicTV = topicTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BookStoreItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BookStoreItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.book_store_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BookStoreItemBinding bind(View rootView) {
        int i = R.id.authorTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorTV);
        if (textView != null) {
            i = R.id.bookImg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookImg);
            if (imageView != null) {
                i = R.id.main;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.main);
                if (relativeLayout != null) {
                    i = R.id.offerTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.offerTV);
                    if (textView2 != null) {
                        i = R.id.priceTV;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                        if (textView3 != null) {
                            i = R.id.topicTV;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topicTV);
                            if (textView4 != null) {
                                return new BookStoreItemBinding((RelativeLayout) rootView, textView, imageView, relativeLayout, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
