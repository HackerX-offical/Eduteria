package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TestSubmittionActivityBinding implements ViewBinding {
    public final TextView Thanks;
    public final Button backBtn;
    public final ImageView backimag;
    public final RelativeLayout layput;
    public final TextView result;
    private final RelativeLayout rootView;
    public final AppCompatTextView testName;
    public final TextView testSubmit;
    public final ImageView thumb;
    public final Toolbar toolbar;

    private TestSubmittionActivityBinding(RelativeLayout rootView, TextView Thanks, Button backBtn, ImageView backimag, RelativeLayout layput, TextView result, AppCompatTextView testName, TextView testSubmit, ImageView thumb, Toolbar toolbar) {
        this.rootView = rootView;
        this.Thanks = Thanks;
        this.backBtn = backBtn;
        this.backimag = backimag;
        this.layput = layput;
        this.result = result;
        this.testName = testName;
        this.testSubmit = testSubmit;
        this.thumb = thumb;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TestSubmittionActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TestSubmittionActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.test_submittion_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TestSubmittionActivityBinding bind(View rootView) {
        int i = R.id.Thanks;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.Thanks);
        if (textView != null) {
            i = R.id.backBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
            if (button != null) {
                i = R.id.backimag;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.backimag);
                if (imageView != null) {
                    i = R.id.layput;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layput);
                    if (relativeLayout != null) {
                        i = R.id.result;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.result);
                        if (textView2 != null) {
                            i = R.id.test_name;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(rootView, R.id.test_name);
                            if (appCompatTextView != null) {
                                i = R.id.test_submit;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_submit);
                                if (textView3 != null) {
                                    i = R.id.thumb;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.thumb);
                                    if (imageView2 != null) {
                                        i = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                        if (toolbar != null) {
                                            return new TestSubmittionActivityBinding((RelativeLayout) rootView, textView, button, imageView, relativeLayout, textView2, appCompatTextView, textView3, imageView2, toolbar);
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
