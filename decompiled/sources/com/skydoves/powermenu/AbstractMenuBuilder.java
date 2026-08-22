package com.skydoves.powermenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractMenuBuilder {
    protected Context context;
    protected LayoutInflater layoutInflater;
    protected boolean showBackground = true;
    protected LifecycleOwner lifecycleOwner = null;
    protected View.OnClickListener backgroundClickListener = null;
    protected OnDismissedListener onDismissedListener = null;
    protected MenuAnimation menuAnimation = MenuAnimation.DROP_DOWN;
    protected View headerView = null;
    protected View footerView = null;
    protected int animationStyle = -1;
    protected float menuRadius = 5.0f;
    protected float menuShadow = 5.0f;
    protected int width = 0;
    protected int height = 0;
    protected int padding = 0;
    protected int dividerHeight = 0;
    protected Drawable divider = null;
    protected int backgroundColor = -16777216;
    protected int iconSize = 35;
    protected int iconPadding = 7;
    protected int iconColor = -2;
    protected float backgroundAlpha = 0.6f;
    protected int backgroundSystemUiVisibility = 0;
    protected boolean focusable = false;
    protected int selected = -1;
    protected boolean isClipping = true;
    protected boolean autoDismiss = false;
    protected boolean dismissIfShowAgain = true;
    protected String preferenceName = null;
    protected Lifecycle.Event initializeRule = null;
    protected int defaultPosition = 0;
    protected CircularEffect circularEffect = null;
    protected Boolean isMaterial = false;
}
