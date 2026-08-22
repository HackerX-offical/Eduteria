package com.clevertap.android.sdk;

import android.content.DialogInterface;
import com.clevertap.android.sdk.inapp.CTInAppNotificationButton;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class InAppNotificationActivity$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ InAppNotificationActivity f$0;
    public final /* synthetic */ CTInAppNotificationButton f$1;

    public /* synthetic */ InAppNotificationActivity$$ExternalSyntheticLambda3(InAppNotificationActivity inAppNotificationActivity, CTInAppNotificationButton cTInAppNotificationButton) {
        this.f$0 = inAppNotificationActivity;
        this.f$1 = cTInAppNotificationButton;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f$0.m11877x4506b8f0(this.f$1, dialogInterface, i);
    }
}
