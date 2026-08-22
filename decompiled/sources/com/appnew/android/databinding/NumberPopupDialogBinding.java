package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NumberPopupDialogBinding implements ViewBinding {
    public final TextView appName;
    public final LinearLayout linearLayoutPopupNumber;
    public final LinearLayout numberPopupLinerLayout1;
    public final LinearLayout numberPopupLinerLayout2;
    public final RelativeLayout numberPopupRL;
    public final TextView phoneNumber;
    public final TextView phoneNumber2;
    private final RelativeLayout rootView;

    private NumberPopupDialogBinding(RelativeLayout rootView, TextView appName, LinearLayout linearLayoutPopupNumber, LinearLayout numberPopupLinerLayout1, LinearLayout numberPopupLinerLayout2, RelativeLayout numberPopupRL, TextView phoneNumber, TextView phoneNumber2) {
        this.rootView = rootView;
        this.appName = appName;
        this.linearLayoutPopupNumber = linearLayoutPopupNumber;
        this.numberPopupLinerLayout1 = numberPopupLinerLayout1;
        this.numberPopupLinerLayout2 = numberPopupLinerLayout2;
        this.numberPopupRL = numberPopupRL;
        this.phoneNumber = phoneNumber;
        this.phoneNumber2 = phoneNumber2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NumberPopupDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static NumberPopupDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.number_popup_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NumberPopupDialogBinding bind(View rootView) {
        int i = R.id.appName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.appName);
        if (textView != null) {
            i = R.id.linearLayout_popupNumber;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linearLayout_popupNumber);
            if (linearLayout != null) {
                i = R.id.numberPopup_LinerLayout1;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.numberPopup_LinerLayout1);
                if (linearLayout2 != null) {
                    i = R.id.numberPopup_LinerLayout2;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.numberPopup_LinerLayout2);
                    if (linearLayout3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) rootView;
                        i = R.id.phone_number;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.phone_number);
                        if (textView2 != null) {
                            i = R.id.phone_number2;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.phone_number2);
                            if (textView3 != null) {
                                return new NumberPopupDialogBinding(relativeLayout, textView, linearLayout, linearLayout2, linearLayout3, relativeLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
