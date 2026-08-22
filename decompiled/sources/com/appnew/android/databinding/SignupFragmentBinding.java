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
public final class SignupFragmentBinding implements ViewBinding {
    public final LinearLayout bottom;
    public final CountryCodePicker countryDropDown;
    public final EditText etMobile;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final ImageView imagestate;
    public final ImageView ivGoogle;
    public final View loginView1;
    public final LinearLayout mainLLSignIn;
    public final RelativeLayout rlGoogleSignin;
    private final NestedScrollView rootView;
    public final Button signupBtn;
    public final TextView tvCode;
    public final TextView tvTermAndCondition;

    private SignupFragmentBinding(NestedScrollView rootView, LinearLayout bottom, CountryCodePicker countryDropDown, EditText etMobile, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, ImageView imagestate, ImageView ivGoogle, View loginView1, LinearLayout mainLLSignIn, RelativeLayout rlGoogleSignin, Button signupBtn, TextView tvCode, TextView tvTermAndCondition) {
        this.rootView = rootView;
        this.bottom = bottom;
        this.countryDropDown = countryDropDown;
        this.etMobile = etMobile;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.imagestate = imagestate;
        this.ivGoogle = ivGoogle;
        this.loginView1 = loginView1;
        this.mainLLSignIn = mainLLSignIn;
        this.rlGoogleSignin = rlGoogleSignin;
        this.signupBtn = signupBtn;
        this.tvCode = tvCode;
        this.tvTermAndCondition = tvTermAndCondition;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static SignupFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SignupFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.signup_fragment, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SignupFragmentBinding bind(View rootView) {
        int i = R.id.bottom;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom);
        if (linearLayout != null) {
            i = R.id.countryDropDown;
            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
            if (countryCodePicker != null) {
                i = R.id.et_mobile;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_mobile);
                if (editText != null) {
                    i = R.id.flagCountryLL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                    if (relativeLayout != null) {
                        i = R.id.flagMainLL;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                        if (relativeLayout2 != null) {
                            i = R.id.flagRL;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                            if (relativeLayout3 != null) {
                                i = R.id.imagestate;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                if (imageView != null) {
                                    i = R.id.iv_google;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_google);
                                    if (imageView2 != null) {
                                        i = R.id.loginView1;
                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                        if (viewFindChildViewById != null) {
                                            i = R.id.mainLLSignIn;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLLSignIn);
                                            if (linearLayout2 != null) {
                                                i = R.id.rl_google_signin;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_google_signin);
                                                if (relativeLayout4 != null) {
                                                    i = R.id.signupBtn;
                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.signupBtn);
                                                    if (button != null) {
                                                        i = R.id.tv_code;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                        if (textView != null) {
                                                            i = R.id.tv_term_and_condition;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_term_and_condition);
                                                            if (textView2 != null) {
                                                                return new SignupFragmentBinding((NestedScrollView) rootView, linearLayout, countryCodePicker, editText, relativeLayout, relativeLayout2, relativeLayout3, imageView, imageView2, viewFindChildViewById, linearLayout2, relativeLayout4, button, textView, textView2);
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
