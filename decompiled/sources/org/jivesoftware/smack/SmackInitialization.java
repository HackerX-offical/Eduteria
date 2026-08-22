package org.jivesoftware.smack;

import com.clevertap.android.sdk.Constants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.bind2.Bind2ModuleDescriptor;
import org.jivesoftware.smack.compress.provider.CompressedProvider;
import org.jivesoftware.smack.compress.provider.FailureProvider;
import org.jivesoftware.smack.compression.CompressionModuleDescriptor;
import org.jivesoftware.smack.compression.Java7ZlibInputOutputStream;
import org.jivesoftware.smack.compression.XmppCompressionManager;
import org.jivesoftware.smack.compression.zlib.ZlibXmppCompressionFactory;
import org.jivesoftware.smack.initializer.SmackInitializer;
import org.jivesoftware.smack.isr.InstantStreamResumptionModuleDescriptor;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.BindIQProvider;
import org.jivesoftware.smack.provider.BodyElementProvider;
import org.jivesoftware.smack.provider.MessageSubjectElementProvider;
import org.jivesoftware.smack.provider.MessageThreadElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.provider.SaslChallengeProvider;
import org.jivesoftware.smack.provider.SaslFailureProvider;
import org.jivesoftware.smack.provider.SaslSuccessProvider;
import org.jivesoftware.smack.provider.TlsFailureProvider;
import org.jivesoftware.smack.provider.TlsProceedProvider;
import org.jivesoftware.smack.sasl.core.SASLAnonymous;
import org.jivesoftware.smack.sasl.core.SASLXOauth2Mechanism;
import org.jivesoftware.smack.sasl.core.SCRAMSHA1Mechanism;
import org.jivesoftware.smack.sasl.core.ScramSha1PlusMechanism;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;

/* JADX INFO: loaded from: classes10.dex */
public final class SmackInitialization {
    private static final String DEFAULT_CONFIG_FILE = "org.jivesoftware.smack/smack-config.xml";
    private static final Logger LOGGER;
    static final String SMACK_VERSION;

    static {
        BufferedReader bufferedReader;
        String line;
        Logger logger = Logger.getLogger(SmackInitialization.class.getName());
        LOGGER = logger;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(FileUtils.getStreamForClasspathFile("org.jivesoftware.smack/version", null), StandardCharsets.UTF_8));
            try {
                try {
                    line = bufferedReader.readLine();
                    CloseableUtil.maybeClose(bufferedReader, logger);
                } catch (Exception e2) {
                    e = e2;
                    Logger logger2 = LOGGER;
                    logger2.log(Level.SEVERE, "Could not determine Smack version", (Throwable) e);
                    CloseableUtil.maybeClose(bufferedReader, logger2);
                    line = "unknown";
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                CloseableUtil.maybeClose(bufferedReader2, LOGGER);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            CloseableUtil.maybeClose(bufferedReader2, LOGGER);
            throw th;
        }
        SMACK_VERSION = line;
        String property = System.getProperty("smack.disabledClasses");
        if (property != null) {
            for (String str : property.split(Constants.SEPARATOR_COMMA)) {
                SmackConfiguration.disabledSmackClasses.add(str);
            }
        }
        try {
            try {
                processConfigFile(FileUtils.getStreamForClasspathFile(DEFAULT_CONFIG_FILE, null), null);
                SmackConfiguration.addCompressionHandler(new Java7ZlibInputOutputStream());
                XmppCompressionManager.registerXmppCompressionFactory(ZlibXmppCompressionFactory.INSTANCE);
                try {
                    if (Boolean.getBoolean("smack.debugEnabled")) {
                        SmackConfiguration.DEBUG = true;
                    }
                } catch (Exception e4) {
                    LOGGER.log(Level.FINE, "Could not handle debugEnable property on Smack initialization", (Throwable) e4);
                }
                SASLAuthentication.registerSASLMechanism(new SCRAMSHA1Mechanism());
                SASLAuthentication.registerSASLMechanism(new ScramSha1PlusMechanism());
                SASLAuthentication.registerSASLMechanism(new SASLXOauth2Mechanism());
                SASLAuthentication.registerSASLMechanism(new SASLAnonymous());
                ProviderManager.addIQProvider(Bind.ELEMENT, Bind.NAMESPACE, new BindIQProvider());
                ProviderManager.addExtensionProvider("body", "jabber:client", new BodyElementProvider());
                ProviderManager.addExtensionProvider(Message.Thread.ELEMENT, "jabber:client", new MessageThreadElementProvider());
                ProviderManager.addExtensionProvider("subject", "jabber:client", new MessageSubjectElementProvider());
                ProviderManager.addNonzaProvider(SaslChallengeProvider.INSTANCE);
                ProviderManager.addNonzaProvider(SaslSuccessProvider.INSTANCE);
                ProviderManager.addNonzaProvider(SaslFailureProvider.INSTANCE);
                ProviderManager.addNonzaProvider(TlsProceedProvider.INSTANCE);
                ProviderManager.addNonzaProvider(TlsFailureProvider.INSTANCE);
                ProviderManager.addNonzaProvider(CompressedProvider.INSTANCE);
                ProviderManager.addNonzaProvider(FailureProvider.INSTANCE);
                SmackConfiguration.addModule(Bind2ModuleDescriptor.class);
                SmackConfiguration.addModule(CompressionModuleDescriptor.class);
                SmackConfiguration.addModule(InstantStreamResumptionModuleDescriptor.class);
                SmackConfiguration.smackInitialized = true;
            } catch (Exception e5) {
                throw new IllegalStateException("Could not parse Smack configuration file", e5);
            }
        } catch (Exception e6) {
            throw new IllegalStateException("Could not load Smack configuration file", e6);
        }
    }

    public static void processConfigFile(InputStream inputStream, Collection<Exception> collection) throws Exception {
        processConfigFile(inputStream, collection, SmackInitialization.class.getClassLoader());
    }

    public static void processConfigFile(InputStream inputStream, Collection<Exception> collection, ClassLoader classLoader) throws Exception {
        XmlPullParser parserFor = PacketParserUtils.getParserFor(inputStream);
        XmlPullParser.Event eventType = parserFor.getEventType();
        do {
            if (eventType == XmlPullParser.Event.START_ELEMENT) {
                if (parserFor.getName().equals("startupClasses")) {
                    parseClassesToLoad(parserFor, false, collection, classLoader);
                } else if (parserFor.getName().equals("optionalStartupClasses")) {
                    parseClassesToLoad(parserFor, true, collection, classLoader);
                }
            }
            eventType = parserFor.next();
        } while (eventType != XmlPullParser.Event.END_DOCUMENT);
        CloseableUtil.maybeClose(inputStream, LOGGER);
    }

    private static void parseClassesToLoad(XmlPullParser xmlPullParser, boolean z, Collection<Exception> collection, ClassLoader classLoader) throws Exception {
        String name = xmlPullParser.getName();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "className".equals(xmlPullParser.getName())) {
                String strNextText = xmlPullParser.nextText();
                if (!SmackConfiguration.isDisabledSmackClass(strNextText)) {
                    try {
                        loadSmackClass(strNextText, z, classLoader);
                    } catch (Exception e2) {
                        if (collection != null) {
                            collection.add(e2);
                        } else {
                            throw e2;
                        }
                    }
                }
            }
            if (next == XmlPullParser.Event.END_ELEMENT && name.equals(xmlPullParser.getName())) {
                return;
            }
        }
    }

    private static void loadSmackClass(String str, boolean z, ClassLoader classLoader) throws Exception {
        Level level;
        try {
            Class<?> cls = Class.forName(str, true, classLoader);
            if (SmackInitializer.class.isAssignableFrom(cls)) {
                List<Exception> listInitialize = ((SmackInitializer) cls.getConstructor(new Class[0]).newInstance(new Object[0])).initialize();
                if (listInitialize == null || listInitialize.size() == 0) {
                    LOGGER.log(Level.FINE, "Loaded SmackInitializer " + str);
                    return;
                }
                Iterator<Exception> it = listInitialize.iterator();
                while (it.hasNext()) {
                    LOGGER.log(Level.SEVERE, "Exception in loadSmackClass", (Throwable) it.next());
                }
                return;
            }
            LOGGER.log(Level.FINE, "Loaded " + str);
        } catch (ClassNotFoundException e2) {
            if (z) {
                level = Level.FINE;
            } else {
                level = Level.WARNING;
            }
            LOGGER.log(level, "A startup class '" + str + "' could not be loaded.");
            if (!z) {
                throw e2;
            }
        }
    }
}
