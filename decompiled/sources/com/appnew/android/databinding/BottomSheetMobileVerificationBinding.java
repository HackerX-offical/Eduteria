package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetMobileVerificationBinding implements ViewBinding {
    public final LinearLayout bottomSheetContainer;
    public final ImageView cancelDialog;
    public final CardView clearNumber;
    public final RelativeLayout commentRL;
    public final EditText mobileNumberEditText;
    private final LinearLayout rootView;
    public final CardView submitNumber;
    public final TextView titleTv;

    private BottomSheetMobileVerificationBinding(LinearLayout rootView, LinearLayout bottomSheetContainer, ImageView cancelDialog, CardView clearNumber, RelativeLayout commentRL, EditText mobileNumberEditText, CardView submitNumber, TextView titleTv) {
        this.rootView = rootView;
        this.bottomSheetContainer = bottomSheetContainer;
        this.cancelDialog = cancelDialog;
        this.clearNumber = clearNumber;
        this.commentRL = commentRL;
        this.mobileNumberEditText = mobileNumberEditText;
        this.submitNumber = submitNumber;
        this.titleTv = titleTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetMobileVerificationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetMobileVerificationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_mobile_verification, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetMobileVerificationBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.cancelDialog;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancelDialog);
        if (imageView != null) {
            i = R.id.clearNumber;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.clearNumber);
            if (cardView != null) {
                i = R.id.commentRL;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.commentRL);
                if (relativeLayout != null) {
                    i = R.id.mobileNumberEditText;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.mobileNumberEditText);
                    if (editText != null) {
                        i = R.id.submitNumber;
                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.submitNumber);
                        if (cardView2 != null) {
                            i = R.id.titleTv;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleTv);
                            if (textView != null) {
                                return new BottomSheetMobileVerificationBinding(linearLayout, linearLayout, imageView, cardView, relativeLayout, editText, cardView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
