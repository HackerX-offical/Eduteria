package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCourseBinding implements ViewBinding {
    public final RecyclerView courseListRV;
    public final TextView errorTV;
    private final RelativeLayout rootView;

    private FragmentCourseBinding(RelativeLayout rootView, RecyclerView courseListRV, TextView errorTV) {
        this.rootView = rootView;
        this.courseListRV = courseListRV;
        this.errorTV = errorTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCourseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCourseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_course, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCourseBinding bind(View rootView) {
        int i = R.id.courseListRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
        if (recyclerView != null) {
            i = R.id.errorTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTV);
            if (textView != null) {
                return new FragmentCourseBinding((RelativeLayout) rootView, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
