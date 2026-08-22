package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LibusedlistitemBinding implements ViewBinding {
    public final TextView libdesctext;
    public final TextView libnametext;
    private final RelativeLayout rootView;
    public final View view1;

    private LibusedlistitemBinding(RelativeLayout rootView, TextView libdesctext, TextView libnametext, View view1) {
        this.rootView = rootView;
        this.libdesctext = libdesctext;
        this.libnametext = libnametext;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LibusedlistitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LibusedlistitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.libusedlistitem, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LibusedlistitemBinding bind(View rootView) {
        int i = R.id.libdesctext;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.libdesctext);
        if (textView != null) {
            i = R.id.libnametext;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.libnametext);
            if (textView2 != null) {
                i = R.id.view1;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                if (viewFindChildViewById != null) {
                    return new LibusedlistitemBinding((RelativeLayout) rootView, textView, textView2, viewFindChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
