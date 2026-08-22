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
public final class LiveClassAdapterBinding implements ViewBinding {
    public final ImageView courseImage;
    public final TextView courseName;
    public final TextView listneNow;
    public final TextView liveDate;
    public final ImageView liveIV;
    public final TextView liveTime;
    public final CardView maincard;
    public final TextView pdfTV;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView startedin;
    public final TextView studyItemTitleTV;
    public final LinearLayout studySingleItemLL;
    public final RelativeLayout thumbRl;
    public final TextView time;
    public final TextView timing;
    public final View view1;
    public final View view2;
    public final TextView watchNow;

    private LiveClassAdapterBinding(RelativeLayout rootView, ImageView courseImage, TextView courseName, TextView listneNow, TextView liveDate, ImageView liveIV, TextView liveTime, CardView maincard, TextView pdfTV, ImageView share, TextView startedin, TextView studyItemTitleTV, LinearLayout studySingleItemLL, RelativeLayout thumbRl, TextView time, TextView timing, View view1, View view2, TextView watchNow) {
        this.rootView = rootView;
        this.courseImage = courseImage;
        this.courseName = courseName;
        this.listneNow = listneNow;
        this.liveDate = liveDate;
        this.liveIV = liveIV;
        this.liveTime = liveTime;
        this.maincard = maincard;
        this.pdfTV = pdfTV;
        this.share = share;
        this.startedin = startedin;
        this.studyItemTitleTV = studyItemTitleTV;
        this.studySingleItemLL = studySingleItemLL;
        this.thumbRl = thumbRl;
        this.time = time;
        this.timing = timing;
        this.view1 = view1;
        this.view2 = view2;
        this.watchNow = watchNow;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveClassAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LiveClassAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.live_class_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LiveClassAdapterBinding bind(View rootView) {
        int i = R.id.courseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
        if (imageView != null) {
            i = R.id.course_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
            if (textView != null) {
                i = R.id.listne_now;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listne_now);
                if (textView2 != null) {
                    i = R.id.liveDate;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveDate);
                    if (textView3 != null) {
                        i = R.id.liveIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                        if (imageView2 != null) {
                            i = R.id.liveTime;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveTime);
                            if (textView4 != null) {
                                i = R.id.maincard;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.maincard);
                                if (cardView != null) {
                                    i = R.id.pdf_TV;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pdf_TV);
                                    if (textView5 != null) {
                                        i = R.id.share;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                        if (imageView3 != null) {
                                            i = R.id.startedin;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startedin);
                                            if (textView6 != null) {
                                                i = R.id.study_item_titleTV;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.study_item_titleTV);
                                                if (textView7 != null) {
                                                    i = R.id.study_single_itemLL;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                    if (linearLayout != null) {
                                                        i = R.id.thumbRl;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                        if (relativeLayout != null) {
                                                            i = R.id.time;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                                            if (textView8 != null) {
                                                                i = R.id.timing;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timing);
                                                                if (textView9 != null) {
                                                                    i = R.id.view1;
                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                                    if (viewFindChildViewById != null) {
                                                                        i = R.id.view2;
                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                        if (viewFindChildViewById2 != null) {
                                                                            i = R.id.watch_now;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                            if (textView10 != null) {
                                                                                return new LiveClassAdapterBinding((RelativeLayout) rootView, imageView, textView, textView2, textView3, imageView2, textView4, cardView, textView5, imageView3, textView6, textView7, linearLayout, relativeLayout, textView8, textView9, viewFindChildViewById, viewFindChildViewById2, textView10);
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
