package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ContactUsLayoutBinding implements ViewBinding {
    public final LinearLayout classStreamLL;
    public final TextView delete;
    public final TextInputEditText email;
    public final ImageView imageBack;
    public final TextInputEditText issue;
    public final Toolbar mainToolbar;
    public final TextInputEditText message;
    public final TextInputEditText mobile;
    public final TextInputEditText name;
    private final ScrollView rootView;
    public final CheckBox selectAllDelete;
    public final TextInputEditText selectClass;
    public final TextInputLayout selectClassTIL;
    public final TextView selectClassTV;
    public final TextInputEditText selectStream;
    public final TextInputLayout selectStreamTIL;
    public final TextView selectStreamTV;
    public final Button submitBtn;
    public final TextView toolbarTitleTV;
    public final Button viewConversation;

    private ContactUsLayoutBinding(ScrollView rootView, LinearLayout classStreamLL, TextView delete, TextInputEditText email, ImageView imageBack, TextInputEditText issue, Toolbar mainToolbar, TextInputEditText message, TextInputEditText mobile, TextInputEditText name, CheckBox selectAllDelete, TextInputEditText selectClass, TextInputLayout selectClassTIL, TextView selectClassTV, TextInputEditText selectStream, TextInputLayout selectStreamTIL, TextView selectStreamTV, Button submitBtn, TextView toolbarTitleTV, Button viewConversation) {
        this.rootView = rootView;
        this.classStreamLL = classStreamLL;
        this.delete = delete;
        this.email = email;
        this.imageBack = imageBack;
        this.issue = issue;
        this.mainToolbar = mainToolbar;
        this.message = message;
        this.mobile = mobile;
        this.name = name;
        this.selectAllDelete = selectAllDelete;
        this.selectClass = selectClass;
        this.selectClassTIL = selectClassTIL;
        this.selectClassTV = selectClassTV;
        this.selectStream = selectStream;
        this.selectStreamTIL = selectStreamTIL;
        this.selectStreamTV = selectStreamTV;
        this.submitBtn = submitBtn;
        this.toolbarTitleTV = toolbarTitleTV;
        this.viewConversation = viewConversation;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ContactUsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ContactUsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.contact_us_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ContactUsLayoutBinding bind(View rootView) {
        int i = R.id.class_streamLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.class_streamLL);
        if (linearLayout != null) {
            i = R.id.delete;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
            if (textView != null) {
                i = R.id.email;
                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.email);
                if (textInputEditText != null) {
                    i = R.id.image_back;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                    if (imageView != null) {
                        i = R.id.issue;
                        TextInputEditText textInputEditText2 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.issue);
                        if (textInputEditText2 != null) {
                            i = R.id.main_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                            if (toolbar != null) {
                                i = R.id.message;
                                TextInputEditText textInputEditText3 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.message);
                                if (textInputEditText3 != null) {
                                    i = R.id.mobile;
                                    TextInputEditText textInputEditText4 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.mobile);
                                    if (textInputEditText4 != null) {
                                        i = R.id.name;
                                        TextInputEditText textInputEditText5 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.name);
                                        if (textInputEditText5 != null) {
                                            i = R.id.select_all_delete;
                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                            if (checkBox != null) {
                                                i = R.id.selectClass;
                                                TextInputEditText textInputEditText6 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.selectClass);
                                                if (textInputEditText6 != null) {
                                                    i = R.id.selectClassTIL;
                                                    TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.selectClassTIL);
                                                    if (textInputLayout != null) {
                                                        i = R.id.selectClassTV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.selectClassTV);
                                                        if (textView2 != null) {
                                                            i = R.id.selectStream;
                                                            TextInputEditText textInputEditText7 = (TextInputEditText) ViewBindings.findChildViewById(rootView, R.id.selectStream);
                                                            if (textInputEditText7 != null) {
                                                                i = R.id.selectStreamTIL;
                                                                TextInputLayout textInputLayout2 = (TextInputLayout) ViewBindings.findChildViewById(rootView, R.id.selectStreamTIL);
                                                                if (textInputLayout2 != null) {
                                                                    i = R.id.selectStreamTV;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.selectStreamTV);
                                                                    if (textView3 != null) {
                                                                        i = R.id.submitBtn;
                                                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitBtn);
                                                                        if (button != null) {
                                                                            i = R.id.toolbarTitleTV;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                            if (textView4 != null) {
                                                                                i = R.id.viewConversation;
                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.viewConversation);
                                                                                if (button2 != null) {
                                                                                    return new ContactUsLayoutBinding((ScrollView) rootView, linearLayout, textView, textInputEditText, imageView, textInputEditText2, toolbar, textInputEditText3, textInputEditText4, textInputEditText5, checkBox, textInputEditText6, textInputLayout, textView2, textInputEditText7, textInputLayout2, textView3, button, textView4, button2);
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
