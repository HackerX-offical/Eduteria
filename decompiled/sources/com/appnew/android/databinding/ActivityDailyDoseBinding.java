package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDailyDoseBinding implements ViewBinding {
    public final RelativeLayout container;
    public final LinearLayout cvrNotificationCount1;
    public final Toolbar dashboardToolbar;
    public final ImageView gotoCart;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    private final RelativeLayout rootView;
    public final ImageView searchIcon;

    private ActivityDailyDoseBinding(RelativeLayout rootView, RelativeLayout container, LinearLayout cvrNotificationCount1, Toolbar dashboardToolbar, ImageView gotoCart, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ImageView searchIcon) {
        this.rootView = rootView;
        this.container = container;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.dashboardToolbar = dashboardToolbar;
        this.gotoCart = gotoCart;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.searchIcon = searchIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDailyDoseBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDailyDoseBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_daily_dose, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDailyDoseBinding bind(View rootView) {
        int i = R.id.container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.container);
        if (relativeLayout != null) {
            i = R.id.cvrNotificationCount1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
            if (linearLayout != null) {
                i = R.id.dashboardToolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.dashboardToolbar);
                if (toolbar != null) {
                    i = R.id.gotoCart;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.gotoCart);
                    if (imageView != null) {
                        i = R.id.notificaionCount1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                        if (textView != null) {
                            i = R.id.notificationIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                            if (imageView2 != null) {
                                i = R.id.notificationLL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                if (relativeLayout2 != null) {
                                    i = R.id.searchIcon;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIcon);
                                    if (imageView3 != null) {
                                        return new ActivityDailyDoseBinding((RelativeLayout) rootView, relativeLayout, linearLayout, toolbar, imageView, textView, imageView2, relativeLayout2, imageView3);
                                    }
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
