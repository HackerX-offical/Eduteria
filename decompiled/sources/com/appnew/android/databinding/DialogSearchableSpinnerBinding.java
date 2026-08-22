package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogSearchableSpinnerBinding implements ViewBinding {
    public final EditText editText;
    public final ListView listView;
    private final LinearLayout rootView;

    private DialogSearchableSpinnerBinding(LinearLayout rootView, EditText editText, ListView listView) {
        this.rootView = rootView;
        this.editText = editText;
        this.listView = listView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogSearchableSpinnerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogSearchableSpinnerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_searchable_spinner, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSearchableSpinnerBinding bind(View rootView) {
        int i = R.id.edit_text;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.edit_text);
        if (editText != null) {
            i = R.id.list_view;
            ListView listView = (ListView) ViewBindings.findChildViewById(rootView, R.id.list_view);
            if (listView != null) {
                return new DialogSearchableSpinnerBinding((LinearLayout) rootView, editText, listView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
