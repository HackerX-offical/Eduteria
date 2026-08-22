package com.clevertap.android.sdk.inapp.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTInAppHtmlHeaderFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/fragment/CTInAppHtmlHeaderFragment;", "Lcom/clevertap/android/sdk/inapp/fragment/CTInAppBasePartialHtmlFragment;", "<init>", "()V", "getLayout", "Landroid/view/ViewGroup;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getView", "inflater", "Landroid/view/LayoutInflater;", "container", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppHtmlHeaderFragment extends CTInAppBasePartialHtmlFragment {
    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBasePartialHtmlFragment
    public ViewGroup getLayout(View view) {
        if (view != null) {
            return (ViewGroup) view.findViewById(R.id.inapp_html_header_frame_layout);
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.inapp.fragment.CTInAppBasePartialHtmlFragment
    public View getView(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.inapp_html_header, container, false);
        Intrinsics.checkNotNull(viewInflate);
        CTXtensions.applyInsetsWithMarginAdjustment(viewInflate, new Function2() { // from class: com.clevertap.android.sdk.inapp.fragment.CTInAppHtmlHeaderFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CTInAppHtmlHeaderFragment.getView$lambda$0((Insets) obj, (ViewGroup.MarginLayoutParams) obj2);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getView$lambda$0(Insets insets, ViewGroup.MarginLayoutParams mlp) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mlp, "mlp");
        mlp.leftMargin = insets.left;
        mlp.rightMargin = insets.right;
        mlp.topMargin = insets.top;
        return Unit.INSTANCE;
    }
}
