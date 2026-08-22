package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Courses.Fragment.TestSeriesOptionWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentQuizBinding implements ViewBinding {
    public final ImageView bookmarkQues;
    public final RelativeLayout clickBlockView;
    public final TextView coins;
    public final CardView controlLayoutCV;
    public final TextView correctAns;
    public final LinearLayout correctIncorrectLL;
    public final RelativeLayout finishQuizLL;
    public final TextView incorrectAns;
    public final Button nextQuizBT;
    public final ImageView playBtn;
    public final TextView playTextTV;
    public final Button prevQuizBT;
    public final CardView quesCV;
    public final RelativeLayout quesCoontainerRL;
    public final TextView quesCount;
    public final RecyclerView quesRV;
    public final CardView questionQuizCV;
    public final TestSeriesOptionWebView questionQuizTV;
    public final LinearLayout quizLL;
    public final LinearLayout quizQuestionLL;
    public final TextView quizQuestionNum;
    public final RelativeLayout quizSwipeRL;
    public final RelativeLayout resumeQuizLL;
    private final RelativeLayout rootView;
    public final ScrollView scrollView;
    public final RelativeLayout swipeRL;
    public final ImageView tickblue;
    public final TextView timeSlot;
    public final ProgressBar timerProgress;

    private FragmentQuizBinding(RelativeLayout rootView, ImageView bookmarkQues, RelativeLayout clickBlockView, TextView coins, CardView controlLayoutCV, TextView correctAns, LinearLayout correctIncorrectLL, RelativeLayout finishQuizLL, TextView incorrectAns, Button nextQuizBT, ImageView playBtn, TextView playTextTV, Button prevQuizBT, CardView quesCV, RelativeLayout quesCoontainerRL, TextView quesCount, RecyclerView quesRV, CardView questionQuizCV, TestSeriesOptionWebView questionQuizTV, LinearLayout quizLL, LinearLayout quizQuestionLL, TextView quizQuestionNum, RelativeLayout quizSwipeRL, RelativeLayout resumeQuizLL, ScrollView scrollView, RelativeLayout swipeRL, ImageView tickblue, TextView timeSlot, ProgressBar timerProgress) {
        this.rootView = rootView;
        this.bookmarkQues = bookmarkQues;
        this.clickBlockView = clickBlockView;
        this.coins = coins;
        this.controlLayoutCV = controlLayoutCV;
        this.correctAns = correctAns;
        this.correctIncorrectLL = correctIncorrectLL;
        this.finishQuizLL = finishQuizLL;
        this.incorrectAns = incorrectAns;
        this.nextQuizBT = nextQuizBT;
        this.playBtn = playBtn;
        this.playTextTV = playTextTV;
        this.prevQuizBT = prevQuizBT;
        this.quesCV = quesCV;
        this.quesCoontainerRL = quesCoontainerRL;
        this.quesCount = quesCount;
        this.quesRV = quesRV;
        this.questionQuizCV = questionQuizCV;
        this.questionQuizTV = questionQuizTV;
        this.quizLL = quizLL;
        this.quizQuestionLL = quizQuestionLL;
        this.quizQuestionNum = quizQuestionNum;
        this.quizSwipeRL = quizSwipeRL;
        this.resumeQuizLL = resumeQuizLL;
        this.scrollView = scrollView;
        this.swipeRL = swipeRL;
        this.tickblue = tickblue;
        this.timeSlot = timeSlot;
        this.timerProgress = timerProgress;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentQuizBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentQuizBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_quiz, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentQuizBinding bind(View rootView) {
        int i = R.id.bookmark_ques;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.bookmark_ques);
        if (imageView != null) {
            i = R.id.clickBlockView;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.clickBlockView);
            if (relativeLayout != null) {
                i = R.id.coins;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.coins);
                if (textView != null) {
                    i = R.id.controlLayoutCV;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.controlLayoutCV);
                    if (cardView != null) {
                        i = R.id.correctAns;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.correctAns);
                        if (textView2 != null) {
                            i = R.id.correctIncorrectLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.correctIncorrectLL);
                            if (linearLayout != null) {
                                i = R.id.finishQuizLL;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.finishQuizLL);
                                if (relativeLayout2 != null) {
                                    i = R.id.incorrectAns;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.incorrectAns);
                                    if (textView3 != null) {
                                        i = R.id.nextQuizBT;
                                        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.nextQuizBT);
                                        if (button != null) {
                                            i = R.id.playBtn;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.playBtn);
                                            if (imageView2 != null) {
                                                i = R.id.playTextTV;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.playTextTV);
                                                if (textView4 != null) {
                                                    i = R.id.prevQuizBT;
                                                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.prevQuizBT);
                                                    if (button2 != null) {
                                                        i = R.id.quesCV;
                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.quesCV);
                                                        if (cardView2 != null) {
                                                            i = R.id.ques_coontainerRL;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ques_coontainerRL);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.quesCount;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.quesCount);
                                                                if (textView5 != null) {
                                                                    i = R.id.quesRV;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.quesRV);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.questionQuizCV;
                                                                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.questionQuizCV);
                                                                        if (cardView3 != null) {
                                                                            i = R.id.questionQuizTV;
                                                                            TestSeriesOptionWebView testSeriesOptionWebView = (TestSeriesOptionWebView) ViewBindings.findChildViewById(rootView, R.id.questionQuizTV);
                                                                            if (testSeriesOptionWebView != null) {
                                                                                i = R.id.quizLL;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.quizLL);
                                                                                if (linearLayout2 != null) {
                                                                                    i = R.id.quizQuestionLL;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.quizQuestionLL);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.quiz_question_num;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.quiz_question_num);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.quiz_swipe_RL;
                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.quiz_swipe_RL);
                                                                                            if (relativeLayout4 != null) {
                                                                                                i = R.id.resumeQuizLL;
                                                                                                RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.resumeQuizLL);
                                                                                                if (relativeLayout5 != null) {
                                                                                                    i = R.id.scrollView;
                                                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                                                                                    if (scrollView != null) {
                                                                                                        i = R.id.swipeRL;
                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.swipeRL);
                                                                                                        if (relativeLayout6 != null) {
                                                                                                            i = R.id.tickblue;
                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.tickblue);
                                                                                                            if (imageView3 != null) {
                                                                                                                i = R.id.time_slot;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.time_slot);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.timer_progress;
                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.timer_progress);
                                                                                                                    if (progressBar != null) {
                                                                                                                        return new FragmentQuizBinding((RelativeLayout) rootView, imageView, relativeLayout, textView, cardView, textView2, linearLayout, relativeLayout2, textView3, button, imageView2, textView4, button2, cardView2, relativeLayout3, textView5, recyclerView, cardView3, testSeriesOptionWebView, linearLayout2, linearLayout3, textView6, relativeLayout4, relativeLayout5, scrollView, relativeLayout6, imageView3, textView7, progressBar);
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
