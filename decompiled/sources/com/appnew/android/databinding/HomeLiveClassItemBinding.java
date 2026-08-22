package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HomeLiveClassItemBinding implements ViewBinding {
    public final ImageView homeCourseImage;
    public final TextView homeCourseName;
    public final TextView homeLiveDate;
    public final TextView homeSubCourseName;
    public final CardView liveClassCardView;
    private final CardView rootView;
    public final LinearLayout studySingleItemLL;

    private HomeLiveClassItemBinding(CardView rootView, ImageView homeCourseImage, TextView homeCourseName, TextView homeLiveDate, TextView homeSubCourseName, CardView liveClassCardView, LinearLayout studySingleItemLL) {
        this.rootView = rootView;
        this.homeCourseImage = homeCourseImage;
        this.homeCourseName = homeCourseName;
        this.homeLiveDate = homeLiveDate;
        this.homeSubCourseName = homeSubCourseName;
        this.liveClassCardView = liveClassCardView;
        this.studySingleItemLL = studySingleItemLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static HomeLiveClassItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HomeLiveClassItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.home_live_class_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HomeLiveClassItemBinding bind(View rootView) {
        int i = R.id.home_courseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.home_courseImage);
        if (imageView != null) {
            i = R.id.home_courseName;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.home_courseName);
            if (textView != null) {
                i = R.id.home_liveDate;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.home_liveDate);
                if (textView2 != null) {
                    i = R.id.home_subCourseName;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.home_subCourseName);
                    if (textView3 != null) {
                        CardView cardView = (CardView) rootView;
                        i = R.id.study_single_itemLL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                        if (linearLayout != null) {
                            return new HomeLiveClassItemBinding(cardView, imageView, textView, textView2, textView3, cardView, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
