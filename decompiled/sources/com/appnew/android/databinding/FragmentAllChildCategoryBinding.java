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
public final class FragmentAllChildCategoryBinding implements ViewBinding {
    public final TextView choseTxt;
    private final RelativeLayout rootView;
    public final RecyclerView subCatRecyclerview;

    private FragmentAllChildCategoryBinding(RelativeLayout rootView, TextView choseTxt, RecyclerView subCatRecyclerview) {
        this.rootView = rootView;
        this.choseTxt = choseTxt;
        this.subCatRecyclerview = subCatRecyclerview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAllChildCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentAllChildCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_all_child_category, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAllChildCategoryBinding bind(View rootView) {
        int i = R.id.chose_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.chose_txt);
        if (textView != null) {
            i = R.id.sub_cat_recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.sub_cat_recyclerview);
            if (recyclerView != null) {
                return new FragmentAllChildCategoryBinding((RelativeLayout) rootView, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
