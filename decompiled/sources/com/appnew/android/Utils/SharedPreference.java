package com.appnew.android.Utils;

import android.content.SharedPreferences;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.Courses.Modal.NotesPDF.NoteList;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.User;
import com.appnew.android.Model.UserAttendanceModel.UserAttendanceMain;
import com.appnew.android.Response.MasterFeedsHitResponse;
import com.appnew.android.Response.MasterRegistrationResponse;
import com.appnew.android.Response.PostResponse;
import com.appnew.android.Response.Registration.StreamResponse;
import com.appnew.android.Response.Registration.SubStreamResponse;
import com.appnew.android.home.model.Search.RecentList;
import com.appnew.android.pojo.Userinfo.Data;
import com.appnew.android.pojo.Userinfo.IntitutePojo.IntituteData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class SharedPreference {
    public static final int MODE = 0;
    public static final String MY_PREFERENCES = "MY_PREFERENCES";
    private static SharedPreference pref;
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreference;

    public void saveLanguage(String key) {
    }

    private SharedPreference() {
        SharedPreferences sharedPreferences = MakeMyExam.getAppContext().getSharedPreferences(MY_PREFERENCES, 0);
        this.sharedPreference = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public static SharedPreference getInstance() {
        if (pref == null) {
            pref = new SharedPreference();
        }
        return pref;
    }

    public HashMap<String, String> getHashMapdata(String key) {
        return (HashMap) new Gson().fromJson(this.sharedPreference.getString(key, ""), new TypeToken<HashMap<String, String>>() { // from class: com.appnew.android.Utils.SharedPreference.1
        }.getType());
    }

    public void saveHashMap(String key, Object obj) {
        this.editor.putString(key, new Gson().toJson(obj));
        this.editor.apply();
    }

    public String getGoogleToken(String key) {
        return this.sharedPreference.getString(key, "");
    }

    public void putGoogleToken(String key, String value) {
        this.editor.putString(key, value).commit();
    }

    public String getString(String key) {
        return this.sharedPreference.getString(key, "");
    }

    public Set<String> getStringSet(String key) {
        return this.sharedPreference.getStringSet(key, Collections.emptySet());
    }

    public void putString(String key, String value) {
        this.editor.putString(key, value).commit();
    }

    public void putStringSet(String key, Set<String> value) {
        this.editor.putStringSet(key, value).commit();
    }

    public int getInt(String key) {
        return this.sharedPreference.getInt(key, 1);
    }

    public int getIntdefault(String key) {
        return this.sharedPreference.getInt(key, 0);
    }

    public void putInt(String key, int value) {
        this.editor.putInt(key, value).commit();
    }

    public long getLong(String key) {
        return this.sharedPreference.getLong(key, 0L);
    }

    public void putLong(String key, long value) {
        this.editor.putLong(key, value).commit();
    }

    public float getFloat(String key) {
        return this.sharedPreference.getFloat(key, 0.5f);
    }

    public void putFloat(String key, float value) {
        this.editor.putFloat(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return this.sharedPreference.getBoolean(key, false);
    }

    public void putBoolean(String key, boolean value) {
        this.editor.putBoolean(key, value).commit();
    }

    public void ClearLoggedInUser() {
        this.editor.putString("user_logged_in", new Gson().toJson(new User()));
        this.editor.commit();
    }

    public void ClearTestUser() {
        this.editor.putString(Const.USER_TEST_DATA, new Gson().toJson(new User()));
        this.editor.commit();
    }

    public void ClearUserCoupon() {
        this.editor.putString(Const.USER_COUPON, new Gson().toJson(new User()));
        this.editor.commit();
    }

    public Data getLoggedInUser() {
        String string = this.sharedPreference.getString("user_logged_in", null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (Data) new Gson().fromJson(string, Data.class);
    }

    public EncryptionData getTestUser() {
        String string = this.sharedPreference.getString(Const.USER_TEST_DATA, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (EncryptionData) new Gson().fromJson(string, EncryptionData.class);
    }

    public CouponPojo getUserCoupon() {
        String string = this.sharedPreference.getString(Const.USER_COUPON, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (CouponPojo) new Gson().fromJson(string, CouponPojo.class);
    }

    public IntituteData getIntituteData() {
        String string = this.sharedPreference.getString(Const.INTITUTE_DATA, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (IntituteData) new Gson().fromJson(string, IntituteData.class);
    }

    public void setLoggedInUser(User user) {
        this.editor.putString("user_logged_in", new Gson().toJson(user));
        this.editor.commit();
    }

    public void setTestUser(EncryptionData user) {
        this.editor.putString(Const.USER_TEST_DATA, new Gson().toJson(user));
        this.editor.commit();
    }

    public void setUserCoupon(CouponPojo user) {
        this.editor.putString(Const.USER_COUPON, new Gson().toJson(user));
        this.editor.commit();
    }

    public NoteList getNoteData() {
        String string = this.sharedPreference.getString(Const.NOTE_DATA, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (NoteList) new Gson().fromJson(string, NoteList.class);
    }

    public void setNoteData(NoteList noteList) {
        this.editor.putString(Const.NOTE_DATA, new Gson().toJson(noteList));
        this.editor.commit();
    }

    public void setLoggedInUserr(Data user) {
        this.editor.putString("user_logged_in", new Gson().toJson(user));
        this.editor.commit();
    }

    public void setIntitute(IntituteData user) {
        this.editor.putString(Const.INTITUTE_DATA, new Gson().toJson(user));
        this.editor.commit();
    }

    public void setUserAttendance(UserAttendanceMain userAttendanceMain) {
        this.editor.putString(Const.INTITUTE_DATA, new Gson().toJson(userAttendanceMain));
        this.editor.commit();
    }

    public UserAttendanceMain getUserAttendance() {
        String string = this.sharedPreference.getString(Const.USER_ATTENDANCE, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (UserAttendanceMain) new Gson().fromJson(string, UserAttendanceMain.class);
    }

    public MasterFeedsHitResponse getMasterHitResponse() {
        String string = this.sharedPreference.getString(Const.MASTER_FEED_HIT_RESPONSE, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (MasterFeedsHitResponse) new Gson().fromJson(string, MasterFeedsHitResponse.class);
    }

    public MasterRegistrationResponse getRegistrationResponse() {
        String string = this.sharedPreference.getString(Const.MASTER_REGISTRATION_HIT_RESPONSE, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (MasterRegistrationResponse) new Gson().fromJson(string, MasterRegistrationResponse.class);
    }

    public PostResponse getPost() {
        String string = this.sharedPreference.getString(Const.POST, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (PostResponse) new Gson().fromJson(string, PostResponse.class);
    }

    public void setPost(PostResponse post) {
        this.editor.putString(Const.POST, new Gson().toJson(post));
        this.editor.commit();
    }

    public boolean contains(String key) {
        return this.sharedPreference.contains(key);
    }

    public void remove(String key) {
        this.editor.remove(key).commit();
    }

    public String getString(String s, String name) {
        return this.sharedPreference.getString(s, name);
    }

    public LinkedHashMap<StreamResponse, ArrayList<SubStreamResponse>> getHashMap(String key) {
        return (LinkedHashMap) new Gson().fromJson(this.sharedPreference.getString(key, ""), new TypeToken<LinkedHashMap<StreamResponse, ArrayList<SubStreamResponse>>>() { // from class: com.appnew.android.Utils.SharedPreference.2
        }.getType());
    }

    public RecentList getRecentData() {
        String string = this.sharedPreference.getString(Const.RECENT_DATA, null);
        if (string == null || string.trim().length() <= 0) {
            return null;
        }
        return (RecentList) new Gson().fromJson(string, RecentList.class);
    }

    public void setRecentData(RecentList recentList) {
        this.editor.putString(Const.RECENT_DATA, new Gson().toJson(recentList));
        this.editor.commit();
    }
}
