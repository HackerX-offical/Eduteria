package com.appnew.android.Utils.Network;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.table.APITABLE;
import com.appnew.android.table.UserWiseCourseTable;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MainFragment extends Fragment {
    public Activity activity;
    String id;
    UtkashRoom utkashRoom = UtkashRoom.getAppDatabase(MakeMyExam.getAppContext());

    public abstract void ErrorCallBack(String jsonstring, String apitype, String typeApi);

    public abstract void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException;

    public abstract Call<String> getAPIB(String apitype, String typeApi, APIInterface service);

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        this.activity = activity;
        Helper.enableScreenShot(activity);
    }

    public void NetworkAPICall(final String apiType, final String typeApi, final boolean showprogress, final boolean multipleAPI, boolean isMiddle) {
        Call<String> apib;
        try {
            APIInterface aPIInterface = (APIInterface) MakeMyExam.getRetrofitInstance().create(APIInterface.class);
            try {
                if (Helper.isConnected(this.activity)) {
                    if (showprogress) {
                        Helper.showProgressDialog(this.activity);
                    }
                    if (apiType.equals("changedetecter")) {
                        EncryptionData encryptionData = new EncryptionData();
                        encryptionData.setUser_id("1");
                        apib = aPIInterface.getchangedetector(AES.encrypt(new Gson().toJson(encryptionData)));
                    } else {
                        apib = getAPIB(apiType, typeApi, aPIInterface);
                    }
                    apib.enqueue(new Callback<String>() { // from class: com.appnew.android.Utils.Network.MainFragment.1
                        /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
                        /* JADX WARN: Removed duplicated region for block: B:36:0x00cf A[Catch: JSONException -> 0x03ab, TryCatch #3 {JSONException -> 0x03ab, blocks: (B:12:0x003b, B:16:0x0055, B:18:0x005b, B:20:0x0066, B:21:0x0073, B:23:0x007b, B:25:0x0081, B:27:0x008b, B:29:0x0097, B:31:0x00a4, B:34:0x00c3, B:36:0x00cf, B:38:0x0118, B:40:0x0124, B:41:0x012d, B:44:0x0135, B:46:0x013d, B:48:0x0147, B:50:0x0151, B:53:0x0160, B:54:0x0164, B:56:0x0170, B:58:0x017a, B:61:0x0189, B:65:0x01cd, B:67:0x01d3, B:69:0x01de, B:70:0x01eb, B:72:0x01f1, B:74:0x01fb, B:100:0x032f, B:102:0x033d, B:104:0x0343, B:106:0x034d, B:108:0x0359, B:110:0x0360, B:114:0x036d, B:113:0x036a, B:75:0x020d, B:77:0x0215, B:79:0x021f, B:83:0x0252, B:86:0x0264, B:88:0x0282, B:89:0x028e, B:90:0x02a5, B:93:0x02d5, B:95:0x02eb, B:97:0x0301, B:99:0x0319, B:82:0x024f, B:115:0x0379, B:32:0x00b1, B:62:0x018d), top: B:129:0x003b, inners: #1, #2, #6, #7, #8 }] */
                        @Override // retrofit2.Callback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void onResponse(retrofit2.Call<java.lang.String> r25, retrofit2.Response<java.lang.String> r26) {
                            /*
                                Method dump skipped, instruction units count: 1057
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.Network.MainFragment.AnonymousClass1.onResponse(retrofit2.Call, retrofit2.Response):void");
                        }

                        @Override // retrofit2.Callback
                        public void onFailure(Call<String> call, Throwable t) {
                            Helper.dismissProgressDialog();
                            Toast.makeText(MainFragment.this.activity, MainFragment.this.activity.getResources().getString(R.string.jsonparsing_error_message), 0).show();
                            MainFragment mainFragment = MainFragment.this;
                            mainFragment.ErrorCallBack(mainFragment.activity.getResources().getString(R.string.exception_api_error_message), apiType, typeApi);
                        }
                    });
                    return;
                }
                if (getActivity() != null && !getActivity().isDestroyed()) {
                    Helper.dismissProgressDialog();
                }
                ErrorCallBack(getResources().getString(R.string.internet_error_message), apiType, typeApi);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    public void onSessionExpired() {
        Helper.SignOutUser(this.activity);
    }

    public void showProgress() {
        Helper.showProgressDialog(this.activity);
    }

    public void hideProgress() {
        Helper.dismissProgressDialog();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Helper.dismissProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkandupdateversion(JSONObject jsonObject) {
        try {
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
                    this.utkashRoom.getthemeSettingdao().deletedata();
                }
            }
            if (jsonObject.getJSONObject("data").getJSONObject("master").has("ut_012")) {
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
                } else if (Float.parseFloat(this.utkashRoom.getapidao().getapidetail("ut_012", MakeMyExam.userId).getVersion()) < Float.parseFloat(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_012"))) {
                    this.utkashRoom.getapidao().updateversion(jsonObject.getJSONObject("data").getJSONObject("master").getString("ut_012"), MakeMyExam.userId, "ut_012");
                    this.utkashRoom.getMyCourseDao().deletedata();
                }
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
            if (jsonObject.getJSONObject("data").has("uw_master")) {
                for (int i = 0; i < jsonObject.getJSONObject("data").getJSONArray("uw_master").length(); i++) {
                    UserWiseCourseTable userWiseCourseTable = (UserWiseCourseTable) new Gson().fromJson(jsonObject.getJSONObject("data").getJSONArray("uw_master").get(i).toString(), UserWiseCourseTable.class);
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
}
