package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentShowAllClassesBinding implements ViewBinding {
    public final TextView authorname;
    public final ImageView courseImagebg;
    public final TextView courseName;
    public final TextView courseid;
    public final RecyclerView examPrepLayerRV;
    public final RelativeLayout headerLL;
    public final LinearLayout imageRL;
    public final LinearLayoutCompat llCompat;
    public final NestedScrollView nestedScroll;
    public final ProgressBar progressBar;
    public final RelativeLayout relativeL;
    public final RelativeLayout relativeLL;
    private final RelativeLayout rootView;
    public final RecyclerView subjectRecyclerView;
    public final RecyclerView tilesRV;
    public final TextView type;
    public final TextView validityTV;

    private FragmentShowAllClassesBinding(RelativeLayout rootView, TextView authorname, ImageView courseImagebg, TextView courseName, TextView courseid, RecyclerView examPrepLayerRV, RelativeLayout headerLL, LinearLayout imageRL, LinearLayoutCompat llCompat, NestedScrollView nestedScroll, ProgressBar progressBar, RelativeLayout relativeL, RelativeLayout relativeLL, RecyclerView subjectRecyclerView, RecyclerView tilesRV, TextView type, TextView validityTV) {
        this.rootView = rootView;
        this.authorname = authorname;
        this.courseImagebg = courseImagebg;
        this.courseName = courseName;
        this.courseid = courseid;
        this.examPrepLayerRV = examPrepLayerRV;
        this.headerLL = headerLL;
        this.imageRL = imageRL;
        this.llCompat = llCompat;
        this.nestedScroll = nestedScroll;
        this.progressBar = progressBar;
        this.relativeL = relativeL;
        this.relativeLL = relativeLL;
        this.subjectRecyclerView = subjectRecyclerView;
        this.tilesRV = tilesRV;
        this.type = type;
        this.validityTV = validityTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentShowAllClassesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentShowAllClassesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_show_all_classes, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentShowAllClassesBinding bind(View rootView) {
        int i = R.id.authorname;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.authorname);
        if (textView != null) {
            i = R.id.courseImagebg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImagebg);
            if (imageView != null) {
                i = R.id.course_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
                if (textView2 != null) {
                    i = R.id.courseid;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseid);
                    if (textView3 != null) {
                        i = R.id.examPrepLayerRV;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.examPrepLayerRV);
                        if (recyclerView != null) {
                            i = R.id.headerLL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.headerLL);
                            if (relativeLayout != null) {
                                i = R.id.imageRL;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                if (linearLayout != null) {
                                    i = R.id.ll_compat;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_compat);
                                    if (linearLayoutCompat != null) {
                                        i = R.id.nested_scroll;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nested_scroll);
                                        if (nestedScrollView != null) {
                                            i = R.id.progressBar;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                            if (progressBar != null) {
                                                i = R.id.relativeL;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeL);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.relativeLL;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeLL);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.subjectRecyclerView;
                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.subjectRecyclerView);
                                                        if (recyclerView2 != null) {
                                                            i = R.id.tilesRV;
                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tilesRV);
                                                            if (recyclerView3 != null) {
                                                                i = R.id.type;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.type);
                                                                if (textView4 != null) {
                                                                    i = R.id.validityTV;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                                    if (textView5 != null) {
                                                                        return new FragmentShowAllClassesBinding((RelativeLayout) rootView, textView, imageView, textView2, textView3, recyclerView, relativeLayout, linearLayout, linearLayoutCompat, nestedScrollView, progressBar, relativeLayout2, relativeLayout3, recyclerView2, recyclerView3, textView4, textView5);
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
