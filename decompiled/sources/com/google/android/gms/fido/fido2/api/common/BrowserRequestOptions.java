package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BrowserRequestOptions extends RequestOptions {
    public abstract byte[] getClientDataHash();

    public abstract Uri getOrigin();
}
