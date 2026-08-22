package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityNotificationBinding implements ViewBinding {
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final TextView markasread;
    public final NestedScrollView nestedScroll;
    public final RecyclerView notification;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityNotificationBinding(RelativeLayout rootView, ImageView imageBack, Toolbar mainToolbar, TextView markasread, NestedScrollView nestedScroll, RecyclerView notification, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout root, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.markasread = markasread;
        this.nestedScroll = nestedScroll;
        this.notification = notification;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.root = root;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNotificationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNotificationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_notification, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNotificationBinding bind(View rootView) {
        int i = R.id.image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
        if (imageView != null) {
            i = R.id.main_toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
            if (toolbar != null) {
                i = R.id.markasread;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.markasread);
                if (textView != null) {
                    i = R.id.nested_scroll;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
                    if (nestedScrollView != null) {
                        i = R.id.notification;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.notification);
                        if (recyclerView != null) {
                            i = R.id.progressBar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                            if (progressBar != null) {
                                i = R.id.pullto_referesh;
                                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                if (swipeRefreshLayout != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                    i = R.id.toolbarTitleTV;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                    if (textView2 != null) {
                                        return new ActivityNotificationBinding(relativeLayout, imageView, toolbar, textView, nestedScrollView, recyclerView, progressBar, swipeRefreshLayout, relativeLayout, textView2);
                                    }
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
