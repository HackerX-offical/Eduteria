package com.appnew.android.base;

import com.appnew.android.Model.subscription.SubscriptionMetaItem;
import kotlin.Metadata;

/* JADX INFO: compiled from: Dialogs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/appnew/android/base/SubscriptionCallback;", "", "okClick", "", "which", "", "checkedItemData", "Lcom/appnew/android/Model/subscription/SubscriptionMetaItem;", "cancelClick", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface SubscriptionCallback {
    void cancelClick(int which, SubscriptionMetaItem checkedItemData);

    void okClick(int which, SubscriptionMetaItem checkedItemData);
}
