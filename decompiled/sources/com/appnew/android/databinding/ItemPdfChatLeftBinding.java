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
public final class ItemPdfChatLeftBinding implements ViewBinding {
    public final RelativeLayout cvrDownLoadLeft;
    public final RelativeLayout cvrLeftpdf;
    public final ImageView downloadIcLeft;
    public final ImageView ivPinMsgLeftPdf;
    public final LinearLayout mainRl5;
    public final LinearLayout navHeaderLLPdf;
    public final TextView pdfNameLeft;
    public final TextView pdfTextUsernameLeft;
    public final TextView pdfTimeLeftPdf;
    public final LinearLayout pdfViewLeft;
    public final LinearLayout pdflayoutLeft;
    private final RelativeLayout rootView;
    public final LinearLayout timeRl6;
    public final TextView tvLeft;

    private ItemPdfChatLeftBinding(RelativeLayout rootView, RelativeLayout cvrDownLoadLeft, RelativeLayout cvrLeftpdf, ImageView downloadIcLeft, ImageView ivPinMsgLeftPdf, LinearLayout mainRl5, LinearLayout navHeaderLLPdf, TextView pdfNameLeft, TextView pdfTextUsernameLeft, TextView pdfTimeLeftPdf, LinearLayout pdfViewLeft, LinearLayout pdflayoutLeft, LinearLayout timeRl6, TextView tvLeft) {
        this.rootView = rootView;
        this.cvrDownLoadLeft = cvrDownLoadLeft;
        this.cvrLeftpdf = cvrLeftpdf;
        this.downloadIcLeft = downloadIcLeft;
        this.ivPinMsgLeftPdf = ivPinMsgLeftPdf;
        this.mainRl5 = mainRl5;
        this.navHeaderLLPdf = navHeaderLLPdf;
        this.pdfNameLeft = pdfNameLeft;
        this.pdfTextUsernameLeft = pdfTextUsernameLeft;
        this.pdfTimeLeftPdf = pdfTimeLeftPdf;
        this.pdfViewLeft = pdfViewLeft;
        this.pdflayoutLeft = pdflayoutLeft;
        this.timeRl6 = timeRl6;
        this.tvLeft = tvLeft;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemPdfChatLeftBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemPdfChatLeftBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_pdf_chat_left, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemPdfChatLeftBinding bind(View rootView) {
        int i = R.id.cvrDownLoadLeft;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrDownLoadLeft);
        if (relativeLayout != null) {
            i = R.id.cvrLeftpdf;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLeftpdf);
            if (relativeLayout2 != null) {
                i = R.id.downloadIcLeft;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downloadIcLeft);
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
                                i = R.id.pdfNameLeft;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfNameLeft);
                                if (textView != null) {
                                    i = R.id.pdfText_usernameLeft;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdfText_usernameLeft);
                                    if (textView2 != null) {
                                        i = R.id.pdf_timeLeftPdf;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_timeLeftPdf);
                                        if (textView3 != null) {
                                            i = R.id.pdfViewLeft;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdfViewLeft);
                                            if (linearLayout3 != null) {
                                                i = R.id.pdflayoutLeft;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.pdflayoutLeft);
                                                if (linearLayout4 != null) {
                                                    i = R.id.timeRl_6;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.timeRl_6);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.tvLeft;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLeft);
                                                        if (textView4 != null) {
                                                            return new ItemPdfChatLeftBinding((RelativeLayout) rootView, relativeLayout, relativeLayout2, imageView, imageView2, linearLayout, linearLayout2, textView, textView2, textView3, linearLayout3, linearLayout4, linearLayout5, textView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
