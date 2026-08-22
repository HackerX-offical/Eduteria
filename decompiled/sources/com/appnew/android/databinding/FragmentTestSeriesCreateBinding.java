package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTestSeriesCreateBinding implements ViewBinding {
    public final LinearLayout LLFIBquestion;
    public final LinearLayout LLmatchinquestion;
    public final ImageView imgBookmark;
    public final LinearLayout mcqoptions;
    public final NestedScrollView nestedSV;
    public final RelativeLayout questionLayout1;
    private final NestedScrollView rootView;
    public final RecyclerView rvfibquestion1;
    public final RecyclerView rvmatchinquestion1;
    public final RecyclerView rvmatchinquestion2;
    public final ClickableWebView tvQuestion;
    public final ClickableWebView tvQuestionFib;

    private FragmentTestSeriesCreateBinding(NestedScrollView rootView, LinearLayout LLFIBquestion, LinearLayout LLmatchinquestion, ImageView imgBookmark, LinearLayout mcqoptions, NestedScrollView nestedSV, RelativeLayout questionLayout1, RecyclerView rvfibquestion1, RecyclerView rvmatchinquestion1, RecyclerView rvmatchinquestion2, ClickableWebView tvQuestion, ClickableWebView tvQuestionFib) {
        this.rootView = rootView;
        this.LLFIBquestion = LLFIBquestion;
        this.LLmatchinquestion = LLmatchinquestion;
        this.imgBookmark = imgBookmark;
        this.mcqoptions = mcqoptions;
        this.nestedSV = nestedSV;
        this.questionLayout1 = questionLayout1;
        this.rvfibquestion1 = rvfibquestion1;
        this.rvmatchinquestion1 = rvmatchinquestion1;
        this.rvmatchinquestion2 = rvmatchinquestion2;
        this.tvQuestion = tvQuestion;
        this.tvQuestionFib = tvQuestionFib;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentTestSeriesCreateBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentTestSeriesCreateBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_test_series_create, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentTestSeriesCreateBinding bind(View rootView) {
        int i = R.id.LLFIBquestion;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLFIBquestion);
        if (linearLayout != null) {
            i = R.id.LLmatchinquestion;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.LLmatchinquestion);
            if (linearLayout2 != null) {
                i = R.id.img_bookmark;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_bookmark);
                if (imageView != null) {
                    i = R.id.mcqoptions;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.mcqoptions);
                    if (linearLayout3 != null) {
                        NestedScrollView nestedScrollView = (NestedScrollView) rootView;
                        i = R.id.question_layout1;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.question_layout1);
                        if (relativeLayout != null) {
                            i = R.id.rvfibquestion1;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvfibquestion1);
                            if (recyclerView != null) {
                                i = R.id.rvmatchinquestion1;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion1);
                                if (recyclerView2 != null) {
                                    i = R.id.rvmatchinquestion2;
                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.rvmatchinquestion2);
                                    if (recyclerView3 != null) {
                                        i = R.id.tv_question;
                                        ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question);
                                        if (clickableWebView != null) {
                                            i = R.id.tv_question_fib;
                                            ClickableWebView clickableWebView2 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.tv_question_fib);
                                            if (clickableWebView2 != null) {
                                                return new FragmentTestSeriesCreateBinding(nestedScrollView, linearLayout, linearLayout2, imageView, linearLayout3, nestedScrollView, relativeLayout, recyclerView, recyclerView2, recyclerView3, clickableWebView, clickableWebView2);
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
