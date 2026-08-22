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
public final class CategoryItemAdapterBinding implements ViewBinding {
    public final TextView categoryCount;
    public final TextView categoryName;
    public final ImageView checkBox;
    public final ImageView dropDownIV;
    public final LinearLayout lowerViewItem;
    public final RecyclerView mainCatRecycler;
    public final LinearLayout parentLL;
    private final LinearLayout rootView;
    public final RelativeLayout schoolCat;

    private CategoryItemAdapterBinding(LinearLayout rootView, TextView categoryCount, TextView categoryName, ImageView checkBox, ImageView dropDownIV, LinearLayout lowerViewItem, RecyclerView mainCatRecycler, LinearLayout parentLL, RelativeLayout schoolCat) {
        this.rootView = rootView;
        this.categoryCount = categoryCount;
        this.categoryName = categoryName;
        this.checkBox = checkBox;
        this.dropDownIV = dropDownIV;
        this.lowerViewItem = lowerViewItem;
        this.mainCatRecycler = mainCatRecycler;
        this.parentLL = parentLL;
        this.schoolCat = schoolCat;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CategoryItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CategoryItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.category_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CategoryItemAdapterBinding bind(View rootView) {
        int i = R.id.category_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_count);
        if (textView != null) {
            i = R.id.category_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_name);
            if (textView2 != null) {
                i = R.id.checkBox;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.checkBox);
                if (imageView != null) {
                    i = R.id.dropDownIV;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.dropDownIV);
                    if (imageView2 != null) {
                        i = R.id.lowerViewItem;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.lowerViewItem);
                        if (linearLayout != null) {
                            i = R.id.main_cat_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.main_cat_recycler);
                            if (recyclerView != null) {
                                i = R.id.parentLL;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentLL);
                                if (linearLayout2 != null) {
                                    i = R.id.school_cat;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.school_cat);
                                    if (relativeLayout != null) {
                                        return new CategoryItemAdapterBinding((LinearLayout) rootView, textView, textView2, imageView, imageView2, linearLayout, recyclerView, linearLayout2, relativeLayout);
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
