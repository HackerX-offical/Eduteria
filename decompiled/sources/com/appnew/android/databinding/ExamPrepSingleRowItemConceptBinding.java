package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepSingleRowItemConceptBinding implements ViewBinding {
    public final ImageView arrowIV;
    public final TextView examPrepTitleTV;
    public final CardView ibtSingleSubVdRL;
    public final RelativeLayout imageRL;
    public final RelativeLayout layoutFun;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final AppCompatImageView optionMenuImgView;
    public final ImageView profileImage;
    public final TextView readNow;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studySingleItemLL;
    public final TextView subItemRV;
    public final RelativeLayout thumbRl;

    private ExamPrepSingleRowItemConceptBinding(RelativeLayout rootView, ImageView arrowIV, TextView examPrepTitleTV, CardView ibtSingleSubVdRL, RelativeLayout imageRL, RelativeLayout layoutFun, ImageView liveIV, RelativeLayout lockRL, AppCompatImageView optionMenuImgView, ImageView profileImage, TextView readNow, ImageView share, RelativeLayout studySingleItemLL, TextView subItemRV, RelativeLayout thumbRl) {
        this.rootView = rootView;
        this.arrowIV = arrowIV;
        this.examPrepTitleTV = examPrepTitleTV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.imageRL = imageRL;
        this.layoutFun = layoutFun;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.optionMenuImgView = optionMenuImgView;
        this.profileImage = profileImage;
        this.readNow = readNow;
        this.share = share;
        this.studySingleItemLL = studySingleItemLL;
        this.subItemRV = subItemRV;
        this.thumbRl = thumbRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemConceptBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemConceptBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_concept, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemConceptBinding bind(View rootView) {
        int i = R.id.arrowIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowIV);
        if (imageView != null) {
            i = R.id.examPrepTitleTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
            if (textView != null) {
                i = R.id.ibt_single_sub_vd_RL;
                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                if (cardView != null) {
                    i = R.id.imageRL;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                    if (relativeLayout != null) {
                        i = R.id.layout_fun;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_fun);
                        if (relativeLayout2 != null) {
                            i = R.id.liveIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                            if (imageView2 != null) {
                                i = R.id.lockRL;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                if (relativeLayout3 != null) {
                                    i = R.id.optionMenuImgView;
                                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, R.id.optionMenuImgView);
                                    if (appCompatImageView != null) {
                                        i = R.id.profileImage;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                        if (imageView3 != null) {
                                            i = R.id.read_now;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                            if (textView2 != null) {
                                                i = R.id.share;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                if (imageView4 != null) {
                                                    i = R.id.study_single_itemLL;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                    if (relativeLayout4 != null) {
                                                        i = R.id.subItemRV;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subItemRV);
                                                        if (textView3 != null) {
                                                            i = R.id.thumbRl;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                            if (relativeLayout5 != null) {
                                                                return new ExamPrepSingleRowItemConceptBinding((RelativeLayout) rootView, imageView, textView, cardView, relativeLayout, relativeLayout2, imageView2, relativeLayout3, appCompatImageView, imageView3, textView2, imageView4, relativeLayout4, textView3, relativeLayout5);
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
