package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepSingleRowItemSubjectiveBinding implements ViewBinding {
    public final LinearLayout attemptLL;
    public final Button booklet;
    public final LinearLayout cvrBoundries;
    public final TextView examPrepTitleTV;
    public final ImageView forwardIV;
    public final CardView ibtSingleSubVdRL;
    public final TextView learn;
    public final RelativeLayout lockRL;
    public final Button marks;
    public final Button paper;
    public final TextView practice;
    public final ImageView profileImage;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final TextView startdate;
    public final RelativeLayout studySingleItemLL;
    public final TextView subItemRV;
    public final LinearLayout subjectBTNLL;
    public final RelativeLayout thumbRl;
    public final Button upload;

    private ExamPrepSingleRowItemSubjectiveBinding(RelativeLayout rootView, LinearLayout attemptLL, Button booklet, LinearLayout cvrBoundries, TextView examPrepTitleTV, ImageView forwardIV, CardView ibtSingleSubVdRL, TextView learn, RelativeLayout lockRL, Button marks, Button paper, TextView practice, ImageView profileImage, ImageView share, TextView startdate, RelativeLayout studySingleItemLL, TextView subItemRV, LinearLayout subjectBTNLL, RelativeLayout thumbRl, Button upload) {
        this.rootView = rootView;
        this.attemptLL = attemptLL;
        this.booklet = booklet;
        this.cvrBoundries = cvrBoundries;
        this.examPrepTitleTV = examPrepTitleTV;
        this.forwardIV = forwardIV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.learn = learn;
        this.lockRL = lockRL;
        this.marks = marks;
        this.paper = paper;
        this.practice = practice;
        this.profileImage = profileImage;
        this.share = share;
        this.startdate = startdate;
        this.studySingleItemLL = studySingleItemLL;
        this.subItemRV = subItemRV;
        this.subjectBTNLL = subjectBTNLL;
        this.thumbRl = thumbRl;
        this.upload = upload;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemSubjectiveBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemSubjectiveBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_subjective, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemSubjectiveBinding bind(View rootView) {
        int i = R.id.attemptLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.attemptLL);
        if (linearLayout != null) {
            i = R.id.booklet;
            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.booklet);
            if (button != null) {
                i = R.id.cvrBoundries;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrBoundries);
                if (linearLayout2 != null) {
                    i = R.id.examPrepTitleTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                    if (textView != null) {
                        i = R.id.forwardIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                        if (imageView != null) {
                            i = R.id.ibt_single_sub_vd_RL;
                            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                            if (cardView != null) {
                                i = R.id.learn;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.learn);
                                if (textView2 != null) {
                                    i = R.id.lockRL;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                    if (relativeLayout != null) {
                                        i = R.id.marks;
                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.marks);
                                        if (button2 != null) {
                                            i = R.id.paper;
                                            Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.paper);
                                            if (button3 != null) {
                                                i = R.id.practice;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.practice);
                                                if (textView3 != null) {
                                                    i = R.id.profileImage;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.profileImage);
                                                    if (imageView2 != null) {
                                                        i = R.id.share;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                        if (imageView3 != null) {
                                                            i = R.id.startdate;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.startdate);
                                                            if (textView4 != null) {
                                                                i = R.id.study_single_itemLL;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.subItemRV;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subItemRV);
                                                                    if (textView5 != null) {
                                                                        i = R.id.subjectBTNLL;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.subjectBTNLL);
                                                                        if (linearLayout3 != null) {
                                                                            i = R.id.thumbRl;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                                            if (relativeLayout3 != null) {
                                                                                i = R.id.upload;
                                                                                Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.upload);
                                                                                if (button4 != null) {
                                                                                    return new ExamPrepSingleRowItemSubjectiveBinding((RelativeLayout) rootView, linearLayout, button, linearLayout2, textView, imageView, cardView, textView2, relativeLayout, button2, button3, textView3, imageView2, imageView3, textView4, relativeLayout2, textView5, linearLayout3, relativeLayout3, button4);
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
