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
public final class FragmentMainCategoryBinding implements ViewBinding {
    public final TextView choseTxt;
    public final RecyclerView mainCatRecyclerview;
    private final RelativeLayout rootView;
    public final TextView selectTxt;

    private FragmentMainCategoryBinding(RelativeLayout rootView, TextView choseTxt, RecyclerView mainCatRecyclerview, TextView selectTxt) {
        this.rootView = rootView;
        this.choseTxt = choseTxt;
        this.mainCatRecyclerview = mainCatRecyclerview;
        this.selectTxt = selectTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentMainCategoryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentMainCategoryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_main_category, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentMainCategoryBinding bind(View rootView) {
        int i = R.id.chose_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.chose_txt);
        if (textView != null) {
            i = R.id.main_cat_recyclerview;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.main_cat_recyclerview);
            if (recyclerView != null) {
                i = R.id.select_txt;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.select_txt);
                if (textView2 != null) {
                    return new FragmentMainCategoryBinding((RelativeLayout) rootView, textView, recyclerView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
