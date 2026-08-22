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
public final class FragmentContactusBottomSheetBinding implements ViewBinding {
    public final LinearLayout bottomSheetBtnCall;
    public final LinearLayout bottomSheetBtnChat;
    public final LinearLayout bottomSheetBtnEmail;
    private final LinearLayout rootView;
    public final TextView titleDialog;

    private FragmentContactusBottomSheetBinding(LinearLayout rootView, LinearLayout bottomSheetBtnCall, LinearLayout bottomSheetBtnChat, LinearLayout bottomSheetBtnEmail, TextView titleDialog) {
        this.rootView = rootView;
        this.bottomSheetBtnCall = bottomSheetBtnCall;
        this.bottomSheetBtnChat = bottomSheetBtnChat;
        this.bottomSheetBtnEmail = bottomSheetBtnEmail;
        this.titleDialog = titleDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentContactusBottomSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentContactusBottomSheetBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_contactus_bottom_sheet, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentContactusBottomSheetBinding bind(View rootView) {
        int i = R.id.bottomSheetBtnCall;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomSheetBtnCall);
        if (linearLayout != null) {
            i = R.id.bottomSheetBtnChat;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomSheetBtnChat);
            if (linearLayout2 != null) {
                i = R.id.bottomSheetBtnEmail;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomSheetBtnEmail);
                if (linearLayout3 != null) {
                    i = R.id.titleDialog;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                    if (textView != null) {
                        return new FragmentContactusBottomSheetBinding((LinearLayout) rootView, linearLayout, linearLayout2, linearLayout3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
