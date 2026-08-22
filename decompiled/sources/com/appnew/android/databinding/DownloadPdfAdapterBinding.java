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
public final class DownloadPdfAdapterBinding implements ViewBinding {
    public final RelativeLayout cancelProgressLayout;
    public final ImageView courseImage;
    public final ImageView downloadIcon;
    public final TextView percentageTxt;
    private final RelativeLayout rootView;
    public final LinearLayout studySingleItemLL;
    public final TextView videoName;

    private DownloadPdfAdapterBinding(RelativeLayout rootView, RelativeLayout cancelProgressLayout, ImageView courseImage, ImageView downloadIcon, TextView percentageTxt, LinearLayout studySingleItemLL, TextView videoName) {
        this.rootView = rootView;
        this.cancelProgressLayout = cancelProgressLayout;
        this.courseImage = courseImage;
        this.downloadIcon = downloadIcon;
        this.percentageTxt = percentageTxt;
        this.studySingleItemLL = studySingleItemLL;
        this.videoName = videoName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DownloadPdfAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DownloadPdfAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.download_pdf_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DownloadPdfAdapterBinding bind(View rootView) {
        int i = R.id.cancel_progress_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cancel_progress_layout);
        if (relativeLayout != null) {
            i = R.id.courseImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
            if (imageView != null) {
                i = R.id.download_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.download_icon);
                if (imageView2 != null) {
                    i = R.id.percentageTxt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.percentageTxt);
                    if (textView != null) {
                        i = R.id.study_single_itemLL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                        if (linearLayout != null) {
                            i = R.id.video_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.video_name);
                            if (textView2 != null) {
                                return new DownloadPdfAdapterBinding((RelativeLayout) rootView, relativeLayout, imageView, imageView2, textView, linearLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
