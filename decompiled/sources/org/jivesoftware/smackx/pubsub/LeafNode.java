package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.pubsub.ItemsExtension;
import org.jivesoftware.smackx.pubsub.packet.PubSub;

/* JADX INFO: loaded from: classes10.dex */
public class LeafNode extends Node {
    LeafNode(PubSubManager pubSubManager, String str) {
        super(pubSubManager, str);
    }

    public DiscoverItems discoverItems() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setTo(this.pubSubManager.getServiceJid());
        discoverItems.setNode(getId());
        return (DiscoverItems) this.pubSubManager.getConnection().createStanzaCollectorAndSend(discoverItems).nextResultOrThrow();
    }

    public <T extends Item> List<T> getItems() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getItems((List<ExtensionElement>) null, (List<ExtensionElement>) null);
    }

    public <T extends Item> List<T> getItems(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), str)));
    }

    public <T extends Item> List<T> getItems(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new Item(it.next()));
        }
        return getItems(createPubsubPacket(IQ.Type.get, new ItemsExtension(ItemsExtension.ItemsElementType.items, getId(), arrayList)));
    }

    public <T extends Item> List<T> getItems(int i) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), i)));
    }

    public <T extends Item> List<T> getItems(int i, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getItems(createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId(), str, i)));
    }

    public <T extends Item> List<T> getItems(List<ExtensionElement> list, List<ExtensionElement> list2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSub pubSubCreatePubsubPacket = createPubsubPacket(IQ.Type.get, new GetItemsRequest(getId()));
        pubSubCreatePubsubPacket.addExtensions(list);
        return getItems(pubSubCreatePubsubPacket, list2);
    }

    private <T extends Item> List<T> getItems(PubSub pubSub) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return getItems(pubSub, (List<ExtensionElement>) null);
    }

    private <T extends Item> List<T> getItems(PubSub pubSub, List<ExtensionElement> list) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        PubSub pubSub2 = (PubSub) this.pubSubManager.getConnection().createStanzaCollectorAndSend(pubSub).nextResultOrThrow();
        ItemsExtension itemsExtension = (ItemsExtension) pubSub2.getExtension(PubSubElementType.ITEMS);
        if (list != null) {
            list.addAll(pubSub2.getExtensions());
        }
        return (List<T>) itemsExtension.getItems();
    }

    @Deprecated
    public void send() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        publish();
    }

    @Deprecated
    public <T extends Item> void send(T t) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        publish(t);
    }

    @Deprecated
    public <T extends Item> void send(Collection<T> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        publish(collection);
    }

    public void publish() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.PUBLISH, getId()))).nextResultOrThrow();
    }

    public <T extends Item> void publish(T t) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList(1);
        if (t == null) {
            t = (T) new Item();
        }
        arrayList.add(t);
        publish(arrayList);
    }

    public <T extends Item> void publish(Collection<T> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new PublishItem(getId(), collection))).nextResultOrThrow();
    }

    public void deleteAllItems() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new NodeExtension(PubSubElementType.PURGE_OWNER, getId()))).nextResultOrThrow();
    }

    public void deleteItem(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        deleteItem(arrayList);
    }

    public void deleteItem(Collection<String> collection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new Item(it.next()));
        }
        this.pubSubManager.getConnection().createStanzaCollectorAndSend(createPubsubPacket(IQ.Type.set, new ItemsExtension(ItemsExtension.ItemsElementType.retract, getId(), arrayList))).nextResultOrThrow();
    }
}
