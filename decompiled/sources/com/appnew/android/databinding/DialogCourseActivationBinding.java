package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCourseActivationBinding implements ViewBinding {
    public final Button btnCancel;
    public final Button btnSubmit;
    public final EditText etPost;
    private final LinearLayout rootView;
    public final TextView titleDialog;

    private DialogCourseActivationBinding(LinearLayout rootView, Button btnCancel, Button btnSubmit, EditText etPost, TextView titleDialog) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnSubmit = btnSubmit;
        this.etPost = etPost;
        this.titleDialog = titleDialog;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogCourseActivationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogCourseActivationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_course_activation, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogCourseActivationBinding bind(View rootView) {
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_cancel);
        if (button != null) {
            i = R.id.btn_submit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
            if (button2 != null) {
                i = R.id.et_post;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_post);
                if (editText != null) {
                    i = R.id.titleDialog;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleDialog);
                    if (textView != null) {
                        return new DialogCourseActivationBinding((LinearLayout) rootView, button, button2, editText, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
