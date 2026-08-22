package org.jivesoftware.smack.packet;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes10.dex */
public interface FullyQualifiedElement extends NamedElement, XmlLangElement {
    default String getLanguage() {
        return null;
    }

    String getNamespace();

    default QName getQName() {
        return new QName(getNamespace(), getElementName());
    }
}
