package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySignInBinding implements ViewBinding {
    public final RelativeLayout LoginRL;
    public final TextView LoginText;
    public final LinearLayout activitySignIn;
    public final LinearLayout fourFragmentLayout;
    public final ImageView ivBack;
    public final LinearLayout llToolbar;
    public final ImageView loginImage;
    public final LinearLayout loginLL;
    public final TextView loginMessage;
    private final ScrollView rootView;
    public final TextView signInTextView;
    public final LinearLayout signInUpLayout;
    public final LinearLayout signLL;
    public final TextView signUpTextView;
    public final TabLayout tabanimTabs;
    public final ViewPager tabanimViewpager;

    private ActivitySignInBinding(ScrollView rootView, RelativeLayout LoginRL, TextView LoginText, LinearLayout activitySignIn, LinearLayout fourFragmentLayout, ImageView ivBack, LinearLayout llToolbar, ImageView loginImage, LinearLayout loginLL, TextView loginMessage, TextView signInTextView, LinearLayout signInUpLayout, LinearLayout signLL, TextView signUpTextView, TabLayout tabanimTabs, ViewPager tabanimViewpager) {
        this.rootView = rootView;
        this.LoginRL = LoginRL;
        this.LoginText = LoginText;
        this.activitySignIn = activitySignIn;
        this.fourFragmentLayout = fourFragmentLayout;
        this.ivBack = ivBack;
        this.llToolbar = llToolbar;
        this.loginImage = loginImage;
        this.loginLL = loginLL;
        this.loginMessage = loginMessage;
        this.signInTextView = signInTextView;
        this.signInUpLayout = signInUpLayout;
        this.signLL = signLL;
        this.signUpTextView = signUpTextView;
        this.tabanimTabs = tabanimTabs;
        this.tabanimViewpager = tabanimViewpager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ActivitySignInBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivitySignInBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_sign_in, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySignInBinding bind(View rootView) {
        int i = R.id.LoginRL;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.LoginRL);
        if (relativeLayout != null) {
            i = R.id.LoginText;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.LoginText);
            if (textView != null) {
                i = R.id.activity_sign_in;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.activity_sign_in);
                if (linearLayout != null) {
                    i = R.id.fourFragmentLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.fourFragmentLayout);
                    if (linearLayout2 != null) {
                        i = R.id.iv_back;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                        if (imageView != null) {
                            i = R.id.ll_toolbar;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_toolbar);
                            if (linearLayout3 != null) {
                                i = R.id.login_image;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.login_image);
                                if (imageView2 != null) {
                                    i = R.id.loginLL;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.loginLL);
                                    if (linearLayout4 != null) {
                                        i = R.id.loginMessage;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.loginMessage);
                                        if (textView2 != null) {
                                            i = R.id.signInTextView;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.signInTextView);
                                            if (textView3 != null) {
                                                i = R.id.signInUpLayout;
                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.signInUpLayout);
                                                if (linearLayout5 != null) {
                                                    i = R.id.signLL;
                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.signLL);
                                                    if (linearLayout6 != null) {
                                                        i = R.id.signUpTextView;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.signUpTextView);
                                                        if (textView4 != null) {
                                                            i = R.id.tabanim_tabs;
                                                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(rootView, R.id.tabanim_tabs);
                                                            if (tabLayout != null) {
                                                                i = R.id.tabanim_viewpager;
                                                                ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(rootView, R.id.tabanim_viewpager);
                                                                if (viewPager != null) {
                                                                    return new ActivitySignInBinding((ScrollView) rootView, relativeLayout, textView, linearLayout, linearLayout2, imageView, linearLayout3, imageView2, linearLayout4, textView2, textView3, linearLayout5, linearLayout6, textView4, tabLayout, viewPager);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
