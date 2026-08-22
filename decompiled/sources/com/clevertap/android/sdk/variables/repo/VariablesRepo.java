package com.clevertap.android.sdk.variables.repo;

import android.content.Context;
import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.db.DBEncryptionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariablesRepo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/variables/repo/VariablesRepo;", "", "context", "Landroid/content/Context;", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "", "dbEncryptionHandler", "Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/clevertap/android/sdk/db/DBEncryptionHandler;)V", "getContext", "()Landroid/content/Context;", "getAccountId", "()Ljava/lang/String;", "getDbEncryptionHandler", "()Lcom/clevertap/android/sdk/db/DBEncryptionHandler;", "storeDataInCache", "", "data", "loadDataFromCache", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VariablesRepo {
    private final String accountId;
    private final Context context;
    private final DBEncryptionHandler dbEncryptionHandler;

    public VariablesRepo(Context context, String accountId, DBEncryptionHandler dbEncryptionHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(dbEncryptionHandler, "dbEncryptionHandler");
        this.context = context;
        this.accountId = accountId;
        this.dbEncryptionHandler = dbEncryptionHandler;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final DBEncryptionHandler getDbEncryptionHandler() {
        return this.dbEncryptionHandler;
    }

    public final void storeDataInCache(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger.d("storeDataInCache() called with: data = [" + data + ']');
        try {
            StorageHelper.putString(this.context, this.accountId, Constants.CACHED_VARIABLES_KEY, this.dbEncryptionHandler.wrapDbData(data));
        } catch (Throwable th) {
            Logger.d("storeDataInCache failed", th);
        }
    }

    public final String loadDataFromCache() {
        String strUnwrapDbData = this.dbEncryptionHandler.unwrapDbData(StorageHelper.getStringFromPrefs(this.context, this.accountId, Constants.CACHED_VARIABLES_KEY, "{}"));
        Logger.d("VarCache loaded cache data:\n" + strUnwrapDbData);
        return strUnwrapDbData;
    }
}
