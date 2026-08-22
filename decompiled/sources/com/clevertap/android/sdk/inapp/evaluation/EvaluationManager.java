package com.clevertap.android.sdk.inapp.evaluation;

import android.location.Location;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.inapp.TriggerManager;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateInAppData;
import com.clevertap.android.sdk.inapp.customtemplates.TemplatesManager;
import com.clevertap.android.sdk.inapp.evaluation.InAppSelectionStrategy;
import com.clevertap.android.sdk.inapp.store.preference.InAppStore;
import com.clevertap.android.sdk.inapp.store.preference.StoreRegistry;
import com.clevertap.android.sdk.network.EndpointId;
import com.clevertap.android.sdk.network.NetworkHeadersListener;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.variables.JsonUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.ErrorBundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvaluationManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 x2\u00020\u0001:\u0001xB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ8\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u00192\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010%\u001a\u0004\u0018\u00010&JJ\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0018\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180*2\b\u0010%\u001a\u0004\u0018\u00010&JP\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u001e\u0010$\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018J0\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010%\u001a\u0004\u0018\u00010&J2\u0010.\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000*2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010%\u001a\u0004\u0018\u00010&J2\u00101\u001a\u00020\"2\f\u00102\u001a\b\u0012\u0004\u0012\u0002000*2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010%\u001a\u0004\u0018\u00010&J\u001c\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002060*2\u0006\u00107\u001a\u00020\u0019J\u001b\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0*H\u0001¢\u0006\u0002\b<J\u001b\u0010=\u001a\u00020\"2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0*H\u0001¢\u0006\u0002\b>J\u001b\u0010?\u001a\u00020\"2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0*H\u0001¢\u0006\u0002\b@JN\u0010A\u001a\b\u0012\u0004\u0012\u0002000*2\u0006\u0010B\u001a\u00020;2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002000*2#\b\u0002\u0010D\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002090EH\u0001¢\u0006\u0002\bIJ-\u0010J\u001a\u00020\"2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002000*2\u0006\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u000204H\u0001¢\u0006\u0002\bOJ=\u0010P\u001a\u00020\"2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0*2\u0006\u0010L\u001a\u00020M2\u0018\u0010Q\u001a\u0014\u0012\u0004\u0012\u00020R\u0012\n\u0012\b\u0012\u0004\u0012\u0002000*0EH\u0001¢\u0006\u0002\bSJA\u0010T\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000*2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010L\u001a\u00020MH\u0001¢\u0006\u0002\bUJ\u001b\u0010V\u001a\b\u0012\u0004\u0012\u00020W0*2\u0006\u0010X\u001a\u000200H\u0001¢\u0006\u0002\bYJ\u001b\u0010Z\u001a\b\u0012\u0004\u0012\u0002060*2\u0006\u0010[\u001a\u000200H\u0000¢\u0006\u0002\b\\J!\u0010]\u001a\b\u0012\u0004\u0012\u0002000*2\f\u0010^\u001a\b\u0012\u0004\u0012\u0002000*H\u0000¢\u0006\u0002\b_J\u0010\u0010`\u001a\u0002042\u0006\u0010a\u001a\u000200H\u0002J\u0015\u0010b\u001a\u0002092\u0006\u0010a\u001a\u000200H\u0001¢\u0006\u0002\bcJ\u001f\u0010d\u001a\u00020\u00192\u0006\u0010e\u001a\u00020\u00192\b\b\u0002\u0010f\u001a\u00020gH\u0001¢\u0006\u0002\bhJ\u001f\u0010i\u001a\u0002092\u0006\u0010a\u001a\u0002002\b\b\u0002\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bjJ\u0010\u0010k\u001a\u0002092\u0006\u0010l\u001a\u000200H\u0002J\u0010\u0010m\u001a\u0002092\u0006\u0010l\u001a\u000200H\u0002J\u0012\u0010n\u001a\u0004\u0018\u0001002\u0006\u0010o\u001a\u00020pH\u0016J\u0018\u0010q\u001a\u0002092\u0006\u0010r\u001a\u0002002\u0006\u0010o\u001a\u00020pH\u0016J\b\u0010s\u001a\u000209H\u0007J\r\u0010t\u001a\u000209H\u0001¢\u0006\u0002\buJ\r\u0010v\u001a\u000209H\u0001¢\u0006\u0002\bwR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R8\u0010\u0017\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00180\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/EvaluationManager;", "Lcom/clevertap/android/sdk/network/NetworkHeadersListener;", "triggersMatcher", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggersMatcher;", "triggersManager", "Lcom/clevertap/android/sdk/inapp/TriggerManager;", "limitsMatcher", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitsMatcher;", "storeRegistry", "Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;", "templatesManager", "Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;", "<init>", "(Lcom/clevertap/android/sdk/inapp/evaluation/TriggersMatcher;Lcom/clevertap/android/sdk/inapp/TriggerManager;Lcom/clevertap/android/sdk/inapp/evaluation/LimitsMatcher;Lcom/clevertap/android/sdk/inapp/store/preference/StoreRegistry;Lcom/clevertap/android/sdk/inapp/customtemplates/TemplatesManager;)V", "evaluatedServerSideCampaignIds", "", "", "getEvaluatedServerSideCampaignIds$clevertap_core_release$annotations", "()V", "getEvaluatedServerSideCampaignIds$clevertap_core_release", "()Ljava/util/List;", "setEvaluatedServerSideCampaignIds$clevertap_core_release", "(Ljava/util/List;)V", "suppressedClientSideInApps", "", "", "", "getSuppressedClientSideInApps$clevertap_core_release$annotations", "getSuppressedClientSideInApps$clevertap_core_release", "setSuppressedClientSideInApps$clevertap_core_release", "dateFormatter", "Ljava/text/SimpleDateFormat;", "evaluateOnEvent", "Lkotlin/Pair;", "Lorg/json/JSONArray;", "eventName", TriggerAdapter.KEY_EVENT_PROPERTIES, "userLocation", "Landroid/location/Location;", "evaluateOnChargedEvent", ErrorBundle.DETAIL_ENTRY, FirebaseAnalytics.Param.ITEMS, "", "evaluateOnUserAttributeChange", "appFields", "evaluateOnAppLaunchedClientSide", "evaluateOnAppLaunchedServerSide", "appLaunchedNotifs", "Lorg/json/JSONObject;", "evaluateOnAppLaunchedDelayedServerSide", "appLaunchedDelayedNotifs", "matchWhenLimitsBeforeDisplay", "", "listOfLimitAdapter", "Lcom/clevertap/android/sdk/inapp/evaluation/LimitAdapter;", Column.CAMPAIGN, "evaluateServerSide", "", "events", "Lcom/clevertap/android/sdk/inapp/evaluation/EventAdapter;", "evaluateServerSide$clevertap_core_release", "evaluateClientSide", "evaluateClientSide$clevertap_core_release", "evaluateDelayedClientSide", "evaluateDelayedClientSide$clevertap_core_release", "evaluate", "event", "inappNotifs", "clearResource", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "evaluate$clevertap_core_release", "selectAndProcessEligibleInApps", "eligibleInApps", "strategy", "Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy;", "shouldUpdateTTLForThisContext", "selectAndProcessEligibleInApps$clevertap_core_release", "executeClientSideEvaluationFlow", "readInAppsFromStore", "Lcom/clevertap/android/sdk/inapp/store/preference/InAppStore;", "executeClientSideEvaluationFlow$clevertap_core_release", "executeServerSideAppLaunchEvaluationFlow", "executeServerSideAppLaunchEvaluationFlow$clevertap_core_release", "getWhenTriggers", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerAdapter;", "triggerJson", "getWhenTriggers$clevertap_core_release", "getWhenLimits", "limitJSON", "getWhenLimits$clevertap_core_release", "sortByPriority", "inApps", "sortByPriority$clevertap_core_release", "shouldSuppress", Constants.INAPP_KEY, "suppress", "suppress$clevertap_core_release", "generateWzrkId", Constants.INAPP_ID_IN_PAYLOAD, "clock", "Lcom/clevertap/android/sdk/utils/Clock;", "generateWzrkId$clevertap_core_release", "updateTTL", "updateTTL$clevertap_core_release", "removeSentEvaluatedServerSideCampaignIds", "header", "removeSentSuppressedClientSideInApps", "onAttachHeaders", "endpointId", "Lcom/clevertap/android/sdk/network/EndpointId;", "onSentHeaders", "allHeaders", "loadSuppressedCSAndEvaluatedSSInAppsIds", "saveEvaluatedServerSideInAppIds", "saveEvaluatedServerSideInAppIds$clevertap_core_release", "saveSuppressedClientSideInAppIds", "saveSuppressedClientSideInAppIds$clevertap_core_release", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EvaluationManager implements NetworkHeadersListener {
    private static final String TAG = "EvaluationManager";
    private final SimpleDateFormat dateFormatter;
    private List<Long> evaluatedServerSideCampaignIds;
    private final LimitsMatcher limitsMatcher;
    private final StoreRegistry storeRegistry;
    private List<Map<String, Object>> suppressedClientSideInApps;
    private final TemplatesManager templatesManager;
    private final TriggerManager triggersManager;
    private final TriggersMatcher triggersMatcher;

    public static /* synthetic */ void getEvaluatedServerSideCampaignIds$clevertap_core_release$annotations() {
    }

    public static /* synthetic */ void getSuppressedClientSideInApps$clevertap_core_release$annotations() {
    }

    public EvaluationManager(TriggersMatcher triggersMatcher, TriggerManager triggersManager, LimitsMatcher limitsMatcher, StoreRegistry storeRegistry, TemplatesManager templatesManager) {
        Intrinsics.checkNotNullParameter(triggersMatcher, "triggersMatcher");
        Intrinsics.checkNotNullParameter(triggersManager, "triggersManager");
        Intrinsics.checkNotNullParameter(limitsMatcher, "limitsMatcher");
        Intrinsics.checkNotNullParameter(storeRegistry, "storeRegistry");
        Intrinsics.checkNotNullParameter(templatesManager, "templatesManager");
        this.triggersMatcher = triggersMatcher;
        this.triggersManager = triggersManager;
        this.limitsMatcher = limitsMatcher;
        this.storeRegistry = storeRegistry;
        this.templatesManager = templatesManager;
        this.evaluatedServerSideCampaignIds = new ArrayList();
        this.suppressedClientSideInApps = new ArrayList();
        this.dateFormatter = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    }

    public final List<Long> getEvaluatedServerSideCampaignIds$clevertap_core_release() {
        return this.evaluatedServerSideCampaignIds;
    }

    public final void setEvaluatedServerSideCampaignIds$clevertap_core_release(List<Long> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.evaluatedServerSideCampaignIds = list;
    }

    public final List<Map<String, Object>> getSuppressedClientSideInApps$clevertap_core_release() {
        return this.suppressedClientSideInApps;
    }

    public final void setSuppressedClientSideInApps$clevertap_core_release(List<Map<String, Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.suppressedClientSideInApps = list;
    }

    public final Pair<JSONArray, JSONArray> evaluateOnEvent(String eventName, Map<String, ? extends Object> eventProperties, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        List<EventAdapter> listListOf = CollectionsKt.listOf(new EventAdapter(eventName, eventProperties, null, userLocation, null, 20, null));
        evaluateServerSide$clevertap_core_release(listListOf);
        return new Pair<>(evaluateClientSide$clevertap_core_release(listListOf), evaluateDelayedClientSide$clevertap_core_release(listListOf));
    }

    public final Pair<JSONArray, JSONArray> evaluateOnChargedEvent(Map<String, ? extends Object> details, List<? extends Map<String, ? extends Object>> items, Location userLocation) throws JSONException {
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(items, "items");
        List<EventAdapter> listListOf = CollectionsKt.listOf(new EventAdapter(Constants.CHARGED_EVENT, details, items, userLocation, null, 16, null));
        evaluateServerSide$clevertap_core_release(listListOf);
        return new Pair<>(evaluateClientSide$clevertap_core_release(listListOf), evaluateDelayedClientSide$clevertap_core_release(listListOf));
    }

    public final Pair<JSONArray, JSONArray> evaluateOnAppLaunchedClientSide(Map<String, ? extends Object> eventProperties, Location userLocation) {
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        List<EventAdapter> listListOf = CollectionsKt.listOf(new EventAdapter(Constants.APP_LAUNCHED_EVENT, eventProperties, null, userLocation, null, 20, null));
        return new Pair<>(evaluateClientSide$clevertap_core_release(listListOf), evaluateDelayedClientSide$clevertap_core_release(listListOf));
    }

    public final JSONArray evaluateOnAppLaunchedServerSide(List<? extends JSONObject> appLaunchedNotifs, Map<String, ? extends Object> eventProperties, Location userLocation) {
        Intrinsics.checkNotNullParameter(appLaunchedNotifs, "appLaunchedNotifs");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        return executeServerSideAppLaunchEvaluationFlow$clevertap_core_release(appLaunchedNotifs, eventProperties, userLocation, InAppSelectionStrategy.Immediate.INSTANCE);
    }

    public final JSONArray evaluateOnAppLaunchedDelayedServerSide(List<? extends JSONObject> appLaunchedDelayedNotifs, Map<String, ? extends Object> eventProperties, Location userLocation) {
        Intrinsics.checkNotNullParameter(appLaunchedDelayedNotifs, "appLaunchedDelayedNotifs");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        return executeServerSideAppLaunchEvaluationFlow$clevertap_core_release(appLaunchedDelayedNotifs, eventProperties, userLocation, InAppSelectionStrategy.Delayed.INSTANCE);
    }

    public final boolean matchWhenLimitsBeforeDisplay(List<LimitAdapter> listOfLimitAdapter, String campaignId) {
        Intrinsics.checkNotNullParameter(listOfLimitAdapter, "listOfLimitAdapter");
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        return this.limitsMatcher.matchWhenLimits(listOfLimitAdapter, campaignId);
    }

    public final void evaluateServerSide$clevertap_core_release(List<EventAdapter> events) throws JSONException {
        int i;
        Intrinsics.checkNotNullParameter(events, "events");
        ArrayList arrayList = new ArrayList();
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        if (inAppStore != null) {
            Iterator<EventAdapter> it = events.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                EventAdapter next = it.next();
                JSONArray serverSideInAppsMetaData = inAppStore.readServerSideInAppsMetaData();
                ArrayList arrayList2 = new ArrayList();
                int length = serverSideInAppsMetaData.length();
                while (i < length) {
                    Object obj = serverSideInAppsMetaData.get(i);
                    if (obj instanceof JSONObject) {
                        arrayList2.add(obj);
                    }
                    i++;
                }
                arrayList.addAll(evaluate$clevertap_core_release$default(this, next, arrayList2, null, 4, null));
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                long jOptLong = ((JSONObject) it2.next()).optLong(Constants.INAPP_ID_IN_PAYLOAD);
                if (jOptLong != 0) {
                    this.evaluatedServerSideCampaignIds.add(Long.valueOf(jOptLong));
                    i = 1;
                }
            }
            if (i != 0) {
                saveEvaluatedServerSideInAppIds$clevertap_core_release();
            }
        }
    }

    public final JSONArray evaluateClientSide$clevertap_core_release(List<EventAdapter> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        return executeClientSideEvaluationFlow$clevertap_core_release(events, InAppSelectionStrategy.Immediate.INSTANCE, new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EvaluationManager.evaluateClientSide$lambda$4((InAppStore) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List evaluateClientSide$lambda$4(InAppStore store) throws JSONException {
        Intrinsics.checkNotNullParameter(store, "store");
        JSONArray clientSideInApps = store.readClientSideInApps();
        ArrayList arrayList = new ArrayList();
        int length = clientSideInApps.length();
        for (int i = 0; i < length; i++) {
            Object obj = clientSideInApps.get(i);
            if (obj instanceof JSONObject) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final JSONArray evaluateDelayedClientSide$clevertap_core_release(List<EventAdapter> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        return executeClientSideEvaluationFlow$clevertap_core_release(events, InAppSelectionStrategy.Delayed.INSTANCE, new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EvaluationManager.evaluateDelayedClientSide$lambda$5((InAppStore) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List evaluateDelayedClientSide$lambda$5(InAppStore store) throws JSONException {
        Intrinsics.checkNotNullParameter(store, "store");
        JSONArray clientSideDelayedInApps = store.readClientSideDelayedInApps();
        ArrayList arrayList = new ArrayList();
        int length = clientSideDelayedInApps.length();
        for (int i = 0; i < length; i++) {
            Object obj = clientSideDelayedInApps.get(i);
            if (obj instanceof JSONObject) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List evaluate$clevertap_core_release$default(EvaluationManager evaluationManager, EventAdapter eventAdapter, List list, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return EvaluationManager.evaluate$lambda$6((String) obj2);
                }
            };
        }
        return evaluationManager.evaluate$clevertap_core_release(eventAdapter, list, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit evaluate$lambda$6(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final List<JSONObject> evaluate$clevertap_core_release(EventAdapter event, List<? extends JSONObject> inappNotifs, Function1<? super String, Unit> clearResource) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(inappNotifs, "inappNotifs");
        Intrinsics.checkNotNullParameter(clearResource, "clearResource");
        ArrayList arrayList = new ArrayList();
        for (JSONObject jSONObject : inappNotifs) {
            CustomTemplateInAppData customTemplateInAppDataCreateFromJson = CustomTemplateInAppData.INSTANCE.createFromJson(jSONObject);
            String templateName = customTemplateInAppDataCreateFromJson != null ? customTemplateInAppDataCreateFromJson.getTemplateName() : null;
            if (templateName == null || this.templatesManager.isTemplateRegistered(templateName)) {
                String strOptString = jSONObject.optString(Constants.INAPP_ID_IN_PAYLOAD);
                if (this.triggersMatcher.matchEvent(getWhenTriggers$clevertap_core_release(jSONObject), event)) {
                    Logger.v("INAPP", "Triggers matched for event " + event.getEventName() + " against inApp " + strOptString);
                    TriggerManager triggerManager = this.triggersManager;
                    Intrinsics.checkNotNull(strOptString);
                    triggerManager.increment(strOptString);
                    boolean zMatchWhenLimits = this.limitsMatcher.matchWhenLimits(getWhenLimits$clevertap_core_release(jSONObject), strOptString);
                    if (this.limitsMatcher.shouldDiscard(getWhenLimits$clevertap_core_release(jSONObject), strOptString)) {
                        clearResource.invoke("");
                    }
                    if (zMatchWhenLimits) {
                        Logger.v("INAPP", "Limits matched for event " + event.getEventName() + " against inApp " + strOptString);
                        arrayList.add(jSONObject);
                    } else {
                        Logger.v("INAPP", "Limits did not matched for event " + event.getEventName() + " against inApp " + strOptString);
                    }
                } else {
                    Logger.v("INAPP", "Triggers did not matched for event " + event.getEventName() + " against inApp " + strOptString);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ JSONArray selectAndProcessEligibleInApps$clevertap_core_release$default(EvaluationManager evaluationManager, List list, InAppSelectionStrategy inAppSelectionStrategy, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return evaluationManager.selectAndProcessEligibleInApps$clevertap_core_release(list, inAppSelectionStrategy, z);
    }

    public final JSONArray selectAndProcessEligibleInApps$clevertap_core_release(List<? extends JSONObject> eligibleInApps, InAppSelectionStrategy strategy, boolean shouldUpdateTTLForThisContext) throws JSONException {
        Intrinsics.checkNotNullParameter(eligibleInApps, "eligibleInApps");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        List<JSONObject> listSortByPriority$clevertap_core_release = sortByPriority$clevertap_core_release(eligibleInApps);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        List<JSONObject> listSelectInApps = strategy.selectInApps(listSortByPriority$clevertap_core_release, new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(EvaluationManager.selectAndProcessEligibleInApps$lambda$7(this.f$0, booleanRef, (JSONObject) obj));
            }
        });
        if (shouldUpdateTTLForThisContext && strategy.shouldUpdateTTL()) {
            for (JSONObject jSONObject : listSelectInApps) {
                updateTTL$clevertap_core_release$default(this, jSONObject, null, 2, null);
                Logger.v(TAG, "Updated TTL for in-app: " + jSONObject.optString(Constants.INAPP_ID_IN_PAYLOAD));
            }
        }
        if (booleanRef.element) {
            saveSuppressedClientSideInAppIds$clevertap_core_release();
        }
        if (!listSelectInApps.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = listSelectInApps.iterator();
            while (it.hasNext()) {
                jSONArray.put((JSONObject) it.next());
            }
            return jSONArray;
        }
        return new JSONArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean selectAndProcessEligibleInApps$lambda$7(EvaluationManager this$0, Ref.BooleanRef updated, JSONObject inApp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updated, "$updated");
        Intrinsics.checkNotNullParameter(inApp, "inApp");
        boolean zShouldSuppress = this$0.shouldSuppress(inApp);
        if (zShouldSuppress) {
            updated.element = true;
            this$0.suppress$clevertap_core_release(inApp);
            Logger.v(TAG, "Suppressed in-app: " + inApp.optString(Constants.INAPP_ID_IN_PAYLOAD));
        }
        return zShouldSuppress;
    }

    public final JSONArray executeClientSideEvaluationFlow$clevertap_core_release(List<EventAdapter> events, InAppSelectionStrategy strategy, Function1<? super InAppStore, ? extends List<? extends JSONObject>> readInAppsFromStore) {
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(readInAppsFromStore, "readInAppsFromStore");
        ArrayList arrayList = new ArrayList();
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        if (inAppStore == null) {
            return new JSONArray();
        }
        for (EventAdapter eventAdapter : events) {
            Object obj = eventAdapter.getEventProperties().get(Constants.KEY_OLD_VALUE);
            Object obj2 = eventAdapter.getEventProperties().get(Constants.KEY_NEW_VALUE);
            if (obj2 == null || !Intrinsics.areEqual(obj2, obj)) {
                arrayList.addAll(evaluate$clevertap_core_release$default(this, eventAdapter, readInAppsFromStore.invoke(inAppStore), null, 4, null));
            }
        }
        return selectAndProcessEligibleInApps$clevertap_core_release(arrayList, strategy, true);
    }

    public final JSONArray executeServerSideAppLaunchEvaluationFlow$clevertap_core_release(List<? extends JSONObject> appLaunchedNotifs, Map<String, ? extends Object> eventProperties, Location userLocation, InAppSelectionStrategy strategy) {
        Intrinsics.checkNotNullParameter(appLaunchedNotifs, "appLaunchedNotifs");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        return selectAndProcessEligibleInApps$clevertap_core_release(evaluate$clevertap_core_release$default(this, new EventAdapter(Constants.APP_LAUNCHED_EVENT, eventProperties, null, userLocation, null, 20, null), appLaunchedNotifs, null, 4, null), strategy, false);
    }

    public final List<TriggerAdapter> getWhenTriggers$clevertap_core_release(JSONObject triggerJson) throws JSONException {
        Intrinsics.checkNotNullParameter(triggerJson, "triggerJson");
        JSONArray jSONArrayOrEmptyArray = CTXtensions.orEmptyArray(triggerJson.optJSONArray(Constants.INAPP_WHEN_TRIGGERS));
        IntRange intRangeUntil = RangesKt.until(0, jSONArrayOrEmptyArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            Object obj = jSONArrayOrEmptyArray.get(((IntIterator) it).nextInt());
            JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
            TriggerAdapter triggerAdapter = jSONObject != null ? new TriggerAdapter(jSONObject) : null;
            if (triggerAdapter != null) {
                arrayList.add(triggerAdapter);
            }
        }
        return arrayList;
    }

    public final List<LimitAdapter> getWhenLimits$clevertap_core_release(JSONObject limitJSON) throws JSONException {
        Intrinsics.checkNotNullParameter(limitJSON, "limitJSON");
        JSONArray jSONArrayOrEmptyArray = CTXtensions.orEmptyArray(limitJSON.optJSONArray(Constants.INAPP_FC_LIMITS));
        JSONArray jSONArrayOrEmptyArray2 = CTXtensions.orEmptyArray(limitJSON.optJSONArray(Constants.INAPP_OCCURRENCE_LIMITS));
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOrEmptyArray.length();
        for (int i = 0; i < length; i++) {
            Object obj = jSONArrayOrEmptyArray.get(i);
            if (obj instanceof JSONObject) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        int length2 = jSONArrayOrEmptyArray2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            Object obj2 = jSONArrayOrEmptyArray2.get(i2);
            if (obj2 instanceof JSONObject) {
                arrayList3.add(obj2);
            }
        }
        List<JSONObject> listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (JSONObject jSONObject : listPlus) {
            LimitAdapter limitAdapter = CTXtensions.isNotNullAndEmpty(jSONObject) ? new LimitAdapter(jSONObject) : null;
            if (limitAdapter != null) {
                arrayList4.add(limitAdapter);
            }
        }
        return arrayList4;
    }

    public final List<JSONObject> sortByPriority$clevertap_core_release(List<? extends JSONObject> inApps) {
        Intrinsics.checkNotNullParameter(inApps, "inApps");
        final Function1 function1 = new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(EvaluationManager.sortByPriority$lambda$17((JSONObject) obj));
            }
        };
        final Function1 function12 = new Function1() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EvaluationManager.sortByPriority$lambda$18((JSONObject) obj);
            }
        };
        final Comparator comparator = new Comparator() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$sortByPriority$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Comparable) function1.invoke((JSONObject) t2), (Comparable) function1.invoke((JSONObject) t));
            }
        };
        return CollectionsKt.sortedWith(inApps, new Comparator() { // from class: com.clevertap.android.sdk.inapp.evaluation.EvaluationManager$sortByPriority$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                if (iCompare != 0) {
                    return iCompare;
                }
                return ComparisonsKt.compareValues((Comparable) function12.invoke((JSONObject) t), (Comparable) function12.invoke((JSONObject) t2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sortByPriority$lambda$17(JSONObject inApp) {
        Intrinsics.checkNotNullParameter(inApp, "inApp");
        return inApp.optInt("priority", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sortByPriority$lambda$18(JSONObject inApp) {
        Intrinsics.checkNotNullParameter(inApp, "inApp");
        return inApp.optString(Constants.INAPP_ID_IN_PAYLOAD, String.valueOf(Clock.SYSTEM.newDate().getTime() / ((long) 1000)));
    }

    private final boolean shouldSuppress(JSONObject inApp) {
        return inApp.optBoolean(Constants.INAPP_SUPPRESSED);
    }

    public final void suppress$clevertap_core_release(JSONObject inApp) {
        Intrinsics.checkNotNullParameter(inApp, "inApp");
        String strOptString = inApp.optString(Constants.INAPP_ID_IN_PAYLOAD);
        Intrinsics.checkNotNull(strOptString);
        this.suppressedClientSideInApps.add(MapsKt.mapOf(TuplesKt.to(Constants.NOTIFICATION_ID_TAG, generateWzrkId$clevertap_core_release$default(this, strOptString, null, 2, null)), TuplesKt.to(Constants.INAPP_WZRK_PIVOT, inApp.optString(Constants.INAPP_WZRK_PIVOT, "wzrk_default")), TuplesKt.to(Constants.INAPP_WZRK_CGID, Integer.valueOf(inApp.optInt(Constants.INAPP_WZRK_CGID)))));
    }

    public static /* synthetic */ String generateWzrkId$clevertap_core_release$default(EvaluationManager evaluationManager, String str, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            clock = Clock.SYSTEM;
        }
        return evaluationManager.generateWzrkId$clevertap_core_release(str, clock);
    }

    public final String generateWzrkId$clevertap_core_release(String ti, Clock clock) {
        Intrinsics.checkNotNullParameter(ti, "ti");
        Intrinsics.checkNotNullParameter(clock, "clock");
        return ti + '_' + this.dateFormatter.format(clock.newDate());
    }

    public static /* synthetic */ void updateTTL$clevertap_core_release$default(EvaluationManager evaluationManager, JSONObject jSONObject, Clock clock, int i, Object obj) throws JSONException {
        if ((i & 2) != 0) {
            clock = Clock.SYSTEM;
        }
        evaluationManager.updateTTL$clevertap_core_release(jSONObject, clock);
    }

    public final void updateTTL$clevertap_core_release(JSONObject inApp, Clock clock) throws JSONException {
        Intrinsics.checkNotNullParameter(inApp, "inApp");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Object objOpt = inApp.opt(Constants.WZRK_TIME_TO_LIVE_OFFSET);
        Long l = objOpt instanceof Long ? (Long) objOpt : null;
        if (l != null) {
            inApp.put("wzrk_ttl", clock.currentTimeSeconds() + l.longValue());
        } else {
            inApp.remove("wzrk_ttl");
        }
    }

    private final void removeSentEvaluatedServerSideCampaignIds(JSONObject header) throws JSONException {
        JSONArray jSONArrayOptJSONArray = header.optJSONArray(Constants.INAPP_SS_EVAL_META);
        int i = 0;
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            int i2 = 0;
            while (i < length) {
                long jOptLong = jSONArrayOptJSONArray.optLong(i);
                if (jOptLong != 0) {
                    this.evaluatedServerSideCampaignIds.remove(Long.valueOf(jOptLong));
                    i2 = 1;
                }
                i++;
            }
            i = i2;
        }
        if (i != 0) {
            saveEvaluatedServerSideInAppIds$clevertap_core_release();
        }
    }

    private final void removeSentSuppressedClientSideInApps(JSONObject header) throws JSONException {
        JSONArray jSONArrayOptJSONArray = header.optJSONArray(Constants.INAPP_SUPPRESSED_META);
        boolean z = false;
        if (jSONArrayOptJSONArray != null) {
            Iterator<Map<String, Object>> it = this.suppressedClientSideInApps.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Object obj = it.next().get(Constants.NOTIFICATION_ID_TAG);
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    String string = jSONArrayOptJSONArray.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    if (StringsKt.contains$default((CharSequence) string, (CharSequence) str, false, 2, (Object) null)) {
                        it.remove();
                        z2 = true;
                    }
                }
            }
            z = z2;
        }
        if (z) {
            saveSuppressedClientSideInAppIds$clevertap_core_release();
        }
    }

    @Override // com.clevertap.android.sdk.network.NetworkHeadersListener
    public JSONObject onAttachHeaders(EndpointId endpointId) throws JSONException {
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        JSONObject jSONObject = new JSONObject();
        if (endpointId == EndpointId.ENDPOINT_A1) {
            if (!this.evaluatedServerSideCampaignIds.isEmpty()) {
                jSONObject.put(Constants.INAPP_SS_EVAL_META, JsonUtil.listToJsonArray(this.evaluatedServerSideCampaignIds));
            }
            if (!this.suppressedClientSideInApps.isEmpty()) {
                jSONObject.put(Constants.INAPP_SUPPRESSED_META, JsonUtil.listToJsonArray(this.suppressedClientSideInApps));
            }
        }
        if (CTXtensions.isNotNullAndEmpty(jSONObject)) {
            return jSONObject;
        }
        return null;
    }

    @Override // com.clevertap.android.sdk.network.NetworkHeadersListener
    public void onSentHeaders(JSONObject allHeaders, EndpointId endpointId) throws JSONException {
        Intrinsics.checkNotNullParameter(allHeaders, "allHeaders");
        Intrinsics.checkNotNullParameter(endpointId, "endpointId");
        if (endpointId == EndpointId.ENDPOINT_A1) {
            removeSentEvaluatedServerSideCampaignIds(allHeaders);
            removeSentSuppressedClientSideInApps(allHeaders);
        }
    }

    public final void loadSuppressedCSAndEvaluatedSSInAppsIds() {
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        if (inAppStore != null) {
            JSONArray evaluatedServerSideInAppIds = inAppStore.readEvaluatedServerSideInAppIds();
            ArrayList arrayList = new ArrayList();
            int length = evaluatedServerSideInAppIds.length();
            for (int i = 0; i < length; i++) {
                Object obj = evaluatedServerSideInAppIds.get(i);
                if (obj instanceof Long) {
                    arrayList.add(obj);
                }
            }
            this.evaluatedServerSideCampaignIds = arrayList;
            this.suppressedClientSideInApps = JsonUtil.listFromJson(inAppStore.readSuppressedClientSideInAppIds());
        }
    }

    public final void saveEvaluatedServerSideInAppIds$clevertap_core_release() throws JSONException {
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        if (inAppStore != null) {
            JSONArray jSONArrayListToJsonArray = JsonUtil.listToJsonArray(this.evaluatedServerSideCampaignIds);
            Intrinsics.checkNotNullExpressionValue(jSONArrayListToJsonArray, "listToJsonArray(...)");
            inAppStore.storeEvaluatedServerSideInAppIds(jSONArrayListToJsonArray);
        }
    }

    public final void saveSuppressedClientSideInAppIds$clevertap_core_release() throws JSONException {
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        if (inAppStore != null) {
            JSONArray jSONArrayListToJsonArray = JsonUtil.listToJsonArray(this.suppressedClientSideInApps);
            Intrinsics.checkNotNullExpressionValue(jSONArrayListToJsonArray, "listToJsonArray(...)");
            inAppStore.storeSuppressedClientSideInAppIds(jSONArrayListToJsonArray);
        }
    }

    public final Pair<JSONArray, JSONArray> evaluateOnUserAttributeChange(Map<String, ? extends Map<String, ? extends Object>> eventProperties, Location userLocation, Map<String, ? extends Object> appFields) throws JSONException {
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        Intrinsics.checkNotNullParameter(appFields, "appFields");
        ArrayList arrayList = new ArrayList(eventProperties.size());
        for (Map.Entry<String, ? extends Map<String, ? extends Object>> entry : eventProperties.entrySet()) {
            Map mutableMap = MapsKt.toMutableMap(entry.getValue());
            mutableMap.putAll(appFields);
            arrayList.add(new EventAdapter(entry.getKey() + Constants.USER_ATTRIBUTE_CHANGE, mutableMap, null, userLocation, entry.getKey(), 4, null));
        }
        ArrayList arrayList2 = arrayList;
        evaluateServerSide$clevertap_core_release(arrayList2);
        return new Pair<>(evaluateClientSide$clevertap_core_release(arrayList2), evaluateDelayedClientSide$clevertap_core_release(arrayList2));
    }
}
