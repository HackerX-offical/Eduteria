package org.jivesoftware.smackx.iqregister;

import androidx.autofill.HintConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaIdFilter;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.iqregister.packet.Registration;
import org.jxmpp.jid.parts.Localpart;

/* JADX INFO: loaded from: classes10.dex */
public final class AccountManager extends Manager {
    private static final Map<XMPPConnection, AccountManager> INSTANCES = new WeakHashMap();
    private static boolean allowSensitiveOperationOverInsecureConnectionDefault = false;
    private boolean accountCreationSupported;
    private boolean allowSensitiveOperationOverInsecureConnection;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private Registration f1498info;

    public static synchronized AccountManager getInstance(XMPPConnection xMPPConnection) {
        AccountManager accountManager;
        Map<XMPPConnection, AccountManager> map = INSTANCES;
        accountManager = map.get(xMPPConnection);
        if (accountManager == null) {
            accountManager = new AccountManager(xMPPConnection);
            map.put(xMPPConnection, accountManager);
        }
        return accountManager;
    }

    public static void sensitiveOperationOverInsecureConnectionDefault(boolean z) {
        allowSensitiveOperationOverInsecureConnectionDefault = z;
    }

    public void sensitiveOperationOverInsecureConnection(boolean z) {
        this.allowSensitiveOperationOverInsecureConnection = z;
    }

    private AccountManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.allowSensitiveOperationOverInsecureConnection = allowSensitiveOperationOverInsecureConnectionDefault;
        this.f1498info = null;
        this.accountCreationSupported = false;
    }

    void setSupportsAccountCreation(boolean z) {
        this.accountCreationSupported = z;
    }

    public boolean supportsAccountCreation() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.accountCreationSupported) {
            return true;
        }
        if (this.f1498info == null) {
            getRegistrationInfo();
            this.accountCreationSupported = this.f1498info.getType() != IQ.Type.error;
        }
        return this.accountCreationSupported;
    }

    public Set<String> getAccountAttributes() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.f1498info == null) {
            getRegistrationInfo();
        }
        Map<String, String> attributes = this.f1498info.getAttributes();
        if (attributes != null) {
            return Collections.unmodifiableSet(attributes.keySet());
        }
        return Collections.emptySet();
    }

    public String getAccountAttribute(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.f1498info == null) {
            getRegistrationInfo();
        }
        return this.f1498info.getAttributes().get(str);
    }

    public String getAccountInstructions() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (this.f1498info == null) {
            getRegistrationInfo();
        }
        return this.f1498info.getInstructions();
    }

    public void createAccount(Localpart localpart, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap map = new HashMap();
        Iterator<String> it = getAccountAttributes().iterator();
        while (it.hasNext()) {
            map.put(it.next(), "");
        }
        createAccount(localpart, str, map);
    }

    public void createAccount(Localpart localpart, String str, Map<String, String> map) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (!connection().isSecureConnection() && !this.allowSensitiveOperationOverInsecureConnection) {
            throw new IllegalStateException("Creating account over insecure connection");
        }
        if (localpart == null) {
            throw new IllegalArgumentException("Username must not be null");
        }
        if (StringUtils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Password must not be null");
        }
        map.put(HintConstants.AUTOFILL_HINT_USERNAME, localpart.toString());
        map.put("password", str);
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getXMPPServiceDomain());
        createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public void changePassword(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        if (!connection().isSecureConnection() && !this.allowSensitiveOperationOverInsecureConnection) {
            throw new IllegalStateException("Changing password over insecure connection.");
        }
        HashMap map = new HashMap();
        map.put(HintConstants.AUTOFILL_HINT_USERNAME, connection().getUser().getLocalpart().toString());
        map.put("password", str);
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getXMPPServiceDomain());
        createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public void deleteAccount() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        HashMap map = new HashMap();
        map.put("remove", "");
        Registration registration = new Registration(map);
        registration.setType(IQ.Type.set);
        registration.setTo(connection().getXMPPServiceDomain());
        createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    public boolean isSupported() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        XMPPConnection xMPPConnectionConnection = connection();
        if (((ExtensionElement) xMPPConnectionConnection.getFeature(Registration.Feature.class)) != null) {
            return true;
        }
        if (xMPPConnectionConnection.isAuthenticated()) {
            return ServiceDiscoveryManager.getInstanceFor(xMPPConnectionConnection).serverSupportsFeature(Registration.NAMESPACE);
        }
        return false;
    }

    private synchronized void getRegistrationInfo() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        Registration registration = new Registration();
        registration.setTo(connection().getXMPPServiceDomain());
        this.f1498info = (Registration) createStanzaCollectorAndSend(registration).nextResultOrThrow();
    }

    private StanzaCollector createStanzaCollectorAndSend(IQ iq) throws SmackException.NotConnectedException, InterruptedException {
        return connection().createStanzaCollectorAndSend(new StanzaIdFilter(iq.getStanzaId()), iq);
    }
}
