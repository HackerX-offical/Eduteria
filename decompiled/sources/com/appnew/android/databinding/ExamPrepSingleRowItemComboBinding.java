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
public final class ExamPrepSingleRowItemComboBinding implements ViewBinding {
    public final LinearLayout currentAffairRL;
    public final TextView ibtCurrentAffairTitle;
    public final CardView ibtSingleSubVdRL;
    public final ImageView ibtSingleVdIv;
    public final TextView ibtSingleVdTvDay;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final ImageView openEye;
    private final RelativeLayout rootView;
    public final RelativeLayout thumbRl;

    private ExamPrepSingleRowItemComboBinding(RelativeLayout rootView, LinearLayout currentAffairRL, TextView ibtCurrentAffairTitle, CardView ibtSingleSubVdRL, ImageView ibtSingleVdIv, TextView ibtSingleVdTvDay, ImageView liveIV, RelativeLayout lockRL, ImageView openEye, RelativeLayout thumbRl) {
        this.rootView = rootView;
        this.currentAffairRL = currentAffairRL;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.openEye = openEye;
        this.thumbRl = thumbRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemComboBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemComboBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_combo, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemComboBinding bind(View rootView) {
        int i = R.id.currentAffairRL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.currentAffairRL);
        if (linearLayout != null) {
            i = R.id.ibt_current_affair_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
            if (textView != null) {
                i = R.id.ibt_single_sub_vd_RL;
                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                if (cardView != null) {
                    i = R.id.ibt_single_vd_iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                    if (imageView != null) {
                        i = R.id.ibt_single_vd_tv_day;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                        if (textView2 != null) {
                            i = R.id.liveIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                            if (imageView2 != null) {
                                i = R.id.lockRL;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                if (relativeLayout != null) {
                                    i = R.id.open_eye;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.open_eye);
                                    if (imageView3 != null) {
                                        i = R.id.thumbRl;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                        if (relativeLayout2 != null) {
                                            return new ExamPrepSingleRowItemComboBinding((RelativeLayout) rootView, linearLayout, textView, cardView, imageView, textView2, imageView2, relativeLayout, imageView3, relativeLayout2);
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
