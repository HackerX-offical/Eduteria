package org.jivesoftware.smack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionConfiguration;
import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnectionModuleDescriptor;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.debugger.ReflectionDebuggerFactory;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.parsing.ExceptionThrowingCallbackWithHint;
import org.jivesoftware.smack.parsing.ParsingExceptionCallback;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class SmackConfiguration {
    public static boolean DEBUG = false;
    private static SmackDebuggerFactory DEFAULT_DEBUGGER_FACTORY = null;
    private static final Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> KNOWN_MODULES;
    public static final URL SMACK_URL;
    public static final String SMACK_URL_STRING = "https://igniterealtime.org/projects/smack";
    static final List<XMPPInputOutputStream> compressionHandlers;
    private static ParsingExceptionCallback defaultCallback;
    private static final int defaultConcurrencyLevelLimit;
    private static HostnameVerifier defaultHostnameVerififer;
    private static List<String> defaultMechs;
    private static int defaultPacketReplyTimeout;
    static Set<String> disabledSmackClasses;
    private static int packetCollectorSize;
    static boolean smackInitialized;
    private static UnknownIqRequestReplyMode unknownIqRequestReplyMode;

    public enum UnknownIqRequestReplyMode {
        doNotReply,
        replyFeatureNotImplemented,
        replyServiceUnavailable
    }

    static {
        try {
            SMACK_URL = new URL(SMACK_URL_STRING);
            defaultPacketReplyTimeout = 5000;
            packetCollectorSize = 5000;
            defaultMechs = new ArrayList();
            disabledSmackClasses = new HashSet();
            compressionHandlers = new ArrayList(2);
            smackInitialized = false;
            DEBUG = false;
            DEFAULT_DEBUGGER_FACTORY = ReflectionDebuggerFactory.INSTANCE;
            defaultCallback = new ExceptionThrowingCallbackWithHint();
            unknownIqRequestReplyMode = UnknownIqRequestReplyMode.replyFeatureNotImplemented;
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            if (iAvailableProcessors < 8) {
                defaultConcurrencyLevelLimit = 8;
            } else {
                defaultConcurrencyLevelLimit = (int) (((double) iAvailableProcessors) * 1.1d);
            }
            KNOWN_MODULES = new HashSet();
        } catch (MalformedURLException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Deprecated
    public static String getVersion() {
        return SmackInitialization.SMACK_VERSION;
    }

    public static int getDefaultReplyTimeout() {
        if (defaultPacketReplyTimeout <= 0) {
            defaultPacketReplyTimeout = 5000;
        }
        return defaultPacketReplyTimeout;
    }

    public static void setDefaultReplyTimeout(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        defaultPacketReplyTimeout = i;
    }

    public static void setDefaultSmackDebuggerFactory(SmackDebuggerFactory smackDebuggerFactory) {
        DEFAULT_DEBUGGER_FACTORY = (SmackDebuggerFactory) Objects.requireNonNull(smackDebuggerFactory, "Debugger factory must not be null");
    }

    public static SmackDebuggerFactory getDefaultSmackDebuggerFactory() {
        return DEFAULT_DEBUGGER_FACTORY;
    }

    public static int getStanzaCollectorSize() {
        return packetCollectorSize;
    }

    public static void setStanzaCollectorSize(int i) {
        packetCollectorSize = i;
    }

    public static void addSaslMech(String str) {
        if (defaultMechs.contains(str)) {
            return;
        }
        defaultMechs.add(str);
    }

    public static void addSaslMechs(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addSaslMech(it.next());
        }
    }

    public static void removeSaslMech(String str) {
        defaultMechs.remove(str);
    }

    public static void removeSaslMechs(Collection<String> collection) {
        defaultMechs.removeAll(collection);
    }

    public static List<String> getSaslMechs() {
        return Collections.unmodifiableList(defaultMechs);
    }

    public static void setDefaultParsingExceptionCallback(ParsingExceptionCallback parsingExceptionCallback) {
        defaultCallback = parsingExceptionCallback;
    }

    public static ParsingExceptionCallback getDefaultParsingExceptionCallback() {
        return defaultCallback;
    }

    public static void addCompressionHandler(XMPPInputOutputStream xMPPInputOutputStream) {
        compressionHandlers.add(xMPPInputOutputStream);
    }

    public static List<XMPPInputOutputStream> getCompressionHandlers() {
        List<XMPPInputOutputStream> list = compressionHandlers;
        ArrayList arrayList = new ArrayList(list.size());
        for (XMPPInputOutputStream xMPPInputOutputStream : list) {
            if (xMPPInputOutputStream.isSupported()) {
                arrayList.add(xMPPInputOutputStream);
            }
        }
        return arrayList;
    }

    public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
        defaultHostnameVerififer = hostnameVerifier;
    }

    public static void addDisabledSmackClass(Class<?> cls) {
        addDisabledSmackClass(cls.getName());
    }

    public static void addDisabledSmackClass(String str) {
        disabledSmackClasses.add(str);
    }

    public static void addDisabledSmackClasses(String... strArr) {
        for (String str : strArr) {
            addDisabledSmackClass(str);
        }
    }

    public static boolean isDisabledSmackClass(String str) {
        for (String str2 : disabledSmackClasses) {
            if (str2.equals(str)) {
                return true;
            }
            int iLastIndexOf = str2.lastIndexOf(46);
            if (str2.length() > iLastIndexOf && !Character.isUpperCase(str2.charAt(iLastIndexOf + 1)) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSmackInitialized() {
        return smackInitialized;
    }

    static HostnameVerifier getDefaultHostnameVerifier() {
        return defaultHostnameVerififer;
    }

    public static UnknownIqRequestReplyMode getUnknownIqRequestReplyMode() {
        return unknownIqRequestReplyMode;
    }

    public static void setUnknownIqRequestReplyMode(UnknownIqRequestReplyMode unknownIqRequestReplyMode2) {
        unknownIqRequestReplyMode = (UnknownIqRequestReplyMode) Objects.requireNonNull(unknownIqRequestReplyMode2, "Must set mode");
    }

    public static int getDefaultConcurrencyLevelLimit() {
        return defaultConcurrencyLevelLimit;
    }

    public static boolean addModule(Class<? extends ModularXmppClientToServerConnectionModuleDescriptor> cls) {
        boolean zAdd;
        Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> set = KNOWN_MODULES;
        synchronized (set) {
            zAdd = set.add(cls);
        }
        return zAdd;
    }

    public static void addAllKnownModulesTo(ModularXmppClientToServerConnectionConfiguration.Builder builder) {
        Set<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> set = KNOWN_MODULES;
        synchronized (set) {
            Iterator<Class<? extends ModularXmppClientToServerConnectionModuleDescriptor>> it = set.iterator();
            while (it.hasNext()) {
                builder.addModule(it.next());
            }
        }
    }
}
