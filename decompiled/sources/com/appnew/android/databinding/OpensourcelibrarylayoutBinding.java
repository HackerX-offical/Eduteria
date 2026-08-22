package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class OpensourcelibrarylayoutBinding implements ViewBinding {
    public final ImageView ivBack;
    public final TextView libheaderdesctext;
    public final TextView libheadertext;
    public final RecyclerView libusedlist;
    public final Toolbar oslibactionbar;
    private final RelativeLayout rootView;
    public final TextView toolbartitleTV;

    private OpensourcelibrarylayoutBinding(RelativeLayout rootView, ImageView ivBack, TextView libheaderdesctext, TextView libheadertext, RecyclerView libusedlist, Toolbar oslibactionbar, TextView toolbartitleTV) {
        this.rootView = rootView;
        this.ivBack = ivBack;
        this.libheaderdesctext = libheaderdesctext;
        this.libheadertext = libheadertext;
        this.libusedlist = libusedlist;
        this.oslibactionbar = oslibactionbar;
        this.toolbartitleTV = toolbartitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OpensourcelibrarylayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static OpensourcelibrarylayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.opensourcelibrarylayout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static OpensourcelibrarylayoutBinding bind(View rootView) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
        if (imageView != null) {
            i = R.id.libheaderdesctext;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.libheaderdesctext);
            if (textView != null) {
                i = R.id.libheadertext;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.libheadertext);
                if (textView2 != null) {
                    i = R.id.libusedlist;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.libusedlist);
                    if (recyclerView != null) {
                        i = R.id.oslibactionbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.oslibactionbar);
                        if (toolbar != null) {
                            i = R.id.toolbartitleTV;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                            if (textView3 != null) {
                                return new OpensourcelibrarylayoutBinding((RelativeLayout) rootView, imageView, textView, textView2, recyclerView, toolbar, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
