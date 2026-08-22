package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepSingleRowItemPdfBinding implements ViewBinding {
    public final ImageView arrowIV;
    public final CardView card;
    public final TextView examPrepTitleTV;
    public final CardView ibtSingleSubVdRL;
    public final RelativeLayout iconRL;
    public final ImageView imageIV;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final RelativeLayout pdfTitleRl;
    public final TextView readNow;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studyRL;
    public final RelativeLayout studySingleItemLL;
    public final RelativeLayout thumbRl;

    private ExamPrepSingleRowItemPdfBinding(RelativeLayout rootView, ImageView arrowIV, CardView card, TextView examPrepTitleTV, CardView ibtSingleSubVdRL, RelativeLayout iconRL, ImageView imageIV, ImageView liveIV, RelativeLayout lockRL, RelativeLayout pdfTitleRl, TextView readNow, ImageView share, RelativeLayout studyRL, RelativeLayout studySingleItemLL, RelativeLayout thumbRl) {
        this.rootView = rootView;
        this.arrowIV = arrowIV;
        this.card = card;
        this.examPrepTitleTV = examPrepTitleTV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.iconRL = iconRL;
        this.imageIV = imageIV;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.pdfTitleRl = pdfTitleRl;
        this.readNow = readNow;
        this.share = share;
        this.studyRL = studyRL;
        this.studySingleItemLL = studySingleItemLL;
        this.thumbRl = thumbRl;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemPdfBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemPdfBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_pdf, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemPdfBinding bind(View rootView) {
        int i = R.id.arrowIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowIV);
        if (imageView != null) {
            i = R.id.card;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card);
            if (cardView != null) {
                i = R.id.examPrepTitleTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                if (textView != null) {
                    i = R.id.ibt_single_sub_vd_RL;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                    if (cardView2 != null) {
                        i = R.id.iconRL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.iconRL);
                        if (relativeLayout != null) {
                            i = R.id.imageIV;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                            if (imageView2 != null) {
                                i = R.id.liveIV;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                if (imageView3 != null) {
                                    i = R.id.lockRL;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                    if (relativeLayout2 != null) {
                                        i = R.id.pdfTitleRl;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pdfTitleRl);
                                        if (relativeLayout3 != null) {
                                            i = R.id.read_now;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                            if (textView2 != null) {
                                                i = R.id.share;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                                if (imageView4 != null) {
                                                    i = R.id.study_RL;
                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_RL);
                                                    if (relativeLayout4 != null) {
                                                        i = R.id.study_single_itemLL;
                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                        if (relativeLayout5 != null) {
                                                            i = R.id.thumbRl;
                                                            RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.thumbRl);
                                                            if (relativeLayout6 != null) {
                                                                return new ExamPrepSingleRowItemPdfBinding((RelativeLayout) rootView, imageView, cardView, textView, cardView2, relativeLayout, imageView2, imageView3, relativeLayout2, relativeLayout3, textView2, imageView4, relativeLayout4, relativeLayout5, relativeLayout6);
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
