package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtFragmentPracticeChildBinding implements ViewBinding {
    public final RecyclerView fragmentPracticeChildRV1;
    public final RecyclerView fragmentPracticeChildRV2;
    public final RelativeLayout mainParentLL;
    private final RelativeLayout rootView;

    private IbtFragmentPracticeChildBinding(RelativeLayout rootView, RecyclerView fragmentPracticeChildRV1, RecyclerView fragmentPracticeChildRV2, RelativeLayout mainParentLL) {
        this.rootView = rootView;
        this.fragmentPracticeChildRV1 = fragmentPracticeChildRV1;
        this.fragmentPracticeChildRV2 = fragmentPracticeChildRV2;
        this.mainParentLL = mainParentLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtFragmentPracticeChildBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentPracticeChildBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_practice_child, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentPracticeChildBinding bind(View rootView) {
        int i = R.id.fragment_practice_child_RV1;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.fragment_practice_child_RV1);
        if (recyclerView != null) {
            i = R.id.fragment_practice_child_RV2;
            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.fragment_practice_child_RV2);
            if (recyclerView2 != null) {
                i = R.id.mainParentLL;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainParentLL);
                if (relativeLayout != null) {
                    return new IbtFragmentPracticeChildBinding((RelativeLayout) rootView, recyclerView, recyclerView2, relativeLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
