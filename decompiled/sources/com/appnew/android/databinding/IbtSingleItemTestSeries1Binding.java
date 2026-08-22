package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtSingleItemTestSeries1Binding implements ViewBinding {
    public final RelativeLayout ibtSingleTestSeriesRL;
    public final ImageView ibtSingleVdIv;
    public final TextView ibtSingleVdTvDay;
    public final TextView ibtSingleVdTvLikes;
    public final TextView ibtSingleVdTvTitle;
    private final RelativeLayout rootView;

    private IbtSingleItemTestSeries1Binding(RelativeLayout rootView, RelativeLayout ibtSingleTestSeriesRL, ImageView ibtSingleVdIv, TextView ibtSingleVdTvDay, TextView ibtSingleVdTvLikes, TextView ibtSingleVdTvTitle) {
        this.rootView = rootView;
        this.ibtSingleTestSeriesRL = ibtSingleTestSeriesRL;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.ibtSingleVdTvLikes = ibtSingleVdTvLikes;
        this.ibtSingleVdTvTitle = ibtSingleVdTvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtSingleItemTestSeries1Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtSingleItemTestSeries1Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_single_item_test_series1, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtSingleItemTestSeries1Binding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.ibt_single_vd_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
        if (imageView != null) {
            i = R.id.ibt_single_vd_tv_day;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
            if (textView != null) {
                i = R.id.ibt_single_vd_tv_likes;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_likes);
                if (textView2 != null) {
                    i = R.id.ibt_single_vd_tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_title);
                    if (textView3 != null) {
                        return new IbtSingleItemTestSeries1Binding(relativeLayout, relativeLayout, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
