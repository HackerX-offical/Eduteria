package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DetailSingleItemTestTheme7Binding implements ViewBinding {
    public final TextView attemptsId;
    public final CardView card;
    public final ImageView coinImage;
    public final TextView coinsId;
    public final TextView dateId;
    public final TextView dotId;
    public final ProgressBar downloadprogess;
    public final ImageView image;
    public final RelativeLayout lockRL;
    private final CardView rootView;
    public final ImageView shareId;
    public final TextView titleId;

    private DetailSingleItemTestTheme7Binding(CardView rootView, TextView attemptsId, CardView card, ImageView coinImage, TextView coinsId, TextView dateId, TextView dotId, ProgressBar downloadprogess, ImageView image, RelativeLayout lockRL, ImageView shareId, TextView titleId) {
        this.rootView = rootView;
        this.attemptsId = attemptsId;
        this.card = card;
        this.coinImage = coinImage;
        this.coinsId = coinsId;
        this.dateId = dateId;
        this.dotId = dotId;
        this.downloadprogess = downloadprogess;
        this.image = image;
        this.lockRL = lockRL;
        this.shareId = shareId;
        this.titleId = titleId;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static DetailSingleItemTestTheme7Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DetailSingleItemTestTheme7Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.detail_single_item_test_theme7, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DetailSingleItemTestTheme7Binding bind(View rootView) {
        int i = R.id.attemptsId;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.attemptsId);
        if (textView != null) {
            i = R.id.card;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.card);
            if (cardView != null) {
                i = R.id.coinImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.coinImage);
                if (imageView != null) {
                    i = R.id.coinsId;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coinsId);
                    if (textView2 != null) {
                        i = R.id.dateId;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dateId);
                        if (textView3 != null) {
                            i = R.id.dotId;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.dotId);
                            if (textView4 != null) {
                                i = R.id.downloadprogess;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, R.id.downloadprogess);
                                if (progressBar != null) {
                                    i = R.id.image;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image);
                                    if (imageView2 != null) {
                                        i = R.id.lockRL;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.lockRL);
                                        if (relativeLayout != null) {
                                            i = R.id.shareId;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.shareId);
                                            if (imageView3 != null) {
                                                i = R.id.titleId;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleId);
                                                if (textView5 != null) {
                                                    return new DetailSingleItemTestTheme7Binding((CardView) rootView, textView, cardView, imageView, textView2, textView3, textView4, progressBar, imageView2, relativeLayout, imageView3, textView5);
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
