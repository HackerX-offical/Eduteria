package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RevisionDialogBinding implements ViewBinding {
    public final TextView addCoupounTxt;
    public final TextView btnCancel;
    public final TextView btnSubmit;
    public final RelativeLayout calcpagerl;
    private final RelativeLayout rootView;
    public final TextView txt;
    public final EditText writeCouponET;

    private RevisionDialogBinding(RelativeLayout rootView, TextView addCoupounTxt, TextView btnCancel, TextView btnSubmit, RelativeLayout calcpagerl, TextView txt, EditText writeCouponET) {
        this.rootView = rootView;
        this.addCoupounTxt = addCoupounTxt;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.calcpagerl = calcpagerl;
        this.txt = txt;
        this.writeCouponET = writeCouponET;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevisionDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RevisionDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.revision_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RevisionDialogBinding bind(View rootView) {
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
                    i = R.id.txt;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt);
                    if (textView4 != null) {
                        i = R.id.writeCouponET;
                        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.writeCouponET);
                        if (editText != null) {
                            return new RevisionDialogBinding(relativeLayout, textView, textView2, textView3, relativeLayout, textView4, editText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
