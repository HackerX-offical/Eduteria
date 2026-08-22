package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SubscriptionPlanNewBinding implements ViewBinding {
    public final LinearLayout mainLay;
    private final RelativeLayout rootView;
    public final TextView subscriptionAmount;
    public final TextView subscriptionBenefits;
    public final WebView subscriptionDescription;
    public final RecyclerView subscriptionPlanRecycler;
    public final RelativeLayout subscriptionRelativeLayout;

    private SubscriptionPlanNewBinding(RelativeLayout rootView, LinearLayout mainLay, TextView subscriptionAmount, TextView subscriptionBenefits, WebView subscriptionDescription, RecyclerView subscriptionPlanRecycler, RelativeLayout subscriptionRelativeLayout) {
        this.rootView = rootView;
        this.mainLay = mainLay;
        this.subscriptionAmount = subscriptionAmount;
        this.subscriptionBenefits = subscriptionBenefits;
        this.subscriptionDescription = subscriptionDescription;
        this.subscriptionPlanRecycler = subscriptionPlanRecycler;
        this.subscriptionRelativeLayout = subscriptionRelativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SubscriptionPlanNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SubscriptionPlanNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.subscription_plan_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SubscriptionPlanNewBinding bind(View rootView) {
        int i = R.id.mainLay;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainLay);
        if (linearLayout != null) {
            i = R.id.subscription_amount;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscription_amount);
            if (textView != null) {
                i = R.id.subscriptionBenefits;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscriptionBenefits);
                if (textView2 != null) {
                    i = R.id.subscriptionDescription;
                    WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.subscriptionDescription);
                    if (webView != null) {
                        i = R.id.subscriptionPlanRecycler;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.subscriptionPlanRecycler);
                        if (recyclerView != null) {
                            i = R.id.subscriptionRelativeLayout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subscriptionRelativeLayout);
                            if (relativeLayout != null) {
                                return new SubscriptionPlanNewBinding((RelativeLayout) rootView, linearLayout, textView, textView2, webView, recyclerView, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
