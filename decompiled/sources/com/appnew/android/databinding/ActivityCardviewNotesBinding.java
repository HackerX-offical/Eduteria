package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCardviewNotesBinding implements ViewBinding {
    public final ImageView ivPdf;
    public final TextView pdftext;
    public final RelativeLayout rl3;
    private final LinearLayoutCompat rootView;
    public final ImageView textpdf;

    private ActivityCardviewNotesBinding(LinearLayoutCompat rootView, ImageView ivPdf, TextView pdftext, RelativeLayout rl3, ImageView textpdf) {
        this.rootView = rootView;
        this.ivPdf = ivPdf;
        this.pdftext = pdftext;
        this.rl3 = rl3;
        this.textpdf = textpdf;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ActivityCardviewNotesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCardviewNotesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_cardview_notes, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardviewNotesBinding bind(View rootView) {
        int i = R.id.iv_pdf;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_pdf);
        if (imageView != null) {
            i = R.id.pdftext;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdftext);
            if (textView != null) {
                i = R.id.rl3;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl3);
                if (relativeLayout != null) {
                    i = R.id.textpdf;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.textpdf);
                    if (imageView2 != null) {
                        return new ActivityCardviewNotesBinding((LinearLayoutCompat) rootView, imageView, textView, relativeLayout, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
