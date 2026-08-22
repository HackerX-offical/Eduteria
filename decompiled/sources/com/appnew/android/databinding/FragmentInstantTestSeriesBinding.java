package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentInstantTestSeriesBinding implements ViewBinding {
    public final LinearLayout LLFIBquestion;
    public final LinearLayout LLmatchinquestion;
    public final CheckBox checkBox;
    public final LinearLayout explanationLL;
    public final TextView explanationTV;
    public final ImageView imgBookmark;
    public final TextView markForReview;
    public final LinearLayout mcqoptions;
    public final NestedScrollView nestedSV;
    public final RelativeLayout questionLayout1;
    public final TextView removeMarkForReview;
    private final NestedScrollView rootView;
    public final RecyclerView rvfibquestion1;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final TextView saveMarkForReview;
    public final TextView tvEmail;
    public final MathView tvQuestion;
    public final MathView tvQuestionFib;
    public final MathView tvQuestionInstantSolution;
    public final TextView tvReportError;
    public final TextView tvUid;
    public final TextView unmarkForReview;

    private FragmentInstantTestSeriesBinding(NestedScrollView rootView, LinearLayout LLFIBquestion, LinearLayout LLmatchinquestion, CheckBox checkBox, LinearLayout explanationLL, TextView explanationTV, ImageView imgBookmark, TextView markForReview, LinearLayout mcqoptions, NestedScrollView nestedSV, RelativeLayout questionLayout1, TextView removeMarkForReview, RecyclerView rvfibquestion1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, TextView saveMarkForReview, TextView tvEmail, MathView tvQuestion, MathView tvQuestionFib, MathView tvQuestionInstantSolution, TextView tvReportError, TextView tvUid, TextView unmarkForReview) {
        this.rootView = rootView;
        this.LLFIBquestion = LLFIBquestion;
        this.LLmatchinquestion = LLmatchinquestion;
        this.checkBox = checkBox;
        this.explanationLL = explanationLL;
        this.explanationTV = explanationTV;
        this.imgBookmark = imgBookmark;
        this.markForReview = markForReview;
        this.mcqoptions = mcqoptions;
        this.nestedSV = nestedSV;
        this.questionLayout1 = questionLayout1;
        this.removeMarkForReview = removeMarkForReview;
        this.rvfibquestion1 = rvfibquestion1;
        this.rvmatchinquestion1 = rvmatchinquestion1;
        this.rvmatchinquestion2 = rvmatchinquestion2;
        this.saveMarkForReview = saveMarkForReview;
        this.tvEmail = tvEmail;
        this.tvQuestion = tvQuestion;
        this.tvQuestionFib = tvQuestionFib;
        this.tvQuestionInstantSolution = tvQuestionInstantSolution;
        this.tvReportError = tvReportError;
        this.tvUid = tvUid;
        this.unmarkForReview = unmarkForReview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentInstantTestSeriesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentInstantTestSeriesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_instant_test_series, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentInstantTestSeriesBinding bind(View rootView) {
        int i = R.id.LLFIBquestion;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLFIBquestion);
        if (linearLayout != null) {
            i = R.id.LLmatchinquestion;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLmatchinquestion);
            if (linearLayout2 != null) {
                i = R.id.checkBox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.checkBox);
                if (checkBox != null) {
                    i = R.id.explanationLL;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.explanationLL);
                    if (linearLayout3 != null) {
                        i = R.id.explanationTV;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.explanationTV);
                        if (textView != null) {
                            i = R.id.img_bookmark;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_bookmark);
                            if (imageView != null) {
                                i = R.id.mark_for_review;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mark_for_review);
                                if (textView2 != null) {
                                    i = R.id.mcqoptions;
                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                                    if (linearLayout4 != null) {
                                        NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                                        i = R.id.question_layout1;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_layout1);
                                        if (relativeLayout != null) {
                                            i = R.id.remove_mark_for_review;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remove_mark_for_review);
                                            if (textView3 != null) {
                                                i = R.id.rvfibquestion1;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvfibquestion1);
                                                if (recyclerView != null) {
                                                    i = R.id.rvmatchinquestion1;
                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion1);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.rvmatchinquestion2;
                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion2);
                                                        if (recyclerView3 != null) {
                                                            i = R.id.save_mark_for_review;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_mark_for_review);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_email;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_email);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_question;
                                                                    MathView mathView = (MathView) ViewBindings.findChildViewById(rootView, R.id.tv_question);
                                                                    if (mathView != null) {
                                                                        i = R.id.tv_question_fib;
                                                                        MathView mathView2 = (MathView) ViewBindings.findChildViewById(rootView, R.id.tv_question_fib);
                                                                        if (mathView2 != null) {
                                                                            i = R.id.tv_question_instant_solution;
                                                                            MathView mathView3 = (MathView) ViewBindings.findChildViewById(rootView, R.id.tv_question_instant_solution);
                                                                            if (mathView3 != null) {
                                                                                i = R.id.tv_report_error;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_report_error);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.tv_uid;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uid);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.unmark_for_review;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unmark_for_review);
                                                                                        if (textView8 != null) {
                                                                                            return new FragmentInstantTestSeriesBinding(nestedScrollView, linearLayout, linearLayout2, checkBox, linearLayout3, textView, imageView, textView2, linearLayout4, nestedScrollView, relativeLayout, textView3, recyclerView, recyclerView2, recyclerView3, textView4, textView5, mathView, mathView2, mathView3, textView6, textView7, textView8);
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
