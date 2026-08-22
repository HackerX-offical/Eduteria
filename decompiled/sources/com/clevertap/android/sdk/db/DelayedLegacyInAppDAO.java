package com.clevertap.android.sdk.db;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: DelayedLegacyInAppDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH'J\b\u0010\u000b\u001a\u00020\u0003H'¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/db/DelayedLegacyInAppDAO;", "", "insertBatch", "", "delayedInApps", "", "Lcom/clevertap/android/sdk/db/DelayedLegacyInAppData;", "remove", Column.INAPP_ID, "", "fetchSingleInApp", "clearAll", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DelayedLegacyInAppDAO {
    boolean clearAll();

    String fetchSingleInApp(String inAppId);

    boolean insertBatch(List<DelayedLegacyInAppData> delayedInApps);

    boolean remove(String inAppId);
}
