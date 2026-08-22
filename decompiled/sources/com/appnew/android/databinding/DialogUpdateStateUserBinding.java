package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogUpdateStateUserBinding implements ViewBinding {
    public final ConstraintLayout addressCL;
    public final RelativeLayout addressRL;
    public final ScrollView addressSV;
    public final TextView addressTitle;
    public final EditText alternateMobileTV;
    public final Button btnSubmit;
    public final LinearLayout buttonSbmt;
    public final EditText cityTV;
    public final EditText districtTV;
    public final ImageView downarrowIV;
    public final RelativeLayout editRL;
    public final EditText fullAddressTV;
    public final ImageView imagestate;
    public final EditText mobileTV;
    public final TextView msgDialog;
    public final EditText nameTV;
    public final EditText orderNotesTV;
    public final EditText pincodeTV;
    private final RelativeLayout rootView;
    public final RelativeLayout stateRL;
    public final TextView stateSpinner;
    public final EditText stateTV;
    public final ImageView successIV;
    public final TextView titleDialog;
    public final TextView tvStateError;

    private DialogUpdateStateUserBinding(RelativeLayout rootView, ConstraintLayout addressCL, RelativeLayout addressRL, ScrollView addressSV, TextView addressTitle, EditText alternateMobileTV, Button btnSubmit, LinearLayout buttonSbmt, EditText cityTV, EditText districtTV, ImageView downarrowIV, RelativeLayout editRL, EditText fullAddressTV, ImageView imagestate, EditText mobileTV, TextView msgDialog, EditText nameTV, EditText orderNotesTV, EditText pincodeTV, RelativeLayout stateRL, TextView stateSpinner, EditText stateTV, ImageView successIV, TextView titleDialog, TextView tvStateError) {
        this.rootView = rootView;
        this.addressCL = addressCL;
        this.addressRL = addressRL;
        this.addressSV = addressSV;
        this.addressTitle = addressTitle;
        this.alternateMobileTV = alternateMobileTV;
        this.btnSubmit = btnSubmit;
        this.buttonSbmt = buttonSbmt;
        this.cityTV = cityTV;
        this.districtTV = districtTV;
        this.downarrowIV = downarrowIV;
        this.editRL = editRL;
        this.fullAddressTV = fullAddressTV;
        this.imagestate = imagestate;
        this.mobileTV = mobileTV;
        this.msgDialog = msgDialog;
        this.nameTV = nameTV;
        this.orderNotesTV = orderNotesTV;
        this.pincodeTV = pincodeTV;
        this.stateRL = stateRL;
        this.stateSpinner = stateSpinner;
        this.stateTV = stateTV;
        this.successIV = successIV;
        this.titleDialog = titleDialog;
        this.tvStateError = tvStateError;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogUpdateStateUserBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogUpdateStateUserBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_update_state_user, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogUpdateStateUserBinding bind(View rootView) {
        int i = R.id.addressCL;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, R.id.addressCL);
        if (constraintLayout != null) {
            i = R.id.addressRL;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.addressRL);
            if (relativeLayout != null) {
                i = R.id.addressSV;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.addressSV);
                if (scrollView != null) {
                    i = R.id.addressTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.addressTitle);
                    if (textView != null) {
                        i = R.id.alternateMobileTV;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.alternateMobileTV);
                        if (editText != null) {
                            i = R.id.btn_submit;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
                            if (button != null) {
                                i = R.id.buttonSbmt;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.buttonSbmt);
                                if (linearLayout != null) {
                                    i = R.id.cityTV;
                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.cityTV);
                                    if (editText2 != null) {
                                        i = R.id.districtTV;
                                        EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.districtTV);
                                        if (editText3 != null) {
                                            i = R.id.downarrowIV;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                            if (imageView != null) {
                                                i = R.id.editRL;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.editRL);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.fullAddressTV;
                                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.fullAddressTV);
                                                    if (editText4 != null) {
                                                        i = R.id.imagestate;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imagestate);
                                                        if (imageView2 != null) {
                                                            i = R.id.mobileTV;
                                                            EditText editText5 = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileTV);
                                                            if (editText5 != null) {
                                                                i = R.id.msgDialog;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.msgDialog);
                                                                if (textView2 != null) {
                                                                    i = R.id.nameTV;
                                                                    EditText editText6 = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                                                                    if (editText6 != null) {
                                                                        i = R.id.orderNotesTV;
                                                                        EditText editText7 = (EditText) ViewBindings.findChildViewById(rootView, R.id.orderNotesTV);
                                                                        if (editText7 != null) {
                                                                            i = R.id.pincodeTV;
                                                                            EditText editText8 = (EditText) ViewBindings.findChildViewById(rootView, R.id.pincodeTV);
                                                                            if (editText8 != null) {
                                                                                i = R.id.stateRL;
                                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.stateRL);
                                                                                if (relativeLayout3 != null) {
                                                                                    i = R.id.stateSpinner;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.stateSpinner);
                                                                                    if (textView3 != null) {
                                                                                        i = R.id.stateTV;
                                                                                        EditText editText9 = (EditText) ViewBindings.findChildViewById(rootView, R.id.stateTV);
                                                                                        if (editText9 != null) {
                                                                                            i = R.id.successIV;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.successIV);
                                                                                            if (imageView3 != null) {
                                                                                                i = R.id.titleDialog;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tv_stateError;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stateError);
                                                                                                    if (textView5 != null) {
                                                                                                        return new DialogUpdateStateUserBinding((RelativeLayout) rootView, constraintLayout, relativeLayout, scrollView, textView, editText, button, linearLayout, editText2, editText3, imageView, relativeLayout2, editText4, imageView2, editText5, textView2, editText6, editText7, editText8, relativeLayout3, textView3, editText9, imageView3, textView4, textView5);
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
