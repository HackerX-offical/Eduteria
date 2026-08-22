package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentVideoBookMarkBinding implements ViewBinding {
    public final Button backBtn;
    public final ImageView image;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final ProgressBar progressBar;
    private final FrameLayout rootView;
    public final RecyclerView videoBookmarkListRecycler;

    private FragmentVideoBookMarkBinding(FrameLayout rootView, Button backBtn, ImageView image, TextView noData, RelativeLayout noDataFoundRL, ProgressBar progressBar, RecyclerView videoBookmarkListRecycler) {
        this.rootView = rootView;
        this.backBtn = backBtn;
        this.image = image;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.progressBar = progressBar;
        this.videoBookmarkListRecycler = videoBookmarkListRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVideoBookMarkBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentVideoBookMarkBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_video_book_mark, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVideoBookMarkBinding bind(View rootView) {
        int i = R.id.backBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
        if (button != null) {
            i = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
            if (imageView != null) {
                i = R.id.no_data;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                if (textView != null) {
                    i = R.id.no_data_found_RL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                    if (relativeLayout != null) {
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                        if (progressBar != null) {
                            i = R.id.video_bookmarkList_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.video_bookmarkList_recycler);
                            if (recyclerView != null) {
                                return new FragmentVideoBookMarkBinding((FrameLayout) rootView, button, imageView, textView, relativeLayout, progressBar, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
