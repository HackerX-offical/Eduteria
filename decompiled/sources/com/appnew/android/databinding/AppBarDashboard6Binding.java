package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboard6Binding implements ViewBinding {
    public final DynamicBottomBarBinding bottomMenu;
    public final LinearLayout cvrNotificationCount1;
    public final Toolbar dashboardToolbar;
    public final TextView desc;
    public final ImageView imageMyCourses;
    public final LinearLayout myCoursesLL;
    public final NoDataFoundBinding noDataFound;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final ProgressBar progressBar;
    public final TextView recordAudio;
    public final RecyclerView recycler;
    private final RelativeLayout rootView;
    public final RecyclerView textRecycler;
    public final TextView title;

    private AppBarDashboard6Binding(RelativeLayout rootView, DynamicBottomBarBinding bottomMenu, LinearLayout cvrNotificationCount1, Toolbar dashboardToolbar, TextView desc, ImageView imageMyCourses, LinearLayout myCoursesLL, NoDataFoundBinding noDataFound, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, ProgressBar progressBar, TextView recordAudio, RecyclerView recycler, RecyclerView textRecycler, TextView title) {
        this.rootView = rootView;
        this.bottomMenu = bottomMenu;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.dashboardToolbar = dashboardToolbar;
        this.desc = desc;
        this.imageMyCourses = imageMyCourses;
        this.myCoursesLL = myCoursesLL;
        this.noDataFound = noDataFound;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.progressBar = progressBar;
        this.recordAudio = recordAudio;
        this.recycler = recycler;
        this.textRecycler = textRecycler;
        this.title = title;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboard6Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboard6Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard6, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboard6Binding bind(View rootView) {
        int i = R.id.bottom_menu;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
        if (viewFindChildViewById != null) {
            DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById);
            i = R.id.cvrNotificationCount1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
            if (linearLayout != null) {
                i = R.id.dashboardToolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.dashboardToolbar);
                if (toolbar != null) {
                    i = R.id.desc;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
                    if (textView != null) {
                        i = R.id.imageMyCourses;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageMyCourses);
                        if (imageView != null) {
                            i = R.id.myCoursesLL;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.myCoursesLL);
                            if (linearLayout2 != null) {
                                i = R.id.noDataFound;
                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.noDataFound);
                                if (viewFindChildViewById2 != null) {
                                    NoDataFoundBinding noDataFoundBindingBind = NoDataFoundBinding.bind(viewFindChildViewById2);
                                    i = R.id.notificaionCount1;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                                    if (textView2 != null) {
                                        i = R.id.notificationIV;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                                        if (imageView2 != null) {
                                            i = R.id.notificationLL;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                                            if (relativeLayout != null) {
                                                i = R.id.progressBar;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                if (progressBar != null) {
                                                    i = R.id.recordAudio;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.recordAudio);
                                                    if (textView3 != null) {
                                                        i = R.id.recycler;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler);
                                                        if (recyclerView != null) {
                                                            i = R.id.textRecycler;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.textRecycler);
                                                            if (recyclerView2 != null) {
                                                                i = R.id.title;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                                                if (textView4 != null) {
                                                                    return new AppBarDashboard6Binding((RelativeLayout) rootView, dynamicBottomBarBindingBind, linearLayout, toolbar, textView, imageView, linearLayout2, noDataFoundBindingBind, textView2, imageView2, relativeLayout, progressBar, textView3, recyclerView, recyclerView2, textView4);
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
