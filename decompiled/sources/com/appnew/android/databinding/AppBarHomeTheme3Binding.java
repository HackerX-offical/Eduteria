package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarHomeTheme3Binding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RelativeLayout RL1P;
    public final DynamicBottomBarBinding bottomMenu;
    public final LinearLayout cartLL;
    public final LinearLayout cvrNotificationCount;
    public final LinearLayout cvrNotificationCount1;
    public final Toolbar dashboardToolbar;
    public final RecyclerView emiRecyclerView;
    public final LinearLayout emiView;
    public final RelativeLayout headerRL;
    public final LinearLayout homeLL;
    public final LinearLayout libLL;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetestLL;
    public final LinearLayout myLibrary;
    public final TextView notificaionCount;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    private final RelativeLayout rootView;
    public final ViewPager2 sliderViewPager;
    public final RecyclerView tabsRV;
    public final LinearLayout testLL;
    public final RelativeLayout viewPagerRL;
    public final View vodView;

    private AppBarHomeTheme3Binding(RelativeLayout rootView, LinearLayout CourseLL, RelativeLayout RL1P, DynamicBottomBarBinding bottomMenu, LinearLayout cartLL, LinearLayout cvrNotificationCount, LinearLayout cvrNotificationCount1, Toolbar dashboardToolbar, RecyclerView emiRecyclerView, LinearLayout emiView, RelativeLayout headerRL, LinearLayout homeLL, LinearLayout libLL, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetestLL, LinearLayout myLibrary, TextView notificaionCount, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ImageView profileImage, RelativeLayout profileLL, ViewPager2 sliderViewPager, RecyclerView tabsRV, LinearLayout testLL, RelativeLayout viewPagerRL, View vodView) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.RL1P = RL1P;
        this.bottomMenu = bottomMenu;
        this.cartLL = cartLL;
        this.cvrNotificationCount = cvrNotificationCount;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.dashboardToolbar = dashboardToolbar;
        this.emiRecyclerView = emiRecyclerView;
        this.emiView = emiView;
        this.headerRL = headerRL;
        this.homeLL = homeLL;
        this.libLL = libLL;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetestLL = livetestLL;
        this.myLibrary = myLibrary;
        this.notificaionCount = notificaionCount;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.sliderViewPager = sliderViewPager;
        this.tabsRV = tabsRV;
        this.testLL = testLL;
        this.viewPagerRL = viewPagerRL;
        this.vodView = vodView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarHomeTheme3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarHomeTheme3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_home_theme3, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarHomeTheme3Binding bind(View rootView) {
        int i = R.id.CourseLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.CourseLL);
        if (linearLayout != null) {
            i = R.id.RL1P;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
            if (relativeLayout != null) {
                i = R.id.bottom_menu;
                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                if (viewFindChildViewById != null) {
                    DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
                    i = R.id.cartLL;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                    if (linearLayout2 != null) {
                        i = R.id.cvrNotificationCount;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                        if (linearLayout3 != null) {
                            i = R.id.cvrNotificationCount1;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
                            if (linearLayout4 != null) {
                                i = R.id.dashboardToolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.dashboardToolbar);
                                if (toolbar != null) {
                                    i = R.id.emiRecyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.emiRecyclerView);
                                    if (recyclerView != null) {
                                        i = R.id.emiView;
                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.emiView);
                                        if (linearLayout5 != null) {
                                            i = R.id.headerRL;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.headerRL);
                                            if (relativeLayout2 != null) {
                                                i = R.id.homeLL;
                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                if (linearLayout6 != null) {
                                                    i = R.id.libLL;
                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                    if (linearLayout7 != null) {
                                                        i = R.id.liveclass;
                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                        if (linearLayout8 != null) {
                                                            i = R.id.liveclassLL;
                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                            if (linearLayout9 != null) {
                                                                i = R.id.livetest;
                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                if (linearLayout10 != null) {
                                                                    i = R.id.livetestLL;
                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                    if (linearLayout11 != null) {
                                                                        i = R.id.my_library;
                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                        if (linearLayout12 != null) {
                                                                            i = R.id.notificaionCount;
                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                            if (textView != null) {
                                                                                i = R.id.notificaionCount1;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.notificationIV;
                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                                                                    if (imageView != null) {
                                                                                        i = R.id.notificationLL;
                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                                                                        if (relativeLayout3 != null) {
                                                                                            i = R.id.profile_image;
                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                            if (imageView2 != null) {
                                                                                                i = R.id.profileLL;
                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                if (relativeLayout4 != null) {
                                                                                                    i = R.id.sliderViewPager;
                                                                                                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(rootView, R.id.sliderViewPager);
                                                                                                    if (viewPager2 != null) {
                                                                                                        i = R.id.tabsRV;
                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tabsRV);
                                                                                                        if (recyclerView2 != null) {
                                                                                                            i = R.id.testLL;
                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                            if (linearLayout13 != null) {
                                                                                                                i = R.id.viewPagerRL;
                                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                if (relativeLayout5 != null) {
                                                                                                                    i = R.id.vodView;
                                                                                                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                    if (viewFindChildViewById2 != null) {
                                                                                                                        return new AppBarHomeTheme3Binding((RelativeLayout) rootView, linearLayout, relativeLayout, dynamicBottomBarBindingBind, linearLayout2, linearLayout3, linearLayout4, toolbar, recyclerView, linearLayout5, relativeLayout2, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, textView, textView2, imageView, relativeLayout3, imageView2, relativeLayout4, viewPager2, recyclerView2, linearLayout13, relativeLayout5, viewFindChildViewById2);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
