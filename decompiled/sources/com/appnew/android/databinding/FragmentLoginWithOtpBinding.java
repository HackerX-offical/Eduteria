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
import com.eduteria.app.app.R;
import com.hbb20.CountryCodePicker;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentLoginWithOtpBinding implements ViewBinding {
    public final Button attendanceIn;
    public final Button attendanceOut;
    public final RelativeLayout attendanceRl;
    public final TextView contactNumber;
    public final LinearLayout contactUsLinear;
    public final CountryCodePicker countryDropDown;
    public final EditText etEmail;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final LinearLayout googleLL;
    public final ImageView imagestate;
    public final Button loginBtn;
    public final Button loginBtn2;
    public final LinearLayout loginOptionLL;
    public final View loginView1;
    public final EditText mobileNo;
    public final RelativeLayout mobileRL;
    public final LinearLayout mobileVerifyLL;
    private final RelativeLayout rootView;
    public final LinearLayout termAndConditionRel;
    public final TextView tvCode;
    public final TextView tvOr;
    public final TextView tvTermAndCondition;
    public final EditText verifyEmail;
    public final EditText verifyIdET;
    public final LinearLayout verifyIdLL;
    public final EditText verifyMobile;
    public final EditText verifyName;
    public final Button verifyNumberBtn;
    public final LinearLayout verifyUserDetails;
    public final TextView welcomeTV;

    private FragmentLoginWithOtpBinding(RelativeLayout rootView, Button attendanceIn, Button attendanceOut, RelativeLayout attendanceRl, TextView contactNumber, LinearLayout contactUsLinear, CountryCodePicker countryDropDown, EditText etEmail, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, LinearLayout googleLL, ImageView imagestate, Button loginBtn, Button loginBtn2, LinearLayout loginOptionLL, View loginView1, EditText mobileNo, RelativeLayout mobileRL, LinearLayout mobileVerifyLL, LinearLayout termAndConditionRel, TextView tvCode, TextView tvOr, TextView tvTermAndCondition, EditText verifyEmail, EditText verifyIdET, LinearLayout verifyIdLL, EditText verifyMobile, EditText verifyName, Button verifyNumberBtn, LinearLayout verifyUserDetails, TextView welcomeTV) {
        this.rootView = rootView;
        this.attendanceIn = attendanceIn;
        this.attendanceOut = attendanceOut;
        this.attendanceRl = attendanceRl;
        this.contactNumber = contactNumber;
        this.contactUsLinear = contactUsLinear;
        this.countryDropDown = countryDropDown;
        this.etEmail = etEmail;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.googleLL = googleLL;
        this.imagestate = imagestate;
        this.loginBtn = loginBtn;
        this.loginBtn2 = loginBtn2;
        this.loginOptionLL = loginOptionLL;
        this.loginView1 = loginView1;
        this.mobileNo = mobileNo;
        this.mobileRL = mobileRL;
        this.mobileVerifyLL = mobileVerifyLL;
        this.termAndConditionRel = termAndConditionRel;
        this.tvCode = tvCode;
        this.tvOr = tvOr;
        this.tvTermAndCondition = tvTermAndCondition;
        this.verifyEmail = verifyEmail;
        this.verifyIdET = verifyIdET;
        this.verifyIdLL = verifyIdLL;
        this.verifyMobile = verifyMobile;
        this.verifyName = verifyName;
        this.verifyNumberBtn = verifyNumberBtn;
        this.verifyUserDetails = verifyUserDetails;
        this.welcomeTV = welcomeTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLoginWithOtpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLoginWithOtpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_login_with_otp, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLoginWithOtpBinding bind(View rootView) {
        int i = R.id.attendanceIn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.attendanceIn);
        if (button != null) {
            i = R.id.attendanceOut;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.attendanceOut);
            if (button2 != null) {
                i = R.id.attendance_rl;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.attendance_rl);
                if (relativeLayout != null) {
                    i = R.id.contactNumber;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.contactNumber);
                    if (textView != null) {
                        i = R.id.contactUsLinear;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.contactUsLinear);
                        if (linearLayout != null) {
                            i = R.id.countryDropDown;
                            CountryCodePicker countryCodePicker = (CountryCodePicker) ViewBindings.findChildViewById(rootView, R.id.countryDropDown);
                            if (countryCodePicker != null) {
                                i = R.id.et_email;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_email);
                                if (editText != null) {
                                    i = R.id.flagCountryLL;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                                    if (relativeLayout2 != null) {
                                        i = R.id.flagMainLL;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                                        if (relativeLayout3 != null) {
                                            i = R.id.flagRL;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                                            if (relativeLayout4 != null) {
                                                i = R.id.googleLL;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.googleLL);
                                                if (linearLayout2 != null) {
                                                    i = R.id.imagestate;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                    if (imageView != null) {
                                                        i = R.id.loginBtn;
                                                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                                                        if (button3 != null) {
                                                            i = R.id.loginBtn2;
                                                            Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn2);
                                                            if (button4 != null) {
                                                                i = R.id.loginOptionLL;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.loginOptionLL);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.loginView1;
                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.loginView1);
                                                                    if (viewFindChildViewById != null) {
                                                                        i = R.id.mobileNo;
                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileNo);
                                                                        if (editText2 != null) {
                                                                            i = R.id.mobileRL;
                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRL);
                                                                            if (relativeLayout5 != null) {
                                                                                i = R.id.mobileVerifyLL;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mobileVerifyLL);
                                                                                if (linearLayout4 != null) {
                                                                                    i = R.id.termAndConditionRel;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.termAndConditionRel);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = R.id.tv_code;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tvOr;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvOr);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tv_term_and_condition;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_term_and_condition);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.verifyEmail;
                                                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyEmail);
                                                                                                    if (editText3 != null) {
                                                                                                        i = R.id.verifyId_ET;
                                                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyId_ET);
                                                                                                        if (editText4 != null) {
                                                                                                            i = R.id.verifyId_LL;
                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifyId_LL);
                                                                                                            if (linearLayout6 != null) {
                                                                                                                i = R.id.verifyMobile;
                                                                                                                EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyMobile);
                                                                                                                if (editText5 != null) {
                                                                                                                    i = R.id.verifyName;
                                                                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyName);
                                                                                                                    if (editText6 != null) {
                                                                                                                        i = R.id.verifyNumberBtn;
                                                                                                                        Button button5 = (Button) ViewBindings.findChildViewById(rootView, R.id.verifyNumberBtn);
                                                                                                                        if (button5 != null) {
                                                                                                                            i = R.id.verifyUserDetails;
                                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifyUserDetails);
                                                                                                                            if (linearLayout7 != null) {
                                                                                                                                i = R.id.welcomeTV;
                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.welcomeTV);
                                                                                                                                if (textView5 != null) {
                                                                                                                                    return new FragmentLoginWithOtpBinding((RelativeLayout) rootView, button, button2, relativeLayout, textView, linearLayout, countryCodePicker, editText, relativeLayout2, relativeLayout3, relativeLayout4, linearLayout2, imageView, button3, button4, linearLayout3, viewFindChildViewById, editText2, relativeLayout5, linearLayout4, linearLayout5, textView2, textView3, textView4, editText3, editText4, linearLayout6, editText5, editText6, button5, linearLayout7, textView5);
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
