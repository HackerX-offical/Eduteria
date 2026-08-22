package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityFolderBinding implements ViewBinding {
    public final FrameLayout container;
    public final LinearLayout cvrNotificationCount1;
    public final ImageView homeBackIV;
    public final TextView notificaionCount1;
    public final ImageView notificationIV;
    public final RelativeLayout notificationLL;
    public final NoDataFound1Binding rlNoData;
    private final RelativeLayout rootView;
    public final RelativeLayout tileRl;
    public final TextView title;
    public final Toolbar toolbar;
    public final LinearLayout toolbarIcon;
    public final ImageView whatsappIcon;

    private ActivityFolderBinding(RelativeLayout rootView, FrameLayout container, LinearLayout cvrNotificationCount1, ImageView homeBackIV, TextView notificaionCount1, ImageView notificationIV, RelativeLayout notificationLL, NoDataFound1Binding rlNoData, RelativeLayout tileRl, TextView title, Toolbar toolbar, LinearLayout toolbarIcon, ImageView whatsappIcon) {
        this.rootView = rootView;
        this.container = container;
        this.cvrNotificationCount1 = cvrNotificationCount1;
        this.homeBackIV = homeBackIV;
        this.notificaionCount1 = notificaionCount1;
        this.notificationIV = notificationIV;
        this.notificationLL = notificationLL;
        this.rlNoData = rlNoData;
        this.tileRl = tileRl;
        this.title = title;
        this.toolbar = toolbar;
        this.toolbarIcon = toolbarIcon;
        this.whatsappIcon = whatsappIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFolderBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityFolderBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_folder, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityFolderBinding bind(View rootView) {
        int i = R.id.container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.container);
        if (frameLayout != null) {
            i = R.id.cvrNotificationCount1;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrNotificationCount1);
            if (linearLayout != null) {
                i = R.id.homeBackIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.homeBackIV);
                if (imageView != null) {
                    i = R.id.notificaionCount1;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.notificaionCount1);
                    if (textView != null) {
                        i = R.id.notificationIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.notificationIV);
                        if (imageView2 != null) {
                            i = R.id.notificationLL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.notificationLL);
                            if (relativeLayout != null) {
                                i = R.id.rl_no_data;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.rl_no_data);
                                if (viewFindChildViewById != null) {
                                    NoDataFound1Binding noDataFound1BindingBind = NoDataFound1Binding.bind(viewFindChildViewById);
                                    i = R.id.tile_rl;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tile_rl);
                                    if (relativeLayout2 != null) {
                                        i = R.id.title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                        if (textView2 != null) {
                                            i = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.toolbar);
                                            if (toolbar != null) {
                                                i = R.id.toolbarIcon;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.toolbarIcon);
                                                if (linearLayout2 != null) {
                                                    i = R.id.whatsappIcon;
                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.whatsappIcon);
                                                    if (imageView3 != null) {
                                                        return new ActivityFolderBinding((RelativeLayout) rootView, frameLayout, linearLayout, imageView, textView, imageView2, relativeLayout, noDataFound1BindingBind, relativeLayout2, textView2, toolbar, linearLayout2, imageView3);
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
