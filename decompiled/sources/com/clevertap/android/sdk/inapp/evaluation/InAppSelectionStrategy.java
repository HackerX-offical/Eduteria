package com.clevertap.android.sdk.inapp.evaluation;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.inapp.data.InAppDelayConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: EvaluationManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\n\u000bJ0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\bH&\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy;", "", "selectInApps", "", "Lorg/json/JSONObject;", "sortedInApps", "suppressionHandler", "Lkotlin/Function1;", "", "shouldUpdateTTL", "Immediate", "Delayed", "Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy$Delayed;", "Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy$Immediate;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InAppSelectionStrategy {
    List<JSONObject> selectInApps(List<? extends JSONObject> sortedInApps, Function1<? super JSONObject, Boolean> suppressionHandler);

    boolean shouldUpdateTTL();

    /* JADX INFO: compiled from: EvaluationManager.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001¨\u0006\u0013"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy$Immediate;", "Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy;", "<init>", "()V", "shouldUpdateTTL", "", "selectInApps", "", "Lorg/json/JSONObject;", "sortedInApps", "suppressionHandler", "Lkotlin/Function1;", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Immediate implements InAppSelectionStrategy {
        public static final Immediate INSTANCE = new Immediate();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Immediate)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1080828396;
        }

        @Override // com.clevertap.android.sdk.inapp.evaluation.InAppSelectionStrategy
        public boolean shouldUpdateTTL() {
            return true;
        }

        public String toString() {
            return "Immediate";
        }

        private Immediate() {
        }

        @Override // com.clevertap.android.sdk.inapp.evaluation.InAppSelectionStrategy
        public List<JSONObject> selectInApps(List<? extends JSONObject> sortedInApps, Function1<? super JSONObject, Boolean> suppressionHandler) {
            Intrinsics.checkNotNullParameter(sortedInApps, "sortedInApps");
            Intrinsics.checkNotNullParameter(suppressionHandler, "suppressionHandler");
            for (JSONObject jSONObject : sortedInApps) {
                if (!suppressionHandler.invoke(jSONObject).booleanValue()) {
                    return CollectionsKt.listOf(jSONObject);
                }
            }
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: compiled from: EvaluationManager.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy$Delayed;", "Lcom/clevertap/android/sdk/inapp/evaluation/InAppSelectionStrategy;", "<init>", "()V", "TAG", "", "shouldUpdateTTL", "", "selectInApps", "", "Lorg/json/JSONObject;", "sortedInApps", "suppressionHandler", "Lkotlin/Function1;", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Delayed implements InAppSelectionStrategy {
        public static final Delayed INSTANCE = new Delayed();
        private static final String TAG = "DelayedInAppSelectionStrategy";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Delayed)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -498871163;
        }

        @Override // com.clevertap.android.sdk.inapp.evaluation.InAppSelectionStrategy
        public boolean shouldUpdateTTL() {
            return false;
        }

        public String toString() {
            return "Delayed";
        }

        private Delayed() {
        }

        @Override // com.clevertap.android.sdk.inapp.evaluation.InAppSelectionStrategy
        public List<JSONObject> selectInApps(List<? extends JSONObject> sortedInApps, Function1<? super JSONObject, Boolean> suppressionHandler) {
            Object next;
            Intrinsics.checkNotNullParameter(sortedInApps, "sortedInApps");
            Intrinsics.checkNotNullParameter(suppressionHandler, "suppressionHandler");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : sortedInApps) {
                Integer numValueOf = Integer.valueOf(((JSONObject) obj).optInt(InAppDelayConstants.INAPP_DELAY_AFTER_TRIGGER, 0));
                Object obj2 = linkedHashMap.get(numValueOf);
                if (obj2 == null) {
                    obj2 = (List) new ArrayList();
                    linkedHashMap.put(numValueOf, obj2);
                }
                ((List) obj2).add(obj);
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iIntValue = ((Number) entry.getKey()).intValue();
                List list = (List) entry.getValue();
                Logger.v(TAG, "Processing " + list.size() + " in-apps with delay: " + iIntValue + 's');
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (!suppressionHandler.invoke((JSONObject) next).booleanValue()) {
                        break;
                    }
                }
                JSONObject jSONObject = (JSONObject) next;
                if (jSONObject != null) {
                    arrayList.add(jSONObject);
                    Logger.v(TAG, "Selected in-app for delay " + iIntValue + "s: " + jSONObject.optString(Constants.INAPP_ID_IN_PAYLOAD));
                }
            }
            return arrayList;
        }
    }
}
