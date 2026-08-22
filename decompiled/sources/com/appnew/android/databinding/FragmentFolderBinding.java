package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentFolderBinding implements ViewBinding {
    public final RecyclerView fileRecycler;
    public final RecyclerView folderRecycler;
    public final NestedScrollView nesterScollView;
    public final NoDataFoundBinding noData;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pullToRefresh;
    private final RelativeLayout rootView;
    public final EditText search;
    public final ImageView searchIV;
    public final RelativeLayout searchRl;

    private FragmentFolderBinding(RelativeLayout rootView, RecyclerView fileRecycler, RecyclerView folderRecycler, NestedScrollView nesterScollView, NoDataFoundBinding noData, ProgressBar progressBar, SwipeRefreshLayout pullToRefresh, EditText search, ImageView searchIV, RelativeLayout searchRl) {
        this.rootView = rootView;
        this.fileRecycler = fileRecycler;
        this.folderRecycler = folderRecycler;
        this.nesterScollView = nesterScollView;
        this.noData = noData;
        this.progressBar = progressBar;
        this.pullToRefresh = pullToRefresh;
        this.search = search;
        this.searchIV = searchIV;
        this.searchRl = searchRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFolderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentFolderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_folder, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentFolderBinding bind(View rootView) {
        int i = R.id.file_recycler;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.file_recycler);
        if (recyclerView != null) {
            i = R.id.folder_recycler;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.folder_recycler);
            if (recyclerView2 != null) {
                i = R.id.nesterScollView;
                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nesterScollView);
                if (nestedScrollView != null) {
                    i = R.id.noData;
                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.noData);
                    if (viewFindChildViewById != null) {
                        NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById);
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                        if (progressBar != null) {
                            i = R.id.pullToRefresh;
                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullToRefresh);
                            if (swipeRefreshLayout != null) {
                                i = R.id.search;
                                EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.search);
                                if (editText != null) {
                                    i = R.id.searchIV;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                    if (imageView != null) {
                                        i = R.id.searchRl;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.searchRl);
                                        if (relativeLayout != null) {
                                            return new FragmentFolderBinding((RelativeLayout) rootView, recyclerView, recyclerView2, nestedScrollView, noDataFoundBindingBind, progressBar, swipeRefreshLayout, editText, imageView, relativeLayout);
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
