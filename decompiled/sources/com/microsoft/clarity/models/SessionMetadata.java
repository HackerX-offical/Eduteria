package com.microsoft.clarity.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001d\u001a\u00020\u0003R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/microsoft/clarity/models/SessionMetadata;", "", "version", "", "projectId", "userId", "sessionId", "timestamp", "", "localStorageVersion", "", "leanSession", "", "ingestUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIZLjava/lang/String;)V", "getIngestUrl", "()Ljava/lang/String;", "getLeanSession", "()Z", "getLocalStorageVersion", "()I", "getProjectId", "getSessionId", "getTimestamp", "()J", "getUserId", "setUserId", "(Ljava/lang/String;)V", "getVersion", "toJson", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SessionMetadata {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String ingestUrl;
    private final boolean leanSession;
    private final int localStorageVersion;
    private final String projectId;
    private final String sessionId;
    private final long timestamp;
    private String userId;
    private final String version;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/SessionMetadata$Companion;", "", "()V", "fromJson", "Lcom/microsoft/clarity/models/SessionMetadata;", "serialized", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionMetadata fromJson(String serialized) throws JSONException {
            Intrinsics.checkNotNullParameter(serialized, "serialized");
            JSONObject jSONObject = new JSONObject(serialized);
            String string = jSONObject.getString("version");
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"version\")");
            String string2 = jSONObject.getString("projectId");
            Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"projectId\")");
            String string3 = jSONObject.getString("userId");
            Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"userId\")");
            String string4 = jSONObject.getString("sessionId");
            Intrinsics.checkNotNullExpressionValue(string4, "json.getString(\"sessionId\")");
            long j = jSONObject.getLong("timestamp");
            int i = jSONObject.getInt("localStorageVersion");
            boolean z = jSONObject.getBoolean("leanSession");
            String string5 = jSONObject.getString("ingestUrl");
            Intrinsics.checkNotNullExpressionValue(string5, "json.getString(\"ingestUrl\")");
            return new SessionMetadata(string, string2, string3, string4, j, i, z, string5);
        }
    }

    public SessionMetadata(String version, String projectId, String userId, String sessionId, long j, int i, boolean z, String ingestUrl) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(projectId, "projectId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(ingestUrl, "ingestUrl");
        this.version = version;
        this.projectId = projectId;
        this.userId = userId;
        this.sessionId = sessionId;
        this.timestamp = j;
        this.localStorageVersion = i;
        this.leanSession = z;
        this.ingestUrl = ingestUrl;
    }

    public final String getIngestUrl() {
        return this.ingestUrl;
    }

    public final boolean getLeanSession() {
        return this.leanSession;
    }

    public final int getLocalStorageVersion() {
        return this.localStorageVersion;
    }

    public final String getProjectId() {
        return this.projectId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", this.version);
        jSONObject.put("projectId", this.projectId);
        jSONObject.put("userId", this.userId);
        jSONObject.put("sessionId", this.sessionId);
        jSONObject.put("timestamp", this.timestamp);
        jSONObject.put("localStorageVersion", this.localStorageVersion);
        jSONObject.put("leanSession", this.leanSession);
        jSONObject.put("ingestUrl", this.ingestUrl);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "json.toString()");
        return string;
    }
}
