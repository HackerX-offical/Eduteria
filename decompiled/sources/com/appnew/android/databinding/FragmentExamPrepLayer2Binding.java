package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentExamPrepLayer2Binding implements ViewBinding {
    public final FloatingActionButton addRelatedReferenceBtn;
    public final FloatingActionButton addRelatedVideoBtn;
    public final FloatingActionButton addRevisionBtn;
    public final FloatingActionButton addSupport;
    public final FloatingActionMenu allResourceAddMenu;
    public final ImageView downarrowIV;
    public final RelativeLayout dropDownFilter;
    public final RecyclerView examPrepLayerRV;
    public final com.google.android.material.floatingactionbutton.FloatingActionButton floatGoToTop;
    public final FrameLayout parentLL;
    public final ProgressBar progressBar;
    public final ProgressBar progressBarAll;
    public final LinearLayout progressLinearL;
    private final FrameLayout rootView;
    public final Spinner spinner;
    public final TextView spinnerTitle;
    public final RecyclerView tileRv;

    private FragmentExamPrepLayer2Binding(FrameLayout rootView, FloatingActionButton addRelatedReferenceBtn, FloatingActionButton addRelatedVideoBtn, FloatingActionButton addRevisionBtn, FloatingActionButton addSupport, FloatingActionMenu allResourceAddMenu, ImageView downarrowIV, RelativeLayout dropDownFilter, RecyclerView examPrepLayerRV, com.google.android.material.floatingactionbutton.FloatingActionButton floatGoToTop, FrameLayout parentLL, ProgressBar progressBar, ProgressBar progressBarAll, LinearLayout progressLinearL, Spinner spinner, TextView spinnerTitle, RecyclerView tileRv) {
        this.rootView = rootView;
        this.addRelatedReferenceBtn = addRelatedReferenceBtn;
        this.addRelatedVideoBtn = addRelatedVideoBtn;
        this.addRevisionBtn = addRevisionBtn;
        this.addSupport = addSupport;
        this.allResourceAddMenu = allResourceAddMenu;
        this.downarrowIV = downarrowIV;
        this.dropDownFilter = dropDownFilter;
        this.examPrepLayerRV = examPrepLayerRV;
        this.floatGoToTop = floatGoToTop;
        this.parentLL = parentLL;
        this.progressBar = progressBar;
        this.progressBarAll = progressBarAll;
        this.progressLinearL = progressLinearL;
        this.spinner = spinner;
        this.spinnerTitle = spinnerTitle;
        this.tileRv = tileRv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamPrepLayer2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentExamPrepLayer2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_exam_prep_layer2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamPrepLayer2Binding bind(View rootView) {
        int i = R.id.addRelatedReferenceBtn;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addRelatedReferenceBtn);
        if (floatingActionButton != null) {
            i = R.id.addRelatedVideoBtn;
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addRelatedVideoBtn);
            if (floatingActionButton2 != null) {
                i = R.id.addRevisionBtn;
                FloatingActionButton floatingActionButton3 = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addRevisionBtn);
                if (floatingActionButton3 != null) {
                    i = R.id.addSupport;
                    FloatingActionButton floatingActionButton4 = (FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.addSupport);
                    if (floatingActionButton4 != null) {
                        i = R.id.allResourceAddMenu;
                        FloatingActionMenu floatingActionMenu = (FloatingActionMenu) ViewBindings.findChildViewById(rootView, R.id.allResourceAddMenu);
                        if (floatingActionMenu != null) {
                            i = R.id.downarrowIV;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                            if (imageView != null) {
                                i = R.id.dropDown_filter;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.dropDown_filter);
                                if (relativeLayout != null) {
                                    i = R.id.examPrepLayerRV;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.examPrepLayerRV);
                                    if (recyclerView != null) {
                                        i = R.id.floatGoToTop;
                                        com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton5 = (com.google.android.material.floatingactionbutton.FloatingActionButton) ViewBindings.findChildViewById(rootView, R.id.floatGoToTop);
                                        if (floatingActionButton5 != null) {
                                            FrameLayout frameLayout = (FrameLayout) rootView;
                                            i = R.id.progressBar;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                            if (progressBar != null) {
                                                i = R.id.progressBarAll;
                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBarAll);
                                                if (progressBar2 != null) {
                                                    i = R.id.progressLinearL;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.progressLinearL);
                                                    if (linearLayout != null) {
                                                        i = R.id.spinner;
                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(rootView, R.id.spinner);
                                                        if (spinner != null) {
                                                            i = R.id.spinnerTitle;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.spinnerTitle);
                                                            if (textView != null) {
                                                                i = R.id.tileRv;
                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                if (recyclerView2 != null) {
                                                                    return new FragmentExamPrepLayer2Binding(frameLayout, floatingActionButton, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionMenu, imageView, relativeLayout, recyclerView, floatingActionButton5, frameLayout, progressBar, progressBar2, linearLayout, spinner, textView, recyclerView2);
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
