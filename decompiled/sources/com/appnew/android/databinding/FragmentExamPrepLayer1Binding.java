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
public final class FragmentExamPrepLayer1Binding implements ViewBinding {
    public final RecyclerView examPrepLayerRV;
    public final RelativeLayout parentLL;
    private final RelativeLayout rootView;

    private FragmentExamPrepLayer1Binding(RelativeLayout rootView, RecyclerView examPrepLayerRV, RelativeLayout parentLL) {
        this.rootView = rootView;
        this.examPrepLayerRV = examPrepLayerRV;
        this.parentLL = parentLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamPrepLayer1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentExamPrepLayer1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_exam_prep_layer1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamPrepLayer1Binding bind(View rootView) {
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.examPrepLayerRV);
        if (recyclerView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            return new FragmentExamPrepLayer1Binding(relativeLayout, recyclerView, relativeLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.examPrepLayerRV)));
    }
}
