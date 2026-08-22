package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class SuccessDialogBinding implements ViewBinding {
    public final LinearLayout admitCardLL;
    public final EditText bookName;
    public final Button btnMyCourse;
    public final EditText courseName;
    public final TextInputLayout cvrBookName;
    public final TextInputLayout cvrCourseName;
    public final EditText etOrderId;
    public final EditText etTransactionId;
    private final RelativeLayout rootView;
    public final TextView testTextView;
    public final LinearLayout transactionLL;

    private SuccessDialogBinding(RelativeLayout rootView, LinearLayout admitCardLL, EditText bookName, Button btnMyCourse, EditText courseName, TextInputLayout cvrBookName, TextInputLayout cvrCourseName, EditText etOrderId, EditText etTransactionId, TextView testTextView, LinearLayout transactionLL) {
        this.rootView = rootView;
        this.admitCardLL = admitCardLL;
        this.bookName = bookName;
        this.btnMyCourse = btnMyCourse;
        this.courseName = courseName;
        this.cvrBookName = cvrBookName;
        this.cvrCourseName = cvrCourseName;
        this.etOrderId = etOrderId;
        this.etTransactionId = etTransactionId;
        this.testTextView = testTextView;
        this.transactionLL = transactionLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SuccessDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SuccessDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.success_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SuccessDialogBinding bind(View rootView) {
        int i = R.id.admitCardLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.admitCardLL);
        if (linearLayout != null) {
            i = R.id.book_name;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.book_name);
            if (editText != null) {
                i = R.id.btn_my_course;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_my_course);
                if (button != null) {
                    i = R.id.course_name;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.course_name);
                    if (editText2 != null) {
                        i = R.id.cvrBookName;
                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.cvrBookName);
                        if (textInputLayout != null) {
                            i = R.id.cvrCourseName;
                            TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.cvrCourseName);
                            if (textInputLayout2 != null) {
                                i = R.id.et_order_id;
                                EditText editText3 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_order_id);
                                if (editText3 != null) {
                                    i = R.id.et_transaction_id;
                                    EditText editText4 = (EditText) ViewBindings.findChildViewById(rootView, R.id.et_transaction_id);
                                    if (editText4 != null) {
                                        i = R.id.test_textView;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_textView);
                                        if (textView != null) {
                                            i = R.id.transactionLL;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.transactionLL);
                                            if (linearLayout2 != null) {
                                                return new SuccessDialogBinding((RelativeLayout) rootView, linearLayout, editText, button, editText2, textInputLayout, textInputLayout2, editText3, editText4, textView, linearLayout2);
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
