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
public final class ItemPdfChatRightNewBinding implements ViewBinding {
    public final RelativeLayout cvrDownLoadRight;
    public final RelativeLayout cvrRightpdf;
    public final ImageView imageThumbnail;
    public final ImageView ivPinPdf;
    public final LinearLayout mainContainerLL;
    public final ImageView pdfImageRight;
    public final TextView pdfNameRight;
    public final LinearLayout pdfRightClick;
    public final TextView pdfTextUsername;
    public final TextView pdfTimeLeftPdf;
    public final LinearLayout rightPdfLl;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl6;

    private ItemPdfChatRightNewBinding(RelativeLayout rootView, RelativeLayout cvrDownLoadRight, RelativeLayout cvrRightpdf, ImageView imageThumbnail, ImageView ivPinPdf, LinearLayout mainContainerLL, ImageView pdfImageRight, TextView pdfNameRight, LinearLayout pdfRightClick, TextView pdfTextUsername, TextView pdfTimeLeftPdf, LinearLayout rightPdfLl, LinearLayout timeRl6) {
        this.rootView = rootView;
        this.cvrDownLoadRight = cvrDownLoadRight;
        this.cvrRightpdf = cvrRightpdf;
        this.imageThumbnail = imageThumbnail;
        this.ivPinPdf = ivPinPdf;
        this.mainContainerLL = mainContainerLL;
        this.pdfImageRight = pdfImageRight;
        this.pdfNameRight = pdfNameRight;
        this.pdfRightClick = pdfRightClick;
        this.pdfTextUsername = pdfTextUsername;
        this.pdfTimeLeftPdf = pdfTimeLeftPdf;
        this.rightPdfLl = rightPdfLl;
        this.timeRl6 = timeRl6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemPdfChatRightNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemPdfChatRightNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_pdf_chat_right_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPdfChatRightNewBinding bind(View rootView) {
        int i = R.id.cvrDownLoadRight;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadRight);
        if (relativeLayout != null) {
            i = R.id.cvrRightpdf;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightpdf);
            if (relativeLayout2 != null) {
                i = R.id.imageThumbnail;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageThumbnail);
                if (imageView != null) {
                    i = R.id.ivPinPdf;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinPdf);
                    if (imageView2 != null) {
                        i = R.id.mainContainerLL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainContainerLL);
                        if (linearLayout != null) {
                            i = R.id.pdfImageRight;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdfImageRight);
                            if (imageView3 != null) {
                                i = R.id.pdfNameRight;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfNameRight);
                                if (textView != null) {
                                    i = R.id.pdf_right_click;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdf_right_click);
                                    if (linearLayout2 != null) {
                                        i = R.id.pdfText_username;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_username);
                                        if (textView2 != null) {
                                            i = R.id.pdf_timeLeftPdf;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_timeLeftPdf);
                                            if (textView3 != null) {
                                                i = R.id.rightPdf_ll;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rightPdf_ll);
                                                if (linearLayout3 != null) {
                                                    i = R.id.timeRl_6;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_6);
                                                    if (linearLayout4 != null) {
                                                        return new ItemPdfChatRightNewBinding((RelativeLayout) rootView, relativeLayout, relativeLayout2, imageView, imageView2, linearLayout, imageView3, textView, linearLayout2, textView2, textView3, linearLayout3, linearLayout4);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
