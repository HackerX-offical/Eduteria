package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomReviewBinding implements ViewBinding {
    public final LinearLayout bottomSheetContainer;
    public final CardView cancelReview;
    public final RelativeLayout commentRL;
    public final ImageView crossBottomIMG;
    public final EditText descriptionTv;
    public final CircleImageView profileImg;
    public final RatingBar ratingBar;
    private final LinearLayout rootView;
    public final CardView submitReview;
    public final TextView titleTv;

    private BottomReviewBinding(LinearLayout rootView, LinearLayout bottomSheetContainer, CardView cancelReview, RelativeLayout commentRL, ImageView crossBottomIMG, EditText descriptionTv, CircleImageView profileImg, RatingBar ratingBar, CardView submitReview, TextView titleTv) {
        this.rootView = rootView;
        this.bottomSheetContainer = bottomSheetContainer;
        this.cancelReview = cancelReview;
        this.commentRL = commentRL;
        this.crossBottomIMG = crossBottomIMG;
        this.descriptionTv = descriptionTv;
        this.profileImg = profileImg;
        this.ratingBar = ratingBar;
        this.submitReview = submitReview;
        this.titleTv = titleTv;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomReviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BottomReviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.bottom_review, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomReviewBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.cancelReview;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.cancelReview);
        if (cardView != null) {
            i = R.id.commentRL;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.commentRL);
            if (relativeLayout != null) {
                i = R.id.crossBottomIMG;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.crossBottomIMG);
                if (imageView != null) {
                    i = R.id.descriptionTv;
                    EditText editText = (EditText) ViewBindings.findChildViewById(rootView, R.id.descriptionTv);
                    if (editText != null) {
                        i = R.id.profileImg;
                        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImg);
                        if (circleImageView != null) {
                            i = R.id.ratingBar;
                            RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.ratingBar);
                            if (ratingBar != null) {
                                i = R.id.submitReview;
                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.submitReview);
                                if (cardView2 != null) {
                                    i = R.id.titleTv;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleTv);
                                    if (textView != null) {
                                        return new BottomReviewBinding(linearLayout, linearLayout, cardView, relativeLayout, imageView, editText, circleImageView, ratingBar, cardView2, textView);
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
