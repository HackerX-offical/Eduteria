package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PlaylistUtilsEmiDialogBinding implements ViewBinding {
    public final Button continueBtn;
    public final CardView dataCv;
    public final CardView imageCloseIV;
    public final ListView list;
    private final RelativeLayout rootView;
    public final TextView title;
    public final TextView totalPrice;

    private PlaylistUtilsEmiDialogBinding(RelativeLayout rootView, Button continueBtn, CardView dataCv, CardView imageCloseIV, ListView list, TextView title, TextView totalPrice) {
        this.rootView = rootView;
        this.continueBtn = continueBtn;
        this.dataCv = dataCv;
        this.imageCloseIV = imageCloseIV;
        this.list = list;
        this.title = title;
        this.totalPrice = totalPrice;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PlaylistUtilsEmiDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PlaylistUtilsEmiDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.playlist_utils_emi_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PlaylistUtilsEmiDialogBinding bind(View rootView) {
        int i = R.id.continueBtn;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.continueBtn);
        if (button != null) {
            i = R.id.data_cv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.data_cv);
            if (cardView != null) {
                i = R.id.imageCloseIV;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, R.id.imageCloseIV);
                if (cardView2 != null) {
                    i = R.id.list;
                    ListView listView = (ListView) ViewBindings.findChildViewById(rootView, R.id.list);
                    if (listView != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.title);
                        if (textView != null) {
                            i = R.id.totalPrice;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.totalPrice);
                            if (textView2 != null) {
                                return new PlaylistUtilsEmiDialogBinding((RelativeLayout) rootView, button, cardView, cardView2, listView, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
