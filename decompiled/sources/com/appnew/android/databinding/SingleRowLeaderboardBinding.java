package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleRowLeaderboardBinding implements ViewBinding {
    public final ImageView barIV;
    public final ImageView clockIV;
    public final ImageView imageIV;
    public final TextView nameTV;
    public final LinearLayout parentLL;
    private final LinearLayout rootView;
    public final RelativeLayout seeResultLL;
    public final TextView timeTV;

    private SingleRowLeaderboardBinding(LinearLayout rootView, ImageView barIV, ImageView clockIV, ImageView imageIV, TextView nameTV, LinearLayout parentLL, RelativeLayout seeResultLL, TextView timeTV) {
        this.rootView = rootView;
        this.barIV = barIV;
        this.clockIV = clockIV;
        this.imageIV = imageIV;
        this.nameTV = nameTV;
        this.parentLL = parentLL;
        this.seeResultLL = seeResultLL;
        this.timeTV = timeTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SingleRowLeaderboardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SingleRowLeaderboardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.single_row_leaderboard, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SingleRowLeaderboardBinding bind(View rootView) {
        int i = R.id.barIV;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.barIV);
        if (imageView != null) {
            i = R.id.clockIV;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.clockIV);
            if (imageView2 != null) {
                i = R.id.imageIV;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                if (imageView3 != null) {
                    i = R.id.nameTV;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.nameTV);
                    if (textView != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.seeResultLL;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.seeResultLL);
                        if (relativeLayout != null) {
                            i = R.id.timeTV;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.timeTV);
                            if (textView2 != null) {
                                return new SingleRowLeaderboardBinding(linearLayout, imageView, imageView2, imageView3, textView, linearLayout, relativeLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
