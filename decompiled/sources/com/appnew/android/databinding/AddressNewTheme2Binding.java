package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AddressNewTheme2Binding implements ViewBinding {
    public final LinearLayout addedAddressLL;
    public final TextView addedAddressTV;
    public final RelativeLayout addressCV;
    public final CheckBox checkBoxAddress;
    public final ImageView defaultAddressIV;
    public final ImageView editAddressIV;
    public final TextView mobileNumber;
    public final TextView mobileNumberAlternate;
    public final TextView nameAddressTv;
    private final RelativeLayout rootView;

    private AddressNewTheme2Binding(RelativeLayout rootView, LinearLayout addedAddressLL, TextView addedAddressTV, RelativeLayout addressCV, CheckBox checkBoxAddress, ImageView defaultAddressIV, ImageView editAddressIV, TextView mobileNumber, TextView mobileNumberAlternate, TextView nameAddressTv) {
        this.rootView = rootView;
        this.addedAddressLL = addedAddressLL;
        this.addedAddressTV = addedAddressTV;
        this.addressCV = addressCV;
        this.checkBoxAddress = checkBoxAddress;
        this.defaultAddressIV = defaultAddressIV;
        this.editAddressIV = editAddressIV;
        this.mobileNumber = mobileNumber;
        this.mobileNumberAlternate = mobileNumberAlternate;
        this.nameAddressTv = nameAddressTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AddressNewTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddressNewTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.address_new_theme_2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddressNewTheme2Binding bind(View rootView) {
        int i = R.id.addedAddressLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.addedAddressLL);
        if (linearLayout != null) {
            i = R.id.addedAddressTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addedAddressTV);
            if (textView != null) {
                i = R.id.addressCV;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addressCV);
                if (relativeLayout != null) {
                    i = R.id.checkBoxAddress;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkBoxAddress);
                    if (checkBox != null) {
                        i = R.id.defaultAddressIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.defaultAddressIV);
                        if (imageView != null) {
                            i = R.id.editAddressIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.editAddressIV);
                            if (imageView2 != null) {
                                i = R.id.mobileNumber;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumber);
                                if (textView2 != null) {
                                    i = R.id.mobileNumberAlternate;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mobileNumberAlternate);
                                    if (textView3 != null) {
                                        i = R.id.nameAddressTv;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameAddressTv);
                                        if (textView4 != null) {
                                            return new AddressNewTheme2Binding((RelativeLayout) rootView, linearLayout, textView, relativeLayout, checkBox, imageView, imageView2, textView2, textView3, textView4);
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
