package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityNoticeboardBinding implements ViewBinding {
    public final Toolbar mainToolbar;
    public final ImageView noticeboardBackButton;
    public final RecyclerView noticeboardList;
    private final LinearLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityNoticeboardBinding(LinearLayout rootView, Toolbar mainToolbar, ImageView noticeboardBackButton, RecyclerView noticeboardList, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.mainToolbar = mainToolbar;
        this.noticeboardBackButton = noticeboardBackButton;
        this.noticeboardList = noticeboardList;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNoticeboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNoticeboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_noticeboard, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNoticeboardBinding bind(View rootView) {
        int i = R.id.main_toolbar;
        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
        if (toolbar != null) {
            i = R.id.noticeboardBackButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.noticeboardBackButton);
            if (imageView != null) {
                i = R.id.noticeboardList;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.noticeboardList);
                if (recyclerView != null) {
                    i = R.id.toolbarTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                    if (textView != null) {
                        return new ActivityNoticeboardBinding((LinearLayout) rootView, toolbar, imageView, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
