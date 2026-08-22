package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityLanguageBinding implements ViewBinding {
    public final Button btnEnglish;
    public final Button btnHindi;
    private final LinearLayout rootView;

    private ActivityLanguageBinding(LinearLayout rootView, Button btnEnglish, Button btnHindi) {
        this.rootView = rootView;
        this.btnEnglish = btnEnglish;
        this.btnHindi = btnHindi;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLanguageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityLanguageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_language, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityLanguageBinding bind(View rootView) {
        int i = R.id.btnEnglish;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnEnglish);
        if (button != null) {
            i = R.id.btnHindi;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnHindi);
            if (button2 != null) {
                return new ActivityLanguageBinding((LinearLayout) rootView, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
