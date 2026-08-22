package org.jivesoftware.smackx.pubsub;

import com.clevertap.android.sdk.Constants;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.pubsub.Item;

/* JADX INFO: loaded from: classes10.dex */
public class PayloadItem<E extends ExtensionElement> extends Item {
    private final E payload;

    public PayloadItem(E e2) {
        if (e2 == null) {
            throw new IllegalArgumentException("payload cannot be 'null'");
        }
        this.payload = e2;
    }

    public PayloadItem(String str, E e2) {
        super(str);
        if (e2 == null) {
            throw new IllegalArgumentException("payload cannot be 'null'");
        }
        this.payload = e2;
    }

    public PayloadItem(String str, String str2, E e2) {
        this(Item.ItemNamespace.pubsub, str, str2, e2);
    }

    public PayloadItem(Item.ItemNamespace itemNamespace, String str, String str2, E e2) {
        super(itemNamespace, str, str2);
        if (e2 == null) {
            throw new IllegalArgumentException("payload cannot be 'null'");
        }
        this.payload = e2;
    }

    public E getPayload() {
        return this.payload;
    }

    @Override // org.jivesoftware.smackx.pubsub.Item, org.jivesoftware.smackx.pubsub.NodeExtension
    protected void addXml(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute("id", getId());
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.payload);
        xmlStringBuilder.closeElement(this);
    }

    @Override // org.jivesoftware.smackx.pubsub.Item, org.jivesoftware.smackx.pubsub.NodeExtension
    public String toString() {
        return getClass().getName() + " | Content [" + ((Object) toXML()) + Constants.AES_SUFFIX;
    }
}
