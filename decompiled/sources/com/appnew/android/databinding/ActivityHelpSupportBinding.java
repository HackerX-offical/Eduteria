package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityHelpSupportBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final RelativeLayout btnpcd;
    public final EditText commentEt;
    public final TextView courseIdTxt;
    public final RelativeLayout courseRL;
    public final AppCompatSpinner feedtype;
    public final ImageView imageIV;
    public final Toolbar myProgressToolbar;
    public final TextView orderLabelTxt;
    private final RelativeLayout rootView;
    public final Button submitBtn;
    public final EditText title;
    public final TextView toolbartitleTV;

    private ActivityHelpSupportBinding(RelativeLayout rootView, AppBarLayout appBarLayout, RelativeLayout btnpcd, EditText commentEt, TextView courseIdTxt, RelativeLayout courseRL, AppCompatSpinner feedtype, ImageView imageIV, Toolbar myProgressToolbar, TextView orderLabelTxt, Button submitBtn, EditText title, TextView toolbartitleTV) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.btnpcd = btnpcd;
        this.commentEt = commentEt;
        this.courseIdTxt = courseIdTxt;
        this.courseRL = courseRL;
        this.feedtype = feedtype;
        this.imageIV = imageIV;
        this.myProgressToolbar = myProgressToolbar;
        this.orderLabelTxt = orderLabelTxt;
        this.submitBtn = submitBtn;
        this.title = title;
        this.toolbartitleTV = toolbartitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHelpSupportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityHelpSupportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_help_support, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHelpSupportBinding bind(View rootView) {
        int i = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i = R.id.btnpcd;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.btnpcd);
            if (relativeLayout != null) {
                i = R.id.comment_et;
                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.comment_et);
                if (editText != null) {
                    i = R.id.courseIdTxt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseIdTxt);
                    if (textView != null) {
                        i = R.id.courseRL;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.courseRL);
                        if (relativeLayout2 != null) {
                            i = R.id.feedtype;
                            AppCompatSpinner appCompatSpinner = (AppCompatSpinner) ViewBindings.findChildViewById(rootView, R.id.feedtype);
                            if (appCompatSpinner != null) {
                                i = R.id.imageIV;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                                if (imageView != null) {
                                    i = R.id.myProgress_toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.myProgress_toolbar);
                                    if (toolbar != null) {
                                        i = R.id.orderLabelTxt;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderLabelTxt);
                                        if (textView2 != null) {
                                            i = R.id.submitBtn;
                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.submitBtn);
                                            if (button != null) {
                                                i = R.id.title;
                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.title);
                                                if (editText2 != null) {
                                                    i = R.id.toolbartitleTV;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                    if (textView3 != null) {
                                                        return new ActivityHelpSupportBinding((RelativeLayout) rootView, appBarLayout, relativeLayout, editText, textView, relativeLayout2, appCompatSpinner, imageView, toolbar, textView2, button, editText2, textView3);
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
