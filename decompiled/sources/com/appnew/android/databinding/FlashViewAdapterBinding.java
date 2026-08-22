package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FlashViewAdapterBinding implements ViewBinding {
    public final RelativeLayout flashCover;
    public final RelativeLayout layoutBack;
    public final RelativeLayout layoutFront;
    private final LinearLayoutCompat rootView;
    public final TextView textBack;
    public final TextView textFront;
    public final TextView turn;

    private FlashViewAdapterBinding(LinearLayoutCompat rootView, RelativeLayout flashCover, RelativeLayout layoutBack, RelativeLayout layoutFront, TextView textBack, TextView textFront, TextView turn) {
        this.rootView = rootView;
        this.flashCover = flashCover;
        this.layoutBack = layoutBack;
        this.layoutFront = layoutFront;
        this.textBack = textBack;
        this.textFront = textFront;
        this.turn = turn;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FlashViewAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FlashViewAdapterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.flash_view_adapter, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FlashViewAdapterBinding bind(View rootView) {
        int i = R.id.flashCover;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.flashCover);
        if (relativeLayout != null) {
            i = R.id.layout_back;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_back);
            if (relativeLayout2 != null) {
                i = R.id.layout_front;
                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.layout_front);
                if (relativeLayout3 != null) {
                    i = R.id.text_back;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_back);
                    if (textView != null) {
                        i = R.id.text_front;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.text_front);
                        if (textView2 != null) {
                            i = R.id.turn;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.turn);
                            if (textView3 != null) {
                                return new FlashViewAdapterBinding((LinearLayoutCompat) rootView, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
