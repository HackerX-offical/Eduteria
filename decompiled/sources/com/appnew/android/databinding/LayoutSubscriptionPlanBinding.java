package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutSubscriptionPlanBinding implements ViewBinding {
    public final ImageView btnDownloadInvoice;
    public final RelativeLayout cvrShowHide;
    private final RelativeLayout rootView;
    public final TextView txtMrp;
    public final TextView txtStatus;
    public final TextView txtTransactionDate;

    private LayoutSubscriptionPlanBinding(RelativeLayout rootView, ImageView btnDownloadInvoice, RelativeLayout cvrShowHide, TextView txtMrp, TextView txtStatus, TextView txtTransactionDate) {
        this.rootView = rootView;
        this.btnDownloadInvoice = btnDownloadInvoice;
        this.cvrShowHide = cvrShowHide;
        this.txtMrp = txtMrp;
        this.txtStatus = txtStatus;
        this.txtTransactionDate = txtTransactionDate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSubscriptionPlanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutSubscriptionPlanBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_subscription_plan, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutSubscriptionPlanBinding bind(View rootView) {
        int i = R.id.btnDownloadInvoice;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.btnDownloadInvoice);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.txtMrp;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtMrp);
            if (textView != null) {
                i = R.id.txtStatus;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtStatus);
                if (textView2 != null) {
                    i = R.id.txtTransactionDate;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTransactionDate);
                    if (textView3 != null) {
                        return new LayoutSubscriptionPlanBinding(relativeLayout, imageView, relativeLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
