package com.clevertap.android.sdk.network;

import com.clevertap.android.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: compiled from: BatchListeners.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/network/AppLaunchListener;", "Lcom/clevertap/android/sdk/network/BatchListener;", "<init>", "()V", "listeners", "", "Lkotlin/Function0;", "", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "onBatchSent", "batch", "Lorg/json/JSONArray;", "success", "", "onAppLaunchedFound", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppLaunchListener implements BatchListener {
    private final List<Function0<Unit>> listeners = new ArrayList();

    public final void addListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void removeListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    @Override // com.clevertap.android.sdk.network.BatchListener
    public void onBatchSent(JSONArray batch, boolean success) {
        Intrinsics.checkNotNullParameter(batch, "batch");
        int length = batch.length();
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(batch.getJSONObject(i).optString(Constants.KEY_EVT_NAME), Constants.APP_LAUNCHED_EVENT) && success) {
                onAppLaunchedFound();
                return;
            }
        }
    }

    private final void onAppLaunchedFound() {
        Iterator<T> it = this.listeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }
}
