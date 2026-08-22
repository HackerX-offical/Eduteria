package org.jivesoftware.smackx.address;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaFactory;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MultipleRecipientManager {
    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, XMPPException.XMPPErrorException {
        send(xMPPConnection, stanza, collection, collection2, collection3, null, null, false);
    }

    public static void send(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3, Jid jid, Jid jid2, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, XMPPException.XMPPErrorException {
        if (collection != null && collection.size() == 1 && ((collection2 == null || collection2.isEmpty()) && ((collection3 == null || collection3.isEmpty()) && !z && StringUtils.isNullOrEmpty(jid) && StringUtils.isNullOrEmpty(jid2)))) {
            stanza.setTo(collection.iterator().next());
            xMPPConnection.sendStanza(stanza);
            return;
        }
        DomainBareJid multipleRecipientServiceAddress = getMultipleRecipientServiceAddress(xMPPConnection);
        if (multipleRecipientServiceAddress != null) {
            sendThroughService(xMPPConnection, stanza, collection, collection2, collection3, jid, jid2, z, multipleRecipientServiceAddress);
        } else {
            if (z || jid != null || jid2 != null) {
                throw new SmackException.FeatureNotSupportedException("Extended Stanza Addressing");
            }
            sendToIndividualRecipients(xMPPConnection, stanza, collection, collection2, collection3);
        }
    }

    public static void reply(XMPPConnection xMPPConnection, Message message, Message message2) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, XMPPException.XMPPErrorException {
        MultipleRecipientInfo multipleRecipientInfo = getMultipleRecipientInfo(message);
        if (multipleRecipientInfo == null) {
            throw new IllegalArgumentException("Original message does not contain multiple recipient info");
        }
        if (multipleRecipientInfo.shouldNotReply()) {
            throw new IllegalArgumentException("Original message should not be replied");
        }
        if (multipleRecipientInfo.getReplyRoom() != null) {
            throw new IllegalArgumentException("Reply should be sent through a room");
        }
        if (message.getThread() != null) {
            message2.asBuilder().setThread(message.getThread()).build();
        }
        MultipleAddresses.Address replyAddress = multipleRecipientInfo.getReplyAddress();
        if (replyAddress != null && replyAddress.getJid() != null) {
            message2.setTo(replyAddress.getJid());
            xMPPConnection.sendStanza(message2);
            return;
        }
        ArrayList arrayList = new ArrayList(multipleRecipientInfo.getTOAddresses().size());
        ArrayList arrayList2 = new ArrayList(multipleRecipientInfo.getCCAddresses().size());
        Iterator<MultipleAddresses.Address> it = multipleRecipientInfo.getTOAddresses().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getJid());
        }
        Iterator<MultipleAddresses.Address> it2 = multipleRecipientInfo.getCCAddresses().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().getJid());
        }
        if (!arrayList.contains(message.getFrom()) && !arrayList2.contains(message.getFrom())) {
            arrayList.add(message.getFrom());
        }
        EntityFullJid user = xMPPConnection.getUser();
        if (!arrayList.remove(user) && !arrayList2.remove(user)) {
            EntityBareJid entityBareJidAsEntityBareJid = user.asEntityBareJid();
            arrayList.remove(entityBareJidAsEntityBareJid);
            arrayList2.remove(entityBareJidAsEntityBareJid);
        }
        send(xMPPConnection, message2, arrayList, arrayList2, null, null, null, false);
    }

    public static MultipleRecipientInfo getMultipleRecipientInfo(Stanza stanza) {
        MultipleAddresses multipleAddresses = (MultipleAddresses) stanza.getExtension(MultipleAddresses.class);
        if (multipleAddresses == null) {
            return null;
        }
        return new MultipleRecipientInfo(multipleAddresses);
    }

    private static void sendToIndividualRecipients(XMPPConnection xMPPConnection, StanzaView stanzaView, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3) throws SmackException.NotConnectedException, InterruptedException {
        StanzaBuilder stanzaBuilderBuildPresenceStanzaFrom;
        StanzaFactory stanzaFactory = xMPPConnection.getStanzaFactory();
        if (stanzaView instanceof Message) {
            stanzaBuilderBuildPresenceStanzaFrom = stanzaFactory.buildMessageStanzaFrom((Message) stanzaView);
        } else if (stanzaView instanceof Presence) {
            stanzaBuilderBuildPresenceStanzaFrom = stanzaFactory.buildPresenceStanzaFrom((Presence) stanzaView);
        } else {
            if (stanzaView instanceof IQ) {
                throw new IllegalArgumentException("IQ stanzas have no supported fallback in case no XEP-0033 service is available");
            }
            throw new AssertionError();
        }
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection2 == null) {
            collection2 = Collections.emptyList();
        }
        if (collection3 == null) {
            collection3 = Collections.emptyList();
        }
        int size = collection.size() + collection2.size() + collection3.size();
        ArrayList arrayList = new ArrayList(size);
        arrayList.addAll(collection);
        arrayList.addAll(collection2);
        arrayList.addAll(collection3);
        ArrayList arrayList2 = new ArrayList(size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(stanzaBuilderBuildPresenceStanzaFrom.to((Jid) it.next()).build());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            xMPPConnection.sendStanza((Stanza) it2.next());
        }
    }

    private static void sendThroughService(XMPPConnection xMPPConnection, Stanza stanza, Collection<? extends Jid> collection, Collection<? extends Jid> collection2, Collection<? extends Jid> collection3, Jid jid, Jid jid2, boolean z, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, InterruptedException {
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        if (collection != null) {
            Iterator<? extends Jid> it = collection.iterator();
            while (it.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.to, it.next(), null, null, false, null);
            }
        }
        if (collection2 != null) {
            Iterator<? extends Jid> it2 = collection2.iterator();
            while (it2.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.to, it2.next(), null, null, false, null);
            }
        }
        if (collection3 != null) {
            Iterator<? extends Jid> it3 = collection3.iterator();
            while (it3.hasNext()) {
                multipleAddresses.addAddress(MultipleAddresses.Type.bcc, it3.next(), null, null, false, null);
            }
        }
        if (z) {
            multipleAddresses.setNoReply();
        } else {
            if (jid != null) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyto, jid, null, null, false, null);
            }
            if (jid2 != null) {
                multipleAddresses.addAddress(MultipleAddresses.Type.replyroom, jid2, null, null, false, null);
            }
        }
        stanza.setTo(domainBareJid);
        stanza.addExtension(multipleAddresses);
        xMPPConnection.sendStanza(stanza);
    }

    private static DomainBareJid getMultipleRecipientServiceAddress(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(xMPPConnection).findService(MultipleAddresses.NAMESPACE, true);
    }
}
