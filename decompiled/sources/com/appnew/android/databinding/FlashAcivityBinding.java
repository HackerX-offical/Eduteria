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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FlashAcivityBinding implements ViewBinding {
    public final ImageView backView;
    public final TextView delete;
    public final ImageView imageBack;
    public final Toolbar mainToolbar;
    public final ImageView moveView;
    public final RelativeLayout progessLayout;
    public final ProgressBar progressValue;
    public final RelativeLayout root;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView setProgress;
    public final TextView toolbarTitleTV;
    public final ViewPager viewPagerBanner;

    private FlashAcivityBinding(RelativeLayout rootView, ImageView backView, TextView delete, ImageView imageBack, Toolbar mainToolbar, ImageView moveView, RelativeLayout progessLayout, ProgressBar progressValue, RelativeLayout root, CheckBox selectAllDelete, TextView setProgress, TextView toolbarTitleTV, ViewPager viewPagerBanner) {
        this.rootView = rootView;
        this.backView = backView;
        this.delete = delete;
        this.imageBack = imageBack;
        this.mainToolbar = mainToolbar;
        this.moveView = moveView;
        this.progessLayout = progessLayout;
        this.progressValue = progressValue;
        this.root = root;
        this.selectAllDelete = selectAllDelete;
        this.setProgress = setProgress;
        this.toolbarTitleTV = toolbarTitleTV;
        this.viewPagerBanner = viewPagerBanner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FlashAcivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FlashAcivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.flash_acivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FlashAcivityBinding bind(View rootView) {
        int i = R.id.back_view;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back_view);
        if (imageView != null) {
            i = R.id.delete;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
            if (textView != null) {
                i = R.id.image_back;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView2 != null) {
                    i = R.id.main_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                    if (toolbar != null) {
                        i = R.id.move_view;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.move_view);
                        if (imageView3 != null) {
                            i = R.id.progess_layout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.progess_layout);
                            if (relativeLayout != null) {
                                i = R.id.progress_value;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progress_value);
                                if (progressBar != null) {
                                    RelativeLayout relativeLayout2 = (RelativeLayout) rootView;
                                    i = R.id.select_all_delete;
                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                    if (checkBox != null) {
                                        i = R.id.setProgress;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.setProgress);
                                        if (textView2 != null) {
                                            i = R.id.toolbarTitleTV;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                            if (textView3 != null) {
                                                i = R.id.viewPager_Banner;
                                                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.viewPager_Banner);
                                                if (viewPager != null) {
                                                    return new FlashAcivityBinding(relativeLayout2, imageView, textView, imageView2, toolbar, imageView3, relativeLayout, progressBar, relativeLayout2, checkBox, textView2, textView3, viewPager);
                                                }
                                            }
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
