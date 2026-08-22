package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentStudentDoubtListBinding implements ViewBinding {
    public final ImageView arrow;
    public final ImageView downarrowIVNew;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final LinearLayout llTopTwo;
    private final RelativeLayout rootView;
    public final RecyclerView studentDoubtRecycler;

    private FragmentStudentDoubtListBinding(RelativeLayout rootView, ImageView arrow, ImageView downarrowIVNew, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, LinearLayout llTopTwo, RecyclerView studentDoubtRecycler) {
        this.rootView = rootView;
        this.arrow = arrow;
        this.downarrowIVNew = downarrowIVNew;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.llTopTwo = llTopTwo;
        this.studentDoubtRecycler = studentDoubtRecycler;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentDoubtListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentStudentDoubtListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_student_doubt_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentDoubtListBinding bind(View rootView) {
        int i = R.id.arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
        if (imageView != null) {
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
                                        i = R.id.studentDoubtRecycler;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studentDoubtRecycler);
                                        if (recyclerView != null) {
                                            return new FragmentStudentDoubtListBinding((RelativeLayout) rootView, imageView, imageView2, relativeLayout, textView, relativeLayout2, textView2, relativeLayout3, linearLayout, recyclerView);
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
