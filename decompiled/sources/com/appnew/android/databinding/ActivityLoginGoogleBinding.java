package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityLoginGoogleBinding implements ViewBinding {
    public final Button btnSubmit;
    public final CountryCodePicker countryDropDown;
    public final EditText etEmail;
    public final EditText etMobileNumber;
    public final EditText etName;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final ImageView imagestate;
    public final CircleImageView ivImage;
    public final View loginView1;
    private final NestedScrollView rootView;
    public final TextView tvCode;
    public final TextView tvTermAndCondition;

    private ActivityLoginGoogleBinding(NestedScrollView rootView, Button btnSubmit, CountryCodePicker countryDropDown, EditText etEmail, EditText etMobileNumber, EditText etName, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, ImageView imagestate, CircleImageView ivImage, View loginView1, TextView tvCode, TextView tvTermAndCondition) {
        this.rootView = rootView;
        this.btnSubmit = btnSubmit;
        this.countryDropDown = countryDropDown;
        this.etEmail = etEmail;
        this.etMobileNumber = etMobileNumber;
        this.etName = etName;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.imagestate = imagestate;
        this.ivImage = ivImage;
        this.loginView1 = loginView1;
        this.tvCode = tvCode;
        this.tvTermAndCondition = tvTermAndCondition;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static ActivityLoginGoogleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLoginGoogleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_login_google, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLoginGoogleBinding bind(View rootView) {
        int i = R.id.btn_submit;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
        if (button != null) {
            i = R.id.countryDropDown;
            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
            if (countryCodePicker != null) {
                i = R.id.et_email;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_email);
                if (editText != null) {
                    i = R.id.et_mobile_number;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_mobile_number);
                    if (editText2 != null) {
                        i = R.id.et_name;
                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_name);
                        if (editText3 != null) {
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
                                            i = R.id.iv_image;
                                            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.iv_image);
                                            if (circleImageView != null) {
                                                i = R.id.loginView1;
                                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                if (viewFindChildViewById != null) {
                                                    i = R.id.tv_code;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                    if (textView != null) {
                                                        i = R.id.tv_term_and_condition;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_term_and_condition);
                                                        if (textView2 != null) {
                                                            return new ActivityLoginGoogleBinding((NestedScrollView) rootView, button, countryCodePicker, editText, editText2, editText3, relativeLayout, relativeLayout2, relativeLayout3, imageView, circleImageView, viewFindChildViewById, textView, textView2);
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
