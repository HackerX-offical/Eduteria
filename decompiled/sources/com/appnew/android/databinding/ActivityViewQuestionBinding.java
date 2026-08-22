package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityViewQuestionBinding implements ViewBinding {
    public final LinearLayout bottomLinearLayout;
    public final FrameLayout btnNext;
    public final FrameLayout btnPrev;
    public final TextView changelang;
    public final ImageView imgPause;
    public final Toolbar mainToolbar;
    public final TextView nextTV;
    public final RecyclerView optionViewRecycler;
    public final ImageView questionBookmark;
    public final LinearLayout reviewExplanationLL;
    public final ClickableWebView reviewExplanationTV;
    public final RelativeLayout rlTime;
    private final ConstraintLayout rootView;
    public final TextView toolbarTitleTV;
    public final TextView tvQuestionnumber;
    public final TextView tvTime;
    public final ClickableWebView viewQuestion;
    public final ImageView viewQuestionBack;

    private ActivityViewQuestionBinding(ConstraintLayout rootView, LinearLayout bottomLinearLayout, FrameLayout btnNext, FrameLayout btnPrev, TextView changelang, ImageView imgPause, Toolbar mainToolbar, TextView nextTV, RecyclerView optionViewRecycler, ImageView questionBookmark, LinearLayout reviewExplanationLL, ClickableWebView reviewExplanationTV, RelativeLayout rlTime, TextView toolbarTitleTV, TextView tvQuestionnumber, TextView tvTime, ClickableWebView viewQuestion, ImageView viewQuestionBack) {
        this.rootView = rootView;
        this.bottomLinearLayout = bottomLinearLayout;
        this.btnNext = btnNext;
        this.btnPrev = btnPrev;
        this.changelang = changelang;
        this.imgPause = imgPause;
        this.mainToolbar = mainToolbar;
        this.nextTV = nextTV;
        this.optionViewRecycler = optionViewRecycler;
        this.questionBookmark = questionBookmark;
        this.reviewExplanationLL = reviewExplanationLL;
        this.reviewExplanationTV = reviewExplanationTV;
        this.rlTime = rlTime;
        this.toolbarTitleTV = toolbarTitleTV;
        this.tvQuestionnumber = tvQuestionnumber;
        this.tvTime = tvTime;
        this.viewQuestion = viewQuestion;
        this.viewQuestionBack = viewQuestionBack;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityViewQuestionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityViewQuestionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_view_question, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityViewQuestionBinding bind(View rootView) {
        int i = R.id.bottom_linear_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bottom_linear_layout);
        if (linearLayout != null) {
            i = R.id.btn_next;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_next);
            if (frameLayout != null) {
                i = R.id.btn_prev;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.btn_prev);
                if (frameLayout2 != null) {
                    i = R.id.changelang;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.changelang);
                    if (textView != null) {
                        i = R.id.img_pause;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_pause);
                        if (imageView != null) {
                            i = R.id.main_toolbar;
                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                            if (toolbar != null) {
                                i = R.id.nextTV;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nextTV);
                                if (textView2 != null) {
                                    i = R.id.optionView_recycler;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.optionView_recycler);
                                    if (recyclerView != null) {
                                        i = R.id.question_bookmark;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.question_bookmark);
                                        if (imageView2 != null) {
                                            i = R.id.review_explanationLL;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.review_explanationLL);
                                            if (linearLayout2 != null) {
                                                i = R.id.review_explanationTV;
                                                ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.review_explanationTV);
                                                if (clickableWebView != null) {
                                                    i = R.id.rl_time;
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_time);
                                                    if (relativeLayout != null) {
                                                        i = R.id.toolbarTitleTV;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_questionnumber;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_questionnumber);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_time;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_time);
                                                                if (textView5 != null) {
                                                                    i = R.id.viewQuestion;
                                                                    ClickableWebView clickableWebView2 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.viewQuestion);
                                                                    if (clickableWebView2 != null) {
                                                                        i = R.id.viewQuestion_back;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.viewQuestion_back);
                                                                        if (imageView3 != null) {
                                                                            return new ActivityViewQuestionBinding((ConstraintLayout) rootView, linearLayout, frameLayout, frameLayout2, textView, imageView, toolbar, textView2, recyclerView, imageView2, linearLayout2, clickableWebView, relativeLayout, textView3, textView4, textView5, clickableWebView2, imageView3);
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
