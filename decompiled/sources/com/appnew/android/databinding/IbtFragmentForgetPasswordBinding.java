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
public final class IbtFragmentForgetPasswordBinding implements ViewBinding {
    public final CountryCodePicker countryDropDown;
    public final LinearLayout emailLL;
    public final EditText emailTV;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final TextView forgetpasswordTV;
    public final ImageView image;
    public final ImageView imagestate;
    public final ImageView ivBack;
    public final LinearLayout ll1;
    public final Button loginBtn;
    public final TextView loginUsingTV;
    public final View loginView1;
    public final RelativeLayout mobileRl;
    public final EditText mobileTV;
    private final NestedScrollView rootView;
    public final TextView title;
    public final TextView tvCode;

    private IbtFragmentForgetPasswordBinding(NestedScrollView rootView, CountryCodePicker countryDropDown, LinearLayout emailLL, EditText emailTV, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, TextView forgetpasswordTV, ImageView image, ImageView imagestate, ImageView ivBack, LinearLayout ll1, Button loginBtn, TextView loginUsingTV, View loginView1, RelativeLayout mobileRl, EditText mobileTV, TextView title, TextView tvCode) {
        this.rootView = rootView;
        this.countryDropDown = countryDropDown;
        this.emailLL = emailLL;
        this.emailTV = emailTV;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.forgetpasswordTV = forgetpasswordTV;
        this.image = image;
        this.imagestate = imagestate;
        this.ivBack = ivBack;
        this.ll1 = ll1;
        this.loginBtn = loginBtn;
        this.loginUsingTV = loginUsingTV;
        this.loginView1 = loginView1;
        this.mobileRl = mobileRl;
        this.mobileTV = mobileTV;
        this.title = title;
        this.tvCode = tvCode;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static IbtFragmentForgetPasswordBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentForgetPasswordBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_forget_password, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentForgetPasswordBinding bind(View rootView) {
        int i = R.id.countryDropDown;
        CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
        if (countryCodePicker != null) {
            i = R.id.emailLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emailLL);
            if (linearLayout != null) {
                i = R.id.emailTV;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
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
                                i = R.id.forgetpasswordTV;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.forgetpasswordTV);
                                if (textView != null) {
                                    i = R.id.image;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                    if (imageView != null) {
                                        i = R.id.imagestate;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                        if (imageView2 != null) {
                                            i = R.id.iv_back;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                            if (imageView3 != null) {
                                                i = R.id.ll1;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll1);
                                                if (linearLayout2 != null) {
                                                    i = R.id.loginBtn;
                                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                                                    if (button != null) {
                                                        i = R.id.loginUsingTV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loginUsingTV);
                                                        if (textView2 != null) {
                                                            i = R.id.loginView1;
                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                            if (viewFindChildViewById != null) {
                                                                i = R.id.mobileRl;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRl);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.mobileTV;
                                                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileTV);
                                                                    if (editText2 != null) {
                                                                        i = R.id.title;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_code;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                            if (textView4 != null) {
                                                                                return new IbtFragmentForgetPasswordBinding((NestedScrollView) rootView, countryCodePicker, linearLayout, editText, relativeLayout, relativeLayout2, relativeLayout3, textView, imageView, imageView2, imageView3, linearLayout2, button, textView2, viewFindChildViewById, relativeLayout4, editText2, textView3, textView4);
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
