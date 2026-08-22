package org.jivesoftware.smack.initializer;

import com.clevertap.android.sdk.Constants;
import java.io.InputStream;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackInitialization;
import org.jivesoftware.smack.provider.ProviderFileLoader;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class UrlInitializer implements SmackInitializer {
    private static final Logger LOGGER = Logger.getLogger(UrlInitializer.class.getName());

    protected String getConfigUri() {
        return null;
    }

    protected String getProvidersUri() {
        return null;
    }

    @Override // org.jivesoftware.smack.initializer.SmackInitializer
    public List<Exception> initialize() {
        ClassLoader classLoader = getClass().getClassLoader();
        LinkedList linkedList = new LinkedList();
        String providersUri = getProvidersUri();
        InputStream streamForUri = null;
        if (providersUri != null) {
            try {
                try {
                    URI uriCreate = URI.create(providersUri);
                    streamForUri = FileUtils.getStreamForUri(uriCreate, classLoader);
                    LOGGER.log(Level.FINE, "Loading providers for providerUri [" + uriCreate + Constants.AES_SUFFIX);
                    ProviderFileLoader providerFileLoader = new ProviderFileLoader(streamForUri, classLoader);
                    ProviderManager.addLoader(providerFileLoader);
                    linkedList.addAll(providerFileLoader.getLoadingExceptions());
                } catch (Exception e2) {
                    LOGGER.log(Level.SEVERE, "Error trying to load provider file " + providersUri, (Throwable) e2);
                    linkedList.add(e2);
                }
            } finally {
            }
        }
        String configUri = getConfigUri();
        if (configUri != null) {
            try {
                try {
                    streamForUri = FileUtils.getStreamForUri(URI.create(configUri), classLoader);
                    SmackInitialization.processConfigFile(streamForUri, linkedList, classLoader);
                } catch (Exception e3) {
                    linkedList.add(e3);
                }
            } finally {
            }
        }
        return linkedList;
    }

    private static void maybeClose(InputStream inputStream) {
        CloseableUtil.maybeClose(inputStream, LOGGER);
    }
}
