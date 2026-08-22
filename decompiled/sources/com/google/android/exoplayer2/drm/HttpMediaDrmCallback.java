package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    private static final int MAX_MANUAL_REDIRECTS = 5;
    private final HttpDataSource.Factory dataSourceFactory;
    private final String defaultLicenseUrl;
    private final boolean forceDefaultLicenseUrl;
    private final Map<String, String> keyRequestProperties;

    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
    }

    public HttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        Assertions.checkArgument((z && TextUtils.isEmpty(str)) ? false : true);
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z;
        this.keyRequestProperties = new HashMap();
    }

    public void setKeyRequestProperty(String str, String str2) {
        Assertions.checkNotNull(str);
        Assertions.checkNotNull(str2);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.put(str, str2);
        }
    }

    public void clearKeyRequestProperty(String str) {
        Assertions.checkNotNull(str);
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.remove(str);
        }
    }

    public void clearAllKeyRequestProperties() {
        synchronized (this.keyRequestProperties) {
            this.keyRequestProperties.clear();
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException {
        String defaultUrl = provisionRequest.getDefaultUrl();
        String strFromUtf8Bytes = Util.fromUtf8Bytes(provisionRequest.getData());
        return executePost(this.dataSourceFactory, new StringBuilder(String.valueOf(defaultUrl).length() + 15 + String.valueOf(strFromUtf8Bytes).length()).append(defaultUrl).append("&signedRequest=").append(strFromUtf8Bytes).toString(), null, Collections.emptyMap());
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException {
        String str;
        String licenseServerUrl = keyRequest.getLicenseServerUrl();
        if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(licenseServerUrl)) {
            licenseServerUrl = this.defaultLicenseUrl;
        }
        if (TextUtils.isEmpty(licenseServerUrl)) {
            throw new MediaDrmCallbackException(new DataSpec.Builder().setUri(Uri.EMPTY).build(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        if (C.PLAYREADY_UUID.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
        }
        map.put("Content-Type", str);
        if (C.PLAYREADY_UUID.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.keyRequestProperties) {
            map.putAll(this.keyRequestProperties);
        }
        return executePost(this.dataSourceFactory, licenseServerUrl, keyRequest.getData(), map);
    }

    private static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        StatsDataSource statsDataSource = new StatsDataSource(factory.createDataSource());
        DataSpec dataSpecBuild = new DataSpec.Builder().setUri(str).setHttpRequestHeaders(map).setHttpMethod(2).setHttpBody(bArr).setFlags(1).build();
        int i = 0;
        DataSpec dataSpecBuild2 = dataSpecBuild;
        while (true) {
            try {
                DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(statsDataSource, dataSpecBuild2);
                try {
                    try {
                        byte[] byteArray = Util.toByteArray(dataSourceInputStream);
                        Util.closeQuietly(dataSourceInputStream);
                        return byteArray;
                    } catch (HttpDataSource.InvalidResponseCodeException e2) {
                        String redirectUrl = getRedirectUrl(e2, i);
                        if (redirectUrl == null) {
                            throw e2;
                        }
                        i++;
                        dataSpecBuild2 = dataSpecBuild2.buildUpon().setUri(redirectUrl).build();
                        Util.closeQuietly(dataSourceInputStream);
                    }
                } catch (Throwable th) {
                    Util.closeQuietly(dataSourceInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                throw new MediaDrmCallbackException(dataSpecBuild, (Uri) Assertions.checkNotNull(statsDataSource.getLastOpenedUri()), statsDataSource.getResponseHeaders(), statsDataSource.getBytesRead(), e3);
            }
        }
    }

    private static String getRedirectUrl(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i) {
        Map<String, List<String>> map;
        List<String> list;
        if ((invalidResponseCodeException.responseCode != 307 && invalidResponseCodeException.responseCode != 308) || i >= 5 || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
