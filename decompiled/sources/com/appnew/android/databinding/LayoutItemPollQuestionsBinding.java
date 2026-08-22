package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LayoutItemPollQuestionsBinding implements ViewBinding {
    public final LinearLayoutCompat cvrOption;
    public final TextView options;
    private final RelativeLayout rootView;
    public final TextView txtOptionNumber;

    private LayoutItemPollQuestionsBinding(RelativeLayout rootView, LinearLayoutCompat cvrOption, TextView options, TextView txtOptionNumber) {
        this.rootView = rootView;
        this.cvrOption = cvrOption;
        this.options = options;
        this.txtOptionNumber = txtOptionNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemPollQuestionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LayoutItemPollQuestionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_item_poll_questions, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutItemPollQuestionsBinding bind(View rootView) {
        int i = R.id.cvrOption;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrOption);
        if (linearLayoutCompat != null) {
            i = R.id.options;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.options);
            if (textView != null) {
                i = R.id.txtOptionNumber;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtOptionNumber);
                if (textView2 != null) {
                    return new LayoutItemPollQuestionsBinding((RelativeLayout) rootView, linearLayoutCompat, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
