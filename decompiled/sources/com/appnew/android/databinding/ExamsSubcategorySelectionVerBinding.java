package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamsSubcategorySelectionVerBinding implements ViewBinding {
    public final ImageView examsCategoryIV;
    public final LinearLayout examsCategoryMainLL;
    public final TextView examsCategorySubtitleTV;
    public final TextView examsCategoryTitleTV;
    private final RelativeLayout rootView;

    private ExamsSubcategorySelectionVerBinding(RelativeLayout rootView, ImageView examsCategoryIV, LinearLayout examsCategoryMainLL, TextView examsCategorySubtitleTV, TextView examsCategoryTitleTV) {
        this.rootView = rootView;
        this.examsCategoryIV = examsCategoryIV;
        this.examsCategoryMainLL = examsCategoryMainLL;
        this.examsCategorySubtitleTV = examsCategorySubtitleTV;
        this.examsCategoryTitleTV = examsCategoryTitleTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamsSubcategorySelectionVerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamsSubcategorySelectionVerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exams_subcategory_selection_ver, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamsSubcategorySelectionVerBinding bind(View rootView) {
        int i = R.id.examsCategoryIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.examsCategoryIV);
        if (imageView != null) {
            i = R.id.examsCategoryMainLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.examsCategoryMainLL);
            if (linearLayout != null) {
                i = R.id.examsCategorySubtitleTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examsCategorySubtitleTV);
                if (textView != null) {
                    i = R.id.examsCategoryTitleTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.examsCategoryTitleTV);
                    if (textView2 != null) {
                        return new ExamsSubcategorySelectionVerBinding((RelativeLayout) rootView, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
