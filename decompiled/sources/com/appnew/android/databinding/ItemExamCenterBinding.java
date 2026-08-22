package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemExamCenterBinding implements ViewBinding {
    public final CheckBox checkBox;
    public final TextView examCenterText;
    public final RelativeLayout mainRl;
    private final RelativeLayout rootView;

    private ItemExamCenterBinding(RelativeLayout rootView, CheckBox checkBox, TextView examCenterText, RelativeLayout mainRl) {
        this.rootView = rootView;
        this.checkBox = checkBox;
        this.examCenterText = examCenterText;
        this.mainRl = mainRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamCenterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemExamCenterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_exam_center, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamCenterBinding bind(View rootView) {
        int i = R.id.check_box;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.check_box);
        if (checkBox != null) {
            i = R.id.exam_center_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exam_center_text);
            if (textView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) rootView;
                return new ItemExamCenterBinding(relativeLayout, checkBox, textView, relativeLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
