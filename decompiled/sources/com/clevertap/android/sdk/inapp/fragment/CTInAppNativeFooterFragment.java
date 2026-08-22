package com.clevertap.android.sdk.inapp.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CTInAppNativeFooterFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppNativeFooterFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialNativeFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNativeFooterFragment extends CTInAppBasePartialNativeFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ArrayList arrayList = new ArrayList();
        View viewInflate = inflater.inflate(R.layout.inapp_footer, container, false);
        setInAppView(viewInflate);
        RelativeLayout relativeLayout = (RelativeLayout) ((FrameLayout) viewInflate.findViewById(R.id.footer_frame_layout)).findViewById(R.id.footer_relative_layout);
        relativeLayout.setBackgroundColor(Color.parseColor(getInAppNotification().getBackgroundColor()));
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.footer_linear_layout_1);
        LinearLayout linearLayout2 = (LinearLayout) relativeLayout.findViewById(R.id.footer_linear_layout_2);
        LinearLayout linearLayout3 = (LinearLayout) relativeLayout.findViewById(R.id.footer_linear_layout_3);
        Button button = (Button) linearLayout3.findViewById(R.id.footer_button_1);
        Intrinsics.checkNotNull(button);
        arrayList.add(button);
        Button button2 = (Button) linearLayout3.findViewById(R.id.footer_button_2);
        Intrinsics.checkNotNull(button2);
        arrayList.add(button2);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.footer_icon);
        if (!getInAppNotification().getMediaList$clevertap_core_release().isEmpty()) {
            CTInAppNotificationMedia cTInAppNotificationMedia = getInAppNotification().getMediaList$clevertap_core_release().get(0);
            if (!StringsKt.isBlank(cTInAppNotificationMedia.getContentDescription())) {
                imageView.setContentDescription(cTInAppNotificationMedia.getContentDescription());
            }
            Bitmap bitmapCachedInAppImageV1 = resourceProvider().cachedInAppImageV1(cTInAppNotificationMedia.getMediaUrl());
            if (bitmapCachedInAppImageV1 != null) {
                imageView.setImageBitmap(bitmapCachedInAppImageV1);
            } else {
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(8);
        }
        TextView textView = (TextView) linearLayout2.findViewById(R.id.footer_title);
        textView.setText(getInAppNotification().getTitle());
        textView.setTextColor(Color.parseColor(getInAppNotification().getTitleColor()));
        TextView textView2 = (TextView) linearLayout2.findViewById(R.id.footer_message);
        textView2.setText(getInAppNotification().getMessage());
        textView2.setTextColor(Color.parseColor(getInAppNotification().getMessageColor()));
        List<CTInAppNotificationButton> buttons = getInAppNotification().getButtons();
        if (!buttons.isEmpty()) {
            int size = buttons.size();
            for (int i = 0; i < size && i < 2; i++) {
                setupInAppButton((Button) arrayList.get(i), buttons.get(i), i);
            }
        }
        if (getInAppNotification().getButtonCount() == 1) {
            hideSecondaryButton(button, button2);
        }
        viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeFooterFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CTInAppNativeFooterFragment.onCreateView$lambda$0(this.f$0, view, motionEvent);
            }
        });
        Intrinsics.checkNotNull(viewInflate);
        CTXtensions.applyInsetsWithMarginAdjustment(viewInflate, new Function2() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppNativeFooterFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CTInAppNativeFooterFragment.onCreateView$lambda$1((Insets) obj, (ViewGroup.MarginLayoutParams) obj2);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$0(CTInAppNativeFooterFragment this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGd().onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(Insets insets, ViewGroup.MarginLayoutParams mlp) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mlp, "mlp");
        mlp.leftMargin = insets.left;
        mlp.rightMargin = insets.right;
        mlp.bottomMargin = insets.bottom;
        return Unit.INSTANCE;
    }
}
