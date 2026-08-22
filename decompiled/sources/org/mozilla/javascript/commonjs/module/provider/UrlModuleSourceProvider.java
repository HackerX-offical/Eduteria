package org.mozilla.javascript.commonjs.module.provider;

import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class UrlModuleSourceProvider extends ModuleSourceProviderBase {
    private static final long serialVersionUID = 1;
    private final Iterable<URI> fallbackUris;
    private final Iterable<URI> privilegedUris;
    private final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator;
    private final UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider;

    protected void onFailedClosingUrlConnection(URLConnection uRLConnection, IOException iOException) {
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2) {
        this(iterable, iterable2, new DefaultUrlConnectionExpiryCalculator(), null);
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator, UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider) {
        this.privilegedUris = iterable;
        this.fallbackUris = iterable2;
        this.urlConnectionExpiryCalculator = urlConnectionExpiryCalculator;
        this.urlConnectionSecurityDomainProvider = urlConnectionSecurityDomainProvider;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromPrivilegedLocations(String str, Object obj) throws URISyntaxException, IOException {
        return loadFromPathList(str, obj, this.privilegedUris);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromFallbackLocations(String str, Object obj) throws URISyntaxException, IOException {
        return loadFromPathList(str, obj, this.fallbackUris);
    }

    private ModuleSource loadFromPathList(String str, Object obj, Iterable<URI> iterable) throws URISyntaxException, IOException {
        if (iterable == null) {
            return null;
        }
        for (URI uri : iterable) {
            ModuleSource moduleSourceLoadFromUri = loadFromUri(uri.resolve(str), uri, obj);
            if (moduleSourceLoadFromUri != null) {
                return moduleSourceLoadFromUri;
            }
        }
        return null;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromUri(URI uri, URI uri2, Object obj) throws URISyntaxException, IOException {
        ModuleSource moduleSourceLoadFromActualUri = loadFromActualUri(new URI(uri + ".js"), uri2, obj);
        return moduleSourceLoadFromActualUri != null ? moduleSourceLoadFromActualUri : loadFromActualUri(uri, uri2, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.mozilla.javascript.commonjs.module.provider.ModuleSource loadFromActualUri(java.net.URI r18, java.net.URI r19, java.lang.Object r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            java.net.URL r2 = new java.net.URL
            r3 = 0
            if (r19 != 0) goto Lb
            r4 = r3
            goto Lf
        Lb:
            java.net.URL r4 = r19.toURL()
        Lf:
            java.lang.String r5 = r18.toString()
            r2.<init>(r4, r5)
            long r9 = java.lang.System.currentTimeMillis()
            java.net.URLConnection r8 = r1.openUrlConnection(r2)
            boolean r2 = r0 instanceof org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.URLValidator
            if (r2 == 0) goto L2d
            org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator r0 = (org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.URLValidator) r0
            r14 = r18
            boolean r2 = r0.appliesTo(r14)
            if (r2 == 0) goto L2f
            goto L30
        L2d:
            r14 = r18
        L2f:
            r0 = r3
        L30:
            if (r0 == 0) goto L35
            r0.applyConditionals(r8)
        L35:
            r8.connect()     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            if (r0 == 0) goto L48
            org.mozilla.javascript.commonjs.module.provider.UrlConnectionExpiryCalculator r2 = r1.urlConnectionExpiryCalculator     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            boolean r0 = r0.updateValidator(r8, r9, r2)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            if (r0 == 0) goto L48
            r1.close(r8)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            org.mozilla.javascript.commonjs.module.provider.ModuleSource r0 = org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.NOT_MODIFIED     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            return r0
        L48:
            org.mozilla.javascript.commonjs.module.provider.ModuleSource r0 = new org.mozilla.javascript.commonjs.module.provider.ModuleSource     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            java.io.Reader r12 = getReader(r8)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            java.lang.Object r13 = r1.getSecurityDomain(r8)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator r16 = new org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            org.mozilla.javascript.commonjs.module.provider.UrlConnectionExpiryCalculator r11 = r1.urlConnectionExpiryCalculator     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            r7 = r14
            r6 = r16
            r6.<init>(r7, r8, r9, r11)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            r14 = r18
            r15 = r19
            r11 = r0
            r16 = r6
            r11.<init>(r12, r13, r14, r15, r16)     // Catch: java.io.IOException -> L67 java.lang.RuntimeException -> L6c java.io.FileNotFoundException -> L71
            return r11
        L67:
            r0 = move-exception
            r1.close(r8)
            throw r0
        L6c:
            r0 = move-exception
            r1.close(r8)
            throw r0
        L71:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.loadFromActualUri(java.net.URI, java.net.URI, java.lang.Object):org.mozilla.javascript.commonjs.module.provider.ModuleSource");
    }

    private static Reader getReader(URLConnection uRLConnection) throws IOException {
        return new InputStreamReader(uRLConnection.getInputStream(), getCharacterEncoding(uRLConnection));
    }

    private static String getCharacterEncoding(URLConnection uRLConnection) {
        ParsedContentType parsedContentType = new ParsedContentType(uRLConnection.getContentType());
        String encoding = parsedContentType.getEncoding();
        if (encoding != null) {
            return encoding;
        }
        String contentType = parsedContentType.getContentType();
        if (contentType != null && contentType.startsWith("text/")) {
            return "8859_1";
        }
        return "utf-8";
    }

    private Object getSecurityDomain(URLConnection uRLConnection) {
        UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider = this.urlConnectionSecurityDomainProvider;
        if (urlConnectionSecurityDomainProvider == null) {
            return null;
        }
        return urlConnectionSecurityDomainProvider.getSecurityDomain(uRLConnection);
    }

    private void close(URLConnection uRLConnection) {
        try {
            uRLConnection.getInputStream().close();
        } catch (IOException e2) {
            onFailedClosingUrlConnection(uRLConnection, e2);
        }
    }

    protected URLConnection openUrlConnection(URL url) throws IOException {
        return url.openConnection();
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected boolean entityNeedsRevalidation(Object obj) {
        return !(obj instanceof URLValidator) || ((URLValidator) obj).entityNeedsRevalidation();
    }

    private static class URLValidator implements Serializable {
        private static final long serialVersionUID = 1;
        private final String entityTags;
        private long expiry;
        private final long lastModified;
        private final URI uri;

        public URLValidator(URI uri, URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            this.uri = uri;
            this.lastModified = uRLConnection.getLastModified();
            this.entityTags = getEntityTags(uRLConnection);
            this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
        }

        boolean updateValidator(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) throws IOException {
            boolean zIsResourceChanged = isResourceChanged(uRLConnection);
            if (!zIsResourceChanged) {
                this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
            }
            return zIsResourceChanged;
        }

        private boolean isResourceChanged(URLConnection uRLConnection) throws IOException {
            return uRLConnection instanceof HttpURLConnection ? ((HttpURLConnection) uRLConnection).getResponseCode() == 304 : this.lastModified == uRLConnection.getLastModified();
        }

        private long calculateExpiry(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(uRLConnection.getHeaderField("Pragma"))) {
                return 0L;
            }
            String headerField = uRLConnection.getHeaderField("Cache-Control");
            if (headerField != null) {
                if (headerField.indexOf(HeaderConstants.CACHE_CONTROL_NO_CACHE) != -1) {
                    return 0L;
                }
                int maxAge = getMaxAge(headerField);
                if (-1 != maxAge) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    return (((long) maxAge) * 1000) + (jCurrentTimeMillis - (Math.max(Math.max(0L, jCurrentTimeMillis - uRLConnection.getDate()), ((long) uRLConnection.getHeaderFieldInt("Age", 0)) * 1000) + (jCurrentTimeMillis - j)));
                }
            }
            long headerFieldDate = uRLConnection.getHeaderFieldDate("Expires", -1L);
            if (headerFieldDate != -1) {
                return headerFieldDate;
            }
            if (urlConnectionExpiryCalculator == null) {
                return 0L;
            }
            return urlConnectionExpiryCalculator.calculateExpiry(uRLConnection);
        }

        private int getMaxAge(String str) {
            int iIndexOf;
            String strSubstring;
            int iIndexOf2 = str.indexOf("max-age");
            if (iIndexOf2 == -1 || (iIndexOf = str.indexOf(61, iIndexOf2 + 7)) == -1) {
                return -1;
            }
            int i = iIndexOf + 1;
            int iIndexOf3 = str.indexOf(44, i);
            if (iIndexOf3 == -1) {
                strSubstring = str.substring(i);
            } else {
                strSubstring = str.substring(i, iIndexOf3);
            }
            try {
                return Integer.parseInt(strSubstring);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private String getEntityTags(URLConnection uRLConnection) {
            List<String> list = uRLConnection.getHeaderFields().get("ETag");
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(", ").append(it.next());
            }
            return sb.toString();
        }

        boolean appliesTo(URI uri) {
            return this.uri.equals(uri);
        }

        void applyConditionals(URLConnection uRLConnection) {
            long j = this.lastModified;
            if (j != 0) {
                uRLConnection.setIfModifiedSince(j);
            }
            String str = this.entityTags;
            if (str == null || str.length() <= 0) {
                return;
            }
            uRLConnection.addRequestProperty("If-None-Match", this.entityTags);
        }

        boolean entityNeedsRevalidation() {
            return System.currentTimeMillis() > this.expiry;
        }
    }
}
