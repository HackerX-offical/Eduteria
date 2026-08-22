package com.clevertap.android.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.StorageHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IJRepo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/network/IJRepo;", "", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "<init>", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;)V", "setI", "", "context", "Landroid/content/Context;", CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "", "setJ", "j", "getI", "getJ", "clearIJ", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IJRepo {
    private final CleverTapInstanceConfig config;

    public IJRepo(CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final void setI(Context context, long i) {
        Intrinsics.checkNotNullParameter(context, "context");
        StorageHelper.INSTANCE.putLong(context, "IJ", "comms_i:" + this.config.getAccountId(), i);
    }

    public final void setJ(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        StorageHelper.INSTANCE.putLong(context, "IJ", "comms_j:" + this.config.getAccountId(), j);
    }

    public final long getI(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StorageHelper storageHelper = StorageHelper.INSTANCE;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return storageHelper.getLongFromPrefs(context, accountId, "comms_i", 0L, "IJ");
    }

    public final long getJ(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StorageHelper storageHelper = StorageHelper.INSTANCE;
        String accountId = this.config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        return storageHelper.getLongFromPrefs(context, accountId, "comms_j", 0L, "IJ");
    }

    public final void clearIJ(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences.Editor editorEdit = StorageHelper.getPreferences(context, "IJ").edit();
        editorEdit.clear();
        editorEdit.apply();
    }
}
