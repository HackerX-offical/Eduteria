package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.LabeledEditText;
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtFragmentForgetPasswordNewBinding implements ViewBinding {
    public final ImageView arrowFlag;
    public final CountryCodePicker countryDropDown;
    public final TextView desc;
    public final LinearLayout emailLL;
    public final LabeledEditText emailTV;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final TextView forgetpasswordTV;
    public final ImageView imagestate;
    public final Button loginBtn;
    public final ImageView loginLogo;
    public final TextView loginUsingTV;
    public final RelativeLayout mobileRl;
    public final EditText mobileTV;
    private final LinearLayout rootView;
    public final TextView title;
    public final TextView tvCode;

    private IbtFragmentForgetPasswordNewBinding(LinearLayout rootView, ImageView arrowFlag, CountryCodePicker countryDropDown, TextView desc, LinearLayout emailLL, LabeledEditText emailTV, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, TextView forgetpasswordTV, ImageView imagestate, Button loginBtn, ImageView loginLogo, TextView loginUsingTV, RelativeLayout mobileRl, EditText mobileTV, TextView title, TextView tvCode) {
        this.rootView = rootView;
        this.arrowFlag = arrowFlag;
        this.countryDropDown = countryDropDown;
        this.desc = desc;
        this.emailLL = emailLL;
        this.emailTV = emailTV;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.forgetpasswordTV = forgetpasswordTV;
        this.imagestate = imagestate;
        this.loginBtn = loginBtn;
        this.loginLogo = loginLogo;
        this.loginUsingTV = loginUsingTV;
        this.mobileRl = mobileRl;
        this.mobileTV = mobileTV;
        this.title = title;
        this.tvCode = tvCode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtFragmentForgetPasswordNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentForgetPasswordNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_forget_password_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentForgetPasswordNewBinding bind(View rootView) {
        int i = R.id.arrowFlag;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowFlag);
        if (imageView != null) {
            i = R.id.countryDropDown;
            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
            if (countryCodePicker != null) {
                i = R.id.desc;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
                if (textView != null) {
                    i = R.id.emailLL;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emailLL);
                    if (linearLayout != null) {
                        i = R.id.emailTV;
                        LabeledEditText labeledEditText = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                        if (labeledEditText != null) {
                            i = R.id.flagCountryLL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                            if (relativeLayout != null) {
                                i = R.id.flagMainLL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                                if (relativeLayout2 != null) {
                                    i = R.id.flagRL;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                                    if (relativeLayout3 != null) {
                                        i = R.id.forgetpasswordTV;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forgetpasswordTV);
                                        if (textView2 != null) {
                                            i = R.id.imagestate;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                            if (imageView2 != null) {
                                                i = R.id.loginBtn;
                                                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                                                if (button != null) {
                                                    i = R.id.loginLogo;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.loginLogo);
                                                    if (imageView3 != null) {
                                                        i = R.id.loginUsingTV;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loginUsingTV);
                                                        if (textView3 != null) {
                                                            i = R.id.mobileRl;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRl);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.mobileTV;
                                                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileTV);
                                                                if (editText != null) {
                                                                    i = R.id.title;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tv_code;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                        if (textView5 != null) {
                                                                            return new IbtFragmentForgetPasswordNewBinding((LinearLayout) rootView, imageView, countryCodePicker, textView, linearLayout, labeledEditText, relativeLayout, relativeLayout2, relativeLayout3, textView2, imageView2, button, imageView3, textView3, relativeLayout4, editText, textView4, textView5);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
