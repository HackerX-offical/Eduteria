package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: loaded from: classes6.dex */
public final class PdfBottomsheetBinding implements ViewBinding {
    public final RelativeLayout calcpagerl;
    public final ImageView cross;
    public final ImageView expand;
    public final PDFView pdfViewPager;
    public final ProgressBar progreebar;
    private final RelativeLayout rootView;

    private PdfBottomsheetBinding(RelativeLayout rootView, RelativeLayout calcpagerl, ImageView cross, ImageView expand, PDFView pdfViewPager, ProgressBar progreebar) {
        this.rootView = rootView;
        this.calcpagerl = calcpagerl;
        this.cross = cross;
        this.expand = expand;
        this.pdfViewPager = pdfViewPager;
        this.progreebar = progreebar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PdfBottomsheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PdfBottomsheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pdf_bottomsheet, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PdfBottomsheetBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.cross;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cross);
        if (imageView != null) {
            i = R.id.expand;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.expand);
            if (imageView2 != null) {
                i = R.id.pdfViewPager;
                PDFView pDFView = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfViewPager);
                if (pDFView != null) {
                    i = R.id.progreebar;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progreebar);
                    if (progressBar != null) {
                        return new PdfBottomsheetBinding(relativeLayout, relativeLayout, imageView, imageView2, pDFView, progressBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
