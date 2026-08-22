package com.clevertap.android.sdk.inapp.data;

import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.inapp.CTInAppNotificationMedia;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateInAppData;
import com.clevertap.android.sdk.inapp.customtemplates.TemplatesManager;
import com.clevertap.android.sdk.inapp.evaluation.LimitAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InAppResponseAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u001e\u0010)\u001a\u00020%2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0'2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0003H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u00109\u001a\u00020\u0003H\u0002R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"0\t0\u001a¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u00101\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001f\u00104\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0015¨\u0006<"}, d2 = {"Lcom/clevertap/android/sdk/inapp/data/InAppResponseAdapter;", "", "responseJson", "Lorg/json/JSONObject;", "templatesManager", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "<init>", "(Lorg/json/JSONObject;Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;)V", "legacyInApps", "Lkotlin/Pair;", "", "Lorg/json/JSONArray;", "partitionedLegacyInApps", "Lcom/clevertap/android/sdk/inapp/data/PartitionedInApps;", "getPartitionedLegacyInApps", "()Lcom/clevertap/android/sdk/inapp/data/PartitionedInApps;", "clientSideInApps", "partitionedClientSideInApps", "getPartitionedClientSideInApps", "serverSideInApps", "getServerSideInApps", "()Lkotlin/Pair;", "appLaunchServerSideInApps", "partitionedAppLaunchServerSideInApps", "getPartitionedAppLaunchServerSideInApps", "preloadImages", "", "", "preloadGifs", "preloadFiles", "preloadAssets", "getPreloadAssets", "()Ljava/util/List;", "preloadAssetsMeta", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "getPreloadAssetsMeta", "fetchMediaUrls", "", "imageList", "", "gifList", "fetchFilesUrlsForTemplates", "filesList", "inAppsPerSession", "", "getInAppsPerSession", "()I", "inAppsPerDay", "getInAppsPerDay", "inAppMode", "getInAppMode", "()Ljava/lang/String;", "staleInApps", "getStaleInApps", "partitionInAppsByDelay", "inAppsArray", "hasNoDelay", Constants.INAPP_KEY, "getValidatedInAppDelay", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppResponseAdapter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String IN_APP_DAILY_KEY = "imp";
    private static final int IN_APP_DEFAULT_DAILY = 10;
    private static final int IN_APP_DEFAULT_SESSION = 10;
    private static final String IN_APP_SESSION_KEY = "imc";
    private final Pair<Boolean, JSONArray> appLaunchServerSideInApps;
    private final Pair<Boolean, JSONArray> clientSideInApps;
    private final String inAppMode;
    private final int inAppsPerDay;
    private final int inAppsPerSession;
    private final Pair<Boolean, JSONArray> legacyInApps;
    private final PartitionedInApps partitionedAppLaunchServerSideInApps;
    private final PartitionedInApps partitionedClientSideInApps;
    private final PartitionedInApps partitionedLegacyInApps;
    private final List<String> preloadAssets;
    private final List<Pair<String, CtCacheType>> preloadAssetsMeta;
    private final List<String> preloadFiles;
    private final List<String> preloadGifs;
    private final List<String> preloadImages;
    private final Pair<Boolean, JSONArray> serverSideInApps;
    private final Pair<Boolean, JSONArray> staleInApps;

    @JvmStatic
    public static final List<LimitAdapter> getListOfWhenLimits(JSONObject jSONObject) {
        return INSTANCE.getListOfWhenLimits(jSONObject);
    }

    public InAppResponseAdapter(JSONObject responseJson, TemplatesManager templatesManager) throws JSONException {
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        Intrinsics.checkNotNullParameter(templatesManager, "templatesManager");
        Pair<Boolean, JSONArray> pairSafeGetJSONArrayOrNullIfEmpty = CTXtensions.safeGetJSONArrayOrNullIfEmpty(responseJson, Constants.INAPP_JSON_RESPONSE_KEY);
        this.legacyInApps = pairSafeGetJSONArrayOrNullIfEmpty;
        this.partitionedLegacyInApps = partitionInAppsByDelay(pairSafeGetJSONArrayOrNullIfEmpty.getSecond());
        Pair<Boolean, JSONArray> pairSafeGetJSONArray = CTXtensions.safeGetJSONArray(responseJson, "inapp_notifs_cs");
        this.clientSideInApps = pairSafeGetJSONArray;
        this.partitionedClientSideInApps = partitionInAppsByDelay(pairSafeGetJSONArray.getSecond());
        this.serverSideInApps = CTXtensions.safeGetJSONArray(responseJson, "inapp_notifs_ss");
        Pair<Boolean, JSONArray> pairSafeGetJSONArrayOrNullIfEmpty2 = CTXtensions.safeGetJSONArrayOrNullIfEmpty(responseJson, Constants.INAPP_NOTIFS_APP_LAUNCHED_KEY);
        this.appLaunchServerSideInApps = pairSafeGetJSONArrayOrNullIfEmpty2;
        this.partitionedAppLaunchServerSideInApps = partitionInAppsByDelay(pairSafeGetJSONArrayOrNullIfEmpty2.getSecond());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        fetchMediaUrls(arrayList, arrayList2);
        fetchFilesUrlsForTemplates(arrayList3, templatesManager);
        this.preloadImages = arrayList;
        this.preloadGifs = arrayList2;
        this.preloadFiles = arrayList3;
        ArrayList arrayList4 = arrayList2;
        ArrayList arrayList5 = arrayList3;
        this.preloadAssets = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList4), (Iterable) arrayList5);
        ArrayList arrayList6 = arrayList;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it = arrayList6.iterator();
        while (it.hasNext()) {
            arrayList7.add(new Pair((String) it.next(), CtCacheType.IMAGE));
        }
        ArrayList arrayList8 = arrayList7;
        ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            arrayList9.add(new Pair((String) it2.next(), CtCacheType.GIF));
        }
        List listPlus = CollectionsKt.plus((Collection) arrayList8, (Iterable) arrayList9);
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            arrayList10.add(new Pair((String) it3.next(), CtCacheType.FILES));
        }
        List listPlus2 = CollectionsKt.plus((Collection) listPlus, (Iterable) arrayList10);
        HashSet hashSet = new HashSet();
        ArrayList arrayList11 = new ArrayList();
        for (Object obj : listPlus2) {
            if (hashSet.add((String) ((Pair) obj).getFirst())) {
                arrayList11.add(obj);
            }
        }
        this.preloadAssetsMeta = arrayList11;
        this.inAppsPerSession = responseJson.optInt("imc", 10);
        this.inAppsPerDay = responseJson.optInt("imp", 10);
        String strOptString = responseJson.optString(Constants.INAPP_DELIVERY_MODE_KEY, "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        this.inAppMode = strOptString;
        this.staleInApps = CTXtensions.safeGetJSONArrayOrNullIfEmpty(responseJson, Constants.INAPP_NOTIFS_STALE_KEY);
    }

    /* JADX INFO: compiled from: InAppResponseAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/data/InAppResponseAdapter$Companion;", "", "<init>", "()V", "IN_APP_DEFAULT_DAILY", "", "IN_APP_DEFAULT_SESSION", "IN_APP_SESSION_KEY", "", "IN_APP_DAILY_KEY", "getListOfWhenLimits", "", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitAdapter;", "limitJSON", "Lorg/json/JSONObject;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<LimitAdapter> getListOfWhenLimits(JSONObject limitJSON) {
            Intrinsics.checkNotNullParameter(limitJSON, "limitJSON");
            JSONArray jSONArrayOrEmptyArray = CTXtensions.orEmptyArray(limitJSON.optJSONArray(Constants.INAPP_FC_LIMITS));
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOrEmptyArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jSONArrayOrEmptyArray.get(i);
                if (obj instanceof JSONObject) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new LimitAdapter((JSONObject) it.next()));
            }
            return CollectionsKt.toMutableList((Collection) arrayList3);
        }
    }

    public final PartitionedInApps getPartitionedLegacyInApps() {
        return this.partitionedLegacyInApps;
    }

    public final PartitionedInApps getPartitionedClientSideInApps() {
        return this.partitionedClientSideInApps;
    }

    public final Pair<Boolean, JSONArray> getServerSideInApps() {
        return this.serverSideInApps;
    }

    public final PartitionedInApps getPartitionedAppLaunchServerSideInApps() {
        return this.partitionedAppLaunchServerSideInApps;
    }

    public final List<String> getPreloadAssets() {
        return this.preloadAssets;
    }

    public final List<Pair<String, CtCacheType>> getPreloadAssetsMeta() {
        return this.preloadAssetsMeta;
    }

    private final void fetchMediaUrls(List<String> imageList, List<String> gifList) throws JSONException {
        JSONArray second;
        CTInAppNotificationMedia cTInAppNotificationMediaCreate;
        CTInAppNotificationMedia cTInAppNotificationMediaCreate2;
        if (!this.clientSideInApps.getFirst().booleanValue() || (second = this.clientSideInApps.getSecond()) == null) {
            return;
        }
        int length = second.length();
        for (int i = 0; i < length; i++) {
            Object obj = second.get(i);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("media");
                if (jSONObjectOptJSONObject != null && (cTInAppNotificationMediaCreate2 = CTInAppNotificationMedia.INSTANCE.create(jSONObjectOptJSONObject, 1)) != null && !StringsKt.isBlank(cTInAppNotificationMediaCreate2.getMediaUrl())) {
                    if (cTInAppNotificationMediaCreate2.isImage()) {
                        imageList.add(cTInAppNotificationMediaCreate2.getMediaUrl());
                    } else if (cTInAppNotificationMediaCreate2.isGIF()) {
                        gifList.add(cTInAppNotificationMediaCreate2.getMediaUrl());
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(Constants.KEY_MEDIA_LANDSCAPE);
                if (jSONObjectOptJSONObject2 != null && (cTInAppNotificationMediaCreate = CTInAppNotificationMedia.INSTANCE.create(jSONObjectOptJSONObject2, 2)) != null && !StringsKt.isBlank(cTInAppNotificationMediaCreate.getMediaUrl())) {
                    if (cTInAppNotificationMediaCreate.isImage()) {
                        imageList.add(cTInAppNotificationMediaCreate.getMediaUrl());
                    } else if (cTInAppNotificationMediaCreate.isGIF()) {
                        gifList.add(cTInAppNotificationMediaCreate.getMediaUrl());
                    }
                }
            }
        }
    }

    private final void fetchFilesUrlsForTemplates(List<String> filesList, TemplatesManager templatesManager) {
        JSONArray second;
        if (!this.clientSideInApps.getFirst().booleanValue() || (second = this.clientSideInApps.getSecond()) == null) {
            return;
        }
        int length = second.length();
        for (int i = 0; i < length; i++) {
            CustomTemplateInAppData customTemplateInAppDataCreateFromJson = CustomTemplateInAppData.INSTANCE.createFromJson(second.optJSONObject(i));
            if (customTemplateInAppDataCreateFromJson != null) {
                customTemplateInAppDataCreateFromJson.getFileArgsUrls$clevertap_core_release(templatesManager, filesList);
            }
        }
    }

    public final int getInAppsPerSession() {
        return this.inAppsPerSession;
    }

    public final int getInAppsPerDay() {
        return this.inAppsPerDay;
    }

    public final String getInAppMode() {
        return this.inAppMode;
    }

    public final Pair<Boolean, JSONArray> getStaleInApps() {
        return this.staleInApps;
    }

    private final PartitionedInApps partitionInAppsByDelay(JSONArray inAppsArray) throws JSONException {
        if (inAppsArray == null) {
            return PartitionedInApps.INSTANCE.empty();
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        int length = inAppsArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = inAppsArray.get(i);
            if (obj instanceof JSONObject) {
                if (hasNoDelay((JSONObject) obj)) {
                    jSONArray.put(obj);
                } else {
                    jSONArray2.put(obj);
                }
            }
        }
        Pair pair = TuplesKt.to(jSONArray, jSONArray2);
        return new PartitionedInApps((JSONArray) pair.component1(), (JSONArray) pair.component2());
    }

    private final boolean hasNoDelay(JSONObject inApp) {
        return getValidatedInAppDelay(inApp) == 0;
    }

    private final int getValidatedInAppDelay(JSONObject inApp) {
        int iOptInt = inApp.optInt(InAppDelayConstants.INAPP_DELAY_AFTER_TRIGGER, 0);
        if (1 > iOptInt || iOptInt >= 1201) {
            return 0;
        }
        return iOptInt;
    }
}
