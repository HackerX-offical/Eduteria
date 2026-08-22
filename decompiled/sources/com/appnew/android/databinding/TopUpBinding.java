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
public final class TopUpBinding implements ViewBinding {
    public final TextView buyNow;
    public final RelativeLayout calcpagerl;
    public final TextView cname;
    public final RoundedImageView ibtSingleVdIv;
    public final RecyclerView recyclerViewValidy;
    private final RelativeLayout rootView;
    public final TextView view2;
    public final TextView view3;

    private TopUpBinding(RelativeLayout rootView, TextView buyNow, RelativeLayout calcpagerl, TextView cname, RoundedImageView ibtSingleVdIv, RecyclerView recyclerViewValidy, TextView view2, TextView view3) {
        this.rootView = rootView;
        this.buyNow = buyNow;
        this.calcpagerl = calcpagerl;
        this.cname = cname;
        this.ibtSingleVdIv = ibtSingleVdIv;
        this.recyclerViewValidy = recyclerViewValidy;
        this.view2 = view2;
        this.view3 = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TopUpBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static TopUpBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.top_up, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TopUpBinding bind(View rootView) {
        int i = R.id.buy_now;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.buy_now);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) rootView;
            i = R.id.cname;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.cname);
            if (textView2 != null) {
                i = R.id.ibt_single_vd_iv;
                RoundedImageView roundedImageView = (RoundedImageView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_vd_iv);
                if (roundedImageView != null) {
                    i = R.id.recycler_view_validy;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recycler_view_validy);
                    if (recyclerView != null) {
                        i = R.id.view2;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view2);
                        if (textView3 != null) {
                            i = R.id.view3;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.view3);
                            if (textView4 != null) {
                                return new TopUpBinding(relativeLayout, textView, relativeLayout, textView2, roundedImageView, recyclerView, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
