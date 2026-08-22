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
public final class FragmentRevisionSolutionBinding implements ViewBinding {
    public final LinearLayout LLmatchinquestion;
    public final ImageView imgBookmark;
    public final LinearLayout mcqoptions;
    public final NestedScrollView nestedSV;
    public final TextView questionStatus;
    public final RelativeLayout questionsolLayout1;
    private final NestedScrollView rootView;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final ClickableWebView tvQuestion;
    public final TextView tvQuestionFib;
    public final TextView tvUid;
    public final TextView userEmailTV;
    public final TextView yourAns;

    private FragmentRevisionSolutionBinding(NestedScrollView rootView, LinearLayout LLmatchinquestion, ImageView imgBookmark, LinearLayout mcqoptions, NestedScrollView nestedSV, TextView questionStatus, RelativeLayout questionsolLayout1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, ClickableWebView tvQuestion, TextView tvQuestionFib, TextView tvUid, TextView userEmailTV, TextView yourAns) {
        this.rootView = rootView;
        this.LLmatchinquestion = LLmatchinquestion;
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
        this.yourAns = yourAns;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentRevisionSolutionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentRevisionSolutionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_revision_solution, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRevisionSolutionBinding bind(View rootView) {
        int i = R.id.LLmatchinquestion;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLmatchinquestion);
        if (linearLayout != null) {
            i = R.id.img_bookmark;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_bookmark);
            if (imageView != null) {
                i = R.id.mcqoptions;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                if (linearLayout2 != null) {
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
                                    ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question);
                                    if (clickableWebView != null) {
                                        i = R.id.tv_question_fib;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_question_fib);
                                        if (textView2 != null) {
                                            i = R.id.tv_uid;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uid);
                                            if (textView3 != null) {
                                                i = R.id.userEmailTV;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userEmailTV);
                                                if (textView4 != null) {
                                                    i = R.id.your_ans;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.your_ans);
                                                    if (textView5 != null) {
                                                        return new FragmentRevisionSolutionBinding(nestedScrollView, linearLayout, imageView, linearLayout2, nestedScrollView, textView, relativeLayout, recyclerView, recyclerView2, clickableWebView, textView2, textView3, textView4, textView5);
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
