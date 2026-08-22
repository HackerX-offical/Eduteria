package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTestBinding implements ViewBinding {
    public final RelativeLayout main;
    public final PDFView pdfView;
    private final RelativeLayout rootView;

    private ActivityTestBinding(RelativeLayout rootView, RelativeLayout main, PDFView pdfView) {
        this.rootView = rootView;
        this.main = main;
        this.pdfView = pdfView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_test, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        PDFView pDFView = (PDFView) ViewBindings.findChildViewById(rootView, R.id.pdfView);
        if (pDFView != null) {
            return new ActivityTestBinding(relativeLayout, relativeLayout, pDFView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.pdfView)));
    }
}
