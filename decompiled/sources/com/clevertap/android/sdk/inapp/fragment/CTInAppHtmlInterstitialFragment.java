package com.clevertap.android.sdk.inapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import com.clevertap.android.sdk.CTXtensions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInAppHtmlInterstitialFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppHtmlInterstitialFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBaseFullHtmlFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppHtmlInterstitialFragment extends CTInAppBaseFullHtmlFragment {
    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBaseFullHtmlFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (!getIsFullscreen() && viewOnCreateView != null) {
            CTXtensions.applyInsetsWithMarginAdjustment(viewOnCreateView, new Function2() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppHtmlInterstitialFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CTInAppHtmlInterstitialFragment.onCreateView$lambda$0((Insets) obj, (ViewGroup.MarginLayoutParams) obj2);
                }
            });
        }
        return viewOnCreateView;
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
}
