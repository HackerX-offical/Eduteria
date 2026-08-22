package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPopupFeedBinding implements ViewBinding {
    public final TextView changePrefence;
    public final CardView changeRl;
    public final RelativeLayout layput;
    public final ListView mainRecyclerview;
    private final RelativeLayout rootView;
    public final View view1;

    private DialogPopupFeedBinding(RelativeLayout rootView, TextView changePrefence, CardView changeRl, RelativeLayout layput, ListView mainRecyclerview, View view1) {
        this.rootView = rootView;
        this.changePrefence = changePrefence;
        this.changeRl = changeRl;
        this.layput = layput;
        this.mainRecyclerview = mainRecyclerview;
        this.view1 = view1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogPopupFeedBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogPopupFeedBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_popup_feed, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPopupFeedBinding bind(View rootView) {
        int i = R.id.change_prefence;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.change_prefence);
        if (textView != null) {
            i = R.id.change_rl;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.change_rl);
            if (cardView != null) {
                i = R.id.layput;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layput);
                if (relativeLayout != null) {
                    i = R.id.main_recyclerview;
                    ListView listView = (ListView) ViewBindings.findChildViewById(rootView, R.id.main_recyclerview);
                    if (listView != null) {
                        i = R.id.view1;
                        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.view1);
                        if (viewFindChildViewById != null) {
                            return new DialogPopupFeedBinding((RelativeLayout) rootView, textView, cardView, relativeLayout, listView, viewFindChildViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
