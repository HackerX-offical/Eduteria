package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.ui.DefaultTimeBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExtracterExoControlViewBinding implements ViewBinding {
    public final ImageButton exoFfwd;
    public final ImageButton exoNext;
    public final ImageButton exoPause;
    public final ImageButton exoPlay;
    public final TextView exoPosition;
    public final ImageButton exoPrev;
    public final DefaultTimeBar exoProgress;
    public final ImageButton exoRepeatToggle;
    public final ImageButton exoRew;
    public final ImageView imgZoomIn;
    public final ImageView imgZoomOut;
    public final TextView pixelRate;
    private final LinearLayout rootView;

    private ExtracterExoControlViewBinding(LinearLayout rootView, ImageButton exoFfwd, ImageButton exoNext, ImageButton exoPause, ImageButton exoPlay, TextView exoPosition, ImageButton exoPrev, DefaultTimeBar exoProgress, ImageButton exoRepeatToggle, ImageButton exoRew, ImageView imgZoomIn, ImageView imgZoomOut, TextView pixelRate) {
        this.rootView = rootView;
        this.exoFfwd = exoFfwd;
        this.exoNext = exoNext;
        this.exoPause = exoPause;
        this.exoPlay = exoPlay;
        this.exoPosition = exoPosition;
        this.exoPrev = exoPrev;
        this.exoProgress = exoProgress;
        this.exoRepeatToggle = exoRepeatToggle;
        this.exoRew = exoRew;
        this.imgZoomIn = imgZoomIn;
        this.imgZoomOut = imgZoomOut;
        this.pixelRate = pixelRate;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ExtracterExoControlViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExtracterExoControlViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.extracter_exo_control_view, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExtracterExoControlViewBinding bind(View rootView) {
        int i = R.id.exo_ffwd;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_ffwd);
        if (imageButton != null) {
            i = R.id.exo_next;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_next);
            if (imageButton2 != null) {
                i = R.id.exo_pause;
                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_pause);
                if (imageButton3 != null) {
                    i = R.id.exo_play;
                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_play);
                    if (imageButton4 != null) {
                        i = R.id.exo_position;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.exo_position);
                        if (textView != null) {
                            i = R.id.exo_prev;
                            ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_prev);
                            if (imageButton5 != null) {
                                i = R.id.exo_progress;
                                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) ViewBindings.findChildViewById(rootView, R.id.exo_progress);
                                if (defaultTimeBar != null) {
                                    i = R.id.exo_repeat_toggle;
                                    ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_repeat_toggle);
                                    if (imageButton6 != null) {
                                        i = R.id.exo_rew;
                                        ImageButton imageButton7 = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.exo_rew);
                                        if (imageButton7 != null) {
                                            i = R.id.img_zoomIn;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_zoomIn);
                                            if (imageView != null) {
                                                i = R.id.img_zoomOut;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.img_zoomOut);
                                                if (imageView2 != null) {
                                                    i = R.id.pixel_rate;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.pixel_rate);
                                                    if (textView2 != null) {
                                                        return new ExtracterExoControlViewBinding((LinearLayout) rootView, imageButton, imageButton2, imageButton3, imageButton4, textView, imageButton5, defaultTimeBar, imageButton6, imageButton7, imageView, imageView2, textView2);
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
