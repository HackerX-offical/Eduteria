package com.google.firebase.database.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public class GAuthToken {
    private static final String AUTH_KEY = "auth";
    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX = "gauth|";
    private final Map<String, Object> auth;
    private final String token;

    public GAuthToken(String str, Map<String, Object> map) {
        this.token = str;
        this.auth = map;
    }

    public static GAuthToken tryParseFromString(String str) {
        if (!str.startsWith(TOKEN_PREFIX)) {
            return null;
        }
        try {
            Map<String, Object> json = JsonMapper.parseJson(str.substring(TOKEN_PREFIX.length()));
            return new GAuthToken((String) json.get("token"), (Map) json.get("auth"));
        } catch (IOException e2) {
            throw new RuntimeException("Failed to parse gauth token", e2);
        }
    }

    public String serializeToString() {
        HashMap map = new HashMap();
        map.put("token", this.token);
        map.put("auth", this.auth);
        try {
            return TOKEN_PREFIX + JsonMapper.serializeJson(map);
        } catch (IOException e2) {
            throw new RuntimeException("Failed to serialize gauth token", e2);
        }
    }

    public String getToken() {
        return this.token;
    }

    public Map<String, Object> getAuth() {
        return this.auth;
    }
}
