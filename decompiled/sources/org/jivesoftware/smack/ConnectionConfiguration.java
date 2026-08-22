package org.jivesoftware.smack;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.debugger.SmackDebuggerFactory;
import org.jivesoftware.smack.internal.SmackTlsContext;
import org.jivesoftware.smack.packet.id.StandardStanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSource;
import org.jivesoftware.smack.packet.id.StanzaIdSourceFactory;
import org.jivesoftware.smack.proxy.ProxyInfo;
import org.jivesoftware.smack.sasl.core.SASLAnonymous;
import org.jivesoftware.smack.util.CloseableUtil;
import org.jivesoftware.smack.util.CollectionUtil;
import org.jivesoftware.smack.util.DNSUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.SslContextFactory;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smack.util.dns.SmackDaneProvider;
import org.jivesoftware.smack.util.dns.SmackDaneVerifier;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Resourcepart;
import org.jxmpp.stringprep.XmppStringprepException;
import org.minidns.dnsname.DnsName;
import org.minidns.dnsname.InvalidDnsNameException;
import org.minidns.util.InetAddressUtil;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ConnectionConfiguration {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOGGER;
    protected final boolean allowNullOrEmptyUsername;
    private final EntityBareJid authzid;
    private final CallbackHandler callbackHandler;
    private final boolean compressionEnabled;
    private final SmackDebuggerFactory debuggerFactory;
    private final DnssecMode dnssecMode;
    private final String[] enabledSSLCiphers;
    private final String[] enabledSSLProtocols;
    private final Set<String> enabledSaslMechanisms;
    protected final DnsName host;
    protected final InetAddress hostAddress;
    private final HostnameVerifier hostnameVerifier;
    private final Locale language;
    private final String password;
    protected final UInt16 port;
    protected final ProxyInfo proxy;
    private final Resourcepart resource;
    private final SecurityMode securityMode;
    private final boolean sendPresence;
    final SmackTlsContext smackTlsContext;
    private final SocketFactory socketFactory;
    private final StanzaIdSourceFactory stanzaIdSourceFactory;
    private final CharSequence username;
    protected final DomainBareJid xmppServiceDomain;
    protected final DnsName xmppServiceDomainDnsName;

    public enum DnssecMode {
        disabled,
        needsDnssec,
        needsDnssecAndDane
    }

    public enum SecurityMode {
        required,
        ifpossible,
        disabled
    }

    static {
        Smack.ensureInitialized();
        LOGGER = Logger.getLogger(ConnectionConfiguration.class.getName());
    }

    protected ConnectionConfiguration(Builder<?, ?> builder) {
        DnsName dnsNameFrom;
        try {
            this.smackTlsContext = getSmackTlsContext(((Builder) builder).dnssecMode, ((Builder) builder).sslContextFactory, ((Builder) builder).customX509TrustManager, ((Builder) builder).keystoreType, ((Builder) builder).keystorePath, ((Builder) builder).callbackHandler, ((Builder) builder).pkcs11Library);
            this.authzid = ((Builder) builder).authzid;
            this.username = ((Builder) builder).username;
            this.password = ((Builder) builder).password;
            this.callbackHandler = ((Builder) builder).callbackHandler;
            this.resource = ((Builder) builder).resource;
            this.language = ((Builder) builder).language;
            DomainBareJid domainBareJid = ((Builder) builder).xmppServiceDomain;
            this.xmppServiceDomain = domainBareJid;
            if (domainBareJid == null) {
                throw new IllegalArgumentException("Must define the XMPP domain");
            }
            try {
                dnsNameFrom = DnsName.from(domainBareJid);
            } catch (InvalidDnsNameException e2) {
                LOGGER.log(Level.INFO, "Could not transform XMPP service domain '" + ((Object) this.xmppServiceDomain) + "' to a DNS name. TLS X.509 certificate validiation may not be possible.", (Throwable) e2);
                dnsNameFrom = null;
            }
            this.xmppServiceDomainDnsName = dnsNameFrom;
            this.hostAddress = ((Builder) builder).hostAddress;
            this.host = ((Builder) builder).host;
            this.port = ((Builder) builder).port;
            this.proxy = ((Builder) builder).proxy;
            this.socketFactory = ((Builder) builder).socketFactory;
            this.dnssecMode = ((Builder) builder).dnssecMode;
            this.securityMode = ((Builder) builder).securityMode;
            this.enabledSSLProtocols = ((Builder) builder).enabledSSLProtocols;
            this.enabledSSLCiphers = ((Builder) builder).enabledSSLCiphers;
            this.hostnameVerifier = ((Builder) builder).hostnameVerifier;
            this.sendPresence = ((Builder) builder).sendPresence;
            this.debuggerFactory = ((Builder) builder).debuggerFactory;
            this.allowNullOrEmptyUsername = ((Builder) builder).allowEmptyOrNullUsername;
            this.enabledSaslMechanisms = ((Builder) builder).enabledSaslMechanisms;
            this.compressionEnabled = ((Builder) builder).compressionEnabled;
            this.stanzaIdSourceFactory = ((Builder) builder).stanzaIdSourceFactory;
        } catch (IOException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | NoSuchProviderException | UnrecoverableKeyException | CertificateException | UnsupportedCallbackException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    private static SmackTlsContext getSmackTlsContext(DnssecMode dnssecMode, SslContextFactory sslContextFactory, X509TrustManager x509TrustManager, String str, String str2, CallbackHandler callbackHandler, String str3) throws IllegalAccessException, NoSuchMethodException, UnsupportedCallbackException, IOException, KeyStoreException, CertificateException, KeyManagementException, IllegalArgumentException, InvocationTargetException, NoSuchAlgorithmException, UnrecoverableKeyException, InstantiationException, SecurityException, ClassNotFoundException, NoSuchProviderException {
        SSLContext sSLContext;
        KeyStore keyStore;
        PasswordCallback passwordCallback;
        KeyManager[] keyManagers;
        KeyManagerFactory keyManagerFactory;
        if (sslContextFactory != null) {
            sSLContext = sslContextFactory.createSslContext();
        } else {
            sSLContext = SSLContext.getInstance("TLS");
        }
        SmackDaneVerifier smackDaneVerifier = null;
        if ("PKCS11".equals(str)) {
            Provider provider = (Provider) Class.forName("sun.security.pkcs11.SunPKCS11").getConstructor(InputStream.class).newInstance(new ByteArrayInputStream(("name = SmartCard\nlibrary = " + str3).getBytes(StandardCharsets.UTF_8)));
            Security.addProvider(provider);
            keyStore = KeyStore.getInstance("PKCS11", provider);
            passwordCallback = new PasswordCallback("PKCS11 Password: ", false);
            callbackHandler.handle(new Callback[]{passwordCallback});
            keyStore.load(null, passwordCallback.getPassword());
        } else {
            if ("Apple".equals(str)) {
                keyStore = KeyStore.getInstance("KeychainStore", "Apple");
                keyStore.load(null, null);
            } else if (str != null) {
                keyStore = KeyStore.getInstance(str);
                if (callbackHandler != null && StringUtils.isNotEmpty(str2)) {
                    PasswordCallback passwordCallback2 = new PasswordCallback("Keystore Password: ", false);
                    callbackHandler.handle(new Callback[]{passwordCallback2});
                    keyStore.load(new FileInputStream(str2), passwordCallback2.getPassword());
                    passwordCallback = passwordCallback2;
                } else {
                    FileInputStream defaultTruststoreStreamIfPossible = TLSUtils.getDefaultTruststoreStreamIfPossible();
                    try {
                        try {
                            keyStore.load(defaultTruststoreStreamIfPossible, "changeit".toCharArray());
                            CloseableUtil.maybeClose(defaultTruststoreStreamIfPossible);
                        } finally {
                        }
                    } catch (IOException e2) {
                        LOGGER.log(Level.FINE, "KeyStore load() threw, attempting 'jks' fallback", (Throwable) e2);
                        keyStore = KeyStore.getInstance("jks");
                        try {
                            keyStore.load(TLSUtils.getDefaultTruststoreStreamIfPossible(), null);
                        } finally {
                        }
                    }
                }
            } else {
                keyStore = null;
                passwordCallback = null;
            }
            passwordCallback = null;
        }
        if (keyStore == null || (keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())) == null) {
            keyManagers = null;
        } else {
            if (passwordCallback == null) {
                keyManagerFactory.init(keyStore, null);
            } else {
                keyManagerFactory.init(keyStore, passwordCallback.getPassword());
                passwordCallback.clearPassword();
            }
            keyManagers = keyManagerFactory.getKeyManagers();
        }
        if (dnssecMode == DnssecMode.needsDnssecAndDane) {
            SmackDaneProvider daneProvider = DNSUtil.getDaneProvider();
            if (daneProvider == null) {
                throw new UnsupportedOperationException("DANE enabled but no SmackDaneProvider configured");
            }
            SmackDaneVerifier smackDaneVerifierNewInstance = daneProvider.newInstance();
            if (smackDaneVerifierNewInstance == null) {
                throw new IllegalStateException("DANE requested but DANE provider did not return a DANE verifier");
            }
            smackDaneVerifierNewInstance.init(sSLContext, keyManagers, x509TrustManager, null);
            smackDaneVerifier = smackDaneVerifierNewInstance;
        } else {
            sSLContext.init(keyManagers, x509TrustManager != null ? new TrustManager[]{x509TrustManager} : null, null);
        }
        return new SmackTlsContext(sSLContext, smackDaneVerifier);
    }

    public DnsName getHost() {
        return this.host;
    }

    public InetAddress getHostAddress() {
        return this.hostAddress;
    }

    public UInt16 getPort() {
        return this.port;
    }

    @Deprecated
    public DomainBareJid getServiceName() {
        return this.xmppServiceDomain;
    }

    public DomainBareJid getXMPPServiceDomain() {
        return this.xmppServiceDomain;
    }

    public DnsName getXmppServiceDomainAsDnsNameIfPossible() {
        return this.xmppServiceDomainDnsName;
    }

    public SecurityMode getSecurityMode() {
        return this.securityMode;
    }

    public DnssecMode getDnssecMode() {
        return this.dnssecMode;
    }

    public String[] getEnabledSSLProtocols() {
        return this.enabledSSLProtocols;
    }

    public String[] getEnabledSSLCiphers() {
        return this.enabledSSLCiphers;
    }

    public HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = this.hostnameVerifier;
        return hostnameVerifier != null ? hostnameVerifier : SmackConfiguration.getDefaultHostnameVerifier();
    }

    public SmackDebuggerFactory getDebuggerFactory() {
        return this.debuggerFactory;
    }

    public CallbackHandler getCallbackHandler() {
        return this.callbackHandler;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public ProxyInfo getProxyInfo() {
        return this.proxy;
    }

    public CharSequence getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Resourcepart getResource() {
        return this.resource;
    }

    public Locale getLanguage() {
        return this.language;
    }

    public String getXmlLang() {
        Locale locale = this.language;
        if (locale != null) {
            return locale.toString().replace("_", "-");
        }
        return null;
    }

    public EntityBareJid getAuthzid() {
        return this.authzid;
    }

    public boolean isSendPresence() {
        return this.sendPresence;
    }

    public boolean isCompressionEnabled() {
        return this.compressionEnabled;
    }

    public boolean isEnabledSaslMechanism(String str) {
        Set<String> set = this.enabledSaslMechanisms;
        if (set == null) {
            return !SASLAuthentication.getBlacklistedSASLMechanisms().contains(str);
        }
        return set.contains(str);
    }

    public Set<String> getEnabledSaslMechanisms() {
        Set<String> set = this.enabledSaslMechanisms;
        if (set == null) {
            return null;
        }
        return Collections.unmodifiableSet(set);
    }

    StanzaIdSource constructStanzaIdSource() {
        return this.stanzaIdSourceFactory.constructStanzaIdSource();
    }

    public static abstract class Builder<B extends Builder<B, C>, C extends ConnectionConfiguration> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private EntityBareJid authzid;
        private CallbackHandler callbackHandler;
        private X509TrustManager customX509TrustManager;
        private SmackDebuggerFactory debuggerFactory;
        private String[] enabledSSLCiphers;
        private String[] enabledSSLProtocols;
        private Set<String> enabledSaslMechanisms;
        private DnsName host;
        private InetAddress hostAddress;
        private HostnameVerifier hostnameVerifier;
        private String keystorePath;
        private String keystoreType;
        private String password;
        private ProxyInfo proxy;
        private Resourcepart resource;
        private boolean saslMechanismsSealed;
        private SocketFactory socketFactory;
        private SslContextFactory sslContextFactory;
        private CharSequence username;
        private DomainBareJid xmppServiceDomain;
        private SecurityMode securityMode = SecurityMode.required;
        private DnssecMode dnssecMode = DnssecMode.disabled;
        private String pkcs11Library = "pkcs11.config";
        private Locale language = Locale.getDefault();
        private boolean sendPresence = true;
        private UInt16 port = UInt16.from(5222);
        private boolean allowEmptyOrNullUsername = false;
        private boolean compressionEnabled = false;
        private StanzaIdSourceFactory stanzaIdSourceFactory = new StandardStanzaIdSource.Factory();

        static /* synthetic */ SSLContext lambda$setCustomSSLContext$0(SSLContext sSLContext) {
            return sSLContext;
        }

        public abstract C build();

        protected abstract B getThis();

        protected Builder() {
            if (SmackConfiguration.DEBUG) {
                enableDefaultDebugger();
            }
        }

        public B setXmppAddressAndPassword(CharSequence charSequence, String str) throws XmppStringprepException {
            return (B) setXmppAddressAndPassword(JidCreate.entityBareFrom(charSequence), str);
        }

        public B setXmppAddressAndPassword(EntityBareJid entityBareJid, String str) {
            setUsernameAndPassword(entityBareJid.getLocalpart(), str);
            return (B) setXmppDomain(entityBareJid.asDomainBareJid());
        }

        public B setUsernameAndPassword(CharSequence charSequence, String str) {
            this.username = charSequence;
            this.password = str;
            return (B) getThis();
        }

        @Deprecated
        public B setServiceName(DomainBareJid domainBareJid) {
            return (B) setXmppDomain(domainBareJid);
        }

        public B setXmppDomain(DomainBareJid domainBareJid) {
            this.xmppServiceDomain = domainBareJid;
            return (B) getThis();
        }

        public B setXmppDomain(String str) throws XmppStringprepException {
            this.xmppServiceDomain = JidCreate.domainBareFrom(str);
            return (B) getThis();
        }

        public B setResource(Resourcepart resourcepart) {
            this.resource = resourcepart;
            return (B) getThis();
        }

        public B setLanguage(Locale locale) {
            this.language = locale;
            return (B) getThis();
        }

        public B setResource(CharSequence charSequence) throws XmppStringprepException {
            Objects.requireNonNull(charSequence, "resource must not be null");
            return (B) setResource(Resourcepart.from(charSequence.toString()));
        }

        public B setHostAddress(InetAddress inetAddress) {
            this.hostAddress = inetAddress;
            return (B) getThis();
        }

        public B setHost(CharSequence charSequence) {
            String string = charSequence.toString();
            if (InetAddressUtil.isIpAddress(string)) {
                try {
                    setHostAddress(InetAddress.getByName(string));
                } catch (UnknownHostException e2) {
                    throw new AssertionError(e2);
                }
            } else {
                setHost(DnsName.from(string));
            }
            return (B) getThis();
        }

        public B setHost(DnsName dnsName) {
            this.host = dnsName;
            return (B) getThis();
        }

        @Deprecated
        public B setHostAddressByNameOrIp(CharSequence charSequence) {
            return (B) setHost(charSequence);
        }

        public B setPort(int i) {
            if (i < 0 || i > 65535) {
                throw new IllegalArgumentException("Port must be a 16-bit unsigned integer (i.e. between 0-65535. Port was: " + i);
            }
            return (B) setPort(UInt16.from(i));
        }

        public B setPort(UInt16 uInt16) {
            this.port = (UInt16) Objects.requireNonNull(uInt16);
            return (B) getThis();
        }

        public B setCallbackHandler(CallbackHandler callbackHandler) {
            this.callbackHandler = callbackHandler;
            return (B) getThis();
        }

        public B setDnssecMode(DnssecMode dnssecMode) {
            this.dnssecMode = (DnssecMode) Objects.requireNonNull(dnssecMode, "DNSSEC mode must not be null");
            return (B) getThis();
        }

        public B setCustomX509TrustManager(X509TrustManager x509TrustManager) {
            this.customX509TrustManager = x509TrustManager;
            return (B) getThis();
        }

        public B setSecurityMode(SecurityMode securityMode) {
            this.securityMode = securityMode;
            return (B) getThis();
        }

        public B setKeystorePath(String str) {
            this.keystorePath = str;
            return (B) getThis();
        }

        public B setKeystoreType(String str) {
            this.keystoreType = str;
            return (B) getThis();
        }

        public B setPKCS11Library(String str) {
            this.pkcs11Library = str;
            return (B) getThis();
        }

        @Deprecated
        public B setCustomSSLContext(final SSLContext sSLContext) {
            return (B) setSslContextFactory(new SslContextFactory() { // from class: org.jivesoftware.smack.ConnectionConfiguration$Builder$$ExternalSyntheticLambda0
                @Override // org.jivesoftware.smack.util.SslContextFactory
                public final SSLContext createSslContext() {
                    return ConnectionConfiguration.Builder.lambda$setCustomSSLContext$0(sSLContext);
                }
            });
        }

        public B setSslContextFactory(SslContextFactory sslContextFactory) {
            this.sslContextFactory = (SslContextFactory) Objects.requireNonNull(sslContextFactory, "The provided SslContextFactory must not be null");
            return (B) getThis();
        }

        public B setEnabledSSLProtocols(String[] strArr) {
            this.enabledSSLProtocols = strArr;
            return (B) getThis();
        }

        public B setEnabledSSLCiphers(String[] strArr) {
            this.enabledSSLCiphers = strArr;
            return (B) getThis();
        }

        public B setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return (B) getThis();
        }

        public B setSendPresence(boolean z) {
            this.sendPresence = z;
            return (B) getThis();
        }

        public B enableDefaultDebugger() {
            this.debuggerFactory = SmackConfiguration.getDefaultSmackDebuggerFactory();
            return (B) getThis();
        }

        public B setDebuggerFactory(SmackDebuggerFactory smackDebuggerFactory) {
            this.debuggerFactory = smackDebuggerFactory;
            return (B) getThis();
        }

        public B setSocketFactory(SocketFactory socketFactory) {
            this.socketFactory = socketFactory;
            return (B) getThis();
        }

        public B setProxyInfo(ProxyInfo proxyInfo) {
            this.proxy = proxyInfo;
            return (B) getThis();
        }

        public B allowEmptyOrNullUsernames() {
            this.allowEmptyOrNullUsername = true;
            return (B) getThis();
        }

        public B performSaslAnonymousAuthentication() {
            if (!SASLAuthentication.isSaslMechanismRegistered(SASLAnonymous.NAME)) {
                throw new IllegalArgumentException("SASL ANONYMOUS is not registered");
            }
            throwIfEnabledSaslMechanismsSet();
            allowEmptyOrNullUsernames();
            addEnabledSaslMechanism(SASLAnonymous.NAME);
            this.saslMechanismsSealed = true;
            return (B) getThis();
        }

        public B performSaslExternalAuthentication(SSLContext sSLContext) {
            if (!SASLAuthentication.isSaslMechanismRegistered("EXTERNAL")) {
                throw new IllegalArgumentException("SASL EXTERNAL is not registered");
            }
            setCustomSSLContext(sSLContext);
            throwIfEnabledSaslMechanismsSet();
            allowEmptyOrNullUsernames();
            setSecurityMode(SecurityMode.required);
            addEnabledSaslMechanism("EXTERNAL");
            this.saslMechanismsSealed = true;
            return (B) getThis();
        }

        private void throwIfEnabledSaslMechanismsSet() {
            if (this.enabledSaslMechanisms != null) {
                throw new IllegalStateException("Enabled SASL mechanisms found");
            }
        }

        public B addEnabledSaslMechanism(String str) {
            return (B) addEnabledSaslMechanism(Arrays.asList((String) StringUtils.requireNotNullNorEmpty(str, "saslMechanism must not be null nor empty")));
        }

        public B addEnabledSaslMechanism(Collection<String> collection) {
            if (this.saslMechanismsSealed) {
                throw new IllegalStateException("The enabled SASL mechanisms are sealed, you can not add new ones");
            }
            CollectionUtil.requireNotEmpty(collection, "saslMechanisms");
            Set<String> blacklistedSASLMechanisms = SASLAuthentication.getBlacklistedSASLMechanisms();
            for (String str : collection) {
                if (!SASLAuthentication.isSaslMechanismRegistered(str)) {
                    throw new IllegalArgumentException("SASL " + str + " is not available. Consider registering it with Smack");
                }
                if (blacklistedSASLMechanisms.contains(str)) {
                    throw new IllegalArgumentException("SALS " + str + " is blacklisted.");
                }
            }
            if (this.enabledSaslMechanisms == null) {
                this.enabledSaslMechanisms = new HashSet(collection.size());
            }
            this.enabledSaslMechanisms.addAll(collection);
            return (B) getThis();
        }

        public B setAuthzid(EntityBareJid entityBareJid) {
            this.authzid = entityBareJid;
            return (B) getThis();
        }

        public B setCompressionEnabled(boolean z) {
            this.compressionEnabled = z;
            return (B) getThis();
        }

        public B setStanzaIdSourceFactory(StanzaIdSourceFactory stanzaIdSourceFactory) {
            this.stanzaIdSourceFactory = (StanzaIdSourceFactory) Objects.requireNonNull(stanzaIdSourceFactory);
            return (B) getThis();
        }
    }
}
