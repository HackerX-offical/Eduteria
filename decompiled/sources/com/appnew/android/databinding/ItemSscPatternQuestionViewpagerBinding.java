package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemSscPatternQuestionViewpagerBinding extends ViewDataBinding {
    public final ImageView iconTimer;
    public final ImageView imgBookmark;
    public final LinearLayout llRightActions;
    public final TextView mandatoryText;
    public final ImageView markForReview;
    public final LinearLayout negPosContainer;
    public final TextView negativeText;
    public final TextView pgText;
    public final TextView positiveText;
    public final RecyclerView rvOptions;
    public final LinearLayout timeContainer;
    public final LinearLayout timeNegPosContainer;
    public final TextView tvQNumber;
    public final ClickableWebView tvQuestionText;
    public final LinearLayout tvQuestionTextContainer;
    public final ImageView tvReportError;
    public final TextView tvTimer;
    public final View vDiv;

    protected ItemSscPatternQuestionViewpagerBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView iconTimer, ImageView imgBookmark, LinearLayout llRightActions, TextView mandatoryText, ImageView markForReview, LinearLayout negPosContainer, TextView negativeText, TextView pgText, TextView positiveText, RecyclerView rvOptions, LinearLayout timeContainer, LinearLayout timeNegPosContainer, TextView tvQNumber, ClickableWebView tvQuestionText, LinearLayout tvQuestionTextContainer, ImageView tvReportError, TextView tvTimer, View vDiv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.iconTimer = iconTimer;
        this.imgBookmark = imgBookmark;
        this.llRightActions = llRightActions;
        this.mandatoryText = mandatoryText;
        this.markForReview = markForReview;
        this.negPosContainer = negPosContainer;
        this.negativeText = negativeText;
        this.pgText = pgText;
        this.positiveText = positiveText;
        this.rvOptions = rvOptions;
        this.timeContainer = timeContainer;
        this.timeNegPosContainer = timeNegPosContainer;
        this.tvQNumber = tvQNumber;
        this.tvQuestionText = tvQuestionText;
        this.tvQuestionTextContainer = tvQuestionTextContainer;
        this.tvReportError = tvReportError;
        this.tvTimer = tvTimer;
        this.vDiv = vDiv;
    }

    public static ItemSscPatternQuestionViewpagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternQuestionViewpagerBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemSscPatternQuestionViewpagerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_question_viewpager, root, attachToRoot, component);
    }

    public static ItemSscPatternQuestionViewpagerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternQuestionViewpagerBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemSscPatternQuestionViewpagerBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_ssc_pattern_question_viewpager, null, false, component);
    }

    public static ItemSscPatternQuestionViewpagerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSscPatternQuestionViewpagerBinding bind(View view, Object component) {
        return (ItemSscPatternQuestionViewpagerBinding) bind(component, view, R.layout.item_ssc_pattern_question_viewpager);
    }
}
