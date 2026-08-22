package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboard6aBinding implements ViewBinding {
    public final RelativeLayout RL1P;
    public final ImageView arrow;
    public final LinearLayout cartLL;
    public final ImageView chatboat;
    public final ImageButton chromecast;
    public final RecyclerView courseListRV;
    public final LinearLayout cvrNotificationCount;
    public final ImageView downarrowIV;
    public final ImageView downarrowIVNew;
    public final Toolbar feedsToolbar;
    public final RelativeLayout filter;
    public final TextView filterOne;
    public final RelativeLayout filterOneClick;
    public final TextView filterTwo;
    public final RelativeLayout filterTwoClick;
    public final ImageView homeBackIV;
    public final LinearLayout homeLL;
    public final LinearLayout liveclass;
    public final LinearLayout livetest;
    public final RelativeLayout llTop;
    public final LinearLayout llTopTwo;
    public final RelativeLayout mainlayout;
    public final LinearLayout myLibrary;
    public final TextView notificaionCount;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    private final RelativeLayout rootView;
    public final StickyScrollView scrollView;
    public final ImageView searchIV;
    public final LinearLayout testLL;
    public final RecyclerView tileRv;
    public final TextView tileTv;
    public final LinearLayout titleLl;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;
    public final TextView toolbartitleTV1;

    private AppBarDashboard6aBinding(RelativeLayout rootView, RelativeLayout RL1P, ImageView arrow, LinearLayout cartLL, ImageView chatboat, ImageButton chromecast, RecyclerView courseListRV, LinearLayout cvrNotificationCount, ImageView downarrowIV, ImageView downarrowIVNew, Toolbar feedsToolbar, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, ImageView homeBackIV, LinearLayout homeLL, LinearLayout liveclass, LinearLayout livetest, RelativeLayout llTop, LinearLayout llTopTwo, RelativeLayout mainlayout, LinearLayout myLibrary, TextView notificaionCount, ImageView profileImage, RelativeLayout profileLL, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, StickyScrollView scrollView, ImageView searchIV, LinearLayout testLL, RecyclerView tileRv, TextView tileTv, LinearLayout titleLl, RelativeLayout titleinnerRL, TextView toolbartitleTV, TextView toolbartitleTV1) {
        this.rootView = rootView;
        this.RL1P = RL1P;
        this.arrow = arrow;
        this.cartLL = cartLL;
        this.chatboat = chatboat;
        this.chromecast = chromecast;
        this.courseListRV = courseListRV;
        this.cvrNotificationCount = cvrNotificationCount;
        this.downarrowIV = downarrowIV;
        this.downarrowIVNew = downarrowIVNew;
        this.feedsToolbar = feedsToolbar;
        this.filter = filter;
        this.filterOne = filterOne;
        this.filterOneClick = filterOneClick;
        this.filterTwo = filterTwo;
        this.filterTwoClick = filterTwoClick;
        this.homeBackIV = homeBackIV;
        this.homeLL = homeLL;
        this.liveclass = liveclass;
        this.livetest = livetest;
        this.llTop = llTop;
        this.llTopTwo = llTopTwo;
        this.mainlayout = mainlayout;
        this.myLibrary = myLibrary;
        this.notificaionCount = notificaionCount;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.scrollView = scrollView;
        this.searchIV = searchIV;
        this.testLL = testLL;
        this.tileRv = tileRv;
        this.tileTv = tileTv;
        this.titleLl = titleLl;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
        this.toolbartitleTV1 = toolbartitleTV1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboard6aBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboard6aBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard6a, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboard6aBinding bind(View rootView) {
        int i = R.id.RL1P;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
        if (relativeLayout != null) {
            i = R.id.arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
            if (imageView != null) {
                i = R.id.cartLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                if (linearLayout != null) {
                    i = R.id.chatboat;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatboat);
                    if (imageView2 != null) {
                        i = R.id.chromecast;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.chromecast);
                        if (imageButton != null) {
                            i = R.id.courseListRV;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
                            if (recyclerView != null) {
                                i = R.id.cvrNotificationCount;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                if (linearLayout2 != null) {
                                    i = R.id.downarrowIV;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                    if (imageView3 != null) {
                                        i = R.id.downarrowIV_new;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                                        if (imageView4 != null) {
                                            i = R.id.feeds_toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.feeds_toolbar);
                                            if (toolbar != null) {
                                                i = R.id.filter;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.filterOne;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                                    if (textView != null) {
                                                        i = R.id.filter_one_click;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                                        if (relativeLayout3 != null) {
                                                            i = R.id.filterTwo;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                                            if (textView2 != null) {
                                                                i = R.id.filter_two_click;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                                                if (relativeLayout4 != null) {
                                                                    i = R.id.homeBackIV;
                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                    if (imageView5 != null) {
                                                                        i = R.id.homeLL;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.liveclass;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.livetest;
                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R.id.ll_top;
                                                                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top);
                                                                                    if (relativeLayout5 != null) {
                                                                                        i = R.id.ll_top_two;
                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                                                        if (linearLayout6 != null) {
                                                                                            i = R.id.mainlayout;
                                                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                                            if (relativeLayout6 != null) {
                                                                                                i = R.id.my_library;
                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                if (linearLayout7 != null) {
                                                                                                    i = R.id.notificaionCount;
                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.profile_image;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                        if (imageView6 != null) {
                                                                                                            i = R.id.profileLL;
                                                                                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                            if (relativeLayout7 != null) {
                                                                                                                i = R.id.progressBar;
                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                if (progressBar != null) {
                                                                                                                    i = R.id.pullto_referesh;
                                                                                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                                                                    if (swipeRefreshLayout != null) {
                                                                                                                        i = R.id.scrollView;
                                                                                                                        StickyScrollView stickyScrollView = (StickyScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                        if (stickyScrollView != null) {
                                                                                                                            i = R.id.searchIV;
                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                                                                            if (imageView7 != null) {
                                                                                                                                i = R.id.testLL;
                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                    i = R.id.tileRv;
                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                        i = R.id.tile_tv;
                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tile_tv);
                                                                                                                                        if (textView4 != null) {
                                                                                                                                            i = R.id.title_ll;
                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                i = R.id.titleinnerRL;
                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                    i = R.id.toolbartitleTV;
                                                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                                                                    if (textView5 != null) {
                                                                                                                                                        i = R.id.toolbartitleTV1;
                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV1);
                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                            return new AppBarDashboard6aBinding((RelativeLayout) rootView, relativeLayout, imageView, linearLayout, imageView2, imageButton, recyclerView, linearLayout2, imageView3, imageView4, toolbar, relativeLayout2, textView, relativeLayout3, textView2, relativeLayout4, imageView5, linearLayout3, linearLayout4, linearLayout5, relativeLayout5, linearLayout6, relativeLayout6, linearLayout7, textView3, imageView6, relativeLayout7, progressBar, swipeRefreshLayout, stickyScrollView, imageView7, linearLayout8, recyclerView2, textView4, linearLayout9, relativeLayout8, textView5, textView6);
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
