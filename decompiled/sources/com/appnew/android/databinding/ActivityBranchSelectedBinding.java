package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityBranchSelectedBinding implements ViewBinding {
    public final RelativeLayout btnpcd;
    public final Button buttonProceed;
    public final RecyclerView createTestRV;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final RelativeLayout parentLL;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityBranchSelectedBinding(RelativeLayout rootView, RelativeLayout btnpcd, Button buttonProceed, RecyclerView createTestRV, ImageView imageBack, Toolbar mainToolbar, RelativeLayout parentLL, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.btnpcd = btnpcd;
        this.buttonProceed = buttonProceed;
        this.createTestRV = createTestRV;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.parentLL = parentLL;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBranchSelectedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityBranchSelectedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_branch_selected, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBranchSelectedBinding bind(View rootView) {
        int i = R.id.btnpcd;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.btnpcd);
        if (relativeLayout != null) {
            i = R.id.buttonProceed;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buttonProceed);
            if (button != null) {
                i = R.id.createTestRV;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.createTestRV);
                if (recyclerView != null) {
                    i = R.id.image_back;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                    if (imageView != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.parentLL;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                            if (relativeLayout2 != null) {
                                i = R.id.toolbarTitleTV;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                if (textView != null) {
                                    return new ActivityBranchSelectedBinding((RelativeLayout) rootView, relativeLayout, button, recyclerView, imageView, toolbar, relativeLayout2, textView);
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
