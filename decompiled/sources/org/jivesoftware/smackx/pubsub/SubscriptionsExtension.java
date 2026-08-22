package org.jivesoftware.smackx.pubsub;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class SubscriptionsExtension extends NodeExtension {
    protected List<Subscription> items;

    public enum SubscriptionsNamespace {
        basic(PubSubElementType.SUBSCRIPTIONS),
        owner(PubSubElementType.SUBSCRIPTIONS_OWNER);

        public final PubSubElementType type;

        SubscriptionsNamespace(PubSubElementType pubSubElementType) {
            this.type = pubSubElementType;
        }

        public static SubscriptionsNamespace fromXmlns(String str) {
            for (SubscriptionsNamespace subscriptionsNamespace : values()) {
                if (subscriptionsNamespace.type.getNamespace().getXmlns().equals(str)) {
                    return subscriptionsNamespace;
                }
            }
            throw new IllegalArgumentException("Invalid Subscription namespace: " + str);
        }
    }

    public SubscriptionsExtension(List<Subscription> list) {
        this(SubscriptionsNamespace.basic, null, list);
    }

    public SubscriptionsExtension(String str, List<Subscription> list) {
        this(SubscriptionsNamespace.basic, str, list);
    }

    public SubscriptionsExtension(SubscriptionsNamespace subscriptionsNamespace, String str, List<Subscription> list) {
        super(subscriptionsNamespace.type, str);
        this.items = Collections.emptyList();
        if (list != null) {
            this.items = list;
        }
    }

    public List<Subscription> getSubscriptions() {
        return this.items;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        List<Subscription> list = this.items;
        if (list == null || list.size() == 0) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.items);
        xmlStringBuilder.closeElement(this);
    }
}
