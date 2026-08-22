package com.google.firebase.database;

import com.google.firebase.database.core.ServerValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class ServerValue {
    public static final Map<String, String> TIMESTAMP = createServerValuePlaceholder("timestamp");

    private static Map<String, String> createServerValuePlaceholder(String str) {
        HashMap map = new HashMap();
        map.put(ServerValues.NAME_SUBKEY_SERVERVALUE, str);
        return Collections.unmodifiableMap(map);
    }
}
