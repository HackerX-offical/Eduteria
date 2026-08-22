package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SmeHomeLayoutBinding implements ViewBinding {
    public final TextView cartCount;
    public final LinearLayout cvrNotificationCount1;
    public final Toolbar dashboardToolbar;
    public final FragmentContainerView fragmentContainerView;
    public final ImageView gotoCart;
    public final LinearLayout linearGotoCart;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final RelativeLayout relativeGotoCart;
    private final ConstraintLayout rootView;
    public final ImageView searchIcon;
    public final ConstraintLayout smeHomeLayout;

    private SmeHomeLayoutBinding(ConstraintLayout rootView, TextView cartCount, LinearLayout cvrNotificationCount1, Toolbar dashboardToolbar, FragmentContainerView fragmentContainerView, ImageView gotoCart, LinearLayout linearGotoCart, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, RelativeLayout relativeGotoCart, ImageView searchIcon, ConstraintLayout smeHomeLayout) {
        this.rootView = rootView;
        this.cartCount = cartCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.dashboardToolbar = dashboardToolbar;
        this.fragmentContainerView = fragmentContainerView;
        this.gotoCart = gotoCart;
        this.linearGotoCart = linearGotoCart;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.relativeGotoCart = relativeGotoCart;
        this.searchIcon = searchIcon;
        this.smeHomeLayout = smeHomeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SmeHomeLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SmeHomeLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.sme_home_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SmeHomeLayoutBinding bind(View rootView) {
        int i = R.id.cart_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.cart_count);
        if (textView != null) {
            i = R.id.cvrNotificationCount1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
            if (linearLayout != null) {
                i = R.id.dashboardToolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.dashboardToolbar);
                if (toolbar != null) {
                    i = R.id.fragmentContainerView;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(rootView, R.id.fragmentContainerView);
                    if (fragmentContainerView != null) {
                        i = R.id.gotoCart;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.gotoCart);
                        if (imageView != null) {
                            i = R.id.linear_gotoCart;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.linear_gotoCart);
                            if (linearLayout2 != null) {
                                i = R.id.notificaionCount1;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                if (textView2 != null) {
                                    i = R.id.notificationIV;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                    if (imageView2 != null) {
                                        i = R.id.notificationLL;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                        if (relativeLayout != null) {
                                            i = R.id.relative_gotoCart;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relative_gotoCart);
                                            if (relativeLayout2 != null) {
                                                i = R.id.searchIcon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIcon);
                                                if (imageView3 != null) {
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                    return new SmeHomeLayoutBinding(constraintLayout, textView, linearLayout, toolbar, fragmentContainerView, imageView, linearLayout2, textView2, imageView2, relativeLayout, relativeLayout2, imageView3, constraintLayout);
                                                }
                                            }
                                        }
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
