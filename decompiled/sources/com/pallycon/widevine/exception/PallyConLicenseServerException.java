package com.pallycon.widevine.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/pallycon/widevine/exception/PallyConLicenseServerException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "body", "", "errorCode", "", "message", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PallyConLicenseServerException extends RuntimeException {
    private final String body;
    private final int errorCode;
    private final String message;

    public PallyConLicenseServerException(String body, int i, String str) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
        this.errorCode = i;
        this.message = str;
    }

    /* JADX INFO: renamed from: body, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* JADX INFO: renamed from: errorCode, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final String message() {
        String message = getMessage();
        return message == null ? "" : message;
    }
}
