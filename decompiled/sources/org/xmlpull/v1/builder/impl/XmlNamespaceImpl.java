package org.xmlpull.v1.builder.impl;

import org.xmlpull.v1.builder.XmlBuilderException;
import org.xmlpull.v1.builder.XmlNamespace;

/* JADX INFO: loaded from: classes9.dex */
public class XmlNamespaceImpl implements XmlNamespace {
    private String namespaceName;
    private String prefix;

    XmlNamespaceImpl(String str) {
        if (str == null) {
            throw new XmlBuilderException("namespace name can not be null");
        }
        this.namespaceName = str;
    }

    XmlNamespaceImpl(String str, String str2) {
        this.prefix = str;
        if (str2 == null) {
            throw new XmlBuilderException("namespace name can not be null");
        }
        if (str != null && str.indexOf(58) != -1) {
            throw new XmlBuilderException(new StringBuffer("prefix '").append(str).append("' for namespace '").append(str2).append("' can not contain colon (:)").toString());
        }
        this.namespaceName = str2;
    }

    @Override // org.xmlpull.v1.builder.XmlNamespace
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.v1.builder.XmlNamespace
    public String getNamespaceName() {
        return this.namespaceName;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof XmlNamespace)) {
            return getNamespaceName().equals(((XmlNamespace) obj).getNamespaceName());
        }
        return false;
    }

    public String toString() {
        return new StringBuffer("{prefix='").append(this.prefix).append("',namespaceName='").append(this.namespaceName).append("'}").toString();
    }
}
