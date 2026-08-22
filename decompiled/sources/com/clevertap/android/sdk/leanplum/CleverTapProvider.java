package com.clevertap.android.sdk.leanplum;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CleverTapProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\n\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/sdk/leanplum/CleverTapProvider;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "customInstance", "Lcom/clevertap/android/sdk/CleverTapAPI;", "(Lcom/clevertap/android/sdk/CleverTapAPI;)V", "defaultInstance", "getCleverTap", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CleverTapProvider {
    private CleverTapAPI customInstance;
    private CleverTapAPI defaultInstance;

    public CleverTapProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultInstance = CleverTapAPI.getDefaultInstance(context);
    }

    public CleverTapProvider(CleverTapAPI customInstance) {
        Intrinsics.checkNotNullParameter(customInstance, "customInstance");
        this.customInstance = customInstance;
    }

    public final CleverTapAPI getCleverTap() {
        CleverTapAPI cleverTapAPI = this.customInstance;
        if (cleverTapAPI != null) {
            return cleverTapAPI;
        }
        CleverTapAPI cleverTapAPI2 = this.defaultInstance;
        if (cleverTapAPI2 != null) {
            return cleverTapAPI2;
        }
        Logger.i("CTWrapper", "Please initialize LeanplumCT, because CleverTap instance is missing.");
        return null;
    }
}
