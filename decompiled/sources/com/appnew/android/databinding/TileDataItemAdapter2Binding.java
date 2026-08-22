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
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class TileDataItemAdapter2Binding implements ViewBinding {
    public final LinearLayout currentAffairRL;
    public final RelativeLayout cvr;
    public final TextView desc;
    public final TextView ibtCurrentAffairTitle;
    public final CircleImageView ibtSingleVdIv;
    public final ImageView liveIV;
    public final ImageView newCourse;
    private final LinearLayout rootView;
    public final CardView topCV;

    private TileDataItemAdapter2Binding(LinearLayout rootView, LinearLayout currentAffairRL, RelativeLayout cvr, TextView desc, TextView ibtCurrentAffairTitle, CircleImageView ibtSingleVdIv, ImageView liveIV, ImageView newCourse, CardView topCV) {
        this.rootView = rootView;
        this.currentAffairRL = currentAffairRL;
        this.cvr = cvr;
        this.desc = desc;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.liveIV = liveIV;
        this.newCourse = newCourse;
        this.topCV = topCV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TileDataItemAdapter2Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TileDataItemAdapter2Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.tile_data_item_adapter2, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TileDataItemAdapter2Binding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.cvr;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvr);
        if (relativeLayout != null) {
            i = R.id.desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.desc);
            if (textView != null) {
                i = R.id.ibt_current_affair_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
                if (textView2 != null) {
                    i = R.id.ibt_single_vd_iv;
                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                    if (circleImageView != null) {
                        i = R.id.liveIV;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                        if (imageView != null) {
                            i = R.id.new_course;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                            if (imageView2 != null) {
                                i = R.id.topCV;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.topCV);
                                if (cardView != null) {
                                    return new TileDataItemAdapter2Binding(linearLayout, linearLayout, relativeLayout, textView, textView2, circleImageView, imageView, imageView2, cardView);
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
