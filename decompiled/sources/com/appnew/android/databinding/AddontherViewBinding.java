package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AddontherViewBinding implements ViewBinding {
    public final EditText description;
    public final RelativeLayout questionLayout;
    private final RelativeLayout rootView;
    public final EditText termsEdittext;

    private AddontherViewBinding(RelativeLayout rootView, EditText description, RelativeLayout questionLayout, EditText termsEdittext) {
        this.rootView = rootView;
        this.description = description;
        this.questionLayout = questionLayout;
        this.termsEdittext = termsEdittext;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AddontherViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AddontherViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.addonther_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AddontherViewBinding bind(View rootView) {
        int i = R.id.description;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.description);
        if (editText != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(rootView, R.id.terms_edittext);
            if (editText2 != null) {
                return new AddontherViewBinding(relativeLayout, editText, relativeLayout, editText2);
            }
            i = R.id.terms_edittext;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
