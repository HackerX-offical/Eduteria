package com.clevertap.android.sdk.inapp.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeInterstitialImageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeInterstitialImageFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeInterstitialImageFragment extends CTInAppBaseFullFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getInAppNotification().getIsTablet() && isTablet()) {
            viewInflate = inflater.inflate(R.layout.tab_inapp_interstitial_image, container, false);
        } else {
            viewInflate = inflater.inflate(R.layout.inapp_interstitial_image, container, false);
        }
        final FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.inapp_interstitial_image_frame_layout);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(CloseImageView.VIEW_ID);
        final RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R.id.interstitial_image_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.interstitial_image);
        int currentOrientation = getCurrentOrientation();
        if (currentOrientation == 1) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialImageFragment.onCreateView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (this.getInAppNotification().getIsTablet() && this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = this;
                        RelativeLayout relativeLayout2 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout2);
                        FrameLayout frameLayout2 = frameLayout;
                        Intrinsics.checkNotNull(frameLayout2);
                        CloseImageView closeImageView2 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView2);
                        cTInAppNativeInterstitialImageFragment.redrawInterstitialTabletInApp(relativeLayout2, layoutParams2, frameLayout2, closeImageView2);
                    } else if (this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = this;
                        RelativeLayout relativeLayout3 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout3);
                        FrameLayout frameLayout3 = frameLayout;
                        Intrinsics.checkNotNull(frameLayout3);
                        CloseImageView closeImageView3 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView3);
                        cTInAppNativeInterstitialImageFragment2.redrawInterstitialMobileInAppOnTablet(relativeLayout3, layoutParams2, frameLayout3, closeImageView3);
                    } else {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = this;
                        RelativeLayout relativeLayout4 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout4);
                        CloseImageView closeImageView4 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView4);
                        cTInAppNativeInterstitialImageFragment3.redrawInterstitialInApp(relativeLayout4, layoutParams2, closeImageView4);
                    }
                    relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (currentOrientation == 2) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialImageFragment.onCreateView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (this.getInAppNotification().getIsTablet() && this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment = this;
                        RelativeLayout relativeLayout2 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout2);
                        FrameLayout frameLayout2 = frameLayout;
                        Intrinsics.checkNotNull(frameLayout2);
                        CloseImageView closeImageView2 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView2);
                        cTInAppNativeInterstitialImageFragment.redrawLandscapeInterstitialTabletInApp(relativeLayout2, layoutParams2, frameLayout2, closeImageView2);
                    } else if (this.isTablet()) {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment2 = this;
                        RelativeLayout relativeLayout3 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout3);
                        FrameLayout frameLayout3 = frameLayout;
                        Intrinsics.checkNotNull(frameLayout3);
                        CloseImageView closeImageView3 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView3);
                        cTInAppNativeInterstitialImageFragment2.redrawLandscapeInterstitialMobileInAppOnTablet(relativeLayout3, layoutParams2, frameLayout3, closeImageView3);
                    } else {
                        CTInAppNativeInterstitialImageFragment cTInAppNativeInterstitialImageFragment3 = this;
                        RelativeLayout relativeLayout4 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout4);
                        CloseImageView closeImageView4 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView4);
                        cTInAppNativeInterstitialImageFragment3.redrawLandscapeInterstitialInApp(relativeLayout4, layoutParams2, closeImageView4);
                    }
                    relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        }
        CTInAppNotificationMedia inAppMediaForOrientation$clevertap_core_release = getInAppNotification().getInAppMediaForOrientation$clevertap_core_release(getCurrentOrientation());
        if (inAppMediaForOrientation$clevertap_core_release != null) {
            if (!StringsKt.isBlank(inAppMediaForOrientation$clevertap_core_release.getContentDescription())) {
                imageView.setContentDescription(inAppMediaForOrientation$clevertap_core_release.getContentDescription());
            }
            Bitmap bitmapCachedInAppImageV1 = resourceProvider().cachedInAppImageV1(inAppMediaForOrientation$clevertap_core_release.getMediaUrl());
            if (bitmapCachedInAppImageV1 != null) {
                imageView.setImageBitmap(bitmapCachedInAppImageV1);
                imageView.setTag(0);
                imageView.setOnClickListener(new CTInAppBaseFragment.CTInAppNativeButtonClickListener());
            }
        }
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialImageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CTInAppNativeInterstitialImageFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        if (!getInAppNotification().getIsHideCloseButton()) {
            closeImageView.setVisibility(8);
            return viewInflate;
        }
        closeImageView.setVisibility(0);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(CTInAppNativeInterstitialImageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.didDismiss(null);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
