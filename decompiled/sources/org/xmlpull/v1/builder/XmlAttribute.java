package org.xmlpull.v1.builder;

/* JADX INFO: loaded from: classes9.dex */
public interface XmlAttribute extends Cloneable {
    Object clone() throws CloneNotSupportedException;

    String getName();

    XmlNamespace getNamespace();

    String getNamespaceName();

    XmlElement getOwner();

    String getType();

    String getValue();

    boolean isSpecified();
}
