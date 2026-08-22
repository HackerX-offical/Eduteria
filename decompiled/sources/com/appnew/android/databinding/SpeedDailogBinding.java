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
public final class SpeedDailogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tv1080;
    public final TextView tv720;
    public final TextView tvHighRes;
    public final TextView tvLarge;
    public final TextView tvMedium;
    public final TextView tvSmall;
    public final TextView tvVarySmall;

    private SpeedDailogBinding(LinearLayout rootView, TextView tv1080, TextView tv720, TextView tvHighRes, TextView tvLarge, TextView tvMedium, TextView tvSmall, TextView tvVarySmall) {
        this.rootView = rootView;
        this.tv1080 = tv1080;
        this.tv720 = tv720;
        this.tvHighRes = tvHighRes;
        this.tvLarge = tvLarge;
        this.tvMedium = tvMedium;
        this.tvSmall = tvSmall;
        this.tvVarySmall = tvVarySmall;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SpeedDailogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpeedDailogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.speed_dailog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SpeedDailogBinding bind(View rootView) {
        int i = R.id.tv1080;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv1080);
        if (textView != null) {
            i = R.id.tv720;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv720);
            if (textView2 != null) {
                i = R.id.tvHighRes;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvHighRes);
                if (textView3 != null) {
                    i = R.id.tvLarge;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvLarge);
                    if (textView4 != null) {
                        i = R.id.tvMedium;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvMedium);
                        if (textView5 != null) {
                            i = R.id.tvSmall;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvSmall);
                            if (textView6 != null) {
                                i = R.id.tvVarySmall;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvVarySmall);
                                if (textView7 != null) {
                                    return new SpeedDailogBinding((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
