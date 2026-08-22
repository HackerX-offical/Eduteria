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
public final class FragmentViewSolutionBinding implements ViewBinding {
    public final LinearLayout LLmatchinquestion;
    public final LinearLayout explanationLL;
    public final ClickableWebView explanationTV;
    public final ImageView imgBookmark;
    public final TextView maxmarks;
    public final LinearLayout mcqoptions;
    public final TextView minmarks;
    public final NestedScrollView nestedSV;
    public final TextView onScreenTxt;
    public final TextView onscreenValue;
    public final TextView questionStatus;
    public final RelativeLayout questionsolLayout1;
    private final NestedScrollView rootView;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final ClickableWebView tvQuestion;
    public final ClickableWebView tvQuestionFib;
    public final ClickableWebView tvQuestionPG;
    public final TextView tvReportError;
    public final TextView tvUid;
    public final TextView userEmailTV;
    public final TextView videosolution;
    public final TextView yourAns;
    public final TextView yourAnsTxt;

    private FragmentViewSolutionBinding(NestedScrollView rootView, LinearLayout LLmatchinquestion, LinearLayout explanationLL, ClickableWebView explanationTV, ImageView imgBookmark, TextView maxmarks, LinearLayout mcqoptions, TextView minmarks, NestedScrollView nestedSV, TextView onScreenTxt, TextView onscreenValue, TextView questionStatus, RelativeLayout questionsolLayout1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, ClickableWebView tvQuestion, ClickableWebView tvQuestionFib, ClickableWebView tvQuestionPG, TextView tvReportError, TextView tvUid, TextView userEmailTV, TextView videosolution, TextView yourAns, TextView yourAnsTxt) {
        this.rootView = rootView;
        this.LLmatchinquestion = LLmatchinquestion;
        this.explanationLL = explanationLL;
        this.explanationTV = explanationTV;
        this.imgBookmark = imgBookmark;
        this.maxmarks = maxmarks;
        this.mcqoptions = mcqoptions;
        this.minmarks = minmarks;
        this.nestedSV = nestedSV;
        this.onScreenTxt = onScreenTxt;
        this.onscreenValue = onscreenValue;
        this.questionStatus = questionStatus;
        this.questionsolLayout1 = questionsolLayout1;
        this.rvmatchinquestion1 = rvmatchinquestion1;
        this.rvmatchinquestion2 = rvmatchinquestion2;
        this.tvQuestion = tvQuestion;
        this.tvQuestionFib = tvQuestionFib;
        this.tvQuestionPG = tvQuestionPG;
        this.tvReportError = tvReportError;
        this.tvUid = tvUid;
        this.userEmailTV = userEmailTV;
        this.videosolution = videosolution;
        this.yourAns = yourAns;
        this.yourAnsTxt = yourAnsTxt;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentViewSolutionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentViewSolutionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_view_solution, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentViewSolutionBinding bind(View rootView) {
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
                        i = R.id.maxmarks;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.maxmarks);
                        if (textView != null) {
                            i = R.id.mcqoptions;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                            if (linearLayout3 != null) {
                                i = R.id.minmarks;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.minmarks);
                                if (textView2 != null) {
                                    NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                                    i = R.id.on_screen_txt;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.on_screen_txt);
                                    if (textView3 != null) {
                                        i = R.id.onscreen_value;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.onscreen_value);
                                        if (textView4 != null) {
                                            i = R.id.question_status;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.question_status);
                                            if (textView5 != null) {
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
                                                                    i = R.id.tv_question_PG;
                                                                    ClickableWebView clickableWebView4 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question_PG);
                                                                    if (clickableWebView4 != null) {
                                                                        i = R.id.tv_report_error;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_report_error);
                                                                        if (textView6 != null) {
                                                                            i = R.id.tv_uid;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_uid);
                                                                            if (textView7 != null) {
                                                                                i = R.id.userEmailTV;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userEmailTV);
                                                                                if (textView8 != null) {
                                                                                    i = R.id.videosolution;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.videosolution);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.your_ans;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.your_ans);
                                                                                        if (textView10 != null) {
                                                                                            i = R.id.your_ans_txt;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.your_ans_txt);
                                                                                            if (textView11 != null) {
                                                                                                return new FragmentViewSolutionBinding(nestedScrollView, linearLayout, linearLayout2, clickableWebView, imageView, textView, linearLayout3, textView2, nestedScrollView, textView3, textView4, textView5, relativeLayout, recyclerView, recyclerView2, clickableWebView2, clickableWebView3, clickableWebView4, textView6, textView7, textView8, textView9, textView10, textView11);
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
