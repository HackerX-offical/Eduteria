package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SubCatViewBinding implements ViewBinding {
    public final TextView count;
    public final LinearLayout parentLL;
    private final LinearLayout rootView;
    public final CheckBox selectCB;
    public final TextView subCatName;
    public final View view1;

    private SubCatViewBinding(LinearLayout rootView, TextView count, LinearLayout parentLL, CheckBox selectCB, TextView subCatName, View view1) {
        this.rootView = rootView;
        this.count = count;
        this.parentLL = parentLL;
        this.selectCB = selectCB;
        this.subCatName = subCatName;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SubCatViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SubCatViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.sub_cat_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SubCatViewBinding bind(View rootView) {
        int i = R.id.count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.count);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.selectCB;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.selectCB);
            if (checkBox != null) {
                i = R.id.sub_cat_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.sub_cat_name);
                if (textView2 != null) {
                    i = R.id.view1;
                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                    if (viewFindChildViewById != null) {
                        return new SubCatViewBinding(linearLayout, textView, linearLayout, checkBox, textView2, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
