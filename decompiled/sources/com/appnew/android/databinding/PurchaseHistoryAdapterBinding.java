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
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class PurchaseHistoryAdapterBinding implements ViewBinding {
    public final RoundedImageView courseImage;
    public final CardView cvrImage;
    public final CardView cvrNewUi;
    public final View dividerView;
    public final TextView emiTxt;
    public final LinearLayout expiredLL;
    public final TextView expiryDate;
    public final TextView extendValidy;
    public final ImageView forwardIV;
    public final ImageView forwardIVNew;
    public final CardView ibtSingleSubVdRL;
    public final TextView idLabelTxt;
    public final RelativeLayout imCover;
    public final ImageView imageCourse;
    public final RelativeLayout imageRL;
    public final ImageView liveIV;
    public final ImageView more;
    public final TextView orderIdTxt;
    public final TextView orderLabelTxt;
    public final TextView paidAmountTxt;
    public final TextView paidLabelTxt;
    public final RelativeLayout parentLayout;
    public final TextView paymentIdTxt;
    public final LinearLayout paymentLayout;
    public final TextView purchaseDate;
    public final TextView purchasedOnTxt;
    public final LinearLayout rl;
    private final RelativeLayout rootView;
    public final TextView studyItemTitleTV;
    public final RelativeLayout studySingleItemLL;
    public final LinearLayout totalPaidLayout;
    public final TextView transerText;
    public final TextView txtTitle;

    private PurchaseHistoryAdapterBinding(RelativeLayout rootView, RoundedImageView courseImage, CardView cvrImage, CardView cvrNewUi, View dividerView, TextView emiTxt, LinearLayout expiredLL, TextView expiryDate, TextView extendValidy, ImageView forwardIV, ImageView forwardIVNew, CardView ibtSingleSubVdRL, TextView idLabelTxt, RelativeLayout imCover, ImageView imageCourse, RelativeLayout imageRL, ImageView liveIV, ImageView more, TextView orderIdTxt, TextView orderLabelTxt, TextView paidAmountTxt, TextView paidLabelTxt, RelativeLayout parentLayout, TextView paymentIdTxt, LinearLayout paymentLayout, TextView purchaseDate, TextView purchasedOnTxt, LinearLayout rl, TextView studyItemTitleTV, RelativeLayout studySingleItemLL, LinearLayout totalPaidLayout, TextView transerText, TextView txtTitle) {
        this.rootView = rootView;
        this.courseImage = courseImage;
        this.cvrImage = cvrImage;
        this.cvrNewUi = cvrNewUi;
        this.dividerView = dividerView;
        this.emiTxt = emiTxt;
        this.expiredLL = expiredLL;
        this.expiryDate = expiryDate;
        this.extendValidy = extendValidy;
        this.forwardIV = forwardIV;
        this.forwardIVNew = forwardIVNew;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.idLabelTxt = idLabelTxt;
        this.imCover = imCover;
        this.imageCourse = imageCourse;
        this.imageRL = imageRL;
        this.liveIV = liveIV;
        this.more = more;
        this.orderIdTxt = orderIdTxt;
        this.orderLabelTxt = orderLabelTxt;
        this.paidAmountTxt = paidAmountTxt;
        this.paidLabelTxt = paidLabelTxt;
        this.parentLayout = parentLayout;
        this.paymentIdTxt = paymentIdTxt;
        this.paymentLayout = paymentLayout;
        this.purchaseDate = purchaseDate;
        this.purchasedOnTxt = purchasedOnTxt;
        this.rl = rl;
        this.studyItemTitleTV = studyItemTitleTV;
        this.studySingleItemLL = studySingleItemLL;
        this.totalPaidLayout = totalPaidLayout;
        this.transerText = transerText;
        this.txtTitle = txtTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PurchaseHistoryAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PurchaseHistoryAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.purchase_history_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PurchaseHistoryAdapterBinding bind(View rootView) {
        int i = R.id.courseImage;
        RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.courseImage);
        if (roundedImageView != null) {
            i = R.id.cvrImage;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cvrImage);
            if (cardView != null) {
                i = R.id.cvrNewUi;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.cvrNewUi);
                if (cardView2 != null) {
                    i = R.id.dividerView;
                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.dividerView);
                    if (viewFindChildViewById != null) {
                        i = R.id.emiTxt;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.emiTxt);
                        if (textView != null) {
                            i = R.id.expiredLL;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.expiredLL);
                            if (linearLayout != null) {
                                i = R.id.expiry_date;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.expiry_date);
                                if (textView2 != null) {
                                    i = R.id.extend_validy;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.extend_validy);
                                    if (textView3 != null) {
                                        i = R.id.forwardIV;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIV);
                                        if (imageView != null) {
                                            i = R.id.forwardIVNew;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.forwardIVNew);
                                            if (imageView2 != null) {
                                                i = R.id.ibt_single_sub_vd_RL;
                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
                                                if (cardView3 != null) {
                                                    i = R.id.idLabelTxt;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.idLabelTxt);
                                                    if (textView4 != null) {
                                                        i = R.id.imCover;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imCover);
                                                        if (relativeLayout != null) {
                                                            i = R.id.imageCourse;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageCourse);
                                                            if (imageView3 != null) {
                                                                i = R.id.imageRL;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.imageRL);
                                                                if (relativeLayout2 != null) {
                                                                    i = R.id.liveIV;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.more;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.more);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.orderIdTxt;
                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderIdTxt);
                                                                            if (textView5 != null) {
                                                                                i = R.id.orderLabelTxt;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderLabelTxt);
                                                                                if (textView6 != null) {
                                                                                    i = R.id.paidAmountTxt;
                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paidAmountTxt);
                                                                                    if (textView7 != null) {
                                                                                        i = R.id.paidLabelTxt;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paidLabelTxt);
                                                                                        if (textView8 != null) {
                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) rootView;
                                                                                            i = R.id.paymentIdTxt;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paymentIdTxt);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.payment_layout;
                                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.payment_layout);
                                                                                                if (linearLayout2 != null) {
                                                                                                    i = R.id.purchase_date;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.purchase_date);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.purchasedOnTxt;
                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.purchasedOnTxt);
                                                                                                        if (textView11 != null) {
                                                                                                            i = R.id.rl;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rl);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i = R.id.study_item_titleTV;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.study_item_titleTV);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.study_single_itemLL;
                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.study_single_itemLL);
                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                        i = R.id.total_paid_layout;
                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.total_paid_layout);
                                                                                                                        if (linearLayout4 != null) {
                                                                                                                            i = R.id.transer_text;
                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.transer_text);
                                                                                                                            if (textView13 != null) {
                                                                                                                                i = R.id.txtTitle;
                                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTitle);
                                                                                                                                if (textView14 != null) {
                                                                                                                                    return new PurchaseHistoryAdapterBinding(relativeLayout3, roundedImageView, cardView, cardView2, viewFindChildViewById, textView, linearLayout, textView2, textView3, imageView, imageView2, cardView3, textView4, relativeLayout, imageView3, relativeLayout2, imageView4, imageView5, textView5, textView6, textView7, textView8, relativeLayout3, textView9, linearLayout2, textView10, textView11, linearLayout3, textView12, relativeLayout4, linearLayout4, textView13, textView14);
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
