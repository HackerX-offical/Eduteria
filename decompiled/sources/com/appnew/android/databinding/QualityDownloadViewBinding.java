package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class QualityDownloadViewBinding implements ViewBinding {
    public final LinearLayout bitrateLL;
    public final RecyclerView bitrateRecyclerView;
    public final Button btn240;
    public final Button btnHigh;
    public final Button btnLow;
    public final Button btnMedium;
    public final LinearLayout lnPreparing;
    private final LinearLayout rootView;
    public final TextView tvResName;

    private QualityDownloadViewBinding(LinearLayout rootView, LinearLayout bitrateLL, RecyclerView bitrateRecyclerView, Button btn240, Button btnHigh, Button btnLow, Button btnMedium, LinearLayout lnPreparing, TextView tvResName) {
        this.rootView = rootView;
        this.bitrateLL = bitrateLL;
        this.bitrateRecyclerView = bitrateRecyclerView;
        this.btn240 = btn240;
        this.btnHigh = btnHigh;
        this.btnLow = btnLow;
        this.btnMedium = btnMedium;
        this.lnPreparing = lnPreparing;
        this.tvResName = tvResName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static QualityDownloadViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QualityDownloadViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quality_download_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QualityDownloadViewBinding bind(View rootView) {
        int i = R.id.bitrateLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bitrateLL);
        if (linearLayout != null) {
            i = R.id.bitrate_recyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.bitrate_recyclerView);
            if (recyclerView != null) {
                i = R.id.btn240;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn240);
                if (button != null) {
                    i = R.id.btnHigh;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnHigh);
                    if (button2 != null) {
                        i = R.id.btnLow;
                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnLow);
                        if (button3 != null) {
                            i = R.id.btnMedium;
                            Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnMedium);
                            if (button4 != null) {
                                i = R.id.lnPreparing;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lnPreparing);
                                if (linearLayout2 != null) {
                                    i = R.id.tvResName;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvResName);
                                    if (textView != null) {
                                        return new QualityDownloadViewBinding((LinearLayout) rootView, linearLayout, recyclerView, button, button2, button3, button4, linearLayout2, textView);
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
