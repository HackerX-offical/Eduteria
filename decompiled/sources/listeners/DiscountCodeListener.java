package listeners;

import datamodels.DiscountCodeDataModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public interface DiscountCodeListener {
    void applySelectedDiscountCode(DiscountCodeDataModel discountCodeDataModel, int i);

    void setBasicPaymentInfo();

    JSONObject validateApplyDiscount(String str);
}
