package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCourseDetailsTheme1Binding implements ViewBinding {
    public final LinearLayout bottomLL;
    public final RecyclerView idRVUsers;
    private final LinearLayout rootView;

    private FragmentCourseDetailsTheme1Binding(LinearLayout rootView, LinearLayout bottomLL, RecyclerView idRVUsers) {
        this.rootView = rootView;
        this.bottomLL = bottomLL;
        this.idRVUsers = idRVUsers;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCourseDetailsTheme1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCourseDetailsTheme1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_course_details_theme1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCourseDetailsTheme1Binding bind(View rootView) {
        int i = R.id.bottomLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottomLL);
        if (linearLayout != null) {
            i = R.id.idRVUsers;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.idRVUsers);
            if (recyclerView != null) {
                return new FragmentCourseDetailsTheme1Binding((LinearLayout) rootView, linearLayout, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
