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
public final class CustomBookmarkListBinding implements ViewBinding {
    public final TextView bookmarkCount;
    public final ImageView bookmarkImage;
    public final TextView bookmarkSubject;
    public final TextView bookmarkTittle;
    private final RelativeLayout rootView;
    public final ImageView shareCurrentAffair;

    private CustomBookmarkListBinding(RelativeLayout rootView, TextView bookmarkCount, ImageView bookmarkImage, TextView bookmarkSubject, TextView bookmarkTittle, ImageView shareCurrentAffair) {
        this.rootView = rootView;
        this.bookmarkCount = bookmarkCount;
        this.bookmarkImage = bookmarkImage;
        this.bookmarkSubject = bookmarkSubject;
        this.bookmarkTittle = bookmarkTittle;
        this.shareCurrentAffair = shareCurrentAffair;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomBookmarkListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomBookmarkListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_bookmark_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomBookmarkListBinding bind(View rootView) {
        int i = R.id.bookmark_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_count);
        if (textView != null) {
            i = R.id.bookmark_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookmark_image);
            if (imageView != null) {
                i = R.id.bookmark_subject;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_subject);
                if (textView2 != null) {
                    i = R.id.bookmark_tittle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookmark_tittle);
                    if (textView3 != null) {
                        i = R.id.shareCurrentAffair;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareCurrentAffair);
                        if (imageView2 != null) {
                            return new CustomBookmarkListBinding((RelativeLayout) rootView, textView, imageView, textView2, textView3, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
