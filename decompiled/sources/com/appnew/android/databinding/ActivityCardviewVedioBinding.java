package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCardviewVedioBinding implements ViewBinding {
    public final CardView parentCV;
    private final RelativeLayout rootView;
    public final ImageView vedioicon;
    public final TextView vediotime;
    public final TextView vediotitle;

    private ActivityCardviewVedioBinding(RelativeLayout rootView, CardView parentCV, ImageView vedioicon, TextView vediotime, TextView vediotitle) {
        this.rootView = rootView;
        this.parentCV = parentCV;
        this.vedioicon = vedioicon;
        this.vediotime = vediotime;
        this.vediotitle = vediotitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCardviewVedioBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCardviewVedioBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_cardview_vedio, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityCardviewVedioBinding bind(View rootView) {
        int i = R.id.parentCV;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.parentCV);
        if (cardView != null) {
            i = R.id.vedioicon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.vedioicon);
            if (imageView != null) {
                i = R.id.vediotime;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.vediotime);
                if (textView != null) {
                    i = R.id.vediotitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.vediotitle);
                    if (textView2 != null) {
                        return new ActivityCardviewVedioBinding((RelativeLayout) rootView, cardView, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
