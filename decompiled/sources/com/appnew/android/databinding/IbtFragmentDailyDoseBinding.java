package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtFragmentDailyDoseBinding implements ViewBinding {
    public final RecyclerView dailyDoseRV;
    public final SwipeRefreshLayout fragStudySRL;
    public final TextView noDailyDoseFoundTV;
    private final RelativeLayout rootView;

    private IbtFragmentDailyDoseBinding(RelativeLayout rootView, RecyclerView dailyDoseRV, SwipeRefreshLayout fragStudySRL, TextView noDailyDoseFoundTV) {
        this.rootView = rootView;
        this.dailyDoseRV = dailyDoseRV;
        this.fragStudySRL = fragStudySRL;
        this.noDailyDoseFoundTV = noDailyDoseFoundTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtFragmentDailyDoseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtFragmentDailyDoseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_fragment_daily_dose, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtFragmentDailyDoseBinding bind(View rootView) {
        int i = R.id.dailyDoseRV;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.dailyDoseRV);
        if (recyclerView != null) {
            i = R.id.frag_studySRL;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.frag_studySRL);
            if (swipeRefreshLayout != null) {
                i = R.id.noDailyDoseFoundTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.noDailyDoseFoundTV);
                if (textView != null) {
                    return new IbtFragmentDailyDoseBinding((RelativeLayout) rootView, recyclerView, swipeRefreshLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
