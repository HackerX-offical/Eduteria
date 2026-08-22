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
public final class LiveClassAdapterTheme5Binding implements ViewBinding {
    public final ImageView courseImage;
    public final TextView courseName;
    public final RelativeLayout cvrItems;
    public final TextView listneNow;
    public final TextView liveDate;
    public final ImageView liveIV;
    public final CardView maincard;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView startedin;
    public final TextView studyItemTitleTV;
    public final LinearLayout studySingleItemLL;
    public final TextView time;
    public final TextView timing;
    public final View view1;
    public final View view2;
    public final TextView watchNow;

    private LiveClassAdapterTheme5Binding(RelativeLayout rootView, ImageView courseImage, TextView courseName, RelativeLayout cvrItems, TextView listneNow, TextView liveDate, ImageView liveIV, CardView maincard, ImageView share, TextView startedin, TextView studyItemTitleTV, LinearLayout studySingleItemLL, TextView time, TextView timing, View view1, View view2, TextView watchNow) {
        this.rootView = rootView;
        this.courseImage = courseImage;
        this.courseName = courseName;
        this.cvrItems = cvrItems;
        this.listneNow = listneNow;
        this.liveDate = liveDate;
        this.liveIV = liveIV;
        this.maincard = maincard;
        this.share = share;
        this.startedin = startedin;
        this.studyItemTitleTV = studyItemTitleTV;
        this.studySingleItemLL = studySingleItemLL;
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

    public static LiveClassAdapterTheme5Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LiveClassAdapterTheme5Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.live_class_adapter_theme5, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LiveClassAdapterTheme5Binding bind(View rootView) {
        int i = R.id.courseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
        if (imageView != null) {
            i = R.id.course_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.course_name);
            if (textView != null) {
                i = R.id.cvrItems;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrItems);
                if (relativeLayout != null) {
                    i = R.id.listne_now;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.listne_now);
                    if (textView2 != null) {
                        i = R.id.liveDate;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.liveDate);
                        if (textView3 != null) {
                            i = R.id.liveIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                            if (imageView2 != null) {
                                i = R.id.maincard;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.maincard);
                                if (cardView != null) {
                                    i = R.id.share;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                    if (imageView3 != null) {
                                        i = R.id.startedin;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startedin);
                                        if (textView4 != null) {
                                            i = R.id.study_item_titleTV;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.study_item_titleTV);
                                            if (textView5 != null) {
                                                i = R.id.study_single_itemLL;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                if (linearLayout != null) {
                                                    i = R.id.time;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time);
                                                    if (textView6 != null) {
                                                        i = R.id.timing;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timing);
                                                        if (textView7 != null) {
                                                            i = R.id.view1;
                                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                                                            if (viewFindChildViewById != null) {
                                                                i = R.id.view2;
                                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view2);
                                                                if (viewFindChildViewById2 != null) {
                                                                    i = R.id.watch_now;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.watch_now);
                                                                    if (textView8 != null) {
                                                                        return new LiveClassAdapterTheme5Binding((RelativeLayout) rootView, imageView, textView, relativeLayout, textView2, textView3, imageView2, cardView, imageView3, textView4, textView5, linearLayout, textView6, textView7, viewFindChildViewById, viewFindChildViewById2, textView8);
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
