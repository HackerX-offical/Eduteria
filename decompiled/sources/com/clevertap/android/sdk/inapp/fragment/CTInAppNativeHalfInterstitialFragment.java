package com.clevertap.android.sdk.inapp.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeHalfInterstitialFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeHalfInterstitialFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullNativeFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "isTabletFromDeviceType", "", "context", "Landroid/content/Context;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeHalfInterstitialFragment extends CTInAppBaseFullNativeFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ArrayList arrayList = new ArrayList();
        if ((getInAppNotification().getIsTablet() && isTablet()) || (getInAppNotification().getIsLocalInApp() && isTabletFromDeviceType(inflater.getContext()))) {
            viewInflate = inflater.inflate(R.layout.tab_inapp_half_interstitial, container, false);
            Intrinsics.checkNotNull(viewInflate);
        } else {
            viewInflate = inflater.inflate(R.layout.inapp_half_interstitial, container, false);
            Intrinsics.checkNotNull(viewInflate);
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.inapp_half_interstitial_frame_layout);
        final CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(CloseImageView.VIEW_ID);
        final RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R.id.half_interstitial_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        int currentOrientation = getCurrentOrientation();
        if (currentOrientation == 1) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment.onCreateView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if ((this.getInAppNotification().getIsTablet() && this.isTablet()) || (this.getInAppNotification().getIsLocalInApp() && this.isTabletFromDeviceType(inflater.getContext()))) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment = this;
                        RelativeLayout relativeLayout2 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout2);
                        CloseImageView closeImageView2 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView2);
                        cTInAppNativeHalfInterstitialFragment.redrawHalfInterstitialInApp(relativeLayout2, layoutParams2, closeImageView2);
                    } else if (this.isTablet()) {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment2 = this;
                        RelativeLayout relativeLayout3 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout3);
                        CloseImageView closeImageView3 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView3);
                        cTInAppNativeHalfInterstitialFragment2.redrawHalfInterstitialMobileInAppOnTablet(relativeLayout3, layoutParams2, closeImageView3);
                    } else {
                        CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment3 = this;
                        RelativeLayout relativeLayout4 = relativeLayout;
                        Intrinsics.checkNotNull(relativeLayout4);
                        CloseImageView closeImageView4 = closeImageView;
                        Intrinsics.checkNotNull(closeImageView4);
                        cTInAppNativeHalfInterstitialFragment3.redrawHalfInterstitialInApp(relativeLayout4, layoutParams2, closeImageView4);
                    }
                    relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else if (currentOrientation == 2) {
            relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(relativeLayout, this, closeImageView));
        }
        CTInAppNotificationMedia inAppMediaForOrientation$clevertap_core_release = getInAppNotification().getInAppMediaForOrientation$clevertap_core_release(getCurrentOrientation());
        if (inAppMediaForOrientation$clevertap_core_release != null) {
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.backgroundImage);
            if (!StringsKt.isBlank(inAppMediaForOrientation$clevertap_core_release.getContentDescription())) {
                imageView.setContentDescription(inAppMediaForOrientation$clevertap_core_release.getContentDescription());
            }
            Bitmap bitmapCachedInAppImageV1 = resourceProvider().cachedInAppImageV1(inAppMediaForOrientation$clevertap_core_release.getMediaUrl());
            if (bitmapCachedInAppImageV1 != null) {
                imageView.setImageBitmap(bitmapCachedInAppImageV1);
            }
        }
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.half_interstitial_linear_layout);
        Button button = (Button) linearLayout.findViewById(R.id.half_interstitial_button1);
        Intrinsics.checkNotNull(button);
        arrayList.add(button);
        Button button2 = (Button) linearLayout.findViewById(R.id.half_interstitial_button2);
        Intrinsics.checkNotNull(button2);
        arrayList.add(button2);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.half_interstitial_title);
        textView.setText(getInAppNotification().getTitle());
        textView.setTextColor(Color.parseColor(getInAppNotification().getTitleColor()));
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.half_interstitial_message);
        textView2.setText(getInAppNotification().getMessage());
        textView2.setTextColor(Color.parseColor(getInAppNotification().getMessageColor()));
        List<CTInAppNotificationButton> buttons = getInAppNotification().getButtons();
        if (buttons.size() == 1) {
            if (getCurrentOrientation() == 2) {
                button.setVisibility(8);
            } else if (getCurrentOrientation() == 1) {
                button.setVisibility(4);
            }
            setupInAppButton(button2, buttons.get(0), 0);
        } else if (!buttons.isEmpty()) {
            int size = buttons.size();
            for (int i = 0; i < size; i++) {
                if (i < 2) {
                    setupInAppButton((Button) arrayList.get(i), buttons.get(i), i);
                }
            }
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CTInAppNativeHalfInterstitialFragment.onCreateView$lambda$0(this.f$0, view);
            }
        });
        if (!getInAppNotification().getIsHideCloseButton()) {
            closeImageView.setVisibility(8);
            return viewInflate;
        }
        closeImageView.setVisibility(0);
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: CTInAppNativeHalfInterstitialFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/clevertap/android/sdk/inapp/fragment/CTInAppNativeHalfInterstitialFragment$onCreateView$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ CloseImageView $closeImageView;
        final /* synthetic */ RelativeLayout $relativeLayout;
        final /* synthetic */ CTInAppNativeHalfInterstitialFragment this$0;

        AnonymousClass2(RelativeLayout relativeLayout, CTInAppNativeHalfInterstitialFragment cTInAppNativeHalfInterstitialFragment, CloseImageView closeImageView) {
            this.$relativeLayout = relativeLayout;
            this.this$0 = cTInAppNativeHalfInterstitialFragment;
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
                    relativeLayout.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment$onCreateView$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            CTInAppNativeHalfInterstitialFragment.AnonymousClass2.onGlobalLayout$lambda$0(closeImageView, relativeLayout);
                        }
                    });
                } else {
                    layoutParams2.width = (int) (this.$relativeLayout.getMeasuredHeight() * 1.3f);
                    layoutParams2.gravity = 1;
                    this.$relativeLayout.setLayoutParams(layoutParams2);
                    final RelativeLayout relativeLayout2 = this.$relativeLayout;
                    final CloseImageView closeImageView2 = this.$closeImageView;
                    relativeLayout2.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment$onCreateView$2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CTInAppNativeHalfInterstitialFragment.AnonymousClass2.onGlobalLayout$lambda$1(closeImageView2, relativeLayout2);
                        }
                    });
                }
            } else {
                layoutParams2.width = (int) (this.$relativeLayout.getMeasuredHeight() * 1.3f);
                layoutParams2.gravity = 17;
                this.$relativeLayout.setLayoutParams(layoutParams2);
                final RelativeLayout relativeLayout3 = this.$relativeLayout;
                final CloseImageView closeImageView3 = this.$closeImageView;
                relativeLayout3.post(new Runnable() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeHalfInterstitialFragment$onCreateView$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        CTInAppNativeHalfInterstitialFragment.AnonymousClass2.onGlobalLayout$lambda$2(closeImageView3, relativeLayout3);
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
    public static final void onCreateView$lambda$0(CTInAppNativeHalfInterstitialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.didDismiss(null);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final boolean isTabletFromDeviceType(Context context) {
        return DeviceInfo.getDeviceType(context) == 2;
    }
}
