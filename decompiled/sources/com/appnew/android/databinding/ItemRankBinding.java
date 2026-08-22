package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemRankBinding implements ViewBinding {
    public final ImageView imageIVText;
    public final CircleImageView imgSuccess;
    public final CircleImageView imgthumb;
    public final TextView mark;
    public final LinearLayout rankLL;
    private final CardView rootView;
    public final TextView textname;
    public final TextView textrank;
    public final TextView tvYourRank;

    private ItemRankBinding(CardView rootView, ImageView imageIVText, CircleImageView imgSuccess, CircleImageView imgthumb, TextView mark, LinearLayout rankLL, TextView textname, TextView textrank, TextView tvYourRank) {
        this.rootView = rootView;
        this.imageIVText = imageIVText;
        this.imgSuccess = imgSuccess;
        this.imgthumb = imgthumb;
        this.mark = mark;
        this.rankLL = rankLL;
        this.textname = textname;
        this.textrank = textrank;
        this.tvYourRank = tvYourRank;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemRankBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemRankBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_rank, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemRankBinding bind(View rootView) {
        int i = R.id.imageIVText;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIVText);
        if (imageView != null) {
            i = R.id.imgSuccess;
            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.imgSuccess);
            if (circleImageView != null) {
                i = R.id.imgthumb;
                CircleImageView circleImageView2 = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.imgthumb);
                if (circleImageView2 != null) {
                    i = R.id.mark;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.mark);
                    if (textView != null) {
                        i = R.id.rankLL;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rankLL);
                        if (linearLayout != null) {
                            i = R.id.textname;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textname);
                            if (textView2 != null) {
                                i = R.id.textrank;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.textrank);
                                if (textView3 != null) {
                                    i = R.id.tv_your_rank;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_your_rank);
                                    if (textView4 != null) {
                                        return new ItemRankBinding((CardView) rootView, imageView, circleImageView, circleImageView2, textView, linearLayout, textView2, textView3, textView4);
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
