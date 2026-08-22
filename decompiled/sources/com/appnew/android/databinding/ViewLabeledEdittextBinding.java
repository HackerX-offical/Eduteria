package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewLabeledEdittextBinding implements ViewBinding {
    public final EditText editText;
    public final TextView label;
    private final EditText rootView;

    private ViewLabeledEdittextBinding(EditText rootView, EditText editText, TextView label) {
        this.rootView = rootView;
        this.editText = editText;
        this.label = label;
    }

    @Override // androidx.viewbinding.ViewBinding
    public EditText getRoot() {
        return this.rootView;
    }

    public static ViewLabeledEdittextBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewLabeledEdittextBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_labeled_edittext, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewLabeledEdittextBinding bind(View rootView) {
        EditText editText = (EditText) rootView;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.label);
        if (textView != null) {
            return new ViewLabeledEdittextBinding(editText, editText, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.label)));
    }
}
