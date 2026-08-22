package com.clevertap.android.sdk.inapp.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
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
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.gif.GifImageView;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import com.clevertap.android.sdk.video.InAppVideoPlayerHandle;
import com.clevertap.android.sdk.video.VideoLibChecker;
import com.clevertap.android.sdk.video.VideoLibraryIntegrated;
import com.clevertap.android.sdk.video.inapps.ExoplayerHandle;
import com.clevertap.android.sdk.video.inapps.Media3Handle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeInterstitialFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000*\u0001\u0016\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0014J\b\u0010'\u001a\u00020\u0019H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u0014\u00106\u001a\u00020\u0019*\u00020\u001d2\u0006\u00107\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u00069"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeInterstitialFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullNativeFragment;", "<init>", "()V", "exoPlayerFullscreen", "", "fullScreenDialog", "Landroidx/activity/ComponentDialog;", "fullScreenIcon", "Landroid/widget/ImageView;", "gifImageView", "Lcom/clevertap/android/sdk/gif/GifImageView;", "handle", "Lcom/clevertap/android/sdk/video/InAppVideoPlayerHandle;", "relativeLayout", "Landroid/widget/RelativeLayout;", "videoFrameLayout", "Landroid/widget/FrameLayout;", "videoFrameInDialog", "imageViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "onBackPressedCallback", "com/clevertap/android/sdk/inapp/fragment/CTInAppNativeInterstitialFragment$onBackPressedCallback$1", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeInterstitialFragment$onBackPressedCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onResume", "onPause", "onStop", "cleanup", "handleCloseButton", "setButtons", "setTitleAndMessage", "setMediaForInApp", "initFullScreenIconForStream", "resizeContainer", "fl", "closeImageView", "Lcom/clevertap/android/sdk/customviews/CloseImageView;", "disableFullScreenButton", "closeFullscreenDialog", "openFullscreenDialog", "playMedia", "prepareMedia", "addViewsForStreamMedia", "setContentDescriptionIfNotBlank", "contentDescription", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeInterstitialFragment extends CTInAppBaseFullNativeFragment {
    private boolean exoPlayerFullscreen;
    private ComponentDialog fullScreenDialog;
    private ImageView fullScreenIcon;
    private GifImageView gifImageView;
    private InAppVideoPlayerHandle handle;
    private ViewGroup.LayoutParams imageViewLayoutParams;
    private final CTInAppNativeInterstitialFragment$onBackPressedCallback$1 onBackPressedCallback = new OnBackPressedCallback() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialFragment$onBackPressedCallback$1
        {
            super(false);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (this.this$0.exoPlayerFullscreen) {
                this.this$0.closeFullscreenDialog();
                setEnabled(false);
            }
        }
    };
    private RelativeLayout relativeLayout;
    private FrameLayout videoFrameInDialog;
    private FrameLayout videoFrameLayout;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        ExoplayerHandle exoplayerHandle;
        super.onCreate(savedInstanceState);
        if (VideoLibChecker.mediaLibType == VideoLibraryIntegrated.MEDIA3) {
            exoplayerHandle = new Media3Handle();
        } else {
            exoplayerHandle = new ExoplayerHandle();
        }
        this.handle = exoplayerHandle;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getInAppNotification().getIsTablet() && isTablet()) {
            viewInflate = inflater.inflate(R.layout.tab_inapp_interstitial, container, false);
        } else {
            viewInflate = inflater.inflate(R.layout.inapp_interstitial, container, false);
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.inapp_interstitial_frame_layout);
        setCloseImageView((CloseImageView) frameLayout.findViewById(CloseImageView.VIEW_ID));
        RelativeLayout relativeLayout = (RelativeLayout) frameLayout.findViewById(R.id.interstitial_relative_layout);
        this.relativeLayout = relativeLayout;
        this.videoFrameLayout = relativeLayout != null ? (FrameLayout) relativeLayout.findViewById(R.id.video_frame) : null;
        RelativeLayout relativeLayout2 = this.relativeLayout;
        if (relativeLayout2 != null) {
            relativeLayout2.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        }
        frameLayout.setBackground(new ColorDrawable(-1157627904));
        Intrinsics.checkNotNull(frameLayout);
        CloseImageView closeImageView = getCloseImageView();
        Intrinsics.checkNotNull(closeImageView);
        resizeContainer(frameLayout, closeImageView);
        setMediaForInApp();
        setTitleAndMessage();
        setButtons();
        handleCloseButton();
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        CTInAppNotificationMedia cTInAppNotificationMedia;
        super.onStart();
        GifImageView gifImageView = this.gifImageView;
        if (gifImageView == null || (cTInAppNotificationMedia = (CTInAppNotificationMedia) CollectionsKt.firstOrNull((List) getInAppNotification().getMediaList$clevertap_core_release())) == null) {
            return;
        }
        gifImageView.setBytes(resourceProvider().cachedInAppGifV1(cTInAppNotificationMedia.getMediaUrl()));
        gifImageView.startAnimation();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getInAppNotification().hasStreamMedia()) {
            prepareMedia();
            playMedia();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GifImageView gifImageView = this.gifImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        if (this.exoPlayerFullscreen) {
            closeFullscreenDialog();
            setEnabled(false);
        }
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        InAppVideoPlayerHandle inAppVideoPlayerHandle2 = null;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        inAppVideoPlayerHandle.savePosition();
        InAppVideoPlayerHandle inAppVideoPlayerHandle3 = this.handle;
        if (inAppVideoPlayerHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
        } else {
            inAppVideoPlayerHandle2 = inAppVideoPlayerHandle3;
        }
        inAppVideoPlayerHandle2.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GifImageView gifImageView = this.gifImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        inAppVideoPlayerHandle.pause();
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFullFragment, com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment
    protected void cleanup() {
        super.cleanup();
        GifImageView gifImageView = this.gifImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        inAppVideoPlayerHandle.pause();
    }

    private final void handleCloseButton() {
        if (!getInAppNotification().getIsHideCloseButton()) {
            CloseImageView closeImageView = getCloseImageView();
            if (closeImageView != null) {
                closeImageView.setOnClickListener(null);
            }
            CloseImageView closeImageView2 = getCloseImageView();
            if (closeImageView2 != null) {
                closeImageView2.setVisibility(8);
                return;
            }
            return;
        }
        CloseImageView closeImageView3 = getCloseImageView();
        if (closeImageView3 != null) {
            closeImageView3.setVisibility(0);
        }
        CloseImageView closeImageView4 = getCloseImageView();
        if (closeImageView4 != null) {
            closeImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CTInAppNativeInterstitialFragment.handleCloseButton$lambda$1(this.f$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleCloseButton$lambda$1(CTInAppNativeInterstitialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.didDismiss(null);
        GifImageView gifImageView = this$0.gifImageView;
        if (gifImageView != null) {
            gifImageView.clear();
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void setButtons() {
        ArrayList arrayList = new ArrayList();
        RelativeLayout relativeLayout = this.relativeLayout;
        LinearLayout linearLayout = relativeLayout != null ? (LinearLayout) relativeLayout.findViewById(R.id.interstitial_linear_layout) : null;
        Button button = linearLayout != null ? (Button) linearLayout.findViewById(R.id.interstitial_button1) : null;
        if (button != null) {
            arrayList.add(button);
        }
        Button button2 = linearLayout != null ? (Button) linearLayout.findViewById(R.id.interstitial_button2) : null;
        if (button2 != null) {
            arrayList.add(button2);
        }
        List<CTInAppNotificationButton> buttons = getInAppNotification().getButtons();
        if (buttons.size() == 1) {
            if (getCurrentOrientation() == 2) {
                if (button != null) {
                    button.setVisibility(8);
                }
            } else if (getCurrentOrientation() == 1 && button != null) {
                button.setVisibility(4);
            }
            if (button2 != null) {
                setupInAppButton(button2, buttons.get(0), 0);
                return;
            }
            return;
        }
        if (buttons.isEmpty()) {
            return;
        }
        int size = buttons.size();
        for (int i = 0; i < size && i < 2; i++) {
            setupInAppButton((Button) arrayList.get(i), buttons.get(i), i);
        }
    }

    private final void setTitleAndMessage() {
        RelativeLayout relativeLayout = this.relativeLayout;
        TextView textView = relativeLayout != null ? (TextView) relativeLayout.findViewById(R.id.interstitial_title) : null;
        if (textView != null) {
            textView.setText(getInAppNotification().getTitle());
        }
        if (textView != null) {
            textView.setTextColor(Color.parseColor(getInAppNotification().getTitleColor()));
        }
        RelativeLayout relativeLayout2 = this.relativeLayout;
        TextView textView2 = relativeLayout2 != null ? (TextView) relativeLayout2.findViewById(R.id.interstitial_message) : null;
        if (textView2 != null) {
            textView2.setText(getInAppNotification().getMessage());
        }
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor(getInAppNotification().getMessageColor()));
        }
    }

    private final void setMediaForInApp() {
        if (getInAppNotification().getMediaList$clevertap_core_release().isEmpty()) {
            return;
        }
        CTInAppNotificationMedia cTInAppNotificationMedia = getInAppNotification().getMediaList$clevertap_core_release().get(0);
        if (cTInAppNotificationMedia.isImage()) {
            Bitmap bitmapCachedInAppImageV1 = resourceProvider().cachedInAppImageV1(cTInAppNotificationMedia.getMediaUrl());
            if (bitmapCachedInAppImageV1 != null) {
                RelativeLayout relativeLayout = this.relativeLayout;
                ImageView imageView = relativeLayout != null ? (ImageView) relativeLayout.findViewById(R.id.backgroundImage) : null;
                if (imageView != null) {
                    setContentDescriptionIfNotBlank(imageView, cTInAppNotificationMedia.getContentDescription());
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (imageView != null) {
                    imageView.setImageBitmap(bitmapCachedInAppImageV1);
                    return;
                }
                return;
            }
            return;
        }
        if (cTInAppNotificationMedia.isGIF()) {
            byte[] bArrCachedInAppGifV1 = resourceProvider().cachedInAppGifV1(cTInAppNotificationMedia.getMediaUrl());
            if (bArrCachedInAppGifV1 != null) {
                RelativeLayout relativeLayout2 = this.relativeLayout;
                GifImageView gifImageView = relativeLayout2 != null ? (GifImageView) relativeLayout2.findViewById(R.id.gifImage) : null;
                this.gifImageView = gifImageView;
                if (gifImageView != null) {
                    setContentDescriptionIfNotBlank(gifImageView, cTInAppNotificationMedia.getContentDescription());
                }
                GifImageView gifImageView2 = this.gifImageView;
                if (gifImageView2 != null) {
                    gifImageView2.setVisibility(0);
                }
                GifImageView gifImageView3 = this.gifImageView;
                if (gifImageView3 != null) {
                    gifImageView3.setBytes(bArrCachedInAppGifV1);
                }
                GifImageView gifImageView4 = this.gifImageView;
                if (gifImageView4 != null) {
                    gifImageView4.startAnimation();
                    return;
                }
                return;
            }
            return;
        }
        if (cTInAppNotificationMedia.isVideo()) {
            initFullScreenIconForStream();
            prepareMedia();
            playMedia();
            FrameLayout frameLayout = this.videoFrameLayout;
            if (frameLayout != null) {
                setContentDescriptionIfNotBlank(frameLayout, cTInAppNotificationMedia.getContentDescription());
                return;
            }
            return;
        }
        if (cTInAppNotificationMedia.isAudio()) {
            initFullScreenIconForStream();
            prepareMedia();
            playMedia();
            disableFullScreenButton();
            FrameLayout frameLayout2 = this.videoFrameLayout;
            if (frameLayout2 != null) {
                setContentDescriptionIfNotBlank(frameLayout2, cTInAppNotificationMedia.getContentDescription());
            }
        }
    }

    private final void initFullScreenIconForStream() {
        float fApplyDimension;
        ImageView imageView = new ImageView(requireContext());
        this.fullScreenIcon = imageView;
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ct_ic_fullscreen_expand, null));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CTInAppNativeInterstitialFragment.initFullScreenIconForStream$lambda$5(this.f$0, view);
            }
        });
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (getInAppNotification().getIsTablet() && isTablet()) {
            fApplyDimension = TypedValue.applyDimension(1, 30.0f, displayMetrics);
        } else {
            fApplyDimension = TypedValue.applyDimension(1, 20.0f, displayMetrics);
        }
        int i = (int) fApplyDimension;
        int iApplyDimension = (int) TypedValue.applyDimension(1, 4.0f, displayMetrics);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = GravityCompat.END;
        layoutParams.setMargins(0, iApplyDimension, iApplyDimension2, 0);
        imageView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFullScreenIconForStream$lambda$5(CTInAppNativeInterstitialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.exoPlayerFullscreen) {
            this$0.onBackPressedCallback.setEnabled(true);
            this$0.openFullscreenDialog();
        } else {
            this$0.closeFullscreenDialog();
            this$0.onBackPressedCallback.setEnabled(false);
        }
    }

    private final void resizeContainer(final FrameLayout fl, final CloseImageView closeImageView) {
        ViewTreeObserver viewTreeObserver;
        RelativeLayout relativeLayout;
        ViewTreeObserver viewTreeObserver2;
        int currentOrientation = getCurrentOrientation();
        if (currentOrientation != 1) {
            if (currentOrientation != 2 || (relativeLayout = this.relativeLayout) == null || (viewTreeObserver2 = relativeLayout.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialFragment.resizeContainer.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    RelativeLayout relativeLayout2 = CTInAppNativeInterstitialFragment.this.relativeLayout;
                    if (relativeLayout2 == null) {
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = relativeLayout2.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    if (CTInAppNativeInterstitialFragment.this.getInAppNotification().getIsTablet() && CTInAppNativeInterstitialFragment.this.isTablet()) {
                        CTInAppNativeInterstitialFragment.this.redrawLandscapeInterstitialTabletInApp(relativeLayout2, layoutParams2, fl, closeImageView);
                    } else if (CTInAppNativeInterstitialFragment.this.isTablet()) {
                        CTInAppNativeInterstitialFragment.this.redrawLandscapeInterstitialMobileInAppOnTablet(relativeLayout2, layoutParams2, fl, closeImageView);
                    } else {
                        CTInAppNativeInterstitialFragment.this.redrawLandscapeInterstitialInApp(relativeLayout2, layoutParams2, closeImageView);
                    }
                    relativeLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
            return;
        }
        RelativeLayout relativeLayout2 = this.relativeLayout;
        if (relativeLayout2 == null || (viewTreeObserver = relativeLayout2.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeInterstitialFragment.resizeContainer.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RelativeLayout relativeLayout3 = CTInAppNativeInterstitialFragment.this.relativeLayout;
                if (relativeLayout3 == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = relativeLayout3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                if (CTInAppNativeInterstitialFragment.this.getInAppNotification().getIsTablet() && CTInAppNativeInterstitialFragment.this.isTablet()) {
                    CTInAppNativeInterstitialFragment.this.redrawInterstitialTabletInApp(relativeLayout3, layoutParams2, fl, closeImageView);
                } else if (CTInAppNativeInterstitialFragment.this.isTablet()) {
                    CTInAppNativeInterstitialFragment.this.redrawInterstitialMobileInAppOnTablet(relativeLayout3, layoutParams2, fl, closeImageView);
                } else {
                    CTInAppNativeInterstitialFragment.this.redrawInterstitialInApp(relativeLayout3, layoutParams2, closeImageView);
                }
                relativeLayout3.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    private final void disableFullScreenButton() {
        ImageView imageView = this.fullScreenIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeFullscreenDialog() {
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        InAppVideoPlayerHandle inAppVideoPlayerHandle2 = null;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        View viewVideoSurface = inAppVideoPlayerHandle.videoSurface();
        InAppVideoPlayerHandle inAppVideoPlayerHandle3 = this.handle;
        if (inAppVideoPlayerHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
        } else {
            inAppVideoPlayerHandle2 = inAppVideoPlayerHandle3;
        }
        inAppVideoPlayerHandle2.switchToFullScreen(false);
        ImageView imageView = this.fullScreenIcon;
        if (imageView != null) {
            imageView.setLayoutParams(this.imageViewLayoutParams);
        }
        FrameLayout frameLayout = this.videoFrameInDialog;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.videoFrameLayout;
        if (frameLayout2 != null) {
            frameLayout2.addView(viewVideoSurface);
        }
        FrameLayout frameLayout3 = this.videoFrameLayout;
        if (frameLayout3 != null) {
            frameLayout3.addView(this.fullScreenIcon);
        }
        this.exoPlayerFullscreen = false;
        ComponentDialog componentDialog = this.fullScreenDialog;
        if (componentDialog != null) {
            componentDialog.dismiss();
        }
        ImageView imageView2 = this.fullScreenIcon;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ct_ic_fullscreen_expand));
        }
    }

    private final void openFullscreenDialog() {
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        InAppVideoPlayerHandle inAppVideoPlayerHandle2 = null;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        View viewVideoSurface = inAppVideoPlayerHandle.videoSurface();
        ImageView imageView = this.fullScreenIcon;
        this.imageViewLayoutParams = imageView != null ? imageView.getLayoutParams() : null;
        InAppVideoPlayerHandle inAppVideoPlayerHandle3 = this.handle;
        if (inAppVideoPlayerHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
        } else {
            inAppVideoPlayerHandle2 = inAppVideoPlayerHandle3;
        }
        inAppVideoPlayerHandle2.switchToFullScreen(true);
        FrameLayout frameLayout = this.videoFrameLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        if (this.fullScreenDialog == null) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ComponentDialog componentDialog = new ComponentDialog(contextRequireContext, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
            this.fullScreenDialog = componentDialog;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FrameLayout frameLayout2 = new FrameLayout(requireContext());
            this.videoFrameInDialog = frameLayout2;
            componentDialog.addContentView(frameLayout2, layoutParams);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                componentDialog.getOnBackPressedDispatcher().addCallback(activity, this.onBackPressedCallback);
            }
        }
        FrameLayout frameLayout3 = this.videoFrameInDialog;
        if (frameLayout3 != null) {
            frameLayout3.addView(viewVideoSurface);
        }
        this.exoPlayerFullscreen = true;
        ComponentDialog componentDialog2 = this.fullScreenDialog;
        if (componentDialog2 != null) {
            componentDialog2.show();
        }
    }

    private final void playMedia() {
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        inAppVideoPlayerHandle.play();
    }

    private final void prepareMedia() {
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        InAppVideoPlayerHandle inAppVideoPlayerHandle2 = null;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        inAppVideoPlayerHandle.initPlayerView(contextRequireContext, getInAppNotification().getIsTablet() && isTablet());
        addViewsForStreamMedia();
        InAppVideoPlayerHandle inAppVideoPlayerHandle3 = this.handle;
        if (inAppVideoPlayerHandle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
        } else {
            inAppVideoPlayerHandle2 = inAppVideoPlayerHandle3;
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        inAppVideoPlayerHandle2.initExoplayer(contextRequireContext2, getInAppNotification().getMediaList$clevertap_core_release().get(0).getMediaUrl());
    }

    private final void addViewsForStreamMedia() {
        FrameLayout frameLayout = this.videoFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        InAppVideoPlayerHandle inAppVideoPlayerHandle = this.handle;
        if (inAppVideoPlayerHandle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handle");
            inAppVideoPlayerHandle = null;
        }
        View viewVideoSurface = inAppVideoPlayerHandle.videoSurface();
        FrameLayout frameLayout2 = this.videoFrameLayout;
        if (frameLayout2 != null && frameLayout2.getChildCount() == 0) {
            FrameLayout frameLayout3 = this.videoFrameLayout;
            if (frameLayout3 != null) {
                frameLayout3.addView(viewVideoSurface);
            }
            FrameLayout frameLayout4 = this.videoFrameLayout;
            if (frameLayout4 != null) {
                frameLayout4.addView(this.fullScreenIcon);
                return;
            }
            return;
        }
        Logger.d("Video views and controls are already added, not re-attaching");
    }

    private final void setContentDescriptionIfNotBlank(View view, String str) {
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            return;
        }
        view.setContentDescription(str2);
    }
}
