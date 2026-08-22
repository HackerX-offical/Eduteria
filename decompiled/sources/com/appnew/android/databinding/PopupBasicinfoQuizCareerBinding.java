package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class PopupBasicinfoQuizCareerBinding extends ViewDataBinding {
    public final RelativeLayout basicInfoDialogLL;
    public final CheckBox checkBox;
    public final TextView generalInstrValueTV;
    public final LinearLayout generalLayout;
    public final TextView gerneralTxt;
    public final LinearLayout languageLLayout;
    public final RecyclerView languageRecycler;
    public final TextView languageSpinnerTV;
    public final TextView markPerQuesTV;
    public final TextView marksCorrectValueTV;
    public final TextView marksTextValueTV;
    public final TextView marksWrongValueTV;
    public final TextView maxMarksTV;
    public final TextView negMarkPerQuesTV;
    public final TextView numQuesValueTV;
    public final ImageView quizImageIV;
    public final TextView quizTimeValueTV;
    public final TextView quizTitleTV;
    public final TextView remarksTV;
    public final TextView secNameTV;
    public final LinearLayout sectionListLL;
    public final LinearLayout sectionTime;
    public final TextView sectionValueTV;
    public final Button startQuizBtn;
    public final TextView totNoAttmtsTV;
    public final TextView totQuesTV;
    public final TextView totTimeTV;

    protected PopupBasicinfoQuizCareerBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout basicInfoDialogLL, CheckBox checkBox, TextView generalInstrValueTV, LinearLayout generalLayout, TextView gerneralTxt, LinearLayout languageLLayout, RecyclerView languageRecycler, TextView languageSpinnerTV, TextView markPerQuesTV, TextView marksCorrectValueTV, TextView marksTextValueTV, TextView marksWrongValueTV, TextView maxMarksTV, TextView negMarkPerQuesTV, TextView numQuesValueTV, ImageView quizImageIV, TextView quizTimeValueTV, TextView quizTitleTV, TextView remarksTV, TextView secNameTV, LinearLayout sectionListLL, LinearLayout sectionTime, TextView sectionValueTV, Button startQuizBtn, TextView totNoAttmtsTV, TextView totQuesTV, TextView totTimeTV) {
        super(_bindingComponent, _root, _localFieldCount);
        this.basicInfoDialogLL = basicInfoDialogLL;
        this.checkBox = checkBox;
        this.generalInstrValueTV = generalInstrValueTV;
        this.generalLayout = generalLayout;
        this.gerneralTxt = gerneralTxt;
        this.languageLLayout = languageLLayout;
        this.languageRecycler = languageRecycler;
        this.languageSpinnerTV = languageSpinnerTV;
        this.markPerQuesTV = markPerQuesTV;
        this.marksCorrectValueTV = marksCorrectValueTV;
        this.marksTextValueTV = marksTextValueTV;
        this.marksWrongValueTV = marksWrongValueTV;
        this.maxMarksTV = maxMarksTV;
        this.negMarkPerQuesTV = negMarkPerQuesTV;
        this.numQuesValueTV = numQuesValueTV;
        this.quizImageIV = quizImageIV;
        this.quizTimeValueTV = quizTimeValueTV;
        this.quizTitleTV = quizTitleTV;
        this.remarksTV = remarksTV;
        this.secNameTV = secNameTV;
        this.sectionListLL = sectionListLL;
        this.sectionTime = sectionTime;
        this.sectionValueTV = sectionValueTV;
        this.startQuizBtn = startQuizBtn;
        this.totNoAttmtsTV = totNoAttmtsTV;
        this.totQuesTV = totQuesTV;
        this.totTimeTV = totTimeTV;
    }

    public static PopupBasicinfoQuizCareerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupBasicinfoQuizCareerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (PopupBasicinfoQuizCareerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.popup_basicinfo_quiz_career, root, attachToRoot, component);
    }

    public static PopupBasicinfoQuizCareerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupBasicinfoQuizCareerBinding inflate(LayoutInflater inflater, Object component) {
        return (PopupBasicinfoQuizCareerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.popup_basicinfo_quiz_career, null, false, component);
    }

    public static PopupBasicinfoQuizCareerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static PopupBasicinfoQuizCareerBinding bind(View view, Object component) {
        return (PopupBasicinfoQuizCareerBinding) bind(component, view, R.layout.popup_basicinfo_quiz_career);
    }
}
