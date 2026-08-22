package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityRegisterationTestBinding implements ViewBinding {
    public final FragmentTestSignInFormBinding fragmentTestSignInForm;
    public final FragmentTestSignInFormFourBinding fragmentTestSignInFormFour;
    public final FragmentTestSignInFormThreeBinding fragmentTestSignInFormThree;
    public final FragmentTestSignInFormTwoBinding fragmentTestSignInFormTwo;
    public final LinearLayout registrationLayout;
    private final LinearLayout rootView;

    private ActivityRegisterationTestBinding(LinearLayout rootView, FragmentTestSignInFormBinding fragmentTestSignInForm, FragmentTestSignInFormFourBinding fragmentTestSignInFormFour, FragmentTestSignInFormThreeBinding fragmentTestSignInFormThree, FragmentTestSignInFormTwoBinding fragmentTestSignInFormTwo, LinearLayout registrationLayout) {
        this.rootView = rootView;
        this.fragmentTestSignInForm = fragmentTestSignInForm;
        this.fragmentTestSignInFormFour = fragmentTestSignInFormFour;
        this.fragmentTestSignInFormThree = fragmentTestSignInFormThree;
        this.fragmentTestSignInFormTwo = fragmentTestSignInFormTwo;
        this.registrationLayout = registrationLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRegisterationTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityRegisterationTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_registeration_test, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityRegisterationTestBinding bind(View rootView) {
        int i = R.id.fragment_test_sign_in_form;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.fragment_test_sign_in_form);
        if (viewFindChildViewById != null) {
            FragmentTestSignInFormBinding fragmentTestSignInFormBindingBind = FragmentTestSignInFormBinding.bind(viewFindChildViewById);
            i = R.id.fragment_test_sign_in_form_four;
            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.fragment_test_sign_in_form_four);
            if (viewFindChildViewById2 != null) {
                FragmentTestSignInFormFourBinding fragmentTestSignInFormFourBindingBind = FragmentTestSignInFormFourBinding.bind(viewFindChildViewById2);
                i = R.id.fragment_test_sign_in_form_three;
                View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.fragment_test_sign_in_form_three);
                if (viewFindChildViewById3 != null) {
                    FragmentTestSignInFormThreeBinding fragmentTestSignInFormThreeBindingBind = FragmentTestSignInFormThreeBinding.bind(viewFindChildViewById3);
                    i = R.id.fragment_test_sign_in_form_two;
                    View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.fragment_test_sign_in_form_two);
                    if (viewFindChildViewById4 != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        return new ActivityRegisterationTestBinding(linearLayout, fragmentTestSignInFormBindingBind, fragmentTestSignInFormFourBindingBind, fragmentTestSignInFormThreeBindingBind, FragmentTestSignInFormTwoBinding.bind(viewFindChildViewById4), linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
