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
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSeriesBinding implements ViewBinding {
    public final LinearLayout LLFIBquestion;
    public final LinearLayout LLmatchinquestion;
    public final CheckBox checkBox;
    public final LinearLayout explanationLL;
    public final TextView explanationTV;
    public final ImageView imgBookmark;
    public final LinearLayout llTimerNegPos;
    public final TextView mandatoryType;
    public final TextView markForReview;
    public final LinearLayout mcqoptions;
    public final TextView multipleChoiceInstruction;
    public final TextView negMark;
    public final NestedScrollView nestedSV;
    public final TextView posMark;
    public final RelativeLayout questionLayout1;
    public final TextView removeMarkForReview;
    private final NestedScrollView rootView;
    public final RecyclerView rvfibquestion1;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final TextView saveMarkForReview;
    public final TextView tvEmail;
    public final ClickableWebView tvQuestion;
    public final ClickableWebView tvQuestionFib;
    public final TextView tvReportError;
    public final TextView tvTimer;
    public final TextView tvUid;
    public final TextView unmarkForReview;

    private FragmentTestSeriesBinding(NestedScrollView rootView, LinearLayout LLFIBquestion, LinearLayout LLmatchinquestion, CheckBox checkBox, LinearLayout explanationLL, TextView explanationTV, ImageView imgBookmark, LinearLayout llTimerNegPos, TextView mandatoryType, TextView markForReview, LinearLayout mcqoptions, TextView multipleChoiceInstruction, TextView negMark, NestedScrollView nestedSV, TextView posMark, RelativeLayout questionLayout1, TextView removeMarkForReview, RecyclerView rvfibquestion1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, TextView saveMarkForReview, TextView tvEmail, ClickableWebView tvQuestion, ClickableWebView tvQuestionFib, TextView tvReportError, TextView tvTimer, TextView tvUid, TextView unmarkForReview) {
        this.rootView = rootView;
        this.LLFIBquestion = LLFIBquestion;
        this.LLmatchinquestion = LLmatchinquestion;
        this.checkBox = checkBox;
        this.explanationLL = explanationLL;
        this.explanationTV = explanationTV;
        this.imgBookmark = imgBookmark;
        this.llTimerNegPos = llTimerNegPos;
        this.mandatoryType = mandatoryType;
        this.markForReview = markForReview;
        this.mcqoptions = mcqoptions;
        this.multipleChoiceInstruction = multipleChoiceInstruction;
        this.negMark = negMark;
        this.nestedSV = nestedSV;
        this.posMark = posMark;
        this.questionLayout1 = questionLayout1;
        this.removeMarkForReview = removeMarkForReview;
        this.rvfibquestion1 = rvfibquestion1;
        this.rvmatchinquestion1 = rvmatchinquestion1;
        this.rvmatchinquestion2 = rvmatchinquestion2;
        this.saveMarkForReview = saveMarkForReview;
        this.tvEmail = tvEmail;
        this.tvQuestion = tvQuestion;
        this.tvQuestionFib = tvQuestionFib;
        this.tvReportError = tvReportError;
        this.tvTimer = tvTimer;
        this.tvUid = tvUid;
        this.unmarkForReview = unmarkForReview;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentTestSeriesBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSeriesBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSeriesBinding bind(View rootView) {
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
                                i = R.id.llTimerNegPos;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.llTimerNegPos);
                                if (linearLayout4 != null) {
                                    i = R.id.mandatoryType;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mandatoryType);
                                    if (textView2 != null) {
                                        i = R.id.mark_for_review;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mark_for_review);
                                        if (textView3 != null) {
                                            i = R.id.mcqoptions;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                                            if (linearLayout5 != null) {
                                                i = R.id.multiple_choice_instruction;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.multiple_choice_instruction);
                                                if (textView4 != null) {
                                                    i = R.id.neg_mark;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.neg_mark);
                                                    if (textView5 != null) {
                                                        NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                                                        i = R.id.pos_mark;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pos_mark);
                                                        if (textView6 != null) {
                                                            i = R.id.question_layout1;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_layout1);
                                                            if (relativeLayout != null) {
                                                                i = R.id.remove_mark_for_review;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.remove_mark_for_review);
                                                                if (textView7 != null) {
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
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_mark_for_review);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.tv_email;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_email);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.tv_question;
                                                                                        ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question);
                                                                                        if (clickableWebView != null) {
                                                                                            i = R.id.tv_question_fib;
                                                                                            ClickableWebView clickableWebView2 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question_fib);
                                                                                            if (clickableWebView2 != null) {
                                                                                                i = R.id.tv_report_error;
                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_report_error);
                                                                                                if (textView10 != null) {
                                                                                                    i = R.id.tv_timer;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_timer);
                                                                                                    if (textView11 != null) {
                                                                                                        i = R.id.tv_uid;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uid);
                                                                                                        if (textView12 != null) {
                                                                                                            i = R.id.unmark_for_review;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unmark_for_review);
                                                                                                            if (textView13 != null) {
                                                                                                                return new FragmentTestSeriesBinding(nestedScrollView, linearLayout, linearLayout2, checkBox, linearLayout3, textView, imageView, linearLayout4, textView2, textView3, linearLayout5, textView4, textView5, nestedScrollView, textView6, relativeLayout, textView7, recyclerView, recyclerView2, recyclerView3, textView8, textView9, clickableWebView, clickableWebView2, textView10, textView11, textView12, textView13);
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
