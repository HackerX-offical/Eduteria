package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCoursesClassesBinding implements ViewBinding {
    public final RecyclerView educatorRecyclerView1;
    public final TextView filterTextName;
    public final ImageView filterVideo;
    public final NestedScrollView nestedScrollEducator;
    public final ProgressBar progressBar;
    public final LinearLayout progressLinearL;
    private final FrameLayout rootView;

    private FragmentCoursesClassesBinding(FrameLayout rootView, RecyclerView educatorRecyclerView1, TextView filterTextName, ImageView filterVideo, NestedScrollView nestedScrollEducator, ProgressBar progressBar, LinearLayout progressLinearL) {
        this.rootView = rootView;
        this.educatorRecyclerView1 = educatorRecyclerView1;
        this.filterTextName = filterTextName;
        this.filterVideo = filterVideo;
        this.nestedScrollEducator = nestedScrollEducator;
        this.progressBar = progressBar;
        this.progressLinearL = progressLinearL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCoursesClassesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCoursesClassesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_courses_classes, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCoursesClassesBinding bind(View rootView) {
        int i = R.id.educatorRecyclerView1;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.educatorRecyclerView1);
        if (recyclerView != null) {
            i = R.id.filterText_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterText_name);
            if (textView != null) {
                i = R.id.filterVideo;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.filterVideo);
                if (imageView != null) {
                    i = R.id.nested_scroll_educator;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll_educator);
                    if (nestedScrollView != null) {
                        i = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                        if (progressBar != null) {
                            i = R.id.progressLinearL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.progressLinearL);
                            if (linearLayout != null) {
                                return new FragmentCoursesClassesBinding((FrameLayout) rootView, recyclerView, textView, imageView, nestedScrollView, progressBar, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
