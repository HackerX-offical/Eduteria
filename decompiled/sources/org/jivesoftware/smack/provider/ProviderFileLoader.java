package org.jivesoftware.smack.provider;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class ProviderFileLoader implements ProviderLoader {
    private static final Logger LOGGER = Logger.getLogger(ProviderFileLoader.class.getName());
    private List<Exception> exceptions;
    private final Collection<ExtensionProviderInfo> extProviders;
    private final Collection<IQProviderInfo> iqProviders;
    private final Collection<StreamFeatureProviderInfo> sfProviders;

    public ProviderFileLoader(InputStream inputStream) {
        this(inputStream, ProviderFileLoader.class.getClassLoader());
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0122 A[Catch: InstantiationException -> 0x013b, ClassNotFoundException -> 0x015c, IllegalArgumentException -> 0x016c, all -> 0x01a0, TRY_LEAVE, TryCatch #3 {IllegalArgumentException -> 0x016c, blocks: (B:7:0x002f, B:9:0x0037, B:10:0x0055, B:32:0x0122, B:17:0x006f, B:19:0x0077, B:21:0x007f, B:22:0x0099, B:23:0x00b8, B:25:0x00c0, B:26:0x00da, B:28:0x00e2, B:30:0x00ea, B:31:0x0104, B:35:0x013c, B:37:0x015d), top: B:60:0x002f, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ProviderFileLoader(java.io.InputStream r10, java.lang.ClassLoader r11) {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.provider.ProviderFileLoader.<init>(java.io.InputStream, java.lang.ClassLoader):void");
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<IQProviderInfo> getIQProviderInfo() {
        return this.iqProviders;
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<ExtensionProviderInfo> getExtensionProviderInfo() {
        return this.extProviders;
    }

    @Override // org.jivesoftware.smack.provider.ProviderLoader
    public Collection<StreamFeatureProviderInfo> getStreamFeatureProviderInfo() {
        return this.sfProviders;
    }

    public List<Exception> getLoadingExceptions() {
        return Collections.unmodifiableList(this.exceptions);
    }
}
