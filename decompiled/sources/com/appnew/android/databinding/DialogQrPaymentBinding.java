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
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogQrPaymentBinding implements ViewBinding {
    public final TextView emptyView;
    public final ImageView ivClose;
    public final ShapeableImageView ivQrImage;
    public final RelativeLayout mainQRRL;
    public final LinearLayout qrLoader;
    private final RelativeLayout rootView;
    public final TextView time;

    private DialogQrPaymentBinding(RelativeLayout rootView, TextView emptyView, ImageView ivClose, ShapeableImageView ivQrImage, RelativeLayout mainQRRL, LinearLayout qrLoader, TextView time) {
        this.rootView = rootView;
        this.emptyView = emptyView;
        this.ivClose = ivClose;
        this.ivQrImage = ivQrImage;
        this.mainQRRL = mainQRRL;
        this.qrLoader = qrLoader;
        this.time = time;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogQrPaymentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogQrPaymentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_qr_payment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogQrPaymentBinding bind(View rootView) {
        int i = R.id.emptyView;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.emptyView);
        if (textView != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_close);
            if (imageView != null) {
                i = R.id.iv_qr_image;
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.iv_qr_image);
                if (shapeableImageView != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.qrLoader;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.qrLoader);
                    if (linearLayout != null) {
                        i = R.id.time;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                        if (textView2 != null) {
                            return new DialogQrPaymentBinding(relativeLayout, textView, imageView, shapeableImageView, relativeLayout, linearLayout, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
