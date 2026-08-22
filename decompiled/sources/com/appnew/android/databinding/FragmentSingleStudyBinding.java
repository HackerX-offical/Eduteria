package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSingleStudyBinding implements ViewBinding {
    public final RelativeLayout RLSingleStudy;
    public final NestedScrollView nestedScrollView;
    public final ProgressBar paginationLoader;
    public final NoDataFound1Binding rlNoData;
    private final RelativeLayout rootView;
    public final RecyclerView studyCourseRV;
    public final RecyclerView studyCourseRVContent;
    public final RecyclerView studyCourseRVTile;
    public final ExamPrepHeaderBinding viewHeader;

    private FragmentSingleStudyBinding(RelativeLayout rootView, RelativeLayout RLSingleStudy, NestedScrollView nestedScrollView, ProgressBar paginationLoader, NoDataFound1Binding rlNoData, RecyclerView studyCourseRV, RecyclerView studyCourseRVContent, RecyclerView studyCourseRVTile, ExamPrepHeaderBinding viewHeader) {
        this.rootView = rootView;
        this.RLSingleStudy = RLSingleStudy;
        this.nestedScrollView = nestedScrollView;
        this.paginationLoader = paginationLoader;
        this.rlNoData = rlNoData;
        this.studyCourseRV = studyCourseRV;
        this.studyCourseRVContent = studyCourseRVContent;
        this.studyCourseRVTile = studyCourseRVTile;
        this.viewHeader = viewHeader;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSingleStudyBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentSingleStudyBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_single_study, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSingleStudyBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.nestedScrollView;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.nestedScrollView);
        if (nestedScrollView != null) {
            i = R.id.paginationLoader;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.paginationLoader);
            if (progressBar != null) {
                i = R.id.rl_no_data;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rl_no_data);
                if (viewFindChildViewById != null) {
                    NoDataFound1Binding noDataFound1BindingBind = NoDataFound1Binding.bind(viewFindChildViewById);
                    i = R.id.studyCourseRV;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studyCourseRV);
                    if (recyclerView != null) {
                        i = R.id.studyCourseRVContent;
                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studyCourseRVContent);
                        if (recyclerView2 != null) {
                            i = R.id.studyCourseRVTile;
                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.studyCourseRVTile);
                            if (recyclerView3 != null) {
                                i = R.id.view_header;
                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_header);
                                if (viewFindChildViewById2 != null) {
                                    return new FragmentSingleStudyBinding(relativeLayout, relativeLayout, nestedScrollView, progressBar, noDataFound1BindingBind, recyclerView, recyclerView2, recyclerView3, ExamPrepHeaderBinding.bind(viewFindChildViewById2));
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
