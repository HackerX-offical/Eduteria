package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.navigation.NavigationView;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDashboardTheme7Binding implements ViewBinding {
    public final ImageView arrowImg;
    public final CardView changeInterfaceCV;
    public final AppBarDashboard7Binding dashBoardMain7;
    public final DrawerLayout drawerLayout;
    public final FrameLayout forchatbot;
    public final ImageView iconFacebook;
    public final ImageView iconInstagram;
    public final ImageView iconLinkedIn;
    public final ImageView iconTelegram;
    public final ImageView iconTwitter;
    public final ImageView iconYoutube;
    public final LinearLayout navHeaderLL;
    public final LinearLayout navHeaderRL;
    public final RecyclerView navRV;
    public final NavigationView navView;
    public final TextView profileEmail;
    public final CircleImageView profileImage;
    public final ImageView profileImageText;
    public final TextView profileName;
    private final DrawerLayout rootView;
    public final TextView selectionType;
    public final LinearLayout socialIconLL;
    public final ImageView updateProfileBtn;
    public final TextView vNameTV;

    private ActivityDashboardTheme7Binding(DrawerLayout rootView, ImageView arrowImg, CardView changeInterfaceCV, AppBarDashboard7Binding dashBoardMain7, DrawerLayout drawerLayout, FrameLayout forchatbot, ImageView iconFacebook, ImageView iconInstagram, ImageView iconLinkedIn, ImageView iconTelegram, ImageView iconTwitter, ImageView iconYoutube, LinearLayout navHeaderLL, LinearLayout navHeaderRL, RecyclerView navRV, NavigationView navView, TextView profileEmail, CircleImageView profileImage, ImageView profileImageText, TextView profileName, TextView selectionType, LinearLayout socialIconLL, ImageView updateProfileBtn, TextView vNameTV) {
        this.rootView = rootView;
        this.arrowImg = arrowImg;
        this.changeInterfaceCV = changeInterfaceCV;
        this.dashBoardMain7 = dashBoardMain7;
        this.drawerLayout = drawerLayout;
        this.forchatbot = forchatbot;
        this.iconFacebook = iconFacebook;
        this.iconInstagram = iconInstagram;
        this.iconLinkedIn = iconLinkedIn;
        this.iconTelegram = iconTelegram;
        this.iconTwitter = iconTwitter;
        this.iconYoutube = iconYoutube;
        this.navHeaderLL = navHeaderLL;
        this.navHeaderRL = navHeaderRL;
        this.navRV = navRV;
        this.navView = navView;
        this.profileEmail = profileEmail;
        this.profileImage = profileImage;
        this.profileImageText = profileImageText;
        this.profileName = profileName;
        this.selectionType = selectionType;
        this.socialIconLL = socialIconLL;
        this.updateProfileBtn = updateProfileBtn;
        this.vNameTV = vNameTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DrawerLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDashboardTheme7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityDashboardTheme7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_dashboard_theme7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDashboardTheme7Binding bind(View rootView) {
        int i = R.id.arrow_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow_img);
        if (imageView != null) {
            i = R.id.changeInterfaceCV;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.changeInterfaceCV);
            if (cardView != null) {
                i = R.id.dashBoardMain7;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dashBoardMain7);
                if (viewFindChildViewById != null) {
                    AppBarDashboard7Binding appBarDashboard7BindingBind = AppBarDashboard7Binding.bind(viewFindChildViewById);
                    DrawerLayout drawerLayout = (DrawerLayout) rootView;
                    i = R.id.forchatbot;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.forchatbot);
                    if (frameLayout != null) {
                        i = R.id.iconFacebook;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconFacebook);
                        if (imageView2 != null) {
                            i = R.id.iconInstagram;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconInstagram);
                            if (imageView3 != null) {
                                i = R.id.iconLinkedIn;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconLinkedIn);
                                if (imageView4 != null) {
                                    i = R.id.iconTelegram;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTelegram);
                                    if (imageView5 != null) {
                                        i = R.id.iconTwitter;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconTwitter);
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
                                                                                i = R.id.selectionType;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.selectionType);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.socialIconLL;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.socialIconLL);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.updateProfileBtn;
                                                                                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.updateProfileBtn);
                                                                                        if (imageView9 != null) {
                                                                                            i = R.id.vNameTV;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.vNameTV);
                                                                                            if (textView4 != null) {
                                                                                                return new ActivityDashboardTheme7Binding(drawerLayout, imageView, cardView, appBarDashboard7BindingBind, drawerLayout, frameLayout, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, recyclerView, navigationView, textView, circleImageView, imageView8, textView2, textView3, linearLayout3, imageView9, textView4);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
