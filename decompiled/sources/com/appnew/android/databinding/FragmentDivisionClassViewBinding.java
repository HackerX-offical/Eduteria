package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentDivisionClassViewBinding implements ViewBinding {
    public final RecyclerView prefrenceRecyclerview;
    private final LinearLayout rootView;
    public final TextView title;
    public final ImageView viewTop;

    private FragmentDivisionClassViewBinding(LinearLayout rootView, RecyclerView prefrenceRecyclerview, TextView title, ImageView viewTop) {
        this.rootView = rootView;
        this.prefrenceRecyclerview = prefrenceRecyclerview;
        this.title = title;
        this.viewTop = viewTop;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDivisionClassViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentDivisionClassViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_division_class_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentDivisionClassViewBinding bind(View rootView) {
        int i = R.id.prefrence_recyclerview;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.prefrence_recyclerview);
        if (recyclerView != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
            if (textView != null) {
                i = R.id.viewTop;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.viewTop);
                if (imageView != null) {
                    return new FragmentDivisionClassViewBinding((LinearLayout) rootView, recyclerView, textView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
