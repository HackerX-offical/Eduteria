package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentPdfBookMarkBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView image;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final RecyclerView pdfBookmarkListRecycler;
    private final FrameLayout rootView;

    private FragmentPdfBookMarkBinding(FrameLayout rootView, Button backBtn, ImageView image, TextView noData, RelativeLayout noDataFoundRL, RecyclerView pdfBookmarkListRecycler) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.pdfBookmarkListRecycler = pdfBookmarkListRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPdfBookMarkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentPdfBookMarkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_pdf_book_mark, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentPdfBookMarkBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (imageView != null) {
                i = R.id.no_data;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                if (textView != null) {
                    i = R.id.no_data_found_RL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                    if (relativeLayout != null) {
                        i = R.id.pdf_bookmarkList_recycler;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.pdf_bookmarkList_recycler);
                        if (recyclerView != null) {
                            return new FragmentPdfBookMarkBinding((FrameLayout) rootView, button, imageView, textView, relativeLayout, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
