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
public final class FragmentChildCategoryBinding implements ViewBinding {
    public final TextView choseTxt;
    private final RelativeLayout rootView;
    public final TextView selectTxt;
    public final RecyclerView subCatRecyclerview;

    private FragmentChildCategoryBinding(RelativeLayout rootView, TextView choseTxt, TextView selectTxt, RecyclerView subCatRecyclerview) {
        this.rootView = rootView;
        this.choseTxt = choseTxt;
        this.selectTxt = selectTxt;
        this.subCatRecyclerview = subCatRecyclerview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentChildCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentChildCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_child_category, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentChildCategoryBinding bind(View rootView) {
        int i = R.id.chose_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.chose_txt);
        if (textView != null) {
            i = R.id.select_txt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_txt);
            if (textView2 != null) {
                i = R.id.sub_cat_recyclerview;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.sub_cat_recyclerview);
                if (recyclerView != null) {
                    return new FragmentChildCategoryBinding((RelativeLayout) rootView, textView, textView2, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
