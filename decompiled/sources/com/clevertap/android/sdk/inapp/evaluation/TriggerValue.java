package com.clevertap.android.sdk.inapp.evaluation;

import com.clevertap.android.sdk.variables.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: compiled from: TriggerValue.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004J\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/inapp/evaluation/TriggerValue;", "", "value", "listValue", "", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "getValue", "()Ljava/lang/Object;", "stringValue", "", "stringValueCleaned", "listValueWithCleanedStringIfPresent", "numberValue", "", "isList", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TriggerValue {
    private List<? extends Object> listValue;
    private List<? extends Object> listValueWithCleanedStringIfPresent;
    private Number numberValue;
    private String stringValue;
    private String stringValueCleaned;
    private final Object value;

    /* JADX WARN: Multi-variable type inference failed */
    public TriggerValue() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public TriggerValue(Object obj, List<? extends Object> list) {
        ArrayList arrayList;
        this.value = obj;
        this.listValue = list;
        if (obj instanceof String) {
            this.stringValue = (String) obj;
            String lowerCase = StringsKt.trim((CharSequence) obj).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            this.stringValueCleaned = lowerCase;
            return;
        }
        if (obj instanceof Boolean) {
            this.stringValue = String.valueOf(((Boolean) obj).booleanValue());
            String lowerCase2 = StringsKt.trim((CharSequence) String.valueOf(((Boolean) obj).booleanValue())).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            this.stringValueCleaned = lowerCase2;
            return;
        }
        if (obj instanceof Number) {
            this.numberValue = (Number) obj;
            return;
        }
        if (obj instanceof List) {
            this.listValue = (List) obj;
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object lowerCase3 : iterable) {
                if (lowerCase3 instanceof String) {
                    lowerCase3 = StringsKt.trim((CharSequence) lowerCase3).toString().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                }
                arrayList2.add(lowerCase3);
            }
            this.listValueWithCleanedStringIfPresent = arrayList2;
            return;
        }
        if (obj instanceof JSONArray) {
            List<? extends Object> listListFromJson = JsonUtil.listFromJson((JSONArray) obj);
            this.listValue = listListFromJson;
            if (listListFromJson != null) {
                List<? extends Object> list2 = listListFromJson;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Object lowerCase4 : list2) {
                    if (lowerCase4 instanceof String) {
                        lowerCase4 = StringsKt.trim((CharSequence) lowerCase4).toString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    }
                    arrayList3.add(lowerCase4);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            this.listValueWithCleanedStringIfPresent = arrayList;
        }
    }

    public /* synthetic */ TriggerValue(Object obj, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : list);
    }

    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: numberValue, reason: from getter */
    public final Number getNumberValue() {
        return this.numberValue;
    }

    /* JADX INFO: renamed from: stringValue, reason: from getter */
    public final String getStringValue() {
        return this.stringValue;
    }

    /* JADX INFO: renamed from: stringValueCleaned, reason: from getter */
    public final String getStringValueCleaned() {
        return this.stringValueCleaned;
    }

    public final List<?> listValue() {
        return this.listValue;
    }

    public final List<?> listValueWithCleanedStringIfPresent() {
        return this.listValueWithCleanedStringIfPresent;
    }

    public final boolean isList() {
        return this.listValue != null;
    }
}
