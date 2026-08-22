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
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSignUpFormNaveenBinding implements ViewBinding {
    public final EditText confirmPasswordET;
    public final ImageView downarrowIV;
    public final EditText emailTV;
    public final EditText etMobile;
    public final ImageView imagestates;
    public final ImageView ivBack;
    public final RelativeLayout masterCategory;
    public final ImageView masterCategoryImage;
    public final EditText passwordET;
    private final NestedScrollView rootView;
    public final Button signupBtn;
    public final TextView stateSpinner;
    public final TextInputLayout tilConfirmPassword;
    public final TextInputLayout tilPassword;
    public final TextView title;
    public final TextView tvCode;
    public final TextView tvStateError;
    public final View view0;

    private FragmentSignUpFormNaveenBinding(NestedScrollView rootView, EditText confirmPasswordET, ImageView downarrowIV, EditText emailTV, EditText etMobile, ImageView imagestates, ImageView ivBack, RelativeLayout masterCategory, ImageView masterCategoryImage, EditText passwordET, Button signupBtn, TextView stateSpinner, TextInputLayout tilConfirmPassword, TextInputLayout tilPassword, TextView title, TextView tvCode, TextView tvStateError, View view0) {
        this.rootView = rootView;
        this.confirmPasswordET = confirmPasswordET;
        this.downarrowIV = downarrowIV;
        this.emailTV = emailTV;
        this.etMobile = etMobile;
        this.imagestates = imagestates;
        this.ivBack = ivBack;
        this.masterCategory = masterCategory;
        this.masterCategoryImage = masterCategoryImage;
        this.passwordET = passwordET;
        this.signupBtn = signupBtn;
        this.stateSpinner = stateSpinner;
        this.tilConfirmPassword = tilConfirmPassword;
        this.tilPassword = tilPassword;
        this.title = title;
        this.tvCode = tvCode;
        this.tvStateError = tvStateError;
        this.view0 = view0;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentSignUpFormNaveenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSignUpFormNaveenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_sign_up_form_naveen, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSignUpFormNaveenBinding bind(View rootView) {
        int i = R.id.confirmPasswordET;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.confirmPasswordET);
        if (editText != null) {
            i = R.id.downarrowIV;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
            if (imageView != null) {
                i = R.id.emailTV;
                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.emailTV);
                if (editText2 != null) {
                    i = R.id.et_mobile;
                    EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_mobile);
                    if (editText3 != null) {
                        i = R.id.imagestates;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestates);
                        if (imageView2 != null) {
                            i = R.id.iv_back;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                            if (imageView3 != null) {
                                i = R.id.master_category;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.master_category);
                                if (relativeLayout != null) {
                                    i = R.id.master_category_image;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.master_category_image);
                                    if (imageView4 != null) {
                                        i = R.id.passwordET;
                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.passwordET);
                                        if (editText4 != null) {
                                            i = R.id.signupBtn;
                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.signupBtn);
                                            if (button != null) {
                                                i = R.id.stateSpinner;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                if (textView != null) {
                                                    i = R.id.til_confirm_password;
                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_confirm_password);
                                                    if (textInputLayout != null) {
                                                        i = R.id.til_password;
                                                        TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.til_password);
                                                        if (textInputLayout2 != null) {
                                                            i = R.id.title;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                            if (textView2 != null) {
                                                                i = R.id.tv_code;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_code);
                                                                if (textView3 != null) {
                                                                    i = R.id.tv_stateError;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stateError);
                                                                    if (textView4 != null) {
                                                                        i = R.id.view0;
                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view0);
                                                                        if (viewFindChildViewById != null) {
                                                                            return new FragmentSignUpFormNaveenBinding((NestedScrollView) rootView, editText, imageView, editText2, editText3, imageView2, imageView3, relativeLayout, imageView4, editText4, button, textView, textInputLayout, textInputLayout2, textView2, textView3, textView4, viewFindChildViewById);
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
