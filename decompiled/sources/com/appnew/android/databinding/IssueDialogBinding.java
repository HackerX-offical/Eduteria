package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class IssueDialogBinding implements ViewBinding {
    public final LinearLayout idLlFeilds;
    public final TextView issue1;
    public final TextView issue2;
    public final TextView issue3;
    public final TextView issue4;
    public final TextView issue5;
    public final TextView issue6;
    public final TextView issue7;
    public final TextView issue8;
    private final RelativeLayout rootView;
    public final View viewDivider1;
    public final View viewDivider2;
    public final View viewDivider3;
    public final View viewDivider5;
    public final View viewDivider6;
    public final View viewDivider7;
    public final View viewDivider8;

    private IssueDialogBinding(RelativeLayout rootView, LinearLayout idLlFeilds, TextView issue1, TextView issue2, TextView issue3, TextView issue4, TextView issue5, TextView issue6, TextView issue7, TextView issue8, View viewDivider1, View viewDivider2, View viewDivider3, View viewDivider5, View viewDivider6, View viewDivider7, View viewDivider8) {
        this.rootView = rootView;
        this.idLlFeilds = idLlFeilds;
        this.issue1 = issue1;
        this.issue2 = issue2;
        this.issue3 = issue3;
        this.issue4 = issue4;
        this.issue5 = issue5;
        this.issue6 = issue6;
        this.issue7 = issue7;
        this.issue8 = issue8;
        this.viewDivider1 = viewDivider1;
        this.viewDivider2 = viewDivider2;
        this.viewDivider3 = viewDivider3;
        this.viewDivider5 = viewDivider5;
        this.viewDivider6 = viewDivider6;
        this.viewDivider7 = viewDivider7;
        this.viewDivider8 = viewDivider8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IssueDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static IssueDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.issue_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static IssueDialogBinding bind(View rootView) {
        int i = R.id.id_ll_feilds;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.id_ll_feilds);
        if (linearLayout != null) {
            i = R.id.issue1;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue1);
            if (textView != null) {
                i = R.id.issue2;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue2);
                if (textView2 != null) {
                    i = R.id.issue3;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue3);
                    if (textView3 != null) {
                        i = R.id.issue4;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue4);
                        if (textView4 != null) {
                            i = R.id.issue5;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue5);
                            if (textView5 != null) {
                                i = R.id.issue6;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue6);
                                if (textView6 != null) {
                                    i = R.id.issue7;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue7);
                                    if (textView7 != null) {
                                        i = R.id.issue8;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.issue8);
                                        if (textView8 != null) {
                                            i = R.id.viewDivider1;
                                            View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.viewDivider1);
                                            if (viewFindChildViewById != null) {
                                                i = R.id.viewDivider2;
                                                View viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, R.id.viewDivider2);
                                                if (viewFindChildViewById2 != null) {
                                                    i = R.id.viewDivider3;
                                                    View viewFindChildViewById3 = ViewBindings.findChildViewById(rootView, R.id.viewDivider3);
                                                    if (viewFindChildViewById3 != null) {
                                                        i = R.id.viewDivider5;
                                                        View viewFindChildViewById4 = ViewBindings.findChildViewById(rootView, R.id.viewDivider5);
                                                        if (viewFindChildViewById4 != null) {
                                                            i = R.id.viewDivider6;
                                                            View viewFindChildViewById5 = ViewBindings.findChildViewById(rootView, R.id.viewDivider6);
                                                            if (viewFindChildViewById5 != null) {
                                                                i = R.id.viewDivider7;
                                                                View viewFindChildViewById6 = ViewBindings.findChildViewById(rootView, R.id.viewDivider7);
                                                                if (viewFindChildViewById6 != null) {
                                                                    i = R.id.viewDivider8;
                                                                    View viewFindChildViewById7 = ViewBindings.findChildViewById(rootView, R.id.viewDivider8);
                                                                    if (viewFindChildViewById7 != null) {
                                                                        return new IssueDialogBinding((RelativeLayout) rootView, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7);
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
