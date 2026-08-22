package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class RevisionResultScrrenBinding implements ViewBinding {
    public final LinearLayout accuracyLL;
    public final NestedScrollView mainLL;
    public final TextView notVisited;
    public final LinearLayout percentileLL;
    public final TextView resultAccuracyTV;
    public final TextView resultAttemptTV;
    public final TextView resultAttemptedTV;
    public final TextView resultBookmarkTV;
    public final TextView resultCorrectTV;
    public final LinearLayout resultDeclaredLL;
    public final TextView resultGuessTV;
    public final TextView resultIncorrectTV;
    public final TextView resultNameTV;
    public final TextView resultPercentileTV;
    public final TextView resultScoreTV;
    public final TextView resultSkippedTV;
    public final TextView resultUnAttemptTV;
    public final LinearLayout resultViewSolution;
    private final RelativeLayout rootView;
    public final ImageView scoreIV;
    public final View viewaccuracy;
    public final View viewpercentile;

    private RevisionResultScrrenBinding(RelativeLayout rootView, LinearLayout accuracyLL, NestedScrollView mainLL, TextView notVisited, LinearLayout percentileLL, TextView resultAccuracyTV, TextView resultAttemptTV, TextView resultAttemptedTV, TextView resultBookmarkTV, TextView resultCorrectTV, LinearLayout resultDeclaredLL, TextView resultGuessTV, TextView resultIncorrectTV, TextView resultNameTV, TextView resultPercentileTV, TextView resultScoreTV, TextView resultSkippedTV, TextView resultUnAttemptTV, LinearLayout resultViewSolution, ImageView scoreIV, View viewaccuracy, View viewpercentile) {
        this.rootView = rootView;
        this.accuracyLL = accuracyLL;
        this.mainLL = mainLL;
        this.notVisited = notVisited;
        this.percentileLL = percentileLL;
        this.resultAccuracyTV = resultAccuracyTV;
        this.resultAttemptTV = resultAttemptTV;
        this.resultAttemptedTV = resultAttemptedTV;
        this.resultBookmarkTV = resultBookmarkTV;
        this.resultCorrectTV = resultCorrectTV;
        this.resultDeclaredLL = resultDeclaredLL;
        this.resultGuessTV = resultGuessTV;
        this.resultIncorrectTV = resultIncorrectTV;
        this.resultNameTV = resultNameTV;
        this.resultPercentileTV = resultPercentileTV;
        this.resultScoreTV = resultScoreTV;
        this.resultSkippedTV = resultSkippedTV;
        this.resultUnAttemptTV = resultUnAttemptTV;
        this.resultViewSolution = resultViewSolution;
        this.scoreIV = scoreIV;
        this.viewaccuracy = viewaccuracy;
        this.viewpercentile = viewpercentile;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevisionResultScrrenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RevisionResultScrrenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.revision_result_scrren, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RevisionResultScrrenBinding bind(View rootView) {
        int i = R.id.accuracy_LL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.accuracy_LL);
        if (linearLayout != null) {
            i = R.id.mainLL;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.mainLL);
            if (nestedScrollView != null) {
                i = R.id.not_visited;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.not_visited);
                if (textView != null) {
                    i = R.id.percentileLL;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.percentileLL);
                    if (linearLayout2 != null) {
                        i = R.id.resultAccuracyTV;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAccuracyTV);
                        if (textView2 != null) {
                            i = R.id.resultAttemptTV;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAttemptTV);
                            if (textView3 != null) {
                                i = R.id.resultAttemptedTV;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultAttemptedTV);
                                if (textView4 != null) {
                                    i = R.id.resultBookmarkTV;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultBookmarkTV);
                                    if (textView5 != null) {
                                        i = R.id.resultCorrectTV;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultCorrectTV);
                                        if (textView6 != null) {
                                            i = R.id.resultDeclaredLL;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.resultDeclaredLL);
                                            if (linearLayout3 != null) {
                                                i = R.id.resultGuessTV;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultGuessTV);
                                                if (textView7 != null) {
                                                    i = R.id.resultIncorrectTV;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultIncorrectTV);
                                                    if (textView8 != null) {
                                                        i = R.id.resultNameTV;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultNameTV);
                                                        if (textView9 != null) {
                                                            i = R.id.resultPercentileTV;
                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultPercentileTV);
                                                            if (textView10 != null) {
                                                                i = R.id.resultScoreTV;
                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultScoreTV);
                                                                if (textView11 != null) {
                                                                    i = R.id.resultSkippedTV;
                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultSkippedTV);
                                                                    if (textView12 != null) {
                                                                        i = R.id.resultUnAttemptTV;
                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.resultUnAttemptTV);
                                                                        if (textView13 != null) {
                                                                            i = R.id.resultViewSolution;
                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.resultViewSolution);
                                                                            if (linearLayout4 != null) {
                                                                                i = R.id.scoreIV;
                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.scoreIV);
                                                                                if (imageView != null) {
                                                                                    i = R.id.viewaccuracy;
                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewaccuracy);
                                                                                    if (viewFindChildViewById != null) {
                                                                                        i = R.id.viewpercentile;
                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.viewpercentile);
                                                                                        if (viewFindChildViewById2 != null) {
                                                                                            return new RevisionResultScrrenBinding((RelativeLayout) rootView, linearLayout, nestedScrollView, textView, linearLayout2, textView2, textView3, textView4, textView5, textView6, linearLayout3, textView7, textView8, textView9, textView10, textView11, textView12, textView13, linearLayout4, imageView, viewFindChildViewById, viewFindChildViewById2);
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
