package org.jivesoftware.smackx.pubsub;

import com.clevertap.android.sdk.Constants;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Item extends NodeExtension {
    private final String itemId;

    public enum ItemNamespace {
        pubsub(PubSubElementType.ITEM),
        event(PubSubElementType.ITEM_EVENT);

        private final PubSubElementType type;

        ItemNamespace(PubSubElementType pubSubElementType) {
            this.type = pubSubElementType;
        }

        public static ItemNamespace fromXmlns(String str) {
            for (ItemNamespace itemNamespace : values()) {
                if (itemNamespace.type.getNamespace().getXmlns().equals(str)) {
                    return itemNamespace;
                }
            }
            throw new IllegalArgumentException("Invalid item namespace: " + str);
        }
    }

    public Item() {
        this(ItemNamespace.pubsub, null, null);
    }

    public Item(String str) {
        this(ItemNamespace.pubsub, str, null);
    }

    public Item(ItemNamespace itemNamespace, String str) {
        this(itemNamespace, str, null);
    }

    public Item(String str, String str2) {
        this(ItemNamespace.pubsub, str, str2);
    }

    public Item(ItemNamespace itemNamespace, String str, String str2) {
        super(itemNamespace.type, str2);
        this.itemId = str;
    }

    public String getId() {
        return this.itemId;
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("id", getId());
        xmlStringBuilder.closeEmptyElement();
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + " | Content [" + ((Object) toXML()) + Constants.AES_SUFFIX;
    }
}
