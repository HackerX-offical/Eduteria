package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.devzone.fillprogresslayout.FillProgressLayout;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ChildDailyPollOptionBinding implements ViewBinding {
    public final FillProgressLayout fillProgress;
    public final ImageView ivRightOrWrong;
    public final LinearLayout llEnd;
    public final RelativeLayout rlPollChildMain;
    private final RelativeLayout rootView;
    public final TextView tvAnswerPer;
    public final TextView tvOption;
    public final TextView tvOptionSerial;

    private ChildDailyPollOptionBinding(RelativeLayout rootView, FillProgressLayout fillProgress, ImageView ivRightOrWrong, LinearLayout llEnd, RelativeLayout rlPollChildMain, TextView tvAnswerPer, TextView tvOption, TextView tvOptionSerial) {
        this.rootView = rootView;
        this.fillProgress = fillProgress;
        this.ivRightOrWrong = ivRightOrWrong;
        this.llEnd = llEnd;
        this.rlPollChildMain = rlPollChildMain;
        this.tvAnswerPer = tvAnswerPer;
        this.tvOption = tvOption;
        this.tvOptionSerial = tvOptionSerial;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChildDailyPollOptionBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ChildDailyPollOptionBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.child_daily_poll_option, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChildDailyPollOptionBinding bind(View rootView) {
        int i = R.id.fill_progress;
        FillProgressLayout fillProgressLayout = (FillProgressLayout) ViewBindings.findChildViewById(rootView, R.id.fill_progress);
        if (fillProgressLayout != null) {
            i = R.id.iv_rightOrWrong;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_rightOrWrong);
            if (imageView != null) {
                i = R.id.ll_end;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_end);
                if (linearLayout != null) {
                    i = R.id.rl_poll_child_main;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_poll_child_main);
                    if (relativeLayout != null) {
                        i = R.id.tv_answer_per;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_answer_per);
                        if (textView != null) {
                            i = R.id.tv_option;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_option);
                            if (textView2 != null) {
                                i = R.id.tv_option_serial;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_option_serial);
                                if (textView3 != null) {
                                    return new ChildDailyPollOptionBinding((RelativeLayout) rootView, fillProgressLayout, imageView, linearLayout, relativeLayout, textView, textView2, textView3);
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
