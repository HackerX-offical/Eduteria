package com.razorpay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes9.dex */
final class RZPProgressBar {
    private String color;
    private ViewGroup container;
    private Context context;
    private int defaultHeight;
    private View progressBar;
    private float screenWidth;

    public RZPProgressBar(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, null);
    }

    public RZPProgressBar(Context context, ViewGroup viewGroup, String str) {
        this.color = str;
        this.context = context;
        this.container = viewGroup;
        getScreenDimensions();
        this.defaultHeight = convertDPtoInt(4);
        insertView();
    }

    private void getScreenDimensions() {
        this.screenWidth = r0.widthPixels / this.context.getResources().getDisplayMetrics().density;
    }

    private int getThemeAccentColor() {
        TypedValue typedValue = new TypedValue();
        if (this.context.getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true)) {
            return typedValue.data;
        }
        return Color.parseColor("#4aa3df");
    }

    private void insertView() {
        int themeAccentColor;
        this.progressBar = new View(this.context);
        this.progressBar.setLayoutParams(new RelativeLayout.LayoutParams(0, this.defaultHeight));
        if (TextUtils.isEmpty(this.color)) {
            themeAccentColor = getThemeAccentColor();
        } else {
            try {
                themeAccentColor = Color.parseColor(this.color);
            } catch (IllegalArgumentException unused) {
                themeAccentColor = getThemeAccentColor();
            }
        }
        float[] fArr = new float[3];
        Color.colorToHSV(themeAccentColor, fArr);
        fArr[2] = fArr[2] * 0.8f;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{themeAccentColor, Color.HSVToColor(fArr)});
        gradientDrawable.setCornerRadius(0.0f);
        this.progressBar.setBackgroundDrawable(gradientDrawable);
        this.container.addView(this.progressBar);
    }

    private int convertDPtoInt(int i) {
        return (int) TypedValue.applyDimension(1, i, this.context.getResources().getDisplayMetrics());
    }

    final void show(int i) {
        if (i == 100) {
            hide();
        } else {
            animateTo(i, 500);
        }
    }

    final void hide() {
        animateToEnd(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateTo(int i, int i2) {
        ResizeWidthAnimation resizeWidthAnimation = new ResizeWidthAnimation(this.progressBar, convertDPtoInt((int) ((this.screenWidth * i) / 100.0f)));
        resizeWidthAnimation.setDuration(i2);
        this.progressBar.startAnimation(resizeWidthAnimation);
        resizeWidthAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.razorpay.RZPProgressBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void animateToEnd(int i) {
        ResizeWidthAnimation resizeWidthAnimation = new ResizeWidthAnimation(this.progressBar, convertDPtoInt((int) this.screenWidth));
        resizeWidthAnimation.setDuration(i);
        this.progressBar.startAnimation(resizeWidthAnimation);
        resizeWidthAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.razorpay.RZPProgressBar.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                RZPProgressBar.this.animateTo(0, 10);
            }
        });
    }
}
