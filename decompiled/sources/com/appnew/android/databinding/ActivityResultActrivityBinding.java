package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.github.mikephil.charting.charts.BarChart;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityResultActrivityBinding implements ViewBinding {
    public final LinearLayout accuracyLL;
    public final CardView cartIv1;
    public final CardView cartIv2;
    public final CardView cartIv3;
    public final ImageView doubtImageBack;
    public final TextView endPercentage;
    public final Toolbar mainToolbar;
    public final Button overallBtn;
    public final LinearLayout percentileLL;
    public final CardView rankIV;
    public final RelativeLayout rankRL;
    public final RelativeLayout relatoiveInfo;
    public final TextView resultAccuracyTV;
    public final TextView resultAttemptTV;
    public final TextView resultAttemptedTV;
    public final TextView resultCorrectTV;
    public final TextView resultGuessTV;
    public final TextView resultIncorrectTV;
    public final TextView resultPercentileTV;
    public final BarChart resultRank;
    public final TextView resultRankTV;
    public final TextView resultScoreTV;
    public final TextView resultSkippedTV;
    public final TextView resultTextBtn;
    public final TextView resultTimeDuration;
    public final LinearLayout resultTopperLinear;
    public final LinearLayout resultUserLinear;
    public final TextView resultUsername;
    public final TextView resultUsername1;
    public final LinearLayout resultViewSolution;
    private final ConstraintLayout rootView;
    public final CardView scoreIV;
    public final SeekBar seekBar1;
    public final SeekBar seekBar2;
    public final ProgressBar simpleProgressBar;
    public final TextView startPercentage;
    public final TextView testName;
    public final TextView textCorrectText;
    public final TextView textInCorrectText;
    public final TextView textPercentageText;
    public final TextView toolbarTitleTV;
    public final TextView topperResultTextBtn;
    public final TextView tvXMax;
    public final TextView tvYMax;
    public final LinearLayout viewResultUserName;
    public final View viewaccuracy;
    public final View viewpercentile;

    private ActivityResultActrivityBinding(ConstraintLayout rootView, LinearLayout accuracyLL, CardView cartIv1, CardView cartIv2, CardView cartIv3, ImageView doubtImageBack, TextView endPercentage, Toolbar mainToolbar, Button overallBtn, LinearLayout percentileLL, CardView rankIV, RelativeLayout rankRL, RelativeLayout relatoiveInfo, TextView resultAccuracyTV, TextView resultAttemptTV, TextView resultAttemptedTV, TextView resultCorrectTV, TextView resultGuessTV, TextView resultIncorrectTV, TextView resultPercentileTV, BarChart resultRank, TextView resultRankTV, TextView resultScoreTV, TextView resultSkippedTV, TextView resultTextBtn, TextView resultTimeDuration, LinearLayout resultTopperLinear, LinearLayout resultUserLinear, TextView resultUsername, TextView resultUsername1, LinearLayout resultViewSolution, CardView scoreIV, SeekBar seekBar1, SeekBar seekBar2, ProgressBar simpleProgressBar, TextView startPercentage, TextView testName, TextView textCorrectText, TextView textInCorrectText, TextView textPercentageText, TextView toolbarTitleTV, TextView topperResultTextBtn, TextView tvXMax, TextView tvYMax, LinearLayout viewResultUserName, View viewaccuracy, View viewpercentile) {
        this.rootView = rootView;
        this.accuracyLL = accuracyLL;
        this.cartIv1 = cartIv1;
        this.cartIv2 = cartIv2;
        this.cartIv3 = cartIv3;
        this.doubtImageBack = doubtImageBack;
        this.endPercentage = endPercentage;
        this.mainToolbar = mainToolbar;
        this.overallBtn = overallBtn;
        this.percentileLL = percentileLL;
        this.rankIV = rankIV;
        this.rankRL = rankRL;
        this.relatoiveInfo = relatoiveInfo;
        this.resultAccuracyTV = resultAccuracyTV;
        this.resultAttemptTV = resultAttemptTV;
        this.resultAttemptedTV = resultAttemptedTV;
        this.resultCorrectTV = resultCorrectTV;
        this.resultGuessTV = resultGuessTV;
        this.resultIncorrectTV = resultIncorrectTV;
        this.resultPercentileTV = resultPercentileTV;
        this.resultRank = resultRank;
        this.resultRankTV = resultRankTV;
        this.resultScoreTV = resultScoreTV;
        this.resultSkippedTV = resultSkippedTV;
        this.resultTextBtn = resultTextBtn;
        this.resultTimeDuration = resultTimeDuration;
        this.resultTopperLinear = resultTopperLinear;
        this.resultUserLinear = resultUserLinear;
        this.resultUsername = resultUsername;
        this.resultUsername1 = resultUsername1;
        this.resultViewSolution = resultViewSolution;
        this.scoreIV = scoreIV;
        this.seekBar1 = seekBar1;
        this.seekBar2 = seekBar2;
        this.simpleProgressBar = simpleProgressBar;
        this.startPercentage = startPercentage;
        this.testName = testName;
        this.textCorrectText = textCorrectText;
        this.textInCorrectText = textInCorrectText;
        this.textPercentageText = textPercentageText;
        this.toolbarTitleTV = toolbarTitleTV;
        this.topperResultTextBtn = topperResultTextBtn;
        this.tvXMax = tvXMax;
        this.tvYMax = tvYMax;
        this.viewResultUserName = viewResultUserName;
        this.viewaccuracy = viewaccuracy;
        this.viewpercentile = viewpercentile;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityResultActrivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityResultActrivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_result_actrivity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityResultActrivityBinding bind(View rootView) {
        int i = R.id.accuracy_LL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.accuracy_LL);
        if (linearLayout != null) {
            i = R.id.cart_iv1;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cart_iv1);
            if (cardView != null) {
                i = R.id.cart_iv2;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cart_iv2);
                if (cardView2 != null) {
                    i = R.id.cart_iv3;
                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cart_iv3);
                    if (cardView3 != null) {
                        i = R.id.doubt_image_back;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.doubt_image_back);
                        if (imageView != null) {
                            i = R.id.endPercentage;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.endPercentage);
                            if (textView != null) {
                                i = R.id.main_toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                if (toolbar != null) {
                                    i = R.id.overall_btn;
                                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.overall_btn);
                                    if (button != null) {
                                        i = R.id.percentileLL;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.percentileLL);
                                        if (linearLayout2 != null) {
                                            i = R.id.rankIV;
                                            CardView cardView4 = (CardView) ViewBindings.findChildViewById(rootView, R.id.rankIV);
                                            if (cardView4 != null) {
                                                i = R.id.rankRL;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rankRL);
                                                if (relativeLayout != null) {
                                                    i = R.id.relatoive_info;
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relatoive_info);
                                                    if (relativeLayout2 != null) {
                                                        i = R.id.resultAccuracyTV;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAccuracyTV);
                                                        if (textView2 != null) {
                                                            i = R.id.resultAttemptTV;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAttemptTV);
                                                            if (textView3 != null) {
                                                                i = R.id.resultAttemptedTV;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAttemptedTV);
                                                                if (textView4 != null) {
                                                                    i = R.id.resultCorrectTV;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultCorrectTV);
                                                                    if (textView5 != null) {
                                                                        i = R.id.resultGuessTV;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultGuessTV);
                                                                        if (textView6 != null) {
                                                                            i = R.id.resultIncorrectTV;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultIncorrectTV);
                                                                            if (textView7 != null) {
                                                                                i = R.id.resultPercentileTV;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultPercentileTV);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.resultRank;
                                                                                    BarChart barChart = (BarChart) ViewBindings.findChildViewById(rootView, R.id.resultRank);
                                                                                    if (barChart != null) {
                                                                                        i = R.id.resultRankTV;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultRankTV);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.resultScoreTV;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultScoreTV);
                                                                                            if (textView10 != null) {
                                                                                                i = R.id.resultSkippedTV;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultSkippedTV);
                                                                                                if (textView11 != null) {
                                                                                                    i = R.id.resultTextBtn;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultTextBtn);
                                                                                                    if (textView12 != null) {
                                                                                                        i = R.id.resultTimeDuration;
                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultTimeDuration);
                                                                                                        if (textView13 != null) {
                                                                                                            i = R.id.result_topper_linear;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.result_topper_linear);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i = R.id.result_user_linear;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.result_user_linear);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i = R.id.result_username;
                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.result_username);
                                                                                                                    if (textView14 != null) {
                                                                                                                        i = R.id.result_username1;
                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.result_username1);
                                                                                                                        if (textView15 != null) {
                                                                                                                            i = R.id.resultViewSolution;
                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.resultViewSolution);
                                                                                                                            if (linearLayout5 != null) {
                                                                                                                                i = R.id.scoreIV;
                                                                                                                                CardView cardView5 = (CardView) ViewBindings.findChildViewById(rootView, R.id.scoreIV);
                                                                                                                                if (cardView5 != null) {
                                                                                                                                    i = R.id.seekBar1;
                                                                                                                                    SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(rootView, R.id.seekBar1);
                                                                                                                                    if (seekBar != null) {
                                                                                                                                        i = R.id.seekBar2;
                                                                                                                                        SeekBar seekBar2 = (SeekBar) ViewBindings.findChildViewById(rootView, R.id.seekBar2);
                                                                                                                                        if (seekBar2 != null) {
                                                                                                                                            i = R.id.simpleProgressBar;
                                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.simpleProgressBar);
                                                                                                                                            if (progressBar != null) {
                                                                                                                                                i = R.id.startPercentage;
                                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startPercentage);
                                                                                                                                                if (textView16 != null) {
                                                                                                                                                    i = R.id.test_name;
                                                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.test_name);
                                                                                                                                                    if (textView17 != null) {
                                                                                                                                                        i = R.id.textCorrect_text;
                                                                                                                                                        TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textCorrect_text);
                                                                                                                                                        if (textView18 != null) {
                                                                                                                                                            i = R.id.textInCorrect_text;
                                                                                                                                                            TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textInCorrect_text);
                                                                                                                                                            if (textView19 != null) {
                                                                                                                                                                i = R.id.textPercentage_text;
                                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textPercentage_text);
                                                                                                                                                                if (textView20 != null) {
                                                                                                                                                                    i = R.id.toolbarTitleTV;
                                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                                        i = R.id.topperResultTextBtn;
                                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.topperResultTextBtn);
                                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                                            i = R.id.tvXMax;
                                                                                                                                                                            TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvXMax);
                                                                                                                                                                            if (textView23 != null) {
                                                                                                                                                                                i = R.id.tvYMax;
                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tvYMax);
                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                    i = R.id.viewResult_userName;
                                                                                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.viewResult_userName);
                                                                                                                                                                                    if (linearLayout6 != null) {
                                                                                                                                                                                        i = R.id.viewaccuracy;
                                                                                                                                                                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewaccuracy);
                                                                                                                                                                                        if (viewFindChildViewById != null) {
                                                                                                                                                                                            i = R.id.viewpercentile;
                                                                                                                                                                                            View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.viewpercentile);
                                                                                                                                                                                            if (viewFindChildViewById2 != null) {
                                                                                                                                                                                                return new ActivityResultActrivityBinding((ConstraintLayout) rootView, linearLayout, cardView, cardView2, cardView3, imageView, textView, toolbar, button, linearLayout2, cardView4, relativeLayout, relativeLayout2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, barChart, textView9, textView10, textView11, textView12, textView13, linearLayout3, linearLayout4, textView14, textView15, linearLayout5, cardView5, seekBar, seekBar2, progressBar, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, linearLayout6, viewFindChildViewById, viewFindChildViewById2);
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
