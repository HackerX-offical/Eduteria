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
public final class ItemOptionBinding implements ViewBinding {
    public final ImageView correctAnswer;
    public final EditText enterOptionEt;
    public final RelativeLayout optionLayout;
    public final TextView optionNumber;
    public final TextView remove;
    private final RelativeLayout rootView;

    private ItemOptionBinding(RelativeLayout rootView, ImageView correctAnswer, EditText enterOptionEt, RelativeLayout optionLayout, TextView optionNumber, TextView remove) {
        this.rootView = rootView;
        this.correctAnswer = correctAnswer;
        this.enterOptionEt = enterOptionEt;
        this.optionLayout = optionLayout;
        this.optionNumber = optionNumber;
        this.remove = remove;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemOptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemOptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_option, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemOptionBinding bind(View rootView) {
        int i = R.id.correctAnswer;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.correctAnswer);
        if (imageView != null) {
            i = R.id.enterOptionEt;
            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.enterOptionEt);
            if (editText != null) {
                i = R.id.optionLayout;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.optionLayout);
                if (relativeLayout != null) {
                    i = R.id.optionNumber;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionNumber);
                    if (textView != null) {
                        i = R.id.remove;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remove);
                        if (textView2 != null) {
                            return new ItemOptionBinding((RelativeLayout) rootView, imageView, editText, relativeLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
