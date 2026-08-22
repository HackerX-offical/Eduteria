package com.microsoft.clarity.n;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class k {
    public static String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(string, "\\", "\\\\", false, 4, (Object) null), "\"", "\\\"", false, 4, (Object) null), "\r\n", " ", false, 4, (Object) null), "\n", " ", false, 4, (Object) null);
    }

    public static LinkedHashMap a(JSONObject jsonObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jsonObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "jsonObject.keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            Object obj = jsonObject.get(key);
            Intrinsics.checkNotNullExpressionValue(obj, "jsonObject.get(key)");
            linkedHashMap.put(key, obj);
        }
        return linkedHashMap;
    }

    public static Set a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }
}
