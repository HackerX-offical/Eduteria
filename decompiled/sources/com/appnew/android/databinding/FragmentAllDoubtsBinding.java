package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentAllDoubtsBinding implements ViewBinding {
    public final FloatingActionButton addDoubtFloatingButton;
    public final ImageView arrow;
    public final RecyclerView doubtListRecycler;
    public final RecyclerView doubtSubjects;
    public final ImageView downarrowIVNew;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final LinearLayout llTopTwo;
    public final NestedScrollView nestedScrollView;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoRefereshDoubtAll;
    private final ConstraintLayout rootView;

    private FragmentAllDoubtsBinding(ConstraintLayout rootView, FloatingActionButton addDoubtFloatingButton, ImageView arrow, RecyclerView doubtListRecycler, RecyclerView doubtSubjects, ImageView downarrowIVNew, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, LinearLayout llTopTwo, NestedScrollView nestedScrollView, ProgressBar progressBar, SwipeRefreshLayout pulltoRefereshDoubtAll) {
        this.rootView = rootView;
        this.addDoubtFloatingButton = addDoubtFloatingButton;
        this.arrow = arrow;
        this.doubtListRecycler = doubtListRecycler;
        this.doubtSubjects = doubtSubjects;
        this.downarrowIVNew = downarrowIVNew;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.llTopTwo = llTopTwo;
        this.nestedScrollView = nestedScrollView;
        this.progressBar = progressBar;
        this.pulltoRefereshDoubtAll = pulltoRefereshDoubtAll;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAllDoubtsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAllDoubtsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_all_doubts, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAllDoubtsBinding bind(View rootView) {
        int i = R.id.addDoubt_floatingButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addDoubt_floatingButton);
        if (floatingActionButton != null) {
            i = R.id.arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
            if (imageView != null) {
                i = R.id.doubt_list_recycler;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.doubt_list_recycler);
                if (recyclerView != null) {
                    i = R.id.doubt_subjects;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.doubt_subjects);
                    if (recyclerView2 != null) {
                        i = R.id.downarrowIV_new;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                        if (imageView2 != null) {
                            i = R.id.filter;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                            if (relativeLayout != null) {
                                i = R.id.filterOne;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                if (textView != null) {
                                    i = R.id.filter_one_click;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                    if (relativeLayout2 != null) {
                                        i = R.id.filterTwo;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                        if (textView2 != null) {
                                            i = R.id.filter_two_click;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                            if (relativeLayout3 != null) {
                                                i = R.id.ll_top_two;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                if (linearLayout != null) {
                                                    i = R.id.nestedScrollView;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nestedScrollView);
                                                    if (nestedScrollView != null) {
                                                        i = R.id.progressBar;
                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                        if (progressBar != null) {
                                                            i = R.id.pullto_referesh_doubtAll;
                                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh_doubtAll);
                                                            if (swipeRefreshLayout != null) {
                                                                return new FragmentAllDoubtsBinding((ConstraintLayout) rootView, floatingActionButton, imageView, recyclerView, recyclerView2, imageView2, relativeLayout, textView, relativeLayout2, textView2, relativeLayout3, linearLayout, nestedScrollView, progressBar, swipeRefreshLayout);
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
