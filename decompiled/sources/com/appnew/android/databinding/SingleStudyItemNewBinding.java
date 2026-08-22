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
public final class SingleStudyItemNewBinding implements ViewBinding {
    public final TextView count;
    public final ImageView courseImage;
    public final ImageView forwardIV;
    public final CardView ibtSingleSubVdRL;
    public final ImageView liveIV;
    public final RelativeLayout lockRL;
    public final TextView noData;
    public final RelativeLayout rlThumb;
    private final RelativeLayout rootView;
    public final TextView studyItemTitleTV;
    public final LinearLayout studySingleItemLL;

    private SingleStudyItemNewBinding(RelativeLayout rootView, TextView count, ImageView courseImage, ImageView forwardIV, CardView ibtSingleSubVdRL, ImageView liveIV, RelativeLayout lockRL, TextView noData, RelativeLayout rlThumb, TextView studyItemTitleTV, LinearLayout studySingleItemLL) {
        this.rootView = rootView;
        this.count = count;
        this.courseImage = courseImage;
        this.forwardIV = forwardIV;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.liveIV = liveIV;
        this.lockRL = lockRL;
        this.noData = noData;
        this.rlThumb = rlThumb;
        this.studyItemTitleTV = studyItemTitleTV;
        this.studySingleItemLL = studySingleItemLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SingleStudyItemNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleStudyItemNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_study_item_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleStudyItemNewBinding bind(View rootView) {
        int i = R.id.count;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.count);
        if (textView != null) {
            i = R.id.courseImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
            if (imageView != null) {
                i = R.id.forwardIV;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                if (imageView2 != null) {
                    i = R.id.ibt_single_sub_vd_RL;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                    if (cardView != null) {
                        i = R.id.liveIV;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                        if (imageView3 != null) {
                            i = R.id.lockRL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                            if (relativeLayout != null) {
                                i = R.id.no_data;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.no_data);
                                if (textView2 != null) {
                                    i = R.id.rlThumb;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rlThumb);
                                    if (relativeLayout2 != null) {
                                        i = R.id.study_item_titleTV;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.study_item_titleTV);
                                        if (textView3 != null) {
                                            i = R.id.study_single_itemLL;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                            if (linearLayout != null) {
                                                return new SingleStudyItemNewBinding((RelativeLayout) rootView, textView, imageView, imageView2, cardView, imageView3, relativeLayout, textView2, relativeLayout2, textView3, linearLayout);
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
