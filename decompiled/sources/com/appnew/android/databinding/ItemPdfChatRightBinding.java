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
public final class ItemPdfChatRightBinding implements ViewBinding {
    public final RelativeLayout cvrDownLoadRight;
    public final RelativeLayout cvrRightpdf;
    public final ImageView downloadIc;
    public final ImageView ivPinPdf;
    public final TextView pdfNameRight;
    public final LinearLayout pdfRightClick;
    public final TextView pdfTextUsername;
    public final LinearLayout pdfViewRight;
    public final LinearLayout pdflayout;
    public final TextView righttexttimePdf;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl5;

    private ItemPdfChatRightBinding(RelativeLayout rootView, RelativeLayout cvrDownLoadRight, RelativeLayout cvrRightpdf, ImageView downloadIc, ImageView ivPinPdf, TextView pdfNameRight, LinearLayout pdfRightClick, TextView pdfTextUsername, LinearLayout pdfViewRight, LinearLayout pdflayout, TextView righttexttimePdf, LinearLayout timeRl5) {
        this.rootView = rootView;
        this.cvrDownLoadRight = cvrDownLoadRight;
        this.cvrRightpdf = cvrRightpdf;
        this.downloadIc = downloadIc;
        this.ivPinPdf = ivPinPdf;
        this.pdfNameRight = pdfNameRight;
        this.pdfRightClick = pdfRightClick;
        this.pdfTextUsername = pdfTextUsername;
        this.pdfViewRight = pdfViewRight;
        this.pdflayout = pdflayout;
        this.righttexttimePdf = righttexttimePdf;
        this.timeRl5 = timeRl5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemPdfChatRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemPdfChatRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_pdf_chat_right, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPdfChatRightBinding bind(View rootView) {
        int i = R.id.cvrDownLoadRight;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadRight);
        if (relativeLayout != null) {
            i = R.id.cvrRightpdf;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrRightpdf);
            if (relativeLayout2 != null) {
                i = R.id.downloadIc;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downloadIc);
                if (imageView != null) {
                    i = R.id.ivPinPdf;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivPinPdf);
                    if (imageView2 != null) {
                        i = R.id.pdfNameRight;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfNameRight);
                        if (textView != null) {
                            i = R.id.pdf_right_click;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdf_right_click);
                            if (linearLayout != null) {
                                i = R.id.pdfText_username;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_username);
                                if (textView2 != null) {
                                    i = R.id.pdfViewRight;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfViewRight);
                                    if (linearLayout2 != null) {
                                        i = R.id.pdflayout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdflayout);
                                        if (linearLayout3 != null) {
                                            i = R.id.righttexttimePdf;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.righttexttimePdf);
                                            if (textView3 != null) {
                                                i = R.id.timeRl_5;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_5);
                                                if (linearLayout4 != null) {
                                                    return new ItemPdfChatRightBinding((RelativeLayout) rootView, relativeLayout, relativeLayout2, imageView, imageView2, textView, linearLayout, textView2, linearLayout2, linearLayout3, textView3, linearLayout4);
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
