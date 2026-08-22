package com.clevertap.android.sdk.inapp.evaluation;

import android.location.Location;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u001a\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0003H\u0001¢\u0006\u0002\b J\u0012\u0010!\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001a\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006\""}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/EventAdapter;", "", "eventName", "", TriggerAdapter.KEY_EVENT_PROPERTIES, "", FirebaseAnalytics.Param.ITEMS, "", "userLocation", "Landroid/location/Location;", TriggerAdapter.KEY_PROFILE_ATTR_NAME, "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Landroid/location/Location;Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "getEventProperties", "()Ljava/util/Map;", "getItems", "()Ljava/util/List;", "getUserLocation", "()Landroid/location/Location;", "getProfileAttrName", "systemPropToKey", "getSystemPropToKey$clevertap_core_release", "getPropertyValue", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;", TriggerAdapter.INAPP_PROPERTYNAME, "getItemValue", "isChargedEvent", "", "isUserAttributeChangeEvent", "getActualPropertyValue", "getActualPropertyValue$clevertap_core_release", "evaluateActualPropertyValue", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EventAdapter {
    private final String eventName;
    private final Map<String, Object> eventProperties;
    private final List<Map<String, Object>> items;
    private final String profileAttrName;
    private final Map<String, String> systemPropToKey;
    private final Location userLocation;

    /* JADX WARN: Multi-variable type inference failed */
    public EventAdapter(String eventName, Map<String, ? extends Object> eventProperties, List<? extends Map<String, ? extends Object>> items, Location location, String str) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        Intrinsics.checkNotNullParameter(items, "items");
        this.eventName = eventName;
        this.eventProperties = eventProperties;
        this.items = items;
        this.userLocation = location;
        this.profileAttrName = str;
        this.systemPropToKey = MapsKt.mapOf(TuplesKt.to("CT App Version", "Version"), TuplesKt.to("ct_app_version", "Version"), TuplesKt.to("CT Latitude", Constants.CLTAP_LATITUDE), TuplesKt.to("ct_latitude", Constants.CLTAP_LATITUDE), TuplesKt.to("CT Longitude", Constants.CLTAP_LONGITUDE), TuplesKt.to("ct_longitude", Constants.CLTAP_LONGITUDE), TuplesKt.to("CT OS Version", Constants.CLTAP_OS_VERSION), TuplesKt.to("ct_os_version", Constants.CLTAP_OS_VERSION), TuplesKt.to("CT SDK Version", Constants.CLTAP_SDK_VERSION), TuplesKt.to("ct_sdk_version", Constants.CLTAP_SDK_VERSION), TuplesKt.to("CT Network Carrier", Constants.CLTAP_CARRIER), TuplesKt.to("ct_network_carrier", Constants.CLTAP_CARRIER), TuplesKt.to("CT Network Type", Constants.CLTAP_NETWORK_TYPE), TuplesKt.to("ct_network_type", Constants.CLTAP_NETWORK_TYPE), TuplesKt.to("CT Connected To WiFi", Constants.CLTAP_CONNECTED_TO_WIFI), TuplesKt.to("ct_connected_to_wifi", Constants.CLTAP_CONNECTED_TO_WIFI), TuplesKt.to("CT Bluetooth Version", Constants.CLTAP_BLUETOOTH_VERSION), TuplesKt.to("ct_bluetooth_version", Constants.CLTAP_BLUETOOTH_VERSION), TuplesKt.to("CT Bluetooth Enabled", Constants.CLTAP_BLUETOOTH_ENABLED), TuplesKt.to("ct_bluetooth_enabled", Constants.CLTAP_BLUETOOTH_ENABLED), TuplesKt.to("CT App Name", "appnId"));
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getEventProperties() {
        return this.eventProperties;
    }

    public /* synthetic */ EventAdapter(String str, Map map, List list, Location location, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : location, (i & 16) != 0 ? null : str2);
    }

    public final List<Map<String, Object>> getItems() {
        return this.items;
    }

    public final Location getUserLocation() {
        return this.userLocation;
    }

    public final String getProfileAttrName() {
        return this.profileAttrName;
    }

    public final Map<String, String> getSystemPropToKey$clevertap_core_release() {
        return this.systemPropToKey;
    }

    public final TriggerValue getPropertyValue(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        return new TriggerValue(getActualPropertyValue$clevertap_core_release(propertyName), null, 2, null);
    }

    public final List<TriggerValue> getItemValue(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        List<Map> listFilterNotNull = CollectionsKt.filterNotNull(this.items);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFilterNotNull, 10));
        for (Map map : listFilterNotNull) {
            Object obj = map.get(propertyName);
            if (obj == null) {
                obj = map.get(Utils.getNormalizedName(propertyName));
            }
            if (obj == null) {
                ArrayList arrayList2 = new ArrayList(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    arrayList2.add(TuplesKt.to(Utils.getNormalizedName((String) entry.getKey()), entry.getValue()));
                }
                obj = MapsKt.toMap(arrayList2).get(Utils.getNormalizedName(propertyName));
            }
            arrayList.add(new TriggerValue(obj, null, 2, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((TriggerValue) obj2).getValue() != null) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    public final boolean isChargedEvent() {
        return Intrinsics.areEqual(this.eventName, Constants.CHARGED_EVENT);
    }

    public final boolean isUserAttributeChangeEvent() {
        return this.profileAttrName != null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Object getActualPropertyValue$clevertap_core_release(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Object objEvaluateActualPropertyValue = evaluateActualPropertyValue(propertyName);
        if (objEvaluateActualPropertyValue != null) {
            return objEvaluateActualPropertyValue;
        }
        switch (propertyName.hashCode()) {
            case -543370741:
                if (propertyName.equals(Constants.CLTAP_PROP_CAMPAIGN_ID)) {
                    return evaluateActualPropertyValue(Constants.NOTIFICATION_ID_TAG);
                }
                break;
            case 1035561631:
                if (propertyName.equals(Constants.INAPP_WZRK_PIVOT)) {
                    return evaluateActualPropertyValue(Constants.CLTAP_PROP_VARIANT);
                }
                break;
            case 1840075742:
                if (propertyName.equals(Constants.NOTIFICATION_ID_TAG)) {
                    return evaluateActualPropertyValue(Constants.CLTAP_PROP_CAMPAIGN_ID);
                }
                break;
            case 1901439077:
                if (propertyName.equals(Constants.CLTAP_PROP_VARIANT)) {
                    return evaluateActualPropertyValue(Constants.INAPP_WZRK_PIVOT);
                }
                break;
        }
        String str = this.systemPropToKey.get(propertyName);
        if (str != null) {
            return evaluateActualPropertyValue(str);
        }
        return null;
    }

    private final Object evaluateActualPropertyValue(String propertyName) {
        Object obj = this.eventProperties.get(propertyName);
        if (obj == null) {
            obj = this.eventProperties.get(Utils.getNormalizedName(propertyName));
        }
        if (obj != null) {
            return obj;
        }
        Map<String, Object> map = this.eventProperties;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(Utils.getNormalizedName(entry.getKey()), entry.getValue()));
        }
        return MapsKt.toMap(arrayList).get(Utils.getNormalizedName(propertyName));
    }
}
