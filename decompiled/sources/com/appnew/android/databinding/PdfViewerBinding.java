package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: loaded from: classes6.dex */
public final class PdfViewerBinding implements ViewBinding {
    public final RelativeLayout RL;
    public final TextView SavePdf;
    public final ImageView back;
    public final TextView blink;
    public final ImageView downloadPdf;
    public final ImageView pdfBookmark;
    public final TextView pdfName;
    public final ImageView pdfRotate;
    public final PDFView pdfView;
    public final WebView pdfWebView;
    public final Button procceedBtn;
    public final ProgressBar progressbarPdf;
    public final ImageView refreshPage;
    public final LinearLayout root;
    private final LinearLayout rootView;
    public final ImageView searchPDF;
    public final CardView shareFloatingActionButton;
    public final RelativeLayout toolbarLayout;
    public final RelativeLayout webViewClick;

    private PdfViewerBinding(LinearLayout rootView, RelativeLayout RL, TextView SavePdf, ImageView back, TextView blink, ImageView downloadPdf, ImageView pdfBookmark, TextView pdfName, ImageView pdfRotate, PDFView pdfView, WebView pdfWebView, Button procceedBtn, ProgressBar progressbarPdf, ImageView refreshPage, LinearLayout root, ImageView searchPDF, CardView shareFloatingActionButton, RelativeLayout toolbarLayout, RelativeLayout webViewClick) {
        this.rootView = rootView;
        this.RL = RL;
        this.SavePdf = SavePdf;
        this.back = back;
        this.blink = blink;
        this.downloadPdf = downloadPdf;
        this.pdfBookmark = pdfBookmark;
        this.pdfName = pdfName;
        this.pdfRotate = pdfRotate;
        this.pdfView = pdfView;
        this.pdfWebView = pdfWebView;
        this.procceedBtn = procceedBtn;
        this.progressbarPdf = progressbarPdf;
        this.refreshPage = refreshPage;
        this.root = root;
        this.searchPDF = searchPDF;
        this.shareFloatingActionButton = shareFloatingActionButton;
        this.toolbarLayout = toolbarLayout;
        this.webViewClick = webViewClick;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PdfViewerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PdfViewerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pdf_viewer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PdfViewerBinding bind(View rootView) {
        int i = R.id.RL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL);
        if (relativeLayout != null) {
            i = R.id.Save_pdf;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Save_pdf);
            if (textView != null) {
                i = R.id.back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back);
                if (imageView != null) {
                    i = R.id.blink;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.blink);
                    if (textView2 != null) {
                        i = R.id.download_pdf;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.download_pdf);
                        if (imageView2 != null) {
                            i = R.id.pdf_bookmark;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdf_bookmark);
                            if (imageView3 != null) {
                                i = R.id.pdf_name;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_name);
                                if (textView3 != null) {
                                    i = R.id.pdf_Rotate;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.pdf_Rotate);
                                    if (imageView4 != null) {
                                        i = R.id.pdfView;
                                        PDFView pDFView = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfView);
                                        if (pDFView != null) {
                                            i = R.id.pdfWebView;
                                            WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.pdfWebView);
                                            if (webView != null) {
                                                i = R.id.procceed_btn;
                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.procceed_btn);
                                                if (button != null) {
                                                    i = R.id.progressbar_pdf;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressbar_pdf);
                                                    if (progressBar != null) {
                                                        i = R.id.refresh_page;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refresh_page);
                                                        if (imageView5 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) rootView;
                                                            i = R.id.searchPDF;
                                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchPDF);
                                                            if (imageView6 != null) {
                                                                i = R.id.shareFloatingActionButton;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.shareFloatingActionButton);
                                                                if (cardView != null) {
                                                                    i = R.id.toolbar_layout;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.toolbar_layout);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.webViewClick;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.webViewClick);
                                                                        if (relativeLayout3 != null) {
                                                                            return new PdfViewerBinding(linearLayout, relativeLayout, textView, imageView, textView2, imageView2, imageView3, textView3, imageView4, pDFView, webView, button, progressBar, imageView5, linearLayout, imageView6, cardView, relativeLayout2, relativeLayout3);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
