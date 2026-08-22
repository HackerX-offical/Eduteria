package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityTestSeriesBinding implements ViewBinding {
    public final DynamicBottomBarBinding bottomMenu;
    public final TextView desc;
    public final ImageView filterIV;
    public final ImageView imageBack;
    public final ImageView imageMyCourses;
    public final RelativeLayout layout;
    public final Toolbar mainToolbar;
    public final LinearLayout maincontrolLL;
    public final LinearLayout myCoursesLL;
    public final NoDataFoundBinding noDataFound;
    public final ProgressBar progressBar;
    public final RecyclerView recycler;
    private final RelativeLayout rootView;
    public final ImageView searchIV;
    public final SearchView searchSV;
    public final ImageView shareIV;
    public final SearchView svSearch;
    public final RecyclerView textRecycler;
    public final TextView title;
    public final TextView toolbarTitleTV;
    public final TextView tvNotification;

    private ActivityTestSeriesBinding(RelativeLayout rootView, DynamicBottomBarBinding bottomMenu, TextView desc, ImageView filterIV, ImageView imageBack, ImageView imageMyCourses, RelativeLayout layout, Toolbar mainToolbar, LinearLayout maincontrolLL, LinearLayout myCoursesLL, NoDataFoundBinding noDataFound, ProgressBar progressBar, RecyclerView recycler, ImageView searchIV, SearchView searchSV, ImageView shareIV, SearchView svSearch, RecyclerView textRecycler, TextView title, TextView toolbarTitleTV, TextView tvNotification) {
        this.rootView = rootView;
        this.bottomMenu = bottomMenu;
        this.desc = desc;
        this.filterIV = filterIV;
        this.imageBack = imageBack;
        this.imageMyCourses = imageMyCourses;
        this.layout = layout;
        this.mainToolbar = mainToolbar;
        this.maincontrolLL = maincontrolLL;
        this.myCoursesLL = myCoursesLL;
        this.noDataFound = noDataFound;
        this.progressBar = progressBar;
        this.recycler = recycler;
        this.searchIV = searchIV;
        this.searchSV = searchSV;
        this.shareIV = shareIV;
        this.svSearch = svSearch;
        this.textRecycler = textRecycler;
        this.title = title;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvNotification = tvNotification;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTestSeriesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityTestSeriesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_test_series, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTestSeriesBinding bind(View rootView) {
        int i = R.id.bottom_menu;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
        if (viewFindChildViewById != null) {
            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
            i = R.id.desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
            if (textView != null) {
                i = R.id.filterIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.filterIV);
                if (imageView != null) {
                    i = R.id.image_back;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                    if (imageView2 != null) {
                        i = R.id.imageMyCourses;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageMyCourses);
                        if (imageView3 != null) {
                            i = R.id.layout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                            if (relativeLayout != null) {
                                i = R.id.mainToolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.mainToolbar);
                                if (toolbar != null) {
                                    i = R.id.maincontrolLL;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maincontrolLL);
                                    if (linearLayout != null) {
                                        i = R.id.myCoursesLL;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.myCoursesLL);
                                        if (linearLayout2 != null) {
                                            i = R.id.noDataFound;
                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.noDataFound);
                                            if (viewFindChildViewById2 != null) {
                                                NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById2);
                                                i = R.id.progressBar;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                if (progressBar != null) {
                                                    i = R.id.recycler;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler);
                                                    if (recyclerView != null) {
                                                        i = R.id.searchIV;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                        if (imageView4 != null) {
                                                            i = R.id.searchSV;
                                                            SearchView searchView = (SearchView) ViewBindings.findChildViewById(rootView, R.id.searchSV);
                                                            if (searchView != null) {
                                                                i = R.id.shareIV;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareIV);
                                                                if (imageView5 != null) {
                                                                    i = R.id.sv_search;
                                                                    SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(rootView, R.id.sv_search);
                                                                    if (searchView2 != null) {
                                                                        i = R.id.textRecycler;
                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.textRecycler);
                                                                        if (recyclerView2 != null) {
                                                                            i = R.id.title;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                            if (textView2 != null) {
                                                                                i = R.id.toolbarTitleTV;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.tv_notification;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_notification);
                                                                                    if (textView4 != null) {
                                                                                        return new ActivityTestSeriesBinding((RelativeLayout) rootView, dynamicBottomBarBindingBind, textView, imageView, imageView2, imageView3, relativeLayout, toolbar, linearLayout, linearLayout2, noDataFoundBindingBind, progressBar, recyclerView, imageView4, searchView, imageView5, searchView2, recyclerView2, textView2, textView3, textView4);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
