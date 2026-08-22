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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.StickyView.ui.StickyScrollView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AppBarDashboard5Binding implements ViewBinding {
    public final LinearLayout CourseLL;
    public final RelativeLayout RL1P;
    public final LinearLayout Topperreview;
    public final ImageView TopperreviewIV;
    public final ImageView arrow;
    public final AutoSliderPageLayoutBinding bannerSliderLayout;
    public final DynamicBottomBarBinding bottomMenu;
    public final LinearLayout cartLL;
    public final ImageView chatboat;
    public final ImageButton chromecast;
    public final RecyclerView courseListRV;
    public final TextView coursesTxt;
    public final ImageView currentaffair;
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
    public final LinearLayout libLL;
    public final LinearLayout liveclass;
    public final LinearLayout liveclassLL;
    public final LinearLayout livetest;
    public final LinearLayout livetestLL;
    public final RelativeLayout llTop;
    public final LinearLayout llTopTwo;
    public final RelativeLayout mainlayout;
    public final LinearLayout myLibrary;
    public final TextView notificaionCount;
    public final CardView offlineClasses;
    public final ImageView ourcourses;
    public final LinearLayout ourcouselayout;
    public final ImageView parentRL;
    public final ImageView profileImage;
    public final RelativeLayout profileLL;
    public final ProgressBar progressBar;
    public final SwipeRefreshLayout pulltoReferesh;
    public final RelativeLayout rl1;
    private final RelativeLayout rootView;
    public final StickyScrollView scrollView;
    public final ImageView searchIV;
    public final ImageView seminarbanner;
    public final LinearLayout seminarlayout;
    public final ImageView tabIV;
    public final TextView tabTitle;
    public final LinearLayout testLL;
    public final TextView testseriesTxt;
    public final RecyclerView tileRv;
    public final TextView tileTv;
    public final LinearLayout titleLl;
    public final RelativeLayout titleinnerRL;
    public final TextView toolbartitleTV;
    public final RelativeLayout viewPagerRL;
    public final View vodView;

    private AppBarDashboard5Binding(RelativeLayout rootView, LinearLayout CourseLL, RelativeLayout RL1P, LinearLayout Topperreview, ImageView TopperreviewIV, ImageView arrow, AutoSliderPageLayoutBinding bannerSliderLayout, DynamicBottomBarBinding bottomMenu, LinearLayout cartLL, ImageView chatboat, ImageButton chromecast, RecyclerView courseListRV, TextView coursesTxt, ImageView currentaffair, LinearLayout cvrNotificationCount, ImageView downarrowIV, ImageView downarrowIVNew, Toolbar feedsToolbar, RelativeLayout filter, TextView filterOne, RelativeLayout filterOneClick, TextView filterTwo, RelativeLayout filterTwoClick, ImageView homeBackIV, LinearLayout homeLL, LinearLayout libLL, LinearLayout liveclass, LinearLayout liveclassLL, LinearLayout livetest, LinearLayout livetestLL, RelativeLayout llTop, LinearLayout llTopTwo, RelativeLayout mainlayout, LinearLayout myLibrary, TextView notificaionCount, CardView offlineClasses, ImageView ourcourses, LinearLayout ourcouselayout, ImageView parentRL, ImageView profileImage, RelativeLayout profileLL, ProgressBar progressBar, SwipeRefreshLayout pulltoReferesh, RelativeLayout rl1, StickyScrollView scrollView, ImageView searchIV, ImageView seminarbanner, LinearLayout seminarlayout, ImageView tabIV, TextView tabTitle, LinearLayout testLL, TextView testseriesTxt, RecyclerView tileRv, TextView tileTv, LinearLayout titleLl, RelativeLayout titleinnerRL, TextView toolbartitleTV, RelativeLayout viewPagerRL, View vodView) {
        this.rootView = rootView;
        this.CourseLL = CourseLL;
        this.RL1P = RL1P;
        this.Topperreview = Topperreview;
        this.TopperreviewIV = TopperreviewIV;
        this.arrow = arrow;
        this.bannerSliderLayout = bannerSliderLayout;
        this.bottomMenu = bottomMenu;
        this.cartLL = cartLL;
        this.chatboat = chatboat;
        this.chromecast = chromecast;
        this.courseListRV = courseListRV;
        this.coursesTxt = coursesTxt;
        this.currentaffair = currentaffair;
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
        this.libLL = libLL;
        this.liveclass = liveclass;
        this.liveclassLL = liveclassLL;
        this.livetest = livetest;
        this.livetestLL = livetestLL;
        this.llTop = llTop;
        this.llTopTwo = llTopTwo;
        this.mainlayout = mainlayout;
        this.myLibrary = myLibrary;
        this.notificaionCount = notificaionCount;
        this.offlineClasses = offlineClasses;
        this.ourcourses = ourcourses;
        this.ourcouselayout = ourcouselayout;
        this.parentRL = parentRL;
        this.profileImage = profileImage;
        this.profileLL = profileLL;
        this.progressBar = progressBar;
        this.pulltoReferesh = pulltoReferesh;
        this.rl1 = rl1;
        this.scrollView = scrollView;
        this.searchIV = searchIV;
        this.seminarbanner = seminarbanner;
        this.seminarlayout = seminarlayout;
        this.tabIV = tabIV;
        this.tabTitle = tabTitle;
        this.testLL = testLL;
        this.testseriesTxt = testseriesTxt;
        this.tileRv = tileRv;
        this.tileTv = tileTv;
        this.titleLl = titleLl;
        this.titleinnerRL = titleinnerRL;
        this.toolbartitleTV = toolbartitleTV;
        this.viewPagerRL = viewPagerRL;
        this.vodView = vodView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppBarDashboard5Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AppBarDashboard5Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.app_bar_dashboard5, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static AppBarDashboard5Binding bind(View rootView) {
        int i = R.id.CourseLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.CourseLL);
        if (linearLayout != null) {
            i = R.id.RL1P;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.RL1P);
            if (relativeLayout != null) {
                i = R.id.Topperreview;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Topperreview);
                if (linearLayout2 != null) {
                    i = R.id.TopperreviewIV;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.TopperreviewIV);
                    if (imageView != null) {
                        i = R.id.arrow;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrow);
                        if (imageView2 != null) {
                            i = R.id.bannerSliderLayout;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.bannerSliderLayout);
                            if (viewFindChildViewById != null) {
                                AutoSliderPageLayoutBinding autoSliderPageLayoutBindingBind = AutoSliderPageLayoutBinding.bind(viewFindChildViewById);
                                i = R.id.bottom_menu;
                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.bottom_menu);
                                if (viewFindChildViewById2 != null) {
                                    DynamicBottomBarBinding dynamicBottomBarBindingBind = DynamicBottomBarBinding.bind(viewFindChildViewById2);
                                    i = R.id.cartLL;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cartLL);
                                    if (linearLayout3 != null) {
                                        i = R.id.chatboat;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.chatboat);
                                        if (imageView3 != null) {
                                            i = R.id.chromecast;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.chromecast);
                                            if (imageButton != null) {
                                                i = R.id.courseListRV;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.courseListRV);
                                                if (recyclerView != null) {
                                                    i = R.id.courses_txt;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courses_txt);
                                                    if (textView != null) {
                                                        i = R.id.currentaffair;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.currentaffair);
                                                        if (imageView4 != null) {
                                                            i = R.id.cvrNotificationCount;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.downarrowIV;
                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV);
                                                                if (imageView5 != null) {
                                                                    i = R.id.downarrowIV_new;
                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.downarrowIV_new);
                                                                    if (imageView6 != null) {
                                                                        i = R.id.feeds_toolbar;
                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.feeds_toolbar);
                                                                        if (toolbar != null) {
                                                                            i = R.id.filter;
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter);
                                                                            if (relativeLayout2 != null) {
                                                                                i = R.id.filterOne;
                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterOne);
                                                                                if (textView2 != null) {
                                                                                    i = R.id.filter_one_click;
                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_one_click);
                                                                                    if (relativeLayout3 != null) {
                                                                                        i = R.id.filterTwo;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.filterTwo);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.filter_two_click;
                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.filter_two_click);
                                                                                            if (relativeLayout4 != null) {
                                                                                                i = R.id.homeBackIV;
                                                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                                                                                                if (imageView7 != null) {
                                                                                                    i = R.id.homeLL;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.homeLL);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        i = R.id.libLL;
                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.libLL);
                                                                                                        if (linearLayout6 != null) {
                                                                                                            i = R.id.liveclass;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclass);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i = R.id.liveclassLL;
                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.liveclassLL);
                                                                                                                if (linearLayout8 != null) {
                                                                                                                    i = R.id.livetest;
                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetest);
                                                                                                                    if (linearLayout9 != null) {
                                                                                                                        i = R.id.livetestLL;
                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.livetestLL);
                                                                                                                        if (linearLayout10 != null) {
                                                                                                                            i = R.id.ll_top;
                                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top);
                                                                                                                            if (relativeLayout5 != null) {
                                                                                                                                i = R.id.ll_top_two;
                                                                                                                                LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_top_two);
                                                                                                                                if (linearLayout11 != null) {
                                                                                                                                    i = R.id.mainlayout;
                                                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.mainlayout);
                                                                                                                                    if (relativeLayout6 != null) {
                                                                                                                                        i = R.id.my_library;
                                                                                                                                        LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.my_library);
                                                                                                                                        if (linearLayout12 != null) {
                                                                                                                                            i = R.id.notificaionCount;
                                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount);
                                                                                                                                            if (textView4 != null) {
                                                                                                                                                i = R.id.offline_classes;
                                                                                                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.offline_classes);
                                                                                                                                                if (cardView != null) {
                                                                                                                                                    i = R.id.ourcourses;
                                                                                                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ourcourses);
                                                                                                                                                    if (imageView8 != null) {
                                                                                                                                                        i = R.id.ourcouselayout;
                                                                                                                                                        LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ourcouselayout);
                                                                                                                                                        if (linearLayout13 != null) {
                                                                                                                                                            i = R.id.parentRL;
                                                                                                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.parentRL);
                                                                                                                                                            if (imageView9 != null) {
                                                                                                                                                                i = R.id.profile_image;
                                                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profile_image);
                                                                                                                                                                if (imageView10 != null) {
                                                                                                                                                                    i = R.id.profileLL;
                                                                                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.profileLL);
                                                                                                                                                                    if (relativeLayout7 != null) {
                                                                                                                                                                        i = R.id.progressBar;
                                                                                                                                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.progressBar);
                                                                                                                                                                        if (progressBar != null) {
                                                                                                                                                                            i = R.id.pullto_referesh;
                                                                                                                                                                            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(rootView, R.id.pullto_referesh);
                                                                                                                                                                            if (swipeRefreshLayout != null) {
                                                                                                                                                                                i = R.id.rl1;
                                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                                    i = R.id.scrollView;
                                                                                                                                                                                    StickyScrollView stickyScrollView = (StickyScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                                                                                                    if (stickyScrollView != null) {
                                                                                                                                                                                        i = R.id.searchIV;
                                                                                                                                                                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.searchIV);
                                                                                                                                                                                        if (imageView11 != null) {
                                                                                                                                                                                            i = R.id.seminarbanner;
                                                                                                                                                                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.seminarbanner);
                                                                                                                                                                                            if (imageView12 != null) {
                                                                                                                                                                                                i = R.id.seminarlayout;
                                                                                                                                                                                                LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.seminarlayout);
                                                                                                                                                                                                if (linearLayout14 != null) {
                                                                                                                                                                                                    i = R.id.tabIV;
                                                                                                                                                                                                    ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
                                                                                                                                                                                                    if (imageView13 != null) {
                                                                                                                                                                                                        i = R.id.tabTitle;
                                                                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tabTitle);
                                                                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                                                                            i = R.id.testLL;
                                                                                                                                                                                                            LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.testLL);
                                                                                                                                                                                                            if (linearLayout15 != null) {
                                                                                                                                                                                                                i = R.id.testseries_txt;
                                                                                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testseries_txt);
                                                                                                                                                                                                                if (textView6 != null) {
                                                                                                                                                                                                                    i = R.id.tileRv;
                                                                                                                                                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                                                                                                                                                                                                    if (recyclerView2 != null) {
                                                                                                                                                                                                                        i = R.id.tile_tv;
                                                                                                                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tile_tv);
                                                                                                                                                                                                                        if (textView7 != null) {
                                                                                                                                                                                                                            i = R.id.title_ll;
                                                                                                                                                                                                                            LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                                                                                                                                                                                            if (linearLayout16 != null) {
                                                                                                                                                                                                                                i = R.id.titleinnerRL;
                                                                                                                                                                                                                                RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.titleinnerRL);
                                                                                                                                                                                                                                if (relativeLayout9 != null) {
                                                                                                                                                                                                                                    i = R.id.toolbartitleTV;
                                                                                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                                                                                        i = R.id.viewPagerRL;
                                                                                                                                                                                                                                        RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.viewPagerRL);
                                                                                                                                                                                                                                        if (relativeLayout10 != null) {
                                                                                                                                                                                                                                            i = R.id.vodView;
                                                                                                                                                                                                                                            View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.vodView);
                                                                                                                                                                                                                                            if (viewFindChildViewById3 != null) {
                                                                                                                                                                                                                                                return new AppBarDashboard5Binding((RelativeLayout) rootView, linearLayout, relativeLayout, linearLayout2, imageView, imageView2, autoSliderPageLayoutBindingBind, dynamicBottomBarBindingBind, linearLayout3, imageView3, imageButton, recyclerView, textView, imageView4, linearLayout4, imageView5, imageView6, toolbar, relativeLayout2, textView2, relativeLayout3, textView3, relativeLayout4, imageView7, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, relativeLayout5, linearLayout11, relativeLayout6, linearLayout12, textView4, cardView, imageView8, linearLayout13, imageView9, imageView10, relativeLayout7, progressBar, swipeRefreshLayout, relativeLayout8, stickyScrollView, imageView11, imageView12, linearLayout14, imageView13, textView5, linearLayout15, textView6, recyclerView2, textView7, linearLayout16, relativeLayout9, textView8, relativeLayout10, viewFindChildViewById3);
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
