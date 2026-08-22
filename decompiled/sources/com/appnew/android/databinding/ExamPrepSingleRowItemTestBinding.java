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
public final class ExamPrepSingleRowItemTestBinding implements ViewBinding {
    public final LinearLayout attemptLL;
    public final RelativeLayout contantLL;
    public final LinearLayout cvrBoundries;
    public final TextView examPrepTitleTV;
    public final ImageView forwardIV;
    public final CardView ibtSingleSubVdRL;
    public final RelativeLayout imageRL;
    public final TextView learn;
    public final RelativeLayout lockRL;
    public final LinearLayout mainContent;
    public final TextView practice;
    public final ImageView profileImage;
    public final TextView registerText;
    public final RelativeLayout rlTextMode;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView startdate;
    public final RelativeLayout studySingleItemLL;
    public final TextView subItemRV;
    public final CardView testCard;
    public final TextView testModeTv;
    public final TextView testPriceTv;
    public final TextView testPriceTv1;
    public final TextView testResume;
    public final RelativeLayout thumbRl;
    public final TextView viewResult;

    private ExamPrepSingleRowItemTestBinding(RelativeLayout rootView, LinearLayout attemptLL, RelativeLayout contantLL, LinearLayout cvrBoundries, TextView examPrepTitleTV, ImageView forwardIV, CardView ibtSingleSubVdRL, RelativeLayout imageRL, TextView learn, RelativeLayout lockRL, LinearLayout mainContent, TextView practice, ImageView profileImage, TextView registerText, RelativeLayout rlTextMode, ImageView share, TextView startdate, RelativeLayout studySingleItemLL, TextView subItemRV, CardView testCard, TextView testModeTv, TextView testPriceTv, TextView testPriceTv1, TextView testResume, RelativeLayout thumbRl, TextView viewResult) {
        this.rootView = rootView;
        this.attemptLL = attemptLL;
        this.contantLL = contantLL;
        this.cvrBoundries = cvrBoundries;
        this.examPrepTitleTV = examPrepTitleTV;
        this.forwardIV = forwardIV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.imageRL = imageRL;
        this.learn = learn;
        this.lockRL = lockRL;
        this.mainContent = mainContent;
        this.practice = practice;
        this.profileImage = profileImage;
        this.registerText = registerText;
        this.rlTextMode = rlTextMode;
        this.share = share;
        this.startdate = startdate;
        this.studySingleItemLL = studySingleItemLL;
        this.subItemRV = subItemRV;
        this.testCard = testCard;
        this.testModeTv = testModeTv;
        this.testPriceTv = testPriceTv;
        this.testPriceTv1 = testPriceTv1;
        this.testResume = testResume;
        this.thumbRl = thumbRl;
        this.viewResult = viewResult;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_test, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemTestBinding bind(View rootView) {
        int i = R.id.attemptLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attemptLL);
        if (linearLayout != null) {
            i = R.id.contantLL;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.contantLL);
            if (relativeLayout != null) {
                i = R.id.cvrBoundries;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrBoundries);
                if (linearLayout2 != null) {
                    i = R.id.examPrepTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                    if (textView != null) {
                        i = R.id.forwardIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                        if (imageView != null) {
                            i = R.id.ibt_single_sub_vd_RL;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                            if (cardView != null) {
                                i = R.id.imageRL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                if (relativeLayout2 != null) {
                                    i = R.id.learn;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                    if (textView2 != null) {
                                        i = R.id.lockRL;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                        if (relativeLayout3 != null) {
                                            i = R.id.mainContent;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mainContent);
                                            if (linearLayout3 != null) {
                                                i = R.id.practice;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                if (textView3 != null) {
                                                    i = R.id.profileImage;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                    if (imageView2 != null) {
                                                        i = R.id.registerText;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.registerText);
                                                        if (textView4 != null) {
                                                            i = R.id.rl_text_mode;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_text_mode);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.share;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                                if (imageView3 != null) {
                                                                    i = R.id.startdate;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startdate);
                                                                    if (textView5 != null) {
                                                                        i = R.id.study_single_itemLL;
                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                        if (relativeLayout5 != null) {
                                                                            i = R.id.subItemRV;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subItemRV);
                                                                            if (textView6 != null) {
                                                                                i = R.id.test_card;
                                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.test_card);
                                                                                if (cardView2 != null) {
                                                                                    i = R.id.test_mode_tv;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_mode_tv);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.test_price_tv;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_price_tv);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.test_price_tv1;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_price_tv1);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.testResume;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.testResume);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.thumbRl;
                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                                                                    if (relativeLayout6 != null) {
                                                                                                        i = R.id.view_result;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view_result);
                                                                                                        if (textView11 != null) {
                                                                                                            return new ExamPrepSingleRowItemTestBinding((RelativeLayout) rootView, linearLayout, relativeLayout, linearLayout2, textView, imageView, cardView, relativeLayout2, textView2, relativeLayout3, linearLayout3, textView3, imageView2, textView4, relativeLayout4, imageView3, textView5, relativeLayout5, textView6, cardView2, textView7, textView8, textView9, textView10, relativeLayout6, textView11);
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
