package clientRequestsApi;

import com.appnew.android.Utils.Const;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes4.dex */
public interface RetroAPI {
    @FormUrlEncoded
    @POST("applyDiscountCode")
    Call<String> applyCoupon(@Field(Const.ZOOM_ACCESS_KEY) String str, @Field("txn_id") String str2, @Field("mode_selected") String str3, @Field("bin_number") String str4, @Field("bank_wallet_name") String str5, @Field("discount_code") String str6, @Field("savedcard_id") String str7, @Field("bank_code") String str8, @Field("upiVA") String str9);

    @FormUrlEncoded
    @POST("cancel-pg-transaction")
    Call<String> cancelInstaCollectRequest(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("cancelupi")
    Call<String> cancelUPIRequest(@Field(Const.ZOOM_ACCESS_KEY) String str);

    @FormUrlEncoded
    @POST("check-insta-collect-status")
    Call<String> checkInstaCollectStatus(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("getOlaMoneyEligibility")
    Call<String> checkOlaEligibilty(@Field(Const.ZOOM_ACCESS_KEY) String str);

    @FormUrlEncoded
    @POST("getPayLaterEligibility")
    Call<String> checkSimplEligibilty(@Field(Const.ZOOM_ACCESS_KEY) String str, @Field("pay_later_app") String str2);

    @FormUrlEncoded
    @POST("checkStatus")
    Call<String> checkUPIStatus(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("deleteSavedCard")
    Call<String> deleteSavedCard(@Field(Const.ZOOM_ACCESS_KEY) String str, @Field("saved_card_id") String str2);

    @FormUrlEncoded
    @POST("getEMIOptions")
    Call<String> getEMIOptions(@Field(Const.ZOOM_ACCESS_KEY) String str, @Field("amount") String str2);

    @FormUrlEncoded
    @POST("initiateLink")
    Call<String> initiatePayment(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("v1/fetch_checkout_modes/")
    Call<String> initiatePaymentByAccessKey(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("submitInitiatePayment")
    Call<String> submitInitiatePayment(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("v1/postGpay")
    Call<String> submitPostGPay(@Field("data") String str);

    @FormUrlEncoded
    @POST("retryCancelled")
    Call<String> userCancelRequest(@Field(Const.ZOOM_ACCESS_KEY) String str, @Field("status") int i, @Field("cancellation_reason") String str2);
}
