package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomRewardListBinding implements ViewBinding {
    public final TextView rewordCount;
    public final TextView rewordPoint;
    public final TextView rewordPointTime;
    private final LinearLayout rootView;

    private CustomRewardListBinding(LinearLayout rootView, TextView rewordCount, TextView rewordPoint, TextView rewordPointTime) {
        this.rootView = rootView;
        this.rewordCount = rewordCount;
        this.rewordPoint = rewordPoint;
        this.rewordPointTime = rewordPointTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomRewardListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomRewardListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_reward_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomRewardListBinding bind(View rootView) {
        int i = R.id.rewordCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.rewordCount);
        if (textView != null) {
            i = R.id.rewordPoint;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rewordPoint);
            if (textView2 != null) {
                i = R.id.rewordPointTime;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rewordPointTime);
                if (textView3 != null) {
                    return new CustomRewardListBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
