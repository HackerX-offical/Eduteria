package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDownloadPdfactivityBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView downloadImageBack;
    public final ImageView image;
    public final Toolbar mainToolbar;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final RecyclerView pdfListRecycler;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityDownloadPdfactivityBinding(ConstraintLayout rootView, Button backBtn, ImageView downloadImageBack, ImageView image, Toolbar mainToolbar, TextView noData, RelativeLayout noDataFoundRL, RecyclerView pdfListRecycler, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.downloadImageBack = downloadImageBack;
        this.image = image;
        this.mainToolbar = mainToolbar;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.pdfListRecycler = pdfListRecycler;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDownloadPdfactivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDownloadPdfactivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_download_pdfactivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDownloadPdfactivityBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.download_image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.download_image_back);
            if (imageView != null) {
                i = R.id.image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                if (imageView2 != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.no_data;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                        if (textView != null) {
                            i = R.id.no_data_found_RL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                            if (relativeLayout != null) {
                                i = R.id.pdfList_recycler;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.pdfList_recycler);
                                if (recyclerView != null) {
                                    i = R.id.toolbarTitleTV;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                    if (textView2 != null) {
                                        return new ActivityDownloadPdfactivityBinding((ConstraintLayout) rootView, button, imageView, imageView2, toolbar, textView, relativeLayout, recyclerView, textView2);
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
