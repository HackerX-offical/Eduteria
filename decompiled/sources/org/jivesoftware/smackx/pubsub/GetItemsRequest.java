package org.jivesoftware.smackx.pubsub;

import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class GetItemsRequest extends NodeExtension {
    protected final int maxItems;
    protected final String subId;

    public GetItemsRequest(String str) {
        this(str, null, -1);
    }

    public GetItemsRequest(String str, String str2) {
        this(str, str2, -1);
    }

    public GetItemsRequest(String str, int i) {
        this(str, null, i);
    }

    public GetItemsRequest(String str, String str2, int i) {
        super(PubSubElementType.ITEMS, str);
        this.maxItems = i;
        this.subId = str2;
    }

    public String getSubscriptionId() {
        return this.subId;
    }

    public int getMaxItems() {
        return this.maxItems;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("subid", getSubscriptionId());
        xmlStringBuilder.optIntAttribute("max_items", getMaxItems());
        xmlStringBuilder.closeEmptyElement();
    }
}
