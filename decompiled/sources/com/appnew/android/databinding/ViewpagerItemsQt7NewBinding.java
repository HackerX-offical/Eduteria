package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.testmodule.mathview.MathView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewpagerItemsQt7NewBinding implements ViewBinding {
    public final ClickableWebView essaywebview;
    public final LinearLayout layoutOptions;
    public final LinearLayout layoutQuestiontxt;
    public final RelativeLayout llOption1;
    public final RelativeLayout llOption2;
    public final RelativeLayout llOption3;
    public final RelativeLayout llOption4;
    public final RelativeLayout llOption5;
    public final RelativeLayout llOption6;
    public final RelativeLayout llOption7;
    public final RelativeLayout llOption8;
    public final MathView option1Webview;
    public final MathView option2Webview;
    public final MathView option3Webview;
    public final MathView option4Webview;
    public final MathView option5Webview;
    public final MathView option6Webview;
    public final MathView option7Webview;
    public final MathView option8Webview;
    public final LinearLayout questionmarksll;
    public final ClickableWebView questionwebview;
    public final TextView rightMarks;
    private final FrameLayout rootView;
    public final TextView txtQno;
    public final TextView txtSerialnoA;
    public final TextView txtSerialnoB;
    public final TextView txtSerialnoC;
    public final TextView txtSerialnoD;
    public final TextView txtSerialnoE;
    public final TextView txtSerialnoF;
    public final TextView txtSerialnoG;
    public final TextView txtSerialnoH;
    public final View viewDivider;
    public final View viewDivider1;
    public final View viewDivider2;
    public final View viewDivider3;
    public final View viewDivider4;
    public final View viewDivider5;
    public final View viewDivider6;
    public final View viewDivider7;
    public final View viewDivider8;
    public final TextView wrongMarks;

    private ViewpagerItemsQt7NewBinding(FrameLayout rootView, ClickableWebView essaywebview, LinearLayout layoutOptions, LinearLayout layoutQuestiontxt, RelativeLayout llOption1, RelativeLayout llOption2, RelativeLayout llOption3, RelativeLayout llOption4, RelativeLayout llOption5, RelativeLayout llOption6, RelativeLayout llOption7, RelativeLayout llOption8, MathView option1Webview, MathView option2Webview, MathView option3Webview, MathView option4Webview, MathView option5Webview, MathView option6Webview, MathView option7Webview, MathView option8Webview, LinearLayout questionmarksll, ClickableWebView questionwebview, TextView rightMarks, TextView txtQno, TextView txtSerialnoA, TextView txtSerialnoB, TextView txtSerialnoC, TextView txtSerialnoD, TextView txtSerialnoE, TextView txtSerialnoF, TextView txtSerialnoG, TextView txtSerialnoH, View viewDivider, View viewDivider1, View viewDivider2, View viewDivider3, View viewDivider4, View viewDivider5, View viewDivider6, View viewDivider7, View viewDivider8, TextView wrongMarks) {
        this.rootView = rootView;
        this.essaywebview = essaywebview;
        this.layoutOptions = layoutOptions;
        this.layoutQuestiontxt = layoutQuestiontxt;
        this.llOption1 = llOption1;
        this.llOption2 = llOption2;
        this.llOption3 = llOption3;
        this.llOption4 = llOption4;
        this.llOption5 = llOption5;
        this.llOption6 = llOption6;
        this.llOption7 = llOption7;
        this.llOption8 = llOption8;
        this.option1Webview = option1Webview;
        this.option2Webview = option2Webview;
        this.option3Webview = option3Webview;
        this.option4Webview = option4Webview;
        this.option5Webview = option5Webview;
        this.option6Webview = option6Webview;
        this.option7Webview = option7Webview;
        this.option8Webview = option8Webview;
        this.questionmarksll = questionmarksll;
        this.questionwebview = questionwebview;
        this.rightMarks = rightMarks;
        this.txtQno = txtQno;
        this.txtSerialnoA = txtSerialnoA;
        this.txtSerialnoB = txtSerialnoB;
        this.txtSerialnoC = txtSerialnoC;
        this.txtSerialnoD = txtSerialnoD;
        this.txtSerialnoE = txtSerialnoE;
        this.txtSerialnoF = txtSerialnoF;
        this.txtSerialnoG = txtSerialnoG;
        this.txtSerialnoH = txtSerialnoH;
        this.viewDivider = viewDivider;
        this.viewDivider1 = viewDivider1;
        this.viewDivider2 = viewDivider2;
        this.viewDivider3 = viewDivider3;
        this.viewDivider4 = viewDivider4;
        this.viewDivider5 = viewDivider5;
        this.viewDivider6 = viewDivider6;
        this.viewDivider7 = viewDivider7;
        this.viewDivider8 = viewDivider8;
        this.wrongMarks = wrongMarks;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewpagerItemsQt7NewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewpagerItemsQt7NewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.viewpager_items_qt7_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewpagerItemsQt7NewBinding bind(View rootView) {
        int i = R.id.essaywebview;
        ClickableWebView clickableWebView = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.essaywebview);
        if (clickableWebView != null) {
            i = R.id.layout_options;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_options);
            if (linearLayout != null) {
                i = R.id.layout_questiontxt;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout_questiontxt);
                if (linearLayout2 != null) {
                    i = R.id.ll_option1;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option1);
                    if (relativeLayout != null) {
                        i = R.id.ll_option2;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option2);
                        if (relativeLayout2 != null) {
                            i = R.id.ll_option3;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option3);
                            if (relativeLayout3 != null) {
                                i = R.id.ll_option4;
                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option4);
                                if (relativeLayout4 != null) {
                                    i = R.id.ll_option5;
                                    RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option5);
                                    if (relativeLayout5 != null) {
                                        i = R.id.ll_option6;
                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option6);
                                        if (relativeLayout6 != null) {
                                            i = R.id.ll_option7;
                                            RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option7);
                                            if (relativeLayout7 != null) {
                                                i = R.id.ll_option8;
                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.ll_option8);
                                                if (relativeLayout8 != null) {
                                                    i = R.id.option1_webview;
                                                    MathView mathView = (MathView) ViewBindings.findChildViewById(rootView, R.id.option1_webview);
                                                    if (mathView != null) {
                                                        i = R.id.option2_webview;
                                                        MathView mathView2 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option2_webview);
                                                        if (mathView2 != null) {
                                                            i = R.id.option3_webview;
                                                            MathView mathView3 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option3_webview);
                                                            if (mathView3 != null) {
                                                                i = R.id.option4_webview;
                                                                MathView mathView4 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option4_webview);
                                                                if (mathView4 != null) {
                                                                    i = R.id.option5_webview;
                                                                    MathView mathView5 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option5_webview);
                                                                    if (mathView5 != null) {
                                                                        i = R.id.option6_webview;
                                                                        MathView mathView6 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option6_webview);
                                                                        if (mathView6 != null) {
                                                                            i = R.id.option7_webview;
                                                                            MathView mathView7 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option7_webview);
                                                                            if (mathView7 != null) {
                                                                                i = R.id.option8_webview;
                                                                                MathView mathView8 = (MathView) ViewBindings.findChildViewById(rootView, R.id.option8_webview);
                                                                                if (mathView8 != null) {
                                                                                    i = R.id.questionmarksll;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.questionmarksll);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.questionwebview;
                                                                                        ClickableWebView clickableWebView2 = (ClickableWebView) ViewBindings.findChildViewById(rootView, R.id.questionwebview);
                                                                                        if (clickableWebView2 != null) {
                                                                                            i = R.id.right_marks;
                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.right_marks);
                                                                                            if (textView != null) {
                                                                                                i = R.id.txt_qno;
                                                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_qno);
                                                                                                if (textView2 != null) {
                                                                                                    i = R.id.txt_serialnoA;
                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoA);
                                                                                                    if (textView3 != null) {
                                                                                                        i = R.id.txt_serialnoB;
                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoB);
                                                                                                        if (textView4 != null) {
                                                                                                            i = R.id.txt_serialnoC;
                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoC);
                                                                                                            if (textView5 != null) {
                                                                                                                i = R.id.txt_serialnoD;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoD);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.txt_serialnoE;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoE);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = R.id.txt_serialnoF;
                                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoF);
                                                                                                                        if (textView8 != null) {
                                                                                                                            i = R.id.txt_serialnoG;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoG);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.txt_serialnoH;
                                                                                                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt_serialnoH);
                                                                                                                                if (textView10 != null) {
                                                                                                                                    i = R.id.view_divider;
                                                                                                                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_divider);
                                                                                                                                    if (viewFindChildViewById != null) {
                                                                                                                                        i = R.id.view_divider1;
                                                                                                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.view_divider1);
                                                                                                                                        if (viewFindChildViewById2 != null) {
                                                                                                                                            i = R.id.view_divider2;
                                                                                                                                            View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.view_divider2);
                                                                                                                                            if (viewFindChildViewById3 != null) {
                                                                                                                                                i = R.id.view_divider3;
                                                                                                                                                View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.view_divider3);
                                                                                                                                                if (viewFindChildViewById4 != null) {
                                                                                                                                                    i = R.id.view_divider4;
                                                                                                                                                    View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.view_divider4);
                                                                                                                                                    if (viewFindChildViewById5 != null) {
                                                                                                                                                        i = R.id.view_divider5;
                                                                                                                                                        View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.view_divider5);
                                                                                                                                                        if (viewFindChildViewById6 != null) {
                                                                                                                                                            i = R.id.view_divider6;
                                                                                                                                                            View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.view_divider6);
                                                                                                                                                            if (viewFindChildViewById7 != null) {
                                                                                                                                                                i = R.id.view_divider7;
                                                                                                                                                                View viewFindChildViewById8 = ViewBindings.findChildViewById(rootView, R.id.view_divider7);
                                                                                                                                                                if (viewFindChildViewById8 != null) {
                                                                                                                                                                    i = R.id.view_divider8;
                                                                                                                                                                    View viewFindChildViewById9 = ViewBindings.findChildViewById(rootView, R.id.view_divider8);
                                                                                                                                                                    if (viewFindChildViewById9 != null) {
                                                                                                                                                                        i = R.id.wrong_marks;
                                                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.wrong_marks);
                                                                                                                                                                        if (textView11 != null) {
                                                                                                                                                                            return new ViewpagerItemsQt7NewBinding((FrameLayout) rootView, clickableWebView, linearLayout, linearLayout2, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, relativeLayout8, mathView, mathView2, mathView3, mathView4, mathView5, mathView6, mathView7, mathView8, linearLayout3, clickableWebView2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, viewFindChildViewById9, textView11);
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
