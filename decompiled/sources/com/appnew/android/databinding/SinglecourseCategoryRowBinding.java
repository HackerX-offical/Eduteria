package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SinglecourseCategoryRowBinding implements ViewBinding {
    public final RecyclerView categoryRV;
    public final Button courseCatseeAllBtn;
    public final LinearLayout coursesoptionLL;
    private final LinearLayout rootView;
    public final RelativeLayout topViewItem;
    public final TextView tv1;

    private SinglecourseCategoryRowBinding(LinearLayout rootView, RecyclerView categoryRV, Button courseCatseeAllBtn, LinearLayout coursesoptionLL, RelativeLayout topViewItem, TextView tv1) {
        this.rootView = rootView;
        this.categoryRV = categoryRV;
        this.courseCatseeAllBtn = courseCatseeAllBtn;
        this.coursesoptionLL = coursesoptionLL;
        this.topViewItem = topViewItem;
        this.tv1 = tv1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SinglecourseCategoryRowBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SinglecourseCategoryRowBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.singlecourse_category_row, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SinglecourseCategoryRowBinding bind(View rootView) {
        int i = R.id.categoryRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.categoryRV);
        if (recyclerView != null) {
            i = R.id.courseCatseeAllBtn;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.courseCatseeAllBtn);
            if (button != null) {
                i = R.id.coursesoptionLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.coursesoptionLL);
                if (linearLayout != null) {
                    i = R.id.topViewItem;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.topViewItem);
                    if (relativeLayout != null) {
                        i = R.id.tv1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv1);
                        if (textView != null) {
                            return new SinglecourseCategoryRowBinding((LinearLayout) rootView, recyclerView, button, linearLayout, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
