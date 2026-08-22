package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class TileDataItemAdapterTheme8Binding implements ViewBinding {
    public final LinearLayout currentAffairRL;
    public final RelativeLayout cvrLayout;
    public final TextView dicountValue;
    public final TextView ibtCurrentAffairTitle;
    public final RoundedImageView ibtSingleVdIv;
    public final TextView ibtSingleVdTvDay;
    public final LinearLayout layout1;
    public final ImageView liveIV;
    public final RelativeLayout maiView;
    public final TextView mrpCutTV;
    public final ImageView newCourse;
    public final TextView offerinside;
    public final TextView priceTV;
    private final LinearLayout rootView;
    public final RecyclerView tagRecyclerview;
    public final RelativeLayout tileRL;
    public final TextView tvCourseExpireDate;
    public final TextView tvStreamOffered;
    public final TextView validityTextTV;
    public final RelativeLayout videoplayerRL;

    private TileDataItemAdapterTheme8Binding(LinearLayout rootView, LinearLayout currentAffairRL, RelativeLayout cvrLayout, TextView dicountValue, TextView ibtCurrentAffairTitle, RoundedImageView ibtSingleVdIv, TextView ibtSingleVdTvDay, LinearLayout layout1, ImageView liveIV, RelativeLayout maiView, TextView mrpCutTV, ImageView newCourse, TextView offerinside, TextView priceTV, RecyclerView tagRecyclerview, RelativeLayout tileRL, TextView tvCourseExpireDate, TextView tvStreamOffered, TextView validityTextTV, RelativeLayout videoplayerRL) {
        this.rootView = rootView;
        this.currentAffairRL = currentAffairRL;
        this.cvrLayout = cvrLayout;
        this.dicountValue = dicountValue;
        this.ibtCurrentAffairTitle = ibtCurrentAffairTitle;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.ibtSingleVdTvDay = ibtSingleVdTvDay;
        this.layout1 = layout1;
        this.liveIV = liveIV;
        this.maiView = maiView;
        this.mrpCutTV = mrpCutTV;
        this.newCourse = newCourse;
        this.offerinside = offerinside;
        this.priceTV = priceTV;
        this.tagRecyclerview = tagRecyclerview;
        this.tileRL = tileRL;
        this.tvCourseExpireDate = tvCourseExpireDate;
        this.tvStreamOffered = tvStreamOffered;
        this.validityTextTV = validityTextTV;
        this.videoplayerRL = videoplayerRL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TileDataItemAdapterTheme8Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TileDataItemAdapterTheme8Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.tile_data_item_adapter_theme8, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TileDataItemAdapterTheme8Binding bind(View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i = R.id.cvrLayout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cvrLayout);
        if (relativeLayout != null) {
            i = R.id.dicount_value;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.dicount_value);
            if (textView != null) {
                i = R.id.ibt_current_affair_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_current_affair_title);
                if (textView2 != null) {
                    i = R.id.ibt_single_vd_iv;
                    RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                    if (roundedImageView != null) {
                        i = R.id.ibt_single_vd_tv_day;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_tv_day);
                        if (textView3 != null) {
                            i = R.id.layout1;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.layout1);
                            if (linearLayout2 != null) {
                                i = R.id.liveIV;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.liveIV);
                                if (imageView != null) {
                                    i = R.id.maiView;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.maiView);
                                    if (relativeLayout2 != null) {
                                        i = R.id.mrpCutTV;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                        if (textView4 != null) {
                                            i = R.id.new_course;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.new_course);
                                            if (imageView2 != null) {
                                                i = R.id.offerinside;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.offerinside);
                                                if (textView5 != null) {
                                                    i = R.id.priceTV;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTV);
                                                    if (textView6 != null) {
                                                        i = R.id.tag_recyclerview;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tag_recyclerview);
                                                        if (recyclerView != null) {
                                                            i = R.id.tileRL;
                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.tileRL);
                                                            if (relativeLayout3 != null) {
                                                                i = R.id.tv_course_expire_date;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_course_expire_date);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_stream_offered;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_stream_offered);
                                                                    if (textView8 != null) {
                                                                        i = R.id.validityTextTV;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTextTV);
                                                                        if (textView9 != null) {
                                                                            i = R.id.videoplayerRL;
                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.videoplayerRL);
                                                                            if (relativeLayout4 != null) {
                                                                                return new TileDataItemAdapterTheme8Binding(linearLayout, linearLayout, relativeLayout, textView, textView2, roundedImageView, textView3, linearLayout2, imageView, relativeLayout2, textView4, imageView2, textView5, textView6, recyclerView, relativeLayout3, textView7, textView8, textView9, relativeLayout4);
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
