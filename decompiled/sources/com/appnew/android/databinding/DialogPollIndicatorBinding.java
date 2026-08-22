package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPollIndicatorBinding implements ViewBinding {
    public final Button btnLeaderboard;
    public final Button btnResult;
    public final ImageView iconIV;
    public final FrameLayout iconWithDot;
    public final ImageView ivCloseIndic;
    public final FrameLayout outerTouchArea;
    public final RelativeLayout pollIndicatorRL;
    public final View redDot;
    private final FrameLayout rootView;

    private DialogPollIndicatorBinding(FrameLayout rootView, Button btnLeaderboard, Button btnResult, ImageView iconIV, FrameLayout iconWithDot, ImageView ivCloseIndic, FrameLayout outerTouchArea, RelativeLayout pollIndicatorRL, View redDot) {
        this.rootView = rootView;
        this.btnLeaderboard = btnLeaderboard;
        this.btnResult = btnResult;
        this.iconIV = iconIV;
        this.iconWithDot = iconWithDot;
        this.ivCloseIndic = ivCloseIndic;
        this.outerTouchArea = outerTouchArea;
        this.pollIndicatorRL = pollIndicatorRL;
        this.redDot = redDot;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogPollIndicatorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DialogPollIndicatorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.dialog_poll_indicator, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogPollIndicatorBinding bind(View rootView) {
        int i = R.id.btnLeaderboard;
        Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.btnLeaderboard);
        if (button != null) {
            i = R.id.btnResult;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.btnResult);
            if (button2 != null) {
                i = R.id.iconIV;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iconIV);
                if (imageView != null) {
                    i = R.id.iconWithDot;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, R.id.iconWithDot);
                    if (frameLayout != null) {
                        i = R.id.ivCloseIndic;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.ivCloseIndic);
                        if (imageView2 != null) {
                            FrameLayout frameLayout2 = (FrameLayout) rootView;
                            i = R.id.pollIndicatorRL;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.pollIndicatorRL);
                            if (relativeLayout != null) {
                                i = R.id.redDot;
                                View viewFindChildViewById = ViewBindings.findChildViewById(rootView, R.id.redDot);
                                if (viewFindChildViewById != null) {
                                    return new DialogPollIndicatorBinding(frameLayout2, button, button2, imageView, frameLayout, imageView2, frameLayout2, relativeLayout, viewFindChildViewById);
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
