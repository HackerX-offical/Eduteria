package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutInstallmentItemBinding implements ViewBinding {
    public final TextView btnDownloadInvoice;
    public final TextView btnQRPay;
    public final LinearLayoutCompat cvrDueDate;
    public final CardView cvrShowHide;
    public final LinearLayoutCompat cvrTransaction;
    public final LinearLayoutCompat discountAmountLLC;
    public final TextView discountAmountTV;
    public final ImageView imArrow;
    private final LinearLayoutCompat rootView;
    public final TextView txtDueDate;
    public final TextView txtEmiStatus;
    public final TextView txtInstallment;
    public final TextView txtMrp;
    public final TextView txtPaymentMode;
    public final TextView txtStatus;
    public final TextView txtTransactionDate;

    private LayoutInstallmentItemBinding(LinearLayoutCompat rootView, TextView btnDownloadInvoice, TextView btnQRPay, LinearLayoutCompat cvrDueDate, CardView cvrShowHide, LinearLayoutCompat cvrTransaction, LinearLayoutCompat discountAmountLLC, TextView discountAmountTV, ImageView imArrow, TextView txtDueDate, TextView txtEmiStatus, TextView txtInstallment, TextView txtMrp, TextView txtPaymentMode, TextView txtStatus, TextView txtTransactionDate) {
        this.rootView = rootView;
        this.btnDownloadInvoice = btnDownloadInvoice;
        this.btnQRPay = btnQRPay;
        this.cvrDueDate = cvrDueDate;
        this.cvrShowHide = cvrShowHide;
        this.cvrTransaction = cvrTransaction;
        this.discountAmountLLC = discountAmountLLC;
        this.discountAmountTV = discountAmountTV;
        this.imArrow = imArrow;
        this.txtDueDate = txtDueDate;
        this.txtEmiStatus = txtEmiStatus;
        this.txtInstallment = txtInstallment;
        this.txtMrp = txtMrp;
        this.txtPaymentMode = txtPaymentMode;
        this.txtStatus = txtStatus;
        this.txtTransactionDate = txtTransactionDate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static LayoutInstallmentItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutInstallmentItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_installment_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutInstallmentItemBinding bind(View rootView) {
        int i = R.id.btnDownloadInvoice;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.btnDownloadInvoice);
        if (textView != null) {
            i = R.id.btnQRPay;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.btnQRPay);
            if (textView2 != null) {
                i = R.id.cvrDueDate;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrDueDate);
                if (linearLayoutCompat != null) {
                    i = R.id.cvrShowHide;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cvrShowHide);
                    if (cardView != null) {
                        i = R.id.cvrTransaction;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrTransaction);
                        if (linearLayoutCompat2 != null) {
                            i = R.id.discountAmountLLC;
                            LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.discountAmountLLC);
                            if (linearLayoutCompat3 != null) {
                                i = R.id.discountAmountTV;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.discountAmountTV);
                                if (textView3 != null) {
                                    i = R.id.imArrow;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imArrow);
                                    if (imageView != null) {
                                        i = R.id.txtDueDate;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDueDate);
                                        if (textView4 != null) {
                                            i = R.id.txtEmiStatus;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtEmiStatus);
                                            if (textView5 != null) {
                                                i = R.id.txtInstallment;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtInstallment);
                                                if (textView6 != null) {
                                                    i = R.id.txtMrp;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtMrp);
                                                    if (textView7 != null) {
                                                        i = R.id.txtPaymentMode;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPaymentMode);
                                                        if (textView8 != null) {
                                                            i = R.id.txtStatus;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtStatus);
                                                            if (textView9 != null) {
                                                                i = R.id.txtTransactionDate;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTransactionDate);
                                                                if (textView10 != null) {
                                                                    return new LayoutInstallmentItemBinding((LinearLayoutCompat) rootView, textView, textView2, linearLayoutCompat, cardView, linearLayoutCompat2, linearLayoutCompat3, textView3, imageView, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
