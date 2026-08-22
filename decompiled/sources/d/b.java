package d;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ4\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001a\u0010\n¨\u0006\u001b"}, d2 = {"Ld/b;", "", "", "body", "", "errorCode", "message", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "a", "()Ljava/lang/String;", "b", "()Ljava/lang/Integer;", "c", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ld/b;", InAppPurchaseConstants.METHOD_TO_STRING, "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "d", "Ljava/lang/Integer;", "e", "f", "widevine_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @SerializedName("body")
    private final String body;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    @SerializedName("errorCode")
    private final Integer errorCode;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    @SerializedName("message")
    private final String message;

    public b(String str, Integer num, String str2) {
        this.body = str;
        this.errorCode = num;
        this.message = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final String d() {
        return this.body;
    }

    public final Integer e() {
        return this.errorCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        return Intrinsics.areEqual(this.body, bVar.body) && Intrinsics.areEqual(this.errorCode, bVar.errorCode) && Intrinsics.areEqual(this.message, bVar.message);
    }

    public final String f() {
        return this.message;
    }

    public int hashCode() {
        String str = this.body;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.errorCode;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PallyConLicenseServerError(body=" + this.body + ", errorCode=" + this.errorCode + ", message=" + this.message + ')';
    }

    public final b a(String body, Integer errorCode, String message) {
        return new b(body, errorCode, message);
    }

    public static /* synthetic */ b a(b bVar, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bVar.body;
        }
        if ((i & 2) != 0) {
            num = bVar.errorCode;
        }
        if ((i & 4) != 0) {
            str2 = bVar.message;
        }
        return bVar.a(str, num, str2);
    }
}
