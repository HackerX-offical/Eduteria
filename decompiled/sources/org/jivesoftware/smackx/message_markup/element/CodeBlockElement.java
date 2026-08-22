package org.jivesoftware.smackx.message_markup.element;

import org.jivesoftware.smackx.message_markup.element.MarkupElement;

/* JADX INFO: loaded from: classes10.dex */
public class CodeBlockElement extends MarkupElement.BlockLevelMarkupElement {
    public static final String ELEMENT = "bcode";

    public CodeBlockElement(int i, int i2) {
        super(i, i2);
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }
}
