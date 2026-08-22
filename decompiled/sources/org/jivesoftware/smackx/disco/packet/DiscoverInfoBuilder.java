package org.jivesoftware.smackx.disco.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IqBuilder;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

/* JADX INFO: loaded from: classes10.dex */
public class DiscoverInfoBuilder extends IqBuilder<DiscoverInfoBuilder, DiscoverInfo> implements DiscoverInfoView {
    private final List<DiscoverInfo.Feature> features;
    private final List<DiscoverInfo.Identity> identities;
    private String node;

    @Override // org.jivesoftware.smack.packet.StanzaBuilder
    public DiscoverInfoBuilder getThis() {
        return this;
    }

    DiscoverInfoBuilder(IqData iqData) {
        super(iqData);
        this.features = new ArrayList();
        this.identities = new ArrayList();
    }

    DiscoverInfoBuilder(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.features = new ArrayList();
        this.identities = new ArrayList();
    }

    DiscoverInfoBuilder(String str) {
        super(str);
        this.features = new ArrayList();
        this.identities = new ArrayList();
    }

    public DiscoverInfoBuilder(DiscoverInfo discoverInfo, String str) {
        super(discoverInfo, str);
        ArrayList arrayList = new ArrayList();
        this.features = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.identities = arrayList2;
        arrayList.addAll(discoverInfo.getFeatures());
        arrayList2.addAll(discoverInfo.getIdentities());
        this.node = discoverInfo.getNode();
    }

    public DiscoverInfoBuilder addFeatures(Collection<String> collection) {
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            addFeature(it.next());
        }
        return getThis();
    }

    public DiscoverInfoBuilder addFeature(String str) {
        return addFeature(new DiscoverInfo.Feature(str));
    }

    public DiscoverInfoBuilder addFeature(DiscoverInfo.Feature feature) {
        this.features.add(feature);
        return getThis();
    }

    public DiscoverInfoBuilder addIdentities(Collection<DiscoverInfo.Identity> collection) {
        this.identities.addAll(collection);
        return getThis();
    }

    public DiscoverInfoBuilder addIdentity(DiscoverInfo.Identity identity) {
        this.identities.add(identity);
        return getThis();
    }

    public DiscoverInfoBuilder setNode(String str) {
        this.node = str;
        return getThis();
    }

    @Override // org.jivesoftware.smack.packet.IqBuilder, org.jivesoftware.smack.packet.StanzaBuilder
    public DiscoverInfo build() {
        return new DiscoverInfo(this, true);
    }

    public DiscoverInfo buildWithoutValidiation() {
        return new DiscoverInfo(this, false);
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public List<DiscoverInfo.Feature> getFeatures() {
        return this.features;
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public List<DiscoverInfo.Identity> getIdentities() {
        return this.identities;
    }

    @Override // org.jivesoftware.smackx.disco.packet.DiscoverInfoView
    public String getNode() {
        return this.node;
    }

    public static DiscoverInfoBuilder buildResponseFor(DiscoverInfo discoverInfo, IQ.ResponseType responseType) {
        DiscoverInfoBuilder discoverInfoBuilder = new DiscoverInfoBuilder(createResponse(discoverInfo, responseType));
        discoverInfoBuilder.setNode(discoverInfo.getNode());
        return discoverInfoBuilder;
    }
}
