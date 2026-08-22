package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentOtpverifcationNewBinding implements ViewBinding {
    public final EditText OPT1ET;
    public final EditText OPT2ET;
    public final EditText OPT3ET;
    public final EditText OPT4ET;
    public final EditText OPT5ET;
    public final EditText OPT6ET;
    public final LinearLayout activitySignIn;
    public final TextView didnototpTV;
    public final ImageView loginLogo;
    public final EditText pinHiddenEdittext;
    public final TextView resendotpTV;
    public final TextView resendotpTV1;
    private final LinearLayout rootView;
    public final TextView tvTimer;
    public final Button verifyBtn;
    public final TextView verifyTextTV;

    private FragmentOtpverifcationNewBinding(LinearLayout rootView, EditText OPT1ET, EditText OPT2ET, EditText OPT3ET, EditText OPT4ET, EditText OPT5ET, EditText OPT6ET, LinearLayout activitySignIn, TextView didnototpTV, ImageView loginLogo, EditText pinHiddenEdittext, TextView resendotpTV, TextView resendotpTV1, TextView tvTimer, Button verifyBtn, TextView verifyTextTV) {
        this.rootView = rootView;
        this.OPT1ET = OPT1ET;
        this.OPT2ET = OPT2ET;
        this.OPT3ET = OPT3ET;
        this.OPT4ET = OPT4ET;
        this.OPT5ET = OPT5ET;
        this.OPT6ET = OPT6ET;
        this.activitySignIn = activitySignIn;
        this.didnototpTV = didnototpTV;
        this.loginLogo = loginLogo;
        this.pinHiddenEdittext = pinHiddenEdittext;
        this.resendotpTV = resendotpTV;
        this.resendotpTV1 = resendotpTV1;
        this.tvTimer = tvTimer;
        this.verifyBtn = verifyBtn;
        this.verifyTextTV = verifyTextTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentOtpverifcationNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentOtpverifcationNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_otpverifcation_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentOtpverifcationNewBinding bind(View rootView) {
        int i = R.id.OPT1ET;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT1ET);
        if (editText != null) {
            i = R.id.OPT2ET;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT2ET);
            if (editText2 != null) {
                i = R.id.OPT3ET;
                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT3ET);
                if (editText3 != null) {
                    i = R.id.OPT4ET;
                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT4ET);
                    if (editText4 != null) {
                        i = R.id.OPT5ET;
                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT5ET);
                        if (editText5 != null) {
                            i = R.id.OPT6ET;
                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.OPT6ET);
                            if (editText6 != null) {
                                LinearLayout linearLayout = (LinearLayout) rootView;
                                i = R.id.didnototpTV;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.didnototpTV);
                                if (textView != null) {
                                    i = R.id.loginLogo;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.loginLogo);
                                    if (imageView != null) {
                                        i = R.id.pin_hidden_edittext;
                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pin_hidden_edittext);
                                        if (editText7 != null) {
                                            i = R.id.resendotpTV;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resendotpTV);
                                            if (textView2 != null) {
                                                i = R.id.resendotpTV1;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resendotpTV1);
                                                if (textView3 != null) {
                                                    i = R.id.tv_timer;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_timer);
                                                    if (textView4 != null) {
                                                        i = R.id.verifyBtn;
                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.verifyBtn);
                                                        if (button != null) {
                                                            i = R.id.verifyTextTV;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.verifyTextTV);
                                                            if (textView5 != null) {
                                                                return new FragmentOtpverifcationNewBinding(linearLayout, editText, editText2, editText3, editText4, editText5, editText6, linearLayout, textView, imageView, editText7, textView2, textView3, textView4, button, textView5);
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
