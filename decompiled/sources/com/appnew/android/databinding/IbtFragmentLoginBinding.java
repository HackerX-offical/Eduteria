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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtFragmentLoginBinding implements ViewBinding {
    public final TextView contactEmail;
    public final TextView contactNumber;
    public final LinearLayout contactUsLinear;
    public final CountryCodePicker countryDropDown;
    public final LinearLayout emailLL;
    public final EditText emailTV;
    public final EditText etEmail;
    public final EditText etPassword;
    public final EditText etRollNumber;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final TextView forgetpasswordTV;
    public final ImageView imagestate;
    public final ImageView ivFacebook;
    public final ImageView ivGoogle;
    public final Button loginBtn;
    public final TextView loginUsingTV;
    public final View loginView1;
    public final RelativeLayout mobileRL;
    public final RelativeLayout rlGoogleSignin;
    private final NestedScrollView rootView;
    public final TextView tvCode;
    public final TextView tvOr;
    public final LinearLayout whatsappRedirectLL;

    private IbtFragmentLoginBinding(NestedScrollView rootView, TextView contactEmail, TextView contactNumber, LinearLayout contactUsLinear, CountryCodePicker countryDropDown, LinearLayout emailLL, EditText emailTV, EditText etEmail, EditText etPassword, EditText etRollNumber, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, TextView forgetpasswordTV, ImageView imagestate, ImageView ivFacebook, ImageView ivGoogle, Button loginBtn, TextView loginUsingTV, View loginView1, RelativeLayout mobileRL, RelativeLayout rlGoogleSignin, TextView tvCode, TextView tvOr, LinearLayout whatsappRedirectLL) {
        this.rootView = rootView;
        this.contactEmail = contactEmail;
        this.contactNumber = contactNumber;
        this.contactUsLinear = contactUsLinear;
        this.countryDropDown = countryDropDown;
        this.emailLL = emailLL;
        this.emailTV = emailTV;
        this.etEmail = etEmail;
        this.etPassword = etPassword;
        this.etRollNumber = etRollNumber;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.forgetpasswordTV = forgetpasswordTV;
        this.imagestate = imagestate;
        this.ivFacebook = ivFacebook;
        this.ivGoogle = ivGoogle;
        this.loginBtn = loginBtn;
        this.loginUsingTV = loginUsingTV;
        this.loginView1 = loginView1;
        this.mobileRL = mobileRL;
        this.rlGoogleSignin = rlGoogleSignin;
        this.tvCode = tvCode;
        this.tvOr = tvOr;
        this.whatsappRedirectLL = whatsappRedirectLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static IbtFragmentLoginBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentLoginBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_login, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentLoginBinding bind(View rootView) {
        int i = R.id.contactEmail;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.contactEmail);
        if (textView != null) {
            i = R.id.contactNumber;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.contactNumber);
            if (textView2 != null) {
                i = R.id.contactUsLinear;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.contactUsLinear);
                if (linearLayout != null) {
                    i = R.id.countryDropDown;
                    CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
                    if (countryCodePicker != null) {
                        i = R.id.emailLL;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emailLL);
                        if (linearLayout2 != null) {
                            i = R.id.emailTV;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                            if (editText != null) {
                                i = R.id.et_email;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_email);
                                if (editText2 != null) {
                                    i = R.id.et_password;
                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_password);
                                    if (editText3 != null) {
                                        i = R.id.etRollNumber;
                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.etRollNumber);
                                        if (editText4 != null) {
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
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forgetpasswordTV);
                                                        if (textView3 != null) {
                                                            i = R.id.imagestate;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                            if (imageView != null) {
                                                                i = R.id.iv_facebook;
                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_facebook);
                                                                if (imageView2 != null) {
                                                                    i = R.id.iv_google;
                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_google);
                                                                    if (imageView3 != null) {
                                                                        i = R.id.loginBtn;
                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                                                                        if (button != null) {
                                                                            i = R.id.loginUsingTV;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loginUsingTV);
                                                                            if (textView4 != null) {
                                                                                i = R.id.loginView1;
                                                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                                                if (viewFindChildViewById != null) {
                                                                                    i = R.id.mobileRL;
                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRL);
                                                                                    if (relativeLayout4 != null) {
                                                                                        i = R.id.rl_google_signin;
                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_google_signin);
                                                                                        if (relativeLayout5 != null) {
                                                                                            i = R.id.tv_code;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.tvOr;
                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvOr);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.whatsappRedirectLL;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.whatsappRedirectLL);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        return new IbtFragmentLoginBinding((NestedScrollView) rootView, textView, textView2, linearLayout, countryCodePicker, linearLayout2, editText, editText2, editText3, editText4, relativeLayout, relativeLayout2, relativeLayout3, textView3, imageView, imageView2, imageView3, button, textView4, viewFindChildViewById, relativeLayout4, relativeLayout5, textView5, textView6, linearLayout3);
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
