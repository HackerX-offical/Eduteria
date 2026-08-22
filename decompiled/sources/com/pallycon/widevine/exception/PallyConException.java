package com.pallycon.widevine.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\t\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u001f\b\u0004\u0012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u0007R\u0019\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0001\t\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "getE", "()Ljava/lang/Exception;", "getMsg", "()Ljava/lang/String;", "message", "ClearKeyLicenseException", "ContentDataException", "DetectedDeviceTimeModifiedException", "DownloadException", "DrmException", "MigrationException", "MigrationLocalPathException", "NetworkConnectedException", "PallyConLicenseCipherException", "Lcom/pallycon/widevine/exception/PallyConException$ClearKeyLicenseException;", "Lcom/pallycon/widevine/exception/PallyConException$ContentDataException;", "Lcom/pallycon/widevine/exception/PallyConException$DetectedDeviceTimeModifiedException;", "Lcom/pallycon/widevine/exception/PallyConException$DownloadException;", "Lcom/pallycon/widevine/exception/PallyConException$DrmException;", "Lcom/pallycon/widevine/exception/PallyConException$MigrationException;", "Lcom/pallycon/widevine/exception/PallyConException$MigrationLocalPathException;", "Lcom/pallycon/widevine/exception/PallyConException$NetworkConnectedException;", "Lcom/pallycon/widevine/exception/PallyConException$PallyConLicenseCipherException;", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PallyConException extends RuntimeException {
    private final Exception e;
    private final String msg;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$ClearKeyLicenseException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClearKeyLicenseException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearKeyLicenseException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$ContentDataException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ContentDataException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentDataException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$DetectedDeviceTimeModifiedException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DetectedDeviceTimeModifiedException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DetectedDeviceTimeModifiedException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$DownloadException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DownloadException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$DrmException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DrmException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DrmException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$MigrationException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MigrationException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MigrationException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$MigrationLocalPathException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MigrationLocalPathException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MigrationLocalPathException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$NetworkConnectedException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NetworkConnectedException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkConnectedException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConException$PallyConLicenseCipherException;", "Lcom/pallycon/widevine/exception/PallyConException;", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PallyConLicenseCipherException extends PallyConException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PallyConLicenseCipherException(Exception exc, String msg) {
            super(exc, msg, null);
            Intrinsics.checkNotNullParameter(msg, "msg");
        }
    }

    public /* synthetic */ PallyConException(Exception exc, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(exc, str);
    }

    public final Exception getE() {
        return this.e;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String message() {
        String message = getMessage();
        return message == null ? this.msg : message;
    }

    private PallyConException(Exception exc, String str) {
        this.e = exc;
        this.msg = str;
    }
}
