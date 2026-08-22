package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MainCatViewBinding implements ViewBinding {
    public final TextView categoryCount;
    public final TextView categoryName;
    public final ImageView dropDownIV;
    public final RelativeLayout layout;
    public final LinearLayout parentLL;
    private final LinearLayout rootView;
    public final RecyclerView subCatRecycler;
    public final View view1;

    private MainCatViewBinding(LinearLayout rootView, TextView categoryCount, TextView categoryName, ImageView dropDownIV, RelativeLayout layout, LinearLayout parentLL, RecyclerView subCatRecycler, View view1) {
        this.rootView = rootView;
        this.categoryCount = categoryCount;
        this.categoryName = categoryName;
        this.dropDownIV = dropDownIV;
        this.layout = layout;
        this.parentLL = parentLL;
        this.subCatRecycler = subCatRecycler;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static MainCatViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static MainCatViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.main_cat_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainCatViewBinding bind(View rootView) {
        int i = R.id.category_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_count);
        if (textView != null) {
            i = R.id.category_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_name);
            if (textView2 != null) {
                i = R.id.dropDownIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dropDownIV);
                if (imageView != null) {
                    i = R.id.layout;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout);
                    if (relativeLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.sub_cat_recycler;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.sub_cat_recycler);
                        if (recyclerView != null) {
                            i = R.id.view1;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                            if (viewFindChildViewById != null) {
                                return new MainCatViewBinding(linearLayout, textView, textView2, imageView, relativeLayout, linearLayout, recyclerView, viewFindChildViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
