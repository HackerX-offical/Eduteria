package com.appnew.android.Utils.Network;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteFullException;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.PigibagTable;
import com.appnew.android.table.UserWiseCourseTable;
import com.eduteria.app.app.R;
import com.facebook.appevents.UserDataStore;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkCall {
    Context context;
    String id;
    MyNetworkCallBack myCBI;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public interface MyNetworkCallBack {
        void ErrorCallBack(String jsonstring, String apitype, String typeApi);

        void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException;

        Call<String> getAPIB(String apitype, String typeApi, APIInterface service);
    }

    public NetworkCall(MyNetworkCallBack callBackInterface, Context context) {
        this.myCBI = callBackInterface;
        this.context = context;
    }

    public void NetworkAPICall(final String apiType, final String typeApi, final boolean showprogress, boolean ismultipleapi) {
        Call<String> apib;
        APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
        if (Helper.isConnected(this.context)) {
            if (showprogress) {
                Helper.showProgressDialog(this.context);
            }
            if (apiType.equals("changedetecter")) {
                EncryptionData encryptionData = new EncryptionData();
                encryptionData.setUser_id("1");
                apib = aPIInterface.getchangedetector(AES.encrypt(new Gson().toJson(encryptionData)));
            } else {
                apib = this.myCBI.getAPIB(apiType, typeApi, aPIInterface);
            }
            apib.enqueue(new AnonymousClass1(ismultipleapi, apiType, typeApi, showprogress));
        }
    }

    /* JADX INFO: renamed from: com.appnew.android.Utils.Network.NetworkCall$1, reason: invalid class name */
    class AnonymousClass1 implements Callback<String> {
        final /* synthetic */ String val$apiType;
        final /* synthetic */ boolean val$ismultipleapi;
        final /* synthetic */ boolean val$showprogress;
        final /* synthetic */ String val$typeApi;

        AnonymousClass1(final boolean val$ismultipleapi, final String val$apiType, final String val$typeApi, final boolean val$showprogress) {
            this.val$ismultipleapi = val$ismultipleapi;
            this.val$apiType = val$apiType;
            this.val$typeApi = val$typeApi;
            this.val$showprogress = val$showprogress;
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<String> call, Response<String> response) {
            String str;
            String str2;
            String strBody;
            String str3;
            String str4;
            String str5;
            String str6;
            if (!this.val$ismultipleapi) {
                Helper.dismissProgressDialog();
            }
            if (response.body() != null && response.isSuccessful()) {
                try {
                    String strBody2 = response.body();
                    str2 = Const.MARKSHEET_SHOW;
                    try {
                        str = "address";
                        try {
                            strBody = AES.decrypt(strBody2, AES.generatekeyAPI(), AES.generateVectorAPI());
                        } catch (Exception unused) {
                            strBody = response.body();
                        }
                    } catch (Exception unused2) {
                        str = "address";
                    }
                } catch (Exception unused3) {
                    str = "address";
                    str2 = Const.MARKSHEET_SHOW;
                }
                try {
                    if (this.val$apiType.equalsIgnoreCase("changedetecter")) {
                        if (strBody != null && !strBody.isEmpty()) {
                            str3 = "father_name";
                            JSONObject jSONObject = new JSONObject(strBody);
                            str4 = "caste_category";
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject.optString("time")) * 1000);
                            if (!MakeMyExam.userId.equalsIgnoreCase("0")) {
                                NetworkCall.this.checkandupdateversion(jSONObject);
                            }
                            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                            if (jSONObject2.has("version_control")) {
                                str5 = "gender";
                                String strOptString = jSONObject2.getJSONObject("version_control").optString("version");
                                String strOptString2 = jSONObject2.getJSONObject("version_control").optString("min_version");
                                String strOptString3 = jSONObject2.getJSONObject("version_control").optString("force_update");
                                str6 = "1";
                                String strOptString4 = jSONObject2.getJSONObject("version_control").optString("break_from");
                                String strOptString5 = jSONObject2.getJSONObject("version_control").optString("break_to");
                                int i = Integer.parseInt(strOptString);
                                int i2 = Integer.parseInt(strOptString2);
                                if (Long.parseLong(strOptString4) < System.currentTimeMillis() && Long.parseLong(strOptString5) > System.currentTimeMillis()) {
                                    Helper.getMaintanaceDialog((Activity) NetworkCall.this.context, strOptString4, strOptString5);
                                } else if (strOptString3.equalsIgnoreCase("0")) {
                                    if (Helper.isvisible.equalsIgnoreCase("0") && (i > Helper.getVersionCode((Activity) NetworkCall.this.context) || Helper.getVersionCode((Activity) NetworkCall.this.context) < i2)) {
                                        Activity activity = (Activity) NetworkCall.this.context;
                                        if (Helper.getVersionCode((Activity) NetworkCall.this.context) < i2) {
                                            strOptString3 = str6;
                                        }
                                        Helper.getVersionUpdateDialog(activity, strOptString3);
                                    }
                                } else {
                                    Helper.isvisible = "0";
                                    if (i > Helper.getVersionCode((Activity) NetworkCall.this.context) || Helper.getVersionCode((Activity) NetworkCall.this.context) < i2) {
                                        Activity activity2 = (Activity) NetworkCall.this.context;
                                        if (Helper.getVersionCode((Activity) NetworkCall.this.context) < i2) {
                                            strOptString3 = str6;
                                        }
                                        Helper.getVersionUpdateDialog(activity2, strOptString3);
                                    }
                                }
                            }
                        } else {
                            str3 = "father_name";
                            str4 = "caste_category";
                            str5 = "gender";
                            str6 = "1";
                            Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                            NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), this.val$apiType, this.val$typeApi);
                        }
                        if (strBody == null && !strBody.isEmpty()) {
                            final JSONObject jSONObject3 = new JSONObject(strBody);
                            MakeMyExam.setTime_server(Long.parseLong(jSONObject3.optString("time")) * 1000);
                            if (MakeMyExam.userId == null || !MakeMyExam.userId.equalsIgnoreCase("0")) {
                                if (jSONObject3.has("auth_code")) {
                                    RetrofitResponse.GetApiData(NetworkCall.this.context, jSONObject3.getString("auth_code"), jSONObject3.getString("message"), false);
                                } else {
                                    AsyncTask.execute(new Runnable() { // from class: com.appnew.android.Utils.Network.NetworkCall$1$$ExternalSyntheticLambda0
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.f$0.lambda$onResponse$0(jSONObject3);
                                        }
                                    });
                                }
                            }
                            try {
                                if (jSONObject3.getString("status").equalsIgnoreCase("false") && !GenericUtils.isEmpty(jSONObject3.getString("auth_code"))) {
                                    RetrofitResponse.GetApiData(NetworkCall.this.context, jSONObject3.has("auth_code") ? jSONObject3.getString("auth_code") : "", jSONObject3.getString("message"), false);
                                }
                            } catch (Exception unused4) {
                            }
                            Helper.logPrinter("NetworkCall", "d", jSONObject3.toString(), "");
                            NetworkCall.this.myCBI.SuccessCallBack(jSONObject3, this.val$apiType, this.val$typeApi, this.val$showprogress);
                            try {
                                if (this.val$apiType.equalsIgnoreCase(API.API_GET_APP_VERSION) && jSONObject3.optString("status").equals("true")) {
                                    JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                                    if (jSONObject4.has(Const.SPLASH_DATA)) {
                                        SharedPreference.getInstance().putString(Const.SPLASH_DATA, String.valueOf(jSONObject4.optJSONObject(Const.SPLASH_DATA)));
                                        if (jSONObject4.optJSONObject(Const.SPLASH_DATA).has("type")) {
                                            jSONObject4.optJSONObject(Const.SPLASH_DATA).get("type").equals("video");
                                        }
                                        if (jSONObject4.optJSONObject(Const.SPLASH_DATA).has(Const.SPLASH_URL)) {
                                            SharedPreference.getInstance().putString(Const.SPLASH_URL, jSONObject4.optJSONObject(Const.SPLASH_DATA).get(Const.SPLASH_URL).toString());
                                        }
                                        if (jSONObject4.optJSONObject(Const.SPLASH_DATA).has(Const.SPLASH_TIMING)) {
                                            SharedPreference.getInstance().putString(Const.SPLASH_TIMING, jSONObject4.optJSONObject(Const.SPLASH_DATA).get(Const.SPLASH_TIMING).toString());
                                        }
                                    }
                                    if (jSONObject4.has(Const.DIVISION)) {
                                        SharedPreference.getInstance().putString(Const.DIVISION, jSONObject4.getJSONArray(Const.DIVISION).toString());
                                    }
                                    if (jSONObject4.has("in_release")) {
                                        SharedPreference.getInstance().putString("in_release", jSONObject4.optString("in_release"));
                                    }
                                    if (jSONObject4.has("in_release_user")) {
                                        SharedPreference.getInstance().putString("in_release_user", jSONObject4.optString("in_release_user"));
                                    }
                                    if (jSONObject4.has("permissions")) {
                                        SharedPreference.getInstance().putString(Const.FloatingMobileNumber, jSONObject4.optJSONObject("permissions").optString(Const.FloatingMobileNumber));
                                        SharedPreference.getInstance().putString(Const.EnableScreenshot, jSONObject4.optJSONObject("permissions").optString(Const.EnableScreenshot));
                                        SharedPreference.getInstance().putString(Const.SHOW_GREETING, jSONObject4.optJSONObject("permissions").optString("greeting"));
                                        SharedPreference.getInstance().putString(Const.EMAIL_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.EMAIL_SHOW));
                                        SharedPreference.getInstance().putString(Const.IS_GOOGLE_LOGIN_ENABLE, jSONObject4.optJSONObject("permissions").optString("google_login"));
                                        SharedPreference.getInstance().putString(Const.DOB_SHOW, jSONObject4.optJSONObject("permissions").optString("date_of_birth"));
                                        SharedPreference.getInstance().putString(Const.EXPERT_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.IS_EXPERT));
                                        SharedPreference.getInstance().putString(Const.HIDE_CITY_STATE, jSONObject4.optJSONObject("permissions").optString("is_state_validate"));
                                        SharedPreference.getInstance().putString(Const.IS_GSTIN, jSONObject4.optJSONObject("permissions").optString(Const.IS_GSTIN));
                                        SharedPreference.getInstance().putString(Const.DRM_ACCESS_KEY, jSONObject4.optJSONObject("permissions").optString(Const.DRM_ACCESS_KEY));
                                        SharedPreference.getInstance().putString(Const.DRM_SECRET_KEY, jSONObject4.optJSONObject("permissions").optString(Const.DRM_SECRET_KEY));
                                        SharedPreference.getInstance().putString(Const.VIDEOCRYPT_ACCOUNT_ID, jSONObject4.optJSONObject("permissions").optString(Const.VIDEOCRYPT_ACCOUNT_ID));
                                        if (jSONObject4.optJSONObject("permissions").has(UserDataStore.COUNTRY)) {
                                            SharedPreference.getInstance().putString(Const.COUNTRY_SHOW, jSONObject4.optJSONObject("permissions").optString(UserDataStore.COUNTRY));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.EMAIL_FORM_SHOW)) {
                                            SharedPreference.getInstance().putString(Const.EMAIL_FORM_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.EMAIL_FORM_SHOW));
                                        } else {
                                            SharedPreference.getInstance().putString(Const.EMAIL_FORM_SHOW, str6);
                                        }
                                        String str7 = str5;
                                        if (jSONObject4.optJSONObject("permissions").has(str7)) {
                                            jSONObject4.optJSONObject("permissions").optString(str7);
                                            SharedPreference.getInstance().putString(Const.GENDER_SHOW, jSONObject4.optJSONObject("permissions").optString(str7));
                                        }
                                        String str8 = str4;
                                        if (jSONObject4.optJSONObject("permissions").has(str8)) {
                                            jSONObject4.optJSONObject("permissions").optString(str8);
                                            SharedPreference.getInstance().putString(Const.CASTE_SHOW, jSONObject4.optJSONObject("permissions").optString(str8));
                                        }
                                        String str9 = str3;
                                        if (jSONObject4.optJSONObject("permissions").has(str9)) {
                                            jSONObject4.optJSONObject("permissions").optString(str9);
                                            SharedPreference.getInstance().putString(Const.FATHER_SHOW, jSONObject4.optJSONObject("permissions").optString(str9));
                                        }
                                        String str10 = str;
                                        if (jSONObject4.optJSONObject("permissions").has(str10)) {
                                            jSONObject4.optJSONObject("permissions").optString(str10);
                                            SharedPreference.getInstance().putString(Const.ADDRESS_SHOW, jSONObject4.optJSONObject("permissions").optString(str10));
                                        }
                                        String str11 = str2;
                                        if (jSONObject4.optJSONObject("permissions").has(str11)) {
                                            jSONObject4.optJSONObject("permissions").optString(str11);
                                            SharedPreference.getInstance().putString(str11, jSONObject4.optJSONObject("permissions").optString(str11));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.PROFILE_PICTURE)) {
                                            jSONObject4.optJSONObject("permissions").optString(Const.PROFILE_PICTURE);
                                            SharedPreference.getInstance().putString(Const.PHOTO_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.PROFILE_PICTURE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("alt_mobile")) {
                                            jSONObject4.optJSONObject("permissions").optString("alt_mobile");
                                            SharedPreference.getInstance().putString(Const.ALTERNATE_SHOW, jSONObject4.optJSONObject("permissions").optString("alt_mobile"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("pin_code")) {
                                            SharedPreference.getInstance().putString(Const.PIN_CODE_SHOW, jSONObject4.optJSONObject("permissions").optString("pin_code"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.LANGUAGE)) {
                                            SharedPreference.getInstance().putString(Const.LANG_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.LANGUAGE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.ATTENDANCE_REPORT)) {
                                            SharedPreference.getInstance().putString(Const.ATTENDANCE_REPORT, jSONObject4.optJSONObject("permissions").optString(Const.ATTENDANCE_REPORT));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.CONTACTUS_MOBILE1)) {
                                            SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE1, jSONObject4.optJSONObject("permissions").optString(Const.CONTACTUS_MOBILE1));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("contactus_mobile2")) {
                                            SharedPreference.getInstance().putString(Const.CONTACTUS_MOBILE2, jSONObject4.optJSONObject("permissions").optString("contactus_mobile2"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.CHANGE_CONTACT)) {
                                            SharedPreference.getInstance().putString(Const.CHANGE_CONTACT, jSONObject4.optJSONObject("permissions").optString(Const.CHANGE_CONTACT));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.GOVERNMENET_ID)) {
                                            SharedPreference.getInstance().putString(Const.GOVERNMENET_ID, jSONObject4.optJSONObject("permissions").optString(Const.GOVERNMENET_ID));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.EMAIL_UPDATE_POPUP)) {
                                            SharedPreference.getInstance().putString(Const.EMAIL_UPDATE_POPUP, jSONObject4.optJSONObject("permissions").optString(Const.EMAIL_UPDATE_POPUP));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.CUSTOM_YOUTUBE_PLAYER)) {
                                            SharedPreference.getInstance().putString(Const.CUSTOM_YOUTUBE_PLAYER, jSONObject4.optJSONObject("permissions").optString(Const.CUSTOM_YOUTUBE_PLAYER));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.WHATSAPP_CHANNEL_DATA)) {
                                            SharedPreference.getInstance().putString(Const.WHATSAPP_CHANNEL_DATA, jSONObject4.optJSONObject("permissions").optString(Const.WHATSAPP_CHANNEL_DATA));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HIDE_SIGNUP)) {
                                            SharedPreference.getInstance().putString(Const.HIDE_SIGNUP, jSONObject4.optJSONObject("permissions").optString(Const.HIDE_SIGNUP));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.TEACHER_TIME_TABLE)) {
                                            SharedPreference.getInstance().putString(Const.TEACHER_TIME_TABLE, jSONObject4.optJSONObject("permissions").optString(Const.TEACHER_TIME_TABLE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("doubt_firebase_chat")) {
                                            SharedPreference.getInstance().putString(Const.DOUBT_FIREBASE_CHAT, jSONObject4.optJSONObject("permissions").optString("doubt_firebase_chat"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("cumulative_test_report")) {
                                            SharedPreference.getInstance().putString(Const.cumulative_test_report, jSONObject4.optJSONObject("permissions").optString("cumulative_test_report"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("notice_board")) {
                                            SharedPreference.getInstance().putString(Const.notice_board, jSONObject4.optJSONObject("permissions").optString("notice_board"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("hide_FIB")) {
                                            SharedPreference.getInstance().putString(Const.HIDE_FIB, jSONObject4.optJSONObject("permissions").optString("hide_FIB"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("horizontal_course")) {
                                            SharedPreference.getInstance().putString(Const.HORIZONTAL_COURSE, jSONObject4.optJSONObject("permissions").optString("horizontal_course"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has("PdfView_On_VideoList")) {
                                            SharedPreference.getInstance().putString(Const.PDFVIEW_ON_VIDEOLIST, jSONObject4.optJSONObject("permissions").optString("PdfView_On_VideoList"));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.CUSTOM_TESTSERIES_UI)) {
                                            SharedPreference.getInstance().putString(Const.CUSTOM_TESTSERIES_UI, jSONObject4.optJSONObject("permissions").optString(Const.CUSTOM_TESTSERIES_UI));
                                        }
                                        SharedPreference.getInstance().putString(Const.SHOW_CERTIFICATE, jSONObject4.optJSONObject("permissions").optString(Const.SHOW_CERTIFICATE));
                                        SharedPreference.getInstance().putString(Const.IS_AUTO_PLAY, jSONObject4.optJSONObject("permissions").optString("video_autoplay"));
                                        SharedPreference.getInstance().putString(Const.IS_RECENT_WATCH, jSONObject4.optJSONObject("permissions").optString("recent_watch"));
                                        SharedPreference.getInstance().putString(Const.AUDIO_LISTEN, jSONObject4.optJSONObject("permissions").optString(Const.AUDIO_LISTEN));
                                        SharedPreference.getInstance().putString(Const.MY_DOWNLOAD_TABS, jSONObject4.optJSONObject("permissions").optString("my_downloads_tab"));
                                        SharedPreference.getInstance().putString(Const.IN_APP_DOWNLOADS, jSONObject4.optJSONObject("permissions").optString(Const.IN_APP_DOWNLOADS));
                                        SharedPreference.getInstance().putString(Const.YOUTUBE_DOWNLOAD, jSONObject4.optJSONObject("permissions").optString(Const.YOUTUBE_DOWNLOAD));
                                        SharedPreference.getInstance().putString(Const.IS_HOME_GRID, jSONObject4.optJSONObject("permissions").optString(Const.IS_HOME_GRID));
                                        SharedPreference.getInstance().putString(Const.OTP_LOGIN, jSONObject4.optJSONObject("permissions").optString(Const.OTP_LOGIN));
                                        if (jSONObject4.optJSONObject("permissions").optString(Const.Youtube_Player_Control) != null) {
                                            SharedPreference.getInstance().putString(Const.Youtube_Player_Control, jSONObject4.optJSONObject("permissions").optString(Const.Youtube_Player_Control));
                                        }
                                        SharedPreference.getInstance().putString(Const.IS_LIVE_CLASS_PDF_SHOW, jSONObject4.optJSONObject("permissions").optString(Const.IS_LIVE_CLASS_PDF_SHOW));
                                        SharedPreference.getInstance().putString(Const.SAME_CONTENT_VIEW, jSONObject4.optJSONObject("permissions").optString(Const.SAME_CONTENT_VIEW));
                                        SharedPreference.getInstance().putString(Const.PREFERENCE_SELECTION_TYPE, jSONObject4.optJSONObject("permissions").optString(Const.PREFERENCE_SELECTION_TYPE));
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HIDE_FEED_CATEGORY)) {
                                            SharedPreference.getInstance().putString(Const.HIDE_FEED_CATEGORY, jSONObject4.optJSONObject("permissions").optString(Const.HIDE_FEED_CATEGORY));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DASHBOARD_LIVE_CLASS)) {
                                            SharedPreference.getInstance().putString(Const.DASHBOARD_LIVE_CLASS, jSONObject4.optJSONObject("permissions").optString(Const.DASHBOARD_LIVE_CLASS));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.dashboard_TrendingCourses)) {
                                            SharedPreference.getInstance().putString(Const.dashboard_TrendingCourses, jSONObject4.optJSONObject("permissions").optString(Const.dashboard_TrendingCourses));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DASHBOARD_EDUCATORSECTION)) {
                                            SharedPreference.getInstance().putString(Const.DASHBOARD_EDUCATORSECTION, jSONObject4.optJSONObject("permissions").optString(Const.DASHBOARD_EDUCATORSECTION));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DASHBOARD_TESTIMONIAL)) {
                                            SharedPreference.getInstance().putString(Const.DASHBOARD_TESTIMONIAL, jSONObject4.optJSONObject("permissions").optString(Const.DASHBOARD_TESTIMONIAL));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DASHBOARD_WHATSAPP_BANNER)) {
                                            SharedPreference.getInstance().putString(Const.DASHBOARD_WHATSAPP_BANNER, jSONObject4.optJSONObject("permissions").optString(Const.DASHBOARD_WHATSAPP_BANNER));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DASHBOARD_SOCIALMEDIA_ICONS)) {
                                            SharedPreference.getInstance().putString(Const.DASHBOARD_SOCIALMEDIA_ICONS, jSONObject4.optJSONObject("permissions").optString(Const.DASHBOARD_SOCIALMEDIA_ICONS));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.CUSTOM_TESTSERIES_UI)) {
                                            SharedPreference.getInstance().putString(Const.CUSTOM_TESTSERIES_UI, jSONObject4.optJSONObject("permissions").optString(Const.CUSTOM_TESTSERIES_UI));
                                        }
                                        SharedPreference.getInstance().putString(Const.ENROLL_NOW, jSONObject4.optJSONObject("permissions").optString(Const.ENROLL_NOW));
                                        SharedPreference.getInstance().putString(Const.SHOW_STUDENT_CLASS, jSONObject4.optJSONObject("permissions").optString(Const.SHOW_STUDENT_CLASS));
                                        SharedPreference.getInstance().putString(Const.SHOW_ROLL_NUMBER, jSONObject4.optJSONObject("permissions").optString(Const.SHOW_ROLL_NUMBER));
                                        SharedPreference.getInstance().putString(Const.SHOW_SCHOLARSHIP_APPLIED, jSONObject4.optJSONObject("permissions").optString(Const.SHOW_SCHOLARSHIP_APPLIED));
                                        if (jSONObject4.optJSONObject("permissions").has(Const.enableQRCode)) {
                                            SharedPreference.getInstance().putString(Const.enableQRCode, jSONObject4.optJSONObject("permissions").optString(Const.enableQRCode));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.directPayment)) {
                                            SharedPreference.getInstance().putString(Const.directPayment, jSONObject4.optJSONObject("permissions").optString(Const.directPayment));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isChatSettingEnabled)) {
                                            SharedPreference.getInstance().putString(Const.isChatSettingEnabled, jSONObject4.optJSONObject("permissions").optString(Const.isChatSettingEnabled));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isGenerateLeaderboardEnabled)) {
                                            SharedPreference.getInstance().putString(Const.isGenerateLeaderboardEnabled, jSONObject4.optJSONObject("permissions").optString(Const.isGenerateLeaderboardEnabled));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DRM_LICENSE_URL)) {
                                            SharedPreference.getInstance().putString(Const.DRM_LICENSE_URL, jSONObject4.optJSONObject("permissions").optString(Const.DRM_LICENSE_URL));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isNewLoginFLow)) {
                                            SharedPreference.getInstance().putString(Const.isNewLoginFLow, jSONObject4.optJSONObject("permissions").optString(Const.isNewLoginFLow));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isAddressNeeded)) {
                                            SharedPreference.getInstance().putString(Const.isAddressNeeded, jSONObject4.optJSONObject("permissions").optString(Const.isAddressNeeded));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isLandscapePoll)) {
                                            SharedPreference.getInstance().putString(Const.isLandscapePoll, jSONObject4.optJSONObject("permissions").optString(Const.isLandscapePoll));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.isDefaultEmail)) {
                                            SharedPreference.getInstance().putString(Const.isDefaultEmail, jSONObject4.optJSONObject("permissions").optString(Const.isDefaultEmail));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.restrictSystemFont)) {
                                            SharedPreference.getInstance().putString(Const.restrictSystemFont, jSONObject4.optJSONObject("permissions").optString(Const.restrictSystemFont));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.EnableCleverTap)) {
                                            SharedPreference.getInstance().putString(Const.EnableCleverTap, jSONObject4.optJSONObject("permissions").optString(Const.EnableCleverTap));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DEVELOPER_OPTIONS)) {
                                            SharedPreference.getInstance().putString(Const.DEVELOPER_OPTIONS, jSONObject4.optJSONObject("permissions").optString(Const.DEVELOPER_OPTIONS));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.LOGIN_MESSAGE)) {
                                            SharedPreference.getInstance().putString(Const.LOGIN_MESSAGE, jSONObject4.optJSONObject("permissions").optString(Const.LOGIN_MESSAGE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.MAX_SPEED)) {
                                            SharedPreference.getInstance().putString(Const.MAX_SPEED, jSONObject4.optJSONObject("permissions").optString(Const.MAX_SPEED));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.GRID_TILE)) {
                                            SharedPreference.getInstance().putString(Const.GRID_TILE, jSONObject4.optJSONObject("permissions").optString(Const.GRID_TILE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.WEBVIEW_PDF)) {
                                            SharedPreference.getInstance().putString(Const.WEBVIEW_PDF, jSONObject4.optJSONObject("permissions").optString(Const.WEBVIEW_PDF));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.TILE_CONTENT_MANAGE)) {
                                            SharedPreference.getInstance().putString(Const.TILE_CONTENT_MANAGE, jSONObject4.optJSONObject("permissions").optString(Const.TILE_CONTENT_MANAGE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.IS_DAILY_QUESTION)) {
                                            SharedPreference.getInstance().putString(Const.IS_DAILY_QUESTION, jSONObject4.optJSONObject("permissions").optString(Const.IS_DAILY_QUESTION));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.PROFILE_TEACHER)) {
                                            SharedPreference.getInstance().putString(Const.PROFILE_TEACHER, jSONObject4.optJSONObject("permissions").optString(Const.PROFILE_TEACHER));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.AUTO_FILL_OTP)) {
                                            SharedPreference.getInstance().putString(Const.AUTO_FILL_OTP, jSONObject4.optJSONObject("permissions").optString(Const.AUTO_FILL_OTP));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HARVEST_CLASS_TIME_HIDE)) {
                                            SharedPreference.getInstance().putString(Const.HARVEST_CLASS_TIME_HIDE, jSONObject4.optJSONObject("permissions").optString(Const.HARVEST_CLASS_TIME_HIDE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.BITRATE_SELECTION)) {
                                            SharedPreference.getInstance().putString(Const.BITRATE_SELECTION, jSONObject4.optJSONObject("permissions").optString(Const.BITRATE_SELECTION));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.DOWNLOAD_VISIBLE_WITH_INTERNET)) {
                                            SharedPreference.getInstance().putString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET, jSONObject4.optJSONObject("permissions").optString(Const.DOWNLOAD_VISIBLE_WITH_INTERNET));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.MARK_AS_DONE)) {
                                            SharedPreference.getInstance().putString(Const.MARK_AS_DONE, jSONObject4.optJSONObject("permissions").optString(Const.MARK_AS_DONE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.SHARE_LINK_WITH_FIREBASE)) {
                                            SharedPreference.getInstance().putString(Const.SHARE_LINK_WITH_FIREBASE, jSONObject4.optJSONObject("permissions").optString(Const.SHARE_LINK_WITH_FIREBASE));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HIDE_EXPLORE_BTN)) {
                                            SharedPreference.getInstance().putString(Const.HIDE_EXPLORE_BTN, jSONObject4.optJSONObject("permissions").optString(Const.HIDE_EXPLORE_BTN));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.YOUTUBE_AUDIO_TRACK)) {
                                            SharedPreference.getInstance().putString(Const.YOUTUBE_AUDIO_TRACK, jSONObject4.optJSONObject("permissions").optString(Const.YOUTUBE_AUDIO_TRACK));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HIDE_PROFILE_POPUP)) {
                                            SharedPreference.getInstance().putString(Const.HIDE_PROFILE_POPUP, jSONObject4.optJSONObject("permissions").optString(Const.HIDE_PROFILE_POPUP));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.HIDE_COPARE_TOPPER)) {
                                            SharedPreference.getInstance().putString(Const.HIDE_COPARE_TOPPER, jSONObject4.optJSONObject("permissions").optString(Const.HIDE_COPARE_TOPPER));
                                        }
                                        if (jSONObject4.optJSONObject("permissions").has(Const.TEST_SUBMIT_S3)) {
                                            SharedPreference.getInstance().putString(Const.TEST_SUBMIT_S3, jSONObject4.optJSONObject("permissions").optString(Const.TEST_SUBMIT_S3));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception unused5) {
                                return;
                            }
                        }
                        Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                        NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), this.val$apiType, this.val$typeApi);
                        return;
                    }
                    str3 = "father_name";
                    str4 = "caste_category";
                    str5 = "gender";
                    str6 = "1";
                    if (strBody == null) {
                    }
                    Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                    NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), this.val$apiType, this.val$typeApi);
                    return;
                } catch (JSONException unused6) {
                    if (SharedPreference.getInstance().getLoggedInUser() == null || SharedPreference.getInstance().getLoggedInUser().getId() == null) {
                        return;
                    }
                    Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                    NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.exception_api_error_message), this.val$apiType, this.val$typeApi);
                    return;
                }
            }
            Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.exception_api_error_message), 0).show();
            NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.exception_api_error_message), this.val$apiType, this.val$typeApi);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onResponse$0(JSONObject jSONObject) {
            try {
                if (!NetworkCall.this.utkashRoom.isOpen()) {
                    NetworkCall.this.utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());
                    NetworkCall.this.utkashRoom.getOpenHelper().getWritableDatabase();
                    NetworkCall.this.utkashRoom.getOpenHelper().getReadableDatabase();
                    NetworkCall.this.utkashRoom.getOpenHelper().setWriteAheadLoggingEnabled(true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (NetworkCall.this.utkashRoom.getpigibag().isRecordExistsUserId(MakeMyExam.userId)) {
                    if (Long.parseLong(NetworkCall.this.utkashRoom.getpigibag().getpigidetail(MakeMyExam.userId).getCdtimestamp()) < jSONObject.optLong("cd_time")) {
                        NetworkCall.this.NetworkAPICall("changedetecter", "", false, false);
                    }
                    NetworkCall.this.utkashRoom.getpigibag().updaterecord(MakeMyExam.userId, String.valueOf(jSONObject.optLong("cd_time")));
                } else {
                    PigibagTable pigibagTable = new PigibagTable();
                    pigibagTable.setUser_id(MakeMyExam.getUserId());
                    pigibagTable.setCdtimestamp(String.valueOf(jSONObject.optLong("cd_time")));
                    NetworkCall.this.NetworkAPICall("changedetecter", "", false, false);
                    NetworkCall.this.utkashRoom.getpigibag().addApiedata(pigibagTable);
                }
            } catch (SQLiteDiskIOException e3) {
                Log.e("DatabaseHelper", "SQLiteDiskIOException during onUpgrade: " + e3.getMessage());
            } catch (SQLiteFullException e4) {
                Log.e("DatabaseHelper", "SQLiteFullException during onUpgrade: " + e4.getMessage());
            } catch (IllegalStateException e5) {
                Log.e("DatabaseHelper", "IllegalStateException (DB closed): " + e5.getMessage());
            } catch (Exception e6) {
                Log.e("DatabaseHelper", "Unhandled Exception: " + e6.getMessage());
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<String> call, Throwable t) {
            Helper.dismissProgressDialog();
            Toast.makeText(NetworkCall.this.context, NetworkCall.this.context.getResources().getString(R.string.jsonparsing_error_message), 0).show();
            NetworkCall.this.myCBI.ErrorCallBack(NetworkCall.this.context.getResources().getString(R.string.exception_api_error_message), this.val$apiType, this.val$typeApi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkandupdateversion(JSONObject jsonObject) {
        String str;
        try {
            if (jsonObject.has("auth_code")) {
                if (jsonObject.optString("auth_code").equals(Const.EXPIRY_AUTH_CODE)) {
                    RetrofitResponse.GetApiData(this.context, jsonObject.has("auth_code") ? jsonObject.getString("auth_code") : "", jsonObject.getString("message"), false);
                    return;
                }
                return;
            }
            if (jsonObject.getJSONObject("data").getJSONObject("master").has("ut_009")) {
                if (!this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_009")) {
                    APITABLE apitable = new APITABLE();
                    apitable.setApicode("ut_009");
                    apitable.setApiname("master_content");
                    apitable.setInterval("0");
                    apitable.setUser_id(MakeMyExam.userId);
                    apitable.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                    apitable.setCdtimestamp("0");
                    apitable.setVersion("0.000");
                    this.utkashRoom.getapidao().addUser(apitable);
                } else if (Float.parseFloat(this.utkashRoom.getapidao().getapidetail("ut_009", MakeMyExam.userId).getVersion()) < Float.parseFloat(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_009"))) {
                    this.utkashRoom.getapidao().updateversion(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_009"), MakeMyExam.userId, "ut_009");
                    this.utkashRoom.getLaunguages().deletedata();
                    this.utkashRoom.getMasterAllCatDao().deletedata();
                    this.utkashRoom.getMastercatDao().deletedata();
                    this.utkashRoom.getcoursetypemaster().deletedata();
                    this.utkashRoom.getBannerTableDao().deleteBanners();
                }
            }
            if (jsonObject.getJSONObject("data").getJSONObject("master").has("ut_012")) {
                String string = SharedPreference.getInstance().getString(Const.VERSION_CODE);
                float f2 = Float.parseFloat(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_012"));
                if (string == null || string.equalsIgnoreCase("") || Integer.parseInt(string) < 53) {
                    SharedPreference.getInstance().putString(Const.VERSION_CODE, "53");
                    str = "uw_master";
                    f2 = Float.parseFloat(String.valueOf(((double) f2) + 0.001d));
                } else {
                    str = "uw_master";
                }
                if (!this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_012")) {
                    APITABLE apitable2 = new APITABLE();
                    apitable2.setApicode("ut_012");
                    apitable2.setApiname("get_my_courses");
                    apitable2.setInterval("0");
                    apitable2.setUser_id(MakeMyExam.userId);
                    apitable2.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                    apitable2.setCdtimestamp("0");
                    apitable2.setVersion("0.000");
                    this.utkashRoom.getapidao().addUser(apitable2);
                } else if (Float.parseFloat(this.utkashRoom.getapidao().getapidetail("ut_012", MakeMyExam.userId).getVersion()) < f2) {
                    this.utkashRoom.getapidao().updateversion("" + f2, MakeMyExam.userId, "ut_012");
                    this.utkashRoom.getMyCourseDao().deletedata();
                }
            } else {
                str = "uw_master";
            }
            if (jsonObject.getJSONObject("data").getJSONObject("master").has("ut_010")) {
                if (!this.utkashRoom.getapidao().is_api_code_exits(MakeMyExam.userId, "ut_010")) {
                    APITABLE apitable3 = new APITABLE();
                    apitable3.setApicode("ut_010");
                    apitable3.setApiname("get_courses");
                    apitable3.setInterval("0");
                    apitable3.setUser_id(MakeMyExam.userId);
                    apitable3.setTimestamp(String.valueOf(jsonObject.optLong("time")));
                    apitable3.setCdtimestamp("0");
                    apitable3.setVersion("0.000");
                    this.utkashRoom.getapidao().addUser(apitable3);
                } else if (Float.parseFloat(this.utkashRoom.getapidao().getapidetail("ut_010", MakeMyExam.userId).getVersion()) < Float.parseFloat(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_010"))) {
                    this.utkashRoom.getapidao().updateversion(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_010"), MakeMyExam.userId, "ut_010");
                    this.utkashRoom.getCoursedata().deletedata();
                    this.utkashRoom.getHomeApiStatusdata().deletedata();
                }
            }
            if (jsonObject.getJSONObject("data").has(str)) {
                for (int i = 0; i < jsonObject.getJSONObject("data").getJSONArray(str).length(); i++) {
                    UserWiseCourseTable userWiseCourseTable = (UserWiseCourseTable) new Gson().fromJson(jsonObject.getJSONObject("data").getJSONArray(str).get(i).toString(), UserWiseCourseTable.class);
                    if (!this.utkashRoom.getCourseDetaildata().isRecordExistsUserId(MakeMyExam.userId, userWiseCourseTable.getMeta_id())) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(userWiseCourseTable.getMeta_id(), MakeMyExam.userId);
                    } else if (Long.parseLong(userWiseCourseTable.getExp()) < jsonObject.optLong("time")) {
                        this.utkashRoom.getCourseDetaildata().deletecoursedetail(userWiseCourseTable.getMeta_id(), MakeMyExam.userId);
                    } else if (this.utkashRoom.getuserwisecourse().is_api_code_exits(MakeMyExam.userId, userWiseCourseTable.getMeta_id())) {
                        if (Float.parseFloat(this.utkashRoom.getuserwisecourse().getapidetail(userWiseCourseTable.getMeta_id(), MakeMyExam.userId).getVersion()) < Float.parseFloat(userWiseCourseTable.getVersion())) {
                            this.utkashRoom.getCourseDetaildata().deletecoursedetail(userWiseCourseTable.getMeta_id(), MakeMyExam.userId);
                        }
                        this.utkashRoom.getuserwisecourse().update_api_version(userWiseCourseTable.getMeta_id(), MakeMyExam.userId, userWiseCourseTable.getVersion());
                    } else {
                        userWiseCourseTable.setUserid(MakeMyExam.userId);
                        this.utkashRoom.getuserwisecourse().addUser(userWiseCourseTable);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onSessionExpired() {
        Helper.SignOutUser(this.context);
    }
}
