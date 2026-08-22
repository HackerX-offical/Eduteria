package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepSubitemBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView row11TV;

    private ExamPrepSubitemBinding(RelativeLayout rootView, TextView row11TV) {
        this.rootView = rootView;
        this.row11TV = row11TV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSubitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSubitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_subitem, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSubitemBinding bind(View rootView) {
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.row1_1TV);
        if (textView != null) {
            return new ExamPrepSubitemBinding((RelativeLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.row1_1TV)));
    }
}
