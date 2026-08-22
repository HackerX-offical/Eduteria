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
import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class HelpQueryBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final RecyclerView chatList;
    public final FloatingActionButton floatingButton;
    public final ImageView imageIV;
    public final Toolbar myProgressToolbar;
    private final RelativeLayout rootView;
    public final TextView toolbartitleTV;

    private HelpQueryBinding(RelativeLayout rootView, AppBarLayout appBarLayout, RecyclerView chatList, FloatingActionButton floatingButton, ImageView imageIV, Toolbar myProgressToolbar, TextView toolbartitleTV) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.chatList = chatList;
        this.floatingButton = floatingButton;
        this.imageIV = imageIV;
        this.myProgressToolbar = myProgressToolbar;
        this.toolbartitleTV = toolbartitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HelpQueryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HelpQueryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.help_query, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HelpQueryBinding bind(View rootView) {
        int i = R.id.app_bar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(rootView, R.id.app_bar_layout);
        if (appBarLayout != null) {
            i = R.id.chat_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.chat_list);
            if (recyclerView != null) {
                i = R.id.floating_button;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.floating_button);
                if (floatingActionButton != null) {
                    i = R.id.imageIV;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                    if (imageView != null) {
                        i = R.id.myProgress_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.myProgress_toolbar);
                        if (toolbar != null) {
                            i = R.id.toolbartitleTV;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                            if (textView != null) {
                                return new HelpQueryBinding((RelativeLayout) rootView, appBarLayout, recyclerView, floatingActionButton, imageView, toolbar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
