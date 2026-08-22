package com.paytm.pgsdk;

import com.google.gson.Gson;
import com.paytm.pgsdk.model.ProcessTransactionInfo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PaytmPaymentRepository {
    private static PaytmPaymentRepository INSTANCE;

    public static synchronized PaytmPaymentRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PaytmPaymentRepository();
        }
        return INSTANCE;
    }

    public static void onDestroy() {
        INSTANCE = null;
    }

    public void makeCloseOrderApi(final ApiCallback<ProcessTransactionInfo> apiCallback) {
        String str;
        String str2;
        String str3;
        PaytmOrder paytmOrder = PaytmPGService.getService().mOrder;
        if (paytmOrder == null || paytmOrder.getRequestParamMap() == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str = paytmOrder.getRequestParamMap().get("MID");
            str3 = paytmOrder.getRequestParamMap().get("ORDER_ID");
            str2 = paytmOrder.getRequestParamMap().get(Constants.TXN_TOKEN);
        }
        if (str == null || str3 == null) {
            apiCallback.onError();
            return;
        }
        String str4 = PaytmPGService.closeOrderUrl() + "?orderId=" + str3 + "&mid=" + str;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("mid", str);
            jSONObject3.put("orderId", str3);
            jSONObject2.put(Constants.KEY_API_TXN_TYPE, Constants.TXN_TOKEN);
            if (str2 != null) {
                jSONObject2.put("token", str2);
            }
            jSONObject2.put("version", "v2");
            jSONObject2.put(Constants.KEY_API_REQ_TIME_STAMP, System.currentTimeMillis());
            jSONObject.put("head", jSONObject2);
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        new OkHttpClient().newBuilder().connectTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build().newCall(new Request.Builder().url(str4).header("content-type", "application/json").header("Accept", "application/json").post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString().getBytes())).build()).enqueue(new Callback() { // from class: com.paytm.pgsdk.PaytmPaymentRepository.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                apiCallback.onError();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    try {
                        apiCallback.onSuccess((ProcessTransactionInfo) new Gson().fromJson(responseBodyBody.string(), ProcessTransactionInfo.class));
                        responseBodyBody.close();
                    } catch (Exception e3) {
                        PaytmUtility.printStackTrace(e3);
                        apiCallback.onError();
                    }
                }
            }
        });
    }
}
