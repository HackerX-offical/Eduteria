package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrefrenceItemAdapterBinding implements ViewBinding {
    public final TextView categoryName;
    public final TextView categorySubitem;
    public final RelativeLayout container;
    public final ImageView logo;
    private final CardView rootView;
    public final ImageView selectionLogo;

    private ExamPrefrenceItemAdapterBinding(CardView rootView, TextView categoryName, TextView categorySubitem, RelativeLayout container, ImageView logo, ImageView selectionLogo) {
        this.rootView = rootView;
        this.categoryName = categoryName;
        this.categorySubitem = categorySubitem;
        this.container = container;
        this.logo = logo;
        this.selectionLogo = selectionLogo;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ExamPrefrenceItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrefrenceItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prefrence_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrefrenceItemAdapterBinding bind(View rootView) {
        int i = R.id.category_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_name);
        if (textView != null) {
            i = R.id.category_subitem;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.category_subitem);
            if (textView2 != null) {
                i = R.id.container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.container);
                if (relativeLayout != null) {
                    i = R.id.logo;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.logo);
                    if (imageView != null) {
                        i = R.id.selection_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.selection_logo);
                        if (imageView2 != null) {
                            return new ExamPrefrenceItemAdapterBinding((CardView) rootView, textView, textView2, relativeLayout, imageView, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
