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

/* JADX INFO: loaded from: classes6.dex */
public final class IbtSingleItemExamPrepViewallBinding implements ViewBinding {
    public final RelativeLayout currentAffairRL;
    public final TextView expireDate;
    public final TextView ibtCurrentAffairTitle;
    public final ImageView ibtSingleVdIv;
    public final TextView ibtSingleVdTvDay;
    public final TextView mrpCutTV;
    public final TextView nextPaymentTxt;
    public final LinearLayout payCompleteLL;
    public final LinearLayout payNowBtn;
    public final LinearLayout payNowLL;
    public final TextView priceTV;
    public final LinearLayout removeCart;
    private final RelativeLayout rootView;
    public final LinearLayout titleLl;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private IbtSingleItemExamPrepViewallBinding(RelativeLayout rootView, RelativeLayout currentAffairRL, TextView expireDate, TextView ibtCurrentAffairTitle, ImageView ibtSingleVdIv, TextView ibtSingleVdTvDay, TextView mrpCutTV, TextView nextPaymentTxt, LinearLayout payCompleteLL, LinearLayout payNowBtn, LinearLayout payNowLL, TextView priceTV, LinearLayout removeCart, LinearLayout titleLl, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.currentAffairRL = currentAffairRL;
        this.expireDate = expireDate;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.mrpCutTV = mrpCutTV;
        this.nextPaymentTxt = nextPaymentTxt;
        this.payCompleteLL = payCompleteLL;
        this.payNowBtn = payNowBtn;
        this.payNowLL = payNowLL;
        this.priceTV = priceTV;
        this.removeCart = removeCart;
        this.titleLl = titleLl;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IbtSingleItemExamPrepViewallBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IbtSingleItemExamPrepViewallBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.ibt_single_item_exam_prep_viewall, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IbtSingleItemExamPrepViewallBinding bind(View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.expire_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.expire_date);
        if (textView != null) {
            i = R.id.ibt_current_affair_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
            if (textView2 != null) {
                i = R.id.ibt_single_vd_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                if (imageView != null) {
                    i = R.id.ibt_single_vd_tv_day;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                    if (textView3 != null) {
                        i = R.id.mrpCutTV;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                        if (textView4 != null) {
                            i = R.id.next_payment_txt;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.next_payment_txt);
                            if (textView5 != null) {
                                i = R.id.payCompleteLL;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payCompleteLL);
                                if (linearLayout != null) {
                                    i = R.id.payNowBtn;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payNowBtn);
                                    if (linearLayout2 != null) {
                                        i = R.id.payNowLL;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payNowLL);
                                        if (linearLayout3 != null) {
                                            i = R.id.priceTV;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                            if (textView6 != null) {
                                                i = R.id.remove_cart;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.remove_cart);
                                                if (linearLayout4 != null) {
                                                    i = R.id.title_ll;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.validityTextTV;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                                        if (textView7 != null) {
                                                            i = R.id.videoplayerRL;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                            if (relativeLayout2 != null) {
                                                                return new IbtSingleItemExamPrepViewallBinding(relativeLayout, relativeLayout, textView, textView2, imageView, textView3, textView4, textView5, linearLayout, linearLayout2, linearLayout3, textView6, linearLayout4, linearLayout5, textView7, relativeLayout2);
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
