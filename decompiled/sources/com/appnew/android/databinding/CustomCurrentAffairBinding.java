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
public final class CustomCurrentAffairBinding implements ViewBinding {
    public final ImageView blinkNewCF;
    public final TextView currentAffairDate;
    public final ImageView currentAffairImage;
    public final TextView currentAffairSubject;
    public final TextView currentAffairTittle;
    private final RelativeLayout rootView;
    public final ImageView shareCurrentAffair;

    private CustomCurrentAffairBinding(RelativeLayout rootView, ImageView blinkNewCF, TextView currentAffairDate, ImageView currentAffairImage, TextView currentAffairSubject, TextView currentAffairTittle, ImageView shareCurrentAffair) {
        this.rootView = rootView;
        this.blinkNewCF = blinkNewCF;
        this.currentAffairDate = currentAffairDate;
        this.currentAffairImage = currentAffairImage;
        this.currentAffairSubject = currentAffairSubject;
        this.currentAffairTittle = currentAffairTittle;
        this.shareCurrentAffair = shareCurrentAffair;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomCurrentAffairBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomCurrentAffairBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_current_affair, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomCurrentAffairBinding bind(View rootView) {
        int i = R.id.blinkNewCF;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.blinkNewCF);
        if (imageView != null) {
            i = R.id.currentAffair_date;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_date);
            if (textView != null) {
                i = R.id.currentAffair_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_image);
                if (imageView2 != null) {
                    i = R.id.currentAffair_subject;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_subject);
                    if (textView2 != null) {
                        i = R.id.currentAffair_tittle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.currentAffair_tittle);
                        if (textView3 != null) {
                            i = R.id.shareCurrentAffair;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareCurrentAffair);
                            if (imageView3 != null) {
                                return new CustomCurrentAffairBinding((RelativeLayout) rootView, imageView, textView, imageView2, textView2, textView3, imageView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
