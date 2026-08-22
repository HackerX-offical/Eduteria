package com.razorpay;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: RzpGPayInABoxExternalPlugin.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/razorpay/RzpGPayInABoxExternalPlugin;", "", "getPaymentMethods", "", "context", "Landroid/content/Context;", "amount", "", "initializePaymentMethods", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RzpGPayInABoxExternalPlugin {
    String getPaymentMethods(Context context, double amount);

    void initializePaymentMethods(Context context);
}
