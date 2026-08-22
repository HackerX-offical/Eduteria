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

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSignInFormTwoBinding implements ViewBinding {
    public final View addressProgressBar;
    public final Button buyNowBtn;
    public final View cartProgressBar;
    public final EditText fatherContectET;
    public final EditText fatherNameET;
    public final EditText fatherOccupationET;
    public final TextView firstProgressBarText;
    public final View fourthProgressBar;
    public final TextView fourthProgressBarText;
    public final ImageView ivBack;
    public final LinearLayout llBottom;
    public final EditText motherContactET;
    public final EditText motherNameET;
    public final EditText motherOccupationET;
    public final TextView mrpCutTV;
    public final View paymentProgressBar;
    public final LinearLayout paymentStepProgress;
    public final LinearLayout paymentStepProgress1;
    public final Button previousBtn;
    public final LinearLayout priceLL;
    public final TextView priceTV;
    public final RelativeLayout rlMain;
    private final RelativeLayout rootView;
    public final TextView secondProgressBarText;
    public final RelativeLayout svMain;
    public final TextView thirdProgressBarText;
    public final TextView title;
    public final View viewAd;
    public final View viewFatherOccupation;
    public final View viewMother;
    public final View viewMotherContact;
    public final View viewMotherOccupation;
    public final View viewfather;

    private FragmentTestSignInFormTwoBinding(RelativeLayout rootView, View addressProgressBar, Button buyNowBtn, View cartProgressBar, EditText fatherContectET, EditText fatherNameET, EditText fatherOccupationET, TextView firstProgressBarText, View fourthProgressBar, TextView fourthProgressBarText, ImageView ivBack, LinearLayout llBottom, EditText motherContactET, EditText motherNameET, EditText motherOccupationET, TextView mrpCutTV, View paymentProgressBar, LinearLayout paymentStepProgress, LinearLayout paymentStepProgress1, Button previousBtn, LinearLayout priceLL, TextView priceTV, RelativeLayout rlMain, TextView secondProgressBarText, RelativeLayout svMain, TextView thirdProgressBarText, TextView title, View viewAd, View viewFatherOccupation, View viewMother, View viewMotherContact, View viewMotherOccupation, View viewfather) {
        this.rootView = rootView;
        this.addressProgressBar = addressProgressBar;
        this.buyNowBtn = buyNowBtn;
        this.cartProgressBar = cartProgressBar;
        this.fatherContectET = fatherContectET;
        this.fatherNameET = fatherNameET;
        this.fatherOccupationET = fatherOccupationET;
        this.firstProgressBarText = firstProgressBarText;
        this.fourthProgressBar = fourthProgressBar;
        this.fourthProgressBarText = fourthProgressBarText;
        this.ivBack = ivBack;
        this.llBottom = llBottom;
        this.motherContactET = motherContactET;
        this.motherNameET = motherNameET;
        this.motherOccupationET = motherOccupationET;
        this.mrpCutTV = mrpCutTV;
        this.paymentProgressBar = paymentProgressBar;
        this.paymentStepProgress = paymentStepProgress;
        this.paymentStepProgress1 = paymentStepProgress1;
        this.previousBtn = previousBtn;
        this.priceLL = priceLL;
        this.priceTV = priceTV;
        this.rlMain = rlMain;
        this.secondProgressBarText = secondProgressBarText;
        this.svMain = svMain;
        this.thirdProgressBarText = thirdProgressBarText;
        this.title = title;
        this.viewAd = viewAd;
        this.viewFatherOccupation = viewFatherOccupation;
        this.viewMother = viewMother;
        this.viewMotherContact = viewMotherContact;
        this.viewMotherOccupation = viewMotherOccupation;
        this.viewfather = viewfather;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTestSignInFormTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSignInFormTwoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_sign_in_form_two, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSignInFormTwoBinding bind(View rootView) {
        int i = R.id.address_progress_bar;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_progress_bar);
        if (viewFindChildViewById != null) {
            i = R.id.buyNowBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
            if (button != null) {
                i = R.id.cart_progress_bar;
                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cart_progress_bar);
                if (viewFindChildViewById2 != null) {
                    i = R.id.fatherContectET;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherContectET);
                    if (editText != null) {
                        i = R.id.fatherNameET;
                        EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherNameET);
                        if (editText2 != null) {
                            i = R.id.fatherOccupationET;
                            EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fatherOccupationET);
                            if (editText3 != null) {
                                i = R.id.first_progress_bar_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_progress_bar_text);
                                if (textView != null) {
                                    i = R.id.fourth_progress_bar;
                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar);
                                    if (viewFindChildViewById3 != null) {
                                        i = R.id.fourth_progress_bar_text;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar_text);
                                        if (textView2 != null) {
                                            i = R.id.iv_back;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                            if (imageView != null) {
                                                i = R.id.ll_bottom;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_bottom);
                                                if (linearLayout != null) {
                                                    i = R.id.motherContactET;
                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherContactET);
                                                    if (editText4 != null) {
                                                        i = R.id.motherNameET;
                                                        EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherNameET);
                                                        if (editText5 != null) {
                                                            i = R.id.motherOccupationET;
                                                            EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.motherOccupationET);
                                                            if (editText6 != null) {
                                                                i = R.id.mrpCutTV;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                if (textView3 != null) {
                                                                    i = R.id.payment_progress_bar;
                                                                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.payment_progress_bar);
                                                                    if (viewFindChildViewById4 != null) {
                                                                        i = R.id.payment_step_progress;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.payment_step_progress_1;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_step_progress_1);
                                                                            if (linearLayout3 != null) {
                                                                                i = R.id.previousBtn;
                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.previousBtn);
                                                                                if (button2 != null) {
                                                                                    i = R.id.priceLL;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.priceLL);
                                                                                    if (linearLayout4 != null) {
                                                                                        i = R.id.priceTV;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                                        if (textView4 != null) {
                                                                                            i = R.id.rl_main;
                                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_main);
                                                                                            if (relativeLayout != null) {
                                                                                                i = R.id.second_progress_bar_text;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.second_progress_bar_text);
                                                                                                if (textView5 != null) {
                                                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                                                                                    i = R.id.third_progress_bar_text;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.third_progress_bar_text);
                                                                                                    if (textView6 != null) {
                                                                                                        i = R.id.title;
                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                                                        if (textView7 != null) {
                                                                                                            i = R.id.viewAd;
                                                                                                            View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.viewAd);
                                                                                                            if (viewFindChildViewById5 != null) {
                                                                                                                i = R.id.viewFatherOccupation;
                                                                                                                View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.viewFatherOccupation);
                                                                                                                if (viewFindChildViewById6 != null) {
                                                                                                                    i = R.id.viewMother;
                                                                                                                    View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.viewMother);
                                                                                                                    if (viewFindChildViewById7 != null) {
                                                                                                                        i = R.id.viewMotherContact;
                                                                                                                        View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.viewMotherContact);
                                                                                                                        if (viewFindChildViewById8 != null) {
                                                                                                                            i = R.id.viewMotherOccupation;
                                                                                                                            View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.viewMotherOccupation);
                                                                                                                            if (viewFindChildViewById9 != null) {
                                                                                                                                i = R.id.viewfather;
                                                                                                                                View viewFindChildViewById10 = ViewBindings.findChildViewById(rootView, R.id.viewfather);
                                                                                                                                if (viewFindChildViewById10 != null) {
                                                                                                                                    return new FragmentTestSignInFormTwoBinding(relativeLayout2, viewFindChildViewById, button, viewFindChildViewById2, editText, editText2, editText3, textView, viewFindChildViewById3, textView2, imageView, linearLayout, editText4, editText5, editText6, textView3, viewFindChildViewById4, linearLayout2, linearLayout3, button2, linearLayout4, textView4, relativeLayout, textView5, relativeLayout2, textView6, textView7, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, viewFindChildViewById10);
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
