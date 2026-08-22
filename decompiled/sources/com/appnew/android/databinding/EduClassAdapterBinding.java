package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class EduClassAdapterBinding implements ViewBinding {
    public final ImageView courseImage;
    public final TextView courseName;
    public final TextView liveDate;
    public final ImageView liveIV;
    public final TextView liveTime;
    public final RelativeLayout liveWatchRL;
    public final ImageView lockIcon;
    public final CardView maincard;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView studyItemTitle;
    public final LinearLayout studySingleItemLL;
    public final RelativeLayout thumbRl;
    public final TextView timeAM;
    public final TextView timing;
    public final RelativeLayout upcomingWatchRel;
    public final TextView watchNowAM;

    private EduClassAdapterBinding(RelativeLayout rootView, ImageView courseImage, TextView courseName, TextView liveDate, ImageView liveIV, TextView liveTime, RelativeLayout liveWatchRL, ImageView lockIcon, CardView maincard, ImageView share, TextView studyItemTitle, LinearLayout studySingleItemLL, RelativeLayout thumbRl, TextView timeAM, TextView timing, RelativeLayout upcomingWatchRel, TextView watchNowAM) {
        this.rootView = rootView;
        this.courseImage = courseImage;
        this.courseName = courseName;
        this.liveDate = liveDate;
        this.liveIV = liveIV;
        this.liveTime = liveTime;
        this.liveWatchRL = liveWatchRL;
        this.lockIcon = lockIcon;
        this.maincard = maincard;
        this.share = share;
        this.studyItemTitle = studyItemTitle;
        this.studySingleItemLL = studySingleItemLL;
        this.thumbRl = thumbRl;
        this.timeAM = timeAM;
        this.timing = timing;
        this.upcomingWatchRel = upcomingWatchRel;
        this.watchNowAM = watchNowAM;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EduClassAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EduClassAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.edu_class_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EduClassAdapterBinding bind(View rootView) {
        int i = R.id.courseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
        if (imageView != null) {
            i = R.id.courseName;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.courseName);
            if (textView != null) {
                i = R.id.liveDate;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveDate);
                if (textView2 != null) {
                    i = R.id.liveIV;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                    if (imageView2 != null) {
                        i = R.id.liveTime;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveTime);
                        if (textView3 != null) {
                            i = R.id.liveWatchRL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.liveWatchRL);
                            if (relativeLayout != null) {
                                i = R.id.lockIcon;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.lockIcon);
                                if (imageView3 != null) {
                                    i = R.id.maincard;
                                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.maincard);
                                    if (cardView != null) {
                                        i = R.id.share;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                        if (imageView4 != null) {
                                            i = R.id.studyItemTitle;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.studyItemTitle);
                                            if (textView4 != null) {
                                                i = R.id.study_single_itemLL;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                if (linearLayout != null) {
                                                    i = R.id.thumbRl;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.timeAM;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeAM);
                                                        if (textView5 != null) {
                                                            i = R.id.timing;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timing);
                                                            if (textView6 != null) {
                                                                i = R.id.upcomingWatchRel;
                                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upcomingWatchRel);
                                                                if (relativeLayout3 != null) {
                                                                    i = R.id.watch_nowAM;
                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_nowAM);
                                                                    if (textView7 != null) {
                                                                        return new EduClassAdapterBinding((RelativeLayout) rootView, imageView, textView, textView2, imageView2, textView3, relativeLayout, imageView3, cardView, imageView4, textView4, linearLayout, relativeLayout2, textView5, textView6, relativeLayout3, textView7);
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
