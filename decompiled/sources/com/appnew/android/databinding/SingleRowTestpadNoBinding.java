package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowTestpadNoBinding implements ViewBinding {
    public final LinearLayout countLL;
    public final ImageView imageIVText;
    public final TextView myImageViewText;
    public final LinearLayout parentLLTestpad;
    public final TextView questionTV;
    public final RelativeLayout rlSelected;
    private final LinearLayout rootView;
    public final TextView sectionText;
    public final ClickableWebView webviewQuestionTV;

    private SingleRowTestpadNoBinding(LinearLayout rootView, LinearLayout countLL, ImageView imageIVText, TextView myImageViewText, LinearLayout parentLLTestpad, TextView questionTV, RelativeLayout rlSelected, TextView sectionText, ClickableWebView webviewQuestionTV) {
        this.rootView = rootView;
        this.countLL = countLL;
        this.imageIVText = imageIVText;
        this.myImageViewText = myImageViewText;
        this.parentLLTestpad = parentLLTestpad;
        this.questionTV = questionTV;
        this.rlSelected = rlSelected;
        this.sectionText = sectionText;
        this.webviewQuestionTV = webviewQuestionTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowTestpadNoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowTestpadNoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_testpad_no, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowTestpadNoBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.imageIVText;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIVText);
        if (imageView != null) {
            i = R.id.myImageViewText;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.myImageViewText);
            if (textView != null) {
                i = R.id.parentLLTestpad;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentLLTestpad);
                if (linearLayout2 != null) {
                    i = R.id.questionTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.questionTV);
                    if (textView2 != null) {
                        i = R.id.rl_selected;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_selected);
                        if (relativeLayout != null) {
                            i = R.id.sectionText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sectionText);
                            if (textView3 != null) {
                                i = R.id.webview_questionTV;
                                ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.webview_questionTV);
                                if (clickableWebView != null) {
                                    return new SingleRowTestpadNoBinding(linearLayout, linearLayout, imageView, textView, linearLayout2, textView2, relativeLayout, textView3, clickableWebView);
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
