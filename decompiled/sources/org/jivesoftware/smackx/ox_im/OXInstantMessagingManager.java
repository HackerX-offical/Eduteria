package org.jivesoftware.smackx.ox_im;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.bouncycastle.openpgp.PGPException;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.eme.element.ExplicitMessageEncryptionElement;
import org.jivesoftware.smackx.hints.element.StoreHint;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.OpenPgpManager;
import org.jivesoftware.smackx.ox.OpenPgpMessage;
import org.jivesoftware.smackx.ox.crypto.OpenPgpElementAndMetadata;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener;
import org.jxmpp.jid.BareJid;
import org.jxmpp.jid.Jid;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public final class OXInstantMessagingManager extends Manager {
    private static final Map<XMPPConnection, OXInstantMessagingManager> INSTANCES = new WeakHashMap();
    public static final String NAMESPACE_0 = "urn:xmpp:openpgp:im:0";
    private final OpenPgpManager openPgpManager;
    private final Set<OxMessageListener> oxMessageListeners;

    private OXInstantMessagingManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.oxMessageListeners = new HashSet();
        OpenPgpManager instanceFor = OpenPgpManager.getInstanceFor(xMPPConnection);
        this.openPgpManager = instanceFor;
        instanceFor.registerSigncryptReceivedListener(new SigncryptElementReceivedListener() { // from class: org.jivesoftware.smackx.ox_im.OXInstantMessagingManager$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smackx.ox.listener.SigncryptElementReceivedListener
            public final void signcryptElementReceived(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, OpenPgpMetadata openPgpMetadata) {
                this.f$0.signcryptElementReceivedListener(openPgpContact, message, signcryptElement, openPgpMetadata);
            }
        });
        announceSupportForOxInstantMessaging();
    }

    public static synchronized OXInstantMessagingManager getInstanceFor(XMPPConnection xMPPConnection) {
        OXInstantMessagingManager oXInstantMessagingManager;
        Map<XMPPConnection, OXInstantMessagingManager> map = INSTANCES;
        oXInstantMessagingManager = map.get(xMPPConnection);
        if (oXInstantMessagingManager == null) {
            oXInstantMessagingManager = new OXInstantMessagingManager(xMPPConnection);
            map.put(xMPPConnection, oXInstantMessagingManager);
        }
        return oXInstantMessagingManager;
    }

    public void announceSupportForOxInstantMessaging() {
        ServiceDiscoveryManager.getInstanceFor(connection()).addFeature(NAMESPACE_0);
    }

    public boolean contactSupportsOxInstantMessaging(BareJid bareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(connection()).supportsFeature(bareJid, NAMESPACE_0);
    }

    public boolean contactSupportsOxInstantMessaging(OpenPgpContact openPgpContact) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return contactSupportsOxInstantMessaging(openPgpContact.getJid());
    }

    public boolean addOxMessageListener(OxMessageListener oxMessageListener) {
        return this.oxMessageListeners.add(oxMessageListener);
    }

    public boolean removeOxMessageListener(OxMessageListener oxMessageListener) {
        return this.oxMessageListeners.remove(oxMessageListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPgpMetadata sendOxMessage(OpenPgpContact openPgpContact, CharSequence charSequence) throws SmackException.NotConnectedException, InterruptedException, IOException, PGPException, SmackException.NotLoggedInException {
        MessageBuilder messageBuilder = (MessageBuilder) connection().getStanzaFactory().buildMessageStanza().to((Jid) openPgpContact.getJid());
        OpenPgpMetadata openPgpMetadataAddOxMessage = addOxMessage(messageBuilder, openPgpContact, Collections.singletonList(new Message.Body(null, charSequence.toString())));
        ChatManager.getInstanceFor(connection()).chatWith(openPgpContact.getJid().asEntityBareJidIfPossible()).send(messageBuilder.build());
        return openPgpMetadataAddOxMessage;
    }

    public OpenPgpMetadata addOxMessage(MessageBuilder messageBuilder, OpenPgpContact openPgpContact, List<ExtensionElement> list) throws IOException, PGPException, SmackException.NotLoggedInException {
        return addOxMessage(messageBuilder, Collections.singleton(openPgpContact), list);
    }

    public OpenPgpMetadata addOxMessage(MessageBuilder messageBuilder, Set<OpenPgpContact> set, List<ExtensionElement> list) throws IOException, PGPException, SmackException.NotLoggedInException {
        OpenPgpElementAndMetadata openPgpElementAndMetadataSignAndEncrypt = signAndEncrypt(set, list);
        messageBuilder.addExtension(openPgpElementAndMetadataSignAndEncrypt.getElement());
        ExplicitMessageEncryptionElement.set(messageBuilder, ExplicitMessageEncryptionElement.ExplicitMessageEncryptionProtocol.openpgpV0);
        StoreHint.set(messageBuilder);
        setOXBodyHint(messageBuilder);
        return openPgpElementAndMetadataSignAndEncrypt.getMetadata();
    }

    public OpenPgpElementAndMetadata signAndEncrypt(Set<OpenPgpContact> set, List<ExtensionElement> list) throws IOException, PGPException, SmackException.NotLoggedInException {
        HashSet hashSet = new HashSet();
        Iterator<OpenPgpContact> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getJid());
        }
        hashSet.add(this.openPgpManager.getOpenPgpSelf().getJid());
        return this.openPgpManager.getOpenPgpProvider().signAndEncrypt(new SigncryptElement(hashSet, list), this.openPgpManager.getOpenPgpSelf(), set);
    }

    public OpenPgpMessage decryptAndVerify(OpenPgpElement openPgpElement, OpenPgpContact openPgpContact) throws XmlPullParserException, IOException, PGPException, SmackException.NotLoggedInException {
        OpenPgpMessage openPgpMessageDecryptOpenPgpElement = this.openPgpManager.decryptOpenPgpElement(openPgpElement, openPgpContact);
        if (openPgpMessageDecryptOpenPgpElement.getState() == OpenPgpMessage.State.signcrypt) {
            return openPgpMessageDecryptOpenPgpElement;
        }
        throw new IllegalArgumentException("Decrypted message does appear to not be an OX message. (State: " + openPgpMessageDecryptOpenPgpElement.getState() + ")");
    }

    private static void setOXBodyHint(MessageBuilder messageBuilder) {
        messageBuilder.setBody("This message is encrypted using XEP-0374: OpenPGP for XMPP: Instant Messaging.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signcryptElementReceivedListener(OpenPgpContact openPgpContact, Message message, SigncryptElement signcryptElement, OpenPgpMetadata openPgpMetadata) {
        Iterator<OxMessageListener> it = this.oxMessageListeners.iterator();
        while (it.hasNext()) {
            it.next().newIncomingOxMessage(openPgpContact, message, signcryptElement, openPgpMetadata);
        }
    }
}
