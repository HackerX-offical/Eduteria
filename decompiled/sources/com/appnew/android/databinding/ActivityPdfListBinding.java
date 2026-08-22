package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityPdfListBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout noDataFoundRL;
    public final RecyclerView pdfListRV;
    private final LinearLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityPdfListBinding(LinearLayout rootView, ImageView imageBack, Toolbar mainToolbar, RelativeLayout noDataFoundRL, RecyclerView pdfListRV, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.noDataFoundRL = noDataFoundRL;
        this.pdfListRV = pdfListRV;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPdfListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityPdfListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_pdf_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityPdfListBinding bind(View rootView) {
        int i = R.id.image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
        if (imageView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                i = R.id.no_data_foundRL;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_foundRL);
                if (relativeLayout != null) {
                    i = R.id.pdf_ListRV;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.pdf_ListRV);
                    if (recyclerView != null) {
                        i = R.id.toolbarTitleTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                        if (textView != null) {
                            return new ActivityPdfListBinding((LinearLayout) rootView, imageView, toolbar, relativeLayout, recyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
