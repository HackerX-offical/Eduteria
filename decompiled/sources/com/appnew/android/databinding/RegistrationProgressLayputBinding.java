package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RegistrationProgressLayputBinding implements ViewBinding {
    public final View addressProgressBar;
    public final View cartProgressBar;
    public final TextView firstProgressBarText;
    public final View fourthProgressBar;
    public final TextView fourthProgressBarText;
    public final View paymentProgressBar;
    public final LinearLayout paymentStepProgress;
    private final LinearLayout rootView;
    public final TextView secondProgressBarText;
    public final TextView thirdProgressBarText;

    private RegistrationProgressLayputBinding(LinearLayout rootView, View addressProgressBar, View cartProgressBar, TextView firstProgressBarText, View fourthProgressBar, TextView fourthProgressBarText, View paymentProgressBar, LinearLayout paymentStepProgress, TextView secondProgressBarText, TextView thirdProgressBarText) {
        this.rootView = rootView;
        this.addressProgressBar = addressProgressBar;
        this.cartProgressBar = cartProgressBar;
        this.firstProgressBarText = firstProgressBarText;
        this.fourthProgressBar = fourthProgressBar;
        this.fourthProgressBarText = fourthProgressBarText;
        this.paymentProgressBar = paymentProgressBar;
        this.paymentStepProgress = paymentStepProgress;
        this.secondProgressBarText = secondProgressBarText;
        this.thirdProgressBarText = thirdProgressBarText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RegistrationProgressLayputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RegistrationProgressLayputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.registration_progress_layput, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RegistrationProgressLayputBinding bind(View rootView) {
        int i = R.id.address_progress_bar;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.address_progress_bar);
        if (viewFindChildViewById != null) {
            i = R.id.cart_progress_bar;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.cart_progress_bar);
            if (viewFindChildViewById2 != null) {
                i = R.id.first_progress_bar_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.first_progress_bar_text);
                if (textView != null) {
                    i = R.id.fourth_progress_bar;
                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar);
                    if (viewFindChildViewById3 != null) {
                        i = R.id.fourth_progress_bar_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fourth_progress_bar_text);
                        if (textView2 != null) {
                            i = R.id.payment_progress_bar;
                            View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.payment_progress_bar);
                            if (viewFindChildViewById4 != null) {
                                LinearLayout linearLayout = (LinearLayout) rootView;
                                i = R.id.second_progress_bar_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.second_progress_bar_text);
                                if (textView3 != null) {
                                    i = R.id.third_progress_bar_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.third_progress_bar_text);
                                    if (textView4 != null) {
                                        return new RegistrationProgressLayputBinding(linearLayout, viewFindChildViewById, viewFindChildViewById2, textView, viewFindChildViewById3, textView2, viewFindChildViewById4, linearLayout, textView3, textView4);
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
