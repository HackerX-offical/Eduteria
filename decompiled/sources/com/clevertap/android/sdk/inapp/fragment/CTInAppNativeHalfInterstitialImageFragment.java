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
import com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeHalfInterstitialImageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeHalfInterstitialImageFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeHalfInterstitialImageFragment extends CTInAppBaseFullFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getInAppNotification().getIsTablet() && isTablet()) {
            viewInflate = inflater.inflate(R.layout.tab_inapp_half_interstitial_image, container, false);
        } else {
            viewInflate = inflater.inflate(R.layout.inapp_half_interstitial_image, container, false);
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.inapp_half_interstitial_image_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(CloseImageView.VIEW_ID);
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        final RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R.id.half_interstitial_image_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.half_interstitial_image);
        int currentOrientation = getCurrentOrientation();
        if (currentOrientation == 1) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment.onCreateView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (this.getInAppNotification().getIsTablet() && this.isTablet()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment = this;
                        RelativeLayout relativeLayout2 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout2);
                        CloseImageView closeImageView2 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView2);
                        cTInAppNativeHalfInterstitialImageFragment.redrawHalfInterstitialInApp(relativeLayout2, layoutParams2, closeImageView2);
                    } else if (this.isTablet()) {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment2 = this;
                        RelativeLayout relativeLayout3 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout3);
                        CloseImageView closeImageView3 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView3);
                        cTInAppNativeHalfInterstitialImageFragment2.redrawHalfInterstitialMobileInAppOnTablet(relativeLayout3, layoutParams2, closeImageView3);
                    } else {
                        CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment3 = this;
                        RelativeLayout relativeLayout4 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout4);
                        CloseImageView closeImageView4 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView4);
                        cTInAppNativeHalfInterstitialImageFragment3.redrawHalfInterstitialInApp(relativeLayout4, layoutParams2, closeImageView4);
                    }
                    relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (currentOrientation == 2) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(relativeLayout, this, closeImageView));
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
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CTInAppNativeHalfInterstitialImageFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        if (!getInAppNotification().getIsHideCloseButton()) {
            closeImageView.setVisibility(8);
            return viewInflate;
        }
        closeImageView.setVisibility(0);
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: CTInAppNativeHalfInterstitialImageFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/clevertap/android/sdk/inapp/fragment/CTInAppNativeHalfInterstitialImageFragment$onCreateView$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ CloseImageView $closeImageView;
        final /* synthetic */ RelativeLayout $relativeLayout;
        final /* synthetic */ CTInAppNativeHalfInterstitialImageFragment this$0;

        AnonymousClass2(RelativeLayout relativeLayout, CTInAppNativeHalfInterstitialImageFragment cTInAppNativeHalfInterstitialImageFragment, CloseImageView closeImageView) {
            this.$relativeLayout = relativeLayout;
            this.this$0 = cTInAppNativeHalfInterstitialImageFragment;
            this.$closeImageView = closeImageView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams = this.$relativeLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (!this.this$0.getInAppNotification().getIsTablet() || !this.this$0.isTablet()) {
                if (this.this$0.isTablet()) {
                    layoutParams2.setMargins(this.this$0.getScaledPixels(140), this.this$0.getScaledPixels(100), this.this$0.getScaledPixels(140), this.this$0.getScaledPixels(100));
                    layoutParams2.height = this.$relativeLayout.getMeasuredHeight() - this.this$0.getScaledPixels(130);
                    layoutParams2.width = (int) (layoutParams2.height * 1.3f);
                    layoutParams2.gravity = 17;
                    this.$relativeLayout.setLayoutParams(layoutParams2);
                    final RelativeLayout relativeLayout = this.$relativeLayout;
                    final CloseImageView closeImageView = this.$closeImageView;
                    relativeLayout.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment$onCreateView$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CTInAppNativeHalfInterstitialImageFragment.AnonymousClass2.onGlobalLayout$lambda$0(closeImageView, relativeLayout);
                        }
                    });
                } else {
                    layoutParams2.width = (int) (this.$relativeLayout.getMeasuredHeight() * 1.3f);
                    layoutParams2.gravity = 1;
                    this.$relativeLayout.setLayoutParams(layoutParams2);
                    final RelativeLayout relativeLayout2 = this.$relativeLayout;
                    final CloseImageView closeImageView2 = this.$closeImageView;
                    relativeLayout2.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment$onCreateView$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CTInAppNativeHalfInterstitialImageFragment.AnonymousClass2.onGlobalLayout$lambda$1(closeImageView2, relativeLayout2);
                        }
                    });
                }
            } else {
                layoutParams2.width = (int) (this.$relativeLayout.getMeasuredHeight() * 1.3f);
                layoutParams2.gravity = 17;
                this.$relativeLayout.setLayoutParams(layoutParams2);
                final RelativeLayout relativeLayout3 = this.$relativeLayout;
                final CloseImageView closeImageView3 = this.$closeImageView;
                relativeLayout3.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialImageFragment$onCreateView$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        CTInAppNativeHalfInterstitialImageFragment.AnonymousClass2.onGlobalLayout$lambda$2(closeImageView3, relativeLayout3);
                    }
                });
            }
            this.$relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$0(CloseImageView closeImageView, RelativeLayout relativeLayout) {
            int measuredWidth = closeImageView.getMeasuredWidth() / 2;
            closeImageView.setX(relativeLayout.getRight() - measuredWidth);
            closeImageView.setY(relativeLayout.getTop() - measuredWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$1(CloseImageView closeImageView, RelativeLayout relativeLayout) {
            int measuredWidth = closeImageView.getMeasuredWidth() / 2;
            closeImageView.setX(relativeLayout.getRight() - measuredWidth);
            closeImageView.setY(relativeLayout.getTop() - measuredWidth);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onGlobalLayout$lambda$2(CloseImageView closeImageView, RelativeLayout relativeLayout) {
            int measuredWidth = closeImageView.getMeasuredWidth() / 2;
            closeImageView.setX(relativeLayout.getRight() - measuredWidth);
            closeImageView.setY(relativeLayout.getTop() - measuredWidth);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(CTInAppNativeHalfInterstitialImageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.didDismiss(null);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
