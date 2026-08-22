package com.clevertap.android.sdk.inapp.evaluation;

import android.location.Location;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.LocalDataStore;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TriggersMatcher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ\u001d\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\u000fJ\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\nH\u0003J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001d\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0001¢\u0006\u0002\b\u0015J%\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001cJ%\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020 H\u0001¢\u0006\u0002\b!J\u001d\u0010\"\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0002\b#J%\u0010$\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0007H\u0001¢\u0006\u0002\b&J\u001d\u0010'\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0002\b*J\u001e\u0010+\u001a\u00020\u00072\n\u0010,\u001a\u0006\u0012\u0002\b\u00030\t2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/TriggersMatcher;", "", "localDataStore", "Lcom/clevertap/android/sdk/LocalDataStore;", "<init>", "(Lcom/clevertap/android/sdk/LocalDataStore;)V", "matchEvent", "", Constants.INAPP_WHEN_TRIGGERS, "", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerAdapter;", "event", "Lcom/clevertap/android/sdk/inapp/evaluation/EventAdapter;", "match", "trigger", "match$clevertap_core_release", "matchFirstTimeOnly", "matchPropertyConditions", "triggerAdapter", "matchChargedItemConditions", "matchGeoRadius", "matchGeoRadius$clevertap_core_release", "evaluate", "op", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerOperator;", "expected", "Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;", "actual", "evaluate$clevertap_core_release", "evaluateDistance", Constants.KEY_RADIUS, "", "Landroid/location/Location;", "evaluateDistance$clevertap_core_release", "expectedValueEqualsActual", "expectedValueEqualsActual$clevertap_core_release", "expectedValueLessThanGreaterThanActual", "isLessThan", "expectedValueLessThanGreaterThanActual$clevertap_core_release", "actualContainsExpected", "actualContainsExpected$clevertap_core_release", "actualIsInRangeOfExpected", "actualIsInRangeOfExpected$clevertap_core_release", "checkGivenElementEqualsAnyElementInList", "list", "elementToCheckForEquality", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TriggersMatcher {
    private final LocalDataStore localDataStore;

    /* JADX INFO: compiled from: TriggersMatcher.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TriggerOperator.values().length];
            try {
                iArr[TriggerOperator.Set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TriggerOperator.LessThan.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TriggerOperator.GreaterThan.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TriggerOperator.Equals.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TriggerOperator.NotEquals.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TriggerOperator.Between.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TriggerOperator.Contains.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TriggerOperator.NotContains.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TriggerOperator.NotSet.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TriggersMatcher(LocalDataStore localDataStore) {
        Intrinsics.checkNotNullParameter(localDataStore, "localDataStore");
        this.localDataStore = localDataStore;
    }

    public final boolean matchEvent(List<TriggerAdapter> whenTriggers, EventAdapter event) {
        Intrinsics.checkNotNullParameter(whenTriggers, "whenTriggers");
        Intrinsics.checkNotNullParameter(event, "event");
        List<TriggerAdapter> list = whenTriggers;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (match$clevertap_core_release((TriggerAdapter) it.next(), event)) {
                return true;
            }
        }
        return false;
    }

    public final boolean match$clevertap_core_release(TriggerAdapter trigger, EventAdapter event) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(event, "event");
        if ((!Utils.areNamesNormalizedEqual(event.getEventName(), trigger.getEventName()) && (event.getProfileAttrName() == null || !Utils.areNamesNormalizedEqual(event.getProfileAttrName(), trigger.getProfileAttrName()))) || !matchPropertyConditions(trigger, event) || !matchFirstTimeOnly(trigger)) {
            return false;
        }
        if (!event.isChargedEvent() || matchChargedItemConditions(trigger, event)) {
            return trigger.getGeoRadiusCount() <= 0 || matchGeoRadius$clevertap_core_release(event, trigger);
        }
        return false;
    }

    private final boolean matchFirstTimeOnly(TriggerAdapter trigger) {
        if (!trigger.getFirstTimeOnly()) {
            return true;
        }
        String profileAttrName = trigger.getProfileAttrName();
        if (profileAttrName == null) {
            profileAttrName = trigger.getEventName();
        }
        return this.localDataStore.isUserEventLogFirstTime(profileAttrName);
    }

    private final boolean matchPropertyConditions(TriggerAdapter triggerAdapter, EventAdapter event) {
        IntRange intRangeUntil = RangesKt.until(0, triggerAdapter.getPropertyCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            TriggerCondition triggerConditionPropertyAtIndex = triggerAdapter.propertyAtIndex(((IntIterator) it).nextInt());
            if (triggerConditionPropertyAtIndex != null) {
                arrayList.add(triggerConditionPropertyAtIndex);
            }
        }
        ArrayList<TriggerCondition> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return true;
        }
        for (TriggerCondition triggerCondition : arrayList2) {
            if (!evaluate$clevertap_core_release(triggerCondition.getOp(), triggerCondition.getValue(), event.getPropertyValue(triggerCondition.getPropertyName()))) {
                return false;
            }
        }
        return true;
    }

    private final boolean matchChargedItemConditions(TriggerAdapter trigger, EventAdapter event) {
        IntRange intRangeUntil = RangesKt.until(0, trigger.getItemsCount());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            TriggerCondition triggerConditionItemAtIndex = trigger.itemAtIndex(((IntIterator) it).nextInt());
            if (triggerConditionItemAtIndex != null) {
                arrayList.add(triggerConditionItemAtIndex);
            }
        }
        ArrayList<TriggerCondition> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return true;
        }
        for (TriggerCondition triggerCondition : arrayList2) {
            List<TriggerValue> itemValue = event.getItemValue(triggerCondition.getPropertyName());
            if (!(itemValue instanceof Collection) || !itemValue.isEmpty()) {
                Iterator<T> it2 = itemValue.iterator();
                while (it2.hasNext()) {
                    if (evaluate$clevertap_core_release(triggerCondition.getOp(), triggerCondition.getValue(), (TriggerValue) it2.next())) {
                        break;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean matchGeoRadius$clevertap_core_release(EventAdapter event, TriggerAdapter trigger) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        if (event.getUserLocation() != null && CTXtensions.isValid(event.getUserLocation())) {
            int geoRadiusCount = trigger.getGeoRadiusCount();
            for (int i = 0; i < geoRadiusCount; i++) {
                TriggerGeoRadius triggerGeoRadiusGeoRadiusAtIndex = trigger.geoRadiusAtIndex(i);
                Location location = new Location("");
                Intrinsics.checkNotNull(triggerGeoRadiusGeoRadiusAtIndex);
                location.setLatitude(triggerGeoRadiusGeoRadiusAtIndex.getLatitude());
                location.setLongitude(triggerGeoRadiusGeoRadiusAtIndex.getLongitude());
                try {
                } catch (Exception e2) {
                    Logger.d("Error matching GeoRadius triggers for event named " + event.getEventName() + ". Reason: " + e2.getLocalizedMessage());
                }
                if (evaluateDistance$clevertap_core_release(triggerGeoRadiusGeoRadiusAtIndex.getRadius(), location, event.getUserLocation())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean evaluate$clevertap_core_release(TriggerOperator op, TriggerValue expected, TriggerValue actual) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        if (actual.getValue() == null) {
            return op == TriggerOperator.NotSet;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[op.ordinal()]) {
            case 1:
                return true;
            case 2:
                return expectedValueLessThanGreaterThanActual$clevertap_core_release(expected, actual, true);
            case 3:
                return expectedValueLessThanGreaterThanActual$clevertap_core_release(expected, actual, false);
            case 4:
                return expectedValueEqualsActual$clevertap_core_release(expected, actual);
            case 5:
                return !expectedValueEqualsActual$clevertap_core_release(expected, actual);
            case 6:
                return actualIsInRangeOfExpected$clevertap_core_release(expected, actual);
            case 7:
                return actualContainsExpected$clevertap_core_release(expected, actual);
            case 8:
                return !actualContainsExpected$clevertap_core_release(expected, actual);
            case 9:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean evaluateDistance$clevertap_core_release(double radius, Location expected, Location actual) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        return Utils.haversineDistance(expected, actual) <= radius;
    }

    public final boolean expectedValueEqualsActual$clevertap_core_release(TriggerValue expected, TriggerValue actual) {
        Double doubleOrNull;
        double dDoubleValue;
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        if (expected.isList() && actual.isList()) {
            List<?> listListValueWithCleanedStringIfPresent = expected.listValueWithCleanedStringIfPresent();
            Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent);
            HashSet hashSet = CollectionsKt.toHashSet(listListValueWithCleanedStringIfPresent);
            List<?> listListValueWithCleanedStringIfPresent2 = actual.listValueWithCleanedStringIfPresent();
            Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent2);
            return Intrinsics.areEqual(hashSet, CollectionsKt.toHashSet(listListValueWithCleanedStringIfPresent2));
        }
        if (actual.isList()) {
            List<?> listListValueWithCleanedStringIfPresent3 = actual.listValueWithCleanedStringIfPresent();
            Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent3);
            return checkGivenElementEqualsAnyElementInList(listListValueWithCleanedStringIfPresent3, expected.getValue());
        }
        if (expected.isList()) {
            List<?> listListValueWithCleanedStringIfPresent4 = expected.listValueWithCleanedStringIfPresent();
            Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent4);
            return checkGivenElementEqualsAnyElementInList(listListValueWithCleanedStringIfPresent4, actual.getValue());
        }
        if (expected.getNumberValue() != null) {
            Number numberValue = actual.getNumberValue();
            if (numberValue == null) {
                String stringValueCleaned = actual.getStringValueCleaned();
                Double doubleOrNull2 = stringValueCleaned != null ? StringsKt.toDoubleOrNull(stringValueCleaned) : null;
                if (doubleOrNull2 != null) {
                    dDoubleValue = doubleOrNull2.doubleValue();
                }
            }
            dDoubleValue = numberValue.doubleValue();
            Number numberValue2 = expected.getNumberValue();
            Intrinsics.checkNotNull(numberValue2);
            return numberValue2.doubleValue() == dDoubleValue;
        }
        if (actual.getNumberValue() != null) {
            String stringValueCleaned2 = expected.getStringValueCleaned();
            if (stringValueCleaned2 != null && (doubleOrNull = StringsKt.toDoubleOrNull(stringValueCleaned2)) != null) {
                double dDoubleValue2 = doubleOrNull.doubleValue();
                Number numberValue3 = actual.getNumberValue();
                Intrinsics.checkNotNull(numberValue3);
                if (numberValue3.doubleValue() == dDoubleValue2) {
                    return true;
                }
            }
            return false;
        }
        if (actual.getStringValue() != null) {
            return Intrinsics.areEqual(expected.getStringValueCleaned(), actual.getStringValueCleaned());
        }
        return false;
    }

    public final boolean expectedValueLessThanGreaterThanActual$clevertap_core_release(TriggerValue expected, TriggerValue actual, boolean isLessThan) {
        double dDoubleValue;
        double dDoubleValue2;
        Object objFirstOrNull;
        Double dValueOf;
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        Number numberValue = actual.getNumberValue();
        if (numberValue == null) {
            String stringValue = actual.getStringValue();
            Double doubleOrNull = stringValue != null ? StringsKt.toDoubleOrNull(stringValue) : null;
            if (doubleOrNull != null) {
                dDoubleValue = doubleOrNull.doubleValue();
            }
        }
        dDoubleValue = numberValue.doubleValue();
        List<?> listListValue = expected.listValue();
        if (listListValue != null && (objFirstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) listListValue)) != null) {
            if (objFirstOrNull instanceof String) {
                dValueOf = StringsKt.toDoubleOrNull((String) objFirstOrNull);
            } else {
                dValueOf = objFirstOrNull instanceof Number ? Double.valueOf(((Number) objFirstOrNull).doubleValue()) : null;
            }
            if (dValueOf != null) {
                double dDoubleValue3 = dValueOf.doubleValue();
                return isLessThan ? dDoubleValue < dDoubleValue3 : dDoubleValue > dDoubleValue3;
            }
        }
        Number numberValue2 = expected.getNumberValue();
        if (numberValue2 == null) {
            String stringValue2 = expected.getStringValue();
            Double doubleOrNull2 = stringValue2 != null ? StringsKt.toDoubleOrNull(stringValue2) : null;
            if (doubleOrNull2 != null) {
                dDoubleValue2 = doubleOrNull2.doubleValue();
            }
        }
        dDoubleValue2 = numberValue2.doubleValue();
        return isLessThan ? dDoubleValue < dDoubleValue2 : dDoubleValue > dDoubleValue2;
    }

    public final boolean actualContainsExpected$clevertap_core_release(TriggerValue expected, TriggerValue actual) {
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        if (actual.getStringValue() != null && expected.getStringValue() != null) {
            String stringValueCleaned = actual.getStringValueCleaned();
            Intrinsics.checkNotNull(stringValueCleaned);
            String stringValueCleaned2 = expected.getStringValueCleaned();
            Intrinsics.checkNotNull(stringValueCleaned2);
            return StringsKt.contains$default((CharSequence) stringValueCleaned, (CharSequence) stringValueCleaned2, false, 2, (Object) null);
        }
        if (!expected.isList() || actual.getStringValue() == null) {
            if (expected.isList() && actual.isList()) {
                List<?> listListValueWithCleanedStringIfPresent = actual.listValueWithCleanedStringIfPresent();
                Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent);
                ArrayList arrayList = new ArrayList();
                for (Object obj : listListValueWithCleanedStringIfPresent) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                Set set = CollectionsKt.toSet(arrayList);
                List<?> listListValueWithCleanedStringIfPresent2 = expected.listValueWithCleanedStringIfPresent();
                Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent2);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : listListValueWithCleanedStringIfPresent2) {
                    if (obj2 instanceof String) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
                    return false;
                }
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    if (set.contains((String) it.next())) {
                        return true;
                    }
                }
                return false;
            }
            if (!actual.isList() || expected.getStringValue() == null) {
                return false;
            }
            List<?> listListValueWithCleanedStringIfPresent3 = actual.listValueWithCleanedStringIfPresent();
            Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent3);
            ArrayList arrayList4 = new ArrayList();
            for (Object obj3 : listListValueWithCleanedStringIfPresent3) {
                if (obj3 instanceof String) {
                    arrayList4.add(obj3);
                }
            }
            return CollectionsKt.contains(CollectionsKt.toSet(arrayList4), expected.getStringValueCleaned());
        }
        List<?> listListValueWithCleanedStringIfPresent4 = expected.listValueWithCleanedStringIfPresent();
        Intrinsics.checkNotNull(listListValueWithCleanedStringIfPresent4);
        Sequence<String> sequenceFilter = SequencesKt.filter(SequencesKt.filterNotNull(CollectionsKt.asSequence(listListValueWithCleanedStringIfPresent4)), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$actualContainsExpected$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj4) {
                return Boolean.valueOf(obj4 instanceof String);
            }
        });
        Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        for (String str : sequenceFilter) {
            String stringValueCleaned3 = actual.getStringValueCleaned();
            Intrinsics.checkNotNull(stringValueCleaned3);
            if (StringsKt.contains$default((CharSequence) stringValueCleaned3, (CharSequence) str, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean actualIsInRangeOfExpected$clevertap_core_release(TriggerValue expected, TriggerValue actual) {
        List listTake;
        double dDoubleValue;
        Double dValueOf;
        Intrinsics.checkNotNullParameter(expected, "expected");
        Intrinsics.checkNotNullParameter(actual, "actual");
        List<?> listListValue = expected.listValue();
        if (listListValue != null) {
            if (listListValue.size() < 2) {
                listListValue = null;
            }
            if (listListValue != null && (listTake = CollectionsKt.take(listListValue, 2)) != null) {
                List list = listTake;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Object obj : list) {
                    if (obj instanceof String) {
                        dValueOf = StringsKt.toDoubleOrNull((String) obj);
                    } else {
                        dValueOf = obj instanceof Number ? Double.valueOf(((Number) obj).doubleValue()) : null;
                    }
                    arrayList.add(dValueOf);
                }
                ArrayList arrayList2 = arrayList;
                if (arrayList2.contains(null)) {
                    return false;
                }
                Number numberValue = actual.getNumberValue();
                if (numberValue != null) {
                    dDoubleValue = numberValue.doubleValue();
                } else {
                    String stringValue = actual.getStringValue();
                    Double doubleOrNull = stringValue != null ? StringsKt.toDoubleOrNull(stringValue) : null;
                    if (doubleOrNull != null) {
                        dDoubleValue = doubleOrNull.doubleValue();
                    }
                }
                Object obj2 = arrayList2.get(0);
                Intrinsics.checkNotNull(obj2);
                double dDoubleValue2 = ((Number) obj2).doubleValue();
                Object obj3 = arrayList2.get(1);
                Intrinsics.checkNotNull(obj3);
                if (dDoubleValue <= ((Number) obj3).doubleValue() && dDoubleValue2 <= dDoubleValue) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkGivenElementEqualsAnyElementInList(List<?> list, Object elementToCheckForEquality) {
        if (elementToCheckForEquality instanceof String) {
            List<?> list2 = list;
            Sequence sequenceFilter = SequencesKt.filter(CollectionsKt.asSequence(list2), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$checkGivenElementEqualsAnyElementInList$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof String);
                }
            });
            Intrinsics.checkNotNull(sequenceFilter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it = sequenceFilter.iterator();
            while (true) {
                if (it.hasNext()) {
                    String str = (String) it.next();
                    String lowerCase = StringsKt.trim((CharSequence) elementToCheckForEquality).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (Intrinsics.areEqual(str, lowerCase)) {
                        break;
                    }
                } else {
                    Sequence sequenceFilter2 = SequencesKt.filter(CollectionsKt.asSequence(list2), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$checkGivenElementEqualsAnyElementInList$$inlined$filterIsInstance$2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Object obj) {
                            return Boolean.valueOf(obj instanceof Number);
                        }
                    });
                    Intrinsics.checkNotNull(sequenceFilter2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
                    Iterator it2 = sequenceFilter2.iterator();
                    while (it2.hasNext()) {
                        double dDoubleValue = ((Number) it2.next()).doubleValue();
                        String lowerCase2 = StringsKt.trim((CharSequence) elementToCheckForEquality).toString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        if (Intrinsics.areEqual(dDoubleValue, StringsKt.toDoubleOrNull(lowerCase2))) {
                        }
                    }
                    return false;
                }
            }
            return true;
        }
        if (elementToCheckForEquality instanceof Number) {
            double dDoubleValue2 = ((Number) elementToCheckForEquality).doubleValue();
            List<?> list3 = list;
            Sequence sequenceFilter3 = SequencesKt.filter(CollectionsKt.asSequence(list3), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$checkGivenElementEqualsAnyElementInList$$inlined$filterIsInstance$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof Number);
                }
            });
            Intrinsics.checkNotNull(sequenceFilter3, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it3 = sequenceFilter3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    Sequence sequenceFilter4 = SequencesKt.filter(CollectionsKt.asSequence(list3), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$checkGivenElementEqualsAnyElementInList$$inlined$filterIsInstance$4
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Object obj) {
                            return Boolean.valueOf(obj instanceof String);
                        }
                    });
                    Intrinsics.checkNotNull(sequenceFilter4, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
                    Iterator it4 = sequenceFilter4.iterator();
                    while (it4.hasNext()) {
                        String lowerCase3 = StringsKt.trim((CharSequence) it4.next()).toString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                        if (Intrinsics.areEqual(StringsKt.toDoubleOrNull(lowerCase3), dDoubleValue2)) {
                        }
                    }
                    return false;
                }
                if (((Number) it3.next()).doubleValue() == dDoubleValue2) {
                    break;
                }
            }
            return true;
        }
        if (elementToCheckForEquality instanceof Boolean) {
            Sequence sequenceFilter5 = SequencesKt.filter(CollectionsKt.asSequence(list), new Function1<Object, Boolean>() { // from class: com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher$checkGivenElementEqualsAnyElementInList$$inlined$filterIsInstance$5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object obj) {
                    return Boolean.valueOf(obj instanceof String);
                }
            });
            Intrinsics.checkNotNull(sequenceFilter5, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            Iterator it5 = sequenceFilter5.iterator();
            while (it5.hasNext()) {
                if (Intrinsics.areEqual((String) it5.next(), String.valueOf(((Boolean) elementToCheckForEquality).booleanValue()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
