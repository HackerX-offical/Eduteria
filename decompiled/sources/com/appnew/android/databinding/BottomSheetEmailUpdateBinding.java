package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetEmailUpdateBinding implements ViewBinding {
    public final TextView apply;
    public final TextView bottomDialogTitle;
    public final TextView cancel;
    public final RelativeLayout headerRl;
    public final ImageView imf;
    private final RelativeLayout rootView;
    public final EditText updateEmailEdt;
    public final RelativeLayout updateEmailRl;
    public final View view;

    private BottomSheetEmailUpdateBinding(RelativeLayout rootView, TextView apply, TextView bottomDialogTitle, TextView cancel, RelativeLayout headerRl, ImageView imf, EditText updateEmailEdt, RelativeLayout updateEmailRl, View view) {
        this.rootView = rootView;
        this.apply = apply;
        this.bottomDialogTitle = bottomDialogTitle;
        this.cancel = cancel;
        this.headerRl = headerRl;
        this.imf = imf;
        this.updateEmailEdt = updateEmailEdt;
        this.updateEmailRl = updateEmailRl;
        this.view = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetEmailUpdateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomSheetEmailUpdateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_sheet_email_update, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetEmailUpdateBinding bind(View rootView) {
        int i = R.id.apply;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.apply);
        if (textView != null) {
            i = R.id.bottomDialog_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bottomDialog_title);
            if (textView2 != null) {
                i = R.id.cancel;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cancel);
                if (textView3 != null) {
                    i = R.id.header_rl;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.header_rl);
                    if (relativeLayout != null) {
                        i = R.id.imf;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imf);
                        if (imageView != null) {
                            i = R.id.updateEmail_edt;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.updateEmail_edt);
                            if (editText != null) {
                                i = R.id.updateEmail_rl;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.updateEmail_rl);
                                if (relativeLayout2 != null) {
                                    i = R.id.view;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view);
                                    if (viewFindChildViewById != null) {
                                        return new BottomSheetEmailUpdateBinding((RelativeLayout) rootView, textView, textView2, textView3, relativeLayout, imageView, editText, relativeLayout2, viewFindChildViewById);
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
