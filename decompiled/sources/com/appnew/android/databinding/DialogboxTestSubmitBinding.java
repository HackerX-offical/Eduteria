package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogboxTestSubmitBinding implements ViewBinding {
    public final TextView answeredTV;
    public final Button btnCancel;
    public final Button btnResume;
    public final Button btnSubmit;
    public final TextView marked1;
    public final TextView markedTV;
    public final View markedView1;
    public final View markedView2;
    public final TextView notVisited;
    public final TextView notVistedValue;
    private final LinearLayout rootView;
    public final TextView saveMarked1;
    public final TextView saveMarkedTV;
    public final TextView tvTestTitle;
    public final TextView tvTestTitleDesc;
    public final TextView tvUnattemptQuestion;
    public final TextView unansweredTV;

    private DialogboxTestSubmitBinding(LinearLayout rootView, TextView answeredTV, Button btnCancel, Button btnResume, Button btnSubmit, TextView marked1, TextView markedTV, View markedView1, View markedView2, TextView notVisited, TextView notVistedValue, TextView saveMarked1, TextView saveMarkedTV, TextView tvTestTitle, TextView tvTestTitleDesc, TextView tvUnattemptQuestion, TextView unansweredTV) {
        this.rootView = rootView;
        this.answeredTV = answeredTV;
        this.btnCancel = btnCancel;
        this.btnResume = btnResume;
        this.btnSubmit = btnSubmit;
        this.marked1 = marked1;
        this.markedTV = markedTV;
        this.markedView1 = markedView1;
        this.markedView2 = markedView2;
        this.notVisited = notVisited;
        this.notVistedValue = notVistedValue;
        this.saveMarked1 = saveMarked1;
        this.saveMarkedTV = saveMarkedTV;
        this.tvTestTitle = tvTestTitle;
        this.tvTestTitleDesc = tvTestTitleDesc;
        this.tvUnattemptQuestion = tvUnattemptQuestion;
        this.unansweredTV = unansweredTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogboxTestSubmitBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogboxTestSubmitBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialogbox_test_submit, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogboxTestSubmitBinding bind(View rootView) {
        int i = R.id.answeredTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.answeredTV);
        if (textView != null) {
            i = R.id.btn_cancel;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_cancel);
            if (button != null) {
                i = R.id.btn_resume;
                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_resume);
                if (button2 != null) {
                    i = R.id.btn_submit;
                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.btn_submit);
                    if (button3 != null) {
                        i = R.id.marked1;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.marked1);
                        if (textView2 != null) {
                            i = R.id.markedTV;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.markedTV);
                            if (textView3 != null) {
                                i = R.id.markedView1;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.markedView1);
                                if (viewFindChildViewById != null) {
                                    i = R.id.markedView2;
                                    View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.markedView2);
                                    if (viewFindChildViewById2 != null) {
                                        i = R.id.not_visited;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.not_visited);
                                        if (textView4 != null) {
                                            i = R.id.not_visted_value;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.not_visted_value);
                                            if (textView5 != null) {
                                                i = R.id.save_marked1;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_marked1);
                                                if (textView6 != null) {
                                                    i = R.id.save_markedTV;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.save_markedTV);
                                                    if (textView7 != null) {
                                                        i = R.id.tv_testTitle;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_testTitle);
                                                        if (textView8 != null) {
                                                            i = R.id.tv_testTitleDesc;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_testTitleDesc);
                                                            if (textView9 != null) {
                                                                i = R.id.tv_unattempt_question;
                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_unattempt_question);
                                                                if (textView10 != null) {
                                                                    i = R.id.unansweredTV;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.unansweredTV);
                                                                    if (textView11 != null) {
                                                                        return new DialogboxTestSubmitBinding((LinearLayout) rootView, textView, button, button2, button3, textView2, textView3, viewFindChildViewById, viewFindChildViewById2, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
