package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.balysv.materialripple.MaterialRippleLayout;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemDragBinding implements ViewBinding {
    public final LinearLayout llmain;
    public final MaterialRippleLayout lytParent;
    public final TextView name;
    public final TextView optionIconTV;
    private final MaterialRippleLayout rootView;

    private ItemDragBinding(MaterialRippleLayout rootView, LinearLayout llmain, MaterialRippleLayout lytParent, TextView name, TextView optionIconTV) {
        this.rootView = rootView;
        this.llmain = llmain;
        this.lytParent = lytParent;
        this.name = name;
        this.optionIconTV = optionIconTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialRippleLayout getRoot() {
        return this.rootView;
    }

    public static ItemDragBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemDragBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_drag, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDragBinding bind(View rootView) {
        int i = R.id.llmain;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llmain);
        if (linearLayout != null) {
            MaterialRippleLayout materialRippleLayout = (MaterialRippleLayout) rootView;
            i = R.id.name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.name);
            if (textView != null) {
                i = R.id.optionIconTV;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.optionIconTV);
                if (textView2 != null) {
                    return new ItemDragBinding(materialRippleLayout, linearLayout, materialRippleLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
