package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public final class PurchaseHistoryActivityBinding implements ViewBinding {
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final NestedScrollView nestedScroll;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RecyclerView purchaseHistory;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView toolbarTitleTV;

    private PurchaseHistoryActivityBinding(RelativeLayout rootView, TextView delete, ImageView imageBack, Toolbar mainToolbar, NestedScrollView nestedScroll, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RecyclerView purchaseHistory, RelativeLayout root, CheckBox selectAllDelete, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.nestedScroll = nestedScroll;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.purchaseHistory = purchaseHistory;
        this.root = root;
        this.selectAllDelete = selectAllDelete;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PurchaseHistoryActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PurchaseHistoryActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.purchase_history_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PurchaseHistoryActivityBinding bind(View rootView) {
        int i = R.id.delete;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
        if (textView != null) {
            i = R.id.image_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
            if (imageView != null) {
                i = R.id.main_toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                if (toolbar != null) {
                    i = R.id.nested_scroll;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
                    if (nestedScrollView != null) {
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                        if (progressBar != null) {
                            i = R.id.pullto_referesh;
                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                            if (swipeRefreshLayout != null) {
                                i = R.id.purchase_history;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.purchase_history);
                                if (recyclerView != null) {
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                                    i = R.id.select_all_delete;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                    if (checkBox != null) {
                                        i = R.id.toolbarTitleTV;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                        if (textView2 != null) {
                                            return new PurchaseHistoryActivityBinding(relativeLayout, textView, imageView, toolbar, nestedScrollView, progressBar, swipeRefreshLayout, recyclerView, relativeLayout, checkBox, textView2);
                                        }
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
