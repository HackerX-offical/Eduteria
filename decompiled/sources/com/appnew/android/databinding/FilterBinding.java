package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FilterBinding implements ViewBinding {
    public final LinearLayout bothLl;
    public final TextView bothTextTv;
    public final Button filterdata;
    public final LinearLayout free;
    public final TextView freeTextTv;
    public final RelativeLayout launguage;
    public final ImageView launguageIV;
    public final TextView launguagespinner;
    public final LinearLayout paidLl;
    public final TextView paidTextTv;
    public final RelativeLayout rl1;
    public final RelativeLayout rl2;
    private final RelativeLayout rootView;
    public final ImageView spinnerIV;
    public final RelativeLayout subject;
    public final TextView subjectspinner;
    public final TextView txt1;
    public final TextView txt2;
    public final TextView txt3;
    public final TextView txt4;

    private FilterBinding(RelativeLayout rootView, LinearLayout bothLl, TextView bothTextTv, Button filterdata, LinearLayout free, TextView freeTextTv, RelativeLayout launguage, ImageView launguageIV, TextView launguagespinner, LinearLayout paidLl, TextView paidTextTv, RelativeLayout rl1, RelativeLayout rl2, ImageView spinnerIV, RelativeLayout subject, TextView subjectspinner, TextView txt1, TextView txt2, TextView txt3, TextView txt4) {
        this.rootView = rootView;
        this.bothLl = bothLl;
        this.bothTextTv = bothTextTv;
        this.filterdata = filterdata;
        this.free = free;
        this.freeTextTv = freeTextTv;
        this.launguage = launguage;
        this.launguageIV = launguageIV;
        this.launguagespinner = launguagespinner;
        this.paidLl = paidLl;
        this.paidTextTv = paidTextTv;
        this.rl1 = rl1;
        this.rl2 = rl2;
        this.spinnerIV = spinnerIV;
        this.subject = subject;
        this.subjectspinner = subjectspinner;
        this.txt1 = txt1;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.txt4 = txt4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FilterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FilterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.filter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FilterBinding bind(View rootView) {
        int i = R.id.both_ll;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.both_ll);
        if (linearLayout != null) {
            i = R.id.bothTextTv;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.bothTextTv);
            if (textView != null) {
                i = R.id.filterdata;
                Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.filterdata);
                if (button != null) {
                    i = R.id.free;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.free);
                    if (linearLayout2 != null) {
                        i = R.id.freeTextTv;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.freeTextTv);
                        if (textView2 != null) {
                            i = R.id.launguage;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.launguage);
                            if (relativeLayout != null) {
                                i = R.id.launguageIV;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.launguageIV);
                                if (imageView != null) {
                                    i = R.id.launguagespinner;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.launguagespinner);
                                    if (textView3 != null) {
                                        i = R.id.paid_ll;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.paid_ll);
                                        if (linearLayout3 != null) {
                                            i = R.id.paidTextTv;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paidTextTv);
                                            if (textView4 != null) {
                                                i = R.id.rl1;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl1);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rl2;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl2);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.spinnerIV;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.spinnerIV);
                                                        if (imageView2 != null) {
                                                            i = R.id.subject;
                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subject);
                                                            if (relativeLayout4 != null) {
                                                                i = R.id.subjectspinner;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subjectspinner);
                                                                if (textView5 != null) {
                                                                    i = R.id.txt1;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt1);
                                                                    if (textView6 != null) {
                                                                        i = R.id.txt2;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt2);
                                                                        if (textView7 != null) {
                                                                            i = R.id.txt3;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt3);
                                                                            if (textView8 != null) {
                                                                                i = R.id.txt4;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txt4);
                                                                                if (textView9 != null) {
                                                                                    return new FilterBinding((RelativeLayout) rootView, linearLayout, textView, button, linearLayout2, textView2, relativeLayout, imageView, textView3, linearLayout3, textView4, relativeLayout2, relativeLayout3, imageView2, relativeLayout4, textView5, textView6, textView7, textView8, textView9);
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
