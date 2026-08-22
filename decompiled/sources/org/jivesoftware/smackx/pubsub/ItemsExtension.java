package org.jivesoftware.smackx.pubsub;

import com.clevertap.android.sdk.Constants;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class ItemsExtension extends NodeExtension implements EmbeddedPacketExtension {
    protected List<? extends NamedElement> items;
    protected Boolean notify;
    protected ItemsElementType type;

    public enum ItemsElementType {
        items(PubSubElementType.ITEMS, "max_items"),
        retract(PubSubElementType.RETRACT, "notify");

        private final String att;
        private final PubSubElementType elem;

        ItemsElementType(PubSubElementType pubSubElementType, String str) {
            this.elem = pubSubElementType;
            this.att = str;
        }

        public PubSubElementType getNodeElement() {
            return this.elem;
        }

        public String getElementAttribute() {
            return this.att;
        }
    }

    public ItemsExtension(ItemsElementType itemsElementType, String str, List<? extends NamedElement> list) {
        super(itemsElementType.getNodeElement(), str);
        this.type = itemsElementType;
        this.items = list;
    }

    public ItemsExtension(String str, List<? extends ExtensionElement> list, boolean z) {
        super(ItemsElementType.retract.getNodeElement(), str);
        this.type = ItemsElementType.retract;
        this.items = list;
        this.notify = Boolean.valueOf(z);
    }

    public ItemsElementType getItemsElementType() {
        return this.type;
    }

    @Override // org.jivesoftware.smackx.pubsub.EmbeddedPacketExtension
    public List<ExtensionElement> getExtensions() {
        return getItems();
    }

    public List<? extends NamedElement> getItems() {
        return this.items;
    }

    public boolean getNotify() {
        return this.notify.booleanValue();
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        List<? extends NamedElement> list = this.items;
        if (list == null || list.size() == 0) {
            xmlStringBuilder.closeEmptyElement();
            return;
        }
        if (this.notify != null) {
            xmlStringBuilder.attribute(this.type.getElementAttribute(), this.notify.booleanValue());
            xmlStringBuilder.rightAngleBracket();
        } else {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(this.items);
        }
        xmlStringBuilder.closeElement(this);
    }

    @Override // org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + "Content [" + ((Object) toXML()) + Constants.AES_SUFFIX;
    }
}
