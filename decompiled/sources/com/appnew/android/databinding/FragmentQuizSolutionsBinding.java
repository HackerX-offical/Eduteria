package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentQuizSolutionsBinding implements ViewBinding {
    public final CardView controlLayoutCV;
    public final LinearLayout descriptionTVLL;
    public final Button nextQuizBT;
    public final Button prevQuizBT;
    public final TextView quesCount;
    public final CardView questionQuizCV;
    public final RelativeLayout quizDescriptionContainerRL;
    public final LinearLayout quizQuestionLL;
    private final LinearLayout rootView;
    public final ScrollView scrollView;

    private FragmentQuizSolutionsBinding(LinearLayout rootView, CardView controlLayoutCV, LinearLayout descriptionTVLL, Button nextQuizBT, Button prevQuizBT, TextView quesCount, CardView questionQuizCV, RelativeLayout quizDescriptionContainerRL, LinearLayout quizQuestionLL, ScrollView scrollView) {
        this.rootView = rootView;
        this.controlLayoutCV = controlLayoutCV;
        this.descriptionTVLL = descriptionTVLL;
        this.nextQuizBT = nextQuizBT;
        this.prevQuizBT = prevQuizBT;
        this.quesCount = quesCount;
        this.questionQuizCV = questionQuizCV;
        this.quizDescriptionContainerRL = quizDescriptionContainerRL;
        this.quizQuestionLL = quizQuestionLL;
        this.scrollView = scrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentQuizSolutionsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentQuizSolutionsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_quiz_solutions, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentQuizSolutionsBinding bind(View rootView) {
        int i = R.id.controlLayoutCV;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.controlLayoutCV);
        if (cardView != null) {
            i = R.id.descriptionTVLL;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.descriptionTVLL);
            if (linearLayout != null) {
                i = R.id.nextQuizBT;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.nextQuizBT);
                if (button != null) {
                    i = R.id.prevQuizBT;
                    Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.prevQuizBT);
                    if (button2 != null) {
                        i = R.id.quesCount;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.quesCount);
                        if (textView != null) {
                            i = R.id.questionQuizCV;
                            CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.questionQuizCV);
                            if (cardView2 != null) {
                                i = R.id.quiz_description_containerRL;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.quiz_description_containerRL);
                                if (relativeLayout != null) {
                                    i = R.id.quizQuestionLL;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.quizQuestionLL);
                                    if (linearLayout2 != null) {
                                        i = R.id.scrollView;
                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(rootView, R.id.scrollView);
                                        if (scrollView != null) {
                                            return new FragmentQuizSolutionsBinding((LinearLayout) rootView, cardView, linearLayout, button, button2, textView, cardView2, relativeLayout, linearLayout2, scrollView);
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
