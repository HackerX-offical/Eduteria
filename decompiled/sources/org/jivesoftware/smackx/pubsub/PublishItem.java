package org.jivesoftware.smackx.pubsub;

import java.util.ArrayList;
import java.util.Collection;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Item;

/* JADX INFO: loaded from: classes10.dex */
public class PublishItem<T extends Item> extends NodeExtension {
    protected Collection<T> items;

    public PublishItem(String str, T t) {
        super(PubSubElementType.PUBLISH, str);
        ArrayList arrayList = new ArrayList(1);
        this.items = arrayList;
        arrayList.add(t);
    }

    public PublishItem(String str, Collection<T> collection) {
        super(PubSubElementType.PUBLISH, str);
        this.items = collection;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((Collection<? extends Element>) this.items);
        xmlStringBuilder.closeElement(this);
    }
}
