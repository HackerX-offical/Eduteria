package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PollquestionNextToppersBinding implements ViewBinding {
    public final Button buyNowBtn;
    public final Button cancel;
    public final LinearLayout cvrQuestions;
    private final RelativeLayout rootView;
    public final Button submit;
    public final TextView txt1;
    public final LayoutItemPollQuestionsNextToppersBinding typeA;
    public final LayoutItemPollQuestionsNextToppersBinding typeB;
    public final LayoutItemPollQuestionsNextToppersBinding typeC;
    public final LayoutItemPollQuestionsNextToppersBinding typeD;

    private PollquestionNextToppersBinding(RelativeLayout rootView, Button buyNowBtn, Button cancel, LinearLayout cvrQuestions, Button submit, TextView txt1, LayoutItemPollQuestionsNextToppersBinding typeA, LayoutItemPollQuestionsNextToppersBinding typeB, LayoutItemPollQuestionsNextToppersBinding typeC, LayoutItemPollQuestionsNextToppersBinding typeD) {
        this.rootView = rootView;
        this.buyNowBtn = buyNowBtn;
        this.cancel = cancel;
        this.cvrQuestions = cvrQuestions;
        this.submit = submit;
        this.txt1 = txt1;
        this.typeA = typeA;
        this.typeB = typeB;
        this.typeC = typeC;
        this.typeD = typeD;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PollquestionNextToppersBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PollquestionNextToppersBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pollquestion_next_toppers, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PollquestionNextToppersBinding bind(View rootView) {
        int i = R.id.buyNowBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
        if (button != null) {
            i = R.id.cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.cancel);
            if (button2 != null) {
                i = R.id.cvrQuestions;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrQuestions);
                if (linearLayout != null) {
                    i = R.id.submit;
                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                    if (button3 != null) {
                        i = R.id.txt1;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt1);
                        if (textView != null) {
                            i = R.id.typeA;
                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.typeA);
                            if (viewFindChildViewById != null) {
                                LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById);
                                i = R.id.typeB;
                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.typeB);
                                if (viewFindChildViewById2 != null) {
                                    LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind2 = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById2);
                                    i = R.id.typeC;
                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.typeC);
                                    if (viewFindChildViewById3 != null) {
                                        LayoutItemPollQuestionsNextToppersBinding layoutItemPollQuestionsNextToppersBindingBind3 = LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById3);
                                        i = R.id.typeD;
                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.typeD);
                                        if (viewFindChildViewById4 != null) {
                                            return new PollquestionNextToppersBinding((RelativeLayout) rootView, button, button2, linearLayout, button3, textView, layoutItemPollQuestionsNextToppersBindingBind, layoutItemPollQuestionsNextToppersBindingBind2, layoutItemPollQuestionsNextToppersBindingBind3, LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById4));
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
