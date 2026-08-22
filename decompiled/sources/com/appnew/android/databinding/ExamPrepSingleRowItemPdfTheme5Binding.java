package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExamPrepSingleRowItemPdfTheme5Binding implements ViewBinding {
    public final ImageView arrowIV;
    public final LinearLayout cvrReadorLive;
    public final TextView examPrepTitleTV;
    public final CardView ibtSingleSubVdRL;
    public final ImageView imageIV;
    public final RelativeLayout imageRL;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final TextView readNow;
    private final RelativeLayout rootView;
    public final ImageView share;
    public final RelativeLayout studySingleItemLL;

    private ExamPrepSingleRowItemPdfTheme5Binding(RelativeLayout rootView, ImageView arrowIV, LinearLayout cvrReadorLive, TextView examPrepTitleTV, CardView ibtSingleSubVdRL, ImageView imageIV, RelativeLayout imageRL, ImageView liveIV, RelativeLayout lockRL, TextView readNow, ImageView share, RelativeLayout studySingleItemLL) {
        this.rootView = rootView;
        this.arrowIV = arrowIV;
        this.cvrReadorLive = cvrReadorLive;
        this.examPrepTitleTV = examPrepTitleTV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.imageIV = imageIV;
        this.imageRL = imageRL;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.readNow = readNow;
        this.share = share;
        this.studySingleItemLL = studySingleItemLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ExamPrepSingleRowItemPdfTheme5Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExamPrepSingleRowItemPdfTheme5Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exam_prep_single_row_item_pdf_theme5, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExamPrepSingleRowItemPdfTheme5Binding bind(View rootView) {
        int i = R.id.arrowIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.arrowIV);
        if (imageView != null) {
            i = R.id.cvrReadorLive;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrReadorLive);
            if (linearLayout != null) {
                i = R.id.examPrepTitleTV;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.examPrepTitleTV);
                if (textView != null) {
                    i = R.id.ibt_single_sub_vd_RL;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                    if (cardView != null) {
                        i = R.id.imageIV;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                        if (imageView2 != null) {
                            i = R.id.imageRL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                            if (relativeLayout != null) {
                                i = R.id.liveIV;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                if (imageView3 != null) {
                                    i = R.id.lockRL;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                    if (relativeLayout2 != null) {
                                        i = R.id.read_now;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.read_now);
                                        if (textView2 != null) {
                                            i = R.id.share;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.share);
                                            if (imageView4 != null) {
                                                i = R.id.study_single_itemLL;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                if (relativeLayout3 != null) {
                                                    return new ExamPrepSingleRowItemPdfTheme5Binding((RelativeLayout) rootView, imageView, linearLayout, textView, cardView, imageView2, relativeLayout, imageView3, relativeLayout2, textView2, imageView4, relativeLayout3);
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
