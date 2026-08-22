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
import com.appnew.android.Utils.LabeledEditText;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentLoginWithOtpNewBinding implements ViewBinding {
    public final ImageView arrowFlag;
    public final Button attendanceIn;
    public final Button attendanceOut;
    public final RelativeLayout attendanceRl;
    public final TextView contactNumber;
    public final LinearLayout contactUsLinear;
    public final CountryCodePicker countryDropDown;
    public final LinearLayout emailLL;
    public final LabeledEditText emailTV;
    public final EditText etEmail;
    public final LabeledEditText etName;
    public final LabeledEditText etPassword;
    public final LabeledEditText etRollNumber;
    public final RelativeLayout flagCountryLL;
    public final RelativeLayout flagMainLL;
    public final RelativeLayout flagRL;
    public final TextView forgetpasswordTV;
    public final LinearLayout googleLL;
    public final ImageView imagestate;
    public final Button loginBtn;
    public final Button loginBtn2;
    public final LinearLayout loginOptionLL;
    public final ImageView loginUsingIV;
    public final TextView loginUsingTV;
    public final RelativeLayout mobileRL;
    public final LinearLayout mobileVerifyLL;
    public final TextInputLayout passwordTIL;
    private final NestedScrollView rootView;
    public final LinearLayout termAndConditionRel;
    public final TextView topText;
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
    public final View viewExtra;

    private FragmentLoginWithOtpNewBinding(NestedScrollView rootView, ImageView arrowFlag, Button attendanceIn, Button attendanceOut, RelativeLayout attendanceRl, TextView contactNumber, LinearLayout contactUsLinear, CountryCodePicker countryDropDown, LinearLayout emailLL, LabeledEditText emailTV, EditText etEmail, LabeledEditText etName, LabeledEditText etPassword, LabeledEditText etRollNumber, RelativeLayout flagCountryLL, RelativeLayout flagMainLL, RelativeLayout flagRL, TextView forgetpasswordTV, LinearLayout googleLL, ImageView imagestate, Button loginBtn, Button loginBtn2, LinearLayout loginOptionLL, ImageView loginUsingIV, TextView loginUsingTV, RelativeLayout mobileRL, LinearLayout mobileVerifyLL, TextInputLayout passwordTIL, LinearLayout termAndConditionRel, TextView topText, TextView tvCode, TextView tvOr, TextView tvTermAndCondition, EditText verifyEmail, EditText verifyIdET, LinearLayout verifyIdLL, EditText verifyMobile, EditText verifyName, Button verifyNumberBtn, LinearLayout verifyUserDetails, View viewExtra) {
        this.rootView = rootView;
        this.arrowFlag = arrowFlag;
        this.attendanceIn = attendanceIn;
        this.attendanceOut = attendanceOut;
        this.attendanceRl = attendanceRl;
        this.contactNumber = contactNumber;
        this.contactUsLinear = contactUsLinear;
        this.countryDropDown = countryDropDown;
        this.emailLL = emailLL;
        this.emailTV = emailTV;
        this.etEmail = etEmail;
        this.etName = etName;
        this.etPassword = etPassword;
        this.etRollNumber = etRollNumber;
        this.flagCountryLL = flagCountryLL;
        this.flagMainLL = flagMainLL;
        this.flagRL = flagRL;
        this.forgetpasswordTV = forgetpasswordTV;
        this.googleLL = googleLL;
        this.imagestate = imagestate;
        this.loginBtn = loginBtn;
        this.loginBtn2 = loginBtn2;
        this.loginOptionLL = loginOptionLL;
        this.loginUsingIV = loginUsingIV;
        this.loginUsingTV = loginUsingTV;
        this.mobileRL = mobileRL;
        this.mobileVerifyLL = mobileVerifyLL;
        this.passwordTIL = passwordTIL;
        this.termAndConditionRel = termAndConditionRel;
        this.topText = topText;
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
        this.viewExtra = viewExtra;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentLoginWithOtpNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLoginWithOtpNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_login_with_otp_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLoginWithOtpNewBinding bind(View rootView) {
        int i = R.id.arrowFlag;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowFlag);
        if (imageView != null) {
            i = R.id.attendanceIn;
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
                                    i = R.id.emailLL;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emailLL);
                                    if (linearLayout2 != null) {
                                        i = R.id.emailTV;
                                        LabeledEditText labeledEditText = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                                        if (labeledEditText != null) {
                                            i = R.id.et_email;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_email);
                                            if (editText != null) {
                                                i = R.id.etName;
                                                LabeledEditText labeledEditText2 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.etName);
                                                if (labeledEditText2 != null) {
                                                    i = R.id.et_password;
                                                    LabeledEditText labeledEditText3 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.et_password);
                                                    if (labeledEditText3 != null) {
                                                        i = R.id.etRollNumber;
                                                        LabeledEditText labeledEditText4 = (LabeledEditText) ViewBindings.findChildViewById(rootView, R.id.etRollNumber);
                                                        if (labeledEditText4 != null) {
                                                            i = R.id.flagCountryLL;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagCountryLL);
                                                            if (relativeLayout2 != null) {
                                                                i = R.id.flagMainLL;
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagMainLL);
                                                                if (relativeLayout3 != null) {
                                                                    i = R.id.flagRL;
                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flagRL);
                                                                    if (relativeLayout4 != null) {
                                                                        i = R.id.forgetpasswordTV;
                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.forgetpasswordTV);
                                                                        if (textView2 != null) {
                                                                            i = R.id.googleLL;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.googleLL);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.imagestate;
                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                                                if (imageView2 != null) {
                                                                                    i = R.id.loginBtn;
                                                                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn);
                                                                                    if (button3 != null) {
                                                                                        i = R.id.loginBtn2;
                                                                                        Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.loginBtn2);
                                                                                        if (button4 != null) {
                                                                                            i = R.id.loginOptionLL;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.loginOptionLL);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.loginUsingIV;
                                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.loginUsingIV);
                                                                                                if (imageView3 != null) {
                                                                                                    i = R.id.loginUsingTV;
                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loginUsingTV);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.mobileRL;
                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mobileRL);
                                                                                                        if (relativeLayout5 != null) {
                                                                                                            i = R.id.mobileVerifyLL;
                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mobileVerifyLL);
                                                                                                            if (linearLayout5 != null) {
                                                                                                                i = R.id.passwordTIL;
                                                                                                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.passwordTIL);
                                                                                                                if (textInputLayout != null) {
                                                                                                                    i = R.id.termAndConditionRel;
                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.termAndConditionRel);
                                                                                                                    if (linearLayout6 != null) {
                                                                                                                        i = R.id.topText;
                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topText);
                                                                                                                        if (textView4 != null) {
                                                                                                                            i = R.id.tv_code;
                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                                                                            if (textView5 != null) {
                                                                                                                                i = R.id.tvOr;
                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvOr);
                                                                                                                                if (textView6 != null) {
                                                                                                                                    i = R.id.tv_term_and_condition;
                                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_term_and_condition);
                                                                                                                                    if (textView7 != null) {
                                                                                                                                        i = R.id.verifyEmail;
                                                                                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyEmail);
                                                                                                                                        if (editText2 != null) {
                                                                                                                                            i = R.id.verifyId_ET;
                                                                                                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyId_ET);
                                                                                                                                            if (editText3 != null) {
                                                                                                                                                i = R.id.verifyId_LL;
                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifyId_LL);
                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                    i = R.id.verifyMobile;
                                                                                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyMobile);
                                                                                                                                                    if (editText4 != null) {
                                                                                                                                                        i = R.id.verifyName;
                                                                                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.verifyName);
                                                                                                                                                        if (editText5 != null) {
                                                                                                                                                            i = R.id.verifyNumberBtn;
                                                                                                                                                            Button button5 = (Button) ViewBindings.findChildViewById(rootView, R.id.verifyNumberBtn);
                                                                                                                                                            if (button5 != null) {
                                                                                                                                                                i = R.id.verifyUserDetails;
                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.verifyUserDetails);
                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                    i = R.id.viewExtra;
                                                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewExtra);
                                                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                                                        return new FragmentLoginWithOtpNewBinding((NestedScrollView) rootView, imageView, button, button2, relativeLayout, textView, linearLayout, countryCodePicker, linearLayout2, labeledEditText, editText, labeledEditText2, labeledEditText3, labeledEditText4, relativeLayout2, relativeLayout3, relativeLayout4, textView2, linearLayout3, imageView2, button3, button4, linearLayout4, imageView3, textView3, relativeLayout5, linearLayout5, textInputLayout, linearLayout6, textView4, textView5, textView6, textView7, editText2, editText3, linearLayout7, editText4, editText5, button5, linearLayout8, viewFindChildViewById);
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
