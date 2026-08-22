package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogFormBinding implements ViewBinding {
    public final ImageView adharIV;
    public final ImageView cancelButton;
    public final Button imgAdhrBtn;
    public final Button imgBtn;
    public final Toolbar mainToolbar;
    public final ImageView profileIV;
    private final LinearLayoutCompat rootView;
    public final Button submitBtn;
    public final TextView title;
    public final TextView toolbarTitleTV;

    private DialogFormBinding(LinearLayoutCompat rootView, ImageView adharIV, ImageView cancelButton, Button imgAdhrBtn, Button imgBtn, Toolbar mainToolbar, ImageView profileIV, Button submitBtn, TextView title, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.adharIV = adharIV;
        this.cancelButton = cancelButton;
        this.imgAdhrBtn = imgAdhrBtn;
        this.imgBtn = imgBtn;
        this.mainToolbar = mainToolbar;
        this.profileIV = profileIV;
        this.submitBtn = submitBtn;
        this.title = title;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static DialogFormBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogFormBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_form, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogFormBinding bind(View rootView) {
        int i = R.id.adharIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.adharIV);
        if (imageView != null) {
            i = R.id.cancel_button;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cancel_button);
            if (imageView2 != null) {
                i = R.id.img_adhr_btn;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.img_adhr_btn);
                if (button != null) {
                    i = R.id.img_btn;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.img_btn);
                    if (button2 != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.profileIV;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileIV);
                            if (imageView3 != null) {
                                i = R.id.submit_btn;
                                Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit_btn);
                                if (button3 != null) {
                                    i = R.id.title;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                    if (textView != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView2 != null) {
                                            return new DialogFormBinding((LinearLayoutCompat) rootView, imageView, imageView2, button, button2, toolbar, imageView3, button3, textView, textView2);
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
