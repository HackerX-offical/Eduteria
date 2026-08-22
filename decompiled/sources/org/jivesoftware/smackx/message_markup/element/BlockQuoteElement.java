package org.jivesoftware.smackx.message_markup.element;

import javax.xml.namespace.QName;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

/* JADX INFO: loaded from: classes10.dex */
public class BlockQuoteElement extends MarkupElement.BlockLevelMarkupElement {
    public static final String ELEMENT = "bquote";
    public static final QName QNAME = new QName(MarkupElement.NAMESPACE, ELEMENT);

    public BlockQuoteElement(int i, int i2) {
        super(i, i2);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return QNAME.getLocalPart();
    }
}
