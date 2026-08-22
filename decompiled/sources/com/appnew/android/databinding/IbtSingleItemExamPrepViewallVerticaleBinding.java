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
public final class IbtSingleItemExamPrepViewallVerticaleBinding implements ViewBinding {
    public final CardView cardCV;
    public final RelativeLayout currentAffairRL;
    public final TextView ibtCurrentAffairTitle;
    public final ImageView ibtSingleVdIv;
    public final TextView ibtSingleVdTvDay;
    public final ImageView liveIV;
    public final TextView mrpCutTV;
    public final TextView priceTV;
    private final RelativeLayout rootView;
    public final LinearLayout titleLl;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private IbtSingleItemExamPrepViewallVerticaleBinding(RelativeLayout rootView, CardView cardCV, RelativeLayout currentAffairRL, TextView ibtCurrentAffairTitle, ImageView ibtSingleVdIv, TextView ibtSingleVdTvDay, ImageView liveIV, TextView mrpCutTV, TextView priceTV, LinearLayout titleLl, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.cardCV = cardCV;
        this.currentAffairRL = currentAffairRL;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.liveIV = liveIV;
        this.mrpCutTV = mrpCutTV;
        this.priceTV = priceTV;
        this.titleLl = titleLl;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtSingleItemExamPrepViewallVerticaleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtSingleItemExamPrepViewallVerticaleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_single_item_exam_prep_viewall_verticale, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtSingleItemExamPrepViewallVerticaleBinding bind(View rootView) {
        int i = R.id.card_CV;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card_CV);
        if (cardView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.ibt_current_affair_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
            if (textView != null) {
                i = R.id.ibt_single_vd_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                if (imageView != null) {
                    i = R.id.ibt_single_vd_tv_day;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                    if (textView2 != null) {
                        i = R.id.liveIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                        if (imageView2 != null) {
                            i = R.id.mrpCutTV;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                            if (textView3 != null) {
                                i = R.id.priceTV;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                if (textView4 != null) {
                                    i = R.id.title_ll;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                    if (linearLayout != null) {
                                        i = R.id.validityTextTV;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                        if (textView5 != null) {
                                            i = R.id.videoplayerRL;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                            if (relativeLayout2 != null) {
                                                return new IbtSingleItemExamPrepViewallVerticaleBinding(relativeLayout, cardView, relativeLayout, textView, imageView, textView2, imageView2, textView3, textView4, linearLayout, textView5, relativeLayout2);
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
