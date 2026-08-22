package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CustomQuestionListBinding implements ViewBinding {
    public final TextView resultQuestion;
    public final TextView resultQuestionCount;
    public final TextView resultQuestionTime;
    private final LinearLayout rootView;

    private CustomQuestionListBinding(LinearLayout rootView, TextView resultQuestion, TextView resultQuestionCount, TextView resultQuestionTime) {
        this.rootView = rootView;
        this.resultQuestion = resultQuestion;
        this.resultQuestionCount = resultQuestionCount;
        this.resultQuestionTime = resultQuestionTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CustomQuestionListBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CustomQuestionListBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.custom_question_list, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CustomQuestionListBinding bind(View rootView) {
        int i = R.id.result_question;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.result_question);
        if (textView != null) {
            i = R.id.result_question_count;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.result_question_count);
            if (textView2 != null) {
                i = R.id.result_question_time;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.result_question_time);
                if (textView3 != null) {
                    return new CustomQuestionListBinding((LinearLayout) rootView, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
