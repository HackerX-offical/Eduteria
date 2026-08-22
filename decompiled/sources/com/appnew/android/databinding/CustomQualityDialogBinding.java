package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomQualityDialogBinding implements ViewBinding {
    public final LinearLayout bitrateLL;
    public final Button btn240;
    public final Button btn360;
    public final Button btn480;
    public final Button btn720;
    public final ProgressBar qualityProgressBar;
    public final RecyclerView qualityRecycler;
    public final RelativeLayout rlDialogLatestPopup;
    private final RelativeLayout rootView;

    private CustomQualityDialogBinding(RelativeLayout rootView, LinearLayout bitrateLL, Button btn240, Button btn360, Button btn480, Button btn720, ProgressBar qualityProgressBar, RecyclerView qualityRecycler, RelativeLayout rlDialogLatestPopup) {
        this.rootView = rootView;
        this.bitrateLL = bitrateLL;
        this.btn240 = btn240;
        this.btn360 = btn360;
        this.btn480 = btn480;
        this.btn720 = btn720;
        this.qualityProgressBar = qualityProgressBar;
        this.qualityRecycler = qualityRecycler;
        this.rlDialogLatestPopup = rlDialogLatestPopup;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CustomQualityDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomQualityDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_quality_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomQualityDialogBinding bind(View rootView) {
        int i = R.id.bitrateLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bitrateLL);
        if (linearLayout != null) {
            i = R.id.btn240;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn240);
            if (button != null) {
                i = R.id.btn360;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn360);
                if (button2 != null) {
                    i = R.id.btn480;
                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn480);
                    if (button3 != null) {
                        i = R.id.btn720;
                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn720);
                        if (button4 != null) {
                            i = R.id.qualityProgressBar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.qualityProgressBar);
                            if (progressBar != null) {
                                i = R.id.qualityRecycler;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.qualityRecycler);
                                if (recyclerView != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                    return new CustomQualityDialogBinding(relativeLayout, linearLayout, button, button2, button3, button4, progressBar, recyclerView, relativeLayout);
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
