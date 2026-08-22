package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Courses.Activity.ObservableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityNewconceptBinding implements ViewBinding {
    public final ImageView actionTextFormate;
    public final View borderView;
    public final ObservableWebView chapterContentWebview;
    public final TextView chapterNameTxt;
    public final ImageView ivBack;
    public final TextView nameLabel;
    public final RelativeLayout nextChapterLayout;
    public final AppCompatImageView nextImageView;
    public final ImageView notesIV;
    public final SwipeRefreshLayout readSwipeRefresh;
    public final Toolbar readchaptertoolbar;
    public final ImageView refresh;
    private final RelativeLayout rootView;
    public final TextView toolbarTitleTV;

    private ActivityNewconceptBinding(RelativeLayout rootView, ImageView actionTextFormate, View borderView, ObservableWebView chapterContentWebview, TextView chapterNameTxt, ImageView ivBack, TextView nameLabel, RelativeLayout nextChapterLayout, AppCompatImageView nextImageView, ImageView notesIV, SwipeRefreshLayout readSwipeRefresh, Toolbar readchaptertoolbar, ImageView refresh, TextView toolbarTitleTV) {
        this.rootView = rootView;
        this.actionTextFormate = actionTextFormate;
        this.borderView = borderView;
        this.chapterContentWebview = chapterContentWebview;
        this.chapterNameTxt = chapterNameTxt;
        this.ivBack = ivBack;
        this.nameLabel = nameLabel;
        this.nextChapterLayout = nextChapterLayout;
        this.nextImageView = nextImageView;
        this.notesIV = notesIV;
        this.readSwipeRefresh = readSwipeRefresh;
        this.readchaptertoolbar = readchaptertoolbar;
        this.refresh = refresh;
        this.toolbarTitleTV = toolbarTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNewconceptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityNewconceptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_newconcept, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityNewconceptBinding bind(View rootView) {
        int i = R.id.action_text_formate;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.action_text_formate);
        if (imageView != null) {
            i = R.id.borderView;
            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.borderView);
            if (viewFindChildViewById != null) {
                i = R.id.chapter_content_webview;
                ObservableWebView observableWebView = (ObservableWebView) ViewBindings.findChildViewById(rootView, R.id.chapter_content_webview);
                if (observableWebView != null) {
                    i = R.id.chapterNameTxt;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.chapterNameTxt);
                    if (textView != null) {
                        i = R.id.iv_back;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                        if (imageView2 != null) {
                            i = R.id.nameLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameLabel);
                            if (textView2 != null) {
                                i = R.id.nextChapterLayout;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.nextChapterLayout);
                                if (relativeLayout != null) {
                                    i = R.id.nextImageView;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.nextImageView);
                                    if (appCompatImageView != null) {
                                        i = R.id.notesIV;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notesIV);
                                        if (imageView3 != null) {
                                            i = R.id.read_swipe_refresh;
                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.read_swipe_refresh);
                                            if (swipeRefreshLayout != null) {
                                                i = R.id.readchaptertoolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.readchaptertoolbar);
                                                if (toolbar != null) {
                                                    i = R.id.refresh;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.refresh);
                                                    if (imageView4 != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView3 != null) {
                                                            return new ActivityNewconceptBinding((RelativeLayout) rootView, imageView, viewFindChildViewById, observableWebView, textView, imageView2, textView2, relativeLayout, appCompatImageView, imageView3, swipeRefreshLayout, toolbar, imageView4, textView3);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
