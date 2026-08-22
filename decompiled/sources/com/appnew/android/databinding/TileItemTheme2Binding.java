package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TileItemTheme2Binding implements ViewBinding {
    public final TextView buyNowId;
    public final TextView buyNowId1;
    public final ImageView cartIcon;
    public final RelativeLayout cartSection;
    public final LinearLayout courseDurationrRow;
    public final RelativeLayout discountRL;
    public final TextView discountTV;
    public final View divider;
    public final TextView exploreId;
    public final TextView fullBatchId;
    public final TextView ibtCurrentAffairTitle;
    public final ImageView ibtSingleVdIv;
    public final ImageView liveIV;
    public final LinearLayout maiView;
    public final TextView mrpCutTV;
    public final ImageView newCourse;
    public final RelativeLayout priceLinear;
    public final TextView priceTV;
    private final CardView rootView;
    public final FrameLayout soldOutImg;
    public final TextView tileSubTitle;
    public final LinearLayout validityRowId;
    public final TextView validityTextTV;

    private TileItemTheme2Binding(CardView rootView, TextView buyNowId, TextView buyNowId1, ImageView cartIcon, RelativeLayout cartSection, LinearLayout courseDurationrRow, RelativeLayout discountRL, TextView discountTV, View divider, TextView exploreId, TextView fullBatchId, TextView ibtCurrentAffairTitle, ImageView ibtSingleVdIv, ImageView liveIV, LinearLayout maiView, TextView mrpCutTV, ImageView newCourse, RelativeLayout priceLinear, TextView priceTV, FrameLayout soldOutImg, TextView tileSubTitle, LinearLayout validityRowId, TextView validityTextTV) {
        this.rootView = rootView;
        this.buyNowId = buyNowId;
        this.buyNowId1 = buyNowId1;
        this.cartIcon = cartIcon;
        this.cartSection = cartSection;
        this.courseDurationrRow = courseDurationrRow;
        this.discountRL = discountRL;
        this.discountTV = discountTV;
        this.divider = divider;
        this.exploreId = exploreId;
        this.fullBatchId = fullBatchId;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.liveIV = liveIV;
        this.maiView = maiView;
        this.mrpCutTV = mrpCutTV;
        this.newCourse = newCourse;
        this.priceLinear = priceLinear;
        this.priceTV = priceTV;
        this.soldOutImg = soldOutImg;
        this.tileSubTitle = tileSubTitle;
        this.validityRowId = validityRowId;
        this.validityTextTV = validityTextTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static TileItemTheme2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TileItemTheme2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.tile_item_theme_2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TileItemTheme2Binding bind(View rootView) {
        int i = R.id.buyNowId;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNowId);
        if (textView != null) {
            i = R.id.buyNowId1;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.buyNowId1);
            if (textView2 != null) {
                i = R.id.cartIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.cartIcon);
                if (imageView != null) {
                    i = R.id.cartSection;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cartSection);
                    if (relativeLayout != null) {
                        i = R.id.courseDurationrRow;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.courseDurationrRow);
                        if (linearLayout != null) {
                            i = R.id.discountRL;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.discountRL);
                            if (relativeLayout2 != null) {
                                i = R.id.discountTV;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.discountTV);
                                if (textView3 != null) {
                                    i = R.id.divider;
                                    View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.divider);
                                    if (viewFindChildViewById != null) {
                                        i = R.id.exploreId;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.exploreId);
                                        if (textView4 != null) {
                                            i = R.id.fullBatchId;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.fullBatchId);
                                            if (textView5 != null) {
                                                i = R.id.ibt_current_affair_title;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
                                                if (textView6 != null) {
                                                    i = R.id.ibt_single_vd_iv;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                                                    if (imageView2 != null) {
                                                        i = R.id.liveIV;
                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                                        if (imageView3 != null) {
                                                            i = R.id.maiView;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.mrpCutTV;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                if (textView7 != null) {
                                                                    i = R.id.new_course;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.price_linear;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.price_linear);
                                                                        if (relativeLayout3 != null) {
                                                                            i = R.id.priceTV;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                                            if (textView8 != null) {
                                                                                i = R.id.soldOutImg;
                                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.soldOutImg);
                                                                                if (frameLayout != null) {
                                                                                    i = R.id.tileSubTitle;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tileSubTitle);
                                                                                    if (textView9 != null) {
                                                                                        i = R.id.validityRowId;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.validityRowId);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.validityTextTV;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                                                                            if (textView10 != null) {
                                                                                                return new TileItemTheme2Binding((CardView) rootView, textView, textView2, imageView, relativeLayout, linearLayout, relativeLayout2, textView3, viewFindChildViewById, textView4, textView5, textView6, imageView2, imageView3, linearLayout2, textView7, imageView4, relativeLayout3, textView8, frameLayout, textView9, linearLayout3, textView10);
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
