package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class AddBookDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f324a;
    public final Button btnDialogCancel;
    public final Button btnDialogSubmit;
    public final EditText nameTV;
    private final RelativeLayout rootView;
    public final TextView textDialogTime;
    public final TextInputLayout tittleName;

    private AddBookDialogBinding(RelativeLayout rootView, TextView a2, Button btnDialogCancel, Button btnDialogSubmit, EditText nameTV, TextView textDialogTime, TextInputLayout tittleName) {
        this.rootView = rootView;
        this.f324a = a2;
        this.btnDialogCancel = btnDialogCancel;
        this.btnDialogSubmit = btnDialogSubmit;
        this.nameTV = nameTV;
        this.textDialogTime = textDialogTime;
        this.tittleName = tittleName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AddBookDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddBookDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.add_book_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddBookDialogBinding bind(View rootView) {
        int i = R.id.f567a;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.f567a);
        if (textView != null) {
            i = R.id.btn_dialog_cancel;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_dialog_cancel);
            if (button != null) {
                i = R.id.btn_dialog_submit;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_dialog_submit);
                if (button2 != null) {
                    i = R.id.nameTV;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                    if (editText != null) {
                        i = R.id.text_dialog_time;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_dialog_time);
                        if (textView2 != null) {
                            i = R.id.tittle_name;
                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.tittle_name);
                            if (textInputLayout != null) {
                                return new AddBookDialogBinding((RelativeLayout) rootView, textView, button, button2, editText, textView2, textInputLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
