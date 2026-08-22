package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtFragmentChooseLanguageBinding implements ViewBinding {
    public final Button continueBtn;
    public final RadioButton engRadio;
    public final LinearLayout englishRL;
    public final LinearLayout hindiRL;
    public final RadioButton hindiRadio;
    private final RelativeLayout rootView;

    private IbtFragmentChooseLanguageBinding(RelativeLayout rootView, Button continueBtn, RadioButton engRadio, LinearLayout englishRL, LinearLayout hindiRL, RadioButton hindiRadio) {
        this.rootView = rootView;
        this.continueBtn = continueBtn;
        this.engRadio = engRadio;
        this.englishRL = englishRL;
        this.hindiRL = hindiRL;
        this.hindiRadio = hindiRadio;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtFragmentChooseLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentChooseLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_choose_language, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentChooseLanguageBinding bind(View rootView) {
        int i = R.id.continue_btn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.continue_btn);
        if (button != null) {
            i = R.id.engRadio;
            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.engRadio);
            if (radioButton != null) {
                i = R.id.englishRL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.englishRL);
                if (linearLayout != null) {
                    i = R.id.hindiRL;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.hindiRL);
                    if (linearLayout2 != null) {
                        i = R.id.hindiRadio;
                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(rootView, R.id.hindiRadio);
                        if (radioButton2 != null) {
                            return new IbtFragmentChooseLanguageBinding((RelativeLayout) rootView, button, radioButton, linearLayout, linearLayout2, radioButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
