package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSignInFormFourBinding implements ViewBinding {
    public final View addressProgressBar;
    public final Button buyNowBtn;
    public final View cartProgressBar;
    public final CheckBox checkboxAddress;
    public final TextView cityET;
    public final EditText eveningTime2;
    public final TextView firstProgressBarText;
    public final View fourthProgressBar;
    public final TextView fourthProgressBarText;
    public final ImageView ivBack;
    public final LinearLayout llBottom;
    public final TextView mrpCutTV;
    public final View paymentProgressBar;
    public final LinearLayout paymentStepProgress;
    public final LinearLayout paymentStepProgress1;
    public final TextView permanentCityET;
    public final EditText permanentEveningTime2;
    public final EditText permanentPinCodeET;
    public final TextView permanentStateET;
    public final EditText permanentStreetAddressET;
    public final EditText pinCodeET;
    public final Button previousBtn;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView secondProgressBarText;
    public final ImageView stateDropDownIV;
    public final TextView stateET;
    public final EditText streetAddressET;
    public final RelativeLayout svMain;
    public final TextView thirdProgressBarText;
    public final TextView title;
    public final View view;
    public final View viewEvening;

    private FragmentTestSignInFormFourBinding(RelativeLayout rootView, View addressProgressBar, Button buyNowBtn, View cartProgressBar, CheckBox checkboxAddress, TextView cityET, EditText eveningTime2, TextView firstProgressBarText, View fourthProgressBar, TextView fourthProgressBarText, ImageView ivBack, LinearLayout llBottom, TextView mrpCutTV, View paymentProgressBar, LinearLayout paymentStepProgress, LinearLayout paymentStepProgress1, TextView permanentCityET, EditText permanentEveningTime2, EditText permanentPinCodeET, TextView permanentStateET, EditText permanentStreetAddressET, EditText pinCodeET, Button previousBtn, LinearLayout priceLL, TextView priceTV, RelativeLayout rlMain, TextView secondProgressBarText, ImageView stateDropDownIV, TextView stateET, EditText streetAddressET, RelativeLayout svMain, TextView thirdProgressBarText, TextView title, View view, View viewEvening) {
        this.rootView = rootView;
        this.addressProgressBar = addressProgressBar;
        this.buyNowBtn = buyNowBtn;
        this.cartProgressBar = cartProgressBar;
        this.checkboxAddress = checkboxAddress;
        this.cityET = cityET;
        this.eveningTime2 = eveningTime2;
        this.firstProgressBarText = firstProgressBarText;
        this.fourthProgressBar = fourthProgressBar;
        this.fourthProgressBarText = fourthProgressBarText;
        this.ivBack = ivBack;
        this.llBottom = llBottom;
        this.mrpCutTV = mrpCutTV;
        this.paymentProgressBar = paymentProgressBar;
        this.paymentStepProgress = paymentStepProgress;
        this.paymentStepProgress1 = paymentStepProgress1;
        this.permanentCityET = permanentCityET;
        this.permanentEveningTime2 = permanentEveningTime2;
        this.permanentPinCodeET = permanentPinCodeET;
        this.permanentStateET = permanentStateET;
        this.permanentStreetAddressET = permanentStreetAddressET;
        this.pinCodeET = pinCodeET;
        this.previousBtn = previousBtn;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.rlMain = rlMain;
        this.secondProgressBarText = secondProgressBarText;
        this.stateDropDownIV = stateDropDownIV;
        this.stateET = stateET;
        this.streetAddressET = streetAddressET;
        this.svMain = svMain;
        this.thirdProgressBarText = thirdProgressBarText;
        this.title = title;
        this.view = view;
        this.viewEvening = viewEvening;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTestSignInFormFourBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSignInFormFourBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_sign_in_form_four, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSignInFormFourBinding bind(View rootView) {
        int i = R.id.address_progress_bar;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_progress_bar);
        if (viewFindChildViewById != null) {
            i = R.id.buyNowBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
            if (button != null) {
                i = R.id.cart_progress_bar;
                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cart_progress_bar);
                if (viewFindChildViewById2 != null) {
                    i = R.id.checkbox_address;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkbox_address);
                    if (checkBox != null) {
                        i = R.id.cityET;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cityET);
                        if (textView != null) {
                            i = R.id.eveningTime2;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.eveningTime2);
                            if (editText != null) {
                                i = R.id.first_progress_bar_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_progress_bar_text);
                                if (textView2 != null) {
                                    i = R.id.fourth_progress_bar;
                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar);
                                    if (viewFindChildViewById3 != null) {
                                        i = R.id.fourth_progress_bar_text;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar_text);
                                        if (textView3 != null) {
                                            i = R.id.iv_back;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                            if (imageView != null) {
                                                i = R.id.ll_bottom;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                if (linearLayout != null) {
                                                    i = R.id.mrpCutTV;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                    if (textView4 != null) {
                                                        i = R.id.payment_progress_bar;
                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.payment_progress_bar);
                                                        if (viewFindChildViewById4 != null) {
                                                            i = R.id.payment_step_progress;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.payment_step_progress_1;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress_1);
                                                                if (linearLayout3 != null) {
                                                                    i = R.id.permanent_cityET;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.permanent_cityET);
                                                                    if (textView5 != null) {
                                                                        i = R.id.permanent_eveningTime2;
                                                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.permanent_eveningTime2);
                                                                        if (editText2 != null) {
                                                                            i = R.id.permanent_pinCodeET;
                                                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.permanent_pinCodeET);
                                                                            if (editText3 != null) {
                                                                                i = R.id.permanent_stateET;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.permanent_stateET);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.permanent_streetAddressET;
                                                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.permanent_streetAddressET);
                                                                                    if (editText4 != null) {
                                                                                        i = R.id.pinCodeET;
                                                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pinCodeET);
                                                                                        if (editText5 != null) {
                                                                                            i = R.id.previousBtn;
                                                                                            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.previousBtn);
                                                                                            if (button2 != null) {
                                                                                                i = R.id.priceLL;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                                                                                                if (linearLayout4 != null) {
                                                                                                    i = R.id.priceTV;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.rl_main;
                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                                                                                                        if (relativeLayout != null) {
                                                                                                            i = R.id.second_progress_bar_text;
                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.second_progress_bar_text);
                                                                                                            if (textView8 != null) {
                                                                                                                i = R.id.stateDropDownIV;
                                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.stateDropDownIV);
                                                                                                                if (imageView2 != null) {
                                                                                                                    i = R.id.stateET;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateET);
                                                                                                                    if (textView9 != null) {
                                                                                                                        i = R.id.streetAddressET;
                                                                                                                        EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.streetAddressET);
                                                                                                                        if (editText6 != null) {
                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                                                                                                            i = R.id.third_progress_bar_text;
                                                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.third_progress_bar_text);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = R.id.title;
                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = R.id.view;
                                                                                                                                    View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view);
                                                                                                                                    if (viewFindChildViewById5 != null) {
                                                                                                                                        i = R.id.viewEvening;
                                                                                                                                        View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.viewEvening);
                                                                                                                                        if (viewFindChildViewById6 != null) {
                                                                                                                                            return new FragmentTestSignInFormFourBinding(relativeLayout2, viewFindChildViewById, button, viewFindChildViewById2, checkBox, textView, editText, textView2, viewFindChildViewById3, textView3, imageView, linearLayout, textView4, viewFindChildViewById4, linearLayout2, linearLayout3, textView5, editText2, editText3, textView6, editText4, editText5, button2, linearLayout4, textView7, relativeLayout, textView8, imageView2, textView9, editText6, relativeLayout2, textView10, textView11, viewFindChildViewById5, viewFindChildViewById6);
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
