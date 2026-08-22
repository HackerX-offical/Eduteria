package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemEmiBinding implements ViewBinding {
    public final TextView desc;
    public final TextView nextPaymentTxt;
    private final LinearLayout rootView;
    public final LinearLayout statusLl;
    public final TextView textStatus;
    public final TextView title;

    private ItemEmiBinding(LinearLayout rootView, TextView desc, TextView nextPaymentTxt, LinearLayout statusLl, TextView textStatus, TextView title) {
        this.rootView = rootView;
        this.desc = desc;
        this.nextPaymentTxt = nextPaymentTxt;
        this.statusLl = statusLl;
        this.textStatus = textStatus;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemEmiBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemEmiBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_emi, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemEmiBinding bind(View rootView) {
        int i = R.id.desc;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
        if (textView != null) {
            i = R.id.next_payment_txt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.next_payment_txt);
            if (textView2 != null) {
                i = R.id.status_ll;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.status_ll);
                if (linearLayout != null) {
                    i = R.id.text_status;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_status);
                    if (textView3 != null) {
                        i = R.id.title;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                        if (textView4 != null) {
                            return new ItemEmiBinding((LinearLayout) rootView, textView, textView2, linearLayout, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
