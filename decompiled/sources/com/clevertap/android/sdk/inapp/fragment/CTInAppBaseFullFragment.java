package com.clevertap.android.sdk.inapp.fragment;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.clevertap.android.sdk.InAppNotificationActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.InAppListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInAppBaseFullFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0014J\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ&\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t¨\u0006\u001a"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFragment;", "<init>", "()V", "addCloseImageView", "", "relativeLayout", "Landroid/widget/RelativeLayout;", "closeImageView", "Lcom/clevertap/android/sdk/customviews/CloseImageView;", "cleanup", "generateListener", "isTablet", "", "redrawHalfInterstitialInApp", "layoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "redrawHalfInterstitialMobileInAppOnTablet", "redrawInterstitialInApp", "redrawInterstitialMobileInAppOnTablet", "fl", "Landroid/widget/FrameLayout;", "redrawInterstitialTabletInApp", "redrawLandscapeInterstitialInApp", "redrawLandscapeInterstitialMobileInAppOnTablet", "redrawLandscapeInterstitialTabletInApp", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CTInAppBaseFullFragment extends CTInAppBaseFragment {
    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment
    protected void cleanup() {
    }

    public final void addCloseImageView(final RelativeLayout relativeLayout, final CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        relativeLayout.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFullFragment.addCloseImageView.1
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth = closeImageView.getMeasuredWidth() / 2;
                closeImageView.setX(relativeLayout.getRight() - measuredWidth);
                closeImageView.setY(relativeLayout.getTop() - measuredWidth);
            }
        });
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment
    protected void generateListener() {
        Object context = getContext();
        if (context instanceof InAppNotificationActivity) {
            setListener((InAppListener) context);
        }
    }

    public final boolean isTablet() {
        if (Utils.isActivityDead(getActivity())) {
            return false;
        }
        try {
            return getResources().getBoolean(R.bool.ctIsTablet);
        } catch (Exception unused) {
            Logger.d("Failed to decide whether device is a smart phone or tablet!");
            return false;
        }
    }

    public final void redrawHalfInterstitialInApp(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        layoutParams.height = (int) (relativeLayout.getMeasuredWidth() * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawHalfInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(140), getScaledPixels(140), getScaledPixels(140));
        layoutParams.width = relativeLayout.getMeasuredWidth() - getScaledPixels(210);
        layoutParams.height = (int) (layoutParams.width * 1.3f);
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawInterstitialInApp(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        layoutParams.height = (int) (relativeLayout.getMeasuredWidth() * 1.78f);
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout fl, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(fl, "fl");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        int measuredWidth = (int) ((relativeLayout.getMeasuredWidth() - getScaledPixels(200)) * 1.78f);
        int measuredHeight = fl.getMeasuredHeight() - getScaledPixels(280);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (measuredHeight / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
            layoutParams.width = relativeLayout.getMeasuredWidth() - getScaledPixels(200);
        }
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(140), getScaledPixels(140), getScaledPixels(140));
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawInterstitialTabletInApp(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout fl, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(fl, "fl");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        int measuredWidth = (int) (relativeLayout.getMeasuredWidth() * 1.78f);
        int measuredHeight = fl.getMeasuredHeight() - getScaledPixels(80);
        if (measuredWidth > measuredHeight) {
            layoutParams.height = measuredHeight;
            layoutParams.width = (int) (measuredHeight / 1.78f);
        } else {
            layoutParams.height = measuredWidth;
        }
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawLandscapeInterstitialInApp(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        layoutParams.width = (int) (relativeLayout.getMeasuredHeight() * 1.78f);
        layoutParams.gravity = 1;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawLandscapeInterstitialMobileInAppOnTablet(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout fl, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(fl, "fl");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        int measuredHeight = (int) ((relativeLayout.getMeasuredHeight() - getScaledPixels(120)) * 1.78f);
        int measuredWidth = fl.getMeasuredWidth() - getScaledPixels(280);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (measuredWidth / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
            layoutParams.height = relativeLayout.getMeasuredHeight() - getScaledPixels(120);
        }
        layoutParams.setMargins(getScaledPixels(140), getScaledPixels(100), getScaledPixels(140), getScaledPixels(100));
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }

    public final void redrawLandscapeInterstitialTabletInApp(RelativeLayout relativeLayout, FrameLayout.LayoutParams layoutParams, FrameLayout fl, CloseImageView closeImageView) {
        Intrinsics.checkNotNullParameter(relativeLayout, "relativeLayout");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Intrinsics.checkNotNullParameter(fl, "fl");
        Intrinsics.checkNotNullParameter(closeImageView, "closeImageView");
        int measuredHeight = (int) (relativeLayout.getMeasuredHeight() * 1.78f);
        int measuredWidth = fl.getMeasuredWidth() - getScaledPixels(80);
        if (measuredHeight > measuredWidth) {
            layoutParams.width = measuredWidth;
            layoutParams.height = (int) (measuredWidth / 1.78f);
        } else {
            layoutParams.width = measuredHeight;
        }
        layoutParams.gravity = 17;
        relativeLayout.setLayoutParams(layoutParams);
        addCloseImageView(relativeLayout, closeImageView);
    }
}
