package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCourseListBinding implements ViewBinding {
    public final ImageView filterIV;
    public final FrameLayout frameLayout;
    public final ImageView imageBack;
    public final RelativeLayout layout;
    public final Toolbar mainToolbar;
    public final LinearLayout maincontrolLL;
    public final RecyclerView recyclerView;
    public final RelativeLayout relative;
    public final RelativeLayout relativeL;
    private final LinearLayout rootView;
    public final ImageView searchIV;
    public final SearchView searchSV;
    public final ImageView shareIV;
    public final SearchView svSearch;
    public final TextView toolbarTitleTV;
    public final TextView tvNotification;
    public final TextView unlock;

    private ActivityCourseListBinding(LinearLayout rootView, ImageView filterIV, FrameLayout frameLayout, ImageView imageBack, RelativeLayout layout, Toolbar mainToolbar, LinearLayout maincontrolLL, RecyclerView recyclerView, RelativeLayout relative, RelativeLayout relativeL, ImageView searchIV, SearchView searchSV, ImageView shareIV, SearchView svSearch, TextView toolbarTitleTV, TextView tvNotification, TextView unlock) {
        this.rootView = rootView;
        this.filterIV = filterIV;
        this.frameLayout = frameLayout;
        this.imageBack = imageBack;
        this.layout = layout;
        this.mainToolbar = mainToolbar;
        this.maincontrolLL = maincontrolLL;
        this.recyclerView = recyclerView;
        this.relative = relative;
        this.relativeL = relativeL;
        this.searchIV = searchIV;
        this.searchSV = searchSV;
        this.shareIV = shareIV;
        this.svSearch = svSearch;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvNotification = tvNotification;
        this.unlock = unlock;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCourseListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCourseListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_course_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCourseListBinding bind(View rootView) {
        int i = R.id.filterIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.filterIV);
        if (imageView != null) {
            i = R.id.frame_layout;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.frame_layout);
            if (frameLayout != null) {
                i = R.id.image_back;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                if (imageView2 != null) {
                    i = R.id.layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                    if (relativeLayout != null) {
                        i = R.id.main_toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                        if (toolbar != null) {
                            i = R.id.maincontrolLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maincontrolLL);
                            if (linearLayout != null) {
                                i = R.id.recyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerView);
                                if (recyclerView != null) {
                                    i = R.id.relative;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative);
                                    if (relativeLayout2 != null) {
                                        i = R.id.relativeL;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeL);
                                        if (relativeLayout3 != null) {
                                            i = R.id.searchIV;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                            if (imageView3 != null) {
                                                i = R.id.searchSV;
                                                SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchSV);
                                                if (searchView != null) {
                                                    i = R.id.shareIV;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareIV);
                                                    if (imageView4 != null) {
                                                        i = R.id.sv_search;
                                                        SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                                        if (searchView2 != null) {
                                                            i = R.id.toolbarTitleTV;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                            if (textView != null) {
                                                                i = R.id.tv_notification;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_notification);
                                                                if (textView2 != null) {
                                                                    i = R.id.unlock;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unlock);
                                                                    if (textView3 != null) {
                                                                        return new ActivityCourseListBinding((LinearLayout) rootView, imageView, frameLayout, imageView2, relativeLayout, toolbar, linearLayout, recyclerView, relativeLayout2, relativeLayout3, imageView3, searchView, imageView4, searchView2, textView, textView2, textView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
