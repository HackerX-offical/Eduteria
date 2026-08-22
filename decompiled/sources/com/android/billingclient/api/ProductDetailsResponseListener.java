package com.android.billingclient.api;

import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
public interface ProductDetailsResponseListener {
    void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list);
}
