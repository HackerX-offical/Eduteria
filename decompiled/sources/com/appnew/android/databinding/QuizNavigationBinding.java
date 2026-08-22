package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class QuizNavigationBinding implements ViewBinding {
    public final ImageView counterIV;
    private final LinearLayout rootView;

    private QuizNavigationBinding(LinearLayout rootView, ImageView counterIV) {
        this.rootView = rootView;
        this.counterIV = counterIV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static QuizNavigationBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizNavigationBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_navigation, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizNavigationBinding bind(View rootView) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.counterIV);
        if (imageView != null) {
            return new QuizNavigationBinding((LinearLayout) rootView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.counterIV)));
    }
}
