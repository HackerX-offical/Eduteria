package org.jivesoftware.smackx.ox.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.ox.OpenPgpManager;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;
import org.jivesoftware.smackx.pep.PepManager;
import org.jivesoftware.smackx.pubsub.AccessModel;
import org.jivesoftware.smackx.pubsub.LeafNode;
import org.jivesoftware.smackx.pubsub.Node;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jivesoftware.smackx.pubsub.PubSubManager;
import org.jivesoftware.smackx.pubsub.form.ConfigureForm;
import org.jivesoftware.smackx.pubsub.form.FillableConfigureForm;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpPubSubUtil {
    private static final Logger LOGGER = Logger.getLogger(OpenPgpPubSubUtil.class.getName());
    public static final String PEP_NODE_PUBLIC_KEYS = "urn:xmpp:openpgp:0:public-keys";
    public static final String PEP_NODE_PUBLIC_KEYS_NOTIFY = "urn:xmpp:openpgp:0:public-keys+notify";
    public static final String PEP_NODE_SECRET_KEY = "urn:xmpp:openpgp:0:secret-key";

    public static String PEP_NODE_PUBLIC_KEY(OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        return "urn:xmpp:openpgp:0:public-keys:" + ((Object) openPgpV4Fingerprint);
    }

    public static void changeAccessModelIfNecessary(LeafNode leafNode, AccessModel accessModel) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ConfigureForm nodeConfiguration = leafNode.getNodeConfiguration();
        if (nodeConfiguration.getAccessModel() != accessModel) {
            FillableConfigureForm fillableForm = nodeConfiguration.getFillableForm();
            fillableForm.setAccessModel(accessModel);
            leafNode.sendConfigurationForm(fillableForm);
        }
    }

    public static void publishPublicKey(PepManager pepManager, PubkeyElement pubkeyElement, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        String strPEP_NODE_PUBLIC_KEY = PEP_NODE_PUBLIC_KEY(openPgpV4Fingerprint);
        PubSubManager pepPubSubManager = pepManager.getPepPubSubManager();
        LeafNode orCreateLeafNode = pepPubSubManager.getOrCreateLeafNode(strPEP_NODE_PUBLIC_KEY);
        changeAccessModelIfNecessary(orCreateLeafNode, AccessModel.open);
        if (orCreateLeafNode.getItems(1).isEmpty()) {
            LOGGER.log(Level.FINE, "Node " + strPEP_NODE_PUBLIC_KEY + " is empty. Publish.");
            orCreateLeafNode.publish(new PayloadItem(pubkeyElement));
        } else {
            LOGGER.log(Level.FINE, "Node " + strPEP_NODE_PUBLIC_KEY + " already contains key. Skip.");
        }
        LeafNode orCreateLeafNode2 = pepPubSubManager.getOrCreateLeafNode(PEP_NODE_PUBLIC_KEYS);
        changeAccessModelIfNecessary(orCreateLeafNode2, AccessModel.open);
        List items = orCreateLeafNode2.getItems(1);
        PublicKeysListElement.Builder builder = PublicKeysListElement.builder();
        if (!items.isEmpty() && ((PayloadItem) items.get(0)).getPayload() != null) {
            Iterator<PublicKeysListElement.PubkeyMetadataElement> it = ((PublicKeysListElement) ((PayloadItem) items.get(0)).getPayload()).getMetadata().values().iterator();
            while (it.hasNext()) {
                builder.addMetadata(it.next());
            }
        }
        builder.addMetadata(new PublicKeysListElement.PubkeyMetadataElement(openPgpV4Fingerprint, new Date()));
        orCreateLeafNode2.publish(new PayloadItem(builder.build()));
    }

    public static PublicKeysListElement fetchPubkeysList(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotAPubSubNodeException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        return fetchPubkeysList(xMPPConnection, null);
    }

    public static PublicKeysListElement fetchPubkeysList(XMPPConnection xMPPConnection, BareJid bareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, PubSubException.NotAPubSubNodeException, XMPPException.XMPPErrorException {
        List items = getLeafNode(PubSubManager.getInstanceFor(xMPPConnection, bareJid), PEP_NODE_PUBLIC_KEYS).getItems(1);
        if (items.isEmpty()) {
            return null;
        }
        return (PublicKeysListElement) ((PayloadItem) items.get(0)).getPayload();
    }

    public static boolean deletePubkeysListNode(PepManager pepManager) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_PUBLIC_KEYS);
    }

    public static boolean deletePublicKeyNode(PepManager pepManager, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_PUBLIC_KEY(openPgpV4Fingerprint));
    }

    public static PubkeyElement fetchPubkey(XMPPConnection xMPPConnection, BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotAPubSubNodeException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        List items = getLeafNode(PubSubManager.getInstanceFor(xMPPConnection, bareJid), PEP_NODE_PUBLIC_KEY(openPgpV4Fingerprint)).getItems(1);
        if (items.isEmpty()) {
            return null;
        }
        return (PubkeyElement) ((PayloadItem) items.get(0)).getPayload();
    }

    static LeafNode getLeafNode(PubSubManager pubSubManager, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, PubSubException.NotALeafNodeException, InterruptedException, PubSubException.NotAPubSubNodeException, XMPPException.XMPPErrorException {
        try {
            return pubSubManager.getLeafNode(str);
        } catch (XMPPException.XMPPErrorException e2) {
            if (e2.getStanzaError().getCondition() == StanzaError.Condition.subscription_required) {
                return getOpenLeafNode(pubSubManager, str);
            }
            throw e2;
        }
    }

    public static void depositSecretKey(XMPPConnection xMPPConnection, SecretkeyElement secretkeyElement) throws SmackException.NotConnectedException, SmackException.NoResponseException, SmackException.FeatureNotSupportedException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        if (!OpenPgpManager.serverSupportsSecretKeyBackups(xMPPConnection)) {
            throw new SmackException.FeatureNotSupportedException("http://jabber.org/protocol/pubsub#access-whitelist");
        }
        LeafNode orCreateLeafNode = PepManager.getInstanceFor(xMPPConnection).getPepPubSubManager().getOrCreateLeafNode(PEP_NODE_SECRET_KEY);
        changeAccessModelIfNecessary(orCreateLeafNode, AccessModel.whitelist);
        orCreateLeafNode.publish(new PayloadItem(secretkeyElement));
    }

    public static SecretkeyElement fetchSecretKey(PepManager pepManager) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, XMPPException.XMPPErrorException {
        List items = pepManager.getPepPubSubManager().getOrCreateLeafNode(PEP_NODE_SECRET_KEY).getItems(1);
        if (items.size() == 0) {
            LOGGER.log(Level.INFO, "No secret key published!");
            return null;
        }
        return (SecretkeyElement) ((PayloadItem) items.get(0)).getPayload();
    }

    public static boolean deleteSecretKeyNode(PepManager pepManager) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return pepManager.getPepPubSubManager().deleteNode(PEP_NODE_SECRET_KEY);
    }

    public static LeafNode getOpenLeafNode(PubSubManager pubSubManager, String str) throws PubSubException.NotALeafNodeException {
        try {
            Field declaredField = pubSubManager.getClass().getDeclaredField("nodeMap");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(pubSubManager);
            Node node = (Node) map.get(str);
            if (node != null) {
                if (node instanceof LeafNode) {
                    return (LeafNode) node;
                }
                Constructor declaredConstructor = PubSubException.NotALeafNodeException.class.getDeclaredConstructor(String.class, BareJid.class);
                declaredConstructor.setAccessible(true);
                throw ((PubSubException.NotALeafNodeException) declaredConstructor.newInstance(str, pubSubManager.getServiceJid()));
            }
            Constructor declaredConstructor2 = LeafNode.class.getDeclaredConstructor(PubSubManager.class, String.class);
            declaredConstructor2.setAccessible(true);
            LeafNode leafNode = (LeafNode) declaredConstructor2.newInstance(pubSubManager, str);
            map.put(str, leafNode);
            return leafNode;
        } catch (IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
            LOGGER.log(Level.SEVERE, "Using reflections to create a LeafNode and put it into PubSubManagers nodeMap failed.", e2);
            throw new AssertionError(e2);
        }
    }
}
