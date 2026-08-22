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
public final class TransparentLiveDialogBinding implements ViewBinding {
    public final Button buyNowBtn;
    public final Button cancel;
    public final LinearLayout cvrQuestions;
    public final RelativeLayout dialogLayout;
    public final TextView dialogTimer;
    private final RelativeLayout rootView;
    public final Button submit;
    public final TextView txt1;
    public final LayoutItemPollQuestionsNextToppersBinding typeA;
    public final LayoutItemPollQuestionsNextToppersBinding typeB;
    public final LayoutItemPollQuestionsNextToppersBinding typeC;
    public final LayoutItemPollQuestionsNextToppersBinding typeD;

    private TransparentLiveDialogBinding(RelativeLayout rootView, Button buyNowBtn, Button cancel, LinearLayout cvrQuestions, RelativeLayout dialogLayout, TextView dialogTimer, Button submit, TextView txt1, LayoutItemPollQuestionsNextToppersBinding typeA, LayoutItemPollQuestionsNextToppersBinding typeB, LayoutItemPollQuestionsNextToppersBinding typeC, LayoutItemPollQuestionsNextToppersBinding typeD) {
        this.rootView = rootView;
        this.buyNowBtn = buyNowBtn;
        this.cancel = cancel;
        this.cvrQuestions = cvrQuestions;
        this.dialogLayout = dialogLayout;
        this.dialogTimer = dialogTimer;
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

    public static TransparentLiveDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TransparentLiveDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.transparent_live_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TransparentLiveDialogBinding bind(View rootView) {
        int i = R.id.buyNowBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.buyNowBtn);
        if (button != null) {
            i = R.id.cancel;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.cancel);
            if (button2 != null) {
                i = R.id.cvrQuestions;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrQuestions);
                if (linearLayout != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i = R.id.dialogTimer;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dialogTimer);
                    if (textView != null) {
                        i = R.id.submit;
                        Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.submit);
                        if (button3 != null) {
                            i = R.id.txt1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt1);
                            if (textView2 != null) {
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
                                                return new TransparentLiveDialogBinding(relativeLayout, button, button2, linearLayout, relativeLayout, textView, button3, textView2, layoutItemPollQuestionsNextToppersBindingBind, layoutItemPollQuestionsNextToppersBindingBind2, layoutItemPollQuestionsNextToppersBindingBind3, LayoutItemPollQuestionsNextToppersBinding.bind(viewFindChildViewById4));
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
