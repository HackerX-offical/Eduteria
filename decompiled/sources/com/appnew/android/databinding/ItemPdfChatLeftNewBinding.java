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
public final class ItemPdfChatLeftNewBinding implements ViewBinding {
    public final RelativeLayout cvrDownLoadLeft;
    public final RelativeLayout cvrLeftpdf;
    public final ImageView imageThumbnail;
    public final ImageView ivPinMsgLeftPdf;
    public final LinearLayout mainRl5;
    public final LinearLayout navHeaderLLPdf;
    public final ImageView pdfImageRight;
    public final LinearLayout pdfLl;
    public final TextView pdfNameLeft;
    public final TextView pdfTextUsernameLeft;
    public final TextView pdfTimeLeftPdf;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl6;

    private ItemPdfChatLeftNewBinding(RelativeLayout rootView, RelativeLayout cvrDownLoadLeft, RelativeLayout cvrLeftpdf, ImageView imageThumbnail, ImageView ivPinMsgLeftPdf, LinearLayout mainRl5, LinearLayout navHeaderLLPdf, ImageView pdfImageRight, LinearLayout pdfLl, TextView pdfNameLeft, TextView pdfTextUsernameLeft, TextView pdfTimeLeftPdf, LinearLayout timeRl6) {
        this.rootView = rootView;
        this.cvrDownLoadLeft = cvrDownLoadLeft;
        this.cvrLeftpdf = cvrLeftpdf;
        this.imageThumbnail = imageThumbnail;
        this.ivPinMsgLeftPdf = ivPinMsgLeftPdf;
        this.mainRl5 = mainRl5;
        this.navHeaderLLPdf = navHeaderLLPdf;
        this.pdfImageRight = pdfImageRight;
        this.pdfLl = pdfLl;
        this.pdfNameLeft = pdfNameLeft;
        this.pdfTextUsernameLeft = pdfTextUsernameLeft;
        this.pdfTimeLeftPdf = pdfTimeLeftPdf;
        this.timeRl6 = timeRl6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemPdfChatLeftNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemPdfChatLeftNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_pdf_chat_left_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPdfChatLeftNewBinding bind(View rootView) {
        int i = R.id.cvrDownLoadLeft;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadLeft);
        if (relativeLayout != null) {
            i = R.id.cvrLeftpdf;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftpdf);
            if (relativeLayout2 != null) {
                i = R.id.imageThumbnail;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageThumbnail);
                if (imageView != null) {
                    i = R.id.ivPinMsgLeftPdf;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinMsgLeftPdf);
                    if (imageView2 != null) {
                        i = R.id.mainRl5;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainRl5);
                        if (linearLayout != null) {
                            i = R.id.nav_headerLLPdf;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLLPdf);
                            if (linearLayout2 != null) {
                                i = R.id.pdfImageRight;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdfImageRight);
                                if (imageView3 != null) {
                                    i = R.id.pdf_ll;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdf_ll);
                                    if (linearLayout3 != null) {
                                        i = R.id.pdfNameLeft;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfNameLeft);
                                        if (textView != null) {
                                            i = R.id.pdfText_usernameLeft;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_usernameLeft);
                                            if (textView2 != null) {
                                                i = R.id.pdf_timeLeftPdf;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_timeLeftPdf);
                                                if (textView3 != null) {
                                                    i = R.id.timeRl_6;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_6);
                                                    if (linearLayout4 != null) {
                                                        return new ItemPdfChatLeftNewBinding((RelativeLayout) rootView, relativeLayout, relativeLayout2, imageView, imageView2, linearLayout, linearLayout2, imageView3, linearLayout3, textView, textView2, textView3, linearLayout4);
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
