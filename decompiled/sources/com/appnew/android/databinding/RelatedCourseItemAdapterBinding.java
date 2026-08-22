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
public final class RelatedCourseItemAdapterBinding implements ViewBinding {
    public final CardView cardCV;
    public final LinearLayout currentAffairRL;
    public final TextView ibtCurrentAffairTitle;
    public final ImageView ibtSingleVdIv;
    public final ImageView liveIV;
    public final TextView mrpCutTV;
    public final TextView priceTV;
    private final LinearLayout rootView;
    public final LinearLayout titleLl;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private RelatedCourseItemAdapterBinding(LinearLayout rootView, CardView cardCV, LinearLayout currentAffairRL, TextView ibtCurrentAffairTitle, ImageView ibtSingleVdIv, ImageView liveIV, TextView mrpCutTV, TextView priceTV, LinearLayout titleLl, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.cardCV = cardCV;
        this.currentAffairRL = currentAffairRL;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.liveIV = liveIV;
        this.mrpCutTV = mrpCutTV;
        this.priceTV = priceTV;
        this.titleLl = titleLl;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RelatedCourseItemAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RelatedCourseItemAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.related_course_item_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RelatedCourseItemAdapterBinding bind(View rootView) {
        int i = R.id.card_CV;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card_CV);
        if (cardView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.ibt_current_affair_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
            if (textView != null) {
                i = R.id.ibt_single_vd_iv;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                if (imageView != null) {
                    i = R.id.liveIV;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                    if (imageView2 != null) {
                        i = R.id.mrpCutTV;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                        if (textView2 != null) {
                            i = R.id.priceTV;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                            if (textView3 != null) {
                                i = R.id.title_ll;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.title_ll);
                                if (linearLayout2 != null) {
                                    i = R.id.validityTextTV;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                    if (textView4 != null) {
                                        i = R.id.videoplayerRL;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                        if (relativeLayout != null) {
                                            return new RelatedCourseItemAdapterBinding(linearLayout, cardView, linearLayout, textView, imageView, imageView2, textView2, textView3, linearLayout2, textView4, relativeLayout);
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
