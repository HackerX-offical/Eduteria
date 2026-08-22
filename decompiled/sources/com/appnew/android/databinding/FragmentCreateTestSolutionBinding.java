package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public final class FragmentCreateTestSolutionBinding implements ViewBinding {
    public final LinearLayout LLmatchinquestion;
    public final LinearLayout explanationLL;
    public final ClickableWebView explanationTV;
    public final ImageView imgBookmark;
    public final LinearLayout mcqoptions;
    public final NestedScrollView nestedSV;
    public final TextView questionStatus;
    public final RelativeLayout questionsolLayout1;
    private final NestedScrollView rootView;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final ClickableWebView tvQuestion;
    public final ClickableWebView tvQuestionFib;
    public final TextView tvUid;
    public final TextView userEmailTV;
    public final TextView videosolution;
    public final TextView yourAns;

    private FragmentCreateTestSolutionBinding(NestedScrollView rootView, LinearLayout LLmatchinquestion, LinearLayout explanationLL, ClickableWebView explanationTV, ImageView imgBookmark, LinearLayout mcqoptions, NestedScrollView nestedSV, TextView questionStatus, RelativeLayout questionsolLayout1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, ClickableWebView tvQuestion, ClickableWebView tvQuestionFib, TextView tvUid, TextView userEmailTV, TextView videosolution, TextView yourAns) {
        this.rootView = rootView;
        this.LLmatchinquestion = LLmatchinquestion;
        this.explanationLL = explanationLL;
        this.explanationTV = explanationTV;
        this.imgBookmark = imgBookmark;
        this.mcqoptions = mcqoptions;
        this.nestedSV = nestedSV;
        this.questionStatus = questionStatus;
        this.questionsolLayout1 = questionsolLayout1;
        this.rvmatchinquestion1 = rvmatchinquestion1;
        this.rvmatchinquestion2 = rvmatchinquestion2;
        this.tvQuestion = tvQuestion;
        this.tvQuestionFib = tvQuestionFib;
        this.tvUid = tvUid;
        this.userEmailTV = userEmailTV;
        this.videosolution = videosolution;
        this.yourAns = yourAns;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentCreateTestSolutionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentCreateTestSolutionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_create_test_solution, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCreateTestSolutionBinding bind(View rootView) {
        int i = R.id.LLmatchinquestion;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLmatchinquestion);
        if (linearLayout != null) {
            i = R.id.explanationLL;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.explanationLL);
            if (linearLayout2 != null) {
                i = R.id.explanationTV;
                ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.explanationTV);
                if (clickableWebView != null) {
                    i = R.id.img_bookmark;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_bookmark);
                    if (imageView != null) {
                        i = R.id.mcqoptions;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                        if (linearLayout3 != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                            i = R.id.question_status;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_status);
                            if (textView != null) {
                                i = R.id.questionsol_layout1;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.questionsol_layout1);
                                if (relativeLayout != null) {
                                    i = R.id.rvmatchinquestion1;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion1);
                                    if (recyclerView != null) {
                                        i = R.id.rvmatchinquestion2;
                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion2);
                                        if (recyclerView2 != null) {
                                            i = R.id.tv_question;
                                            ClickableWebView clickableWebView2 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question);
                                            if (clickableWebView2 != null) {
                                                i = R.id.tv_question_fib;
                                                ClickableWebView clickableWebView3 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question_fib);
                                                if (clickableWebView3 != null) {
                                                    i = R.id.tv_uid;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uid);
                                                    if (textView2 != null) {
                                                        i = R.id.userEmailTV;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userEmailTV);
                                                        if (textView3 != null) {
                                                            i = R.id.videosolution;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.videosolution);
                                                            if (textView4 != null) {
                                                                i = R.id.your_ans;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.your_ans);
                                                                if (textView5 != null) {
                                                                    return new FragmentCreateTestSolutionBinding(nestedScrollView, linearLayout, linearLayout2, clickableWebView, imageView, linearLayout3, nestedScrollView, textView, relativeLayout, recyclerView, recyclerView2, clickableWebView2, clickableWebView3, textView2, textView3, textView4, textView5);
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
