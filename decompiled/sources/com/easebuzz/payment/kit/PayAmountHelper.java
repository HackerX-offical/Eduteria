package com.easebuzz.payment.kit;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.IdManager;
import datamodels.PWEStaticDataModel;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PayAmountHelper {
    private Context context;
    public PWEPaymentInfoHandler paymentInfoHandler;

    public PayAmountHelper(Context context) {
        this.context = context;
        this.paymentInfoHandler = new PWEPaymentInfoHandler(this.context);
    }

    public String getPaymentAmountStr(String str) {
        if (str.equals("savedcard")) {
            str = "creditcard";
        } else if (str.equals(PWEStaticDataModel.INSTA_COLLECT_CODE)) {
            str = "BT";
        }
        String payAmountStr = this.paymentInfoHandler.getPayAmountStr();
        if (this.paymentInfoHandler.getIsCustomerSurcharge() == 1) {
            try {
                JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getCustomerSurchargeDetails());
                if (jSONObject.has(str)) {
                    return BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("final_amount")).toPlainString();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return payAmountStr;
    }

    public String getInitialPaymentAmountStr() {
        return this.paymentInfoHandler.getPayAmountStr();
    }

    protected void resetAppliedCouponFlag(boolean z, String str, String str2, String str3) {
        this.paymentInfoHandler.setIsDiscountCouponApplied(z);
        this.paymentInfoHandler.setDiscountedCouponDetails(str);
        this.paymentInfoHandler.setAppliedDiscountCouponCode(str2);
        this.paymentInfoHandler.setAppliedDiscountType(str3);
    }

    public String getConvenienceFeeStr(String str) {
        if (str.equals("savedcard")) {
            str = "creditcard";
        } else if (str.equals(PWEStaticDataModel.INSTA_COLLECT_CODE)) {
            str = "BT";
        }
        if (this.paymentInfoHandler.getIsCustomerSurcharge() == 1) {
            try {
                JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getCustomerSurchargeDetails());
                if (jSONObject.has(str)) {
                    return "" + BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("easebuzz_charge"));
                }
                return IdManager.DEFAULT_VERSION_NAME;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return IdManager.DEFAULT_VERSION_NAME;
            }
        }
        return IdManager.DEFAULT_VERSION_NAME;
    }

    public String getDiscountedAmountPayableStr(String str) {
        String payAmountStr = this.paymentInfoHandler.getPayAmountStr();
        try {
            JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getDiscountedCouponDetails());
            if (jSONObject.has(str)) {
                return "" + BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("discounted_amount"));
            }
        } catch (JSONException unused) {
        }
        return payAmountStr;
    }

    public String getDiscountedPaymentAmountStr(String str) {
        String payAmountStr = this.paymentInfoHandler.getPayAmountStr();
        try {
            JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getDiscountedCouponDetails());
            if (jSONObject.has(str)) {
                return "" + BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("final_amount"));
            }
        } catch (JSONException unused) {
        }
        return payAmountStr;
    }

    public String getDiscountAmountStr(String str) {
        try {
            JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getDiscountedCouponDetails());
            if (jSONObject.has(str)) {
                return "" + BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("discount_amount"));
            }
            return IdManager.DEFAULT_VERSION_NAME;
        } catch (JSONException unused) {
            return IdManager.DEFAULT_VERSION_NAME;
        }
    }

    public String getDiscountedConvenienceFeeStr(String str) {
        if (this.paymentInfoHandler.getIsCustomerSurcharge() == 1) {
            try {
                JSONObject jSONObject = new JSONObject(this.paymentInfoHandler.getDiscountedCouponDetails());
                if (jSONObject.has(str)) {
                    return "" + BigDecimal.valueOf(jSONObject.getJSONObject(str).getDouble("easebuzz_charge"));
                }
                return IdManager.DEFAULT_VERSION_NAME;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return IdManager.DEFAULT_VERSION_NAME;
            }
        }
        return IdManager.DEFAULT_VERSION_NAME;
    }
}
