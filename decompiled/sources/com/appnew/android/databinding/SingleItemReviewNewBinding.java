package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleItemReviewNewBinding implements ViewBinding {
    public final LinearLayout bottomSheetContainer;
    public final TextView descriptionTV;
    public final TextView nameTV;
    public final CircleImageView profileImg;
    public final RatingBar ratingBar;
    private final LinearLayout rootView;

    private SingleItemReviewNewBinding(LinearLayout rootView, LinearLayout bottomSheetContainer, TextView descriptionTV, TextView nameTV, CircleImageView profileImg, RatingBar ratingBar) {
        this.rootView = rootView;
        this.bottomSheetContainer = bottomSheetContainer;
        this.descriptionTV = descriptionTV;
        this.nameTV = nameTV;
        this.profileImg = profileImg;
        this.ratingBar = ratingBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleItemReviewNewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleItemReviewNewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_item_review_new, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleItemReviewNewBinding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.descriptionTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.descriptionTV);
        if (textView != null) {
            i = R.id.nameTV;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTV);
            if (textView2 != null) {
                i = R.id.profileImg;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.profileImg);
                if (circleImageView != null) {
                    i = R.id.ratingBar;
                    RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(rootView, R.id.ratingBar);
                    if (ratingBar != null) {
                        return new SingleItemReviewNewBinding(linearLayout, linearLayout, textView, textView2, circleImageView, ratingBar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
