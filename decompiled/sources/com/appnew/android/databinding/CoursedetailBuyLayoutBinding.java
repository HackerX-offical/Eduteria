package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class CoursedetailBuyLayoutBinding implements ViewBinding {
    public final TextView basicProgramTxt;
    public final TextView batchNameTxt;
    public final RoundedImageView headerBanner;
    public final TextView meduiumTxt;
    public final TextView meduiumTxtHindi;
    public final RelativeLayout rlBuy;
    private final RelativeLayout rootView;
    public final RecyclerView tileRv;
    public final RelativeLayout upperRl;
    public final View view1;

    private CoursedetailBuyLayoutBinding(RelativeLayout rootView, TextView basicProgramTxt, TextView batchNameTxt, RoundedImageView headerBanner, TextView meduiumTxt, TextView meduiumTxtHindi, RelativeLayout rlBuy, RecyclerView tileRv, RelativeLayout upperRl, View view1) {
        this.rootView = rootView;
        this.basicProgramTxt = basicProgramTxt;
        this.batchNameTxt = batchNameTxt;
        this.headerBanner = headerBanner;
        this.meduiumTxt = meduiumTxt;
        this.meduiumTxtHindi = meduiumTxtHindi;
        this.rlBuy = rlBuy;
        this.tileRv = tileRv;
        this.upperRl = upperRl;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CoursedetailBuyLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static CoursedetailBuyLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.coursedetail_buy_layout, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CoursedetailBuyLayoutBinding bind(View rootView) {
        int i = R.id.basic_program_txt;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.basic_program_txt);
        if (textView != null) {
            i = R.id.batch_name_txt;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.batch_name_txt);
            if (textView2 != null) {
                i = R.id.header_banner;
                RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.header_banner);
                if (roundedImageView != null) {
                    i = R.id.meduium_txt;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.meduium_txt);
                    if (textView3 != null) {
                        i = R.id.meduium_txt_hindi;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.meduium_txt_hindi);
                        if (textView4 != null) {
                            i = R.id.rl_buy;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_buy);
                            if (relativeLayout != null) {
                                i = R.id.tileRv;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.tileRv);
                                if (recyclerView != null) {
                                    i = R.id.upper_rl;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.upper_rl);
                                    if (relativeLayout2 != null) {
                                        i = R.id.view_1;
                                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view_1);
                                        if (viewFindChildViewById != null) {
                                            return new CoursedetailBuyLayoutBinding((RelativeLayout) rootView, textView, textView2, roundedImageView, textView3, textView4, relativeLayout, recyclerView, relativeLayout2, viewFindChildViewById);
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
