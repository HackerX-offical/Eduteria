package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMyDoubtBinding implements ViewBinding {
    public final FloatingActionButton addDoubtFloatingButton;
    public final ImageView arrow;
    public final Button backBtn;
    public final RecyclerView doubtSubjects;
    public final ImageView downarrowIVNew;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final ImageView image;
    public final LinearLayout llTopTwo;
    public final RecyclerView mydoubtListRecycler;
    public final TextView noData;
    public final RelativeLayout noDataFoundRL;
    public final SwipeRefreshLayout pulltoReferesh;
    private final ConstraintLayout rootView;

    private FragmentMyDoubtBinding(ConstraintLayout rootView, FloatingActionButton addDoubtFloatingButton, ImageView arrow, Button backBtn, RecyclerView doubtSubjects, ImageView downarrowIVNew, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, ImageView image, LinearLayout llTopTwo, RecyclerView mydoubtListRecycler, TextView noData, RelativeLayout noDataFoundRL, SwipeRefreshLayout pulltoReferesh) {
        this.rootView = rootView;
        this.addDoubtFloatingButton = addDoubtFloatingButton;
        this.arrow = arrow;
        this.backBtn = backBtn;
        this.doubtSubjects = doubtSubjects;
        this.downarrowIVNew = downarrowIVNew;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.image = image;
        this.llTopTwo = llTopTwo;
        this.mydoubtListRecycler = mydoubtListRecycler;
        this.noData = noData;
        this.noDataFoundRL = noDataFoundRL;
        this.pulltoReferesh = pulltoReferesh;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMyDoubtBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentMyDoubtBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_my_doubt, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMyDoubtBinding bind(View rootView) {
        int i = R.id.addDoubt_floatingButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addDoubt_floatingButton);
        if (floatingActionButton != null) {
            i = R.id.arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
            if (imageView != null) {
                i = R.id.backBtn;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.backBtn);
                if (button != null) {
                    i = R.id.doubt_subjects;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.doubt_subjects);
                    if (recyclerView != null) {
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
                                                i = R.id.image;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                                if (imageView3 != null) {
                                                    i = R.id.ll_top_two;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                    if (linearLayout != null) {
                                                        i = R.id.mydoubt_list_recycler;
                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.mydoubt_list_recycler);
                                                        if (recyclerView2 != null) {
                                                            i = R.id.no_data;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                                            if (textView3 != null) {
                                                                i = R.id.no_data_found_RL;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.no_data_found_RL);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.pullto_referesh;
                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                    if (swipeRefreshLayout != null) {
                                                                        return new FragmentMyDoubtBinding((ConstraintLayout) rootView, floatingActionButton, imageView, button, recyclerView, imageView2, relativeLayout, textView, relativeLayout2, textView2, relativeLayout3, imageView3, linearLayout, recyclerView2, textView3, relativeLayout4, swipeRefreshLayout);
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
