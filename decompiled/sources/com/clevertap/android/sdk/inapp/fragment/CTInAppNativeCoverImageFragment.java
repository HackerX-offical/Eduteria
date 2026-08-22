package com.clevertap.android.sdk.inapp.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.Insets;
import androidx.fragment.app.FragmentActivity;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeCoverImageFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeCoverImageFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeCoverImageFragment extends CTInAppBaseFullFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.inapp_cover_image, container, false);
        Intrinsics.checkNotNull(viewInflate);
        CTXtensions.applyInsetsWithMarginAdjustment(viewInflate, new Function2() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeCoverImageFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CTInAppNativeCoverImageFragment.onCreateView$lambda$0((Insets) obj, (ViewGroup.MarginLayoutParams) obj2);
            }
        });
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.inapp_cover_image_frame_layout);
        frameLayout.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        ImageView imageView = (ImageView) ((RelativeLayout) frameLayout.findViewById(R.id.cover_image_relative_layout)).findViewById(R.id.cover_image);
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
        CloseImageView closeImageView = (CloseImageView) frameLayout.findViewById(CloseImageView.VIEW_ID);
        closeImageView.setOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeCoverImageFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CTInAppNativeCoverImageFragment.onCreateView$lambda$1(this.f$0, view);
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
    public static final Unit onCreateView$lambda$0(Insets insets, ViewGroup.MarginLayoutParams mlp) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mlp, "mlp");
        mlp.leftMargin = insets.left;
        mlp.rightMargin = insets.right;
        mlp.topMargin = insets.top;
        mlp.bottomMargin = insets.bottom;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(CTInAppNativeCoverImageFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.didDismiss(null);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
