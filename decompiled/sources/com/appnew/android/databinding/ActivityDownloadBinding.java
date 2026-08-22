package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDownloadBinding implements ViewBinding {
    public final TextView delete;
    public final LinearLayout downloadAudio;
    public final TextView downloadAudioButton;
    public final LinearLayout downloadPDF;
    public final TextView downloadPdfButton;
    public final RecyclerView downloadRecycler;
    public final LinearLayout downloadVideo;
    public final TextView downloadVideoButton;
    public final ImageView imageBack;
    public final LinearLayout layout;
    public final LinearLayout linearTab;
    public final Toolbar mainToolbar;
    private final LinearLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private ActivityDownloadBinding(LinearLayout rootView, TextView delete, LinearLayout downloadAudio, TextView downloadAudioButton, LinearLayout downloadPDF, TextView downloadPdfButton, RecyclerView downloadRecycler, LinearLayout downloadVideo, TextView downloadVideoButton, ImageView imageBack, LinearLayout layout, LinearLayout linearTab, Toolbar mainToolbar, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.delete = delete;
        this.downloadAudio = downloadAudio;
        this.downloadAudioButton = downloadAudioButton;
        this.downloadPDF = downloadPDF;
        this.downloadPdfButton = downloadPdfButton;
        this.downloadRecycler = downloadRecycler;
        this.downloadVideo = downloadVideo;
        this.downloadVideoButton = downloadVideoButton;
        this.imageBack = imageBack;
        this.layout = layout;
        this.linearTab = linearTab;
        this.mainToolbar = mainToolbar;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDownloadBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDownloadBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_download, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDownloadBinding bind(View rootView) {
        int i = R.id.delete;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
        if (textView != null) {
            i = R.id.downloadAudio;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.downloadAudio);
            if (linearLayout != null) {
                i = R.id.downloadAudioButton;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.downloadAudioButton);
                if (textView2 != null) {
                    i = R.id.downloadPDF;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.downloadPDF);
                    if (linearLayout2 != null) {
                        i = R.id.downloadPdfButton;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.downloadPdfButton);
                        if (textView3 != null) {
                            i = R.id.download_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.download_recycler);
                            if (recyclerView != null) {
                                i = R.id.downloadVideo;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.downloadVideo);
                                if (linearLayout3 != null) {
                                    i = R.id.downloadVideoButton;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.downloadVideoButton);
                                    if (textView4 != null) {
                                        i = R.id.image_back;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                        if (imageView != null) {
                                            LinearLayout linearLayout4 = (LinearLayout) rootView;
                                            i = R.id.linear_tab;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_tab);
                                            if (linearLayout5 != null) {
                                                i = R.id.main_toolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                if (toolbar != null) {
                                                    i = R.id.select_all_delete;
                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                    if (checkBox != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView5 != null) {
                                                            return new ActivityDownloadBinding(linearLayout4, textView, linearLayout, textView2, linearLayout2, textView3, recyclerView, linearLayout3, textView4, imageView, linearLayout4, linearLayout5, toolbar, checkBox, textView5);
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
