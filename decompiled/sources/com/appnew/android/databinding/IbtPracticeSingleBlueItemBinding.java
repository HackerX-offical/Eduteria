package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class IbtPracticeSingleBlueItemBinding implements ViewBinding {
    public final LinearLayout LinearBackground;
    public final LinearLayout MainLL;
    public final TextView ibtSingleBlueItemTv;
    public final RelativeLayout imageplayerRL;
    public final ImageView itemIV;
    public final LinearLayout parentRL;
    private final LinearLayout rootView;
    public final CircleImageView tabIV;
    public final TextView title;
    public final View view1;

    private IbtPracticeSingleBlueItemBinding(LinearLayout rootView, LinearLayout LinearBackground, LinearLayout MainLL, TextView ibtSingleBlueItemTv, RelativeLayout imageplayerRL, ImageView itemIV, LinearLayout parentRL, CircleImageView tabIV, TextView title, View view1) {
        this.rootView = rootView;
        this.LinearBackground = LinearBackground;
        this.MainLL = MainLL;
        this.ibtSingleBlueItemTv = ibtSingleBlueItemTv;
        this.imageplayerRL = imageplayerRL;
        this.itemIV = itemIV;
        this.parentRL = parentRL;
        this.tabIV = tabIV;
        this.title = title;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static IbtPracticeSingleBlueItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtPracticeSingleBlueItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_practice_single_blue_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtPracticeSingleBlueItemBinding bind(View rootView) {
        int i = R.id.Linear_background;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Linear_background);
        if (linearLayout != null) {
            i = R.id.MainLL;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.MainLL);
            if (linearLayout2 != null) {
                i = R.id.ibt_single_blue_item_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_blue_item_tv);
                if (textView != null) {
                    i = R.id.imageplayerRL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageplayerRL);
                    if (relativeLayout != null) {
                        i = R.id.itemIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.itemIV);
                        if (imageView != null) {
                            i = R.id.parentRL;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.parentRL);
                            if (linearLayout3 != null) {
                                i = R.id.tabIV;
                                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.tabIV);
                                if (circleImageView != null) {
                                    i = R.id.title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                                    if (textView2 != null) {
                                        i = R.id.view1;
                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                        if (viewFindChildViewById != null) {
                                            return new IbtPracticeSingleBlueItemBinding((LinearLayout) rootView, linearLayout, linearLayout2, textView, relativeLayout, imageView, linearLayout3, circleImageView, textView2, viewFindChildViewById);
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
