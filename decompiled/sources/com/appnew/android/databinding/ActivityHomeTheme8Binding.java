package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.navigation.NavigationView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityHomeTheme8Binding implements ViewBinding {
    public final AppBarDashboard8Binding dashBoardMain;
    public final DrawerLayout drawerLayout;
    public final FrameLayout forchatbot;
    public final ImageView iconFacebook;
    public final ImageView iconInstagram;
    public final ImageView iconLinkedIn;
    public final ImageView iconTelegram;
    public final ImageView iconTwitter;
    public final ImageView iconWebsite;
    public final ImageView iconYoutube;
    public final LinearLayout navHeaderLL;
    public final LinearLayout navHeaderRL;
    public final RecyclerView navRV;
    public final NavigationView navView;
    public final TextView profileEmail;
    public final CircleImageView profileImage;
    public final ImageView profileImageText;
    public final TextView profileName;
    public final CoordinatorLayout rootView;
    private final CoordinatorLayout rootView_;
    public final LinearLayout socialIconLL;
    public final TextView vNameTV;

    private ActivityHomeTheme8Binding(CoordinatorLayout rootView_, AppBarDashboard8Binding dashBoardMain, DrawerLayout drawerLayout, FrameLayout forchatbot, ImageView iconFacebook, ImageView iconInstagram, ImageView iconLinkedIn, ImageView iconTelegram, ImageView iconTwitter, ImageView iconWebsite, ImageView iconYoutube, LinearLayout navHeaderLL, LinearLayout navHeaderRL, RecyclerView navRV, NavigationView navView, TextView profileEmail, CircleImageView profileImage, ImageView profileImageText, TextView profileName, CoordinatorLayout rootView, LinearLayout socialIconLL, TextView vNameTV) {
        this.rootView_ = rootView_;
        this.dashBoardMain = dashBoardMain;
        this.drawerLayout = drawerLayout;
        this.forchatbot = forchatbot;
        this.iconFacebook = iconFacebook;
        this.iconInstagram = iconInstagram;
        this.iconLinkedIn = iconLinkedIn;
        this.iconTelegram = iconTelegram;
        this.iconTwitter = iconTwitter;
        this.iconWebsite = iconWebsite;
        this.iconYoutube = iconYoutube;
        this.navHeaderLL = navHeaderLL;
        this.navHeaderRL = navHeaderRL;
        this.navRV = navRV;
        this.navView = navView;
        this.profileEmail = profileEmail;
        this.profileImage = profileImage;
        this.profileImageText = profileImageText;
        this.profileName = profileName;
        this.rootView = rootView;
        this.socialIconLL = socialIconLL;
        this.vNameTV = vNameTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityHomeTheme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityHomeTheme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_home_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHomeTheme8Binding bind(View rootView) {
        int i = R.id.dashBoardMain;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dashBoardMain);
        if (viewFindChildViewById != null) {
            AppBarDashboard8Binding appBarDashboard8BindingBind = AppBarDashboard8Binding.bind(viewFindChildViewById);
            i = R.id.drawer_layout;
            DrawerLayout drawerLayout = (DrawerLayout) ViewBindings.findChildViewById(rootView, R.id.drawer_layout);
            if (drawerLayout != null) {
                i = R.id.forchatbot;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.forchatbot);
                if (frameLayout != null) {
                    i = R.id.iconFacebook;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconFacebook);
                    if (imageView != null) {
                        i = R.id.iconInstagram;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconInstagram);
                        if (imageView2 != null) {
                            i = R.id.iconLinkedIn;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconLinkedIn);
                            if (imageView3 != null) {
                                i = R.id.iconTelegram;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTelegram);
                                if (imageView4 != null) {
                                    i = R.id.iconTwitter;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTwitter);
                                    if (imageView5 != null) {
                                        i = R.id.icon_website;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.icon_website);
                                        if (imageView6 != null) {
                                            i = R.id.iconYoutube;
                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconYoutube);
                                            if (imageView7 != null) {
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
                                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImageText);
                                                                        if (imageView8 != null) {
                                                                            i = R.id.profileName;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.profileName);
                                                                            if (textView2 != null) {
                                                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView;
                                                                                i = R.id.socialIconLL;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.socialIconLL);
                                                                                if (linearLayout3 != null) {
                                                                                    i = R.id.vNameTV;
                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.vNameTV);
                                                                                    if (textView3 != null) {
                                                                                        return new ActivityHomeTheme8Binding(coordinatorLayout, appBarDashboard8BindingBind, drawerLayout, frameLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, recyclerView, navigationView, textView, circleImageView, imageView8, textView2, coordinatorLayout, linearLayout3, textView3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
