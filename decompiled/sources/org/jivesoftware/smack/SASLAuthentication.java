package org.jivesoftware.smack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.security.auth.callback.CallbackHandler;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Mechanisms;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.core.ScramSha1PlusMechanism;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.util.StringUtils;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class SASLAuthentication {
    private final ConnectionConfiguration configuration;
    private final AbstractXMPPConnection connection;
    private SASLMechanism currentMechanism = null;
    private static final Logger LOGGER = Logger.getLogger(SASLAuthentication.class.getName());
    private static final List<SASLMechanism> REGISTERED_MECHANISMS = new ArrayList();
    private static final Set<String> BLACKLISTED_MECHANISMS = new HashSet();

    static {
        blacklistSASLMechanism(ScramSha1PlusMechanism.NAME);
    }

    public static void registerSASLMechanism(SASLMechanism sASLMechanism) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            list.add(sASLMechanism);
            Collections.sort(list);
        }
    }

    public static Map<String, String> getRegisterdSASLMechanisms() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            for (SASLMechanism sASLMechanism : list) {
                linkedHashMap.put(sASLMechanism.getClass().getName(), sASLMechanism.toString());
            }
        }
        return linkedHashMap;
    }

    public static boolean isSaslMechanismRegistered(String str) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            Iterator<SASLMechanism> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean unregisterSASLMechanism(String str) {
        List<SASLMechanism> list = REGISTERED_MECHANISMS;
        synchronized (list) {
            Iterator<SASLMechanism> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getClass().getName().equals(str)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean blacklistSASLMechanism(String str) {
        boolean zAdd;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            zAdd = set.add(str);
        }
        return zAdd;
    }

    public static boolean unBlacklistSASLMechanism(String str) {
        boolean zRemove;
        Set<String> set = BLACKLISTED_MECHANISMS;
        synchronized (set) {
            zRemove = set.remove(str);
        }
        return zRemove;
    }

    public static Set<String> getBlacklistedSASLMechanisms() {
        return Collections.unmodifiableSet(BLACKLISTED_MECHANISMS);
    }

    SASLAuthentication(AbstractXMPPConnection abstractXMPPConnection, ConnectionConfiguration connectionConfiguration) {
        this.configuration = connectionConfiguration;
        this.connection = abstractXMPPConnection;
    }

    SASLMechanism authenticate(String str, String str2, EntityBareJid entityBareJid, SSLSession sSLSession) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, SmackException.SmackSaslException, SASLErrorException, IOException, XMPPException.XMPPErrorException {
        SASLMechanism sASLMechanismSelectMechanism = selectMechanism(entityBareJid, str2);
        CallbackHandler callbackHandler = this.configuration.getCallbackHandler();
        String host = this.connection.getHost();
        DomainBareJid xMPPServiceDomain = this.connection.getXMPPServiceDomain();
        synchronized (this) {
            this.currentMechanism = sASLMechanismSelectMechanism;
            if (callbackHandler != null) {
                sASLMechanismSelectMechanism.authenticate(host, xMPPServiceDomain, callbackHandler, entityBareJid, sSLSession);
            } else {
                sASLMechanismSelectMechanism.authenticate(str, host, xMPPServiceDomain, str2, entityBareJid, sSLSession);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() + this.connection.getReplyTimeout();
            while (!sASLMechanismSelectMechanism.isFinished()) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 >= jCurrentTimeMillis) {
                    break;
                }
                wait(jCurrentTimeMillis - jCurrentTimeMillis2);
            }
        }
        sASLMechanismSelectMechanism.throwExceptionIfRequired();
        return sASLMechanismSelectMechanism;
    }

    void challengeReceived(SaslNonza.Challenge challenge) throws SmackException, InterruptedException {
        challengeReceived(challenge.getData(), false);
    }

    private void challengeReceived(String str, boolean z) throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        SASLMechanism sASLMechanism;
        synchronized (this) {
            sASLMechanism = this.currentMechanism;
        }
        sASLMechanism.challengeReceived(str, z);
    }

    void authenticated(SaslNonza.Success success) throws SmackException.NotConnectedException, InterruptedException, SmackException.SmackSaslException {
        if (success.getData() != null) {
            challengeReceived(success.getData(), true);
        }
        synchronized (this) {
            this.currentMechanism.afterFinalSaslChallenge();
            notify();
        }
    }

    void authenticationFailed(SaslNonza.SASLFailure sASLFailure) {
        SASLErrorException sASLErrorException;
        synchronized (this) {
            sASLErrorException = new SASLErrorException(this.currentMechanism.getName(), sASLFailure);
        }
        authenticationFailed(sASLErrorException);
    }

    void authenticationFailed(Exception exc) {
        synchronized (this) {
            this.currentMechanism.setException(exc);
            notify();
        }
    }

    public boolean authenticationSuccessful() {
        synchronized (this) {
            SASLMechanism sASLMechanism = this.currentMechanism;
            if (sASLMechanism == null) {
                return false;
            }
            return sASLMechanism.isAuthenticationSuccessful();
        }
    }

    String getNameOfLastUsedSaslMechansism() {
        SASLMechanism sASLMechanism = this.currentMechanism;
        if (sASLMechanism == null) {
            return null;
        }
        return sASLMechanism.getName();
    }

    private SASLMechanism selectMechanism(EntityBareJid entityBareJid, String str) throws SmackException.SmackSaslException {
        boolean zIsNotEmpty = StringUtils.isNotEmpty(str);
        List<String> serverMechanisms = getServerMechanisms();
        if (serverMechanisms.isEmpty()) {
            LOGGER.warning("Server did not report any SASL mechanisms");
        }
        ArrayList arrayList = new ArrayList();
        for (SASLMechanism sASLMechanism : REGISTERED_MECHANISMS) {
            String name = sASLMechanism.getName();
            if (serverMechanisms.contains(name)) {
                Set<String> set = BLACKLISTED_MECHANISMS;
                synchronized (set) {
                    if (!set.contains(name)) {
                        if (!this.configuration.isEnabledSaslMechanism(name)) {
                            continue;
                        } else if (entityBareJid != null && !sASLMechanism.authzidSupported()) {
                            arrayList.add("Skipping " + sASLMechanism + " because authzid is required by not supported by this SASL mechanism");
                        } else if (sASLMechanism.requiresPassword() && !zIsNotEmpty) {
                            arrayList.add("Skipping " + sASLMechanism + " because a password is required for it, but none was provided to the connection configuration");
                        } else {
                            return sASLMechanism.instanceForAuthentication(this.connection, this.configuration);
                        }
                    }
                }
            }
        }
        Set<String> set2 = BLACKLISTED_MECHANISMS;
        synchronized (set2) {
            throw new SmackException.SmackSaslException("No supported and enabled SASL Mechanism provided by server. Server announced mechanisms: " + serverMechanisms + ". Registered SASL mechanisms with Smack: " + REGISTERED_MECHANISMS + ". Enabled SASL mechanisms for this connection: " + this.configuration.getEnabledSaslMechanisms() + ". Blacklisted SASL mechanisms: " + set2 + ". Skip reasons: " + arrayList);
        }
    }

    private List<String> getServerMechanisms() {
        Mechanisms mechanisms = (Mechanisms) this.connection.getFeature(Mechanisms.class);
        if (mechanisms == null) {
            return Collections.emptyList();
        }
        return mechanisms.getMechanisms();
    }
}
