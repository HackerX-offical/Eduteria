package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.appnew.android.Courses.Fragment.TestSeriesOptionWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class QuizSolutionDescriptionBinding implements ViewBinding {
    public final TestSeriesOptionWebView descriptionTV;
    private final TestSeriesOptionWebView rootView;

    private QuizSolutionDescriptionBinding(TestSeriesOptionWebView rootView, TestSeriesOptionWebView descriptionTV) {
        this.rootView = rootView;
        this.descriptionTV = descriptionTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TestSeriesOptionWebView getRoot() {
        return this.rootView;
    }

    public static QuizSolutionDescriptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static QuizSolutionDescriptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.quiz_solution_description, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static QuizSolutionDescriptionBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TestSeriesOptionWebView testSeriesOptionWebView = (TestSeriesOptionWebView) rootView;
        return new QuizSolutionDescriptionBinding(testSeriesOptionWebView, testSeriesOptionWebView);
    }
}
