package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CouponDialogBinding implements ViewBinding {
    public final TextView addCoupounTxt;
    public final Button btnCancel;
    public final Button btnSubmit;
    public final RelativeLayout calcpagerl;
    private final RelativeLayout rootView;
    public final TextView txt;
    public final EditText writeCouponET;

    private CouponDialogBinding(RelativeLayout rootView, TextView addCoupounTxt, Button btnCancel, Button btnSubmit, RelativeLayout calcpagerl, TextView txt, EditText writeCouponET) {
        this.rootView = rootView;
        this.addCoupounTxt = addCoupounTxt;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.calcpagerl = calcpagerl;
        this.txt = txt;
        this.writeCouponET = writeCouponET;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CouponDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CouponDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.coupon_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CouponDialogBinding bind(View rootView) {
        int i = R.id.add_coupoun_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_coupoun_txt);
        if (textView != null) {
            i = R.id.btn__cancel;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn__cancel);
            if (button != null) {
                i = R.id.btn_submit;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
                if (button2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.txt;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt);
                    if (textView2 != null) {
                        i = R.id.writeCouponET;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.writeCouponET);
                        if (editText != null) {
                            return new CouponDialogBinding(relativeLayout, textView, button, button2, relativeLayout, textView2, editText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
