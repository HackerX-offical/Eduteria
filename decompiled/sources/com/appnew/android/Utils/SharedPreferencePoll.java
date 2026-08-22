package com.appnew.android.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.appnew.android.Model.AttemptedUserPoll;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferencePoll {
    private static final String PREF_NAME = "SharedPreference1";
    private static SharedPreferencePoll instance;
    private SharedPreferences sharedPreferences;

    private SharedPreferencePoll(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
    }

    public static synchronized SharedPreferencePoll getInstance(Context context) {
        if (instance == null) {
            if (context == null) {
                throw new IllegalStateException("Context cannot be null when initializing SharedPreference1");
            }
            instance = new SharedPreferencePoll(context.getApplicationContext());
        }
        return instance;
    }

    public List<AttemptedUserPoll> getAttemptedUserPollList() {
        if (this.sharedPreferences == null) {
            throw new IllegalStateException("Shared Preferences not initialized");
        }
        Gson gson = new Gson();
        String string = this.sharedPreferences.getString("KEY_SEND_USER_DATA", null);
        if (string != null) {
            try {
                return (List) gson.fromJson(string, new TypeToken<ArrayList<AttemptedUserPoll>>() { // from class: com.appnew.android.Utils.SharedPreferencePoll.1
                }.getType());
            } catch (Exception e2) {
                Log.e("TAG_APP", "Error parsing JSON: " + e2.getMessage());
            }
        }
        return new ArrayList();
    }

    public void saveAttemptedUserPollList(List<AttemptedUserPoll> list) {
        if (this.sharedPreferences == null) {
            throw new IllegalStateException("Shared Preferences not initialized");
        }
        this.sharedPreferences.edit().putString("KEY_SEND_USER_DATA", new Gson().toJson(list)).apply();
    }

    public void removeItemByRandomKey(final String randomKey) {
        if (this.sharedPreferences == null) {
            throw new IllegalStateException("Shared Preferences not initialized");
        }
        Gson gson = new Gson();
        String string = this.sharedPreferences.getString("KEY_SEND_USER_DATA", null);
        if (string != null) {
            try {
                List list = (List) gson.fromJson(string, new TypeToken<ArrayList<AttemptedUserPoll>>() { // from class: com.appnew.android.Utils.SharedPreferencePoll.2
                }.getType());
                list.removeIf(new Predicate() { // from class: com.appnew.android.Utils.SharedPreferencePoll$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return SharedPreferencePoll.lambda$removeItemByRandomKey$0(randomKey, (AttemptedUserPoll) obj);
                    }
                });
                this.sharedPreferences.edit().putString("KEY_SEND_USER_DATA", gson.toJson(list)).apply();
            } catch (Exception e2) {
                Log.e("TAG_APP", "Error removing item by randomKey: " + e2.getMessage());
            }
        }
    }

    static /* synthetic */ boolean lambda$removeItemByRandomKey$0(String str, AttemptedUserPoll attemptedUserPoll) {
        return attemptedUserPoll != null && str.equals(attemptedUserPoll.getPollkey());
    }
}
