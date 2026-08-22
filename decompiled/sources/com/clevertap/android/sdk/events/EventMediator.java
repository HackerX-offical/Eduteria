package com.clevertap.android.sdk.events;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ProfileValueHandler;
import com.clevertap.android.sdk.network.NetworkRepo;
import com.clevertap.android.sdk.validation.Validator;
import com.clevertap.android.sdk.variables.JsonUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class EventMediator {
    private final CoreMetaData cleverTapMetaData;
    private final CleverTapInstanceConfig config;
    private final LocalDataStore localDataStore;
    private final NetworkRepo networkRepo;
    private final ProfileValueHandler profileValueHandler;

    public EventMediator(CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, LocalDataStore localDataStore, ProfileValueHandler profileValueHandler, NetworkRepo networkRepo) {
        this.config = cleverTapInstanceConfig;
        this.localDataStore = localDataStore;
        this.networkRepo = networkRepo;
        this.profileValueHandler = profileValueHandler;
        this.cleverTapMetaData = coreMetaData;
    }

    public boolean shouldDeferProcessingEvent(JSONObject jSONObject, int i) {
        if (i == 8 || this.config.isCreatedPostAppLaunch()) {
            return false;
        }
        if (jSONObject.has(Constants.KEY_EVT_NAME)) {
            try {
                if (Arrays.asList(Constants.SYSTEM_EVENTS).contains(jSONObject.getString(Constants.KEY_EVT_NAME))) {
                    return false;
                }
            } catch (JSONException unused) {
            }
        }
        return i == 4 && !this.cleverTapMetaData.isAppLaunchPushed();
    }

    public boolean shouldDropEvent(JSONObject jSONObject, int i) {
        if (i == 7 || i == 8) {
            return false;
        }
        if (this.networkRepo.isMuted()) {
            this.config.getLogger().verbose(this.config.getAccountId(), "CleverTap is muted, dropping event - " + jSONObject.toString());
            return true;
        }
        if (!this.cleverTapMetaData.isCurrentUserOptedOut()) {
            return false;
        }
        if (!this.cleverTapMetaData.getEnabledSystemEvents()) {
            this.config.getLogger().debug(this.config.getAccountId(), "Current user is opted out dropping event: " + jSONObject);
            return true;
        }
        if (i != 4 && i != 6) {
            this.config.getLogger().debug(this.config.getAccountId(), "This is not RAISED_EVENT or NV_EVENT, not dropping event: " + jSONObject);
            return false;
        }
        boolean zContains = Arrays.asList(Validator.restrictedNames).contains(jSONObject != null ? getEventName(jSONObject) : null);
        boolean z = !zContains;
        if (!zContains) {
            this.config.getLogger().debug(this.config.getAccountId(), "Current user is opted out dropping event: " + jSONObject);
            return z;
        }
        this.config.getLogger().debug(this.config.getAccountId(), "This is a system event, not dropping event: " + jSONObject);
        return z;
    }

    public boolean isAppLaunchedEvent(JSONObject jSONObject) {
        try {
            if (jSONObject.has(Constants.KEY_EVT_NAME)) {
                if (jSONObject.getString(Constants.KEY_EVT_NAME).equals(Constants.APP_LAUNCHED_EVENT)) {
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public boolean isEvent(JSONObject jSONObject) {
        return jSONObject.has(Constants.KEY_EVT_NAME);
    }

    public String getEventName(JSONObject jSONObject) {
        try {
            return jSONObject.getString(Constants.KEY_EVT_NAME);
        } catch (JSONException unused) {
            return null;
        }
    }

    public Map<String, Object> getEventProperties(JSONObject jSONObject) {
        if (jSONObject.has(Constants.KEY_EVT_NAME) && jSONObject.has(Constants.KEY_EVT_DATA)) {
            try {
                return JsonUtil.mapFromJson(jSONObject.getJSONObject(Constants.KEY_EVT_DATA));
            } catch (JSONException e2) {
                Logger.v("Could not convert JSONObject to Map - " + e2.getMessage());
            }
        }
        return new HashMap();
    }

    public boolean isChargedEvent(JSONObject jSONObject) {
        try {
            if (jSONObject.has(Constants.KEY_EVT_NAME)) {
                if (jSONObject.getString(Constants.KEY_EVT_NAME).equals(Constants.CHARGED_EVENT)) {
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    public List<Map<String, Object>> getChargedEventItemDetails(JSONObject jSONObject) {
        try {
            return JsonUtil.listFromJson(jSONObject.getJSONObject(Constants.KEY_EVT_DATA).getJSONArray(Constants.KEY_ITEMS));
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public Map<String, Object> getChargedEventDetails(JSONObject jSONObject) {
        try {
            Object objRemove = jSONObject.getJSONObject(Constants.KEY_EVT_DATA).remove(Constants.KEY_ITEMS);
            Map<String, Object> mapMapFromJson = JsonUtil.mapFromJson(jSONObject.getJSONObject(Constants.KEY_EVT_DATA));
            jSONObject.getJSONObject(Constants.KEY_EVT_DATA).put(Constants.KEY_ITEMS, objRemove);
            return mapMapFromJson;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public Map<String, Map<String, Object>> computeUserAttributeChangeProperties(JSONObject jSONObject) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("profile");
        if (jSONObjectOptJSONObject == null) {
            return map;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                if (!Constants.keysToSkipForUserAttributesEvaluation.contains(next)) {
                    Object profileProperty = this.localDataStore.getProfileProperty(next);
                    Object objValueOf = jSONObjectOptJSONObject.get(next);
                    if (objValueOf instanceof JSONObject) {
                        JSONObject jSONObject2 = (JSONObject) objValueOf;
                        String next2 = jSONObject2.keys().next();
                        switch (next2.hashCode()) {
                            case 1168893:
                                if (next2.equals(Constants.COMMAND_ADD)) {
                                    objValueOf = this.profileValueHandler.handleMultiValues(next, (JSONArray) jSONObject2.get(next2), next2, profileProperty);
                                }
                                break;
                            case 1186238:
                                if (next2.equals(Constants.COMMAND_SET)) {
                                    objValueOf = this.profileValueHandler.handleMultiValues(next, (JSONArray) jSONObject2.get(next2), next2, profileProperty);
                                }
                                break;
                            case 36326100:
                                if (next2.equals(Constants.COMMAND_DECREMENT)) {
                                    objValueOf = this.profileValueHandler.handleIncrementDecrementValues((Number) jSONObject2.get(next2), next2, (Number) profileProperty);
                                }
                                break;
                            case 36483704:
                                if (next2.equals(Constants.COMMAND_INCREMENT)) {
                                    objValueOf = this.profileValueHandler.handleIncrementDecrementValues((Number) jSONObject2.get(next2), next2, (Number) profileProperty);
                                }
                                break;
                            case 549903055:
                                if (next2.equals(Constants.COMMAND_DELETE)) {
                                    objValueOf = null;
                                }
                                break;
                            case 950750632:
                                if (next2.equals(Constants.COMMAND_REMOVE)) {
                                    objValueOf = this.profileValueHandler.handleMultiValues(next, (JSONArray) jSONObject2.get(next2), next2, profileProperty);
                                }
                                break;
                        }
                    } else if ((objValueOf instanceof String) && ((String) objValueOf).startsWith(Constants.DATE_PREFIX)) {
                        objValueOf = Long.valueOf(Long.parseLong(((String) objValueOf).substring(Constants.DATE_PREFIX.length())));
                    }
                    HashMap map3 = new HashMap();
                    if (profileProperty != null && !(profileProperty instanceof JSONArray)) {
                        map3.put(Constants.KEY_OLD_VALUE, profileProperty);
                    }
                    if (objValueOf != null && !(objValueOf instanceof JSONArray)) {
                        map3.put(Constants.KEY_NEW_VALUE, objValueOf);
                    }
                    if (!map3.isEmpty()) {
                        map.put(next, map3);
                    }
                    map2.put(next, objValueOf);
                }
            } catch (JSONException e2) {
                this.config.getLogger().debug(this.config.getAccountId(), "Error getting user attribute changes for key: " + next + e2);
            }
        }
        this.localDataStore.updateProfileFields(map2);
        return map;
    }
}
