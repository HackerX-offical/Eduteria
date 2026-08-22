package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.navigation.NavigationView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDashboardTheme4Binding implements ViewBinding {
    public final AppBarDashboardBinding dashBoardMain;
    public final DrawerLayout drawerLayout;
    public final FrameLayout forchatbot;
    public final LinearLayout navHeaderLL;
    public final LinearLayout navHeaderRL;
    public final RecyclerView navRV;
    public final NavigationView navView;
    public final TextView profileEmail;
    public final CircleImageView profileImage;
    public final ImageView profileImageText;
    public final TextView profileName;
    private final DrawerLayout rootView;
    public final TextView vNameTV;

    private ActivityDashboardTheme4Binding(DrawerLayout rootView, AppBarDashboardBinding dashBoardMain, DrawerLayout drawerLayout, FrameLayout forchatbot, LinearLayout navHeaderLL, LinearLayout navHeaderRL, RecyclerView navRV, NavigationView navView, TextView profileEmail, CircleImageView profileImage, ImageView profileImageText, TextView profileName, TextView vNameTV) {
        this.rootView = rootView;
        this.dashBoardMain = dashBoardMain;
        this.drawerLayout = drawerLayout;
        this.forchatbot = forchatbot;
        this.navHeaderLL = navHeaderLL;
        this.navHeaderRL = navHeaderRL;
        this.navRV = navRV;
        this.navView = navView;
        this.profileEmail = profileEmail;
        this.profileImage = profileImage;
        this.profileImageText = profileImageText;
        this.profileName = profileName;
        this.vNameTV = vNameTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDashboardTheme4Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDashboardTheme4Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_dashboard_theme4, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDashboardTheme4Binding bind(View rootView) {
        int i = R.id.dashBoardMain;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dashBoardMain);
        if (viewFindChildViewById != null) {
            AppBarDashboardBinding appBarDashboardBindingBind = AppBarDashboardBinding.bind(viewFindChildViewById);
            DrawerLayout drawerLayout = (DrawerLayout) rootView;
            i = R.id.forchatbot;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.forchatbot);
            if (frameLayout != null) {
                i = R.id.nav_headerLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerLL);
                if (linearLayout != null) {
                    i = R.id.nav_headerRL;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.nav_headerRL);
                    if (linearLayout2 != null) {
                        i = R.id.navRV;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.navRV);
                        if (recyclerView != null) {
                            i = R.id.nav_view;
                            NavigationView navigationView = (NavigationView) ViewBindings.findChildViewById(rootView, R.id.nav_view);
                            if (navigationView != null) {
                                i = R.id.profileEmail;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileEmail);
                                if (textView != null) {
                                    i = R.id.profileImage;
                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                    if (circleImageView != null) {
                                        i = R.id.profileImageText;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageText);
                                        if (imageView != null) {
                                            i = R.id.profileName;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileName);
                                            if (textView2 != null) {
                                                i = R.id.vNameTV;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.vNameTV);
                                                if (textView3 != null) {
                                                    return new ActivityDashboardTheme4Binding(drawerLayout, appBarDashboardBindingBind, drawerLayout, frameLayout, linearLayout, linearLayout2, recyclerView, navigationView, textView, circleImageView, imageView, textView2, textView3);
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
