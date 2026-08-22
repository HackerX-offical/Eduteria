package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemInstallmentShowAdapterBinding implements ViewBinding {
    public final TextView countInstallment;
    public final TextView dueDateTxt;
    public final TextView gstTxt;
    public final TextView markPerQuesTV;
    public final TextView priceTxt;
    private final LinearLayoutCompat rootView;
    public final LinearLayout sectionTime;
    public final TextView totTimeTV;
    public final TextView ttlTxt;

    private ItemInstallmentShowAdapterBinding(LinearLayoutCompat rootView, TextView countInstallment, TextView dueDateTxt, TextView gstTxt, TextView markPerQuesTV, TextView priceTxt, LinearLayout sectionTime, TextView totTimeTV, TextView ttlTxt) {
        this.rootView = rootView;
        this.countInstallment = countInstallment;
        this.dueDateTxt = dueDateTxt;
        this.gstTxt = gstTxt;
        this.markPerQuesTV = markPerQuesTV;
        this.priceTxt = priceTxt;
        this.sectionTime = sectionTime;
        this.totTimeTV = totTimeTV;
        this.ttlTxt = ttlTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemInstallmentShowAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemInstallmentShowAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_installment_show_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemInstallmentShowAdapterBinding bind(View rootView) {
        int i = R.id.countInstallment;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.countInstallment);
        if (textView != null) {
            i = R.id.dueDateTxt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dueDateTxt);
            if (textView2 != null) {
                i = R.id.gstTxt;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.gstTxt);
                if (textView3 != null) {
                    i = R.id.markPerQuesTV;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.markPerQuesTV);
                    if (textView4 != null) {
                        i = R.id.priceTxt;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTxt);
                        if (textView5 != null) {
                            i = R.id.section_time;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.section_time);
                            if (linearLayout != null) {
                                i = R.id.totTimeTV;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totTimeTV);
                                if (textView6 != null) {
                                    i = R.id.ttlTxt;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ttlTxt);
                                    if (textView7 != null) {
                                        return new ItemInstallmentShowAdapterBinding((LinearLayoutCompat) rootView, textView, textView2, textView3, textView4, textView5, linearLayout, textView6, textView7);
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
