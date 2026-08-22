package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ConceptScreenBinding implements ViewBinding {
    public final ImageView back;
    public final TextView conceptName;
    public final ImageView notesIV;
    private final LinearLayout rootView;
    public final TextView txt;

    private ConceptScreenBinding(LinearLayout rootView, ImageView back, TextView conceptName, ImageView notesIV, TextView txt) {
        this.rootView = rootView;
        this.back = back;
        this.conceptName = conceptName;
        this.notesIV = notesIV;
        this.txt = txt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConceptScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ConceptScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.concept_screen, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ConceptScreenBinding bind(View rootView) {
        int i = R.id.back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.back);
        if (imageView != null) {
            i = R.id.concept_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.concept_name);
            if (textView != null) {
                i = R.id.notesIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notesIV);
                if (imageView2 != null) {
                    i = R.id.txt;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt);
                    if (textView2 != null) {
                        return new ConceptScreenBinding((LinearLayout) rootView, imageView, textView, imageView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
