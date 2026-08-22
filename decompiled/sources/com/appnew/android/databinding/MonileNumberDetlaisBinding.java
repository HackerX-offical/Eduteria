package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class MonileNumberDetlaisBinding implements ViewBinding {
    public final TextView addCoupounTxt;
    public final TextView btnCancel;
    public final TextView btnSubmit;
    public final RelativeLayout calcpagerl;
    public final CircleImageView profileImage;
    private final RelativeLayout rootView;
    public final TextView userEmail;
    public final TextView userMobile;
    public final TextView userName;

    private MonileNumberDetlaisBinding(RelativeLayout rootView, TextView addCoupounTxt, TextView btnCancel, TextView btnSubmit, RelativeLayout calcpagerl, CircleImageView profileImage, TextView userEmail, TextView userMobile, TextView userName) {
        this.rootView = rootView;
        this.addCoupounTxt = addCoupounTxt;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.calcpagerl = calcpagerl;
        this.profileImage = profileImage;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userName = userName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MonileNumberDetlaisBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MonileNumberDetlaisBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.monile_number_detlais, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MonileNumberDetlaisBinding bind(View rootView) {
        int i = R.id.add_coupoun_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.add_coupoun_txt);
        if (textView != null) {
            i = R.id.btn__cancel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn__cancel);
            if (textView2 != null) {
                i = R.id.btn_submit;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
                if (textView3 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.profileImage;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                    if (circleImageView != null) {
                        i = R.id.user_email;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_email);
                        if (textView4 != null) {
                            i = R.id.user_mobile;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_mobile);
                            if (textView5 != null) {
                                i = R.id.user_name;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.user_name);
                                if (textView6 != null) {
                                    return new MonileNumberDetlaisBinding(relativeLayout, textView, textView2, textView3, relativeLayout, circleImageView, textView4, textView5, textView6);
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
