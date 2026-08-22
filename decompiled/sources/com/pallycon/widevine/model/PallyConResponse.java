package com.pallycon.widevine.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.paytm.pgsdk.Constants;
import d.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/pallycon/widevine/model/PallyConResponse;", "", "()V", Constants.EVENT_ACTION_ERROR, "License", "RawData", "Lcom/pallycon/widevine/model/PallyConResponse$Error;", "Lcom/pallycon/widevine/model/PallyConResponse$License;", "Lcom/pallycon/widevine/model/PallyConResponse$RawData;", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PallyConResponse {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/pallycon/widevine/model/PallyConResponse$Error;", "Lcom/pallycon/widevine/model/PallyConResponse;", "Ld/b;", "error", "<init>", "(Ld/b;)V", "component1", "()Ld/b;", com.clevertap.android.sdk.Constants.COPY_TYPE, "(Ld/b;)Lcom/pallycon/widevine/model/PallyConResponse$Error;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ld/b;", "getError", "widevine_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class Error extends PallyConResponse {
        private final b error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(b error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, b bVar, int i, Object obj) {
            if ((i & 1) != 0) {
                bVar = error.error;
            }
            return error.copy(bVar);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final b getError() {
            return this.error;
        }

        public final Error copy(b error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
        }

        public final b getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/pallycon/widevine/model/PallyConResponse$License;", "Lcom/pallycon/widevine/model/PallyConResponse;", "license", "Lcom/pallycon/widevine/model/PallyConLicenseResponse;", "(Lcom/pallycon/widevine/model/PallyConLicenseResponse;)V", "getLicense", "()Lcom/pallycon/widevine/model/PallyConLicenseResponse;", "component1", com.clevertap.android.sdk.Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class License extends PallyConResponse {
        private final PallyConLicenseResponse license;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public License(PallyConLicenseResponse license) {
            super(null);
            Intrinsics.checkNotNullParameter(license, "license");
            this.license = license;
        }

        public static /* synthetic */ License copy$default(License license, PallyConLicenseResponse pallyConLicenseResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                pallyConLicenseResponse = license.license;
            }
            return license.copy(pallyConLicenseResponse);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PallyConLicenseResponse getLicense() {
            return this.license;
        }

        public final License copy(PallyConLicenseResponse license) {
            Intrinsics.checkNotNullParameter(license, "license");
            return new License(license);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof License) && Intrinsics.areEqual(this.license, ((License) other).license);
        }

        public final PallyConLicenseResponse getLicense() {
            return this.license;
        }

        public int hashCode() {
            return this.license.hashCode();
        }

        public String toString() {
            return "License(license=" + this.license + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/pallycon/widevine/model/PallyConResponse$RawData;", "Lcom/pallycon/widevine/model/PallyConResponse;", "data", "", "([B)V", "getData", "()[B", "component1", com.clevertap.android.sdk.Constants.COPY_TYPE, "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class RawData extends PallyConResponse {
        private final byte[] data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RawData(byte[] data) {
            super(null);
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public static /* synthetic */ RawData copy$default(RawData rawData, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = rawData.data;
            }
            return rawData.copy(bArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final byte[] getData() {
            return this.data;
        }

        public final RawData copy(byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new RawData(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RawData) && Intrinsics.areEqual(this.data, ((RawData) other).data);
        }

        public final byte[] getData() {
            return this.data;
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }

        public String toString() {
            return "RawData(data=" + Arrays.toString(this.data) + ')';
        }
    }

    public /* synthetic */ PallyConResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PallyConResponse() {
    }
}
