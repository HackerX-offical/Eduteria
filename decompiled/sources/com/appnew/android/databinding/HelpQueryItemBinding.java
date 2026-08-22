package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class HelpQueryItemBinding implements ViewBinding {
    public final CardView ibtSingleSubVdRL;
    public final TextView queryIDTV;
    public final RelativeLayout queryLL;
    public final TextView queryTextTV;
    public final TextView queryTimeTV;
    public final TextView querystatusTV;
    private final RelativeLayout rootView;
    public final LinearLayout titleLL;

    private HelpQueryItemBinding(RelativeLayout rootView, CardView ibtSingleSubVdRL, TextView queryIDTV, RelativeLayout queryLL, TextView queryTextTV, TextView queryTimeTV, TextView querystatusTV, LinearLayout titleLL) {
        this.rootView = rootView;
        this.ibtSingleSubVdRL = ibtSingleSubVdRL;
        this.queryIDTV = queryIDTV;
        this.queryLL = queryLL;
        this.queryTextTV = queryTextTV;
        this.queryTimeTV = queryTimeTV;
        this.querystatusTV = querystatusTV;
        this.titleLL = titleLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HelpQueryItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HelpQueryItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.help_query_item, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static HelpQueryItemBinding bind(View rootView) {
        int i = R.id.ibt_single_sub_vd_RL;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.ibt_single_sub_vd_RL);
        if (cardView != null) {
            i = R.id.queryIDTV;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.queryIDTV);
            if (textView != null) {
                i = R.id.queryLL;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.queryLL);
                if (relativeLayout != null) {
                    i = R.id.queryTextTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.queryTextTV);
                    if (textView2 != null) {
                        i = R.id.queryTimeTV;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.queryTimeTV);
                        if (textView3 != null) {
                            i = R.id.querystatusTV;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.querystatusTV);
                            if (textView4 != null) {
                                i = R.id.titleLL;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.titleLL);
                                if (linearLayout != null) {
                                    return new HelpQueryItemBinding((RelativeLayout) rootView, cardView, textView, relativeLayout, textView2, textView3, textView4, linearLayout);
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
