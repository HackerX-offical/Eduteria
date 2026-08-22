package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.params.HttpParams;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
