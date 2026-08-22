package info.mqtt.android.service.room.entity;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PingEntity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Linfo/mqtt/android/service/room/entity/PingEntity;", "", "timestamp", "", "clientId", "", "serverURI", "success", "", "message", "<init>", "(JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getTimestamp", "()J", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "getServerURI", "setServerURI", "getSuccess", "()Z", "getMessage", "setMessage", "component1", "component2", "component3", "component4", "component5", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PingEntity {
    private String clientId;
    private String message;
    private String serverURI;
    private final boolean success;
    private final long timestamp;

    public static /* synthetic */ PingEntity copy$default(PingEntity pingEntity, long j, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pingEntity.timestamp;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = pingEntity.clientId;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = pingEntity.serverURI;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            z = pingEntity.success;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str3 = pingEntity.message;
        }
        return pingEntity.copy(j2, str4, str5, z2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getServerURI() {
        return this.serverURI;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final PingEntity copy(long timestamp, String clientId, String serverURI, boolean success, String message) {
        return new PingEntity(timestamp, clientId, serverURI, success, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PingEntity)) {
            return false;
        }
        PingEntity pingEntity = (PingEntity) other;
        return this.timestamp == pingEntity.timestamp && Intrinsics.areEqual(this.clientId, pingEntity.clientId) && Intrinsics.areEqual(this.serverURI, pingEntity.serverURI) && this.success == pingEntity.success && Intrinsics.areEqual(this.message, pingEntity.message);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.timestamp) * 31;
        String str = this.clientId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.serverURI;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.success)) * 31;
        String str3 = this.message;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PingEntity(timestamp=" + this.timestamp + ", clientId=" + this.clientId + ", serverURI=" + this.serverURI + ", success=" + this.success + ", message=" + this.message + ")";
    }

    public PingEntity(long j, String str, String str2, boolean z, String str3) {
        this.timestamp = j;
        this.clientId = str;
        this.serverURI = str2;
        this.success = z;
        this.message = str3;
    }

    public /* synthetic */ PingEntity(long j, String str, String str2, boolean z, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, z, (i & 16) != 0 ? null : str3);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final String getServerURI() {
        return this.serverURI;
    }

    public final void setServerURI(String str) {
        this.serverURI = str;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
